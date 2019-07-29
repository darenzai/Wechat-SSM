package com.dbteam.beans;

import java.io.Serializable;

public class imageBar implements Serializable{
	public int id;
	
	
	
	public String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
