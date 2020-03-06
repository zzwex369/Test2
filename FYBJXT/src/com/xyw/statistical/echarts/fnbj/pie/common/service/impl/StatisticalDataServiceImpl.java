package com.xyw.statistical.echarts.fnbj.pie.common.service.impl;

import javax.annotation.Resource;

import com.xyw.statistical.echarts.fnbj.model.EchartsDataResponse;
import com.xyw.statistical.echarts.fnbj.pie.common.dao.StatisticalDataDao;
import com.xyw.statistical.echarts.fnbj.pie.common.service.StatisticalDataService;

public class StatisticalDataServiceImpl implements StatisticalDataService{
	
	@Resource
	private StatisticalDataDao statisticalDataDao;
	
	@Override
	public EchartsDataResponse getPieData(String sql) {
		return statisticalDataDao.getPieData(sql);
	}

	
}
