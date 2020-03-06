package com.xyw.medical.fnbj.fngwfxpg.dao;

import com.xyw.medical.fnbj.model.F309;
import com.xyw.medical.fnbj.model.F309Request;
import com.xyw.medical.fnbj.model.F309Response;

public interface F309Dao {
	
F309Response saveF309(F309 f309);
	
	F309Response renewF309(F309 f309);
	
	F309Response queryF309(F309Request F309Request);
	
	F309Response deleteF309(F309Request f309Request);
}	
