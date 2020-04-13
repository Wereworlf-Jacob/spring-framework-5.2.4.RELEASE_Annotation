package com.design.pattern.strategy.payport;

/**
 * @ClassName AliPay
 * @Description 支付宝支付方式
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:24
 **/
public class AliPay implements Payment {

	@Override
	public PayState pay(double amount) {
		System.out.println("welcome to use zhi fu bao of alibaba");
		System.out.println("your balance is ***, paying please wait");
		return new PayState("200", "success", amount);
	}

}
