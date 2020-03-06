package com.xyw.medical.birth.hfsqb.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.xyw.client.henan.HfbResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.hfsqb.dao.D306Dao;
import com.xyw.medical.birth.hfsqb.service.D306Service;
import com.xyw.medical.birth.model.D306;
import com.xyw.medical.birth.model.D306Request;
import com.xyw.medical.birth.model.D306Response;

public class D306ServiceImpl implements D306Service{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private D306Dao d306Dao;

	@Override
	public D306Response saveD306(D306 d306) {
//		d306.setD30625("3");
		D306Response d306Response = d306Dao.saveD306(d306);
		//向上传数据  开始，先验证是否上传换发登记表，具体查询 s900
		if(CsyxzmWebRequestUtil.isValidate("18", this.sessionFactory.getCurrentSession())){
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(d306Response.getErrorMessage() == null || "".equals(d306Response.getErrorMessage())){
				try {
					HfbResponse hfbResponse = remoteInvokeTools.remoteInvokeD306(d306);
					String status = hfbResponse.getStatus();
					d306.setD30624(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d306.setD30625("1");//上传标志 1成功，2失败，3未传
					} else {
						d306.setD30625("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d306.setD30624("fail");
					d306.setD30625("2");
				}
			}
		}
		//向上传数据  结束		
		return d306Response;
	}

	@Override
	public D306Response updateD306(D306 d306) {
		return d306Dao.updateD306(d306);
	}

	@Override
	public D306Response queryVD306(D306Request d306Request) {
		return d306Dao.queryVD306(d306Request);
	}
	
	@Override
	public D306Response queryVD306_new(D306Request d306Request) {
		return d306Dao.queryVD306_new(d306Request);
	}

	@Override
	public D306Response deleteD306(D306Request d306Request) {
		return d306Dao.deleteD306(d306Request);
	}

	@Override
	public D306Response queryVD306s(D306Request d306Request) {
		return d306Dao.queryVD306s(d306Request);
	}
	
	@Override
	public D306Response queryVD306s_new(D306Request d306Request) {
		return d306Dao.queryVD306s_new(d306Request);
	}

}

