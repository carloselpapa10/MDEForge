package org.mdeforge.projectservice.dao;

import java.util.List;

import org.mdeforge.projectservice.model.Project;
import org.mdeforge.servicemodel.common.BusinessException;

public interface ProjectService {

	public Project create(Project project) throws BusinessException;	
	
	public Project findOne(String id) throws BusinessException;
	public List<Project> findAllProjects() throws BusinessException;
	public Boolean delete(String projectId, String userId) throws BusinessException;
	
	/*
	public Project update(Project project, UserInfo idUser) throws BusinessException;	
	public void removeArtifactFromProject(String idArtifact, String idProject,UserInfo user) throws BusinessException;
	public void addArtifactInProject(String idArtifact, String idProject, UserInfo user) throws BusinessException;
	public UserInfo addUserInProject(String idUser, String idProject, UserInfo user);
	public Project cloneProject(String userId, String projectToCloneId,String workspaceId);
	public void removeUserFromProject(String idUser, String idProject, UserInfo user) throws BusinessException;
	
	public Project findById(String id, String ownerId) throws BusinessException;
	public Project findByName(String name) throws BusinessException;
	public Project findById(String id, UserInfo user) throws BusinessException;
	public List<Project> findByIdWorkspace(String idWorkspace, UserInfo user) throws BusinessException;
	public List<Project> findByUser(UserInfo idUser) throws BusinessException;
	public List<Project> findAll() throws BusinessException;
	public Project findOne(String id) throws BusinessException;
	public List<Project> findSharedNoWorkspace(UserInfo user) throws BusinessException;
	public List<Project> findMostSharedProject(UserInfo user) throws BusinessException;
	public long countAll() throws BusinessException;
	public List<Project> findRecent() throws BusinessException;
	*/
	//ResponseGrid<Project> findAllPaginated(RequestGrid requestGrid) throws BusinessException;
		
}
