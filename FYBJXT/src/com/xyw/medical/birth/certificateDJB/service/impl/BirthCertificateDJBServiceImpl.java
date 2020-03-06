package com.xyw.medical.birth.certificateDJB.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.henan.SfbResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.certificateDJB.dao.BirthCertificateDJBDao;
import com.xyw.medical.birth.certificateDJB.service.BirthCertificateDJBService;
import com.xyw.medical.birth.model.D304;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;

@Transactional
public class BirthCertificateDJBServiceImpl implements BirthCertificateDJBService {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private BirthCertificateDJBDao DJBDao;
	
	@Override
	public QueryBirthResponse saveFirstBirthCertificateDJB(D304 d304) {
		QueryBirthResponse queryBirthResponse = this.DJBDao.saveFirstBirthCertificateDJB(d304);
	
		//向上传数据  开始，先验证是否上传首发登记表，具体查询 s900
		if(CsyxzmWebRequestUtil.isValidate("15", this.sessionFactory.getCurrentSession())){
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(queryBirthResponse.getErrorMessage() == null || "".equals(queryBirthResponse.getErrorMessage())){
				try {
					SfbResponse sfbResponse = remoteInvokeTools.remoteInvokeD304(d304);
					String status = sfbResponse.getStatus();
					d304.setD30436(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d304.setD30437("1");//上传标志 1成功，2失败，3未传
					} else {
						d304.setD30437("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d304.setD30436("fail");
					d304.setD30437("2");
				}
			}
		}
		//向上传数据  结束
		
		return queryBirthResponse;
	}

	@Override
	public QueryBirthResponse queryFirstBirthCertificateDJB(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.DJBDao.queryFirstBirthCertificateDJB(queryBirthRequest);
		return queryBirthResponse;
	}

	@Override
	public QueryBirthResponse updateFirstBirthCertificateDJB(D304 d304) {
		QueryBirthResponse queryBirthResponse = this.DJBDao.updateFirstBirthCertificateDJB(d304);
		return queryBirthResponse;
	
	}

	@Override
	public QueryBirthResponse deleteFirstBirthCertificateDJB(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.DJBDao.deleteFirstBirthCertificateDJB(queryBirthRequest);
		return queryBirthResponse;
	}
	

}
