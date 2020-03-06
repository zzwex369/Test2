package com.xyw.client.henan.util;


import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class CsyxzmWebRequestUtil {
	
	public static boolean isValidate(String s900_01,Session session){
		try {
			SQLQuery sqlQuery = session.createSQLQuery("select t.S900_03 from S900 t where t.S900_01 = ?");
			sqlQuery.setString(0, s900_01);
			String s900_03 = (String)sqlQuery.uniqueResult();
			if("1".equals(s900_03)){
				return true;
			} else {
				return false;
			}
			
		} catch (HibernateException e) {
			return true;
		}
	}
}
