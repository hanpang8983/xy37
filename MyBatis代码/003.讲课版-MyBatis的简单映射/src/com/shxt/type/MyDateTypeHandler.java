package com.shxt.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class MyDateTypeHandler extends BaseTypeHandler<Date> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType)
			throws SQLException {
		if(parameter!=null){
			Long l = parameter.getTime();
			ps.setString(i, String.valueOf(l));
		}
		
	}

	@Override
	public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if(rs.getString(columnName)!=null){
			Long l = Long.parseLong(rs.getString(columnName));
			return new Date(l);
		}
		return null;
	}

	@Override
	public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		if(rs.getString(columnIndex)!=null){
			Long l = Long.parseLong(rs.getString(columnIndex));
			return new Date(l);
		}
		return null;
	}

	@Override
	public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		if(cs.getString(columnIndex)!=null){
			Long l = Long.parseLong(cs.getString(columnIndex));
			return new Date(l);
		}
		return null;
	}

}
