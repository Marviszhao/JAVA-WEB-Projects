package com.zhiyou.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.sun.org.apache.regexp.internal.recompile;

public class BaseDao {

	public <T> List<T> query(String sql,Class<T> type,Object ...os) throws Exception{
		if (sql == null){
			return null;
		}
		
		Connection c = DaoUtil.getConnecttion();
		PreparedStatement ps = c.prepareStatement(sql);
		ParameterMetaData paramData = ps.getParameterMetaData();
		int paramCount = paramData.getParameterCount();
		if (paramCount != os.length) {
			System.out.println("长度不匹配");
			System.out.println("参数个数："+os.length);
			System.out.println("参数个数："+paramCount);
			DaoUtil.closeDB(c,ps);
			return null;
		}
		
		for (int i = 0; i < os.length; i++) {
			ps.setObject(i+1, os[i]);
		}
		ResultSet set = ps.executeQuery();
		ResultSetMetaData setMetaData = set.getMetaData();
		int columncount = setMetaData.getColumnCount();
		String[] names = new String[columncount];
		
		for (int i = 1; i <= columncount; i++) {
			String name = setMetaData.getColumnName(i);
			names[i-1] = name;			
		}
		
		System.out.println(names);
		
		List<T> list = new ArrayList<>();
		while (set.next()) {
			T oE = type.newInstance();
			for (int i = 0; i < names.length; i++) {
				String cName = names[i];
				Object value = set.getObject(cName);
				BeanUtils.setProperty(oE, cName, value);
			}
			System.out.println(oE);
			list.add(oE);
		}
		
		DaoUtil.closeDB(c, ps, set);
		
		return list;		
				
	}
	
	public void update(String sql, Object ... os)  throws Exception{
		if (sql == null) {
			return;
		}
		Connection connection = DaoUtil.getConnecttion();
		PreparedStatement pStatement = connection.prepareStatement(sql);
		ParameterMetaData parameterMetaData = pStatement.getParameterMetaData();
		int paramCount = parameterMetaData.getParameterCount();
		if (paramCount != os.length) {
			System.out.println("长度不匹配");
			System.out.println("参数值个数为："+os.length);
			System.out.println("参数个数为：" + paramCount);
			DaoUtil.closeDB(connection,pStatement);
			return;
		}
		for (int i = 0; i < os.length; i++) {
			pStatement.setObject(i+1, os[i]);			
		}
		pStatement.execute();
		DaoUtil.closeDB(connection, pStatement);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
