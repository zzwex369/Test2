package com.xyw.medical.birth.certificateDJB.service;

import com.xyw.medical.birth.model.D305;
import com.xyw.medical.birth.model.D305Request;
import com.xyw.medical.birth.model.D305Response;

public interface ReissueBirthCertificateDJBService {

	public D305Response saveReissueBirthCertificateDJB(D305Request d305Request);
	
	public D305Response queryBirthCertificateDJB(D305Request d305Request);
	
    public D305Response updateD305(D305 d305);
	
	public D305Response deleteD305(D305Request d305Request);
}
