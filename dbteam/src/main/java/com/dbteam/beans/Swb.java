package com.dbteam.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.dbteam.controller.SwbController;



//	实现序列化接口，为了二级缓存Mybatis反序列化
public class Swb implements Serializable{
	SimpleDateFormat ft=new SimpleDateFormat("YYYY-MM-dd hh:mm");
	
	@Size(min=100,max=701,message="{Swb.hostelId.length.error}")
	public int hostelId;
	
	public int id;
	
	public String hostelGrade;
	Date now =new Date();
	
	//检查时间实时获取
	public String checkTime=ft.format(now);
	
	public String hostelItem;
	
	public String deductMarkScause;

	public String image;
	
	//与卫生图片唯一对应的Id值
	public int only=SwbController.only;
	
	List<imageProduct> imageproduct1;
	
	public List<imageProduct> getImageproduct1() {
		return imageproduct1;
	}

	public void setImageproduct1(List<imageProduct> imageproduct1) {
		this.imageproduct1 = imageproduct1;
	}

	public int getOnly() {
		return only;
	}

	public void setOnly(int only) {
		this.only = SwbController.only;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getHostelId() {
		return hostelId;
	}

	public void setHostelId(int hostelId) {
		this.hostelId = hostelId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostelGrade() {
		return hostelGrade;
	}

	public void setHostelGrade(String hostelGrade) {
		this.hostelGrade = hostelGrade;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime() {
		this.checkTime = checkTime;
	}

	public String getHostelItem() {
		return hostelItem;
	}

	public void setHostelItem(String hostelItem) {
		this.hostelItem = hostelItem;
	}

	public String getDeductMarkScause() {
		return deductMarkScause;
	}

	public void setDeductMarkScause(String deductMarkScause) {
		this.deductMarkScause = deductMarkScause;
	}

	@Override
	public String toString() {
		return "Swb [ hostelId=" + hostelId + ", id=" + id + ", hostelGrade=" + hostelGrade + ", n checkTime=" + checkTime + ", hostelItem=" + hostelItem + ", deductMarkScause="
				+ deductMarkScause + ", image=" + image + ", only=" + only + ", imageproduct1=" + imageproduct1 + "]";
	}
	
	
	
}
