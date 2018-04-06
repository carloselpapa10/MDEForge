package org.mdeforge.mdeforgeviewservice.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.mdeforge.mdeforgeviewservice.dao.WorkspaceService;
import org.mdeforge.mdeforgeviewservice.model.Workspace;
import org.mdeforge.mdeforgeviewservice.repository.WorkspaceRepository;
import org.mdeforge.servicemodel.common.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceServiceImpl implements WorkspaceService{

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceImpl.class);
	
	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Override
	public Workspace create(Workspace workspace) throws BusinessException {
		log.info("create - WorkspaceServiceImpl "+workspace);
		return workspaceRepository.save(workspace);
	}

	@Override
	public Workspace update(Workspace workspace) throws BusinessException {
		log.info("update - WorkspaceServiceImpl "+workspace);
		return workspaceRepository.save(workspace);
	}
	
	@Override
	public List<Workspace> findAll() throws BusinessException {
		log.info("findAll - WorkspaceServiceImpl");
		return workspaceRepository.findAll();
	}

	@Override
	public Workspace findOne(String workspaceId) throws BusinessException {
		log.info("findOne - WorkspaceServiceImpl");
		
		try {
			Workspace workspace = workspaceRepository.findById(workspaceId).get();
			return workspace;
		}catch (NoSuchElementException e) {
			return null;
		}		
	}
	
	@Override
	public void delete(String workspaceId) throws BusinessException {
		log.info("delete - WorkspaceServiceImpl");
		
		Workspace workspace = findOne(workspaceId);
		
		if(workspace != null) {
			workspaceRepository.delete(workspace);
		}else {
			log.info("delete - WorkspaceServiceImpl ::: Unexpected error");
		}
		
	}

}
