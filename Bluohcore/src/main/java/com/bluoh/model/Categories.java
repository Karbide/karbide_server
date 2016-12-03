package com.bluoh.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories_master")
public class Categories {

	private String category [];

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}
}