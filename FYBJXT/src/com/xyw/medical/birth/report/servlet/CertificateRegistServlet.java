package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD502;
import com.xyw.medical.birth.report.service.CertificateRegistService;

public class CertificateRegistServlet extends HttpServlet {
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
		
//		if("6".equals(institutionType))
//		{
//			institution = institution.substring(0, 6);
//			System.out.println(institution);
//		}else if("4".equals(institutionType))
//		{
//			institution = institution.substring(0, 4);
//		}else if("2".equals(institutionType))
//		{
//			institution = institution.substring(0, 2);
//		}
		
		CertificateRegistService certificateRegistService = new CertificateRegistService();
		List<VD502> vd502s = certificateRegistService.queryD502(institution, date_start,date_end, request.getSession().getServletContext());
		
		request.setAttribute("vd502s", vd502s);
		request.setAttribute("date_start", date_start);
		request.setAttribute("date_end", date_end);
		request.setAttribute("institution", institution);
		request.setAttribute("institutionLabel", institutionLabel);
		request.setAttribute("institutionType", institutionType);
		
		if("excel".equals(request.getParameter("flag"))) {
			response.setHeader("Content-disposition","inline; filename=csyxzmrkdjb.xls");
			request.getRequestDispatcher("/report/csyxzmrkdjbExcel.jsp").forward(request, response);
		} else{
			request.getRequestDispatcher("/report/csyxzmrkdjb.jsp").forward(request, response);
		}
		
	}

}
