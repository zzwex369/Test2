package com.xyw.medical.swjc.etsw.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.swjc.etsw.dao.Sw301Dao;
import com.xyw.medical.swjc.etsw.service.Sw301Service;
import com.xyw.medical.swjc.model.Sw301Request;
import com.xyw.medical.swjc.model.Sw301Response;
import com.xyw.medical.swjc.model.Sw301;

public class Sw301ServiceImpl implements Sw301Service {
	
	@Resource
	private Sw301Dao sw301Dao;

	@Override
	public Sw301Response saveSw301(Sw301 sw301) {
		return sw301Dao.saveSw301(sw301);
	}

	@Override
	public Sw301Response querySw301(Sw301Request sw301Request) {
		return sw301Dao.querySw301(sw301Request);
	}

	@Override
	public Sw301Response delSw301(String sw30101) {
		return sw301Dao.delSw301(sw30101);
	}

	@Override
	public Sw301Response renewSw301(Sw301 sw301) {
		return sw301Dao.renewSw301(sw301);
	}
	
	
}
