package com.vmware.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.vmware.mapper.ShapeRowMapper;
import com.vmware.models.Shape;

public class ShapeRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(ShapeRepository.class);

	public Shape getResult(Long taskId) {
		Shape shape = null;
		String sql = "SELECT * FROM Shape where taskId = :taskId";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("taskId", taskId);
		List<Shape> shapeList = jdbcTemplate.query(sql, parameters, new ShapeRowMapper());
		shape = (shapeList != null && !shapeList.isEmpty()) ? shapeList.get(0) : null;
		LOGGER.info("Successfully fetched metro card details for metro card : " + taskId);
		return shape;
	}

	public void addShape(String type, Shape shape) {
		String sql = "INSERT INTO SHAPE(type,radius,length,breadth,result) VALUES( :type, :radius, :length, :breadth, :result)";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("taskId", shape.getType());
		parameters.addValue("taskId", shape.getRadius());
		parameters.addValue("taskId", shape.getLength());
		parameters.addValue("taskId", shape.getBreadth());
		parameters.addValue("taskId", shape.getResult());
		jdbcTemplate.update(sql, parameters);

	}

}
