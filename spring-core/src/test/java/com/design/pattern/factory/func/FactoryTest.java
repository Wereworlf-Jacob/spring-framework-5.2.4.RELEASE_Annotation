package com.design.pattern.factory.func;

/**
 * @ClassName FactoryTest
 * @Description 工厂方法模式应用的测试类
 * @Author Jacob
 * @Date 2020/3/27 20:04
 */
public class FactoryTest {

	public static void main(String[] args) {

		//然后你可以通过工厂来生产牛奶 ，但是这只是一个工厂范本，是无法真正生产牛奶的
//		System.out.println(new Factory().getMilk());

		//所以需要根据类型，来具象出具体的工厂来进行生产行为
		Factory factory = new YiliFactory();
		//此方法为 3.0，此时通过各个流水线，就可以拿到你想要的产品，而不需要提供产品名称
		System.out.println(factory.getMilk().getName());

		//但是，会给用户增加困难度，因为你想要要给产品，还要知道流水线
		//所以一般会通过配置，蒙牛对用哪个流水线，然后供给用户使用。
		//相比版本2.0，此时对于用户来说操作较多，所以工厂就升级为4.0 抽象工厂模式
	}

}
