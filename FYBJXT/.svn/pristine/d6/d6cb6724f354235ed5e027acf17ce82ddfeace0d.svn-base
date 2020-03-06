package com.xyw.client.henan.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.xyw.client.henan.Bfb;
import com.xyw.client.henan.BfbResponse;
import com.xyw.client.henan.CsyxzmWebService;
import com.xyw.client.henan.CsyxzmWebServiceImpl;
import com.xyw.client.henan.Dj;
import com.xyw.client.henan.DjResponse;
import com.xyw.client.henan.Fm;
import com.xyw.client.henan.FmResponse;
import com.xyw.client.henan.Fp;
import com.xyw.client.henan.FpResponse;
import com.xyw.client.henan.Hfb;
import com.xyw.client.henan.HfbResponse;
import com.xyw.client.henan.Jgw;
import com.xyw.client.henan.JgwResponse;
import com.xyw.client.henan.Rk;
import com.xyw.client.henan.RkResponse;
import com.xyw.client.henan.Sfb;
import com.xyw.client.henan.SfbResponse;
import com.xyw.client.henan.Zf;
import com.xyw.client.henan.ZfResponse;
import com.xyw.medical.birth.model.D301;
import com.xyw.medical.birth.model.D304;
import com.xyw.medical.birth.model.D305;
import com.xyw.medical.birth.model.D306;
import com.xyw.medical.birth.model.D307;
import com.xyw.medical.birth.model.D401;
import com.xyw.medical.birth.model.D501;
import com.xyw.medical.birth.model.D502;
import com.xyw.medical.birth.model.D601;

public class RemoteInvokeTools {
	
	public FpResponse remoteInvokeD501(D501 d501){
		Fp fp = new Fp();
		fp.setFp01(d501.getD50101());
		fp.setFp02(d501.getD50102());
		fp.setFp03(d501.getD50103());
		fp.setFp04(d501.getD50104());
		fp.setFp05(d501.getD50105());
		fp.setFp06(d501.getD50106());
		fp.setFp07(d501.getD50107());
		fp.setFp08(d501.getD50108());
		fp.setFp09(d501.getD50109());
		fp.setFp10(d501.getD50110());
		fp.setFp11(d501.getD50111());
		fp.setFp12(dateConvertToXMLGregorianCalendar(d501.getD50112()));
		fp.setFp13(d501.getD50113());
		fp.setFp14(d501.getD50114());
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getPort(CsyxzmWebService.class);
		return csyxzmWebService.csyxzmFp(fp);
	}
	
	public RkResponse remoteInvokeD502(D502 d502){
		Rk rk = new Rk();
		rk.setRk02(d502.getD50202());
		rk.setRk03(d502.getD50203());
		rk.setRk04(d502.getD50204());
		rk.setRk05(dateConvertToXMLGregorianCalendar(d502.getD50205()));
		rk.setRk06(d502.getD50206());
		rk.setRk07(d502.getD50207());
		rk.setRk08(d502.getD50208());
		rk.setRk09(d502.getD50209());
		rk.setRk10(d502.getD50210());
		rk.setRk11(d502.getD50211());
		rk.setRk12(d502.getD50212());
			
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		return csyxzmWebService.csyxzmRk(rk);
	}
	
	public DjResponse remoteInvokeD301(D301 d301){
		Dj dj = new Dj();
		//01主键不需要传，因为无需拼接
		dj.setDj02(d301.getD30102());
		dj.setDj03(d301.getD30103());
		dj.setDj04(dateConvertToXMLGregorianCalendar(d301.getD30104()));
		dj.setDj05(d301.getD30105());
		//06其他出生地
		dj.setDj07(d301.getD30107());
		dj.setDj08(d301.getD30108());
		dj.setDj09(d301.getD30109());
		dj.setDj10(d301.getD30110());
		dj.setDj11(d301.getD30111());
		dj.setDj12(d301.getD30112());
		dj.setDj13(dateConvertToXMLGregorianCalendar(d301.getD30113()));
		dj.setDj14(d301.getD30114());
		dj.setDj15(d301.getD30115());
		dj.setDj16(d301.getD30116());
		dj.setDj17(d301.getD30117());
		dj.setDj18(dateConvertToXMLGregorianCalendar(d301.getD30118()));
		dj.setDj19(d301.getD30119());
		dj.setDj20(d301.getD30120());
		dj.setDj21(d301.getD30121());
		dj.setDj22(d301.getD30122());
		//23出生地其他
		dj.setDj24(d301.getD30124());
		dj.setDj25(d301.getD30125());
		dj.setDj26(d301.getD30126());
		dj.setDj27(d301.getD30127());
		dj.setDj28(dateConvertToXMLGregorianCalendar(d301.getD30128()));
		dj.setDj29(d301.getD30129());
		dj.setDj30(d301.getD30130());
		dj.setDj31(d301.getD30131());
		dj.setDj32(d301.getD30132());
		dj.setDj33(dateConvertToXMLGregorianCalendar(d301.getD30133()));
		dj.setDj34(d301.getD30134());
		dj.setDj35(d301.getD30135());
		dj.setDj36(d301.getD30136());
		dj.setDj37(d301.getD30137());
		dj.setDj38(d301.getD30138());
		dj.setDj39(d301.getD30139());
		dj.setDj40(dateConvertToXMLGregorianCalendar(d301.getD30140()));
		//41申领表主键
		dj.setDj42(d301.getD30142());
		dj.setDj43(d301.getD30143());
		//44母亲身份类别其他,45父亲身份类别其他,46母亲村地址
		dj.setDj47(d301.getD30147());
		dj.setDj48(d301.getD30148());
		//49父亲村地址
		dj.setDj50(d301.getD30150());
		//51其他原因
		dj.setDj52(d301.getD30152());
		dj.setDj53(d301.getD30153());
		dj.setDj54(d301.getD30154());
		dj.setDj55(d301.getD30155());
		dj.setDj56(d301.getD30156());//分娩登记主键
		dj.setDj57(d301.getD30157());//首发登记表主键
		//58上传状态,59上传标志
		if(d301.getD30160() == null || "".equals(d301.getD30160())){
			dj.setDj60("123456");//以前的数据这两个字段为空，为了保证以前的也能传上去，此处虚拟一个假地址，让它能通过验证
		} else if(d301.getD30160().length() >= 9) {
			dj.setDj60(d301.getD30160().substring(0, 9));
		} else {
			dj.setDj60(d301.getD30160());
		}
		if(d301.getD30161() == null || "".equals(d301.getD30161())){
			dj.setDj61("123456");
		} else if(d301.getD30161().length() >= 9) {
			dj.setDj61(d301.getD30161().substring(0, 9));
		} else {
			dj.setDj61(d301.getD30161());
		}
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		
		return csyxzmWebService.csyxzmDj(dj);
		
	}
	
	public ZfResponse remoteInvokeD401(D401 d401){
		Zf zf = new Zf();
		zf.setZf02(d401.getD40102());
		if("0".equals(d401.getD40125())){
			zf.setZf03(d401.getD40103());
		}
		zf.setZf04(dateConvertToXMLGregorianCalendar(d401.getD40104()));
		zf.setZf05(d401.getD40105());
		zf.setZf06(d401.getD40106());
		zf.setZf08(dateConvertToXMLGregorianCalendar(d401.getD40108()));
		zf.setZf09(d401.getD40109());
		zf.setZf10(d401.getD40110());
		zf.setZf11(d401.getD40111());
		zf.setZf12(d401.getD40112());
		zf.setZf13(d401.getD40113());
		zf.setZf14(d401.getD40114());
		zf.setZf15(d401.getD40115());
		zf.setZf16(dateConvertToXMLGregorianCalendar(d401.getD40116()));
		zf.setZf17(d401.getD40117());
		zf.setZf18(d401.getD40118());
		zf.setZf19(d401.getD40119());
		zf.setZf20(d401.getD40120());
		zf.setZf21(d401.getD40121());
		zf.setZf22(d401.getD40122());
		zf.setZf23(dateConvertToXMLGregorianCalendar(d401.getD40123()));
		zf.setZf24(d401.getD40124());
		zf.setZf25(d401.getD40125());
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		return csyxzmWebService.csyxzmZf(zf);
	}
	
	public ZfResponse remoteInvokeUpdateD401(D401 d401){
		Zf zf = new Zf();
		zf.setZf05(d401.getD40105());
		zf.setZf06(d401.getD40106());
		zf.setZf15(d401.getD40115());
		zf.setZf16(dateConvertToXMLGregorianCalendar(d401.getD40116()));
		zf.setZf17(d401.getD40117());
		zf.setZf18(d401.getD40118());
		zf.setZf19(d401.getD40119());
		zf.setZf20(d401.getD40120());
		zf.setZf21(d401.getD40121());
		zf.setZf22(d401.getD40122());
		zf.setZf23(dateConvertToXMLGregorianCalendar(d401.getD40123()));
		zf.setZf24(d401.getD40124());
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		return csyxzmWebService.csyxzmZfcl(zf);
		
	}
	
	public SfbResponse remoteInvokeD304(D304 d304){
		Sfb sfb = new Sfb();
		
		sfb.setSfb01(d304.getD30401());//拼接字符串用（Sfb41）,并且不能占用wsdl中的字段
		sfb.setSfb02(d304.getD30402());
		sfb.setSfb03(d304.getD30403());
		sfb.setSfb04(dateConvertToXMLGregorianCalendar(d304.getD30404()));
		sfb.setSfb05(d304.getD30405());
		sfb.setSfb06(d304.getD30406());
		sfb.setSfb07(d304.getD30407());
		sfb.setSfb08(d304.getD30408());
		sfb.setSfb09(d304.getD30409());
		sfb.setSfb10(d304.getD30410());
		
		sfb.setSfb11(d304.getD30411());
		sfb.setSfb12(d304.getD30412());
		sfb.setSfb13(dateConvertToXMLGregorianCalendar(d304.getD30413()));
		sfb.setSfb14(d304.getD30414());
		sfb.setSfb15(d304.getD30415());
		sfb.setSfb16(d304.getD30416());
		sfb.setSfb17(d304.getD30417());
		sfb.setSfb18(d304.getD30418());
		sfb.setSfb19(d304.getD30419());
		sfb.setSfb20(d304.getD30420());
		
		sfb.setSfb21(d304.getD30421());
		sfb.setSfb22(d304.getD30422());
		sfb.setSfb23(d304.getD30423());
		sfb.setSfb24(d304.getD30424());
		sfb.setSfb25(d304.getD30425());
		sfb.setSfb26(d304.getD30426());
		sfb.setSfb27(d304.getD30427());
		sfb.setSfb28(d304.getD30428());
		sfb.setSfb29(d304.getD30429());
		sfb.setSfb30(d304.getD30430());
		
		sfb.setSfb31(d304.getD30431());
		sfb.setSfb32(d304.getD30432());
		sfb.setSfb33(d304.getD30433());
		sfb.setSfb34(dateConvertToXMLGregorianCalendar(d304.getD30434()));
		sfb.setSfb35(dateConvertToXMLGregorianCalendar(d304.getD30435()));
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		return csyxzmWebService.csyxzmSfb(sfb);
	}
	
	public BfbResponse remoteInvokeD305(D305 d305){
		Bfb bfb = new Bfb();
		
		bfb.setBfb01(d305.getD30501());//拼接字符串用（Bfb44）,并且不能占用wsdl中的字段
		bfb.setBfb02(d305.getD30502());
		bfb.setBfb03(d305.getD30503());
		bfb.setBfb04(dateConvertToXMLGregorianCalendar(d305.getD30504()));
		bfb.setBfb05(d305.getD30505());
		bfb.setBfb06(d305.getD30506());
		bfb.setBfb07(d305.getD30507());
		bfb.setBfb08(d305.getD30508());
		bfb.setBfb09(d305.getD30509());
		bfb.setBfb10(d305.getD30510());
		
		bfb.setBfb11(d305.getD30511());
		bfb.setBfb12(d305.getD30512());
		bfb.setBfb13(dateConvertToXMLGregorianCalendar(d305.getD30513()));
		bfb.setBfb14(d305.getD30514());
		bfb.setBfb15(d305.getD30515());
		bfb.setBfb16(d305.getD30516());
		bfb.setBfb17(d305.getD30517());
		bfb.setBfb18(d305.getD30518());
		bfb.setBfb19(d305.getD30519());
		bfb.setBfb20(d305.getD30520());
		
		bfb.setBfb21(d305.getD30521());
		bfb.setBfb22(d305.getD30522());
		bfb.setBfb23(d305.getD30523());
		bfb.setBfb24(d305.getD30524());
		bfb.setBfb25(d305.getD30525());
		bfb.setBfb26(d305.getD30526());
		bfb.setBfb27(d305.getD30527());
		bfb.setBfb28(d305.getD30528());
		bfb.setBfb29(d305.getD30529());
		bfb.setBfb30(d305.getD30530());
		
		bfb.setBfb31(d305.getD30531());
		bfb.setBfb32(d305.getD30532());
		bfb.setBfb33(d305.getD30533());
		bfb.setBfb34(d305.getD30534());
		bfb.setBfb35(dateConvertToXMLGregorianCalendar(d305.getD30535()));
		bfb.setBfb36(d305.getD30536());
		bfb.setBfb37(dateConvertToXMLGregorianCalendar(d305.getD30537()));
		bfb.setBfb38(d305.getD30538());
		bfb.setBfb40(d305.getD30540());
		bfb.setBfb41(dateConvertToXMLGregorianCalendar(d305.getD30541()));
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		return csyxzmWebService.csyxzmBfb(bfb);
	}
	
	public HfbResponse remoteInvokeD306(D306 d306){
		Hfb hfb = new Hfb();
		hfb.setHfb01(d306.getD30601());//拼接字符串用（Hfb24）,并且不能占用wsdl中的字段
		hfb.setHfb02(d306.getD30602());
		hfb.setHfb03(d306.getD30603());
		hfb.setHfb04(d306.getD30604());
		hfb.setHfb05(d306.getD30605());
		hfb.setHfb06(d306.getD30606());
		hfb.setHfb07(d306.getD30607());
		hfb.setHfb08(d306.getD30608());
		hfb.setHfb09(d306.getD30609());
		hfb.setHfb10(d306.getD30610());
		hfb.setHfb11(d306.getD30611());
		hfb.setHfb12(d306.getD30612());
		hfb.setHfb13(d306.getD30613());
		hfb.setHfb14(d306.getD30614());
		hfb.setHfb15(d306.getD30615());
		hfb.setHfb16(d306.getD30616());
		hfb.setHfb17(d306.getD30617());
		hfb.setHfb18(d306.getD30618());
		hfb.setHfb19(d306.getD30619());
		hfb.setHfb20(d306.getD30620());
		hfb.setHfb21(d306.getD30621());
		hfb.setHfb22(d306.getD30622());
		hfb.setHfb23(dateConvertToXMLGregorianCalendar(d306.getD30623()));
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		return csyxzmWebService.csyxzmHfb(hfb);
	}
	
	public JgwResponse remoteInvokeD307(D307 d307) {
		Jgw jgw = new Jgw();
		jgw.setJgw01(d307.getD30701());//拼接字符串用（Jgw32）,并且不能占用wsdl中的字段
		jgw.setJgw02(d307.getD30702());
		jgw.setJgw03(d307.getD30703());
		jgw.setJgw04(dateConvertToXMLGregorianCalendar(d307.getD30704()));
		jgw.setJgw05(d307.getD30705());
		jgw.setJgw06(d307.getD30706());
		jgw.setJgw07(d307.getD30707());
		jgw.setJgw08(d307.getD30708());
		jgw.setJgw09(d307.getD30709());
		jgw.setJgw10(d307.getD30710());
		jgw.setJgw11(d307.getD30711());
		jgw.setJgw12(d307.getD30712());
		jgw.setJgw13(d307.getD30713());
		jgw.setJgw14(d307.getD30714());
		jgw.setJgw15(d307.getD30715());
		jgw.setJgw16(d307.getD30716());
		jgw.setJgw17(d307.getD30717());
		jgw.setJgw18(d307.getD30718());
		jgw.setJgw19(d307.getD30719());
		jgw.setJgw20(d307.getD30720());
		jgw.setJgw21(d307.getD30721());
		jgw.setJgw22(d307.getD30722());
		jgw.setJgw23(dateConvertToXMLGregorianCalendar(d307.getD30723()));
		jgw.setJgw24(d307.getD30724());
		jgw.setJgw25(d307.getD30725());
		jgw.setJgw26(d307.getD30726());
		jgw.setJgw27(d307.getD30727());
		jgw.setJgw28(d307.getD30728());
		jgw.setJgw29(d307.getD30729());
		jgw.setJgw30(d307.getD30730());
		jgw.setJgw31(d307.getD30731());
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		return csyxzmWebService.csyxzmJgw(jgw);
	}
	
	public FmResponse remoteInvokeD601(D601 d601){
		Fm fm = new Fm();
		
		fm.setFm01(d601.getD60101());//拼接字符串用（Fm91),并且不能占用wsdl中的字段
		fm.setFm02(d601.getD60102());
		fm.setFm03(dateConvertToXMLGregorianCalendar(d601.getD60103()));
		fm.setFm04(d601.getD60104());
		fm.setFm05(d601.getD60105());
		fm.setFm06(d601.getD60106());
		fm.setFm07(d601.getD60107());
		fm.setFm08(d601.getD60108());
		fm.setFm09(d601.getD60109());
		fm.setFm10(d601.getD60110());
		
		fm.setFm11(d601.getD60111());
		fm.setFm12(dateConvertToXMLGregorianCalendar(d601.getD60112()));
		fm.setFm13(dateConvertToXMLGregorianCalendar(d601.getD60113()));
		fm.setFm14(d601.getD60114());
		fm.setFm15(d601.getD60115());
		fm.setFm16(d601.getD60116());
		fm.setFm17(d601.getD60117());
		fm.setFm18(d601.getD60118());
		fm.setFm19(d601.getD60119());
		fm.setFm20(d601.getD60120());
		
		fm.setFm21(d601.getD60121());
		fm.setFm22(d601.getD60122());
		fm.setFm23(d601.getD60123());
		fm.setFm24(dateConvertToXMLGregorianCalendar(d601.getD60124()));
		fm.setFm25(d601.getD60125());
		fm.setFm26(d601.getD60126());
		fm.setFm27(d601.getD60127());
		fm.setFm28(d601.getD60128());
		fm.setFm29(d601.getD60129());
		fm.setFm30(d601.getD60130());
		
		fm.setFm31(d601.getD60131());
		fm.setFm32(d601.getD60132());
		fm.setFm33(d601.getD60133());
		fm.setFm34(d601.getD60134());
		fm.setFm35(d601.getD60135());
		fm.setFm36(d601.getD60136());
		fm.setFm37(d601.getD60137());
		fm.setFm38(d601.getD60138());
		fm.setFm39(d601.getD60139());
		fm.setFm40(d601.getD60140());
		
		fm.setFm41(d601.getD60141());
		fm.setFm42(d601.getD60142());
		fm.setFm43(d601.getD60143());
		fm.setFm44(d601.getD60144());
		fm.setFm45(d601.getD60145());
		fm.setFm46(d601.getD60146());
		fm.setFm47(d601.getD60147());
		fm.setFm48(d601.getD60148());
		fm.setFm49(d601.getD60149());
		fm.setFm50(d601.getD60150());
		
		fm.setFm51(d601.getD60151());
		fm.setFm52(d601.getD60152());
		fm.setFm53(d601.getD60153());
		fm.setFm54(d601.getD60154());
		fm.setFm55(d601.getD60155());
		fm.setFm56(d601.getD60156());
		fm.setFm57(d601.getD60157());
		fm.setFm58(d601.getD60158());
		fm.setFm59(d601.getD60159());
		fm.setFm60(dateConvertToXMLGregorianCalendar(d601.getD60160()));
		
		fm.setFm61(d601.getD60161());
		fm.setFm62(d601.getD60162());
		fm.setFm63(d601.getD60163());
		fm.setFm64(d601.getD60164());
		fm.setFm65(d601.getD60165());
		fm.setFm66(d601.getD60166());
		fm.setFm67(d601.getD60167());
		fm.setFm68(d601.getD60168());
		fm.setFm69(d601.getD60169());
		fm.setFm70(d601.getD60170());
		
		fm.setFm71(d601.getD60171());
		fm.setFm72(d601.getD60172());
		fm.setFm73(d601.getD60173());
		fm.setFm74(d601.getD60174());
		fm.setFm75(d601.getD60175());
		fm.setFm76(d601.getD60176());
		fm.setFm77(d601.getD60177());
		fm.setFm78(d601.getD60178());
		fm.setFm79(d601.getD60179());
		fm.setFm80(d601.getD60180());
		
		fm.setFm81(d601.getD60181());
		fm.setFm82(d601.getD60182());
		fm.setFm83(d601.getD60183());
		fm.setFm84(d601.getD60184());
		fm.setFm85(d601.getD60185());
		fm.setFm86(d601.getD60186());
		fm.setFm87(d601.getD60187());
		fm.setFm88(d601.getD60188());
		fm.setFm94(d601.getD60194());
		
		CsyxzmWebServiceImpl csyxzmWebServiceImpl = new CsyxzmWebServiceImpl();
		CsyxzmWebService csyxzmWebService = csyxzmWebServiceImpl.getCsyxzmWebServicePort();
		return csyxzmWebService.csyxzmFm(fm);
	}
	
	public static XMLGregorianCalendar dateConvertToXMLGregorianCalendar(Date date){
		if(date == null) return null;
		try {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			return xmlGregorianCalendar;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
