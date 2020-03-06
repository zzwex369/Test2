package com.xyw.client.fybj.util;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class DictionaryConvert {

	// 转换性别 1表示男，2表示女，0表示待定
	public String sexConvert(String str) {
		switch (Integer.parseInt(str)) {
		case 1:
			str = "1";
			break;
		case 2:
			str = "2";
			break;
		default:
			str = "0";
			break;
		}
		return str;
	}

	// 转换生产方式 0表示顺产，1表示难产，2表示剖腹产
	public String birthWayConvert(String str) {
		switch (Integer.parseInt(str)) {
		case 1:
			str = "0";
			break;
		case 2:
			str = "2";
			break;
		default:
			str = "1";
			break;
		}
		return str;
	}

	// 转换是否免费 1表示免费，0表示自费
	public String isFreeConvert(String str) {
		switch (Integer.parseInt(str)) {
		case 1:
			str = "1";
			break;
		case 2:
			str = "0";
			break;
		default:
			break;
		}
		return str;
	}

	// 转换胎数 0：单胎，1：双胎，2：多胎
	public Short taiShuConvert(Short sh) {
		switch (sh) {
		case 1:
			sh = 0;
			break;
		case 2:
			sh = 1;
			break;
		default:
			sh = 2;
			break;
		}
		return sh;
	}

	// 转换医院名称 （传汉字）
	public String hospitalNameConvert(String str, Session session) {
		String d101_02 = "";
		try {
			SQLQuery sqlQuery = session
					.createSQLQuery("select t.d101_02 from D101 t where t.d101_01 = ?");
			sqlQuery.setString(0, str);
			d101_02 = (String) sqlQuery.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return d101_02;
	}

	// 转换民族 （传汉字）
	public String nationConvert(String str) {
		switch (Integer.parseInt(str)) {
		case 1:
			str = "汉族";
			break;
		case 2:
			str = "满族";
			break;
		case 3:
			str = "朝鲜族";
			break;
		case 4:
			str = "蒙古族";
			break;
		case 5:
			str = "达斡尔族";
			break;
		case 6:
			str = "鄂温克族";
			break;
		case 7:
			str = "鄂伦春族";
			break;
		case 8:
			str = "赫哲族";
			break;
		case 9:
			str = "回族";
			break;
		case 10:
			str = "维吾尔族";
			break;
		case 11:
			str = "哈萨克族";
			break;
		case 12:
			str = "东乡族";
			break;
		case 13:
			str = "土族";
			break;
		case 14:
			str = "锡伯族";
			break;
		case 15:
			str = "柯尔克孜族";
			break;
		case 16:
			str = "撒拉族";
			break;
		case 17:
			str = "塔吉克族";
			break;
		case 18:
			str = "乌孜别克族";
			break;
		case 19:
			str = "俄罗斯族";
			break;
		case 20:
			str = "裕固族";
			break;
		case 21:
			str = "保安族";
			break;
		case 22:
			str = "塔塔尔族";
			break;
		case 23:
			str = "苗族";
			break;
		case 24:
			str = "彝族";
			break;
		case 25:
			str = "藏族";
			break;
		case 26:
			str = "布依族";
			break;
		case 27:
			str = "侗族";
			break;
		case 28:
			str = "白族";
			break;
		case 29:
			str = "哈尼族";
			break;
		case 30:
			str = "傣族";
			break;
		case 31:
			str = "傈僳族";
			break;
		case 32:
			str = "仡佬族";
			break;
		case 33:
			str = "拉祜族";
			break;
		case 34:
			str = "佤族";
			break;
		case 35:
			str = "水族";
			break;
		case 36:
			str = "纳西族";
			break;
		case 37:
			str = "羌族";
			break;
		case 38:
			str = "景颇族";
			break;
		case 39:
			str = "布朗族";
			break;
		case 40:
			str = "普米族";
			break;
		case 41:
			str = "阿昌族";
			break;
		case 42:
			str = "怒族";
			break;
		case 43:
			str = "基诺族";
			break;
		case 44:
			str = "德昂族";
			break;
		case 45:
			str = "独龙族";
			break;
		case 46:
			str = "珞巴族";
			break;
		case 47:
			str = "壮族";
			break;
		case 48:
			str = "土家族";
			break;
		case 49:
			str = "瑶族";
			break;
		case 50:
			str = "黎族";
			break;
		case 51:
			str = "畲族";
			break;
		case 52:
			str = "高山族";
			break;
		case 53:
			str = "仫佬族";
			break;
		case 54:
			str = "毛南族";
			break;
		case 55:
			str = "京族";
			break;
		case 56:
			str = "门巴族";
			break;
		case 57:
			str = "穿青人";
			break;
		case 58:
			str = "高棉族";
			break;
		default:
			str = "无";
			break;
		}
		return str;
	}
}
