package com.xyw.medical.birth.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.csqxr.model.VD606;
import com.xyw.medical.birth.report.service.CsqxrService;
import com.xyw.medical.xzjgwh.dao.impl.GovernmentDaoImpl;
import com.xyw.medical.xzjgwh.model.D201;
import com.xyw.medical.xzjgwh.model.D201Request;
import com.xyw.medical.xzjgwh.model.D201Response;

public class CsqxrServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String d606_01 = request.getParameter("d60601");
		String d606_04 = request.getParameter("d60604");
		String d606_07 = request.getParameter("d60607");
		String d606_16 = request.getParameter("d60616");
		String d606_61 = request.getParameter("d60661");
		String d606_62 = request.getParameter("d60662");
		
		String cc =null;
		String sheng = null;
		String shi = null;
		String quXian=null;
		String areaName = null;
		CsqxrService csqxrService = new CsqxrService();
		
		if("1".equals(request.getParameter("flagF"))){
			VD606 vd606 = csqxrService.queryD606(d606_01,d606_04,d606_07,d606_16,d606_61,d606_62, request.getSession().getServletContext());
			String d60610 =vd606.getD60610();
			String[] aa =d60610.split(";");
			for(int i=0;i<aa.length;i++){
				cc =aa[i];
			}
			String d60618 =vd606.getD60618Str();
			String nian = d60618.substring(0,4);
			String yue = d60618.substring(5,7);
			String ri = d60618.substring(8,10);
			
//			String d10104 =vd606.getD10104();
//			if(areaName !=null){
//			if(areaName.indexOf("省") ==-1){
//			shi = areaName.substring(0,areaName.indexOf("市"));
//		}else{
//			sheng = areaName.substring(0, areaName.indexOf("省"));
//			shi = areaName.substring((areaName.indexOf("省")+1),areaName.indexOf("市"));
//		}
//		if(areaName.indexOf("区")!=-1){
//			quXian= areaName.substring((areaName.indexOf("市")+1),areaName.indexOf("区"));
//		}
//		if(areaName.indexOf("县")!=-1){
//			quXian= areaName.substring((areaName.indexOf("市")+1),areaName.indexOf("县"));
//		}	
//			}

			
			request.setAttribute("nian", nian);
			request.setAttribute("yue", yue);
			request.setAttribute("ri", ri);
//			request.setAttribute("sheng", sheng);
//			request.setAttribute("shi", shi);
//			request.setAttribute("quXian", quXian);
			request.setAttribute("d60610", cc);
			request.setAttribute("vd606", vd606);
			request.getRequestDispatcher("/print/csqxrExcel.jsp").forward(request, response);
		}
	}
}
