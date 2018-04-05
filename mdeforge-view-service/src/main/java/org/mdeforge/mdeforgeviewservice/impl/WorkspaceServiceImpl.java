package org.mdeforge.mdeforgeviewservice.impl;

import java.util.List;

import org.mdeforge.mdeforgeviewservice.dao.WorkspaceService;
import org.mdeforge.mdeforgeviewservice.model.Workspace;
import org.mdeforge.servicemodel.common.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceServiceImpl implements WorkspaceService{

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceImpl.class);
	
	@Override
	public Workspace create(Workspace workspace) throws BusinessException {
		log.info("create - WorkspaceServiceImpl "+workspace);

		return null;
	}

	@Override
	public List<Workspace> findAll() throws BusinessException {
		log.info("findAll - WorkspaceServiceImpl");
		return null;
	}

}
