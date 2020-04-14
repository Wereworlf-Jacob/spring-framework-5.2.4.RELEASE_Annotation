package com.design.pattern.template.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName RowMapper
 * @Description 结果集转化成对象的接口
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/13 17:22
 **/
public interface RowMapper<T> {

	//结果集转化成对象的接口方法
	T mapRow(ResultSet rs) throws SQLException;

}
