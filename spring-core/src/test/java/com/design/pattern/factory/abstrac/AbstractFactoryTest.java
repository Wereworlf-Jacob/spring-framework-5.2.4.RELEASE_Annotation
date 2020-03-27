package com.design.pattern.factory.abstrac;

/**
 * @ClassName AbstractFactoryTest
 * @Description 抽象工厂模式应用的测试类
 * @Author Jacob
 * @Date 2020/3/27 20:24
 */
public class AbstractFactoryTest {

	public static void main(String[] args) {

		//对于用户来说，只需要拿到这个工厂，那么就可以选择自己想要的产品
//		AbstractFactory abstractFactory = new AbstractFactory();
//		System.out.println(abstractFactory.getMengniu());

		//同样这是一个抽象工厂，一般是不拿来直接使用的，需要给定具象的工厂
		MilkFactory factory = new MilkFactory();
		//此时用户不关心产品配方，不关心生产过程，只需要选择心仪的产品就好了
		System.out.println(factory.getMengniu().getName());

	}

}
