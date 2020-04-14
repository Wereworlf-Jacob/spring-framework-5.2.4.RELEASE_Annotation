package com.design.pattern.delegate.mvc.http;

/**
 * @ClassName HttpServletRequest
 * @Description 模拟request对象
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 13:21
 **/
public class HttpServletRequest {

	private String requestUri;

	//这里通过构造方法，来模拟接收请求字符串
	public HttpServletRequest(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}
}
