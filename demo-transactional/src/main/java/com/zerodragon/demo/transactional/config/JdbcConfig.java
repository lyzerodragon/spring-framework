package com.zerodragon.demo.transactional.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/23-17:13
 **/
@Configuration
@ComponentScan("com.zerodragon.demo")
@EnableTransactionManagement
public class JdbcConfig {

	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://192.168.11.165:3306/demo?characterEncoding=utf-8&serverTimezone=GMT%2B8");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setDefaultAutoCommit(true);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
}
