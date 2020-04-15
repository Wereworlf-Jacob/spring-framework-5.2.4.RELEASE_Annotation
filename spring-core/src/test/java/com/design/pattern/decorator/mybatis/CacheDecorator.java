package com.design.pattern.decorator.mybatis;

/**
 * @ClassName CacheDecorator
 * @Description 缓存装饰器
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 11:36
 **/
public class CacheDecorator extends Executor {

	private Executor executor;

	public CacheDecorator(Executor executor) {
		this.executor = executor;
	}

	@Override
	public void execute() {
		System.out.println("I can help you set cache!");
		executor.execute();
	}
}
