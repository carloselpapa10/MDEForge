package org.mdeforge.projectservice.controller;

import org.mdeforge.projectservice.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	
}
