package com.consulting.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu_child_content")
public class ChildMenuContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "child_menu_content_id")
	private Integer childMenuContentId;

	@ManyToOne
	@JoinColumn(name = "parent_menu_id", insertable = true, updatable = true)
	private Menu menu;

	@Column(columnDefinition = "TEXT")
	private String title;

	@Column(columnDefinition = "TEXT")
	private String attachment;

	@Column(length = 10000)
	private String description;

	public Integer getChildMenuContentId() {
		return childMenuContentId;
	}

	public void setChildMenuContentId(Integer childMenuContentId) {
		this.childMenuContentId = childMenuContentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
