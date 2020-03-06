package com.xyw.medical.fnbj.fnbjhqtj.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.F401;
import com.xyw.medical.fnbj.model.F401Request;
import com.xyw.medical.fnbj.model.F401Response;

@Transactional
public interface F401Service {
    public F401Response saveF401(F401 f401);
	
	public F401Response renewF401(F401 f401);
	
	public F401Response queryF401(F401Request f401Request);
	
	public F401Response deleteF401(F401Request f401Request);

}
