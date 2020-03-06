 var contextRoot = "/csyxzm";
$(document).ready(function(){
	
	var printInfo = new Array();
	var printInfoLabel  = new Array();
	var birthInfo = new Array();
	var birthInfoLabel = new Array();

	printInfo[0] = "BIRTH_PRINTINFO_HF";
	printInfoLabel[0] = "出生证明";

	printInfo[1] = "BIRTH_PRINTINFO_SECOND_HF";
	printInfoLabel[1] = "副页";
	
	printInfo[2] = "BIRTH_PRINTINFO_THIRD_HF";
	printInfoLabel[2] = "存根";
	
	birthInfo[0] = "d30202;d30203;a03;d30204;a05;a06;a07;a08;d30205;a10;a11;a12;d30207;d30209;a15;a16;d30229;d30208;d30211;d30213;d30214Zh;d30215Zh;d30212;d30216;d30218;d30219Zh;d30220Zh;d30217;d30222;a30;a31;a32;d30223;d30224Zh;d30228;a36;a37";
	birthInfoLabel[0] = "新生儿姓名;男;女;年;月;日;时;分;省;市;县;乡;孕周;良好;一般;差;体重;身长;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲身份证号;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲身份证号;医院;保健院;家庭;其他;其它;接生机构;签发年;签发月;签发日";
	
	birthInfo[1] = "d30202S;d30203ZhS;d30204S;s05;s06;s07;s08;d30205ZhS;d30211S;d30213S;d30214ZhS;d30215ZhS;d30212S;d30216S;d30218S;d30219ZhS;d30220ZhS;d30217S;d30221S;d30228S;s36;s37";
	birthInfoLabel[1] = "婴儿姓名;性别;年;月;日;时;分;出生地点;母亲姓名;母亲年龄;母亲国籍;母亲民族;身份证;父亲姓名;父亲年龄;父亲国籍;父亲民族;身份证;家庭住址;签发年;签发月;签发日";
	
	birthInfo[2] = "d30202T;d30203ZhT;d30204T;t05;t06;t07;t08;d30205ZhT;d30211T;d30213T;d30214ZhT;d30215ZhT;d30212T;d30216T;d30218T;d30219ZhT;d30220ZhT;d30217T;d30221T;d30228T;t36;t37";
	birthInfoLabel[2] = "婴儿姓名;性别;年;月;日;时;分;出生地点;母亲姓名;母亲年龄;母亲国籍;母亲民族;身份证;父亲姓名;父亲年龄;父亲国籍;父亲民族;身份证;家庭住址;签发年;签发月;签发日";
	
	var d30210 = $("#d30210").val();
	$.post(contextRoot + "/PrintBirthInfoHfServlet", {"flag":"BIRTH_PRINTINFO_HF","d30210":d30210}, function(data){
		var jsonStr = data[0];
		var vd302 = data[1];
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
		if(d30203Value == "1") {
			birthInfosd30203Offset = jsonStr[birthInfos[1]];
		} else if(d30203Value == "2") {
			birthInfosd30203Offset = jsonStr[birthInfos[2]];
		} 
		if(birthInfosd30203Offset != "") {
			var d30203Offset = birthInfosd30203Offset.split(";");
			var d30203Offset_left = d30203Offset[0];
			var d30203Offset_top = d30203Offset[1];
			createDiv(birthInfos[1], symbol, d30203Offset_left, d30203Offset_top);
		}
		
		var d30204Value = vd302[birthInfos[3]];
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
		
		var d30204Offset = jsonStr[birthInfos[3]];
		if(d30204Offset != undefined) {
			var d30204Offsets = d30204Offset.split(";");
			var d30204Offset_left = d30204Offsets[0];
			var d30204Offset_top = d30204Offsets[1];
			createDiv(birthInfos[3], year, d30204Offset_left, d30204Offset_top);
		}
		
		var d30204MonthOffset = jsonStr[birthInfos[4]];
		if(d30204MonthOffset != undefined) {
			var d30204MonthOffsets = d30204MonthOffset.split(";");
			var d30204MonthOffset_left = d30204MonthOffsets[0];
			var d30204MonthOffset_top = d30204MonthOffsets[1];
			createDiv(birthInfos[4], month, d30204MonthOffset_left, d30204MonthOffset_top);
		}
		
		var d30204DateOffset = jsonStr[birthInfos[5]];
		if(d30204DateOffset != undefined) {
			var d30204DateOffsets = d30204DateOffset.split(";");
			var d30204DateOffset_left = d30204DateOffsets[0];
			var d30204DateOffset_top = d30204DateOffsets[1];
			createDiv(birthInfos[5], date, d30204DateOffset_left, d30204DateOffset_top);
		}
		
		var d30204HourOffset = jsonStr[birthInfos[6]];
		if(d30204HourOffset != undefined) {
			var d30204HourOffsets = d30204HourOffset.split(";");
			var d30204HourOffset_left = d30204HourOffsets[0];
			var d30204HourOffset_top = d30204HourOffsets[1];
			createDiv(birthInfos[6], hour, d30204HourOffset_left, d30204HourOffset_top);
		}
		
		var d30204MinuteOffset = jsonStr[birthInfos[7]];
		if(d30204MinuteOffset != undefined) {
			var d30204MinuteOffsets = d30204MinuteOffset.split(";");
			var d30204MinuteOffset_left = d30204MinuteOffsets[0];
			var d30204MinuteOffset_top = d30204MinuteOffsets[1];
			createDiv(birthInfos[7], minute, d30204MinuteOffset_left, d30204MinuteOffset_top);
		}
		
		var d30205OffsetProvice = jsonStr[birthInfos[8]];
		var d30205OffsetCity = jsonStr[birthInfos[9]];
		var d30205OffsetCounty = jsonStr[birthInfos[10]];
		var d30205OffsetTown = jsonStr[birthInfos[11]];
		var areaCode = vd302[birthInfos[8]];

		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			var d30205OffsetProviceValue = dataValue[0];
			var d30205OffsetCityValue = dataValue[1];
			var d30205OffsetCountyValue = dataValue[2];
			var d30205OffsetTownValue = dataValue[3];
			if(d30205OffsetProvice != undefined) {
				var d30205OffsetProvices =  d30205OffsetProvice.split(";");
				var d30205OffsetProvices_left = d30205OffsetProvices[0];
				var d30205OffsetProvices_top = d30205OffsetProvices[1];
				createDiv(birthInfos[8], d30205OffsetProviceValue, d30205OffsetProvices_left, d30205OffsetProvices_top);
			}
			if(d30205OffsetCity != undefined) {
				var d30205OffsetCitys =  d30205OffsetCity.split(";");
				var d30205OffsetCitys_left = d30205OffsetCitys[0];
				var d30205OffsetCitys_top = d30205OffsetCitys[1];
				createDiv(birthInfos[9], d30205OffsetCityValue, d30205OffsetCitys_left, d30205OffsetCitys_top);
			}
			if(d30205OffsetCounty != undefined) {
				var d30205OffsetCountys =  d30205OffsetCounty.split(";");
				var d30205OffsetCountys_left = d30205OffsetCountys[0];
				var d30205OffsetCountys_top = d30205OffsetCountys[1];
				createDiv(birthInfos[10], d30205OffsetCountyValue, d30205OffsetCountys_left, d30205OffsetCountys_top);
			}
			if(d30205OffsetTown != undefined) {
				var d30205OffsetTowns =  d30205OffsetTown.split(";");
				var d30205OffsetTowns_left = d30205OffsetTowns[0];
				var d30205OffsetTowns_top = d30205OffsetTowns[1];
				createDiv(birthInfos[11], d30205OffsetTownValue, d30205OffsetTowns_left, d30205OffsetTowns_top);
			}
		}, "json");
		
		var d30207Offset = jsonStr[birthInfos[12]];
		if(d30207Offset != undefined) {
			var d30207Offsets = d30207Offset.split(";");
			var d30207Offsets_left = d30207Offsets[0];
			var d30207Offsets_top = d30207Offsets[1];
			var d30207Value = vd302[birthInfos[12]];
			createDiv(birthInfos[12], d30207Value, d30207Offsets_left, d30207Offsets_top);
		}
		
		var d30209Value = vd302[birthInfos[13]];
		if(d30209Value == "1") {
			var d30209OffsetGood = jsonStr[birthInfos[13]];
			if(d30209OffsetGood != undefined) {
				var d30209OffsetGoods = d30209OffsetGood.split(";");
				d30209OffsetGoods_left = d30209OffsetGoods[0];
				d30209OffsetGoods_top = d30209OffsetGoods[1];
				createDiv(birthInfos[13], symbol, d30209OffsetGoods_left, d30209OffsetGoods_top);
			}
		} else if(d30209Value == "2") {
			var d30209OffsetNormal = jsonStr[birthInfos[14]];
			if(d30209OffsetNormal != undefined) {
				var d30209OffsetNormals = d30209OffsetNormal.split(";");
				d30209OffsetNormals_left = d30209OffsetNormals[0];
				d30209OffsetNormals_top = d30209OffsetNormals[1];
				createDiv(birthInfos[14], symbol, d30209OffsetNormals_left, d30209OffsetNormals_top);
			}
		} else if(d30209Value == "3") {
			var d30209OffsetBad = jsonStr[birthInfos[15]];
			if(d30209OffsetBad != undefined) {
				var d30209OffsetBads = d30209OffsetBad.split(";");
				d30209OffsetBads_left = d30209OffsetBads[0];
				d30209OffsetBads_top = d30209OffsetBads[1];
				createDiv(birthInfos[15], symbol, d30209OffsetBads_left, d30209OffsetBads_top);
			}
		}
		
		var d30229Offset = jsonStr[birthInfos[16]];
		if(d30229Offset != undefined) {
			var d30229Offsets = d30229Offset.split(";");
			var d30229Offsets_left = d30229Offsets[0];
			var d30229Offsets_top = d30229Offsets[1];
			var d30229Value = vd302[birthInfos[16]];
			createDiv(birthInfos[16], d30229Value, d30229Offsets_left, d30229Offsets_top);
		}
		
		var d30208Offset = jsonStr[birthInfos[17]];
		if(d30208Offset != undefined) {
			var d30208Offsets = d30208Offset.split(";");
			var d30208Offsets_left = d30208Offsets[0];
			var d30208Offsets_top = d30208Offsets[1];
			var d30208Value = vd302[birthInfos[17]];
			createDiv(birthInfos[17], d30208Value, d30208Offsets_left, d30208Offsets_top);
		}
		
		var d30211Offset = jsonStr[birthInfos[18]];
		if(d30211Offset != undefined) {
			var d30211Offsets = d30211Offset.split(";");
			var d30211Offsets_left = d30211Offsets[0];
			var d30211Offsets_top = d30211Offsets[1];
			var d30211Value = vd302[birthInfos[18]];
			createDiv(birthInfos[18], d30211Value, d30211Offsets_left, d30211Offsets_top);
		}
		
		var d30213Offset = jsonStr[birthInfos[19]];
		if(d30213Offset != undefined) {
			var d30213Offsets = d30213Offset.split(";");
			var d30213Offsets_left = d30213Offsets[0];
			var d30213Offsets_top = d30213Offsets[1];
			var d30213Value = vd302[birthInfos[19]];
			createDiv(birthInfos[19], d30213Value, d30213Offsets_left, d30213Offsets_top);
		}
		
		var d30214ZhOffset = jsonStr[birthInfos[20]];
		if(d30214ZhOffset != undefined) {
			var d30214ZhOffsets = d30214ZhOffset.split(";");
			var d30214ZhOffsets_left = d30214ZhOffsets[0];
			var d30214ZhOffsets_top = d30214ZhOffsets[1];
			var d30214ZhValue = vd302[birthInfos[20]];
			createDiv(birthInfos[20], d30214ZhValue, d30214ZhOffsets_left, d30214ZhOffsets_top);
		}
		
		var d30215ZhOffset = jsonStr[birthInfos[21]];
		if(d30215ZhOffset != undefined) {
			var d30215ZhOffsets = d30215ZhOffset.split(";");
			var d30215ZhOffsets_left = d30215ZhOffsets[0];
			var d30215ZhOffsets_top = d30215ZhOffsets[1];
			var d30215ZhValue = vd302[birthInfos[21]];
			createDiv(birthInfos[21], d30215ZhValue, d30215ZhOffsets_left, d30215ZhOffsets_top);
		}
		
		var d30212Offset = jsonStr[birthInfos[22]];
		if(d30212Offset != undefined) {
			var d30212Offsets = d30212Offset.split(";");
			var d30212Offsets_left = d30212Offsets[0];
			var d30212Offsets_top = d30212Offsets[1];
			var d30212Value = vd302[birthInfos[22]];
			createDiv(birthInfos[22], d30212Value, d30212Offsets_left, d30212Offsets_top);
		}
		
		var d30216Offset = jsonStr[birthInfos[23]];
		if(d30216Offset != undefined) {
			var d30216Offsets = d30216Offset.split(";");
			var d30216Offsets_left = d30216Offsets[0];
			var d30216Offsets_top = d30216Offsets[1];
			var d30216Value = vd302[birthInfos[23]];
			createDiv(birthInfos[23], d30216Value, d30216Offsets_left, d30216Offsets_top);
		}
		
		var d30218Offset = jsonStr[birthInfos[24]];
		if(d30218Offset != undefined) {
			var d30218Offsets = d30218Offset.split(";");
			var d30218Offsets_left = d30218Offsets[0];
			var d30218Offsets_top = d30218Offsets[1];
			var d30218Value = vd302[birthInfos[24]];
			createDiv(birthInfos[24], d30218Value, d30218Offsets_left, d30218Offsets_top);
		}
		
		var d30219Offset = jsonStr[birthInfos[25]];
		if(d30219Offset != undefined) {
			var d30219Offsets = d30219Offset.split(";");
			var d30219Offsets_left = d30219Offsets[0];
			var d30219Offsets_top = d30219Offsets[1];
			var d30219Value = vd302[birthInfos[25]];
			createDiv(birthInfos[25], d30219Value, d30219Offsets_left, d30219Offsets_top);
		}
		
		var d30220Offset = jsonStr[birthInfos[26]];
		if(d30220Offset != undefined) {
			var d30220Offsets = d30220Offset.split(";");
			var d30220Offsets_left = d30220Offsets[0];
			var d30220Offsets_top = d30220Offsets[1];
			var d30220Value = vd302[birthInfos[26]];
			createDiv(birthInfos[26], d30220Value, d30220Offsets_left, d30220Offsets_top);
		}
		
		var d30217Offset = jsonStr[birthInfos[27]];
		if(d30217Offset != undefined) {
			var d30217Offsets = d30217Offset.split(";");
			var d30217Offsets_left = d30217Offsets[0];
			var d30217Offsets_top = d30217Offsets[1];
			var d30217Value = vd302[birthInfos[27]];
			createDiv(birthInfos[27], d30217Value, d30217Offsets_left, d30217Offsets_top);
		}
		
		var d30222Value = vd302[birthInfos[28]];
		if(d30222Value == "1") {
			var d30222OffsetHospital = jsonStr[birthInfos[28]];
			if(d30222OffsetHospital != undefined) {
				var d30222OffsetHospitals = d30222OffsetHospital.split(";");
				d30222OffsetHospitals_left = d30222OffsetHospitals[0];
				d30222OffsetHospitals_top = d30222OffsetHospitals[1];
				createDiv(birthInfos[28], symbol, d30222OffsetHospitals_left, d30222OffsetHospitals_top);
			}
		} else if(d30222Value == "2") {
			var d30222OffsetHealth = jsonStr[birthInfos[29]];
			if(d30222OffsetHealth != undefined) {
				var d30222OffsetHealths = d30222OffsetHealth.split(";");
				d30222OffsetHealths_left = d30222OffsetHealths[0];
				d30222OffsetHealths_top = d30222OffsetHealths[1];
				createDiv(birthInfos[29], symbol, d30222OffsetHealths_left, d30222OffsetHealths_top);
			}
		}else if(d30222Value == "3"){
			var d30222OffsetFamily = jsonStr[birthInfos[30]];
			if(d30222OffsetFamily != undefined) {
				var d30222OffsetFamilys = d30222OffsetFamily.split(";");
				d30222OffsetFamilys_left = d30222OffsetFamilys[0];
				d30222OffsetFamilys_top = d30222OffsetFamilys[1];
				createDiv(birthInfos[30], symbol, d30222OffsetFamilys_left, d30222OffsetFamilys_top);
			}
		} else if(d30222Value == "4") {
			var d30222OffsetOther = jsonStr[birthInfos[31]];
			if(d30222OffsetOther != undefined) {
				var d30222OffsetOthers = d30222OffsetOther.split(";");
				d30222OffsetOthers_left = d30222OffsetOthers[0];
				d30222OffsetOthers_top = d30222OffsetOthers[1];
				createDiv(birthInfos[31], symbol, d30222OffsetOthers_left, d30222OffsetOthers_top);
			}
			
			var d30223Offset = jsonStr[birthInfos[32]];
			if(d30223Offset != undefined) {
				var d30223Offsets = d30223Offset.split(";");
				d30223Offsets_left = d30223Offsets[0];
				d30223Offsets_top = d30223Offsets[1];
				createDiv(birthInfos[32], vd302[birthInfos[32]], d30223Offsets_left, d30223Offsets_top);
			}
		}
		
		var d30224Offset = jsonStr[birthInfos[33]];
		if(d30224Offset != undefined) {
			var d30224Offsets = d30224Offset.split(";");
			var d30224Offsets_left = d30224Offsets[0];
			var d30224Offsets_top = d30224Offsets[1];
			var d30224Value = vd302[birthInfos[33]];
			createDiv(birthInfos[33], d30224Value, d30224Offsets_left, d30224Offsets_top);
		}
		
		var d30228Value = vd302[birthInfos[34]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30228Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30228OffsetYear = jsonStr[birthInfos[34]];
		if(d30228OffsetYear != undefined) {
			var d30228OffsetYears = d30228OffsetYear.split(";");
			var d30228OffsetYear_left = d30228OffsetYears[0];
			var d30228OffsetYear_top = d30228OffsetYears[1];
			createDiv(birthInfos[34], yearS, d30228OffsetYear_left, d30228OffsetYear_top);
		}
		
		var d30228OffsetMonth = jsonStr[birthInfos[35]];
		if(d30228OffsetMonth != undefined) {
			var d30228OffsetMonths = d30228OffsetMonth.split(";");
			var d30228OffsetMonths_left = d30228OffsetMonths[0];
			var d30228OffsetMonths_top = d30228OffsetMonths[1];
			createDiv(birthInfos[35], monthS, d30228OffsetMonths_left, d30228OffsetMonths_top);
		}
		
		var d30228OffsetDate = jsonStr[birthInfos[36]];
		if(d30228OffsetDate != undefined) {
			var d30228OffsetDates = d30228OffsetDate.split(";");
			var d30228OffsetDates_left = d30228OffsetDates[0];
			var d30228OffsetDates_top = d30228OffsetDates[1];
			createDiv(birthInfos[36], dateS, d30228OffsetDates_left, d30228OffsetDates_top);
		}
	}, "json");
	
	$.post(contextRoot + "/PrintBirthInfoHfServlet", {"flag":"BIRTH_PRINTINFO_SECOND_HF","d30210":d30210}, function(dataVd302S){
		var jsonStrS = dataVd302S[0];
		var vd302S = dataVd302S[1];
		
		var birthInfosS = birthInfo[1].split(";");

		var birthInfosd30202OSffset = jsonStrS[birthInfosS[0]];
		if(birthInfosd30202OSffset != undefined) {
			var d30202SOffset = birthInfosd30202OSffset.split(";");
			var d30202SOffset_left = d30202SOffset[0];
			var d30202SOffset_top = d30202SOffset[1];
			var d30202SValue = vd302S[birthInfosS[0]];
			createDiv(birthInfosS[0], d30202SValue, d30202SOffset_left, d30202SOffset_top);
		}
		var birthInfosd30203OZhSffset = jsonStrS[birthInfosS[1]];
		if(birthInfosd30203OZhSffset != undefined){
			var d30203ZhSOffset = birthInfosd30203OZhSffset.split(";");
			var d30203ZhSOffset_left = d30203ZhSOffset[0];
			var d30203ZhSOffset_top = d30203ZhSOffset[1];
			var d30203ZhSValue = vd302S[birthInfosS[1]];
			createDiv(birthInfosS[1], d30203ZhSValue, d30203ZhSOffset_left, d30203ZhSOffset_top);
		}
		
		var d30204SValue = vd302S[birthInfosS[2]];
		var regsS = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/;  
		var timeVsS = "";
		var yearsS = "";
		var monthsS = "";
		var datesS = "";
		var hourS = "";
		var minuteS = "";
		if(d30204SValue != ""){
			timeVsS = regsS.exec(d30204SValue);
			yearsS = timeVsS[1];
			monthsS = timeVsS[2];
			datesS = timeVsS[3];
			hourS = timeVsS[4];
			minuteS = timeVsS[5];
		}
		
		var d30204SOffsetYear = jsonStrS[birthInfosS[2]];
		var d30204SOffsetYears = d30204SOffsetYear.split(";");
		var d30204SOffsetYear_left = d30204SOffsetYears[0];
		var d30204SOffsetYear_top = d30204SOffsetYears[1];
		
		var d30204SOffsetMonth = jsonStrS[birthInfosS[3]];
		var d30204SOffsetMonths = d30204SOffsetMonth.split(";");
		var d30204SOffsetMonth_left = d30204SOffsetMonths[0];
		var d30204SOffsetMonth_top = d30204SOffsetMonths[1];
		
		var d30204SOffsetDate = jsonStrS[birthInfosS[4]];
		var d30204SOffsetDates = d30204SOffsetDate.split(";");
		var d30204SOffsetDate_left = d30204SOffsetDates[0];
		var d30204SOffsetDate_top = d30204SOffsetDates[1];
		
		var d30204SOffsetHour = jsonStrS[birthInfosS[5]];
		var d30204SOffsetHours = d30204SOffsetHour.split(";");
		var d30204SOffsetHour_left = d30204SOffsetHours[0];
		var d30204SOffsetHour_top = d30204SOffsetHours[1];
		
		var d30204SOffsetMinute = jsonStrS[birthInfosS[6]];
		var d30204SOffsetMinutes = d30204SOffsetMinute.split(";");
		var d30204SOffsetMinute_left = d30204SOffsetMinutes[0];
		var d30204SOffsetMinute_top = d30204SOffsetMinutes[1];
		
		if(d30204SOffsetYears != undefined){
			createDiv(birthInfosS[2], yearsS, d30204SOffsetYear_left, d30204SOffsetYear_top);
		}
		if(d30204SOffsetMonth != undefined){
			createDiv(birthInfosS[3], monthsS, d30204SOffsetMonth_left, d30204SOffsetMonth_top);
		}
		if(d30204SOffsetDate != undefined){
			createDiv(birthInfosS[4], datesS, d30204SOffsetDate_left, d30204SOffsetDate_top);
		}
		if(d30204SOffsetHour != undefined){
			createDiv(birthInfosS[5], hourS, d30204SOffsetHour_left, d30204SOffsetHour_top);
		}
		if(d30204SOffsetMinute != undefined){
			createDiv(birthInfosS[6], minuteS, d30204SOffsetMinute_left, d30204SOffsetMinute_top);
		}
		
		var birthInfosd30205ZhSffset = jsonStrS[birthInfosS[7]];
		if(birthInfosd30205ZhSffset != undefined){
			var d30205ZhSOffset = birthInfosd30205ZhSffset.split(";");
			var d30205ZhSOffset_left = d30205ZhSOffset[0];
			var d30205ZhSOffset_top = d30205ZhSOffset[1];
			var d30205ZhSValue = vd302S[birthInfosS[7]];
			createDiv(birthInfosS[7], d30205ZhSValue, d30205ZhSOffset_left, d30205ZhSOffset_top);
		}
		
		var birthInfosd30211Sffset = jsonStrS[birthInfosS[8]];
		if(birthInfosd30211Sffset != undefined){
			var d30211Sffset = birthInfosd30211Sffset.split(";");
			var d30211Sffset_left = d30211Sffset[0];
			var d30211Sffset_top = d30211Sffset[1];
			var d30211SValue = vd302S[birthInfosS[8]];
			createDiv(birthInfosS[8], d30211SValue, d30211Sffset_left, d30211Sffset_top);
		}
		
		var birthInfosd30213Sffset = jsonStrS[birthInfosS[9]];
		if(birthInfosd30213Sffset != undefined){
			var d30213Sffset = birthInfosd30213Sffset.split(";");
			var d30213Sffset_left = d30213Sffset[0];
			var d30213Sffset_top = d30213Sffset[1];
			var d30213SValue = vd302S[birthInfosS[9]];
			createDiv(birthInfosS[9], d30213SValue, d30213Sffset_left, d30213Sffset_top);
		}
		
		var birthInfosd30214ZhSffset = jsonStrS[birthInfosS[10]];
		if(birthInfosd30214ZhSffset != undefined){
			var d30214ZhSOffset = birthInfosd30214ZhSffset.split(";");
			var d30214ZhSOffset_left = d30214ZhSOffset[0];
			var d30214ZhSOffset_top = d30214ZhSOffset[1];
			var d30214ZhSValue = vd302S[birthInfosS[10]];
			createDiv(birthInfosS[10], d30214ZhSValue, d30214ZhSOffset_left, d30214ZhSOffset_top);
		}
		
		var birthInfosd30215ZhSffset = jsonStrS[birthInfosS[11]];
		if(birthInfosd30215ZhSffset != undefined){
			var d30215ZhSOffset = birthInfosd30215ZhSffset.split(";");
			var d30215ZhSOffset_left = d30215ZhSOffset[0];
			var d30215ZhSOffset_top = d30215ZhSOffset[1];
			var d30215ZhSValue = vd302S[birthInfosS[11]];
			createDiv(birthInfosS[11], d30215ZhSValue, d30215ZhSOffset_left, d30215ZhSOffset_top);
		}
		
		var birthInfosd30212Sffset = jsonStrS[birthInfosS[12]];
		if(birthInfosd30212Sffset != undefined){
			var d30212Sffset = birthInfosd30212Sffset.split(";");
			var d30212Sffset_left = d30212Sffset[0];
			var d30212Sffset_top = d30212Sffset[1];
			var d30212SValue = vd302S[birthInfosS[12]];
			createDiv(birthInfosS[12], d30212SValue, d30212Sffset_left, d30212Sffset_top);
		}
		
		var birthInfosd30216Sffset = jsonStrS[birthInfosS[13]];
		if(birthInfosd30216Sffset != undefined){
			var d30216Sffset = birthInfosd30216Sffset.split(";");
			var d30216Sffset_left = d30216Sffset[0];
			var d30216Sffset_top = d30216Sffset[1];
			var d30216SValue = vd302S[birthInfosS[13]];
			createDiv(birthInfosS[13], d30216SValue, d30216Sffset_left, d30216Sffset_top);
		}
		
		var birthInfosd30218Sffset = jsonStrS[birthInfosS[14]];
		if(birthInfosd30218Sffset != undefined){
			var d30218Sffset = birthInfosd30218Sffset.split(";");
			var d30218Sffset_left = d30218Sffset[0];
			var d30218Sffset_top = d30218Sffset[1];
			var d30218SValue = vd302S[birthInfosS[14]];
			createDiv(birthInfosS[14], d30218SValue, d30218Sffset_left, d30218Sffset_top);
		}
		
		var birthInfosd30219ZhSffset = jsonStrS[birthInfosS[15]];
		if(birthInfosd30219ZhSffset != undefined){
			var d30219ZhSOffset = birthInfosd30219ZhSffset.split(";");
			var d30219ZhSOffset_left = d30219ZhSOffset[0];
			var d30219ZhSOffset_top = d30219ZhSOffset[1];
			var d30219ZhSValue = vd302S[birthInfosS[15]];
			createDiv(birthInfosS[15], d30219ZhSValue, d30219ZhSOffset_left, d30219ZhSOffset_top);
		}
		
		var birthInfosd30220ZhSffset = jsonStrS[birthInfosS[16]];
		if(birthInfosd30220ZhSffset != undefined){
			var d30220ZhSOffset = birthInfosd30220ZhSffset.split(";");
			var d30220ZhSOffset_left = d30220ZhSOffset[0];
			var d30220ZhSOffset_top = d30220ZhSOffset[1];
			var d30220ZhSValue = vd302S[birthInfosS[16]];
			createDiv(birthInfosS[16], d30220ZhSValue, d30220ZhSOffset_left, d30220ZhSOffset_top);
		}
		
		var birthInfosd30217Sffset = jsonStrS[birthInfosS[17]];
		if(birthInfosd30217Sffset != undefined){
			var d30217Sffset = birthInfosd30217Sffset.split(";");
			var d30217Sffset_left = d30217Sffset[0];
			var d30217Sffset_top = d30217Sffset[1];
			var d30217SValue = vd302S[birthInfosS[17]];
			createDiv(birthInfosS[17], d30217SValue, d30217Sffset_left, d30217Sffset_top);
		}
		
		var birthInfosd30221Sffset = jsonStrS[birthInfosS[18]];
		if(birthInfosd30221Sffset != undefined){
			var d30221Sffset = birthInfosd30221Sffset.split(";");
			var d30221Sffset_left = d30221Sffset[0];
			var d30221Sffset_top = d30221Sffset[1];
			var d30221SValue = vd302S[birthInfosS[18]];
			createDiv(birthInfosS[18], d30221SValue, d30221Sffset_left, d30221Sffset_top);
		}
		
		var d30228SValue = vd302S[birthInfosS[19]];
		var regd30228S = /(\d{4})-(\d{2})-(\d{2})/; 
		var timed30228S = regd30228S.exec(d30228SValue);
		var yeard30228S = timed30228S[1];
		var monthd30228S = timed30228S[2];
		var dated30228S = timed30228S[3];
		
		var d30228SOffsetYear = jsonStrS[birthInfosS[19]];
		var d30228SOffsetYears = d30228SOffsetYear.split(";");
		var d30228SOffsetYear_left = d30228SOffsetYears[0];
		var d30228SOffsetYear_top = d30228SOffsetYears[1];
		if(d30228SOffsetYear != undefined){
			createDiv(birthInfosS[19], yeard30228S, d30228SOffsetYear_left, d30228SOffsetYear_top);
		}
		
		var d30228SOffsetMonth = jsonStrS[birthInfosS[20]];
		var d30228SOffsetMonths = d30228SOffsetMonth.split(";");
		var d30228SOffsetMonth_left = d30228SOffsetMonths[0];
		var d30228SOffsetMonth_top = d30228SOffsetMonths[1];
		if(d30228SOffsetMonth != undefined){
			createDiv(birthInfosS[20], monthd30228S, d30228SOffsetMonth_left, d30228SOffsetMonth_top);
		}
		
		var d30228SOffsetDate = jsonStrS[birthInfosS[21]];
		var d30228SOffsetDates = d30228SOffsetDate.split(";");
		var d30228SOffsetDate_left = d30228SOffsetDates[0];
		var d30228SOffsetDate_top = d30228SOffsetDates[1];
		if(d30228SOffsetDate != undefined){
			createDiv(birthInfosS[21], dated30228S, d30228SOffsetDate_left, d30228SOffsetDate_top);
		}
	}, "json");
	
	$.post(contextRoot + "/PrintBirthInfoHfServlet", {"flag":"BIRTH_PRINTINFO_THIRD_HF","d30210":d30210}, function(dataVd302T){
		var jsonStrT = dataVd302T[0];
		var vd302T = dataVd302T[1];
		
		var birthInfosT = birthInfo[2].split(";");
		
		var birthInfosd30202OTffset = jsonStrT[birthInfosT[0]];
		if(birthInfosd30202OTffset != undefined) {
			var d30202TOffset = birthInfosd30202OTffset.split(";");
			var d30202TOffset_left = d30202TOffset[0];
			var d30202TOffset_top = d30202TOffset[1];
			var d30202TValue = vd302T[birthInfosT[0]];
			createDiv(birthInfosT[0], d30202TValue, d30202TOffset_left, d30202TOffset_top);
		}
		
		var birthInfosd30203OZhTffset = jsonStrT[birthInfosT[1]];
		if(birthInfosd30203OZhTffset != undefined){
			var d30203ZhTOffset = birthInfosd30203OZhTffset.split(";");
			var d30203ZhTOffset_left = d30203ZhTOffset[0];
			var d30203ZhTOffset_top = d30203ZhTOffset[1];
			var d30203ZhTValue = vd302T[birthInfosT[1]];
			createDiv(birthInfosT[1], d30203ZhTValue, d30203ZhTOffset_left, d30203ZhTOffset_top);
		}
		
		var d30204TValue = vd302T[birthInfosT[2]];
		var regsT = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/;  
		var timeVsT = "";
		var yearsT = "";
		var monthsT = "";
		var datesT = "";
		var hourT = "";
		var minuteT = "";
		if(d30204TValue != ""){
			timeVsT = regsT.exec(d30204TValue);
			yearsT = timeVsT[1];
			monthsT = timeVsT[2];
			datesT = timeVsT[3];
			hourT = timeVsT[4];
			minuteT = timeVsT[5];
		}
		
		var d30204TOffsetYear = jsonStrT[birthInfosT[2]];
		var d30204TOffsetYears = d30204TOffsetYear.split(";");
		var d30204TOffsetYear_left = d30204TOffsetYears[0];
		var d30204TOffsetYear_top = d30204TOffsetYears[1];
		
		var d30204TOffsetMonth = jsonStrT[birthInfosT[3]];
		var d30204TOffsetMonths = d30204TOffsetMonth.split(";");
		var d30204TOffsetMonth_left = d30204TOffsetMonths[0];
		var d30204TOffsetMonth_top = d30204TOffsetMonths[1];
		
		var d30204TOffsetDate = jsonStrT[birthInfosT[4]];
		var d30204TOffsetDates = d30204TOffsetDate.split(";");
		var d30204TOffsetDate_left = d30204TOffsetDates[0];
		var d30204TOffsetDate_top = d30204TOffsetDates[1];
		
		var d30204TOffsetHour = jsonStrT[birthInfosT[5]];
		var d30204TOffsetHours = d30204TOffsetHour.split(";");
		var d30204TOffsetHour_left = d30204TOffsetHours[0];
		var d30204TOffsetHour_top = d30204TOffsetHours[1];
		
		var d30204TOffsetMinute = jsonStrT[birthInfosT[6]];
		var d30204TOffsetMinutes = d30204TOffsetMinute.split(";");
		var d30204TOffsetMinute_left = d30204TOffsetMinutes[0];
		var d30204TOffsetMinute_top = d30204TOffsetMinutes[1];
		
		if(d30204TOffsetYears != undefined){
			createDiv(birthInfosT[2], yearsT, d30204TOffsetYear_left, d30204TOffsetYear_top);
		}
		if(d30204TOffsetMonth != undefined){
			createDiv(birthInfosT[3], monthsT, d30204TOffsetMonth_left, d30204TOffsetMonth_top);
		}
		if(d30204TOffsetDate != undefined){
			createDiv(birthInfosT[4], datesT, d30204TOffsetDate_left, d30204TOffsetDate_top);
		}
		if(d30204TOffsetHour != undefined){
			createDiv(birthInfosT[5], hourT, d30204TOffsetHour_left, d30204TOffsetHour_top);
		}
		if(d30204TOffsetMinute != undefined){
			createDiv(birthInfosT[6], minuteT, d30204TOffsetMinute_left, d30204TOffsetMinute_top);
		}
		
		var birthInfosd30205ZhTffset = jsonStrT[birthInfosT[7]];
		if(birthInfosd30205ZhTffset != undefined){
			var d30205ZhTOffset = birthInfosd30205ZhTffset.split(";");
			var d30205ZhTOffset_left = d30205ZhTOffset[0];
			var d30205ZhTOffset_top = d30205ZhTOffset[1];
			var d30205ZhTValue = vd302T[birthInfosT[7]];
			createDiv(birthInfosT[7], d30205ZhTValue, d30205ZhTOffset_left, d30205ZhTOffset_top);
		}
		
		var birthInfosd30211Tffset = jsonStrT[birthInfosT[8]];
		if(birthInfosd30211Tffset != undefined){
			var d30211Tffset = birthInfosd30211Tffset.split(";");
			var d30211Tffset_left = d30211Tffset[0];
			var d30211Tffset_top = d30211Tffset[1];
			var d30211TValue = vd302T[birthInfosT[8]];
			createDiv(birthInfosT[8], d30211TValue, d30211Tffset_left, d30211Tffset_top);
		}
		
		var birthInfosd30213Tffset = jsonStrT[birthInfosT[9]];
		if(birthInfosd30213Tffset != undefined){
			var d30213Tffset = birthInfosd30213Tffset.split(";");
			var d30213Tffset_left = d30213Tffset[0];
			var d30213Tffset_top = d30213Tffset[1];
			var d30213TValue = vd302T[birthInfosT[9]];
			createDiv(birthInfosT[9], d30213TValue, d30213Tffset_left, d30213Tffset_top);
		}
		
		var birthInfosd30214ZhTffset = jsonStrT[birthInfosT[10]];
		if(birthInfosd30214ZhTffset != undefined){
			var d30214ZhTOffset = birthInfosd30214ZhTffset.split(";");
			var d30214ZhTOffset_left = d30214ZhTOffset[0];
			var d30214ZhTOffset_top = d30214ZhTOffset[1];
			var d30214ZhTValue = vd302T[birthInfosT[10]];
			createDiv(birthInfosT[10], d30214ZhTValue, d30214ZhTOffset_left, d30214ZhTOffset_top);
		}
		
		var birthInfosd30215ZhTffset = jsonStrT[birthInfosT[11]];
		if(birthInfosd30215ZhTffset != undefined){
			var d30215ZhTOffset = birthInfosd30215ZhTffset.split(";");
			var d30215ZhTOffset_left = d30215ZhTOffset[0];
			var d30215ZhTOffset_top = d30215ZhTOffset[1];
			var d30215ZhTValue = vd302T[birthInfosT[11]];
			createDiv(birthInfosT[11], d30215ZhTValue, d30215ZhTOffset_left, d30215ZhTOffset_top);
		}
		
		var birthInfosd30212Tffset = jsonStrT[birthInfosT[12]];
		if(birthInfosd30212Tffset != undefined){
			var d30212Tffset = birthInfosd30212Tffset.split(";");
			var d30212Tffset_left = d30212Tffset[0];
			var d30212Tffset_top = d30212Tffset[1];
			var d30212TValue = vd302T[birthInfosT[12]];
			createDiv(birthInfosT[12], d30212TValue, d30212Tffset_left, d30212Tffset_top);
		}
		
		var birthInfosd30216Tffset = jsonStrT[birthInfosT[13]];
		if(birthInfosd30216Tffset != undefined){
			var d30216Tffset = birthInfosd30216Tffset.split(";");
			var d30216Tffset_left = d30216Tffset[0];
			var d30216Tffset_top = d30216Tffset[1];
			var d30216TValue = vd302T[birthInfosT[13]];
			createDiv(birthInfosT[13], d30216TValue, d30216Tffset_left, d30216Tffset_top);
		}
		
		var birthInfosd30218Tffset = jsonStrT[birthInfosT[14]];
		if(birthInfosd30218Tffset != undefined){
			var d30218Tffset = birthInfosd30218Tffset.split(";");
			var d30218Tffset_left = d30218Tffset[0];
			var d30218Tffset_top = d30218Tffset[1];
			var d30218TValue = vd302T[birthInfosT[14]];
			createDiv(birthInfosT[14], d30218TValue, d30218Tffset_left, d30218Tffset_top);
		}
		
		var birthInfosd30219ZhTffset = jsonStrT[birthInfosT[15]];
		if(birthInfosd30219ZhTffset != undefined){
			var d30219ZhTOffset = birthInfosd30219ZhTffset.split(";");
			var d30219ZhTOffset_left = d30219ZhTOffset[0];
			var d30219ZhTOffset_top = d30219ZhTOffset[1];
			var d30219ZhTValue = vd302T[birthInfosT[15]];
			createDiv(birthInfosT[15], d30219ZhTValue, d30219ZhTOffset_left, d30219ZhTOffset_top);
		}
		
		var birthInfosd30220ZhTffset = jsonStrT[birthInfosT[16]];
		if(birthInfosd30220ZhTffset != undefined){
			var d30220ZhTOffset = birthInfosd30220ZhTffset.split(";");
			var d30220ZhTOffset_left = d30220ZhTOffset[0];
			var d30220ZhTOffset_top = d30220ZhTOffset[1];
			var d30220ZhTValue = vd302T[birthInfosT[16]];
			createDiv(birthInfosT[16], d30220ZhTValue, d30220ZhTOffset_left, d30220ZhTOffset_top);
		}
		
		var birthInfosd30217Tffset = jsonStrT[birthInfosT[17]];
		if(birthInfosd30217Tffset != undefined){
			var d30217Tffset = birthInfosd30217Tffset.split(";");
			var d30217Tffset_left = d30217Tffset[0];
			var d30217Tffset_top = d30217Tffset[1];
			var d30217TValue = vd302T[birthInfosT[17]];
			createDiv(birthInfosT[17], d30217TValue, d30217Tffset_left, d30217Tffset_top);
		}
		
		var birthInfosd30221Tffset = jsonStrT[birthInfosT[18]];
		if(birthInfosd30221Tffset != undefined){
			var d30221Tffset = birthInfosd30221Tffset.split(";");
			var d30221Tffset_left = d30221Tffset[0];
			var d30221Tffset_top = d30221Tffset[1];
			var d30221TValue = vd302T[birthInfosT[18]];
			createDiv(birthInfosT[18], d30221TValue, d30221Tffset_left, d30221Tffset_top);
		}
		
		var d30228TValue = vd302T[birthInfosT[19]];
		var regd30228T = /(\d{4})-(\d{2})-(\d{2})/; 
		var timed30228T = regd30228T.exec(d30228TValue);
		var yeard30228T = timed30228T[1];
		var monthd30228T = timed30228T[2];
		var dated30228T = timed30228T[3];
		
		var d30228TOffsetYear = jsonStrT[birthInfosT[19]];
		var d30228TOffsetYears = d30228TOffsetYear.split(";");
		var d30228TOffsetYear_left = d30228TOffsetYears[0];
		var d30228TOffsetYear_top = d30228TOffsetYears[1];
		if(d30228TOffsetYear != undefined){
			createDiv(birthInfosT[19], yeard30228T, d30228TOffsetYear_left, d30228TOffsetYear_top);
		}
		
		var d30228TOffsetMonth = jsonStrT[birthInfosT[20]];
		var d30228TOffsetMonths = d30228TOffsetMonth.split(";");
		var d30228TOffsetMonth_left = d30228TOffsetMonths[0];
		var d30228TOffsetMonth_top = d30228TOffsetMonths[1];
		if(d30228TOffsetMonth != undefined){
			createDiv(birthInfosT[20], monthd30228T, d30228TOffsetMonth_left, d30228TOffsetMonth_top);
		}
		
		var d30228TOffsetDate = jsonStrT[birthInfosT[21]];
		var d30228TOffsetDates = d30228TOffsetDate.split(";");
		var d30228TOffsetDate_left = d30228TOffsetDates[0];
		var d30228TOffsetDate_top = d30228TOffsetDates[1];
		if(d30228TOffsetDate != undefined){
			createDiv(birthInfosT[21], dated30228T, d30228TOffsetDate_left, d30228TOffsetDate_top);
		}
	}, "json");
});

function createDiv(id, value, offset_left, offset_top)
{
	$("body").append($("<div></div>").attr("id", id).text(value));
	if(id == "d30212" || id == "d30217") {
		$("#" + id).css({"letter-spacing":"7.6px"});
	}
	$("#" + id).css({"position":"absolute", "font-size":"12px"});
	$("#" + id).offset({left:offset_left, top:offset_top});
}