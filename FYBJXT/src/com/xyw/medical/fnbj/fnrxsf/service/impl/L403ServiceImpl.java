package com.xyw.medical.fnbj.fnrxsf.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnrxsf.dao.L403Dao;
import com.xyw.medical.fnbj.fnrxsf.service.L403Service;
import com.xyw.medical.fnbj.model.L403;
import com.xyw.medical.fnbj.model.L403Request;
import com.xyw.medical.fnbj.model.L403Response;

public class L403ServiceImpl implements L403Service {
	@Resource
	private L403Dao l403Dao;

	@Override
	public L403Response saveL403(L403 l403) {
		// TODO Auto-generated method stub
		return l403Dao.saveL403(l403);
	}
	

}
