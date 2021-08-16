package com.vmware.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vmware.models.Shape;

public class ShapeRowMapper  implements RowMapper<Shape> {

	@Override
	public Shape mapRow(ResultSet rs, int rowNum) throws SQLException {
		Shape shape = new Shape();
		shape.setTaskId(rs.getLong("taskId"));
		shape.setType(rs.getString("type"));
		shape.setRadius(rs.getDouble("radius"));
		shape.setLength(rs.getDouble("length"));
		shape.setBreadth(rs.getDouble("breadth"));
		shape.setResult(rs.getDouble("result"));
		return shape;
	}

}
