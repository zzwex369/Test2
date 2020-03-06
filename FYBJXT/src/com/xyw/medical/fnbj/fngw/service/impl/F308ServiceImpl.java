package com.xyw.medical.fnbj.fngw.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fngw.dao.F308Dao;
import com.xyw.medical.fnbj.fngw.service.F308Service;
import com.xyw.medical.fnbj.model.F308;
import com.xyw.medical.fnbj.model.F308Request;
import com.xyw.medical.fnbj.model.F308Response;


public class F308ServiceImpl implements F308Service {
	@Resource
	private F308Dao f308Dao;
	@Override
	public F308Response deleteF308(F308Request f308Request) {
	
		return f308Dao.deleteF308(f308Request);
	}

	@Override
	public F308Response queryF308(F308Request f308Request) {
	
		return f308Dao.queryF308(f308Request);
	}

	@Override
	public F308Response renewF308(F308 f308) {
	
		return f308Dao.renewF308(f308);
	}

	@Override
	public F308Response saveF308(F308 f308) {
	
		return f308Dao.saveF308(f308);
	}

	@Override
	public F308Response queryByF301Id(long f301_id) {

		return f308Dao.queryByF301Id(f301_id);
	}

	

}
