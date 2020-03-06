package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD601;
import com.xyw.medical.birth.model.VD601_DBF;
import com.xyw.medical.birth.report.service.DeliveryRegistService;
import com.xyw.sys.util.DBF;
public class DeliveryRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String institution = request.getParameter("institution");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		String institutionType = request.getParameter("institutionType");
		String institutionLabel = request.getParameter("institutionLabel");
		String flag = "none";
		/*
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
		*/
		DeliveryRegistService deliveryRegistService = new DeliveryRegistService();
		if (1<institutionType.length()) {
			String report_per = request.getParameter("report_per");
			String person_charge = request.getParameter("person_charge");
			String phone = request.getParameter("phone");
			String systemName = request.getParameter("systemName");
			List<Object> vd601s_dbf = deliveryRegistService.queryVD601(institution, date_start, date_end, flag,report_per,person_charge,phone,  request.getSession().getServletContext());
			if (vd601s_dbf==null) {
				request.getRequestDispatcher("/report/error.jsp").forward(request, response);
			}else {
				String message = DBF.createDBF(vd601s_dbf,institution+".dbf","/report/dbf/");//CSYXZM/build/classes
				if ("102".equals(message)) {
					request.getRequestDispatcher("/report/error.jsp").forward(request, response);
				}else {
					request.setAttribute("systemName", systemName);
					request.setAttribute("pathname", "report//dbf//"+institution+".dbf");
					request.getRequestDispatcher("/report/success.jsp").forward(request, response);
				}
			}
			
		}else {
			List<VD601> vd601s = deliveryRegistService.queryVD601(institution, date_start, date_end, flag,  request.getSession().getServletContext());
			request.setAttribute("vd601s", vd601s);
			request.setAttribute("date_start", date_start);
			request.setAttribute("date_end", date_end);
			request.setAttribute("institution", institution);
			request.setAttribute("institutionType", institutionType);
			request.setAttribute("institutionLabel", institutionLabel);
			if("excel".equals(request.getParameter("flag"))) {
				response.setContentType("application/msexcel;charset=UTF-8");
				response.setHeader("Content-disposition","inline; filename=deliverydj.xls");
				request.getRequestDispatcher("/report/deliverydjExcel.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/report/deliverydj.jsp").forward(request, response);
			}
		}
		
	}

}
