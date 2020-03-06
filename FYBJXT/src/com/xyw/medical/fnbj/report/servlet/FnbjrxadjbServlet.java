package com.xyw.medical.fnbj.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.model.VL402;
import com.xyw.medical.fnbj.report.service.FnbjrxadjbService;

public class FnbjrxadjbServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2204428560018863984L;
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String l40201 = request.getParameter("l40201");
		FnbjrxadjbService fnbjrxadjbService=new FnbjrxadjbService();
		VL402 vl402=fnbjrxadjbService.queryVl402ById(l40201, request.getSession().getServletContext());
		request.setAttribute("vl402", vl402);
		request.getRequestDispatcher("/print_fb/fnbjrxajc.jsp").forward(request, response);	
	}

}
