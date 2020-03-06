package com.xyw.medical.fnbj.fnlapic.dao.impl;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fnlapic.dao.L306Dao;
import com.xyw.medical.fnbj.model.L302;
import com.xyw.medical.fnbj.model.L306;
import com.xyw.medical.fnbj.model.L306Request;
import com.xyw.medical.fnbj.model.L306Response;
import com.xyw.medical.fnbj.model.L402;
import com.xyw.medical.fnbj.model.VL306;
import com.xyw.sys.util.FileOperation;
import com.xyw.sys.util.StringUtil;

public class L306DaoImpl implements L306Dao {
	@Resource
	private SessionFactory sessionFactory;
	private String[][] fieldAllArr = { { "137", "138" }, { "150", "152" },
			{ "151", "153" } };

	@Override
	public L306Response saveLaPic(L306Request l306Request) {
		boolean status = true;
		StringBuilder errorMessage = new StringBuilder();
		L306 l306 = l306Request.getL306();
		L306Response l306Response = new L306Response();
		Session session = sessionFactory.getCurrentSession();
		// 本地
//		StringBuffer path = new StringBuffer("E:" + File.separator
//				+ "cs_csyxzmweb" + File.separator + "FYBJ_la_picture"
//				+ File.separator);
		// 正式
		 StringBuffer path = new StringBuffer(File.separator + "cs_csyxzmweb"
		 + File.separator + "FYBJ_la_picture" + File.separator);
		List<HashMap<String, Object>> picList = l306Request.getPicList();
		path.append(l306Request.getFlag() + File.separator + l306.getL30602());
		String picPath = path.toString();
		int count = 5;// 计数器
		boolean countStatus = true;//
		for (HashMap<String, Object> map : picList) {
			String picName = map.get("name").toString();
			String position = map.get("position").toString();
			if (!StringUtil.isBlankString(position)) {
				if ("2".equals(position) && countStatus) {
					count = 8;
					countStatus = false;
				}
			}
			try {
				/**
				 * setFieldVal(l306, Integer.toString(count), String.class,
				 * picPath + File.separator + picName, "setL306");
				 */
				FileOperation.uploadPic(picPath, (byte[]) map.get("data"),
						picName);
				setFieldVal(l306, String.class, "setL306",
						new String[] { Integer.toString(count) },
						new String[] { picPath + File.separator + picName });
			} catch (Exception e) {
				status = false;
				errorMessage.append("图片保存至服务器中失败！\n" + e.getMessage());
				e.printStackTrace();
				break;
			}
			++count;
		}
		if (status) {
			l306.setL30641("2");
			l306.setL30642("2");
			session.save(l306);
			session.flush();
			session.clear();
		}
		l306Response.setStatus(status);
		l306Response.setErrorMessage(errorMessage.toString());
		return l306Response;
	}

	@Override
	public L306Response saveLaZk(L306Request l306Request) {
		boolean status = true;
		L306 l306 = l306Request.getL306();
		String message = null;
		L306Response l306Response = new L306Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			String l30641 = (String) session.createSQLQuery(
					"select l306_41 from l306 where l306_01='"
							+ l306.getL30601() + "'").uniqueResult();
			if (StringUtil.isBlankString(l30641) || "2".equals(l30641)) {// 第一次保存
																			// 质控信息
				setParentTableField(l306.getL30604(), l306.getL30602(),
						session, new String[] { null, "1" });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status) {
			try {
				if (l306Request.isDelStatus() && "2".equals(l306.getL30641()))// 清空字段																// 有图片情况下
				{
					// 设置父表字段未质控
					setParentTableField(l306.getL30604(), l306.getL30602(),
							session, new String[] { null, "2" });
				}
				session.saveOrUpdate(l306);
				l306Response.setMessage(l306Request.getFlag());
			} catch (Exception e) {
				status = false;
				e.printStackTrace();
				l306Response.setErrorMessage("发生错误!请联系客服 " + e.getMessage());
			}
		}
		l306Response.setStatus(status);
		l306Response.setErrorMessage(message);
		return l306Response;
	}

	@Override
	public L306Response delLaZk(L306Request l306Request) {
		boolean status = true;
		L306 l306 = l306Request.getL306();
		String message = null;
		L306Response l306Response = new L306Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			String l30602 = (String) session.createSQLQuery(
					"select l306_02 from l306 where l306_01='"
							+ l306.getL30601() + "'").uniqueResult();
			if (StringUtil.isBlankString(l30602)) {
				status = false;
				message = "不存在这条记录！,无法保存";
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
			message = "发生错误!请联系客服 " + e.getMessage();
		}
		if (status) {
			try {
				// 设置父表字段未质控
				setParentTableField(l306.getL30604(), l306.getL30602(),
						session, new String[] { null, "2" });
				session.delete(l306);
				l306Response.setMessage(l306Request.getFlag());
			} catch (Exception e) {
				status = false;
				e.printStackTrace();
				l306Response.setErrorMessage("发生错误!请联系客服 " + e.getMessage());
			}
		}
		l306Response.setStatus(status);
		l306Response.setErrorMessage(message);
		return l306Response;
	}

	/**
	 * 批量删除图片
	 */
	@SuppressWarnings("unchecked")
	@Override
	public L306Response delAllByParentId(L306Request l306Request) {
		Object[] params = null;
		boolean status = false;
		boolean delStatus = false;
		L306 l306 = l306Request.getL306();
		String parentId = l306.getL30602();
		String picType = l306.getL30604();
		StringBuilder errorMessage = new StringBuilder();
		Session session = sessionFactory.getCurrentSession();
		String[] gurd = { "select ", "l306_05", ",l306_08",
				",l306_06,l306_07,l306_09,l306_10", "delete" };
		L306Response l306Response = new L306Response();
		try {

			StringBuffer sql = new StringBuffer(" from l306 where l306_02='"
					+ parentId + "'");
			params = (Object[]) session.createSQLQuery(
					gurd[0] + gurd[1] + gurd[2] + gurd[3] + sql.toString())
					.uniqueResult();
			if (params != null) {
				int count = 0;// 批量上传文件计数器
				for (Object path : params) {
					if (path != null)
						delStatus = FileOperation.deleteFile(path.toString());
					if (delStatus)
						++count;
					if (params.length == count) {// 删除完了才会删除目录
						String sqlPrefix = "1".equals(picType) ? gurd[1]
								: gurd[1] + gurd[2];
						params = (Object[]) session.createSQLQuery(
								gurd[0] + sqlPrefix + sql.toString()
										+ "group by " + gurd[1] + gurd[2])
								.uniqueResult();
					}
				}
				if (params.length > 0) {
					for (Object fileObj : params) {
						String file = fileObj.toString();
						file = file.substring(0, file
								.lastIndexOf(File.separator));
						FileOperation.deleteDirectory(file, false);
					}
					session.createSQLQuery(gurd[4] + sql.toString())
							.executeUpdate();
					setParentTableField(picType, parentId, session,
							new String[] { "2", null });
					status = true;
				} else
					errorMessage.append("图片删不成功，请联系客服！");
			} else
				errorMessage.append("该图片信息不存在，请联系客服！");
		} catch (Exception e) {
			errorMessage.append("图片数据删除失败！\n" + e.getMessage());
		}
		l306Response.setStatus(status);
		l306Response.setErrorMessage(errorMessage.toString());
		return l306Response;
	}

	/**
	 * 单个图片删除 图片删除完会删除目录 ，可以删除代表未质控
	 */
	@Override
	public L306Response delByPicName(L306Request l306Request) {
		String resultPicPath = null;
		boolean status = false;
		L306 l306 = l306Request.getL306();
		String picPath = l306Request.getPicPath();
		String field = "l306_" + l306Request.getSuffix();
		String id = l306.getL30601();
		String picType = l306.getL30604();
		StringBuilder errorMessage = new StringBuilder();
		Session session = sessionFactory.getCurrentSession();
		L306Response l306Response = new L306Response();
		try {
			String suffixSql = "where " + field + "='" + picPath
					+ "' and l306_01='" + id + "'";
			StringBuffer sql = new StringBuffer("select " + field
					+ " from l306 ");
			sql.append(suffixSql);
			resultPicPath = (String) session.createSQLQuery(sql.toString())
					.uniqueResult();
			if (resultPicPath != null) {
				boolean delStatus = FileOperation.deleteFile(resultPicPath);
				if (delStatus) {
					resultPicPath = resultPicPath.substring(0, resultPicPath
							.lastIndexOf(File.separator));
					FileOperation.deleteDirectory(resultPicPath.toString(),
							false);
					session.createSQLQuery(
							"update l306 set " + field + "='' " + suffixSql)
							.executeUpdate();
					suffixSql = " from l306 where l306_01='" + id + "'";
					String queryField = "1".equals(picType) ? ""
							: ",l306_09,l306_10";
					Object[] fieldVal = (Object[]) session.createSQLQuery(
							"select l306_02,l306_05,l306_06,l306_07,l306_08"
									+ queryField + suffixSql).uniqueResult();
					int count = 1;// 空字段计数器
					for (Object val : fieldVal) {
						if (val == null)
							++count;
					}
					if (count == fieldVal.length) {
						session.createSQLQuery("delete" + suffixSql)
								.executeUpdate();
						setParentTableField(picType, fieldVal[0].toString(),
								session, new String[] { "2", null });
					}
					status = true;
				} else
					errorMessage.append("图片删不成功，请联系客服！");
			} else
				errorMessage.append("该图片信息不存在，请联系客服！");
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
			errorMessage.append("图片数据删除失败！\n" + e.getMessage());
		}
		l306Response.setStatus(status);
		l306Response.setErrorMessage(errorMessage.toString());
		return l306Response;
	}

	@Override
	public L306Response downPic(L306Request l306Request) {
		boolean status = false;
		String picPath = l306Request.getPicPath();
		L306Response l306Response = new L306Response();
		l306Response.setFlag(l306Request.getFlag());
		l306Response.setSuffix(l306Request.getSuffix());
		l306Response.setPicNum(l306Request.getPicNum());
		l306Response.setPicPath(l306Request.getPicPath());
		l306Response.setDelStatus(l306Request.isDelStatus());
		l306Response.setL30601(l306Request.getL306().getL30601());
		StringBuilder errorMessage = new StringBuilder();
		byte[] data = null;
		FileImageInputStream input = null;
		ByteArrayOutputStream output = null;
		try {
			if (picPath != null) {
				input = new FileImageInputStream(new File(picPath));
				output = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int numBytesRead = 0;
				while ((numBytesRead = input.read(buf)) != -1) {
					output.write(buf, 0, numBytesRead);
				}
				data = output.toByteArray();
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage.append("下载图片失败！" + e.getMessage());
		} finally {
			try {
				if (input != null)
					input.close();
				if (output != null)
					output.close();
			} catch (IOException e) {
				status = false;
				e.printStackTrace();
				errorMessage.append("关闭流失败！" + e.getMessage());
			}
		}
		l306Response.setImageByte(data);
		l306Response.setStatus(status);
		l306Response.setErrorMessage(errorMessage.toString());
		return l306Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public L306Response queryL306(L306Request l306Request) {
		L306 l306 = l306Request.getL306();
		Date l30613 = l306.getL30613();
		String l30602 = l306.getL30602();
		String l30604 = l306.getL30604();
		String l30611 = l306.getL30611();
		String l30641 = l306.getL30641();
		String l30642 = l306.getL30642();
		String flag = l306Request.getFlag();// sql 语句
		L306Response l306Response = new L306Response();
		int pageIndex = l306Request.getParameterPageindex();
		int pageSize = l306Request.getParameterPagesize();
		StringBuffer parameterConditionwhere = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (!StringUtil.isBlankString(l30602)) {
			parameterConditionwhere.append("and l306_02 ='" + l30602 + "' ");
		}

		if (!StringUtil.isBlankString(l30604)) {
			l306Response.setFlag(l30604);
			parameterConditionwhere.append("and l306_04 ='" + l30604 + "' ");
		}

		if (!StringUtil.isBlankString(l30641)) {
			parameterConditionwhere.append("and l306_41 ='" + l30641 + "' ");
		}

		if (!StringUtil.isBlankString(l30642)) {
			parameterConditionwhere.append("and l306_42 ='" + l30642 + "' ");
		}

		if (l30613 != null) {
			String date = sdf.format(l30613);
			parameterConditionwhere
					.append("and to_char(l306_13,'yyyy-mm-dd') >='" + date
							+ "' ");
			parameterConditionwhere
					.append("and to_char(l306_13,'yyyy-mm-dd') <='" + date
							+ "' ");
		}

		if (!StringUtil.isBlankString(l30611)) {
			if (l30611.length() == 14) {
				parameterConditionwhere.append(" and  l306_11  = '");
				parameterConditionwhere.append(l30611);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and  l306_11 like '");
				parameterConditionwhere.append(l30611);
				parameterConditionwhere.append("%'");
			}
		}

		if (!StringUtil.isBlankString(flag)) {// 修改时候用 动态sql
			parameterConditionwhere.append(flag);
		}

		boolean state = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from v_l306 where 1=1 "
					+ parameterConditionwhere).uniqueResult();
			List<VL306> vl306s = (List<VL306>) session.createSQLQuery(
					"select * from v_l306 where 1=1 "
							+ parameterConditionwhere.append(
									"order by l306_13,l306_01").toString())
					.addEntity(VL306.class).setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();
			l306Response.setRowCount(vl306s.size());
			l306Response.setVl306s(vl306s);
		} catch (Exception e) {
			state = false;
			e.printStackTrace();
			l306Response.setErrorMessage(e.getMessage());
		}
		l306Response.setStatus(state);
		return l306Response;
	}

	/**
	 * 设置父表字段 是否上传图片标志
	 * 
	 * @param picType
	 * @param parentId
	 * @param session
	 * 
	 */
	private void setParentTableField(String picType, String parentId,
			Session session, String[] fieldValArr) {
		try {
			int idx = Integer.valueOf(picType) - 1;
			if ("1".equals(picType)) {
				L302 l302 = (L302) session.get(L302.class, parentId);
				setFieldVal(l302, String.class, "setL302", fieldAllArr[idx],
						fieldValArr);
			} else {
				L402 l402 = (L402) session.get(L402.class, parentId);
				setFieldVal(l402, String.class, "setL402", fieldAllArr[idx],
						fieldValArr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 反射设置字段属性值
	 * 
	 * @param l306
	 *            对象
	 * @param suffix
	 *            方法后缀
	 * @param fieldType
	 *            字段类型
	 * @param val
	 *            字段值
	 *@param field
	 *            set字段前缀
	 * 
	 * @throws Exception
	 */
	private void setFieldVal(Object obj, Class fieldType, String field,
			String[] fieldArr, String[] fieldValArr) throws Exception {
		for (int i = 0; i < fieldArr.length; i++) {
			if (fieldValArr[i] != null) {
				String suffix = fieldArr[i];
				suffix = suffix.length() > 1 ? suffix : 0 + suffix;
				Method method = obj.getClass().getDeclaredMethod(
						field + suffix, fieldType);
				method.invoke(obj, fieldValArr[i]);

			}
		}
	}

	/**
	 * 反射得到字段属性值
	 * 
	 * @param l306
	 * @param suffix
	 * @throws Exception
	 */
	private String[] getFieldVal(VL306 vl306, String suffix) throws Exception {
		suffix = suffix.length() > 1 ? suffix : 0 + suffix;
		PropertyDescriptor pd = new PropertyDescriptor("getL306" + suffix,
				vl306.getClass());
		Method method = pd.getReadMethod();
		String path = method.invoke(vl306).toString();
		String[] params = new String[3];// 1 路径 2字段后缀 3左右
		params[0] = path;
		params[1] = suffix;
		return params;
	}

	/**
	 * 批量下载图片二进制
	 * 
	 * @param input
	 * @param output
	 * @param vl306
	 * @return
	 */
	private List<HashMap<String, Object>> downPics(FileImageInputStream input,
			ByteArrayOutputStream output, VL306 vl306) throws Exception {
		ArrayList<HashMap<String, Object>> listPic = new ArrayList<HashMap<String, Object>>();
		String l30604 = vl306.getL30104();
		int picNum = "1".equals(l30604) ? 9 : 11;
		for (int i = 5; i < picNum; i++) {

			String field = Integer.toString(i);
			String[] params = getFieldVal(vl306, field);
			if (!StringUtil.isBlankString(params[0])) {
				byte[] data = null;
				input = new FileImageInputStream(new File(params[0]));
				output = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int numBytesRead = 0;
				while ((numBytesRead = input.read(buf)) != -1) {
					output.write(buf, 0, numBytesRead);
				}
				data = output.toByteArray();
				String position = (!"1".equals(l30604) && i < 8) ? "1" : "2";
				HashMap<String, Object> picMap = new HashMap<String, Object>();
				picMap.put("data", data);
				picMap.put("field", "l306" + params[1]);
				picMap.put("position", position);
				listPic.add(picMap);
			}

		}
		return listPic;
	}

}
