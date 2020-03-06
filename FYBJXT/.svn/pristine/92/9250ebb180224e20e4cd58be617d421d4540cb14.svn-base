package com.xyw.medical.etbj.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.etbj.model.VE502;
import com.xyw.medical.etbj.report.service.EtbjtlscyytzdService;

public class EtbjtlscyytzdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		res.setContentType("text/plain;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		Long e50201 =Long.parseLong(req.getParameter("e50201")) ;
		try{
			EtbjtlscyytzdService EtbjtlscyytzdServlet = new EtbjtlscyytzdService();
			VE502 ve502 = EtbjtlscyytzdServlet.queryVE502(e50201, req.getSession().getServletContext());
			req.setAttribute("ve502", ve502);
			req.getRequestDispatcher("/print_eb/etbjtlscyytzd.jsp").forward(req, res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
