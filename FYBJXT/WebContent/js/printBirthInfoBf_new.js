 var contextRoot = "/csyxzm";
$(document).ready(function(){
	
	var printInfo = new Array();
	var printInfoLabel  = new Array();
	
	printInfo[0] = "BIRTH_PRINTINFOBF_NEW";
	printInfoLabel[0] = "出生证明";

	printInfo[1] = "BIRTH_PRINTINFOBF_SECOND_NEW";
	printInfoLabel[1] = "副页";
	
	printInfo[2] = "BIRTH_PRINTINFOBF_THIRD_NEW";
	printInfoLabel[2] = "存根";
	
	var birthInfo = new Array();
	var birthInfoLabel = new Array();
	
	birthInfo[0] = "d30302;d30303;d30304;d30304m;d30304d;d30304h;d30304mi;d30307;d30331;d30308;d30305;d30305c;d30305co;d30324Zh;d30311;d30313;d30314Zh;d30315Zh;d30321m;d30336id;d30336pa;d30349;d30312;d30316;d30318;d30319Zh;d30320Zh;d30321f;d30337id;d30337pa;d30350;d30317;d30326Zh;d30328;d30328m;d30328d";
	birthInfoLabel[0] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;签发机构;签发年;签发月;签发日";
	birthInfo[1] = "d30302S;d30303S;d30304S;d30304mS;d30304dS;d30304hS;d30304miS;d30307S;d30331S;d30308S;d30305S;d30305cS;d30305coS;d30324ZhS;d30311S;d30313S;d30314ZhS;d30315ZhS;d30321mS;d30336idS;d30336paS;d30349S;d30312S;d30316S;d30318S;d30319ZhS;d30320ZhS;d30321fS;d30337idS;d30337paS;d30350S;d30317S;d30326ZhS;d30328S;d30328mS;d30328dS";
    birthInfoLabel[1] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;签发机构;签发年;签发月;签发日";
	birthInfo[2] = "d30302T;d30303T;d30304T;d30304mT;d30304dT;d30304hT;d30304miT;d30307T;d30331T;d30308T;d30305T;d30305cT;d30305coT;d30324ZhT;d30311T;d30313T;d30314ZhT;d30315ZhT;d30321mT;d30336idT;d30336paT;d30349T;d30312T;d30316T;d30318T;d30319ZhT;d30320ZhT;d30321fT;d30337idT;d30337paT;d30350T;d30317T;d30325T;d30338T;d30327T;d30328T;d30328mT;d30328dT;d30326ZhT";
    birthInfoLabel[2] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;接生人;领证人;签发人;签发年;签发月;签发日;签发机构";
	
	var d30310 = $("#d30310").val();
	var userCode = $("#userCode").val();
	$.post(contextRoot + "/PrintBirthInfoServletNew", {"flag":"BIRTH_PRINTINFOBF_NEW","d30310":d30310, "userCode":userCode}, function(data){
		var jsonStr = data[0];//位置
		var vd303 = data[1];//值
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
		var gender = "";
		birthInfosd30303Offset = jsonStr[birthInfos[1]];
		if(d30303Value == "1") {
			gender = "男";
		} else if(d30303Value == "2") {
			gender = "女";
		} 
		if(birthInfosd30303Offset != "") {
			var d30303Offset = birthInfosd30303Offset.split(";");
			var d30303Offset_left = d30303Offset[0];
			var d30303Offset_top = d30303Offset[1];
			createDiv(birthInfos[1], gender, d30303Offset_left, d30303Offset_top);
		}
		
		var d30304Value = vd303[birthInfos[2]];
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
		
		var d30304Offset = jsonStr[birthInfos[2]];
		if(d30304Offset != undefined) {
			var d30304Offsets = d30304Offset.split(";");
			var d30304Offset_left = d30304Offsets[0];
			var d30304Offset_top = d30304Offsets[1];
			createDiv(birthInfos[2], year, d30304Offset_left, d30304Offset_top);
		}
		
		var d30304MonthOffset = jsonStr[birthInfos[3]];
		if(d30304MonthOffset != undefined) {
			var d30304MonthOffsets = d30304MonthOffset.split(";");
			var d30304MonthOffset_left = d30304MonthOffsets[0];
			var d30304MonthOffset_top = d30304MonthOffsets[1];
			createDiv(birthInfos[3], month, d30304MonthOffset_left, d30304MonthOffset_top);
		}
		
		var d30304DateOffset = jsonStr[birthInfos[4]];
		if(d30304DateOffset != undefined) {
			var d30304DateOffsets = d30304DateOffset.split(";");
			var d30304DateOffset_left = d30304DateOffsets[0];
			var d30304DateOffset_top = d30304DateOffsets[1];
			createDiv(birthInfos[4], date, d30304DateOffset_left, d30304DateOffset_top);
		}
		
		var d30304HourOffset = jsonStr[birthInfos[5]];
		if(d30304HourOffset != undefined) {
			var d30304HourOffsets = d30304HourOffset.split(";");
			var d30304HourOffset_left = d30304HourOffsets[0];
			var d30304HourOffset_top = d30304HourOffsets[1];
			createDiv(birthInfos[5], hour, d30304HourOffset_left, d30304HourOffset_top);
		}
		
		var d30304MinuteOffset = jsonStr[birthInfos[6]];
		if(d30304MinuteOffset != undefined) {
			var d30304MinuteOffsets = d30304MinuteOffset.split(";");
			var d30304MinuteOffset_left = d30304MinuteOffsets[0];
			var d30304MinuteOffset_top = d30304MinuteOffsets[1];
			createDiv(birthInfos[6], minute, d30304MinuteOffset_left, d30304MinuteOffset_top);
		}
		
		var d30307 = vd303[birthInfos[7]]; // weeks
		var d30351 = vd303["d30351"]; // days
		
		var d30307Offset = jsonStr[birthInfos[7]];
		if(d30307Offset != undefined) {
			var d30307Offsets = d30307Offset.split(";");
			var d30307Offset_left = d30307Offsets[0];
			var d30307Offset_top = d30307Offsets[1];
			if(d30351 != undefined && d30351 != 0) {
				createDiv(birthInfos[7], d30307 + "<sup>+" + d30351 + "</sup>", d30307Offset_left, d30307Offset_top);
			}else{
				createDiv(birthInfos[7], d30307, d30307Offset_left, d30307Offset_top);
			}
		}
		
		var d30331 = vd303[birthInfos[8]];
		var d30331Offset = jsonStr[birthInfos[8]];
		if(d30331Offset != undefined) {
			var d30331Offsets = d30331Offset.split(";");
			var d30331Offset_left = d30331Offsets[0];
			var d30331Offset_top = d30331Offsets[1];
			createDiv(birthInfos[8], d30331, d30331Offset_left, d30331Offset_top);
		}
		
		var d30308 = vd303[birthInfos[9]];
		var d30308Offset = jsonStr[birthInfos[9]];
		if(d30308Offset != undefined) {
			var d30308Offsets = d30308Offset.split(";");
			var d30308Offset_left = d30308Offsets[0];
			var d30308Offset_top = d30308Offsets[1];
			createDiv(birthInfos[9], d30308, d30308Offset_left, d30308Offset_top);
		}
		
		var d30305OffsetProviceValue = "";
		var d30305OffsetCityValue = "";
		var d30305OffsetCountyValue = "";
		var areaCode = vd303["d30305"];
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30305OffsetProviceValue = dataValue[0];
			d30305OffsetCityValue = dataValue[1];
			d30305OffsetCountyValue = dataValue[2];
			
			var d30305OffsetProvice = jsonStr[birthInfos[10]];
			var d30305OffsetCity = jsonStr[birthInfos[11]];
			var d30305OffsetCounty = jsonStr[birthInfos[12]];
			if(d30305OffsetProvice != undefined) {
				var d30305OffsetProvices =  d30305OffsetProvice.split(";");
				var d30305OffsetProvices_left = d30305OffsetProvices[0];
				var d30305OffsetProvices_top = d30305OffsetProvices[1];
				createDiv(birthInfos[10], d30305OffsetProviceValue, d30305OffsetProvices_left, d30305OffsetProvices_top);
			}
			if(d30305OffsetCity != undefined) {
				var d30305OffsetCitys =  d30305OffsetCity.split(";");
				var d30305OffsetCitys_left = d30305OffsetCitys[0];
				var d30305OffsetCitys_top = d30305OffsetCitys[1];
				createDiv(birthInfos[11], d30305OffsetCityValue, d30305OffsetCitys_left, d30305OffsetCitys_top);
			}
			if(d30305OffsetCounty != undefined) {
				var d30305OffsetCountys =  d30305OffsetCounty.split(";");
				var d30305OffsetCountys_left = d30305OffsetCountys[0];
				var d30305OffsetCountys_top = d30305OffsetCountys[1];
				createDiv(birthInfos[12], d30305OffsetCountyValue, d30305OffsetCountys_left, d30305OffsetCountys_top);
			}
		}, "json");
		
		var d30324Offset = jsonStr[birthInfos[13]];
		if(d30324Offset != undefined) {
			var d30324Offsets = d30324Offset.split(";");
			var d30324Offsets_left = d30324Offsets[0];
			var d30324Offsets_top = d30324Offsets[1];
			var d30324Value = vd303[birthInfos[13]];
			createDiv(birthInfos[13], d30324Value, d30324Offsets_left, d30324Offsets_top);
		}
		
		var d30311Value = vd303[birthInfos[14]];
		
		var d30311Offset = jsonStr[birthInfos[14]];
		if(d30311Offset != undefined) {
			var d30311Offsets = d30311Offset.split(";");
			d30311Offset_left = d30311Offsets[0];
			d30311Offset_top = d30311Offsets[1];
			//母亲姓名
			if(d30311Value == undefined || "" == d30311Value || d30311Value == null){
				d30311Value = "///" ;
			}
			createDiv(birthInfos[14], d30311Value, d30311Offset_left, d30311Offset_top);
		}
		
		var d30313Offset = jsonStr[birthInfos[15]];
		if(d30313Offset != undefined) {
			var d30313Offsets = d30313Offset.split(";");
			var d30313Offsets_left = d30313Offsets[0];
			var d30313Offsets_top = d30313Offsets[1];
			var d30313Value = vd303[birthInfos[15]];
			//母亲年龄
			if(d30313Value == undefined || "" == d30313Value || d30313Value == null){
				d30313Value = "//" ;
			}
			createDiv(birthInfos[15], d30313Value, d30313Offsets_left, d30313Offsets_top);
		}
		
		var d30314Offset = jsonStr[birthInfos[16]];
		if(d30314Offset != undefined) {
			var d30314Offsets = d30314Offset.split(";");
			var d30314Offsets_left = d30314Offsets[0];
			var d30314Offsets_top = d30314Offsets[1];
			var d30314Value = vd303[birthInfos[16]];
			//母亲国籍
			if(d30314Value == null || "" == d30314Value || d30314Value == undefined){
				d30314Value = "//" ;
			}
			createDiv(birthInfos[16], d30314Value, d30314Offsets_left, d30314Offsets_top);
		}
		
		var d30315Offset = jsonStr[birthInfos[17]];
		if(d30315Offset != undefined) {
			var d30315Offsets = d30315Offset.split(";");
			var d30315Offsets_left = d30315Offsets[0];
			var d30315Offsets_top = d30315Offsets[1];
			var d30315Value = vd303[birthInfos[17]];
			//母亲民族
			if(d30315Value == null || "" == d30315Value || d30315Value == undefined){
				d30315Value = "//" ;
			}
			createDiv(birthInfos[17], d30315Value, d30315Offsets_left, d30315Offsets_top);
		}
		
		var d30321mOffset = jsonStr[birthInfos[18]];
		if(d30321mOffset != undefined) {
			var d30321mOffsets = d30321mOffset.split(";");
			var d30321mOffsets_left = d30321mOffsets[0];
			var d30321mOffsets_top = d30321mOffsets[1];
			var d30321mValue = vd303["d30321"];
			//母亲家庭地址
			if(d30311Value == "///" && (d30321mValue == null || "" == d30321mValue || d30321mValue == undefined)){
				d30321mValue = "//////////////////" ;
			}
			createDiv(birthInfos[18], d30321mValue, d30321mOffsets_left, d30321mOffsets_top);
		}
		
		var d30336idZhOffset = jsonStr[birthInfos[19]];
		var d30336paZhOffset = jsonStr[birthInfos[20]];
		var d30349Offset = jsonStr[birthInfos[21]];
		var d30336Value = vd303["d30336"];
		var d30349Value = vd303["d30349"];
		
		if(d30336Value == "1") {
			if(d30336idZhOffset != undefined) {
				var d30336idZhOffsets = d30336idZhOffset.split(";");
				var d30336idZhOffset_left = d30336idZhOffsets[0];
				var d30336idZhOffset_top = d30336idZhOffsets[1];
				
				createDiv(birthInfos[19], symbol, d30336idZhOffset_left, d30336idZhOffset_top);
			}
		} else if(d30336Value == "3") {
			if(d30336paZhOffset != undefined) {
				var d30336paZhOffsets = d30336paZhOffset.split(";");
				var d30336paZhOffset_left = d30336paZhOffsets[0];
				var d30336paZhOffset_top = d30336paZhOffsets[1];
				
				createDiv(birthInfos[20], symbol, d30336paZhOffset_left, d30336paZhOffset_top);
			}
		} else if(d30336Value == "4") {
			if(d30349Offset != undefined) {
				var d30349Offsets = d30349Offset.split(";");
				var d30349Offset_left = d30349Offsets[0];
				var d30349Offset_top = d30349Offsets[1];
				
				createDiv(birthInfos[21], d30349Value, d30349Offset_left, d30349Offset_top);
			}
		}
		
		
		
		var d30312Offset = jsonStr[birthInfos[22]];
		if(d30312Offset != undefined) {
			var d30312Offsets = d30312Offset.split(";");
			var d30312Offsets_left = d30312Offsets[0];
			var d30312Offsets_top = d30312Offsets[1];
			var d30312Value = vd303[birthInfos[22]];
			//母亲身份证
			if(d30312Value == null || "" == d30312Value || d30312Value == undefined){
				d30312Value = "//////////////////" ;
			}
			createDiv(birthInfos[22], d30312Value, d30312Offsets_left, d30312Offsets_top);
		}
		
		var d30316Value = vd303[birthInfos[23]];
		var d30316Offset = jsonStr[birthInfos[23]];
		if(d30316Offset != undefined) {
			var d30316Offsets = d30316Offset.split(";");
			var d30316Offsets_left = d30316Offsets[0];
			var d30316Offsets_top = d30316Offsets[1];
			//父亲姓名
			if(d30316Value == null || "" == d30316Value || d30316Value == undefined){
				d30316Value = "///" ;
			}
			createDiv(birthInfos[23], d30316Value, d30316Offsets_left, d30316Offsets_top);
		}
		
		var d30318Offset = jsonStr[birthInfos[24]];
		if(d30318Offset != undefined) {
			var d30318Offsets = d30318Offset.split(";");
			var d30318Offsets_left = d30318Offsets[0];
			var d30318Offsets_top = d30318Offsets[1];
			var d30318Value = vd303[birthInfos[24]];
			//父亲年龄
			if(d30318Value == null || "" == d30318Value || d30318Value == undefined){
				d30318Value = "//" ;
			}
			createDiv(birthInfos[24], d30318Value, d30318Offsets_left, d30318Offsets_top);
		}
		
		var d30319Offset = jsonStr[birthInfos[25]];
		if(d30319Offset != undefined) {
			var d30319Offsets = d30319Offset.split(";");
			var d30319Offsets_left = d30319Offsets[0];
			var d30319Offsets_top = d30319Offsets[1];
			var d30319Value = vd303[birthInfos[25]];
			//父亲国籍
			if(d30319Value == null || "" == d30319Value || d30319Value == undefined){
				d30319Value = "//" ;
			}
			createDiv(birthInfos[25], d30319Value, d30319Offsets_left, d30319Offsets_top);
		}
		
		var d30320Offset = jsonStr[birthInfos[26]];
		if(d30320Offset != undefined) {
			var d30320Offsets = d30320Offset.split(";");
			var d30320Offsets_left = d30320Offsets[0];
			var d30320Offsets_top = d30320Offsets[1];
			var d30320Value = vd303[birthInfos[26]];
			//父亲民族
			if(d30320Value == null || "" == d30320Value || d30320Value == undefined){
				d30320Value = "//" ;
			}
			createDiv(birthInfos[26], d30320Value, d30320Offsets_left, d30320Offsets_top);
		}
		
		var d30321fOffset = jsonStr[birthInfos[27]];
		if(d30321fOffset != undefined) {
			var d30321fOffsets = d30321fOffset.split(";");
			var d30321fOffsets_left = d30321fOffsets[0];
			var d30321fOffsets_top = d30321fOffsets[1];
			var d30352Value = vd303["d30352"];
			//父亲家庭地址
			if(d30316Value == "///" &&(d30352Value == null || "" == d30352Value || d30352Value == undefined)){
				d30352Value = "//////////////////" ;
			}
			createDiv(birthInfos[27], d30352Value, d30321fOffsets_left, d30321fOffsets_top);
		}
		
		
		var d30337idZhOffset = jsonStr[birthInfos[28]];
		var d30337paZhOffset = jsonStr[birthInfos[29]];
		var d30350Offset = jsonStr[birthInfos[30]];
		var d30337Value = vd303["d30337"];
		var d30350Value = vd303["d30350"];
		
		if(d30337Value == "1") {
			if(d30337idZhOffset != undefined) {
				var d30337idZhOffsets = d30337idZhOffset.split(";");
				var d30337idZhOffset_left = d30337idZhOffsets[0];
				var d30337idZhOffset_top = d30337idZhOffsets[1];
				
				createDiv(birthInfos[28], symbol, d30337idZhOffset_left, d30337idZhOffset_top);
			}
		} else if(d30337Value == "3") {
			if(d30337paZhOffset != undefined) {
				var d30337paZhOffsets = d30337paZhOffset.split(";");
				var d30337paZhOffset_left = d30337paZhOffsets[0];
				var d30337paZhOffset_top = d30337paZhOffsets[1];
				
				createDiv(birthInfos[29], symbol, d30337paZhOffset_left, d30337paZhOffset_top);
			}
		} else if(d30337Value == "4") {
			if(d30350Offset != undefined) {
				var d30350Offsets = d30350Offset.split(";");
				var d30350Offset_left = d30350Offsets[0];
				var d30350Offset_top = d30350Offsets[1];
				
				createDiv(birthInfos[30], d30350Value, d30350Offset_left, d30350Offset_top);
			}
		}
		
		var d30317Offset = jsonStr[birthInfos[31]];
		if(d30317Offset != undefined) {
			var d30317Offsets = d30317Offset.split(";");
			var d30317Offsets_left = d30317Offsets[0];
			var d30317Offsets_top = d30317Offsets[1];
			var d30317Value = vd303[birthInfos[31]];
			createDiv(birthInfos[31], d30317Value, d30317Offsets_left, d30317Offsets_top);
		}
		
		var d30326ZhValue = vd303[birthInfos[32]];
		var d30326ZhOffset = jsonStr[birthInfos[32]];
		if(d30326ZhOffset != undefined) {
			var d30326ZhOffsets = d30326ZhOffset.split(";");
			var d30326ZhOffset_left = d30326ZhOffsets[0];
			var d30326ZhOffset_top = d30326ZhOffsets[1];
			createDiv(birthInfos[32], d30326ZhValue, d30326ZhOffset_left, d30326ZhOffset_top);
		}
		
		
		
		var d30328Value = vd303[birthInfos[33]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30328Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30328OffsetYear = jsonStr[birthInfos[33]];
		if(d30328OffsetYear != undefined) {
			var d30328OffsetYears = d30328OffsetYear.split(";");
			var d30328OffsetYear_left = d30328OffsetYears[0];
			var d30328OffsetYear_top = d30328OffsetYears[1];
			createDiv(birthInfos[33], yearS, d30328OffsetYear_left, d30328OffsetYear_top);
		}
		
		var d30328OffsetMonth = jsonStr[birthInfos[34]];
		if(d30328OffsetMonth != undefined) {
			var d30328OffsetMonths = d30328OffsetMonth.split(";");
			var d30328OffsetMonths_left = d30328OffsetMonths[0];
			var d30328OffsetMonths_top = d30328OffsetMonths[1];
			createDiv(birthInfos[34], monthS, d30328OffsetMonths_left, d30328OffsetMonths_top);
		}
		
		var d30328OffsetDate = jsonStr[birthInfos[35]];
		if(d30328OffsetDate != undefined) {
			var d30328OffsetDates = d30328OffsetDate.split(";");
			var d30328OffsetDates_left = d30328OffsetDates[0];
			var d30328OffsetDates_top = d30328OffsetDates[1];
			createDiv(birthInfos[35], dateS, d30328OffsetDates_left, d30328OffsetDates_top);
		}
	
		var birthInfoSs = birthInfo[1].split(";");
		var birthInfoSsd30302Offset = jsonStr[birthInfoSs[0]];
		if(birthInfoSsd30302Offset != undefined) {
			var d30302Offset = birthInfoSsd30302Offset.split(";");
			var d30302Offset_left = d30302Offset[0];
			var d30302Offset_top = d30302Offset[1];
			var d30302Value = vd303[birthInfoSs[0]];
			createDiv(birthInfoSs[0], d30302Value, d30302Offset_left, d30302Offset_top);
		}
		
		var d30303Value = vd303[birthInfoSs[1]];
		var birthInfoSsd30303Offset = "";
		var gender = "";
		birthInfoSsd30303Offset = jsonStr[birthInfoSs[1]];
		if(d30303Value == "1") {
			gender = "男";
		} else if(d30303Value == "2") {
			gender = "女";
		} 
		if(birthInfoSsd30303Offset != "") {
			var d30303Offset = birthInfoSsd30303Offset.split(";");
			var d30303Offset_left = d30303Offset[0];
			var d30303Offset_top = d30303Offset[1];
			createDiv(birthInfoSs[1], gender, d30303Offset_left, d30303Offset_top);
		}
		
		var d30304Value = vd303[birthInfoSs[2]];
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
		
		var d30304Offset = jsonStr[birthInfoSs[2]];
		if(d30304Offset != undefined) {
			var d30304Offsets = d30304Offset.split(";");
			var d30304Offset_left = d30304Offsets[0];
			var d30304Offset_top = d30304Offsets[1];
			createDiv(birthInfoSs[2], year, d30304Offset_left, d30304Offset_top);
		}
		
		var d30304MonthOffset = jsonStr[birthInfoSs[3]];
		if(d30304MonthOffset != undefined) {
			var d30304MonthOffsets = d30304MonthOffset.split(";");
			var d30304MonthOffset_left = d30304MonthOffsets[0];
			var d30304MonthOffset_top = d30304MonthOffsets[1];
			createDiv(birthInfoSs[3], month, d30304MonthOffset_left, d30304MonthOffset_top);
		}
		
		var d30304DateOffset = jsonStr[birthInfoSs[4]];
		if(d30304DateOffset != undefined) {
			var d30304DateOffsets = d30304DateOffset.split(";");
			var d30304DateOffset_left = d30304DateOffsets[0];
			var d30304DateOffset_top = d30304DateOffsets[1];
			createDiv(birthInfoSs[4], date, d30304DateOffset_left, d30304DateOffset_top);
		}
		
		var d30304HourOffset = jsonStr[birthInfoSs[5]];
		if(d30304HourOffset != undefined) {
			var d30304HourOffsets = d30304HourOffset.split(";");
			var d30304HourOffset_left = d30304HourOffsets[0];
			var d30304HourOffset_top = d30304HourOffsets[1];
			createDiv(birthInfoSs[5], hour, d30304HourOffset_left, d30304HourOffset_top);
		}
		
		var d30304MinuteOffset = jsonStr[birthInfoSs[6]];
		if(d30304MinuteOffset != undefined) {
			var d30304MinuteOffsets = d30304MinuteOffset.split(";");
			var d30304MinuteOffset_left = d30304MinuteOffsets[0];
			var d30304MinuteOffset_top = d30304MinuteOffsets[1];
			createDiv(birthInfoSs[6], minute, d30304MinuteOffset_left, d30304MinuteOffset_top);
		}
		
		var d30307 = vd303[birthInfoSs[7]]; // weeks
		var d30351 = vd303["d30351"]; // days
		
		var d30307Offset = jsonStr[birthInfoSs[7]];
		if(d30307Offset != undefined) {
			var d30307Offsets = d30307Offset.split(";");
			var d30307Offset_left = d30307Offsets[0];
			var d30307Offset_top = d30307Offsets[1];
			if(d30351 != undefined && d30351 != 0) {
				createDiv(birthInfoSs[7], d30307 + "<sup>+" + d30351 + "</sup>", d30307Offset_left, d30307Offset_top);
			}else{
				createDiv(birthInfoSs[7], d30307, d30307Offset_left, d30307Offset_top);
			}
		}
		
		var d30331 = vd303[birthInfoSs[8]];
		var d30331Offset = jsonStr[birthInfoSs[8]];
		if(d30331Offset != undefined) {
			var d30331Offsets = d30331Offset.split(";");
			var d30331Offset_left = d30331Offsets[0];
			var d30331Offset_top = d30331Offsets[1];
			createDiv(birthInfoSs[8], d30331, d30331Offset_left, d30331Offset_top);
		}
		
		var d30308 = vd303[birthInfoSs[9]];
		var d30308Offset = jsonStr[birthInfoSs[9]];
		if(d30308Offset != undefined) {
			var d30308Offsets = d30308Offset.split(";");
			var d30308Offset_left = d30308Offsets[0];
			var d30308Offset_top = d30308Offsets[1];
			createDiv(birthInfoSs[9], d30308, d30308Offset_left, d30308Offset_top);
		}
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30305OffsetProviceValue = dataValue[0];
			d30305OffsetCityValue = dataValue[1];
			d30305OffsetCountyValue = dataValue[2];
			
			var d30305OffsetProvice = jsonStr[birthInfoSs[10]];
			var d30305OffsetCity = jsonStr[birthInfoSs[11]];
			var d30305OffsetCounty = jsonStr[birthInfoSs[12]];

			if(d30305OffsetProvice != undefined) {
				var d30305OffsetProvices =  d30305OffsetProvice.split(";");
				var d30305OffsetProvices_left = d30305OffsetProvices[0];
				var d30305OffsetProvices_top = d30305OffsetProvices[1];
				createDiv(birthInfoSs[10], d30305OffsetProviceValue, d30305OffsetProvices_left, d30305OffsetProvices_top);
			}
			if(d30305OffsetCity != undefined) {
				var d30305OffsetCitys =  d30305OffsetCity.split(";");
				var d30305OffsetCitys_left = d30305OffsetCitys[0];
				var d30305OffsetCitys_top = d30305OffsetCitys[1];
				createDiv(birthInfoSs[11], d30305OffsetCityValue, d30305OffsetCitys_left, d30305OffsetCitys_top);
			}
			if(d30305OffsetCounty != undefined) {
				var d30305OffsetCountys =  d30305OffsetCounty.split(";");
				var d30305OffsetCountys_left = d30305OffsetCountys[0];
				var d30305OffsetCountys_top = d30305OffsetCountys[1];
				createDiv(birthInfoSs[12], d30305OffsetCountyValue, d30305OffsetCountys_left, d30305OffsetCountys_top);
			}
		}, "json");
		
		var d30324Offset = jsonStr[birthInfoSs[13]];
		if(d30324Offset != undefined) {
			var d30324Offsets = d30324Offset.split(";");
			var d30324Offsets_left = d30324Offsets[0];
			var d30324Offsets_top = d30324Offsets[1];
			var d30324Value = vd303[birthInfoSs[13]];
			createDiv(birthInfoSs[13], d30324Value, d30324Offsets_left, d30324Offsets_top);
		}
		
		var d30311Value = vd303[birthInfoSs[14]];
		
		var d30311Offset = jsonStr[birthInfoSs[14]];
		if(d30311Offset != undefined) {
			var d30311Offsets = d30311Offset.split(";");
			d30311Offset_left = d30311Offsets[0];
			d30311Offset_top = d30311Offsets[1];
			//母亲姓名
			if(d30311Value == undefined || "" == d30311Value || d30311Value == null){
				d30311Value = "///" ;
			}
			createDiv(birthInfoSs[14], d30311Value, d30311Offset_left, d30311Offset_top);
		}
		
		var d30313Offset = jsonStr[birthInfoSs[15]];
		if(d30313Offset != undefined) {
			var d30313Offsets = d30313Offset.split(";");
			var d30313Offsets_left = d30313Offsets[0];
			var d30313Offsets_top = d30313Offsets[1];
			var d30313Value = vd303[birthInfoSs[15]];
			//母亲年龄
			if(d30313Value == undefined || "" == d30313Value || d30313Value == null){
				d30313Value = "//" ;
			}
			createDiv(birthInfoSs[15], d30313Value, d30313Offsets_left, d30313Offsets_top);
		}
		
		var d30314Offset = jsonStr[birthInfoSs[16]];
		if(d30314Offset != undefined) {
			var d30314Offsets = d30314Offset.split(";");
			var d30314Offsets_left = d30314Offsets[0];
			var d30314Offsets_top = d30314Offsets[1];
			var d30314Value = vd303[birthInfoSs[16]];
			//母亲国籍
			if(d30314Value == null || "" == d30314Value || d30314Value == undefined){
				d30314Value = "//" ;
			}
			createDiv(birthInfoSs[16], d30314Value, d30314Offsets_left, d30314Offsets_top);
		}
		
		var d30315Offset = jsonStr[birthInfoSs[17]];
		if(d30315Offset != undefined) {
			var d30315Offsets = d30315Offset.split(";");
			var d30315Offsets_left = d30315Offsets[0];
			var d30315Offsets_top = d30315Offsets[1];
			var d30315Value = vd303[birthInfoSs[17]];
			//母亲民族
			if(d30315Value == null || "" == d30315Value || d30315Value == undefined){
				d30315Value = "//" ;
			}
			createDiv(birthInfoSs[17], d30315Value, d30315Offsets_left, d30315Offsets_top);
		}
		
		var d30321mOffset = jsonStr[birthInfoSs[18]];
		if(d30321mOffset != undefined) {
			var d30321mOffsets = d30321mOffset.split(";");
			var d30321mOffsets_left = d30321mOffsets[0];
			var d30321mOffsets_top = d30321mOffsets[1];
			var d30321mValue = vd303["d30321"];
			//母亲家庭地址
			if(d30311Value == "///" && (d30321mValue == null || "" == d30321mValue || d30321mValue == undefined)){
				d30321mValue = "//////////////////" ;
			}
			createDiv(birthInfoSs[18], d30321mValue, d30321mOffsets_left, d30321mOffsets_top);
		}
		
		var d30336idZhOffset = jsonStr[birthInfoSs[19]];
		var d30336paZhOffset = jsonStr[birthInfoSs[20]];
		var d30349Offset = jsonStr[birthInfoSs[21]];
		var d30336Value = vd303["d30336"];
		var d30349Value = vd303["d30349"];
		
		if(d30336Value == "1") {
			if(d30336idZhOffset != undefined) {
				var d30336idZhOffsets = d30336idZhOffset.split(";");
				var d30336idZhOffset_left = d30336idZhOffsets[0];
				var d30336idZhOffset_top = d30336idZhOffsets[1];
				
				createDiv(birthInfoSs[19], symbol, d30336idZhOffset_left, d30336idZhOffset_top);
			}
		} else if(d30336Value == "3") {
			if(d30336paZhOffset != undefined) {
				var d30336paZhOffsets = d30336paZhOffset.split(";");
				var d30336paZhOffset_left = d30336paZhOffsets[0];
				var d30336paZhOffset_top = d30336paZhOffsets[1];
				
				createDiv(birthInfoSs[20], symbol, d30336paZhOffset_left, d30336paZhOffset_top);
			}
		} else if(d30336Value == "4") {
			if(d30349Offset != undefined) {
				var d30349Offsets = d30349Offset.split(";");
				var d30349Offset_left = d30349Offsets[0];
				var d30349Offset_top = d30349Offsets[1];
				
				createDiv(birthInfoSs[21], d30349Value, d30349Offset_left, d30349Offset_top);
			}
		}
		
		
		
		var d30312Offset = jsonStr[birthInfoSs[22]];
		if(d30312Offset != undefined) {
			var d30312Offsets = d30312Offset.split(";");
			var d30312Offsets_left = d30312Offsets[0];
			var d30312Offsets_top = d30312Offsets[1];
			var d30312Value = vd303[birthInfoSs[22]];
			//母亲身份证
			if(d30312Value == null || "" == d30312Value || d30312Value == undefined){
				d30312Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[22], d30312Value, d30312Offsets_left, d30312Offsets_top);
		}
		
		var d30316Value = vd303[birthInfoSs[23]];
		var d30316Offset = jsonStr[birthInfoSs[23]];
		if(d30316Offset != undefined) {
			var d30316Offsets = d30316Offset.split(";");
			var d30316Offsets_left = d30316Offsets[0];
			var d30316Offsets_top = d30316Offsets[1];
			//父亲姓名
			if(d30316Value == null || "" == d30316Value || d30316Value == undefined){
				d30316Value = "///" ;
			}
			createDiv(birthInfoSs[23], d30316Value, d30316Offsets_left, d30316Offsets_top);
		}
		
		var d30318Offset = jsonStr[birthInfoSs[24]];
		if(d30318Offset != undefined) {
			var d30318Offsets = d30318Offset.split(";");
			var d30318Offsets_left = d30318Offsets[0];
			var d30318Offsets_top = d30318Offsets[1];
			var d30318Value = vd303[birthInfoSs[24]];
			//父亲年龄
			if(d30318Value == null || "" == d30318Value || d30318Value == undefined){
				d30318Value = "//" ;
			}
			createDiv(birthInfoSs[24], d30318Value, d30318Offsets_left, d30318Offsets_top);
		}
		
		var d30319Offset = jsonStr[birthInfoSs[25]];
		if(d30319Offset != undefined) {
			var d30319Offsets = d30319Offset.split(";");
			var d30319Offsets_left = d30319Offsets[0];
			var d30319Offsets_top = d30319Offsets[1];
			var d30319Value = vd303[birthInfoSs[25]];
			//父亲国籍
			if(d30319Value == null || "" == d30319Value || d30319Value == undefined){
				d30319Value = "//" ;
			}
			createDiv(birthInfoSs[25], d30319Value, d30319Offsets_left, d30319Offsets_top);
		}
		
		var d30320Offset = jsonStr[birthInfoSs[26]];
		if(d30320Offset != undefined) {
			var d30320Offsets = d30320Offset.split(";");
			var d30320Offsets_left = d30320Offsets[0];
			var d30320Offsets_top = d30320Offsets[1];
			var d30320Value = vd303[birthInfoSs[26]];
			//父亲民族
			if(d30320Value == null || "" == d30320Value || d30320Value == undefined){
				d30320Value = "//" ;
			}
			createDiv(birthInfoSs[26], d30320Value, d30320Offsets_left, d30320Offsets_top);
		}
		
		var d30321fOffset = jsonStr[birthInfoSs[27]];
		if(d30321fOffset != undefined) {
			var d30321fOffsets = d30321fOffset.split(";");
			var d30321fOffsets_left = d30321fOffsets[0];
			var d30321fOffsets_top = d30321fOffsets[1];
			var d30352Value = vd303["d30352"];
			//父亲家庭地址
			if(d30316Value == "///" &&(d30352Value == null || "" == d30352Value || d30352Value == undefined)){
				d30352Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[27], d30352Value, d30321fOffsets_left, d30321fOffsets_top);
		}
		
		
		var d30337idZhOffset = jsonStr[birthInfoSs[28]];
		var d30337paZhOffset = jsonStr[birthInfoSs[29]];
		var d30350Offset = jsonStr[birthInfoSs[30]];
		var d30337Value = vd303["d30337"];
		var d30350Value = vd303["d30350"];
		
		if(d30337Value == "1") {
			if(d30337idZhOffset != undefined) {
				var d30337idZhOffsets = d30337idZhOffset.split(";");
				var d30337idZhOffset_left = d30337idZhOffsets[0];
				var d30337idZhOffset_top = d30337idZhOffsets[1];
				
				createDiv(birthInfoSs[28], symbol, d30337idZhOffset_left, d30337idZhOffset_top);
			}
		} else if(d30337Value == "3") {
			if(d30337paZhOffset != undefined) {
				var d30337paZhOffsets = d30337paZhOffset.split(";");
				var d30337paZhOffset_left = d30337paZhOffsets[0];
				var d30337paZhOffset_top = d30337paZhOffsets[1];
				
				createDiv(birthInfoSs[29], symbol, d30337paZhOffset_left, d30337paZhOffset_top);
			}
		} else if(d30337Value == "4") {
			if(d30350Offset != undefined) {
				var d30350Offsets = d30350Offset.split(";");
				var d30350Offset_left = d30350Offsets[0];
				var d30350Offset_top = d30350Offsets[1];
				
				createDiv(birthInfoSs[30], d30350Value, d30350Offset_left, d30350Offset_top);
			}
		}
		
		var d30317Offset = jsonStr[birthInfoSs[31]];
		if(d30317Offset != undefined) {
			var d30317Offsets = d30317Offset.split(";");
			var d30317Offsets_left = d30317Offsets[0];
			var d30317Offsets_top = d30317Offsets[1];
			var d30317Value = vd303[birthInfoSs[31]];
			createDiv(birthInfoSs[31], d30317Value, d30317Offsets_left, d30317Offsets_top);
		}
		
		var d30326ZhValue = vd303[birthInfoSs[32]];
		var d30326ZhOffset = jsonStr[birthInfoSs[32]];
		if(d30326ZhOffset != undefined) {
			var d30326ZhOffsets = d30326ZhOffset.split(";");
			var d30326ZhOffset_left = d30326ZhOffsets[0];
			var d30326ZhOffset_top = d30326ZhOffsets[1];
			createDiv(birthInfoSs[32], d30326ZhValue, d30326ZhOffset_left, d30326ZhOffset_top);
		}
		
		
		
		var d30328Value = vd303[birthInfoSs[33]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30328Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30328OffsetYear = jsonStr[birthInfoSs[33]];
		if(d30328OffsetYear != undefined) {
			var d30328OffsetYears = d30328OffsetYear.split(";");
			var d30328OffsetYear_left = d30328OffsetYears[0];
			var d30328OffsetYear_top = d30328OffsetYears[1];
			createDiv(birthInfoSs[33], yearS, d30328OffsetYear_left, d30328OffsetYear_top);
		}
		
		var d30328OffsetMonth = jsonStr[birthInfoSs[34]];
		if(d30328OffsetMonth != undefined) {
			var d30328OffsetMonths = d30328OffsetMonth.split(";");
			var d30328OffsetMonths_left = d30328OffsetMonths[0];
			var d30328OffsetMonths_top = d30328OffsetMonths[1];
			createDiv(birthInfoSs[34], monthS, d30328OffsetMonths_left, d30328OffsetMonths_top);
		}
		
		var d30328OffsetDate = jsonStr[birthInfoSs[35]];
		if(d30328OffsetDate != undefined) {
			var d30328OffsetDates = d30328OffsetDate.split(";");
			var d30328OffsetDates_left = d30328OffsetDates[0];
			var d30328OffsetDates_top = d30328OffsetDates[1];
			createDiv(birthInfoSs[35], dateS, d30328OffsetDates_left, d30328OffsetDates_top);
		}
		
		var birthInfoTs = birthInfo[2].split(";");
		var birthInfoTsd30302Offset = jsonStr[birthInfoTs[0]];
		if(birthInfoTsd30302Offset != undefined) {
			var d30302Offset = birthInfoTsd30302Offset.split(";");
			var d30302Offset_left = d30302Offset[0];
			var d30302Offset_top = d30302Offset[1];
			var d30302Value = vd303[birthInfoTs[0]];
			createDiv(birthInfoTs[0], d30302Value, d30302Offset_left, d30302Offset_top);
		}
		
		var d30303Value = vd303[birthInfoTs[1]];
		var birthInfoTsd30303Offset = "";
		var gender = "";
		birthInfoTsd30303Offset = jsonStr[birthInfoTs[1]];
		if(d30303Value == "1") {
			gender = "男";
		} else if(d30303Value == "2") {
			gender = "女";
		} 
		if(birthInfoTsd30303Offset != "") {
			var d30303Offset = birthInfoTsd30303Offset.split(";");
			var d30303Offset_left = d30303Offset[0];
			var d30303Offset_top = d30303Offset[1];
			createDiv(birthInfoTs[1], gender, d30303Offset_left, d30303Offset_top);
		}
		
		var d30304Value = vd303[birthInfoTs[2]];
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
		
		var d30304Offset = jsonStr[birthInfoTs[2]];
		if(d30304Offset != undefined) {
			var d30304Offsets = d30304Offset.split(";");
			var d30304Offset_left = d30304Offsets[0];
			var d30304Offset_top = d30304Offsets[1];
			createDiv(birthInfoTs[2], year, d30304Offset_left, d30304Offset_top);
		}
		
		var d30304MonthOffset = jsonStr[birthInfoTs[3]];
		if(d30304MonthOffset != undefined) {
			var d30304MonthOffsets = d30304MonthOffset.split(";");
			var d30304MonthOffset_left = d30304MonthOffsets[0];
			var d30304MonthOffset_top = d30304MonthOffsets[1];
			createDiv(birthInfoTs[3], month, d30304MonthOffset_left, d30304MonthOffset_top);
		}
		
		var d30304DateOffset = jsonStr[birthInfoTs[4]];
		if(d30304DateOffset != undefined) {
			var d30304DateOffsets = d30304DateOffset.split(";");
			var d30304DateOffset_left = d30304DateOffsets[0];
			var d30304DateOffset_top = d30304DateOffsets[1];
			createDiv(birthInfoTs[4], date, d30304DateOffset_left, d30304DateOffset_top);
		}
		
		var d30304HourOffset = jsonStr[birthInfoTs[5]];
		if(d30304HourOffset != undefined) {
			var d30304HourOffsets = d30304HourOffset.split(";");
			var d30304HourOffset_left = d30304HourOffsets[0];
			var d30304HourOffset_top = d30304HourOffsets[1];
			createDiv(birthInfoTs[5], hour, d30304HourOffset_left, d30304HourOffset_top);
		}
		
		var d30304MinuteOffset = jsonStr[birthInfoTs[6]];
		if(d30304MinuteOffset != undefined) {
			var d30304MinuteOffsets = d30304MinuteOffset.split(";");
			var d30304MinuteOffset_left = d30304MinuteOffsets[0];
			var d30304MinuteOffset_top = d30304MinuteOffsets[1];
			createDiv(birthInfoTs[6], minute, d30304MinuteOffset_left, d30304MinuteOffset_top);
		}
		
		var d30307 = vd303[birthInfoTs[7]]; // weeks
		var d30351 = vd303["d30351"]; // days
		
		var d30307Offset = jsonStr[birthInfoTs[7]];
		if(d30307Offset != undefined) {
			var d30307Offsets = d30307Offset.split(";");
			var d30307Offset_left = d30307Offsets[0];
			var d30307Offset_top = d30307Offsets[1];
			if(d30351 != undefined && d30351 != 0) {
				createDiv(birthInfoTs[7], d30307 + "<sup>+" + d30351 + "</sup>", d30307Offset_left, d30307Offset_top);
			}else{
				createDiv(birthInfoTs[7], d30307, d30307Offset_left, d30307Offset_top);
			}
		}
		
		var d30331 = vd303[birthInfoTs[8]];
		var d30331Offset = jsonStr[birthInfoTs[8]];
		if(d30331Offset != undefined) {
			var d30331Offsets = d30331Offset.split(";");
			var d30331Offset_left = d30331Offsets[0];
			var d30331Offset_top = d30331Offsets[1];
			createDiv(birthInfoTs[8], d30331, d30331Offset_left, d30331Offset_top);
		}
		
		var d30308 = vd303[birthInfoTs[9]];
		var d30308Offset = jsonStr[birthInfoTs[9]];
		if(d30308Offset != undefined) {
			var d30308Offsets = d30308Offset.split(";");
			var d30308Offset_left = d30308Offsets[0];
			var d30308Offset_top = d30308Offsets[1];
			createDiv(birthInfoTs[9], d30308, d30308Offset_left, d30308Offset_top);
		}
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30305OffsetProviceValue = dataValue[0];
			d30305OffsetCityValue = dataValue[1];
			d30305OffsetCountyValue = dataValue[2];
		
			var d30305OffsetProvice = jsonStr[birthInfoTs[10]];
			var d30305OffsetCity = jsonStr[birthInfoTs[11]];
			var d30305OffsetCounty = jsonStr[birthInfoTs[12]];
	
			if(d30305OffsetProvice != undefined) {
				var d30305OffsetProvices =  d30305OffsetProvice.split(";");
				var d30305OffsetProvices_left = d30305OffsetProvices[0];
				var d30305OffsetProvices_top = d30305OffsetProvices[1];
				createDiv(birthInfoTs[10], d30305OffsetProviceValue, d30305OffsetProvices_left, d30305OffsetProvices_top);
			}
			if(d30305OffsetCity != undefined) {
				var d30305OffsetCitys =  d30305OffsetCity.split(";");
				var d30305OffsetCitys_left = d30305OffsetCitys[0];
				var d30305OffsetCitys_top = d30305OffsetCitys[1];
				createDiv(birthInfoTs[11], d30305OffsetCityValue, d30305OffsetCitys_left, d30305OffsetCitys_top);
			}
			if(d30305OffsetCounty != undefined) {
				var d30305OffsetCountys =  d30305OffsetCounty.split(";");
				var d30305OffsetCountys_left = d30305OffsetCountys[0];
				var d30305OffsetCountys_top = d30305OffsetCountys[1];
				createDiv(birthInfoTs[12], d30305OffsetCountyValue, d30305OffsetCountys_left, d30305OffsetCountys_top);
			}
		}, "json");
		
		var d30324Offset = jsonStr[birthInfoTs[13]];
		if(d30324Offset != undefined) {
			var d30324Offsets = d30324Offset.split(";");
			var d30324Offsets_left = d30324Offsets[0];
			var d30324Offsets_top = d30324Offsets[1];
			var d30324Value = vd303[birthInfoTs[13]];
			createDiv(birthInfoTs[13], d30324Value, d30324Offsets_left, d30324Offsets_top);
		}
		
		var d30311Value = vd303[birthInfoTs[14]];
		
		var d30311Offset = jsonStr[birthInfoTs[14]];
		if(d30311Offset != undefined) {
			var d30311Offsets = d30311Offset.split(";");
			d30311Offset_left = d30311Offsets[0];
			d30311Offset_top = d30311Offsets[1];
			//母亲姓名
			if(d30311Value == undefined || "" == d30311Value || d30311Value == null){
				d30311Value = "///" ;
			}
			createDiv(birthInfoTs[14], d30311Value, d30311Offset_left, d30311Offset_top);
		}
		
		var d30313Offset = jsonStr[birthInfoTs[15]];
		if(d30313Offset != undefined) {
			var d30313Offsets = d30313Offset.split(";");
			var d30313Offsets_left = d30313Offsets[0];
			var d30313Offsets_top = d30313Offsets[1];
			var d30313Value = vd303[birthInfoTs[15]];
			//母亲年龄
			if(d30313Value == undefined || "" == d30313Value || d30313Value == null){
				d30313Value = "//" ;
			}
			createDiv(birthInfoTs[15], d30313Value, d30313Offsets_left, d30313Offsets_top);
		}
		
		var d30314Offset = jsonStr[birthInfoTs[16]];
		if(d30314Offset != undefined) {
			var d30314Offsets = d30314Offset.split(";");
			var d30314Offsets_left = d30314Offsets[0];
			var d30314Offsets_top = d30314Offsets[1];
			var d30314Value = vd303[birthInfoTs[16]];
			//母亲国籍
			if(d30314Value == null || "" == d30314Value || d30314Value == undefined){
				d30314Value = "//" ;
			}
			createDiv(birthInfoTs[16], d30314Value, d30314Offsets_left, d30314Offsets_top);
		}
		
		var d30315Offset = jsonStr[birthInfoTs[17]];
		if(d30315Offset != undefined) {
			var d30315Offsets = d30315Offset.split(";");
			var d30315Offsets_left = d30315Offsets[0];
			var d30315Offsets_top = d30315Offsets[1];
			var d30315Value = vd303[birthInfoTs[17]];
			//母亲民族
			if(d30315Value == null || "" == d30315Value || d30315Value == undefined){
				d30315Value = "//" ;
			}
			createDiv(birthInfoTs[17], d30315Value, d30315Offsets_left, d30315Offsets_top);
		}
		
		var d30321mOffset = jsonStr[birthInfoTs[18]];
		if(d30321mOffset != undefined) {
			var d30321mOffsets = d30321mOffset.split(";");
			var d30321mOffsets_left = d30321mOffsets[0];
			var d30321mOffsets_top = d30321mOffsets[1];
			var d30321mValue = vd303["d30321"];
			//母亲家庭地址
			if(d30311Value == "///" && (d30321mValue == null || "" == d30321mValue || d30321mValue == undefined)){
				d30321mValue = "//////////////////" ;
			}
			createDiv(birthInfoTs[18], d30321mValue, d30321mOffsets_left, d30321mOffsets_top);
		}
		
		var d30336idZhOffset = jsonStr[birthInfoTs[19]];
		var d30336paZhOffset = jsonStr[birthInfoTs[20]];
		var d30349Offset = jsonStr[birthInfoTs[21]];
		var d30336Value = vd303["d30336"];
		var d30349Value = vd303["d30349"];
		
		if(d30336Value == "1") {
			if(d30336idZhOffset != undefined) {
				var d30336idZhOffsets = d30336idZhOffset.split(";");
				var d30336idZhOffset_left = d30336idZhOffsets[0];
				var d30336idZhOffset_top = d30336idZhOffsets[1];
				
				createDiv(birthInfoTs[19], symbol, d30336idZhOffset_left, d30336idZhOffset_top);
			}
		} else if(d30336Value == "3") {
			if(d30336paZhOffset != undefined) {
				var d30336paZhOffsets = d30336paZhOffset.split(";");
				var d30336paZhOffset_left = d30336paZhOffsets[0];
				var d30336paZhOffset_top = d30336paZhOffsets[1];
				
				createDiv(birthInfoTs[20], symbol, d30336paZhOffset_left, d30336paZhOffset_top);
			}
		} else if(d30336Value == "4") {
			if(d30349Offset != undefined) {
				var d30349Offsets = d30349Offset.split(";");
				var d30349Offset_left = d30349Offsets[0];
				var d30349Offset_top = d30349Offsets[1];
				
				createDiv(birthInfoTs[21], d30349Value, d30349Offset_left, d30349Offset_top);
			}
		}
		
		
		
		var d30312Offset = jsonStr[birthInfoTs[22]];
		if(d30312Offset != undefined) {
			var d30312Offsets = d30312Offset.split(";");
			var d30312Offsets_left = d30312Offsets[0];
			var d30312Offsets_top = d30312Offsets[1];
			var d30312Value = vd303[birthInfoTs[22]];
			//母亲身份证
			if(d30312Value == null || "" == d30312Value || d30312Value == undefined){
				d30312Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[22], d30312Value, d30312Offsets_left, d30312Offsets_top);
		}
		
		var d30316Value = vd303[birthInfoTs[23]];
		var d30316Offset = jsonStr[birthInfoTs[23]];
		if(d30316Offset != undefined) {
			var d30316Offsets = d30316Offset.split(";");
			var d30316Offsets_left = d30316Offsets[0];
			var d30316Offsets_top = d30316Offsets[1];
			//父亲姓名
			if(d30316Value == null || "" == d30316Value || d30316Value == undefined){
				d30316Value = "///" ;
			}
			createDiv(birthInfoTs[23], d30316Value, d30316Offsets_left, d30316Offsets_top);
		}
		
		var d30318Offset = jsonStr[birthInfoTs[24]];
		if(d30318Offset != undefined) {
			var d30318Offsets = d30318Offset.split(";");
			var d30318Offsets_left = d30318Offsets[0];
			var d30318Offsets_top = d30318Offsets[1];
			var d30318Value = vd303[birthInfoTs[24]];
			//父亲年龄
			if(d30318Value == null || "" == d30318Value || d30318Value == undefined){
				d30318Value = "//" ;
			}
			createDiv(birthInfoTs[24], d30318Value, d30318Offsets_left, d30318Offsets_top);
		}
		
		var d30319Offset = jsonStr[birthInfoTs[25]];
		if(d30319Offset != undefined) {
			var d30319Offsets = d30319Offset.split(";");
			var d30319Offsets_left = d30319Offsets[0];
			var d30319Offsets_top = d30319Offsets[1];
			var d30319Value = vd303[birthInfoTs[25]];
			//父亲国籍
			if(d30319Value == null || "" == d30319Value || d30319Value == undefined){
				d30319Value = "//" ;
			}
			createDiv(birthInfoTs[25], d30319Value, d30319Offsets_left, d30319Offsets_top);
		}
		
		var d30320Offset = jsonStr[birthInfoTs[26]];
		if(d30320Offset != undefined) {
			var d30320Offsets = d30320Offset.split(";");
			var d30320Offsets_left = d30320Offsets[0];
			var d30320Offsets_top = d30320Offsets[1];
			var d30320Value = vd303[birthInfoTs[26]];
			//父亲民族
			if(d30320Value == null || "" == d30320Value || d30320Value == undefined){
				d30320Value = "//" ;
			}
			createDiv(birthInfoTs[26], d30320Value, d30320Offsets_left, d30320Offsets_top);
		}
		
		var d30321fOffset = jsonStr[birthInfoTs[27]];
		if(d30321fOffset != undefined) {
			var d30321fOffsets = d30321fOffset.split(";");
			var d30321fOffsets_left = d30321fOffsets[0];
			var d30321fOffsets_top = d30321fOffsets[1];
			var d30352Value = vd303["d30352"];
			//父亲家庭地址
			if(d30316Value == "///" &&(d30352Value == null || "" == d30352Value || d30352Value == undefined)){
				d30352Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[27], d30352Value, d30321fOffsets_left, d30321fOffsets_top);
		}
		
		
		var d30337idZhOffset = jsonStr[birthInfoTs[28]];
		var d30337paZhOffset = jsonStr[birthInfoTs[29]];
		var d30350Offset = jsonStr[birthInfoTs[30]];
		var d30337Value = vd303["d30337"];
		var d30350Value = vd303["d30350"];
		
		if(d30337Value == "1") {
			if(d30337idZhOffset != undefined) {
				var d30337idZhOffsets = d30337idZhOffset.split(";");
				var d30337idZhOffset_left = d30337idZhOffsets[0];
				var d30337idZhOffset_top = d30337idZhOffsets[1];
				
				createDiv(birthInfoTs[28], symbol, d30337idZhOffset_left, d30337idZhOffset_top);
			}
		} else if(d30337Value == "3") {
			if(d30337paZhOffset != undefined) {
				var d30337paZhOffsets = d30337paZhOffset.split(";");
				var d30337paZhOffset_left = d30337paZhOffsets[0];
				var d30337paZhOffset_top = d30337paZhOffsets[1];
				
				createDiv(birthInfoTs[29], symbol, d30337paZhOffset_left, d30337paZhOffset_top);
			}
		} else if(d30337Value == "4") {
			if(d30350Offset != undefined) {
				var d30350Offsets = d30350Offset.split(";");
				var d30350Offset_left = d30350Offsets[0];
				var d30350Offset_top = d30350Offsets[1];
				
				createDiv(birthInfoTs[30], d30350Value, d30350Offset_left, d30350Offset_top);
			}
		}
		
		var d30317Offset = jsonStr[birthInfoTs[31]];
		if(d30317Offset != undefined) {
			var d30317Offsets = d30317Offset.split(";");
			var d30317Offsets_left = d30317Offsets[0];
			var d30317Offsets_top = d30317Offsets[1];
			var d30317Value = vd303[birthInfoTs[31]];
			createDiv(birthInfoTs[31], d30317Value, d30317Offsets_left, d30317Offsets_top);
		}
		
		var d30325Value = vd303[birthInfoTs[32]];
		var d30325Offset = jsonStr[birthInfoTs[32]];
		if(d30325Offset != undefined) {
			var d30325Offsets = d30325Offset.split(";");
			var d30325Offset_left = d30325Offsets[0];
			var d30325Offset_top = d30325Offsets[1];
			createDiv(birthInfoTs[32], d30325Value, d30325Offset_left, d30325Offset_top);
		}
		
		var d30338Value = vd303[birthInfoTs[33]];
		var d30338Offset = jsonStr[birthInfoTs[33]];
		if(d30338Offset != undefined) {
			var d30338Offsets = d30338Offset.split(";");
			var d30338Offset_left = d30338Offsets[0];
			var d30338Offset_top = d30338Offsets[1];
			createDiv(birthInfoTs[33], d30338Value, d30338Offset_left, d30338Offset_top);
		}
		
		var d30327Value = vd303[birthInfoTs[34]];
		var d30327Offset = jsonStr[birthInfoTs[34]];
		if(d30327Offset != undefined) {
			var d30327Offsets = d30327Offset.split(";");
			var d30327Offset_left = d30327Offsets[0];
			var d30327Offset_top = d30327Offsets[1];
			createDiv(birthInfoTs[34], d30327Value, d30327Offset_left, d30327Offset_top);
		}
		
		var d30328Value = vd303[birthInfoTs[35]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30328Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30328OffsetYear = jsonStr[birthInfoTs[35]];
		if(d30328OffsetYear != undefined) {
			var d30328OffsetYears = d30328OffsetYear.split(";");
			var d30328OffsetYear_left = d30328OffsetYears[0];
			var d30328OffsetYear_top = d30328OffsetYears[1];
			createDiv(birthInfoTs[35], yearS, d30328OffsetYear_left, d30328OffsetYear_top);
		}
		
		var d30328OffsetMonth = jsonStr[birthInfoTs[36]];
		if(d30328OffsetMonth != undefined) {
			var d30328OffsetMonths = d30328OffsetMonth.split(";");
			var d30328OffsetMonths_left = d30328OffsetMonths[0];
			var d30328OffsetMonths_top = d30328OffsetMonths[1];
			createDiv(birthInfoTs[36], monthS, d30328OffsetMonths_left, d30328OffsetMonths_top);
		}
		
		var d30328OffsetDate = jsonStr[birthInfoTs[37]];
		if(d30328OffsetDate != undefined) {
			var d30328OffsetDates = d30328OffsetDate.split(";");
			var d30328OffsetDates_left = d30328OffsetDates[0];
			var d30328OffsetDates_top = d30328OffsetDates[1];
			createDiv(birthInfoTs[37], dateS, d30328OffsetDates_left, d30328OffsetDates_top);
		}
		
		var d30326Value = vd303[birthInfoTs[38]];
		var d30326Offset = jsonStr[birthInfoTs[38]];
		if(d30326Offset != undefined) {
			var d30326Offsets = d30326Offset.split(";");
			var d30326Offset_left = d30326Offsets[0];
			var d30326Offset_top = d30326Offsets[1];
			createDiv(birthInfoTs[38], d30326Value, d30326Offset_left, d30326Offset_top);
		}
	}, "json");
});

function createDiv(id, value, offset_left, offset_top)
{
	if(id == "d30307" || id == "d30307S" || id == "d30307T") {
		$("body").append($("<div></div>").attr("id", id).append(value));
	} else {
		$("body").append($("<div></div>").attr("id", id).text(value));
	}
	
	$("#" + id).css({"position":"absolute", "font-size":"15px"});
	$("#" + id).offset({left:offset_left, top:offset_top});
}