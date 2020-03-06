package com.xyw.medical.yljggl.dao.impl;

import java.io.FileOutputStream;
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

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.yljggl.dao.MedicalDao;
import com.xyw.medical.yljggl.model.D101Request;
import com.xyw.medical.yljggl.model.D101Response;
import com.xyw.medical.yljggl.model.VD101;
import com.xyw.sys.model.D101;
import com.xyw.sys.util.StringUtil;

public class MedicalDaoImpl implements MedicalDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;
	
	private StringBuffer sql;
	
	@Override
	public D101Response save(D101Request d101Request) {
		D101Response d101Response = new D101Response();
		
		D101 d101 = new D101();
		d101 = d101Request.getD101();
		
		String d10102 = d101.getD10102();
		String d10103 = d101.getD10103();
		String d10104 = d101.getD10104();
		String d10105 = d101.getD10105();
		String d10106 = d101.getD10106();
		String d10107 = d101.getD10107();
		String d10108 = d101.getD10108();
		String d10109 = d101.getD10109();
		String d10110 = d101.getD10110();
		String d10111 = d101.getD10111();
		
		if (StringUtil.isBlankString(d10102)){
			d101Response.setErrorMessage("机构名称不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10103)) {
			d101Response.setErrorMessage("拼音码不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10104)) {
			d101Response.setErrorMessage("所属地区不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10105)) {
			d101Response.setErrorMessage("机构类别不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10106)) {
			d101Response.setErrorMessage("机构级别不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10107)) {
			d101Response.setErrorMessage("通讯地址不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10108)) {
			d101Response.setErrorMessage("邮政编码不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10109)) {
			d101Response.setErrorMessage("电话号码不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10110)) {
			d101Response.setErrorMessage("签发机构类型不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10111)) {
			d101Response.setErrorMessage("上级单位不能为空！");
			return d101Response;
		}
		
		String sqlA = "SELECT COUNT(*) FROM D101 T WHERE T.D101_02 = ?";
		String sqlB = "SELECT COUNT(*) FROM D201 T WHERE T.D201_01 = ?";

		Session session = this.sessionFactory.getCurrentSession();
		
		SQLQuery sqlQuery = session.createSQLQuery(sqlA);
		sqlQuery.setString(0, d10102);
		Object obj = sqlQuery.uniqueResult();
		int result = Integer.valueOf((obj.toString()));
		if(result > 0) {
			d101Response.setErrorMessage("该机构名称已经存在!");
			return d101Response;
		}
		
		sqlQuery = session.createSQLQuery(sqlB);
		sqlQuery.setString(0, d10104);
		Object objB = sqlQuery.uniqueResult();
		int resultB = Integer.valueOf((objB.toString()));
		if(resultB == 0) {
			d101Response.setErrorMessage("所属地区编码不存在!");
			return d101Response;
		}
		
		try{
			d101.setD10101("0");
			String resultS = (String)session.save(d101);
			if(resultS != null) {
				d101Response.setPromptMessage("保存成功！");
			} else {
				d101Response.setErrorMessage("保存失败！");
			}
		}catch(Exception e){
			d101Response.setErrorMessage("保存失败！");
		}
		return d101Response;
	}

	@Override
	public D101Response find(D101Request d101Request) {
		D101 d101 = d101Request.getD101();
		String d10104_text = d101.getD10104();
		String d10106_text = d101.getD10106();
		
		int parameterPageindex = d101Request.getPageIndex();
		int parameterPagesize = d101Request.getPageSize();

		if(parameterPageindex == 0) {
			parameterPageindex = 1;
		}
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		parameterConditionwhere.append(" and t.d101_04 like '" + d10104_text + "%'");
		
		if(!StringUtil.isBlankString(d10106_text))
		{
			parameterConditionwhere.append(" and t.d101_06 = '" + d10106_text + "'");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		D101Response d101Response = new D101Response();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D101");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D101_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d101Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD101 vd101 = null;
			List<VD101> vd101s = new ArrayList<VD101>();
			while (resultSet.next()) {

				String d10101 = resultSet.getString("D101_01");
				String d10102 = resultSet.getString("D101_02");
				String d10103 = resultSet.getString("D101_03");
				String d10105 = resultSet.getString("D101_05");
				String d10105Zh = resultSet.getString("D101_05_ZH");
				String d10106 = resultSet.getString("D101_06");
				String d10106Zh = resultSet.getString("D101_06_ZH");
				String d10107 = resultSet.getString("D101_07");
				String d10108 = resultSet.getString("D101_08");
				String d10109 = resultSet.getString("D101_09");
				String d10110 = resultSet.getString("D101_10");
				String d10110Zh = resultSet.getString("D101_10_ZH");
				//String d10111 = resultSet.getString("D101_11");
				Date d10140 = resultSet.getDate("D101_40");
				
				vd101 = new VD101();

				vd101.setD10101(d10101);
				vd101.setD10102(d10102);
				vd101.setD10103(d10103);
				vd101.setD10105(d10105);
				vd101.setD10105Zh(d10105Zh);
				vd101.setD10106(d10106);
				vd101.setD10106Zh(d10106Zh);
				vd101.setD10107(d10107);
				vd101.setD10108(d10108);
				vd101.setD10109(d10109);
				vd101.setD10110(d10110);
				vd101.setD10110Zh(d10110Zh);
				//vd101.setD10111(d10110);
				vd101.setD10140(d10140);
				
				vd101s.add(vd101);
			}
			d101Response.setVd101s(vd101s);
		} catch (Exception e) {
			d101Response.setErrorMessage("查询失败!");
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

			}
		}
		return d101Response;
	}

	@Override
	public D101Response findById(D101Request d101Request) {
		D101Response d101Response = new D101Response();
		
		String id = d101Request.getD101().getD10101();
		this.sql = new StringBuffer("from D101 t where 0=0");
		if(!StringUtil.isBlankString(id)){
			this.sql.append("and t.d10101 = '");
			this.sql.append(id);
			this.sql.append("'");
		}
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(this.sql.toString());
			D101 d101 = (D101)query.uniqueResult();
			
			d101Response.setD101(d101);
		}catch(Exception e){
			d101Response.setErrorMessage("查询失败");
		}
		return d101Response;
	}

	@Override
	public D101Response update(D101Request d101Request) {
		D101Response d101Response = new D101Response();
		
		D101 d101 = d101Request.getD101();
		
		String d10101 = d101.getD10101();
		
		String d10102 = d101.getD10102();
		String d10103 = d101.getD10103();
		String d10105 = d101.getD10105();
		String d10106 = d101.getD10106();
		String d10107 = d101.getD10107();
		String d10108 = d101.getD10108();
		String d10109 = d101.getD10109();
		String d10110 = d101.getD10110();
		Date d10140 = d101.getD10140();
		
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd");
		String d10140_str = dateFormat.format(d10140);
		
		if (StringUtil.isBlankString(d10102)) {
			d101Response.setErrorMessage("机构名称不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10105)) {
			d101Response.setErrorMessage("机构类别不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10106)) {
			d101Response.setErrorMessage("机构级别不能为空！");
			return d101Response;
		}
		if (StringUtil.isBlankString(d10110)) {
			d101Response.setErrorMessage("签发机构类型不能为空！");
			return d101Response;
		}
		
		//String sqlA = "SELECT COUNT(*) FROM D101 T WHERE T.D101_02 = ?";
		this.sql = new StringBuffer("FROM D101 t WHERE 0=0 ");
		if(!StringUtil.isBlankString(d10102)){
			this.sql.append("and t.d10102 = '");
			this.sql.append(d10102);
			this.sql.append("'");
		}
		if(!StringUtil.isBlankString(d10103)){
			this.sql.append("and t.d10103 = '");
			this.sql.append(d10103);
			this.sql.append("'");
		}
		if(!StringUtil.isBlankString(d10105)){
			this.sql.append("and t.d10105 = '");
			this.sql.append(d10105);
			this.sql.append("'");
		}
		if(!StringUtil.isBlankString(d10106)){
			this.sql.append("and t.d10106 = '");
			this.sql.append(d10106);
			this.sql.append("'");
		}
		if(!StringUtil.isBlankString(d10107)){
			this.sql.append("and t.d10107 = '");
			this.sql.append(d10107);
			this.sql.append("'");
		}
		if(!StringUtil.isBlankString(d10108)){
			this.sql.append("and t.d10108 = '");
			this.sql.append(d10108);
			this.sql.append("'");
		}
		if(!StringUtil.isBlankString(d10109)){
			this.sql.append("and t.d10109 = '");
			this.sql.append(d10109);
			this.sql.append("'");
		}
		if(!StringUtil.isBlankString(d10110)){
			this.sql.append("and t.d10110 = '");
			this.sql.append(d10110);
			this.sql.append("'");
		}
		if(!StringUtil.isBlankString(d10140_str)){
			this.sql.append("and t.d10140 = to_date('");
			this.sql.append(d10140_str);
			this.sql.append("','yyyy-mm-dd')");
		}

		Session session = this.sessionFactory.getCurrentSession();
		
		try{
			Query query = session.createQuery(this.sql.toString());
			d101 = (D101)query.uniqueResult();
			if(d101 != null){
				d101Response.setErrorMessage("该机构名称已经存在!");
				return d101Response;
			}
		}catch(Exception e){
			e.printStackTrace();
			d101Response.setErrorMessage("查询失败！");
		}
//		SQLQuery sqlQuery = session.createSQLQuery(sqlA);
//		sqlQuery.setString(0, d10102);
//		Object obj = sqlQuery.uniqueResult();
//		int result = Integer.valueOf((obj.toString()));
//		if(result > 0) {
//			d101Response.setErrorMessage("该机构名称已经存在!");
//			return d101Response;
//		}
		
		String strSql = "update D101 t set t.d101_02 = ?, t.d101_03 = ?, t.d101_05 = ?, t.d101_06 = ?," +
				"t.d101_07 = ?, t.d101_08 = ?, t.d101_09 = ?, t.d101_10 = ?, t.d101_40 = ? where t.d101_01 = ?";
		
		SQLQuery sQLQuery = session.createSQLQuery(strSql);
		
		sQLQuery.setString(0, d10102);
		sQLQuery.setString(1, d10103);
		sQLQuery.setString(2, d10105);
		sQLQuery.setString(3, d10106);
		sQLQuery.setString(4, d10107);
		sQLQuery.setString(5, d10108);
		sQLQuery.setString(6, d10109);
		sQLQuery.setString(7, d10110);
		sQLQuery.setDate(8, d10140);
		sQLQuery.setString(9, d10101);
		
		int results = sQLQuery.executeUpdate();
		if(results > 0){
			d101Response.setPromptMessage("修改成功!");
		}else{
			d101Response.setErrorMessage("修改失败!");
		}
		return d101Response;
	}

	@Override
	public D101Response delete(D101Request d101Request) {
		D101Response d101Response = new D101Response();
		D101 d101 = d101Request.getD101();
		String d10101 = d101.getD10101();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			d101 = (D101) session.get(D101.class, d10101);
			session.delete(d101);
			d101Response.setPromptMessage("删除成功!");
		}catch(Exception e){
			d101Response.setErrorMessage("删除失败!");
	}
	return d101Response;
	}

	@Override
	@SuppressWarnings("unchecked")
	public D101Response exportExcelData(D101Request d101Request) {
		D101Response d101Response = new D101Response();
	
		String d10104 = d101Request.getD101().getD10104();
		String d10106 = d101Request.getD101().getD10106();
		
		this.sql = new StringBuffer("from D101 t where 0=0");
		
		if(!StringUtil.isBlankString(d10104)){
			this.sql.append("and t.d10104 = '");
			this.sql.append(d10104);
			this.sql.append("'");
		}
		
		if(!StringUtil.isBlankString(d10106)){
			this.sql.append("and d10106 = '");
			this.sql.append(d10106);
			this.sql.append("'");
		}
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(this.sql.toString());
			List<D101> list = query.list();
			createExcel(list);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return d101Response;
	}
	
	public void createExcel(List<D101> list){
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("D101");
		Row row = null;
		for(int i = 0; i < list.size(); i++ ){
			row = sheet.createRow(i + 1);
			D101 d101 = list.get(i);
			row.createCell(0).setCellValue(d101.getD10101());
			row.createCell(1).setCellValue(d101.getD10102());
			row.createCell(2).setCellValue(d101.getD10105());
			row.createCell(3).setCellValue(d101.getD10106());
			row.createCell(4).setCellValue(d101.getD10107());
			row.createCell(5).setCellValue(d101.getD10108());
			row.createCell(6).setCellValue(d101.getD10109());
			row.createCell(7).setCellValue(d101.getD10110());
			row.createCell(8).setCellValue(d101.getD10140());
		}
		try{
			FileOutputStream fos = new FileOutputStream("医疗机构表.xls");
			wb.write(fos);
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
