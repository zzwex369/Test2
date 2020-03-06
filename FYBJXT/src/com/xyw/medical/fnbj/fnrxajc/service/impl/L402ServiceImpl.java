package com.xyw.medical.fnbj.fnrxajc.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnrxajc.dao.L402Dao;
import com.xyw.medical.fnbj.fnrxajc.service.L402Service;
import com.xyw.medical.fnbj.model.L402Request;
import com.xyw.medical.fnbj.model.L402Response;

public class L402ServiceImpl implements L402Service {
	@Resource
	private L402Dao l402Dao;
	@Override
	public L402Response delL402(L402Request l402Request) {	
		return l402Dao.delL402(l402Request);
	}

	@Override
	public L402Response queryL402(L402Request l402Request) {		
		return l402Dao.queryL402(l402Request);
	}

	@Override
	public L402Response renewL402(L402Request l402Request) {	
		return l402Dao.renewL402(l402Request);
	}

	@Override
	public L402Response saveL402(L402Request l402Request) {
		return l402Dao.saveL402(l402Request);
	}

	@Override
	public L402Response queryByL402(String l40202) {
		return l402Dao.queryByL402(l40202);
	}

}
