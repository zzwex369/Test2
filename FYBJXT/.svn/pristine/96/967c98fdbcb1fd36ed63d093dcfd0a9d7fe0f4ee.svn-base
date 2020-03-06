package com.xyw.medical.fnbj.report.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.model.VL302;
import com.xyw.medical.fnbj.report.service.FnbjgjadjbService;

public class FnbjgjadjbServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8207443629688770116L;

	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String l30201 = request.getParameter("l30201");
		FnbjgjadjbService fnbjgjadjbService=new FnbjgjadjbService();
		VL302 vl302=fnbjgjadjbService.queryVl302ById(l30201, request.getSession().getServletContext());
		request.setAttribute("vl302", vl302);
		request.getRequestDispatcher("/print_fb/fnbjgjajc.jsp").forward(request, response);	
	}
}
