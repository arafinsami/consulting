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
@Table(name = "menu_parent")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parent_menu_id")
	private Integer menuId;

	@Column(columnDefinition = "TEXT")
	private String name;

	@OneToMany(mappedBy = "menu", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<ChildMenuContent> childMenuContents;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ChildMenuContent> getChildMenuContents() {
		return childMenuContents;
	}

	public void setChildMenuContents(List<ChildMenuContent> childMenuContents) {
		this.childMenuContents = childMenuContents;
	}

}
