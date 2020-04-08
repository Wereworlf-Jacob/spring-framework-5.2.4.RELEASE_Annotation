package com.design.pattern.prototype.deep;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.List;

/**
 * @ClassName SunWuKong
 * @Description 孙悟空
 * @Author Jacob
 * @Date 2020/4/8 14:18
 * @Version 1.0
 **/
public class SunWuKong extends ShengWu implements Cloneable, Serializable {

	private static final long serialVersionUID = -8964844060953649564L;
	private String name;

	private Master master;

	private List<Brother> brothers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public List<Brother> getBrothers() {
		return brothers;
	}

	public void setBrothers(List<Brother> brothers) {
		this.brothers = brothers;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return deepClone(this);
	}

	//通过序列化的方式实现深度copy
	private Object deepClone(Object o) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(o);

			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			return ois.readObject();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
