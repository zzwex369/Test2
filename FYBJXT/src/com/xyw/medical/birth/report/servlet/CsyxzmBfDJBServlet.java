package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.xyw.medical.birth.model.VD305;
import com.xyw.medical.birth.report.service.CsyxzmBfDJBService;


//@WebServlet("/CsyxzmBfDJBServlet")
public class CsyxzmBfDJBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CsyxzmBfDJBServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String d30502 = request.getParameter("d30502");//姓名
		String d30534 = request.getParameter("d30534");//新证号
		String institution = request.getParameter("institution");
		String institutionLabel = request.getParameter("institutionLabel");
		String institutionType = request.getParameter("institutionType");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		
		CsyxzmBfDJBService csyxzmBfDJBService = new CsyxzmBfDJBService();
		
		if("0".equals(request.getParameter("flagF"))){
			VD305 vd305 = csyxzmBfDJBService.queryVD305(d30502, d30534, request.getSession().getServletContext());
			Date d30504 = null;
			String d30518 = null;
			String d30524 = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if(vd305.getD30504() != null){
				try {
					d30504 = simpleDateFormat.parse(vd305.getD30504());
				} catch (ParseException e) {
					e.printStackTrace();
				}//婴儿出生日期
			}
			if(vd305.getD30518() != null){
				d30518 = vd305.getD30518();//母亲身份证号
				int motherAge = this.getAge(d30504, d30518);
				request.setAttribute("motherAge", motherAge);
			}
			if(vd305.getD30524() != null){
				d30524 = vd305.getD30524();//父亲身份证号
				int fatherAge = this.getAge(d30504, d30524);
				request.setAttribute("fatherAge", fatherAge);
			}
			
			request.setAttribute("vd305", vd305);
			
			request.getRequestDispatcher("/print/csyxzmbfdjbiao.jsp").forward(request, response);
		}
		if("1".equals(request.getParameter("flagF"))){
			
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
			List<VD305> vd305s = csyxzmBfDJBService.queryListVD305(institution, date_start, date_end, request.getSession().getServletContext());
			
			request.setAttribute("vd305s", vd305s);
			request.setAttribute("institution", institution);
			request.setAttribute("institutionLabel", institutionLabel);
			request.setAttribute("date_start", date_start);
			request.setAttribute("date_end", date_end);
			
			if("excel".equals(request.getParameter("flag"))) {
				response.setHeader("Content-disposition","inline; filename=certificate_ressiueDBJ.xls");
				request.getRequestDispatcher("/report/certificate_ressiueDBJExcel.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/report/certificate_ressiueDBJ.jsp").forward(request, response);
			}
		}
		
	}
	
	private int getAge(Date date, String str){
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		XMLGregorianCalendar xmlGregorianCalendar;
		int d30504Year = 0;
		try {
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			d30504Year = xmlGregorianCalendar.getYear();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		String strDate = str.substring(6, 10);
		int strYear = Integer.parseInt(strDate);
		
		int age = d30504Year - strYear;
		return age;
	}

}
