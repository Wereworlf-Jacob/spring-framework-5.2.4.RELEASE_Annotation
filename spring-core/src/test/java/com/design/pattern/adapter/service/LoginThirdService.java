package com.design.pattern.adapter.service;

import com.design.pattern.adapter.vo.ResultVO;
import com.design.pattern.adapter.vo.UserInfo;

/**
 * @ClassName LoginThirdService
 * @Description 第三方登录服务类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 15:59
 **/
public class LoginThirdService extends LoginService {

	/**
	 * 一般来说，我们较少地使用继承，还可以通过注入的方式，来扩展接口
	 * 此处通过new来模拟注入过程
	 * LoginService loginService = new LoginService();
	 * 然后将super.*替换为loginService.*
	 */

	/**
	 * 模式方法，要根据业务情况进行合理化调整
	 * 比如第三方登录，是否应该根据openId查询出具体用户后，再执行登录方法
	 * 要根据数据结构设计来具体分析，具体使用
	 */

	/**
	 * 模拟QQ登录
	 * @param openId
	 */
	public void loginForQQ(String openId) {
		String defultPwd = "QQ_PWD";
		System.out.println("login from QQ!");
		ResultVO<UserInfo> resultVO = super.register(openId, defultPwd);
		resultVO = super.login(resultVO.getData().getUserName(), resultVO.getData().getPassword());
		System.out.println(resultVO);
	}

	/**
	 * 模拟微信登录
	 * @param openId
	 */
	public void loginForWechat(String openId) {
		String defultPwd = "WECHAT_PWD";
		System.out.println("login from wechat!");
		ResultVO<UserInfo> resultVO = super.register(openId, defultPwd);
		resultVO = super.login(resultVO.getData().getUserName(), resultVO.getData().getPassword());
		System.out.println(resultVO);
	}

	/**
	 * 模拟新浪登录
	 * @param openId
	 */
	public void loginForSina(String openId) {
		String defultPwd = "SINA_PWD";
		System.out.println("login from sina!");
		ResultVO<UserInfo> resultVO = super.register(openId, defultPwd);
		resultVO = super.login(resultVO.getData().getUserName(), resultVO.getData().getPassword());
		System.out.println(resultVO);
	}

}
