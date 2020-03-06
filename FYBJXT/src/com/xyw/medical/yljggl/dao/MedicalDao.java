package com.xyw.medical.yljggl.dao;

import com.xyw.medical.yljggl.model.D101Request;
import com.xyw.medical.yljggl.model.D101Response;


public interface MedicalDao {
	public D101Response save(D101Request d101Request);
	public D101Response find(D101Request d101Request);
	public D101Response findById(D101Request d101Request);
	public D101Response update(D101Request d101Request);
	public D101Response delete(D101Request d101Request);
	public D101Response exportExcelData(D101Request d101Request);
}
