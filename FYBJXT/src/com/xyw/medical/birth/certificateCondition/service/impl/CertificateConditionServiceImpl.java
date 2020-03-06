package com.xyw.medical.birth.certificateCondition.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.certificateCondition.dao.CertificateConditionDao;
import com.xyw.medical.birth.certificateCondition.service.CertificateConditionService;
import com.xyw.medical.birth.model.CertificateConditionRequest;
import com.xyw.medical.birth.model.CertificateConditionResponse;

@Transactional
public class CertificateConditionServiceImpl implements CertificateConditionService {

	@Resource
	private CertificateConditionDao certificateConditionDao;

	@Override
	public CertificateConditionResponse query(CertificateConditionRequest certificateConditionRequest) {
		return this.certificateConditionDao.query(certificateConditionRequest);
	}

	@Override
	public CertificateConditionResponse queryA(CertificateConditionRequest certificateConditionRequest) {
		return this.certificateConditionDao.query(certificateConditionRequest);
	}

	@Override
	public CertificateConditionResponse queryB(CertificateConditionRequest certificateConditionRequest) {
		return this.certificateConditionDao.queryB(certificateConditionRequest);
	}

	@Override
	public CertificateConditionResponse queryC(CertificateConditionRequest certificateConditionRequest) {
		return this.certificateConditionDao.queryC(certificateConditionRequest);
	}

	@Override
	public CertificateConditionResponse queryD(CertificateConditionRequest certificateConditionRequest) {
		return this.certificateConditionDao.queryC(certificateConditionRequest);
	}
	
	@Override
	public CertificateConditionResponse queryE(CertificateConditionRequest certificateConditionRequest) {
		return this.certificateConditionDao.queryE(certificateConditionRequest);
	}

	@Override
	public CertificateConditionResponse queryF(CertificateConditionRequest certificateConditionRequest) {
		return this.certificateConditionDao.queryF(certificateConditionRequest);
	}

}
