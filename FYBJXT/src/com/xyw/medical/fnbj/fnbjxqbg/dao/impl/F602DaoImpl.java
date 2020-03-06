package com.xyw.medical.fnbj.fnbjxqbg.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fnbjxqbg.dao.F602Dao;
import com.xyw.medical.fnbj.model.F601;
import com.xyw.medical.fnbj.model.F602;
import com.xyw.medical.fnbj.model.F602Request;
import com.xyw.medical.fnbj.model.F602Response;
import com.xyw.medical.fnbj.model.VF602;
import com.xyw.sys.util.StringUtil;

public class F602DaoImpl implements F602Dao{
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public F602Response saveF602(F602 f602) {
	
		F602Response f602Response =new F602Response();

		boolean state =true;
		Session session =sessionFactory.getCurrentSession();
		try {
			F602Response   _f602Response=queryF602Id(f602.getF60202(),session);
			
			if(!_f602Response.isState()){
				f602Response.setErrorMessage(_f602Response.getErrorMessage());
				state =_f602Response.isState();
			}
		} catch (Exception e) {
			f602Response.setErrorMessage("保存失败! ");
			e.printStackTrace();
			state =false;
		}
		if(state){
			try {
				session.save(f602);
				session.flush();
				session.refresh(f602);
				f602Response.setPromptMessage("保存成功");
			} catch (Exception e) {
				f602Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
				state =false;
			}
		}
		f602Response.setState(state);
		return f602Response;
	}

	@Override
	public F602Response renewF602(F602 f602) {
		F602Response f602Response =new F602Response();
		
		boolean state =true;
		Session session =sessionFactory.getCurrentSession();
		if(state){
			try {
				session.saveOrUpdate(f602);
				f602Response.setPromptMessage("保存成功");
			} catch (Exception e) {
				f602Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
				state =false;
			}
		}
		f602Response.setState(state);
		return f602Response;
	}

	@Override
	public F602Response queryF602(F602Request f602Request) {
		F602Response f602Response =new F602Response();
		F601 f601=f602Request.getF601();
		String f60103 =f601.getF60103();
		String f60104 =f601.getF60104();
		String f60129 =f601.getF60129();
		String f60155 =f601.getF60155();
		String f60173 =f601.getF60173();
		String f60174 =f601.getF60174();
		String flag =f602Request.getFlag();
		Date timeStr_ = f602Request.getTimeStr();
		Date timeEnd_ = f602Request.getTimeEnd();	
		int parameterPageindex = f602Request.getParameterPageindex();
		int parameterPagesize = f602Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		parameterConditionwhere.append(" and f602_02 in(select t.f601_01 from f601 t where t.f601_74 ");
		
		if (!StringUtil.isBlankString(f60174)) {
			parameterConditionwhere.append(" ='" + f60174 + "' ");
		}else 
			parameterConditionwhere.append(" is null ");

		if (!StringUtil.isBlankString(f60129)) {
			parameterConditionwhere.append(" and t.f601_29 ='" + f60129 + "' ");
		}
		
		if (!StringUtil.isBlankString(f60155)) {
			parameterConditionwhere.append(" and t.f601_55 ='" + f60155 + "' ");
		}
		if("true".equals(flag)){
			
			if (!StringUtil.isBlankString(f60103)) {
				parameterConditionwhere.append(" and t.f601_03 ='" + f60103 + "' ");
			}
			if (!StringUtil.isBlankString(f60104)) {
				parameterConditionwhere.append(" and t.f601_04 ='" + f60104 + "' ");
			}
		
		}else if("false".equals(flag)) {
			String dateField=f602Request.getF60201List().get(0);//这里用来得到字段 
			if (timeStr_ != null) {
				String timeStr = sdf.format(timeStr_);
				parameterConditionwhere.append(" and to_char("+dateField+",'yyyy-mm-dd') >= '" + timeStr+ "'");
			}
			if (timeEnd_ != null) {
				String timeEnd = sdf.format(timeEnd_);
				parameterConditionwhere.append(" and to_char("+dateField+",'yyyy-mm-dd') <= '" + timeEnd+ "'");		
			}
			
		
		}
	
		if (!StringUtil.isBlankString(f60173)) {
			if (f60173.length() == 14) {
				parameterConditionwhere.append(" and t.f601_73 = '");
				parameterConditionwhere.append(f60173);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.f601_73 like '");
				parameterConditionwhere.append(f60173);
				parameterConditionwhere.append("%'");
			}
		}
	
		parameterConditionwhere.append(")");

		
		boolean state =true;
		Connection connection =null;
		CallableStatement callableStatement = null;
		try {
			connection =this.dataSource.getConnection();
			callableStatement =connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_F602");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.f602_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			
			long rowCount = callableStatement.getLong(6);
			f602Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF602 vf602=null;
			List<VF602> vf602s=new ArrayList<VF602>();
			while (resultSet.next()) {
				String f60201 = resultSet.getString("F602_01");
				String f60202 = resultSet.getString("F602_02");
				String f60203 = resultSet.getString("F602_03");
				String f60204 = resultSet.getString("F602_04");
				String f60205 = resultSet.getString("F602_05");
				String f60206 = resultSet.getString("F602_06");
				String f60207 = resultSet.getString("F602_07");
				String f60208 = resultSet.getString("F602_08"); 
				String f60209 = resultSet.getString("F602_09");
				String f60210 = resultSet.getString("F602_10");
				String f60211 = resultSet.getString("F602_11");
				String f60212 = resultSet.getString("F602_12");
				String f60213 = resultSet.getString("F602_13");
				String f60214 = resultSet.getString("F602_14");
				String f60215 = resultSet.getString("F602_15");
				String f60216 = resultSet.getString("F602_16");
				String f60217 = resultSet.getString("F602_17");
				String f60218 = resultSet.getString("F602_18");
				String f60219 = resultSet.getString("F602_19");
				String f60220 = resultSet.getString("F602_20");
				String f60221 = resultSet.getString("F602_21");
				String f60222 = resultSet.getString("F602_22");
				Date f60223 = resultSet.getDate("F602_23");
				String f60224 = resultSet.getString("F602_24");
				String f60225 = resultSet.getString("F602_25");
				String f60226 = resultSet.getString("F602_26");
				Date f60227 = resultSet.getDate("F602_27");
				String f60228 = resultSet.getString("F602_28");
				String f60229 = resultSet.getString("F602_29");
				String _f60159 = resultSet.getString("F601_59");
				String f60226Zh =resultSet.getString("F602_26_ZH");
				String f60156Zh =resultSet.getString("F601_56_ZH");
				String f60159Zh =resultSet.getString("F601_59_ZH");
				
				vf602 =new VF602();
				vf602.setF60201(f60201);
				vf602.setF60202(f60202);
				vf602.setF60203(f60203);
				vf602.setF60204(f60204);
				vf602.setF60205(f60205);
				vf602.setF60206(f60206);
				
				vf602.setF60207(f60207);
				vf602.setF60208(f60208);
				vf602.setF60209(f60209);
				vf602.setF60210(f60210);
				vf602.setF60211(f60211);
				vf602.setF60212(f60212);
				vf602.setF60213(f60213);
				vf602.setF60214(f60214);
				vf602.setF60215(f60215);
				vf602.setF60216(f60216);
				vf602.setF60217(f60217);
				vf602.setF60218(f60218);
				vf602.setF60219(f60219);
				vf602.setF60220(f60220);
				vf602.setF60221(f60221);
				vf602.setF60222(f60222);
				vf602.setF60223(f60223);
				vf602.setF60224(f60224);
				vf602.setF60225(f60225);
				vf602.setF60226(f60226);
				vf602.setF60227(f60227);
				vf602.setF60228(f60228);
				vf602.setF60229(f60229);
				vf602.setF60159(_f60159);
				vf602.setF60226Zh(f60226Zh);
				vf602.setF60156Zh(f60156Zh);
				vf602.setF60159Zh(f60159Zh);
				
				vf602s.add(vf602);
			}
			f602Response.setVf602s(vf602s);
			f602Response.setState(true);
		} catch (Exception e) {
			f602Response.setErrorMessage("查询失败！");
			e.printStackTrace();
			f602Response.setState(false);
		}finally{
			try {
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return f602Response;
	}

	@Override
	public F602Response deleteF602(F602Request f602Request) {
		F602Response f602Response =new F602Response();
		String f60201_ =f602Request.getF602().getF60201();
		
		boolean state =true;
		Session session =sessionFactory.getCurrentSession();
		if(state){
			try {
				F602 f602 =new F602();
				f602.setF60201(f60201_);
				session.delete(f602);
			} catch (Exception e) {
				f602Response.setErrorMessage("删除失败！");
				e.printStackTrace();
				state =false;
			}
		}
		f602Response.setState(state);
		return f602Response;
	}

	@Override
	public F602Response renewF602(F602Request f602Request) {
		F602Response f602Response =new F602Response();
		F601 _f601=f602Request.getF601();
		Session session=sessionFactory.getCurrentSession();
		boolean state=false;
		try {
			
			int count=0;
			int fail=0;//计数器
			List<String> f60201List=f602Request.getF60201List();
			for(String f60201:f60201List)
			{
				String  f60101=(String) session.createSQLQuery("select f602_02 from f602 where f602_01='"+f60201+"'").uniqueResult();
				F601 f601=null;
				if(f60101!=null){
					f601=(F601) session.get(F601.class, f60101);
					if(f601!=null){
						f601.setF60159("5");
						f601.setF60174("1");
						f601.setF60175(_f601.getF60175());
						f601.setF60176(_f601.getF60176());
					}
					else {
						fail++;
						continue;
					}
					count++;
					session.saveOrUpdate(f601);
					session.flush();
					session.refresh(f601);
//					session.saveOrUpdate(f602);
//					session.flush();
//					session.refresh(f602);
					if(count%20==0)
						session.clear();
				}else{
					fail++;
					continue;
				}
			}
			state=true;
			String message=(fail==0)?"已审核成功":("已审核成功"+(f60201List.size()-fail)+"条，"+"已审核失败"+fail+"条");
			f602Response.setPromptMessage(message);
			
		} catch (Exception e) {
			f602Response.setErrorMessage(e.getMessage());
		}
		f602Response.setState(state);
		return f602Response;
	}

	@Override
	public F602Response queryF602Id(String f60202,Session _session) {
		F602Response f602Response =new F602Response();
		Session session=(_session!=null)?_session:sessionFactory.getCurrentSession();
		boolean state=false;
		try {
			String f60201 =(String) session.createSQLQuery("select t.f602_01 from f602 t where t.f602_02=?")
			.setString(0, f60202).uniqueResult();
			if(!StringUtil.isBlankString(f60201)){
				f602Response.setErrorMessage("重复保存！");
			}else {
				state =true;
				f602Response.setPromptMessage("该信息未保存");
			}
		} catch (Exception e) {
			f602Response.setErrorMessage(e.getMessage());		
			}
		f602Response.setState(state);
		return f602Response;
	}
	
	@Override
	public F602Response importF602Excel(F602Request f602Request) {
		boolean state=false;
		String message="";
		List <String> f60205s=new ArrayList<String>();//失败的条码号
		F602Response f602Response =new F602Response();
		List <F602> list=f602Request.getF602List();
		Session session=sessionFactory.getCurrentSession();
		try {
			int i=0,k=0;//i成功计数器  k失败计数器
			Date nowDate=new Date();
			for(F602 f602:list){
				String f60205=f602.getF60205();
					
					Object [] _f602=(Object[]) session.createSQLQuery("select t.f602_01,t.f602_02,t.f602_03" +
							",t.f602_04,t.f602_30 from f602 t where t.f602_05=? ").setString(0, f60205)
							.uniqueResult();
					if(_f602!=null){
						F601 f601=(F601) session.createSQLQuery("select t.* from f601 t where f601_01 = ?")
								  .addEntity(F601.class).setString(0, _f602[1].toString()).uniqueResult();
						if(f601!=null){
							//先保存f601
							f601.setF60169(f602.getF60225());
							f601.setF60170(f602.getF60224());
							f601.setF60171(nowDate);
							f601.setF60172(f602.getF60225());
							f601.setF60173(f602.getF60226());//机构
							session.saveOrUpdate(f601);
							//保存f602
							f602.setF60201(_f602[0].toString());
							f602.setF60202(_f602[1].toString());
							f602.setF60203(_f602[2].toString());
							f602.setF60204(_f602[3].toString());
							f602.setF60230(_f602[4].toString());
							f602.setF60223(nowDate);
							f602.setF60227(nowDate);
							session.saveOrUpdate(f602);
							session.flush();
							++i;
							if(i%20==0)
								session.clear();
						}else{
							++k;
							f60205s.add(f60205);
						}
							
					}else{
						++k;
						f60205s.add(f60205);
					}
			}
			state=true;
			message=(list.size()==i)?"信息全部导入成功":"导入成功"+i+"条,"+"导入失败"+k+"条";
			if(k!=0)
				f602Response.setF60205s(f60205s);
			f602Response.setRowCount(k);
			f602Response.setPromptMessage(message);
			
		} catch (Exception e) {
			e.printStackTrace();
			f602Response.setErrorMessage(e.getMessage());
		}
		f602Response.setState(state);
		return f602Response;
	}

	
}
