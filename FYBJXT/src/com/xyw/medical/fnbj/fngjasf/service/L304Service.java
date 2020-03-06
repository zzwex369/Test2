package com.xyw.medical.fnbj.fngjasf.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.L304;
import com.xyw.medical.fnbj.model.L304Response;
@Transactional
public interface L304Service {
	 L304Response saveL304(L304 l304);
	
}
