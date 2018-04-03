package org.mdeforge.artifactservice.model;

import org.springframework.data.annotation.Id;

public class Relation {

	@Id
	private String id;
	private String name;
	private Artifact toArtifact;
	private Artifact fromArtifact;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Artifact getToArtifact() {
		return toArtifact;
	}
	public void setToArtifact(Artifact toArtifact) {
		this.toArtifact = toArtifact;
	}
	public Artifact getFromArtifact() {
		return fromArtifact;
	}
	public void setFromArtifact(Artifact fromArtifact) {
		this.fromArtifact = fromArtifact;
	}
	
}
