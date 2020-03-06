package com.xyw.medical.fnbj.fncszk.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fncszk.dao.F504Dao;
import com.xyw.medical.fnbj.fncszk.service.F504Service;
import com.xyw.medical.fnbj.model.F504Request;
import com.xyw.medical.fnbj.model.F504Response;

public class F504ServiceImpl implements F504Service {
	@Resource
	private F504Dao f504Dao;

	@Override
	public F504Response delF504(F504Request f504Request) {
		return f504Dao.delF504(f504Request);
	}

	@Override
	public F504Response queryF504(F504Request F504Request) {
		return f504Dao.queryF504(F504Request);
	}

	@Override
	public F504Response saveOrF504(F504Request f504Request) {
		return f504Dao.saveOrF504(f504Request);
	}


}
