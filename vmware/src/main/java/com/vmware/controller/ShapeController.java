package com.vmware.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.models.Shape;
import com.vmware.service.ShapeService;

@RestController
@RequestMapping("/shape")
public class ShapeController {

	@Autowired
	private ShapeService shapeService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ShapeController.class);

	@GetMapping(value = "/results/{taskId}")
	public void getShapeResult(@PathVariable Long taskId) throws IOException {
		shapeService.getResult(taskId);
		LOGGER.info("Result fetched successfully.");
	}
	
	@PostMapping(value = "/add/{type}")
	public void addShape(@PathVariable String type, @RequestBody Shape shape) {
		shapeService.addShape(type,shape);
		LOGGER.info("Shape added successfully.");
	}

}
