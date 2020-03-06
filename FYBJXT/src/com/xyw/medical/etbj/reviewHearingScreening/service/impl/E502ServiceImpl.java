package com.xyw.medical.etbj.reviewHearingScreening.service.impl;


import javax.annotation.Resource;

import com.xyw.medical.etbj.model.E502;
import com.xyw.medical.etbj.model.E502Request;
import com.xyw.medical.etbj.model.E502Response;
import com.xyw.medical.etbj.reviewHearingScreening.dao.E502Dao;
import com.xyw.medical.etbj.reviewHearingScreening.service.E502Service;

public class E502ServiceImpl implements E502Service {
	@Resource
	private E502Dao e502Dao;
	@Override
	public E502Response saveE502(E502 e502) {
		E502Response e502Response=new E502Response();
		e502Response=e502Dao.saveE502(e502);
		return e502Response;
	}
	@Override
	public E502Response deleteE502(E502Request e502Request) {
		E502Response e502Response=new E502Response();
		e502Response=e502Dao.deleteE502(e502Request);
		return e502Response;
	}
	@Override
	public E502Response queryE502(E502Request e502Request) {
		E502Response e502Response=new E502Response();
		e502Response=e502Dao.queryE502(e502Request);
		return e502Response;
	}
	@Override
	public E502Response renewE502(E502 e502) {
		E502Response e502Response=new E502Response();
		e502Response=e502Dao.renewE502(e502);
		return e502Response;
	}

}
