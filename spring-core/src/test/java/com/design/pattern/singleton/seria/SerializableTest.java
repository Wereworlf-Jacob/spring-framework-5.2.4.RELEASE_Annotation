package com.design.pattern.singleton.seria;

import com.design.pattern.singleton.Hungry;

import java.io.*;

/**
 * @ClassName SerializableTest
 * @Description
 * @Author Jacob
 * @Date 2020/3/31 15:44
 * @Version 1.0
 **/
public class SerializableTest {

	public static void main(String[] args) {

		//通过测试发现，经过序列号，再反序列化之后，对象就变了，破坏了单例模式
		Object obj = Hungry.getInstance();
		Object obj2 = seriableObj(obj);
		System.out.println(obj);
		System.out.println(obj2);
		System.out.println(obj == obj2);

		Object obj3 = SingletonSeriable.getInstance();
		Object obj4 = seriableObj(obj3);
		System.out.println(obj3);
		System.out.println(obj4);
		System.out.println(obj3 == obj4);
	}

	public static Object seriableObj(Object obj) {
		Object obj2 = null;
		try {
			FileOutputStream fos = new FileOutputStream("Seriable.Obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();
			oos.close();

			FileInputStream fis = new FileInputStream("Seriable.Obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj2 = ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj2;
	}
}
