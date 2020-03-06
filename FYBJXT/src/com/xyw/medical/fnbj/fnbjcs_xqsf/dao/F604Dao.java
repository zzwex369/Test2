package com.xyw.medical.fnbj.fnbjcs_xqsf.dao;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.F604;
import com.xyw.medical.fnbj.model.F604Request;
import com.xyw.medical.fnbj.model.F604Response;
@Transactional
public interface F604Dao {
	F604Response saveF604(F604 f604);

	F604Response renewF604(F604 f604);

	F604Response queryF604(F604Request f604Request);

	F604Response deleteF604(F604Request f604Request)throws Exception;
}
