package com.xyw.medical.fnbj.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	//1.注册驱动
	static{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//2.建立连接
	public Connection getCon(){
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.111:1521:xyw", "fybjxt", "fybjxt");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@125.46.49.213:1521:orcl", "ny_csyxzm", "csyxzm_ny");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con; 
	}
	
	
	public int update(String sql,Object []	ob){
		if(con==null){
			con=this.getCon();
			//System.out.println("连接成功");
		}
		int k=0;
		try {
			ps=con.prepareStatement(sql);
			for(int i=0;i<ob.length;i++){
				ps.setObject(i+1, ob[i]);
			}
			k=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}
	
	
	public ResultSet query(String sql,Object[] ob){
		if(con==null){
			con=this.getCon();
			//System.out.println("连接成功");
		}
		
		try {
			ps=con.prepareStatement(sql);
			for(int i=0;i<ob.length;i++){
				ps.setObject(i+1, ob[i]);
			}
			rs= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public void close(){
		
		try {
			if(ps!=null){
				ps.close();
			}
			if(rs!=null){
				rs.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

