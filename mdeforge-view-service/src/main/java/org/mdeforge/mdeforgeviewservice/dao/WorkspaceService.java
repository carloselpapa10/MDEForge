package org.mdeforge.mdeforgeviewservice.dao;

import java.util.List;

import org.mdeforge.mdeforgeviewservice.model.Workspace;
import org.mdeforge.servicemodel.common.BusinessException;

public interface WorkspaceService {
	
	public Workspace create(Workspace workspace) throws BusinessException;	
	public Workspace update(Workspace workspace) throws BusinessException;	
	public List<Workspace> findAll() throws BusinessException;
	public Workspace findOne(String workspaceId) throws BusinessException;
	public void delete(String workspaceId) throws BusinessException;
	
}
