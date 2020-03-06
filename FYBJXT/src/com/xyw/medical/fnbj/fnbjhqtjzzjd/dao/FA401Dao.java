package com.xyw.medical.fnbj.fnbjhqtjzzjd.dao;

import com.xyw.medical.fnbj.model.FA401;
import com.xyw.medical.fnbj.model.FA401Request;
import com.xyw.medical.fnbj.model.FA401Response;

public interface FA401Dao {
	public FA401Response queryFA401(FA401Request fA401Request);
	public FA401Response renewFA401(FA401 fA401);
	public FA401Response deleteFA401(FA401Request fA401Request);
}
