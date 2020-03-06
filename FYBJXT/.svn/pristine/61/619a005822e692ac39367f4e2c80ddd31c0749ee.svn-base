package com.xyw.medical.fnbj.report.service;
import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.xyw.medical.fnbj.model.VL402;

public class FnbjrxadjbService {
	public VL402 queryVl402ById(String l40201,ServletContext servletContext){
		SessionFactory sessionFactory=null;
		Session session=null;
		VL402 vl402=null;
		try {			
			WebApplicationContext webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
			 sessionFactory=(SessionFactory) webApplicationContext.getBean("sessionFactory");
			 session=sessionFactory.openSession();
			 vl402=(VL402) session.get(VL402.class,l40201);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
			sessionFactory=null;
			
		}
		return vl402;
	}
}
