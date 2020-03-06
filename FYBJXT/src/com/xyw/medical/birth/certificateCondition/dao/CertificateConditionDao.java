package com.xyw.medical.birth.certificateCondition.dao;

import com.xyw.medical.birth.model.CertificateConditionRequest;
import com.xyw.medical.birth.model.CertificateConditionResponse;

public interface CertificateConditionDao {
	
	public CertificateConditionResponse query(CertificateConditionRequest certificateConditionRequest);

	public CertificateConditionResponse queryB(CertificateConditionRequest certificateConditionRequest);

	public CertificateConditionResponse queryC(CertificateConditionRequest certificateConditionRequest);
	
	public CertificateConditionResponse queryE(CertificateConditionRequest certificateConditionRequest);
	
	public CertificateConditionResponse queryF(CertificateConditionRequest certificateConditionRequest);
}
