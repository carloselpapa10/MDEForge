package org.mdeforge.mdeforgeviewservice.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.mdeforge.mdeforgeviewservice.dao.ProjectService;
import org.mdeforge.mdeforgeviewservice.model.Project;
import org.mdeforge.mdeforgeviewservice.repository.ProjectRepository;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ProjectServiceImpl implements ProjectService{

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project create(Project project) throws BusinessException {
		log.info("create - ProjectServiceImpl "+project);		
		return projectRepository.save(project);
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

	@Override
	public void delete(String projectId) throws BusinessException {
		log.info("delete - ProjectServiceImpl");
		
		Project project = findOne(projectId);
		
		if(project != null) {
			projectRepository.delete(project);
		}else {
			log.info("delete - ProjectServiceImpl ::: Unexpected error");
		}
		
	}

}
