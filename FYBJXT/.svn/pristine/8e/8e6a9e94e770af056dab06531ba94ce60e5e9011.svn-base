package com.xyw.sys.util;

import java.util.Date;

import org.hibernate.Session;

import com.xyw.sys.model.D403;
/**
 * 
 * @author Administrator
 * 异常收集
 */
public class ExceptionCollection {
	/**
	 *  将异常保存至数据库
	 * @param e  异常
	 * @param code 保存单位
	 * @param table 保存表名称
	 * @param id_sql sql或者主键
	 * @param session   
	 */
	public static void saveD403(Exception e, String code, String table,String id_sql,Session session) {
		StackTraceElement[] stack =e.getStackTrace();
		D403 d403=new D403();
		d403.setD40302(new Date());
		d403.setD40303("Class: "+stack[1].getClassName()+" method: "+
					stack[1].getMethodName() +" line: 【"+
					stack[1].getLineNumber()+"】发生的异常是: " + e.toString());
		d403.setD40304(code);
		d403.setD40305(table);
		d403.setD40306(id_sql);
		session.save(d403);
		session.flush();
	}
}
