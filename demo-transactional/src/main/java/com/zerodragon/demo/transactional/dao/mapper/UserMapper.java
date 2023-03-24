package com.zerodragon.demo.transactional.dao.mapper;

import com.zerodragon.demo.transactional.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/23-17:26
 **/
@Component
public class UserMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		user.setId(rs.getInt("id"));
		return user;
	}



}
