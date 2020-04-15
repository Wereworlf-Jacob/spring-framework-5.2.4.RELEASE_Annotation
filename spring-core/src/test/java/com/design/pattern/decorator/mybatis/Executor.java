package com.design.pattern.decorator.mybatis;

/**
 * @ClassName Executor
 * @Description 模拟mybatis方法执行器
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 11:33
 **/
public abstract class Executor {

	public void execute(){
		System.out.println("I'll execute the sql!");
	};

}
