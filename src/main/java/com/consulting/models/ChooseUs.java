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
@Table(name = "why_choose_us")
public class ChooseUs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer chooseId;

	@Column(length = 200)
	private String title;

	@Column(length = 2000)
	private String description;

	@Column(length = 2000)
	private String attachment;

	@OneToMany(mappedBy = "chooseUs", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ChooseUsList> chooseUsLists;

	public Integer getChooseId() {
		return chooseId;
	}

	public void setChooseId(Integer chooseId) {
		this.chooseId = chooseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ChooseUsList> getChooseUsLists() {
		return chooseUsLists;
	}

	public void setChooseUsLists(List<ChooseUsList> chooseUsLists) {
		this.chooseUsLists = chooseUsLists;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
