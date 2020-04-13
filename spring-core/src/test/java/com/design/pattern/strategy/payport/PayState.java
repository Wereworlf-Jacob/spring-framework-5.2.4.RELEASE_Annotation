package com.design.pattern.strategy.payport;

/**
 * @ClassName PayState
 * @Description 支付状态
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:19
 **/
public class PayState {

	//状态码
	private String code;

	//支付数据
	private Object data;

	//支付信息
	private String msg;

	public PayState(String code, String msg, Object data) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "state:[" + code + "]" + ";message:" + msg + ";pay amount:" + data;
	}
}
