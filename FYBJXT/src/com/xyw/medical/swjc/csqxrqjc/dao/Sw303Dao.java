package com.xyw.medical.swjc.csqxrqjc.dao;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.swjc.model.Sw303;
import com.xyw.medical.swjc.model.Sw303Request;
import com.xyw.medical.swjc.model.Sw303Response;
@Transactional
public interface Sw303Dao {
	Sw303Response saveSw303(Sw303 sw303);
	Sw303Response delSw303(String sw30301);
	Sw303Response renewSw303(Sw303 sw303);
	Sw303Response querySw303(Sw303Request sw303Request);

}
