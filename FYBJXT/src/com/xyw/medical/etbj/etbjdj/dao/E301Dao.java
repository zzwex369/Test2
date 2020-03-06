package com.xyw.medical.etbj.etbjdj.dao;

import com.xyw.medical.etbj.model.E301;
import com.xyw.medical.etbj.model.E301Request;
import com.xyw.medical.etbj.model.E301Response;

public interface E301Dao {
	public E301Response saveE301(E301 e301);
	public E301Response queryE301(E301Request e301Request);
	public E301Response updateE301(E301 e301);
	public E301Response deleteE301(E301Request e301Request);
	public E301Response queryE301All(E301Request e301Request);
}
