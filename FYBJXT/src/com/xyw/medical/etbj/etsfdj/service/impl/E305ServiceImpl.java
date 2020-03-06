package com.xyw.medical.etbj.etsfdj.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.etsfdj.dao.E305Dao;
import com.xyw.medical.etbj.etsfdj.service.E305Service;
import com.xyw.medical.etbj.model.E305;
import com.xyw.medical.etbj.model.E305Request;
import com.xyw.medical.etbj.model.E305Response;
@Transactional
public class E305ServiceImpl implements E305Service{
	@Resource
	private E305Dao e305Dao;
	@Override
	public E305Response saveE305(E305 e305) {
		return this.e305Dao.saveE305(e305);
	}

	@Override
	public E305Response queryE305(E305Request e305Request) {
		return this.e305Dao.queryE305(e305Request);
	}

	@Override
	public E305Response queryE305H(E305Request e305Request) {
		return this.e305Dao.queryE305H(e305Request);
	}

	@Override
	public E305Response updateE305(E305 e305) {
		return this.e305Dao.updateE305(e305);
	}

	@Override
	public E305Response deleteE305(E305Request e305Request) {
		return this.e305Dao.deleteE305(e305Request);
	}
	
	@Override
	public E305Response queryE305D(E305Request e305Request) {
		return this.e305Dao.queryE305D(e305Request);

	}
	@Override
	public E305Response queryE305All(E305Request e305Request) {
		return this.e305Dao.queryE305All(e305Request);
	}
}
