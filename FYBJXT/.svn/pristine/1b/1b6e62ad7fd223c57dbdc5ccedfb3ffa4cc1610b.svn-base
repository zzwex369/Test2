package com.xyw.medical.fnbj.birthcard.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.birthcard.dao.F304Dao;
import com.xyw.medical.fnbj.birthcard.service.F304Service;
import com.xyw.medical.fnbj.model.F304;
import com.xyw.medical.fnbj.model.F304Request;
import com.xyw.medical.fnbj.model.F304Response;

public class F304ServiceImpl implements F304Service{
	@Resource
	public F304Dao f304Dao;

	@Override
	public F304Response saveF304(F304 f304) {
		F304Response f304Response =f304Dao.saveF304(f304);
		return f304Response;
	}

	@Override
	public F304Response renewF304(F304 f304) {
		F304Response f304Response =f304Dao.renewF304(f304);
		return f304Response;
	}

	@Override
	public F304Response queryF304(F304Request f304Request) {
		F304Response f304Response =f304Dao.queryF304(f304Request);
		return f304Response;
	}

	@Override
	public F304Response deleteF304(F304Request f304Request) {
		F304Response f304Response =f304Dao.deleteF304(f304Request);
		return f304Response;
	}

}
