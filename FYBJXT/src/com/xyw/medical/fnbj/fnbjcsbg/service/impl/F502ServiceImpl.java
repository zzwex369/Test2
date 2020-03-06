package com.xyw.medical.fnbj.fnbjcsbg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.fnbjcsbg.dao.F502Dao;
import com.xyw.medical.fnbj.fnbjcsbg.service.F502Service;
import com.xyw.medical.fnbj.model.F502Request;
import com.xyw.medical.fnbj.model.F502Response;

@Transactional
public class F502ServiceImpl implements F502Service{
	@Resource
	private F502Dao f502Dao;

	@Override
	public F502Response saveF502(List<Object []> f502PicArr) {
		return f502Dao.saveF502(f502PicArr);
	}

	@Override
	public F502Response renewF502(F502Request f502Request) {
		return f502Dao.renewF502(f502Request);
	}

	@Override
	public F502Response queryF502(F502Request f502Request) {
		return f502Dao.queryF502(f502Request);
	}

	@Override
	public F502Response deleteF502(F502Request f502Request) {
		return f502Dao.deleteF502(f502Request);
	}

	@Override
	public F502Response getEmptyFile(boolean del) {
		return f502Dao.getEmptyFile(del);
	}

}

