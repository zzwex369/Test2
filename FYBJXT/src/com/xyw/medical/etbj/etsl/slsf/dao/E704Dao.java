package com.xyw.medical.etbj.etsl.slsf.dao;

import com.xyw.medical.etbj.etsl.model.E704;
import com.xyw.medical.etbj.etsl.model.E704Request;
import com.xyw.medical.etbj.etsl.model.E704Response;

public interface E704Dao {
	E704Response saveE704(E704 e704);
	E704Response queryE704(E704Request e704Request);
	E704Response deleteE704(E704Request e704Request);
	E704Response updateE704(E704 e704);
}
