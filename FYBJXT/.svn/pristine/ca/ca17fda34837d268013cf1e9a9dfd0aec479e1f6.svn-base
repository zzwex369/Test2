package com.xyw.medical.fnbj.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.model.VL401;
import com.xyw.medical.fnbj.report.service.FnrxadaService;
public class FnrxadaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.doPost(request, response);
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		long l401_01 = Long.parseLong(request.getParameter("l40101"));	
		
		FnrxadaService fnrxadaService = new FnrxadaService(); 
		VL401 vl401 = fnrxadaService.queryL401(l401_01,request.getSession().getServletContext());
		request.setAttribute("vl401", vl401);
		request.getRequestDispatcher("/print_fb/fnrxada.jsp").forward(request, response);
	}
}
