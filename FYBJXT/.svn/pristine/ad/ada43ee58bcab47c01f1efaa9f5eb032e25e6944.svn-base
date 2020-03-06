package com.xyw.medical.fnbj.fnlapic.dao;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.L306Request;
import com.xyw.medical.fnbj.model.L306Response;
@Transactional(rollbackFor=Exception.class)
public interface L306Dao{
	 L306Response delLaZk(L306Request l306Request);
	 L306Response saveLaZk(L306Request l306Request);
	 L306Response saveLaPic(L306Request l306Request);
	 L306Response delAllByParentId(L306Request l306Request);
	 L306Response delByPicName(L306Request l306Request);
	 L306Response queryL306(L306Request l306Request);
	 L306Response downPic(L306Request l306Request);
}
