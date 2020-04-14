package com.design.pattern.delegate.leader;

/**
 * @ClassName LeaderTest
 * @Description 职场领导任务调度分发，
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 14:14
 **/
public class LeaderTest {

	/**
	 * 客户请求、委派者、被委派者
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.recived("decode");
	}

}
