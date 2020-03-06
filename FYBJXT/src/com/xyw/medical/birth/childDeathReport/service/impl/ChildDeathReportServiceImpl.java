package com.xyw.medical.birth.childDeathReport.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.childDeathReport.dao.ChildDeathReportDao;
import com.xyw.medical.birth.childDeathReport.service.ChildDeathReportService;
import com.xyw.medical.birth.model.D605;
import com.xyw.medical.birth.model.D605Request;
import com.xyw.medical.birth.model.D605Response;
import com.xyw.medical.birth.model.QueryChildRequest;
import com.xyw.medical.birth.model.QueryChildResponse;

@Transactional
public class ChildDeathReportServiceImpl implements ChildDeathReportService {
	@Resource
	private ChildDeathReportDao  childDeathReportDao;
	@Override
	public D605Response saveD605(D605Request d605Request) {
		D605Response d605Response =this.childDeathReportDao.saveD605(d605Request);
		return d605Response;
	}
	@Override
	public QueryChildResponse queryD605(QueryChildRequest queryChildRequest) {
		QueryChildResponse queryChildResponse=this.childDeathReportDao.queryD605(queryChildRequest);
		return queryChildResponse;
	}
	@Override
	public QueryChildResponse renewD605Handler(D605 d605) {
		QueryChildResponse queryChildResponse=this.childDeathReportDao.renewD605Handler(d605);
		return queryChildResponse;
	}
	@Override
	public QueryChildResponse deleteD605(QueryChildRequest queryChildRequest) {
		QueryChildResponse queryChildResponse=this.childDeathReportDao.deleteD605(queryChildRequest);
		return queryChildResponse;
	}
	
}
