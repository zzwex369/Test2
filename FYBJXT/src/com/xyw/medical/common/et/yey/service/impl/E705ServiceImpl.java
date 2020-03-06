package com.xyw.medical.common.et.yey.service.impl;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xyw.medical.common.et.yey.dao.E705Dao;
import com.xyw.medical.common.et.yey.model.E705;
import com.xyw.medical.common.et.yey.model.E705Request;
import com.xyw.medical.common.et.yey.model.E705Response;
import com.xyw.medical.common.et.yey.service.E705Service;
import com.xyw.sys.util.ExceptionCollection;

@Service("e705Service")
@Scope("prototype")
public class E705ServiceImpl implements E705Service{
	@Resource
	private E705Dao e705Dao;
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public E705Response saveE705(E705Request e705Request) {
		E705Response resp;
		try{
			resp = e705Dao.saveE705(e705Request);
		}catch (Exception e) {
			resp = getError(e705Request.getE705(),e,"保存失败！");
			
		}
		return resp;
	}

	@Override
	public E705Response renewE705(E705Request e705Request) {
		E705Response resp;
		try{
			resp = e705Dao.renewE705(e705Request);
		}catch (Exception e) {
			resp = getError(e705Request.getE705(),e,"修改失败！");
			
		}
		return resp;
	}

	@Override
	public E705Response queryE705(E705Request e705Request) {
		E705Response resp;
		try{
			resp = e705Dao.queryE705(e705Request);
		}catch (Exception e) {
			resp = getError(e705Request.getE705(),e,"查询失败！");
		}
		return resp;
	}

	@Override
	public E705Response deleteE705(E705Request e705Request) {
		E705Response resp;
		try{
			resp = e705Dao.deleteE705(e705Request);
		}catch (Exception e) {
			resp = getError(e705Request.getE705(),e,"删除失败！");
			
		}
		return resp;
	}

	private E705Response getError(E705 e705,Exception e,String errorMessage) {
		e.printStackTrace();
		E705Response resp = new E705Response();
		resp.setState(false);
		resp.setErrorMessage(errorMessage);
//		ExceptionCollection.saveD403(e, e705.getE70511(), "E705", e705
//				.getE70501(), sessionFactory.getCurrentSession());
		return resp;
	}


	

}
