package com.xyw.medical.etbj.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.etbj.model.VE501;
import com.xyw.medical.etbj.report.service.EttlscbgdService;


public class EttlscbgdServlet extends HttpServlet {
	/**
	 * @author dwh
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		response.setCharacterEncoding("UTF-8");
		long e501_01 = Long.parseLong(request.getParameter("e50101")) ;
		EttlscbgdService ed = new EttlscbgdService();
		try{
			VE501 ve501 = ed.ve501query(e501_01, request.getSession().getServletContext());
			request.setAttribute("ve501", ve501);
			request.getRequestDispatcher("/print_eb/etbjtlscbgd.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
