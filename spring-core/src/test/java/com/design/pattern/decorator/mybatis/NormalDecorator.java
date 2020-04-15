package com.design.pattern.decorator.mybatis;

/**
 * @ClassName NormalDecorator
 * @Description 普通的装饰器，仅执行原生语句
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 11:41
 **/
public class NormalDecorator extends Executor {

	@Override
	public void execute() {
		super.execute();
	}
}
