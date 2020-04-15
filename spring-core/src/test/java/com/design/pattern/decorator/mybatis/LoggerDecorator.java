package com.design.pattern.decorator.mybatis;

/**
 * @ClassName LoggerDecorator
 * @Description 日志装饰器-在查询之前，查询之后加装日志模块
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 11:34
 **/
public class LoggerDecorator extends Executor {

	private Executor executor;

	public LoggerDecorator(Executor executor) {
		this.executor = executor;
	}

	@Override
	public void execute() {
		System.out.println("prepare to execute");
		executor.execute();
		System.out.println("execute finished!");
	}
}
