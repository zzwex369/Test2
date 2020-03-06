package com.xyw.medical.etbj.report.service;


import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletContext;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.etbj.model.VE501;


public class EttlscbgdService {
	@SuppressWarnings("unchecked")
	public VE501 ve501query(long id,ServletContext servletContext) throws SQLException{
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		SessionFactory sessionFactory = (SessionFactory) webApplicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		List<VE501> list= session.createSQLQuery("select * from V_E501 t where t.e501_01=?").addEntity(VE501.class).setLong(0, id).list();
		VE501 ve501 = new VE501();
			if(list!=null){
//				for(VE501 _ve501:list){
//					ve501=_ve501;
//				}
				for(int i=0;i<list.size();i++){//上面注释掉的代码可以替代以下for循环中代码.session.createSQLQuery返回的是类型为VE501的一群对象，引用为list，
												//for循环中list.get(i)得到的是session.createSQLQuery返回的第i个对象。
					ve501.setE50101(list.get(i).getE50101());
					ve501.setE50102(list.get(i).getE50102());
					ve501.setE50103(list.get(i).getE50103());
					ve501.setE50104(list.get(i).getE50104());
					ve501.setE50105(list.get(i).getE50105());
					ve501.setE50106(list.get(i).getE50106());
					ve501.setE50107(list.get(i).getE50107());
					ve501.setE50108(list.get(i).getE50108());
					ve501.setE50109(list.get(i).getE50109());
					ve501.setE50110(list.get(i).getE50110());
					ve501.setE50111(list.get(i).getE50111());
					ve501.setE50112(list.get(i).getE50112());
					ve501.setE50113(list.get(i).getE50113());
					ve501.setE50114(list.get(i).getE50114());
					ve501.setE50115(list.get(i).getE50115());
					ve501.setE50116(list.get(i).getE50116());
					ve501.setE50117(list.get(i).getE50117());
					ve501.setE50118(list.get(i).getE50118());
					ve501.setE50119(list.get(i).getE50119());
					ve501.setE50120(list.get(i).getE50120());
					ve501.setE50121(list.get(i).getE50121());
					ve501.setE50122(list.get(i).getE50122());
					ve501.setE50123(list.get(i).getE50123());
					ve501.setE50124(list.get(i).getE50124());
					ve501.setE50125(list.get(i).getE50125());
					ve501.setE50126(list.get(i).getE50126());
					ve501.setE50127(list.get(i).getE50127());
					ve501.setE50128(list.get(i).getE50128());
					ve501.setE50129(list.get(i).getE50129());
					
					ve501.setE50108Str(list.get(i).getE50108Str());
					ve501.setE50118Str(list.get(i).getE50118Str());
				}
			}
		return ve501;
	}
}
