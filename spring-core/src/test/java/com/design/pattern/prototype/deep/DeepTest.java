package com.design.pattern.prototype.deep;

import java.util.Arrays;

/**
 * @ClassName DeepTest
 * @Description 深度copy，原型模式
 * @Author Jacob
 * @Date 2020/4/8 14:11
 * @Version 1.0
 **/
public class DeepTest {

	public static void main(String[] args) {

		//新建一个孙悟空特定对象
		SunWuKong swk = createWuKong();
		try {
			//通过序列化的方式，可以实现深度copy，此时修改clone的对象数据，不影响原数据
			//同样的，还可以通过spring的BeanUtils，dozer实现原型模式
			SunWuKong clone = (SunWuKong) swk.clone();
			System.out.println(swk == clone);
			System.out.println(swk.getMaster() == clone.getMaster());
			System.out.println(swk.getBrothers() == clone.getBrothers());
			System.out.println(swk.getMaster().getName());
			clone.getMaster().setName("clone tang san zang");
			System.out.println(clone.getMaster().getName());
			System.out.println(swk.getBrothers().get(0).getName());
			System.out.println(swk.getBrothers().get(1).getName());
			clone.getBrothers().get(0).setName("clone er shi di");
			clone.getBrothers().get(1).setName("clone san shi di");
			System.out.println(clone.getBrothers().get(0).getName());
			System.out.println(clone.getBrothers().get(1).getName());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

	private static SunWuKong createWuKong(){
		SunWuKong swk = new SunWuKong();
		swk.setName("qi tian da sheng");
		swk.setAge(1024);
		swk.setSpecies("monkey");
		swk.setSex("male");
		Master master = new Master();
		master.setName("tang san zang");
		master.setAge(23);
		master.setSex("male");
		master.setSpecies("human");
		Brother two = new Brother();
		two.setName("zhu ba jie");
		two.setAge(730);
		two.setSex("male");
		two.setSpecies("pig");
		Brother three = new Brother();
		three.setName("sha seng");
		three.setSex("female");
		three.setSpecies("shen xian");
		swk.setMaster(master);
		swk.setBrothers(Arrays.asList(two, three));
		return swk;
	}

}
