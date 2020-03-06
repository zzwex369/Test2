package com.xyw.medical.birth.childDeathReport.dao;

import com.xyw.medical.birth.model.D605;
import com.xyw.medical.birth.model.D605Request;
import com.xyw.medical.birth.model.D605Response;
import com.xyw.medical.birth.model.QueryChildRequest;
import com.xyw.medical.birth.model.QueryChildResponse;
public interface ChildDeathReportDao {
	public D605Response saveD605(D605Request d605Request);

	public QueryChildResponse queryD605(QueryChildRequest queryChildRequest);
	
	public QueryChildResponse renewD605Handler(D605 d605);
	
	public QueryChildResponse deleteD605(QueryChildRequest queryChildRequest);
}
