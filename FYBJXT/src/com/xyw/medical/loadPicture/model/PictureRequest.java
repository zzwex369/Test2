package com.xyw.medical.loadPicture.model;

import java.util.Date;
import java.util.List;

public class PictureRequest {
	private long pic01;
	private String pic02;
	private String pic03;
	private String pic04;
	private Date pic05;
	private String pic06;
	private String pic07;
	private String pic08;
	private String pic09;
	private String pic10;
	private String pic11;
	private String pic12;
	private String pic13;
	private String pic14;
	private String pic15;
	private String pic16;
	private String pic17;
	private String pic18;
	private Date timeStr;
	private Date timeEnd;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	private List<Object []> picArrays;
	public PictureRequest(long pic01, String pic02, String pic03, String pic04,
			Date pic05, String pic06, String pic07, String pic08, String pic09,
			String pic10, String pic11, String pic12, String pic13,
			String pic14, String pic15, String pic16, String pic17,
			String pic18, Date timeStr, Date timeEnd, int parameterPageindex,
			int parameterPagesize, String flag) {
		super();
		this.pic01 = pic01;
		this.pic02 = pic02;
		this.pic03 = pic03;
		this.pic04 = pic04;
		this.pic05 = pic05;
		this.pic06 = pic06;
		this.pic07 = pic07;
		this.pic08 = pic08;
		this.pic09 = pic09;
		this.pic10 = pic10;
		this.pic11 = pic11;
		this.pic12 = pic12;
		this.pic13 = pic13;
		this.pic14 = pic14;
		this.pic15 = pic15;
		this.pic16 = pic16;
		this.pic17 = pic17;
		this.pic18 = pic18;
		this.timeStr = timeStr;
		this.timeEnd = timeEnd;
		this.parameterPageindex = parameterPageindex;
		this.parameterPagesize = parameterPagesize;
		this.flag = flag;
	}
	
	public List<Object[]> getPicArrays() {
		return picArrays;
	}

	public void setPicArrays(List<Object[]> picArrays) {
		this.picArrays = picArrays;
	}

	public long getPic01() {
		return pic01;
	}
	public void setPic01(long pic01) {
		this.pic01 = pic01;
	}
	
	public String getPic02() {
		return pic02;
	}
	public void setPic02(String pic02) {
		this.pic02 = pic02;
	}
	public String getPic03() {
		return pic03;
	}
	public void setPic03(String pic03) {
		this.pic03 = pic03;
	}
	public String getPic04() {
		return pic04;
	}
	public void setPic04(String pic04) {
		this.pic04 = pic04;
	}
	public Date getPic05() {
		return pic05;
	}
	public void setPic05(Date pic05) {
		this.pic05 = pic05;
	}
	public String getPic06() {
		return pic06;
	}
	public void setPic06(String pic06) {
		this.pic06 = pic06;
	}
	public String getPic07() {
		return pic07;
	}
	public void setPic07(String pic07) {
		this.pic07 = pic07;
	}
	public String getPic08() {
		return pic08;
	}
	public void setPic08(String pic08) {
		this.pic08 = pic08;
	}
	public String getPic09() {
		return pic09;
	}
	public void setPic09(String pic09) {
		this.pic09 = pic09;
	}
	public String getPic10() {
		return pic10;
	}
	public void setPic10(String pic10) {
		this.pic10 = pic10;
	}
	public String getPic11() {
		return pic11;
	}
	public void setPic11(String pic11) {
		this.pic11 = pic11;
	}
	public String getPic12() {
		return pic12;
	}
	public void setPic12(String pic12) {
		this.pic12 = pic12;
	}
	public String getPic13() {
		return pic13;
	}
	public void setPic13(String pic13) {
		this.pic13 = pic13;
	}
	public String getPic14() {
		return pic14;
	}
	public void setPic14(String pic14) {
		this.pic14 = pic14;
	}
	public String getPic15() {
		return pic15;
	}
	public void setPic15(String pic15) {
		this.pic15 = pic15;
	}
	public String getPic16() {
		return pic16;
	}
	public void setPic16(String pic16) {
		this.pic16 = pic16;
	}
	public String getPic17() {
		return pic17;
	}
	public void setPic17(String pic17) {
		this.pic17 = pic17;
	}
	public String getPic18() {
		return pic18;
	}
	public void setPic18(String pic18) {
		this.pic18 = pic18;
	}
	public Date getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(Date timeStr) {
		this.timeStr = timeStr;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public int getParameterPageindex() {
		return parameterPageindex;
	}
	public void setParameterPageindex(int parameterPageindex) {
		this.parameterPageindex = parameterPageindex;
	}
	public int getParameterPagesize() {
		return parameterPagesize;
	}
	public void setParameterPagesize(int parameterPagesize) {
		this.parameterPagesize = parameterPagesize;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "pictureRequest [flag=" + flag + ", parameterPageindex="
				+ parameterPageindex + ", parameterPagesize="
				+ parameterPagesize + ", pic01=" + pic01 + ", pic02=" + pic02
				+ ", pic03=" + pic03 + ", pic04=" + pic04 + ", pic05=" + pic05
				+ ", pic06=" + pic06 + ", pic07=" + pic07 + ", pic08=" + pic08
				+ ", pic09=" + pic09 + ", pic10=" + pic10 + ", pic11=" + pic11
				+ ", pic12=" + pic12 + ", pic13=" + pic13 + ", pic14=" + pic14
				+ ", pic15=" + pic15 + ", pic16=" + pic16 + ", pic17=" + pic17
				+ ", pic18=" + pic18 + ", timeEnd=" + timeEnd + ", timeStr="
				+ timeStr + "]";
	}
	public PictureRequest() {
	}

}
