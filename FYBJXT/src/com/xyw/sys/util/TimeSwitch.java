package com.xyw.sys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/***
 * 
 * @author Joe 各种日期转换方法
 */
public class TimeSwitch {
	/**
	 * 
	 * @param saveTime
	 *            保存时间
	 * @return 现在时间与保存时间差 (天数)
	 */
	public static Long distanceDay(Date _saveTime) {
		long saveTime = _saveTime.getTime();// 录入时间
		long nowTime = System.currentTimeMillis();// 当前系统毫秒数
		long distanceDay = (nowTime - saveTime) / (24 * 3600 * 1000);// 相差时间
		return distanceDay;
	}

	/**
	 * 得到俩个日期的月份差
	 * @param startDate  开始时间
	 * @param endDate	 结束时间
	 * @return
	 */
	public static int getMonthSpace(Date startDate,Date endDate) {
		String format="yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
        DateTime start = formatter.parseDateTime(sdf.format(startDate));
        DateTime end = formatter.parseDateTime(sdf.format(endDate));
        int months = Months.monthsBetween(start, end).getMonths();
        return months >= 0 ? months : Math.abs(months);
	}

}
