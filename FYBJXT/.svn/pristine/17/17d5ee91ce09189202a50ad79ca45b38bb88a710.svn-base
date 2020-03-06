package com.xyw.medical.birth.deliveryRegist.service.impl;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.henan.FmResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.deliveryRegist.dao.DeliveryDao;
import com.xyw.medical.birth.deliveryRegist.service.DeliveryService;
import com.xyw.medical.birth.model.D601;
import com.xyw.medical.birth.model.D602;
import com.xyw.medical.birth.model.D603;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;
import com.xyw.medical.birth.model.ZyfmdjbRequest;
import com.xyw.medical.birth.model.ZyfmdjbResponse;

@Transactional
public class DeliveryServiceImpl implements DeliveryService {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DeliveryDao deliveryDao;
	
	@Override
	public QueryBirthResponse saveDeliveryRegist(D601 d601) {
		QueryBirthResponse queryBirthResponse = this.deliveryDao.saveDeliveryRegist(d601);
		
		//向上传数据  开始，先验证是否上传分娩登记，具体查询 s900
		if(CsyxzmWebRequestUtil.isValidate("17", this.sessionFactory.getCurrentSession())){
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(queryBirthResponse.getErrorMessage() == null || "".equals(queryBirthResponse.getErrorMessage())){
				try {
					FmResponse fmResponse = remoteInvokeTools.remoteInvokeD601(d601);
					String status = fmResponse.getStatus();
					d601.setD60189(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d601.setD60190("1");//上传标志 1成功，2失败，3未传
					} else {
						d601.setD60190("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d601.setD60189("fail");
					d601.setD60190("2");
				}
			}
		}
		
		//向上传数据  结束
		
		return queryBirthResponse;
	}
	@Override
	public QueryBirthResponse queryDeliveryRegist(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.deliveryDao.queryDeliveryRegist(queryBirthRequest);
		return queryBirthResponse;
	}
	@Override
	public QueryBirthResponse queryDeliveryInfo(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.deliveryDao.queryD601(queryBirthRequest);
		return queryBirthResponse;
	}

	@Override
	public QueryBirthResponse saveD603Info(D603 d603) {
		QueryBirthResponse queryBirthResponse = this.deliveryDao.saveD603(d603);
		return queryBirthResponse;
	}

	@Override
	public QueryBirthResponse renewDelivery(D601 d601) {
		QueryBirthResponse queryBirthResponse = this.deliveryDao.renewDelivery(d601);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse saveHealthcareInfo(D602 d602) {
		QueryBirthResponse queryBirthResponse = this.deliveryDao.saveHealthcareInfo(d602);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse deleteD601(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.deliveryDao.deleteD601(queryBirthRequest);
		return queryBirthResponse;
	}
	
	@Override
	public ZyfmdjbResponse pagerZyfmdjb(ZyfmdjbRequest zyfmdjbRequest) {
		return this.deliveryDao.pagerZyfmdjb(zyfmdjbRequest);
	}
	
}
