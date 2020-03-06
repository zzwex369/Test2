package com.xyw.medical.fnbj.fngwzz.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fngwzz.dao.F310Dao;
import com.xyw.medical.fnbj.fngwzz.service.F310Service;
import com.xyw.medical.fnbj.model.F310;
import com.xyw.medical.fnbj.model.F310Request;
import com.xyw.medical.fnbj.model.F310Response;

public class F310ServiceImpl implements F310Service {
	@Resource
	private F310Dao f310Dao;
	@Override
	public F310Response deleteF310(F310Request f310Request) {
		
		return f310Dao.deleteF310(f310Request);
	}

	@Override
	public F310Response queryF310(F310Request F310Request) {
		
		return f310Dao.queryF310(F310Request);
	}

	@Override
	public F310Response renewF310(F310 f310) {
		
		return f310Dao.renewF310(f310);
	}

	@Override
	public F310Response saveF310(F310 f310) {
		
		return f310Dao.saveF310(f310);
	}

}
