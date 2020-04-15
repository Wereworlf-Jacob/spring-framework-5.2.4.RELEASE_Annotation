package com.design.pattern.decorator.upgrade;

import com.design.pattern.decorator.old.ILoginService;

/**
 * @ClassName ILoginThirdService
 * @Description 第三方登录接口
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 10:12
 **/
public interface ILoginThirdService extends ILoginService {

	void loginForQQ(String openId);

	void loginForWechat(String openId);

	void loginForSina(String openId);

}
