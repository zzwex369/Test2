package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.report.model.ReportGenderTemp;
import com.xyw.medical.birth.report.service.CertificateBabyBirthService;

//@WebServlet("/CertificateBabyBirthServlet")
public class CertificateBabyBirthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CertificateBabyBirthServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
//		String year = request.getParameter("year");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		String areaCode = request.getParameter("areaCode");
		String institution = request.getParameter("institution");
		String institutionType = request.getParameter("institutionType");
		
		CertificateBabyBirthService certificateBabyBirthService = new CertificateBabyBirthService();
		List<ReportGenderTemp> listReportGenderTemp = certificateBabyBirthService.queryReportGenderTemp(date_start, date_end, institution, institutionType, request.getSession().getServletContext());
		
		request.setAttribute("listReportGenderTemp", listReportGenderTemp);
		request.setAttribute("institution", institution);
		request.setAttribute("areaCode", areaCode);
		
		request.getRequestDispatcher("/report/certificateBabyBirth.jsp").forward(request, response);
	}

}
