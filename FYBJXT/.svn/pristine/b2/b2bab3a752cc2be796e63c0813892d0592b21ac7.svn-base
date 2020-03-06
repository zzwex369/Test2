package com.xyw.medical.birth.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD605;
import com.xyw.medical.birth.report.service.ChildDeathReportFirstService;
public class ChildDeathReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String d605_01=request.getParameter("d60501");
		String institution = request.getParameter("institution");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		ChildDeathReportFirstService childDeathReportFirstService =new ChildDeathReportFirstService();
		if ("0".equals(request.getParameter("flagF"))) {
			VD605 vd605=childDeathReportFirstService.queryD605(d605_01,request.getSession().getServletContext());
			request.setAttribute("vd605",vd605);
			request.getRequestDispatcher("/print/childDeathReport.jsp").forward(request, response);
		}
	}
}
