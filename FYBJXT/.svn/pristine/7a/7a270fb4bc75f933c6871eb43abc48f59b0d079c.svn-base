package com.xyw.medical.fnbj.fnjc.service.impl;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import com.xyw.medical.fnbj.fnjc.dao.MaternalCheckDao;
import com.xyw.medical.fnbj.fnjc.service.MaternalCheckService;
import com.xyw.medical.fnbj.model.F303;
import com.xyw.medical.fnbj.model.F303Request;
import com.xyw.medical.fnbj.model.F303Response;
@Transactional
public class MaternalCheckServiceImpl implements MaternalCheckService{

	@Resource
	private MaternalCheckDao maternalCheckDao;
	@Override
	public F303Response saveF303(F303 f303) {
		F303Response f303Response = this.maternalCheckDao.saveF303(f303);
		return f303Response;
	}
	@Override
	public F303Response queryF303(F303Request f303Request) {
		F303Response f303Response = this.maternalCheckDao.queryF303(f303Request);
		return f303Response;
	}
	@Override
	public F303Response updateF303(F303 f303) {
		F303Response f303Response = this.maternalCheckDao.updateF303(f303);
		return f303Response;
	}
	@Override
	public F303Response deleteF303(F303Request f303Request) {
		F303Response f303Response = this.maternalCheckDao.deleteF303(f303Request);
		return f303Response;
	}
}
