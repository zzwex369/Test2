package com.xyw.medical.rws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xyw.medical.rws.dao.RwsDao;
import com.xyw.medical.rws.model.Rws;
import com.xyw.medical.rws.model.RwsRequest;
import com.xyw.medical.rws.model.RwsResponse;
import com.xyw.medical.rws.service.RwsService;

public class RwsServiceImpl implements RwsService{
	
	@Autowired
	private RwsDao rwsDao;

	@Override
	public RwsResponse addRws(Rws rws) {
		RwsResponse resp;
		try{
			resp = rwsDao.addRws(rws);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new RwsResponse();
			resp.setState(false);
			resp.setErrorMessage("保存出错,请稍后重试");
		}
		return resp;
	}

	@Override
	public RwsResponse deleteRws(RwsRequest rwsRequest) {
		RwsResponse resp;
		try{
			resp = rwsDao.deleteRws(rwsRequest);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new RwsResponse();
			resp.setState(false);
			resp.setErrorMessage("删除出错,请稍后重试");
		}
		return resp;
	}

	@Override
	public RwsResponse queryRws(RwsRequest rwsRequest) {
		RwsResponse resp;
		try{
			resp = rwsDao.queryRws(rwsRequest);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new RwsResponse();
			resp.setState(false);
			resp.setErrorMessage("查询出错,请稍后重试");
		}
		return resp;
	}

	@Override
	public RwsResponse updateRws(Rws rws) {
		RwsResponse resp;
		try{
			resp = rwsDao.updateRws(rws);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new RwsResponse();
			resp.setState(false);
			resp.setErrorMessage("保存出错,请稍后重试");
		}
		return resp;
	}
	

}
