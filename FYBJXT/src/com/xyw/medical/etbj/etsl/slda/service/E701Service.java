package com.xyw.medical.etbj.etsl.slda.service;

import com.xyw.medical.etbj.etsl.model.E701;
import com.xyw.medical.etbj.etsl.model.E701Request;
import com.xyw.medical.etbj.etsl.model.E701Response;


public interface E701Service {
	E701Response saveE701(E701 e701);
	E701Response queryE701(E701Request e701Request);
	E701Response updateE701(E701 e701);
	E701Response deleteE701(E701Request e701Request);
}
