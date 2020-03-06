package com.xyw.medical.birth.certificateRemain.dao;

import com.xyw.medical.birth.model.D504Request;
import com.xyw.medical.birth.model.D504Response;

public interface CertificateRemainDao {
	public D504Response queryD504(D504Request d504Request);
	public D504Response saveD504(D504Request d504Request);
	public D504Response updateD504(D504Request d504Request);
	public D504Response validateRemain(D504Request d504Request);
}
