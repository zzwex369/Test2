package com.xyw.medical.fnbj.fnbjdj.dao;

import com.xyw.medical.fnbj.model.F301;
import com.xyw.medical.fnbj.model.F301Request;
import com.xyw.medical.fnbj.model.F301Response;

public interface F301Dao {
	public F301Response saveF301(F301 f301);
	
	public F301Response renewF301(F301 f301);
	
	public F301Response queryF301(F301Request f301Request);
	
	public F301Response deleteF301(F301Request f301Request);
	
	public F301Response updateMate(F301 f301);
	
	F301Response _renewF301(F301 f301);

}
