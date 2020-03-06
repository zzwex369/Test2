package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xyw.medical.birth.report.service.PrintBirthInfoService;

public class GetAreaNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String areaCode = request.getParameter("areaCode");
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintBirthInfoService printBirthInfoService = new PrintBirthInfoService();
		List<String> listAreaName = printBirthInfoService.getAreaName(areaCode, request.getSession().getServletContext());
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(listAreaName);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonStr);
		printWriter.flush();
	}

}
