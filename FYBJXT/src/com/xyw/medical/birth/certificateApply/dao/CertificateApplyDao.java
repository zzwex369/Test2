package com.xyw.medical.birth.certificateApply.dao;

import com.xyw.medical.birth.model.D501Request;
import com.xyw.medical.birth.model.D501Response;

public interface CertificateApplyDao {
	public D501Response saveD501(D501Request d501Request);
	public D501Response queryD501(D501Request d501Request);
}
