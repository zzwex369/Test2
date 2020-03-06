package com.xyw.medical.birth.jgwsfsqb.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.xyw.client.henan.JgwResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.jgwsfsqb.dao.D307Dao;
import com.xyw.medical.birth.jgwsfsqb.service.D307Service;
import com.xyw.medical.birth.model.D307;
import com.xyw.medical.birth.model.D307Request;
import com.xyw.medical.birth.model.D307Response;

public class D307ServiceImpl implements D307Service{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource 
	private D307Dao d307Dao;

	@Override
	public D307Response saveD307(D307 d307) {
		D307Response d307Response = d307Dao.saveD307(d307);
		//向上传数据  开始，先验证是否上传机构外首发登记表，具体查询 s900
		if(CsyxzmWebRequestUtil.isValidate("19", this.sessionFactory.getCurrentSession())){
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(d307Response.getErrorMessage() == null || "".equals(d307Response.getErrorMessage())){
				try {
					JgwResponse jgwResponse = remoteInvokeTools.remoteInvokeD307(d307);
					String status = jgwResponse.getStatus();
					d307.setD30732(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d307.setD30733("1");//上传标志 1成功，2失败，3未传
					} else {
						d307.setD30733("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d307.setD30732("fail");
					d307.setD30733("2");
				}
			}
		}
		//向上传数据  结束
		return d307Response;
	}

	@Override
	public D307Response updateD307(D307 d307) {
		return d307Dao.updateD307(d307);
	}

	@Override
	public D307Response queryVD307(D307Request d307Request) {
		return d307Dao.queryVD307(d307Request);
	}

	@Override
	public D307Response deleteD307(D307Request d307Request) {
		return d307Dao.deleteD307(d307Request);
	}

}


