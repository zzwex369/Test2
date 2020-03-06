package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.report.service.YcfswService;
import com.xyw.medical.ycfsw.model.VD604;

public class YcfswServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String d604_04 = request.getParameter("d60404");
		String d604_01 = request.getParameter("d60401");
		
		String d604_06 = request.getParameter("d60406");
		String institution = request.getParameter("institution");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		
		
		YcfswService ycfswService = new YcfswService();
		
		List<VD604> vd604s = ycfswService.queryListVD604(institution, date_start, date_end, request.getSession().getServletContext());
		
		if("0".equals(request.getParameter("flagF"))){
			VD604 vd604 = ycfswService.queryD604(d604_01,d604_04,d604_06, request.getSession().getServletContext());
			request.setAttribute("vd604", vd604);
			request.getRequestDispatcher("/print/ycfsw.jsp").forward(request, response);
		}
		if("1".equals(request.getParameter("flagF"))){
			request.setAttribute("vd604s", vd604s);
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
