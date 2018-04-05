package org.mdeforge.workspaceservice.controller;

import java.util.List;

import org.mdeforge.workspaceservice.impl.WorkspaceServiceImpl;
import org.mdeforge.workspaceservice.model.Workspace;
import org.mdeforge.workspaceservice.webapi.CreateWorkspaceRequest;
import org.mdeforge.workspaceservice.webapi.CreateWorkspaceResponse;
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
	public CreateWorkspaceResponse createWorkspace(@RequestBody CreateWorkspaceRequest request) {
		Workspace workspace = workspaceServiceImpl.create(new Workspace(request.getName(),request.getDescription(),
														request.getOwnerId(),request.getProjectsId(),request.getArtifactsId()));
		
		return new CreateWorkspaceResponse(workspace.getId());
	}
	
	@GetMapping("/workspaces")
	public List<Workspace> findAllWorkspaces(){
		return workspaceServiceImpl.findAll();
	}
}
