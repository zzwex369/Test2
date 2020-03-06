package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.report.model.BirthTemp;
import com.xyw.medical.birth.report.service.CertificateBabyBirthService2;


//@WebServlet("/CertificateBabyBirthServlet2")
public class CertificateBabyBirthServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CertificateBabyBirthServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		String areaCode = request.getParameter("areaCode");
		
		CertificateBabyBirthService2 certificateBabyBirthService2 = new CertificateBabyBirthService2();
		List<BirthTemp> birthTemps = certificateBabyBirthService2.queryReportGenderTemp(date_start, date_end, areaCode, request.getSession().getServletContext());
		
		request.setAttribute("birthTemps", birthTemps);
		request.setAttribute("areaCode", areaCode);
		
		request.getRequestDispatcher("/report/certificateBabyBirth2.jsp").forward(request, response);
	}

}
