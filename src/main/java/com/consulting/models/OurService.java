package com.consulting.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "our_service")
public class OurService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer ourServiceId;

	@Column(columnDefinition = "TEXT")
	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(columnDefinition = "TEXT")
	private String attachment;

	public Integer getOurServiceId() {
		return ourServiceId;
	}

	public void setOurServiceId(Integer ourServiceId) {
		this.ourServiceId = ourServiceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
