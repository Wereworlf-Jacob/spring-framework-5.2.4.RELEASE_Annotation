package com.design.pattern.delegate.mvc.http;

/**
 * @ClassName HttpServletResponse
 * @Description 模拟response对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 13:21
 **/
public class HttpServletResponse {

	private Object result;

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
