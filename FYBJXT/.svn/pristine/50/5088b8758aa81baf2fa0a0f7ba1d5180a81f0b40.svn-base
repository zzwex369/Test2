package com.xyw.medical.fnbj.fnbjfs.dao.impl;

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

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fnbjfs.dao.F307Dao;
import com.xyw.medical.fnbj.model.F307;
import com.xyw.medical.fnbj.model.F307Request;
import com.xyw.medical.fnbj.model.F307Response;
import com.xyw.medical.fnbj.model.VF307;
import com.xyw.sys.util.StringUtil;

public class F307DaoImpl implements F307Dao{
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource ;

	@SuppressWarnings("unchecked")
	@Override
	public F307Response saveF307(F307 f307) {
		F307Response f307Response =new F307Response();
		String f30702 =f307.getF30702();  //产妇姓名
		String f30727 =f307.getF30727();  //产后访视
		String f30736 =f307.getF30736();  //身份证号
		Date f30703 =f307.getF30703();  //随访日期
		
		boolean state =true;
		Session session =sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			StringBuffer sql = new StringBuffer("select * from F307 t where 1=1 ");
			if (!StringUtil.isBlankString(f30702)) {
				sql.append("and t.f307_02 ='" + f30702 + "' ");
			}
			if (!StringUtil.isBlankString(f30727)) {
				sql.append("and t.f307_27 ='" + f30727 + "' ");
			}
			if (!StringUtil.isBlankString(f30736)) {
				sql.append("and t.f307_36 ='" + f30736 + "' ");
			}
			if (f30703 != null) {
				String f30703_ = sdf.format(f30703);
				sql.append(" and to_char(t.f307_03,'yyyy-MM-dd')  = '"+ f30703_ + "'");
			}
			
			SQLQuery query = session.createSQLQuery(sql.toString());
			List<F307> f307s = query.addEntity(F307.class).list();
			if (f307s.size() > 0) {
				state = false;
				f307Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			f307Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if (state) {
			try {
				session.save(f307);
				session.flush();
				session.refresh(f307);
			} catch (Exception e) {
				e.printStackTrace();
				state =false;
				f307Response.setErrorMessage("保存出错! ");
			}
		}
		
		f307Response.setState(state);	
		return f307Response;
	}

	@Override
	public F307Response renewF307(F307 f307) {
		F307Response f307Response =new F307Response();
		boolean state =true;
		
		Session session =sessionFactory.getCurrentSession();
		try {
			session.update(f307);
		} catch (Exception e) {
			e.printStackTrace();
			state =false;
			f307Response.setErrorMessage(e.getMessage());
		}
		
		f307Response.setState(state);
		return f307Response;
	}

	@Override
	public F307Response queryF307(F307Request f307Request) {
		F307Response f307Response =new F307Response();
		String F307_02 =f307Request.getF30702();
		String F307_36 =f307Request.getF30736();
		String F307_37 =f307Request.getF30737();
		String F307_38 =f307Request.getF30738();
		long F307_33 =f307Request.getF30733();
		Date F307_24 =f307Request.getF30724();
		
	    Date timeStr =f307Request.getTimeStr();
	    Date timeEnd =f307Request.getTimeEnd();
	    String jiancha =f307Request.getJiancha();

	    StringBuffer sql = new StringBuffer();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    int parameterPageindex = f307Request.getParameterPageindex();
	    int parameterPagesize = f307Request.getParameterPagesize();
	    if(jiancha.equals("产后")){
	    	sql.append(" and t.f307_27 !='4'");
	    }else if(jiancha.equals("产后42天")){
	    	sql.append(" and t.f307_27 ='4'");
	    }else if(jiancha.equals("产后所有记录")){
	    	sql.append(" and t.f307_27 is not null");
	    }
	    if(!StringUtil.isBlankString(F307_02)){
	    	sql.append(" and t.f307_02 ='" +F307_02 + "'");
	    }
	    if(!StringUtil.isBlankString(F307_36)){
	    	sql.append(" and t.f307_36 ='" +F307_36 + "'");
	    }
	    if(!StringUtil.isBlankString(F307_38)){
	    	sql.append(" and t.f307_38 ='" +F307_38 + "'");
	    }
	    if(F307_33 !=0){
	    	sql.append(" and t.f307_33 ='" +F307_33 + "'");
	    }
	    if(F307_24 !=null){
	    	String F307_24_ = sdf.format(F307_24);
	    	sql.append(" and t.f307_24_str >= '"+ F307_24_ + "'");
	    }
	    if(timeStr !=null){
	    	String timeStr_ = sdf.format(timeStr);
	    	sql.append(" and t.f307_03_str >= '"+ timeStr_ + "'");
	    }
	    if(timeEnd !=null){
	    	String timeEnd_ = sdf.format(timeEnd);
	    	sql.append(" and t.f307_03_str <= '"+ timeEnd_ + "'");
	    }
	    if (!StringUtil.isBlankString(F307_37)) {
			if (F307_37.length() == 14) {
				sql.append(" and t.f307_37 = '");
				sql.append(F307_37);
				sql.append("'");
			} else {
				sql.append(" and t.f307_37 like '");
				sql.append(F307_37);
				sql.append("%'");
			}
		}

	    boolean state =true;
	    Connection connection =null;
	    CallableStatement callableStatement =null;
	    try {
	    	connection =this.dataSource.getConnection();
	    	callableStatement =connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
	    	callableStatement.setInt(1, parameterPageindex);
	    	callableStatement.setInt(2, parameterPagesize);
	    	callableStatement.setString(3, "V_F307");
	    	callableStatement.setString(4, sql.toString());
	    	callableStatement.setString(5, "t.F307_01");
	    	callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
	    	callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
	    	callableStatement.execute();
	    	
	    	long rowCount =callableStatement.getLong(6);
	    	f307Response.setRowCount(rowCount);
	    	ResultSet resultSet =(ResultSet)callableStatement.getObject(7);
	    	VF307 vf307 = null;
			List<VF307> vf307s = new ArrayList<VF307>();
			while (resultSet.next()) {
				long f30701 =resultSet.getLong("F307_01");
				String f30702 =resultSet.getString("F307_02");
				Date f30703 =resultSet.getDate("F307_03");
				long f30704 =resultSet.getLong("F307_04");
				String f30705 =resultSet.getString("F307_05");
				String f30706 =resultSet.getString("F307_06");
				String f30707 =resultSet.getString("F307_07");
				String f30708 =resultSet.getString("F307_08");
				String f30709 =resultSet.getString("F307_09");
				String f30710 =resultSet.getString("F307_10");
				String f30711 =resultSet.getString("F307_11");
				long f30712 =resultSet.getLong("F307_12");
				String f30713 =resultSet.getString("F307_13");
				String f30714 =resultSet.getString("F307_14");
				String f30715 =resultSet.getString("F307_15");
				String f30716 =resultSet.getString("F307_16");
				String f30717 =resultSet.getString("F307_17");
				String f30718 =resultSet.getString("F307_18");
				String f30719 =resultSet.getString("F307_19");
				String f30720 =resultSet.getString("F307_20");
				String f30721 =resultSet.getString("F307_21");
				String f30722 =resultSet.getString("F307_22");
				String f30723 =resultSet.getString("F307_23");
				Date f30724 =resultSet.getDate("F307_24");
				String f30725 =resultSet.getString("F307_25");
				String f30726 =resultSet.getString("F307_26");
				String f30727 =resultSet.getString("F307_27");
				long f30728 =resultSet.getLong("F307_28");
				long f30729 =resultSet.getLong("F307_29");
				String f30730 =resultSet.getString("F307_30");
				String f30731 =resultSet.getString("F307_31");
				String f30732 =resultSet.getString("F307_32");
				long f30733 =resultSet.getLong("F307_33");
				String f30734 =resultSet.getString("F307_34");
				String f30735 =resultSet.getString("F307_35");
				String f30736 =resultSet.getString("F307_36");
				String f30737 =resultSet.getString("F307_37");
				String f30738 =resultSet.getString("F307_38");
				String f30739 =resultSet.getString("F307_39");
				String f30740 =resultSet.getString("F307_40");
				String f30741 =resultSet.getString("F307_41");
				String f30742 =resultSet.getString("F307_42");
				String f30743 =resultSet.getString("F307_43");
				String f30744 =resultSet.getString("F307_44");
				String f30745 =resultSet.getString("F307_45");
				String f30746 =resultSet.getString("F307_46");
				String f30747 =resultSet.getString("F307_47");
				Date f30748 =resultSet.getDate("F307_48");
				long f30749 =resultSet.getLong("F307_49");
				long f30750 =resultSet.getLong("F307_50");
				long f30751 =resultSet.getLong("F307_51");
				String f30752 =resultSet.getString("F307_52");
				String f30753 =resultSet.getString("F307_53");
				String f30754 =resultSet.getString("F307_54");
				String f30755 =resultSet.getString("F307_55");
				String f30756 =resultSet.getString("F307_56");
				String f30757 =resultSet.getString("F307_57");
				String f30758 =resultSet.getString("F307_58");
				String f30759 =resultSet.getString("F307_59");
				String f30760 =resultSet.getString("F307_60");
				
				String f30703Str =resultSet.getString("F307_03_Str");
				String f30724Str =resultSet.getString("F307_24_Str");
				String f30748Str =resultSet.getString("F307_48_Str");
				
				String f30708Zh =resultSet.getString("F307_08_ZH");
				String f30710Zh =resultSet.getString("F307_10_ZH");
				String f30713Zh =resultSet.getString("F307_13_ZH");
				String f30714Zh =resultSet.getString("F307_14_ZH");
				//String f30717Zh =resultSet.getString("F307_17_ZH");
				String f30721Zh =resultSet.getString("F307_21_ZH");
				String f30726Zh =resultSet.getString("F307_26_ZH");
				String f30727Zh =resultSet.getString("F307_27_ZH");
//				String f30730Zh =resultSet.getString("F307_30_ZH");
//				String f30737Zh =resultSet.getString("F307_37_ZH");
//				String f30741Zh =resultSet.getString("F307_41_ZH");
//				String f30742Zh =resultSet.getString("F307_42_ZH");
//				String f30743Zh =resultSet.getString("F307_43_ZH");
//				String f30744Zh =resultSet.getString("F307_44_ZH");
//				String f30745Zh =resultSet.getString("F307_45_ZH");
//				String f30746Zh =resultSet.getString("F307_46_ZH");
//				String f30747Zh =resultSet.getString("F307_47_ZH");
//				String f30752Zh =resultSet.getString("F307_52_ZH");
//				String f30753Zh =resultSet.getString("F307_53_ZH");
//				String f30754Zh =resultSet.getString("F307_54_ZH");
//				String f30755Zh =resultSet.getString("F307_55_ZH");
//				String f30756Zh =resultSet.getString("F307_56_ZH");
				
//				String f30103 =resultSet.getString("F301_03");
//				String f30104 =resultSet.getString("F301_04");
//				String f30105 =resultSet.getString("F301_05");
//				Date f30106 =resultSet.getDate("F301_06");
//				String f30106Str =resultSet.getString("F301_06_STR");
//				String f30113 =resultSet.getString("F301_13");
//				String f30117 =resultSet.getString("F301_17");
//				String f30118 =resultSet.getString("F301_18");
//				String f30119 =resultSet.getString("F301_19");
//				String f30121 =resultSet.getString("F301_21");
//				String f30135 =resultSet.getString("F301_35");
//				String f30135Zh =resultSet.getString("F301_35_ZH");
				
				vf307 =new VF307();
				vf307.setF30701(f30701);
				vf307.setF30702(f30702);
				vf307.setF30703(f30703);
				vf307.setF30704(f30704);
				vf307.setF30705(f30705);
				vf307.setF30706(f30706);
				vf307.setF30707(f30707);
				vf307.setF30708(f30708);
				vf307.setF30709(f30709);
				vf307.setF30710(f30710);
				vf307.setF30711(f30711);
				vf307.setF30712(f30712);
				vf307.setF30713(f30713);
				vf307.setF30714(f30714);
				vf307.setF30715(f30715);
				vf307.setF30716(f30716);
				vf307.setF30717(f30717);
				vf307.setF30718(f30718);
				vf307.setF30719(f30719);
				vf307.setF30720(f30720);
				vf307.setF30721(f30721);
				vf307.setF30722(f30722);
				vf307.setF30723(f30723);
				vf307.setF30724(f30724);
				vf307.setF30725(f30725);
				vf307.setF30726(f30726);
				vf307.setF30727(f30727);
				vf307.setF30728(f30728);
				vf307.setF30729(f30729);
				vf307.setF30730(f30730);
				vf307.setF30731(f30731);
				vf307.setF30732(f30732);
				vf307.setF30733(f30733);
				vf307.setF30734(f30734);
				vf307.setF30735(f30735);
				vf307.setF30736(f30736);
				vf307.setF30737(f30737);
				vf307.setF30738(f30738);
				vf307.setF30739(f30739);
				vf307.setF30740(f30740);
				vf307.setF30741(f30741);
				vf307.setF30742(f30742);
				vf307.setF30743(f30743);
				vf307.setF30744(f30744);
				vf307.setF30745(f30745);
				vf307.setF30746(f30746);
				vf307.setF30747(f30747);
				vf307.setF30748(f30748);
				vf307.setF30749(f30749);
				vf307.setF30750(f30750);
				vf307.setF30751(f30751);
				vf307.setF30752(f30752);
				vf307.setF30753(f30753);
				vf307.setF30754(f30754);
				vf307.setF30755(f30755);
				vf307.setF30756(f30756);
				vf307.setF30757(f30757);
				vf307.setF30758(f30758);
				vf307.setF30759(f30759);
				vf307.setF30760(f30760);
				
				vf307.setF30703Str(f30703Str);
				vf307.setF30724Str(f30724Str);
				vf307.setF30748Str(f30748Str);
				
				vf307.setF30708Zh(f30708Zh);
				vf307.setF30710Zh(f30710Zh);
				vf307.setF30713Zh(f30713Zh);
				vf307.setF30714Zh(f30714Zh);
//				vf307.setF30717Zh(f30717Zh);
				vf307.setF30721Zh(f30721Zh);
				vf307.setF30726Zh(f30726Zh);
				vf307.setF30727Zh(f30727Zh);
//				vf307.setF30730Zh(f30730Zh);
//				vf307.setF30737Zh(f30737Zh);				
//				vf307.setF30741Zh(f30741Zh);
//				vf307.setF30742Zh(f30742Zh);
//				vf307.setF30743Zh(f30743Zh);
//				vf307.setF30744Zh(f30744Zh);
//				vf307.setF30745Zh(f30745Zh);
//				vf307.setF30746Zh(f30746Zh);
//				vf307.setF30747Zh(f30747Zh);
//				vf307.setF30752Zh(f30752Zh);
//				vf307.setF30753Zh(f30753Zh);
//				vf307.setF30754Zh(f30754Zh);
//				vf307.setF30755Zh(f30755Zh);
//				vf307.setF30756Zh(f30756Zh);
				
//				vf307.setF30103(f30103);
//				vf307.setF30104(f30104);
//				vf307.setF30105(f30105);
//				vf307.setF30106(f30106);
//				vf307.setF30106Str(f30106Str);
//				vf307.setF30113(f30113);
//				vf307.setF30117(f30117);
//				vf307.setF30118(f30118);
//				vf307.setF30119(f30119);
//				vf307.setF30121(f30121);
//				vf307.setF30135(f30135);
//				vf307.setF30135Zh(f30135Zh);
				
				vf307s.add(vf307);
			}
			f307Response.setVf307s(vf307s);
		} catch (Exception e) {
			e.printStackTrace();
			state =false;
			f307Response.setErrorMessage("查询失败！");
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
		
	    f307Response.setState(state);
		return f307Response;
	}

	@Override
	public F307Response deleteF307(F307Request f307Request) {
		F307Response f307Response =new F307Response();
		long f30701 =f307Request.getF30701();
		boolean state =true;
		
		Session session =sessionFactory.getCurrentSession();
		try {
			F307 f307=new F307();
			f307.setF30701(f30701);
			session.delete(f307);
			f307Response.setPromptMessage("删除成功！");
		} catch (Exception e) {
			state  =false;
			f307Response.setErrorMessage("删除失败！");
		}
		
		f307Response.setState(state);
		return f307Response;
	}

	/**
	 *  查询所有产检 返回数量
	 */
	@SuppressWarnings("unchecked")
	@Override
	public F307Response queryById(F307Request f307Request) {
		F307Response f307Response =new F307Response();
		long f30733 =f307Request.getF30733();
		boolean state =true;
		
		Session session =sessionFactory.getCurrentSession();
		try {
			List<Object>list=session.createSQLQuery("select t.f307_01 from f307 t where t.f307_33=? ")
							.setParameter(0, f30733).list();
			f307Response.setRowCount(list.size());
		} catch (Exception e) {
			state  =false;
			f307Response.setErrorMessage(e.getMessage());
		}
		
		f307Response.setState(state);
		return f307Response;
	}

}
