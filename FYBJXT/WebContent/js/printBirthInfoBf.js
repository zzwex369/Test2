 var contextRoot = "/csyxzm";
$(document).ready(function(){
	
	var printInfo = new Array();
	var printInfoLabel  = new Array();
	var birthInfo = new Array();
	var birthInfoLabel = new Array();

	printInfo[0] = "BIRTH_PRINTINFO_BF";
	printInfoLabel[0] = "出生证明";

	printInfo[1] = "BIRTH_PRINTINFO_SECOND_BF";
	printInfoLabel[1] = "副页";
	
	printInfo[2] = "BIRTH_PRINTINFO_THIRD_BF";
	printInfoLabel[2] = "存根";
	
	birthInfo[0] = "d30302;d30303;a03;d30304;a05;a06;a07;a08;d30305;a10;a11;a12;d30307;d30309;a15;a16;d30329;d30308;d30311;d30313;d30314Zh;d30315Zh;d30312;d30316;d30318;d30319Zh;d30320Zh;d30317;d30322;a30;a31;a32;d30323;d30324Zh;d30328;a36;a37";
	birthInfoLabel[0] = "新生儿姓名;男;女;年;月;日;时;分;省;市;县;乡;孕周;良好;一般;差;体重;身长;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲身份证号;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲身份证号;医院;保健院;家庭;其他;其它;接生机构;签发年;签发月;签发日";
	
	birthInfo[1] = "d30302S;d30303ZhS;d30304S;s05;s06;s07;s08;d30305ZhS;d30311S;d30313S;d30314ZhS;d30315ZhS;d30312S;d30316S;d30318S;d30319ZhS;d30320ZhS;d30317S;d30321S;d30328S;s36;s37";
	birthInfoLabel[1] = "婴儿姓名;性别;年;月;日;时;分;出生地点;母亲姓名;母亲年龄;母亲国籍;母亲民族;身份证;父亲姓名;父亲年龄;父亲国籍;父亲民族;身份证;家庭住址;签发年;签发月;签发日";
	
	birthInfo[2] = "d30302T;d30303ZhT;d30304T;t05;t06;t07;t08;d30305ZhT;d30311T;d30313T;d30314ZhT;d30315ZhT;d30312T;d30316T;d30318T;d30319ZhT;d30320ZhT;d30317T;d30321T;d30328T;t36;t37";
	birthInfoLabel[2] = "婴儿姓名;性别;年;月;日;时;分;出生地点;母亲姓名;母亲年龄;母亲国籍;母亲民族;身份证;父亲姓名;父亲年龄;父亲国籍;父亲民族;身份证;家庭住址;签发年;签发月;签发日";
	
	var d30310 = $("#d30310").val();
	$.post(contextRoot + "/PrintBirthInfoBfServlet", {"flag":"BIRTH_PRINTINFO_BF","d30310":d30310}, function(data){
		var jsonStr = data[0];
		var vd303 = data[1];
		var symbol = "√";
		
		var birthInfos = birthInfo[0].split(";");
		var birthInfosd30302Offset = jsonStr[birthInfos[0]];
		if(birthInfosd30302Offset != undefined) {
			var d30302Offset = birthInfosd30302Offset.split(";");
			var d30302Offset_left = d30302Offset[0];
			var d30302Offset_top = d30302Offset[1];
			var d30302Value = vd303[birthInfos[0]];
			createDiv(birthInfos[0], d30302Value, d30302Offset_left, d30302Offset_top);
		}
		
		var d30303Value = vd303[birthInfos[1]];
		var birthInfosd30303Offset = "";
		if(d30303Value == "1") {
			birthInfosd30303Offset = jsonStr[birthInfos[1]];
		} else if(d30303Value == "2") {
			birthInfosd30303Offset = jsonStr[birthInfos[2]];
		} 
		if(birthInfosd30303Offset != "") {
			var d30303Offset = birthInfosd30303Offset.split(";");
			var d30303Offset_left = d30303Offset[0];
			var d30303Offset_top = d30303Offset[1];
			createDiv(birthInfos[1], symbol, d30303Offset_left, d30303Offset_top);
		}
		
		var d30304Value = vd303[birthInfos[3]];
		var reg = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/; 
		var timeV = "";
		var year = "";
		var month = "";
		var date = "";
		var hour = "";
		var minute = "";
		
		if(d30304Value != "")
		{
			timeV = reg.exec(d30304Value);
			year = timeV[1];
			month = timeV[2];
			date = timeV[3];
			hour = timeV[4];
			minute = timeV[5];
		}
		
		var d30304Offset = jsonStr[birthInfos[3]];
		if(d30304Offset != undefined) {
			var d30304Offsets = d30304Offset.split(";");
			var d30304Offset_left = d30304Offsets[0];
			var d30304Offset_top = d30304Offsets[1];
			createDiv(birthInfos[3], year, d30304Offset_left, d30304Offset_top);
		}
		
		var d30304MonthOffset = jsonStr[birthInfos[4]];
		if(d30304MonthOffset != undefined) {
			var d30304MonthOffsets = d30304MonthOffset.split(";");
			var d30304MonthOffset_left = d30304MonthOffsets[0];
			var d30304MonthOffset_top = d30304MonthOffsets[1];
			createDiv(birthInfos[4], month, d30304MonthOffset_left, d30304MonthOffset_top);
		}
		
		var d30304DateOffset = jsonStr[birthInfos[5]];
		if(d30304DateOffset != undefined) {
			var d30304DateOffsets = d30304DateOffset.split(";");
			var d30304DateOffset_left = d30304DateOffsets[0];
			var d30304DateOffset_top = d30304DateOffsets[1];
			createDiv(birthInfos[5], date, d30304DateOffset_left, d30304DateOffset_top);
		}
		
		var d30304HourOffset = jsonStr[birthInfos[6]];
		if(d30304HourOffset != undefined) {
			var d30304HourOffsets = d30304HourOffset.split(";");
			var d30304HourOffset_left = d30304HourOffsets[0];
			var d30304HourOffset_top = d30304HourOffsets[1];
			createDiv(birthInfos[6], hour, d30304HourOffset_left, d30304HourOffset_top);
		}
		
		var d30304MinuteOffset = jsonStr[birthInfos[7]];
		if(d30304MinuteOffset != undefined) {
			var d30304MinuteOffsets = d30304MinuteOffset.split(";");
			var d30304MinuteOffset_left = d30304MinuteOffsets[0];
			var d30304MinuteOffset_top = d30304MinuteOffsets[1];
			createDiv(birthInfos[7], minute, d30304MinuteOffset_left, d30304MinuteOffset_top);
		}
		
		var d30305OffsetProvice = jsonStr[birthInfos[8]];
		var d30305OffsetCity = jsonStr[birthInfos[9]];
		var d30305OffsetCounty = jsonStr[birthInfos[10]];
		var d30305OffsetTown = jsonStr[birthInfos[11]];
		var areaCode = vd303[birthInfos[8]];

		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			var d30305OffsetProviceValue = dataValue[0];
			var d30305OffsetCityValue = dataValue[1];
			var d30305OffsetCountyValue = dataValue[2];
			var d30305OffsetTownValue = dataValue[3];
			if(d30305OffsetProvice != undefined) {
				var d30305OffsetProvices =  d30305OffsetProvice.split(";");
				var d30305OffsetProvices_left = d30305OffsetProvices[0];
				var d30305OffsetProvices_top = d30305OffsetProvices[1];
				createDiv(birthInfos[8], d30305OffsetProviceValue, d30305OffsetProvices_left, d30305OffsetProvices_top);
			}
			if(d30305OffsetCity != undefined) {
				var d30305OffsetCitys =  d30305OffsetCity.split(";");
				var d30305OffsetCitys_left = d30305OffsetCitys[0];
				var d30305OffsetCitys_top = d30305OffsetCitys[1];
				createDiv(birthInfos[9], d30305OffsetCityValue, d30305OffsetCitys_left, d30305OffsetCitys_top);
			}
			if(d30305OffsetCounty != undefined) {
				var d30305OffsetCountys =  d30305OffsetCounty.split(";");
				var d30305OffsetCountys_left = d30305OffsetCountys[0];
				var d30305OffsetCountys_top = d30305OffsetCountys[1];
				createDiv(birthInfos[10], d30305OffsetCountyValue, d30305OffsetCountys_left, d30305OffsetCountys_top);
			}
			if(d30305OffsetTown != undefined) {
				var d30305OffsetTowns =  d30305OffsetTown.split(";");
				var d30305OffsetTowns_left = d30305OffsetTowns[0];
				var d30305OffsetTowns_top = d30305OffsetTowns[1];
				createDiv(birthInfos[11], d30305OffsetTownValue, d30305OffsetTowns_left, d30305OffsetTowns_top);
			}
		}, "json");
		
		var d30307Offset = jsonStr[birthInfos[12]];
		if(d30307Offset != undefined) {
			var d30307Offsets = d30307Offset.split(";");
			var d30307Offsets_left = d30307Offsets[0];
			var d30307Offsets_top = d30307Offsets[1];
			var d30307Value = vd303[birthInfos[12]];
			createDiv(birthInfos[12], d30307Value, d30307Offsets_left, d30307Offsets_top);
		}
		
		var d30309Value = vd303[birthInfos[13]];
		if(d30309Value == "1") {
			var d30309OffsetGood = jsonStr[birthInfos[13]];
			if(d30309OffsetGood != undefined) {
				var d30309OffsetGoods = d30309OffsetGood.split(";");
				d30309OffsetGoods_left = d30309OffsetGoods[0];
				d30309OffsetGoods_top = d30309OffsetGoods[1];
				createDiv(birthInfos[13], symbol, d30309OffsetGoods_left, d30309OffsetGoods_top);
			}
		} else if(d30309Value == "2") {
			var d30309OffsetNormal = jsonStr[birthInfos[14]];
			if(d30309OffsetNormal != undefined) {
				var d30309OffsetNormals = d30309OffsetNormal.split(";");
				d30309OffsetNormals_left = d30309OffsetNormals[0];
				d30309OffsetNormals_top = d30309OffsetNormals[1];
				createDiv(birthInfos[14], symbol, d30309OffsetNormals_left, d30309OffsetNormals_top);
			}
		} else if(d30309Value == "3") {
			var d30309OffsetBad = jsonStr[birthInfos[15]];
			if(d30309OffsetBad != undefined) {
				var d30309OffsetBads = d30309OffsetBad.split(";");
				d30309OffsetBads_left = d30309OffsetBads[0];
				d30309OffsetBads_top = d30309OffsetBads[1];
				createDiv(birthInfos[15], symbol, d30309OffsetBads_left, d30309OffsetBads_top);
			}
		}
		
		var d30329Offset = jsonStr[birthInfos[16]];
		if(d30329Offset != undefined) {
			var d30329Offsets = d30329Offset.split(";");
			var d30329Offsets_left = d30329Offsets[0];
			var d30329Offsets_top = d30329Offsets[1];
			var d30329Value = vd303[birthInfos[16]];
			createDiv(birthInfos[16], d30329Value, d30329Offsets_left, d30329Offsets_top);
		}
		
		var d30308Offset = jsonStr[birthInfos[17]];
		if(d30308Offset != undefined) {
			var d30308Offsets = d30308Offset.split(";");
			var d30308Offsets_left = d30308Offsets[0];
			var d30308Offsets_top = d30308Offsets[1];
			var d30308Value = vd303[birthInfos[17]];
			createDiv(birthInfos[17], d30308Value, d30308Offsets_left, d30308Offsets_top);
		}
		
		var d30311Offset = jsonStr[birthInfos[18]];
		if(d30311Offset != undefined) {
			var d30311Offsets = d30311Offset.split(";");
			var d30311Offsets_left = d30311Offsets[0];
			var d30311Offsets_top = d30311Offsets[1];
			var d30311Value = vd303[birthInfos[18]];
			createDiv(birthInfos[18], d30311Value, d30311Offsets_left, d30311Offsets_top);
		}
		
		var d30313Offset = jsonStr[birthInfos[19]];
		if(d30313Offset != undefined) {
			var d30313Offsets = d30313Offset.split(";");
			var d30313Offsets_left = d30313Offsets[0];
			var d30313Offsets_top = d30313Offsets[1];
			var d30313Value = vd303[birthInfos[19]];
			createDiv(birthInfos[19], d30313Value, d30313Offsets_left, d30313Offsets_top);
		}
		
		var d30314ZhOffset = jsonStr[birthInfos[20]];
		if(d30314ZhOffset != undefined) {
			var d30314ZhOffsets = d30314ZhOffset.split(";");
			var d30314ZhOffsets_left = d30314ZhOffsets[0];
			var d30314ZhOffsets_top = d30314ZhOffsets[1];
			var d30314ZhValue = vd303[birthInfos[20]];
			createDiv(birthInfos[20], d30314ZhValue, d30314ZhOffsets_left, d30314ZhOffsets_top);
		}
		
		var d30315ZhOffset = jsonStr[birthInfos[21]];
		if(d30315ZhOffset != undefined) {
			var d30315ZhOffsets = d30315ZhOffset.split(";");
			var d30315ZhOffsets_left = d30315ZhOffsets[0];
			var d30315ZhOffsets_top = d30315ZhOffsets[1];
			var d30315ZhValue = vd303[birthInfos[21]];
			createDiv(birthInfos[21], d30315ZhValue, d30315ZhOffsets_left, d30315ZhOffsets_top);
		}
		
		var d30312Offset = jsonStr[birthInfos[22]];
		if(d30312Offset != undefined) {
			var d30312Offsets = d30312Offset.split(";");
			var d30312Offsets_left = d30312Offsets[0];
			var d30312Offsets_top = d30312Offsets[1];
			var d30312Value = vd303[birthInfos[22]];
			createDiv(birthInfos[22], d30312Value, d30312Offsets_left, d30312Offsets_top);
		}
		
		var d30316Offset = jsonStr[birthInfos[23]];
		if(d30316Offset != undefined) {
			var d30316Offsets = d30316Offset.split(";");
			var d30316Offsets_left = d30316Offsets[0];
			var d30316Offsets_top = d30316Offsets[1];
			var d30316Value = vd303[birthInfos[23]];
			createDiv(birthInfos[23], d30316Value, d30316Offsets_left, d30316Offsets_top);
		}
		
		var d30318Offset = jsonStr[birthInfos[24]];
		if(d30318Offset != undefined) {
			var d30318Offsets = d30318Offset.split(";");
			var d30318Offsets_left = d30318Offsets[0];
			var d30318Offsets_top = d30318Offsets[1];
			var d30318Value = vd303[birthInfos[24]];
			createDiv(birthInfos[24], d30318Value, d30318Offsets_left, d30318Offsets_top);
		}
		
		var d30319Offset = jsonStr[birthInfos[25]];
		if(d30319Offset != undefined) {
			var d30319Offsets = d30319Offset.split(";");
			var d30319Offsets_left = d30319Offsets[0];
			var d30319Offsets_top = d30319Offsets[1];
			var d30319Value = vd303[birthInfos[25]];
			createDiv(birthInfos[25], d30319Value, d30319Offsets_left, d30319Offsets_top);
		}
		
		var d30320Offset = jsonStr[birthInfos[26]];
		if(d30320Offset != undefined) {
			var d30320Offsets = d30320Offset.split(";");
			var d30320Offsets_left = d30320Offsets[0];
			var d30320Offsets_top = d30320Offsets[1];
			var d30320Value = vd303[birthInfos[26]];
			createDiv(birthInfos[26], d30320Value, d30320Offsets_left, d30320Offsets_top);
		}
		
		var d30317Offset = jsonStr[birthInfos[27]];
		if(d30317Offset != undefined) {
			var d30317Offsets = d30317Offset.split(";");
			var d30317Offsets_left = d30317Offsets[0];
			var d30317Offsets_top = d30317Offsets[1];
			var d30317Value = vd303[birthInfos[27]];
			createDiv(birthInfos[27], d30317Value, d30317Offsets_left, d30317Offsets_top);
		}
		
		var d30322Value = vd303[birthInfos[28]];
		if(d30322Value == "1") {
			var d30322OffsetHospital = jsonStr[birthInfos[28]];
			if(d30322OffsetHospital != undefined) {
				var d30322OffsetHospitals = d30322OffsetHospital.split(";");
				d30322OffsetHospitals_left = d30322OffsetHospitals[0];
				d30322OffsetHospitals_top = d30322OffsetHospitals[1];
				createDiv(birthInfos[28], symbol, d30322OffsetHospitals_left, d30322OffsetHospitals_top);
			}
		} else if(d30322Value == "2") {
			var d30322OffsetHealth = jsonStr[birthInfos[29]];
			if(d30322OffsetHealth != undefined) {
				var d30322OffsetHealths = d30322OffsetHealth.split(";");
				d30322OffsetHealths_left = d30322OffsetHealths[0];
				d30322OffsetHealths_top = d30322OffsetHealths[1];
				createDiv(birthInfos[29], symbol, d30322OffsetHealths_left, d30322OffsetHealths_top);
			}
		}else if(d30322Value == "3"){
			var d30322OffsetFamily = jsonStr[birthInfos[30]];
			if(d30322OffsetFamily != undefined) {
				var d30322OffsetFamilys = d30322OffsetFamily.split(";");
				d30322OffsetFamilys_left = d30322OffsetFamilys[0];
				d30322OffsetFamilys_top = d30322OffsetFamilys[1];
				createDiv(birthInfos[30], symbol, d30322OffsetFamilys_left, d30322OffsetFamilys_top);
			}
		} else if(d30322Value == "4") {
			var d30322OffsetOther = jsonStr[birthInfos[31]];
			if(d30322OffsetOther != undefined) {
				var d30322OffsetOthers = d30322OffsetOther.split(";");
				d30322OffsetOthers_left = d30322OffsetOthers[0];
				d30322OffsetOthers_top = d30322OffsetOthers[1];
				createDiv(birthInfos[31], symbol, d30322OffsetOthers_left, d30322OffsetOthers_top);
			}
			
			var d30323Offset = jsonStr[birthInfos[32]];
			if(d30323Offset != undefined) {
				var d30323Offsets = d30323Offset.split(";");
				d30323Offsets_left = d30323Offsets[0];
				d30323Offsets_top = d30323Offsets[1];
				createDiv(birthInfos[32], vd303[birthInfos[32]], d30323Offsets_left, d30323Offsets_top);
			}
		}
		
		var d30324Offset = jsonStr[birthInfos[33]];
		if(d30324Offset != undefined) {
			var d30324Offsets = d30324Offset.split(";");
			var d30324Offsets_left = d30324Offsets[0];
			var d30324Offsets_top = d30324Offsets[1];
			var d30324Value = vd303[birthInfos[33]];
			createDiv(birthInfos[33], d30324Value, d30324Offsets_left, d30324Offsets_top);
		}
		
		var d30328Value = vd303[birthInfos[34]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30328Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30328OffsetYear = jsonStr[birthInfos[34]];
		if(d30328OffsetYear != undefined) {
			var d30328OffsetYears = d30328OffsetYear.split(";");
			var d30328OffsetYear_left = d30328OffsetYears[0];
			var d30328OffsetYear_top = d30328OffsetYears[1];
			createDiv(birthInfos[34], yearS, d30328OffsetYear_left, d30328OffsetYear_top);
		}
		
		var d30328OffsetMonth = jsonStr[birthInfos[35]];
		if(d30328OffsetMonth != undefined) {
			var d30328OffsetMonths = d30328OffsetMonth.split(";");
			var d30328OffsetMonths_left = d30328OffsetMonths[0];
			var d30328OffsetMonths_top = d30328OffsetMonths[1];
			createDiv(birthInfos[35], monthS, d30328OffsetMonths_left, d30328OffsetMonths_top);
		}
		
		var d30328OffsetDate = jsonStr[birthInfos[36]];
		if(d30328OffsetDate != undefined) {
			var d30328OffsetDates = d30328OffsetDate.split(";");
			var d30328OffsetDates_left = d30328OffsetDates[0];
			var d30328OffsetDates_top = d30328OffsetDates[1];
			createDiv(birthInfos[36], dateS, d30328OffsetDates_left, d30328OffsetDates_top);
		}
	}, "json");
	
	$.post(contextRoot + "/PrintBirthInfoBfServlet", {"flag":"BIRTH_PRINTINFO_SECOND_BF","d30310":d30310}, function(dataVd303S){
		var jsonStrS = dataVd303S[0];
		var vd303S = dataVd303S[1];
		
		var birthInfosS = birthInfo[1].split(";");

		var birthInfosd30302OSffset = jsonStrS[birthInfosS[0]];
		if(birthInfosd30302OSffset != undefined) {
			var d30302SOffset = birthInfosd30302OSffset.split(";");
			var d30302SOffset_left = d30302SOffset[0];
			var d30302SOffset_top = d30302SOffset[1];
			var d30302SValue = vd303S[birthInfosS[0]];
			createDiv(birthInfosS[0], d30302SValue, d30302SOffset_left, d30302SOffset_top);
		}
		var birthInfosd30303OZhSffset = jsonStrS[birthInfosS[1]];
		if(birthInfosd30303OZhSffset != undefined){
			var d30303ZhSOffset = birthInfosd30303OZhSffset.split(";");
			var d30303ZhSOffset_left = d30303ZhSOffset[0];
			var d30303ZhSOffset_top = d30303ZhSOffset[1];
			var d30303ZhSValue = vd303S[birthInfosS[1]];
			createDiv(birthInfosS[1], d30303ZhSValue, d30303ZhSOffset_left, d30303ZhSOffset_top);
		}
		
		var d30304SValue = vd303S[birthInfosS[2]];
		var regsS = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/;  
		var timeVsS = "";
		var yearsS = "";
		var monthsS = "";
		var datesS = "";
		var hourS = "";
		var minuteS = "";
		if(d30304SValue != ""){
			timeVsS = regsS.exec(d30304SValue);
			yearsS = timeVsS[1];
			monthsS = timeVsS[2];
			datesS = timeVsS[3];
			hourS = timeVsS[4];
			minuteS = timeVsS[5];
		}
		
		var d30304SOffsetYear = jsonStrS[birthInfosS[2]];
		var d30304SOffsetYears = d30304SOffsetYear.split(";");
		var d30304SOffsetYear_left = d30304SOffsetYears[0];
		var d30304SOffsetYear_top = d30304SOffsetYears[1];
		
		var d30304SOffsetMonth = jsonStrS[birthInfosS[3]];
		var d30304SOffsetMonths = d30304SOffsetMonth.split(";");
		var d30304SOffsetMonth_left = d30304SOffsetMonths[0];
		var d30304SOffsetMonth_top = d30304SOffsetMonths[1];
		
		var d30304SOffsetDate = jsonStrS[birthInfosS[4]];
		var d30304SOffsetDates = d30304SOffsetDate.split(";");
		var d30304SOffsetDate_left = d30304SOffsetDates[0];
		var d30304SOffsetDate_top = d30304SOffsetDates[1];
		
		var d30304SOffsetHour = jsonStrS[birthInfosS[5]];
		var d30304SOffsetHours = d30304SOffsetHour.split(";");
		var d30304SOffsetHour_left = d30304SOffsetHours[0];
		var d30304SOffsetHour_top = d30304SOffsetHours[1];
		
		var d30304SOffsetMinute = jsonStrS[birthInfosS[6]];
		var d30304SOffsetMinutes = d30304SOffsetMinute.split(";");
		var d30304SOffsetMinute_left = d30304SOffsetMinutes[0];
		var d30304SOffsetMinute_top = d30304SOffsetMinutes[1];
		
		if(d30304SOffsetYears != undefined){
			createDiv(birthInfosS[2], yearsS, d30304SOffsetYear_left, d30304SOffsetYear_top);
		}
		if(d30304SOffsetMonth != undefined){
			createDiv(birthInfosS[3], monthsS, d30304SOffsetMonth_left, d30304SOffsetMonth_top);
		}
		if(d30304SOffsetDate != undefined){
			createDiv(birthInfosS[4], datesS, d30304SOffsetDate_left, d30304SOffsetDate_top);
		}
		if(d30304SOffsetHour != undefined){
			createDiv(birthInfosS[5], hourS, d30304SOffsetHour_left, d30304SOffsetHour_top);
		}
		if(d30304SOffsetMinute != undefined){
			createDiv(birthInfosS[6], minuteS, d30304SOffsetMinute_left, d30304SOffsetMinute_top);
		}
		
		var birthInfosd30305ZhSffset = jsonStrS[birthInfosS[7]];
		if(birthInfosd30305ZhSffset != undefined){
			var d30305ZhSOffset = birthInfosd30305ZhSffset.split(";");
			var d30305ZhSOffset_left = d30305ZhSOffset[0];
			var d30305ZhSOffset_top = d30305ZhSOffset[1];
			var d30305ZhSValue = vd303S[birthInfosS[7]];
			createDiv(birthInfosS[7], d30305ZhSValue, d30305ZhSOffset_left, d30305ZhSOffset_top);
		}
		
		var birthInfosd30311Sffset = jsonStrS[birthInfosS[8]];
		if(birthInfosd30311Sffset != undefined){
			var d30311Sffset = birthInfosd30311Sffset.split(";");
			var d30311Sffset_left = d30311Sffset[0];
			var d30311Sffset_top = d30311Sffset[1];
			var d30311SValue = vd303S[birthInfosS[8]];
			createDiv(birthInfosS[8], d30311SValue, d30311Sffset_left, d30311Sffset_top);
		}
		
		var birthInfosd30313Sffset = jsonStrS[birthInfosS[9]];
		if(birthInfosd30313Sffset != undefined){
			var d30313Sffset = birthInfosd30313Sffset.split(";");
			var d30313Sffset_left = d30313Sffset[0];
			var d30313Sffset_top = d30313Sffset[1];
			var d30313SValue = vd303S[birthInfosS[9]];
			createDiv(birthInfosS[9], d30313SValue, d30313Sffset_left, d30313Sffset_top);
		}
		
		var birthInfosd30314ZhSffset = jsonStrS[birthInfosS[10]];
		if(birthInfosd30314ZhSffset != undefined){
			var d30314ZhSOffset = birthInfosd30314ZhSffset.split(";");
			var d30314ZhSOffset_left = d30314ZhSOffset[0];
			var d30314ZhSOffset_top = d30314ZhSOffset[1];
			var d30314ZhSValue = vd303S[birthInfosS[10]];
			createDiv(birthInfosS[10], d30314ZhSValue, d30314ZhSOffset_left, d30314ZhSOffset_top);
		}
		
		var birthInfosd30315ZhSffset = jsonStrS[birthInfosS[11]];
		if(birthInfosd30315ZhSffset != undefined){
			var d30315ZhSOffset = birthInfosd30315ZhSffset.split(";");
			var d30315ZhSOffset_left = d30315ZhSOffset[0];
			var d30315ZhSOffset_top = d30315ZhSOffset[1];
			var d30315ZhSValue = vd303S[birthInfosS[11]];
			createDiv(birthInfosS[11], d30315ZhSValue, d30315ZhSOffset_left, d30315ZhSOffset_top);
		}
		
		var birthInfosd30312Sffset = jsonStrS[birthInfosS[12]];
		if(birthInfosd30312Sffset != undefined){
			var d30312Sffset = birthInfosd30312Sffset.split(";");
			var d30312Sffset_left = d30312Sffset[0];
			var d30312Sffset_top = d30312Sffset[1];
			var d30312SValue = vd303S[birthInfosS[12]];
			createDiv(birthInfosS[12], d30312SValue, d30312Sffset_left, d30312Sffset_top);
		}
		
		var birthInfosd30316Sffset = jsonStrS[birthInfosS[13]];
		if(birthInfosd30316Sffset != undefined){
			var d30316Sffset = birthInfosd30316Sffset.split(";");
			var d30316Sffset_left = d30316Sffset[0];
			var d30316Sffset_top = d30316Sffset[1];
			var d30316SValue = vd303S[birthInfosS[13]];
			createDiv(birthInfosS[13], d30316SValue, d30316Sffset_left, d30316Sffset_top);
		}
		
		var birthInfosd30318Sffset = jsonStrS[birthInfosS[14]];
		if(birthInfosd30318Sffset != undefined){
			var d30318Sffset = birthInfosd30318Sffset.split(";");
			var d30318Sffset_left = d30318Sffset[0];
			var d30318Sffset_top = d30318Sffset[1];
			var d30318SValue = vd303S[birthInfosS[14]];
			createDiv(birthInfosS[14], d30318SValue, d30318Sffset_left, d30318Sffset_top);
		}
		
		var birthInfosd30319ZhSffset = jsonStrS[birthInfosS[15]];
		if(birthInfosd30319ZhSffset != undefined){
			var d30319ZhSOffset = birthInfosd30319ZhSffset.split(";");
			var d30319ZhSOffset_left = d30319ZhSOffset[0];
			var d30319ZhSOffset_top = d30319ZhSOffset[1];
			var d30319ZhSValue = vd303S[birthInfosS[15]];
			createDiv(birthInfosS[15], d30319ZhSValue, d30319ZhSOffset_left, d30319ZhSOffset_top);
		}
		
		var birthInfosd30320ZhSffset = jsonStrS[birthInfosS[16]];
		if(birthInfosd30320ZhSffset != undefined){
			var d30320ZhSOffset = birthInfosd30320ZhSffset.split(";");
			var d30320ZhSOffset_left = d30320ZhSOffset[0];
			var d30320ZhSOffset_top = d30320ZhSOffset[1];
			var d30320ZhSValue = vd303S[birthInfosS[16]];
			createDiv(birthInfosS[16], d30320ZhSValue, d30320ZhSOffset_left, d30320ZhSOffset_top);
		}
		
		var birthInfosd30317Sffset = jsonStrS[birthInfosS[17]];
		if(birthInfosd30317Sffset != undefined){
			var d30317Sffset = birthInfosd30317Sffset.split(";");
			var d30317Sffset_left = d30317Sffset[0];
			var d30317Sffset_top = d30317Sffset[1];
			var d30317SValue = vd303S[birthInfosS[17]];
			createDiv(birthInfosS[17], d30317SValue, d30317Sffset_left, d30317Sffset_top);
		}
		
		var birthInfosd30321Sffset = jsonStrS[birthInfosS[18]];
		if(birthInfosd30321Sffset != undefined){
			var d30321Sffset = birthInfosd30321Sffset.split(";");
			var d30321Sffset_left = d30321Sffset[0];
			var d30321Sffset_top = d30321Sffset[1];
			var d30321SValue = vd303S[birthInfosS[18]];
			createDiv(birthInfosS[18], d30321SValue, d30321Sffset_left, d30321Sffset_top);
		}
		
		var d30328SValue = vd303S[birthInfosS[19]];
		var regd30328S = /(\d{4})-(\d{2})-(\d{2})/; 
		var timed30328S = regd30328S.exec(d30328SValue);
		var yeard30328S = timed30328S[1];
		var monthd30328S = timed30328S[2];
		var dated30328S = timed30328S[3];
		
		var d30328SOffsetYear = jsonStrS[birthInfosS[19]];
		var d30328SOffsetYears = d30328SOffsetYear.split(";");
		var d30328SOffsetYear_left = d30328SOffsetYears[0];
		var d30328SOffsetYear_top = d30328SOffsetYears[1];
		if(d30328SOffsetYear != undefined){
			createDiv(birthInfosS[19], yeard30328S, d30328SOffsetYear_left, d30328SOffsetYear_top);
		}
		
		var d30328SOffsetMonth = jsonStrS[birthInfosS[20]];
		var d30328SOffsetMonths = d30328SOffsetMonth.split(";");
		var d30328SOffsetMonth_left = d30328SOffsetMonths[0];
		var d30328SOffsetMonth_top = d30328SOffsetMonths[1];
		if(d30328SOffsetMonth != undefined){
			createDiv(birthInfosS[20], monthd30328S, d30328SOffsetMonth_left, d30328SOffsetMonth_top);
		}
		
		var d30328SOffsetDate = jsonStrS[birthInfosS[21]];
		var d30328SOffsetDates = d30328SOffsetDate.split(";");
		var d30328SOffsetDate_left = d30328SOffsetDates[0];
		var d30328SOffsetDate_top = d30328SOffsetDates[1];
		if(d30328SOffsetDate != undefined){
			createDiv(birthInfosS[21], dated30328S, d30328SOffsetDate_left, d30328SOffsetDate_top);
		}
	}, "json");
	
	$.post(contextRoot + "/PrintBirthInfoBfServlet", {"flag":"BIRTH_PRINTINFO_THIRD_BF","d30310":d30310}, function(dataVd303T){
		var jsonStrT = dataVd303T[0];
		var vd303T = dataVd303T[1];
		
		var birthInfosT = birthInfo[2].split(";");
		
		var birthInfosd30302OTffset = jsonStrT[birthInfosT[0]];
		if(birthInfosd30302OTffset != undefined) {
			var d30302TOffset = birthInfosd30302OTffset.split(";");
			var d30302TOffset_left = d30302TOffset[0];
			var d30302TOffset_top = d30302TOffset[1];
			var d30302TValue = vd303T[birthInfosT[0]];
			createDiv(birthInfosT[0], d30302TValue, d30302TOffset_left, d30302TOffset_top);
		}
		
		var birthInfosd30303OZhTffset = jsonStrT[birthInfosT[1]];
		if(birthInfosd30303OZhTffset != undefined){
			var d30303ZhTOffset = birthInfosd30303OZhTffset.split(";");
			var d30303ZhTOffset_left = d30303ZhTOffset[0];
			var d30303ZhTOffset_top = d30303ZhTOffset[1];
			var d30303ZhTValue = vd303T[birthInfosT[1]];
			createDiv(birthInfosT[1], d30303ZhTValue, d30303ZhTOffset_left, d30303ZhTOffset_top);
		}
		
		var d30304TValue = vd303T[birthInfosT[2]];
		var regsT = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/;  
		var timeVsT = "";
		var yearsT = "";
		var monthsT = "";
		var datesT = "";
		var hourT = "";
		var minuteT = "";
		if(d30304TValue != ""){
			timeVsT = regsT.exec(d30304TValue);
			yearsT = timeVsT[1];
			monthsT = timeVsT[2];
			datesT = timeVsT[3];
			hourT = timeVsT[4];
			minuteT = timeVsT[5];
		}
		
		var d30304TOffsetYear = jsonStrT[birthInfosT[2]];
		var d30304TOffsetYears = d30304TOffsetYear.split(";");
		var d30304TOffsetYear_left = d30304TOffsetYears[0];
		var d30304TOffsetYear_top = d30304TOffsetYears[1];
		
		var d30304TOffsetMonth = jsonStrT[birthInfosT[3]];
		var d30304TOffsetMonths = d30304TOffsetMonth.split(";");
		var d30304TOffsetMonth_left = d30304TOffsetMonths[0];
		var d30304TOffsetMonth_top = d30304TOffsetMonths[1];
		
		var d30304TOffsetDate = jsonStrT[birthInfosT[4]];
		var d30304TOffsetDates = d30304TOffsetDate.split(";");
		var d30304TOffsetDate_left = d30304TOffsetDates[0];
		var d30304TOffsetDate_top = d30304TOffsetDates[1];
		
		var d30304TOffsetHour = jsonStrT[birthInfosT[5]];
		var d30304TOffsetHours = d30304TOffsetHour.split(";");
		var d30304TOffsetHour_left = d30304TOffsetHours[0];
		var d30304TOffsetHour_top = d30304TOffsetHours[1];
		
		var d30304TOffsetMinute = jsonStrT[birthInfosT[6]];
		var d30304TOffsetMinutes = d30304TOffsetMinute.split(";");
		var d30304TOffsetMinute_left = d30304TOffsetMinutes[0];
		var d30304TOffsetMinute_top = d30304TOffsetMinutes[1];
		
		if(d30304TOffsetYears != undefined){
			createDiv(birthInfosT[2], yearsT, d30304TOffsetYear_left, d30304TOffsetYear_top);
		}
		if(d30304TOffsetMonth != undefined){
			createDiv(birthInfosT[3], monthsT, d30304TOffsetMonth_left, d30304TOffsetMonth_top);
		}
		if(d30304TOffsetDate != undefined){
			createDiv(birthInfosT[4], datesT, d30304TOffsetDate_left, d30304TOffsetDate_top);
		}
		if(d30304TOffsetHour != undefined){
			createDiv(birthInfosT[5], hourT, d30304TOffsetHour_left, d30304TOffsetHour_top);
		}
		if(d30304TOffsetMinute != undefined){
			createDiv(birthInfosT[6], minuteT, d30304TOffsetMinute_left, d30304TOffsetMinute_top);
		}
		
		var birthInfosd30305ZhTffset = jsonStrT[birthInfosT[7]];
		if(birthInfosd30305ZhTffset != undefined){
			var d30305ZhTOffset = birthInfosd30305ZhTffset.split(";");
			var d30305ZhTOffset_left = d30305ZhTOffset[0];
			var d30305ZhTOffset_top = d30305ZhTOffset[1];
			var d30305ZhTValue = vd303T[birthInfosT[7]];
			createDiv(birthInfosT[7], d30305ZhTValue, d30305ZhTOffset_left, d30305ZhTOffset_top);
		}
		
		var birthInfosd30311Tffset = jsonStrT[birthInfosT[8]];
		if(birthInfosd30311Tffset != undefined){
			var d30311Tffset = birthInfosd30311Tffset.split(";");
			var d30311Tffset_left = d30311Tffset[0];
			var d30311Tffset_top = d30311Tffset[1];
			var d30311TValue = vd303T[birthInfosT[8]];
			createDiv(birthInfosT[8], d30311TValue, d30311Tffset_left, d30311Tffset_top);
		}
		
		var birthInfosd30313Tffset = jsonStrT[birthInfosT[9]];
		if(birthInfosd30313Tffset != undefined){
			var d30313Tffset = birthInfosd30313Tffset.split(";");
			var d30313Tffset_left = d30313Tffset[0];
			var d30313Tffset_top = d30313Tffset[1];
			var d30313TValue = vd303T[birthInfosT[9]];
			createDiv(birthInfosT[9], d30313TValue, d30313Tffset_left, d30313Tffset_top);
		}
		
		var birthInfosd30314ZhTffset = jsonStrT[birthInfosT[10]];
		if(birthInfosd30314ZhTffset != undefined){
			var d30314ZhTOffset = birthInfosd30314ZhTffset.split(";");
			var d30314ZhTOffset_left = d30314ZhTOffset[0];
			var d30314ZhTOffset_top = d30314ZhTOffset[1];
			var d30314ZhTValue = vd303T[birthInfosT[10]];
			createDiv(birthInfosT[10], d30314ZhTValue, d30314ZhTOffset_left, d30314ZhTOffset_top);
		}
		
		var birthInfosd30315ZhTffset = jsonStrT[birthInfosT[11]];
		if(birthInfosd30315ZhTffset != undefined){
			var d30315ZhTOffset = birthInfosd30315ZhTffset.split(";");
			var d30315ZhTOffset_left = d30315ZhTOffset[0];
			var d30315ZhTOffset_top = d30315ZhTOffset[1];
			var d30315ZhTValue = vd303T[birthInfosT[11]];
			createDiv(birthInfosT[11], d30315ZhTValue, d30315ZhTOffset_left, d30315ZhTOffset_top);
		}
		
		var birthInfosd30312Tffset = jsonStrT[birthInfosT[12]];
		if(birthInfosd30312Tffset != undefined){
			var d30312Tffset = birthInfosd30312Tffset.split(";");
			var d30312Tffset_left = d30312Tffset[0];
			var d30312Tffset_top = d30312Tffset[1];
			var d30312TValue = vd303T[birthInfosT[12]];
			createDiv(birthInfosT[12], d30312TValue, d30312Tffset_left, d30312Tffset_top);
		}
		
		var birthInfosd30316Tffset = jsonStrT[birthInfosT[13]];
		if(birthInfosd30316Tffset != undefined){
			var d30316Tffset = birthInfosd30316Tffset.split(";");
			var d30316Tffset_left = d30316Tffset[0];
			var d30316Tffset_top = d30316Tffset[1];
			var d30316TValue = vd303T[birthInfosT[13]];
			createDiv(birthInfosT[13], d30316TValue, d30316Tffset_left, d30316Tffset_top);
		}
		
		var birthInfosd30318Tffset = jsonStrT[birthInfosT[14]];
		if(birthInfosd30318Tffset != undefined){
			var d30318Tffset = birthInfosd30318Tffset.split(";");
			var d30318Tffset_left = d30318Tffset[0];
			var d30318Tffset_top = d30318Tffset[1];
			var d30318TValue = vd303T[birthInfosT[14]];
			createDiv(birthInfosT[14], d30318TValue, d30318Tffset_left, d30318Tffset_top);
		}
		
		var birthInfosd30319ZhTffset = jsonStrT[birthInfosT[15]];
		if(birthInfosd30319ZhTffset != undefined){
			var d30319ZhTOffset = birthInfosd30319ZhTffset.split(";");
			var d30319ZhTOffset_left = d30319ZhTOffset[0];
			var d30319ZhTOffset_top = d30319ZhTOffset[1];
			var d30319ZhTValue = vd303T[birthInfosT[15]];
			createDiv(birthInfosT[15], d30319ZhTValue, d30319ZhTOffset_left, d30319ZhTOffset_top);
		}
		
		var birthInfosd30320ZhTffset = jsonStrT[birthInfosT[16]];
		if(birthInfosd30320ZhTffset != undefined){
			var d30320ZhTOffset = birthInfosd30320ZhTffset.split(";");
			var d30320ZhTOffset_left = d30320ZhTOffset[0];
			var d30320ZhTOffset_top = d30320ZhTOffset[1];
			var d30320ZhTValue = vd303T[birthInfosT[16]];
			createDiv(birthInfosT[16], d30320ZhTValue, d30320ZhTOffset_left, d30320ZhTOffset_top);
		}
		
		var birthInfosd30317Tffset = jsonStrT[birthInfosT[17]];
		if(birthInfosd30317Tffset != undefined){
			var d30317Tffset = birthInfosd30317Tffset.split(";");
			var d30317Tffset_left = d30317Tffset[0];
			var d30317Tffset_top = d30317Tffset[1];
			var d30317TValue = vd303T[birthInfosT[17]];
			createDiv(birthInfosT[17], d30317TValue, d30317Tffset_left, d30317Tffset_top);
		}
		
		var birthInfosd30321Tffset = jsonStrT[birthInfosT[18]];
		if(birthInfosd30321Tffset != undefined){
			var d30321Tffset = birthInfosd30321Tffset.split(";");
			var d30321Tffset_left = d30321Tffset[0];
			var d30321Tffset_top = d30321Tffset[1];
			var d30321TValue = vd303T[birthInfosT[18]];
			createDiv(birthInfosT[18], d30321TValue, d30321Tffset_left, d30321Tffset_top);
		}
		
		var d30328TValue = vd303T[birthInfosT[19]];
		var regd30328T = /(\d{4})-(\d{2})-(\d{2})/; 
		var timed30328T = regd30328T.exec(d30328TValue);
		var yeard30328T = timed30328T[1];
		var monthd30328T = timed30328T[2];
		var dated30328T = timed30328T[3];
		
		var d30328TOffsetYear = jsonStrT[birthInfosT[19]];
		var d30328TOffsetYears = d30328TOffsetYear.split(";");
		var d30328TOffsetYear_left = d30328TOffsetYears[0];
		var d30328TOffsetYear_top = d30328TOffsetYears[1];
		if(d30328TOffsetYear != undefined){
			createDiv(birthInfosT[19], yeard30328T, d30328TOffsetYear_left, d30328TOffsetYear_top);
		}
		
		var d30328TOffsetMonth = jsonStrT[birthInfosT[20]];
		var d30328TOffsetMonths = d30328TOffsetMonth.split(";");
		var d30328TOffsetMonth_left = d30328TOffsetMonths[0];
		var d30328TOffsetMonth_top = d30328TOffsetMonths[1];
		if(d30328TOffsetMonth != undefined){
			createDiv(birthInfosT[20], monthd30328T, d30328TOffsetMonth_left, d30328TOffsetMonth_top);
		}
		
		var d30328TOffsetDate = jsonStrT[birthInfosT[21]];
		var d30328TOffsetDates = d30328TOffsetDate.split(";");
		var d30328TOffsetDate_left = d30328TOffsetDates[0];
		var d30328TOffsetDate_top = d30328TOffsetDates[1];
		if(d30328TOffsetDate != undefined){
			createDiv(birthInfosT[21], dated30328T, d30328TOffsetDate_left, d30328TOffsetDate_top);
		}
	}, "json");
});

function createDiv(id, value, offset_left, offset_top)
{
	$("body").append($("<div></div>").attr("id", id).text(value));
	if(id == "d30312" || id == "d30317") {
		$("#" + id).css({"letter-spacing":"7.6px"});
	}
	$("#" + id).css({"position":"absolute", "font-size":"12px"});
	$("#" + id).offset({left:offset_left, top:offset_top});
}