package com.design.pattern.decorator;

/**
 * @ClassName ResultVO
 * @Description 结果对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/15 10:13
 **/
public class ResultVO<T> {

	private String code;

	private String msg;

	private T data;

	public ResultVO(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	@Override
	public String toString() {
		return "code = " + code + "; msg = " + msg + "; data = " + data;
	}
}
