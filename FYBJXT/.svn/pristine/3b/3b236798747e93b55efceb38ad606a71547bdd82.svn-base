package com.xyw.medical.fnbj.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.model.VL301;
import com.xyw.medical.fnbj.report.service.FngjadaService;
public class FngjadaServlet extends HttpServlet{

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
		
		String l301_01 = request.getParameter("l30101");	
		
		FngjadaService fngjadaService = new FngjadaService(); 
		VL301 vl301 = fngjadaService.queryL301(l301_01,request.getSession().getServletContext());
		request.setAttribute("vl301", vl301);
		request.getRequestDispatcher("/print_fb/fngjada.jsp").forward(request, response);
	}
}
