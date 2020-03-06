package com.xyw.medical.fnbj.fngjadj.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fngjadj.dao.L302Dao;
import com.xyw.medical.fnbj.fngjadj.service.L302Service;
import com.xyw.medical.fnbj.model.L302Request;
import com.xyw.medical.fnbj.model.L302Response;

public class L302ServiceImpl implements L302Service {
	@Resource
	private L302Dao l302Dao;
	@Override
	public L302Response delL302(L302Request l302Request) {	
		return l302Dao.delL302(l302Request);
	}

	@Override
	public L302Response queryL302(L302Request l302Request) {	
		return l302Dao.queryL302(l302Request);
	}

	@Override
	public L302Response renewL302(L302Request l302Request) {	
		return l302Dao.renewL302(l302Request);
	}

	@Override
	public L302Response saveL302(L302Request l302Request) {
		return l302Dao.saveL302(l302Request);
	}

	@Override
	public L302Response queryByL302Id(String l30202) {
		return l302Dao.queryByL302Id(l30202);
	}

	

}
