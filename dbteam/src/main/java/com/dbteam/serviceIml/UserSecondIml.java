package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.UserSecond;
import com.dbteam.mapper.UserSecondMapper;
import com.dbteam.service.UserSecondService;

//����Ա�ӿڲ�

public class UserSecondIml  implements UserSecondService{
	
	
	
	@Autowired
	UserSecondMapper userSecondMapper;
	
	
	//��ӹ���Ա��Ϣ
	public Boolean addUser(UserSecond userSecond) {
		return userSecondMapper.addUser(userSecond);
	}
	
	
	//�����û���Ϣ ID��ʽ
	@Override
	public Boolean selectName(int id) {
		
		return userSecondMapper.selectName(id);
	}
	
	
	//������û�������Ϣ
	public UserSecond selectAll(String userWeChatName) {
		return userSecondMapper.selectAll(userWeChatName);
	}
	
	//ȫ������Ա����
	public List<UserSecond> allSecondUser() {
		
		return userSecondMapper.allSecondUser();
	}


	//ɾ������Ա����
	@Override
	public Boolean deleteSecondUser(int id) {
		
		return userSecondMapper.deleteSecondUser(id);
	}


	//�޸Ĺ���Ա
	@Override
	public Boolean updateSecondUser(UserSecond userSecond) {
		return userSecondMapper.updateSecondUser(userSecond);
	}


	//�����Ʋ��ҹ���Ա(��ʵ����)
	@Override
	public int selectUserGrade(String userWeChatName) {
		// TODO Auto-generated method stub
		return userSecondMapper.selectUserGrade(userWeChatName);
	}


	//���� �������Ǹ����
	@Override
	public Boolean updateUserInformation(int id) {
		// TODO Auto-generated method stub
		return userSecondMapper.updateUserInformation(id);
	}



	@Override
	public UserSecond selectUserName(String userName) {
		// TODO Auto-generated method stub
		return userSecondMapper.selectUserName(userName);
	}
	
	
}
