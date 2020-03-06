package com.xyw.medical.fnbj.fnbjhqtjzzjd.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.FA401;
import com.xyw.medical.fnbj.model.FA401Request;
import com.xyw.medical.fnbj.model.FA401Response;
@Transactional
public interface FA401Service {
	public FA401Response queryFA401(FA401Request fA401Request);
	public FA401Response renewFA401(FA401 fA401);
	public FA401Response deleteFA401(FA401Request fA401Request);
	
}
