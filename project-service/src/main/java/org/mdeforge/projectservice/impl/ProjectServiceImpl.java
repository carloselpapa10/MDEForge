package org.mdeforge.projectservice.impl;

import java.util.List;

import org.mdeforge.projectservice.dao.ProjectService;
import org.mdeforge.projectservice.model.Project;
import org.mdeforge.projectservice.model.ProjectRepository;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project findById(String id, String ownerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findOne(String id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	} 
	
	}
