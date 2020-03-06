package com.xyw.medical.etbj.etsl.slzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xyw.medical.etbj.etsl.model.E703;
import com.xyw.medical.etbj.etsl.model.E703Request;
import com.xyw.medical.etbj.etsl.model.E703Response;
import com.xyw.medical.etbj.etsl.slzz.dao.E703Dao;
import com.xyw.medical.etbj.etsl.slzz.service.E703Service;

public class E703ServiceImpl implements E703Service{

	@Autowired
	E703Dao e703Dao;
	
	@Override
	public E703Response saveE703(E703Request e703Request) {
		E703Response resp;
		try{
			resp = e703Dao.saveE703(e703Request);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new E703Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E703Response deleteE703(E703Request e703Request) {
		E703Response resp;
		try{
			resp = e703Dao.deleteE703(e703Request);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new E703Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E703Response queryE703(E703Request e703Request) {
		E703Response resp;
		try{
			resp = e703Dao.queryE703(e703Request);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new E703Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E703Response updateE703(E703 e703) {
		E703Response resp;
		try{
			resp = e703Dao.updateE703(e703);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new E703Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}
	

}
