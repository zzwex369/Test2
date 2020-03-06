package com.xyw.medical.fnbj.fnbjdj.service.impl;

import javax.annotation.Resource;


import com.xyw.medical.fnbj.fnbjdj.dao.F301Dao;
import com.xyw.medical.fnbj.fnbjdj.service.F301Service;
import com.xyw.medical.fnbj.model.F301;
import com.xyw.medical.fnbj.model.F301Request;
import com.xyw.medical.fnbj.model.F301Response;

public class F301ServiceImpl implements F301Service{
	
	@Resource
	private F301Dao f301Dao;

	@Override
	public F301Response saveF301(F301 f301) {
		F301Response f301Response =f301Dao.saveF301(f301);
		return f301Response;
	}

	@Override
	public F301Response renewF301(F301 f301) {
		F301Response f301Response =f301Dao.renewF301(f301);
		return f301Response;
	}

	@Override
	public F301Response queryF301(F301Request f301Request) {
		F301Response f301Response =f301Dao.queryF301(f301Request);
		return f301Response;
	}

	@Override
	public F301Response deleteF301(F301Request f301Request) {
		F301Response f301Response =f301Dao.deleteF301(f301Request);
		return f301Response;
	}

	@Override
	public F301Response updateMate(F301 f301) {
		F301Response f301Response =f301Dao.updateMate(f301);
		return f301Response;
	}
	
	@Override
	public F301Response _renewF301(F301 f301) {
		return f301Dao._renewF301(f301);
	}
}
