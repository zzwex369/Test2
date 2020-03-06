package com.xyw.medical.fnbj.fnbjcqzd.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xyw.medical.fnbj.fnbjcqzd.dao.F605Dao;
import com.xyw.medical.fnbj.model.F605;
import com.xyw.medical.fnbj.model.F605Request;
import com.xyw.medical.fnbj.model.F605Response;
import com.xyw.medical.fnbj.model.VF605;
import com.xyw.sys.util.ExceptionCollection;
import com.xyw.sys.util.StringUtil;
import com.xyw.sys.util.TimeSwitch;

@Repository("f605Dao")
@Scope("prototype")
public class F605DaoImpl implements F605Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	
	private static final Logger log = LoggerFactory.getLogger(F605DaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public F605Response saveF605(F605 f605) {
		F605Response f605Response = new F605Response();
		String f60507 = f605.getF60507();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {

			Object[] f605Fields = (Object[]) session.createSQLQuery(
					"select max(f605_42),max(f605_41zh) from v_f605 t where f605_07 ='"
							+ f60507 + "'").uniqueResult();
			if (f605Fields[0]!= null) {
				Date f60542 = (Date) f605Fields[0];
				String monthStr = (String) session.createSQLQuery(
						"select c101_02 from C101 where c101_01='6'")
						.uniqueResult();
				int month = TimeSwitch.getMonthSpace(f60542, new Date());
				if (month < Integer.parseInt(monthStr)) {
					state = false;
					f605Response.setErrorMessage("该信息已经被" + f605Fields[1] + "于"
							+ new DateTime(f60542).toString("yyyy-MM-dd")
							+ "登记过档案！信息登记未超过半年");
				}
			}
		} catch (Exception e) {
			f605Response.setErrorMessage("保存失败! ");
			ExceptionCollection.saveD403(e, f605.getF60541(), "F605", f605
					.getF60501(), session);
			state = false;
		}
		if (state) {
			try {
				session.save(f605);
				session.flush();
				session.refresh(f605);
				f605Response.setF605(f605);
				f605Response.setPromptMessage("保存成功! ");
			} catch (Exception e) {
				f605Response.setErrorMessage("保存失败! ");
				ExceptionCollection.saveD403(e, f605.getF60541(), "F605", f605
						.getF60501(), session);
				state = false;
			}
		}
		f605Response.setState(state);
		return f605Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F605Response renewF605(F605 f605) {
		F605Response f605Response = new F605Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			Date f60583=f605.getF60583();
			log.error("f60583--->{}",f60583.toString());
			if(f60583!=null&&"5".equals(f605.getF60540())){
				f605.setF60583(new Date());
				log.error("setF60583--->{}",f605.getF60583().toString());
			}
			F605 _f605 = (F605) session.get(F605.class, f605.getF60501());
			if (_f605 == null) {
				f605Response.setErrorMessage("该信息不存在，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			f605Response.setErrorMessage("保存失败! ");
			ExceptionCollection.saveD403(e, f605.getF60541(), "F605", f605
					.getF60501(), session);
			state = false;
		}
		if (state) {
			try {
				session.clear();
				session.update(f605);
				session.flush();
				session.refresh(f605);
				f605Response.setPromptMessage("修改成功! ");
			} catch (Exception e) {
				f605Response.setErrorMessage("保存失败! ");
				ExceptionCollection.saveD403(e, f605.getF60541(), "F605", f605
						.getF60501(), session);
				state = false;
			}
		}
		f605Response.setState(state);
		return f605Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F605Response queryF605(F605Request f605Request) {
		F605Response f605Response = new F605Response();
		F605 f605 = f605Request.getF605();
		String f60503 = f605.getF60503();
		String f60504 = f605.getF60504();
		String f60505 = f605.getF60505();
		String f60507 = f605.getF60507();
		String f60509 = f605.getF60509();
		String f60510 = f605.getF60510();
		String f60532 = f605.getF60532();
		String f60540 = f605.getF60540();
		int codeLength= f605Request.getCodeLength();
		String suffixSql =f605Request.getSuffixSql();
		Date timeStr = f605Request.getTimeStr();
		Date timeEnd = f605Request.getTimeEnd();
		Map<String, Object>fieldMap=f605Request.getFieldMap();
		String code=fieldMap.get("code").toString();
		String codeField = fieldMap.get("codeField").toString();
		int pageIndex = f605Request.getParameterPageindex();
		int pageSize = f605Request.getParameterPagesize();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
	
		if (!StringUtil.isBlankString(f60503)) {
			sb.append("and t.f605_03 ='" + f60503 + "' ");
		}
		if (!StringUtil.isBlankString(f60504)) {
			sb.append("and t.f605_04 ='" + f60504 + "' ");
		}
		if (!StringUtil.isBlankString(f60505)) {
			sb.append("and t.f605_05 ='" + f60505 + "' ");
		}
		if (!StringUtil.isBlankString(f60507)) {
			sb.append("and t.f605_07 ='" + f60507 + "' ");
		}
		if (!StringUtil.isBlankString(f60509)) {
			sb.append("and t.f605_09 ='" + f60509 + "' ");
		}
		if (!StringUtil.isBlankString(f60510)) {
			sb.append("and t.f605_10 ='" + f60510 + "' ");
		}
		if (!StringUtil.isBlankString(f60532)) {
			sb.append("and t.f605_32 ='" + f60532 + "' ");
		}
		if (!StringUtil.isBlankString(f60540)) {
			sb.append("and t.f605_40 ='" + f60540 + "' ");
		}
		
		if(!StringUtil.isBlankString(suffixSql))
			sb.append(suffixSql);
		
		if (timeStr!=null) {
			String dateField=fieldMap.get("dateField").toString();
			sb.append(" and to_char(" + dateField
					+ ",'yyyy-mm-dd') >= '" + sdf.format(timeStr) + "'");

			sb.append(" and to_char(" + dateField
					+ ",'yyyy-mm-dd') <= '" + sdf.format(timeEnd) + "'");
		}

		if (!StringUtil.isBlankString(code)) {
		
			if (code.length() == codeLength) {
				sb.append(" and " + codeField + " = '");
				sb.append(code);
				sb.append("'");
			} else {
				sb.append(" and " + codeField + " like '");
				sb.append(code);
				sb.append("%'");
			}
		}
		Session session = sessionFactory.getCurrentSession();
	

		String sql =" from v_f605 t where  1=1 "+sb.append(" order by "
					+(codeField!=null?(codeField+","):"")+"f605_01").toString();
		try {
			Object rowCount = session.createSQLQuery("select count(*)"+sql).uniqueResult();

			
			List<VF605> vf605s = (List<VF605>) session.createSQLQuery("select *"+sql)
					.addEntity(VF605.class).setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();

			f605Response.setRowCount(Long.valueOf(rowCount.toString()));
			f605Response.setVf605s(vf605s);
		} catch (Exception e) {
			f605Response.setErrorMessage("查询失败! ");
			ExceptionCollection.saveD403(e, null,"F605",sql,session);
		}
		return f605Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F605Response deleteF605(F605Request f605Request) {
		F605Response f605Response = new F605Response();
		String f60501 = f605Request.getF60501();
		boolean state = true;
		F605 f605=null;
		Session session = sessionFactory.getCurrentSession();
		try {
			f605 = (F605) session.get(F605.class, f60501);
			if (f605 == null) {
				f605Response.setErrorMessage("该信息不存在，不能删除!");
				state = false;
			}
		} catch (Exception e) {
			f605Response.setErrorMessage("删除失败! ");
			ExceptionCollection.saveD403(e, null, "F605", f60501, session);
			state = false;
		}
		if (state) {
			try {
				session.delete(f605);
			} catch (Exception e) {
				f605Response.setErrorMessage("删除失败! ");
				ExceptionCollection.saveD403(e, null, "F605", f60501, session);
				state = false;
			}
		}
		f605Response.setState(state);
		return f605Response;
	}

	@Override
	public F605Response getF605(String f60501) {
		F605Response f605Response = new F605Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		if (state) {
			try {
				F605 f605 = (F605) session.get(F605.class, f60501);
				f605Response.setF605(f605);
			} catch (Exception e) {
				// f605Response.setErrorMessage("删除失败! ");
				ExceptionCollection
						.saveD403(e, f60501, "F605", f60501, session);
				state = false;
			}
		}
		f605Response.setState(state);
		return f605Response;
	}

}
