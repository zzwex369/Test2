package com.xyw.ws.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.sys.util.StringUtil;
import com.xyw.ws.dao.CsyxzmDao;
import com.xyw.ws.model.Fp;
import com.xyw.ws.model.FpResponse;

public class CsyxzmDaoImpl implements CsyxzmDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public FpResponse fp(Fp fp) {
		String status = validateFp(fp);
		boolean flag = true;
		FpResponse fpResponse = new FpResponse();
		if("ok".equals(status)){
			try {
				Session session = this.sessionFactory.getCurrentSession();

				String sql = "select t.d501_01 from D501 t where ? >= to_number(t.d501_07)  and ? <= to_number(t.d501_08) and t.D501_02 = ? and t.D501_06 = ?";
				SQLQuery sqlQuery = session.createSQLQuery(sql);
				sqlQuery.setInteger(0, Integer.valueOf(fp.getFp07()));
				sqlQuery.setInteger(1, Integer.valueOf(fp.getFp08()));
				sqlQuery.setString(2, fp.getFp02());
				sqlQuery.setString(3, fp.getFp06());

				Object objB = sqlQuery.uniqueResult();
				if (objB != null) flag = false;
				
				if(flag == true){
					fp.setFp18("4");//4表示省平台传来的数据
					long id = (Long) session.save(fp);
					if (id <= 0) flag = false;
				}
				
				if(flag == true){
					fpResponse.setStatus("ok");
				} else {
					fpResponse.setStatus("fail");
				}
			} catch (Exception e) {
				e.printStackTrace();
				fpResponse.setStatus("fail");
			}
		} else {
			fpResponse.setStatus(status);
		}
		
		fpResponse.setFp01(fp.getFp01());
		fpResponse.setFp02(fp.getFp02());
		fpResponse.setFp06(fp.getFp06());
		fpResponse.setFp07(fp.getFp07());
		fpResponse.setFp08(fp.getFp08());
		fpResponse.setFp09(fp.getFp09());
		return fpResponse;
	}

	private String validateFp(Fp fp) {
		// 验证数据是否有问题
		if (StringUtil.isBlankString(fp.getFp02())) {
			return "fp02";
		}
		if (StringUtil.isBlankString(fp.getFp03())) {
			return "fp03";
		}
		if (StringUtil.isBlankString(fp.getFp04())) {
			return "fp04";
		}
		if (fp.getFp05() <= 0) {
			return "fp05";
		}
		if (StringUtil.isBlankString(fp.getFp06())) {
			return "fp06";
		}
		if (StringUtil.isBlankString(fp.getFp07())) {
			return "fp07";
		} else {
			String status = validataNumber(fp.getFp07());
			if ("fail".equals(status)) {
				return "fp07";
			}
		}
		if (StringUtil.isBlankString(fp.getFp08())) {
			return "fp08";
		} else {
			String status = validataNumber(fp.getFp08());
			if ("fail".equals(status)) {
				return "fp08";
			}
		}
		if (StringUtil.isBlankString(fp.getFp09())) {
			return "fp09";
		}
		if (StringUtil.isBlankString(fp.getFp10())) {
			return "fp10";
		}
		if (StringUtil.isBlankString(fp.getFp11())) {
			return "fp11";
		}
		if (fp.getFp12() == null) {
			return "fp12";
		}
		if (StringUtil.isBlankString(fp.getFp13())) {
			return "fp13";
		}
		if (StringUtil.isBlankString(fp.getFp14())) {
			return "fp14";
		}

		return "ok";
	}
	
	private String validataNumber(String value){
		try {
			int num = Integer.parseInt(value.trim());
			if(num <= 0) return "fail";
		} catch (NumberFormatException e) {
			return "fail";
		}
		return "ok";
	}

}
