package com.xyw.medical.fnbj.report.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.report.service.FnbjrxajcxmjdtjbService;

public class FnbjrxajcxmjdtjbServlet extends HttpServlet {

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
		FnbjrxajcxmjdtjbService fnbjrxajcxmjdtjbService=new FnbjrxajcxmjdtjbService();
		List<Object> list=fnbjrxajcxmjdtjbService.query(date_start,date_end,institution, request.getSession().getServletContext());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/report/fnbj/rxajcxmjdtjb.jsp").forward(request, response);	
	}
}
