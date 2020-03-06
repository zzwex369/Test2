package com.xyw.medical.etbj.etlbsc.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.xyw.client.fybj.bean.SResult;
import com.xyw.client.fybj.util.FybjWebRequestUtil;
import com.xyw.client.fybj.util.RemoteInvokeTools;
import com.xyw.medical.etbj.etlbsc.dao.E601Dao;
import com.xyw.medical.etbj.etlbsc.service.E601Service;
import com.xyw.medical.etbj.model.E601;
import com.xyw.medical.etbj.model.E601Request;
import com.xyw.medical.etbj.model.E601Response;

public class E601ServiceImpl implements E601Service {
	@Resource
	private E601Dao e601Dao;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public E601Response  deleteE601(E601 e601) {
		E601Response e601Response=new E601Response();
		e601Response=e601Dao.deleteE601(e601);
		return e601Response;
	}

	@Override
	public E601Response queryE601(E601Request e601Request) {
		E601Response e601Response=new E601Response();
		e601Response=e601Dao.queryE601(e601Request);
		return e601Response;
	}
	@Override
	public E601Response renewE601(E601Request e601Request) {
		E601Response e601Response=new E601Response();
		e601Response=e601Dao.renewE601(e601Request);
		return e601Response;
	}

	@Override
	public E601Response saveE601(E601 e601) {
//		e601.setE60139("3");
		E601Response e601Response = e601Dao.saveE601(e601);
//		
//		//向上传数据  开始，先验证是否上传新生儿两病登记表，具体查询 s900
//		if(FybjWebRequestUtil.isValidate("20", this.sessionFactory.getCurrentSession())){
//			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
//			if(e601Response.getErrorMessage() == null || "".equals(e601Response.getErrorMessage())){
//				try {
//					SResult sResult = remoteInvokeTools.remoteInvokeE601(e601,this.sessionFactory.getCurrentSession());
//					Boolean state = sResult.isResult();
//					if(state){
//						e601.setE60138("上传成功");
//						e601.setE60139("1");
//					}else{
//						e601.setE60138(sResult.getInfo().getValue());
//						e601.setE60139("2");
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//					e601.setE60138("fail");
//					e601.setE60139("2");
//				}
//			}
//		}
		return e601Response;
	}

	@Override
	public E601Response renewE601(E601 e601) {
	
		return e601Dao.renewE601(e601);
	}

	@Override
	public E601Response queryRevocationE601(E601Request e601Request) {
	
		return e601Dao.queryRevocationE601(e601Request);
	}

	@Override
	public E601Response queryE60130(String e60130) {
		
		return e601Dao.queryE60130(e60130);
	}

}
