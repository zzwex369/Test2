package com.xyw.client.fybj.upload.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.xyw.client.fybj.bean.IService;
import com.xyw.client.fybj.bean.ModelLiangBing;
import com.xyw.client.fybj.bean.ObjectFactory;
import com.xyw.client.fybj.bean.SResult;
import com.xyw.client.fybj.bean.Service;
import com.xyw.client.fybj.util.DictionaryConvert;
import com.xyw.medical.etbj.model.VE601;

public class RemoteInvokeTools_ve601 {
public SResult remoteInvokeE601(VE601 ve601) {
		
		ObjectFactory objFac=new ObjectFactory(); 
		ModelLiangBing mlb = new ModelLiangBing();
		DictionaryConvert dc = new DictionaryConvert();
		
		//E60108现居住地-详细地址(汉字字符串)
		JAXBElement<String> adDetail = objFac.createModelLiangBingADDetail(ve601.getE60108());
		mlb.setADDetail(adDetail);
		System.out.println("adDetail:      " + adDetail.getValue());
		
		//E60115出生日期
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		mlb.setBirthDate(to_date(ve601.getE60115()));
		System.out.println("birthDate:     " + ve601.getE60115());
		
		//E60118生产方式
//		JAXBElement<String> birthWay = objFac.createModelLiangBingBirthWay(dc.birthWayConvert(ve601.getE60118()));
//		mlb.setBirthWay(birthWay);
//		System.out.println("birthWay:      " + birthWay.getValue());
		
		//E60116出生时的体重
		JAXBElement<String> birthWeight = objFac.createModelLiangBingBirthWeight(String.valueOf(ve601.getE60116()));
		mlb.setBirthWeight(birthWeight);
		System.out.println("birthWeight:   " + birthWeight.getValue());
		
		//E60136血卡编号 若为两病或两病加多病必填 11位，以012开头
		JAXBElement<String> bloodCardCode = objFac.createModelLiangBingBloodCardCode(ve601.getE60136());
		mlb.setBloodCardCode(bloodCardCode);
		System.out.println("bloodCardCode: " + bloodCardCode.getValue());
		
		//E60123采血日期
//		mlb.setBloodDate(dateConvertToXMLGregorianCalendar(ve601.getE60123()));
//		System.out.println("bloodDate:     " + sdf.format(ve601.getE60123()));
		
		//E60137血卡编号 若为多病病或两病加多病必填 11位，以011开头
//		JAXBELEMENT<STRING> BLOODDCARDCODE = OBJFAC.CREATEMODELLIANGBINGBLOODDCARDCODE(VE601.GETE60137());
//		MLB.SETBLOODDCARDCODE(BLOODDCARDCODE);
//		SYSTEM.OUT.PRINTLN("BLOODDCARDCODE:" + BLOODDCARDCODE.GETVALUE());
		
		//E60107现居住地-市(编号)
		JAXBElement<String> cityCode = objFac.createModelLiangBingCityCode(ve601.getE60107().substring(0, 4));
		mlb.setCityCode(cityCode);
		System.out.println("cityCode:      " + cityCode.getValue());
		
		//E60107现居住地-县(编号)
		JAXBElement<String> countyCode = objFac.createModelLiangBingCountyCode(ve601.getE60107().substring(0, 6));
		mlb.setCountyCode(countyCode);
		System.out.println("countyCode:    " + countyCode.getValue());
		
		//E60122采血医院（汉字名称）
//		JAXBElement<String> hospitalName = objFac.createModelLiangBingHospitalName(ve601.getE60122Zh());
//		mlb.setHospitalName(hospitalName);
//		System.out.println("hospitalName:  " + hospitalName.getValue());
		
		//E60105母亲身份证号
//		JAXBElement<String> iDCardMother = objFac.createModelLiangBingIDCardMother(ve601.getE60105());
//		mlb.setIDCardMother(iDCardMother);
//		System.out.println("iDCardMother:  " + iDCardMother.getValue());
//		
		//E60120是否免费 1表示免费，0表示自费
//		mlb.setIsFree(Integer.parseInt(dc.isFreeConvert(ve601.getE60120())));
//		System.out.println("isFree:        " + Integer.parseInt(dc.isFreeConvert(ve601.getE60120())));
		
		//E60104母亲姓名
		JAXBElement<String> motherName = objFac.createModelLiangBingMotherName(ve601.getE60104());
		mlb.setMotherName(motherName);
		System.out.println("motherName:    " + motherName.getValue());
		
		//E60140民族
		JAXBElement<String> nation = objFac.createModelLiangBingNation(dc.nationConvert(ve601.getE60140()));
		mlb.setNation(nation);
		System.out.println("nation:        " + nation.getValue());
		
		//E60106联系手机
		JAXBElement<String> phone = objFac.createModelLiangBingPhone(ve601.getE60106());
		mlb.setPhone(phone);
		System.out.println("phone:         " + phone.getValue());
		
		//E60107现居住地-省(编号)
		JAXBElement<String> provinceCode = objFac.createModelLiangBingProvinceCode(ve601.getE60107().substring(0,2));
		mlb.setProvinceCode(provinceCode);
		System.out.println("provinceCode:  " + provinceCode.getValue());
		
		//E60114婴儿性别
		JAXBElement<String> sex = objFac.createModelLiangBingSex(dc.sexConvert(ve601.getE60114()));
		mlb.setSex(sex);
		System.out.println("sex:           " + sex.getValue());
		
		//E60107现居住地-乡(编号)
		JAXBElement<String> townshipCode = objFac.createModelLiangBingTownshipCode(ve601.getE60107().substring(0, 9));
		mlb.setTownshipCode(townshipCode);
		System.out.println("townshipCode:  " + townshipCode.getValue());
		
		//E60103标本类型
		JAXBElement<String> type = objFac.createModelLiangBingType(ve601.getE60103());
		mlb.setType(type);
		System.out.println("type:          " + type.getValue());
		
		//E601_11产次
//		mlb.setChanCi(ve601.getE60111().intValue());
		System.out.println("chanCi:        " + ve601.getE60111());
		
		//E601_10胎数
//		mlb.setTaiShu(dc.taiShuConvert(ve601.getE60110()).intValue());
//		System.out.println("taiShu:        " + ve601.getE60110());
		
		Service service = new Service();
		IService iService = service.getBasicHttpBindingIService();
		String str = iService.test();
		System.out.println("测试服务的方法Test()==>" + str);
		
		String str01 = "0W2LHd9BZ4A5zVvMT0XU2abBi3c5Ejvebij4SVMoxKZxaHqmU8PvA0Zf+DQtGS5T1IxGoguwkeA=";
		SResult sResult = iService.pushLiangBing(str01, mlb);
		
		System.out.println("对接密钥SecretKey:   " + str01);
		System.out.println("执行结果Result:      " + sResult.isResult());
		System.out.println("返回信息Info:        " + sResult.getInfo().getValue());
//		System.out.println("返回数据Data:        " + sResult.getData().getValue());//正式使用的时候会报错，必须注释掉
		
		return sResult;
	}

	// 将字符串类型转换为XMLGregorianCalendar类型
	private XMLGregorianCalendar to_date(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateConvertToXMLGregorianCalendar(date);
	}

	private XMLGregorianCalendar dateConvertToXMLGregorianCalendar(Date date) {
		if (date == null)
			return null;
		try {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
					.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			return xmlGregorianCalendar;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
