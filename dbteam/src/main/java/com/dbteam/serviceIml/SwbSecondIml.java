package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.Swb;
import com.dbteam.mapper.SwbSecondMapper;
import com.dbteam.service.SwbSecondService;

public class SwbSecondIml implements SwbSecondService {
	
	@Autowired
	SwbSecondMapper  swbSecondMapper;
	
	//���±� ������Ų���
	public Boolean getSecond(int hostelId) {
		
		
		
		
		return swbSecondMapper.getSwbSecond(hostelId);
	}

	//�±�ɾ������ ���������ʽ
	public Boolean deleteSecond(int hostelId) {
		
		return swbSecondMapper.deleteSwbSecond(hostelId);
	}
	
	
	//���������Ϣ ���ϱ�һ�����
	public Boolean addSecond(Swb swbSecond) {
		
		return swbSecondMapper.addSwbSecond(swbSecond);
	}

	//�±�(һ��ʼ��ʾ) �г���������
	@Override
	public List<Swb> allSwbSecond() {
		
		return swbSecondMapper.allSwbSecond();
	}

	//�޸Ĳ���
	@Override
	public Boolean updateSwbSecond(int hostelId) {
		
		return swbSecondMapper.updateSwbSecond(hostelId);
	}
	
}
