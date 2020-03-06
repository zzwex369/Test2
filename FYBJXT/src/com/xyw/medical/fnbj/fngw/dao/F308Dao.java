package com.xyw.medical.fnbj.fngw.dao;

import com.xyw.medical.fnbj.model.F308;
import com.xyw.medical.fnbj.model.F308Request;
import com.xyw.medical.fnbj.model.F308Response;

public interface F308Dao {
	F308Response saveF308(F308 f308);
	
	F308Response renewF308(F308 f308);
	
	F308Response queryF308(F308Request f308Request);
	
	F308Response deleteF308(F308Request f308Request);
	
	F308Response queryByF301Id(long f301_id);
}
