package com.xyw.client.upload.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.client.henan.BfbResponse;
import com.xyw.client.henan.DjResponse;
import com.xyw.client.henan.FmResponse;
import com.xyw.client.henan.FpResponse;
import com.xyw.client.henan.RkResponse;
import com.xyw.client.henan.SfbResponse;
import com.xyw.client.henan.ZfResponse;
import com.xyw.client.henan.util.RemoteInvokeTools;
import com.xyw.client.upload.dao.UploadDao;
import com.xyw.client.upload.model.UploadRequest;
import com.xyw.client.upload.model.UploadResponse;
import com.xyw.client.upload.util.ConvertUtil;
import com.xyw.medical.birth.model.D301;
import com.xyw.medical.birth.model.D304;
import com.xyw.medical.birth.model.D305;
import com.xyw.medical.birth.model.D401;
import com.xyw.medical.birth.model.D501;
import com.xyw.medical.birth.model.D502;
import com.xyw.medical.birth.model.D601;
import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.model.VD304;
import com.xyw.medical.birth.model.VD305;
import com.xyw.medical.birth.model.VD401;
import com.xyw.medical.birth.model.VD501;
import com.xyw.medical.birth.model.VD502;
import com.xyw.medical.birth.model.VD601;
import com.xyw.sys.util.StringUtil;


public class UploadDaoImpl implements UploadDao {
   
    @Resource
    private SessionFactory sessionFactory;
    @Resource
	private RemoteInvokeTools remoteInvokeTools;
    
	@SuppressWarnings("unchecked")
	@Override
	public UploadResponse pagerFp(UploadRequest uploadRequest) {
		String d50109 = uploadRequest.getInstitutionCode();
		String d50112Start = uploadRequest.getTimeStart();
		String d50112End = uploadRequest.getTimeEnd();
		String d50118 = uploadRequest.getStatus();
		
		StringBuffer hql = new StringBuffer();
		if(!StringUtil.isBlankString(d50109)){
			d50109 = d50109.substring(0, 4);
			hql.append(" and t.d50109 like '"+d50109+"%' ");
//			hql.append(" and t.d50109='"+d50109+"' ");
		}
		if(!StringUtil.isBlankString(d50112Start)){
			hql.append(" and t.d50112>=to_date('"+ d50112Start +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(d50112End)){
			hql.append(" and t.d50112<=to_date('"+ d50112End +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(d50118) && !"0".equals(d50118)){
			if("3".equals(d50118)){
				hql.append(" and (t.d50118=3 or t.d50118 is null) ");
			} else {
				hql.append(" and t.d50118='"+ d50118 +"' ");
			}
		}
		
		UploadResponse uploadResponse = new UploadResponse();
		List<VD501> vd501s = null;
		int pageIndex = uploadRequest.getParameterPageindex();
		int pageSize = uploadRequest.getParameterPagesize();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VD501 t where 1=1 " + hql.toString()).uniqueResult();
			
			uploadResponse.setRowCount(Long.valueOf(rowCount+""));
			vd501s = session.createQuery("from VD501 t where 1=1 " + hql.toString() + "order by t.d50101")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			uploadResponse.setVd501s(vd501s);
			if(vd501s.size() <= 0){
				uploadResponse.setPromptMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("查询失败");
		}
		return uploadResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UploadResponse pagerRk(UploadRequest uploadRequest) {
		String d50202 = uploadRequest.getInstitutionCode();
		String d50205Start = uploadRequest.getTimeStart();
		String d50205End = uploadRequest.getTimeEnd();
		String d50216 = uploadRequest.getStatus();
		
		StringBuffer hql = new StringBuffer();
		if(!StringUtil.isBlankString(d50202)){
			d50202 = d50202.substring(0, 4);
			hql.append(" and t.d50202 like '"+d50202+"%' ");
//			hql.append(" and t.d50202='"+d50202+"' ");
		}
		if(!StringUtil.isBlankString(d50205Start)){
			hql.append(" and t.d50205>=to_date('"+ d50205Start +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(d50205End)){
			hql.append(" and t.d50205<=to_date('"+ d50205End +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(d50216) && !"0".equals(d50216)){
			if("3".equals(d50216)){
				hql.append(" and (t.d50216=3 or t.d50216 is null) ");
			} else {
				hql.append(" and t.d50216='"+ d50216 +"' ");
			}
		}
		
		UploadResponse uploadResponse = new UploadResponse();
		List<VD502> vd502s = null;
		int pageIndex = uploadRequest.getParameterPageindex();
		int pageSize = uploadRequest.getParameterPagesize();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VD502 t where 1=1 " + hql.toString()).uniqueResult();
			
			uploadResponse.setRowCount(Long.valueOf(rowCount+""));
			vd502s = session.createQuery("from VD502 t where 1=1 " + hql.toString() + "order by t.d50201")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			uploadResponse.setVd502s(vd502s);
			if(vd502s.size() <= 0){
				uploadResponse.setPromptMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("查询失败");
		}
		return uploadResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UploadResponse pagerFm(UploadRequest uploadRequest) {
		String d60102 = uploadRequest.getInstitutionCode();
		String d60103Start = uploadRequest.getTimeStart();
		String d60103End = uploadRequest.getTimeEnd();
		String d60190 = uploadRequest.getStatus();
		
		StringBuffer hql = new StringBuffer();
		if(!StringUtil.isBlankString(d60102)){
			d60102 = d60102.substring(0, 4);
			hql.append(" and t.d60102 like '"+d60102+"%' ");
//			hql.append(" and t.d60102='"+d60102+"' ");
		}
		if(!StringUtil.isBlankString(d60103Start)){
			hql.append(" and t.d60103_>=to_date('"+ d60103Start +"','yyyy-MM-dd HH24:mi:ss') ");
		}
		if(!StringUtil.isBlankString(d60103End)){
			hql.append(" and t.d60103_<=to_date('"+ d60103End +"','yyyy-MM-dd HH24:mi:ss') ");
		}
		if(!StringUtil.isBlankString(d60190) && !"0".equals(d60190)){
			if("3".equals(d60190)){
				hql.append(" and (t.d60190=3 or t.d60190 is null) ");
			} else {
				hql.append(" and t.d60190='"+ d60190 +"' ");
			}
		}
		
		UploadResponse uploadResponse = new UploadResponse();
		List<VD601> vd601s = null;
		int pageIndex = uploadRequest.getParameterPageindex();
		int pageSize = uploadRequest.getParameterPagesize();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VD601 t where 1=1 " + hql.toString()).uniqueResult();
			
			uploadResponse.setRowCount(Long.valueOf(rowCount+""));
			vd601s = session.createQuery("from VD601 t where 1=1 " + hql.toString() + "order by t.d60101")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			uploadResponse.setVd601s(vd601s);
			if(vd601s.size() <= 0){
				uploadResponse.setPromptMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("查询失败");
		}
		return uploadResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UploadResponse pagerSfb(UploadRequest uploadRequest) {
		String d30411 = uploadRequest.getInstitutionCode();
		String d30404Start = uploadRequest.getTimeStart();
		String d30404End = uploadRequest.getTimeEnd();
		String d30437 = uploadRequest.getStatus();
		
		StringBuffer hql = new StringBuffer();
		if(!StringUtil.isBlankString(d30411)){
			d30411 = d30411.substring(0, 4);
			hql.append(" and t.d30411 like '"+d30411+"%' ");
//			hql.append(" and t.d30411='"+d30411+"' ");
		}
		if(!StringUtil.isBlankString(d30404Start)){
			hql.append(" and t.d30404_>=to_date('"+ d30404Start +"','yyyy-MM-dd HH24:mi:ss') ");
		}
		if(!StringUtil.isBlankString(d30404End)){
			hql.append(" and t.d30404_<=to_date('"+ d30404End +"','yyyy-MM-dd HH24:mi:ss') ");
		}
		if(!StringUtil.isBlankString(d30437) && !"0".equals(d30437)){
			if("3".equals(d30437)){
				hql.append(" and (t.d30437=3 or t.d30437 is null) ");
			} else {
				hql.append(" and t.d30437='"+ d30437 +"' ");
			}
		}
		
		UploadResponse uploadResponse = new UploadResponse();
		List<VD304> vd304s = null;
		int pageIndex = uploadRequest.getParameterPageindex();
		int pageSize = uploadRequest.getParameterPagesize();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VD304 t where 1=1 " + hql.toString()).uniqueResult();
			
			uploadResponse.setRowCount(Long.valueOf(rowCount+""));
			vd304s = session.createQuery("from VD304 t where 1=1 " + hql.toString() + "order by t.d30401")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			uploadResponse.setVd304s(vd304s);
			if(vd304s.size() <= 0){
				uploadResponse.setPromptMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("查询失败");
		}
		return uploadResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UploadResponse pagerDj(UploadRequest uploadRequest) {
		String d30126 = uploadRequest.getInstitutionCode();
		String d30128Start = uploadRequest.getTimeStart();
		String d30128End = uploadRequest.getTimeEnd();
		String d30159 = uploadRequest.getStatus();
		
		StringBuffer hql = new StringBuffer();
		if(!StringUtil.isBlankString(d30126)){
			d30126 = d30126.substring(0, 4);
			hql.append(" and t.d30126 like '"+d30126+"%' ");
//			hql.append(" and t.d30126 = '"+d30126+"' ");
		}
		if(!StringUtil.isBlankString(d30128Start)){
			hql.append(" and t.d30128>='"+ d30128Start +"' ");
		}
		if(!StringUtil.isBlankString(d30128End)){
			hql.append(" and t.d30128<='"+ d30128End +"' ");
		}
		if(!StringUtil.isBlankString(d30159) && !"0".equals(d30159)){
			if("3".equals(d30159)){
				hql.append(" and (t.d30159=3 or t.d30159 is null) ");
			} else {
				hql.append(" and t.d30159='"+ d30159 +"' ");
			}
		}
		
		UploadResponse uploadResponse = new UploadResponse();
		List<VD301> vd301s = null;
		int pageIndex = uploadRequest.getParameterPageindex();
		int pageSize = uploadRequest.getParameterPagesize();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VD301 t where 1=1 " + hql.toString()).uniqueResult();
			
			uploadResponse.setRowCount(Long.valueOf(rowCount+""));
			vd301s = session.createQuery("from VD301 t where 1=1 " + hql.toString() + "order by t.d30101")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			uploadResponse.setVd301s(vd301s);
			if(vd301s.size() <= 0){
				uploadResponse.setPromptMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("查询失败");
		}
		return uploadResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UploadResponse pagerBfb(UploadRequest uploadRequest) {
		String d30511 = uploadRequest.getInstitutionCode();
		String d30513Start = uploadRequest.getTimeStart();
		String d305133End = uploadRequest.getTimeEnd();
		String d30544 = uploadRequest.getStatus();
		
		StringBuffer hql = new StringBuffer();
		if(!StringUtil.isBlankString(d30511)){
			hql.append(" and t.d30511='"+d30511+"' ");
		}
		if(!StringUtil.isBlankString(d30513Start)){
			hql.append(" and t.d30513_>=to_date('"+ d30513Start +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(d305133End)){
			hql.append(" and t.d30513_<=to_date('"+ d305133End +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(d30544) && !"0".equals(d30544)){
			if("3".equals(d30544)){
				hql.append(" and (t.d30544=3 or t.d30544 is null) ");
			} else {
				hql.append(" and t.d30544='"+ d30544 +"' ");
			}
		}
		
		UploadResponse uploadResponse = new UploadResponse();
		List<VD305> vd305s = null;
		int pageIndex = uploadRequest.getParameterPageindex();
		int pageSize = uploadRequest.getParameterPagesize();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VD305 t where 1=1 " + hql.toString()).uniqueResult();
			
			uploadResponse.setRowCount(Long.valueOf(rowCount+""));
			vd305s = session.createQuery("from VD305 t where 1=1 " + hql.toString() + "order by t.d30501")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			uploadResponse.setVd305s(vd305s);
			if(vd305s.size() <= 0){
				uploadResponse.setPromptMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("查询失败");
		}
		return uploadResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UploadResponse pagerFz(UploadRequest uploadRequest) {
		String d40110 = uploadRequest.getInstitutionCode();
		String d40108Start = uploadRequest.getTimeStart();
		String d40108End = uploadRequest.getTimeEnd();
		String d40128 = uploadRequest.getStatus();
		
		StringBuffer hql = new StringBuffer();
		if(!StringUtil.isBlankString(d40110)){
			hql.append(" and t.d40110='"+d40110+"' ");
		}
		if(!StringUtil.isBlankString(d40108Start)){
			hql.append(" and t.d40108>=to_date('"+ d40108Start +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(d40108End)){
			hql.append(" and t.d40108<=to_date('"+ d40108End +"','yyyy-MM-dd') ");
		}
		if(!StringUtil.isBlankString(d40128) && !"0".equals(d40128)){
			if("3".equals(d40128)){
				hql.append(" and (t.d40128=3 or t.d40128 is null) ");
			} else {
				hql.append(" and t.d40128='"+ d40128 +"' ");
			}
		}
		
		UploadResponse uploadResponse = new UploadResponse();
		List<VD401> vd401s = null;
		int pageIndex = uploadRequest.getParameterPageindex();
		int pageSize = uploadRequest.getParameterPagesize();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VD401 t where 1=1 " + hql.toString()).uniqueResult();
			
			uploadResponse.setRowCount(Long.valueOf(rowCount+""));
			vd401s = session.createQuery("from VD401 t where 1=1 " + hql.toString() + "order by t.d40101")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			uploadResponse.setVd401s(vd401s);
			if(vd401s.size() <= 0){
				uploadResponse.setPromptMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("查询失败");
		}
		return uploadResponse;
	}

	@Override
	public UploadResponse pagerFzcl(UploadRequest uploadRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UploadResponse uploadFp(VD501 vd501) {
		
		D501 d501 = ConvertUtil.convertVD501(vd501);
		FpResponse fpResponse = remoteInvokeTools.remoteInvokeD501(d501);
		String status = fpResponse.getStatus();
		UploadResponse uploadResponse = new UploadResponse();
		try {
			Session session = sessionFactory.getCurrentSession();
			D501 d501_ = (D501)session.load(D501.class, d501.getD50101());
			d501_.setD50117(status);
			if("ok".equals(status)){
				uploadResponse.setPromptMessage("上传成功！");
				d501_.setD50118("1");
			} else {
				uploadResponse.setErrorMessage("上传失败！错误代码："+ status);
				d501_.setD50118("2");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("上传失败！");
		}
		
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadRk(VD502 vd502) {
		D502 d502 = ConvertUtil.convertVD502(vd502);
		RkResponse ekResponse = remoteInvokeTools.remoteInvokeD502(d502);
		String status = ekResponse.getStatus();
		UploadResponse uploadResponse = new UploadResponse();
		try {
			Session session = sessionFactory.getCurrentSession();
			D502 d502_ = (D502)session.load(D502.class, d502.getD50201());
			d502_.setD50215(status);
			if("ok".equals(status)){
				uploadResponse.setPromptMessage("上传成功！");
				d502_.setD50216("1");
			} else {
				uploadResponse.setErrorMessage("上传失败！错误代码："+ status);
				d502_.setD50216("2");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("上传失败！");
		}
		
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadFm(VD601 vd601) {
		D601 d601 = ConvertUtil.convertVD601(vd601);
		FmResponse fmResponse = remoteInvokeTools.remoteInvokeD601(d601);
		String status = fmResponse.getStatus();
		UploadResponse uploadResponse = new UploadResponse();
		try {
			Session session = sessionFactory.getCurrentSession();
			D601 d601_ = (D601)session.load(D601.class, vd601.getD60101());
			d601_.setD60189(status);
			if("ok".equals(status)){
				uploadResponse.setPromptMessage("上传成功！");
				d601_.setD60190("1");
			} else {
				uploadResponse.setErrorMessage("上传失败！错误代码："+ status);
				d601_.setD60190("2");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("上传失败！");
		}
		
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadSfb(VD304 vd304) {
		D304 d304 = ConvertUtil.convertVD304(vd304);
		SfbResponse sfbResponse = remoteInvokeTools.remoteInvokeD304(d304);
		String status = sfbResponse.getStatus();
		UploadResponse uploadResponse = new UploadResponse();
		try {
			Session session = sessionFactory.getCurrentSession();
			D304 d304_ = (D304)session.load(D304.class, d304.getD30401());
			d304_.setD30436(status);
			if("ok".equals(status)){
				uploadResponse.setPromptMessage("上传成功！");
				d304_.setD30437("1");
			} else {
				uploadResponse.setErrorMessage("上传失败！错误代码："+ status);
				d304_.setD30437("2");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("上传失败！");
		}
		
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadDj(VD301 vd301) {
		D301 d301 = ConvertUtil.convertVD301(vd301);
		DjResponse djResponse = remoteInvokeTools.remoteInvokeD301(d301);
		String status = djResponse.getStatus();
		UploadResponse uploadResponse = new UploadResponse();
		try {
			Session session = sessionFactory.getCurrentSession();
			D301 d301_ = (D301)session.load(D301.class, d301.getD30101());
			d301_.setD30158(status);
			if("ok".equals(status)){
				uploadResponse.setPromptMessage("上传成功！");
				d301_.setD30159("1");
			} else {
				uploadResponse.setErrorMessage("上传失败！错误代码："+ status);
				d301_.setD30159("2");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("上传失败！");
		}
		
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadBfb(VD305 vd305) {
		D305 d305 = ConvertUtil.convertVD305(vd305);
		BfbResponse bfbResponse = remoteInvokeTools.remoteInvokeD305(d305);
		String status = bfbResponse.getStatus();
		UploadResponse uploadResponse = new UploadResponse();
		try {
			Session session = sessionFactory.getCurrentSession();
			D305 d305_ = (D305)session.load(D305.class, d305.getD30501());
			d305_.setD30543(status);
			if("ok".equals(status)){
				uploadResponse.setPromptMessage("上传成功！");
				d305_.setD30544("1");
			} else {
				uploadResponse.setErrorMessage("上传失败！错误代码："+ status);
				d305_.setD30544("2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("上传失败！");
		}
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadFz(VD401 vd401) {
		D401 d401 = ConvertUtil.convertVD401(vd401);
		ZfResponse zfResponse = remoteInvokeTools.remoteInvokeD401(d401);
		String status = zfResponse.getStatus();
		UploadResponse uploadResponse = new UploadResponse();
		try {
			Session session = sessionFactory.getCurrentSession();
			D401 d401_ = (D401)session.load(D401.class, d401.getD40101());
			d401_.setD40127(status);
			if("ok".equals(status)){
				uploadResponse.setPromptMessage("上传成功！");
				d401_.setD40128("1");
			} else {
				uploadResponse.setErrorMessage("上传失败！错误代码："+ status);
				d401_.setD40128("2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			uploadResponse.setErrorMessage("上传失败！");
		}
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadFzcl(VD401 vd401) {
		// TODO Auto-generated method stub
		return null;
	}

}
