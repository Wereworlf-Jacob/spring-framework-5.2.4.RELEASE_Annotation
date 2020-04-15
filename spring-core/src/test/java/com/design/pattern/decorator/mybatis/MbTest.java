package com.design.pattern.decorator.mybatis;

/**
 * @ClassName MbTest
 * @Description mybatis 装饰器模式测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 11:32
 **/
public class MbTest {

	public static void main(String[] args) {
		//比如mybatis可以设置查询是否启用二级缓存，是否加装日志显示，是否加装流操作
		//假设，我只需要一个执行查询语句，那么就是一个执行器
		Executor executor = new NormalDecorator();
//		executor.execute();
		//假设，我需要给这个查询加装日志模块
		executor = new LoggerDecorator(executor);
//		executor.execute();
		//假设，我还需要给这个查询加装缓存和流操作
		executor = new CacheDecorator(new StreamDecorator(executor));
		executor.execute();
		//通过这样一层一层地包装，可以对原来的方法进行无限制的增强
		//装饰器模式，需要所有的装饰类，都持有一个共同的接口或者抽象类
	}

}
