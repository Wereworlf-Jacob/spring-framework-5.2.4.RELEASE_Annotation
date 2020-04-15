package com.design.pattern.decorator.old;

import com.design.pattern.decorator.MemberInfo;
import com.design.pattern.decorator.ResultVO;

/**
 * @ClassName LoginService
 * @Description 原有的登录业务
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 11:18
 **/
public class LoginService implements ILoginService {

	@Override
	public ResultVO register(String username, String password) {
		return new ResultVO("200", "regist success!", new MemberInfo(username, password));
	}

	@Override
	public ResultVO login(String username, String password) {
		return new ResultVO("200", "welcome home "+ username +"!", new MemberInfo(username, password));
	}
}
