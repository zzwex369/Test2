package com.xyw.sys.util;

import org.hibernate.Session;

/***
 * 
 * @author Joe
 *
 */
public class MsCountryCode {
	/**
	 * 用来得到国家编码
	 * @return String [] 0 现住址编码 国家  1 户口地址编码 国家
	 * nowCode 现住址编码
	 * permanentCode 户口地址编码
	 */
	public static String [] setCountryCode(String nowCode,String permanentCode,Session session) {
		String [] code=new String[2];
		try {
			code[0]=(String) session.createSQLQuery("select d201_07 from d201_ms t " +
									"where t.d201_01='"+nowCode+"'").uniqueResult();
			code[1]=(String) session.createSQLQuery("select d201_07 from d201_ms t " +
									"where t.d201_01='"+permanentCode+"'").uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return code;
	}
}
