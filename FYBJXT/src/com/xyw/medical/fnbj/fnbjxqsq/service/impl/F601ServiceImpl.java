package com.xyw.medical.fnbj.fnbjxqsq.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.fnbjxqsq.dao.F601Dao;
import com.xyw.medical.fnbj.fnbjxqsq.service.F601Service;
import com.xyw.medical.fnbj.model.F601;
import com.xyw.medical.fnbj.model.F601Request;
import com.xyw.medical.fnbj.model.F601Response;

@Transactional
public class F601ServiceImpl implements F601Service{
	@Resource
	private F601Dao f601Dao;

	@Override
	public F601Response saveF601(F601 f601) {
		return f601Dao.saveF601(f601);
	}

	@Override
	public F601Response renewF601(F601 f601) {
		return f601Dao.renewF601(f601);
	}

	@Override
	public F601Response queryF601(F601Request f601Request) {
		return f601Dao.queryF601(f601Request);
	}

	@Override
	public F601Response deleteF601(F601Request f601Request) {
		return f601Dao.deleteF601(f601Request);
	}

	@Override
	public F601Response renewF601(F601Request f601Request) {
		
		return f601Dao.renewF601(f601Request);
	}

	@Override
	public F601Response queryF601Excel(F601Request f601Request) {
		
		return f601Dao.queryF601Excel(f601Request);
	}

	@Override
	public F601Response queryByF60155(String f60155) {
		
		return f601Dao.queryByF60155(f60155);
	}

	@Override
	public F601Response queryRevocationF601(F601Request f601Request) {
		
		return f601Dao.queryRevocationF601(f601Request);
	}
	
	/**
	 * 以前的查询方法无法多次重用
	 */
	@Override
	public F601Response queryF601_(F601Request f601Request) {
		return f601Dao.queryF601_(f601Request);
	}

}
