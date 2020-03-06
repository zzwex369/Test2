package com.xyw.medical.fnbj.fnbjxqsf.service;

import com.xyw.medical.fnbj.model.F603;
import com.xyw.medical.fnbj.model.F603Request;
import com.xyw.medical.fnbj.model.F603Response;

public interface F603Service {
	F603Response saveF603(F603 f603);

	F603Response renewF603(F603 f603);

	F603Response queryF603(F603Request f603Request);

	F603Response deleteF603(F603Request f603Request);
}
