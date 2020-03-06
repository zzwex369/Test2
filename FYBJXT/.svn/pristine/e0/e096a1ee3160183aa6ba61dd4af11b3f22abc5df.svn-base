 var contextRoot = "/csyxzm";
$(document).ready(function(){
	
	var printInfo = new Array();
	var printInfoLabel  = new Array();
	var birthInfo = new Array();
	var birthInfoLabel = new Array();

	printInfo[0] = "BIRTH_PRINTINFO";
	printInfoLabel[0] = "出生证明";

	printInfo[1] = "BIRTH_PRINTINFO_SECOND";
	printInfoLabel[1] = "副页";
	
	printInfo[2] = "BIRTH_PRINTINFO_THIRD";
	printInfoLabel[2] = "存根";
	
	birthInfo[0] = "d30102;d30103;a03;d30104;a05;a06;a07;a08;d30105;a10;a11;a12;d30107;d30109;a15;a16;d30129;d30108;d30111;d30113;d30114Zh;d30115Zh;d30112;d30116;d30118;d30119Zh;d30120Zh;d30117;d30122;a30;a31;a32;d30123;d30124Zh;d30128;a36;a37";
	birthInfoLabel[0] = "新生儿姓名;男;女;年;月;日;时;分;省;市;县;乡;孕周;良好;一般;差;体重;身长;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲身份证号;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲身份证号;医院;保健院;家庭;其他;其它;接生机构;签发年;签发月;签发日";
	
	birthInfo[1] = "d30102S;d30103ZhS;d30104S;s05;s06;s07;s08;d30105ZhS;d30111S;d30113S;d30114ZhS;d30115ZhS;d30112S;d30116S;d30118S;d30119ZhS;d30120ZhS;d30117S;d30121S;d30128S;s36;s37";
	birthInfoLabel[1] = "婴儿姓名;性别;年;月;日;时;分;出生地点;母亲姓名;母亲年龄;母亲国籍;母亲民族;身份证;父亲姓名;父亲年龄;父亲国籍;父亲民族;身份证;家庭住址;签发年;签发月;签发日";
	
	birthInfo[2] = "d30102T;d30103ZhT;d30104T;t05;t06;t07;t08;d30105ZhT;d30111T;d30113T;d30114ZhT;d30115ZhT;d30112T;d30116T;d30118T;d30119ZhT;d30120ZhT;d30117T;d30121T;d30128T;t36;t37";
	birthInfoLabel[2] = "婴儿姓名;性别;年;月;日;时;分;出生地点;母亲姓名;母亲年龄;母亲国籍;母亲民族;身份证;父亲姓名;父亲年龄;父亲国籍;父亲民族;身份证;家庭住址;签发年;签发月;签发日";
	
	var d30110 = $("#d30110").val();
	$.post(contextRoot + "/PrintBirthInfoServlet", {"flag":"BIRTH_PRINTINFO","d30110":d30110}, function(data){
		var jsonStr = data[0];
		var vd301 = data[1];
		var symbol = "√";
		
		var birthInfos = birthInfo[0].split(";");
		var birthInfosD30102Offset = jsonStr[birthInfos[0]];
		if(birthInfosD30102Offset != undefined) {
			var d30102Offset = birthInfosD30102Offset.split(";");
			var d30102Offset_left = d30102Offset[0];
			var d30102Offset_top = d30102Offset[1];
			var d30102Value = vd301[birthInfos[0]];
			createDiv(birthInfos[0], d30102Value, d30102Offset_left, d30102Offset_top);
		}
		
		var d30103Value = vd301[birthInfos[1]];
		var birthInfosD30103Offset = "";
		if(d30103Value == "1") {
			birthInfosD30103Offset = jsonStr[birthInfos[1]];
		} else if(d30103Value == "2") {
			birthInfosD30103Offset = jsonStr[birthInfos[2]];
		} 
		if(birthInfosD30103Offset != "") {
			var d30103Offset = birthInfosD30103Offset.split(";");
			var d30103Offset_left = d30103Offset[0];
			var d30103Offset_top = d30103Offset[1];
			createDiv(birthInfos[1], symbol, d30103Offset_left, d30103Offset_top);
		}
		
		var d30104Value = vd301[birthInfos[3]];
		var reg = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/; 
		var timeV = "";
		var year = "";
		var month = "";
		var date = "";
		var hour = "";
		var minute = "";
		
		if(d30104Value != "")
		{
			timeV = reg.exec(d30104Value);
			year = timeV[1];
			month = timeV[2];
			date = timeV[3];
			hour = timeV[4];
			minute = timeV[5];
		}
		
		var d30104Offset = jsonStr[birthInfos[3]];
		if(d30104Offset != undefined) {
			var d30104Offsets = d30104Offset.split(";");
			var d30104Offset_left = d30104Offsets[0];
			var d30104Offset_top = d30104Offsets[1];
			createDiv(birthInfos[3], year, d30104Offset_left, d30104Offset_top);
		}
		
		var d30104MonthOffset = jsonStr[birthInfos[4]];
		if(d30104MonthOffset != undefined) {
			var d30104MonthOffsets = d30104MonthOffset.split(";");
			var d30104MonthOffset_left = d30104MonthOffsets[0];
			var d30104MonthOffset_top = d30104MonthOffsets[1];
			createDiv(birthInfos[4], month, d30104MonthOffset_left, d30104MonthOffset_top);
		}
		
		var d30104DateOffset = jsonStr[birthInfos[5]];
		if(d30104DateOffset != undefined) {
			var d30104DateOffsets = d30104DateOffset.split(";");
			var d30104DateOffset_left = d30104DateOffsets[0];
			var d30104DateOffset_top = d30104DateOffsets[1];
			createDiv(birthInfos[5], date, d30104DateOffset_left, d30104DateOffset_top);
		}
		
		var d30104HourOffset = jsonStr[birthInfos[6]];
		if(d30104HourOffset != undefined) {
			var d30104HourOffsets = d30104HourOffset.split(";");
			var d30104HourOffset_left = d30104HourOffsets[0];
			var d30104HourOffset_top = d30104HourOffsets[1];
			createDiv(birthInfos[6], hour, d30104HourOffset_left, d30104HourOffset_top);
		}
		
		var d30104MinuteOffset = jsonStr[birthInfos[7]];
		if(d30104MinuteOffset != undefined) {
			var d30104MinuteOffsets = d30104MinuteOffset.split(";");
			var d30104MinuteOffset_left = d30104MinuteOffsets[0];
			var d30104MinuteOffset_top = d30104MinuteOffsets[1];
			createDiv(birthInfos[7], minute, d30104MinuteOffset_left, d30104MinuteOffset_top);
		}
		
		var d30105OffsetProvice = jsonStr[birthInfos[8]];
		var d30105OffsetCity = jsonStr[birthInfos[9]];
		var d30105OffsetCounty = jsonStr[birthInfos[10]];
		var d30105OffsetTown = jsonStr[birthInfos[11]];
		var areaCode = vd301[birthInfos[8]];

		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			var d30105OffsetProviceValue = dataValue[0];
			var d30105OffsetCityValue = dataValue[1];
			var d30105OffsetCountyValue = dataValue[2];
			var d30105OffsetTownValue = dataValue[3];
			if(d30105OffsetProvice != undefined) {
				var d30105OffsetProvices =  d30105OffsetProvice.split(";");
				var d30105OffsetProvices_left = d30105OffsetProvices[0];
				var d30105OffsetProvices_top = d30105OffsetProvices[1];
				createDiv(birthInfos[8], d30105OffsetProviceValue, d30105OffsetProvices_left, d30105OffsetProvices_top);
			}
			if(d30105OffsetCity != undefined) {
				var d30105OffsetCitys =  d30105OffsetCity.split(";");
				var d30105OffsetCitys_left = d30105OffsetCitys[0];
				var d30105OffsetCitys_top = d30105OffsetCitys[1];
				createDiv(birthInfos[9], d30105OffsetCityValue, d30105OffsetCitys_left, d30105OffsetCitys_top);
			}
			if(d30105OffsetCounty != undefined) {
				var d30105OffsetCountys =  d30105OffsetCounty.split(";");
				var d30105OffsetCountys_left = d30105OffsetCountys[0];
				var d30105OffsetCountys_top = d30105OffsetCountys[1];
				createDiv(birthInfos[10], d30105OffsetCountyValue, d30105OffsetCountys_left, d30105OffsetCountys_top);
			}
			if(d30105OffsetTown != undefined) {
				var d30105OffsetTowns =  d30105OffsetTown.split(";");
				var d30105OffsetTowns_left = d30105OffsetTowns[0];
				var d30105OffsetTowns_top = d30105OffsetTowns[1];
				createDiv(birthInfos[11], d30105OffsetTownValue, d30105OffsetTowns_left, d30105OffsetTowns_top);
			}
		}, "json");
		
		var d30107Offset = jsonStr[birthInfos[12]];
		if(d30107Offset != undefined) {
			var d30107Offsets = d30107Offset.split(";");
			var d30107Offsets_left = d30107Offsets[0];
			var d30107Offsets_top = d30107Offsets[1];
			var d30107Value = vd301[birthInfos[12]];
			createDiv(birthInfos[12], d30107Value, d30107Offsets_left, d30107Offsets_top);
		}
		
		var d30109Value = vd301[birthInfos[13]];
		if(d30109Value == "1") {
			var d30109OffsetGood = jsonStr[birthInfos[13]];
			if(d30109OffsetGood != undefined) {
				var d30109OffsetGoods = d30109OffsetGood.split(";");
				d30109OffsetGoods_left = d30109OffsetGoods[0];
				d30109OffsetGoods_top = d30109OffsetGoods[1];
				createDiv(birthInfos[13], symbol, d30109OffsetGoods_left, d30109OffsetGoods_top);
			}
		} else if(d30109Value == "2") {
			var d30109OffsetNormal = jsonStr[birthInfos[14]];
			if(d30109OffsetNormal != undefined) {
				var d30109OffsetNormals = d30109OffsetNormal.split(";");
				d30109OffsetNormals_left = d30109OffsetNormals[0];
				d30109OffsetNormals_top = d30109OffsetNormals[1];
				createDiv(birthInfos[14], symbol, d30109OffsetNormals_left, d30109OffsetNormals_top);
			}
		} else if(d30109Value == "3") {
			var d30109OffsetBad = jsonStr[birthInfos[15]];
			if(d30109OffsetBad != undefined) {
				var d30109OffsetBads = d30109OffsetBad.split(";");
				d30109OffsetBads_left = d30109OffsetBads[0];
				d30109OffsetBads_top = d30109OffsetBads[1];
				createDiv(birthInfos[15], symbol, d30109OffsetBads_left, d30109OffsetBads_top);
			}
		}
		
		var d30129Offset = jsonStr[birthInfos[16]];
		if(d30129Offset != undefined) {
			var d30129Offsets = d30129Offset.split(";");
			var d30129Offsets_left = d30129Offsets[0];
			var d30129Offsets_top = d30129Offsets[1];
			var d30129Value = vd301[birthInfos[16]];
			createDiv(birthInfos[16], d30129Value, d30129Offsets_left, d30129Offsets_top);
		}
		
		var d30108Offset = jsonStr[birthInfos[17]];
		if(d30108Offset != undefined) {
			var d30108Offsets = d30108Offset.split(";");
			var d30108Offsets_left = d30108Offsets[0];
			var d30108Offsets_top = d30108Offsets[1];
			var d30108Value = vd301[birthInfos[17]];
			createDiv(birthInfos[17], d30108Value, d30108Offsets_left, d30108Offsets_top);
		}
		
		var d30111Offset = jsonStr[birthInfos[18]];
		if(d30111Offset != undefined) {
			var d30111Offsets = d30111Offset.split(";");
			var d30111Offsets_left = d30111Offsets[0];
			var d30111Offsets_top = d30111Offsets[1];
			var d30111Value = vd301[birthInfos[18]];
			createDiv(birthInfos[18], d30111Value, d30111Offsets_left, d30111Offsets_top);
		}
		
		var d30113Offset = jsonStr[birthInfos[19]];
		if(d30113Offset != undefined) {
			var d30113Offsets = d30113Offset.split(";");
			var d30113Offsets_left = d30113Offsets[0];
			var d30113Offsets_top = d30113Offsets[1];
			var d30113Value = vd301[birthInfos[19]];
			createDiv(birthInfos[19], d30113Value, d30113Offsets_left, d30113Offsets_top);
		}
		
		var d30114ZhOffset = jsonStr[birthInfos[20]];
		if(d30114ZhOffset != undefined) {
			var d30114ZhOffsets = d30114ZhOffset.split(";");
			var d30114ZhOffsets_left = d30114ZhOffsets[0];
			var d30114ZhOffsets_top = d30114ZhOffsets[1];
			var d30114ZhValue = vd301[birthInfos[20]];
			createDiv(birthInfos[20], d30114ZhValue, d30114ZhOffsets_left, d30114ZhOffsets_top);
		}
		
		var d30115ZhOffset = jsonStr[birthInfos[21]];
		if(d30115ZhOffset != undefined) {
			var d30115ZhOffsets = d30115ZhOffset.split(";");
			var d30115ZhOffsets_left = d30115ZhOffsets[0];
			var d30115ZhOffsets_top = d30115ZhOffsets[1];
			var d30115ZhValue = vd301[birthInfos[21]];
			createDiv(birthInfos[21], d30115ZhValue, d30115ZhOffsets_left, d30115ZhOffsets_top);
		}
		
		var d30112Offset = jsonStr[birthInfos[22]];
		if(d30112Offset != undefined) {
			var d30112Offsets = d30112Offset.split(";");
			var d30112Offsets_left = d30112Offsets[0];
			var d30112Offsets_top = d30112Offsets[1];
			var d30112Value = vd301[birthInfos[22]];
			createDiv(birthInfos[22], d30112Value, d30112Offsets_left, d30112Offsets_top);
		}
		
		var d30116Offset = jsonStr[birthInfos[23]];
		if(d30116Offset != undefined) {
			var d30116Offsets = d30116Offset.split(";");
			var d30116Offsets_left = d30116Offsets[0];
			var d30116Offsets_top = d30116Offsets[1];
			var d30116Value = vd301[birthInfos[23]];
			createDiv(birthInfos[23], d30116Value, d30116Offsets_left, d30116Offsets_top);
		}
		
		var d30118Offset = jsonStr[birthInfos[24]];
		if(d30118Offset != undefined) {
			var d30118Offsets = d30118Offset.split(";");
			var d30118Offsets_left = d30118Offsets[0];
			var d30118Offsets_top = d30118Offsets[1];
			var d30118Value = vd301[birthInfos[24]];
			createDiv(birthInfos[24], d30118Value, d30118Offsets_left, d30118Offsets_top);
		}
		
		var d30119Offset = jsonStr[birthInfos[25]];
		if(d30119Offset != undefined) {
			var d30119Offsets = d30119Offset.split(";");
			var d30119Offsets_left = d30119Offsets[0];
			var d30119Offsets_top = d30119Offsets[1];
			var d30119Value = vd301[birthInfos[25]];
			createDiv(birthInfos[25], d30119Value, d30119Offsets_left, d30119Offsets_top);
		}
		
		var d30120Offset = jsonStr[birthInfos[26]];
		if(d30120Offset != undefined) {
			var d30120Offsets = d30120Offset.split(";");
			var d30120Offsets_left = d30120Offsets[0];
			var d30120Offsets_top = d30120Offsets[1];
			var d30120Value = vd301[birthInfos[26]];
			createDiv(birthInfos[26], d30120Value, d30120Offsets_left, d30120Offsets_top);
		}
		
		var d30117Offset = jsonStr[birthInfos[27]];
		if(d30117Offset != undefined) {
			var d30117Offsets = d30117Offset.split(";");
			var d30117Offsets_left = d30117Offsets[0];
			var d30117Offsets_top = d30117Offsets[1];
			var d30117Value = vd301[birthInfos[27]];
			createDiv(birthInfos[27], d30117Value, d30117Offsets_left, d30117Offsets_top);
		}
		
		var d30122Value = vd301[birthInfos[28]];
		if(d30122Value == "1") {
			var d30122OffsetHospital = jsonStr[birthInfos[28]];
			if(d30122OffsetHospital != undefined) {
				var d30122OffsetHospitals = d30122OffsetHospital.split(";");
				d30122OffsetHospitals_left = d30122OffsetHospitals[0];
				d30122OffsetHospitals_top = d30122OffsetHospitals[1];
				createDiv(birthInfos[28], symbol, d30122OffsetHospitals_left, d30122OffsetHospitals_top);
			}
		} else if(d30122Value == "2") {
			var d30122OffsetHealth = jsonStr[birthInfos[29]];
			if(d30122OffsetHealth != undefined) {
				var d30122OffsetHealths = d30122OffsetHealth.split(";");
				d30122OffsetHealths_left = d30122OffsetHealths[0];
				d30122OffsetHealths_top = d30122OffsetHealths[1];
				createDiv(birthInfos[29], symbol, d30122OffsetHealths_left, d30122OffsetHealths_top);
			}
		}else if(d30122Value == "3"){
			var d30122OffsetFamily = jsonStr[birthInfos[30]];
			if(d30122OffsetFamily != undefined) {
				var d30122OffsetFamilys = d30122OffsetFamily.split(";");
				d30122OffsetFamilys_left = d30122OffsetFamilys[0];
				d30122OffsetFamilys_top = d30122OffsetFamilys[1];
				createDiv(birthInfos[30], symbol, d30122OffsetFamilys_left, d30122OffsetFamilys_top);
			}
		} else if(d30122Value == "4") {
			var d30122OffsetOther = jsonStr[birthInfos[31]];
			if(d30122OffsetOther != undefined) {
				var d30122OffsetOthers = d30122OffsetOther.split(";");
				d30122OffsetOthers_left = d30122OffsetOthers[0];
				d30122OffsetOthers_top = d30122OffsetOthers[1];
				createDiv(birthInfos[31], symbol, d30122OffsetOthers_left, d30122OffsetOthers_top);
			}
			
			var d30123Offset = jsonStr[birthInfos[32]];
			if(d30123Offset != undefined) {
				var d30123Offsets = d30123Offset.split(";");
				d30123Offsets_left = d30123Offsets[0];
				d30123Offsets_top = d30123Offsets[1];
				createDiv(birthInfos[32], vd301[birthInfos[32]], d30123Offsets_left, d30123Offsets_top);
			}
		}
		
		var d30124Offset = jsonStr[birthInfos[33]];
		if(d30124Offset != undefined) {
			var d30124Offsets = d30124Offset.split(";");
			var d30124Offsets_left = d30124Offsets[0];
			var d30124Offsets_top = d30124Offsets[1];
			var d30124Value = vd301[birthInfos[33]];
			if(d30124Value == null || "" == d30124Value || d30124Value == undefined || d30124Value == "///" && (d30124Value == undefined || "" == d30124Value || d30124Value == undefined)){
				d30124Value = "//////////////////" ;
			}
			createDiv(birthInfos[33], d30124Value, d30124Offsets_left, d30124Offsets_top);
		}
		
		var d30128Value = vd301[birthInfos[34]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30128Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30128OffsetYear = jsonStr[birthInfos[34]];
		if(d30128OffsetYear != undefined) {
			var d30128OffsetYears = d30128OffsetYear.split(";");
			var d30128OffsetYear_left = d30128OffsetYears[0];
			var d30128OffsetYear_top = d30128OffsetYears[1];
			createDiv(birthInfos[34], yearS, d30128OffsetYear_left, d30128OffsetYear_top);
		}
		
		var d30128OffsetMonth = jsonStr[birthInfos[35]];
		if(d30128OffsetMonth != undefined) {
			var d30128OffsetMonths = d30128OffsetMonth.split(";");
			var d30128OffsetMonths_left = d30128OffsetMonths[0];
			var d30128OffsetMonths_top = d30128OffsetMonths[1];
			createDiv(birthInfos[35], monthS, d30128OffsetMonths_left, d30128OffsetMonths_top);
		}
		
		var d30128OffsetDate = jsonStr[birthInfos[36]];
		if(d30128OffsetDate != undefined) {
			var d30128OffsetDates = d30128OffsetDate.split(";");
			var d30128OffsetDates_left = d30128OffsetDates[0];
			var d30128OffsetDates_top = d30128OffsetDates[1];
			createDiv(birthInfos[36], dateS, d30128OffsetDates_left, d30128OffsetDates_top);
		}
	}, "json");
	
	$.post(contextRoot + "/PrintBirthInfoServlet", {"flag":"BIRTH_PRINTINFO_SECOND","d30110":d30110}, function(dataVD301S){
		var jsonStrS = dataVD301S[0];
		var vd301S = dataVD301S[1];
		
		var birthInfosS = birthInfo[1].split(";");

		var birthInfosD30102OSffset = jsonStrS[birthInfosS[0]];
		if(birthInfosD30102OSffset != undefined) {
			var d30102SOffset = birthInfosD30102OSffset.split(";");
			var d30102SOffset_left = d30102SOffset[0];
			var d30102SOffset_top = d30102SOffset[1];
			var d30102SValue = vd301S[birthInfosS[0]];
			createDiv(birthInfosS[0], d30102SValue, d30102SOffset_left, d30102SOffset_top);
		}
		var birthInfosD30103OZhSffset = jsonStrS[birthInfosS[1]];
		if(birthInfosD30103OZhSffset != undefined){
			var d30103ZhSOffset = birthInfosD30103OZhSffset.split(";");
			var d30103ZhSOffset_left = d30103ZhSOffset[0];
			var d30103ZhSOffset_top = d30103ZhSOffset[1];
			var d30103ZhSValue = vd301S[birthInfosS[1]];
			createDiv(birthInfosS[1], d30103ZhSValue, d30103ZhSOffset_left, d30103ZhSOffset_top);
		}
		
		var d30104SValue = vd301S[birthInfosS[2]];
		var regsS = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/;  
		var timeVsS = "";
		var yearsS = "";
		var monthsS = "";
		var datesS = "";
		var hourS = "";
		var minuteS = "";
		if(d30104SValue != ""){
			timeVsS = regsS.exec(d30104SValue);
			yearsS = timeVsS[1];
			monthsS = timeVsS[2];
			datesS = timeVsS[3];
			hourS = timeVsS[4];
			minuteS = timeVsS[5];
		}
		
		var d30104SOffsetYear = jsonStrS[birthInfosS[2]];
		var d30104SOffsetYears = d30104SOffsetYear.split(";");
		var d30104SOffsetYear_left = d30104SOffsetYears[0];
		var d30104SOffsetYear_top = d30104SOffsetYears[1];
		
		var d30104SOffsetMonth = jsonStrS[birthInfosS[3]];
		var d30104SOffsetMonths = d30104SOffsetMonth.split(";");
		var d30104SOffsetMonth_left = d30104SOffsetMonths[0];
		var d30104SOffsetMonth_top = d30104SOffsetMonths[1];
		
		var d30104SOffsetDate = jsonStrS[birthInfosS[4]];
		var d30104SOffsetDates = d30104SOffsetDate.split(";");
		var d30104SOffsetDate_left = d30104SOffsetDates[0];
		var d30104SOffsetDate_top = d30104SOffsetDates[1];
		
		var d30104SOffsetHour = jsonStrS[birthInfosS[5]];
		var d30104SOffsetHours = d30104SOffsetHour.split(";");
		var d30104SOffsetHour_left = d30104SOffsetHours[0];
		var d30104SOffsetHour_top = d30104SOffsetHours[1];
		
		var d30104SOffsetMinute = jsonStrS[birthInfosS[6]];
		var d30104SOffsetMinutes = d30104SOffsetMinute.split(";");
		var d30104SOffsetMinute_left = d30104SOffsetMinutes[0];
		var d30104SOffsetMinute_top = d30104SOffsetMinutes[1];
		
		if(d30104SOffsetYears != undefined){
			createDiv(birthInfosS[2], yearsS, d30104SOffsetYear_left, d30104SOffsetYear_top);
		}
		if(d30104SOffsetMonth != undefined){
			createDiv(birthInfosS[3], monthsS, d30104SOffsetMonth_left, d30104SOffsetMonth_top);
		}
		if(d30104SOffsetDate != undefined){
			createDiv(birthInfosS[4], datesS, d30104SOffsetDate_left, d30104SOffsetDate_top);
		}
		if(d30104SOffsetHour != undefined){
			createDiv(birthInfosS[5], hourS, d30104SOffsetHour_left, d30104SOffsetHour_top);
		}
		if(d30104SOffsetMinute != undefined){
			createDiv(birthInfosS[6], minuteS, d30104SOffsetMinute_left, d30104SOffsetMinute_top);
		}
		
		var birthInfosD30105ZhSffset = jsonStrS[birthInfosS[7]];
		if(birthInfosD30105ZhSffset != undefined){
			var d30105ZhSOffset = birthInfosD30105ZhSffset.split(";");
			var d30105ZhSOffset_left = d30105ZhSOffset[0];
			var d30105ZhSOffset_top = d30105ZhSOffset[1];
			var d30105ZhSValue = vd301S[birthInfosS[7]];
			createDiv(birthInfosS[7], d30105ZhSValue, d30105ZhSOffset_left, d30105ZhSOffset_top);
		}
		
		var birthInfosD30111Sffset = jsonStrS[birthInfosS[8]];
		if(birthInfosD30111Sffset != undefined){
			var d30111Sffset = birthInfosD30111Sffset.split(";");
			var d30111Sffset_left = d30111Sffset[0];
			var d30111Sffset_top = d30111Sffset[1];
			var d30111SValue = vd301S[birthInfosS[8]];
			createDiv(birthInfosS[8], d30111SValue, d30111Sffset_left, d30111Sffset_top);
		}
		
		var birthInfosD30113Sffset = jsonStrS[birthInfosS[9]];
		if(birthInfosD30113Sffset != undefined){
			var d30113Sffset = birthInfosD30113Sffset.split(";");
			var d30113Sffset_left = d30113Sffset[0];
			var d30113Sffset_top = d30113Sffset[1];
			var d30113SValue = vd301S[birthInfosS[9]];
			createDiv(birthInfosS[9], d30113SValue, d30113Sffset_left, d30113Sffset_top);
		}
		
		var birthInfosD30114ZhSffset = jsonStrS[birthInfosS[10]];
		if(birthInfosD30114ZhSffset != undefined){
			var d30114ZhSOffset = birthInfosD30114ZhSffset.split(";");
			var d30114ZhSOffset_left = d30114ZhSOffset[0];
			var d30114ZhSOffset_top = d30114ZhSOffset[1];
			var d30114ZhSValue = vd301S[birthInfosS[10]];
			createDiv(birthInfosS[10], d30114ZhSValue, d30114ZhSOffset_left, d30114ZhSOffset_top);
		}
		
		var birthInfosD30115ZhSffset = jsonStrS[birthInfosS[11]];
		if(birthInfosD30115ZhSffset != undefined){
			var d30115ZhSOffset = birthInfosD30115ZhSffset.split(";");
			var d30115ZhSOffset_left = d30115ZhSOffset[0];
			var d30115ZhSOffset_top = d30115ZhSOffset[1];
			var d30115ZhSValue = vd301S[birthInfosS[11]];
			createDiv(birthInfosS[11], d30115ZhSValue, d30115ZhSOffset_left, d30115ZhSOffset_top);
		}
		
		var birthInfosD30112Sffset = jsonStrS[birthInfosS[12]];
		if(birthInfosD30112Sffset != undefined){
			var d30112Sffset = birthInfosD30112Sffset.split(";");
			var d30112Sffset_left = d30112Sffset[0];
			var d30112Sffset_top = d30112Sffset[1];
			var d30112SValue = vd301S[birthInfosS[12]];
			createDiv(birthInfosS[12], d30112SValue, d30112Sffset_left, d30112Sffset_top);
		}
		
		var birthInfosD30116Sffset = jsonStrS[birthInfosS[13]];
		if(birthInfosD30116Sffset != undefined){
			var d30116Sffset = birthInfosD30116Sffset.split(";");
			var d30116Sffset_left = d30116Sffset[0];
			var d30116Sffset_top = d30116Sffset[1];
			var d30116SValue = vd301S[birthInfosS[13]];
			createDiv(birthInfosS[13], d30116SValue, d30116Sffset_left, d30116Sffset_top);
		}
		
		var birthInfosD30118Sffset = jsonStrS[birthInfosS[14]];
		if(birthInfosD30118Sffset != undefined){
			var d30118Sffset = birthInfosD30118Sffset.split(";");
			var d30118Sffset_left = d30118Sffset[0];
			var d30118Sffset_top = d30118Sffset[1];
			var d30118SValue = vd301S[birthInfosS[14]];
			createDiv(birthInfosS[14], d30118SValue, d30118Sffset_left, d30118Sffset_top);
		}
		
		var birthInfosD30119ZhSffset = jsonStrS[birthInfosS[15]];
		if(birthInfosD30119ZhSffset != undefined){
			var d30119ZhSOffset = birthInfosD30119ZhSffset.split(";");
			var d30119ZhSOffset_left = d30119ZhSOffset[0];
			var d30119ZhSOffset_top = d30119ZhSOffset[1];
			var d30119ZhSValue = vd301S[birthInfosS[15]];
			createDiv(birthInfosS[15], d30119ZhSValue, d30119ZhSOffset_left, d30119ZhSOffset_top);
		}
		
		var birthInfosD30120ZhSffset = jsonStrS[birthInfosS[16]];
		if(birthInfosD30120ZhSffset != undefined){
			var d30120ZhSOffset = birthInfosD30120ZhSffset.split(";");
			var d30120ZhSOffset_left = d30120ZhSOffset[0];
			var d30120ZhSOffset_top = d30120ZhSOffset[1];
			var d30120ZhSValue = vd301S[birthInfosS[16]];
			createDiv(birthInfosS[16], d30120ZhSValue, d30120ZhSOffset_left, d30120ZhSOffset_top);
		}
		
		var birthInfosD30117Sffset = jsonStrS[birthInfosS[17]];
		if(birthInfosD30117Sffset != undefined){
			var d30117Sffset = birthInfosD30117Sffset.split(";");
			var d30117Sffset_left = d30117Sffset[0];
			var d30117Sffset_top = d30117Sffset[1];
			var d30117SValue = vd301S[birthInfosS[17]];
			createDiv(birthInfosS[17], d30117SValue, d30117Sffset_left, d30117Sffset_top);
		}
		
		var birthInfosD30121Sffset = jsonStrS[birthInfosS[18]];
		if(birthInfosD30121Sffset != undefined){
			var d30121Sffset = birthInfosD30121Sffset.split(";");
			var d30121Sffset_left = d30121Sffset[0];
			var d30121Sffset_top = d30121Sffset[1];
			var d30121SValue = vd301S[birthInfosS[18]];
			createDiv(birthInfosS[18], d30121SValue, d30121Sffset_left, d30121Sffset_top);
		}
		
		var d30128SValue = vd301S[birthInfosS[19]];
		var regD30128S = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeD30128S = regD30128S.exec(d30128SValue);
		var yearD30128S = timeD30128S[1];
		var monthD30128S = timeD30128S[2];
		var dateD30128S = timeD30128S[3];
		
		var d30128SOffsetYear = jsonStrS[birthInfosS[19]];
		var d30128SOffsetYears = d30128SOffsetYear.split(";");
		var d30128SOffsetYear_left = d30128SOffsetYears[0];
		var d30128SOffsetYear_top = d30128SOffsetYears[1];
		if(d30128SOffsetYear != undefined){
			createDiv(birthInfosS[19], yearD30128S, d30128SOffsetYear_left, d30128SOffsetYear_top);
		}
		
		var d30128SOffsetMonth = jsonStrS[birthInfosS[20]];
		var d30128SOffsetMonths = d30128SOffsetMonth.split(";");
		var d30128SOffsetMonth_left = d30128SOffsetMonths[0];
		var d30128SOffsetMonth_top = d30128SOffsetMonths[1];
		if(d30128SOffsetMonth != undefined){
			createDiv(birthInfosS[20], monthD30128S, d30128SOffsetMonth_left, d30128SOffsetMonth_top);
		}
		
		var d30128SOffsetDate = jsonStrS[birthInfosS[21]];
		var d30128SOffsetDates = d30128SOffsetDate.split(";");
		var d30128SOffsetDate_left = d30128SOffsetDates[0];
		var d30128SOffsetDate_top = d30128SOffsetDates[1];
		if(d30128SOffsetDate != undefined){
			createDiv(birthInfosS[21], dateD30128S, d30128SOffsetDate_left, d30128SOffsetDate_top);
		}
	}, "json");
	
	$.post(contextRoot + "/PrintBirthInfoServlet", {"flag":"BIRTH_PRINTINFO_THIRD","d30110":d30110}, function(dataVD301T){
		var jsonStrT = dataVD301T[0];
		var vd301T = dataVD301T[1];
		
		var birthInfosT = birthInfo[2].split(";");
		
		var birthInfosD30102OTffset = jsonStrT[birthInfosT[0]];
		if(birthInfosD30102OTffset != undefined) {
			var d30102TOffset = birthInfosD30102OTffset.split(";");
			var d30102TOffset_left = d30102TOffset[0];
			var d30102TOffset_top = d30102TOffset[1];
			var d30102TValue = vd301T[birthInfosT[0]];
			createDiv(birthInfosT[0], d30102TValue, d30102TOffset_left, d30102TOffset_top);
		}
		
		var birthInfosD30103OZhTffset = jsonStrT[birthInfosT[1]];
		if(birthInfosD30103OZhTffset != undefined){
			var d30103ZhTOffset = birthInfosD30103OZhTffset.split(";");
			var d30103ZhTOffset_left = d30103ZhTOffset[0];
			var d30103ZhTOffset_top = d30103ZhTOffset[1];
			var d30103ZhTValue = vd301T[birthInfosT[1]];
			createDiv(birthInfosT[1], d30103ZhTValue, d30103ZhTOffset_left, d30103ZhTOffset_top);
		}
		
		var d30104TValue = vd301T[birthInfosT[2]];
		var regsT = /(\d{4})-(\d{2})-(\d{2})\s{1}(\d{2}):(\d{2})/;  
		var timeVsT = "";
		var yearsT = "";
		var monthsT = "";
		var datesT = "";
		var hourT = "";
		var minuteT = "";
		if(d30104TValue != ""){
			timeVsT = regsT.exec(d30104TValue);
			yearsT = timeVsT[1];
			monthsT = timeVsT[2];
			datesT = timeVsT[3];
			hourT = timeVsT[4];
			minuteT = timeVsT[5];
		}
		
		var d30104TOffsetYear = jsonStrT[birthInfosT[2]];
		var d30104TOffsetYears = d30104TOffsetYear.split(";");
		var d30104TOffsetYear_left = d30104TOffsetYears[0];
		var d30104TOffsetYear_top = d30104TOffsetYears[1];
		
		var d30104TOffsetMonth = jsonStrT[birthInfosT[3]];
		var d30104TOffsetMonths = d30104TOffsetMonth.split(";");
		var d30104TOffsetMonth_left = d30104TOffsetMonths[0];
		var d30104TOffsetMonth_top = d30104TOffsetMonths[1];
		
		var d30104TOffsetDate = jsonStrT[birthInfosT[4]];
		var d30104TOffsetDates = d30104TOffsetDate.split(";");
		var d30104TOffsetDate_left = d30104TOffsetDates[0];
		var d30104TOffsetDate_top = d30104TOffsetDates[1];
		
		var d30104TOffsetHour = jsonStrT[birthInfosT[5]];
		var d30104TOffsetHours = d30104TOffsetHour.split(";");
		var d30104TOffsetHour_left = d30104TOffsetHours[0];
		var d30104TOffsetHour_top = d30104TOffsetHours[1];
		
		var d30104TOffsetMinute = jsonStrT[birthInfosT[6]];
		var d30104TOffsetMinutes = d30104TOffsetMinute.split(";");
		var d30104TOffsetMinute_left = d30104TOffsetMinutes[0];
		var d30104TOffsetMinute_top = d30104TOffsetMinutes[1];
		
		if(d30104TOffsetYears != undefined){
			createDiv(birthInfosT[2], yearsT, d30104TOffsetYear_left, d30104TOffsetYear_top);
		}
		if(d30104TOffsetMonth != undefined){
			createDiv(birthInfosT[3], monthsT, d30104TOffsetMonth_left, d30104TOffsetMonth_top);
		}
		if(d30104TOffsetDate != undefined){
			createDiv(birthInfosT[4], datesT, d30104TOffsetDate_left, d30104TOffsetDate_top);
		}
		if(d30104TOffsetHour != undefined){
			createDiv(birthInfosT[5], hourT, d30104TOffsetHour_left, d30104TOffsetHour_top);
		}
		if(d30104TOffsetMinute != undefined){
			createDiv(birthInfosT[6], minuteT, d30104TOffsetMinute_left, d30104TOffsetMinute_top);
		}
		
		var birthInfosD30105ZhTffset = jsonStrT[birthInfosT[7]];
		if(birthInfosD30105ZhTffset != undefined){
			var d30105ZhTOffset = birthInfosD30105ZhTffset.split(";");
			var d30105ZhTOffset_left = d30105ZhTOffset[0];
			var d30105ZhTOffset_top = d30105ZhTOffset[1];
			var d30105ZhTValue = vd301T[birthInfosT[7]];
			createDiv(birthInfosT[7], d30105ZhTValue, d30105ZhTOffset_left, d30105ZhTOffset_top);
		}
		
		var birthInfosD30111Tffset = jsonStrT[birthInfosT[8]];
		if(birthInfosD30111Tffset != undefined){
			var d30111Tffset = birthInfosD30111Tffset.split(";");
			var d30111Tffset_left = d30111Tffset[0];
			var d30111Tffset_top = d30111Tffset[1];
			var d30111TValue = vd301T[birthInfosT[8]];
			createDiv(birthInfosT[8], d30111TValue, d30111Tffset_left, d30111Tffset_top);
		}
		
		var birthInfosD30113Tffset = jsonStrT[birthInfosT[9]];
		if(birthInfosD30113Tffset != undefined){
			var d30113Tffset = birthInfosD30113Tffset.split(";");
			var d30113Tffset_left = d30113Tffset[0];
			var d30113Tffset_top = d30113Tffset[1];
			var d30113TValue = vd301T[birthInfosT[9]];
			createDiv(birthInfosT[9], d30113TValue, d30113Tffset_left, d30113Tffset_top);
		}
		
		var birthInfosD30114ZhTffset = jsonStrT[birthInfosT[10]];
		if(birthInfosD30114ZhTffset != undefined){
			var d30114ZhTOffset = birthInfosD30114ZhTffset.split(";");
			var d30114ZhTOffset_left = d30114ZhTOffset[0];
			var d30114ZhTOffset_top = d30114ZhTOffset[1];
			var d30114ZhTValue = vd301T[birthInfosT[10]];
			createDiv(birthInfosT[10], d30114ZhTValue, d30114ZhTOffset_left, d30114ZhTOffset_top);
		}
		
		var birthInfosD30115ZhTffset = jsonStrT[birthInfosT[11]];
		if(birthInfosD30115ZhTffset != undefined){
			var d30115ZhTOffset = birthInfosD30115ZhTffset.split(";");
			var d30115ZhTOffset_left = d30115ZhTOffset[0];
			var d30115ZhTOffset_top = d30115ZhTOffset[1];
			var d30115ZhTValue = vd301T[birthInfosT[11]];
			createDiv(birthInfosT[11], d30115ZhTValue, d30115ZhTOffset_left, d30115ZhTOffset_top);
		}
		
		var birthInfosD30112Tffset = jsonStrT[birthInfosT[12]];
		if(birthInfosD30112Tffset != undefined){
			var d30112Tffset = birthInfosD30112Tffset.split(";");
			var d30112Tffset_left = d30112Tffset[0];
			var d30112Tffset_top = d30112Tffset[1];
			var d30112TValue = vd301T[birthInfosT[12]];
			createDiv(birthInfosT[12], d30112TValue, d30112Tffset_left, d30112Tffset_top);
		}
		
		var birthInfosD30116Tffset = jsonStrT[birthInfosT[13]];
		if(birthInfosD30116Tffset != undefined){
			var d30116Tffset = birthInfosD30116Tffset.split(";");
			var d30116Tffset_left = d30116Tffset[0];
			var d30116Tffset_top = d30116Tffset[1];
			var d30116TValue = vd301T[birthInfosT[13]];
			createDiv(birthInfosT[13], d30116TValue, d30116Tffset_left, d30116Tffset_top);
		}
		
		var birthInfosD30118Tffset = jsonStrT[birthInfosT[14]];
		if(birthInfosD30118Tffset != undefined){
			var d30118Tffset = birthInfosD30118Tffset.split(";");
			var d30118Tffset_left = d30118Tffset[0];
			var d30118Tffset_top = d30118Tffset[1];
			var d30118TValue = vd301T[birthInfosT[14]];
			createDiv(birthInfosT[14], d30118TValue, d30118Tffset_left, d30118Tffset_top);
		}
		
		var birthInfosD30119ZhTffset = jsonStrT[birthInfosT[15]];
		if(birthInfosD30119ZhTffset != undefined){
			var d30119ZhTOffset = birthInfosD30119ZhTffset.split(";");
			var d30119ZhTOffset_left = d30119ZhTOffset[0];
			var d30119ZhTOffset_top = d30119ZhTOffset[1];
			var d30119ZhTValue = vd301T[birthInfosT[15]];
			createDiv(birthInfosT[15], d30119ZhTValue, d30119ZhTOffset_left, d30119ZhTOffset_top);
		}
		
		var birthInfosD30120ZhTffset = jsonStrT[birthInfosT[16]];
		if(birthInfosD30120ZhTffset != undefined){
			var d30120ZhTOffset = birthInfosD30120ZhTffset.split(";");
			var d30120ZhTOffset_left = d30120ZhTOffset[0];
			var d30120ZhTOffset_top = d30120ZhTOffset[1];
			var d30120ZhTValue = vd301T[birthInfosT[16]];
			createDiv(birthInfosT[16], d30120ZhTValue, d30120ZhTOffset_left, d30120ZhTOffset_top);
		}
		
		var birthInfosD30117Tffset = jsonStrT[birthInfosT[17]];
		if(birthInfosD30117Tffset != undefined){
			var d30117Tffset = birthInfosD30117Tffset.split(";");
			var d30117Tffset_left = d30117Tffset[0];
			var d30117Tffset_top = d30117Tffset[1];
			var d30117TValue = vd301T[birthInfosT[17]];
			createDiv(birthInfosT[17], d30117TValue, d30117Tffset_left, d30117Tffset_top);
		}
		
		var birthInfosD30121Tffset = jsonStrT[birthInfosT[18]];
		if(birthInfosD30121Tffset != undefined){
			var d30121Tffset = birthInfosD30121Tffset.split(";");
			var d30121Tffset_left = d30121Tffset[0];
			var d30121Tffset_top = d30121Tffset[1];
			var d30121TValue = vd301T[birthInfosT[18]];
			createDiv(birthInfosT[18], d30121TValue, d30121Tffset_left, d30121Tffset_top);
		}
		
		var d30128TValue = vd301T[birthInfosT[19]];
		var regD30128T = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeD30128T = regD30128T.exec(d30128TValue);
		var yearD30128T = timeD30128T[1];
		var monthD30128T = timeD30128T[2];
		var dateD30128T = timeD30128T[3];
		
		var d30128TOffsetYear = jsonStrT[birthInfosT[19]];
		var d30128TOffsetYears = d30128TOffsetYear.split(";");
		var d30128TOffsetYear_left = d30128TOffsetYears[0];
		var d30128TOffsetYear_top = d30128TOffsetYears[1];
		if(d30128TOffsetYear != undefined){
			createDiv(birthInfosT[19], yearD30128T, d30128TOffsetYear_left, d30128TOffsetYear_top);
		}
		
		var d30128TOffsetMonth = jsonStrT[birthInfosT[20]];
		var d30128TOffsetMonths = d30128TOffsetMonth.split(";");
		var d30128TOffsetMonth_left = d30128TOffsetMonths[0];
		var d30128TOffsetMonth_top = d30128TOffsetMonths[1];
		if(d30128TOffsetMonth != undefined){
			createDiv(birthInfosT[20], monthD30128T, d30128TOffsetMonth_left, d30128TOffsetMonth_top);
		}
		
		var d30128TOffsetDate = jsonStrT[birthInfosT[21]];
		var d30128TOffsetDates = d30128TOffsetDate.split(";");
		var d30128TOffsetDate_left = d30128TOffsetDates[0];
		var d30128TOffsetDate_top = d30128TOffsetDates[1];
		if(d30128TOffsetDate != undefined){
			createDiv(birthInfosT[21], dateD30128T, d30128TOffsetDate_left, d30128TOffsetDate_top);
		}
	}, "json");
});

function createDiv(id, value, offset_left, offset_top)
{
	$("body").append($("<div></div>").attr("id", id).text(value));
	if(id == "d30112" || id == "d30117") {
		$("#" + id).css({"letter-spacing":"7.6px"});
	}
	$("#" + id).css({"position":"absolute", "font-size":"12px"});
	$("#" + id).offset({left:offset_left, top:offset_top});
}