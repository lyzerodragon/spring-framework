package com.zerodragon.demo.bean;

/**
 * 类声明:&nbsp;
 *
 * @author zeroDragon
 * @date 2022/12/4
 */
public class Cat {
	private String name ;
	private Integer age ;

	public String getName() {
		return name;
	}

	public Cat setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
