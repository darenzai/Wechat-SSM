package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.Swb;

//�±�Mapper��
public interface SwbSecondMapper {
		
	public Boolean addSwbSecond(Swb swbSecond);
		
		//ɾ������
		public Boolean deleteSwbSecond(int hostelId);
		
		//��ȡ����
		public Boolean getSwbSecond(int hostelId);
		
		//���ȫ������
		public List<Swb> allSwbSecond();
		
		//��������
		public Boolean updateSwbSecond(int hostelId);
		
}
