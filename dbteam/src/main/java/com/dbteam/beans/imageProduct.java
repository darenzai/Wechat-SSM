package com.dbteam.beans;

import java.io.Serializable;

import com.dbteam.controller.SwbController;

public class imageProduct implements Serializable{
	public int id;
	
	//添加照片时候跟卫生数据唯一的对应值
	public int only=SwbController.only;
	

	
	public String shijian;
	
	
	public String images;

	

	
	
	public String getShijian() {

		return shijian;
	}

	public void setShijian(String shijian) {
		this.shijian=shijian;
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOnly() {
		return only;
	}

	public void setOnly(int only) {
		this.only =SwbController.only;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images =images;;
	}

	@Override
	public String toString() {
		return "imageProduct [id=" + id + ", only=" + only + ",  shijian=" + shijian + ", images="
				+ images + "]";
	}


	
	
}
