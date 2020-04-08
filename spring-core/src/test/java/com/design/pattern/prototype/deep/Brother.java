package com.design.pattern.prototype.deep;

import java.io.Serializable;

/**
 * @ClassName Brother
 * @Description
 * @Author Jacob
 * @Date 2020/4/8 14:19
 * @Version 1.0
 **/
public class Brother extends ShengWu implements Serializable {

	private static final long serialVersionUID = -5446072406658478552L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
