package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD304;
import com.xyw.medical.birth.report.service.CertificateFirstDJBService;

public class CertificateFirstDJBServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String d304_02 = request.getParameter("d30402");
		String d304_01 = request.getParameter("d30401");
		
		String d304_18 = request.getParameter("d30418");
		String d304_24 = request.getParameter("d30424");
		String institution = request.getParameter("institution");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		
		String fm= request.getParameter("fm");
		
		
		CertificateFirstDJBService certificateFirstDJBService = new CertificateFirstDJBService();
		
		List<VD304> vd304s = certificateFirstDJBService.queryListVD304(institution, date_start, date_end, request.getSession().getServletContext());
		
		if("0".equals(request.getParameter("flagF"))){
			VD304 vd304 = certificateFirstDJBService.queryD304(d304_01,d304_02,d304_18,d304_24,fm, request.getSession().getServletContext());
			request.setAttribute("vd304", vd304);
			request.getRequestDispatcher("/print/csyxzmFirstDJB.jsp").forward(request, response);
		}
		if("1".equals(request.getParameter("flagF"))){
			request.setAttribute("vd304s", vd304s);
			request.setAttribute("institution", institution);
			request.setAttribute("date_start", date_start);
			request.setAttribute("date_end", date_end);
			
			if("excel".equals(request.getParameter("flag"))) {
				response.setHeader("Content-disposition","inline; filename=certificate_firstDBJ.xls");
				request.getRequestDispatcher("/report/certificate_firstDBJExcel.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/report/certificate_firstDBJ.jsp").forward(request, response);
			}
		}
	}

}
