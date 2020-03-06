package com.xyw.medical.fnbj.fnbjcqzd.dao;

import com.xyw.medical.fnbj.model.F605;
import com.xyw.medical.fnbj.model.F605Request;
import com.xyw.medical.fnbj.model.F605Response;

public interface F605Dao {
	F605Response saveF605(F605 f605);
	
	F605Response renewF605(F605 f605);
	
	F605Response getF605(String f60501);
	
	F605Response deleteF605(F605Request f605Request);

	F605Response queryF605(F605Request f605Request);
}
