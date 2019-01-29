package com.consulting.models;

import javax.persistence.*;

@Entity
@Table(name = "slider")
public class Slider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Integer sliderId;

	@Column(columnDefinition = "TEXT")
	private String title;

	@Column(columnDefinition = "TEXT")
	private String subtitle;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String attachment;

	public Integer getSliderId() {
		return sliderId;
	}

	public void setSliderId(Integer sliderId) {
		this.sliderId = sliderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}
