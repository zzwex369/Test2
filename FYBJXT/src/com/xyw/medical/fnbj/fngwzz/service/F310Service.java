package com.xyw.medical.fnbj.fngwzz.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.F310;
import com.xyw.medical.fnbj.model.F310Request;
import com.xyw.medical.fnbj.model.F310Response;
@Transactional
public interface F310Service {
	
	F310Response saveF310(F310 f310);
	
	F310Response renewF310(F310 f310);
	
	F310Response queryF310(F310Request F310Request);
	
	F310Response deleteF310(F310Request f310Request);
}
