package com.xyw.medical.birth.certificate.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.henan.DjResponse;
import com.xyw.client.henan.util.CsyxzmWebRequestUtil;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.medical.birth.certificate.dao.BirthCertificateDao;
import com.xyw.medical.birth.certificate.service.BirthCertificateService;
import com.xyw.medical.birth.certificateAbandon.dao.AbandonCertificateDao;
import com.xyw.medical.birth.model.D301;
import com.xyw.medical.birth.model.D401;
import com.xyw.medical.birth.model.D401Request;
import com.xyw.medical.birth.model.D401Response;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;
import com.xyw.medical.birth.model.VD505;

@Transactional
public class BirthCertificateServiceImpl implements BirthCertificateService {
	@Resource
	private BirthCertificateDao birthDao;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private AbandonCertificateDao abandonCertificateDao;
	
	@Override
	public QueryBirthResponse saveBirthCertificate(D301 d301) {   
		String d30150 = d301.getD30150();
		d301.setD30150("0");//首次签发时补发原因为0；
		QueryBirthResponse queryBirthResponse = this.birthDao.saveBirthCertificate(d301);
		
		//向上传数据  开始，先验证是否上传首发，具体查询 s900
		if(CsyxzmWebRequestUtil.isValidate("13", this.sessionFactory.getCurrentSession())){
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(queryBirthResponse.getErrorMessage() == null || "".equals(queryBirthResponse.getErrorMessage())){
				try {
					DjResponse djResponse = remoteInvokeTools.remoteInvokeD301(d301);
					String status = djResponse.getStatus();
					d301.setD30158(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d301.setD30159("1");//上传标志 1成功，2失败，3未传
					} else {
						d301.setD30159("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d301.setD30158("fail");
					d301.setD30159("2");
				}
			}
		}
		
		//向上传数据  结束
		
		if(queryBirthResponse.getErrorMessage() == null || "".equals(queryBirthResponse.getErrorMessage())){
			D401Response d401Response= new D401Response();
			boolean state = true;
			if(d301.getD30152() != null && "0".equals(d301.getD30142()))
			{
				D401Request d401Request = new D401Request();
				D401 d401 = new D401();
				d401.setD40102(d301.getD30102());
				d401.setD40103(d301.getD30103());
				d401.setD40104(d301.getD30104());
				d401.setD40105(d301.getD30152());
				d401.setD40106(d30150);
				d401.setD40107(d301.getD30151());
				d401.setD40108(d301.getD30128());
				d401.setD40109(d301.getD30127());
				d401.setD40110(d301.getD30126());
				d401.setD40111(d301.getD30127());
				d401.setD40112(d301.getD30126());
				d401.setD40113(d301.getD30131());
				d401.setD40114(d301.getD30141());
				d401.setD40122(d301.getD30126());
				d401.setD40124("0");
				d401.setD40125("0");
				if(d301.getD30159()!=null){
					//二次首发上传成功，原证作废，返回标志写入d301的同时写入d401
					d401.setD40129(d301.getD30159());
				}
				d401Request.setD401(d401);
				this.abandonCertificateDao.saveD401(d401Request);
				boolean flg = this.birthDao.del(d301.getD30152());
				if(!flg)
				{
					queryBirthResponse.setErrorMessage("登记失败!");
					return queryBirthResponse;
				}
			}
			
			if(queryBirthResponse.isState()  && (d401Response.getErrorMessage() == null) )
			{
				queryBirthResponse.setPromptMessage("登记成功!");
			}else
			{
				state = false;
			}
			
			queryBirthResponse.setState(state);
		}
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse validateBirth(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = this.birthDao.validateBirth(queryBirthRequest);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse reissueBirthCertificate(D301 d301) {   
		QueryBirthResponse queryBirthResponse = this.birthDao.saveBirthCertificate(d301);

		//向上传数据  开始，先验证是否上传补发，具体查询 s900
		if(CsyxzmWebRequestUtil.isValidate("13", this.sessionFactory.getCurrentSession())){
		
			RemoteInvokeTools remoteInvokeTools = new RemoteInvokeTools();
			if(queryBirthResponse.getErrorMessage() == null || "".equals(queryBirthResponse.getErrorMessage())){
				try {
					DjResponse djResponse = remoteInvokeTools.remoteInvokeD301(d301);
					String status = djResponse.getStatus();
					d301.setD30158(status);//上传状态（参照出生医学证明接口说明）
					if("ok".equals(status)){
						d301.setD30159("1");//上传标志 1成功，2失败，3未传
					} else {
						d301.setD30159("2");
					}
				} catch (Exception e) {
					e.printStackTrace();
					d301.setD30158("fail");
					d301.setD30159("2");
				}
			}
		}
		//向上传数据  结束
		
		if(queryBirthResponse.getErrorMessage() == null || "".equals(queryBirthResponse.getErrorMessage())){
			boolean state = true;
			
			if(queryBirthResponse.isState())
			{
				queryBirthResponse.setPromptMessage("补发成功!");
			}else
			{
				state = false;
			}
			queryBirthResponse.setState(state);
		}
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse renewBirthCertificate(D301 d301) {
		QueryBirthResponse queryBirthResponse = this.birthDao.saveBirthCertificate(d301);
		boolean state = true;
		if(queryBirthResponse.isState())
		{
			queryBirthResponse.setPromptMessage("换发成功!");
		}else
		{
			state = false;
		}
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse outsideBirthCertificate(D301 d301) {
		QueryBirthResponse queryBirthResponse = this.birthDao.saveBirthCertificate(d301);
		boolean state = true;
		if(queryBirthResponse.isState())
		{
			queryBirthResponse.setPromptMessage("机构外首发成功!");
		}else
		{
			state = false;
		}
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse validateSaveBirthCertiticate(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		boolean state = this.birthDao.validateSaveBirthCertiticate(queryBirthRequest);
		
		if(!state)
		{
			queryBirthResponse.setErrorMessage("该出生证号已存在!");
		}
		queryBirthResponse.setState(state);
		
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse queryBirthCertificate(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		queryBirthResponse = this.birthDao.queryBirthCertificate(queryBirthRequest);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse queryBirthCertificatehf(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		queryBirthResponse = this.birthDao.queryBirthCertificatehf(queryBirthRequest);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse queryBirthCertificatebf(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		queryBirthResponse = this.birthDao.queryBirthCertificatebf(queryBirthRequest);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse gaQueryBirthCertificate(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		queryBirthResponse = this.birthDao.queryBirthCertificate(queryBirthRequest);
		/*
		if(queryBirthResponse.getListVD301().isEmpty()){
			queryBirthRequest.setD302_02(queryBirthRequest.getD301_02());
			queryBirthRequest.setD302_10(queryBirthRequest.getD301_10());
			queryBirthRequest.setD302_11(queryBirthRequest.getD301_11());
			queryBirthRequest.setD302_12(queryBirthRequest.getD301_12());
			queryBirthRequest.setD302_16(queryBirthRequest.getD301_16());
			queryBirthRequest.setD302_17(queryBirthRequest.getD301_17());
			queryBirthResponse = this.birthDao.queryBirthCertificatehf(queryBirthRequest);
			// change 302 to 301
			while(!queryBirthResponse.getListVD302().isEmpty())
					{
						List<VD302> listVD302 = new ArrayList<VD302>();
						List<VD301> listVd301 = new ArrayList<VD301>();
						listVD302 = queryBirthResponse.getListVD302();
						for(VD302 vd302:listVD302){
							VD301 vd301 = new VD301();
							vd301.setD30101(vd302.getD30201());
							vd301.setD30102(vd302.getD30202());
							vd301.setD30103Zh(vd302.getD30203Zh());
							vd301.setD30104(vd302.getD30204());
							vd301.setD30105Zh(vd302.getD30205Zh());
							vd301.setD30106(vd302.getD30206());
							vd301.setD30107(vd302.getD30207());
							vd301.setD30108(vd302.getD30208());
							vd301.setD30109Zh(vd302.getD30209Zh());
							vd301.setD30110(vd302.getD30210());
							vd301.setD30111(vd302.getD30211());
							vd301.setD30112(vd302.getD30212());
							vd301.setD30113(vd302.getD30213());
							vd301.setD30114Zh(vd302.getD30214Zh());
							vd301.setD30115Zh(vd302.getD30215Zh());
							vd301.setD30116(vd302.getD30216());
							vd301.setD30117(vd302.getD30217());
							vd301.setD30118(vd302.getD30218());
							vd301.setD30119Zh(vd302.getD30219Zh());
							vd301.setD30120Zh(vd302.getD30220Zh());
							vd301.setD30121Zh(vd302.getD30221Zh());
							vd301.setD30122Zh(vd302.getD30222Zh());
							vd301.setD30123Zh(vd302.getD30223Zh());
							vd301.setD30124Zh(vd302.getD30224Zh());
							vd301.setD30125(vd302.getD30225());
							vd301.setD30126Zh(vd302.getD30226Zh());
							vd301.setD30127(vd302.getD30227());
							vd301.setD30128(vd302.getD30228());
				//			vd301.setD30129(vd302.getD30231());
							vd301.setD30130Zh(vd302.getD30232Zh());
							vd301.setD30131Zh(vd302.getD30233Zh());
							vd301.setD30130(vd302.getD30232());
							vd301.setD30131(vd302.getD30233());
							vd301.setD30132(vd302.getD30234());
							vd301.setD30133(vd302.getD30235());
							vd301.setD30134(vd302.getD30236());
							vd301.setD30134Zh(vd302.getD30236Zh());
							vd301.setD30135(vd302.getD30237());
							vd301.setD30135Zh(vd302.getD30237Zh());
							vd301.setD30136(vd302.getD30238());
							vd301.setD30137Zh(vd302.getD30239Zh());
							vd301.setD30138(vd302.getD30240());
							vd301.setD30138Zh(vd302.getD30240Zh());
							vd301.setD30139(vd302.getD30241());
							vd301.setD30140(vd302.getD30242());
							vd301.setD30143(vd302.getD30246());
							vd301.setD30148Zh(vd302.getD30252Zh());
							listVd301.add(vd301);
						}
						queryBirthResponse.setListVD301(listVd301);
						return queryBirthResponse;
					}
		if(queryBirthResponse.getListVD302().isEmpty()){
			
				queryBirthRequest.setD303_02(queryBirthRequest.getD301_02());
				queryBirthRequest.setD303_10(queryBirthRequest.getD301_10());
				queryBirthRequest.setD303_11(queryBirthRequest.getD301_11());
				queryBirthRequest.setD303_12(queryBirthRequest.getD301_12());
				queryBirthRequest.setD303_16(queryBirthRequest.getD301_16());
				queryBirthRequest.setD303_17(queryBirthRequest.getD301_17());
				queryBirthResponse = this.birthDao.queryBirthCertificatebf(queryBirthRequest);
				// change 303 to 301
				if(!queryBirthResponse.getListVD303().isEmpty())
				{
					List<VD301> listVD301 = new ArrayList<VD301>();
					List<VD303> listVd303 = new ArrayList<VD303>();
					listVd303  = queryBirthResponse.getListVD303();
					for(VD303 vd303:listVd303){
						VD301 vD301 = new VD301();
						vD301.setD30101(vd303.getD30301());
						vD301.setD30102(vd303.getD30302());
						vD301.setD30103Zh(vd303.getD30303Zh());
						vD301.setD30104(vd303.getD30304());
						vD301.setD30105Zh(vd303.getD30305Zh());
						vD301.setD30106(vd303.getD30306());
						vD301.setD30107(vd303.getD30307());
						vD301.setD30108(vd303.getD30308());
						vD301.setD30109Zh(vd303.getD30309Zh());
						vD301.setD30110(vd303.getD30310());
						vD301.setD30111(vd303.getD30311());
						vD301.setD30112(vd303.getD30312());
						vD301.setD30113(vd303.getD30313());
						vD301.setD30114Zh(vd303.getD30314Zh());
						vD301.setD30115Zh(vd303.getD30315Zh());
						vD301.setD30116(vd303.getD30316());
						vD301.setD30117(vd303.getD30317());
						vD301.setD30118(vd303.getD30318());
						vD301.setD30119Zh(vd303.getD30319Zh());
						vD301.setD30120Zh(vd303.getD30320Zh());
						vD301.setD30121Zh(vd303.getD30321Zh());
						vD301.setD30122Zh(vd303.getD30322Zh());
						vD301.setD30123Zh(vd303.getD30323Zh());
						vD301.setD30124Zh(vd303.getD30324Zh());
						vD301.setD30125(vd303.getD30325());
						vD301.setD30126Zh(vd303.getD30326Zh());
						vD301.setD30127(vd303.getD30327());
						vD301.setD30128(vd303.getD30328());
		//				vD301.setD30129(vd303.getD30331());
						vD301.setD30130Zh(vd303.getD30332Zh());
						vD301.setD30131Zh(vd303.getD30333Zh());
						vD301.setD30130(vd303.getD30332());
						vD301.setD30131(vd303.getD30333());
						vD301.setD30132(vd303.getD30334());
						vD301.setD30133(vd303.getD30335());
						vD301.setD30134(vd303.getD30336());
						vD301.setD30134Zh(vd303.getD30336Zh());
						vD301.setD30135(vd303.getD30337());
						vD301.setD30135Zh(vd303.getD30337Zh());
						vD301.setD30136(vd303.getD30338());
						vD301.setD30137Zh(vd303.getD30339Zh());
						vD301.setD30138(vd303.getD30340());
						vD301.setD30138Zh(vd303.getD30340Zh());
						vD301.setD30139(vd303.getD30341());
						vD301.setD30140(vd303.getD30342());
						vD301.setD30143(vd303.getD30346());
						vD301.setD30148Zh(vd303.getD30352Zh());
						listVD301.add(vD301);
					}
					queryBirthResponse.setListVD301(listVD301);
				}						
			}
		}
		*/
		if(queryBirthResponse.getListVD301().isEmpty()){
			VD505 vd505 = new VD505();
			vd505.setD505_03(queryBirthRequest.getD301_10());
			queryBirthResponse.setVd505(this.birthDao.queryBirthInstitution(vd505));
		}
		return queryBirthResponse;	
	}
	
	@Override
	public QueryBirthResponse validateStockCertiticate(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		queryBirthResponse = this.birthDao.validateStockCertiticate(queryBirthRequest);
		return queryBirthResponse;
	}

	@Override
	public boolean isUsed(long d30401,long d60101) {
		return this.birthDao.isUsed(d30401, d60101);
	}
}
