package com.xyw.medical.fnbj.fnbjhqtj.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnbjhqtj.dao.F401Dao;
import com.xyw.medical.fnbj.fnbjhqtj.service.F401Service;
import com.xyw.medical.fnbj.model.F401;
import com.xyw.medical.fnbj.model.F401Request;
import com.xyw.medical.fnbj.model.F401Response;

public class F401ServiceImpl implements F401Service{
	@Resource
	private F401Dao f401Dao;

	@Override
	public F401Response saveF401(F401 f401) {
		F401Response f401Response =f401Dao.saveF401(f401);
		return f401Response;
	}

	@Override
	public F401Response renewF401(F401 f401) {
		F401Response f401Response =f401Dao.renewF401(f401);
		return f401Response;
	}

	@Override
	public F401Response queryF401(F401Request f401Request) {
		F401Response f401Response =f401Dao.queryF401(f401Request);
		return f401Response;
	}

	@Override
	public F401Response deleteF401(F401Request f401Request) {
		F401Response f401Response =f401Dao.deleteF401(f401Request);
		return f401Response;
	}

}
