package com.xyw.medical.fnbj.wcbj.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.model.F302;
import com.xyw.medical.fnbj.model.F302Request;
import com.xyw.medical.fnbj.model.F302Response;
import com.xyw.medical.fnbj.wcbj.dao.PerinatalHealthDao;
import com.xyw.medical.fnbj.wcbj.service.PerinatalHealthService;

public class PerinatalHealthServiceImpl implements PerinatalHealthService{
	
	@Resource
	private PerinatalHealthDao perinatalHealthDao;

	@Override
	public F302Response saveF302(F302 f302) {
		F302Response f302Response =perinatalHealthDao.saveF302(f302);
		return f302Response;
	}

	@Override
	public F302Response renewF302(F302 f302) {
		F302Response f302Response =perinatalHealthDao.renewF302(f302);
		return f302Response;
	}

	@Override
	public F302Response queryF302(F302Request f302Request) {
		F302Response f302Response =perinatalHealthDao.queryF302(f302Request);
		return f302Response;
	}

	@Override
	public F302Response deleteF302(F302Request f302Request) {
		F302Response f302Response =perinatalHealthDao.deleteF302(f302Request);
		return f302Response;
	}

}
