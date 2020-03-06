package com.xyw.medical.birth.certificateAbandon.service.impl;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.henan.ZfResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.certificate.dao.BirthCertificateDao;
import com.xyw.medical.birth.certificateAbandon.dao.AbandonCertificateDao;
import com.xyw.medical.birth.certificateAbandon.service.AbandonCertificateService;
import com.xyw.medical.birth.model.D401;
import com.xyw.medical.birth.model.D401Request;
import com.xyw.medical.birth.model.D401Response;
import com.xyw.medical.birth.model.VD401;

@Transactional
public class AbandonCertificateServiceImpl implements AbandonCertificateService {

	@Resource
	private AbandonCertificateDao abandonCertificateDao;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private BirthCertificateDao birthDao;
	
	@Override
	public D401Response abandonCertificate(D401Request d401Request) {
		D401Response d401Response = abandonCertificateDao.saveD401(d401Request);
		String d30110 = d401Request.getD401().getD40105();
		boolean flag = false;
		if(d401Response.getErrorMessage() == null || "".equals(d401Response.getErrorMessage()))
		{
			flag = this.birthDao.del(d30110);
		}
		
		//向上传数据  开始，从数据库查询看是否需要上传废证,具体查看 s900
		D401 d401 = d401Request.getD401();
		if(flag && CsyxzmWebRequestUtil.isValidate("14", this.sessionFactory.getCurrentSession())){
			try {
				RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
				ZfResponse zfResponse = remoteInvokeTools.remoteInvokeD401(d401);
				String status = zfResponse.getStatus();
				d401.setD40127(status);//上传状态（参照出生医学证明接口说明）
				if("ok".equals(status)){
					d401.setD40128("1");//上传标志 1成功，2失败，3未传
				} else {
					d401.setD40118("2");
				}
			} catch (Exception e) {
				e.printStackTrace();
				d401.setD40127("fail");
				d401.setD40128("2");
			}
		} else {
			d401.setD40128("3");
		}
		
		//向上传数据  结束
				
		return d401Response;
	}

	@Override
	public D401Response query(D401Request d401Request) {
		D401Response d401Response = this.abandonCertificateDao.queryD401(d401Request);
		return d401Response;
	}
	
	@Override
	public D401Response validateStockCertiticate(D401 d401) {
		D401Response d401Response = this.abandonCertificateDao.validateStockCertiticate(d401);
		return d401Response;
	}
	
	@Override
	public D401Response updateCertiticate(VD401 vd401) {
		D401Response d401Response = this.abandonCertificateDao.updateD401(vd401);
		
		//向上传数据  开始
		D401 d401 = d401Response.getD401();
		RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
		if(d401Response.getErrorMessage() == null || "".equals(d401Response.getErrorMessage())){
			try {
				ZfResponse zfResponse = remoteInvokeTools.remoteInvokeUpdateD401(d401);
				String status = zfResponse.getStatus();
				d401.setD40129(status);//处理状态（参照出生医学证明接口说明）
				if("ok".equals(status)){
					d401.setD40130("1");//处理标志 1成功，2失败，3未传
				} else {
					d401.setD40130("2");
				}
			} catch (Exception e) {
				e.printStackTrace();
				d401.setD40129("fail");
				d401.setD40130("2");
			}
		}
		//向上传数据  结束
		
		return d401Response;
	}

	@Override
	public D401Response validateD301(String idNumber) {
		D401Response d401Response = this.abandonCertificateDao.validateD301Data(idNumber);
		return d401Response;
	}
}
