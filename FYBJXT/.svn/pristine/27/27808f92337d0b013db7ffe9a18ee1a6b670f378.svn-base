package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.report.model.BirthCertificateCount;
import com.xyw.medical.birth.report.model.ReportTemp;
import com.xyw.medical.birth.report.service.CsyxzmglsyqkndtjbService;

public class CsyxzmglsyqkndtjbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String year = request.getParameter("year");
		String institution = request.getParameter("institution");
//		String areaCode = request.getParameter("areaCode");
		String institutionType = request.getParameter("institutionType");
		
		CsyxzmglsyqkndtjbService csyxzmglsyqkndtjbService = new CsyxzmglsyqkndtjbService();
		List<BirthCertificateCount> listBirthCertificateCount = csyxzmglsyqkndtjbService.queryBirthCertificateCount(year, institution, institutionType, request.getSession().getServletContext());
		String institutionName = csyxzmglsyqkndtjbService.getInstitutionName(institution, institutionType, request.getSession().getServletContext());
		
		request.setAttribute("listBirthCertificateCount", listBirthCertificateCount);
		request.setAttribute("year", year);
		request.setAttribute("institution", institution);
//		request.setAttribute("areaCode", areaCode);
		request.setAttribute("institutionType", institutionType);
		request.setAttribute("institutionName", institutionName);
		
		request.getRequestDispatcher("/report/csyxzmglsyqkndtjb.jsp").forward(request, response);
	}

	
}
