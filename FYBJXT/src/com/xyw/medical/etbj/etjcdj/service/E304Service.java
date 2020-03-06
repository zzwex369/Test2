package com.xyw.medical.etbj.etjcdj.service;

import com.xyw.medical.etbj.model.E304;
import com.xyw.medical.etbj.model.E304Request;
import com.xyw.medical.etbj.model.E304Response;


public interface E304Service {
	public E304Response saveE304(E304 e304);
	public E304Response queryE304(E304Request e304Request);
	public E304Response queryE304H(E304Request e304Request);
	public E304Response updateE304(E304 e304);
	public E304Response deleteE304(E304Request e304Request);
	public E304Response queryE304D(E304Request e304Request);
	public E304Response queryE304All(E304Request e304Request);
	E304Response queryPhasesE304(E304Request e304Request);
}
