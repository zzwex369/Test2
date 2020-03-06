package com.xyw.medical.birth.csqxr.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.csqxr.dao.CsqxrDao;
import com.xyw.medical.birth.csqxr.model.D606;
import com.xyw.medical.birth.csqxr.model.D606Request;
import com.xyw.medical.birth.csqxr.model.D606Response;
import com.xyw.medical.birth.csqxr.service.CsqxrService;

@Transactional
public class CsqxrServiceImpl implements CsqxrService {
	
	@Resource
	private CsqxrDao csqxrDao;

	@Override
	public D606Response saveD606(D606 d606) {
		return this.csqxrDao.saveD606(d606);
	}

	@Override
	public D606Response pagerD606(D606Request d606Request) {
		return this.csqxrDao.pagerD606(d606Request);
	}

	@Override
	public D606Response updateD606(D606 d606) {
		return this.csqxrDao.updateD606(d606);
	}

	@Override
	public D606Response deleteD606(D606Request d606Request) {
		return this.csqxrDao.deleteD606(d606Request);
	}

}
