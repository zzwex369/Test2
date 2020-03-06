package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.model.VD602;
import com.xyw.medical.birth.report.service.CencusService;
import com.xyw.medical.birth.report.service.DeliveryRegistService;

//@WebServlet("/MotherBabySafeServiceCertificate")
public class MotherBabySafeServiceCertificate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MotherBabySafeServiceCertificate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String institution = request.getParameter("institution");
		String institutionType = request.getParameter("institutionType");
		String institutionLabel = request.getParameter("institutionLabel");
		
		CencusService cencusService = new CencusService();
		String institutionName = cencusService.getInstitutionName(institution, institutionType, request.getSession().getServletContext());
		
		if("6".equals(institutionType))
		{
			institution = institution.substring(0, 6);
			System.out.println(institution);
		}else if("4".equals(institutionType))
		{
			institution = institution.substring(0, 4);
		}else if("2".equals(institutionType))
		{
			institution = institution.substring(0, 2);
		}
		
		DeliveryRegistService deliveryRegistService = new DeliveryRegistService();
		List<VD602> vd602s = deliveryRegistService.queryVD602(institution, request.getSession().getServletContext());
		
		
		request.setAttribute("vd602s", vd602s);
		request.setAttribute("institution", institution);
		request.setAttribute("institutionType", institutionType);
		request.setAttribute("institutionLabel", institutionLabel);
		request.setAttribute("institutionName", institutionName);
		
		request.getRequestDispatcher("/report/csyxzmmybjjsfwzyxkz.jsp").forward(request, response);
	}

}
