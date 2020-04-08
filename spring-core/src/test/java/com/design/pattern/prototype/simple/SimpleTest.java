package com.design.pattern.prototype.simple;

import java.util.Date;

/**
 * @ClassName SimpleTest
 * @Description 简单的原型模式，应用方式之一
 * @Author Jacob
 * @Date 2020/4/8 13:26
 * @Version 1.0
 **/
public class SimpleTest {

	public static void main(String[] args) {
		Person person = new Person();
		try {
			Person person2 = (Person) person.clone();
			person2.getBirthday().setTime(System.currentTimeMillis() - 1000*60*60*24*7);
			//通过实现cloneable接口，然后重写clone方法，就实现了一个copy的原型模式
			System.out.println(person);
			System.out.println(person2);
			//但是观察Date类型的birthday属性，person 的生日不动，但是我获取到person2的生日
			//然后为其更改生日，向上倒7天之后，发现person的生日也发生了变化，说明克隆出来的
			//人员生日信息，使用了同一个物理地址，而不是copy值，不符合原型模式
			//所以这种方式属于浅copy，只能适用基础数据类型属性的原型
			System.out.println(person.getBirthday());
			System.out.println(person2.getBirthday());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
