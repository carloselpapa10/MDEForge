package org.mdeforge.workspaceservice.controller;

import java.util.List;

import org.mdeforge.workspaceservice.impl.WorkspaceServiceImpl;
import org.mdeforge.workspaceservice.model.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkspaceController {

	@Autowired
	private WorkspaceServiceImpl workspaceServiceImpl;
	
	@PostMapping("/workspace")
	public String createWorkspace(@RequestBody Workspace w) {
		Workspace workspace = workspaceServiceImpl.create(w);
		return "Create workspace is being processing with id= "+workspace.getId();
	}
	
	@GetMapping("/workspaces")
	public List<Workspace> findAllWorkspaces(){
		return workspaceServiceImpl.findAll();
	}
}
