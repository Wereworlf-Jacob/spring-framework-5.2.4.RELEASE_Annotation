package com.design.pattern.strategy;

import com.design.pattern.strategy.payport.PayState;
import com.design.pattern.strategy.payport.PayType;
import com.design.pattern.strategy.payport.Payment;

/**
 * @ClassName OrderInfo
 * @Description 订单信息
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:17
 **/
public class OrderInfo {

	//用户ID
	private String uid;

	//订单号
	private String orderId;

	//价格
	private double amount;

	public OrderInfo(String uid, String orderId, double amount) {
		this.uid = uid;
		this.orderId = orderId;
		this.amount = amount;
	}

	/**
	 * 订单的支付操作
	 */
	public PayState pay(Payment payment){
		return payment.pay(amount);
	}

	public PayState pay(PayType payType) {
		return payType.getPayment().pay(amount);
	}

	public PayState pay(String code) {
		return PayType.get(code).pay(amount);
	}
}
