package com.design.pattern.decorator;

import com.design.pattern.decorator.old.ILoginService;
import com.design.pattern.decorator.old.LoginService;
import com.design.pattern.decorator.upgrade.ILoginThirdService;
import com.design.pattern.decorator.upgrade.LoginThirdService;

/**
 * @ClassName DecoratorTest
 * @Description 装饰器模式测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 9:48
 **/
public class DecoratorTest {

	/**
	 * 装饰器模式，原来的方法可以集成过来，继续使用，而适配器模式，在新的api里面是不支持的。
	 * ---------------------------------------------------------------------------------
	 * 两种模式进行对比
	 * =================================================================================
	 * 装饰器模式                           /      适配器模式
	 * ------------------------------------*--------------------------------------------
	 * 非常特别的适配器模式                  /      可以不保留层级关系
	 * ------------------------------------*--------------------------------------------
	 * 装饰者和被装饰者都要实现同一个接口     /      适配者和被适配者没有必然的关系
	 * 主要目的是为了扩展，依旧保留oop关系    /      通常采用代理或者集成的形式进行包装
	 * ------------------------------------*--------------------------------------------
	 * 满足is-a的关系                       /      满足has-a的关系
	 * ------------------------------------*--------------------------------------------
	 * 注重的是覆盖和扩展                    /      注重的兼容和转换
	 * =================================================================================
	 */

	public static void main(String[] args) {
		//这样，就能通过包装的模式，将原来的登录功能包装成为三方登录功能，同时用于原来的登录方法
		ILoginThirdService iLoginThirdService = new LoginThirdService(new LoginService());
		System.out.println(iLoginThirdService.login("zhangsan", "zhangsanpwd"));
		iLoginThirdService.loginForQQ("QQ_LOGIn");
		iLoginThirdService.loginForWechat("wechat_login");
		iLoginThirdService.loginForSina("sina_login");
		//同样，也可以使用不进行任何包装的登录模式
		ILoginService iLoginService = new LoginService();
		System.out.println(iLoginService.login("wangwu", "zhaoliu"));
	}

}
