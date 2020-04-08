package com.design.pattern.prototype.deep;

import java.io.Serializable;

/**
 * @ClassName Master
 * @Description 师傅
 * @Author Jacob
 * @Date 2020/4/8 14:19
 * @Version 1.0
 **/
public class Master extends ShengWu implements Serializable {

	private static final long serialVersionUID = -1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
