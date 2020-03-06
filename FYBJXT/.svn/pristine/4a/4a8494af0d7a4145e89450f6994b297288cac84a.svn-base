package com.xyw.medical.etbj.etsl.etsljc.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.etsl.etsljc.dao.E702Dao;
import com.xyw.medical.etbj.etsl.etsljc.service.E702Service;
import com.xyw.medical.etbj.etsl.model.E702Request;
import com.xyw.medical.etbj.etsl.model.E702Response;

@Transactional
@Service("e702Service")
@Scope("prototype")
public class E702ServiceImpl implements E702Service{
	@Resource
	private E702Dao e702Dao;

	@Override
	public E702Response saveE702(E702Request e702Request) {
		return e702Dao.saveE702(e702Request);
	}

	@Override
	public E702Response renewE702(E702Request e702Request) {
		return e702Dao.renewE702(e702Request);
	}

	@Override
	public E702Response queryE702(E702Request e702Request) {
		return e702Dao.queryE702(e702Request);
	}

	@Override
	public E702Response deleteE702(E702Request e702Request) {
		return e702Dao.deleteE702(e702Request);
	}

	@Override
	public E702Response getE702(String e70201) {
		return e702Dao.getE702(e70201);
	}


	

}
