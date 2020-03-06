package com.xyw.medical.ycfsw.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.ycfsw.dao.YcfswDao;
import com.xyw.medical.ycfsw.model.D604;
import com.xyw.medical.ycfsw.model.D604Response;
import com.xyw.medical.ycfsw.model.D604Request;
import com.xyw.medical.ycfsw.service.YcfswService;

@Transactional
public class YcfswServiceImpl implements YcfswService {
	
	@Resource
	private YcfswDao ycfswDao;

	@Override
	public D604Response saveD604(D604 d604) {
		return this.ycfswDao.saveD604(d604);
	}

	@Override
	public D604Response pagerD604(D604Request d604Request) {
		return this.ycfswDao.pagerD604(d604Request);
	}

	@Override
	public D604Response updateD604(D604Request d604Request) {
		return this.ycfswDao.updateD604(d604Request);
	}

	@Override
	public D604Response deleteD604(D604Request d604Request) {
		return this.ycfswDao.deleteD604(d604Request);
	}
	
	

}
