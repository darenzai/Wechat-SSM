package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.Swb;

//����Ա�û��ӿڲ�
public interface SwbSecondService {
	
	//�õ��������ĳɼ�
	public Boolean getSecond(int hostelId);
	
	//ɾ��������������
	public Boolean deleteSecond(int hostelId);
	
	//���������������
	public Boolean addSecond(Swb swbSecond);
	
	//�г�����������������
	public List<Swb> allSwbSecond();
	
	//�޸�������������
	public Boolean updateSwbSecond(int hostelId);
}
