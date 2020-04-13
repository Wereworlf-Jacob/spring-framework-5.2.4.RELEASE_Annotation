package com.design.pattern.strategy.payport;

/**
 * @ClassName PayType
 * @Description 支付类型枚举对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:37
 **/
public enum PayType {

	ALI("ali", new AliPay()),
	WECHAT("wechat", new WechatPay()),
	UNION("union", new UnionPay());

	private String code;

	private Payment payment;

	PayType(String code, Payment payment) {
		this.code = code;
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}

	public String getCode() {
		return code;
	}

	//还可以通过code检索的方式，来匹配对应的支付方式
	public static Payment get(String code){
		PayType[] payTypes = values();
		for (PayType payType : payTypes) {
			if (code.equals(payType.getCode())){
				return payType.getPayment();
			}
		}
		return null;
	}
}
