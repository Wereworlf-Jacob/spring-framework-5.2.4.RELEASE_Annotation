package com.design.pattern.adapter.vo;

/**
 * @ClassName ResultVO
 * @Description 结果对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 15:49
 **/
public class ResultVO<T> {
	private int code;

	private String msg;

	private T data;

	public ResultVO(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "code: " + code + "; msg: " + msg + "; data: " + data;
	}
}
