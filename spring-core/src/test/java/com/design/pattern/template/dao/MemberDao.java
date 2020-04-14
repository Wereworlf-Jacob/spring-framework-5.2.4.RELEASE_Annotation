package com.design.pattern.template.dao;

import com.design.pattern.template.Member;
import com.design.pattern.template.jdbc.JdbcTemplate;
import com.design.pattern.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName MemberDao
 * @Description member成员信息执行sql的Dao类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 17:11
 **/
//版本1，jdbc模板类是一个抽象类，所以需要继承
//public class MemberDao extends JdbcTemplate {
//版本2，JDBC模板类就是一个单独的类，dao无需继承template，通常都是注入一个template
public class MemberDao  {

//	public MemberDao(DataSource dataSource) {
//		super(dataSource);
//	}

	//版本1，继承抽象类，实现解析结果集的方法
//	@Override
//	public Object processResult(ResultSet rs) throws Exception {
//		Member member = new Member();
//		member.setName(rs.getString("name"));
//		member.setAge(rs.getString("age"));
//		member.setHeight(rs.getString("height"));
//		return member;
//	}

	//版本2 ，dao类通常都是注入一个template，这个地方通过new模拟注入过程
	JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

	public List<Member> executeQuery(Object[] params){
		String sql = "select * from t_member";
		return jdbcTemplate.executeQuery(sql, params, rs -> {
			Member member = new Member();
			member.setName(rs.getString("name"));
			member.setHeight(rs.getString("height"));
			member.setAge(rs.getString("age"));
			return member;
		});
	}

}
