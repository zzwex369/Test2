package com.xyw.client.upload.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xyw.medical.birth.model.D301;
import com.xyw.medical.birth.model.D304;
import com.xyw.medical.birth.model.D305;
import com.xyw.medical.birth.model.D401;
import com.xyw.medical.birth.model.D501;
import com.xyw.medical.birth.model.D502;
import com.xyw.medical.birth.model.D601;
import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.model.VD304;
import com.xyw.medical.birth.model.VD305;
import com.xyw.medical.birth.model.VD401;
import com.xyw.medical.birth.model.VD501;
import com.xyw.medical.birth.model.VD502;
import com.xyw.medical.birth.model.VD601;
import com.xyw.sys.util.StringUtil;

public class ConvertUtil {
	
	public static D501 convertVD501(VD501 vd501) {
		D501 d501 = new D501();
		d501.setD50101(vd501.getD50101());
		d501.setD50102(vd501.getD50102());
		d501.setD50103(vd501.getD50103());
		d501.setD50104(vd501.getD50104());
		d501.setD50105(vd501.getD50105());
		d501.setD50106(vd501.getD50106());
		d501.setD50107(vd501.getD50107());
		d501.setD50108(vd501.getD50108());
		d501.setD50109(vd501.getD50109());
		d501.setD50110(vd501.getD50110());
		
		d501.setD50111(vd501.getD50111());
		d501.setD50112(vd501.getD50112());
		d501.setD50113(vd501.getD50113());
		d501.setD50114(vd501.getD50114());
		d501.setD50115(vd501.getD50115());
		d501.setD50116(vd501.getD50116());
		d501.setD50117(vd501.getD50117());
		d501.setD50118(vd501.getD50118());
		d501.setD50119(vd501.getD50119());
		d501.setD50120(vd501.getD50120());
		
		d501.setD50121(vd501.getD50121());
		d501.setD50122(vd501.getD50122());
		d501.setD50123(vd501.getD50123());
		d501.setD50124(vd501.getD50124());
		d501.setD50125(vd501.getD50125());
		d501.setD50126(vd501.getD50126());
		d501.setD50127(vd501.getD50127());
		d501.setD50128(vd501.getD50128());
		d501.setD50129(vd501.getD50129());
		d501.setD50130(vd501.getD50130());
		
		d501.setD50131(vd501.getD50131());
		d501.setD50132(vd501.getD50132());
		d501.setD50133(vd501.getD50133());
		d501.setD50134(vd501.getD50134());
		d501.setD50135(vd501.getD50135());
		d501.setD50136(vd501.getD50136());
		d501.setD50137(vd501.getD50137());
		d501.setD50138(vd501.getD50138());
		d501.setD50139(vd501.getD50139());
		d501.setD50140(vd501.getD50140());
		
		d501.setD50141(vd501.getD50141());
		d501.setD50142(vd501.getD50142());
		d501.setD50143(vd501.getD50143());
		d501.setD50144(vd501.getD50144());
		d501.setD50145(vd501.getD50145());
		d501.setD50146(vd501.getD50146());
		d501.setD50147(vd501.getD50147());
		d501.setD50148(vd501.getD50148());
		d501.setD50149(vd501.getD50149());
		d501.setD50150(vd501.getD50150());
			
		return d501;
	}
	
	public static D502 convertVD502(VD502 vd502) {
		D502 d502 = new D502();
		
		d502.setD50201(vd502.getD50201());
		d502.setD50202(vd502.getD50202());
		d502.setD50203(vd502.getD50203());
		d502.setD50204(vd502.getD50204());
		d502.setD50205(vd502.getD50205());
		d502.setD50206(vd502.getD50206());
		d502.setD50207(vd502.getD50207());
		d502.setD50208(vd502.getD50208());
		d502.setD50209(vd502.getD50209());
		d502.setD50210(vd502.getD50210());
		
		d502.setD50211(vd502.getD50211());
		d502.setD50212(vd502.getD50212());
		d502.setD50213(vd502.getD50213());
		d502.setD50214(vd502.getD50214());
		d502.setD50215(vd502.getD50215());
		d502.setD50216(vd502.getD50216());
		d502.setD50217(vd502.getD50217());
		d502.setD50218(vd502.getD50218());
		d502.setD50219(vd502.getD50219());
		d502.setD50220(vd502.getD50220());
		
		d502.setD50221(vd502.getD50221());
		d502.setD50222(vd502.getD50222());
		d502.setD50223(vd502.getD50223());
		d502.setD50224(vd502.getD50224());
		d502.setD50225(vd502.getD50225());
		d502.setD50226(vd502.getD50226());
		d502.setD50227(vd502.getD50227());
		d502.setD50228(vd502.getD50228());
		d502.setD50229(vd502.getD50229());
		d502.setD50230(vd502.getD50230());
		
		d502.setD50231(vd502.getD50231());
		d502.setD50232(vd502.getD50232());
		d502.setD50233(vd502.getD50233());
		d502.setD50234(vd502.getD50234());
		d502.setD50235(vd502.getD50235());
		d502.setD50236(vd502.getD50236());
		d502.setD50237(vd502.getD50237());
		d502.setD50238(vd502.getD50238());
		d502.setD50239(vd502.getD50239());
		d502.setD50240(vd502.getD50240());
		
		d502.setD50241(vd502.getD50241());
		d502.setD50242(vd502.getD50242());
		d502.setD50243(vd502.getD50243());
		d502.setD50244(vd502.getD50244());
		d502.setD50245(vd502.getD50245());
		d502.setD50246(vd502.getD50246());
		d502.setD50247(vd502.getD50247());
		d502.setD50248(vd502.getD50248());
		d502.setD50249(vd502.getD50249());
		d502.setD50250(vd502.getD50250());
		
		return d502;
	}
	
	public static D601 convertVD601(VD601 vd601) {
		D601 d601 = new D601();
		d601.setD60101(vd601.getD60101());
		d601.setD60102(vd601.getD60102());
		d601.setD60103(vd601.getD60103_());
		d601.setD60104(vd601.getD60104());
		d601.setD60105(vd601.getD60105());
		d601.setD60106(vd601.getD60106());
		d601.setD60107(vd601.getD60107());
		d601.setD60108(vd601.getD60108());
		d601.setD60109(vd601.getD60109());
		d601.setD60110(vd601.getD60110());
		
		d601.setD60111(vd601.getD60111());
		d601.setD60112(stringToDate(vd601.getD60112()));
		d601.setD60113(stringToDate(vd601.getD60103()));
		d601.setD60114(vd601.getD60114());
		d601.setD60115(vd601.getD60115());
		d601.setD60116(vd601.getD60116());
		d601.setD60117(vd601.getD60117());
		d601.setD60118(vd601.getD60118());
		d601.setD60119(vd601.getD60119());
		d601.setD60120(vd601.getD60120());
		
		d601.setD60121(vd601.getD60121());
		d601.setD60122(vd601.getD60122());
		d601.setD60123(vd601.getD60123());
		d601.setD60124(stringToDate(vd601.getD60124()));
		d601.setD60125(vd601.getD60125());
		d601.setD60126(vd601.getD60126());
		d601.setD60127(vd601.getD60127());
		d601.setD60128(vd601.getD60128());
		d601.setD60129(vd601.getD60129());
		d601.setD60130(vd601.getD60130());
		
		d601.setD60131(vd601.getD60131());
		d601.setD60132(vd601.getD60132());
		d601.setD60133(vd601.getD60133());
		d601.setD60134(vd601.getD60134());
		d601.setD60135(vd601.getD60135());
		d601.setD60136(vd601.getD60136());
		d601.setD60137(vd601.getD60137());
		d601.setD60138(vd601.getD60138());
		d601.setD60139(vd601.getD60139());
		d601.setD60140(vd601.getD60140());
		
		d601.setD60141(vd601.getD60141());
		d601.setD60142(vd601.getD60142());
		d601.setD60143(vd601.getD60143());
		d601.setD60144(vd601.getD60144());
		d601.setD60145(vd601.getD60145());
		d601.setD60146(vd601.getD60146());
		d601.setD60147(vd601.getD60147());
		d601.setD60148(vd601.getD60148());
		d601.setD60149(vd601.getD60149());
		d601.setD60150(vd601.getD60150());
		
		d601.setD60151(vd601.getD60151());
		d601.setD60152(vd601.getD60152());
		d601.setD60153(vd601.getD60153());
		d601.setD60154(vd601.getD60154());
		d601.setD60155(vd601.getD60155());
		d601.setD60156(vd601.getD60156());
		d601.setD60157(vd601.getD60157());
		d601.setD60158(vd601.getD60158());
		d601.setD60159(vd601.getD60159());
		d601.setD60160(stringToDate(vd601.getD60160()));

		d601.setD60161(vd601.getD60161());
		d601.setD60162(vd601.getD60162());
		d601.setD60163(vd601.getD60163());
		d601.setD60164(vd601.getD60164());
		d601.setD60165(vd601.getD60165());
		d601.setD60166("123456");
		d601.setD60167(vd601.getD60167());
		d601.setD60168(vd601.getD60168());
		d601.setD60169(vd601.getD60169());
		d601.setD60170(vd601.getD60170());
		
		d601.setD60171(vd601.getD60171());
		d601.setD60172(vd601.getD60172());
		d601.setD60173(vd601.getD60173());
		d601.setD60174(vd601.getD60174());
		d601.setD60175(vd601.getD60175());
		d601.setD60176(vd601.getD60176());
		d601.setD60177(vd601.getD60177());
		d601.setD60178(vd601.getD60178());
		d601.setD60179(vd601.getD60179());
		d601.setD60180(vd601.getD60180());
		
		d601.setD60181(vd601.getD60181());
		d601.setD60182(vd601.getD60182());
		d601.setD60183(vd601.getD60183());
		d601.setD60184(vd601.getD60184());
		d601.setD60185(vd601.getD60185());
		d601.setD60186(vd601.getD60186());
		d601.setD60187(vd601.getD60187());
		d601.setD60188(vd601.getD60188());
		d601.setD60189(vd601.getD60189());
		d601.setD60190(vd601.getD60190());
		
		d601.setD60191(vd601.getD60191());
		d601.setD60192(vd601.getD60192());
		d601.setD60193(vd601.getD60193());
		d601.setD60194("123456");
		d601.setD60195(vd601.getD60195());
		d601.setD60196(vd601.getD60196());
		d601.setD60197(vd601.getD60197());
		d601.setD60198(vd601.getD60198());
		d601.setD60199(vd601.getD60199());
		
		return d601;
	}
	
	public static D304 convertVD304(VD304 vd304) {
		D304 d304 = new D304();
		
		d304.setD30401(vd304.getD30401());
		d304.setD30402(vd304.getD30402());
		d304.setD30403(vd304.getD30403());
		d304.setD30404(vd304.getD30404_());
		d304.setD30405(vd304.getD30405());
		d304.setD30406(vd304.getD30406());
		d304.setD30407(vd304.getD30407());
		d304.setD30408(vd304.getD30408());
		d304.setD30409(vd304.getD30409());
		d304.setD30410(vd304.getD30410());
		
		d304.setD30411(vd304.getD30411());
		d304.setD30412(vd304.getD30412());
		d304.setD30413(vd304.getD30413_());
		d304.setD30414(vd304.getD30414());
		d304.setD30415(vd304.getD30415());
		d304.setD30416(vd304.getD30416());
		d304.setD30417(vd304.getD30417());
		d304.setD30418(vd304.getD30418());
		d304.setD30419(vd304.getD30419());
		d304.setD30420(vd304.getD30420());
		
		d304.setD30421(vd304.getD30421());
		d304.setD30422(vd304.getD30422());
		d304.setD30423(vd304.getD30423());
		d304.setD30424(vd304.getD30424());
		d304.setD30425(vd304.getD30425());
		d304.setD30426(vd304.getD30426());
		d304.setD30427(vd304.getD30427());
		d304.setD30428(vd304.getD30428());
		d304.setD30429(vd304.getD30429());
		d304.setD30430(vd304.getD30430());
		
		d304.setD30431(vd304.getD30431());
		if(vd304.getD30432() == 0){
			d304.setD30432(99999999);
		} else {
			d304.setD30432(vd304.getD30432());
		}
		d304.setD30433(vd304.getD30433());
		d304.setD30434(vd304.getD30434());
		d304.setD30435(vd304.getD30435());
		d304.setD30436(vd304.getD30436());
		d304.setD30437(vd304.getD30437());
		d304.setD30438(vd304.getD30438());
		d304.setD30439(vd304.getD30439());
		d304.setD30440(vd304.getD30440());

		d304.setD30441(vd304.getD30441());
		d304.setD30442(vd304.getD30442());
		d304.setD30443(vd304.getD30443());
		d304.setD30444(vd304.getD30444());
		d304.setD30445(vd304.getD30445());
		d304.setD30446(vd304.getD30446());
		d304.setD30447(vd304.getD30447());
		d304.setD30448(vd304.getD30448());
		d304.setD30449(vd304.getD30449());
		d304.setD30450(vd304.getD30450());

		d304.setD30451(vd304.getD30451());
		d304.setD30452(vd304.getD30452());
		d304.setD30453(vd304.getD30453());
		d304.setD30454(vd304.getD30454());
		d304.setD30455(vd304.getD30455());
		d304.setD30456(vd304.getD30456());
		d304.setD30457(vd304.getD30457());
		d304.setD30458(vd304.getD30458());
		d304.setD30459(vd304.getD30459());
		d304.setD30460(vd304.getD30460());

		d304.setD30461(vd304.getD30461());
		d304.setD30462(vd304.getD30462());
		d304.setD30463(vd304.getD30463());
		d304.setD30464(vd304.getD30464());
		d304.setD30465(vd304.getD30465());
		d304.setD30466(vd304.getD30466());
		d304.setD30467(vd304.getD30467());
		d304.setD30468(vd304.getD30468());
		d304.setD30469(vd304.getD30469());
		d304.setD30470(vd304.getD30470());
		
		return d304;
	}
	
	public static D301 convertVD301(VD301 vd301) {
		D301 d301 = new D301();
		
		d301.setD30101(vd301.getD30101());
		d301.setD30102(vd301.getD30102());
		d301.setD30103(vd301.getD30103());
		d301.setD30104(stringToDateTime(vd301.getD30104()));
		d301.setD30105(vd301.getD30105());
		d301.setD30106(vd301.getD30106());
		d301.setD30107(vd301.getD30107());
		d301.setD30108(vd301.getD30108());
		d301.setD30109(vd301.getD30109());
		d301.setD30110(vd301.getD30110());
		
		d301.setD30111(vd301.getD30111());
		d301.setD30112(vd301.getD30112());
		d301.setD30113(stringToDate(vd301.getD30113()));
		d301.setD30114(vd301.getD30114());
		d301.setD30115(vd301.getD30115());
		d301.setD30116(vd301.getD30116());
		d301.setD30117(vd301.getD30117());
		d301.setD30118(stringToDate(vd301.getD30118()));
		d301.setD30119(vd301.getD30119());
		d301.setD30120(vd301.getD30120());
		
		d301.setD30121(vd301.getD30121());
		d301.setD30122(vd301.getD30122());
		d301.setD30123(vd301.getD30123());
		d301.setD30124(vd301.getD30124());
		d301.setD30125(vd301.getD30125());
		d301.setD30126(vd301.getD30126());
		d301.setD30127(vd301.getD30127());
		d301.setD30128(stringToDate(vd301.getD30128()));
		d301.setD30129(vd301.getD30129());
		d301.setD30130(vd301.getD30130());
		
		d301.setD30131(vd301.getD30131());
		d301.setD30132(vd301.getD30132());
		d301.setD30133(stringToDate(vd301.getD30133()));
		d301.setD30134(vd301.getD30134());
		d301.setD30135(vd301.getD30135());
		d301.setD30136(vd301.getD30136());
		d301.setD30137(vd301.getD30137());
		d301.setD30138(vd301.getD30138());
		d301.setD30139(vd301.getD30139());
		d301.setD30140(stringToDate(vd301.getD30140()));
		
		d301.setD30141(vd301.getD30141_());
		d301.setD30142(vd301.getD30142());
		d301.setD30143(vd301.getD30143());
		d301.setD30144(vd301.getD30144());
		d301.setD30145(vd301.getD30145());
		d301.setD30146(vd301.getD30146());
		d301.setD30147(vd301.getD30147());
		d301.setD30148(vd301.getD30148());
		d301.setD30149(vd301.getD30149());
		d301.setD30150(vd301.getD30150());
		
		d301.setD30151(vd301.getD30151());
		if("0".equals(vd301.getD30142())){
			d301.setD30152(null);
		} else {
			d301.setD30152(vd301.getD30152());
		}
		d301.setD30153(vd301.getD30153());
		d301.setD30154(vd301.getD30154());
		d301.setD30155(vd301.getD30155());
		d301.setD30156(vd301.getD30156());
		d301.setD30157(vd301.getD30157());
		d301.setD30158(vd301.getD30158());
		d301.setD30159(vd301.getD30159());
		d301.setD30160(vd301.getD30160());
		
		d301.setD30161(vd301.getD30161());
		d301.setD30162(vd301.getD30162());
		d301.setD30163(vd301.getD30163());
		d301.setD30164(vd301.getD30164());
		d301.setD30165(vd301.getD30165());
		d301.setD30166(vd301.getD30166());
		d301.setD30167(vd301.getD30167());
		d301.setD30168(vd301.getD30168());
		d301.setD30169(vd301.getD30169());
		d301.setD30170(vd301.getD30170());
		
		return d301;
	}
	
	public static D305 convertVD305(VD305 vd305) {
		D305 d305 = new D305();
		
		d305.setD30501(vd305.getD30501());
		d305.setD30502(vd305.getD30502());
		d305.setD30503(vd305.getD30503());
		d305.setD30504(vd305.getD30504_());
		d305.setD30505(vd305.getD30505());
		d305.setD30506(vd305.getD30506());
		d305.setD30507(vd305.getD30507());
		d305.setD30508(vd305.getD30508());
		d305.setD30509(vd305.getD30509());
		d305.setD30510(vd305.getD30510());
		
		d305.setD30511(vd305.getD30511());
		d305.setD30512(vd305.getD30512());
		d305.setD30513(vd305.getD30513_());
		d305.setD30514(vd305.getD30514());
		d305.setD30515(vd305.getD30515());
		d305.setD30516(vd305.getD30516());
		d305.setD30517(vd305.getD30517());
		d305.setD30518(vd305.getD30518());
		d305.setD30519(vd305.getD30519());
		d305.setD30520(vd305.getD30520());
		
		d305.setD30521(vd305.getD30521());
		d305.setD30522(vd305.getD30522());
		d305.setD30523(vd305.getD30523());
		d305.setD30524(vd305.getD30524());
		d305.setD30525(vd305.getD30525());
		d305.setD30526(vd305.getD30526());
		d305.setD30527(vd305.getD30527());
		d305.setD30528(vd305.getD30528());
		d305.setD30529(vd305.getD30529());
		d305.setD30530(vd305.getD30530());
		
		d305.setD30531(vd305.getD30531());
		d305.setD30532(vd305.getD30532());
		d305.setD30533(vd305.getD30533());
		d305.setD30534(vd305.getD30534());
		d305.setD30535(vd305.getD30535_());
		d305.setD30536(vd305.getD30536());
		d305.setD30537(vd305.getD30537_());
		d305.setD30538(vd305.getD30538());
		d305.setD30539(vd305.getD30539());
		d305.setD30540(vd305.getD30540());
		
		d305.setD30541(vd305.getD30541_());
		d305.setD30542(vd305.getD30542());
		d305.setD30543(vd305.getD30543());
		d305.setD30544(vd305.getD30544());
		d305.setD30545(vd305.getD30545());
		d305.setD30546(vd305.getD30546());
		d305.setD30547(vd305.getD30547());
		d305.setD30548(vd305.getD30548());
		d305.setD30549(vd305.getD30549());
		d305.setD30550(vd305.getD30550());
		
		d305.setD30551(vd305.getD30551());
		d305.setD30552(vd305.getD30552());
		d305.setD30553(vd305.getD30553());
		d305.setD30554(vd305.getD30554());
		d305.setD30555(vd305.getD30555());
		d305.setD30556(vd305.getD30556());
		d305.setD30557(vd305.getD30557());
		d305.setD30558(vd305.getD30558());
		d305.setD30559(vd305.getD30559());
		d305.setD30560(vd305.getD30560());
		
		d305.setD30561(vd305.getD30561());
		d305.setD30562(vd305.getD30562());
		d305.setD30563(vd305.getD30563());
		d305.setD30564(vd305.getD30564());
		d305.setD30565(vd305.getD30565());
		d305.setD30566(vd305.getD30566());
		d305.setD30567(vd305.getD30567());
		d305.setD30568(vd305.getD30568());
		d305.setD30569(vd305.getD30569());
		d305.setD30570(vd305.getD30570());

		return d305;
	}
	
	public static D401 convertVD401(VD401 vd401) {
		D401 d401 = new D401();
		
		d401.setD40101(vd401.getD40101());
		d401.setD40102(vd401.getD40102());
		d401.setD40103(vd401.getD40103());
		d401.setD40104(vd401.getD40104());
		d401.setD40105(vd401.getD40105());
		d401.setD40106(vd401.getD40106());
		d401.setD40107(vd401.getD40107());
		d401.setD40108(vd401.getD40108());
		d401.setD40109(vd401.getD40109());
		d401.setD40110(vd401.getD40110());
		
		d401.setD40111(vd401.getD40111());
		d401.setD40112(vd401.getD40112());
		d401.setD40113(vd401.getD40113());
		d401.setD40114(vd401.getD40114());
		d401.setD40115(vd401.getD40115());
		d401.setD40116(vd401.getD40116());
		d401.setD40117(vd401.getD40117());
		d401.setD40118(vd401.getD40118());
		d401.setD40119(vd401.getD40119());
		d401.setD40120(vd401.getD40120());
		
		d401.setD40121(vd401.getD40121());
		d401.setD40122(vd401.getD40122());
		d401.setD40123(vd401.getD40123());
		d401.setD40124(vd401.getD40124());
		d401.setD40125(vd401.getD40125());
		d401.setD40126(vd401.getD40126());
		d401.setD40127(vd401.getD40127());
		d401.setD40128(vd401.getD40128());
		d401.setD40129(vd401.getD40129());
		d401.setD40130(vd401.getD40130());
	
		d401.setD40131(vd401.getD40131());
		d401.setD40132(vd401.getD40132());
		d401.setD40133(vd401.getD40133());
		d401.setD40134(vd401.getD40134());
		d401.setD40135(vd401.getD40135());
		d401.setD40136(vd401.getD40136());
		d401.setD40137(vd401.getD40137());
		d401.setD40138(vd401.getD40138());
		d401.setD40139(vd401.getD40139());
		d401.setD40140(vd401.getD40140());
		
		return d401;
	}
	
	public static Date stringToDateTime(String dateStr){
		if(!StringUtil.isBlankString(dateStr)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return sdf.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Date stringToDate(String dateStr){
		if(!StringUtil.isBlankString(dateStr)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdf.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
