package com.design.pattern.delegate.mvc;

import com.design.pattern.delegate.mvc.http.HttpServletRequest;
import com.design.pattern.delegate.mvc.http.HttpServletResponse;

/**
 * @ClassName MockSendReqTest
 * @Description 模拟发送请求测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 14:03
 **/
public class MockSendReqTest {

	/**
	 * 委派模式可以说是，一种特定的静态代理模式 + 策略模式的特殊组合
	 * 委派模式中，委托人只负责任务调度和分发，不负责任务的执行
	 * 与代理模式的区别：
	 * 1、代理模式注重过程，在被代理人执行方法之前之后，来完成自己的一个代理任务
	 *    委派模式注重结果，在任务下发之后，要先对任务进行一个前期分析和整理，进行一个调度之后，把任务分发给合适的执行者
	 * 2、代理模式，是接收一部分行为的代理，比如前置后置行为；委托模式，是对任务的全权委托，包括被委派人，也要被委托人来管理
	 * 3、当任务需要调度之后，分配下发的情况下，就需要使用委派模式，比如spring的请求分发
	 * 与策略模式的区别：
	 * 策略模式：注重于程序的可扩展性，算法固定，在不影响原有程序的情况下，去扩展新的算法
	 * 委派模式：注重内部的灵活和复用，可以根据客户请求，灵活调度任务，不需要客户去重复分析任务，然后再自己指派人员执行
	 */
	public static void main(String[] args) {
		//首先，作为客户，我要有一个委托人，去完成我的请求
		ServletDispatcher sd = new ServletDispatcher();
		//我要发送命令，让委托人来完成我下达的任务
		sd.doService(new HttpServletRequest("user/add"), new HttpServletResponse());
		//之后我还可以，通过response来拿到任务执行结果，来进行我想要的操作
	}

}
