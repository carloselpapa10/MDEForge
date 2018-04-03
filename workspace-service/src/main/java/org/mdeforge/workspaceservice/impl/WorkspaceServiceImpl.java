package org.mdeforge.workspaceservice.impl;

import java.util.List;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.project.api.info.ProjectInfo;
import org.mdeforge.workspaceservice.dao.WorkspaceService;
import org.mdeforge.workspaceservice.model.Workspace;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Transactional
public class WorkspaceServiceImpl implements WorkspaceService{

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceImpl.class);

}
