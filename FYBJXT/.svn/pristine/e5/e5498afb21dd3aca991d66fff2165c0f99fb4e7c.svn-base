package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD603;
import com.xyw.medical.birth.report.service.MybjkhService;

public class MybjkhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String institution = request.getParameter("institution");
		String institutionLabel = request.getParameter("institutionLabel");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		String institutionType = request.getParameter("institutionType");
		
		MybjkhService mybjkhService = new MybjkhService();
		String institutionName = mybjkhService.getInstitutionName(institution, institutionType, request.getSession().getServletContext());
		
		if("6".equals(institutionType))
		{
			institution = institution.substring(0, 6);
		}else if("4".equals(institutionType))
		{
			institution = institution.substring(0, 4);
		}else if("2".equals(institutionType))
		{
			institution = institution.substring(0, 2);
		}
		
		List<VD603> vd603s = mybjkhService.queryD603(institution, date_start, date_end, request.getSession().getServletContext());
		
		request.setAttribute("vd603s", vd603s);
		request.setAttribute("institutionLabel", institutionLabel);
		request.setAttribute("institutionName", institutionName);
		
		request.getRequestDispatcher("/report/csyxzmmybjkh.jsp").forward(request, response);
		
	}
		
}
