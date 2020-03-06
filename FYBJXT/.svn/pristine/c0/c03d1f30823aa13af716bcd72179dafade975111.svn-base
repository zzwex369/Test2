package com.xyw.medical.etbj.etlbsc.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.model.E601;
import com.xyw.medical.etbj.model.E601Request;
import com.xyw.medical.etbj.model.E601Response;

/**
 * @author libo
 * 创建时间：Jun 17, 2017 11:45:43 AM
 */
@Transactional
public interface E601Service {
	E601Response saveE601(E601 e601);
	E601Response renewE601(E601 e601);
	E601Response renewE601(E601Request e601Request);
	E601Response queryE60130(String e60130);
	E601Response queryE601(E601Request e601Request);
	E601Response queryRevocationE601(E601Request e601Request);
	E601Response deleteE601(E601 e601);
}
