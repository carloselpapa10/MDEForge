package org.mdeforge.artifactservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Artifact {

	@Id
	private String id;
	private Date created;
	private Date modified;
	private GridFileMedia file;
	private boolean open;
	private String name;
	private List<Comment> comments = new ArrayList<>();
	private boolean generated = true;
	@Transient
	private List<Metric> metrics = new ArrayList<Metric>();
	private String description;
	private List<String> tags;
	private String authors;
	private String version;
	private String nameForIndex;
	private String descriptionForIndex;
	private String weightedContentsThree;
	private String weightedContentsTwo;
	private String weightedContentsOne;
	private String defaultWeightedContents;
	
	private List<Relation> relations = new ArrayList<>();
	private List<String> projectsId = new ArrayList<>();
	private List<String> sharedUsersId = new ArrayList<>();
	
	public Artifact() {
		super();
	}
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public GridFileMedia getFile() {
		return file;
	}
	public void setFile(GridFileMedia file) {
		this.file = file;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public boolean isGenerated() {
		return generated;
	}
	public void setGenerated(boolean generated) {
		this.generated = generated;
	}
	public List<Metric> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNameForIndex() {
		return nameForIndex;
	}
	public void setNameForIndex(String nameForIndex) {
		this.nameForIndex = nameForIndex;
	}
	public String getDescriptionForIndex() {
		return descriptionForIndex;
	}
	public void setDescriptionForIndex(String descriptionForIndex) {
		this.descriptionForIndex = descriptionForIndex;
	}
	public String getWeightedContentsThree() {
		return weightedContentsThree;
	}
	public void setWeightedContentsThree(String weightedContentsThree) {
		this.weightedContentsThree = weightedContentsThree;
	}
	public String getWeightedContentsTwo() {
		return weightedContentsTwo;
	}
	public void setWeightedContentsTwo(String weightedContentsTwo) {
		this.weightedContentsTwo = weightedContentsTwo;
	}
	public String getWeightedContentsOne() {
		return weightedContentsOne;
	}
	public void setWeightedContentsOne(String weightedContentsOne) {
		this.weightedContentsOne = weightedContentsOne;
	}
	public String getDefaultWeightedContents() {
		return defaultWeightedContents;
	}
	public void setDefaultWeightedContents(String defaultWeightedContents) {
		this.defaultWeightedContents = defaultWeightedContents;
	}
	public List<Relation> getRelations() {
		return relations;
	}
	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}
	public List<String> getProjectsId() {
		return projectsId;
	}
	public void setProjectsId(List<String> projectsId) {
		this.projectsId = projectsId;
	}
	public List<String> getSharedUsersId() {
		return sharedUsersId;
	}
	public void setSharedUsersId(List<String> sharedUsersId) {
		this.sharedUsersId = sharedUsersId;
	}
		
}
