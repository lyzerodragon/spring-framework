package com.zerodragon.demo.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop config
 * @see EnableAspectJAutoProxy 启用Aop自动代理
 * @author : songchenhao
 * @version : 1.0
 * @date : 2022/12/14-20:13
 **/
@ComponentScan("com.zerodragon.demo.aop")
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

}
