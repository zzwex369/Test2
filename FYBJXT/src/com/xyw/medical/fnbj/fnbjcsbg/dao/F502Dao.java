package com.xyw.medical.fnbj.fnbjcsbg.dao;

import java.util.List;

import com.xyw.medical.fnbj.model.F502Request;
import com.xyw.medical.fnbj.model.F502Response;

public interface F502Dao {
	public F502Response saveF502(List<Object []> f502PicArr);
	
	public F502Response renewF502(F502Request f502Request);
	
	public F502Response queryF502(F502Request f502Request);
	
	public F502Response deleteF502(F502Request f502Request);

	F502Response getEmptyFile(boolean del);
}

