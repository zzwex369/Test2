package com.xyw.medical.fnbj.fnlapic.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnlapic.dao.L306Dao;
import com.xyw.medical.fnbj.fnlapic.service.L306Service;
import com.xyw.medical.fnbj.model.L306Request;
import com.xyw.medical.fnbj.model.L306Response;

public class L306ServiceImpl implements L306Service {
	@Resource
	private L306Dao l306Dao;

	@Override
	public L306Response delAllByParentId(L306Request l306Request) {
		
		return l306Dao.delAllByParentId(l306Request);
	}

	@Override
	public L306Response delByPicName(L306Request l306Request) {
		return l306Dao.delByPicName(l306Request);
	}

	@Override
	public L306Response downPic(L306Request l306Request) {
		
		return l306Dao.downPic(l306Request);
	}

	@Override
	public L306Response queryL306(L306Request l306Request) {
		
		return l306Dao.queryL306(l306Request);
	}

	@Override
	public L306Response saveLaPic(L306Request l306Request) {
		
		return l306Dao.saveLaPic(l306Request);
	}

	@Override
	public L306Response saveLaZk(L306Request l306Request) {
		return l306Dao.saveLaZk(l306Request);
	}

	@Override
	public L306Response delLaZk(L306Request l306Request) {
		return l306Dao.delLaZk(l306Request);
	}
}
