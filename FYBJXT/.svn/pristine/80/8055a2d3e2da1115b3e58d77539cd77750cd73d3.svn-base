package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.report.service.CertificateFamilyService;

public class CertificateFamilyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String areaCode = request.getParameter("areaCode");
		String queryType = request.getParameter("queryType");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		String flag = request.getParameter("flag");
		
		CertificateFamilyService certificateFamilyService = new CertificateFamilyService();
		List<VD301> vd301s = certificateFamilyService.queryVd301(areaCode, queryType, date_start, date_end, request.getSession().getServletContext());
		
		request.setAttribute("vd301s", vd301s);
		request.setAttribute("date_start", date_start);
		request.setAttribute("date_end", date_end);
		request.setAttribute("areaCode", areaCode);
		request.setAttribute("queryType", queryType);
		
		if("baby".equals(flag))
		{
			request.getRequestDispatcher("/report/csyxzmBaby.jsp").forward(request, response);
		}else if("mother".equals(flag))
		{
			request.getRequestDispatcher("/report/csyxzmMother.jsp").forward(request, response);
		}else if("babyExcel".equals(flag))
		{
			response.setHeader("Content-disposition","inline; filename=csyxzmsBabyExcel.xls");
			request.getRequestDispatcher("/report/csyxzmBabyExcel.jsp").forward(request, response);
		}else if("motherExcel".equals(flag))
		{
			response.setHeader("Content-disposition","inline; filename=csyxzmMotherExcel.xls");
			request.getRequestDispatcher("/report/csyxzmMotherExcel.jsp").forward(request, response);
		}
	}
}
