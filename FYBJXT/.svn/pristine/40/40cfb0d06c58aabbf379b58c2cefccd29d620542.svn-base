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
import com.xyw.medical.birth.report.model.PrintInfo;
import com.xyw.medical.birth.report.model.VD301;
import com.xyw.medical.birth.report.model.VD302;
import com.xyw.medical.birth.report.model.VD303;
import com.xyw.medical.birth.report.service.PrintBirthInfoBfServiceNew;
import com.xyw.medical.birth.report.service.PrintBirthInfoHfServiceNew;
import com.xyw.medical.birth.report.service.PrintBirthInfoServiceNew;

public class PrintBirthInfoServletNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d301_10 = request.getParameter("d30110");
		String d303_10 = request.getParameter("d30310");
		String d302_10 = request.getParameter("d30210");
		String userCode = request.getParameter("userCode");
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		
		PrintBirthInfoServiceNew printBirthInfoServiceNew = new PrintBirthInfoServiceNew();
		PrintBirthInfoBfServiceNew printBirthInfoBfServiceNew = new PrintBirthInfoBfServiceNew();
		PrintBirthInfoHfServiceNew printBirthInfoHfServiceNew = new PrintBirthInfoHfServiceNew();
		List<Object> list = new ArrayList<Object>();
		String path = request.getSession().getServletContext().getRealPath("/print");
		String label = flag + "_" + userCode + ".ini";
		
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
		
		if("BIRTH_PRINTINFO_NEW".equals(flag)) {
			VD301 vd301 = printBirthInfoServiceNew.queryD301(d301_10, request.getSession().getServletContext());
			list.add(vd301);
		}else if("BIRTH_PRINTINFOBF_NEW".equals(flag))
		{
			VD303 vd303 = printBirthInfoBfServiceNew.queryD303(d303_10, request.getSession().getServletContext());
			list.add(vd303);
		}else if("BIRTH_PRINTINFOHF_NEW".equals(flag))
		{
			VD302 vd302 = printBirthInfoHfServiceNew.queryD302(d302_10, request.getSession().getServletContext());
			list.add(vd302);
		}
		
		Gson gson = new Gson();
		String listStr = gson.toJson(list);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(listStr);
		printWriter.flush();
		
	}

}
