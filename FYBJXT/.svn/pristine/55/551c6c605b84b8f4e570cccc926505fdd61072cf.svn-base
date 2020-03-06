package com.xyw.medical.birth.certificateOutRegist.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.certificateOutRegist.dao.CertificateOutRegistDao;
import com.xyw.medical.birth.certificateOutRegist.service.CertificateOutRegistService;
import com.xyw.medical.birth.model.D503Request;
import com.xyw.medical.birth.model.D503Response;

@Transactional
public class CertificateOutRegistServiceImpl implements
		CertificateOutRegistService {

	@Resource
	private CertificateOutRegistDao certificateOutRegistDao;
	
	@Override
	public D503Response save(D503Request d503Request) {
		D503Response d503Response = this.certificateOutRegistDao.saveD503(d503Request);
		return d503Response;
	}

	@Override
	public D503Response query(D503Request d503Request) {
		D503Response d503Response = this.certificateOutRegistDao.queryD503(d503Request);
		return d503Response;
	}

}
