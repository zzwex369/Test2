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
import com.xyw.medical.birth.model.VD302;
import com.xyw.medical.birth.report.model.PrintInfo;
import com.xyw.medical.birth.report.model.VD302S;
import com.xyw.medical.birth.report.model.VD302T;
import com.xyw.medical.birth.report.service.PrintBirthInfoHfService;

public class PrintBirthInfoHfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d302_10 = request.getParameter("d30210");
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		
		PrintBirthInfoHfService printBirthInfoHfService = new PrintBirthInfoHfService();
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
		
		if("BIRTH_PRINTINFO_HF".equals(flag)) {
			VD302 vd302 = printBirthInfoHfService.queryD302(d302_10, request.getSession().getServletContext());
			list.add(vd302);
		} else if("BIRTH_PRINTINFO_SECOND_HF".equals(flag)) {
			VD302S vd302S = printBirthInfoHfService.queryD302S(d302_10, request.getSession().getServletContext());
			list.add(vd302S);
		} else if("BIRTH_PRINTINFO_THIRD_HF".equals(flag)) {
			VD302T vd302T = printBirthInfoHfService.queryD302T(d302_10, request.getSession().getServletContext());
			list.add(vd302T);
		}
		
		Gson gson = new Gson();
		String listStr = gson.toJson(list);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(listStr);
		printWriter.flush();
	}

}
