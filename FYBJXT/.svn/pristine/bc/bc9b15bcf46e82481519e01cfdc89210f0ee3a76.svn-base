package com.xyw.medical.fnbj.fnrxada.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnrxada.dao.L401Dao;
import com.xyw.medical.fnbj.fnrxada.service.L401Service;
import com.xyw.medical.fnbj.model.L401Request;
import com.xyw.medical.fnbj.model.L401Response;

public class L401ServiceImpl implements L401Service {
	@Resource
	private L401Dao l401Dao;
	
	@Override
	public L401Response saveL401(L401Request l401Request) {
		
		return this.l401Dao.saveL401(l401Request);
	}

	@Override
	public L401Response delL401(L401Request l401Request) {

		return this.l401Dao.delL401(l401Request);
	}

	@Override
	public L401Response renewL401(L401Request l401Request) {
		
		return this.l401Dao.renewL401(l401Request);
	}

	@Override
	public L401Response queryL401(L401Request l401Request) {
		
		return this.l401Dao.queryL401(l401Request);
	}

}
