package com.design.pattern.template;

import com.design.pattern.template.dao.MemberDao;

import java.util.List;

/**
 * @ClassName TemplateTest
 * @Description 模板方法模式，应用场景测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:51
 **/
public class TemplateTest {

	//版本2.0，通常在这里注入一个dao类，此处用new来模拟注入过程
	static MemberDao memberDao = new MemberDao();

	/**
	 * 模板方式应用场景：
	 * 1、流程必须是固定的，这个流程就是一个模板
	 * 2、客户影响流程中其中一个，或者几个步骤的操作内容，但是操作结果必须是相同的，不能影响流程的执行情况
	 * 3、一般模板方法模式，会设置为抽象类，由客户进行的操作，提取成抽象方法，但是这种方案，对于使用模板的情况下，耦合度较高
	 *    所以，类似于spring就使用了RowMapper接口，来代替抽象方法，以降低耦合度
	 */
	public static void main(String[] args) {
		//这样版本1，就应用了模板方法，从1~7流程必须都得执行，但是第四步解析结果集执行内容需要自己执行
		//但是该版本存在问题，MemberDao需要继承JdbcTemplate，属于紧耦合，1~7步中，有存在复杂操作，都在同一方法执行不优雅
//		MemberDao memberDao = new MemberDao(null);
//		String sql = "select * from t_member";
//		List<?> list = memberDao.executeQuery(sql, null);


		/**
		 * 版本2.0，通常传递参数信息，然后直接返回查询结果
		 */
		List<Member> list = memberDao.executeQuery(new Object[]{});
	}

}
