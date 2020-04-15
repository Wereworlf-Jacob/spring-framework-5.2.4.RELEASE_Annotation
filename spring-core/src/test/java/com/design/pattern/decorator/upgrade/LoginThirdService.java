package com.design.pattern.decorator.upgrade;

import com.design.pattern.decorator.ResultVO;
import com.design.pattern.decorator.old.ILoginService;

/**
 * @ClassName LoginThirdService
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 11:20
 **/
public class LoginThirdService implements ILoginThirdService {

	private ILoginService loginService;

	public LoginThirdService(ILoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public ResultVO register(String username, String password) {
		return loginService.register(username, password);
	}

	@Override
	public ResultVO login(String username, String password) {
		return loginService.login(username, password);
	}

	@Override
	public void loginForQQ(String openId) {
		String pwd = "QQ_PWD";
		System.out.println(loginService.login(openId, pwd));
	}

	@Override
	public void loginForWechat(String openId) {
		String pwd = "WECHAT_PWD";
		System.out.println(loginService.login(openId, pwd));
	}

	@Override
	public void loginForSina(String openId) {
		String pwd = "SINA_PWD";
		System.out.println(loginService.login(openId, pwd));
	}
}
