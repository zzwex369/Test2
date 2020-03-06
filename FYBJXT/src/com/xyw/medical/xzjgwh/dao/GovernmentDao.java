package com.xyw.medical.xzjgwh.dao;

import com.xyw.medical.birth.model.D402Request;
import com.xyw.medical.birth.model.D402Response;
import com.xyw.medical.xzjgwh.model.D201Request;
import com.xyw.medical.xzjgwh.model.D201Response;

public interface GovernmentDao {
	public D201Response save(D201Request d201Request);
	public D201Response find(D201Request d201Request);
	public D201Response findById(D201Request d201Request);
	public D201Response update(D201Request d201Request);
	public D201Response del(D201Request d201Request);
	
	public D402Response save2(D402Request d402Request);
	public D402Response find2(D402Request d402Request);
	public D402Response update2(D402Request d402Request);
	public D402Response chuliuupdate2(D402Request d402Request);
}
