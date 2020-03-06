package com.xyw.medical.birth.certificateApply.service.impl;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.henan.FpResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.certificate.dao.BirthCertificateDao;
import com.xyw.medical.birth.certificateAbandon.dao.AbandonCertificateDao;
import com.xyw.medical.birth.certificateApply.dao.CertificateApplyDao;
import com.xyw.medical.birth.certificateApply.service.CertificateApplyService;
import com.xyw.medical.birth.model.D401Request;
import com.xyw.medical.birth.model.D401Response;
import com.xyw.medical.birth.model.D501;
import com.xyw.medical.birth.model.D501Request;
import com.xyw.medical.birth.model.D501Response;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;

@Transactional
public class CertificateApplyServiceImpl implements CertificateApplyService {

	@Resource
	private CertificateApplyDao certificateApplyDao;
	
	@Resource
	private BirthCertificateDao birthDao;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private AbandonCertificateDao abandonCertificateDao;

	@Override
	public D501Response certificateApply(D501Request d501Request) {
		D501Response d501Response = certificateApplyDao.saveD501(d501Request);
		
		//向上传数据  开始，先验证是否上传分配,具体查看 s900
		if(CsyxzmWebRequestUtil.isValidate("11", this.sessionFactory.getCurrentSession())){
			D501 d501 = d501Request.getD501();
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(d501Response.getErrorMessage() == null || "".equals(d501Response.getErrorMessage())){
				try {
					FpResponse fpResponse = remoteInvokeTools.remoteInvokeD501(d501);
					String status = fpResponse.getStatus();
					d501.setD50117(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d501.setD50118("1");//上传标志 1成功，2失败，3未传
					} else {
						d501.setD50118("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d501.setD50117("fail");
					d501.setD50118("2");
				}
			}
		}
		
		//向上传数据  结束
		
		return d501Response;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public D501Response query(D501Request d501Request) {
		D501Response d501Response = this.certificateApplyDao.queryD501(d501Request);
		return d501Response;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public D501Response queryA(D501Request d501Request) {
		D501Response d501Response = this.certificateApplyDao.queryD501(d501Request);
		return d501Response;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public D501Response queryAA(D501Request d501Request) {
		D501Response d501Response = this.certificateApplyDao.queryD501(d501Request);
		return d501Response;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public QueryBirthResponse queryB(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.birthDao.queryBirthCertificate(queryBirthRequest);
		return queryBirthResponse;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public QueryBirthResponse queryC(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.birthDao.queryBirthCertificate(queryBirthRequest);
		return queryBirthResponse;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public QueryBirthResponse queryD(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.birthDao.queryBirthCertificate(queryBirthRequest);
		return queryBirthResponse;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public D401Response queryE(D401Request d401Request) {
		D401Response d401Response = this.abandonCertificateDao.queryD401(d401Request);
		return d401Response;
	}

	@Override
	public D501Response queryCity(D501Request d501Request) {
		D501Response d501Response = this.certificateApplyDao.queryD501(d501Request);
		return d501Response;
	}
}
