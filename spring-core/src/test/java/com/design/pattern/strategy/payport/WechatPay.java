package com.design.pattern.strategy.payport;

/**
 * @ClassName WechartPay
 * @Description 微信支付方式
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:24
 **/
public class WechatPay implements Payment {
	@Override
	public PayState pay(double amount) {
		System.out.println("welcome to use wechat of tencent");
		System.out.println("your balance is ***, paying please wait");
		return new PayState("200", "success", amount);
	}
}
