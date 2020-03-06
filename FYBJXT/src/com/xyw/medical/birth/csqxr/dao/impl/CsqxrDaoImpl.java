package com.xyw.medical.birth.csqxr.dao.impl;

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

import com.xyw.medical.birth.csqxr.dao.CsqxrDao;
import com.xyw.medical.birth.csqxr.model.D606;
import com.xyw.medical.birth.csqxr.model.D606Request;
import com.xyw.medical.birth.csqxr.model.D606Response;
import com.xyw.medical.birth.csqxr.model.VD606;
import com.xyw.sys.util.StringUtil;

public class CsqxrDaoImpl implements CsqxrDao {
	@Resource
	private DataSource dataSource;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public D606Response saveD606(D606 d606) {
		D606Response d606Response = new D606Response();
		long D606_61 =d606.getD60661();
		long D606_62 =d606.getD60662();
		String D606_04 =d606.getD60604();
		String D606_07 =d606.getD60607();
		String D606_16 =d606.getD60616();
		String D606_17 =d606.getD60617();
		Date D606_18 =d606.getD60618();
		String D606_51 =d606.getD60651();

		boolean state =true;
		Session session =sessionFactory.getCurrentSession();
		try {
			StringBuffer sql =new StringBuffer("select * from D606 t where 1=1 ");
			if(D606_61 >0){
				sql.append(" and t.d606_61 = '"+D606_61+"'");
			}
			if(D606_62 >0){
				sql.append(" and t.d606_62 = '"+D606_62+"'");
			}
			if(!StringUtil.isBlankString(D606_04)){
				sql.append(" and t.d606_04 = '"+D606_04+"'");
			}
			if(!StringUtil.isBlankString(D606_07)){
				sql.append(" and t.d606_07 = '"+D606_07+"'");
			}
			if(!StringUtil.isBlankString(D606_16)){
				sql.append(" and t.d606_16 = '"+D606_16+"'");
			}
			if(!StringUtil.isBlankString(D606_17)){
				sql.append(" and t.d606_17 = '"+D606_17+"'");
			}
			if(!StringUtil.isBlankString(D606_51)){
				if(D606_51.length() == 14)
				{
					sql.append(" and t.d606_51 = '");
					sql.append(D606_51);
					sql.append("'");
				}else
				{
					sql.append(" and t.d606_51 like '");
					sql.append(D606_51);
					sql.append("%'");
				}
			}
			
			SQLQuery query =session.createSQLQuery(sql.toString());
			int d606Size =query.addEntity(D606.class).list().size();
			if(d606Size >0){
				state = false;
				d606Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			d606Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if(state){
			try {
				session.save(d606);
				session.flush();
				session.refresh(d606);
			 } catch (Exception e) {
				 e.printStackTrace();
				 d606Response.setErrorMessage("保存失败!");
				 state = false;
			 }
		}
		
		d606Response.setState(state);
		return d606Response;
	}

	@Override
	public D606Response pagerD606(D606Request d606Request) {
		D606Response d606Response = new D606Response();
		long D606_61_ =d606Request.getD60661();
		long D606_62_ =d606Request.getD60662();
		String D606_04_ =d606Request.getD60604();
		String D606_07_ =d606Request.getD60607();
		String D606_16_ =d606Request.getD60616();
		String D606_17_ =d606Request.getD60617();
		Date D606_18_ =d606Request.getD60618();
		String D606_51_ =d606Request.getD60651();
		
		int pageIndex = d606Request.getPageIndex();
		int pageSize = d606Request.getPageSize();
		Date d60653Start = d606Request.getD60653Start();
		Date d60653End = d606Request.getD60653End();
		
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer("");
		if(!StringUtil.isBlankString(D606_04_)){
			parameterConditionwhere.append(" and t.D606_04 ='" + D606_04_ + "'");
		}
		if(!StringUtil.isBlankString(D606_07_)){
			parameterConditionwhere.append(" and t.D606_07 ='" + D606_07_ + "'");
		}
		if(!StringUtil.isBlankString(D606_16_)){
			parameterConditionwhere.append(" and t.D606_16 ='" + D606_16_ + "'");
		}
		if(!StringUtil.isBlankString(D606_17_)){
			parameterConditionwhere.append(" and t.D606_17 ='" + D606_17_ + "'");
		}
		if(!StringUtil.isBlankString(D606_51_)){
			if(D606_51_.length() == 14)
			{
				parameterConditionwhere.append(" and t.D606_51 = '");
				parameterConditionwhere.append(D606_51_);
				parameterConditionwhere.append("'");
			}else
			{
				parameterConditionwhere.append(" and t.D606_51 like '");
				parameterConditionwhere.append(D606_51_);
				parameterConditionwhere.append("%'");
			}
		}
		if(d60653Start != null){
			String d60653Start_p = simpleDateFormat.format(d60653Start);
			parameterConditionwhere.append(" and t.D606_53_Str >= '" + d60653Start_p + "'");
		}
		if(d60653End != null){
			String d60653End_p = simpleDateFormat.format(d60653End);
			parameterConditionwhere.append(" and t.D606_53_Str <= '" + d60653End_p + "'");
		}
		
		boolean state =true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, pageIndex);
			callableStatement.setInt(2, pageSize);
			callableStatement.setString(3, "V_D606");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D606_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d606Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			
			VD606 vd606 =null;
			List<VD606> vd606s = new ArrayList<VD606>();
			while(resultSet.next()) {
				long d60601 =resultSet.getLong("D606_01");
				String d60602 =resultSet.getString("D606_02");
				String d60603 =resultSet.getString("D606_03");
				String d60604 =resultSet.getString("D606_04");
				String d60605 =resultSet.getString("D606_05");
				Date d60606 =resultSet.getDate("D606_06");
				String d60607 =resultSet.getString("D606_07");
				String d60608 =resultSet.getString("D606_08");
				String d60609 =resultSet.getString("D606_09");
				String d60610 =resultSet.getString("D606_10");
				long d60611 =resultSet.getLong("D606_11");
				long d60612 =resultSet.getLong("D606_12");
				String d60613 =resultSet.getString("D606_13");
				String d60614 =resultSet.getString("D606_14");
				String d60615 =resultSet.getString("D606_15");
				String d60616 =resultSet.getString("D606_16");
				String d60617 =resultSet.getString("D606_17");
				Date d60618 =resultSet.getDate("D606_18");
				long d60619 =resultSet.getLong("D606_19");
				long d60620 =resultSet.getLong("D606_20");
				String d60621 =resultSet.getString("D606_21");
				String d60622 =resultSet.getString("D606_22");
				String d60623 =resultSet.getString("D606_23");
				String d60624 =resultSet.getString("D606_24");
				Date d60625 =resultSet.getDate("D606_25");
				long d60626 =resultSet.getLong("D606_26");
				String d60627 =resultSet.getString("D606_27");
				String d60628 =resultSet.getString("D606_28");
				String d60629 =resultSet.getString("D606_29");
				String d60630 =resultSet.getString("D606_30");
				String d60631 =resultSet.getString("D606_31");
				String d60632 =resultSet.getString("D606_32");
				String d60633 =resultSet.getString("D606_33");
				String d60634 =resultSet.getString("D606_34");
				String d60635 =resultSet.getString("D606_35");
				String d60636 =resultSet.getString("D606_36");
				String d60637 =resultSet.getString("D606_37");
				String d60638 =resultSet.getString("D606_38");
				long d60639 = resultSet.getLong("D606_39");
				long d60640 = resultSet.getLong("D606_40");
				long d60641 = resultSet.getLong("D606_41");
				String d60642 =resultSet.getString("D606_42");
				String d60643 =resultSet.getString("D606_43");
				String d60644 =resultSet.getString("D606_44");
				String d60645 =resultSet.getString("D606_45");
				String d60646 =resultSet.getString("D606_46");
				String d60647 =resultSet.getString("D606_47");
				String d60648 =resultSet.getString("D606_48");
				String d60649 =resultSet.getString("D606_49");
				String d60650 =resultSet.getString("D606_50");
				String d60651 =resultSet.getString("D606_51");
				String d60652 =resultSet.getString("D606_52");
				Date d60653 =resultSet.getDate("D606_53");
				String d60654 =resultSet.getString("D606_54");
				String d60655 =resultSet.getString("D606_55");
				String d60656 =resultSet.getString("D606_56");
				String d60657 =resultSet.getString("D606_57");
				String d60658 =resultSet.getString("D606_58");
				String d60659 =resultSet.getString("D606_59");
				String d60660 =resultSet.getString("D606_60");
				long d60661 =resultSet.getLong("D606_61");
				long d60662 =resultSet.getLong("D606_62");
				String d60663 =resultSet.getString("D606_63");
				String d60664 =resultSet.getString("D606_64");
				String d60665 =resultSet.getString("D606_65");
				String d60666 =resultSet.getString("D606_66");
				String d60667 =resultSet.getString("D606_67");
				String d60668 =resultSet.getString("D606_68");
				String d60669 =resultSet.getString("D606_69");
				String d60670 =resultSet.getString("D606_70");
				String d60671 =resultSet.getString("D606_71");
				String d60672 =resultSet.getString("D606_72");
				String d60673 =resultSet.getString("D606_73");
				String d60674 =resultSet.getString("D606_74");
				String d60675 =resultSet.getString("D606_75");
				String d60676 =resultSet.getString("D606_76");
				String d60677 =resultSet.getString("D606_77");
				String d60678 =resultSet.getString("D606_78");
				String d60679 =resultSet.getString("D606_79");
				String d60680 =resultSet.getString("D606_80");
				String d60681 =resultSet.getString("D606_81");
				String d60682 =resultSet.getString("D606_82");
				String d60683 =resultSet.getString("D606_83");
				String d60684 =resultSet.getString("D606_84");
				String d60685 =resultSet.getString("D606_85");
				String d60686 =resultSet.getString("D606_86");
				String d60687 =resultSet.getString("D606_87");
				String d60688 =resultSet.getString("D606_88");
				String d60689 =resultSet.getString("D606_89");
				String d60690 =resultSet.getString("D606_90");
				String d60691 =resultSet.getString("D606_91");
				String d60692 =resultSet.getString("D606_92");
				String d60693 =resultSet.getString("D606_93");
				String d60694 =resultSet.getString("D606_94");
				String d60695 =resultSet.getString("D606_95");
				String d60696 =resultSet.getString("D606_96");
				String d60697 =resultSet.getString("D606_97");
				String d60698 =resultSet.getString("D606_98");
				String d60699 =resultSet.getString("D606_99");
				
				String d60603Zh =resultSet.getString("D606_03_ZH");
				String d60605Zh =resultSet.getString("D606_05_ZH");
				String d60606Str =resultSet.getString("D606_06_Str");
				String d60609Zh =resultSet.getString("D606_09_ZH");
				String d60613Zh =resultSet.getString("D606_13_ZH");
				String d60614Zh =resultSet.getString("D606_14_ZH");
				String d60615Zh =resultSet.getString("D606_15_ZH");
				String d60617Zh =resultSet.getString("D606_17_ZH");
				String d60618Str =resultSet.getString("D606_18_Str");
				String d60621Zh =resultSet.getString("D606_21_ZH");
				String d60622Zh =resultSet.getString("D606_22_ZH");
				String d60623Zh =resultSet.getString("D606_23_ZH");
				String d60624Zh =resultSet.getString("D606_24_ZH");
				String d60625Str =resultSet.getString("D606_25_Str");
				String d60627Zh =resultSet.getString("D606_27_ZH");
				String d60649Zh =resultSet.getString("D606_49_ZH");
				String d60651Zh =resultSet.getString("D606_51_ZH");
				String d60653Str =resultSet.getString("D606_53_Str");
				String d60656Zh =resultSet.getString("D606_56_ZH");
				String d60657Zh =resultSet.getString("D606_57_ZH");
				String d60659Zh =resultSet.getString("D606_59_ZH");
				String d60663Zh =resultSet.getString("D606_63_ZH");
				String d10104 =resultSet.getString("D101_04");
				
				String e30103 = resultSet.getString("E301_03");
				String e30104 = resultSet.getString("E301_04");
				String e30104Zh = resultSet.getString("E301_04_ZH");
				String e30105 = resultSet.getString("E301_05");
				Date e30106 = resultSet.getDate("E301_06");
				String e30106Str =resultSet.getString("e301_06_Str");
				String e30113 = resultSet.getString("E301_13");
				String e30117 = resultSet.getString("E301_17");
				
				String f30102 =resultSet.getString("F301_02");
				String f30104 =resultSet.getString("F301_04");
				String f30105 =resultSet.getString("F301_05");
				Date f30106 =resultSet.getDate("F301_06");
				String f30106Str =resultSet.getString("F301_06_Str");
				String f30113 =resultSet.getString("F301_13");
				String f30135 =resultSet.getString("F301_35");
				String f30135Zh =resultSet.getString("F301_35_ZH");
				
				vd606 = new VD606();
				vd606.setD60601(d60601);
				vd606.setD60602(d60602);
				vd606.setD60603(d60603);
				vd606.setD60604(d60604);
				vd606.setD60605(d60605);
				vd606.setD60606(d60606);
				vd606.setD60607(d60607);
				vd606.setD60608(d60608);
				vd606.setD60609(d60609);
				vd606.setD60610(d60610);
				vd606.setD60611(d60611);
				vd606.setD60612(d60612);
				vd606.setD60613(d60613);
				vd606.setD60614(d60614);
				vd606.setD60615(d60615);
				vd606.setD60616(d60616);
				vd606.setD60617(d60617);
				vd606.setD60618(d60618);
				vd606.setD60619(d60619);
				vd606.setD60620(d60620);
				vd606.setD60621(d60621);
				vd606.setD60622(d60622);
				vd606.setD60623(d60623);
				vd606.setD60624(d60624);
				vd606.setD60625(d60625);
				vd606.setD60626(d60626);
				vd606.setD60627(d60627);
				vd606.setD60628(d60628);
				vd606.setD60629(d60629);
				vd606.setD60630(d60630);
				vd606.setD60631(d60631);
				vd606.setD60632(d60632);
				vd606.setD60633(d60633);
				vd606.setD60634(d60634);
				vd606.setD60635(d60635);
				vd606.setD60636(d60636);
				vd606.setD60637(d60637);
				vd606.setD60638(d60638);
				vd606.setD60639(d60639);
				vd606.setD60640(d60640);
				vd606.setD60641(d60641);
				vd606.setD60642(d60642);
				vd606.setD60643(d60643);
				vd606.setD60644(d60644);
				vd606.setD60645(d60645);
				vd606.setD60646(d60646);
				vd606.setD60647(d60647);
				vd606.setD60648(d60648);
				vd606.setD60649(d60649);
				vd606.setD60650(d60650);
				vd606.setD60651(d60651);
				vd606.setD60652(d60652);
				vd606.setD60653(d60653);
				vd606.setD60654(d60654);
				vd606.setD60655(d60655);
				vd606.setD60656(d60656);
				vd606.setD60657(d60657);
				vd606.setD60658(d60658);
				vd606.setD60659(d60659);
				vd606.setD60660(d60660);
				vd606.setD60661(d60661);
				vd606.setD60662(d60662);
				vd606.setD60663(d60663);
				vd606.setD60664(d60664);
				vd606.setD60665(d60665);
				vd606.setD60666(d60666);
				vd606.setD60667(d60667);
				vd606.setD60668(d60668);
				vd606.setD60669(d60669);
				vd606.setD60670(d60670);
				vd606.setD60671(d60671);
				vd606.setD60672(d60672);
				vd606.setD60673(d60673);
				vd606.setD60674(d60674);
				vd606.setD60675(d60675);
				vd606.setD60676(d60676);
				vd606.setD60677(d60677);
				vd606.setD60678(d60678);
				vd606.setD60679(d60679);
				vd606.setD60680(d60680);
				vd606.setD60681(d60681);
				vd606.setD60682(d60682);
				vd606.setD60683(d60683);
				vd606.setD60684(d60684);
				vd606.setD60685(d60685);
				vd606.setD60686(d60686);
				vd606.setD60687(d60687);
				vd606.setD60688(d60688);
				vd606.setD60689(d60689);
				vd606.setD60690(d60690);
				vd606.setD60691(d60691);
				vd606.setD60692(d60692);
				vd606.setD60693(d60693);
				vd606.setD60694(d60694);
				vd606.setD60695(d60695);
				vd606.setD60696(d60696);
				vd606.setD60697(d60697);
				vd606.setD60698(d60698);
				vd606.setD60699(d60699);
				
				vd606.setD60603Zh(d60603Zh);
				vd606.setD60605Zh(d60605Zh);
				vd606.setD60606Str(d60606Str);
				vd606.setD60609Zh(d60609Zh);
				vd606.setD60613Zh(d60613Zh);
				vd606.setD60614Zh(d60614Zh);
				vd606.setD60615Zh(d60615Zh);
				vd606.setD60617Zh(d60617Zh);
				vd606.setD60618Str(d60618Str);
				vd606.setD60621Zh(d60621Zh);
				vd606.setD60622Zh(d60622Zh);
				vd606.setD60623Zh(d60623Zh);
				vd606.setD60624Zh(d60624Zh);
				vd606.setD60625Str(d60625Str);
				vd606.setD60627Zh(d60627Zh);
				vd606.setD60649Zh(d60649Zh);
				vd606.setD60651Zh(d60651Zh);
				vd606.setD60653Str(d60653Str);
				vd606.setD60656Zh(d60656Zh);
				vd606.setD60657Zh(d60657Zh);
				vd606.setD60659Zh(d60659Zh);
				vd606.setD60663Zh(d60663Zh);
				vd606.setD10104(d10104);
				
				vd606.setE30103(e30103);
				vd606.setE30104(e30104);
				vd606.setE30104Zh(e30104Zh);
				vd606.setE30105(e30105);
				vd606.setE30106(e30106);
				vd606.setE30106Str(e30106Str);
				vd606.setE30113(e30113);
				vd606.setE30117(e30117);
				
				vd606.setF30102(f30102);
				vd606.setF30104(f30104);
				vd606.setF30105(f30105);
				vd606.setF30106(f30106);
				vd606.setF30106Str(f30106Str);
				vd606.setF30113(f30113);
				vd606.setF30135(f30135);
				vd606.setF30135Zh(f30135Zh);
				
				vd606s.add(vd606);
			}
			d606Response.setState(state);
			d606Response.setvD606s(vd606s);
		} catch (Exception e) {
			e.printStackTrace();
			d606Response.setState(false);
			d606Response.setErrorMessage("查询失败！");
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
		
		return d606Response;
	}

	@Override
	public D606Response updateD606(D606 d606){
		boolean state =true;
		D606Response d606Response = new D606Response();
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(d606);
		} catch (Exception e) {
			d606Response.setErrorMessage("保存失败");
			e.printStackTrace();
			state =false;
		}
		d606Response.setState(state);
		return d606Response;
	}

	@Override
	public D606Response deleteD606(D606Request d606Request) {
		D606Response d606Response = new D606Response();
		long D606_01 =d606Request.getD60601();
		String D606_04 =d606Request.getD60604();
		String D606_07 =d606Request.getD60607();
		String D606_16 =d606Request.getD60616();
		String D606_17 =d606Request.getD60617();
		long D606_61 =d606Request.getD60661();
		long D606_62 =d606Request.getD60662();
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			
			D606 d606 = (D606)session.get(D606.class, D606_01);
			session.delete(d606);
			d606Response.setPromptMessage("删除成功！");
		} catch (Exception e){
			d606Response.setErrorMessage("删除失败！");
		}
		return d606Response;
	}
}
