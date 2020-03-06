package com.xyw.medical.fnbj.fngwfxpg.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fngwfxpg.dao.F309Dao;
import com.xyw.medical.fnbj.fngwfxpg.service.F309Service;
import com.xyw.medical.fnbj.model.F309;
import com.xyw.medical.fnbj.model.F309Request;
import com.xyw.medical.fnbj.model.F309Response;

public class F309ServiceImpl implements F309Service {
	
	@Resource
	private F309Dao f309Dao;
	@Override
	public F309Response deleteF309(F309Request f309Request) {
		return f309Dao.deleteF309(f309Request);
	}

	@Override
	public F309Response queryF309(F309Request F309Request) {
		
		return f309Dao.queryF309(F309Request);
	}

	@Override
	public F309Response renewF309(F309 f309) {
		
		return f309Dao.renewF309(f309);
	}

	@Override
	public F309Response saveF309(F309 f309) {
		
		return f309Dao.saveF309(f309);
	}

}
