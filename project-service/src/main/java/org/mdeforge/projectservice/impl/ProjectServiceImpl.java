package org.mdeforge.projectservice.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.mdeforge.projectservice.dao.ProjectService;
import org.mdeforge.projectservice.model.Project;
import org.mdeforge.projectservice.model.ProjectDomainEventPublisher;
import org.mdeforge.projectservice.model.ProjectRepository;
import org.mdeforge.projectservice.saga.createproject.CreateProjectSagaData;
import org.mdeforge.projectservice.saga.deleteproject.DeleteProjectSagaData;
import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.project.api.events.ProjectCreatedEvent;
import org.mdeforge.servicemodel.project.api.events.ProjectDomainEvent;
import org.mdeforge.servicemodel.project.api.info.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;
import io.eventuate.tram.sagas.orchestration.SagaManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.util.Collections.singletonList;

@Component
@Transactional
public class ProjectServiceImpl implements ProjectService{

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private SagaManager<CreateProjectSagaData> createProjectSagaManager;
	
	@Autowired
	private SagaManager<DeleteProjectSagaData> deleteProjectSagaManager;
	
	@Autowired
	private ProjectDomainEventPublisher projectAggregateEventPublisher;

	@Override
	public Project create(Project project) throws BusinessException {
		log.info("create - ProjectServiceImpl "+project);
		
		ProjectInfo projectInfo = new ProjectInfo(project.getName(), project.getDescription(), project.getOwnerId(), 
													project.getArtifactsId(), project.getUsersId(),project.getWorkspacesId()); 
		
		List<ProjectDomainEvent> events = singletonList(new ProjectCreatedEvent(projectInfo));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);
		
		project = projectRepository.save(project);
		
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);
		
		CreateProjectSagaData data = new CreateProjectSagaData(project.getId(), project.getOwnerId(), project.getArtifactsId(), project.getUsersId(), project.getWorkspacesId());
		createProjectSagaManager.create(data, Project.class, project.getId());
		
		return project;
	}
	
	@Override
	public Boolean delete(String projectId, String userId) throws BusinessException {
		log.info("delete - ProjectServiceImpl ");
		
		Project project = findOne(projectId);
		if(project == null) {
			return false;
		}
		
		DeleteProjectSagaData data = new DeleteProjectSagaData(project.getId(), userId, project.getUsersId());
		deleteProjectSagaManager.create(data);
		
		return true;
	}
	
	@Override
	public Project findOne(String id) throws BusinessException {
		log.info("findOne - ProjectServiceImpl ");
		
		try {
			Project project = projectRepository.findById(id).get();
			return project;
		}catch (NoSuchElementException e) {
			return null;
		}
		
	}
	
	@Override
	public List<Project> findAllProjects() throws BusinessException {
		log.info("findAllProjects - ProjectServiceImpl ");
		return projectRepository.findAll();
	}
	
}
