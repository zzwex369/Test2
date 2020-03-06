package com.xyw.medical.birth.jgwsfsqb.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.birth.model.D307;
import com.xyw.medical.birth.model.D307Request;
import com.xyw.medical.birth.model.D307Response;

@Transactional
public interface D307Service {
	public D307Response saveD307(D307 d307);
	
	public D307Response updateD307(D307 d307);
	
	public D307Response queryVD307(D307Request d307Request);
	
	public D307Response deleteD307(D307Request d307Request);

}
