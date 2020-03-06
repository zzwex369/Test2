package com.xyw.medical.birth.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD306;
import com.xyw.medical.birth.report.service.CsyxzmhfsqbService;

public class CsyxzmhfsqbServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String d306_01 = request.getParameter("d30601");
		String d306_03 = request.getParameter("d30603");
		
		CsyxzmhfsqbService csyxzmhfsqbService = new CsyxzmhfsqbService();
		
		if("0".equals(request.getParameter("flagF"))){
			VD306 vd306 = csyxzmhfsqbService.queryVD306(d306_01,d306_03,request.getSession().getServletContext());
			String d30623 =vd306.getD30623Str();
			String nian =d30623.substring(0,4);
			String yue =d30623.substring(5,7);
			String ri =d30623.substring(8,10);
			request.setAttribute("vd306", vd306);
			request.setAttribute("nian", nian);
			request.setAttribute("yue", yue);
			request.setAttribute("ri", ri);
			request.getRequestDispatcher("/report/csyxzmhfsq.jsp").forward(request, response);
		}
	}

}


