package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.csqxr.model.VD606;

public class CsqxrService {
    private DataSource dataSource;
	
	public VD606 queryD606(String d606_01,String d606_04,String d606_07,String d606_16,String d606_61,String d606_62,ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD606 vd606 = null;
		
		StringBuffer sql = new StringBuffer("select * from v_d606 t where 1=1 ");
		
		if(d606_01 != null){
			sql.append(" and t.D606_01 ="+d606_01 );
		}
		if(d606_04 != null){
			sql.append(" and t.D606_04 ='"+d606_04+"'" );
		}
		if(d606_07 != null){
			sql.append(" and t.D606_07 ='"+d606_07+"'" );
		}
		if(d606_16 != null){
			sql.append(" and t.D606_16 ='"+d606_16+"'" );
		}
		if(d606_61 != null){
			sql.append(" and t.D606_61 ='"+d606_61+"'" );
		}
		if(d606_62 != null){
			sql.append(" and t.D606_62 ='"+d606_62+"'" );
		}
		
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();
			vd606 = new VD606();
			//List<VD606> vd606s = new ArrayList<VD606>();
			while(resultSet.next()) {
				long d60601 = resultSet.getLong("D606_01");
				String d60602 = resultSet.getString("D606_02");
				String d60603 = resultSet.getString("D606_03");
				String d60604 = resultSet.getString("D606_04");
				String d60605 = resultSet.getString("D606_05");
				Date d60606= resultSet.getDate("D606_06");
				String d60607 = resultSet.getString("D606_07");
				String d60608 = resultSet.getString("D606_08");
				String d60609 = resultSet.getString("D606_09");
				String d60610 = resultSet.getString("D606_10");
				long d60611 = resultSet.getLong("D606_11");
				long d60612 = resultSet.getLong("D606_12");
				String d60613 = resultSet.getString("D606_13");
				String d60614 = resultSet.getString("D606_14");
				String d60615 = resultSet.getString("D606_15");
				String d60616 = resultSet.getString("D606_16");
				String d60617 = resultSet.getString("D606_17");
				Date d60618 = resultSet.getDate("D606_18");
				long d60619 = resultSet.getLong("D606_19");
				long d60620 = resultSet.getLong("D606_20");
				String d60621 = resultSet.getString("D606_21");
				String d60622 = resultSet.getString("D606_22");
				String d60623 = resultSet.getString("D606_23");
				String d60624 = resultSet.getString("D606_24");
				Date d60625 = resultSet.getDate("D606_25");
				long d60626 = resultSet.getLong("D606_26");
				String d60627 = resultSet.getString("D606_27");
				String d60628 = resultSet.getString("D606_28");
				String d60629 = resultSet.getString("D606_29");
				String d60630 = resultSet.getString("D606_30");
				String d60631 = resultSet.getString("D606_31");
				String d60632 = resultSet.getString("D606_32");
				String d60633 = resultSet.getString("D606_33");
				String d60634 = resultSet.getString("D606_34");
				String d60635 = resultSet.getString("D606_35");
				String d60636 = resultSet.getString("D606_36");
				String d60637 = resultSet.getString("D606_37");
				String d60638 = resultSet.getString("D606_38");
				long d60639 = resultSet.getLong("D606_39");
				long d60640 = resultSet.getLong("D606_40");
				long d60641 = resultSet.getLong("D606_41");
				String d60642 = resultSet.getString("D606_42");
				String d60643 = resultSet.getString("D606_43");
				String d60644 = resultSet.getString("D606_44");
				String d60645 = resultSet.getString("D606_45");
				String d60646 = resultSet.getString("D606_46");
				String d60647 = resultSet.getString("D606_47");
				String d60648 = resultSet.getString("D606_48");
				String d60649 = resultSet.getString("D606_49");
				String d60650 = resultSet.getString("D606_50");
				String d60651 = resultSet.getString("D606_51");
				String d60652 = resultSet.getString("D606_52");
				Date d60653 = resultSet.getDate("D606_53");
				String d60654 = resultSet.getString("D606_54");
				String d60655 = resultSet.getString("D606_55");
				String d60656 = resultSet.getString("D606_56");
				String d60657 = resultSet.getString("D606_57");
				String d60658 = resultSet.getString("D606_58");
				String d60659 = resultSet.getString("D606_59");
				String d60660 = resultSet.getString("D606_60");
				long d60661 = resultSet.getLong("D606_61");
				long d60662 = resultSet.getLong("D606_62");
				String d60663 = resultSet.getString("D606_63");
				String d60664 = resultSet.getString("D606_64");
				String d60665 = resultSet.getString("D606_65");
				String d60666 = resultSet.getString("D606_66");
				String d60667 = resultSet.getString("D606_67");
				String d60668 = resultSet.getString("D606_68");
				String d60669 = resultSet.getString("D606_69");
				String d60670 = resultSet.getString("D606_70");
				String d60671 = resultSet.getString("D606_71");
				String d60672 = resultSet.getString("D606_72");
				String d60673 = resultSet.getString("D606_73");
				String d60674 = resultSet.getString("D606_74");
				String d60675 = resultSet.getString("D606_75");
				String d60676 = resultSet.getString("D606_76");
				String d60677 = resultSet.getString("D606_77");
				String d60678 = resultSet.getString("D606_78");
				String d60679 = resultSet.getString("D606_79");
				String d60680 = resultSet.getString("D606_80");
				String d60681 = resultSet.getString("D606_81");
				String d60682 = resultSet.getString("D606_82");
				String d60683 = resultSet.getString("D606_83");
				String d60684 = resultSet.getString("D606_84");
				String d60685 = resultSet.getString("D606_85");
				String d60686 = resultSet.getString("D606_86");
				String d60687 = resultSet.getString("D606_87");
				String d60688 = resultSet.getString("D606_88");
				String d60689 = resultSet.getString("D606_89");
				String d60690 = resultSet.getString("D606_90");
				String d60691 = resultSet.getString("D606_91");
				String d60692 = resultSet.getString("D606_92");
				String d60693 = resultSet.getString("D606_93");
				String d60694 = resultSet.getString("D606_94");
				String d60695 = resultSet.getString("D606_95");
				String d60696 = resultSet.getString("D606_96");
				String d60697 = resultSet.getString("D606_97");
				String d60698 = resultSet.getString("D606_98");
				String d60699 = resultSet.getString("D606_99");
				
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
				
				//vd606s.add(vd606);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd606;
	}
	
	
	private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
			if(preparedStatement != null) {
				preparedStatement.close();
				preparedStatement = null;
			}
			if(connection != null) {
				connection.close();
				connection = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getAge(Date dateStart,Date dateEnd){
		String age = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String startime = format.format(dateStart);
			String endtime = format.format(dateEnd);
			int startyy = Integer.parseInt(startime.substring(0, 4));
			int endyy = Integer.parseInt(endtime.substring(0, 4));
			int startMM = Integer.parseInt(startime.substring(5, 7));
			int endMM = Integer.parseInt(endtime.substring(5, 7));
			int startdd = Integer.parseInt(startime.substring(8, 10));
			int enddd = Integer.parseInt(endtime.substring(8, 10));
			if(startMM > endMM || startMM == endMM && startdd > enddd){
				age = String.valueOf((endyy - startyy) - 1);
			}else{
				age = String.valueOf(endyy - startyy);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return age;
	}

}
