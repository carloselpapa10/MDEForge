package org.mdeforge.artifactservice.controller;

import org.mdeforge.artifactservice.impl.ArtifactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtifactController {

	@Autowired
	private ArtifactServiceImpl artifactServiceImpl;
	
}
