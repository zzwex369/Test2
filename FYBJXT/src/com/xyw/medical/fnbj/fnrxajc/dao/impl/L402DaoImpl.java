package com.xyw.medical.fnbj.fnrxajc.dao.impl;

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

import com.xyw.medical.fnbj.fnlapic.service.L306Service;
import com.xyw.medical.fnbj.fnrxajc.dao.L402Dao;
import com.xyw.medical.fnbj.model.L301;
import com.xyw.medical.fnbj.model.L306;
import com.xyw.medical.fnbj.model.L306Request;
import com.xyw.medical.fnbj.model.L306Response;
import com.xyw.medical.fnbj.model.L402;
import com.xyw.medical.fnbj.model.L402Request;
import com.xyw.medical.fnbj.model.L402Response;
import com.xyw.medical.fnbj.model.VL402;
import com.xyw.sys.util.StringUtil;

public class L402DaoImpl implements L402Dao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	@Resource
	L306Service l306Service;

	@Override
	public L402Response delL402(L402Request l402Request) {
		L402Response l402Response = new L402Response();
		l402Response.setState(false);
		String l40201 = l402Request.getL40201();
		try {
			if (!StringUtil.isBlankString(l40201)) {
				Session session = sessionFactory.getCurrentSession();
				L402 _l402 = (L402) session.get(L402.class, l40201);
				if (_l402 != null) {
					session.delete(_l402);
					L301 l301 = (L301) session
					.get(L301.class, _l402.getL40202());
					l301.setL30134("2");
					session.update(l301);
					session.flush();
					l402Response.setState(true);
					l402Response.setPromptMessage("删除成功");
					return l402Response;
				}
				l402Response.setErrorMessage("不存在这条信息");
				return l402Response;
			}
			l402Response.setErrorMessage("传值不正确");
			return l402Response;
		} catch (Exception e) {
			l402Response.setErrorMessage(e.getMessage());
		}
		return l402Response;
	}

	@Override
	public L402Response queryL402(L402Request l402Request) {
		L402Response l402Response = new L402Response();
		String suffixSql = l402Request.getSuffixSql();
		int parameterPageIndex = l402Request.getParameterPageindex();
		int parameterPagesize = l402Request.getParameterPagesize();
		Date timeDate = l402Request.getTimeStr();
		Date timeEnDate = l402Request.getTimeEnd();
		L402 l402 = l402Request.getL402();
		String l40284 = l402.getL40284();
		String l402123 = l402.getL402123();
		String l402148 = l402.getL402148();
		String l402150 = l402.getL402150();
		String l402151 = l402.getL402151();
		String l402152 = l402.getL402152();
		String l402153 = l402.getL402153();
		String l402102 = l402.getL402102();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		String l40203 = l402.getL40203();
		String l40204 = l402.getL40204();
		if (!StringUtil.isBlankString(l40203)) {
			parameterConditionwhere.append(" and t.l402_03='" + l40203 + "'");
		}
		if (!StringUtil.isBlankString(l40204)) {
			parameterConditionwhere.append(" and t.l402_04='" + l40204 + "'");
		}
		
		if (!StringUtil.isBlankString(l402150)) {
			parameterConditionwhere.append(" and t.l402_150='" + l402150 + "'");
		}
		
		if (!StringUtil.isBlankString(l402151)) {
			parameterConditionwhere.append(" and t.l402_151='" + l402151 + "'");
		}
		if (!StringUtil.isBlankString(l402152)) {
			parameterConditionwhere.append(" and t.l402_152='" + l402152 + "'");
		}
		
		if (!StringUtil.isBlankString(l402153)) {
			parameterConditionwhere.append(" and t.l402_153='" + l402153 + "'");
		}

		if (timeDate != null) {
			parameterConditionwhere.append(" and t.l402_125Str >='"
					+ sdf.format(timeDate) + "'");
		}
		if (timeEnDate != null) {
			parameterConditionwhere.append(" and t.l402_125Str <= '"
					+ sdf.format(timeEnDate) + "'");
		}

		if (!StringUtil.isBlankString(l402148)) {
			parameterConditionwhere.append(" and t.l402_148 " + l402148);
		}
		
		
		if (!StringUtil.isBlankString(l40284)) {
			if (l40284.length() == 14) {
				parameterConditionwhere.append(" and t.l402_84 = '");
				parameterConditionwhere.append(l40284);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.l402_84 like '");
				parameterConditionwhere.append(l40284);
				parameterConditionwhere.append("%'");
			}
		}
		
		if (!StringUtil.isBlankString(l402102)) {
			if (l402102.length() == 14) {
				parameterConditionwhere.append(" and t.l402_102 = '");
				parameterConditionwhere.append(l402102);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.l402_102 like '");
				parameterConditionwhere.append(l402102);
				parameterConditionwhere.append("%'");
			}
		}
		
		if (!StringUtil.isBlankString(l402123)) {
			if (l402123.length() == 14) {
				parameterConditionwhere.append(" and t.l402_123 = '");
				parameterConditionwhere.append(l402123);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.l402_123 like '");
				parameterConditionwhere.append(l402123);
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
			callableStatement.setString(3, "v_l402");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.l402_125");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			if (rowCount == 0) {
				l402Response.setState(false);
				l402Response.setErrorMessage("暂无数据");
				return l402Response;
			}
			l402Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);

			VL402 vl402 = null;
			List<VL402> vl402s = new ArrayList<VL402>();
			while (resultSet.next()) {
				vl402 = new VL402();
				vl402.setL40201(resultSet.getString("L402_01"));
				vl402.setL40202(resultSet.getString("L402_02"));
				vl402.setL40203(resultSet.getString("L402_03"));
				vl402.setL40204(resultSet.getString("L402_04"));
				vl402.setL40205(resultSet.getString("L402_05"));
				vl402.setL40206(resultSet.getShort("L402_06"));
				vl402.setL40207(resultSet.getDate("L402_07"));
				vl402.setL40208(resultSet.getString("L402_08"));
				vl402.setL40209(resultSet.getShort("L402_09"));
				vl402.setL40210(resultSet.getString("L402_10"));
				vl402.setL40211(resultSet.getString("L402_11"));
				vl402.setL40212(resultSet.getString("L402_12"));
				vl402.setL40213(resultSet.getString("L402_13"));
				vl402.setL40214(resultSet.getString("L402_14"));
				vl402.setL40215(resultSet.getString("L402_15"));
				vl402.setL40216(resultSet.getString("L402_16"));
				vl402.setL40217(resultSet.getString("L402_17"));
				vl402.setL40218(resultSet.getShort("L402_18"));
				vl402.setL40219(resultSet.getString("L402_19"));
				vl402.setL40220(resultSet.getString("L402_20"));
				vl402.setL40221(resultSet.getByte("L402_21"));
				vl402.setL40222(resultSet.getString("L402_22"));
				vl402.setL40223(resultSet.getString("L402_23"));
				vl402.setL40224(resultSet.getString("L402_24"));
				vl402.setL40225(resultSet.getString("L402_25"));
				vl402.setL40226(resultSet.getString("L402_26"));
				vl402.setL40227(resultSet.getString("L402_27"));
				vl402.setL40228(resultSet.getString("L402_28"));
				vl402.setL40229(resultSet.getString("L402_29"));
				vl402.setL40230(resultSet.getString("L402_30"));
				vl402.setL40231(resultSet.getDouble("L402_31"));
				vl402.setL40232(resultSet.getString("L402_32"));
				vl402.setL40233(resultSet.getString("L402_33"));
				vl402.setL40234(resultSet.getString("L402_34"));
				vl402.setL40235(resultSet.getString("L402_35"));
				vl402.setL40236(resultSet.getString("L402_36"));
				vl402.setL40237(resultSet.getString("L402_37"));
				vl402.setL40238(resultSet.getString("L402_38"));
				vl402.setL40239(resultSet.getDouble("L402_39"));
				vl402.setL40240(resultSet.getString("L402_40"));
				vl402.setL40241(resultSet.getString("L402_41"));
				vl402.setL40242(resultSet.getString("L402_42"));
				vl402.setL40243(resultSet.getString("L402_43"));
				vl402.setL40244(resultSet.getString("L402_44"));
				vl402.setL40245(resultSet.getString("L402_45"));
				vl402.setL40246(resultSet.getDate("L402_46"));
				vl402.setL40247(resultSet.getString("L402_47"));
				vl402.setL40248(resultSet.getString("L402_48"));
				vl402.setL40249(resultSet.getString("L402_49"));
				vl402.setL40250(resultSet.getString("L402_50"));
				vl402.setL40251(resultSet.getString("L402_51"));
				vl402.setL40252(resultSet.getString("L402_52"));
				vl402.setL40253(resultSet.getString("L402_53"));
				vl402.setL40254(resultSet.getString("L402_54"));
				vl402.setL40255(resultSet.getString("L402_55"));
				vl402.setL40256(resultSet.getString("L402_56"));
				vl402.setL40257(resultSet.getString("L402_57"));
				vl402.setL40258(resultSet.getString("L402_58"));
				vl402.setL40259(resultSet.getString("L402_59"));
				vl402.setL40260(resultSet.getString("L402_60"));
				vl402.setL40261(resultSet.getString("L402_61"));
				vl402.setL40262(resultSet.getString("L402_62"));
				vl402.setL40263(resultSet.getString("L402_63"));
				vl402.setL40264(resultSet.getString("L402_64"));
				vl402.setL40265(resultSet.getString("L402_65"));
				vl402.setL40266(resultSet.getString("L402_66"));
				vl402.setL40267(resultSet.getString("L402_67"));
				vl402.setL40268(resultSet.getString("L402_68"));
				vl402.setL40269(resultSet.getString("L402_69"));
				vl402.setL40270(resultSet.getString("L402_70"));
				vl402.setL40271(resultSet.getString("L402_71"));
				vl402.setL40272(resultSet.getString("L402_72"));
				vl402.setL40273(resultSet.getString("L402_73"));
				vl402.setL40274(resultSet.getString("L402_74"));
				vl402.setL40275(resultSet.getString("L402_75"));
				vl402.setL40276(resultSet.getString("L402_76"));
				vl402.setL40277(resultSet.getString("L402_77"));
				vl402.setL40278(resultSet.getString("L402_78"));
				vl402.setL40279(resultSet.getString("L402_79"));
				vl402.setL40280(resultSet.getString("L402_80"));
				vl402.setL40281(resultSet.getString("L402_81"));
				vl402.setL40282(resultSet.getString("L402_82"));
				vl402.setL40283(resultSet.getString("L402_83"));
				vl402.setL40284(resultSet.getString("L402_84"));
				vl402.setL40285(resultSet.getString("L402_85"));
				vl402.setL40286(resultSet.getDate("L402_86"));
				vl402.setL40287(resultSet.getString("L402_87"));
				vl402.setL40288(resultSet.getString("L402_88"));
				vl402.setL40289(resultSet.getString("L402_89"));
				vl402.setL40290(resultSet.getString("L402_90"));
				vl402.setL40291(resultSet.getString("L402_91"));
				vl402.setL40292(resultSet.getString("L402_92"));
				vl402.setL40293(resultSet.getString("L402_93"));
				vl402.setL40294(resultSet.getString("L402_94"));
				vl402.setL40295(resultSet.getString("L402_95"));
				vl402.setL40296(resultSet.getString("L402_96"));
				vl402.setL40297(resultSet.getString("L402_97"));
				vl402.setL40298(resultSet.getString("L402_98"));
				vl402.setL40299(resultSet.getString("L402_99"));
				vl402.setL402100(resultSet.getString("L402_100"));
				vl402.setL402101(resultSet.getString("L402_101"));
				vl402.setL402102(resultSet.getString("L402_102"));
				vl402.setL402103(resultSet.getString("L402_103"));
				vl402.setL402104(resultSet.getDate("L402_104"));
				vl402.setL402105(resultSet.getString("L402_105"));
				vl402.setL402106(resultSet.getString("L402_106"));
				vl402.setL402107(resultSet.getString("L402_107"));
				vl402.setL402108(resultSet.getString("L402_108"));
				vl402.setL402109(resultSet.getDate("L402_109"));
				vl402.setL402110(resultSet.getString("L402_110"));
				vl402.setL402111(resultSet.getString("L402_111"));
				vl402.setL402112(resultSet.getString("L402_112"));
				vl402.setL402113(resultSet.getString("L402_113"));
				vl402.setL402114(resultSet.getString("L402_114"));
				vl402.setL402115(resultSet.getString("L402_115"));
				vl402.setL402116(resultSet.getString("L402_116"));
				vl402.setL402117(resultSet.getString("L402_117"));
				vl402.setL402118(resultSet.getString("L402_118"));
				vl402.setL402119(resultSet.getString("L402_119"));
				vl402.setL402120(resultSet.getString("L402_120"));
				vl402.setL402121(resultSet.getDate("L402_121"));
				vl402.setL402122(resultSet.getString("L402_122"));
				vl402.setL402123(resultSet.getString("L402_123"));
				vl402.setL402124(resultSet.getString("L402_124"));
				vl402.setL402125(resultSet.getDate("L402_125"));
				vl402.setL402126(resultSet.getString("L402_126"));
				vl402.setL402127(resultSet.getString("L402_127"));
				vl402.setL402128(resultSet.getString("L402_128"));
				vl402.setL402131(resultSet.getDate("L402_131"));
				vl402.setL402130(resultSet.getString("L402_130"));
				vl402.setL402147(resultSet.getDate("L402_147"));
				vl402.setL402148(resultSet.getString("L402_148"));
				vl402.setL402149(resultSet.getString("L402_149"));
				vl402.setL402150(resultSet.getString("L402_150"));
				vl402.setL402151(resultSet.getString("L402_151"));
				vl402.setL402152(resultSet.getString("L402_152"));
				vl402.setL402153(resultSet.getString("L402_153"));
				vl402.setL402154(resultSet.getString("L402_154"));
				vl402.setL402155(resultSet.getString("L402_155"));
				vl402.setL402156(resultSet.getString("L402_156"));
				vl402.setL402157(resultSet.getString("L402_157"));
				vl402.setL402158(resultSet.getString("L402_158"));
				vl402.setL402159(resultSet.getString("L402_159"));
				vl402.setL402160(resultSet.getString("L402_160"));
				vl402.setL402161(resultSet.getString("L402_161"));
				vl402.setL402162(resultSet.getString("L402_162"));
				vl402.setL402163(resultSet.getString("L402_163"));
				vl402.setL402164(resultSet.getString("L402_164"));
				vl402.setL402165(resultSet.getString("L402_165"));
				vl402.setL402166(resultSet.getString("L402_166"));
				vl402.setL402167(resultSet.getDate("L402_167"));
				vl402.setL402168(resultSet.getString("L402_168"));
				vl402.setL402169(resultSet.getString("L402_169"));
				vl402.setL402170(resultSet.getDate("L402_170"));
				vl402.setL402171(resultSet.getString("L402_171"));
				vl402.setL402172(resultSet.getString("L402_172"));
				vl402.setL402173(resultSet.getString("L402_173"));
				vl402.setL402174(resultSet.getString("L402_174"));
				vl402.setL402175(resultSet.getString("L402_175"));
				vl402.setL402176(resultSet.getDate("L402_176"));

				vl402.setL402179(resultSet.getString("L402_179"));
				vl402.setL402180(resultSet.getString("L402_180"));
				vl402.setL402181(resultSet.getString("L402_181"));
				vl402.setL402182(resultSet.getString("L402_182"));
				vl402.setL402183(resultSet.getString("L402_183"));
				vl402.setL402184(resultSet.getString("L402_184"));
				vl402.setL402185(resultSet.getString("L402_185"));
				vl402.setL402186(resultSet.getString("L402_186"));
				vl402.setL402187(resultSet.getString("L402_187"));
				vl402.setL402188(resultSet.getString("L402_188"));


				vl402.setL40284Zh(resultSet.getString("l402_84Zh"));
				vl402.setL402102Zh(resultSet.getString("l402_102Zh"));
				vl402.setL40207Str(resultSet.getString("l402_07Str"));
				vl402.setL40246Str(resultSet.getString("l402_46Str"));
				vl402.setL40286Str(resultSet.getString("l402_86Str"));
				vl402.setL402104Str(resultSet.getString("l402_104Str"));
				vl402.setL402109Str(resultSet.getString("l402_109Str"));
				vl402.setL402121Str(resultSet.getString("l402_121Str"));
				vl402.setL402125Str(resultSet.getString("l402_125Str"));
				vl402s.add(vl402);
			}
			l402Response.setState(true);
			l402Response.setVl402s(vl402s);
		} catch (Exception e) {
			e.getStackTrace();
			l402Response.setState(false);
			l402Response.setErrorMessage("查询失败");
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
		return l402Response;
	}

	@Override
	public L402Response renewL402(L402Request l402Request) {
		L402Response l402Response = new L402Response();
		l402Response.setState(false);
		String flag = l402Request.getFlag();
		L402 l402 = l402Request.getL402();
		try {
			if (l402 != null) {
				Session session = sessionFactory.getCurrentSession();
				L402 _l402 = (L402) session.get(L402.class, l402.getL40201());
				if (_l402 != null) {
					// 乳腺触诊
					if ("1".equals(flag)) {
						_l402.setL40226(l402.getL40226());
						_l402.setL40227(l402.getL40227());
						_l402.setL40228(l402.getL40228());
						_l402.setL40229(l402.getL40229());
						_l402.setL40230(l402.getL40230());
						_l402.setL40231(l402.getL40231());
						_l402.setL40232(l402.getL40232());
						_l402.setL40233(l402.getL40233());
						_l402.setL40234(l402.getL40234());
						_l402.setL40235(l402.getL40235());
						_l402.setL40236(l402.getL40236());
						_l402.setL40237(l402.getL40237());
						_l402.setL40238(l402.getL40238());
						_l402.setL40239(l402.getL40239());
						_l402.setL40240(l402.getL40240());
						_l402.setL40241(l402.getL40241());
						_l402.setL40242(l402.getL40242());
						_l402.setL40243(l402.getL40243());
						_l402.setL40244(l402.getL40244());
						_l402.setL40245(l402.getL40245());
						_l402.setL40246(l402.getL40246());
						_l402.setL402179(l402.getL402179());
						_l402.setL402180(l402.getL402180());
					} else if ("2".equals(flag)) {// 乳腺彩超
						_l402.setL40247(l402.getL40247());
						_l402.setL40248(l402.getL40248());
						_l402.setL40249(l402.getL40249());
						_l402.setL40250(l402.getL40250());
						_l402.setL40251(l402.getL40251());
						_l402.setL40252(l402.getL40252());
						_l402.setL40253(l402.getL40253());
						_l402.setL40254(l402.getL40254());
						_l402.setL40255(l402.getL40255());
						_l402.setL40256(l402.getL40256());
						_l402.setL40257(l402.getL40257());
						_l402.setL40258(l402.getL40258());
						_l402.setL40259(l402.getL40259());
						_l402.setL40260(l402.getL40260());
						_l402.setL40261(l402.getL40261());
						_l402.setL40262(l402.getL40262());
						_l402.setL40263(l402.getL40263());
						_l402.setL40264(l402.getL40264());
						_l402.setL40265(l402.getL40265());
						_l402.setL40266(l402.getL40266());
						_l402.setL40267(l402.getL40267());
						_l402.setL40268(l402.getL40268());
						_l402.setL40269(l402.getL40269());
						_l402.setL40270(l402.getL40270());
						_l402.setL40271(l402.getL40271());
						_l402.setL40272(l402.getL40272());
						_l402.setL40273(l402.getL40273());
						_l402.setL40274(l402.getL40274());
						_l402.setL40275(l402.getL40275());
						_l402.setL40276(l402.getL40276());
						_l402.setL40277(l402.getL40277());
						_l402.setL40278(l402.getL40278());
						_l402.setL40279(l402.getL40279());
						_l402.setL40280(l402.getL40280());
						_l402.setL40281(l402.getL40281());
						_l402.setL40282(l402.getL40282());
						_l402.setL40284(l402.getL40284());
						_l402.setL40285(l402.getL40285());
						_l402.setL40286(l402.getL40286());
						_l402.setL402161(l402.getL402161());
					


					} else if ("3".equals(flag)) {	// 乳腺x线
						_l402.setL40287(l402.getL40287());
						_l402.setL40288(l402.getL40288());
						_l402.setL40289(l402.getL40289());
						_l402.setL40290(l402.getL40290());
						_l402.setL40291(l402.getL40291());
						_l402.setL40292(l402.getL40292());
						_l402.setL40293(l402.getL40293());
						_l402.setL40294(l402.getL40294());
						_l402.setL40295(l402.getL40295());
						_l402.setL40296(l402.getL40296());
						_l402.setL40297(l402.getL40297());
						_l402.setL40298(l402.getL40298());
						_l402.setL40299(l402.getL40299());
						_l402.setL402100(l402.getL402100());
						_l402.setL402102(l402.getL402102());
						_l402.setL402103(l402.getL402103());
						_l402.setL402104(l402.getL402104());
						_l402.setL402126(l402.getL402126());
						_l402.setL402127(l402.getL402127());
						_l402.setL402128(l402.getL402128());
						_l402.setL402129(l402.getL402129());
						_l402.setL402130(l402.getL402130());
						_l402.setL402131(l402.getL402131());
						_l402.setL402132(l402.getL402132());
						_l402.setL402133(l402.getL402133());
						
						_l402.setL402162(l402.getL402162());
						_l402.setL402163(l402.getL402163());
						_l402.setL402164(l402.getL402164());
						_l402.setL402181(l402.getL402181());
						_l402.setL402182(l402.getL402182());
						_l402.setL402183(l402.getL402183());
						_l402.setL402184(l402.getL402184());
						_l402.setL402185(l402.getL402185());
						_l402.setL402186(l402.getL402186());
						_l402.setL402187(l402.getL402187());
						_l402.setL402188(l402.getL402188());
			
					} else if ("4".equals(flag)) {	// 随访结果
						_l402.setL402105(l402.getL402105());
						_l402.setL402106(l402.getL402106());
						_l402.setL402107(l402.getL402107());
						_l402.setL402108(l402.getL402108());
						_l402.setL402109(l402.getL402109());
						_l402.setL402110(l402.getL402110());
						_l402.setL402111(l402.getL402111());
						_l402.setL402112(l402.getL402112());
						_l402.setL402113(l402.getL402113());
						_l402.setL402114(l402.getL402114());
						_l402.setL402115(l402.getL402115());
						_l402.setL402116(l402.getL402116());
						_l402.setL402117(l402.getL402117());
						_l402.setL402118(l402.getL402118());
						_l402.setL402119(l402.getL402119());
						_l402.setL402120(l402.getL402120());
						_l402.setL402121(l402.getL402121());
						_l402.setL402122(l402.getL402122());
						_l402.setL402126(l402.getL402126());
						_l402.setL402127(l402.getL402127());
						_l402.setL402128(l402.getL402128());
						_l402.setL402129(l402.getL402129());
						_l402.setL402130(l402.getL402130());
						_l402.setL402131(l402.getL402131());
						_l402.setL402132(l402.getL402132());
						_l402.setL402133(l402.getL402133());
						_l402.setL402154(l402.getL402154());
						_l402.setL402171(l402.getL402171());
						_l402.setL402172(l402.getL402172());
						_l402.setL402173(l402.getL402173());
						_l402.setL402174(l402.getL402174());
						_l402.setL402175(l402.getL402175());
						_l402.setL402176(l402.getL402176());
					} else if ("5".equals(flag)) {//初筛临床建议
						
						_l402.setL40283(l402.getL40283());
						_l402.setL402165(l402.getL402165());
						_l402.setL402166(l402.getL402166());
						_l402.setL402167(l402.getL402167());
						
					} else if ("6".equals(flag)) {//乳腺X线临床建议
						
						_l402.setL402101(l402.getL402101());
						_l402.setL402168(l402.getL402168());
						_l402.setL402169(l402.getL402169());
						_l402.setL402170(l402.getL402170());
						
					} else {
						_l402.setL40202(l402.getL40202());
						_l402.setL40203(l402.getL40203());
						_l402.setL40204(l402.getL40204());
						_l402.setL40205(l402.getL40205());
						_l402.setL40206(l402.getL40206());
						_l402.setL40207(l402.getL40207());
						_l402.setL40208(l402.getL40208());
						_l402.setL40209(l402.getL40209());
						_l402.setL40210(l402.getL40210());
						_l402.setL40211(l402.getL40211());
						_l402.setL40212(l402.getL40212());
						_l402.setL40213(l402.getL40213());
						_l402.setL40214(l402.getL40214());
						_l402.setL40215(l402.getL40215());
						_l402.setL40216(l402.getL40216());
						_l402.setL40217(l402.getL40217());
						_l402.setL40218(l402.getL40218());
						_l402.setL40219(l402.getL40219());
						_l402.setL40220(l402.getL40220());
						_l402.setL40221(l402.getL40221());
						_l402.setL40222(l402.getL40222());
						_l402.setL40223(l402.getL40223());
						_l402.setL40224(l402.getL40224());
						_l402.setL40225(l402.getL40225());
						_l402.setL40226(l402.getL40226());
						_l402.setL40227(l402.getL40227());
						_l402.setL40228(l402.getL40228());
						_l402.setL40229(l402.getL40229());
						_l402.setL40230(l402.getL40230());
						_l402.setL40231(l402.getL40231());
						_l402.setL40232(l402.getL40232());
						_l402.setL40233(l402.getL40233());
						_l402.setL40234(l402.getL40234());
						_l402.setL40235(l402.getL40235());
						_l402.setL40236(l402.getL40236());
						_l402.setL40237(l402.getL40237());
						_l402.setL40238(l402.getL40238());
						_l402.setL40239(l402.getL40239());
						_l402.setL40240(l402.getL40240());
						_l402.setL40241(l402.getL40241());
						_l402.setL40242(l402.getL40242());
						_l402.setL40243(l402.getL40243());
						_l402.setL402123(l402.getL402123());
						_l402.setL402124(l402.getL402124());
						_l402.setL402125(l402.getL402125());
						
						_l402.setL402155(l402.getL402155());
						_l402.setL402156(l402.getL402156());
						_l402.setL402157(l402.getL402157());
						_l402.setL402158(l402.getL402158());
						_l402.setL402159(l402.getL402159());
						_l402.setL402160(l402.getL402160());
					}

					L306Response picResponse = savePic(l402Request
							.getPicList(), flag, _l402);
					_l402 = setField(_l402, picResponse.isStatus(), flag);
					session.saveOrUpdate(_l402);
					l402Response.setState(true);
					L301 l301 = (L301) session.get(L301.class, _l402
							.getL40202());
					if ("2".equals(l301.getL30134())) {
						l301.setL30134("1");
						session.update(l301);
						session.flush();
					}
					l402Response = this.setResponseMessage(l402Response,
							picResponse);
					return l402Response;
				} else {
					l402Response.setErrorMessage("不存在这条信息");
					return l402Response;
				}
			} else {
				l402Response.setErrorMessage("参数为空");
				return l402Response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			l402Response.setErrorMessage("更新异常");
		}
		return l402Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public L402Response saveL402(L402Request l402Request) {
		L402Response l402Response = new L402Response();
		l402Response.setState(false);
		L402 l402 = l402Request.getL402();
		String flag = l402Request.getFlag();
		Session session = sessionFactory.getCurrentSession();
		try {
			L402 _l402 = (L402) session.createSQLQuery(
					"select * from l402 t where t.l402_02=?").addEntity(
					L402.class).setString(0, l402.getL40202()).uniqueResult();
			if (_l402 != null) {
				if ("0".equals(flag)) {
					l402Response.setErrorMessage("个人病史已经登记过，不能重复登记");
					return l402Response;
					// 乳腺触诊
				} else if ("1".equals(flag)) {

					if (_l402.getL40244() != null) {
						l402Response.setErrorMessage("不能重复登记");
						return l402Response;
					} else {
						_l402.setL40226(l402.getL40226());
						_l402.setL40227(l402.getL40227());
						_l402.setL40228(l402.getL40228());
						_l402.setL40229(l402.getL40229());
						_l402.setL40230(l402.getL40230());
						_l402.setL40231(l402.getL40231());
						_l402.setL40232(l402.getL40232());
						_l402.setL40233(l402.getL40233());
						_l402.setL40234(l402.getL40234());
						_l402.setL40235(l402.getL40235());
						_l402.setL40236(l402.getL40236());
						_l402.setL40237(l402.getL40237());
						_l402.setL40238(l402.getL40238());
						_l402.setL40239(l402.getL40239());
						_l402.setL40240(l402.getL40240());
						_l402.setL40241(l402.getL40241());
						_l402.setL40242(l402.getL40242());
						_l402.setL40243(l402.getL40243());
						_l402.setL40244(l402.getL40244());
						_l402.setL40245(l402.getL40245());
						_l402.setL40246(l402.getL40246());
						_l402.setL402179(l402.getL402179());
						_l402.setL402180(l402.getL402180());
					}
					// 乳腺彩超
				} else if ("2".equals(flag)) {

					if (_l402.getL40285() != null) {
						l402Response.setErrorMessage("不能重复登记");
						return l402Response;
					} else {
						_l402.setL40247(l402.getL40247());
						_l402.setL40248(l402.getL40248());
						_l402.setL40249(l402.getL40249());
						_l402.setL40250(l402.getL40250());
						_l402.setL40251(l402.getL40251());
						_l402.setL40252(l402.getL40252());
						_l402.setL40253(l402.getL40253());
						_l402.setL40254(l402.getL40254());
						_l402.setL40255(l402.getL40255());
						_l402.setL40256(l402.getL40256());
						_l402.setL40257(l402.getL40257());
						_l402.setL40258(l402.getL40258());
						_l402.setL40259(l402.getL40259());
						_l402.setL40260(l402.getL40260());
						_l402.setL40261(l402.getL40261());
						_l402.setL40262(l402.getL40262());
						_l402.setL40263(l402.getL40263());
						_l402.setL40264(l402.getL40264());
						_l402.setL40265(l402.getL40265());
						_l402.setL40266(l402.getL40266());
						_l402.setL40267(l402.getL40267());
						_l402.setL40268(l402.getL40268());
						_l402.setL40269(l402.getL40269());
						_l402.setL40270(l402.getL40270());
						_l402.setL40271(l402.getL40271());
						_l402.setL40272(l402.getL40272());
						_l402.setL40273(l402.getL40273());
						_l402.setL40274(l402.getL40274());
						_l402.setL40275(l402.getL40275());
						_l402.setL40276(l402.getL40276());
						_l402.setL40277(l402.getL40277());
						_l402.setL40278(l402.getL40278());
						_l402.setL40279(l402.getL40279());
						_l402.setL40280(l402.getL40280());
						_l402.setL40281(l402.getL40281());
						_l402.setL40282(l402.getL40282());
						_l402.setL40284(l402.getL40284());
						_l402.setL40285(l402.getL40285());
						_l402.setL40286(l402.getL40286());
						_l402.setL402161(l402.getL402161());
					


					}
					// 乳腺x线
				} else if ("3".equals(flag)) {

					if (_l402.getL402128() != null) {
						l402Response.setErrorMessage("不能重复登记");
						return l402Response;
					} else {
						_l402.setL40287(l402.getL40287());
						_l402.setL40288(l402.getL40288());
						_l402.setL40289(l402.getL40289());
						_l402.setL40290(l402.getL40290());
						_l402.setL40291(l402.getL40291());
						_l402.setL40292(l402.getL40292());
						_l402.setL40293(l402.getL40293());
						_l402.setL40294(l402.getL40294());
						_l402.setL40295(l402.getL40295());
						_l402.setL40296(l402.getL40296());
						_l402.setL40297(l402.getL40297());
						_l402.setL40298(l402.getL40298());
						_l402.setL40299(l402.getL40299());
						_l402.setL402100(l402.getL402100());
						_l402.setL402102(l402.getL402102());
						_l402.setL402103(l402.getL402103());
						_l402.setL402104(l402.getL402104());
						_l402.setL402126(l402.getL402126());
						_l402.setL402127(l402.getL402127());
						_l402.setL402128(l402.getL402128());
						_l402.setL402129(l402.getL402129());
						_l402.setL402130(l402.getL402130());
						_l402.setL402131(l402.getL402131());
						_l402.setL402132(l402.getL402132());
						_l402.setL402133(l402.getL402133());
						
						_l402.setL402162(l402.getL402162());
						_l402.setL402163(l402.getL402163());
						_l402.setL402164(l402.getL402164());
						_l402.setL402181(l402.getL402181());
						_l402.setL402182(l402.getL402182());
						_l402.setL402183(l402.getL402183());
						_l402.setL402184(l402.getL402184());
						_l402.setL402185(l402.getL402185());
						_l402.setL402186(l402.getL402186());
						_l402.setL402187(l402.getL402187());
						_l402.setL402188(l402.getL402188());
						

					}
					// 随访结果
				} else if ("4".equals(flag)) {

					if (_l402.getL402120() != null) {
						l402Response.setErrorMessage("不能重复登记");
						return l402Response;
					} else {
						_l402.setL402105(l402.getL402105());
						_l402.setL402106(l402.getL402106());
						_l402.setL402107(l402.getL402107());
						_l402.setL402108(l402.getL402108());
						_l402.setL402109(l402.getL402109());
						_l402.setL402110(l402.getL402110());
						_l402.setL402111(l402.getL402111());
						_l402.setL402112(l402.getL402112());
						_l402.setL402113(l402.getL402113());
						_l402.setL402114(l402.getL402114());
						_l402.setL402115(l402.getL402115());
						_l402.setL402116(l402.getL402116());
						_l402.setL402117(l402.getL402117());
						_l402.setL402118(l402.getL402118());
						_l402.setL402119(l402.getL402119());
						_l402.setL402120(l402.getL402120());
						_l402.setL402121(l402.getL402121());
						_l402.setL402122(l402.getL402122());
						_l402.setL402126(l402.getL402126());
						_l402.setL402127(l402.getL402127());
						_l402.setL402154(l402.getL402154());
						
						_l402.setL402171(l402.getL402171());
						_l402.setL402172(l402.getL402172());
						_l402.setL402173(l402.getL402173());
						_l402.setL402174(l402.getL402174());
						_l402.setL402175(l402.getL402175());
						_l402.setL402176(l402.getL402176());
					}
				} else if ("5".equals(flag)) {//初筛临床建议
					if (_l402.getL402165() != null) {
						l402Response.setErrorMessage("不能重复登记");
						return l402Response;
				}
					
					_l402.setL40283(l402.getL40283());
					_l402.setL402165(l402.getL402165());
					_l402.setL402166(l402.getL402166());
					_l402.setL402167(l402.getL402167());
					
				}else if ("6".equals(flag)) {//乳腺X线临床建议
					if (_l402.getL402168() != null) {
						l402Response.setErrorMessage("不能重复登记");
						return l402Response;
					}
					
					_l402.setL402101(l402.getL402101());
					_l402.setL402168(l402.getL402168());
					_l402.setL402169(l402.getL402169());
					_l402.setL402170(l402.getL402170());
					
				}else if ("99".equals(flag)) {
					
					_l402.setL402147(l402.getL402147());
					_l402.setL402148(l402.getL402148());
					_l402.setL402149(l402.getL402149());
					
				}
				
				L306Response picResponse = savePic(l402Request.getPicList(),
						flag, _l402);
				_l402 = setField(_l402, picResponse.isStatus(), flag);
				session.update(_l402);
				l402Response.setL402(_l402);
				l402Response = saveSuccess(l402Response);

				l402Response = this.setResponseMessage(l402Response,
						picResponse);

			} else if (!"0".equals(flag)) {
				l402Response.setErrorMessage("请先登记病史信息");
				return l402Response;
			} else {
				session.save(l402);
				l402Response.setL402(l402);
				l402Response = saveSuccess(l402Response);

				if (l402Response.isState()) {
					L301 l301 = (L301) session
							.get(L301.class, l402.getL40202());
					l301.setL30134("1");
					session.update(l301);
					session.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			l402Response.setErrorMessage(e.getMessage());
		}
		return l402Response;
	}

	private L402Response saveSuccess(L402Response l402Response) {
		l402Response.setState(true);
		l402Response.setPromptMessage("保存成功");
		return l402Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public L402Response queryByL402(String l40202) {
		L402Response l402Response = new L402Response();
		l402Response.setState(false);
		try {
			if (l40202 != null) {
				Session session = sessionFactory.getCurrentSession();
				List<L402> list = session.createSQLQuery(
						"select * from l402 t where t.l402_02=?").addEntity(
						L402.class).setParameter(0, l40202).list();
				if (list.size() < 1) {
					l402Response.setErrorMessage("不存在该对象");
					return l402Response;
				}
				L402 l402 = null;
				for (L402 _l402 : list) {
					l402 = _l402;
				}
				l402Response.setL402(l402);
				l402Response.setState(true);
				return l402Response;
			}
			l402Response.setErrorMessage("参数不正确");
		} catch (Exception e) {
			e.printStackTrace();
			l402Response.setErrorMessage("查询异常");
		}
		return l402Response;
	}

	/**
	 * 保存图片
	 * 
	 * @param picList
	 * @param flag
	 * @param l402
	 * @return
	 */
	private L306Response savePic(List<HashMap<String, Object>> picList,
			String flag, L402 l402) {
		L306Response picResponse = new L306Response();
		picResponse.setStatus(false);
		boolean resultFlag="2".equals(flag);
		if ( (resultFlag|| "3".equals(flag))&&picList!=null) {
			if (picList.size() > 0) {
				L306 l306=new L306();
				L306Request picRequest = new L306Request();
				l306.setL30604(flag);
				l306.setL30613(new Date());
				l306.setL30602(l402.getL40201());
				l306.setL30603(l402.getL40205());
				l306.setL30611(resultFlag ? l402.getL40284() : l402
						.getL402102());
				l306.setL30612(resultFlag ? l402.getL40285() : l402
						.getL402103());
				picRequest.setL306(l306);
				picRequest.setPicList(picList);
				String fileDirName = "2".equals(flag) ? "cs" : "xx";
				picRequest.setFlag("rxa" + File.separator + fileDirName);
				picResponse = l306Service.saveLaPic(picRequest);
			}
		}
		return picResponse;
	}

	/**
	 * 设置消息
	 * 
	 * @param l402Response
	 * @param picResponse
	 * @return
	 */
	private L402Response setResponseMessage(L402Response l402Response,
			L306Response picResponse) {
		StringBuffer message=new StringBuffer("");
		if (picResponse.isStatus()) {
			 message.append( picResponse.isStatus() ? ",图片保存成功" : picResponse
					.getErrorMessage());
		}
		if (l402Response.isState()) {
			l402Response.setPromptMessage("保存成功 " + message.toString());
		} else
			l402Response.setErrorMessage(l402Response.getErrorMessage()
					+ "/n" + message.toString());
		return l402Response;

	}

	/**
	 * 设置上传图片标识
	 * 
	 * @param l402
	 * @param picStatus
	 * @param flag
	 * @return
	 */
	private L402 setField(L402 l402, boolean picStatus, String flag) {
		boolean ccStatus="2".equals(flag);
		boolean xxStatus="3".equals(flag);
		if (picStatus) {
			if (ccStatus){
				l402.setL402150("1");
				l402.setL402152("2");				
			}
			else if (xxStatus){
				l402.setL402151("1");
				l402.setL402153("2");
			}
		}else{
			if (ccStatus){
				if(l402.getL402150()==null)
					l402.setL402150("2");
				if(l402.getL402152()!=null)
					l402.setL402152("2");				
			}
			else if (xxStatus){
				if(l402.getL402151()==null)
					l402.setL402151("2");
				if(l402.getL402153()==null)
					l402.setL402153("2");	
			}
		}

		return l402;
	}
}
