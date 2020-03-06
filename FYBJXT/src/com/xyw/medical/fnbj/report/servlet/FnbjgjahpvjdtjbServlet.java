package com.xyw.medical.fnbj.report.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.report.service.FnbjgjahpvjdtjbService;

public class FnbjgjahpvjdtjbServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		String institution = request.getParameter("institution");
		FnbjgjahpvjdtjbService fnbjgjahpvjdtjbService=new FnbjgjahpvjdtjbService();
		List<Object> list=fnbjgjahpvjdtjbService.query(date_start,date_end,institution, request.getSession().getServletContext());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/report/fnbj/gjahpvjdtjb.jsp").forward(request, response);	
	}

}
