package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.report.model.DeliveryTemp;
import com.xyw.medical.birth.report.service.PerinatalService;
import com.xyw.sys.util.StringUtil;

public class PerinatalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String year = request.getParameter("year");
		String quarter = request.getParameter("quarter");
		String monthStart = request.getParameter("monthStart");
		String monthEnd = request.getParameter("monthEnd");
		String institution = request.getParameter("institution");
		String institutionType = request.getParameter("institutionType");

		String flag = request.getParameter("flag");
		String timeStr = request.getParameter("timeStr");

		PerinatalService perinatalService = new PerinatalService();
		List<DeliveryTemp> listDeliveryTemp = perinatalService.queryDeliveryTemp(timeStr,flag, year, quarter, monthStart, monthEnd,institutionType, institution, request.getSession().getServletContext());
		String institutionName = perinatalService.getInstitutionName(institution, institutionType, request.getSession().getServletContext());

		DeliveryTemp deliveryTemp =perinatalService.total(listDeliveryTemp);
		String sheng = null;
		String shi = null;
		String quXian = null;
		String d30705Zh = perinatalService.getAreaName(institution, request.getSession().getServletContext());
		if (d30705Zh != null) {
			if (d30705Zh.indexOf("省") == -1) {
				shi = d30705Zh.substring(0, d30705Zh.indexOf("市"));
			} else {
				sheng = d30705Zh.substring(0, d30705Zh.indexOf("省"));
				shi = d30705Zh.substring((d30705Zh.indexOf("省") + 1),d30705Zh.indexOf("市"));
			}
			if (d30705Zh.indexOf("区") != -1) {
				quXian = d30705Zh.substring((d30705Zh.indexOf("市") + 1),d30705Zh.indexOf("区"));
			}
			if (d30705Zh.indexOf("县") != -1) {
				quXian = d30705Zh.substring((d30705Zh.indexOf("市") + 1),d30705Zh.indexOf("县"));
			}
		}
		String tj="";
		if(monthStart !=null){
			if(StringUtil.parseInt(monthStart) ==StringUtil.parseInt(monthEnd)){
				tj=monthStart;
			}else if(StringUtil.parseInt(monthStart) < StringUtil.parseInt(monthEnd)){	
				tj=monthStart+" - "+monthEnd;
			}
		}
		request.setAttribute("tj", tj);
		request.setAttribute("sheng", sheng);
		request.setAttribute("shi", shi);
		request.setAttribute("quXian", quXian);
		request.setAttribute("listDeliveryTemp", listDeliveryTemp);
		request.setAttribute("deliveryTemp", deliveryTemp);
		request.setAttribute("year", year);
		request.setAttribute("quarter", quarter);
		request.setAttribute("institution", institution);
		request.setAttribute("institutionType", institutionType);
		request.setAttribute("institutionName", institutionName);
		
		if(flag.equals("wcjg")) { 
			response.setHeader("Content-disposition","inline; filename=csyxzmfzdjb.xls"); 
			request.getRequestDispatcher("/report/csyxzmwcjb.jsp").forward(request, response);
		}else if(flag.equals("wcq")) {
			request.getRequestDispatcher("/report/csyxzmwcjbq.jsp").forward(request, response);
		}else if(flag.equals("wcjs")) {
			request.getRequestDispatcher("/report/deliveryjs.jsp").forward(request, response);
		}else if(flag.equals("hcyc")) {
			request.getRequestDispatcher("/report/deliveryhcyc.jsp").forward(request, response);
		}else if(flag.equals("fmtj")) {
			request.getRequestDispatcher("/report/deliverytj.jsp").forward(request, response);
		}
	}
	


}
