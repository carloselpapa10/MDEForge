package org.mdeforge.workspaceservice.controller;

import java.util.List;

import org.mdeforge.workspaceservice.impl.WorkspaceServiceImpl;
import org.mdeforge.workspaceservice.model.Workspace;
import org.mdeforge.workspaceservice.webapi.CreateWorkspaceRequest;
import org.mdeforge.workspaceservice.webapi.CreateWorkspaceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class WorkspaceController {

	@Autowired
	private WorkspaceServiceImpl workspaceServiceImpl;
	
	@PostMapping("/workspace")
	public CreateWorkspaceResponse createWorkspace(@RequestBody CreateWorkspaceRequest request) {
		Workspace workspace = workspaceServiceImpl.create(new Workspace(request.getName(),request.getDescription(),
														request.getOwnerId(),request.getProjectsId()));
		
		return new CreateWorkspaceResponse(workspace.getId());
	}
	
	@PutMapping("/update/workspace/")
	public ResponseEntity<Workspace> updateWorkspace(@RequestBody Workspace workspace){
		Workspace modifiedWorkspace =workspaceServiceImpl.update(workspace);
		return modifiedWorkspace != null ? ResponseEntity.ok(modifiedWorkspace) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/workspace/{workspaceId}")
	public String deleteWorkspace(@PathVariable String workspaceId) {
		if(! workspaceServiceImpl.delete(workspaceId)) {
			return "Workspace ID does not exist!";
		}
		return "Workspace deleted";
	}
	
	@GetMapping("/workspaces/{workspaceId}")
	public ResponseEntity<Workspace> findWorkspace(@PathVariable String workspaceId) {
		Workspace workspace = workspaceServiceImpl.findOne(workspaceId);
		return workspace != null ? ResponseEntity.ok(workspace) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/workspaces")
	public List<Workspace> findAllWorkspaces(){
		return workspaceServiceImpl.findAll();
	}
}
