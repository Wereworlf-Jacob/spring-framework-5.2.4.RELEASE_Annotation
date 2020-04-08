package com.design.pattern.prototype.simple;

import java.util.Date;

/**
 * @ClassName Person
 * @Description 个人信息-原型模式  复制一个对象出来，而不是直接赋值
 * @Author Jacob
 * @Date 2020/4/8 13:34
 * @Version 1.0
 **/
public class Person implements Cloneable {

	private String name = "zhang san";

	private String sex = "man";

	private int age = 12;

	private Date birthday = new Date();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	//实现可克隆接口，重写克隆方法，实现浅copy
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
