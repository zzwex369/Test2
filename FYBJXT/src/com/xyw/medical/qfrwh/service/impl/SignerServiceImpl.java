package com.xyw.medical.qfrwh.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.qfrwh.dao.SignerDao;
import com.xyw.medical.qfrwh.model.S301_10Reponse;
import com.xyw.medical.qfrwh.model.S301_10Request;
import com.xyw.medical.qfrwh.service.SignerService;

@Transactional
public class SignerServiceImpl implements SignerService {
	@Resource
	private SignerDao SignerDao;

	@Override
	public S301_10Reponse save(S301_10Request s301_10Request) {
		S301_10Reponse s301_10Reponse = SignerDao.save(s301_10Request);
		return s301_10Reponse;
	}

	@Override
	public S301_10Reponse find(S301_10Request s301_10Request) {
		S301_10Reponse s301_10Reponse = SignerDao.find(s301_10Request);
		return s301_10Reponse;
	}

	@Override
	public S301_10Reponse update(S301_10Request s301_10Request) {
		S301_10Reponse s301_10Reponse = SignerDao.update(s301_10Request);
		return s301_10Reponse;
	}

	@Override
	public S301_10Reponse del(S301_10Request s301_10Request) {
		S301_10Reponse s301_10Reponse = SignerDao.del(s301_10Request);
		return s301_10Reponse;
	}

}
