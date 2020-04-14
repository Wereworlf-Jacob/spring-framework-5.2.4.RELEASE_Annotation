package com.design.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JdbcTemplate
 * @Description jdbc查询模板
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 16:53
 **/
//版本1.0，该模板类是一个抽象方法，客户需要进行的操作抽象抽取
//public abstract class JdbcTemplate {
//版本2.0，该模板类就是一个单独的类，客户需要进行的操作由接口实现
public class JdbcTemplate{
	private DataSource dataSource;

	public JdbcTemplate(DataSource dataSource) {
		this.dataSource = dataSource;
	}

//	/**
//	 * 执行查询方法
//	 * @author Jacob
//	 * @version 1.0 版本1，这是一个抽象类
//	 */
//	public List<?> executeQuery(String sql, Object[] values) {
//		/**
//		 * 1、获得数据库连接对象
//		 * 2、创建预编译语句集
//		 * 3、创建结果集对象
//		 * 4、执行结果集转化为对象
//		 * 5、关闭结果集
//		 * 6、关闭语句集
//		 * 7、关闭数据库连接
//		 */
//		try {
//			Connection conn = dataSource.getConnection(); //1、获得数据库连接对象
//			PreparedStatement pstm = conn.prepareStatement(sql); //2、创建预编译语句集
//			ResultSet rs = pstm.executeQuery();//3、创建结果集对象
//			List<Object> list = new ArrayList<>();
//			while (rs.next()) {
//				list.add(processResult(rs)); //4、执行结果集转化为对象
//			}
//			rs.close();//关闭结果集
//			pstm.close();//关闭语句集
//			conn.close();//关闭数据库连接
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ArrayList<>();
//		}
//	}

	/**
	 * 不同的查询，解析结果集的方式不一样，这个由使用客户来决定如何解析结果集
	 * @author Jacob
	 * @since 2020/4/13 版本1，使用抽象方法
	 */
//	public abstract Object processResult(ResultSet rs) throws Exception;


	/**
	 *
	 * @author Jacob
	 * @since 2020/4/13
	 * @version 版本2.0，提取每个步骤，为一个私有方法单独执行，结果集解析使用接口方法来执行
	 */
	public <T>List<T> executeQuery(String sql, Object[] values, RowMapper<T> rowMapper) {
		try {
			// 1、获得数据库连接对象
			Connection conn = this.getConnection();
			// 2、创建预编译语句集
			PreparedStatement pstm = this.createPrepareStatement(conn, sql);
			//3、创建结果集对象
			ResultSet rs = this.createResultSet(pstm, values);
			//4、执行结果集转化为对象
			List<T> list = this.parseResult(rs, rowMapper);
			//5、关闭结果集
			this.closeResultSet(rs);
			//6、关闭语句集
			this.closeStatement(pstm);
			//7、关闭数据库连接
			this.closeConnection(conn);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	private PreparedStatement createPrepareStatement(Connection conn, String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}
	private ResultSet createResultSet(PreparedStatement preparedStatement, Object[] values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			preparedStatement.setObject(i, values[i]);
		}
		return preparedStatement.executeQuery();
	}
	private <T>List<T> parseResult(ResultSet rs, RowMapper<T> rowMapper) throws SQLException {
		List<T> list = new ArrayList<>();
		while (rs.next()) {
			list.add(rowMapper.mapRow(rs));
		}
		return list;
	}
	private void closeStatement(Statement statement) throws SQLException {
		statement.close();
	}
	private void closeResultSet(ResultSet rs) throws SQLException {
		rs.close();
	}
	private void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

}
