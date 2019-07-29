package com.dbteam.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

import com.dbteam.beans.UserSecond;

public interface UserSecondService {
	
	//��ӹ���Ա
	Boolean addUser( UserSecond userSecond);
	
	//ѡ���û��� ����Աÿ�ε�½�鿴����ͷ����
	Boolean selectName(int id);
	
	
	UserSecond selectAll(String userWeChatName);
	
	//�г����й���Ա�б�
	List<UserSecond> allSecondUser();
	
	//ɾ������Ա
	Boolean deleteSecondUser(int id);
	
	//�޸Ĺ���Ա������Ϣ
	Boolean updateSecondUser(UserSecond userSecond);
	
	//�û�һ��ʼ��½�����û��ȼ��ж��� ����Ա����ʲô
	int selectUserGrade(String userWeChatName);
	
	
	Boolean updateUserInformation(int id);
	
	
	//���û�����ʵ���ֲ��ҹ���Ա������Ϣ		
	UserSecond selectUserName( String userName);
	
	
}
