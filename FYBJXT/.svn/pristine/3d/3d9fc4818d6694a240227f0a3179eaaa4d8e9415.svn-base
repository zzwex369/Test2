package com.xyw.medical.fnbj.fnbjcs_xqsf.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnbjcs_xqsf.dao.F604Dao;
import com.xyw.medical.fnbj.fnbjcs_xqsf.service.F604Service;
import com.xyw.medical.fnbj.model.F604;
import com.xyw.medical.fnbj.model.F604Request;
import com.xyw.medical.fnbj.model.F604Response;

public class F604ServiceImpl implements F604Service{

	@Resource
	private F604Dao f604Dao;
	@Override
	public F604Response saveF604(F604 f604) {
		return f604Dao.saveF604(f604);
	}
	@Override
	public F604Response deleteF604(F604Request f604Request){
		F604Response f604Response=new F604Response();
		try {
			f604Response= f604Dao.deleteF604(f604Request);
		} catch (Exception e) {
			f604Response.setState(false);
			f604Response.setErrorMessage(e.getMessage());
		}
		return f604Response;
	}
	@Override
	public F604Response queryF604(F604Request f604Request) {
		
		return f604Dao.queryF604(f604Request);
	}
	@Override
	public F604Response renewF604(F604 f604) {
		
		return f604Dao.renewF604(f604);
	}

}
