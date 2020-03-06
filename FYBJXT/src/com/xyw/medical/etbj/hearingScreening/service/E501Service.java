package com.xyw.medical.etbj.hearingScreening.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.model.E501;
import com.xyw.medical.etbj.model.E501Request;
import com.xyw.medical.etbj.model.E501Response;
import com.xyw.medical.etbj.model.E502Response;
/**
 * @author libo
 * 创建时间：Jun 17, 2017 11:45:43 AM
 */
@Transactional
public interface E501Service {
	E501Response saveE501(E501 e501);
	E501Response queryHearingScreening(String e50103,String e50104);
	E501Response renewE501(E501 e501);
	E501Response queryE501(E501Request e501Request);
	E501Response deleteE501(E501Request e501Request);
}
