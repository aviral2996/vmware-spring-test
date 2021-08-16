package com.vmware.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.dao.ShapeRepository;
import com.vmware.models.Shape;

@Service
public class ShapeService {
	@Autowired
	private ShapeRepository shapeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ShapeService.class);

	
	public Shape getResult(Long taskId) {
		return shapeRepository.getResult(taskId);
		
	}


	public void addShape(String type, Shape shape) {
		Double result;
		if(type == "Circle")
			result = 3.14*Math.pow(shape.getRadius(),2);
		else
			result = shape.getLength()*shape.getBreadth();
		shape.setResult(result);
		shapeRepository.addShape(type,shape);
		
	}

}
