package com.xyw.medical.fnbj.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.model.VF501;
import com.xyw.medical.fnbj.report.service.fnbjcssqService;

public class fnbjcssqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public fnbjcssqServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("f50101");
		
		fnbjcssqService fs = new fnbjcssqService();
		VF501 vf501 = fs.queryfnbj(id, request.getSession().getServletContext());
		String f50106_ =vf501.getF50106Str();
		String f50113_ =vf501.getF50113Str();
		if(f50113_!=null){
			String nian13 =f50113_.substring(0,4);
			String yue13 =f50113_.substring(5,7);
			String ri13 =f50113_.substring(8,10);
			request.setAttribute("nian13", nian13);
			request.setAttribute("yue13", yue13);
			request.setAttribute("ri13", ri13);
		}else{
			request.setAttribute("nian13", "");
			request.setAttribute("yue13", "");
			request.setAttribute("ri13", "");
		}
		String f50117_ =vf501.getF50117Str();
		String f50119_ =vf501.getF50119();
		String nian06 =f50106_.substring(0,4);
		String yue06 =f50106_.substring(5,7);
		String ri06 =f50106_.substring(8,10);
		
		String nian17 =f50117_.substring(0,4);
		String yue17 =f50117_.substring(5,7);
		String ri17 =f50117_.substring(8,10);
		
		String c[] =f50119_.split(",");
		request.setAttribute("c1", c[0]);
		request.setAttribute("c2", c[1]);
		request.setAttribute("c3", c[2]);
		request.setAttribute("c4", c[3]);
		request.setAttribute("c5", c[4]);
		request.setAttribute("c6", c[5]);
		request.setAttribute("c7", c[6]);
		request.setAttribute("c8", c[7]);
		
		request.setAttribute("vf501", vf501);
		request.setAttribute("nian06", nian06);
		request.setAttribute("yue06", yue06);
		request.setAttribute("ri06", ri06);
		
		request.setAttribute("nian17", nian17);
		request.setAttribute("yue17", yue17);
		request.setAttribute("ri17", ri17);
		request.getRequestDispatcher("/print_fb/fnbjcssq.jsp").forward(request,response);
	}
}
