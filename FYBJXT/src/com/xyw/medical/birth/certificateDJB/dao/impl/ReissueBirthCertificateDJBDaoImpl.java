package com.xyw.medical.birth.certificateDJB.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.birth.certificateDJB.dao.ReissueBirthCertificateDJBDao;
import com.xyw.medical.birth.model.D305;
import com.xyw.medical.birth.model.D305Request;
import com.xyw.medical.birth.model.D305Response;
import com.xyw.medical.birth.model.VD305;
import com.xyw.sys.util.StringUtil;

public class ReissueBirthCertificateDJBDaoImpl implements
		ReissueBirthCertificateDJBDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;
	
	@Override
	@SuppressWarnings("unchecked")
	public D305Response saveD305(D305Request d305Request) {
		D305Response d305Response = new D305Response();
		boolean state =true;
		D305 d305 = d305Request.getD305();
		String d305_33 = d305.getD30533();
		String d305_34 = d305.getD30534();
		String first = d305_34.substring(0, 1);
		long d30534 = Long.valueOf(d305_34.substring(1,d305_34.length()));
		
		String d30502_ =d305.getD30502();
		String d30533_ =d305.getD30533();
		
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = null;
		List<Object> listA = null;
		List<Object> list305 = null;
		
		try {
			StringBuffer SqlD =new StringBuffer("select t.d305_01 from D305 t where t.d305_02 = ? and t.D305_33 = ? ");
			SQLQuery sqlQueryD = session.createSQLQuery(SqlD.toString());
			sqlQueryD.setString(0, d30502_);
			sqlQueryD.setString(1, d30533_);
			List<Object> listB = sqlQueryD.list();
			if(listB.size() > 0)
			{
				state = false;
				d305Response.setErrorMessage("重复登记!");
			}
			
			if(state){
				StringBuffer d501Sql = new StringBuffer("select t.d501_01 from d501 t where t.d501_02 = ? and t.d501_06 = ? and ? >= to_number(t.d501_07) and ? <= to_number(t.d501_08)");
				
				SQLQuery sqlQuery = session.createSQLQuery(d501Sql.toString());
				
				sqlQuery.setString(0, d305.getD30536());
				sqlQuery.setString(1, first);
				sqlQuery.setLong(2, d30534);
				sqlQuery.setLong(3, d30534);
				
				list = sqlQuery.list();
				if(list.size() != 1)
				{
					state = false;
					d305Response.setErrorMessage("该证号不在申领范围!");
					return d305Response;
				}
			}
		   if(state){	
				StringBuffer d505Sql = new StringBuffer("select t.d505_01 from d505 t where t.d505_05 = '1' and t.d505_03 = ? ");
				SQLQuery sqlQueryA = session.createSQLQuery(d505Sql.toString());
				
				sqlQueryA.setString(0, d305_34);
				listA = sqlQueryA.list();
				if(listA.size() <= 0)
				{
					state = false;
					d305Response.setErrorMessage("该新证号已经使用!");
					return d305Response;
				}
		   }
		   if(state){
				StringBuffer d305Sql = new StringBuffer("select t.d305_01 from d305 t where t.d305_33 = ? and t.d305_34 = ? ");
				SQLQuery sqlQueryB = session.createSQLQuery(d305Sql.toString());
				sqlQueryB.setString(0, d305_33);
				sqlQueryB.setString(1, d305_34);
				list305 = sqlQueryB.list();
				if(list305.size() > 0)
				{
					state = false;
					d305Response.setErrorMessage("相同的原证和新证已经使用!");
					return d305Response;
				}
		   }
		   if(state){
				Long result = (Long) session.save(d305);
				if (result > 0) {
					d305Response.setPromptMessage("补发登记成功！");
					state = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			d305Response.setErrorMessage("补发登记失败！");
			state = false;
		}
		d305Response.setStatus(state);
		return d305Response;
	}

	@Override
	public D305Response queryD305(D305Request d305Request) {
		D305Response d305Response = new D305Response();
		String d30505_p = d305Request.getD305().getD30505();//出生地址
		String d30536_p = d305Request.getD305().getD30536();//补证机构
		String d30502_p = d305Request.getD305().getD30502();//婴儿姓名
		String d30516_p = d305Request.getD305().getD30516();//母亲姓名
		String d30518_p = d305Request.getD305().getD30518();//母亲身份证
		String d30522_p = d305Request.getD305().getD30522();//父亲姓名
		String d30524_p = d305Request.getD305().getD30524();//父亲身份证
		String d30533_p = d305Request.getD305().getD30533();//原出生证号
		Date d30537Start = d305Request.getD30537Start();
		Date d30537End = d305Request.getD30537End();
		int parameterPageIndex = d305Request.getParameterPageindex();
		int parameterPageSize = d305Request.getParameterPagesize();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		String flag_ =d305Request.getFlag();
		if(flag_.equals("补发")){
			parameterConditionwhere.append(" and t.d305_39 != '0' ");
		}else if(flag_.equals("信息化前补发")){
			parameterConditionwhere.append(" and t.d305_39 = '0' ");
		}
		if(!StringUtil.isBlankString(d30502_p)){
			parameterConditionwhere.append(" and t.d305_02 = '");
			parameterConditionwhere.append(d30502_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d30516_p)){
			parameterConditionwhere.append(" and t.d305_16 = '");
			parameterConditionwhere.append(d30516_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d30518_p)){
			parameterConditionwhere.append(" and t.d305_18 = '");
			parameterConditionwhere.append(d30518_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d30522_p)){
			parameterConditionwhere.append(" and t.d305_22 = '");
			parameterConditionwhere.append(d30522_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d30524_p)){
			parameterConditionwhere.append(" and t.d305_24 = '");
			parameterConditionwhere.append(d30524_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d30533_p)){
			parameterConditionwhere.append(" and t.d305_33 = '");
			parameterConditionwhere.append(d30533_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d30505_p)){
			parameterConditionwhere.append(" and t.d305_05 like '");
			parameterConditionwhere.append(d30505_p);
			parameterConditionwhere.append("%'");
		}
		if(d30537Start != null)
		{
			String d30537Start_p = simpleDateFormat.format(d30537Start);
			parameterConditionwhere.append(" and t.d305_37 >= to_date('" + d30537Start_p + "', 'yyyy/mm/dd')");
		}
		if(d30537End != null)
		{
			String d30537End_p = simpleDateFormat.format(d30537End);
			parameterConditionwhere.append(" and t.d305_37 <= to_date('" + d30537End_p + "', 'yyyy/mm/dd')");
		}
		if(!StringUtil.isBlankString(d30536_p))
		{
			if(d30536_p.length() == 14)
			{
				parameterConditionwhere.append(" and t.d305_36 = '");
				parameterConditionwhere.append(d30536_p);
				parameterConditionwhere.append("'");
			}else
			{
				parameterConditionwhere.append(" and t.d305_36 like '");
				parameterConditionwhere.append(d30536_p);
				parameterConditionwhere.append("%'");
			}
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageIndex);
			callableStatement.setInt(2, parameterPageSize);
			callableStatement.setString(3, "V_D305");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D305_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			
			long rowCount = callableStatement.getLong(6);
			d305Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			
			VD305 vd305 = null;
			List<VD305> vd305s = new ArrayList<VD305>();
			
			while(resultSet.next()){
				long d30501 = resultSet.getLong("D305_01");
				String d30502 = resultSet.getString("D305_02");
				String d30503 = resultSet.getString("D305_03");
				String d30503_Zh = resultSet.getString("D305_03_ZH");
				String d30504 = resultSet.getString("D305_04");
				String d30505 = resultSet.getString("D305_05");
				int d30506 = resultSet.getInt("D305_06");
				int d30507 = resultSet.getInt("D305_07");
				double d30508 = resultSet.getDouble("D305_08");
				double d30509 = resultSet.getDouble("D305_09");
				String d30510 = resultSet.getString("D305_10");
				String d30511 = resultSet.getString("D305_11");
				String d30511_Zh = resultSet.getString("D305_11_ZH");
				String d30512 = resultSet.getString("D305_12");
				Date d30513 = resultSet.getDate("D305_13");
				String d30514 = resultSet.getString("D305_14");
				String d30515 = resultSet.getString("D305_15");
				String d30516 = resultSet.getString("D305_16");
				String d30517 = resultSet.getString("D305_17");
				String d30517_Zh = resultSet.getString("D305_17_Zh");
				String d30518 = resultSet.getString("D305_18");
				String d30519 = resultSet.getString("D305_19");
				String d30519_Zh = resultSet.getString("D305_19_ZH");
				String d30520 = resultSet.getString("D305_20");
				String d30520_Zh = resultSet.getString("D305_20_ZH");
				String d30521 = resultSet.getString("D305_21");
				String d30522 = resultSet.getString("D305_22");
				String d30523 = resultSet.getString("D305_23");
				String d30523_Zh = resultSet.getString("D305_23_ZH");
				String d30524 = resultSet.getString("D305_24");
				String d30525 = resultSet.getString("D305_25");
				String d30525_Zh = resultSet.getString("D305_25_ZH");
				String d30526 = resultSet.getString("D305_26");
				String d30526_Zh = resultSet.getString("D305_26_ZH");
				String d30527 = resultSet.getString("D305_27");
				String d30528 = resultSet.getString("D305_28");
				String d30529 = resultSet.getString("D305_29");
				String d30529_Zh = resultSet.getString("D305_29_ZH");
				String d30530 = resultSet.getString("D305_30");
				String d30530_Zh = resultSet.getString("D305_30_ZH");
				String d30531 = resultSet.getString("D305_31");
				String d30532 = resultSet.getString("D305_32");
				String d30532_Zh = resultSet.getString("D305_32_ZH");
				String d30533 = resultSet.getString("D305_33");
				String d30534 = resultSet.getString("D305_34");
				Date d30535 = resultSet.getDate("D305_35");
				String d30536 = resultSet.getString("D305_36");
				String d30536_Zh = resultSet.getString("D305_36_ZH");
				Date d30537 = resultSet.getDate("D305_37");
				String d30538 = resultSet.getString("D305_38");
				String d30538_Zh = resultSet.getString("D305_38_ZH");
				String d30540 = resultSet.getString("D305_40");
				Date d30541 = resultSet.getDate("D305_41");
				String d30542 = resultSet.getString("D305_42");
				String d30545 = resultSet.getString("D305_45");
				
				vd305 = new VD305();
				
				vd305.setD30501(d30501);
				vd305.setD30502(d30502);
				vd305.setD30503(d30503);
				vd305.setD30503_Zh(d30503_Zh);
				vd305.setD30504(d30504);
				vd305.setD30505(d30505);
				vd305.setD30506(d30506);
				vd305.setD30507(d30507);
				vd305.setD30508(d30508);
				vd305.setD30509(d30509);
				vd305.setD30510(d30510);
				vd305.setD30511(d30511);
				vd305.setD30511_Zh(d30511_Zh);
				vd305.setD30512(d30512);
				if(d30513 != null){
					String d30513_str = simpleDateFormat.format(d30513);
					vd305.setD30513(d30513_str);
				}
				vd305.setD30514(d30514);
				vd305.setD30515(d30515);
				vd305.setD30516(d30516);
				vd305.setD30517(d30517);
				vd305.setD30517_Zh(d30517_Zh);
				vd305.setD30518(d30518);
				vd305.setD30519(d30519);
				vd305.setD30519_Zh(d30519_Zh);
				vd305.setD30520(d30520);
				vd305.setD30520_Zh(d30520_Zh);
				vd305.setD30521(d30521);
				vd305.setD30522(d30522);
				vd305.setD30523(d30523);
				vd305.setD30523_Zh(d30523_Zh);
				vd305.setD30524(d30524);
				vd305.setD30525(d30525);
				vd305.setD30525_Zh(d30525_Zh);
				vd305.setD30526(d30526);
				vd305.setD30526_Zh(d30526_Zh);
				vd305.setD30527(d30527);
				vd305.setD30528(d30528);
				vd305.setD30529(d30529);
				vd305.setD30529_Zh(d30529_Zh);
				vd305.setD30530(d30530);
				vd305.setD30530_Zh(d30530_Zh);
				vd305.setD30531(d30531);
				vd305.setD30532(d30532);
				vd305.setD30532_Zh(d30532_Zh);
				vd305.setD30533(d30533);
				vd305.setD30534(d30534);
				if(d30535 != null){
					String d30535_str = simpleDateFormat.format(d30535);
					vd305.setD30535(d30535_str);
				}
				vd305.setD30536(d30536);
				vd305.setD30536_Zh(d30536_Zh);
				if(d30537 != null){
					String d30537_str = simpleDateFormat.format(d30537);
					vd305.setD30537(d30537_str);
				}
				vd305.setD30538(d30538);
				vd305.setD30538_Zh(d30538_Zh);
				vd305.setD30540(d30540);
				if(d30541 != null){
					String d30541_str = simpleDateFormat.format(d30541);
					vd305.setD30541(d30541_str);
				}
				vd305.setD30542(d30542);
				vd305.setD30545(d30545);
				
				vd305s.add(vd305);
			}
			d305Response.setVd305s(vd305s);
		} catch (Exception e) {
			e.printStackTrace();
			d305Response.setErrorMessage("查询失败！");
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return d305Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public D305Response updateD305(D305 d305){
		boolean state =true;
		D305Response d305Response =new D305Response();
		Session session =sessionFactory.getCurrentSession();
		List<Object> listD301 = null;
		try {
			String sql ="select * from d301 t where t.d301_42='4' and t.d301_57 ="+d305.getD30501();   //2  补发    4 以往年度补发         (t.d301_42 ='2' or t.d301_42='4')
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
			listD301 = sqlQuery.list();
			if(listD301.size() >0){
				d305Response.setErrorMessage("信息化之前补发打印已保存，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			state = false;
			d305Response.setErrorMessage("保存失败！");
			e.printStackTrace();
		}
		if(state){
			try {
				session.saveOrUpdate(d305);
			} catch (Exception e) {
				state =false;
				d305Response.setErrorMessage("保存失败！");
				e.printStackTrace();
			}
		}
		d305Response.setStatus(state);
		return d305Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public D305Response deleteD305(D305Request d305Request) {
		boolean state =true;
		long d30501 =d305Request.getD305().getD30501();
		D305Response d305Response =new D305Response();
		Session session =sessionFactory.getCurrentSession();
		List<Object> listD301 = null;
		try {
			String sql ="select * from d301 t where t.d301_42='4' and t.d301_57 ="+d30501;   //2  补发    4 以往年度补发         (t.d301_42 ='2' or t.d301_42='4')
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
			listD301 = sqlQuery.list();
			if(listD301.size() >0){
				d305Response.setErrorMessage("信息化之前补发打印已保存，不能删除!");
				state = false;
			}
		} catch (Exception e) {
			state = false;
			d305Response.setErrorMessage("删除失败！");
			e.printStackTrace();
		}
		if(state){
			try {
				D305 d305 =new D305();
				d305.setD30501(d30501);
				session.delete(d305);
				d305Response.setPromptMessage("删除成功！");
			} catch (Exception e) {
				state =false;
				d305Response.setErrorMessage("删除失败！");
				e.printStackTrace();
			}
		}
		d305Response.setStatus(state);
		return d305Response;
	}

}
