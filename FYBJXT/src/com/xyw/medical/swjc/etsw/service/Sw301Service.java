package com.xyw.medical.swjc.etsw.service;

import com.xyw.medical.swjc.model.Sw301Request;
import com.xyw.medical.swjc.model.Sw301Response;
import com.xyw.medical.swjc.model.Sw301;



public interface Sw301Service {
	Sw301Response saveSw301(Sw301 sw301);
	Sw301Response delSw301(String sw30101);
	Sw301Response renewSw301(Sw301 sw301);
	Sw301Response querySw301(Sw301Request sw301Request);
}
