package com.dbteam.service;

import java.util.List;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;
import com.dbteam.serviceIml.SwbServiceIml;

public interface SwbService {
	//�г��������ȫ����Ϣ
	List<Swb> list();
	
	//��� ���������Ϣ
	Boolean add(Swb c);
	
	//ɾ�����������Ϣ
	Boolean delete(int c);
	
	//�޸ļ��������Ϣ
	Boolean update(Swb c);
	
	//������Ų����г���������ȫ��������Ϣ
	List<Swb> get(int hostelId);
	
	//û�õĽӿ�
	List<Swb> listimage();
	
	
	
	
}
