package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD303;
import com.xyw.medical.birth.report.service.CertificateReplaceService;

public class CertificateReplaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String institution = request.getParameter("institution");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		String institutionType = request.getParameter("institutionType");
		
		if("6".equals(institutionType))
		{
			institution = institution.substring(0, 6);
			System.out.println(institution);
		}else if("4".equals(institutionType))
		{
			institution = institution.substring(0, 4);
		}else if("2".equals(institutionType))
		{
			institution = institution.substring(0, 2);
		}
		
		CertificateReplaceService certificateReplaceSevrice = new CertificateReplaceService();
		List<VD303> vd303s = certificateReplaceSevrice.queryVD303(institution, date_start, date_end, request.getSession().getServletContext());
		
		request.setAttribute("vd303s", vd303s);
		request.setAttribute("date_start", date_start);
		request.setAttribute("date_end", date_end);
		request.setAttribute("institution", institution);
		request.setAttribute("institutionType", institutionType);
		
		if("excel".equals(request.getParameter("flag"))) {
			response.setHeader("Content-disposition","inline; filename=csyxzmbfdjb.xls");
			request.getRequestDispatcher("/report/csyxzmbfdjbExcel.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/report/csyxzmbfdjb.jsp").forward(request, response);
		}
	}

}
