package com.xyw.medical.fnbj.report.service;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.fnbj.model.VL302;

public class FnbjgjadjbService {
	public VL302 queryVl302ById(String l30201,ServletContext servletContext){
		SessionFactory sessionFactory=null;
		Session session=null;
		VL302 vl302=null;
		try {			
			WebApplicationContext webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
			 sessionFactory=(SessionFactory) webApplicationContext.getBean("sessionFactory");
			 session=sessionFactory.openSession();
			 vl302=(VL302) session.get(VL302.class,l30201);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
			sessionFactory=null;
			
		}
		return vl302;
	}
}
