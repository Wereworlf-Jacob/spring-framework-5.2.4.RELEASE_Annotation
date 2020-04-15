package com.design.pattern.decorator.old;

import com.design.pattern.decorator.ResultVO;

/**
 * @ClassName ILoginService
 * @Description 原有的登录
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 9:48
 **/
public interface ILoginService {

	/**
	 * 模拟注册接口
	 * @param username
	 * @param password
	 * @return
	 */
	ResultVO register(String username, String password);

	/**
	 * 模拟登录接口
	 * @param username
	 * @param password
	 * @return
	 */
	ResultVO login(String username, String password);
}
