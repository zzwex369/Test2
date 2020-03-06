package com.xyw.medical.fnbj.fnbjxqbg.service.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.fnbjxqbg.dao.F602Dao;
import com.xyw.medical.fnbj.fnbjxqbg.service.F602Service;
import com.xyw.medical.fnbj.model.F602;
import com.xyw.medical.fnbj.model.F602Request;
import com.xyw.medical.fnbj.model.F602Response;

@Transactional
public class F602ServiceImpl implements F602Service{
	@Resource
	private F602Dao f602Dao;

	@Override
	public F602Response saveF602(F602 f602) {
		return f602Dao.saveF602(f602);
	}

	@Override
	public F602Response renewF602(F602 f602) {
		return f602Dao.renewF602(f602);
	}

	@Override
	public F602Response queryF602(F602Request f602Request) {
		return f602Dao.queryF602(f602Request);
	}

	@Override
	public F602Response deleteF602(F602Request f602Request) {
		return f602Dao.deleteF602(f602Request);
	}

	@Override
	public F602Response renewF602(F602Request f602Request) {
		return f602Dao.renewF602(f602Request);
	}

	@Override
	public F602Response queryF602Id(String f60202,Session session) {
		return f602Dao.queryF602Id(f60202,session);
	}

	@Override
	public F602Response importF602Excel(F602Request f602Request) {
		// TODO Auto-generated method stub
		return f602Dao.importF602Excel(f602Request);
	}

	

}
