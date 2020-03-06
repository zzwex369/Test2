package com.xyw.statistical.echarts.fnbj.pie.common.dao;

import com.xyw.statistical.echarts.fnbj.model.EchartsDataResponse;


public interface StatisticalDataDao {
	EchartsDataResponse getPieData(String sql);

}
