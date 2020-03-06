package com.xyw.medical.swjc.csqxyyjc.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.swjc.csqxyyjc.dao.Sw302Dao;
import com.xyw.medical.swjc.csqxyyjc.service.Sw302Service;
import com.xyw.medical.swjc.model.Sw302;
import com.xyw.medical.swjc.model.Sw302Request;
import com.xyw.medical.swjc.model.Sw302Response;

public class Sw302ServiceImpl implements Sw302Service {
	
	@Resource
	private Sw302Dao sw302Dao;

	@Override
	public Sw302Response saveSw302(Sw302 sw302) {
		return sw302Dao.saveSw302(sw302);
	}

	@Override
	public Sw302Response query(Sw302Request sw302Request) {
		return sw302Dao.query(sw302Request);	
	}

	@Override
	public Sw302Response delSw302(String sw30201) {
		return sw302Dao.delSw302(sw30201);
	}

	@Override
	public Sw302Response renewSw302(Sw302 sw302) {
		return sw302Dao.renewSw302(sw302);
	}
	
	
}
