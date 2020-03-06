package com.xyw.medical.etbj.report.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.etbj.model.VE502;

public class EtbjtlscyytzdService {
	@SuppressWarnings("unchecked")
	public VE502 queryVE502(long id,ServletContext servletContext){
		VE502 ve502 = new VE502();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		SessionFactory sessionFactory = (SessionFactory) webApplicationContext.getBean("sessionFactory");
		try{
			List<VE502> list = sessionFactory.openSession().createSQLQuery(" select * from V_E502 t where t.e502_01=? ").addEntity(VE502.class).setLong(0, id).list();
			for(VE502 ve502_:list){
				ve502 = ve502_;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return ve502;
		
	}
}
