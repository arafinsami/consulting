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
@Table(name = "choose_us_list")
public class ChooseUsList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer chooseUsListId;

	private String title;

	@ManyToOne
	@JoinColumn(name = "choose_us_id", insertable = true)
	private ChooseUs chooseUs;

	public Integer getChooseUsListId() {
		return chooseUsListId;
	}

	public void setChooseUsListId(Integer chooseUsListId) {
		this.chooseUsListId = chooseUsListId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ChooseUs getChooseUs() {
		return chooseUs;
	}

	public void setChooseUs(ChooseUs chooseUs) {
		this.chooseUs = chooseUs;
	}

}
