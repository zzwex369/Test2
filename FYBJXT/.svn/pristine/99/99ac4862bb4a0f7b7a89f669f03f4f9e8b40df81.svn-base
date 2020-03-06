package com.xyw.medical.etbj.hearingDisorder.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.etbj.hearingDisorder.dao.E503Dao;
import com.xyw.medical.etbj.hearingDisorder.service.E503Service;
import com.xyw.medical.etbj.model.E503;
import com.xyw.medical.etbj.model.E503Request;
import com.xyw.medical.etbj.model.E503Response;

public class E503ServiceImpl implements E503Service {
	@Resource
	private E503Dao e503Dao;
	@Override
	public E503Response deleteE503(E503Request e503Request) {
		E503Response e503Response=new E503Response();
		e503Response=e503Dao.deleteE503(e503Request);
		return e503Response;
	}

	@Override
	public E503Response queryE503(E503Request e503Request) {
		E503Response e503Response=new E503Response();
		e503Response=e503Dao.queryE503(e503Request);
		return e503Response;
	}

	@Override
	public E503Response renewE503(E503 e503) {
		E503Response e503Response=new E503Response();
		e503Response=e503Dao.renewE503(e503);
		return e503Response;
	}

	@Override
	public E503Response saveE503(E503 e503) {
		E503Response e503Response=new E503Response();
		e503Response=e503Dao.saveE503(e503);
		return e503Response;
	}

}
