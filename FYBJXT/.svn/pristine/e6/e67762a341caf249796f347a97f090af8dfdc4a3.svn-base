package com.xyw.medical.birth.report.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xyw.medical.birth.report.model.Message;
import com.xyw.medical.birth.report.model.PrintInfo;


public class SavePropertyServletNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		String labelPrefix = request.getParameter("BIRTH_PRINTINFO_NEW");
		String label = labelPrefix + ".ini";
		PrintInfo printInfo = null;
		Map<String, String> map = null;
		String gsonStr = "";
		Gson gson = null;
		
		String path = request.getSession().getServletContext().getRealPath("/print");
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control","no-cache");
		PrintWriter printWriter = response.getWriter();

		if("save".equals(flag)) {
			@SuppressWarnings("unchecked")
			Enumeration<String> parameterNames = request.getParameterNames();
			Properties properties = new Properties();
			printInfo = new PrintInfo();
			while(parameterNames.hasMoreElements()) {
				
				String parameterName = parameterNames.nextElement();
				String parameterValue = request.getParameter(parameterName);
				
				if(!"BIRTH_PRINTINFO_NEW".equals(parameterName) && !"save".equals(parameterValue)) {
					properties.setProperty(parameterName, parameterValue);
				} else {
					printInfo.setPath(path);
					printInfo.setLabel(label);
				}	
			}
			boolean result = printInfo.setProperties(properties);
			Message message = new Message();
			gson = new Gson();
			if(result) {
				message.setFlagValue("设置成功!");
			} else {
				message.setFlagValue("设置失败!");
			}
			
			gsonStr = gson.toJson(message);
			
		} else if("load".equals(flag)) {
			printInfo = new PrintInfo();
			printInfo.setLabel(label);
			printInfo.setPath(path);
			
			map = new HashMap<String, String>();
			
			Properties properties = printInfo.getProperties();
			Enumeration<Object> keys = properties.keys();
			
			while(keys.hasMoreElements()) {
				String key = (String)keys.nextElement();
				String value = (String)properties.get(key);
				map.put(key, value);
			}
			gson = new Gson();
			gsonStr = gson.toJson(map);
		}else if("change".equals(flag)){
			printInfo = new PrintInfo();
			printInfo.setLabel(label);
			printInfo.setPath(path);
			boolean result=printInfo.changeProperties();
			map = new HashMap<String, String>();
			if(result){
				map.put("flag","true");
				map.put("message", "恢复成功");
				gson = new Gson();
				gsonStr = gson.toJson(map);
			}else{
				map.put("flag","");
				map.put("message", "恢复失败");
				gson = new Gson();
				gsonStr = gson.toJson(map);
			}
		}
		printWriter.print(gsonStr);
		printWriter.flush();
	}
}
