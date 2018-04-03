package org.mdeforge.artifactservice.model;

import org.springframework.data.annotation.Id;

public class Comment {

	@Id
	private String id;
	private String comment;
	private int star;
	//private UserInfo user;
	
	public void setStar(int star) {
		this.star = star;
	}
	
	public int getStar() {
		return star;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this == null)
			return false;
		if (!Comment.class.isInstance(obj))
			return false;
		if (((Comment) obj).getId()==null)
			return false;
		if (id == null)
			return false;
		if (((Comment)obj).getId().equals(id))
			return true;
		else return false;
	}
}
