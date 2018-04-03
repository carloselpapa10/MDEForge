package org.mdeforge.workspaceservice.controller;

import org.mdeforge.workspaceservice.model.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkspaceController {

	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	
}
