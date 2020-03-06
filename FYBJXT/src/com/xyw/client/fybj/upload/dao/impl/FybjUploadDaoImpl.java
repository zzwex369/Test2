package com.xyw.client.fybj.upload.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.client.fybj.bean.SResult;
import com.xyw.client.fybj.upload.dao.FybjUploadDao;
import com.xyw.client.fybj.upload.model.FybjUploadRequest;
import com.xyw.client.fybj.upload.model.FybjUploadResponse;
import com.xyw.client.fybj.upload.util.RemoteInvokeTools_ve601;
import com.xyw.medical.etbj.model.E601;
import com.xyw.medical.etbj.model.VE601;
import com.xyw.sys.util.StringUtil;

public class FybjUploadDaoImpl implements FybjUploadDao {
	
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private RemoteInvokeTools_ve601 remoteInvokeTools_ve601;

	@SuppressWarnings("unchecked")
	@Override
	public FybjUploadResponse pagerLb(FybjUploadRequest fybjUploadRequest) {
		String e60122 = fybjUploadRequest.getInstitutionCode();
		String e60123Start = fybjUploadRequest.getTimeStart();
		String e60123End = fybjUploadRequest.getTimeEnd();
		String e60139 = fybjUploadRequest.getStatus();
		
		StringBuffer hql = new StringBuffer();
		if(!StringUtil.isBlankString(e60122)){
			e60122 = e60122.substring(0, 4);
			hql.append(" and t.e60122 like '"+e60122+"%' ");
//			hql.append(" and t.e60122='"+e60122+"' ");
		}
		if(!StringUtil.isBlankString(e60123Start)){
			hql.append(" and t.e60123>=to_date('"+ e60123Start +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(e60123End)){
			hql.append(" and t.e60123<=to_date('"+ e60123End +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(e60139) && !"0".equals(e60139)){
			if("3".equals(e60139)){
				hql.append(" and (t.e60139=3 or t.e60139 is null) ");
			} else {
				hql.append(" and t.e60139='"+ e60139 +"' ");
			}
		}
		
		FybjUploadResponse fybjUploadResponse = new FybjUploadResponse();
		List<VE601> ve601s = null;
		int pageIndex = fybjUploadRequest.getParameterPageindex();
		int pageSize = fybjUploadRequest.getParameterPagesize();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VE601 t where 1=1 " + hql.toString()).uniqueResult();
			
			fybjUploadResponse.setRowCount(Long.valueOf(rowCount+""));
			ve601s = session.createQuery("from VE601 t where 1=1 " + hql.toString() + "order by t.e60101")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			fybjUploadResponse.setVe601s(ve601s);
			if(ve601s.size() <= 0){
				fybjUploadResponse.setPromptMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fybjUploadResponse.setErrorMessage("查询失败");
		}
		return fybjUploadResponse;
	}

	@Override
	public FybjUploadResponse uploadLb(VE601 ve601) {
		FybjUploadResponse fybjUploadResponse = new FybjUploadResponse();
		SResult sResult = remoteInvokeTools_ve601.remoteInvokeE601(ve601);
		Boolean status = sResult.isResult();
		try {
			Session session = sessionFactory.getCurrentSession();
			E601 e601_ = (E601)session.load(E601.class, ve601.getE60101());
			if(status){
				fybjUploadResponse.setPromptMessage("上传成功！");
				e601_.setE60138("上传成功！");
//				e601_.setE60139("1");
			} else {
				fybjUploadResponse.setErrorMessage("上传失败！错误代码："+ status);
				e601_.setE60138(sResult.getInfo().getValue());
//				e601_.setE60139("2");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			fybjUploadResponse.setErrorMessage("上传失败！");
		}
		
		return fybjUploadResponse;
	}

}
