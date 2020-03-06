package com.xyw.ws.util;


import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class CsyxzmWebRequestUtil {
	
	public static boolean isValidate(String s900_01,Session session){
		try {
			SQLQuery sqlQuery = session.createSQLQuery("select t.S900_03 from S900 t where t.S900_01 = ?");
			sqlQuery.setString(0, s900_01);
			String s900_03 = (String)sqlQuery.uniqueResult();
			//1:是  0:否
			if("0".equals(s900_03)){
				return false;
			} else {
				return true;
			}
		} catch (HibernateException e) {
			return true;
		}
	}
}
