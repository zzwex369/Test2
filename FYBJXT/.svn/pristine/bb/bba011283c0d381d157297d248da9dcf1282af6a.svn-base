package com.xyw.sys.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;

public class DBF {
	private static List<Object> objectList = null;

	/**
	 * 创建DBF文件
	 * 
	 * @param objectList
	 *            数据对象
	 * @param fileName
	 *            文件名
	 * @param path
	 *            保存路径
	 * @return 创建状态<br/>
	 *         101：创建成功<br/>
	 *         102：创建失败
	 */
	public static String createDBF(List<Object> list, String fileName, String path) {
		objectList = list;
		OutputStream fos = null;
		List<Method> methodList = new ArrayList<Method>();
		String p = "";
		try {
		methodList = getMethods(objectList.get(0));
		// 设置数据库字段
		DBFField[] fields = new DBFField[methodList.size()];
		// 设置字段信息
		for (int i = 0; i < fields.length; i++) {
			fields[i] = new DBFField();
			Method method = methodList.get(i);
			// 获取字段名
			String name = method.getName();
			name = name.replaceAll("^get", "");
			name = name.replaceAll("$()", "");
			name = name.toUpperCase();
			// 设置字段名
			fields[i].setName(name);
			// 获取属性数据类型
			Class clazz = method.getReturnType();
			// d = date l = boolean n = 数字 c = string
			// 设置字段数据类型和字段长度
			if (clazz == Date.class) {
				fields[i].setDataType(DBFField.FIELD_TYPE_D);
			} else if (clazz == short.class || clazz == int.class || clazz == long.class || clazz == double.class
					|| clazz == float.class || clazz == Short.class || clazz == Integer.class || clazz == Long.class
					|| clazz == Double.class || clazz == Float.class) {
				fields[i].setDataType(DBFField.FIELD_TYPE_N);
				fields[i].setFieldLength(30);
				// 设置小数点位数
				// fields[i].setDecimalCount(2);
			} else if (clazz == Boolean.class) {
				fields[i].setDataType(DBFField.FIELD_TYPE_L);
				fields[i].setFieldLength(64);
			} else {
				fields[i].setDataType(DBFField.FIELD_TYPE_C);
				fields[i].setFieldLength(100);
			}
		}

			// 定义DBFWriter实例用来写DBF文件
			DBFWriter writer = new DBFWriter();
			// 把字段信息写入DBFWriter实例，即定义表结构
			writer.setFields(fields);
			p = DBF.class.getClassLoader().getResource("").getPath();
			//服务器中dbf文件保存的路径
			p = p.replaceAll("/WEB-INF/classes/" , "");
			//本地dbf文件保存的路径		p = p.replaceAll("/build/classes/" , "/WebContent");
			fos = new FileOutputStream(new File(p + path + fileName));
			writer.write(fos);
			writer = new DBFWriter(new File(p +path + fileName));

			// 写入数据
			Object[] rowData = new Object[methodList.size()];
			for (Object t : objectList) {
				for (int i = 0; i < methodList.size(); i++) {
					Method method = methodList.get(i);
					Object object = null;
					// 判断返回类型是不是基本类型
					Class type = method.getReturnType();
					if (type == int.class || type == short.class || type == long.class || type == double.class
							|| type == float.class) {
						// 如果该属性没有设置则默认为0
						object = Double.parseDouble(method.invoke(t).toString());
						rowData[i] = object;
					} else {
						object = method.invoke(t);
						rowData[i] = object;
					}
				}
				writer.addRecord(rowData);
			}
			// 写入数据
			writer.write();
//			new ZipCompressor(p+path+fileName).compress(fileName);
		} catch (

		Exception e) {
			e.printStackTrace();
			return "102";
		} finally {
			objectList = null;
			try {
				if (fos != null) {
					fos.close();
					fos = null;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "101";
	}

	

	/**
	 * 获取目标对象的所有无参数get方法
	 * 
	 * @param object
	 *            目标对象
	 * @return 方法数组
	 */
	private static List<Method> getMethods(Object object) {
		List<Method> methodList = new ArrayList<Method>();
		// 获取类对象
		Class clazz = object.getClass();
		// 获取该类的所有方法
		Method[] methods = clazz.getMethods();
		// 获取该类的所有无参数get方法，将所有无参数get方法存进methodList中
		for (Method method : methods) {
			Pattern pattern = Pattern.compile("^get.*$()");
			Matcher matcher = pattern.matcher(method.getName());
			boolean result = matcher.matches();
			if (result) {
				if (!method.getName().equals("getClass")) {
					methodList.add(method);
				}
			}
		}
		return methodList;
	} 
}
