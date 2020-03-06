package com.xyw.medical.xzjgwh.service;

import com.xyw.medical.birth.model.D402Request;
import com.xyw.medical.birth.model.D402Response;
import com.xyw.medical.xzjgwh.model.D201Request;
import com.xyw.medical.xzjgwh.model.D201Response;

public interface GovernmentService {
	public D201Response add(D201Request d201Request);
	public D201Response query(D201Request d201Request);
	public D201Response load(D201Request d201Request);
	public D201Response modify(D201Request d201Request);
	public D201Response remove(D201Request d201Request);
	
	public D402Response saveD402(D402Request d402Request);
	public D402Response queryD402(D402Request d402Request);
	public D402Response updateD402(D402Request d402Request);
	public D402Response chuliupdateD402(D402Request d402Request);
}
