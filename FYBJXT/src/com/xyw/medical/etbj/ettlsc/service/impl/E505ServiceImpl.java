package com.xyw.medical.etbj.ettlsc.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.ettlsc.dao.E505Dao;
import com.xyw.medical.etbj.ettlsc.service.E505Service;
import com.xyw.medical.etbj.model.E504Response;
import com.xyw.medical.etbj.model.E505;
import com.xyw.medical.etbj.model.E505Request;
import com.xyw.medical.etbj.model.E505Response;
@Transactional
public class E505ServiceImpl implements E505Service{
	@Resource
	private E505Dao e505Dao;
	@Override
	public E505Response saveE505(E505 e505) {
		E505Response e505Response = e505Dao.saveE505(e505);
		return e505Response;
	}
	@Override
	public E505Response queryE505ById(String id) {
		E505Response e505Response = e505Dao.queryE505ById(id);
		return e505Response;
	}
	@Override
	public E505Response queryE505ById2(String id) {
		E505Response e505Response = e505Dao.queryE505ById2(id);
		return e505Response;
	}
	@Override
	public E505Response queryE505(E505Request e505Request) {
		E505Response e505Response = e505Dao.queryE505(e505Request);
		return e505Response;
	}
	@Override
	public E505Response deleteE505(E505Request e505Request) {
		E505Response e505Response = e505Dao.deleteE505(e505Request);
		return e505Response;
	}
	@Override
	public E505Response renewE505(E505 e505) {
		E505Response e505Response = e505Dao.renewE505(e505);
		return e505Response;
	}
	@Override
	public E505Response queryE505AndE504(E505Request e505Request) {
		// TODO Auto-generated method stub
		return e505Dao.queryE505AndE504(e505Request);
	}
	@Override
	public E505Response queryE505ById(E505 e505) {
		// TODO Auto-generated method stub
		return e505Dao.queryE505ById(e505);
	}

}
