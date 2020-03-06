package com.xyw.medical.etbj.etjcdj.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.etjcdj.dao.E304Dao;
import com.xyw.medical.etbj.etjcdj.service.E304Service;
import com.xyw.medical.etbj.model.E304;
import com.xyw.medical.etbj.model.E304Request;
import com.xyw.medical.etbj.model.E304Response;

@Transactional
public class E304ServiceImpl implements E304Service {

	
	@Resource
	private E304Dao e304Dao;
	
	@Override
	public E304Response saveE304(E304 e304) {
		return this.e304Dao.saveE304(e304);
	}

	@Override
	public E304Response queryE304(E304Request e304Request) {
		return this.e304Dao.queryE304(e304Request);
	}

	@Override
	public E304Response updateE304(E304 e304) {
		return this.e304Dao.updateE304(e304);
	}

	@Override
	public E304Response deleteE304(E304Request e304Request) {
		return this.e304Dao.deleteE304(e304Request);
	}

	@Override
	public E304Response queryE304H(E304Request e304Request) {
		return this.e304Dao.queryE304H(e304Request);
	}
	
	@Override
	public E304Response queryE304D(E304Request e304Request) {
		return this.e304Dao.queryE304D(e304Request);
	}
	@Override
	public E304Response queryE304All(E304Request e304Request) {
		return  this.e304Dao.queryE304All(e304Request);
	}

	@Override
	public E304Response queryPhasesE304(E304Request e304Request) {
		return this.e304Dao.queryPhasesE304(e304Request);
	}
}
