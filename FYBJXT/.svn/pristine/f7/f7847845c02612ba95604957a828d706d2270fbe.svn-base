package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.birth.report.model.Fmqktj;
import com.xyw.medical.birth.report.service.FmqktjService;

public class FmqktjServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String date_start = req.getParameter("date_start");
		String date_end = req.getParameter("date_end");
		String areaCode = req.getParameter("areaCode");
		String sexFlag = req.getParameter("sexFlag");
		String areaFlag = req.getParameter("areaFlag");
		String timeFlag = req.getParameter("timeFlag");
		String institution = req.getParameter("institution");
		String jiwei = req.getParameter("jiwei");
		
		FmqktjService fmqktjService = new FmqktjService();
		List<Fmqktj> fmqktjs = fmqktjService.queryfmqktj(date_start, date_end, areaCode, sexFlag, areaFlag, timeFlag,jiwei, req.getSession().getServletContext());
		
		
		req.setAttribute("date_start", date_start);
		req.setAttribute("date_end", date_end);
		req.setAttribute("institution", institution);
		req.setAttribute("fmqktjs", fmqktjs);
		req.getRequestDispatcher("/report/fmqktj.jsp").forward(req, resp);
	}

}
