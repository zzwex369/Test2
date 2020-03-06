package com.xyw.medical.fnbj.fngwfxpg.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.F309;
import com.xyw.medical.fnbj.model.F309Request;
import com.xyw.medical.fnbj.model.F309Response;
@Transactional
public interface F309Service {
	
	F309Response saveF309(F309 f309);
	
	F309Response renewF309(F309 f309);
	
	F309Response queryF309(F309Request F309Request);
	
	F309Response deleteF309(F309Request f309Request);
}
