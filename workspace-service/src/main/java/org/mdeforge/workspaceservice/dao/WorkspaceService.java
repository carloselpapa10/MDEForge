package org.mdeforge.workspaceservice.dao;

import java.util.List;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.project.api.info.ProjectInfo;
import org.mdeforge.workspaceservice.model.Workspace;

public interface WorkspaceService {

	/*
	public Workspace create(Workspace workspace) throws BusinessException;
	public Workspace update(Workspace workspace) throws BusinessException;
	public void delete(Workspace workspace) throws BusinessException;
	public void delete(String id, UserInfo user) throws BusinessException;
	public void removeProjectFromWorkspace(String idProject, String idWorkspace, UserInfo user) throws BusinessException;
	public ProjectInfo addProjectInWorkspace(String idProject, String idWorkspace, UserInfo user) throws BusinessException;
	public ProjectInfo addNewProjectInWorkspace(String projectName, String idWorkspace, UserInfo user) throws BusinessException;
	public void removeProjectInWorkspaces(ProjectInfo project) throws BusinessException;
	
	public Workspace findByName(String name) throws BusinessException;
	public Workspace findById(String id, UserInfo user) throws BusinessException;
	public List<Workspace> findAll() throws BusinessException;	
	public Workspace findOne(String id);
	public Workspace findOneWithUser(String id, String idUser) throws BusinessException;
	public List<ProjectInfo> findProjectInWorkspace(String id, UserInfo user);
	*/
	/*
	 List<Workspace> findByUser(User user) throws BusinessException;
	 
	 ResponseGrid<Workspace> findAllPaginated(RequestGrid requestGrid) throws BusinessException;
	 public ResponseGrid<Workspace> findAllPaginatedByOwner(RequestGrid requestGrid, User user) throws BusinessException;
	 Jsfiddle addNewJsfiddleInWorkspace(Jsfiddle jsfiddle, String idWorkspace, User user) throws BusinessException;
	 * */
	
}
