package com.xyw.medical.birth.certificateRemain.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.certificateRemain.dao.CertificateRemainDao;
import com.xyw.medical.birth.certificateRemain.service.CertificateRemainService;
import com.xyw.medical.birth.model.D504Request;
import com.xyw.medical.birth.model.D504Response;

@Transactional
public class CertificateRemainServiceImpl implements CertificateRemainService{

	@Resource
	private CertificateRemainDao certificateRemainDao;
	
	@Override
	public D504Response query(D504Request d504Request) {
		D504Response d504Response = this.certificateRemainDao.queryD504(d504Request);
		return d504Response;
	}

	@Override
	public D504Response save(D504Request d504Request) {
		D504Response d504Response = this.certificateRemainDao.saveD504(d504Request);
		return d504Response;
	}
	
	@Override
	public D504Response update(D504Request d504Request) {
		D504Response d504Response = this.certificateRemainDao.updateD504(d504Request);
		return d504Response;
	}
	
	@Override
	public D504Response validateRemain(D504Request d504Request) {
		D504Response  d504Response = this.certificateRemainDao.validateRemain(d504Request);
		return d504Response;
	}
}
