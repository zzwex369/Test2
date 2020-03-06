package com.xyw.medical.birth.certificate.dao;

import com.xyw.medical.birth.model.D301;
import com.xyw.medical.birth.model.D303;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;
import com.xyw.medical.birth.model.VD505;

public interface BirthCertificateDao {
	public QueryBirthResponse saveBirthCertificate(D301 d301);
	
	public QueryBirthResponse validateBirth(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse reissueBirthCertificate(D303 d303);
	
	public QueryBirthResponse renewBirthCertificate(D301 d301);
	
	public boolean validateSaveBirthCertiticate(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse queryBirthCertificate(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse queryBirthCertificatehf(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse queryBirthCertificatebf(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse validateStockCertiticate(QueryBirthRequest queryBirthRequest);
	
	public VD505 queryBirthInstitution(VD505 v505);
	
	public boolean del(String d30110);
	
	public boolean isUsed(long d30401,long d60101);
	
}
