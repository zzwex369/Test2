package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.report.service.CertificateFirstSignService;

public class CertificateFirstSignServlet extends HttpServlet {
	
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
		String d301_42 = request.getParameter("d30142");
		
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
		
		CertificateFirstSignService certificateFirstSignService = new CertificateFirstSignService();
		List<VD301> vd301s = certificateFirstSignService.queryD301(institution, date_start, date_end, request.getSession().getServletContext() , d301_42);
		
		request.setAttribute("vd301s", vd301s);
		request.setAttribute("date_start", date_start);
		request.setAttribute("date_end", date_end);
		request.setAttribute("institution", institution);
		request.setAttribute("institutionType", institutionType);
		request.setAttribute("institutionLabel", institutionLabel);
		request.setAttribute("d30142", d301_42);
		
		if("0".equals(d301_42)){
			if("excel".equals(request.getParameter("flag"))) {
				response.setHeader("Content-disposition","inline; filename=csyxzmscqfdjb.xls");
				request.getRequestDispatcher("/report/csyxzmscqfdjbExcel.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/report/csyxzmscqfdjb.jsp").forward(request, response);
			}
		} else if("1".equals(d301_42)){
			if("excel".equals(request.getParameter("flag"))) {
				response.setHeader("Content-disposition","inline; filename=csyxzmhfdjb.xls");
				request.getRequestDispatcher("/report/csyxzmhfdjbExcel.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/report/csyxzmhfdjb.jsp").forward(request, response);
			}
		} else if("2".equals(d301_42)){
			if("excel".equals(request.getParameter("flag"))) {
				response.setHeader("Content-disposition","inline; filename=csyxzmbfdjb.xls");
				request.getRequestDispatcher("/report/csyxzmbfdjbExcel.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/report/csyxzmbfdjb.jsp").forward(request, response);
			}
		}
		
	}
		
}
