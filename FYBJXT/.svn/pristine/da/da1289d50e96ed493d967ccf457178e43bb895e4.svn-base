package com.xyw.medical.fnbj.fnsydj.service.imp;

import javax.annotation.Resource;

import com.xyw.medical.fnbj.fnsydj.dao.PrenatalEduDao;
import com.xyw.medical.fnbj.fnsydj.service.PrenatalEduService;
import com.xyw.medical.fnbj.model.F306;
import com.xyw.medical.fnbj.model.F306Request;
import com.xyw.medical.fnbj.model.F306Response;

public class PrenatalEduServiceImpl implements PrenatalEduService{
	@Resource
	private PrenatalEduDao prenatalEduDao;
	
	@Override
	public F306Response queryF306(F306Request f306Request) {
		F306Response f306Response = prenatalEduDao.queryF306(f306Request);
		return f306Response;
	}

	@Override
	public F306Response saveF306(F306 f306) {
		F306Response f306Response = prenatalEduDao.saveF306(f306);
		return f306Response;
	}

	@Override
	public F306Response queryVF306(F306Request f306Request) {
		F306Response f306Response = prenatalEduDao.queryVF306(f306Request);
		return f306Response;
	}

	@Override
	public F306Response updateF306(F306 f306) {
		F306Response f306Response = prenatalEduDao.updateF306(f306);
		return f306Response;
	}

	@Override
	public F306Response deleteF306(F306Request f306Request) {
		F306Response f306Response = prenatalEduDao.deleteF306(f306Request);
		return f306Response;
	}
}
