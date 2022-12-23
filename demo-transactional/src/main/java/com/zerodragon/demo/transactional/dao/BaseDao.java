package com.zerodragon.demo.transactional.dao.mapper;

import com.zerodragon.demo.transactional.dao.SqlConstraint;
import com.zerodragon.demo.transactional.entity.BaseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/23-17:31
 **/
public abstract class BaseDao<T extends BaseEntity,M extends RowMapper<T>> extends SqlConstraint {
	/**
	 * 数据源
	 */
	private final DataSource dataSource ;
	/**
	 * jdbc模板
	 */
	protected final JdbcTemplate jdbcTemplate;
	public BaseDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate ;
	}

	/**
	 * 查询一个
	 *
	 * @param tableName 表名
	 * @param mapper    映射器
	 */
	public List<T> queryList(String tableName, M mapper) {
		return jdbcTemplate.query(generateSelectOne(tableName), mapper);
	}
}
