package com.design.pattern.proxy.dynamic;

import com.design.pattern.proxy.Person;
import com.design.pattern.proxy.Wangwu;
import com.design.pattern.proxy.Zhangsan;
import com.design.pattern.proxy.dynamic.cglib.SameCityProxy;
import com.design.pattern.proxy.dynamic.jdk.MeipoProxy;
import org.springframework.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName JDKProxyTest
 * @Description jdk动态代理测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 10:14
 **/
public class ProxyTest {

	public static void main(String[] args) {
//		saveJdkProxyClass("$person$proxy$0", Zhangsan.class);//通过代理类生成器来生成class文件
//		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); //设置系统数据，保存生成的文件信息，为true，来保存代理类class文件
		//JDK动态代理应用场景
		//使用JDK动态代理，被代理人必须要有顶层接口，才能使用
		MeipoProxy meipoProxy = new MeipoProxy();
		Person person = (Person) meipoProxy.getInstance(new Zhangsan());
		person.findLove();
		System.out.println(person.getClass().getName());
		//CGLIB动态代理应用场景
		//使用CGLIB，被代理人无需实现接口

//		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\lenovo\\Desktop\\cglib"); 设置保存cglib生成的代理类class文件地址的方法
		SameCityProxy sameCityProxy = new SameCityProxy();
		Wangwu wangwu = (Wangwu) sameCityProxy.getInstance(Wangwu.class);
		wangwu.findLove();
		System.out.println(wangwu.getClass().getName());
	}

	/**
	 * 通过ProxyGenerator jdk代理类生成器，来生成一个代理类字节数组信息
	 * 然后将类的字节信息，写入到文件中，来保存一个class文件
	 * @param proxyName 要生成的代理类class文件名称
	 * @param proxyClass 被代理对象类信息
	 * @return
	 * @throws
	 *
	 * @author Jacob
	 * @since 2020/4/13
	 */
	public static void saveJdkProxyClass(String proxyName, Class proxyClass){
		//传入生成class文件名称，以及被代理对象实现的接口信息，来生成一个类信息
		byte[] bytes = ProxyGenerator.generateProxyClass(proxyName, proxyClass.getInterfaces());
		String path = "C:\\Users\\lenovo\\Desktop\\jdkProxy\\";
		path = path + proxyName + ".class";
		try {
			//将类信息写入文件
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(bytes);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
