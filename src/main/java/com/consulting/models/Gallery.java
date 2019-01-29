package com.consulting.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gallery_name")
public class Gallery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer galleryId;

	@Column(columnDefinition = "TEXT")
	private String name;

	@Column(columnDefinition = "TEXT")
	private String attachment;

	@OneToMany(mappedBy = "gallery", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<GalleryContent> galleryContents;

	public Integer getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(Integer galleryId) {
		this.galleryId = galleryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public List<GalleryContent> getGalleryContents() {
		return galleryContents;
	}

	public void setGalleryContents(List<GalleryContent> galleryContents) {
		this.galleryContents = galleryContents;
	}

}
