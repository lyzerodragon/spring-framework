package com.zerodragon.demo.test;

/**
 * 类声明:&nbsp; 动物
 *
 * @author zeroDragon
 * @date 2022/12/7
 */
public abstract class Animal {
	/**
	 * 类型
	 */
	private String type ;
	/**
	 * 年龄
	 */
	private Integer age ;


	public String getType() {
		return type;
	}

	public Integer getAge() {
		return age;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
