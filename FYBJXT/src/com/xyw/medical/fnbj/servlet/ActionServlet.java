package com.xyw.medical.fnbj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.xyw.medical.fnbj.model.echarts.Data;
import com.xyw.medical.fnbj.model.echarts.EchartData;
import com.xyw.medical.fnbj.model.echarts.EchartData02;
import com.xyw.medical.fnbj.model.echarts.Series;
import com.xyw.medical.fnbj.model.echarts.Series02;
import com.xyw.medical.fnbj.servlet.entity.ZaoYun;
import com.xyw.medical.fnbj.servlet.util.DBUtil;

public class ActionServlet extends HttpServlet {
	/**
	 * 串行版本标识
	 */
	private static final long serialVersionUID = -4682217040239906082L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		
		if (action.equals("/echarts")) {//妊娠图************************//
//			String name = request.getParameter("name");// 传递的参数
			//System.out.println(name + "========1===========");
			List<String> legend = new ArrayList<String>(
					Arrays.asList(new String[] { "宫高上限", "实际宫高", "宫高下限" }));// 数据分组
			List<String> category = new ArrayList<String>(
					Arrays.asList(new String[] { "25周", "30周", "35周", "40周" }));// 横坐标
			List<Series> series = new ArrayList<Series>();// 纵坐标
			series.add(new Series("宫高上限", "line", new ArrayList<Integer>(Arrays
					.asList(26, 30, 36, 38))));
			series.add(new Series("实际宫高", "line", new ArrayList<Integer>(Arrays
					.asList(23, 27, 32, 34))));
			series.add(new Series("宫高下限", "line", new ArrayList<Integer>(Arrays
					.asList(20, 24, 28, 30))));

			EchartData data = new EchartData(legend, category, series);
			String jsonString = JSON.toJSONString(data);
			// System.out.println(jsonString);
			out.println(jsonString);
		
		} else if (action.equals("/echarts_pie")) {//早孕建册率************************//
			System.out.println("/echarts_pie:==========早孕建册率==========");
			ResultSet rs = null;
			ZaoYun zaoYun = null;
			String institution = request.getParameter("institution")+"%";// 传递的参数
			String date_start = request.getParameter("date_start");// 传递的参数
			String date_end = request.getParameter("date_end");// 传递的参数
//			System.out.println(institution + "========2===========");
//			System.out.println(date_start + "========3===========");
//			System.out.println(date_end + "========4===========");
			zaoYun = new ZaoYun();
			String sql = "select aaa , bbb from (select count(*) aaa from f301 t where t.f301_32 like ? and to_char(t.f301_31,'yyyy-mm-dd')>=? and to_char(t.f301_31,'yyyy-mm-dd')<=? ),(select count(*) bbb from d601 t where t.d601_02 like ? and to_char(t.d601_03,'yyyy-mm-dd')>=? and to_char(t.d601_03,'yyyy-mm-dd')<=?)";
			Object[] ob = {institution,date_start,date_end,institution,date_start,date_end};
			
			DBUtil db = new DBUtil();
			rs = db.query(sql, ob);
			try {
				if(rs.next()){
					int aaa = Integer.parseInt(rs.getString(1));
					int bbb = Integer.parseInt(rs.getString(2));
					zaoYun.setNum1(aaa);
					zaoYun.setNum2(bbb);
//					System.out.println(" 分子== " + aaa + " <--->");
					 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.close();
			//ZaoYun zaoYun = new ZaoYun(80,400);
			int num1 = (int) zaoYun.getNum1();
			int num2 = (int) zaoYun.getNum2();
			Integer temp = num2 - num1;
			List<String> legend = new ArrayList<String>(
					Arrays.asList(new String[] { "建册人数", "未建册人数" }));// 数据分组
			List<Series02> series02 = new ArrayList<Series02>();// 纵坐标
			series02.add(new Series02("统计", "pie", "55%", new String[] { "50%","60%" },
					new Data[] { new Data(num1, "建册人数"),	new Data(temp, "未建册人数") }));

			EchartData02 data = new EchartData02(legend, series02);
			String jsonString = JSON.toJSONString(data);
			//System.out.println(jsonString);//..............
			out.println(jsonString);
			
		} else if (action.equals("/fnpie02_jkgl")) {//孕妇健康管理率********************//
			System.out.println("/fnpie02_jkgl:==========孕妇健康管理率==========");
			ResultSet rs = null;
			ZaoYun zaoYun = null;
			String institution = request.getParameter("institution")+"%";// 传递的参数
			String date_start = request.getParameter("date_start");// 传递的参数
			String date_end = request.getParameter("date_end");// 传递的参数
//			System.out.println(institution + "========2===========");
//			System.out.println(date_start + "========3===========");
//			System.out.println(date_end + "========4===========");
			zaoYun = new ZaoYun();
			String sql = "select aaa , bbb from (select count(*) aaa from (select count(*) from f305 t where t.f305_08 like ? and to_char(t.f305_03,'yyyy-mm-dd')>=? and to_char(t.f305_03,'yyyy-mm-dd')<=? group by t.f305_02)),(select count(*) bbb from d601 t where t.d601_02 like ? and to_char(t.d601_03,'yyyy-mm-dd')>=? and to_char(t.d601_03,'yyyy-mm-dd')<=?)";
			Object[] ob = {institution,date_start,date_end,institution,date_start,date_end};
			
			DBUtil db = new DBUtil();
			rs = db.query(sql, ob);
			try {
				if(rs.next()){
					int aaa = Integer.parseInt(rs.getString(1));
					int bbb = Integer.parseInt(rs.getString(2));
					zaoYun.setNum1(aaa);
					zaoYun.setNum2(bbb);
//					System.out.println(" 分子== " + aaa + " <--->");
					 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.close();
			//ZaoYun zaoYun = new ZaoYun(80,400);
			int num1 = (int) zaoYun.getNum1();
			int num2 = (int) zaoYun.getNum2();
			Integer temp = num2 - num1;
			List<String> legend = new ArrayList<String>(
					Arrays.asList(new String[] { "接受5次及以上随访人数", "不足5次或未接受随访人数" }));// 数据分组
			List<Series02> series02 = new ArrayList<Series02>();// 纵坐标
			series02.add(new Series02("统计", "pie", "55%", new String[] { "50%","60%" },
					new Data[] { new Data(num1, "接受5次及以上随访人数"),	new Data(temp, "不足5次或未接受随访人数") }));

			EchartData02 data = new EchartData02(legend, series02);
			String jsonString = JSON.toJSONString(data);
			//System.out.println(jsonString);//..............
			out.println(jsonString);
			
		} else if (action.equals("/fnpie03_chfs")) {//产后访视率************************//
			System.out.println("/fnpie03_chfs:==========产后访视率==========");
			ResultSet rs = null;
			ZaoYun zaoYun = null;
			String institution = request.getParameter("institution")+"%";// 传递的参数
			String date_start = request.getParameter("date_start");// 传递的参数
			String date_end = request.getParameter("date_end");// 传递的参数
//			System.out.println(institution + "========2===========");
//			System.out.println(date_start + "========3===========");
//			System.out.println(date_end + "========4===========");
			zaoYun = new ZaoYun();
			String sql = "select aaa , bbb from (select count(*) aaa from f307 t where t.f307_37 like ? and to_char(t.f307_03,'yyyy-mm-dd')>=? and to_char(t.f307_03,'yyyy-mm-dd')<=? ),(select count(*) bbb from d601 t where t.d601_02 like ? and to_char(t.d601_03,'yyyy-mm-dd')>=? and to_char(t.d601_03,'yyyy-mm-dd')<=?)";
			Object[] ob = {institution,date_start,date_end,institution,date_start,date_end};
			
			DBUtil db = new DBUtil();
			rs = db.query(sql, ob);
			try {
				if(rs.next()){
					int aaa = Integer.parseInt(rs.getString(1));
					int bbb = Integer.parseInt(rs.getString(2));
					zaoYun.setNum1(aaa);
					zaoYun.setNum2(bbb);
//					System.out.println(" 分子== " + aaa + " <--->");
					 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.close();
			//ZaoYun zaoYun = new ZaoYun(80,400);
			int num1 = (int) zaoYun.getNum1();
			int num2 = (int) zaoYun.getNum2();
			Integer temp = num2 - num1;
			List<String> legend = new ArrayList<String>(
					Arrays.asList(new String[] { "接受过产后访视的人数", "未接受过产后访视人数" }));// 数据分组
			List<Series02> series02 = new ArrayList<Series02>();// 纵坐标
			series02.add(new Series02("统计", "pie", "55%", new String[] { "50%","60%" },
					new Data[] { new Data(num1, "接受过产后访视的人数"),	new Data(temp, "未接受过产后访视人数") }));

			EchartData02 data = new EchartData02(legend, series02);
			String jsonString = JSON.toJSONString(data);
			//System.out.println(jsonString);//..............
			out.println(jsonString);
			
		} else if (action.equals("/etpie01_xsefs")) {//新生儿访视率*********************//
			System.out.println("/etpie01_xsefs:==========新生儿访视率==========");
			ResultSet rs = null;
			ZaoYun zaoYun = null;
			String institution = request.getParameter("institution")+"%";// 传递的参数
			String date_start = request.getParameter("date_start");// 传递的参数
			String date_end = request.getParameter("date_end");// 传递的参数
//			System.out.println(institution + "========2===========");
//			System.out.println(date_start + "========3===========");
//			System.out.println(date_end + "========4===========");
			zaoYun = new ZaoYun();
			String sql = "select aaa , bbb from (select count(*) aaa from e305 t where t.e305_17 like ? and to_char(t.e305_74,'yyyy-mm-dd')>=? and to_char(t.e305_74,'yyyy-mm-dd')<=?),(select count(*) bbb from d601 t where t.d601_02 like ? and to_char(t.d601_03,'yyyy-mm-dd')>=? and to_char(t.d601_03,'yyyy-mm-dd')<=?)";
			Object[] ob = {institution,date_start,date_end,institution,date_start,date_end};
			
			DBUtil db = new DBUtil();
			rs = db.query(sql, ob);
			try {
				if(rs.next()){
					int aaa = Integer.parseInt(rs.getString(1));
					int bbb = Integer.parseInt(rs.getString(2));
					zaoYun.setNum1(aaa);
					zaoYun.setNum2(bbb);
//					System.out.println(" 分子== " + aaa + " <--->");
					 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.close();
			//ZaoYun zaoYun = new ZaoYun(80,400);
			int num1 = (int) zaoYun.getNum1();
			int num2 = (int) zaoYun.getNum2();
			Integer temp = num2 - num1;
			List<String> legend = new ArrayList<String>(
					Arrays.asList(new String[] { "接受过访视的新生儿数", "未接受过访视的新生儿数" }));// 数据分组
			List<Series02> series02 = new ArrayList<Series02>();// 纵坐标
			series02.add(new Series02("统计", "pie", "55%", new String[] { "50%","60%" },
					new Data[] { new Data(num1, "接受过访视的新生儿数"),	new Data(temp, "未接受过访视的新生儿数") }));

			EchartData02 data = new EchartData02(legend, series02);
			String jsonString = JSON.toJSONString(data);
			//System.out.println(jsonString);//..............
			out.println(jsonString);
			
		} else if (action.equals("/etpie02_jkgl")) {//儿童健康管理率********************//
			System.out.println("/etpie02_jkgl:==========儿童健康管理率==========");
			ResultSet rs = null;
			ZaoYun zaoYun = null;
			String institution = request.getParameter("institution")+"%";// 传递的参数
			String date_start = request.getParameter("date_start");// 传递的参数
			String date_end = request.getParameter("date_end");// 传递的参数
//			System.out.println(institution + "========2===========");
//			System.out.println(date_start + "========3===========");
//			System.out.println(date_end + "========4===========");
			zaoYun = new ZaoYun();
			String sql = "select aaa , bbb from (select count(*) aaa from e305 t where t.e305_17 like ? and to_char(t.e305_74,'yyyy-mm-dd')>=? and to_char(t.e305_74,'yyyy-mm-dd')<=?),(select count(*) bbb from d601 t where t.d601_02 like ? and to_char(t.d601_03,'yyyy-mm-dd')>=? and to_char(t.d601_03,'yyyy-mm-dd')<=?)";
			Object[] ob = {institution,date_start,date_end,institution,date_start,date_end};
			
			DBUtil db = new DBUtil();
			rs = db.query(sql, ob);
			try {
				if(rs.next()){
					int aaa = Integer.parseInt(rs.getString(1));
					int bbb = Integer.parseInt(rs.getString(2));
					zaoYun.setNum1(aaa);
					zaoYun.setNum2(bbb);
//					System.out.println(" 分子== " + aaa + " <--->");
					 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.close();
			//ZaoYun zaoYun = new ZaoYun(80,400);
			int num1 = (int) zaoYun.getNum1();
			int num2 = (int) zaoYun.getNum2();
			Integer temp = num2 - num1;
			List<String> legend = new ArrayList<String>(
					Arrays.asList(new String[] { "接受过访视的儿童数", "未接受过访视的儿童数" }));// 数据分组
			List<Series02> series02 = new ArrayList<Series02>();// 纵坐标
			series02.add(new Series02("统计", "pie", "55%", new String[] { "50%","60%" },
					new Data[] { new Data(num1, "接受过访视的儿童数"),	new Data(temp, "未接受过访视的儿童数") }));

			EchartData02 data = new EchartData02(legend, series02);
			String jsonString = JSON.toJSONString(data);
			//System.out.println(jsonString);//..............
			out.println(jsonString);
			
		}else if (action.equals("/etpie03_xtgl")) {//儿童系统管理率*********************//
			System.out.println("/etpie03_xtgl:==========儿童系统管理率==========");
			ResultSet rs = null;
			ZaoYun zaoYun = null;
			String institution = request.getParameter("institution")+"%";// 传递的参数
			String date_start = request.getParameter("date_start");// 传递的参数
			String date_end = request.getParameter("date_end");// 传递的参数
//			System.out.println(institution + "========2===========");
//			System.out.println(date_start + "========3===========");
//			System.out.println(date_end + "========4===========");
			zaoYun = new ZaoYun();
			String sql = "select aaa , bbb from (select count(*) aaa from e301 t where t.e301_16 like ? and to_char(t.e301_14,'yyyy-mm-dd')>=? and to_char(t.e301_14,'yyyy-mm-dd')<=? ),(select count(*) bbb from d601 t where t.d601_02 like ? and to_char(t.d601_03,'yyyy-mm-dd')>=? and to_char(t.d601_03,'yyyy-mm-dd')<=?)";
			Object[] ob = {institution,date_start,date_end,institution,date_start,date_end};
			
			DBUtil db = new DBUtil();
			rs = db.query(sql, ob);
			try {
				if(rs.next()){
					int aaa = Integer.parseInt(rs.getString(1));
					int bbb = Integer.parseInt(rs.getString(2));
					zaoYun.setNum1(aaa);
					zaoYun.setNum2(bbb);
//					System.out.println(" 分子== " + aaa + " <--->");
					 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.close();
			//ZaoYun zaoYun = new ZaoYun(80,400);
			int num1 = (int) zaoYun.getNum1();
			int num2 = (int) zaoYun.getNum2();
			Integer temp = num2 - num1;
			List<String> legend = new ArrayList<String>(
					Arrays.asList(new String[] { "按要求接受过管理的儿童数", "按要求未接受过管理的儿童数" }));// 数据分组
			List<Series02> series02 = new ArrayList<Series02>();// 纵坐标
			series02.add(new Series02("统计", "pie", "55%", new String[] { "50%","60%" },
					new Data[] { new Data(num1, "按要求接受过管理的儿童数"),	new Data(temp, "按要求未接受过管理的儿童数") }));

			EchartData02 data = new EchartData02(legend, series02);
			String jsonString = JSON.toJSONString(data);
			//System.out.println(jsonString);//..............
			out.println(jsonString);
		}
		out.close();
	}
}
