package com.xyw.medical.fnbj.fngjasf.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fngjasf.dao.L304Dao;
import com.xyw.medical.fnbj.fngjasf.service.L304Service;
import com.xyw.medical.fnbj.model.L304;
import com.xyw.medical.fnbj.model.L304Response;

public class L304ServiceImpl implements L304Service {
	@Resource
	private L304Dao l304Dao;

	@Override
	public L304Response saveL304(L304 l304) {
		// TODO Auto-generated method stub
		return l304Dao.saveL304(l304);
	}
	
}
