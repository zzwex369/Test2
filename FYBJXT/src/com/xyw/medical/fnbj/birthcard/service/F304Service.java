package com.xyw.medical.fnbj.birthcard.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.F304;
import com.xyw.medical.fnbj.model.F304Request;
import com.xyw.medical.fnbj.model.F304Response;

@Transactional
public interface F304Service {
    public F304Response saveF304(F304 f304);
	
	public F304Response renewF304(F304 f304);
	
	public F304Response queryF304(F304Request f304Request);
	
	public F304Response deleteF304(F304Request f304Request);

}
