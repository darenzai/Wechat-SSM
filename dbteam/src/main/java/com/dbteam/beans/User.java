package com.dbteam.beans;

public class User {

	public int id;
	

	public String userImage;
	
	public String userName;
	public int userGrade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
	
	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userGrade=" + userGrade + "]";
	}
}
