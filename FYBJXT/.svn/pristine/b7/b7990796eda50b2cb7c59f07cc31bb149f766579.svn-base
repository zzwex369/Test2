package com.xyw.medical.birth.certificate.service;

import com.xyw.medical.birth.model.D301;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;

public interface BirthCertificateService {
	public QueryBirthResponse saveBirthCertificate(D301 d301);
	
	public QueryBirthResponse validateBirth(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse reissueBirthCertificate(D301 d301);
	
	public QueryBirthResponse renewBirthCertificate(D301 d301);
	
	public QueryBirthResponse outsideBirthCertificate(D301 d301);
	
	public QueryBirthResponse validateSaveBirthCertiticate(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse queryBirthCertificate(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse queryBirthCertificatehf(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse queryBirthCertificatebf(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse gaQueryBirthCertificate(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse validateStockCertiticate(QueryBirthRequest queryBirthRequest);

	public boolean isUsed(long d30401,long d60101);
}
