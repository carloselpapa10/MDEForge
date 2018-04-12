package org.mdeforge.mdeforgeviewservice.dao;

import java.util.List;

import org.mdeforge.mdeforgeviewservice.model.Project;
import org.mdeforge.servicemodel.common.BusinessException;

public interface ProjectService {

	public Project create(Project project) throws BusinessException;	
	public Project findOne(String id) throws BusinessException;
	public List<Project> findAllProjects() throws BusinessException;
	public void delete(String projectId) throws BusinessException;
}
