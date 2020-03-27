package com.design.pattern.factory.simple;

import com.design.pattern.factory.Mengniu;
import com.design.pattern.factory.Milk;
import com.design.pattern.factory.Telunsu;
import com.design.pattern.factory.Yili;

/**
 * @ClassName SimpleFactory
 * @Description 简单工厂类，用于生产各类牛奶
 * @Author Jacob
 * @Date 2020/3/27 19:43
 */

/**
 * 1、简单工厂模式，虽然隐藏了生产过程，但是需要用户来提供产品名称
 * 如果这个参数错误的话，那么就会出现问题
 * 2、当需要扩展事，需要修改工厂，多增加一条生产线
 * 同时要把这个产品告知用户，用户才能准确使用，所以该模式使用较少
 * 针对简单产品有奇效
 */
public class SimpleFactory {

	//这个工厂只生产牛奶这一种产品，通过用户提供的配方，他们可以生产出对应的牛奶
	public Milk getMilk(String name){
		if ("telunsu".equals(name)) {
			return new Telunsu();
		} else if ("mengniu".equals(name)) {
			return new Mengniu();
		} else if ("yili".equals(name)) {
			return new Yili();
		} else {
			throw new RuntimeException("Can't produce undefined name of milk");
		}
	}

}
