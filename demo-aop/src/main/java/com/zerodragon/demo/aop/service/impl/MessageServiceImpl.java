package com.zerodragon.demo.aop.service.impl;

import com.zerodragon.demo.aop.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/14-20:19
 **/
@Service
public class MessageServiceImpl implements MessageService {

	/**
	 * 日志记录器
	 */
	public static final Logger logger = LogManager.getLogger(MessageService.class.getName());


	@Override
	public void infoMessage() {
		logger.info("正常消息");
	}

	@Override
	public void errorMessage() {
		logger.error("错误消息");
	}
}
