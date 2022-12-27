package com.zerodragon.demo.transactional;

import com.alibaba.fastjson2.JSON;
import com.zerodragon.demo.AnnotationConfigApplicationContextUtil;
import com.zerodragon.demo.transactional.config.JdbcConfig;
import com.zerodragon.demo.transactional.dao.UserDao;
import com.zerodragon.demo.transactional.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/23-18:02
 **/
public class CrudUserTest {

	public static final Logger log = LogManager.getLogger(CrudUserTest.class.getName());

	@Test
	public void insertUserTest(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class );
		UserDao userDao = applicationContext.getBean(UserDao.class);


		User u = new User("小明",18);
		Assert.isTrue(userDao.insert(u)>0,"插入失败");

		List<User> users = userDao.queryList();

		Assert.isTrue(!CollectionUtils.isEmpty(users),"查询无数据");

		log.info("users:{}", JSON.toJSONString(users));

		applicationContext.close();

	}

	@Test
	public void insertUserTestAndApplicationTest(){
		AnnotationConfigApplicationContextUtil.run(JdbcConfig.class , applicationContext -> {
			UserDao userDao = applicationContext.getBean(UserDao.class);
			User u = new User("小明",18);
			Assert.isTrue(userDao.insert(u)>0,"插入失败");
			List<User> users = userDao.queryList();
			Assert.isTrue(!CollectionUtils.isEmpty(users),"查询无数据");
			log.info("users:{}", JSON.toJSONString(users));
		});
	}


}
