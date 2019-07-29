package com.dbteam.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbteam.beans.Swb;
import com.dbteam.beans.imageProduct;
import com.dbteam.mapper.imageMapper;
import com.dbteam.service.imageSercive;

public class imageServiceIml  implements imageSercive{

	@Autowired
	imageMapper imagemapper;

	@Override
	public List<imageProduct> getImage(int only) {
		// TODO Auto-generated method stub
		return imagemapper.getImage(only);
	}

	@Override
	public Boolean addImage(imageProduct imageproduct) {
		// TODO Auto-generated method stub
		return addImage(imageproduct);
	}
	

	
	
	
}
