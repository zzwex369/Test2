package com.xyw.medical.birth.hfsqb.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.model.D306;
import com.xyw.medical.birth.model.D306Request;
import com.xyw.medical.birth.model.D306Response;

@Transactional
public interface D306Service {

	public D306Response saveD306(D306 d306);
	
	public D306Response updateD306(D306 d306);
	
	public D306Response queryVD306(D306Request d306Request);
	
	public D306Response queryVD306_new(D306Request d306Request);
	
	public D306Response queryVD306s(D306Request d306Request);
	
	public D306Response queryVD306s_new(D306Request d306Request);
	
	public D306Response deleteD306(D306Request d306Request);
}

