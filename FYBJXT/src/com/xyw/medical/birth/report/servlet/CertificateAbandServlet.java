package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xyw.medical.birth.model.VD401;
import com.xyw.medical.birth.report.service.CertificateAbandService;

public class CertificateAbandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String institution = request.getParameter("institution");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		String institutionType = request.getParameter("institutionType");
		String institutionLabel = request.getParameter("institutionLabel");
		
		String flag = "none";
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
		
		
		CertificateAbandService certificateAbandService = new CertificateAbandService();
		List<VD401> vd401s = certificateAbandService.queryVD401(institution, date_start, date_end, flag, request.getSession().getServletContext());
		request.setAttribute("vd401s", vd401s);
		request.setAttribute("date_start", date_start);
		request.setAttribute("date_end", date_end);
		request.setAttribute("institution", institution);
		request.setAttribute("institutionType", institutionType);
		request.setAttribute("institutionLabel", institutionLabel);
		
		if("excel".equals(request.getParameter("flag"))) {
			response.setHeader("Content-disposition","inline; filename=csyxzmfzdjb.xls");
			request.getRequestDispatcher("/report/csyxzmfzdjbExcel.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/report/csyxzmfzdjb.jsp").forward(request, response);
		}
	}

}
