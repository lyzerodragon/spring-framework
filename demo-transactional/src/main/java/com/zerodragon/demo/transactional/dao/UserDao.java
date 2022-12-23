package com.zerodragon.demo.transactional.dao;

import com.zerodragon.demo.transactional.dao.mapper.BaseDao;
import com.zerodragon.demo.transactional.dao.mapper.UserMapper;
import com.zerodragon.demo.transactional.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/23-17:48
 **/
@Component
public class UserDao extends BaseDao<User, UserMapper> {
	public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		super(dataSource, jdbcTemplate);
	}

	@Transactional(rollbackFor = Exception.class)
	public int insert (User user){
		final String sql = "insert into user (`name`,`age`) values (?,?)";
		return jdbcTemplate.update(sql, user.getName(), user.getAge());
	}

	@Transactional(rollbackFor = Exception.class)
	public int updateNameById(int id , String name ){
		final String sql = "update user set `name` = ? where `id` = ?" ;
		return jdbcTemplate.update(sql,id,name);
	}

	@Transactional(rollbackFor = Exception.class)
	public int updateAgeById(int id , String age ){
		final String sql = "update user set `age` = ? where `id` = ?" ;
		return jdbcTemplate.update(sql,id,age);
	}

	public List<User> queryList() {
		return super.queryList("user", new UserMapper());
	}
}
