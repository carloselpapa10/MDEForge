package org.mdeforge.mdeforgeviewservice.controller;

import java.util.List;

import org.mdeforge.mdeforgeviewservice.impl.ProjectServiceImpl;
import org.mdeforge.mdeforgeviewservice.impl.UserServiceImpl;
import org.mdeforge.mdeforgeviewservice.impl.WorkspaceServiceImpl;
import org.mdeforge.mdeforgeviewservice.model.Project;
import org.mdeforge.mdeforgeviewservice.model.User;
import org.mdeforge.mdeforgeviewservice.model.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MdeforgeController {

	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	@Autowired
	private WorkspaceServiceImpl workspaceServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/Users")
	public List<User> findAllUsers(){
		return userServiceImpl.findAllUsers();
	}
	
	@GetMapping("/User/{userId}")
	public ResponseEntity<User> findUser(@PathVariable String userId){
		User user = userServiceImpl.findOne(userId);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/Workspaces")
	public List<Workspace> findAllWorkspaces(){
		return workspaceServiceImpl.findAllWorkspaces();
	}
	
	@GetMapping("/Workspaces/{workspaceId}")
	public ResponseEntity<Workspace> findWorkspace(@PathVariable String workspaceId) {
		Workspace workspace = workspaceServiceImpl.findOne(workspaceId);
		return workspace != null ? ResponseEntity.ok(workspace) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/projects")
	public List<Project> findAllProjects(){
		return projectServiceImpl.findAllProjects();
	}
	
	@GetMapping("/project/{projectId}")
	public ResponseEntity<Project> findProject(@PathVariable String projectId){
		Project project = projectServiceImpl.findOne(projectId);
		return project != null ? ResponseEntity.ok(project) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}
