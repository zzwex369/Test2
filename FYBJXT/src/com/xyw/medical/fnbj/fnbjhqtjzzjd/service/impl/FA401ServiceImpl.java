package com.xyw.medical.fnbj.fnbjhqtjzzjd.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnbjhqtjzzjd.dao.FA401Dao;
import com.xyw.medical.fnbj.fnbjhqtjzzjd.service.FA401Service;
import com.xyw.medical.fnbj.model.FA401;
import com.xyw.medical.fnbj.model.FA401Request;
import com.xyw.medical.fnbj.model.FA401Response;

public class FA401ServiceImpl implements FA401Service {
	@Resource
	private FA401Dao fA401Dao;
	@Override
	public FA401Response queryFA401(FA401Request fA401Request) {
		
		return this.fA401Dao.queryFA401(fA401Request);
	}

	@Override
	public FA401Response renewFA401(FA401 fA401) {

		return this.fA401Dao.renewFA401(fA401);
	}

	@Override
	public FA401Response deleteFA401(FA401Request fA401Request) {
	
		return this.fA401Dao.deleteFA401(fA401Request);
	}

}
