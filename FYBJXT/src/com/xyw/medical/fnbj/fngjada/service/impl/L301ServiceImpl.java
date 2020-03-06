package com.xyw.medical.fnbj.fngjada.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fngjada.dao.L301Dao;
import com.xyw.medical.fnbj.fngjada.service.L301Service;
import com.xyw.medical.fnbj.model.L301;
import com.xyw.medical.fnbj.model.L301Request;
import com.xyw.medical.fnbj.model.L301Response;

public class L301ServiceImpl implements L301Service {
	@Resource
	private L301Dao l301Dao;
	@Override
	public L301Response delL301(L301Request l301Request) {
		return l301Dao.delL301(l301Request);
	}

	@Override
	public L301Response queryL301(L301Request l301Request) {
		return l301Dao.queryL301(l301Request);
	}

	@Override
	public L301Response renewL301(L301Request l301Request) {
		return l301Dao.renewL301(l301Request);
	}

	@Override
	public L301Response saveL301(L301Request l301Request) {	
		return l301Dao.saveL301(l301Request);
	}

	@Override
	public L301Response finishCaseL301(L301 l301) {
		// TODO Auto-generated method stub
		return l301Dao.finishCaseL301(l301);
	}

}
