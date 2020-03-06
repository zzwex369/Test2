package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xyw.medical.birth.model.VD303;
import com.xyw.medical.birth.report.model.PrintInfo;
import com.xyw.medical.birth.report.model.VD303S;
import com.xyw.medical.birth.report.model.VD303T;
import com.xyw.medical.birth.report.service.PrintBirthInfoBfService;

public class PrintBirthInfoBfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d303_10 = request.getParameter("d30310");
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		
		PrintBirthInfoBfService printBirthInfoBfService = new PrintBirthInfoBfService();
		List<Object> list = new ArrayList<Object>();
		String path = request.getSession().getServletContext().getRealPath("/print");
		String label = flag + ".ini";
		
		PrintInfo printInfo = new PrintInfo();
		printInfo.setPath(path);
		printInfo.setLabel(label);

		Map<String, String> map = new HashMap<String, String>();
		
		Properties properties = printInfo.getProperties();
		Enumeration<Object> keys = properties.keys();
		
		while(keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			String value = (String)properties.get(key);
			map.put(key, value);
		}
		
		list.add(map);
		
		if("BIRTH_PRINTINFO_BF".equals(flag)) {
			VD303 vd303 = printBirthInfoBfService.queryD303(d303_10, request.getSession().getServletContext());
			list.add(vd303);
		} else if("BIRTH_PRINTINFO_SECOND_BF".equals(flag)) {
			VD303S vd303S = printBirthInfoBfService.queryD303S(d303_10, request.getSession().getServletContext());
			list.add(vd303S);
		} else if("BIRTH_PRINTINFO_THIRD_BF".equals(flag)) {
			VD303T vd303T = printBirthInfoBfService.queryD303T(d303_10, request.getSession().getServletContext());
			list.add(vd303T);
		}
		
		Gson gson = new Gson();
		String listStr = gson.toJson(list);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(listStr);
		printWriter.flush();
	}

}
