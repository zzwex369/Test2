package com.xyw.medical.etbj.ettlscdjb.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.ettlscdjb.dao.E504Dao;
import com.xyw.medical.etbj.ettlscdjb.service.E504Service;
import com.xyw.medical.etbj.model.E504;
import com.xyw.medical.etbj.model.E504Request;
import com.xyw.medical.etbj.model.E504Response;
@Transactional
public class E504ServiceImpl implements E504Service{
@Resource
private E504Dao e504Dao;
	@Override
	public E504Response saveE504(E504 e504) {
		E504Response e504Response = this.e504Dao.saveE504(e504);
		return e504Response;
	}
	@Override
	public E504Response queryE504(E504Request e504Request) {
		E504Response e504Response = this.e504Dao.queryE504(e504Request);
		return e504Response;
	}
	@Override
	public E504Response deleteE504(E504Request e504Request) {
		E504Response e504Response = this.e504Dao.deleteE504(e504Request);
		return e504Response;
	}
	@Override
	public E504Response renewE504(E504 e504) {
		E504Response e504Response = this.e504Dao.renewE504(e504);
		return e504Response;
	}

}
