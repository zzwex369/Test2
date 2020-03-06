package com.xyw.medical.fnbj.servlet.entity;

/*
 * 统计概率的分子和分母
 * 
 * */
public class ZaoYun {
	//1.辖区内孕12周之前建册的人数 
	//2.辖区内按照规范要求在孕期接受5次及以上产前随访服务的人数 
	//3.辖区内产后28天内的接受过产后访视的产妇人数
	//4.年度辖区内接受1次及以上访视的新生儿人数 
	//5.年度辖区内接受1次及以上随访的0-6岁儿童数 
	//6.年度内辖区中按照相应频次要求管理的0-6岁儿童数
	private long num1;
	//1.该地该时间段内活产数
	//2.该地该时间段内活产数
	//3.该地该时间段内活产数
	//4.年度辖区内活产数
	//5.年度辖区内应管理的0-6岁儿童数
	//6.年度辖区内应管理的0-6岁儿童数
	private long num2;
	
	public ZaoYun() {
		super();
	}
	public ZaoYun(long num1, long num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	public long getNum1() {
		return num1;
	}
	public void setNum1(long num1) {
		this.num1 = num1;
	}
	public long getNum2() {
		return num2;
	}
	public void setNum2(long num2) {
		this.num2 = num2;
	}
}
