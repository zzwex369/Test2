package com.xyw.medical.etbj.etbjdj.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.etbjdj.dao.E301Dao;
import com.xyw.medical.etbj.etbjdj.service.E301Service;
import com.xyw.medical.etbj.model.E301;
import com.xyw.medical.etbj.model.E301Request;
import com.xyw.medical.etbj.model.E301Response;

@Transactional
public class E301ServiceImpl implements E301Service{
	
	@Resource
	private E301Dao e301Dao;
	
	@Override
	public E301Response saveE301(E301 e301) {
		return this.e301Dao.saveE301(e301);
	}
	@Override
	public E301Response queryE301(E301Request e301Request) {
		E301Response e301Response = this.e301Dao.queryE301(e301Request);
		return e301Response;
	}
	@Override
	public E301Response updateE301(E301 e301) {
		return this.e301Dao.updateE301(e301);
	}
	@Override
	public E301Response deleteE301(E301Request e301Request) {
		return this.e301Dao.deleteE301(e301Request);
	}
	@Override
	public E301Response queryE301All(E301Request e301Request) {
		
		return this.e301Dao.queryE301All(e301Request);
	}
}
