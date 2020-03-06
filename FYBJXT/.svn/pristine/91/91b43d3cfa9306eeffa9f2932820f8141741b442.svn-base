package com.xyw.medical.fnbj.fngjadj.dao.impl;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fngjadj.dao.L302Dao;
import com.xyw.medical.fnbj.fnlapic.service.L306Service;
import com.xyw.medical.fnbj.model.L301;
import com.xyw.medical.fnbj.model.L302;
import com.xyw.medical.fnbj.model.L306;
import com.xyw.medical.fnbj.model.L302Request;
import com.xyw.medical.fnbj.model.L302Response;
import com.xyw.medical.fnbj.model.L306Request;
import com.xyw.medical.fnbj.model.L306Response;
import com.xyw.medical.fnbj.model.VL302;
import com.xyw.sys.util.StringUtil;

public class L302DaoImpl implements L302Dao {
	@Resource
	SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	@Resource
	L306Service l306Service;

	@Override
	public L302Response delL302(L302Request l302Request) {
		L302Response l302Response = new L302Response();
		l302Response.setState(false);
		String l30201 = l302Request.getL30201();
		try {
			if (!StringUtil.isBlankString(l30201)) {
				Session session = sessionFactory.getCurrentSession();
				L302 l302 = (L302) session.get(L302.class, l30201);
				if (l302 != null) {
					session.delete(l302);
					L301 l301 = (L301) session.get(L301.class, l302
							.getL30202());
					if ("1".equals(l301.getL30133())) {
						l301.setL30133("2");
						session.update(l301);
						session.flush();
					}
					l302Response.setState(true);
					l302Response.setPromptMessage("删除成功");
					return l302Response;
				}
				l302Response.setErrorMessage("对象为空");
				return l302Response;
			}
			l302Response.setErrorMessage("参数为空");
			return l302Response;
		} catch (Exception e) {
			e.printStackTrace();
			l302Response.setErrorMessage("删除异常");
		}
		return l302Response;
	}

	@Override
	public L302Response queryL302(L302Request l302Request) {
		L302Response l302Response = new L302Response();
		String suffixSql = l302Request.getSuffixSql();
		int parameterPageIndex = l302Request.getParameterPageindex();
		int parameterPagesize = l302Request.getParameterPagesize();
		Date timeDate = l302Request.getTimeStr();
		Date timeEnDate = l302Request.getTimeEnd();
		L302 l302 = l302Request.getL302();
		String l302102 = l302.getL302102();
		String l302105 = l302.getL302105();
		String l302118 = l302.getL302118();
		String l302132 = l302.getL302132();
		String l302137 = l302.getL302137();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		String l30203 = l302.getL30203();
		String l30204 = l302.getL30204();
		if (!StringUtil.isBlankString(l30203)) {
			parameterConditionwhere.append("and t.l302_03='" + l30203 + "'");
		}
		if (!StringUtil.isBlankString(l30204)) {
			parameterConditionwhere.append("and t.l302_04='" + l30204 + "'");
		}

		if (!StringUtil.isBlankString(l302137)) {
			parameterConditionwhere.append("and t.l302_137= '" + l302137+ "'");
		}
		
		if (timeDate != null) {
			parameterConditionwhere.append("and t.l302_120Str >='"
					+ sdf.format(timeDate) + "'");
		}
		if (timeEnDate != null) {
			parameterConditionwhere.append("and t.l302_120Str <= '"
					+ sdf.format(timeEnDate) + "'");
		}

		if (!StringUtil.isBlankString(l302132)) {
			parameterConditionwhere.append("and t.l302_132 " + l302132);
		}

		if (!StringUtil.isBlankString(l302102)) {
			parameterConditionwhere.append("and t.l302_102 " + l302102);
		}

		if (!StringUtil.isBlankString(l302105)) {
			parameterConditionwhere.append("and t.l302_105 " + l302105);
		}
	
		if (!StringUtil.isBlankString(l302118)) {
			if (l302118.length() == 14) {
				parameterConditionwhere.append(" and t.l302_118 = '");
				parameterConditionwhere.append(l302118);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.l302_118 like '");
				parameterConditionwhere.append(l302118);
				parameterConditionwhere.append("%'");
			}
		}
		if (!StringUtil.isBlankString(suffixSql))
			parameterConditionwhere.append(suffixSql);
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageIndex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "v_l302");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.l302_120");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			if (rowCount == 0) {
				l302Response.setState(false);
				l302Response.setErrorMessage("暂无数据");
				return l302Response;
			}
			l302Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VL302 vl302 = null;
			List<VL302> vl302s = new ArrayList<VL302>();
			while (resultSet.next()) {
				vl302 = new VL302();
				vl302.setL30201(resultSet.getString("L302_01"));
				vl302.setL30202(resultSet.getString("L302_02"));
				vl302.setL30203(resultSet.getString("L302_03"));
				vl302.setL30204(resultSet.getString("L302_04"));
				vl302.setL30205(resultSet.getString("L302_05"));
				vl302.setL30206(resultSet.getString("L302_06"));
				vl302.setL30207(resultSet.getString("L302_07"));
				vl302.setL30208(resultSet.getString("L302_08"));
				vl302.setL30209str(resultSet.getString("L302_09Str"));
				vl302.setL30210(resultSet.getString("L302_10"));
				vl302.setL30211(resultSet.getByte("L302_11"));
				vl302.setL30212(resultSet.getString("L302_12"));
				vl302.setL30213(resultSet.getString("L302_13"));
				vl302.setL30214(resultSet.getByte("L302_14"));
				vl302.setL30215(resultSet.getByte("L302_15"));
				vl302.setL30216(resultSet.getString("L302_16"));
				vl302.setL30217(resultSet.getString("L302_17"));
				vl302.setL30218(resultSet.getString("L302_18"));
				vl302.setL30219(resultSet.getShort("L302_19"));
				vl302.setL30220(resultSet.getString("L302_20"));
				vl302.setL30221(resultSet.getString("L302_21"));
				vl302.setL30222(resultSet.getString("L302_22"));
				vl302.setL30223(resultSet.getString("L302_23"));
				vl302.setL30224(resultSet.getString("L302_24"));
				vl302.setL30225(resultSet.getString("L302_25"));
				vl302.setL30226(resultSet.getString("L302_26"));
				vl302.setL30227(resultSet.getString("L302_27"));
				vl302.setL30228(resultSet.getString("L302_28"));
				vl302.setL30229(resultSet.getString("L302_29"));
				vl302.setL30230(resultSet.getString("L302_30"));
				vl302.setL30231(resultSet.getString("L302_31"));
				vl302.setL30232(resultSet.getString("L302_32"));
				vl302.setL30233(resultSet.getString("L302_33"));
				vl302.setL30234(resultSet.getString("L302_34"));
				vl302.setL30235(resultSet.getString("L302_35"));
				vl302.setL30236(resultSet.getString("L302_36"));
				vl302.setL30237(resultSet.getString("L302_37"));
				vl302.setL30238(resultSet.getString("L302_38"));
				vl302.setL30239(resultSet.getString("L302_39"));
				vl302.setL30240(resultSet.getString("L302_40"));
				vl302.setL30241(resultSet.getString("L302_41"));
				vl302.setL30242(resultSet.getString("L302_42"));
				vl302.setL30243(resultSet.getString("L302_43"));
				vl302.setL30244(resultSet.getString("L302_44"));
				vl302.setL30245(resultSet.getString("L302_45"));
				vl302.setL30246(resultSet.getString("L302_46"));
				vl302.setL30247(resultSet.getString("L302_47"));
				vl302.setL30248(resultSet.getString("L302_48"));
				vl302.setL30249(resultSet.getString("L302_49"));
				vl302.setL30250(resultSet.getString("L302_50"));
				vl302.setL30251(resultSet.getString("L302_51"));
				vl302.setL30252(resultSet.getString("L302_52"));
				vl302.setL30253(resultSet.getString("L302_53"));
				vl302.setL30254(resultSet.getString("L302_54"));
				vl302.setL30255(resultSet.getString("L302_55"));
				vl302.setL30256(resultSet.getString("L302_56"));
				vl302.setL30257(resultSet.getString("L302_57"));
				vl302.setL30258(resultSet.getString("L302_58"));
				vl302.setL30259(resultSet.getString("L302_59"));
				vl302.setL30260(resultSet.getString("L302_60"));
				vl302.setL30261str(resultSet.getString("L302_61Str"));
				vl302.setL30262(resultSet.getString("L302_62"));
				vl302.setL30263(resultSet.getString("L302_63"));
				vl302.setL30264(resultSet.getString("L302_64"));
				vl302.setL30265(resultSet.getString("L302_65"));
				vl302.setL30266(resultSet.getString("L302_66"));
				vl302.setL30267(resultSet.getString("L302_67"));
				vl302.setL30268(resultSet.getString("L302_68"));
				vl302.setL30269(resultSet.getString("L302_69"));
				vl302.setL30270str(resultSet.getString("L302_70Str"));
				vl302.setL30271(resultSet.getString("L302_71"));
				vl302.setL30272(resultSet.getString("L302_72"));
				vl302.setL30273(resultSet.getString("L302_73"));
				vl302.setL30274(resultSet.getString("L302_74"));
				vl302.setL30275(resultSet.getString("L302_75"));
				vl302.setL30276(resultSet.getString("L302_76"));
				vl302.setL30277(resultSet.getString("L302_77"));
				vl302.setL30278str(resultSet.getString("L302_78Str"));
				vl302.setL30279(resultSet.getString("L302_79"));
				vl302.setL30280(resultSet.getString("L302_80"));
				vl302.setL30281(resultSet.getString("L302_81"));
				vl302.setL30282(resultSet.getString("L302_82"));
				vl302.setL30283(resultSet.getString("L302_83"));
				vl302.setL30284str(resultSet.getString("L302_84Str"));
				vl302.setL30285(resultSet.getString("L302_85"));
				vl302.setL30286(resultSet.getString("L302_86"));
				vl302.setL30287(resultSet.getString("L302_87"));
				vl302.setL30288(resultSet.getString("L302_88"));
				vl302.setL30289(resultSet.getString("L302_89"));
				vl302.setL30290(resultSet.getString("L302_90"));
				vl302.setL30291(resultSet.getString("L302_91"));
				vl302.setL30292(resultSet.getString("L302_92"));
				vl302.setL30293(resultSet.getString("L302_93"));
				vl302.setL30294str(resultSet.getString("L302_94Str"));
				vl302.setL30295(resultSet.getString("L302_95"));
				vl302.setL30296(resultSet.getString("L302_96"));
				vl302.setL30297(resultSet.getString("L302_97"));
				vl302.setL30298(resultSet.getString("L302_98"));
				vl302.setL30299(resultSet.getString("L302_99"));
				vl302.setL302100str(resultSet.getString("L302_100Str"));
				vl302.setL302101(resultSet.getString("L302_101"));
				vl302.setL302102(resultSet.getString("L302_102"));
				vl302.setL302102zh(resultSet.getString("L302_102Zh"));
				vl302.setL302103(resultSet.getString("L302_103"));
				vl302.setL302104(resultSet.getString("L302_104"));
				vl302.setL302105(resultSet.getString("L302_105"));
				vl302.setL302106(resultSet.getString("L302_106"));
				vl302.setL302107str(resultSet.getString("L302_107Str"));
				vl302.setL302108(resultSet.getString("L302_108"));
				vl302.setL302109(resultSet.getString("L302_109"));
				vl302.setL302110(resultSet.getString("L302_110"));
				vl302.setL302111(resultSet.getString("L302_111"));
				vl302.setL302112(resultSet.getString("L302_112"));
				vl302.setL302113(resultSet.getString("L302_113"));
				vl302.setL302114str(resultSet.getString("L302_114Str"));
				vl302.setL302115(resultSet.getString("L302_115"));
				vl302.setL302116(resultSet.getString("L302_116"));
				vl302.setL302117(resultSet.getString("L302_117"));
				vl302.setL302118(resultSet.getString("L302_118"));
				vl302.setL302118zh(resultSet.getString("L302_118Zh"));
				vl302.setL302119(resultSet.getString("L302_119"));
				vl302.setL302121(resultSet.getDate("L302_121"));
				vl302.setL302124(resultSet.getString("L302_124"));
				vl302.setL302125(resultSet.getString("L302_125"));
				vl302.setL302127(resultSet.getString("L302_127"));
				vl302.setL302131(resultSet.getDate("L302_131"));
				vl302.setL302132(resultSet.getString("L302_132"));
				vl302.setL302133(resultSet.getString("L302_133"));
				vl302.setL302137(resultSet.getString("L302_137"));
				vl302.setL302138(resultSet.getString("L302_138"));
				vl302.setL302139(resultSet.getString("L302_139"));
				vl302.setL302140(resultSet.getString("L302_140"));
				vl302.setL302141(resultSet.getString("L302_141"));
				vl302.setL302142(resultSet.getString("L302_142"));
				vl302.setL302143(resultSet.getString("L302_143"));
				vl302.setL302144(resultSet.getString("L302_144"));
				vl302.setL302145(resultSet.getString("L302_145"));
				vl302.setL302146(resultSet.getDate("L302_146"));
				vl302.setL302147(resultSet.getString("L302_147"));
				vl302.setL302148(resultSet.getString("L302_148"));
				vl302.setL302149(resultSet.getDate("L302_149"));
				vl302.setL302150(resultSet.getString("L302_150"));
				vl302.setL302151(resultSet.getString("L302_151"));
				vl302.setL302152(resultSet.getString("L302_152"));
				vl302.setL302153(resultSet.getString("L302_153"));
				vl302.setL302154(resultSet.getString("L302_154"));
				vl302.setL302155(resultSet.getString("L302_155"));
				vl302.setL302156(resultSet.getDate("L302_156"));
				vl302.setL302157(resultSet.getString("L302_157"));
				vl302.setL302158(resultSet.getString("L302_158"));
				vl302.setL302159(resultSet.getString("L302_159"));
				vl302.setL302160(resultSet.getString("L302_160"));
				vl302.setL302161(resultSet.getString("L302_161"));
				vl302.setL302162(resultSet.getString("L302_162"));
				vl302.setL302163(resultSet.getString("L302_163"));
				vl302.setL302164(resultSet.getString("L302_164"));
				vl302.setL302165(resultSet.getString("L302_165"));
				vl302.setL302166(resultSet.getString("L302_166"));
				vl302.setL302167(resultSet.getString("L302_167"));
				vl302.setL302168(resultSet.getString("L302_168"));
				vl302.setL302169(resultSet.getString("L302_169"));
				vl302.setL302170(resultSet.getString("L302_170"));
				vl302.setL302171(resultSet.getString("L302_171"));
				vl302.setL302172(resultSet.getString("L302_172"));
				vl302.setL302173(resultSet.getDate("L302_173"));
				vl302.setL302174(resultSet.getString("L302_174"));
				vl302.setL302175(resultSet.getString("L302_175"));
				vl302.setL302176(resultSet.getString("L302_176"));
				vl302.setL302177(resultSet.getString("L302_177"));



				vl302.setL302120str(resultSet.getString("L302_120Str"));
				vl302s.add(vl302);
			}
			l302Response.setState(true);
			l302Response.setVl302s(vl302s);
		} catch (Exception e) {
			e.printStackTrace();
			l302Response.setState(false);
			l302Response.setErrorMessage("查询失败");
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
				e.getStackTrace();
			}
		}
		return l302Response;
	}

	@Override
	public L302Response renewL302(L302Request l302Request) {
		L302Response l302Response = new L302Response();
		boolean status = false;
		String flag = l302Request.getFlag();
		L302 l302 = l302Request.getL302();
		try {
			if (l302 != null) {
				Session session = sessionFactory.getCurrentSession();
				L302 _l302 = (L302) session.get(L302.class, l302.getL30201());
				if (_l302 != null) {
					if ("0".equals(flag)) {
						_l302.setL30202(l302.getL30202());
						_l302.setL30203(l302.getL30203());
						_l302.setL30204(l302.getL30204());
						_l302.setL30205(l302.getL30205());
						_l302.setL30206(l302.getL30206());
						_l302.setL30207(l302.getL30207());
						_l302.setL30208(l302.getL30208());
						_l302.setL30209(l302.getL30209());
						_l302.setL30210(l302.getL30210());
						_l302.setL30211(l302.getL30211());
						_l302.setL30212(l302.getL30212());
						_l302.setL30213(l302.getL30213());
						_l302.setL30214(l302.getL30214());
						_l302.setL30215(l302.getL30215());
						_l302.setL30216(l302.getL30216());
						_l302.setL30217(l302.getL30217());
						_l302.setL30218(l302.getL30218());
						_l302.setL30219(l302.getL30219());
						_l302.setL30220(l302.getL30220());
						_l302.setL30221(l302.getL30221());
						_l302.setL30222(l302.getL30222());
						_l302.setL30223(l302.getL30223());
						_l302.setL30224(l302.getL30224());
						_l302.setL30225(l302.getL30225());
						_l302.setL30226(l302.getL30226());
						_l302.setL30227(l302.getL30227());
						_l302.setL30228(l302.getL30228());
						_l302.setL30229(l302.getL30229());
						_l302.setL30230(l302.getL30230());
						_l302.setL30231(l302.getL30231());
						_l302.setL30232(l302.getL30232());
						_l302.setL30233(l302.getL30233());
						_l302.setL302118(l302.getL302118());
						_l302.setL302119(l302.getL302119());
						_l302.setL302120(l302.getL302120());
						_l302.setL302139(l302.getL302139());
						_l302.setL302140(l302.getL302140());
						_l302.setL302141(l302.getL302141());
						_l302.setL302142(l302.getL302142());
						_l302.setL302143(l302.getL302143());
						
						_l302.setL302158(l302.getL302158());
						_l302.setL302159(l302.getL302159());
						_l302.setL302160(l302.getL302160());
						_l302.setL302161(l302.getL302161());
						_l302.setL302162(l302.getL302162());
						_l302.setL302163(l302.getL302163());
						_l302.setL302164(l302.getL302164());	
						_l302.setL302167(l302.getL302167());	

					}
					// 妇科检查
					else if ("1".equals(flag)) {
						_l302.setL30234(l302.getL30234());
						_l302.setL30235(l302.getL30235());
						_l302.setL30236(l302.getL30236());
						_l302.setL30237(l302.getL30237());
						_l302.setL30238(l302.getL30238());
						_l302.setL30239(l302.getL30239());
						_l302.setL30240(l302.getL30240());
						_l302.setL30241(l302.getL30241());
						_l302.setL30242(l302.getL30242());
						_l302.setL30243(l302.getL30243());
						_l302.setL30244(l302.getL30244());
						_l302.setL30245(l302.getL30245());
						_l302.setL30246(l302.getL30246());
						_l302.setL30247(l302.getL30247());
						_l302.setL30248(l302.getL30248());
						_l302.setL30249(l302.getL30249());
						_l302.setL30250(l302.getL30250());
						_l302.setL30251(l302.getL30251());
						_l302.setL30252(l302.getL30252());
						_l302.setL30253(l302.getL30253());
						_l302.setL30254(l302.getL30254());
						_l302.setL30255(l302.getL30255());
						_l302.setL30256(l302.getL30256());
						_l302.setL30257(l302.getL30257());
						_l302.setL30258(l302.getL30258());
						_l302.setL30259(l302.getL30259());
						_l302.setL30260(l302.getL30260());
						_l302.setL30261(l302.getL30261());
						_l302.setL302165(l302.getL302165());
						_l302.setL302166(l302.getL302166());

					}
					// HPV检查
					else if ("2".equals(flag)) {
						_l302.setL30262(l302.getL30262());
						_l302.setL30263(l302.getL30263());
						_l302.setL30264(l302.getL30264());
						_l302.setL30265(l302.getL30265());
						_l302.setL30266(l302.getL30266());
						_l302.setL30267(l302.getL30267());
						_l302.setL30268(l302.getL30268());
						_l302.setL30269(l302.getL30269());
						_l302.setL30270(l302.getL30270());

					}
					// 宫颈细胞学检查
					else if ("3".equals(flag)) {
						_l302.setL30271(l302.getL30271());
						_l302.setL30272(l302.getL30272());
						_l302.setL30273(l302.getL30273());
						_l302.setL30274(l302.getL30274());
						_l302.setL30276(l302.getL30276());
						_l302.setL30277(l302.getL30277());
						_l302.setL30278(l302.getL30278());
						_l302.setL302168(l302.getL302168());
						_l302.setL302169(l302.getL302169());
					

					}
					// 肉眼观察法
					else if ("4".equals(flag)) {
						_l302.setL30279(l302.getL30279());
						_l302.setL30280(l302.getL30280());
						_l302.setL30281(l302.getL30281());
						_l302.setL30282(l302.getL30282());
						_l302.setL30283(l302.getL30283());
						_l302.setL30284(l302.getL30284());

					}
					// 阴道镜检查
					else if ("5".equals(flag)) {
						_l302.setL30285(l302.getL30285());
						_l302.setL30286(l302.getL30286());
						_l302.setL30287(l302.getL30287());
						_l302.setL30288(l302.getL30288());
						_l302.setL30289(l302.getL30289());
						_l302.setL30290(l302.getL30290());
						_l302.setL30291(l302.getL30291());
						_l302.setL30292(l302.getL30292());
						_l302.setL30293(l302.getL30293());
						_l302.setL30294(l302.getL30294());
						_l302.setL302115(l302.getL302115());
						_l302.setL302144(l302.getL302144());
						_l302.setL302146(l302.getL302146());
						_l302.setL302147(l302.getL302147());
						_l302.setL302148(l302.getL302148());
						_l302.setL302149(l302.getL302149());
						_l302.setL302150(l302.getL302150());
						_l302.setL302151(l302.getL302151());
						_l302.setL302152(l302.getL302152());
						_l302.setL302153(l302.getL302153());
						_l302.setL302154(l302.getL302154());
						_l302.setL302155(l302.getL302155());
						_l302.setL302156(l302.getL302156());
						_l302.setL302176(l302.getL302176());
						_l302.setL302177(l302.getL302177());

					}
					// 组织病理检查
					else if ("6".equals(flag)) {
						_l302.setL30295(l302.getL30295());
						_l302.setL30296(l302.getL30296());
						_l302.setL30297(l302.getL30297());
						_l302.setL30298(l302.getL30298());
						_l302.setL30299(l302.getL30299());
						_l302.setL302100(l302.getL302100());

					}
					// 最后诊断
					else if ("7".equals(flag)) {
						_l302.setL302101(l302.getL302101());
						_l302.setL302102(l302.getL302102());
						_l302.setL302103(l302.getL302103());
						_l302.setL302104(l302.getL302104());
						_l302.setL302105(l302.getL302105());
						_l302.setL302106(l302.getL302106());
						_l302.setL302107(l302.getL302107());
						_l302.setL302121(l302.getL302121());
						_l302.setL302122(l302.getL302122());
						_l302.setL302123(l302.getL302123());
						_l302.setL302124(l302.getL302124());
						_l302.setL302125(l302.getL302125());
						_l302.setL302126(l302.getL302126());
						_l302.setL302145(l302.getL302145());
						_l302.setL302157(l302.getL302157());
					}
					// 随访治疗
					else if ("8".equals(flag)) {
						_l302.setL302108(l302.getL302108());
						_l302.setL302109(l302.getL302109());
						_l302.setL302110(l302.getL302110());
						_l302.setL302111(l302.getL302111());
						_l302.setL302112(l302.getL302112());
						_l302.setL302113(l302.getL302113());
						_l302.setL302114(l302.getL302114());
						_l302.setL302116(l302.getL302116());
						_l302.setL302117(l302.getL302117());
						_l302.setL302174(l302.getL302174());
						_l302.setL302175(l302.getL302175());
					} else if ("9".equals(flag)) {// 初筛临床建议
						_l302.setL30275(l302.getL30275());
						_l302.setL302170(l302.getL302170());
						_l302.setL302171(l302.getL302171());
						_l302.setL302172(l302.getL302172());
						_l302.setL302173(l302.getL302173());
						
					}
					L306Response picResponse = savePic(l302Request
							.getPicList(), flag, _l302);
					_l302=setField(_l302, picResponse.isStatus());
					session.saveOrUpdate(_l302);
					L301 l301 = (L301) session.get(L301.class, _l302
							.getL30202());
					if ("2".equals(l301.getL30133())) {
						l301.setL30133("1");
						session.update(l301);
						session.flush();
					}
					status = true;
					l302Response.setPromptMessage("更新成功");
					l302Response = this.setResponseMessage(l302Response,
							picResponse);
				} else
					l302Response.setErrorMessage("保存失败，不存在这条信息");
			} else
				l302Response.setErrorMessage("参数为空");
		} catch (Exception e) {
			e.printStackTrace();
			l302Response.setErrorMessage("更新异常" + e.getMessage());
		}
		l302Response.setState(status);
		return l302Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public L302Response saveL302(L302Request l302Request) {
		L302Response l302Response = new L302Response();
		String flag = l302Request.getFlag();
		L302 l302 = l302Request.getL302();
		l302Response.setState(false);
		try {
			if (l302 == null) {
				l302Response.setErrorMessage("参数为空");
				return l302Response;
			}
			Session session = sessionFactory.getCurrentSession();
			L302 _l302 = (L302) session.createSQLQuery(
					"select * from l302 t where t.l302_02=?").addEntity(
					L302.class).setString(0, l302.getL30202()).uniqueResult();
			if (_l302 != null) {

				if ("0".equals(flag)) {
					l302Response.setErrorMessage("个人病史已经登记过，不能重复登记");
					return l302Response;

					// 妇科检查 病史0
				} else if ("1".equals(flag)) {

					if (_l302.getL30259() != null) {
						l302Response.setErrorMessage("妇科检查已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL30234(l302.getL30234());
					_l302.setL30235(l302.getL30235());
					_l302.setL30236(l302.getL30236());
					_l302.setL30237(l302.getL30237());
					_l302.setL30238(l302.getL30238());
					_l302.setL30239(l302.getL30239());
					_l302.setL30240(l302.getL30240());
					_l302.setL30241(l302.getL30241());
					_l302.setL30242(l302.getL30242());
					_l302.setL30243(l302.getL30243());
					_l302.setL30244(l302.getL30244());
					_l302.setL30245(l302.getL30245());
					_l302.setL30246(l302.getL30246());
					_l302.setL30247(l302.getL30247());
					_l302.setL30248(l302.getL30248());
					_l302.setL30249(l302.getL30249());
					_l302.setL30250(l302.getL30250());
					_l302.setL30251(l302.getL30251());
					_l302.setL30252(l302.getL30252());
					_l302.setL30253(l302.getL30253());
					_l302.setL30254(l302.getL30254());
					_l302.setL30255(l302.getL30255());
					_l302.setL30256(l302.getL30256());
					_l302.setL30257(l302.getL30257());
					_l302.setL30258(l302.getL30258());
					_l302.setL30259(l302.getL30259());
					_l302.setL30260(l302.getL30260());
					_l302.setL30261(l302.getL30261());
					_l302.setL302165(l302.getL302165());
					_l302.setL302166(l302.getL302166());

				}
				// HPV检查
				else if ("2".equals(flag)) {

					if (_l302.getL30268() != null) {
						l302Response.setErrorMessage("HPV检查已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL30262(l302.getL30262());
					_l302.setL30263(l302.getL30263());
					_l302.setL30264(l302.getL30264());
					_l302.setL30265(l302.getL30265());
					_l302.setL30266(l302.getL30266());
					_l302.setL30267(l302.getL30267());
					_l302.setL30268(l302.getL30268());
					_l302.setL30269(l302.getL30269());
					_l302.setL30270(l302.getL30270());

				}
				// 宫颈细胞学检查
				else if ("3".equals(flag)) {

					if (_l302.getL30276() != null) {
						l302Response.setErrorMessage("宫颈细胞学检查已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL30271(l302.getL30271());
					_l302.setL30272(l302.getL30272());
					_l302.setL30273(l302.getL30273());
					_l302.setL30274(l302.getL30274());
					_l302.setL30276(l302.getL30276());
					_l302.setL30277(l302.getL30277());
					_l302.setL30278(l302.getL30278());
					_l302.setL302168(l302.getL302168());
					_l302.setL302169(l302.getL302169());

				}
				// 肉眼观察法
				else if ("4".equals(flag)) {

					if (_l302.getL30282() != null) {
						l302Response.setErrorMessage("肉眼观察法检查已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL30279(l302.getL30279());
					_l302.setL30280(l302.getL30280());
					_l302.setL30281(l302.getL30281());
					_l302.setL30282(l302.getL30282());
					_l302.setL30283(l302.getL30283());
					_l302.setL30284(l302.getL30284());

				}
				// 阴道镜检查
				else if ("5".equals(flag)) {

					if (_l302.getL30292() != null) {
						l302Response.setErrorMessage("阴道镜检查已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL30285(l302.getL30285());
					_l302.setL30286(l302.getL30286());
					_l302.setL30287(l302.getL30287());
					_l302.setL30288(l302.getL30288());
					_l302.setL30289(l302.getL30289());
					_l302.setL30290(l302.getL30290());
					_l302.setL30291(l302.getL30291());
					_l302.setL30292(l302.getL30292());
					_l302.setL30293(l302.getL30293());
					_l302.setL30294(l302.getL30294());
					_l302.setL302115(l302.getL302115());
					_l302.setL302144(l302.getL302144());
			
					_l302.setL302146(l302.getL302146());
					_l302.setL302147(l302.getL302147());
					_l302.setL302148(l302.getL302148());
					_l302.setL302149(l302.getL302149());
					_l302.setL302150(l302.getL302150());
					_l302.setL302151(l302.getL302151());
					_l302.setL302152(l302.getL302152());
					_l302.setL302153(l302.getL302153());
					_l302.setL302154(l302.getL302154());
					_l302.setL302155(l302.getL302155());
					_l302.setL302156(l302.getL302156());
					_l302.setL302176(l302.getL302176());
					_l302.setL302177(l302.getL302177());
				}
				// 组织病理检查
				else if ("6".equals(flag)) {

					if (_l302.getL30298() != null) {
						l302Response.setErrorMessage("组织病理检查已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL30295(l302.getL30295());
					_l302.setL30296(l302.getL30296());
					_l302.setL30297(l302.getL30297());
					_l302.setL30298(l302.getL30298());
					_l302.setL30299(l302.getL30299());
					_l302.setL302100(l302.getL302100());
					

				}
				// 最后诊断
				else if ("7".equals(flag)) {

					if (_l302.getL302105() != null) {
						l302Response.setErrorMessage("最后诊断已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL302101(l302.getL302101());
					_l302.setL302102(l302.getL302102());
					_l302.setL302103(l302.getL302103());
					_l302.setL302104(l302.getL302104());
					_l302.setL302105(l302.getL302105());
					_l302.setL302106(l302.getL302106());
					_l302.setL302107(l302.getL302107());
					_l302.setL302121(l302.getL302121());
					_l302.setL302122(l302.getL302122());
					_l302.setL302123(l302.getL302123());
					_l302.setL302124(l302.getL302124());
					_l302.setL302125(l302.getL302125());
					_l302.setL302126(l302.getL302126());
					_l302.setL302157(l302.getL302157());
					_l302.setL302145(l302.getL302145());
				}
				// 随访治疗
				else if ("8".equals(flag)) {

					if (_l302.getL302112() != null) {
						l302Response.setErrorMessage("随访治疗已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL302108(l302.getL302108());
					_l302.setL302109(l302.getL302109());
					_l302.setL302110(l302.getL302110());
					_l302.setL302111(l302.getL302111());
					_l302.setL302112(l302.getL302112());
					_l302.setL302113(l302.getL302113());
					_l302.setL302114(l302.getL302114());
					_l302.setL302116(l302.getL302116());
					_l302.setL302117(l302.getL302117());
					_l302.setL302174(l302.getL302174());
					_l302.setL302175(l302.getL302175());
				}  else if ("9".equals(flag)) {// 初筛临床建议
					if (_l302.getL302171() != null) {
						l302Response.setErrorMessage("初筛临床建议已经登记过，不能重复登记");
						return l302Response;
					}
					_l302.setL30275(l302.getL30275());
					_l302.setL302170(l302.getL302170());
					_l302.setL302171(l302.getL302171());
					_l302.setL302172(l302.getL302172());
					_l302.setL302173(l302.getL302173());
					
				}else if ("99".equals(flag)) {// 结案
					_l302.setL302131(l302.getL302131());
					_l302.setL302132(l302.getL302132());
					_l302.setL302133(l302.getL302133());
				}
				L306Response picResponse = savePic(l302Request.getPicList(),
						flag, _l302);
				_l302=setField(_l302, picResponse.isStatus());
				session.update(_l302);
				l302Response.setL302(_l302);
				l302Response = saveSuccess(l302Response);
				l302Response = this.setResponseMessage(l302Response,
						picResponse);
			} else if ("0".equals(flag)) {
				session.save(l302);
				l302Response.setL302(l302);
				l302Response = saveSuccess(l302Response);
				if (l302Response.isState()) {
					L301 l301 = (L301) session
							.get(L301.class, l302.getL30202());
					l301.setL30133("1");
					session.update(l301);
					session.flush();
				}
			} else if (!"0".equals(flag)) {
				l302Response.setErrorMessage("请先登记病史信息");
			}

		} catch (Exception e) {
			l302Response.setErrorMessage(e.getMessage());
		}
		return l302Response;
	}

	private L302Response saveSuccess(L302Response l302Response) {
		l302Response.setState(true);
		l302Response.setPromptMessage("保存成功");
		return l302Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public L302Response queryByL302Id(String l30202) {
		L302Response l302Response = new L302Response();
		l302Response.setState(false);
		try {
			if (l30202 != null) {
				Session session = sessionFactory.getCurrentSession();
				List<L302> list = session.createSQLQuery(
						"select * from l302 t where t.l302_02=?").addEntity(
						L302.class).setParameter(0, l30202).list();
				if (list.size() < 1) {
					l302Response.setErrorMessage("不存在该对象");
					return l302Response;
				}
				L302 l302 = null;
				for (L302 _l302 : list) {
					l302 = _l302;
				}
				l302Response.setL302(l302);
				l302Response.setState(true);
				return l302Response;
			}
			l302Response.setErrorMessage("参数不正确");
		} catch (Exception e) {
			e.printStackTrace();
			l302Response.setErrorMessage("查询异常");
		}
		return l302Response;
	}

	/**
	 * 图片保存
	 * 
	 * @param picList
	 * @param flag
	 * @param l302
	 * @return
	 */
	private L306Response savePic(List<HashMap<String, Object>> picList,
			String flag, L302 l302) {
		L306Response picResponse = new L306Response();
		picResponse.setStatus(false);
		if ("5".equals(flag)&&picList!=null) {
			if (picList.size() > 0) {
				L306 l306=new L306();
				L306Request picRequest = new L306Request();
				l306.setL30604("1");
				l306.setL30613(new Date());
				l306.setL30602(l302.getL30201());
				l306.setL30603(l302.getL30205());
				l306.setL30611(l302.getL30292());
				l306.setL30612(l302.getL30293());
				picRequest.setPicList(picList);
				picRequest.setL306(l306);
				picRequest.setFlag("gja" + File.separator + "ydj");
				picResponse = l306Service.saveLaPic(picRequest);
			}
		}
		return picResponse;
	}

	/**
	 * 设置消息
	 * 
	 * @param l302Response
	 * @param picResponse
	 * @return
	 */
	private L302Response setResponseMessage(L302Response l302Response,
			L306Response picResponse) {
		StringBuffer message=new StringBuffer("");
		if (picResponse.isStatus()) {
			 message.append( picResponse.isStatus() ? ",图片保存成功" : picResponse
					.getErrorMessage());
		}
		if (l302Response.isState()) {
			l302Response.setPromptMessage("保存成功" + message.toString());
		} else
			l302Response.setErrorMessage(l302Response.getErrorMessage()
					+ "/n" + message.toString());
		return l302Response;

	}
	/**
	 * 设置上传图片标识
	 * @param l302
	 * @param picStatus
	 * @return
	 */
	private L302 setField(L302 l302,boolean picStatus) {
		if(picStatus){
			l302.setL302137("1");
			l302.setL302138("2");
		}else{
			if(l302.getL302137()==null)
				l302.setL302137("2");
			if(l302.getL302138()==null)
				l302.setL302138("2");
		}
			
		return l302;
	}
}
