package com.xyw.medical.etbj.ettlzz.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.etbj.ettlzz.dao.E506Dao;
import com.xyw.medical.etbj.ettlzz.service.E506Service;
import com.xyw.medical.etbj.model.E506;
import com.xyw.medical.etbj.model.E506Response;

public class E506ServiceImpl implements E506Service {
	@Resource
	private E506Dao e506Dao;
	@Override
	public E506Response delByE506Id(String id) {
		
		return e506Dao.delByE506Id(id);
	}

	@Override
	public E506Response queryByE506Id(String id) {
		
		return e506Dao.queryByE506Id(id);
	}

	@Override
	public E506Response renewE506(E506 e506) {
		
		return e506Dao.renewE506(e506);
	}

	@Override
	public E506Response saveE506(E506 e506) {
		
		return e506Dao.saveE506(e506);
	}

}
