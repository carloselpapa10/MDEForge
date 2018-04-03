package org.mdeforge.artifactservice.impl;

import java.util.List;

import org.mdeforge.artifactservice.dao.ArtifactService;
import org.mdeforge.artifactservice.model.Artifact;
import org.mdeforge.artifactservice.model.ArtifactRepository;
import org.mdeforge.artifactservice.model.Comment;
import org.mdeforge.artifactservice.model.Metric;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArtifactServiceImpl implements ArtifactService<Artifact>{

	@Autowired
	private ArtifactRepository artifactRepository;

	
}
