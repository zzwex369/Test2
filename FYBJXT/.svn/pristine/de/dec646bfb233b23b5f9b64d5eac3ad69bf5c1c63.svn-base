package com.xyw.medical.etbj.ettlsc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.etbj.ettlsc.dao.E505Dao;
import com.xyw.medical.etbj.model.E504;
import com.xyw.medical.etbj.model.E505;
import com.xyw.medical.etbj.model.E505Request;
import com.xyw.medical.etbj.model.E505Response;
import com.xyw.medical.etbj.model.VE504;
import com.xyw.medical.etbj.model.VE505;
import com.xyw.medical.etbj.model.VE505AndVE504;
import com.xyw.sys.util.StringUtil;

public class E505DaoImpl implements E505Dao{
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@Override
	public E505Response saveE505(E505 e505) {
	
		E505Response e505Response = new E505Response();
		boolean state = true;
		String e50502=e505.getE50502();
		String e50526=e505.getE50526();
		Session session = sessionFactory.getCurrentSession();
		try{
			
				String e50501=(String)session.createSQLQuery("select e505_01 from e505 t where e505_02=? and e505_26=?")
								.setString(0,e50502).setString(1,e50526).uniqueResult();
				if(e50501!=null)
				{
					state = false;
					e505Response.setErrorMessage("已经存在这条记不能重复登记，不能重复登记");
				}
			if(state){
				session.save(e505);
				session.flush();
				session.refresh(e505);
				E504 e504=(E504) session.get(E504.class, e50502);
				if("0".equals(e50526)){
					e504.setE50465(e505.getE50529());
					e504.setE50466(e505.getE50525());
					
				}else if("1".equals(e50526)){
					e504.setE50467(e505.getE50529());
					e504.setE50468(e505.getE50525());
				}
				session.update(e504);
				session.flush();
				session.refresh(e504);
			}
			e505Response.setPromptMessage("保存成功！");
		}catch(Exception e){
			state = false;
			e.printStackTrace();
			e505Response.setErrorMessage("保存失败！"+e.getMessage());
		}
		e505Response.setState(state);
		return e505Response;
	}

	@Override
	public E505Response queryE505ById(String id) {
		E505Response e505Response = new E505Response();
		Session session = sessionFactory.getCurrentSession();
		VE505 ve505 =null;
		List<VE505>ve505s = new ArrayList<VE505>();
		try{
			List<VE505> list = session.createSQLQuery("select * from V_E505 t where t.E505_02=? and t.E505_26='0'").addEntity(VE505.class)
					.setString(0, id).list();
			if(list.size()==0){
			e505Response.setPromptMessage("无初筛信息");
				return e505Response;
			}
			for(VE505 ve505_:list){
				ve505 = new VE505();
				ve505.setE50501(ve505_.getE50501());
				ve505.setE50502(ve505_.getE50502());
				ve505.setE50503(ve505_.getE50503());
				ve505.setE50504(ve505_.getE50504());
				ve505.setE50505(ve505_.getE50505());
				ve505.setE50506(ve505_.getE50506());
				ve505.setE50507(ve505_.getE50507());
				ve505.setE50508(ve505_.getE50508());
				ve505.setE50509(ve505_.getE50509());
				ve505.setE50510(ve505_.getE50510());
				ve505.setE50511(ve505_.getE50511());
				ve505.setE50512(ve505_.getE50512());
				ve505.setE50513(ve505_.getE50513());
				ve505.setE50514(ve505_.getE50514());
				ve505.setE50515(ve505_.getE50515());
				ve505.setE50516(ve505_.getE50516());
				ve505.setE50517(ve505_.getE50517());
				ve505.setE50518(ve505_.getE50518());
				ve505.setE50519(ve505_.getE50519());
				ve505.setE50520(ve505_.getE50520());
				ve505.setE50521(ve505_.getE50521());
				ve505.setE50522(ve505_.getE50522());
				ve505.setE50523(ve505_.getE50523());
				ve505.setE50524(ve505_.getE50524());
				ve505.setE50525(ve505_.getE50525());
				ve505.setE50526(ve505_.getE50526());
				ve505.setE50527(ve505_.getE50527());
				ve505.setE50528(ve505_.getE50528());
				ve505.setE50529(ve505_.getE50529());
				ve505.setE50530(ve505_.getE50530());
				ve505.setE50531(ve505_.getE50531());
				ve505.setE50532(ve505_.getE50532());
				ve505s.add(ve505);
			   }
				e505Response.setVe505(ve505s);
			 
			}catch(Exception e){
				e.printStackTrace();
				e505Response.setErrorMessage("查询失败！");
		}
		return e505Response;
	}

	@Override
	public E505Response queryE505ById2(String id) {
		E505Response e505Response = new E505Response();
		Session session = sessionFactory.getCurrentSession();
		VE505 ve505 =null;
		List<VE505>ve505s = new ArrayList<VE505>();
		try{
			List<VE505> list = session.createSQLQuery("select * from V_E505 t where t.E505_02=?").addEntity(VE505.class)
					.setString(0, id).list();
			if(list.size()>0){
				e505Response.setPromptMessage("已登记过筛查无法进行删除");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return e505Response;
	}

	@Override
	public E505Response queryE505(E505Request e505Request) {
		E505Response e505Response=new E505Response();
		E505 _e505=e505Request.getE505();
		int parameterPageIndex=e505Request.getParameterPageindex();
		int parameterPagesize=e505Request.getParameterPagesize();
		Date timeDate=e505Request.getTimeStr();
		Date timeEnDate=e505Request.getTimeEnd();
		String e505_03 = _e505.getE50503();//婴儿姓名
		String e505_06 = _e505.getE50506();//母亲姓名
		String e505_25 = _e505.getE50525();//筛查结果标志
		String e505_26 = _e505.getE50526();//初复筛标志
		String e505_28 = _e505.getE50528();//录入单位
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if (!StringUtil.isBlankString(e505_03)) {
			parameterConditionwhere.append("and t.E505_03 ='" + e505_03 + "' ");
		}
		
		if (!StringUtil.isBlankString(e505_06)) {
			parameterConditionwhere.append("and t.E505_06 ='" + e505_06 + "' ");
		}
		
		if (!StringUtil.isBlankString(e505_28)) {
			if (e505_28.length() == 14) {
				parameterConditionwhere.append(" and t.E505_28 = '");
				parameterConditionwhere.append(e505_28);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.E505_28 like '");
				parameterConditionwhere.append(e505_28);
				parameterConditionwhere.append("%'");
			}
		}
		
		if (timeDate != null) {
			String timeStr = sdf.format(timeDate);
			parameterConditionwhere.append(" and to_char(t.E505_31,'yyyy-mm-dd') >= '" + timeStr
					+ "'");
		}
		
		if (timeEnDate != null) {
			String timeEnd = sdf.format(timeEnDate);
			parameterConditionwhere.append(" and to_char(t.E505_31,'yyyy-mm-dd') <= '" + timeEnd
					+ "'");
		}
		
		if (!StringUtil.isBlankString(e505_25)) {
			parameterConditionwhere.append("and t.E505_25 ='" + e505_25 + "' ");
		}
		
		if (!StringUtil.isBlankString(e505_26)) {
			parameterConditionwhere.append(" and t.E505_02 in (select e504_01 from e504 e " +
			"where e504_65 is not null and e504_67 is");
			if("0".equals(e505_26)){
				parameterConditionwhere.append(" null");
	
			}else if("1".equals(e505_26)){
				parameterConditionwhere.append(" not null");
			}
			parameterConditionwhere.append(")");
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageIndex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_E505");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.E505_58");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			e505Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VE505 vE505 = null;
			List<VE505> vE505s = new ArrayList<VE505>();
			while (resultSet.next()) {
				 vE505 = new VE505();
				 vE505.setE50501(resultSet.getString("E505_01"));
				 vE505.setE50502(resultSet.getString("E505_02"));
				 vE505.setE50503(resultSet.getString("E505_03"));
				 vE505.setE50504(resultSet.getString("E505_04"));
				 vE505.setE50505(resultSet.getDate("E505_05"));
				 vE505.setE50506(resultSet.getString("E505_06"));
				 vE505.setE50507(resultSet.getString("E505_07"));
				 vE505.setE50508(resultSet.getString("E505_08"));
				 vE505.setE50509(resultSet.getString("E505_09"));
				 vE505.setE50510(resultSet.getString("E505_10"));
				 vE505.setE50511(resultSet.getString("E505_11"));
				 vE505.setE50512(resultSet.getString("E505_12"));
				 vE505.setE50513(resultSet.getString("E505_13"));
				 vE505.setE50514(resultSet.getString("E505_14"));
				 vE505.setE50515(resultSet.getString("E505_15"));
				 vE505.setE50516(resultSet.getString("E505_16"));
				 vE505.setE50517(resultSet.getString("E505_17"));
				 vE505.setE50518(resultSet.getString("E505_18"));
				 vE505.setE50519(resultSet.getString("E505_19"));
				 vE505.setE50520(resultSet.getString("E505_20"));
				 vE505.setE50521(resultSet.getString("E505_21"));
				 vE505.setE50522(resultSet.getString("E505_22"));
				 vE505.setE50523(resultSet.getString("E505_23"));
				 vE505.setE50524(resultSet.getString("E505_24"));
				 vE505.setE50525(resultSet.getString("E505_25"));
				 vE505.setE50526(resultSet.getString("E505_26"));
				 vE505.setE50527(resultSet.getString("E505_27"));
				 vE505.setE50528(resultSet.getString("E505_28"));
				 vE505.setE50529(resultSet.getDate("E505_29"));
				 vE505.setE50530(resultSet.getString("E505_30"));
				 vE505.setE50531(resultSet.getDate("E505_31"));
				 vE505.setE50532(resultSet.getDate("E505_31"));
				 vE505.setE50599(resultSet.getString("E505_99"));
				 vE505.setE50504Zh(resultSet.getString("E505_04_ZH"));
				 vE505.setE50505Str(resultSet.getString("E505_05_STR"));
				 vE505.setE50508Zh(resultSet.getString("E505_08_ZH"));
				 vE505.setE50509Zh(resultSet.getString("E505_09_ZH"));
				 vE505.setE50510Zh(resultSet.getString("E505_10_ZH"));
				 vE505.setE50511Zh(resultSet.getString("E505_11_ZH"));
				 vE505.setE50513Zh(resultSet.getString("E505_13_ZH"));
				 vE505.setE50515Zh(resultSet.getString("E505_15_ZH"));
			
				 vE505.setE50520Zh(resultSet.getString("E505_20_ZH"));
				
				 vE505.setE50525Zh(resultSet.getString("E505_25_ZH"));
				 vE505.setE50528Zh(resultSet.getString("E505_28_ZH"));
				 vE505.setE50529Str(resultSet.getString("E505_29_STR"));
				 vE505s.add(vE505);
			}
			e505Response.setPromptMessage("查询成功");
			e505Response.setRowCount(rowCount);
			e505Response.setVe505(vE505s);
		}catch(Exception e){
			e505Response.setErrorMessage("查询失败");
		}
		return e505Response;
	}

	@Override
	public E505Response deleteE505(E505Request e505Request) {
		E505Response e505Response = new E505Response();
		VE505 ve505 = e505Request.getVe505();
		E504 e504=null;
		boolean state=true;
		try {
			Session session = sessionFactory.getCurrentSession();
			if("0".equals(ve505.getE50526())){//初筛
				String e50501=(String) session.createSQLQuery("select e505_01 from e505 where e505_02=? and e505_26='1'")
								.setString(0, ve505.getE50502()).uniqueResult();
				if(e50501!=null){
					state=false;
					e505Response.setErrorMessage("无法删除初筛信息，已经存在复筛信息！");
				}
			}
			if(state){
				E505 e505 = new E505();
				e505.setE50501(ve505.getE50501());
				session.delete(e505);
				e504=(E504) session.get(E504.class, ve505.getE50502());
				if("0".equals(ve505.getE50526())){//初筛
					e504.setE50465(null);
					e504.setE50466(null);
				}else if("1".equals(ve505.getE50526())){//初筛
					e504.setE50467(null);
					e504.setE50468(null);
				}
				session.update(e504);
			}
		} catch (HibernateException e) {
			e505Response.setErrorMessage("删除失败！");
		}
		return e505Response;
	}

	@Override
	public E505Response renewE505(E505 e505) {
		E505Response e505Response = new E505Response();
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(e505);
			session.flush();
			session.refresh(e505);
			e505Response.setPromptMessage("更新成功！");

		}catch(Exception e){
			e505Response.setErrorMessage("更新失败！"+"/n"+e.getMessage());
		}
		return e505Response;
	}

	
	/**
	 * 查询检查和档案信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E505Response queryE505AndE504(E505Request e505Request) {
		boolean state=true;
		String flag=e505Request.getFlag();
		Date timeDate=e505Request.getTimeStr();
		Date timeEnDate=e505Request.getTimeEnd();
		Map<String, Object>map=e505Request.getMap();
		String suffixSql = e505Request.getSuffixSql();
		E505Response e505Response=new E505Response();
		int pageSize = e505Request.getParameterPagesize();
		int pageIndex = e505Request.getParameterPageindex();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		try {
			String e50457=(String) map.get("institutionCode");
			if("false".equals(flag)){//输入框内容
				E504 e504=(E504) map.get("e504");
				String e50406=e504.getE50406();
				String e50407=e504.getE50407();
				String e50410=e504.getE50410();
				if (!StringUtil.isBlankString(e50406)) {
					parameterConditionwhere.append("and E504_06 ='" + e50406 + "' ");
				}
				if (!StringUtil.isBlankString(e50407)) {
					parameterConditionwhere.append("and E504_07 ='" + e50407 + "' ");
				}
				if (!StringUtil.isBlankString(e50410)) {
					parameterConditionwhere.append("and E504_10 ='" + e50410 + "' ");
				}
			}else if("true".equals(flag)){
				String timeType=(String) map.get("timeType");//时间类型
				String payType=(String) map.get("payType");//付费类型
				String checkType=(String) map.get("checkType");//检查类型
				String addType=(String) map.get("addType");
				String address=(String) map.get("address");
				String referral=(String) map.get("referral");//是否转诊
				String result=(String) map.get("result");//筛查结果
				
				if (!StringUtil.isBlankString(timeType)) {
					parameterConditionwhere.append("and "+timeType+">='" + sdf.format(timeDate) + "' ");
					parameterConditionwhere.append("and "+timeType+"<='" + sdf.format(timeEnDate) + "' ");
				}
				
				if (!StringUtil.isBlankString(payType)) {
					parameterConditionwhere.append("and "+payType);
				}
				
				if (!StringUtil.isBlankString(checkType)) {
					parameterConditionwhere.append("and "+checkType);
				}
				
				if (!StringUtil.isBlankString(referral)) {
					parameterConditionwhere.append("and "+referral);
				}
				
				if (!StringUtil.isBlankString(result)) {
					parameterConditionwhere.append("and "+result);
				}
				
				
				if (!StringUtil.isBlankString(addType)) {
					parameterConditionwhere.append("and "+addType);
					
					if (!StringUtil.isBlankString(address)) {
						if (address.length() == 14) {
							parameterConditionwhere.append("='"+address+"'");
						} else {
							parameterConditionwhere.append(" like '"+address+"%'");
						}
					}
				}
				
			}
//			parameterConditionwhere.append(" and E504_57 = '");
//			parameterConditionwhere.append("41132100000002");
//			parameterConditionwhere.append("'");
			//医疗机构
			if (!StringUtil.isBlankString(e50457)) {
				if (e50457.length() == 14) {
					parameterConditionwhere.append(" and E504_57 = '");
					parameterConditionwhere.append(e50457);
					parameterConditionwhere.append("'");
				} else {
					parameterConditionwhere.append(" and E504_57 like '");
					parameterConditionwhere.append(e50457);
					parameterConditionwhere.append("%'");
				}
			}
			
			if (!StringUtil.isBlankString(suffixSql))
				parameterConditionwhere.append(suffixSql);
			
			Session session=sessionFactory.getCurrentSession();
			
			Object rowCount=session.createSQLQuery("select count(*) from v_e505_and_v_e504 where 1=1 " 
								+parameterConditionwhere.toString()).uniqueResult();
			List<VE505AndVE504>ve505AndVE504s=(List<VE505AndVE504>) session.createSQLQuery("select * from v_e505_and_v_e504 where 1=1 "
								+parameterConditionwhere
								.append("order by e504_59,e504_01").toString())
								.addEntity(VE505AndVE504.class)
								.setFirstResult((pageIndex - 1) * pageSize)
								.setMaxResults(pageSize).list();
			
//			List<VE505AndVE504>ve505AndVE504s=(List<VE505AndVE504>) session.createSQLQuery
//			("select * from   ( select a.* , ROWNUM RN  from v_e505_and_v_e504 a where 1=1 "
//					+parameterConditionwhere
//					.append("order by e504_59  )  where RN BETWEEN "
//							+((pageIndex - 1) * pageSize)+" AND "
//							+(pageSize*pageIndex)).toString())
//					.addEntity(VE505AndVE504.class).list();
			
			e505Response.setRowCount(Long.valueOf(rowCount.toString()));
			e505Response.setVe505AndVE504s(ve505AndVE504s);
//			for(VE505AndVE504 ve505AndVE504:ve505AndVE504s)
//			{
//				System.out.println(ve505AndVE504.getE50406());				
//				
//			}
		} catch (Exception e) {
			state=false;
			e505Response.setErrorMessage(e.getMessage());
		}
		e505Response.setState(state);
		return e505Response;
	}

	@Override
	/**
	 * 查询是否登记
	 */
	public E505Response queryE505ById(E505 e505) {
		boolean state=true;
		E505Response e505Response=new E505Response();
		Session session=sessionFactory.getCurrentSession();
		try {
			String _e50501=e505.getE50501();
			String e50502=e505.getE50502();
			String e50526=e505.getE50526();
			boolean flag="0".equals(e50526);
			String e50501=(String) session.createSQLQuery("select e505_01 from e505 where e505_02=? and e505_26=?")
							.setString(0, e50502).setString(1, e50526).uniqueResult();
			if(e50501!=null){
				state=false;
				String message=flag?"已登记初筛，无法修改档案":"已登记复筛，无法修改初筛信息";
				e505Response.setPromptMessage(message);
			}else {
				if(flag){//档案查询
					VE504 ve504=(VE504) session.get(VE504.class, e50502);
					e505Response.set_ve504(ve504);
				}
			}
		} catch (Exception e) {
			//state=false;
			e505Response.setErrorMessage(e.getMessage());
		}
		e505Response.setState(state);
		return e505Response;
	}
}