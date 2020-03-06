package com.xyw.medical.birth.certificateRegist.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.henan.RkResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.certificateRegist.dao.CertificateRegistDao;
import com.xyw.medical.birth.certificateRegist.service.CertificateRegistService;
import com.xyw.medical.birth.model.D502;
import com.xyw.medical.birth.model.D502Request;
import com.xyw.medical.birth.model.D502Response;
import com.xyw.medical.birth.model.D505Request;
import com.xyw.medical.birth.model.D505Response;
import com.xyw.medical.birth.model.D506Request;
import com.xyw.medical.birth.model.D506Response;
import com.xyw.medical.birth.model.StockRequest;
import com.xyw.medical.birth.model.StockResponse;

@Transactional
public class CertificateRegistServiceImpl implements CertificateRegistService {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private CertificateRegistDao certificateRegistDao;
	
	@Override
	public D502Response registCertificate(D502Request d502Request) {
		D502Response d502Response = this.certificateRegistDao.saveD502(d502Request);
		
		//向上传数据  开始，先验证是否上传入库，具体查询 s900
		if(CsyxzmWebRequestUtil.isValidate("12", this.sessionFactory.getCurrentSession())){
			D502 d502 = d502Request.getD502();
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(d502Response.getErrorMessage() == null || "".equals(d502Response.getErrorMessage())){
				d502.setD50214("1");//调剂标志   s502_01（没什么用）
				try {
					RkResponse rkResponse = remoteInvokeTools.remoteInvokeD502(d502);
					String status = rkResponse.getStatus();
					d502.setD50215(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d502.setD50216("1");//上传标志 1上传成功，2上传失败，3未传
					} else {
						d502.setD50216("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d502.setD50216("2");
				}
			}
		}
		//向上传数据  结束
		
		return d502Response;
	}

	@Override
	public D502Response query(D502Request d502Request) {
		D502Response d502Response = this.certificateRegistDao.queryD502(d502Request);
		return d502Response;
	}

	@Override
	public D505Response queryD(D505Request d505Request) {
		D505Response d505Response = this.certificateRegistDao.queryD505(d505Request);
		return d505Response;
	}

	@Override
	public D506Response save(D506Request d506Request) {
		D506Response d506Response = this.certificateRegistDao.saveD506(d506Request);
		return d506Response;
	}
	
	@Override
	public StockResponse queryStock(StockRequest stockRequest) {
		StockResponse stockResponse = this.certificateRegistDao.queryCountD505(stockRequest);
		return stockResponse;
	}

	@Override
	public D506Response query(D506Request d506Request) {
		D506Response d506Response = this.certificateRegistDao.queryD506(d506Request);
		return d506Response;
	}
	
	@Override
	public StockResponse queryStockDetail(StockRequest stockRequest) {
		StockResponse stockResponse = this.certificateRegistDao.queryStockDetail(stockRequest);
		return stockResponse;
	}
}
