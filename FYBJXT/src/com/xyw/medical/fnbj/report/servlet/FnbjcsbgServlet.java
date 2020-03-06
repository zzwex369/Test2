package com.xyw.medical.fnbj.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.model.VF502;
import com.xyw.medical.fnbj.report.service.FnbjcsbgService;

@SuppressWarnings("all")
public class FnbjcsbgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VF502 vf502;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		long F50203 = Long.parseLong(request.getParameter("F50203"));
	
		String f50201 = request.getParameter("_f50201");
		FnbjcsbgService fnbjcsbgdaoimpl =new FnbjcsbgService();		
		vf502=fnbjcsbgdaoimpl.queryVF502(f50201, request.getSession().getServletContext());
		String f50216_ = vf502.getF50216();
		if(f50216_==null){
			f50216_="0,";
		}
		String f50216[]  = f50216_.split(",");
		if(f50216!=null){
			for(int i=0;i<f50216.length;i++){
				if(f50216[i].equals("1")) request.setAttribute("a1","1");
				if(f50216[i].equals("2")) request.setAttribute("a2","2");
				if(f50216[i].equals("3")) request.setAttribute("a3","3");
				if(f50216[i].equals("4")) request.setAttribute("a4","4");
				if(f50216[i].equals("5")) request.setAttribute("a5","5");	
			}
		}
		request.setAttribute("vf502", vf502);
		request.getRequestDispatcher("/print_fb/fnbjcsbg.jsp").forward(request, response);	
	}

}
