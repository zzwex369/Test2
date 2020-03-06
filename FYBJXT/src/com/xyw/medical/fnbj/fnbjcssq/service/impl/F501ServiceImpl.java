package com.xyw.medical.fnbj.fnbjcssq.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.fnbjcssq.dao.F501Dao;
import com.xyw.medical.fnbj.fnbjcssq.service.F501Service;
import com.xyw.medical.fnbj.model.F501;
import com.xyw.medical.fnbj.model.F501Request;
import com.xyw.medical.fnbj.model.F501Response;

@Transactional
public class F501ServiceImpl implements F501Service{
	@Resource
	private F501Dao f501Dao;

	@Override
	public F501Response saveF501(F501 f501) {
		return f501Dao.saveF501(f501);
	}

	@Override
	public F501Response renewF501(F501 f501) {
		return f501Dao.renewF501(f501);
	}

	@Override
	public F501Response queryF501(F501Request f501Request) {
		return f501Dao.queryF501(f501Request);
	}

	@Override
	public F501Response deleteF501(F501Request f501Request) {
		return f501Dao.deleteF501(f501Request);
	}

}
