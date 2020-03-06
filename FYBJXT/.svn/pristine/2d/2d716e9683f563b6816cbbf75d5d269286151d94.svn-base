package com.xyw.statistical.echarts.fnbj.pie.common.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.statistical.echarts.fnbj.model.EchartsDataResponse;
import com.xyw.statistical.echarts.fnbj.pie.common.dao.StatisticalDataDao;

public class StatisticalDataDaoImpl implements StatisticalDataDao{
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@Override
	public EchartsDataResponse getPieData(String sql) {
		EchartsDataResponse response=new EchartsDataResponse();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			SQLQuery sqlQuery=session.createSQLQuery(sql);
			List<Object[]> list = (List<Object[]>) sqlQuery.list();
			Iterator<Object[]> iterator = list.iterator();
			List<Integer> echartsDataList = new ArrayList<Integer>();
			while (iterator.hasNext()) {
				Object[] objects = iterator.next();
				for(int i=0;i<objects.length;i++){
					echartsDataList.add(Integer.parseInt(objects[i].toString()));
				}
			}
			response.setEchartsDataList(echartsDataList);
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
			state = false;
		}
		response.setState(state);
		return response;
	}

	
}
