package com.xyw.medical.swjc.csqxrqjc.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.swjc.csqxrqjc.dao.Sw303Dao;
import com.xyw.medical.swjc.csqxrqjc.service.Sw303Service;
import com.xyw.medical.swjc.model.Sw303;
import com.xyw.medical.swjc.model.Sw303Request;
import com.xyw.medical.swjc.model.Sw303Response;

public class Sw303ServiceImpl implements Sw303Service {
	
	@Resource
	private Sw303Dao sw303Dao;

	@Override
	public Sw303Response saveSw303(Sw303 sw303) {
		return sw303Dao.saveSw303(sw303);
	}

	@Override
	public Sw303Response querySw303(Sw303Request sw303Request) {
		return sw303Dao.querySw303(sw303Request);
	}

	@Override
	public Sw303Response delSw303(String sw30301) {
		return sw303Dao.delSw303(sw30301);
	}

	@Override
	public Sw303Response renewSw303(Sw303 sw303) {	
		return sw303Dao.renewSw303(sw303);
	}
	
	
}
