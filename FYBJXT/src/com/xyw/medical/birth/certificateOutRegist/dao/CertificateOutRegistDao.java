package com.xyw.medical.birth.certificateOutRegist.dao;

import com.xyw.medical.birth.model.D503Request;
import com.xyw.medical.birth.model.D503Response;

public interface CertificateOutRegistDao {
	public D503Response saveD503(D503Request d503Request);
	public D503Response queryD503(D503Request d503Request);
}
