package com.xyw.medical.swjc.ycfsw.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.swjc.model.Sw304;
import com.xyw.medical.swjc.model.Sw304Request;
import com.xyw.medical.swjc.model.Sw304Response;
import com.xyw.medical.swjc.ycfsw.dao.Sw304Dao;
import com.xyw.medical.swjc.ycfsw.service.Sw304Service;

public class Sw304ServiceImpl implements Sw304Service {
	
	@Resource
	private Sw304Dao sw304Dao;

	@Override
	public Sw304Response saveSw304(Sw304 sw304) {
		return sw304Dao.saveSw304(sw304);
	}

	@Override
	public Sw304Response querySw304(Sw304Request sw304Request) {
		return sw304Dao.querySw304(sw304Request);
	}

	@Override
	public Sw304Response delSw304(String sw30401) {
		return sw304Dao.delSw304(sw30401);
	}

	@Override
	public Sw304Response renewSw304(Sw304 sw304) {
		return sw304Dao.renewSw304(sw304);
	}
	
	
}
