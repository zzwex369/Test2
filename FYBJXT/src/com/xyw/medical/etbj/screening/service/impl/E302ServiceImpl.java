package com.xyw.medical.etbj.screening.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.etbj.model.E302;
import com.xyw.medical.etbj.model.E302Request;
import com.xyw.medical.etbj.model.E302Response;
import com.xyw.medical.etbj.screening.dao.E302Dao;
import com.xyw.medical.etbj.screening.service.E302Service;

public class E302ServiceImpl implements E302Service{

	@Resource
	public E302Dao e302Dao;
	
	@Override
	public E302Response savaE302(E302 e302) {
		E302Response e302Response =new E302Response();
		e302Response =e302Dao.savaE302(e302);
		return e302Response;
	}

	@Override
	public E302Response renewE302(E302 e302) {
		E302Response e302Response =new E302Response();
		e302Response =e302Dao.renewE302(e302);
		return e302Response;
	}

	@Override
	public E302Response deleteE302(E302Request e302Request) {
		E302Response e302Response =new E302Response();
		e302Response =e302Dao.deleteE302(e302Request);
		return e302Response;
	}

	@Override
	public E302Response queryE302(E302Request e302Request) {
		E302Response e302Response =new E302Response();
		e302Response =e302Dao.queryE302(e302Request);
		return e302Response;
	}

}
