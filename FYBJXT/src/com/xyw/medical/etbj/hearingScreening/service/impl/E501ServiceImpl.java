package com.xyw.medical.etbj.hearingScreening.service.impl;

import javax.annotation.Resource;

import com.xyw.medical.etbj.hearingScreening.dao.E501Dao;
import com.xyw.medical.etbj.hearingScreening.service.E501Service;
import com.xyw.medical.etbj.model.E501;
import com.xyw.medical.etbj.model.E501Request;
import com.xyw.medical.etbj.model.E501Response;
import com.xyw.medical.etbj.model.E502Response;
/**
 * @author libo
 * 创建时间：Jun 17, 2017 11:45:43 AM
 */
public class E501ServiceImpl implements E501Service {
	@Resource
	private E501Dao e501Dao;
	@Override
	public E501Response saveE501(E501 e501) {
		E501Response e501Response=new E501Response();
		e501Response=e501Dao.saveE501(e501);
		return e501Response;
	}
	@Override
	public E501Response queryHearingScreening(String e50103, String e50104) {
		E501Response e501Response=new E501Response();
		e501Response=e501Dao.queryHearingScreening(e50103, e50104);
		return e501Response;
	}
	@Override
	public E501Response deleteE501(E501Request e501Request) {
		E501Response e501Response=new E501Response();
		e501Response=e501Dao.deleteE501(e501Request);
		return e501Response;
	}
	@Override
	public E501Response queryE501(E501Request e501Request) {
		E501Response e501Response=new E501Response();
		e501Response=e501Dao.queryE501(e501Request);
		return e501Response;
	}
	@Override
	public E501Response renewE501(E501 e501) {
		E501Response e501Response=new E501Response();
		e501Response=e501Dao.renewE501(e501);
		return e501Response;
	}

}
