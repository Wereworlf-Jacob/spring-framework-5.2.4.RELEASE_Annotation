package com.design.pattern.strategy.payport;

/**
 * @ClassName Payment
 * @Description 支付方式
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:19
 **/
public interface Payment {

	/**
	 * 支付操作
	 * @param amount 支付金额
	 * @return 支付完成状态
	 */
	PayState pay(double amount);

}
