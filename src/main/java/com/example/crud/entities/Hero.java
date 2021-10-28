package com.example.crud.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="heroes")
public class Hero implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable=false)
	private short id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String category;

	@Column(nullable=false)
	private String portraitImageUrl;
	
	public Hero() {
	}

	public Hero(short id, String name, String category, String portraitImageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.portraitImageUrl = portraitImageUrl;
	}

	
	
	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPortraitImageUrl() {
		return portraitImageUrl;
	}

	public void setPortraitImageUrl(String portraitImageUrl) {
		this.portraitImageUrl = portraitImageUrl;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", category=" + category + ", portraitImageUrl=" + portraitImageUrl
				+ "]";
	}
	

}
