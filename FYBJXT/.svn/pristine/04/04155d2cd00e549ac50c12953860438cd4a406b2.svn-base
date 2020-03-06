package com.xyw.client.fybj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hibernate.Session;

import com.xyw.client.fybj.bean.IService;
import com.xyw.client.fybj.bean.ModelLiangBing;
import com.xyw.client.fybj.bean.ObjectFactory;
import com.xyw.client.fybj.bean.SResult;
import com.xyw.client.fybj.bean.Service;
import com.xyw.medical.etbj.model.E601;


public class RemoteInvokeTools {
	
	public SResult remoteInvokeE601(E601 e601,Session session) {
		
		ObjectFactory objFac=new ObjectFactory(); 
		ModelLiangBing mlb = new ModelLiangBing();
		DictionaryConvert dc = new DictionaryConvert();
		
		//E60108现居住地-详细地址(汉字字符串)
		JAXBElement<String> adDetail = objFac.createModelLiangBingADDetail(e601.getE60108());
		mlb.setADDetail(adDetail);
//		System.out.println("adDetail:      " + adDetail.getValue());
		
		//E60115出生日期
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//		mlb.setBirthDate(dateConvertToXMLGregorianCalendar(e601.getE60115()));
//		System.out.println("birthDate:     " + sdf.format(e601.getE60115()));
		
		//E60118生产方式
//		JAXBElement<String> birthWay = objFac.createModelLiangBingBirthWay(dc.birthWayConvert(e601.getE60118()));
//		mlb.setBirthWay(birthWay);
//		System.out.println("birthWay:      " + birthWay.getValue());
		
		//E60116出生时的体重
		JAXBElement<String> birthWeight = objFac.createModelLiangBingBirthWeight(String.valueOf(e601.getE60116()));
		mlb.setBirthWeight(birthWeight);
//		System.out.println("birthWeight:   " + birthWeight.getValue());
		
		//E60136血卡编号 若为两病或两病加多病必填 11位，以012开头
		JAXBElement<String> bloodCardCode = objFac.createModelLiangBingBloodCardCode(e601.getE60136());
		mlb.setBloodCardCode(bloodCardCode);
//		System.out.println("bloodCardCode: " + bloodCardCode.getValue());
		
		//E60123采血日期
//		mlb.setBloodDate(dateConvertToXMLGregorianCalendar(e601.getE60123()));
//		System.out.println("bloodDate:     " + sdf.format(e601.getE60123()));
		
		//E60137血卡编号 若为多病病或两病加多病必填 11位，以011开头
//		JAXBElement<String> bloodDCardCode = objFac.createModelLiangBingBloodDCardCode(e601.getE60137());
//		mlb.setBloodDCardCode(bloodDCardCode);
//		System.out.println("bloodDCardCode:" + bloodDCardCode.getValue());
		
		//E60107现居住地-市(编号)
		JAXBElement<String> cityCode = objFac.createModelLiangBingCityCode(e601.getE60107().substring(0, 4));
		mlb.setCityCode(cityCode);
//		System.out.println("cityCode:      " + cityCode.getValue());
		
		//E60107现居住地-县(编号)
		JAXBElement<String> countyCode = objFac.createModelLiangBingCountyCode(e601.getE60107().substring(0, 6));
		mlb.setCountyCode(countyCode);
//		System.out.println("countyCode:    " + countyCode.getValue());
		
		//E60122采血医院（汉字名称）
		JAXBElement<String> hospitalName = objFac.createModelLiangBingHospitalName(dc.hospitalNameConvert(e601.getE60122(),session));
		mlb.setHospitalName(hospitalName);
//		System.out.println("hospitalName:  " + hospitalName.getValue());
		
		//E60105母亲身份证号
//		JAXBElement<String> iDCardMother = objFac.createModelLiangBingIDCardMother(e601.getE60105());
//		mlb.setIDCardMother(iDCardMother);
//		System.out.println("iDCardMother:  " + iDCardMother.getValue());
		
		//E60120是否免费 1表示免费，0表示自费
//		mlb.setIsFree(Integer.parseInt(dc.isFreeConvert(e601.getE60120())));
//		System.out.println("isFree:        " + Integer.parseInt(e601.getE60120()));
		
		//E60104母亲姓名
		JAXBElement<String> motherName = objFac.createModelLiangBingMotherName(e601.getE60104());
		mlb.setMotherName(motherName);
//		System.out.println("motherName:    " + motherName.getValue());
		
		//E60140民族
		JAXBElement<String> nation = objFac.createModelLiangBingNation(dc.nationConvert(e601.getE60140()));
		mlb.setNation(nation);
//		System.out.println("nation:        " + nation.getValue());
		
		//E60106联系手机
		JAXBElement<String> phone = objFac.createModelLiangBingPhone(e601.getE60106());
		mlb.setPhone(phone);
//		System.out.println("phone:         " + phone.getValue());
		
		//E60107现居住地-省(编号)
		JAXBElement<String> provinceCode = objFac.createModelLiangBingProvinceCode(e601.getE60107().substring(0,2));
		mlb.setProvinceCode(provinceCode);
//		System.out.println("provinceCode:  " + provinceCode.getValue());
		
		//E60114婴儿性别
		JAXBElement<String> sex = objFac.createModelLiangBingSex(dc.sexConvert(e601.getE60114()));
		mlb.setSex(sex);
//		System.out.println("sex:           " + sex.getValue());
		
		//E60107现居住地-乡(编号)
		JAXBElement<String> townshipCode = objFac.createModelLiangBingTownshipCode(e601.getE60107().substring(0, 9));
		mlb.setTownshipCode(townshipCode);
//		System.out.println("townshipCode:  " + townshipCode.getValue());
		
		//E60103标本类型
		JAXBElement<String> type = objFac.createModelLiangBingType(e601.getE60103());
		mlb.setType(type);
//		System.out.println("type:          " + type.getValue());
		
		//E601_11产次
//		mlb.setChanCi(e601.getE60111().intValue());
//		System.out.println("chanCi:        " + e601.getE60111());
		
		//E601_10胎数
//		mlb.setTaiShu(dc.taiShuConvert(e601.getE60110()).intValue());
//		System.out.println("taiShu:        " + e601.getE60110());
		
		Service service = new Service();
		IService iService = service.getBasicHttpBindingIService();
		String str = iService.test();
//		System.out.println("测试服务的方法Test()==>" + str);
		
		String str01 = "0W2LHd9BZ4A5zVvMT0XU2abBi3c5Ejvebij4SVMoxKZxaHqmU8PvA0Zf+DQtGS5T1IxGoguwkeA=";
		SResult sResult = iService.pushLiangBing(str01, mlb);
		
//		System.out.println("对接密钥SecretKey:   " + str01);
//		System.out.println("执行结果Result:      " + sResult.isResult());
//		System.out.println("返回信息Info:        " + sResult.getInfo().getValue());
//		System.out.println("返回数据Data:        " + sResult.getData().getValue());//正式使用的时候会报错，必须注释掉
		
		return sResult;
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
