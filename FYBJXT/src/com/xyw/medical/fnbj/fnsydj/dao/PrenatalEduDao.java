package com.xyw.medical.fnbj.fnsydj.dao;

import com.xyw.medical.fnbj.model.F306;
import com.xyw.medical.fnbj.model.F306Request;
import com.xyw.medical.fnbj.model.F306Response;

public interface PrenatalEduDao {

	public F306Response queryF306(F306Request f306Request);

	public F306Response saveF306(F306 f306);

	public F306Response queryVF306(F306Request f306Request);

	public F306Response updateF306(F306 f306);

	public F306Response deleteF306(F306Request f306Request);


}
