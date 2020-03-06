package com.xyw.medical.etbj.etsl.slda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xyw.medical.etbj.etsl.model.E701;
import com.xyw.medical.etbj.etsl.model.E701Request;
import com.xyw.medical.etbj.etsl.model.E701Response;
import com.xyw.medical.etbj.etsl.slda.dao.E701Dao;
import com.xyw.medical.etbj.etsl.slda.service.E701Service;


public class E701ServiceImpl implements E701Service{

	@Autowired
	E701Dao e701Dao;
	
	@Override
	public E701Response saveE701(E701 e701) {
		E701Response resp;
		try{
			resp = e701Dao.saveE701(e701);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new E701Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E701Response queryE701(E701Request e701Request) {
		E701Response resp;
		try{
			resp = e701Dao.queryE701(e701Request);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new E701Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E701Response updateE701(E701 e701) {
		E701Response resp;
		try{
			resp = e701Dao.updateE701(e701);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new E701Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}

	@Override
	public E701Response deleteE701(E701Request e701Request) {
		E701Response resp;
		try{
			resp = e701Dao.deleteE701(e701Request);
		}catch (Exception e) {
			e.printStackTrace();
			resp = new E701Response();
			resp.setFalg(false);
			resp.setState(2);
		}
		return resp;
	}
	
	
}
