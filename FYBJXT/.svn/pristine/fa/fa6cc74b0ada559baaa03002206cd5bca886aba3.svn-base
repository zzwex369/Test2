package com.xyw.medical.birth.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD307;
import com.xyw.medical.birth.report.service.CsyxzmqfsqbService;

public class CsyxzmqfsqbServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String d307_01 = request.getParameter("d30701");
//		String d307_06 = request.getParameter("d30706");
//		String d307_08 = request.getParameter("d30708");
		
		CsyxzmqfsqbService csyxzmafsqbService = new CsyxzmqfsqbService();
		
		if("0".equals(request.getParameter("flagF"))){
			VD307 vd307 = csyxzmafsqbService.queryVD307(d307_01,request.getSession().getServletContext());
			
			String nian = null;
			String yue = null;
			String ri=null;
			String hourTime=null;
			String minuteTime=null;
			String d30704_= vd307.getD30704Str();
			if(d30704_ !=null){
				nian =d30704_.substring(0,4);
				yue =d30704_.substring(5,7);
				ri =d30704_.substring(8,10);
				hourTime = d30704_.substring(11,13);
				minuteTime = d30704_.substring(14,16);
			}
			
			String sheng = null;
			String shi = null;
			String quXian=null;
			String d30705Zh= vd307.getD30705Zh();
			if(d30705Zh !=null){
				if(d30705Zh.indexOf("省") ==-1){
					shi = d30705Zh.substring(0,d30705Zh.indexOf("市"));
				}else{
					sheng = d30705Zh.substring(0, d30705Zh.indexOf("省"));
					shi = d30705Zh.substring((d30705Zh.indexOf("省")+1),d30705Zh.indexOf("市"));
				}
				if(d30705Zh.indexOf("区")!=-1){
					quXian= d30705Zh.substring((d30705Zh.indexOf("市")+1),d30705Zh.indexOf("区"));
				}
				if(d30705Zh.indexOf("县")!=-1){
					quXian= d30705Zh.substring((d30705Zh.indexOf("市")+1),d30705Zh.indexOf("县"));
				}	
			}
			
			request.setAttribute("vd307", vd307);
			request.setAttribute("nian", nian);
			request.setAttribute("yue", yue);
			request.setAttribute("ri", ri);
			request.setAttribute("hourTime", hourTime);
			request.setAttribute("minuteTime", minuteTime);
			request.setAttribute("sheng", sheng);
			request.setAttribute("shi", shi);
			request.setAttribute("quXian", quXian);
			request.getRequestDispatcher("/report/csyxzmqfsq.jsp").forward(request, response);
		}
	}


}


