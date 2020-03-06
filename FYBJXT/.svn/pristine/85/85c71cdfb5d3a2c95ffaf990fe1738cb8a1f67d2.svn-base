package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.report.model.ReportTemp;
import com.xyw.medical.birth.report.service.CencusService;

public class CencusServlet extends HttpServlet {
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
		String areaCode = request.getParameter("areaCode");
		String institutionType = request.getParameter("institutionType");
		
		CencusService cencusService = new CencusService();
		List<ReportTemp> listReportTemp = cencusService.queryReportTemp(year, institution, institutionType, request.getSession().getServletContext());
		String institutionName = cencusService.getInstitutionName(institution, institutionType, request.getSession().getServletContext());
		
		request.setAttribute("listReportTemp", listReportTemp);
		request.setAttribute("year", year);
		request.setAttribute("institution", institution);
		request.setAttribute("areaCode", areaCode);
		request.setAttribute("institutionType", institutionType);
		request.setAttribute("institutionName", institutionName);
		
		if("excel".equals(request.getParameter("flag"))) {
			response.setHeader("Content-disposition","inline; filename=csyxzmfzdjb.xls");
			request.getRequestDispatcher("/report/cencusExcel.jsp").forward(request, response);
		}else
		{
			request.getRequestDispatcher("/report/cencus.jsp").forward(request, response);
		}
	}

	
}
