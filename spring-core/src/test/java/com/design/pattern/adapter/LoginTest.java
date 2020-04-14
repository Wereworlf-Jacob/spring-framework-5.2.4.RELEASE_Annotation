package com.design.pattern.adapter;

import com.design.pattern.adapter.service.LoginService;
import com.design.pattern.adapter.service.LoginThirdService;

/**
 * @ClassName LoginTest
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 15:45
 **/
public class LoginTest {

	/**
	 *适配器模式-主要特征为“兼容”
	 * 在不影响原有逻辑的情况下，在此基础上扩展新的接口
	 * 已达到程序的复用
	 */
	public static void main(String[] args) {

		//原登录接口可以照常时间，不影响
		LoginService loginService = new LoginService();
		System.out.println(loginService.login("mr.shao", "111111"));
		//通过扩展出来的第三方接口，可以在登录的基础上，增加三方平台登录
		//在这里，客户直接调用方法来执行，同样，可以使用委派模式，或者策略模式，来构造调用登录这一块的方法逻辑
		LoginThirdService loginThirdService = new LoginThirdService();
		loginThirdService.loginForQQ("QQ-login");
		loginThirdService.loginForWechat("wechat-login");
		loginThirdService.loginForSina("sina-login");
		/**
		 * 如 LoginForSinaAdapter, LoginForQQAdapter, LoginForWechatAdapter
		 * 如果登录业务比较复杂的情况，可以单独提取每种登录方式，做为一个适配器类型
		 * 同样的，所有登录可以同时实现LoginAdapter接口
		 * 然后可以使用策略模式，来匹配登录方式和登录接口之间的关系
		 * 如果参数一致，也可以使用委派模式，来通过命令的方式，对接口调用进行一个调度分发
		 * 如果适配器new的过程比较复杂，还可以考虑通过工厂模式，来创建adapter
		 * 根据业务需求，设计模式要灵活组合，来达到简化代码的目的
		 */
	}

}
