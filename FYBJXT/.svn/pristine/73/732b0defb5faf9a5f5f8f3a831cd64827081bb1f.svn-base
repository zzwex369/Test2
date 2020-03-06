package com.xyw.medical.fnbj.fnbjcqzd.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.fnbjcqzd.dao.F605Dao;
import com.xyw.medical.fnbj.fnbjcqzd.service.F605Service;
import com.xyw.medical.fnbj.model.F605;
import com.xyw.medical.fnbj.model.F605Request;
import com.xyw.medical.fnbj.model.F605Response;

@Transactional
@Service("f605Service")
@Scope("prototype")
public class F605ServiceImpl implements F605Service{
	@Resource
	private F605Dao f605Dao;

	@Override
	public F605Response saveF605(F605 f605) {
		return f605Dao.saveF605(f605);
	}

	@Override
	public F605Response renewF605(F605 f605) {
		return f605Dao.renewF605(f605);
	}

	@Override
	public F605Response queryF605(F605Request f605Request) {
		return f605Dao.queryF605(f605Request);
	}

	@Override
	public F605Response deleteF605(F605Request f605Request) {
		return f605Dao.deleteF605(f605Request);
	}

	@Override
	public F605Response getF605(String f60501) {
		return f605Dao.getF605(f60501);
	}


	

}
