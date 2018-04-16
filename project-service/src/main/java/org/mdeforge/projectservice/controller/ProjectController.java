package org.mdeforge.projectservice.controller;

import java.util.List;

import org.mdeforge.projectservice.impl.ProjectServiceImpl;
import org.mdeforge.projectservice.model.Project;
import org.mdeforge.projectservice.webapi.CreateProjectRequest;
import org.mdeforge.projectservice.webapi.CreateProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	@PostMapping("/project")
	public CreateProjectResponse createProject(@RequestBody CreateProjectRequest request) {
		Project project = projectServiceImpl.create(new Project(request.getName(), request.getDescription(), 
																	request.getOwnerId(),request.getArtifactsId(), 
																		request.getUsersId(), request.getWorkspacesId()));
		
		return new CreateProjectResponse(project.getId());
	}
	
	@PutMapping("/update/project")
	public ResponseEntity<Project> updateProject(@RequestBody Project project){
		/*TODO*/
		return null;
	}
	
	@DeleteMapping("/projects/{projectId}")
	public String deleteProject(@PathVariable String projectId) {
		/*TODO*/
		return null;
	}
	
	@GetMapping("/projects/{projectId}")
	public ResponseEntity<Project> findProject(@PathVariable String projectId) {
		Project project = projectServiceImpl.findOne(projectId);
		return project != null ? ResponseEntity.ok(project) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/projects")
	public List<Project> findAllProjects(){
		return projectServiceImpl.findAllProjects();
	}
}
