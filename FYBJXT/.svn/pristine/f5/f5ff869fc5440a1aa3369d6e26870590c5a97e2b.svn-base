package com.xyw.medical.etbj.trexx.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


import com.xyw.medical.etbj.model.E303;
import com.xyw.medical.etbj.model.E303Request;
import com.xyw.medical.etbj.model.E303Response;
import com.xyw.medical.etbj.trexx.dao.ChildrenCheckDao;
import com.xyw.medical.etbj.trexx.service.ChildrenCheckService;


@Transactional
public class ChildrenCheckServiceImpl implements ChildrenCheckService{
	@Resource
	private ChildrenCheckDao childrenCheckDao;
	@Override
	public  E303Response saveE303(E303 e303) {
		E303Response e303Response = childrenCheckDao.saveE303(e303);
		return e303Response;
	}
	@Override
	public E303Response queryE303(E303Request e303Request) {
		E303Response e303Response = this.childrenCheckDao.queryE303(e303Request);
		return e303Response;
	}
	@Override
	public E303Response updateE303(E303 e303) {
		return this.childrenCheckDao.updateE303(e303);
	}
	@Override
	public E303Response deleteE303(E303Request e303Request) {
		return this.childrenCheckDao.deleteE303(e303Request);
	}
}
