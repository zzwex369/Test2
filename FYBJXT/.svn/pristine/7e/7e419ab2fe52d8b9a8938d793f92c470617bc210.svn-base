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
import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.report.model.PrintInfo;
import com.xyw.medical.birth.report.model.VD301S;
import com.xyw.medical.birth.report.model.VD301T;
import com.xyw.medical.birth.report.service.PrintBirthInfoService;

public class PrintBirthInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d301_10 = request.getParameter("d30110");
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		
		PrintBirthInfoService printBirthInfoService = new PrintBirthInfoService();
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
		
		if("BIRTH_PRINTINFO".equals(flag)) {
			VD301 vd301 = printBirthInfoService.queryD301(d301_10, request.getSession().getServletContext());
			list.add(vd301);
		} else if("BIRTH_PRINTINFO_SECOND".equals(flag)) {
			VD301S vd301S = printBirthInfoService.queryD301S(d301_10, request.getSession().getServletContext());
			list.add(vd301S);
		} else if("BIRTH_PRINTINFO_THIRD".equals(flag)) {
			VD301T vd301T = printBirthInfoService.queryD301T(d301_10, request.getSession().getServletContext());
			list.add(vd301T);
		}
		
		Gson gson = new Gson();
		String listStr = gson.toJson(list);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(listStr);
		printWriter.flush();
		
	}

}
