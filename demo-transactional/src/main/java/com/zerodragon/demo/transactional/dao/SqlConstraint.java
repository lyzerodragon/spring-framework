package com.zerodragon.demo.transactional.dao;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/23-17:38
 **/
public abstract class SqlConstraint {
	public static final String SELECT_ONE = "select * from {{tableName}}";



	public String generateSelectOne(String tableName){
		return SELECT_ONE.replace("{{tableName}}", tableName);
	}
}
