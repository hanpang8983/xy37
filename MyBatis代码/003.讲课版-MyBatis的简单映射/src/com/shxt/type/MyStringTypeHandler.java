package com.shxt.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class MyStringTypeHandler extends BaseTypeHandler<String> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		if(parameter!=null){
			parameter = parameter.trim();
			ps.setString(i, parameter);
		}
	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if(rs.getString(columnName)!=null){
			String str = rs.getString(columnName);
			if(str.equals("林志玲")){
				str = str+"大码";
			}
			return str;
		}
		return null;
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		if(rs.getString(columnIndex)!=null){
			String str = rs.getString(columnIndex);
			if(str.equals("林志玲")){
				str = str+"大码";
			}
			return str;
		}
		return null;
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		if(cs.getString(columnIndex)!=null){
			String str = cs.getString(columnIndex);
			if(str.equals("林志玲")){
				str = str+"大码";
			}
			return str;
		}
		return null;
	}

}
