package com.xyw.medical.etbj.etsl.slsf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xyw.medical.etbj.etsl.model.E704;
import com.xyw.medical.etbj.etsl.model.E704Request;
import com.xyw.medical.etbj.etsl.model.E704Response;
import com.xyw.medical.etbj.etsl.slsf.dao.E704Dao;
import com.xyw.medical.etbj.etsl.slsf.service.E704Service;

public class E704ServiceImpl implements E704Service{
	
	@Autowired
	private E704Dao e704Dao;

	@Override
	public E704Response saveE704(E704 e704) {
		E704Response resp;
		try {
			resp = e704Dao.saveE704(e704); 
		} catch (Exception e) {
			e.printStackTrace();
			resp = new E704Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E704Response queryE704(E704Request e704Request) {
		E704Response resp;
		try {
			resp = e704Dao.queryE704(e704Request); 
		} catch (Exception e) {
			e.printStackTrace();
			resp = new E704Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E704Response deleteE704(E704Request e704Request) {
		E704Response resp;
		try {
			resp = e704Dao.deleteE704(e704Request); 
		} catch (Exception e) {
			e.printStackTrace();
			resp = new E704Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E704Response updateE704(E704 e704) {
		E704Response resp;
		try {
			resp = e704Dao.updateE704(e704); 
		} catch (Exception e) {
			e.printStackTrace();
			resp = new E704Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

}
