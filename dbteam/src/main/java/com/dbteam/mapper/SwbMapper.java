package com.dbteam.mapper;

import java.util.List;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;

//�������Mapper��
public interface SwbMapper {
	
	//�������
	public Boolean add(Swb swb);
	
	//ɾ������
	public Boolean delete(int id);

	//��ȡ����
	public List<Swb> get(int hostelId);
	
	//�޸����ݿ�
	public Boolean update(Swb swb);
	
	//��ȡȫ������
	public List<Swb> list();
	
	//��ȡ��������ȫ������
	public List<Swb> getHostelId(int hostel);
	
	//���Է�������
	public List<Swb> listimage();
}
