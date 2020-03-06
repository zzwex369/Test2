package com.xyw.medical.fnbj.fnbjfs.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.fnbjfs.dao.F307Dao;
import com.xyw.medical.fnbj.fnbjfs.service.F307Service;
import com.xyw.medical.fnbj.model.F307;
import com.xyw.medical.fnbj.model.F307Request;
import com.xyw.medical.fnbj.model.F307Response;

@Transactional
public class F307ServiceImpl implements F307Service{
	@Resource 
	private F307Dao f307Dao;

	@Override
	public F307Response saveF307(F307 f307) {
		F307Response f307Response =this.f307Dao.saveF307(f307);
		return f307Response;
	}

	@Override
	public F307Response renewF307(F307 f307) {
		F307Response f307Response =this.f307Dao.renewF307(f307);
		return f307Response;
	}

	@Override
	public F307Response queryF307(F307Request f307Request) {
		F307Response f307Response =this.f307Dao.queryF307(f307Request);
		return f307Response;
	}

	@Override
	public F307Response deleteF307(F307Request f307Request) {
		F307Response f307Response =this.f307Dao.deleteF307(f307Request);
		return f307Response;
	}

	@Override
	public F307Response queryById(F307Request f307Request) {
		return f307Dao.queryById(f307Request);
	}
}
