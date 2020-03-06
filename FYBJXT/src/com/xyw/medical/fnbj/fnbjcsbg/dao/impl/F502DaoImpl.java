package com.xyw.medical.fnbj.fnbjcsbg.dao.impl;

import java.io.File;
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

import com.xyw.medical.fnbj.fnbjcsbg.dao.F502Dao;
import com.xyw.medical.fnbj.model.F501;
import com.xyw.medical.fnbj.model.F502;
import com.xyw.medical.fnbj.model.F502Request;
import com.xyw.medical.fnbj.model.F502Response;
import com.xyw.medical.fnbj.model.VF502;
import com.xyw.medical.loadPicture.dao.PictureDao;
import com.xyw.medical.loadPicture.model.PictureMessage;
import com.xyw.medical.pictureFactory.CCbg;
import com.xyw.sys.util.StringUtil;

public class F502DaoImpl implements F502Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	@Resource
	private PictureDao pictureDao;

	@SuppressWarnings("unchecked")
	@Override
	public F502Response saveF502(List<Object[]> f502PicArr) {
		int i = 0;// 计数器
		Date f50227 = null;
		String f50201 = null;
		String f50202 = null;
		boolean state = true;
		F502Response f502Response = new F502Response();
		Session session = sessionFactory.getCurrentSession();
		for (Object[] f502Obj : f502PicArr) {
			F502 f502 = (F502) f502Obj[0];
			List<Object[]> picArr = (List<Object[]>) f502Obj[1];
			f50202 = f502.getF50202();
			String f50239 = f502.getF50239();
			try {

				String f50201_ = (String) session
						.createSQLQuery(
								"select f502_01 from F502 t where t.f502_02 =? and t.f502_39=?")
						.setString(0, f50202).setString(1, f50239)
						.uniqueResult();
				if (f50201_ != null) {
					f502Response.setErrorMessage("重复保存！");
					state = false;
				}
				if (state) {
					session.save(f502);
					f50201 = f502.getF50201();
					if (i == 0) {
						f50227 = f502.getF50227();
					}

					if (picArr.size() > 0) {
						PictureMessage message = pictureDao
								.save(picArr, f50201);
						if (!message.isStatus()) {
							f502Response.setState(false);
							f502Response.setPromptMessage("保存图片失败，请联系客服！");
							return f502Response;
						}
					}
					++i;
				}
			} catch (Exception e) {
				state = false;
				f502Response.setErrorMessage(e.getMessage());
			}

		}
		if (i == f502PicArr.size()) {
			f502Response.setRowCount(i);
			if (i == 1) {
				F502 f502 = new F502();
				f502.setF50201(f50201);
				f502Response.setF502(f502);
			}
			F501 f501 = (F501) session.get(F501.class, f50202);
			f501.setF50147("1");
			f501.setF50148(f50227);
			session.update(f501);
			f502Response.setState(true);
			f502Response.setPromptMessage("保存成功");
		} else {
			f502Response.setState(false);
			int fail = f502PicArr.size() - i;
			f502Response.setErrorMessage("保存成功" + i + "条，保存失败" + fail + "条");
		}

		return f502Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F502Response renewF502(F502Request f502Request) {
		F502Response f502Response = new F502Response();
		F502 f502 = f502Request.getF502();
		List<Object[]> picArr = null;
		if (f502Request.getF502PicArr() != null)
			picArr = (List<Object[]>) (f502Request.getF502PicArr().get(0))[0];
		boolean state = true;
		String result=null;
		Session session = sessionFactory.getCurrentSession();
		if (state) {
			try {
				session.saveOrUpdate(f502);
				session.flush();
				session.refresh(f502);
				if (picArr.size() > 0) {
					PictureMessage message = pictureDao.save(picArr, f502
							.getF50201());
					result=message.isStatus()?"图片保存成功":"图片保存失败";
				}
				f502Response.setPromptMessage(result!=null?"修改成功,"+result:"修改成功");
			} catch (Exception e) {
				f502Response.setErrorMessage("保存失败！"+e.getMessage());
				state = false;
			}
		}
		f502Response.setState(state);
		f502Response.setF502(f502);
		return f502Response;
	}

	@Override
	public F502Response queryF502(F502Request f502Request) {
		F502Response f502Response = new F502Response();
		F502 f502 = f502Request.getF502();
		String f50201 = f502.getF50201();
		String f50203 = f502.getF50203();
		String f50204 = f502.getF50204();
		String f50225 = f502.getF50225();
		String f50240 = f502.getF50240();
		String f50241 = f502.getF50241();
		String flag = f502Request.getFlag();
		Date timeStr_ = f502Request.getTimeStr();
		Date timeEnd_ = f502Request.getTimeEnd();
		String suffixSql = f502Request.getSuffixSql();
		int parameterPageindex = f502Request.getParameterPageindex();
		int parameterPagesize = f502Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		if (!StringUtil.isBlankString(f50201)) {
			parameterConditionwhere.append("and t.f502_01 ='" + f50201 + "' ");
		}

		if (!StringUtil.isBlankString(f50203)) {
			parameterConditionwhere.append("and t.f502_03 ='" + f50203 + "' ");
		}
		if (!StringUtil.isBlankString(f50204)) {
			parameterConditionwhere.append("and t.f502_04 ='" + f50204 + "' ");
		}
		
		
		if (!StringUtil.isBlankString(f50240)) {
			parameterConditionwhere.append("and t.f502_40 ='" + f50240 + "' ");
		}
		if (!StringUtil.isBlankString(f50241)) {
			parameterConditionwhere.append("and t.f502_41 ='" + f50241 + "' ");
		}
		if (timeStr_ != null) {
			String timeStr = sdf.format(timeStr_);
			parameterConditionwhere.append(" and t.f502_24_str >= '" + timeStr
					+ "'");
		}
		if (timeEnd_ != null) {
			String timeEnd = sdf.format(timeEnd_);
			parameterConditionwhere.append(" and t.f502_24_str <= '" + timeEnd
					+ "'");
		}
		if (!StringUtil.isBlankString(f50225)) {
			if (f50225.length() == 14) {
				parameterConditionwhere.append(" and t.f502_25 = '");
				parameterConditionwhere.append(f50225);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.f502_25 like '");
				parameterConditionwhere.append(f50225);
				parameterConditionwhere.append("%'");
			}
		}
		
		if (!StringUtil.isBlankString(suffixSql))
			parameterConditionwhere.append(suffixSql);

		boolean state = true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_F502");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.f502_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f502Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF502 vf502 = null;
			List<VF502> vf502s = new ArrayList<VF502>();
			while (resultSet.next()) {
				f50201 = resultSet.getString("F502_01");
				String f50202 = resultSet.getString("F502_02");
				f50203 = resultSet.getString("F502_03");
				f50204 = resultSet.getString("F502_04");
				String f50205 = resultSet.getString("F502_05");
				long f50206 = resultSet.getLong("F502_06");
				String f50207 = resultSet.getString("F502_07");
				String f50208 = resultSet.getString("F502_08");
				String f50209 = resultSet.getString("F502_09");
				double f50210 = resultSet.getDouble("F502_10");
				double f50211 = resultSet.getDouble("F502_11");
				long f50212 = resultSet.getLong("F502_12");
				double f50213 = resultSet.getDouble("F502_13");
				long f50214 = resultSet.getLong("F502_14");
				String f50215 = resultSet.getString("F502_15");
				String f50216 = resultSet.getString("F502_16");
				String f50217 = resultSet.getString("F502_17");
				double f50218 = resultSet.getLong("F502_18");
				double f50219 = resultSet.getLong("F502_19");
				String f50220 = resultSet.getString("F502_20");
				String f50221 = resultSet.getString("F502_21");
				String f50222 = resultSet.getString("F502_22");
				String f50223 = resultSet.getString("F502_23");
				Date f50224 = resultSet.getDate("F502_24");
				f50225 = resultSet.getString("F502_25");
				String f50226 = resultSet.getString("F502_26");
				Date f50227 = resultSet.getDate("F502_27");
				String f50228 = resultSet.getString("F502_28");
				String f50229 = resultSet.getString("F502_29");
				String f50230 = resultSet.getString("F502_30");
				String f50233 = resultSet.getString("F502_33");
				String f50234 = resultSet.getString("F502_34");
				String f50235 = resultSet.getString("F502_35");
				String f50238 = resultSet.getString("F502_38");
				String f50239 = resultSet.getString("F502_39");
				f50240 = resultSet.getString("F502_40");
				f50241 = resultSet.getString("F502_41");
				String f50249 = resultSet.getString("F502_49");
				String f50224Str = resultSet.getString("F502_24_Str");
				String f50227Str = resultSet.getString("F502_27_Str");

				String f50205Zh = resultSet.getString("F502_05_ZH");
				String f50215Zh = resultSet.getString("F502_15_ZH");
				String f50216Zh = resultSet.getString("F502_16_ZH");
				String f50217Zh = resultSet.getString("F502_17_ZH");
				String f50220Zh = resultSet.getString("F502_20_ZH");
				String f50225Zh = resultSet.getString("F502_25_ZH");
				String f50229Zh = resultSet.getString("F502_29_ZH");
				String f50142Zh = resultSet.getString("F501_42_ZH");
				
				vf502 = new VF502();
				vf502.setF50201(f50201);
				vf502.setF50202(f50202);
				vf502.setF50203(f50203);
				vf502.setF50204(f50204);
				vf502.setF50205(f50205);
				vf502.setF50205Zh(f50205Zh);
				vf502.setF50206(f50206);
				vf502.setF50207(f50207);
				vf502.setF50208(f50208);
				vf502.setF50209(f50209);
				vf502.setF50210(f50210);
				vf502.setF50211(f50211);
				vf502.setF50212(f50212);
				vf502.setF50213(f50213);
				vf502.setF50214(f50214);
				vf502.setF50215(f50215);
				vf502.setF50215Zh(f50215Zh);
				vf502.setF50216(f50216);
				vf502.setF50216Zh(f50216Zh);
				vf502.setF50217(f50217);
				vf502.setF50217Zh(f50217Zh);
				vf502.setF50218(f50218);
				vf502.setF50219(f50219);
				vf502.setF50220(f50220);
				vf502.setF50220Zh(f50220Zh);
				vf502.setF50221(f50221);
				vf502.setF50222(f50222);
				vf502.setF50223(f50223);
				vf502.setF50224(f50224);
				vf502.setF50224Str(f50224Str);
				vf502.setF50225(f50225);
				vf502.setF50225Zh(f50225Zh);
				vf502.setF50226(f50226);
				vf502.setF50227(f50227);
				vf502.setF50227Str(f50227Str);
				vf502.setF50228(f50228);
				vf502.setF50229(f50229);
				vf502.setF50229Zh(f50229Zh);
				vf502.setF50230(f50230);
				vf502.setF50233(f50233);
				vf502.setF50234(f50234);
				vf502.setF50235(f50235);
				vf502.setF50238(f50238);
				vf502.setF50239(f50239);
				vf502.setF50240(f50240);
				vf502.setF50241(f50241);
				vf502.setF50249(f50249);
				vf502.setF50142Zh(f50142Zh);
				vf502s.add(vf502);
			}
			f502Response.setVf502s(vf502s);
			f502Response.setState(state);
		} catch (Exception e) {
			f502Response.setErrorMessage("查询失败！");
			f502Response.setState(false);
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
			} catch (SQLException e) {
			}
		}
		return f502Response;
	}

	@Override
	public F502Response deleteF502(F502Request f502Request) {
		F502Response f502Response = new F502Response();
		PictureMessage pictureMessage = null;
		boolean state = true;
		String f50201 = f502Request.getF50201();
		Session session = sessionFactory.getCurrentSession();
		try {
			if (state) {
				F502 f502 = (F502) session.get(F502.class, f50201);
				F501 f501 = (F501) session.get(F501.class, f502.getF50202());
				session.delete(f502);
				f501.setF50147("2");
				f501.setF50148(null);
				session.update(f501);
				pictureMessage = CCbg.deletePics(f50201, session);
				if (pictureMessage.isStatus()) {
					f502Response.setPromptMessage("信息和全部图片删除成功！");
				} else {
					f502Response.setPromptMessage("信息删除成功！，图片删除失败");
				}
			}
		} catch (Exception e) {
			state = false;
			f502Response.setErrorMessage(e.getMessage());
		}
		f502Response.setState(state);
		return f502Response;
	}
	
	
	@Override
	public F502Response getEmptyFile(boolean del) {
		F502Response f502Response = new F502Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			
			List<String[]> obj=(List<String[]>)session.createSQLQuery("SELECT pic01,pic03,pic04 FROM " +
						"picture T where t.pic02 in (SELECT pic02 FROM " +
						"picture  group by pic02 having count(pic02)>2)").list();
			List<VF502> vf502s=new ArrayList<VF502>();
			for(Object [] param:obj)
			{
				//System.out.println(new File(param[1].toString()+param[2]));
				File file= new File(param[1].toString()+param[2]);
				if (file.exists() && file.isFile()){
					if(file.length()==0){
						VF502 f502 =new VF502();
						f502.setF50203(param[0].toString());
						vf502s.add(f502);
						System.out.println(param[0].toString());
						if(del)
							file.delete();
					}
				}	
			}	
			f502Response.setVf502s(vf502s);	
		} catch (Exception e) {
			state = false;
			f502Response.setErrorMessage(e.getMessage());
		}
		f502Response.setState(state);
		return f502Response;
	}

}
