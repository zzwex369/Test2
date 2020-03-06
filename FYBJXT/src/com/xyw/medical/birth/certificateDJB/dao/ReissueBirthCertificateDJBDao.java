package com.xyw.medical.birth.certificateDJB.dao;

import com.xyw.medical.birth.model.D305;
import com.xyw.medical.birth.model.D305Request;
import com.xyw.medical.birth.model.D305Response;

public interface ReissueBirthCertificateDJBDao {

	public D305Response saveD305(D305Request d305Request);
	
	public D305Response queryD305(D305Request d305Request);
	
	public D305Response updateD305(D305 d305);
	
	public D305Response deleteD305(D305Request d305Request);
	
}
