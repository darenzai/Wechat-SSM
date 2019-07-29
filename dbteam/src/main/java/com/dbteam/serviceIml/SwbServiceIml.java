package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;
import com.dbteam.mapper.SwbMapper;
import com.dbteam.service.SwbService;

@Service
public class SwbServiceIml implements SwbService {
	@Autowired
	SwbMapper swbMapper;
	
	//�ϱ�
	
	//�г���������ȫ����Ϣ
	public List<Swb> list() {
		return swbMapper.list();

	}
	
	
	//�����������Ϣ
	public Boolean add(Swb c) {
		return swbMapper.add(c);
	}

	//�޸���IdΪ׼
	public Boolean update(Swb c) {
		return swbMapper.update(c);
	}
	
	//ɾ��������Id��ʽȥ���ݿ����
	public Boolean delete(int id) {

		return swbMapper.delete(id);
	}

	//��������� (�г������������е���Ϣ) 
	public List<Swb> get(int hostelId) {

		return swbMapper.get(hostelId);
	}
	
	
	//���õĲ��Է���
	@Override
	public List<Swb> listimage() {
		
		return swbMapper.listimage();
	}
}
