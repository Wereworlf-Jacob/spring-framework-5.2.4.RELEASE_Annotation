package com.design.pattern.factory.simple;

import com.design.pattern.factory.Mengniu;
import com.design.pattern.factory.Milk;
import com.design.pattern.factory.Telunsu;

/**
 * @ClassName SimpleFactoryTest
 * @Description 简单工厂模式的应用测试类
 * @Author Jacob
 * @Date 2020/3/27 19:33
 */
public class SimpleFactoryTest {

	public static void main(String[] args) {

		//直接去生产牛奶这个产品是不行的，因为他是一个产品类型，无法直接生产
		//System.out.println(new Milk());
		//所以需要指定牛奶品牌，去生产一个特仑苏，这样就拿到了一个牛奶产品
		//此生产方法为1.0，此时你要知道每款牛奶的生产过程
		System.out.println(new Telunsu().getName()); //原始版本，未使用设计模式
		//如果想要一个蒙牛，那么就需要生产一个蒙牛
		System.out.println(new Mengniu().getName());

		//上一个版本，牛奶是每个人去生产的，谁想要一个牛奶，那么就去生产一个
		//随着经济的发展，出现了牛奶供应商，他可以生产任何牛奶
		SimpleFactory factory = new SimpleFactory(); //那么首先你需要先有一个工厂，同时知道它在哪
		//然后你才能告诉工厂，你想要什么牛奶，然后工厂会提供给你产品
		//此生产方法为2.0，此时你只需要提供产品名称，然后拿到结果，至于牛奶是如何生产的，你就不需要关心了。
		System.out.println(factory.getMilk("mengniu").getName()); //简单工厂模式

		//上一个版本，虽然有了一个工厂去生产牛奶，但是属于小作坊方式
		//随着生产力的提升，那么必然会出现生产线，流水线，那么每种牛奶，应该由各个流水线去负责
		//所以工厂升级到2.0 func 工厂方法模式

	}

}
