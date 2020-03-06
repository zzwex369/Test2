package com.xyw.sys.util;

public class SqlUtil {
	/**
	 * 
	 * @param suffixSql 查询语句
	 * @param pageSize  每页查询数量
	 * @param pageIdx   第几页
	 * @return 完整分页语句
	 */
	public static String Querybetch(String suffixSql,int pageSize,int pageIdx) {
		if(pageSize==0||pageIdx==0)
			return null;
		StringBuffer sql=new StringBuffer();
		sql.append("select * from(select rownum as rowno,r.*from(");
		sql.append(suffixSql);
		sql.append(")r where rownum <= "+pageSize*pageIdx+") table_alias");
		sql.append(" where table_alias.rowno > "+pageSize*(pageIdx-1));
		return sql.toString();
	}
}
