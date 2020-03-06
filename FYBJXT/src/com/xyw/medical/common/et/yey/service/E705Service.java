package com.xyw.medical.common.et.yey.service;

import com.xyw.medical.common.et.yey.model.E705Request;
import com.xyw.medical.common.et.yey.model.E705Response;

public interface E705Service {
	E705Response saveE705(E705Request e705Request);
	
	E705Response renewE705(E705Request e705Request);
	
	E705Response deleteE705(E705Request e705Request);

	E705Response queryE705(E705Request e705Request);

	

}
