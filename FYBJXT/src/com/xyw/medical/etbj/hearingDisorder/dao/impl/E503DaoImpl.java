package com.xyw.medical.etbj.hearingDisorder.dao.impl;

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

import com.xyw.medical.etbj.hearingDisorder.dao.E503Dao;
import com.xyw.medical.etbj.model.E503;
import com.xyw.medical.etbj.model.E503Request;
import com.xyw.medical.etbj.model.E503Response;
import com.xyw.medical.etbj.model.VE503;
import com.xyw.sys.util.StringUtil;

public class E503DaoImpl implements E503Dao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	private boolean VE503;
	@Override
	public E503Response deleteE503(E503Request e503Request) {
		E503Response e503Response=new E503Response();
		e503Response.setState(false);
		E503 e503=new E503();
		e503.setE50301(e503Request.getE50301());
		try {
			if(e503.getE50301()!=0){
				Session session=sessionFactory.getCurrentSession();
				E503 _e503=(E503) session.get(E503.class, e503.getE50301());
				if(_e503!=null){
					session.delete(_e503);
					e503Response.setState(true);
					e503Response.setPromptMessage("删除成功");
					return e503Response;
				}
			}
			e503Response.setErrorMessage("删除失败");
		} catch (Exception e) {
			e503Response.setState(false);
			e503Response.setErrorMessage("删除异常");
		}
		return e503Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E503Response queryE503(E503Request e503Request) {
		E503Response e503Response=new E503Response();
		e503Response.setState(false);
		E503 e503 = e503Request.getE503();
		String e50305=e503.getE50305();
		String e50312=e503.getE50312();
		String e50313=e503.getE50313();
		String e50314=e503.getE50314();
		String e50317=e503.getE50317();
		String e50318=e503.getE50318();
		String e50388=e503.getE50388();
		String flag = e503Request.getFlag();
		Date timeStart = e503Request.getTimeStr();
		Date timeEnd = e503Request.getTimeEnd();
		int parameterPageindex = e503Request.getParameterPageindex();
		int parameterPagesize = e503Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		if ("true".equals(flag)) {
			if (!StringUtil.isBlankString(e50305)) {
				parameterConditionwhere
						.append("and t.e503_05='" + e50305 + "'");
			}
			if (!StringUtil.isBlankString(e50312)) {
				parameterConditionwhere
						.append("and t.e503_12='" + e50312 + "'");
			}
			if (!StringUtil.isBlankString(e50313)) {
				parameterConditionwhere
						.append("and t.e503_13='" + e50313 + "'");
			}
			if (!StringUtil.isBlankString(e50314)) {
				parameterConditionwhere
						.append("and t.e503_14='" + e50314 + "'");
			}
			if (!StringUtil.isBlankString(e50317)) {
				parameterConditionwhere
						.append("and t.e503_17='" + e50317 + "'");
			}
			if (!StringUtil.isBlankString(e50318)) {
				parameterConditionwhere
						.append("and t.e503_18='" + e50318 + "'");
			}
		}
		if ("false".equals(flag)) {
			if (timeStart != null) {
				parameterConditionwhere.append("and t.e503_90_str >='"
						+ sdf.format(timeStart) + "'");
			}
			if (timeEnd != null) {
				parameterConditionwhere.append("and t.e503_90_str <= '"
						+ sdf.format(timeEnd) + "'");
			}
		}
		if (!StringUtil.isBlankString(e50388)) {
			if (e50388.length() == 14) {
				parameterConditionwhere.append(" and t.e503_88 = '");
				parameterConditionwhere.append(e50388);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.e503_88 like '");
				parameterConditionwhere.append(e50388);
				parameterConditionwhere.append("%'");
			}
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_E503");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.e503_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			e503Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet)callableStatement.getObject(7);
			List<VE503> ve503s= new ArrayList<VE503>();
			VE503 ve503=null;
			if(resultSet.next()){				
				ve503=new VE503();
				ve503.setE50301(resultSet.getLong("E503_01"));
				ve503.setE50302(resultSet.getLong("E503_02"));
				ve503.setE50303(resultSet.getLong("E503_03"));
				ve503.setE50304(resultSet.getString("E503_04"));
				ve503.setE50305(resultSet.getString("E503_05"));
				ve503.setE50306(resultSet.getString("E503_06"));
				ve503.setE50307(resultSet.getString("E503_07"));
				ve503.setE50308(resultSet.getString("E503_08"));
				ve503.setE50309(resultSet.getString("E503_09"));
				ve503.setE50310(resultSet.getString("E503_10"));
				ve503.setE50311(resultSet.getString("E503_11"));
				ve503.setE50312(resultSet.getString("E503_12"));
				ve503.setE50313(resultSet.getString("E503_13"));
				ve503.setE50314(resultSet.getString("E503_14"));
				ve503.setE50315(resultSet.getShort("E503_15"));
				ve503.setE50316(resultSet.getString("E503_16"));
				ve503.setE50317(resultSet.getString("E503_17"));
				ve503.setE50318(resultSet.getString("E503_18"));
				ve503.setE50319(resultSet.getShort("E503_19"));
				ve503.setE50320(resultSet.getString("E503_20"));
				ve503.setE50321(resultSet.getDate("E503_21"));
				ve503.setE50322(resultSet.getString("E503_22"));
				ve503.setE50323(resultSet.getString("E503_23"));
				ve503.setE50324(resultSet.getString("E503_24"));
				ve503.setE50325(resultSet.getString("E503_25"));	
				ve503.setE50326(resultSet.getString("E503_26"));
				ve503.setE50327(resultSet.getShort("E503_27"));
				ve503.setE50328(resultSet.getShort("E503_28"));
				ve503.setE50329(resultSet.getDouble("E503_29"));
				ve503.setE50330(resultSet.getString("E503_30"));
				ve503.setE50331(resultSet.getString("E503_31"));
				ve503.setE50332(resultSet.getString("E503_32"));
				ve503.setE50333(resultSet.getString("E503_33"));
				ve503.setE50334(resultSet.getString("E503_34"));
				ve503.setE50335(resultSet.getByte("E503_35"));
				ve503.setE50336(resultSet.getByte("E503_36"));
				ve503.setE50337(resultSet.getString("E503_37"));
				ve503.setE50338(resultSet.getString("E503_38"));
				ve503.setE50339(resultSet.getString("E503_39"));
				ve503.setE50340(resultSet.getString("E503_40"));
				ve503.setE50341(resultSet.getString("E503_41"));
				ve503.setE50342(resultSet.getString("E503_42"));
				ve503.setE50343(resultSet.getString("E503_43"));
				ve503.setE50344(resultSet.getString("E503_44"));
				ve503.setE50345(resultSet.getString("E503_45"));
				ve503.setE50346(resultSet.getString("E503_46"));
				ve503.setE50347(resultSet.getString("E503_47"));
				ve503.setE50348(resultSet.getString("E503_48"));
				ve503.setE50349(resultSet.getString("E503_49"));
				ve503.setE50350(resultSet.getString("E503_50"));
				ve503.setE50351(resultSet.getString("E503_51"));
				ve503.setE50352(resultSet.getString("E503_52"));	
				ve503.setE50353(resultSet.getString("E503_53"));
				ve503.setE50354(resultSet.getString("E503_54"));
				ve503.setE50355(resultSet.getString("E503_55"));
				ve503.setE50356(resultSet.getString("E503_56"));
				ve503.setE50357(resultSet.getString("E503_57"));
				ve503.setE50358(resultSet.getShort("E503_58"));
				ve503.setE50359(resultSet.getString("E503_59"));
				ve503.setE50360(resultSet.getDate("E503_60"));
				ve503.setE50361(resultSet.getString("E503_61"));
				ve503.setE50362(resultSet.getString("E503_62"));
				ve503.setE50363(resultSet.getString("E503_63"));
				ve503.setE50364(resultSet.getString("E503_64"));
				ve503.setE50365(resultSet.getString("E503_65"));
				ve503.setE50366(resultSet.getString("E503_66"));	
				ve503.setE50367(resultSet.getString("E503_67"));
				ve503.setE50368(resultSet.getString("E503_68"));
				ve503.setE50369(resultSet.getString("E503_69"));
				ve503.setE50370(resultSet.getString("E503_70"));
				ve503.setE50371(resultSet.getString("E503_71"));
				ve503.setE50372(resultSet.getString("E503_72"));
				ve503.setE50373(resultSet.getString("E503_73"));
				ve503.setE50374(resultSet.getString("E503_74"));
				ve503.setE50375(resultSet.getString("E503_75"));
				ve503.setE50376(resultSet.getString("E503_76"));
				ve503.setE50377(resultSet.getString("E503_77"));
				ve503.setE50378(resultSet.getString("E503_78"));
				ve503.setE50379(resultSet.getString("E503_79"));
				ve503.setE50380(resultSet.getString("E503_80"));
				ve503.setE50381(resultSet.getString("E503_81"));
				ve503.setE50382(resultSet.getString("E503_82"));
				ve503.setE50383(resultSet.getString("E503_83"));
				ve503.setE50384(resultSet.getString("E503_84"));
				ve503.setE50385(resultSet.getString("E503_85"));
				ve503.setE50386(resultSet.getString("E503_86"));
				ve503.setE50387(resultSet.getDate("E503_87"));
				ve503.setE50388(resultSet.getString("E503_88"));
				ve503.setE50389(resultSet.getString("E503_89"));
				ve503.setE50390(resultSet.getDate("E503_90"));
				ve503.setE50306Zh(resultSet.getString("E503_06_Zh"));
				ve503.setE50307Zh(resultSet.getString("E503_07_Zh"));
				ve503.setE50316Zh(resultSet.getString("E503_16_Zh"));	
				ve503.setE50320Zh(resultSet.getString("E503_20_Zh"));
				ve503.setE50323Zh(resultSet.getString("E503_23_Zh"));
				ve503.setE50324Zh(resultSet.getString("E503_24_Zh"));
				ve503.setE50325Zh(resultSet.getString("E503_25_Zh"));
				ve503.setE50326Zh(resultSet.getString("E503_26_Zh"));	
				ve503.setE50330Zh(resultSet.getString("E503_30_Zh"));
				ve503.setE50331Zh(resultSet.getString("E503_31_Zh"));
				ve503.setE50332Zh(resultSet.getString("E503_32_Zh"));
				ve503.setE50334Zh(resultSet.getString("E503_34_Zh"));
				ve503.setE50337Zh(resultSet.getString("E503_37_Zh"));	
				ve503.setE50339Zh(resultSet.getString("E503_39_Zh"));
				ve503.setE50340Zh(resultSet.getString("E503_40_Zh"));
				ve503.setE50341Zh(resultSet.getString("E503_41_Zh"));
				ve503.setE50343Zh(resultSet.getString("E503_43_Zh"));
				ve503.setE50346Zh(resultSet.getString("E503_46_Zh"));	
				ve503.setE50349Zh(resultSet.getString("E503_49_Zh"));
				ve503.setE50350Zh(resultSet.getString("E503_50_Zh"));	
				ve503.setE50352Zh(resultSet.getString("E503_52_Zh"));
				ve503.setE50353Zh(resultSet.getString("E503_53_Zh"));
				ve503.setE50355Zh(resultSet.getString("E503_55_Zh"));	
				ve503.setE50357Zh(resultSet.getString("E503_57_Zh"));
				ve503.setE50359Zh(resultSet.getString("E503_59_Zh"));
				ve503.setE50362Zh(resultSet.getString("E503_62_Zh"));
				ve503.setE50363Zh(resultSet.getString("E503_63_Zh"));
				ve503.setE50365Zh(resultSet.getString("E503_65_Zh"));	
				ve503.setE50367Zh(resultSet.getString("E503_67_Zh"));
				ve503.setE50369Zh(resultSet.getString("E503_69_Zh"));
				ve503.setE50372Zh(resultSet.getString("E503_72_Zh"));
				ve503.setE50374Zh(resultSet.getString("E503_74_Zh"));	
				ve503.setE50375Zh(resultSet.getString("E503_75_Zh"));
				ve503.setE50376Zh(resultSet.getString("E503_76_Zh"));
				ve503.setE50377Zh(resultSet.getString("E503_77_Zh"));
				ve503.setE50378Zh(resultSet.getString("E503_78_Zh"));
				ve503.setE50379Zh(resultSet.getString("E503_79_Zh"));	
				ve503.setE50381Zh(resultSet.getString("E503_81_Zh"));
				ve503.setE50382Zh(resultSet.getString("E503_82_Zh"));
				ve503.setE50388Zh(resultSet.getString("E503_88_Zh"));
				ve503.setE50322Zh(resultSet.getString("E503_22_Zh"));
				ve503.setE50308Str(resultSet.getString("E503_08_Str"));
				ve503.setE50321Str(resultSet.getString("E503_21_Str"));
				ve503.setE50360Str(resultSet.getString("E503_60_Str"));
				ve503.setE50387Str(resultSet.getString("E503_87_Str"));	
				ve503.setE50390Str(resultSet.getString("E503_90_Str"));
				ve503s.add(ve503);
			}
			e503Response.setState(true);
			e503Response.setVe503(ve503s);
			e503Response.setPromptMessage("查询成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e503Response.setState(false);
			e503Response.setErrorMessage("查询异常");
		}finally {
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
		return e503Response;
	}

	@Override
	public E503Response renewE503(E503 e503) {
		E503Response e503Response=new E503Response();
		try {
			if (e503 != null) {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(e503);
				session.flush();
				session.refresh(e503);
				e503Response.setState(true);
				e503Response.setPromptMessage("更新成功");
			} else {
				e503Response.setState(false);
				e503Response.setErrorMessage("数据为空");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e503Response.setState(false);
			e503Response.setErrorMessage("更新失败");
		}
		return e503Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E503Response saveE503(E503 e503) {
		E503Response e503Response=new E503Response();
		e503Response.setState(false);
		try {			
			if(e503!=null){
				Session session=sessionFactory.getCurrentSession();
				List list=session.createSQLQuery("select * from E503 t where t.e503_05=? and t.e503_18=?").addEntity(E503.class)
				.setString(0, e503.getE50305()).setString(1, e503.getE50318()).list();
				if(list.size()>0){
					e503Response.setErrorMessage("保存重复");
					return e503Response;
				}
				session.save(e503);
				e503Response.setState(true);
				e503Response.setPromptMessage("保存成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e503Response.setErrorMessage("保存异常");
			e.printStackTrace();
		}
		return e503Response;
	}

}
