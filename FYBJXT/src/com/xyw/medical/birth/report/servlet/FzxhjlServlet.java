package com.xyw.medical.birth.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.xyw.medical.birth.model.VD301;
//import com.xyw.medical.birth.model.VD502;
//import com.xyw.medical.birth.report.service.CertificateFirstSignService;
//import com.xyw.medical.birth.report.service.CertificateRegistService;

public class FzxhjlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String institution = request.getParameter("institution");
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
		
		request.setAttribute("vd301s", vd301s);*/
		
		request.getRequestDispatcher("/report/csyxzmfzxhjl.jsp").forward(request, response);
		
	}
		
}
