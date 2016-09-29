package com.bluoh.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tags_master")
public final class Tags {

	private String tag[];

	public String[] getTag() {
		return tag;
	}

	public void setTag(String[] tag) {
		this.tag = tag;
	}
}