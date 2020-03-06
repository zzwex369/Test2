package com.xyw.medical.birth.certificateDJB.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.henan.BfbResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.certificateDJB.dao.ReissueBirthCertificateDJBDao;
import com.xyw.medical.birth.certificateDJB.service.ReissueBirthCertificateDJBService;
import com.xyw.medical.birth.model.D305;
import com.xyw.medical.birth.model.D305Request;
import com.xyw.medical.birth.model.D305Response;

@Transactional
public class ReissueBirthCertificateDJBServiceImpl implements ReissueBirthCertificateDJBService {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private ReissueBirthCertificateDJBDao reissueBirthCertificateDJBDao = null;
	
	@Override
	public D305Response saveReissueBirthCertificateDJB(D305Request d305Request) {
		D305Response d305Response = this.reissueBirthCertificateDJBDao.saveD305(d305Request);
		
		//向上传数据  开始，先验证是否上传补发登记表，具体查询 s900
		if(CsyxzmWebRequestUtil.isValidate("16", this.sessionFactory.getCurrentSession())){
			D305 d305 = d305Request.getD305();
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(d305Response.getErrorMessage() == null || "".equals(d305Response.getErrorMessage())){
				try {
					BfbResponse bfbResponse = remoteInvokeTools.remoteInvokeD305(d305);
					String status = bfbResponse.getStatus();
					d305.setD30543(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d305.setD30544("1");//上传标志 1成功，2失败，3未传
					} else {
						d305.setD30544("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d305.setD30543("fail");
					d305.setD30544("2");
				}
			}
		}
		
		//向上传数据  结束
		
		return d305Response;
	}

	@Override
	public D305Response queryBirthCertificateDJB(D305Request d305Request) {
		D305Response d305Response = this.reissueBirthCertificateDJBDao.queryD305(d305Request);
		return d305Response;
	}

	@Override
	public D305Response updateD305(D305 d305) {
		D305Response d305Response = this.reissueBirthCertificateDJBDao.updateD305(d305);
		return d305Response;
	}

	@Override
	public D305Response deleteD305(D305Request d305Request) {
		D305Response d305Response = this.reissueBirthCertificateDJBDao.deleteD305(d305Request);
		return d305Response;
	}

}
