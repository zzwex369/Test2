package com.xyw.medical.fnbj.fngjada.dao;

import com.xyw.medical.fnbj.model.L301;
import com.xyw.medical.fnbj.model.L301Request;
import com.xyw.medical.fnbj.model.L301Response;

public interface L301Dao {
	 L301Response saveL301(L301Request l301Request);
	 L301Response delL301(L301Request l301Request);
	 L301Response renewL301(L301Request l301Request);
	 L301Response queryL301(L301Request l301Request);
	 L301Response finishCaseL301(L301 l301);
}
