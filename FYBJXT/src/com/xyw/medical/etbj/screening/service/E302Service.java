package com.xyw.medical.etbj.screening.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.model.E302;
import com.xyw.medical.etbj.model.E302Request;
import com.xyw.medical.etbj.model.E302Response;

@Transactional
public interface E302Service {
	public E302Response savaE302(E302 e302);
	
	public E302Response renewE302(E302 e302);
	
	public E302Response deleteE302(E302Request e302Request);
	
	public E302Response queryE302(E302Request e302Request); 

}
