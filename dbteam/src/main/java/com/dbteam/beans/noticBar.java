package com.dbteam.beans;

import java.io.Serializable;

public class noticBar implements Serializable{
	
	public int id;
	
	public int getId() {
		return id;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}

	public String text;
	
	public String textTime;

	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTextTime() {
		return textTime;
	}

	public void setTextTime(String textTime) {
		this.textTime = textTime;
	}
}
