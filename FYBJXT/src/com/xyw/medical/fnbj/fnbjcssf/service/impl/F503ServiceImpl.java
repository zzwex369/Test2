package com.xyw.medical.fnbj.fnbjcssf.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnbjcssf.dao.F503Dao;
import com.xyw.medical.fnbj.fnbjcssf.service.F503Service;
import com.xyw.medical.fnbj.model.F503;
import com.xyw.medical.fnbj.model.F503Request;
import com.xyw.medical.fnbj.model.F503Response;

public class F503ServiceImpl implements F503Service {
	
	@Resource
	private F503Dao f503Dao;
	
	@Override
	public F503Response saveF503(F503 f503) {
		return f503Dao.saveF503(f503);
	}

	@Override
	public F503Response deleteF503(F503Request f503Request){
		F503Response f503Response=new F503Response();
		try {
			f503Response= f503Dao.deleteF503(f503Request);
		} catch (Exception e) {
			f503Response.setState(false);
			f503Response.setErrorMessage(e.getMessage());
		}
		return f503Response;
	}

	@Override
	public F503Response queryF503(F503Request f503Request) {
		
		return f503Dao.queryF503(f503Request);
	}

	@Override
	public F503Response renewF503(F503 f503) {
		
		return f503Dao.renewF503(f503);
	}

}
