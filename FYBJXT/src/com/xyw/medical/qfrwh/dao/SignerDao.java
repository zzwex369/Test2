package com.xyw.medical.qfrwh.dao;

import com.xyw.medical.qfrwh.model.S301_10Reponse;
import com.xyw.medical.qfrwh.model.S301_10Request;


public interface SignerDao {
	public S301_10Reponse save(S301_10Request s301_10Request);
	public S301_10Reponse find(S301_10Request s301_10Request);
	public S301_10Reponse update(S301_10Request s301_10Request);
	public S301_10Reponse del(S301_10Request s301_10Request);
}
