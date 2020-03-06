package com.xyw.medical.ycfsw.dao;

import com.xyw.medical.ycfsw.model.D604;
import com.xyw.medical.ycfsw.model.D604Response;
import com.xyw.medical.ycfsw.model.D604Request;


public interface YcfswDao {
	public D604Response saveD604(D604 d604);
	public D604Response pagerD604(D604Request d604Request);
	public D604Response updateD604(D604Request d604Request);
	public D604Response deleteD604(D604Request d604Request);
    
}
