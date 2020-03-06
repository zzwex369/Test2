package com.xyw.medical.fnbj.fnrxada.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.L401Request;
import com.xyw.medical.fnbj.model.L401Response;


@Transactional
public interface L401Service {
	
	 L401Response saveL401(L401Request l401Request);
	 L401Response delL401(L401Request l401Request);
	 L401Response renewL401(L401Request l401Request);
	 L401Response queryL401(L401Request l401Request);
	
	

}
