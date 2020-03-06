package com.xyw.medical.fnbj.fnbjxqsf.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnbjxqsf.dao.F603Dao;
import com.xyw.medical.fnbj.fnbjxqsf.service.F603Service;
import com.xyw.medical.fnbj.model.F603;
import com.xyw.medical.fnbj.model.F603Request;
import com.xyw.medical.fnbj.model.F603Response;

public class F603ServiceImpl implements F603Service{

	@Resource
	private F603Dao f603Dao;
	@Override
	public F603Response saveF603(F603 f603) {
		return f603Dao.saveF603(f603);
	}
	@Override
	public F603Response deleteF603(F603Request f603Request) {
		
		F603Response f603Response=new F603Response();
		try {
			f603Response= f603Dao.deleteF603(f603Request);
		} catch (Exception e) {
			f603Response.setState(false);
			f603Response.setErrorMessage(e.getMessage());
		}
		return f603Response;
	}
	@Override
	public F603Response queryF603(F603Request f603Request) {
		
		return f603Dao.queryF603(f603Request);
	}
	@Override
	public F603Response renewF603(F603 f603) {
		
		return f603Dao.renewF603(f603);
	}

}
