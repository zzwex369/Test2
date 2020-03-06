package com.xyw.ws.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.ws.dao.CsyxzmDao;
import com.xyw.ws.model.Fp;
import com.xyw.ws.model.FpResponse;
import com.xyw.ws.service.CsyxzmService;

@Transactional
public class CsyxzmServiceImpl implements CsyxzmService {

	@Resource
	private CsyxzmDao csyxzmDao;
	
	@Override
	public FpResponse csyxzmFp(Fp fp) {
		return csyxzmDao.fp(fp);
	}

}
