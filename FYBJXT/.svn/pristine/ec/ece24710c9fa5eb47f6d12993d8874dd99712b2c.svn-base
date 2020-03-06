 var contextRoot = "/csyxzm";
$(document).ready(function(){
	
	var printInfo = new Array();
	var printInfoLabel  = new Array();
	
	printInfo[0] = "BIRTH_PRINTINFOBHF_NEW";
	printInfoLabel[0] = "出生证明";

	printInfo[1] = "BIRTH_PRINTINFOHF_SECOND_NEW";
	printInfoLabel[1] = "副页";
	
	printInfo[2] = "BIRTH_PRINTINFOHF_THIRD_NEW";
	printInfoLabel[2] = "存根";
	
	var birthInfo = new Array();
	var birthInfoLabel = new Array();
	
	birthInfo[0] = "d30202;d30203;d30204;d30204m;d30204d;d30204h;d30204mi;d30207;d30231;d30208;d30205;d30205c;d30205co;d30224Zh;d30211;d30213;d30214Zh;d30215Zh;d30221m;d30236id;d30236pa;d30249;d30212;d30216;d30218;d30219Zh;d30220Zh;d30221f;d30237id;d30237pa;d30250;d30217;d30226Zh;d30228;d30228m;d30228d";
	birthInfoLabel[0] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;签发机构;签发年;签发月;签发日";
	birthInfo[1] = "d30202S;d30203S;d30204S;d30204mS;d30204dS;d30204hS;d30204miS;d30207S;d30231S;d30208S;d30205S;d30205cS;d30205coS;d30224ZhS;d30211S;d30213S;d30214ZhS;d30215ZhS;d30221mS;d30236idS;d30236paS;d30249S;d30212S;d30216S;d30218S;d30219ZhS;d30220ZhS;d30221fS;d30237idS;d30237paS;d30250S;d30217S;d30226ZhS;d30228S;d30228mS;d30228dS";
    birthInfoLabel[1] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;签发机构;签发年;签发月;签发日";
	birthInfo[2] = "d30202T;d30203T;d30204T;d30204mT;d30204dT;d30204hT;d30204miT;d30207T;d30231T;d30208T;d30205T;d30205cT;d30205coT;d30224ZhT;d30211T;d30213T;d30214ZhT;d30215ZhT;d30221mT;d30236idT;d30236paT;d30249T;d30212T;d30216T;d30218T;d30219ZhT;d30220ZhT;d30221fT;d30237idT;d30237paT;d30250T;d30217T;d30225T;d30238T;d30227T;d30228T;d30228mT;d30228dT;d30226ZhT";
    birthInfoLabel[2] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;接生人;领证人;签发人;签发年;签发月;签发日;签发机构";
	
	var d30210 = $("#d30210").val();
	var userCode = $("#userCode").val();
	$.post(contextRoot + "/PrintBirthInfoServletNew", {"flag":"BIRTH_PRINTINFOHF_NEW","d30210":d30210, "userCode":userCode}, function(data){
		var jsonStr = data[0];//位置
		var vd302 = data[1];//值
		var symbol = "√";
		
		var birthInfos = birthInfo[0].split(";");
		var birthInfosd30202Offset = jsonStr[birthInfos[0]];
		if(birthInfosd30202Offset != undefined) {
			var d30202Offset = birthInfosd30202Offset.split(";");
			var d30202Offset_left = d30202Offset[0];
			var d30202Offset_top = d30202Offset[1];
			var d30202Value = vd302[birthInfos[0]];
			createDiv(birthInfos[0], d30202Value, d30202Offset_left, d30202Offset_top);
		}

		var d30203Value = vd302[birthInfos[1]];
		var birthInfosd30203Offset = "";
		var gender = "";
		birthInfosd30203Offset = jsonStr[birthInfos[1]];
		if(d30203Value == "1") {
			gender = "男";
		} else if(d30203Value == "2") {
			gender = "女";
		} 
		if(birthInfosd30203Offset != "") {
			var d30203Offset = birthInfosd30203Offset.split(";");
			var d30203Offset_left = d30203Offset[0];
			var d30203Offset_top = d30203Offset[1];
			createDiv(birthInfos[1], gender, d30203Offset_left, d30203Offset_top);
		}
		
		var d30204Value = vd302[birthInfos[2]];
		var reg = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/; 
		var timeV = "";
		var year = "";
		var month = "";
		var date = "";
		var hour = "";
		var minute = "";
		
		if(d30204Value != "")
		{
			timeV = reg.exec(d30204Value);
			year = timeV[1];
			month = timeV[2];
			date = timeV[3];
			hour = timeV[4];
			minute = timeV[5];
		}
		
		var d30204Offset = jsonStr[birthInfos[2]];
		if(d30204Offset != undefined) {
			var d30204Offsets = d30204Offset.split(";");
			var d30204Offset_left = d30204Offsets[0];
			var d30204Offset_top = d30204Offsets[1];
			createDiv(birthInfos[2], year, d30204Offset_left, d30204Offset_top);
		}
		
		var d30204MonthOffset = jsonStr[birthInfos[3]];
		if(d30204MonthOffset != undefined) {
			var d30204MonthOffsets = d30204MonthOffset.split(";");
			var d30204MonthOffset_left = d30204MonthOffsets[0];
			var d30204MonthOffset_top = d30204MonthOffsets[1];
			createDiv(birthInfos[3], month, d30204MonthOffset_left, d30204MonthOffset_top);
		}
		
		var d30204DateOffset = jsonStr[birthInfos[4]];
		if(d30204DateOffset != undefined) {
			var d30204DateOffsets = d30204DateOffset.split(";");
			var d30204DateOffset_left = d30204DateOffsets[0];
			var d30204DateOffset_top = d30204DateOffsets[1];
			createDiv(birthInfos[4], date, d30204DateOffset_left, d30204DateOffset_top);
		}
		
		var d30204HourOffset = jsonStr[birthInfos[5]];
		if(d30204HourOffset != undefined) {
			var d30204HourOffsets = d30204HourOffset.split(";");
			var d30204HourOffset_left = d30204HourOffsets[0];
			var d30204HourOffset_top = d30204HourOffsets[1];
			createDiv(birthInfos[5], hour, d30204HourOffset_left, d30204HourOffset_top);
		}
		
		var d30204MinuteOffset = jsonStr[birthInfos[6]];
		if(d30204MinuteOffset != undefined) {
			var d30204MinuteOffsets = d30204MinuteOffset.split(";");
			var d30204MinuteOffset_left = d30204MinuteOffsets[0];
			var d30204MinuteOffset_top = d30204MinuteOffsets[1];
			createDiv(birthInfos[6], minute, d30204MinuteOffset_left, d30204MinuteOffset_top);
		}
		
		var d30207 = vd302[birthInfos[7]]; // weeks
		var d30251 = vd302["d30251"]; // days
		
		var d30207Offset = jsonStr[birthInfos[7]];
		if(d30207Offset != undefined) {
			var d30207Offsets = d30207Offset.split(";");
			var d30207Offset_left = d30207Offsets[0];
			var d30207Offset_top = d30207Offsets[1];
			if(d30251 != undefined && d30251 != 0) {
				createDiv(birthInfos[7], d30207 + "<sup>+" + d30251 + "</sup>", d30207Offset_left, d30207Offset_top);
			}
			else
			{
				createDiv(birthInfos[7], d30207, d30207Offset_left, d30207Offset_top);
			}
		}
		
		var d30231 = vd302[birthInfos[8]];
		var d30231Offset = jsonStr[birthInfos[8]];
		if(d30231Offset != undefined) {
			var d30231Offsets = d30231Offset.split(";");
			var d30231Offset_left = d30231Offsets[0];
			var d30231Offset_top = d30231Offsets[1];
			createDiv(birthInfos[8], d30231, d30231Offset_left, d30231Offset_top);
		}
		
		var d30208 = vd302[birthInfos[9]];
		var d30208Offset = jsonStr[birthInfos[9]];
		if(d30208Offset != undefined) {
			var d30208Offsets = d30208Offset.split(";");
			var d30208Offset_left = d30208Offsets[0];
			var d30208Offset_top = d30208Offsets[1];
			createDiv(birthInfos[9], d30208, d30208Offset_left, d30208Offset_top);
		}
		
		var d30205OffsetProviceValue = "";
		var d30205OffsetCityValue = "";
		var d30205OffsetCountyValue = "";
		var areaCode = vd302["d30205"];
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30205OffsetProviceValue = dataValue[0];
			d30205OffsetCityValue = dataValue[1];
			d30205OffsetCountyValue = dataValue[2];
			
			var d30205OffsetProvice = jsonStr[birthInfos[10]];
			var d30205OffsetCity = jsonStr[birthInfos[11]];
			var d30205OffsetCounty = jsonStr[birthInfos[12]];
			if(d30205OffsetProvice != undefined) {
				var d30205OffsetProvices =  d30205OffsetProvice.split(";");
				var d30205OffsetProvices_left = d30205OffsetProvices[0];
				var d30205OffsetProvices_top = d30205OffsetProvices[1];
				createDiv(birthInfos[10], d30205OffsetProviceValue, d30205OffsetProvices_left, d30205OffsetProvices_top);
			}
			if(d30205OffsetCity != undefined) {
				var d30205OffsetCitys =  d30205OffsetCity.split(";");
				var d30205OffsetCitys_left = d30205OffsetCitys[0];
				var d30205OffsetCitys_top = d30205OffsetCitys[1];
				createDiv(birthInfos[11], d30205OffsetCityValue, d30205OffsetCitys_left, d30205OffsetCitys_top);
			}
			if(d30205OffsetCounty != undefined) {
				var d30205OffsetCountys =  d30205OffsetCounty.split(";");
				var d30205OffsetCountys_left = d30205OffsetCountys[0];
				var d30205OffsetCountys_top = d30205OffsetCountys[1];
				createDiv(birthInfos[12], d30205OffsetCountyValue, d30205OffsetCountys_left, d30205OffsetCountys_top);
			}
		}, "json");
		
		var d30224Offset = jsonStr[birthInfos[13]];
		if(d30224Offset != undefined) {
			var d30224Offsets = d30224Offset.split(";");
			var d30224Offsets_left = d30224Offsets[0];
			var d30224Offsets_top = d30224Offsets[1];
			var d30224Value = vd302[birthInfos[13]];
			createDiv(birthInfos[13], d30224Value, d30224Offsets_left, d30224Offsets_top);
		}
		
		var d30211Value = vd302[birthInfos[14]];
		
		var d30211Offset = jsonStr[birthInfos[14]];
		if(d30211Offset != undefined) {
			var d30211Offsets = d30211Offset.split(";");
			d30211Offset_left = d30211Offsets[0];
			d30211Offset_top = d30211Offsets[1];
			//母亲姓名
			if(d30211Value == null || "" == d30211Value || d30211Value == undefined){
				d30211Value = "///" ;
			}
			createDiv(birthInfos[14], d30211Value, d30211Offset_left, d30211Offset_top);
		}
		
		var d30213Offset = jsonStr[birthInfos[15]];
		if(d30213Offset != undefined) {
			var d30213Offsets = d30213Offset.split(";");
			var d30213Offsets_left = d30213Offsets[0];
			var d30213Offsets_top = d30213Offsets[1];
			var d30213Value = vd302[birthInfos[15]];
			//母亲年龄
			if(d30213Value == null || "" == d30213Value || d30213Value == undefined){
				d30213Value = "//" ;
			}
			createDiv(birthInfos[15], d30213Value, d30213Offsets_left, d30213Offsets_top);
		}
		
		var d30214Offset = jsonStr[birthInfos[16]];
		if(d30214Offset != undefined) {
			var d30214Offsets = d30214Offset.split(";");
			var d30214Offsets_left = d30214Offsets[0];
			var d30214Offsets_top = d30214Offsets[1];
			var d30214Value = vd302[birthInfos[16]];
			//母亲国籍
			if(d30214Value == null || "" == d30214Value || d30214Value == undefined){
				d30214Value = "//" ;
			}
			createDiv(birthInfos[16], d30214Value, d30214Offsets_left, d30214Offsets_top);
		}
		
		var d30215Offset = jsonStr[birthInfos[17]];
		if(d30215Offset != undefined) {
			var d30215Offsets = d30215Offset.split(";");
			var d30215Offsets_left = d30215Offsets[0];
			var d30215Offsets_top = d30215Offsets[1];
			var d30215Value = vd302[birthInfos[17]];
			//母亲民族
			if(d30215Value == null || "" == d30215Value || d30215Value == undefined){
				d30215Value = "//" ;
			}
			createDiv(birthInfos[17], d30215Value, d30215Offsets_left, d30215Offsets_top);
		}
		
		var d30221mOffset = jsonStr[birthInfos[18]];
		if(d30221mOffset != undefined) {
			var d30221mOffsets = d30221mOffset.split(";");
			var d30221mOffsets_left = d30221mOffsets[0];
			var d30221mOffsets_top = d30221mOffsets[1];
			var d30221mValue = vd302["d30221"];
			//母亲家庭住址
			if(d30211Value == "///" && (d30221mValue == null || "" == d30221mValue || d30221mValue == undefined)){
				d30221mValue = "//////////////////" ;
			}
			createDiv(birthInfos[18], d30221mValue, d30221mOffsets_left, d30221mOffsets_top);
		}
		
		var d30236idZhOffset = jsonStr[birthInfos[19]];
		var d30236paZhOffset = jsonStr[birthInfos[20]];
		var d30249Offset = jsonStr[birthInfos[21]];
		var d30236Value = vd302["d30236"];
		var d30249Value = vd302["d30249"];
		
		if(d30236Value == "1") {
			if(d30236idZhOffset != undefined) {
				var d30236idZhOffsets = d30236idZhOffset.split(";");
				var d30236idZhOffset_left = d30236idZhOffsets[0];
				var d30236idZhOffset_top = d30236idZhOffsets[1];
				
				createDiv(birthInfos[19], symbol, d30236idZhOffset_left, d30236idZhOffset_top);
			}
		} else if(d30236Value == "3") {
			if(d30236paZhOffset != undefined) {
				var d30236paZhOffsets = d30236paZhOffset.split(";");
				var d30236paZhOffset_left = d30236paZhOffsets[0];
				var d30236paZhOffset_top = d30236paZhOffsets[1];
				
				createDiv(birthInfos[20], symbol, d30236paZhOffset_left, d30236paZhOffset_top);
			}
		} else if(d30236Value == "4") {
			if(d30249Offset != undefined) {
				var d30249Offsets = d30249Offset.split(";");
				var d30249Offset_left = d30249Offsets[0];
				var d30249Offset_top = d30249Offsets[1];
				
				createDiv(birthInfos[21], d30249Value, d30249Offset_left, d30249Offset_top);
			}
		}
		
		
		
		var d30212Offset = jsonStr[birthInfos[22]];
		if(d30212Offset != undefined) {
			var d30212Offsets = d30212Offset.split(";");
			var d30212Offsets_left = d30212Offsets[0];
			var d30212Offsets_top = d30212Offsets[1];
			var d30212Value = vd302[birthInfos[22]];
			//母亲身份证号
			if(d30212Value == null || "" == d30212Value || d30212Value == undefined){
				d30212Value = "//////////////////" ;
			}
			createDiv(birthInfos[22], d30212Value, d30212Offsets_left, d30212Offsets_top);
		}
		
		var d30216Value = vd302[birthInfos[23]];
		
		var d30216Offset = jsonStr[birthInfos[23]];
		if(d30216Offset != undefined) {
			var d30216Offsets = d30216Offset.split(";");
			var d30216Offsets_left = d30216Offsets[0];
			var d30216Offsets_top = d30216Offsets[1];
			//父亲姓名
			if(d30216Value == null || "" == d30216Value || d30216Value == undefined){
				d30216Value ="///" ;
			}
			createDiv(birthInfos[23], d30216Value, d30216Offsets_left, d30216Offsets_top);
		}
		
		var d30218Offset = jsonStr[birthInfos[24]];
		if(d30218Offset != undefined) {
			var d30218Offsets = d30218Offset.split(";");
			var d30218Offsets_left = d30218Offsets[0];
			var d30218Offsets_top = d30218Offsets[1];
			var d30218Value = vd302[birthInfos[24]];
			//父亲年龄
			if(d30218Value == null || "" == d30218Value || d30218Value == undefined){
				d30218Value = "//" ;
			}
			createDiv(birthInfos[24], d30218Value, d30218Offsets_left, d30218Offsets_top);
		}
		
		var d30219Offset = jsonStr[birthInfos[25]];
		if(d30219Offset != undefined) {
			var d30219Offsets = d30219Offset.split(";");
			var d30219Offsets_left = d30219Offsets[0];
			var d30219Offsets_top = d30219Offsets[1];
			var d30219Value = vd302[birthInfos[25]];
			//父亲国籍
			if(d30219Value == null || "" == d30219Value || d30219Value == undefined){
				d30219Value = "//" ;
			}
			createDiv(birthInfos[25], d30219Value, d30219Offsets_left, d30219Offsets_top);
		}
		
		var d30220Offset = jsonStr[birthInfos[26]];
		if(d30220Offset != undefined) {
			var d30220Offsets = d30220Offset.split(";");
			var d30220Offsets_left = d30220Offsets[0];
			var d30220Offsets_top = d30220Offsets[1];
			var d30220Value = vd302[birthInfos[26]];
			//父亲民族
			if(d30220Value == null || "" == d30220Value || d30220Value == undefined){
				d30220Value = "//" ;
			}
			createDiv(birthInfos[26], d30220Value, d30220Offsets_left, d30220Offsets_top);
		}
		
		var d30221fOffset = jsonStr[birthInfos[27]];
		if(d30221fOffset != undefined) {
			var d30221fOffsets = d30221fOffset.split(";");
			var d30221fOffsets_left = d30221fOffsets[0];
			var d30221fOffsets_top = d30221fOffsets[1];
			var d30252Value = vd302["d30252"];
			//父亲家庭住址
			if(d30216Value == "///" && (d30252Value == null || "" == d30252Value || d30252Value == undefined)){
				d30252Value = "//////////////////" ;
			}
			createDiv(birthInfos[27], d30252Value, d30221fOffsets_left, d30221fOffsets_top);
		}
		
		
		var d30237idZhOffset = jsonStr[birthInfos[28]];
		var d30237paZhOffset = jsonStr[birthInfos[29]];
		var d30250Offset = jsonStr[birthInfos[30]];
		var d30237Value = vd302["d30237"];
		var d30250Value = vd302["d30250"];
		
		if(d30237Value == "1") {
			if(d30237idZhOffset != undefined) {
				var d30237idZhOffsets = d30237idZhOffset.split(";");
				var d30237idZhOffset_left = d30237idZhOffsets[0];
				var d30237idZhOffset_top = d30237idZhOffsets[1];
				
				createDiv(birthInfos[28], symbol, d30237idZhOffset_left, d30237idZhOffset_top);
			}
		} else if(d30237Value == "3") {
			if(d30237paZhOffset != undefined) {
				var d30237paZhOffsets = d30237paZhOffset.split(";");
				var d30237paZhOffset_left = d30237paZhOffsets[0];
				var d30237paZhOffset_top = d30237paZhOffsets[1];
				
				createDiv(birthInfos[29], symbol, d30237paZhOffset_left, d30237paZhOffset_top);
			}
		} else if(d30237Value == "4") {
			if(d30250Offset != undefined) {
				var d30250Offsets = d30250Offset.split(";");
				var d30250Offset_left = d30250Offsets[0];
				var d30250Offset_top = d30250Offsets[1];
				
				createDiv(birthInfos[30], d30250Value, d30250Offset_left, d30250Offset_top);
			}
		}
		
		var d30217Offset = jsonStr[birthInfos[31]];
		if(d30217Offset != undefined) {
			var d30217Offsets = d30217Offset.split(";");
			var d30217Offsets_left = d30217Offsets[0];
			var d30217Offsets_top = d30217Offsets[1];
			var d30217Value = vd302[birthInfos[31]];
			//父亲身份证号
			if(d30217Value == null || "" == d30217Value || d30217Value == undefined){
				d30217Value = "//////////////////" ;
			}
			createDiv(birthInfos[31], d30217Value, d30217Offsets_left, d30217Offsets_top);
		}
		
		var d30226ZhValue = vd302[birthInfos[32]];
		var d30226ZhOffset = jsonStr[birthInfos[32]];
		if(d30226ZhOffset != undefined) {
			var d30226ZhOffsets = d30226ZhOffset.split(";");
			var d30226ZhOffset_left = d30226ZhOffsets[0];
			var d30226ZhOffset_top = d30226ZhOffsets[1];
			createDiv(birthInfos[32], d30226ZhValue, d30226ZhOffset_left, d30226ZhOffset_top);
		}
		
		
		
		var d30228Value = vd302[birthInfos[33]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30228Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30228OffsetYear = jsonStr[birthInfos[33]];
		if(d30228OffsetYear != undefined) {
			var d30228OffsetYears = d30228OffsetYear.split(";");
			var d30228OffsetYear_left = d30228OffsetYears[0];
			var d30228OffsetYear_top = d30228OffsetYears[1];
			createDiv(birthInfos[33], yearS, d30228OffsetYear_left, d30228OffsetYear_top);
		}
		
		var d30228OffsetMonth = jsonStr[birthInfos[34]];
		if(d30228OffsetMonth != undefined) {
			var d30228OffsetMonths = d30228OffsetMonth.split(";");
			var d30228OffsetMonths_left = d30228OffsetMonths[0];
			var d30228OffsetMonths_top = d30228OffsetMonths[1];
			createDiv(birthInfos[34], monthS, d30228OffsetMonths_left, d30228OffsetMonths_top);
		}
		
		var d30228OffsetDate = jsonStr[birthInfos[35]];
		if(d30228OffsetDate != undefined) {
			var d30228OffsetDates = d30228OffsetDate.split(";");
			var d30228OffsetDates_left = d30228OffsetDates[0];
			var d30228OffsetDates_top = d30228OffsetDates[1];
			createDiv(birthInfos[35], dateS, d30228OffsetDates_left, d30228OffsetDates_top);
		}
	
		var birthInfoSs = birthInfo[1].split(";");
		var birthInfoSsd30202Offset = jsonStr[birthInfoSs[0]];
		if(birthInfoSsd30202Offset != undefined) {
			var d30202Offset = birthInfoSsd30202Offset.split(";");
			var d30202Offset_left = d30202Offset[0];
			var d30202Offset_top = d30202Offset[1];
			var d30202Value = vd302[birthInfoSs[0]];
			createDiv(birthInfoSs[0], d30202Value, d30202Offset_left, d30202Offset_top);
		}
		
		var d30203Value = vd302[birthInfoSs[1]];
		var birthInfoSsd30203Offset = "";
		var gender = "";
		birthInfoSsd30203Offset = jsonStr[birthInfoSs[1]];
		if(d30203Value == "1") {
			gender = "男";
		} else if(d30203Value == "2") {
			gender = "女";
		} 
		if(birthInfoSsd30203Offset != "") {
			var d30203Offset = birthInfoSsd30203Offset.split(";");
			var d30203Offset_left = d30203Offset[0];
			var d30203Offset_top = d30203Offset[1];
			createDiv(birthInfoSs[1], gender, d30203Offset_left, d30203Offset_top);
		}
		
		var d30204Value = vd302[birthInfoSs[2]];
		var reg = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/; 
		var timeV = "";
		var year = "";
		var month = "";
		var date = "";
		var hour = "";
		var minute = "";
		
		if(d30204Value != "")
		{
			timeV = reg.exec(d30204Value);
			year = timeV[1];
			month = timeV[2];
			date = timeV[3];
			hour = timeV[4];
			minute = timeV[5];
		}
		
		var d30204Offset = jsonStr[birthInfoSs[2]];
		if(d30204Offset != undefined) {
			var d30204Offsets = d30204Offset.split(";");
			var d30204Offset_left = d30204Offsets[0];
			var d30204Offset_top = d30204Offsets[1];
			createDiv(birthInfoSs[2], year, d30204Offset_left, d30204Offset_top);
		}
		
		var d30204MonthOffset = jsonStr[birthInfoSs[3]];
		if(d30204MonthOffset != undefined) {
			var d30204MonthOffsets = d30204MonthOffset.split(";");
			var d30204MonthOffset_left = d30204MonthOffsets[0];
			var d30204MonthOffset_top = d30204MonthOffsets[1];
			createDiv(birthInfoSs[3], month, d30204MonthOffset_left, d30204MonthOffset_top);
		}
		
		var d30204DateOffset = jsonStr[birthInfoSs[4]];
		if(d30204DateOffset != undefined) {
			var d30204DateOffsets = d30204DateOffset.split(";");
			var d30204DateOffset_left = d30204DateOffsets[0];
			var d30204DateOffset_top = d30204DateOffsets[1];
			createDiv(birthInfoSs[4], date, d30204DateOffset_left, d30204DateOffset_top);
		}
		
		var d30204HourOffset = jsonStr[birthInfoSs[5]];
		if(d30204HourOffset != undefined) {
			var d30204HourOffsets = d30204HourOffset.split(";");
			var d30204HourOffset_left = d30204HourOffsets[0];
			var d30204HourOffset_top = d30204HourOffsets[1];
			createDiv(birthInfoSs[5], hour, d30204HourOffset_left, d30204HourOffset_top);
		}
		
		var d30204MinuteOffset = jsonStr[birthInfoSs[6]];
		if(d30204MinuteOffset != undefined) {
			var d30204MinuteOffsets = d30204MinuteOffset.split(";");
			var d30204MinuteOffset_left = d30204MinuteOffsets[0];
			var d30204MinuteOffset_top = d30204MinuteOffsets[1];
			createDiv(birthInfoSs[6], minute, d30204MinuteOffset_left, d30204MinuteOffset_top);
		}
		
		var d30207 = vd302[birthInfoSs[7]]; // weeks
		var d30251 = vd302["d30251"]; // days
		
		var d30207Offset = jsonStr[birthInfoSs[7]];
		if(d30207Offset != undefined) {
			var d30207Offsets = d30207Offset.split(";");
			var d30207Offset_left = d30207Offsets[0];
			var d30207Offset_top = d30207Offsets[1];
			if(d30251 != undefined && d30251 != 0) {
				createDiv(birthInfoSs[7], d30207 + "<sup>+" + d30251 + "</sup>", d30207Offset_left, d30207Offset_top);
			}
			else
			{
				createDiv(birthInfoSs[7], d30207, d30207Offset_left, d30207Offset_top);
			}
		}
		
		var d30231 = vd302[birthInfoSs[8]];
		var d30231Offset = jsonStr[birthInfoSs[8]];
		if(d30231Offset != undefined) {
			var d30231Offsets = d30231Offset.split(";");
			var d30231Offset_left = d30231Offsets[0];
			var d30231Offset_top = d30231Offsets[1];
			createDiv(birthInfoSs[8], d30231, d30231Offset_left, d30231Offset_top);
		}
		
		var d30208 = vd302[birthInfoSs[9]];
		var d30208Offset = jsonStr[birthInfoSs[9]];
		if(d30208Offset != undefined) {
			var d30208Offsets = d30208Offset.split(";");
			var d30208Offset_left = d30208Offsets[0];
			var d30208Offset_top = d30208Offsets[1];
			createDiv(birthInfoSs[9], d30208, d30208Offset_left, d30208Offset_top);
		}
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30205OffsetProviceValue = dataValue[0];
			d30205OffsetCityValue = dataValue[1];
			d30205OffsetCountyValue = dataValue[2];
			
			var d30205OffsetProvice = jsonStr[birthInfoSs[10]];
			var d30205OffsetCity = jsonStr[birthInfoSs[11]];
			var d30205OffsetCounty = jsonStr[birthInfoSs[12]];

			if(d30205OffsetProvice != undefined) {
				var d30205OffsetProvices =  d30205OffsetProvice.split(";");
				var d30205OffsetProvices_left = d30205OffsetProvices[0];
				var d30205OffsetProvices_top = d30205OffsetProvices[1];
				createDiv(birthInfoSs[10], d30205OffsetProviceValue, d30205OffsetProvices_left, d30205OffsetProvices_top);
			}
			if(d30205OffsetCity != undefined) {
				var d30205OffsetCitys =  d30205OffsetCity.split(";");
				var d30205OffsetCitys_left = d30205OffsetCitys[0];
				var d30205OffsetCitys_top = d30205OffsetCitys[1];
				createDiv(birthInfoSs[11], d30205OffsetCityValue, d30205OffsetCitys_left, d30205OffsetCitys_top);
			}
			if(d30205OffsetCounty != undefined) {
				var d30205OffsetCountys =  d30205OffsetCounty.split(";");
				var d30205OffsetCountys_left = d30205OffsetCountys[0];
				var d30205OffsetCountys_top = d30205OffsetCountys[1];
				createDiv(birthInfoSs[12], d30205OffsetCountyValue, d30205OffsetCountys_left, d30205OffsetCountys_top);
			}
		}, "json");
		
		var d30224Offset = jsonStr[birthInfoSs[13]];
		if(d30224Offset != undefined) {
			var d30224Offsets = d30224Offset.split(";");
			var d30224Offsets_left = d30224Offsets[0];
			var d30224Offsets_top = d30224Offsets[1];
			var d30224Value = vd302[birthInfoSs[13]];
			createDiv(birthInfoSs[13], d30224Value, d30224Offsets_left, d30224Offsets_top);
		}
		
		var d30211Value = vd302[birthInfoSs[14]];
		
		var d30211Offset = jsonStr[birthInfoSs[14]];
		if(d30211Offset != undefined) {
			var d30211Offsets = d30211Offset.split(";");
			d30211Offset_left = d30211Offsets[0];
			d30211Offset_top = d30211Offsets[1];
			//母亲姓名
			if(d30211Value == null || "" == d30211Value || d30211Value == undefined){
				d30211Value = "///" ;
			}
			createDiv(birthInfoSs[14], d30211Value, d30211Offset_left, d30211Offset_top);
		}
		
		var d30213Offset = jsonStr[birthInfoSs[15]];
		if(d30213Offset != undefined) {
			var d30213Offsets = d30213Offset.split(";");
			var d30213Offsets_left = d30213Offsets[0];
			var d30213Offsets_top = d30213Offsets[1];
			var d30213Value = vd302[birthInfoSs[15]];
			//母亲年龄
			if(d30213Value == null || "" == d30213Value || d30213Value == undefined){
				d30213Value = "//" ;
			}
			createDiv(birthInfoSs[15], d30213Value, d30213Offsets_left, d30213Offsets_top);
		}
		
		var d30214Offset = jsonStr[birthInfoSs[16]];
		if(d30214Offset != undefined) {
			var d30214Offsets = d30214Offset.split(";");
			var d30214Offsets_left = d30214Offsets[0];
			var d30214Offsets_top = d30214Offsets[1];
			var d30214Value = vd302[birthInfoSs[16]];
			//母亲国籍
			if(d30214Value == null || "" == d30214Value || d30214Value == undefined){
				d30214Value = "//" ;
			}
			createDiv(birthInfoSs[16], d30214Value, d30214Offsets_left, d30214Offsets_top);
		}
		
		var d30215Offset = jsonStr[birthInfoSs[17]];
		if(d30215Offset != undefined) {
			var d30215Offsets = d30215Offset.split(";");
			var d30215Offsets_left = d30215Offsets[0];
			var d30215Offsets_top = d30215Offsets[1];
			var d30215Value = vd302[birthInfoSs[17]];
			//母亲民族
			if(d30215Value == null || "" == d30215Value || d30215Value == undefined){
				d30215Value = "//" ;
			}
			createDiv(birthInfoSs[17], d30215Value, d30215Offsets_left, d30215Offsets_top);
		}
		
		var d30221mOffset = jsonStr[birthInfoSs[18]];
		if(d30221mOffset != undefined) {
			var d30221mOffsets = d30221mOffset.split(";");
			var d30221mOffsets_left = d30221mOffsets[0];
			var d30221mOffsets_top = d30221mOffsets[1];
			var d30221mValue = vd302["d30221"];
			//母亲家庭住址
			if(d30211Value == "///" && (d30221mValue == null || "" == d30221mValue || d30221mValue == undefined)){
				d30221mValue = "//////////////////" ;
			}
			createDiv(birthInfoSs[18], d30221mValue, d30221mOffsets_left, d30221mOffsets_top);
		}
		
		var d30236idZhOffset = jsonStr[birthInfoSs[19]];
		var d30236paZhOffset = jsonStr[birthInfoSs[20]];
		var d30249Offset = jsonStr[birthInfoSs[21]];
		var d30236Value = vd302["d30236"];
		var d30249Value = vd302["d30249"];
		
		if(d30236Value == "1") {
			if(d30236idZhOffset != undefined) {
				var d30236idZhOffsets = d30236idZhOffset.split(";");
				var d30236idZhOffset_left = d30236idZhOffsets[0];
				var d30236idZhOffset_top = d30236idZhOffsets[1];
				
				createDiv(birthInfoSs[19], symbol, d30236idZhOffset_left, d30236idZhOffset_top);
			}
		} else if(d30236Value == "3") {
			if(d30236paZhOffset != undefined) {
				var d30236paZhOffsets = d30236paZhOffset.split(";");
				var d30236paZhOffset_left = d30236paZhOffsets[0];
				var d30236paZhOffset_top = d30236paZhOffsets[1];
				
				createDiv(birthInfoSs[20], symbol, d30236paZhOffset_left, d30236paZhOffset_top);
			}
		} else if(d30236Value == "4") {
			if(d30249Offset != undefined) {
				var d30249Offsets = d30249Offset.split(";");
				var d30249Offset_left = d30249Offsets[0];
				var d30249Offset_top = d30249Offsets[1];
				
				createDiv(birthInfoSs[21], d30249Value, d30249Offset_left, d30249Offset_top);
			}
		}
		
		
		
		var d30212Offset = jsonStr[birthInfoSs[22]];
		if(d30212Offset != undefined) {
			var d30212Offsets = d30212Offset.split(";");
			var d30212Offsets_left = d30212Offsets[0];
			var d30212Offsets_top = d30212Offsets[1];
			var d30212Value = vd302[birthInfoSs[22]];
			//母亲身份证号
			if(d30212Value == null || "" == d30212Value || d30212Value == undefined){
				d30212Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[22], d30212Value, d30212Offsets_left, d30212Offsets_top);
		}
		
		var d30216Value = vd302[birthInfoSs[23]];
		var d30216Offset = jsonStr[birthInfoSs[23]];
		if(d30216Offset != undefined) {
			var d30216Offsets = d30216Offset.split(";");
			var d30216Offsets_left = d30216Offsets[0];
			var d30216Offsets_top = d30216Offsets[1];
			//父亲姓名
			if(d30216Value == null || "" == d30216Value || d30216Value == undefined){
				d30216Value ="///" ;
			}
			createDiv(birthInfoSs[23], d30216Value, d30216Offsets_left, d30216Offsets_top);
		}
		
		var d30218Offset = jsonStr[birthInfoSs[24]];
		if(d30218Offset != undefined) {
			var d30218Offsets = d30218Offset.split(";");
			var d30218Offsets_left = d30218Offsets[0];
			var d30218Offsets_top = d30218Offsets[1];
			var d30218Value = vd302[birthInfoSs[24]];
			//父亲年龄
			if(d30218Value == null || "" == d30218Value || d30218Value == undefined){
				d30218Value = "//" ;
			}
			createDiv(birthInfoSs[24], d30218Value, d30218Offsets_left, d30218Offsets_top);
		}
		
		var d30219Offset = jsonStr[birthInfoSs[25]];
		if(d30219Offset != undefined) {
			var d30219Offsets = d30219Offset.split(";");
			var d30219Offsets_left = d30219Offsets[0];
			var d30219Offsets_top = d30219Offsets[1];
			var d30219Value = vd302[birthInfoSs[25]];
			//父亲国籍
			if(d30219Value == null || "" == d30219Value || d30219Value == undefined){
				d30219Value = "//" ;
			}
			createDiv(birthInfoSs[25], d30219Value, d30219Offsets_left, d30219Offsets_top);
		}
		
		var d30220Offset = jsonStr[birthInfoSs[26]];
		if(d30220Offset != undefined) {
			var d30220Offsets = d30220Offset.split(";");
			var d30220Offsets_left = d30220Offsets[0];
			var d30220Offsets_top = d30220Offsets[1];
			var d30220Value = vd302[birthInfoSs[26]];
			//父亲民族
			if(d30220Value == null || "" == d30220Value || d30220Value == undefined){
				d30220Value = "//" ;
			}
			createDiv(birthInfoSs[26], d30220Value, d30220Offsets_left, d30220Offsets_top);
		}
		
		var d30221fOffset = jsonStr[birthInfoSs[27]];
		if(d30221fOffset != undefined) {
			var d30221fOffsets = d30221fOffset.split(";");
			var d30221fOffsets_left = d30221fOffsets[0];
			var d30221fOffsets_top = d30221fOffsets[1];
			var d30252Value = vd302["d30252"];
			//父亲家庭住址
			if(d30216Value == "///" && (d30252Value == null || "" == d30252Value || d30252Value == undefined)){
				d30252Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[27], d30252Value, d30221fOffsets_left, d30221fOffsets_top);
		}
		
		
		var d30237idZhOffset = jsonStr[birthInfoSs[28]];
		var d30237paZhOffset = jsonStr[birthInfoSs[29]];
		var d30250Offset = jsonStr[birthInfoSs[30]];
		var d30237Value = vd302["d30237"];
		var d30250Value = vd302["d30250"];
		
		if(d30237Value == "1") {
			if(d30237idZhOffset != undefined) {
				var d30237idZhOffsets = d30237idZhOffset.split(";");
				var d30237idZhOffset_left = d30237idZhOffsets[0];
				var d30237idZhOffset_top = d30237idZhOffsets[1];
				
				createDiv(birthInfoSs[28], symbol, d30237idZhOffset_left, d30237idZhOffset_top);
			}
		} else if(d30237Value == "3") {
			if(d30237paZhOffset != undefined) {
				var d30237paZhOffsets = d30237paZhOffset.split(";");
				var d30237paZhOffset_left = d30237paZhOffsets[0];
				var d30237paZhOffset_top = d30237paZhOffsets[1];
				
				createDiv(birthInfoSs[29], symbol, d30237paZhOffset_left, d30237paZhOffset_top);
			}
		} else if(d30237Value == "4") {
			if(d30250Offset != undefined) {
				var d30250Offsets = d30250Offset.split(";");
				var d30250Offset_left = d30250Offsets[0];
				var d30250Offset_top = d30250Offsets[1];
				
				createDiv(birthInfoSs[30], d30250Value, d30250Offset_left, d30250Offset_top);
			}
		}
		
		var d30217Offset = jsonStr[birthInfoSs[31]];
		if(d30217Offset != undefined) {
			var d30217Offsets = d30217Offset.split(";");
			var d30217Offsets_left = d30217Offsets[0];
			var d30217Offsets_top = d30217Offsets[1];
			var d30217Value = vd302[birthInfoSs[31]];
			//父亲身份证号
			if(d30217Value == null || "" == d30217Value || d30217Value == undefined){
				d30217Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[31], d30217Value, d30217Offsets_left, d30217Offsets_top);
		}
		
		var d30226ZhValue = vd302[birthInfoSs[32]];
		var d30226ZhOffset = jsonStr[birthInfoSs[32]];
		if(d30226ZhOffset != undefined) {
			var d30226ZhOffsets = d30226ZhOffset.split(";");
			var d30226ZhOffset_left = d30226ZhOffsets[0];
			var d30226ZhOffset_top = d30226ZhOffsets[1];
			createDiv(birthInfoSs[32], d30226ZhValue, d30226ZhOffset_left, d30226ZhOffset_top);
		}
		
		
		
		var d30228Value = vd302[birthInfoSs[33]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30228Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30228OffsetYear = jsonStr[birthInfoSs[33]];
		if(d30228OffsetYear != undefined) {
			var d30228OffsetYears = d30228OffsetYear.split(";");
			var d30228OffsetYear_left = d30228OffsetYears[0];
			var d30228OffsetYear_top = d30228OffsetYears[1];
			createDiv(birthInfoSs[33], yearS, d30228OffsetYear_left, d30228OffsetYear_top);
		}
		
		var d30228OffsetMonth = jsonStr[birthInfoSs[34]];
		if(d30228OffsetMonth != undefined) {
			var d30228OffsetMonths = d30228OffsetMonth.split(";");
			var d30228OffsetMonths_left = d30228OffsetMonths[0];
			var d30228OffsetMonths_top = d30228OffsetMonths[1];
			createDiv(birthInfoSs[34], monthS, d30228OffsetMonths_left, d30228OffsetMonths_top);
		}
		
		var d30228OffsetDate = jsonStr[birthInfoSs[35]];
		if(d30228OffsetDate != undefined) {
			var d30228OffsetDates = d30228OffsetDate.split(";");
			var d30228OffsetDates_left = d30228OffsetDates[0];
			var d30228OffsetDates_top = d30228OffsetDates[1];
			createDiv(birthInfoSs[35], dateS, d30228OffsetDates_left, d30228OffsetDates_top);
		}
		
		var birthInfoTs = birthInfo[2].split(";");
		var birthInfoTsd30202Offset = jsonStr[birthInfoTs[0]];
		if(birthInfoTsd30202Offset != undefined) {
			var d30202Offset = birthInfoTsd30202Offset.split(";");
			var d30202Offset_left = d30202Offset[0];
			var d30202Offset_top = d30202Offset[1];
			var d30202Value = vd302[birthInfoTs[0]];
			createDiv(birthInfoTs[0], d30202Value, d30202Offset_left, d30202Offset_top);
		}
		
		var d30203Value = vd302[birthInfoTs[1]];
		var birthInfoTsd30203Offset = "";
		var gender = "";
		birthInfoTsd30203Offset = jsonStr[birthInfoTs[1]];
		if(d30203Value == "1") {
			gender = "男";
		} else if(d30203Value == "2") {
			gender = "女";
		} 
		if(birthInfoTsd30203Offset != "") {
			var d30203Offset = birthInfoTsd30203Offset.split(";");
			var d30203Offset_left = d30203Offset[0];
			var d30203Offset_top = d30203Offset[1];
			createDiv(birthInfoTs[1], gender, d30203Offset_left, d30203Offset_top);
		}
		
		var d30204Value = vd302[birthInfoTs[2]];
		var reg = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/; 
		var timeV = "";
		var year = "";
		var month = "";
		var date = "";
		var hour = "";
		var minute = "";
		
		if(d30204Value != "")
		{
			timeV = reg.exec(d30204Value);
			year = timeV[1];
			month = timeV[2];
			date = timeV[3];
			hour = timeV[4];
			minute = timeV[5];
		}
		
		var d30204Offset = jsonStr[birthInfoTs[2]];
		if(d30204Offset != undefined) {
			var d30204Offsets = d30204Offset.split(";");
			var d30204Offset_left = d30204Offsets[0];
			var d30204Offset_top = d30204Offsets[1];
			createDiv(birthInfoTs[2], year, d30204Offset_left, d30204Offset_top);
		}
		
		var d30204MonthOffset = jsonStr[birthInfoTs[3]];
		if(d30204MonthOffset != undefined) {
			var d30204MonthOffsets = d30204MonthOffset.split(";");
			var d30204MonthOffset_left = d30204MonthOffsets[0];
			var d30204MonthOffset_top = d30204MonthOffsets[1];
			createDiv(birthInfoTs[3], month, d30204MonthOffset_left, d30204MonthOffset_top);
		}
		
		var d30204DateOffset = jsonStr[birthInfoTs[4]];
		if(d30204DateOffset != undefined) {
			var d30204DateOffsets = d30204DateOffset.split(";");
			var d30204DateOffset_left = d30204DateOffsets[0];
			var d30204DateOffset_top = d30204DateOffsets[1];
			createDiv(birthInfoTs[4], date, d30204DateOffset_left, d30204DateOffset_top);
		}
		
		var d30204HourOffset = jsonStr[birthInfoTs[5]];
		if(d30204HourOffset != undefined) {
			var d30204HourOffsets = d30204HourOffset.split(";");
			var d30204HourOffset_left = d30204HourOffsets[0];
			var d30204HourOffset_top = d30204HourOffsets[1];
			createDiv(birthInfoTs[5], hour, d30204HourOffset_left, d30204HourOffset_top);
		}
		
		var d30204MinuteOffset = jsonStr[birthInfoTs[6]];
		if(d30204MinuteOffset != undefined) {
			var d30204MinuteOffsets = d30204MinuteOffset.split(";");
			var d30204MinuteOffset_left = d30204MinuteOffsets[0];
			var d30204MinuteOffset_top = d30204MinuteOffsets[1];
			createDiv(birthInfoTs[6], minute, d30204MinuteOffset_left, d30204MinuteOffset_top);
		}
		
		var d30207 = vd302[birthInfoTs[7]]; // weeks
		var d30251 = vd302["d30251"]; // days
		
		var d30207Offset = jsonStr[birthInfoTs[7]];
		if(d30207Offset != undefined) {
			var d30207Offsets = d30207Offset.split(";");
			var d30207Offset_left = d30207Offsets[0];
			var d30207Offset_top = d30207Offsets[1];
			if(d30251 != undefined && d30251 != 0) {
				createDiv(birthInfoTs[7], d30207 + "<sup>+" + d30251 + "</sup>", d30207Offset_left, d30207Offset_top);
			}
			else
			{
				createDiv(birthInfoTs[7], d30207, d30207Offset_left, d30207Offset_top);
			}
		}
		
		var d30231 = vd302[birthInfoTs[8]];
		var d30231Offset = jsonStr[birthInfoTs[8]];
		if(d30231Offset != undefined) {
			var d30231Offsets = d30231Offset.split(";");
			var d30231Offset_left = d30231Offsets[0];
			var d30231Offset_top = d30231Offsets[1];
			createDiv(birthInfoTs[8], d30231, d30231Offset_left, d30231Offset_top);
		}
		
		var d30208 = vd302[birthInfoTs[9]];
		var d30208Offset = jsonStr[birthInfoTs[9]];
		if(d30208Offset != undefined) {
			var d30208Offsets = d30208Offset.split(";");
			var d30208Offset_left = d30208Offsets[0];
			var d30208Offset_top = d30208Offsets[1];
			createDiv(birthInfoTs[9], d30208, d30208Offset_left, d30208Offset_top);
		}
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30205OffsetProviceValue = dataValue[0];
			d30205OffsetCityValue = dataValue[1];
			d30205OffsetCountyValue = dataValue[2];
		
			var d30205OffsetProvice = jsonStr[birthInfoTs[10]];
			var d30205OffsetCity = jsonStr[birthInfoTs[11]];
			var d30205OffsetCounty = jsonStr[birthInfoTs[12]];
	
			if(d30205OffsetProvice != undefined) {
				var d30205OffsetProvices =  d30205OffsetProvice.split(";");
				var d30205OffsetProvices_left = d30205OffsetProvices[0];
				var d30205OffsetProvices_top = d30205OffsetProvices[1];
				createDiv(birthInfoTs[10], d30205OffsetProviceValue, d30205OffsetProvices_left, d30205OffsetProvices_top);
			}
			if(d30205OffsetCity != undefined) {
				var d30205OffsetCitys =  d30205OffsetCity.split(";");
				var d30205OffsetCitys_left = d30205OffsetCitys[0];
				var d30205OffsetCitys_top = d30205OffsetCitys[1];
				createDiv(birthInfoTs[11], d30205OffsetCityValue, d30205OffsetCitys_left, d30205OffsetCitys_top);
			}
			if(d30205OffsetCounty != undefined) {
				var d30205OffsetCountys =  d30205OffsetCounty.split(";");
				var d30205OffsetCountys_left = d30205OffsetCountys[0];
				var d30205OffsetCountys_top = d30205OffsetCountys[1];
				createDiv(birthInfoTs[12], d30205OffsetCountyValue, d30205OffsetCountys_left, d30205OffsetCountys_top);
			}
		}, "json");
		
		var d30224Offset = jsonStr[birthInfoTs[13]];
		if(d30224Offset != undefined) {
			var d30224Offsets = d30224Offset.split(";");
			var d30224Offsets_left = d30224Offsets[0];
			var d30224Offsets_top = d30224Offsets[1];
			var d30224Value = vd302[birthInfoTs[13]];
			createDiv(birthInfoTs[13], d30224Value, d30224Offsets_left, d30224Offsets_top);
		}
		
		var d30211Value = vd302[birthInfoTs[14]];
		
		var d30211Offset = jsonStr[birthInfoTs[14]];
		if(d30211Offset != undefined) {
			var d30211Offsets = d30211Offset.split(";");
			d30211Offset_left = d30211Offsets[0];
			d30211Offset_top = d30211Offsets[1];
			//母亲姓名
			if(d30211Value == null || "" == d30211Value || d30211Value == undefined){
				d30211Value = "///" ;
			}
			createDiv(birthInfoTs[14], d30211Value, d30211Offset_left, d30211Offset_top);
		}
		
		var d30213Offset = jsonStr[birthInfoTs[15]];
		if(d30213Offset != undefined) {
			var d30213Offsets = d30213Offset.split(";");
			var d30213Offsets_left = d30213Offsets[0];
			var d30213Offsets_top = d30213Offsets[1];
			var d30213Value = vd302[birthInfoTs[15]];
			//母亲年龄
			if(d30213Value == null || "" == d30213Value || d30213Value == undefined){
				d30213Value = "//" ;
			}
			createDiv(birthInfoTs[15], d30213Value, d30213Offsets_left, d30213Offsets_top);
		}
		
		var d30214Offset = jsonStr[birthInfoTs[16]];
		if(d30214Offset != undefined) {
			var d30214Offsets = d30214Offset.split(";");
			var d30214Offsets_left = d30214Offsets[0];
			var d30214Offsets_top = d30214Offsets[1];
			var d30214Value = vd302[birthInfoTs[16]];
			//母亲国籍
			if(d30214Value == null || "" == d30214Value || d30214Value == undefined){
				d30214Value = "//" ;
			}
			createDiv(birthInfoTs[16], d30214Value, d30214Offsets_left, d30214Offsets_top);
		}
		
		var d30215Offset = jsonStr[birthInfoTs[17]];
		if(d30215Offset != undefined) {
			var d30215Offsets = d30215Offset.split(";");
			var d30215Offsets_left = d30215Offsets[0];
			var d30215Offsets_top = d30215Offsets[1];
			var d30215Value = vd302[birthInfoTs[17]];
			//母亲民族
			if(d30215Value == null || "" == d30215Value || d30215Value == undefined){
				d30215Value = "//" ;
			}
			createDiv(birthInfoTs[17], d30215Value, d30215Offsets_left, d30215Offsets_top);
		}
		
		var d30221mOffset = jsonStr[birthInfoTs[18]];
		if(d30221mOffset != undefined) {
			var d30221mOffsets = d30221mOffset.split(";");
			var d30221mOffsets_left = d30221mOffsets[0];
			var d30221mOffsets_top = d30221mOffsets[1];
			var d30221mValue = vd302["d30221"];
			//母亲家庭住址
			if(d30211Value == "///" && (d30221mValue == null || "" == d30221mValue || d30221mValue == undefined)){
				d30221mValue = "//////////////////" ;
			}
			createDiv(birthInfoTs[18], d30221mValue, d30221mOffsets_left, d30221mOffsets_top);
		}
		
		var d30236idZhOffset = jsonStr[birthInfoTs[19]];
		var d30236paZhOffset = jsonStr[birthInfoTs[20]];
		var d30249Offset = jsonStr[birthInfoTs[21]];
		var d30236Value = vd302["d30236"];
		var d30249Value = vd302["d30249"];
		
		if(d30236Value == "1") {
			if(d30236idZhOffset != undefined) {
				var d30236idZhOffsets = d30236idZhOffset.split(";");
				var d30236idZhOffset_left = d30236idZhOffsets[0];
				var d30236idZhOffset_top = d30236idZhOffsets[1];
				
				createDiv(birthInfoTs[19], symbol, d30236idZhOffset_left, d30236idZhOffset_top);
			}
		} else if(d30236Value == "3") {
			if(d30236paZhOffset != undefined) {
				var d30236paZhOffsets = d30236paZhOffset.split(";");
				var d30236paZhOffset_left = d30236paZhOffsets[0];
				var d30236paZhOffset_top = d30236paZhOffsets[1];
				
				createDiv(birthInfoTs[20], symbol, d30236paZhOffset_left, d30236paZhOffset_top);
			}
		} else if(d30236Value == "4") {
			if(d30249Offset != undefined) {
				var d30249Offsets = d30249Offset.split(";");
				var d30249Offset_left = d30249Offsets[0];
				var d30249Offset_top = d30249Offsets[1];
				
				createDiv(birthInfoTs[21], d30249Value, d30249Offset_left, d30249Offset_top);
			}
		}
		
		
		
		var d30212Offset = jsonStr[birthInfoTs[22]];
		if(d30212Offset != undefined) {
			var d30212Offsets = d30212Offset.split(";");
			var d30212Offsets_left = d30212Offsets[0];
			var d30212Offsets_top = d30212Offsets[1];
			var d30212Value = vd302[birthInfoTs[22]];
			//母亲身份证号
			if(d30212Value == null || "" == d30212Value || d30212Value == undefined){
				d30212Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[22], d30212Value, d30212Offsets_left, d30212Offsets_top);
		}
		
		var d30216Value = vd302[birthInfoTs[23]];
		var d30216Offset = jsonStr[birthInfoTs[23]];
		if(d30216Offset != undefined) {
			var d30216Offsets = d30216Offset.split(";");
			var d30216Offsets_left = d30216Offsets[0];
			var d30216Offsets_top = d30216Offsets[1];
			//父亲姓名
			if(d30216Value == null || "" == d30216Value || d30216Value == undefined){
				d30216Value ="///" ;
			}
			createDiv(birthInfoTs[23], d30216Value, d30216Offsets_left, d30216Offsets_top);
		}
		
		var d30218Offset = jsonStr[birthInfoTs[24]];
		if(d30218Offset != undefined) {
			var d30218Offsets = d30218Offset.split(";");
			var d30218Offsets_left = d30218Offsets[0];
			var d30218Offsets_top = d30218Offsets[1];
			var d30218Value = vd302[birthInfoTs[24]];
			//父亲年龄
			if(d30218Value == null || "" == d30218Value || d30218Value == undefined){
				d30218Value = "//" ;
			}
			createDiv(birthInfoTs[24], d30218Value, d30218Offsets_left, d30218Offsets_top);
		}
		
		var d30219Offset = jsonStr[birthInfoTs[25]];
		if(d30219Offset != undefined) {
			var d30219Offsets = d30219Offset.split(";");
			var d30219Offsets_left = d30219Offsets[0];
			var d30219Offsets_top = d30219Offsets[1];
			var d30219Value = vd302[birthInfoTs[25]];
			//父亲国籍
			if(d30219Value == null || "" == d30219Value || d30219Value == undefined){
				d30219Value = "//" ;
			}
			createDiv(birthInfoTs[25], d30219Value, d30219Offsets_left, d30219Offsets_top);
		}
		
		var d30220Offset = jsonStr[birthInfoTs[26]];
		if(d30220Offset != undefined) {
			var d30220Offsets = d30220Offset.split(";");
			var d30220Offsets_left = d30220Offsets[0];
			var d30220Offsets_top = d30220Offsets[1];
			var d30220Value = vd302[birthInfoTs[26]];
			//父亲民族
			if(d30220Value == null || "" == d30220Value || d30220Value == undefined){
				d30220Value = "//" ;
			}
			createDiv(birthInfoTs[26], d30220Value, d30220Offsets_left, d30220Offsets_top);
		}
		
		var d30221fOffset = jsonStr[birthInfoTs[27]];
		if(d30221fOffset != undefined) {
			var d30221fOffsets = d30221fOffset.split(";");
			var d30221fOffsets_left = d30221fOffsets[0];
			var d30221fOffsets_top = d30221fOffsets[1];
			var d30252Value = vd302["d30252"];
			//父亲家庭住址
			if(d30216Value == "///" && (d30252Value == null || "" == d30252Value || d30252Value == undefined)){
				d30252Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[27], d30252Value, d30221fOffsets_left, d30221fOffsets_top);
		}
		
		
		var d30237idZhOffset = jsonStr[birthInfoTs[28]];
		var d30237paZhOffset = jsonStr[birthInfoTs[29]];
		var d30250Offset = jsonStr[birthInfoTs[30]];
		var d30237Value = vd302["d30237"];
		var d30250Value = vd302["d30250"];
		
		if(d30237Value == "1") {
			if(d30237idZhOffset != undefined) {
				var d30237idZhOffsets = d30237idZhOffset.split(";");
				var d30237idZhOffset_left = d30237idZhOffsets[0];
				var d30237idZhOffset_top = d30237idZhOffsets[1];
				
				createDiv(birthInfoTs[28], symbol, d30237idZhOffset_left, d30237idZhOffset_top);
			}
		} else if(d30237Value == "3") {
			if(d30237paZhOffset != undefined) {
				var d30237paZhOffsets = d30237paZhOffset.split(";");
				var d30237paZhOffset_left = d30237paZhOffsets[0];
				var d30237paZhOffset_top = d30237paZhOffsets[1];
				
				createDiv(birthInfoTs[29], symbol, d30237paZhOffset_left, d30237paZhOffset_top);
			}
		} else if(d30237Value == "4") {
			if(d30250Offset != undefined) {
				var d30250Offsets = d30250Offset.split(";");
				var d30250Offset_left = d30250Offsets[0];
				var d30250Offset_top = d30250Offsets[1];
				
				createDiv(birthInfoTs[30], d30250Value, d30250Offset_left, d30250Offset_top);
			}
		}
		
		var d30217Offset = jsonStr[birthInfoTs[31]];
		if(d30217Offset != undefined) {
			var d30217Offsets = d30217Offset.split(";");
			var d30217Offsets_left = d30217Offsets[0];
			var d30217Offsets_top = d30217Offsets[1];
			var d30217Value = vd302[birthInfoTs[31]];
			//父亲身份证号
			if(d30217Value == null || "" == d30217Value || d30217Value == undefined){
				d30217Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[31], d30217Value, d30217Offsets_left, d30217Offsets_top);
		}
		
		var d30225Value = vd302[birthInfoTs[32]];
		var d30225Offset = jsonStr[birthInfoTs[32]];
		if(d30225Offset != undefined) {
			var d30225Offsets = d30225Offset.split(";");
			var d30225Offset_left = d30225Offsets[0];
			var d30225Offset_top = d30225Offsets[1];
			createDiv(birthInfoTs[32], d30225Value, d30225Offset_left, d30225Offset_top);
		}
		
		var d30238Value = vd302[birthInfoTs[33]];
		var d30238Offset = jsonStr[birthInfoTs[33]];
		if(d30238Offset != undefined) {
			var d30238Offsets = d30238Offset.split(";");
			var d30238Offset_left = d30238Offsets[0];
			var d30238Offset_top = d30238Offsets[1];
			createDiv(birthInfoTs[33], d30238Value, d30238Offset_left, d30238Offset_top);
		}
		
		var d30227Value = vd302[birthInfoTs[34]];
		var d30227Offset = jsonStr[birthInfoTs[34]];
		if(d30227Offset != undefined) {
			var d30227Offsets = d30227Offset.split(";");
			var d30227Offset_left = d30227Offsets[0];
			var d30227Offset_top = d30227Offsets[1];
			createDiv(birthInfoTs[34], d30227Value, d30227Offset_left, d30227Offset_top);
		}
		
		var d30228Value = vd302[birthInfoTs[35]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30228Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30228OffsetYear = jsonStr[birthInfoTs[35]];
		if(d30228OffsetYear != undefined) {
			var d30228OffsetYears = d30228OffsetYear.split(";");
			var d30228OffsetYear_left = d30228OffsetYears[0];
			var d30228OffsetYear_top = d30228OffsetYears[1];
			createDiv(birthInfoTs[35], yearS, d30228OffsetYear_left, d30228OffsetYear_top);
		}
		
		var d30228OffsetMonth = jsonStr[birthInfoTs[36]];
		if(d30228OffsetMonth != undefined) {
			var d30228OffsetMonths = d30228OffsetMonth.split(";");
			var d30228OffsetMonths_left = d30228OffsetMonths[0];
			var d30228OffsetMonths_top = d30228OffsetMonths[1];
			createDiv(birthInfoTs[36], monthS, d30228OffsetMonths_left, d30228OffsetMonths_top);
		}
		
		var d30228OffsetDate = jsonStr[birthInfoTs[37]];
		if(d30228OffsetDate != undefined) {
			var d30228OffsetDates = d30228OffsetDate.split(";");
			var d30228OffsetDates_left = d30228OffsetDates[0];
			var d30228OffsetDates_top = d30228OffsetDates[1];
			createDiv(birthInfoTs[37], dateS, d30228OffsetDates_left, d30228OffsetDates_top);
		}
		
		var d30226Value = vd302[birthInfoTs[38]];
		var d30226Offset = jsonStr[birthInfoTs[38]];
		if(d30226Offset != undefined) {
			var d30226Offsets = d30226Offset.split(";");
			var d30226Offset_left = d30226Offsets[0];
			var d30226Offset_top = d30226Offsets[1];
			createDiv(birthInfoTs[38], d30226Value, d30226Offset_left, d30226Offset_top);
		}
	}, "json");
});

function createDiv(id, value, offset_left, offset_top)
{
	if(id == "d30207" || id == "d30207S" || id == "d30207T") {
		$("body").append($("<div></div>").attr("id", id).append(value));
	} else {
		$("body").append($("<div></div>").attr("id", id).text(value));
	}
	
	$("#" + id).css({"position":"absolute", "font-size":"15px"});
	$("#" + id).offset({left:offset_left, top:offset_top});
}