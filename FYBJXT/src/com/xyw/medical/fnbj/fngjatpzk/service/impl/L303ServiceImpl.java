package com.xyw.medical.fnbj.fngjatpzk.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fngjatpzk.dao.L303Dao;
import com.xyw.medical.fnbj.fngjatpzk.service.L303Service;
import com.xyw.medical.fnbj.model.L303;
import com.xyw.medical.fnbj.model.L303Request;
import com.xyw.medical.fnbj.model.L303Response;

public class L303ServiceImpl implements L303Service {
	@Resource
	private L303Dao l303Dao;

	@Override
	public L303Response saveL303(L303 l303) {
		// TODO Auto-generated method stub
		return l303Dao.saveL303(l303);
	}


}
