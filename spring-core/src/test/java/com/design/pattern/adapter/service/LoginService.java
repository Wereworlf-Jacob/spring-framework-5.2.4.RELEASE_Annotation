package com.design.pattern.adapter.service;

import com.design.pattern.adapter.vo.ResultVO;
import com.design.pattern.adapter.vo.UserInfo;

/**
 * @ClassName LoginService
 * @Description 模拟一个已有的登录服务，当前服务已上线多年，此时应该使用适配器模式，来扩展新接口来匹配登录服务
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 15:48
 **/
public class LoginService {

	/**
	 * 模拟注册方法
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public ResultVO register(String username, String password) {
		return new ResultVO(200, "register success!", new UserInfo(username, password));
	}

	/**
	 * 模拟登陆方法
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public ResultVO login(String username, String password) {
		return new ResultVO(200, "login success! welcome home " + username, new UserInfo(username, password));
	}

}
