package com.design.pattern.decorator.mybatis;

/**
 * @ClassName StreamDecorator
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 11:38
 **/
public class StreamDecorator extends Executor {

	private Executor executor;

	public StreamDecorator(Executor executor) {
		this.executor = executor;
	}

	@Override
	public void execute() {
		System.out.println("I'll allow you print to stream");
		executor.execute();
	}
}
