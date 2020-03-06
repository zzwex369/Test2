package com.xyw.medical.yljggl.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.yljggl.dao.MedicalDao;
import com.xyw.medical.yljggl.model.D101Request;
import com.xyw.medical.yljggl.model.D101Response;
import com.xyw.medical.yljggl.service.MedicalService;

@Transactional
public class MedicalServiceImpl implements MedicalService {

	@Resource
	private MedicalDao medicalDao;
	
	@Override
	public D101Response add(D101Request d101Request) {
		D101Response d101Response = medicalDao.save(d101Request);
		return d101Response;
	}

	@Override
	public D101Response query(D101Request d101Request) {
		D101Response d101Response = medicalDao.find(d101Request);
		return d101Response;
	}

	@Override
	public D101Response load(D101Request d101Request) {
		D101Response d101Response = medicalDao.findById(d101Request);
		return d101Response;
	}

	@Override
	public D101Response modify(D101Request d101Request) {
		D101Response d101Response = medicalDao.update(d101Request);
		return d101Response;
	}

	@Override
	public D101Response remove(D101Request d101Request) {
		D101Response d101Response = medicalDao.delete(d101Request);
		return d101Response;
	}

	@Override
	public D101Response export(D101Request d101Request) {
		D101Response d101Response = medicalDao.exportExcelData(d101Request);
		return d101Response;
	}

}
