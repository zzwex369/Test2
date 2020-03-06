package com.xyw.medical.fnbj.fnlasz.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.L305;
import com.xyw.medical.fnbj.model.L305Request;
import com.xyw.medical.fnbj.model.L305Response;
@Transactional
public interface L305Service {
	 L305Response saveL305(L305 f305);
}
