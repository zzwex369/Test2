package com.xyw.medical.birth.certificateOutRegist.service;

import com.xyw.medical.birth.model.D503Request;
import com.xyw.medical.birth.model.D503Response;

public interface CertificateOutRegistService {
	public D503Response save(D503Request d503Request);
	public D503Response query(D503Request d503Request);
}
