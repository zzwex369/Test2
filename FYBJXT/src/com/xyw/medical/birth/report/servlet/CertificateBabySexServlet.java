package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.report.model.ReportGenderTemp;
import com.xyw.medical.birth.report.service.CencusService;
import com.xyw.medical.birth.report.service.CertificateBabySexService;


//@WebServlet("/CertificateBabySexServlet")
public class CertificateBabySexServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String year = request.getParameter("year");
		String institution = request.getParameter("institution");
		String areaCode = request.getParameter("areaCode");
		String institutionType = request.getParameter("institutionType");
		
		CertificateBabySexService certificateBabySexService = new CertificateBabySexService();
		CencusService cencusService = new CencusService();
		List<ReportGenderTemp> listReportGenderTemp = certificateBabySexService.queryReportGenderTemp(year, institution, institutionType, request.getSession().getServletContext());
		String institutionName = cencusService.getInstitutionName(institution, institutionType, request.getSession().getServletContext());
		
		request.setAttribute("listReportGenderTemp", listReportGenderTemp);
		request.setAttribute("year", year);
		request.setAttribute("institution", institution);
		request.setAttribute("areaCode", areaCode);
		request.setAttribute("institutionType", institutionType);
		request.setAttribute("institutionName", institutionName);
		
		request.getRequestDispatcher("/report/certificateBabySex.jsp").forward(request, response);
	}

}
