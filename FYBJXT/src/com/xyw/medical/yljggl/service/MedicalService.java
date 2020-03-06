package com.xyw.medical.yljggl.service;

import com.xyw.medical.yljggl.model.D101Request;
import com.xyw.medical.yljggl.model.D101Response;

public interface MedicalService {
	public D101Response add(D101Request d101Request);
	public D101Response query(D101Request d101Request);
	public D101Response load(D101Request d101Request);
	public D101Response modify(D101Request d101Request);
	public D101Response remove(D101Request d101Request);
	public D101Response export(D101Request d101Request);
}
