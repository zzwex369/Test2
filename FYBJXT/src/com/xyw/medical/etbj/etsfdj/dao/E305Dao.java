package com.xyw.medical.etbj.etsfdj.dao;

import com.xyw.medical.etbj.model.E305;
import com.xyw.medical.etbj.model.E305Request;
import com.xyw.medical.etbj.model.E305Response;

public interface E305Dao {

	E305Response deleteE305(E305Request e305Request);

	E305Response updateE305(E305 e305);

	E305Response queryE305H(E305Request e305Request);

	E305Response queryE305(E305Request e305Request);

	E305Response saveE305(E305 e305);
	
	E305Response queryE305D(E305Request e305Request);
	public E305Response queryE305All(E305Request e305Request);
}
