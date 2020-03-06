package com.xyw.medical.fnbj.fnbjcssq.dao;

import com.xyw.medical.fnbj.model.F501;
import com.xyw.medical.fnbj.model.F501Request;
import com.xyw.medical.fnbj.model.F501Response;

public interface F501Dao {
	public F501Response saveF501(F501 f501);
	
	public F501Response renewF501(F501 f501);
	
	public F501Response queryF501(F501Request f501Request);
	
	public F501Response deleteF501(F501Request f501Request);

}
