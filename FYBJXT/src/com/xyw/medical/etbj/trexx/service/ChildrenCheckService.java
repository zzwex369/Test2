package com.xyw.medical.etbj.trexx.service;

import com.xyw.medical.etbj.model.E303;
import com.xyw.medical.etbj.model.E303Request;
import com.xyw.medical.etbj.model.E303Response;


public interface ChildrenCheckService{

	public E303Response saveE303(E303 e303);
	public E303Response queryE303(E303Request e303Request);
	public E303Response updateE303(E303 e303);
	public E303Response deleteE303(E303Request e303Request);
	
}
