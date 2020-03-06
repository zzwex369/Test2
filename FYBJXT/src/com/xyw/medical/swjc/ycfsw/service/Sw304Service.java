package com.xyw.medical.swjc.ycfsw.service;

import com.xyw.medical.swjc.model.Sw304;
import com.xyw.medical.swjc.model.Sw304Request;
import com.xyw.medical.swjc.model.Sw304Response;



public interface Sw304Service {
	Sw304Response saveSw304(Sw304 sw304);
	Sw304Response delSw304(String sw30401);
	Sw304Response renewSw304(Sw304 sw304);
	Sw304Response querySw304(Sw304Request sw304Request);
}
