package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.UserSecond;

//����ԱMapper��
public interface UserSecondMapper {
	
	
	//��ӹ���Ա
	Boolean addUser(UserSecond userSecond);
	
	//���ҹ���Ա
	Boolean selectName(int id);
	
	//��ù���Աȫ������
	UserSecond selectAll(String userWeChatName);
	
	//��ȡȫ������Ա
	List<UserSecond> allSecondUser();
	
	//ɾ������Ա
	Boolean deleteSecondUser(int id);
	
	//�޸Ĺ���Ա
	Boolean updateSecondUser( UserSecond userSecond);
	
	//���ع���Ա�ȼ�
	int selectUserGrade(String userWeChatName);
	
	//���¹���Ա����
	Boolean updateUserInformation(int id);
	
	//���ҹ���Ա
	UserSecond selectUserName(String userName);
	
}
