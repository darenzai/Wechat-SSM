package com.dbteam.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import com.dbteam.controller.UserSecondController;

//	ʵ�ַ����л��ӿ�
public class UserSecond implements Serializable{
	
	//����JSR303����У��
	
	public int id;
	 @NotNull(message = "�û�������Ϊ��")
	@NotBlank(message = "�û�������Ϊ��")
	public String userName;
	 @NotNull(message = "�û�������Ϊ��")
	@NotBlank(message = "΢��������Ϊ��")
	public String userWeChatName;
	@Pattern(regexp="[1][3|4|5|6|7|8][0-9]{9}",message="�ֻ������ʽ����ȷ")
	public String userPhone;

	public String workPosition;

	public String remark;

	public String urlImage;	
	
	public int userGrade;
	
	public String nickName;
	
	public String avatarUrl;
	
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl =avatarUrl ;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

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

	public String getUserWeChatName() {
		return userWeChatName;
	}

	public void setUserWeChatName(String userWeChatName) {
		this.userWeChatName = userWeChatName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getWorkPosition() {
		return workPosition;
	}

	public void setWorkPosition(String workPosition) {
		this.workPosition = workPosition;
	}

	public String getRemark() {
		return remark;
	}
	
	public int getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}

	
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
