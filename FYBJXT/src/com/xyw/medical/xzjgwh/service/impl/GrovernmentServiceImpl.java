package com.xyw.medical.xzjgwh.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.model.D402Request;
import com.xyw.medical.birth.model.D402Response;
import com.xyw.medical.xzjgwh.dao.GovernmentDao;
import com.xyw.medical.xzjgwh.model.D201Request;
import com.xyw.medical.xzjgwh.model.D201Response;
import com.xyw.medical.xzjgwh.service.GovernmentService;

@Transactional
public class GrovernmentServiceImpl implements GovernmentService {
	
	@Resource
	private GovernmentDao governmentDao;
	
	@Override
	public D201Response add(D201Request d201Request) {
		D201Response d201Response = governmentDao.save(d201Request);
		return d201Response;
	}

	public D201Response query(D201Request d201Request) {
		D201Response d201Response = governmentDao.find(d201Request);
		return d201Response;
	}

	@Override
	public D201Response load(D201Request d201Request) {
		D201Response d201Response = governmentDao.findById(d201Request);
		return d201Response;
	}

	@Override
	public D201Response modify(D201Request d201Request) {
		D201Response d201Response = governmentDao.update(d201Request);
		return d201Response;
	}

	@Override
	public D201Response remove(D201Request d201Request) {
		D201Response d201Response = governmentDao.del(d201Request);
		return d201Response;
	}

	@Override
	public D402Response saveD402(D402Request d402Request) {
		D402Response d402Response = this.governmentDao.save2(d402Request);
		return d402Response;
	}

	@Override
	public D402Response queryD402(D402Request d402Request) {
		D402Response d402Response = this.governmentDao.find2(d402Request);
		return d402Response;
	}

	@Override
	public D402Response updateD402(D402Request d402Request) {
		D402Response d402Response = this.governmentDao.update2(d402Request);
		return d402Response;
	}
	@Override
	public D402Response chuliupdateD402(D402Request d402Request) {
		D402Response d402Response = this.governmentDao.chuliuupdate2(d402Request);
		return d402Response;
	}

}
