package com.xyw.medical.birth.qzjd.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.model.D607;
import com.xyw.medical.birth.model.D607Request;
import com.xyw.medical.birth.model.D607Response;
import com.xyw.medical.birth.qzjd.dao.D607Dao;
import com.xyw.medical.birth.qzjd.service.D607Service;
@Transactional
public class D607ServiceImpl implements D607Service {

	@Resource
	private D607Dao d607Dao;
	@Override
	public D607Response saveD607(D607 d607) {
		return this.d607Dao.saveD607(d607);
	}

	@Override
	public D607Response queryD607(D607Request d607Request) {
		
		return this.d607Dao.queryD607(d607Request);
	}

	@Override
	public D607Response updateD607New(D607 d607) {
		
		return this.d607Dao.updateD607New(d607);
	}

	@Override
	public D607Response deleteD607(D607Request d607Request) {
	
		return this.d607Dao.deleteD607(d607Request);
	}
   
}
