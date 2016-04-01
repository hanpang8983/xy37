package com.shxt.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class DivDaysTypeHandler extends BaseTypeHandler<String> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if(rs.getString(columnName)!=null){
			Long l = Long.parseLong(rs.getString(columnName));
			long day = l/(1000*60*60*24);
			return String.valueOf(day);
		}
		return null;
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		if(rs.getString(columnIndex)!=null){
			Long l = Long.parseLong(rs.getString(columnIndex));
			long day = l/(1000*60*60*24);
			return String.valueOf(day);
		}
		return null;
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		if(cs.getString(columnIndex)!=null){
			Long l = Long.parseLong(cs.getString(columnIndex));
			long day = l/(1000*60*60*24);
			return String.valueOf(day);
		}
		return null;
	}

}
