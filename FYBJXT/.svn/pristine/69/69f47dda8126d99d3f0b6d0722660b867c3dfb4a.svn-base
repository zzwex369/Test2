package com.xyw.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.sys.dao.SystemParametersDao;
import com.xyw.sys.model.S900;
import com.xyw.sys.model.SystemParametersRequest;
import com.xyw.sys.model.SystemParametersResponse;
import com.xyw.sys.service.SystemParametersService;

@Transactional
public class SystemParametersServiceImpl implements SystemParametersService {
	
	@Resource
	private SystemParametersDao systemParametersDao;
	
	@Override
	public SystemParametersResponse query(
			SystemParametersRequest systemParametersRequest) {
		SystemParametersResponse systemParametersResponse = this.systemParametersDao.queryS900(systemParametersRequest);
		return systemParametersResponse;
	}
	
	@Override
	public SystemParametersResponse save(S900 s900) {
		SystemParametersResponse systemParametersResponse = this.systemParametersDao.saveS900(s900);
		return systemParametersResponse;
	}

	@Override
	public String queryById(String id) {
		String flag = this.systemParametersDao.queryS900ById(id);
		return flag;
	}
	@Override
	public String queryById2(String id) {
		String flag = this.systemParametersDao.queryS900ById(id);
		return flag;
	}
}
