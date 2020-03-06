package com.xyw.medical.etbj.etsfdj.dao.impl;

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

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.etbj.etsfdj.dao.E305Dao;
import com.xyw.medical.etbj.model.E305;
import com.xyw.medical.etbj.model.E305Request;
import com.xyw.medical.etbj.model.E305Response;
import com.xyw.medical.etbj.model.VE305;
import com.xyw.medical.fnbj.model.F301;
import com.xyw.sys.util.StringUtil;
import com.xyw.sys.util.TimeSwitch;

public class E305DaoImpl implements E305Dao{
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	@Override
	public E305Response deleteE305(E305Request e305Request) {
		E305Response e305Response = new E305Response();
		E305 e305 = e305Request.getE305();
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(e305);
			e305Response.setPromptMessage("删除成功！");
		} catch (HibernateException e) {
			e.printStackTrace();
			e305Response.setErrorMessage("删除失败！");
		}
		return e305Response;
	}

	@Override
	public E305Response updateE305(E305 e305) {
		boolean state = true;
		E305Response e305Response = new E305Response();
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(e305);
			session.flush();
			session.refresh(e305);
		} catch (Exception e) {
			e305Response.setState(false);
			e305Response.setErrorMessage("修改失败! ");
			e.printStackTrace();
		}
		e305Response.setState(state);
		return e305Response;
	}

	@Override
	public E305Response queryE305H(E305Request e305Request) {
		E305Response e305Response = new E305Response();
		try {
			Session session = sessionFactory.getCurrentSession();
			E305 e305 = (E305) session.get(E305.class, e305Request.getE305().getE30501());
			
			e305Response.setE305(e305);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return e305Response;
	}

	@Override
	public E305Response queryE305(E305Request e305Request) {
		boolean state = true;
		E305Response e305Response = new E305Response();
		E305 e305 = e305Request.getE305();
		String f30102 = e305Request.getF301_02();
		String f30105 = e305Request.getF301_05();
		String e30581 = e305.getE30581();  
		String e30595 = e305.getE30595(); 
		Date e30574Start = e305Request.getTimeStart();
		Date e30574End = e305Request.getTimeEnd();
		int parameterPageindex = e305Request.getParameterPageindex();
		int parameterPagesize = e305Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		if(!StringUtil.isBlankString(f30102)) {
			sql.append(" and e305_11 ='" + f30102 + "' ");
		}
		if(!StringUtil.isBlankString(f30105)) {
			sql.append(" and f301_05 ='" + f30105 + "' ");
		}
		if(!StringUtil.isBlankString(e30595)) {
			sql.append(" and "+e30595);
		}
		if (e30574Start != null) {
			String e30574Start_ = sdf.format(e30574Start);
			sql.append(" and t.e305_74_Str >='" + e30574Start_ + "' ");
		}
		if (e30574End != null) {
			String e30574End_ = sdf.format(e30574End);
			sql.append(" and t.e305_74_Str <='" + e30574End_ + "' ");
		}
		
		if (!StringUtil.isBlankString(e30581)) {
			if (e30581.length() == 14) {
				sql.append(" and t.e305_81 = '"); 
				sql.append(e30581);
				sql.append("'");
			} else {
				sql.append(" and t.e305_81 like '");
				sql.append(e30581);
				sql.append("%'");
			}
		}		
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_E305");
			callableStatement.setString(4, sql.toString());
			callableStatement.setString(5, "t.E305_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			e305Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);

			VE305 ve305 = null;
			List<VE305> ve305s = new ArrayList<VE305>();
			while (resultSet.next()) {
				long e30501 = resultSet.getLong("E305_01");
				String e30502=resultSet.getString("E305_02");
				Date e30504 =resultSet.getDate("E305_04");
				String e30504_Str =resultSet.getString("E305_04_Str");
				String e30507 =resultSet.getString("E305_07");
				String e30511 =resultSet.getString("E305_11");
				String e30517_ZH=resultSet.getString("E305_17_ZH");
				String e30574_Str =resultSet.getString("E305_74_Str");
				String e30576_Str =resultSet.getString("E305_76_Str");
				String e30577 =resultSet.getString("E305_77");
				long e30578 =resultSet.getLong("E305_78");
				String e30581_ZH =resultSet.getString("E305_81_ZH");
				ve305 =new VE305();
				ve305.setE30501(e30501);
				ve305.setE30502(e30502);
				ve305.setE30504(e30504);
				ve305.setE30504Str(e30504_Str);
				ve305.setE30507(e30507);
				ve305.setE30511(e30511);
				ve305.setE30517Zh(e30517_ZH);
				ve305.setE30574Str(e30574_Str);
				ve305.setE30576Str(e30576_Str);
				ve305.setE30577(e30577);
				ve305.setE30578(e30578);
				ve305.setE30581(resultSet.getString("E305_81"));
				ve305.setE30581Zh(e30581_ZH);
				ve305.setE30595(resultSet.getString("E305_95"));
				ve305.setE30597(resultSet.getString("E305_97"));
				ve305.setE305101(resultSet.getString("E305_101"));
				ve305s.add(ve305);

			}
			e305Response.setState(state);
			e305Response.setVe305s(ve305s);
		} catch (SQLException e) {
			e.printStackTrace();
			e305Response.setState(false);
			e305Response.setErrorMessage("查询失败！");
		} finally {
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

		return e305Response;
	}

	@Override
	public E305Response saveE305(E305 e305) {
		E305Response e305Response = new E305Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		Object[] e301Fields = (Object[]) session.createSQLQuery("select e301_03,e301_27 " +
								"from e301 where e301_01=?").setParameter(0, e305.getE30578())
								.uniqueResult();
		Object[] e305Fields = (Object[]) session
		.createSQLQuery(
				"select max(e305_74_str),max(e305_81_zh) from v_e305  where e305_02=? and f301_05=?")
				.setParameter(0, e301Fields[0]).setParameter(1, e301Fields[1]).uniqueResult();
		if (e305Fields[0]!= null) {
			state = false;
			e305Response.setErrorMessage("该信息已经被" + e305Fields[1]
						+ "于"+e305Fields[0]+ "登记过随访信息，不能重复登记！");
			
		}
		if (state) {
			try {
				session.save(e305);
				session.flush();
				session.refresh(e305);
			} catch (Exception e) {
				e.printStackTrace();
				e305Response.setErrorMessage("保存失败!");
				state = false;
			}
		}

		e305Response.setState(state);
		return e305Response;
	}
	@Override
	public E305Response queryE305D(E305Request e305Request) {
		E305Response e305Response = new E305Response();
		e305Response.setState(true);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long e305_78 = e305Request.getE305().getE30578();
		if (e305_78 > 0) {
			try {
				Session session = sessionFactory.getCurrentSession();
				SQLQuery query = session
						.createSQLQuery("select * from e305 t where t.e305_78 ='"
								+ e305_78 + "'");
				List<E305> list = query.addEntity(E305.class).list();
				List<VE305> ve305s = new ArrayList<VE305>();
				for(int i = 0;i<list.size();i++){
					VE305 ve305 = new VE305();
					long e30501 = list.get(i).getE30501();
					ve305.setE30501(e30501);
					ve305.setE30502(list.get(i).getE30502());
					ve305.setE30511(list.get(i).getE30511());
					ve305.setE30574Str(sdf.format(list.get(i).getE30574()));
					ve305s.add(ve305);
				}
				e305Response.setVe305s(ve305s);
			} catch (Exception e) {
				e.printStackTrace();
				e305Response.setState(false);
				e305Response.setErrorMessage("查询失败！");
			}
		}
		return e305Response;
	}
	@Override
	public E305Response queryE305All(E305Request e305Request) {
		E305Response e305Response = new E305Response();
		List<VE305> ve305s = new ArrayList<VE305>();
		boolean state = true;
		VE305 ve305 =null;
		E305 e305 = e305Request.getE305();
		String e30502= e305.getE30502();
		String e305011 = e305.getE30511();
		long e305078 = e305.getE30578();
		StringBuffer sql = new StringBuffer();
		try{
			if (e305078!=0) {
				sql.append(" and t.e305_78 = " + e305078 + "");
			}
			if (!StringUtil.isBlankString(e30502)) {
				sql.append(" and t.e305_02 = '" + e30502 + "'");
			}
			if (!StringUtil.isBlankString(e305011)) {
				sql.append(" and t.e305_11 = " + e305011);
			}
			
			Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session
				.createSQLQuery("select * from V_E305 t where 1=1"+sql.toString() );
		List<VE305> list = query.addEntity(VE305.class).list();
		e305Response.setVe305s(list);
		}catch(HibernateException e){
			state =false;
			e.printStackTrace();
		}
		
		e305Response.setState(state);
		return e305Response;
	}
}
