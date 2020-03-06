 var contextRoot = "/csyxzm";
$(document).ready(function(){
	
	var printInfo = new Array();
	var printInfoLabel  = new Array();
	
	printInfo[0] = "BIRTH_PRINTINFO_NEW";
	printInfoLabel[0] = "出生证明";

	printInfo[1] = "BIRTH_PRINTINFO_SECOND_NEW";
	printInfoLabel[1] = "副页";
	
	printInfo[2] = "BIRTH_PRINTINFO_THIRD_NEW";
	printInfoLabel[2] = "存根";
	
	var birthInfo = new Array();
	var birthInfoLabel = new Array();
	
	birthInfo[0] = "d30102;d30103;d30104;d30104m;d30104d;d30104h;d30104mi;d30107;d30129;d30108;d30105;d30105c;d30105co;d30124Zh;d30111;d30113;d30114Zh;d30115Zh;d30121m;d30134id;d30134pa;d30144;d30112;d30116;d30118;d30119Zh;d30120Zh;d30121f;d30135id;d30135pa;d30145;d30117;d30126Zh;d30128;d30128m;d30128d";
	birthInfoLabel[0] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;签发机构;签发年;签发月;签发日";
	birthInfo[1] = "d30102S;d30103S;d30104S;d30104mS;d30104dS;d30104hS;d30104miS;d30107S;d30129S;d30108S;d30105S;d30105cS;d30105coS;d30124ZhS;d30111S;d30113S;d30114ZhS;d30115ZhS;d30121mS;d30134idS;d30134paS;d30144S;d30112S;d30116S;d30118S;d30119ZhS;d30120ZhS;d30121fS;d30135idS;d30135paS;d30145S;d30117S;d30126ZhS;d30128S;d30128mS;d30128dS";
    birthInfoLabel[1] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;签发机构;签发年;签发月;签发日";
	birthInfo[2] = "d30102T;d30103T;d30104T;d30104mT;d30104dT;d30104hT;d30104miT;d30107T;d30129T;d30108T;d30105T;d30105cT;d30105coT;d30124ZhT;d30111T;d30113T;d30114ZhT;d30115ZhT;d30121mT;d30134idT;d30134paT;d30144T;d30112T;d30116T;d30118T;d30119ZhT;d30120ZhT;d30121fT;d30135idT;d30135paT;d30145T;d30117T;d30125T;d30136T;d30127T;d30128T;d30128mT;d30128dT;d30126ZhT";
    birthInfoLabel[2] = "新生儿姓名;性别;年;月;日;时;分;孕周;体重;身长;省;市;县;医疗机构名称;母亲姓名;母亲年龄;母亲国籍;母亲民族;母亲住址;母亲身份证;母亲护照;母亲其他;母亲证件号码;父亲姓名;父亲年龄;父亲国籍;父亲民族;父亲住址;父亲身份证;父亲护照;父亲其他;父亲证件号码;接生人;领证人;签发人;签发年;签发月;签发日;签发机构";
	
	var d30110 = $("#d30110").val();
	var userCode = $("#userCode").val();
	$.post(contextRoot + "/PrintBirthInfoServletNew", {"flag":"BIRTH_PRINTINFO_NEW","d30110":d30110, "userCode":userCode}, function(data){
		var jsonStr = data[0];//位置
		var vd301 = data[1];//值
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
		var gender = "";
		birthInfosD30103Offset = jsonStr[birthInfos[1]];
		if(d30103Value == "1") {
			gender = "男";
		} else if(d30103Value == "2") {
			gender = "女";
		} 
		if(birthInfosD30103Offset != "") {
			var d30103Offset = birthInfosD30103Offset.split(";");
			var d30103Offset_left = d30103Offset[0];
			var d30103Offset_top = d30103Offset[1];
			createDiv(birthInfos[1], gender, d30103Offset_left, d30103Offset_top);
		}
		
		var d30104Value = vd301[birthInfos[2]];
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
		
		var d30104Offset = jsonStr[birthInfos[2]];
		if(d30104Offset != undefined) {
			var d30104Offsets = d30104Offset.split(";");
			var d30104Offset_left = d30104Offsets[0];
			var d30104Offset_top = d30104Offsets[1];
			createDiv(birthInfos[2], year, d30104Offset_left, d30104Offset_top);
		}
		
		var d30104MonthOffset = jsonStr[birthInfos[3]];
		if(d30104MonthOffset != undefined) {
			var d30104MonthOffsets = d30104MonthOffset.split(";");
			var d30104MonthOffset_left = d30104MonthOffsets[0];
			var d30104MonthOffset_top = d30104MonthOffsets[1];
			createDiv(birthInfos[3], month, d30104MonthOffset_left, d30104MonthOffset_top);
		}
		
		var d30104DateOffset = jsonStr[birthInfos[4]];
		if(d30104DateOffset != undefined) {
			var d30104DateOffsets = d30104DateOffset.split(";");
			var d30104DateOffset_left = d30104DateOffsets[0];
			var d30104DateOffset_top = d30104DateOffsets[1];
			createDiv(birthInfos[4], date, d30104DateOffset_left, d30104DateOffset_top);
		}
		
		var d30104HourOffset = jsonStr[birthInfos[5]];
		if(d30104HourOffset != undefined) {
			var d30104HourOffsets = d30104HourOffset.split(";");
			var d30104HourOffset_left = d30104HourOffsets[0];
			var d30104HourOffset_top = d30104HourOffsets[1];
			createDiv(birthInfos[5], hour, d30104HourOffset_left, d30104HourOffset_top);
		}
		
		var d30104MinuteOffset = jsonStr[birthInfos[6]];
		if(d30104MinuteOffset != undefined) {
			var d30104MinuteOffsets = d30104MinuteOffset.split(";");
			var d30104MinuteOffset_left = d30104MinuteOffsets[0];
			var d30104MinuteOffset_top = d30104MinuteOffsets[1];
			createDiv(birthInfos[6], minute, d30104MinuteOffset_left, d30104MinuteOffset_top);
		}
		
		var d30107 = vd301[birthInfos[7]]; // weeks
		var d30147 = vd301["d30147"]; // days
		
		var d30107Offset = jsonStr[birthInfos[7]];
		if(d30107Offset != undefined) {
			var d30107Offsets = d30107Offset.split(";");
			var d30107Offset_left = d30107Offsets[0];
			var d30107Offset_top = d30107Offsets[1];
			if(d30147 != undefined && d30147 != 0) {
				createDiv(birthInfos[7], d30107 + "<sup>+" + d30147 + "</sup>", d30107Offset_left, d30107Offset_top);
			} else {
				createDiv(birthInfos[7], d30107, d30107Offset_left, d30107Offset_top);
			}
		}
		
		var d30129 = vd301[birthInfos[8]];
		var d30129Offset = jsonStr[birthInfos[8]];
		if(d30129Offset != undefined) {
			var d30129Offsets = d30129Offset.split(";");
			var d30129Offset_left = d30129Offsets[0];
			var d30129Offset_top = d30129Offsets[1];
			createDiv(birthInfos[8], d30129, d30129Offset_left, d30129Offset_top);
		}
		
		var d30108 = vd301[birthInfos[9]];
		var d30108Offset = jsonStr[birthInfos[9]];
		if(d30108Offset != undefined) {
			var d30108Offsets = d30108Offset.split(";");
			var d30108Offset_left = d30108Offsets[0];
			var d30108Offset_top = d30108Offsets[1];
			createDiv(birthInfos[9], d30108, d30108Offset_left, d30108Offset_top);
		}
		
		var d30105OffsetProviceValue = "";
		var d30105OffsetCityValue = "";
		var d30105OffsetCountyValue = "";
		var areaCode = vd301["d30105"];
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30105OffsetProviceValue = dataValue[0];
			d30105OffsetCityValue = dataValue[1];
			d30105OffsetCountyValue = dataValue[2];
			
			var d30105OffsetProvice = jsonStr[birthInfos[10]];
			var d30105OffsetCity = jsonStr[birthInfos[11]];
			var d30105OffsetCounty = jsonStr[birthInfos[12]];
			if(d30105OffsetProvice != undefined) {
				var d30105OffsetProvices =  d30105OffsetProvice.split(";");
				var d30105OffsetProvices_left = d30105OffsetProvices[0];
				var d30105OffsetProvices_top = d30105OffsetProvices[1];
				createDiv(birthInfos[10], d30105OffsetProviceValue, d30105OffsetProvices_left, d30105OffsetProvices_top);
			}
			if(d30105OffsetCity != undefined) {
				var d30105OffsetCitys =  d30105OffsetCity.split(";");
				var d30105OffsetCitys_left = d30105OffsetCitys[0];
				var d30105OffsetCitys_top = d30105OffsetCitys[1];
				createDiv(birthInfos[11], d30105OffsetCityValue, d30105OffsetCitys_left, d30105OffsetCitys_top);
			}
			if(d30105OffsetCounty != undefined) {
				var d30105OffsetCountys =  d30105OffsetCounty.split(";");
				var d30105OffsetCountys_left = d30105OffsetCountys[0];
				var d30105OffsetCountys_top = d30105OffsetCountys[1];
				createDiv(birthInfos[12], d30105OffsetCountyValue, d30105OffsetCountys_left, d30105OffsetCountys_top);
			}
		}, "json");
		
		var d30124Offset = jsonStr[birthInfos[13]];
		if(d30124Offset != undefined) {
			var d30124Offsets = d30124Offset.split(";");
			var d30124Offsets_left = d30124Offsets[0];
			var d30124Offsets_top = d30124Offsets[1];
			var d30124Value = vd301[birthInfos[13]];
			if(d30124Value == null || "" == d30124Value || d30124Value == undefined || d30124Value == "///" && (d30124Value == undefined || "" == d30124Value || d30124Value == undefined)){
				d30124Value = "//////////////////" ;
			}
			createDiv(birthInfos[13], d30124Value, d30124Offsets_left, d30124Offsets_top);
		}
		
		var d30111Value = vd301[birthInfos[14]];
		
		var d30111Offset = jsonStr[birthInfos[14]];
		if(d30111Offset != undefined) {
			var d30111Offsets = d30111Offset.split(";");
			d30111Offset_left = d30111Offsets[0];
			d30111Offset_top = d30111Offsets[1];
			//母亲姓名
			if(d30111Value == null || "" == d30111Value || d30111Value == undefined){
				d30111Value = "///" ;
			}
			createDiv(birthInfos[14], d30111Value, d30111Offset_left, d30111Offset_top);
		}
		
		var d30113Offset = jsonStr[birthInfos[15]];
		if(d30113Offset != undefined) {
			var d30113Offsets = d30113Offset.split(";");
			var d30113Offsets_left = d30113Offsets[0];
			var d30113Offsets_top = d30113Offsets[1];
			var d30113Value = vd301[birthInfos[15]];
			//母亲年龄
			if(d30113Value == null || "" == d30113Value || d30113Value == undefined){
				d30113Value = "//" ;
			}
			createDiv(birthInfos[15], d30113Value, d30113Offsets_left, d30113Offsets_top);
		}
		
		var d30114Offset = jsonStr[birthInfos[16]];
		if(d30114Offset != undefined) {
			var d30114Offsets = d30114Offset.split(";");
			var d30114Offsets_left = d30114Offsets[0];
			var d30114Offsets_top = d30114Offsets[1];
			var d30114Value = vd301[birthInfos[16]];
			//母亲国籍
			if(d30114Value == null || "" == d30114Value || d30114Value == undefined){
				d30114Value = "//" ;
			}
			createDiv(birthInfos[16], d30114Value, d30114Offsets_left, d30114Offsets_top);
		}
		
		var d30115Offset = jsonStr[birthInfos[17]];
		if(d30115Offset != undefined) {
			var d30115Offsets = d30115Offset.split(";");
			var d30115Offsets_left = d30115Offsets[0];
			var d30115Offsets_top = d30115Offsets[1];
			var d30115Value = vd301[birthInfos[17]];
			//母亲民族
			if(d30115Value == null || "" == d30115Value || d30115Value == undefined){
				d30115Value = "//" ;
			}
			createDiv(birthInfos[17], d30115Value, d30115Offsets_left, d30115Offsets_top);
		}
		
		var d30121mOffset = jsonStr[birthInfos[18]];
		if(d30121mOffset != undefined) {
			var d30121mOffsets = d30121mOffset.split(";");
			var d30121mOffsets_left = d30121mOffsets[0];
			var d30121mOffsets_top = d30121mOffsets[1];
			var d30121mValue = vd301["d30121"];
			//母亲家庭住址
			if(d30111Value == "///" && (d30121mValue == null || "" == d30121mValue || d30121mValue == undefined)){
				d30121mValue = "//////////////////" ;
			}
			createDiv(birthInfos[18], d30121mValue, d30121mOffsets_left, d30121mOffsets_top);
		}
		
		var d30134idZhOffset = jsonStr[birthInfos[19]];
		var d30134paZhOffset = jsonStr[birthInfos[20]];
		var d30144Offset = jsonStr[birthInfos[21]];
		var d30134Value = vd301["d30134"];
		var d30144Value = vd301["d30144"];
		
		if(d30134Value == "1") {
			if(d30134idZhOffset != undefined) {
				var d30134idZhOffsets = d30134idZhOffset.split(";");
				var d30134idZhOffset_left = d30134idZhOffsets[0];
				var d30134idZhOffset_top = d30134idZhOffsets[1];
				
				createDiv(birthInfos[19], symbol, d30134idZhOffset_left, d30134idZhOffset_top);
			}
		} else if(d30134Value == "3") {
			if(d30134paZhOffset != undefined) {
				var d30134paZhOffsets = d30134paZhOffset.split(";");
				var d30134paZhOffset_left = d30134paZhOffsets[0];
				var d30134paZhOffset_top = d30134paZhOffsets[1];
				
				createDiv(birthInfos[20], symbol, d30134paZhOffset_left, d30134paZhOffset_top);
			}
		} else if(d30134Value == "4") {
			if(d30144Offset != undefined) {
				var d30144Offsets = d30144Offset.split(";");
				var d30144Offset_left = d30144Offsets[0];
				var d30144Offset_top = d30144Offsets[1];
				
				createDiv(birthInfos[21], d30144Value, d30144Offset_left, d30144Offset_top);
			}
		}
		
		
		
		var d30112Offset = jsonStr[birthInfos[22]];
		if(d30112Offset != undefined) {
			var d30112Offsets = d30112Offset.split(";");
			var d30112Offsets_left = d30112Offsets[0];
			var d30112Offsets_top = d30112Offsets[1];
			var d30112Value = vd301[birthInfos[22]];
			//母亲身份证号
			if(d30112Value == null || "" == d30112Value || d30112Value == undefined){
				d30112Value = "//////////////////" ;
			}
			createDiv(birthInfos[22], d30112Value, d30112Offsets_left, d30112Offsets_top);
		}
		
		var d30116Value = vd301[birthInfos[23]];
		var d30116Offset = jsonStr[birthInfos[23]];
		if(d30116Offset != undefined) {
			var d30116Offsets = d30116Offset.split(";");
			var d30116Offsets_left = d30116Offsets[0];
			var d30116Offsets_top = d30116Offsets[1];
			//父亲姓名
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined){
				d30116Value = "///" ;
			}
			createDiv(birthInfos[23], d30116Value, d30116Offsets_left, d30116Offsets_top);
		}
		
		var d30118Offset = jsonStr[birthInfos[24]];
		if(d30118Offset != undefined) {
			var d30118Offsets = d30118Offset.split(";");
			var d30118Offsets_left = d30118Offsets[0];
			var d30118Offsets_top = d30118Offsets[1];
			var d30118Value = vd301[birthInfos[24]];
			//父亲年龄
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30118Value == null || "" == d30118Value || d30118Value == undefined){
				d30118Value = "//" ;
			}
			createDiv(birthInfos[24], d30118Value, d30118Offsets_left, d30118Offsets_top);
		}
		
		var d30119Offset = jsonStr[birthInfos[25]];
		if(d30119Offset != undefined) {
			var d30119Offsets = d30119Offset.split(";");
			var d30119Offsets_left = d30119Offsets[0];
			var d30119Offsets_top = d30119Offsets[1];
			var d30119Value = vd301[birthInfos[25]];
			//父亲国籍
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30119Value == null || "" == d30119Value || d30119Value == undefined){
				d30119Value = "//" ;
			}
			createDiv(birthInfos[25], d30119Value, d30119Offsets_left, d30119Offsets_top);
		}
		
		var d30120Offset = jsonStr[birthInfos[26]];
		if(d30120Offset != undefined) {
			var d30120Offsets = d30120Offset.split(";");
			var d30120Offsets_left = d30120Offsets[0];
			var d30120Offsets_top = d30120Offsets[1];
			var d30120Value = vd301[birthInfos[26]];
			//父亲民族
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30120Value == null || "" == d30120Value || d30120Value == undefined){
				d30120Value = "//" ;
			}
			createDiv(birthInfos[26], d30120Value, d30120Offsets_left, d30120Offsets_top);
		}
		
		var d30121fOffset = jsonStr[birthInfos[27]];
		if(d30121fOffset != undefined) {
			var d30121fOffsets = d30121fOffset.split(";");
			var d30121fOffsets_left = d30121fOffsets[0];
			var d30121fOffsets_top = d30121fOffsets[1];
			var d30148Value = vd301["d30148"];
			//父亲家庭住址
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30116Value == "///" && (d30148Value == undefined || "" == d30148Value || d30148Value == undefined)){
				d30148Value = "//////////////////" ;
			}
			createDiv(birthInfos[27], d30148Value, d30121fOffsets_left, d30121fOffsets_top);
		}
		
		
		var d30135idZhOffset = jsonStr[birthInfos[28]];
		var d30135paZhOffset = jsonStr[birthInfos[29]];
		var d30145Offset = jsonStr[birthInfos[30]];
		var d30135Value = vd301["d30135"];
		var d30145Value = vd301["d30145"];
		
		if(d30135Value == "1") {
			if(d30135idZhOffset != undefined) {
				var d30135idZhOffsets = d30135idZhOffset.split(";");
				var d30135idZhOffset_left = d30135idZhOffsets[0];
				var d30135idZhOffset_top = d30135idZhOffsets[1];
				
				createDiv(birthInfos[28], symbol, d30135idZhOffset_left, d30135idZhOffset_top);
			}
		} else if(d30135Value == "3") {
			if(d30135paZhOffset != undefined) {
				var d30135paZhOffsets = d30135paZhOffset.split(";");
				var d30135paZhOffset_left = d30135paZhOffsets[0];
				var d30135paZhOffset_top = d30135paZhOffsets[1];
				
				createDiv(birthInfos[29], symbol, d30135paZhOffset_left, d30135paZhOffset_top);
			}
		} else {
			if(d30145Offset != undefined) {
				var d30145Offsets = d30145Offset.split(";");
				var d30145Offset_left = d30145Offsets[0];
				var d30145Offset_top = d30145Offsets[1];
				
				createDiv(birthInfos[30], d30145Value, d30145Offset_left, d30145Offset_top);
			}
		}
		
		var d30117Offset = jsonStr[birthInfos[31]];
		if(d30117Offset != undefined) {
			var d30117Offsets = d30117Offset.split(";");
			var d30117Offsets_left = d30117Offsets[0];
			var d30117Offsets_top = d30117Offsets[1];
			var d30117Value = vd301[birthInfos[31]];
			//父亲身份证号
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30117Value == null || "" == d30117Value || d30117Value == undefined){
				d30117Value = "//////////////////" ;
			}
			createDiv(birthInfos[31], d30117Value, d30117Offsets_left, d30117Offsets_top);
		}
		
		var d30126ZhValue = vd301[birthInfos[32]];
		var d30126ZhOffset = jsonStr[birthInfos[32]];
		if(d30126ZhOffset != undefined) {
			var d30126ZhOffsets = d30126ZhOffset.split(";");
			var d30126ZhOffset_left = d30126ZhOffsets[0];
			var d30126ZhOffset_top = d30126ZhOffsets[1];
			createDiv(birthInfos[32], d30126ZhValue, d30126ZhOffset_left, d30126ZhOffset_top);
		}
		
		
		
		var d30128Value = vd301[birthInfos[33]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30128Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30128OffsetYear = jsonStr[birthInfos[33]];
		if(d30128OffsetYear != undefined) {
			var d30128OffsetYears = d30128OffsetYear.split(";");
			var d30128OffsetYear_left = d30128OffsetYears[0];
			var d30128OffsetYear_top = d30128OffsetYears[1];
			createDiv(birthInfos[33], yearS, d30128OffsetYear_left, d30128OffsetYear_top);
		}
		
		var d30128OffsetMonth = jsonStr[birthInfos[34]];
		if(d30128OffsetMonth != undefined) {
			var d30128OffsetMonths = d30128OffsetMonth.split(";");
			var d30128OffsetMonths_left = d30128OffsetMonths[0];
			var d30128OffsetMonths_top = d30128OffsetMonths[1];
			createDiv(birthInfos[34], monthS, d30128OffsetMonths_left, d30128OffsetMonths_top);
		}
		
		var d30128OffsetDate = jsonStr[birthInfos[35]];
		if(d30128OffsetDate != undefined) {
			var d30128OffsetDates = d30128OffsetDate.split(";");
			var d30128OffsetDates_left = d30128OffsetDates[0];
			var d30128OffsetDates_top = d30128OffsetDates[1];
			createDiv(birthInfos[35], dateS, d30128OffsetDates_left, d30128OffsetDates_top);
		}
	
		var birthInfoSs = birthInfo[1].split(";");
		var birthInfoSsD30102Offset = jsonStr[birthInfoSs[0]];
		if(birthInfoSsD30102Offset != undefined) {
			var d30102Offset = birthInfoSsD30102Offset.split(";");
			var d30102Offset_left = d30102Offset[0];
			var d30102Offset_top = d30102Offset[1];
			var d30102Value = vd301[birthInfoSs[0]];
			createDiv(birthInfoSs[0], d30102Value, d30102Offset_left, d30102Offset_top);
		}
		
		var d30103Value = vd301[birthInfoSs[1]];
		var birthInfoSsD30103Offset = "";
		var gender = "";
		birthInfoSsD30103Offset = jsonStr[birthInfoSs[1]];
		if(d30103Value == "1") {
			gender = "男";
		} else if(d30103Value == "2") {
			gender = "女";
		} 
		if(birthInfoSsD30103Offset != "") {
			var d30103Offset = birthInfoSsD30103Offset.split(";");
			var d30103Offset_left = d30103Offset[0];
			var d30103Offset_top = d30103Offset[1];
			createDiv(birthInfoSs[1], gender, d30103Offset_left, d30103Offset_top);
		}
		
		var d30104Value = vd301[birthInfoSs[2]];
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
		
		var d30104Offset = jsonStr[birthInfoSs[2]];
		if(d30104Offset != undefined) {
			var d30104Offsets = d30104Offset.split(";");
			var d30104Offset_left = d30104Offsets[0];
			var d30104Offset_top = d30104Offsets[1];
			createDiv(birthInfoSs[2], year, d30104Offset_left, d30104Offset_top);
		}
		
		var d30104MonthOffset = jsonStr[birthInfoSs[3]];
		if(d30104MonthOffset != undefined) {
			var d30104MonthOffsets = d30104MonthOffset.split(";");
			var d30104MonthOffset_left = d30104MonthOffsets[0];
			var d30104MonthOffset_top = d30104MonthOffsets[1];
			createDiv(birthInfoSs[3], month, d30104MonthOffset_left, d30104MonthOffset_top);
		}
		
		var d30104DateOffset = jsonStr[birthInfoSs[4]];
		if(d30104DateOffset != undefined) {
			var d30104DateOffsets = d30104DateOffset.split(";");
			var d30104DateOffset_left = d30104DateOffsets[0];
			var d30104DateOffset_top = d30104DateOffsets[1];
			createDiv(birthInfoSs[4], date, d30104DateOffset_left, d30104DateOffset_top);
		}
		
		var d30104HourOffset = jsonStr[birthInfoSs[5]];
		if(d30104HourOffset != undefined) {
			var d30104HourOffsets = d30104HourOffset.split(";");
			var d30104HourOffset_left = d30104HourOffsets[0];
			var d30104HourOffset_top = d30104HourOffsets[1];
			createDiv(birthInfoSs[5], hour, d30104HourOffset_left, d30104HourOffset_top);
		}
		
		var d30104MinuteOffset = jsonStr[birthInfoSs[6]];
		if(d30104MinuteOffset != undefined) {
			var d30104MinuteOffsets = d30104MinuteOffset.split(";");
			var d30104MinuteOffset_left = d30104MinuteOffsets[0];
			var d30104MinuteOffset_top = d30104MinuteOffsets[1];
			createDiv(birthInfoSs[6], minute, d30104MinuteOffset_left, d30104MinuteOffset_top);
		}
		
		var d30107 = vd301[birthInfoSs[7]]; // weeks
		var d30147 = vd301["d30147"]; // days
		
		var d30107Offset = jsonStr[birthInfoSs[7]];
		if(d30107Offset != undefined) {
			var d30107Offsets = d30107Offset.split(";");
			var d30107Offset_left = d30107Offsets[0];
			var d30107Offset_top = d30107Offsets[1];
			if(d30147 != undefined && d30147 != 0) {
				createDiv(birthInfoSs[7], d30107 + "<sup>+" + d30147 + "</sup>", d30107Offset_left, d30107Offset_top);
			} else {
				createDiv(birthInfoSs[7], d30107, d30107Offset_left, d30107Offset_top);
			}
		}
		
		var d30129 = vd301[birthInfoSs[8]];
		var d30129Offset = jsonStr[birthInfoSs[8]];
		if(d30129Offset != undefined) {
			var d30129Offsets = d30129Offset.split(";");
			var d30129Offset_left = d30129Offsets[0];
			var d30129Offset_top = d30129Offsets[1];
			createDiv(birthInfoSs[8], d30129, d30129Offset_left, d30129Offset_top);
		}
		
		var d30108 = vd301[birthInfoSs[9]];
		var d30108Offset = jsonStr[birthInfoSs[9]];
		if(d30108Offset != undefined) {
			var d30108Offsets = d30108Offset.split(";");
			var d30108Offset_left = d30108Offsets[0];
			var d30108Offset_top = d30108Offsets[1];
			createDiv(birthInfoSs[9], d30108, d30108Offset_left, d30108Offset_top);
		}
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30105OffsetProviceValue = dataValue[0];
			d30105OffsetCityValue = dataValue[1];
			d30105OffsetCountyValue = dataValue[2];
			
			var d30105OffsetProvice = jsonStr[birthInfoSs[10]];
			var d30105OffsetCity = jsonStr[birthInfoSs[11]];
			var d30105OffsetCounty = jsonStr[birthInfoSs[12]];

			if(d30105OffsetProvice != undefined) {
				var d30105OffsetProvices =  d30105OffsetProvice.split(";");
				var d30105OffsetProvices_left = d30105OffsetProvices[0];
				var d30105OffsetProvices_top = d30105OffsetProvices[1];
				createDiv(birthInfoSs[10], d30105OffsetProviceValue, d30105OffsetProvices_left, d30105OffsetProvices_top);
			}
			if(d30105OffsetCity != undefined) {
				var d30105OffsetCitys =  d30105OffsetCity.split(";");
				var d30105OffsetCitys_left = d30105OffsetCitys[0];
				var d30105OffsetCitys_top = d30105OffsetCitys[1];
				createDiv(birthInfoSs[11], d30105OffsetCityValue, d30105OffsetCitys_left, d30105OffsetCitys_top);
			}
			if(d30105OffsetCounty != undefined) {
				var d30105OffsetCountys =  d30105OffsetCounty.split(";");
				var d30105OffsetCountys_left = d30105OffsetCountys[0];
				var d30105OffsetCountys_top = d30105OffsetCountys[1];
				createDiv(birthInfoSs[12], d30105OffsetCountyValue, d30105OffsetCountys_left, d30105OffsetCountys_top);
			}
		}, "json");
		
		var d30124Offset = jsonStr[birthInfoSs[13]];
		if(d30124Offset != undefined) {
			var d30124Offsets = d30124Offset.split(";");
			var d30124Offsets_left = d30124Offsets[0];
			var d30124Offsets_top = d30124Offsets[1];
			var d30124Value = vd301[birthInfoSs[13]];
			if(d30124Value == null || "" == d30124Value || d30124Value == undefined || d30124Value == "///" && (d30124Value == undefined || "" == d30124Value || d30124Value == undefined)){
				d30124Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[13], d30124Value, d30124Offsets_left, d30124Offsets_top);
		}
		
		var d30111Value = vd301[birthInfoSs[14]];
		
		var d30111Offset = jsonStr[birthInfoSs[14]];
		if(d30111Offset != undefined) {
			var d30111Offsets = d30111Offset.split(";");
			d30111Offset_left = d30111Offsets[0];
			d30111Offset_top = d30111Offsets[1];
			//母亲姓名
			if(d30111Value == null || "" == d30111Value || d30111Value == undefined){
				d30111Value = "///" ;
			}
			createDiv(birthInfoSs[14], d30111Value, d30111Offset_left, d30111Offset_top);
		}
		
		var d30113Offset = jsonStr[birthInfoSs[15]];
		if(d30113Offset != undefined) {
			var d30113Offsets = d30113Offset.split(";");
			var d30113Offsets_left = d30113Offsets[0];
			var d30113Offsets_top = d30113Offsets[1];
			var d30113Value = vd301[birthInfoSs[15]];
			//母亲年龄
			if(d30113Value == null || "" == d30113Value || d30113Value == undefined){
				d30113Value = "//" ;
			}
			createDiv(birthInfoSs[15], d30113Value, d30113Offsets_left, d30113Offsets_top);
		}
		
		var d30114Offset = jsonStr[birthInfoSs[16]];
		if(d30114Offset != undefined) {
			var d30114Offsets = d30114Offset.split(";");
			var d30114Offsets_left = d30114Offsets[0];
			var d30114Offsets_top = d30114Offsets[1];
			var d30114Value = vd301[birthInfoSs[16]];
			//母亲国籍
			if(d30114Value == null || "" == d30114Value || d30114Value == undefined){
				d30114Value = "//" ;
			}
			createDiv(birthInfoSs[16], d30114Value, d30114Offsets_left, d30114Offsets_top);
		}
		
		var d30115Offset = jsonStr[birthInfoSs[17]];
		if(d30115Offset != undefined) {
			var d30115Offsets = d30115Offset.split(";");
			var d30115Offsets_left = d30115Offsets[0];
			var d30115Offsets_top = d30115Offsets[1];
			var d30115Value = vd301[birthInfoSs[17]];
			//母亲民族
			if(d30115Value == null || "" == d30115Value || d30115Value == undefined){
				d30115Value = "//" ;
			}
			createDiv(birthInfoSs[17], d30115Value, d30115Offsets_left, d30115Offsets_top);
		}
		
		var d30121mOffset = jsonStr[birthInfoSs[18]];
		if(d30121mOffset != undefined) {
			var d30121mOffsets = d30121mOffset.split(";");
			var d30121mOffsets_left = d30121mOffsets[0];
			var d30121mOffsets_top = d30121mOffsets[1];
			var d30121mValue = vd301["d30121"];
			//母亲家庭住址
			if(d30111Value == "///" && (d30121mValue == null || "" == d30121mValue || d30121mValue == undefined)){
				d30121mValue = "//////////////////" ;
			}
			createDiv(birthInfoSs[18], d30121mValue, d30121mOffsets_left, d30121mOffsets_top);
		}
		
		var d30134idZhOffset = jsonStr[birthInfoSs[19]];
		var d30134paZhOffset = jsonStr[birthInfoSs[20]];
		var d30144Offset = jsonStr[birthInfoSs[21]];
		var d30134Value = vd301["d30134"];
		var d30144Value = vd301["d30144"];
		
		if(d30134Value == "1") {
			if(d30134idZhOffset != undefined) {
				var d30134idZhOffsets = d30134idZhOffset.split(";");
				var d30134idZhOffset_left = d30134idZhOffsets[0];
				var d30134idZhOffset_top = d30134idZhOffsets[1];
				
				createDiv(birthInfoSs[19], symbol, d30134idZhOffset_left, d30134idZhOffset_top);
			}
		} else if(d30134Value == "3") {
			if(d30134paZhOffset != undefined) {
				var d30134paZhOffsets = d30134paZhOffset.split(";");
				var d30134paZhOffset_left = d30134paZhOffsets[0];
				var d30134paZhOffset_top = d30134paZhOffsets[1];
				
				createDiv(birthInfoSs[20], symbol, d30134paZhOffset_left, d30134paZhOffset_top);
			}
		} else if(d30134Value == "4") {
			if(d30144Offset != undefined) {
				var d30144Offsets = d30144Offset.split(";");
				var d30144Offset_left = d30144Offsets[0];
				var d30144Offset_top = d30144Offsets[1];
				
				createDiv(birthInfoSs[21], d30144Value, d30144Offset_left, d30144Offset_top);
			}
		}
		
		
		
		var d30112Offset = jsonStr[birthInfoSs[22]];
		if(d30112Offset != undefined) {
			var d30112Offsets = d30112Offset.split(";");
			var d30112Offsets_left = d30112Offsets[0];
			var d30112Offsets_top = d30112Offsets[1];
			var d30112Value = vd301[birthInfoSs[22]];
			//母亲身份证号
			if(d30112Value == null || "" == d30112Value || d30112Value == undefined){
				d30112Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[22], d30112Value, d30112Offsets_left, d30112Offsets_top);
		}
		
		var d30116Value = vd301[birthInfoSs[23]];
		var d30116Offset = jsonStr[birthInfoSs[23]];
		if(d30116Offset != undefined) {
			var d30116Offsets = d30116Offset.split(";");
			var d30116Offsets_left = d30116Offsets[0];
			var d30116Offsets_top = d30116Offsets[1];
			//父亲姓名
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined){
				d30116Value = "///" ;
			}
			createDiv(birthInfoSs[23], d30116Value, d30116Offsets_left, d30116Offsets_top);
		}
		
		var d30118Offset = jsonStr[birthInfoSs[24]];
		if(d30118Offset != undefined) {
			var d30118Offsets = d30118Offset.split(";");
			var d30118Offsets_left = d30118Offsets[0];
			var d30118Offsets_top = d30118Offsets[1];
			var d30118Value = vd301[birthInfoSs[24]];
			//父亲年龄
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30118Value == null || "" == d30118Value || d30118Value == undefined){
				d30118Value = "//" ;
			}
			createDiv(birthInfoSs[24], d30118Value, d30118Offsets_left, d30118Offsets_top);
		}
		
		var d30119Offset = jsonStr[birthInfoSs[25]];
		if(d30119Offset != undefined) {
			var d30119Offsets = d30119Offset.split(";");
			var d30119Offsets_left = d30119Offsets[0];
			var d30119Offsets_top = d30119Offsets[1];
			var d30119Value = vd301[birthInfoSs[25]];
			//父亲国籍
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30119Value == null || "" == d30119Value || d30119Value == undefined){
				d30119Value = "//" ;
			}
			createDiv(birthInfoSs[25], d30119Value, d30119Offsets_left, d30119Offsets_top);
		}
		
		var d30120Offset = jsonStr[birthInfoSs[26]];
		if(d30120Offset != undefined) {
			var d30120Offsets = d30120Offset.split(";");
			var d30120Offsets_left = d30120Offsets[0];
			var d30120Offsets_top = d30120Offsets[1];
			var d30120Value = vd301[birthInfoSs[26]];
			//父亲民族
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30120Value == null || "" == d30120Value || d30120Value == undefined){
				d30120Value = "//" ;
			}
			createDiv(birthInfoSs[26], d30120Value, d30120Offsets_left, d30120Offsets_top);
		}
		
		var d30121fOffset = jsonStr[birthInfoSs[27]];
		if(d30121fOffset != undefined) {
			var d30121fOffsets = d30121fOffset.split(";");
			var d30121fOffsets_left = d30121fOffsets[0];
			var d30121fOffsets_top = d30121fOffsets[1];
			var d30148Value = vd301["d30148"];
			//父亲家庭住址
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30116Value == "///" && (d30148Value == undefined || "" == d30148Value || d30148Value == undefined)){
				d30148Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[27], d30148Value, d30121fOffsets_left, d30121fOffsets_top);
		}
		
		
		var d30135idZhOffset = jsonStr[birthInfoSs[28]];
		var d30135paZhOffset = jsonStr[birthInfoSs[29]];
		var d30145Offset = jsonStr[birthInfoSs[30]];
		var d30135Value = vd301["d30135"];
		var d30145Value = vd301["d30145"];
		
		if(d30135Value == "1") {
			if(d30135idZhOffset != undefined) {
				var d30135idZhOffsets = d30135idZhOffset.split(";");
				var d30135idZhOffset_left = d30135idZhOffsets[0];
				var d30135idZhOffset_top = d30135idZhOffsets[1];
				
				createDiv(birthInfoSs[28], symbol, d30135idZhOffset_left, d30135idZhOffset_top);
			}
		} else if(d30135Value == "3") {
			if(d30135paZhOffset != undefined) {
				var d30135paZhOffsets = d30135paZhOffset.split(";");
				var d30135paZhOffset_left = d30135paZhOffsets[0];
				var d30135paZhOffset_top = d30135paZhOffsets[1];
				
				createDiv(birthInfoSs[29], symbol, d30135paZhOffset_left, d30135paZhOffset_top);
			}
		} else {
			if(d30145Offset != undefined) {
				var d30145Offsets = d30145Offset.split(";");
				var d30145Offset_left = d30145Offsets[0];
				var d30145Offset_top = d30145Offsets[1];
				
				createDiv(birthInfoSs[30], d30145Value, d30145Offset_left, d30145Offset_top);
			}
		}
		
		var d30117Offset = jsonStr[birthInfoSs[31]];
		if(d30117Offset != undefined) {
			var d30117Offsets = d30117Offset.split(";");
			var d30117Offsets_left = d30117Offsets[0];
			var d30117Offsets_top = d30117Offsets[1];
			var d30117Value = vd301[birthInfoSs[31]];
			//父亲身份证号
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30117Value == null || "" == d30117Value || d30117Value == undefined){
				d30117Value = "//////////////////" ;
			}
			createDiv(birthInfoSs[31], d30117Value, d30117Offsets_left, d30117Offsets_top);
		}
		
		var d30126ZhValue = vd301[birthInfoSs[32]];
		var d30126ZhOffset = jsonStr[birthInfoSs[32]];
		if(d30126ZhOffset != undefined) {
			var d30126ZhOffsets = d30126ZhOffset.split(";");
			var d30126ZhOffset_left = d30126ZhOffsets[0];
			var d30126ZhOffset_top = d30126ZhOffsets[1];
			createDiv(birthInfoSs[32], d30126ZhValue, d30126ZhOffset_left, d30126ZhOffset_top);
		}
		
		
		
		var d30128Value = vd301[birthInfoSs[33]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30128Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30128OffsetYear = jsonStr[birthInfoSs[33]];
		if(d30128OffsetYear != undefined) {
			var d30128OffsetYears = d30128OffsetYear.split(";");
			var d30128OffsetYear_left = d30128OffsetYears[0];
			var d30128OffsetYear_top = d30128OffsetYears[1];
			createDiv(birthInfoSs[33], yearS, d30128OffsetYear_left, d30128OffsetYear_top);
		}
		
		var d30128OffsetMonth = jsonStr[birthInfoSs[34]];
		if(d30128OffsetMonth != undefined) {
			var d30128OffsetMonths = d30128OffsetMonth.split(";");
			var d30128OffsetMonths_left = d30128OffsetMonths[0];
			var d30128OffsetMonths_top = d30128OffsetMonths[1];
			createDiv(birthInfoSs[34], monthS, d30128OffsetMonths_left, d30128OffsetMonths_top);
		}
		
		var d30128OffsetDate = jsonStr[birthInfoSs[35]];
		if(d30128OffsetDate != undefined) {
			var d30128OffsetDates = d30128OffsetDate.split(";");
			var d30128OffsetDates_left = d30128OffsetDates[0];
			var d30128OffsetDates_top = d30128OffsetDates[1];
			createDiv(birthInfoSs[35], dateS, d30128OffsetDates_left, d30128OffsetDates_top);
		}
		
		var birthInfoTs = birthInfo[2].split(";");
		var birthInfoTsD30102Offset = jsonStr[birthInfoTs[0]];
		if(birthInfoTsD30102Offset != undefined) {
			var d30102Offset = birthInfoTsD30102Offset.split(";");
			var d30102Offset_left = d30102Offset[0];
			var d30102Offset_top = d30102Offset[1];
			var d30102Value = vd301[birthInfoTs[0]];
			createDiv(birthInfoTs[0], d30102Value, d30102Offset_left, d30102Offset_top);
		}
		
		var d30103Value = vd301[birthInfoTs[1]];
		var birthInfoTsD30103Offset = "";
		var gender = "";
		birthInfoTsD30103Offset = jsonStr[birthInfoTs[1]];
		if(d30103Value == "1") {
			gender = "男";
		} else if(d30103Value == "2") {
			gender = "女";
		} 
		if(birthInfoTsD30103Offset != "") {
			var d30103Offset = birthInfoTsD30103Offset.split(";");
			var d30103Offset_left = d30103Offset[0];
			var d30103Offset_top = d30103Offset[1];
			createDiv(birthInfoTs[1], gender, d30103Offset_left, d30103Offset_top);
		}
		
		var d30104Value = vd301[birthInfoTs[2]];
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
		
		var d30104Offset = jsonStr[birthInfoTs[2]];
		if(d30104Offset != undefined) {
			var d30104Offsets = d30104Offset.split(";");
			var d30104Offset_left = d30104Offsets[0];
			var d30104Offset_top = d30104Offsets[1];
			createDiv(birthInfoTs[2], year, d30104Offset_left, d30104Offset_top);
		}
		
		var d30104MonthOffset = jsonStr[birthInfoTs[3]];
		if(d30104MonthOffset != undefined) {
			var d30104MonthOffsets = d30104MonthOffset.split(";");
			var d30104MonthOffset_left = d30104MonthOffsets[0];
			var d30104MonthOffset_top = d30104MonthOffsets[1];
			createDiv(birthInfoTs[3], month, d30104MonthOffset_left, d30104MonthOffset_top);
		}
		
		var d30104DateOffset = jsonStr[birthInfoTs[4]];
		if(d30104DateOffset != undefined) {
			var d30104DateOffsets = d30104DateOffset.split(";");
			var d30104DateOffset_left = d30104DateOffsets[0];
			var d30104DateOffset_top = d30104DateOffsets[1];
			createDiv(birthInfoTs[4], date, d30104DateOffset_left, d30104DateOffset_top);
		}
		
		var d30104HourOffset = jsonStr[birthInfoTs[5]];
		if(d30104HourOffset != undefined) {
			var d30104HourOffsets = d30104HourOffset.split(";");
			var d30104HourOffset_left = d30104HourOffsets[0];
			var d30104HourOffset_top = d30104HourOffsets[1];
			createDiv(birthInfoTs[5], hour, d30104HourOffset_left, d30104HourOffset_top);
		}
		
		var d30104MinuteOffset = jsonStr[birthInfoTs[6]];
		if(d30104MinuteOffset != undefined) {
			var d30104MinuteOffsets = d30104MinuteOffset.split(";");
			var d30104MinuteOffset_left = d30104MinuteOffsets[0];
			var d30104MinuteOffset_top = d30104MinuteOffsets[1];
			createDiv(birthInfoTs[6], minute, d30104MinuteOffset_left, d30104MinuteOffset_top);
		}
		
		var d30107 = vd301[birthInfoTs[7]]; // weeks
		var d30147 = vd301["d30147"]; // days
		
		var d30107Offset = jsonStr[birthInfoTs[7]];
		if(d30107Offset != undefined) {
			var d30107Offsets = d30107Offset.split(";");
			var d30107Offset_left = d30107Offsets[0];
			var d30107Offset_top = d30107Offsets[1];
			if(d30147 != undefined && d30147 != 0) {
				createDiv(birthInfoTs[7], d30107 + "<sup>+" + d30147 + "</sup>", d30107Offset_left, d30107Offset_top);
			} else {
				createDiv(birthInfoTs[7], d30107, d30107Offset_left, d30107Offset_top);
			}
		}
		
		var d30129 = vd301[birthInfoTs[8]];
		var d30129Offset = jsonStr[birthInfoTs[8]];
		if(d30129Offset != undefined) {
			var d30129Offsets = d30129Offset.split(";");
			var d30129Offset_left = d30129Offsets[0];
			var d30129Offset_top = d30129Offsets[1];
			createDiv(birthInfoTs[8], d30129, d30129Offset_left, d30129Offset_top);
		}
		
		var d30108 = vd301[birthInfoTs[9]];
		var d30108Offset = jsonStr[birthInfoTs[9]];
		if(d30108Offset != undefined) {
			var d30108Offsets = d30108Offset.split(";");
			var d30108Offset_left = d30108Offsets[0];
			var d30108Offset_top = d30108Offsets[1];
			createDiv(birthInfoTs[9], d30108, d30108Offset_left, d30108Offset_top);
		}
		
		$.post(contextRoot + "/GetAreaNameServlet", {"areaCode" : areaCode}, function(dataValue){
			d30105OffsetProviceValue = dataValue[0];
			d30105OffsetCityValue = dataValue[1];
			d30105OffsetCountyValue = dataValue[2];
		
			var d30105OffsetProvice = jsonStr[birthInfoTs[10]];
			var d30105OffsetCity = jsonStr[birthInfoTs[11]];
			var d30105OffsetCounty = jsonStr[birthInfoTs[12]];
	
			if(d30105OffsetProvice != undefined) {
				var d30105OffsetProvices =  d30105OffsetProvice.split(";");
				var d30105OffsetProvices_left = d30105OffsetProvices[0];
				var d30105OffsetProvices_top = d30105OffsetProvices[1];
				createDiv(birthInfoTs[10], d30105OffsetProviceValue, d30105OffsetProvices_left, d30105OffsetProvices_top);
			}
			if(d30105OffsetCity != undefined) {
				var d30105OffsetCitys =  d30105OffsetCity.split(";");
				var d30105OffsetCitys_left = d30105OffsetCitys[0];
				var d30105OffsetCitys_top = d30105OffsetCitys[1];
				createDiv(birthInfoTs[11], d30105OffsetCityValue, d30105OffsetCitys_left, d30105OffsetCitys_top);
			}
			if(d30105OffsetCounty != undefined) {
				var d30105OffsetCountys =  d30105OffsetCounty.split(";");
				var d30105OffsetCountys_left = d30105OffsetCountys[0];
				var d30105OffsetCountys_top = d30105OffsetCountys[1];
				createDiv(birthInfoTs[12], d30105OffsetCountyValue, d30105OffsetCountys_left, d30105OffsetCountys_top);
			}
		}, "json");
		
		var d30124Offset = jsonStr[birthInfoTs[13]];
		if(d30124Offset != undefined) {
			var d30124Offsets = d30124Offset.split(";");
			var d30124Offsets_left = d30124Offsets[0];
			var d30124Offsets_top = d30124Offsets[1];
			var d30124Value = vd301[birthInfoTs[13]];
			if(d30124Value == null || "" == d30124Value || d30124Value == undefined || d30124Value == "///" && (d30124Value == undefined || "" == d30124Value || d30124Value == undefined)){
				d30124Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[13], d30124Value, d30124Offsets_left, d30124Offsets_top);
		}
		
		var d30111Value = vd301[birthInfoTs[14]];
		
		var d30111Offset = jsonStr[birthInfoTs[14]];
		if(d30111Offset != undefined) {
			var d30111Offsets = d30111Offset.split(";");
			d30111Offset_left = d30111Offsets[0];
			d30111Offset_top = d30111Offsets[1];
			//母亲姓名
			if(d30111Value == null || "" == d30111Value || d30111Value == undefined){
				d30111Value = "///" ;
			}
			createDiv(birthInfoTs[14], d30111Value, d30111Offset_left, d30111Offset_top);
		}
		
		var d30113Offset = jsonStr[birthInfoTs[15]];
		if(d30113Offset != undefined) {
			var d30113Offsets = d30113Offset.split(";");
			var d30113Offsets_left = d30113Offsets[0];
			var d30113Offsets_top = d30113Offsets[1];
			var d30113Value = vd301[birthInfoTs[15]];
			//母亲年龄
			if(d30113Value == null || "" == d30113Value || d30113Value == undefined){
				d30113Value = "//" ;
			}
			createDiv(birthInfoTs[15], d30113Value, d30113Offsets_left, d30113Offsets_top);
		}
		
		var d30114Offset = jsonStr[birthInfoTs[16]];
		if(d30114Offset != undefined) {
			var d30114Offsets = d30114Offset.split(";");
			var d30114Offsets_left = d30114Offsets[0];
			var d30114Offsets_top = d30114Offsets[1];
			var d30114Value = vd301[birthInfoTs[16]];
			//母亲国籍
			if(d30114Value == null || "" == d30114Value || d30114Value == undefined){
				d30114Value = "//" ;
			}
			createDiv(birthInfoTs[16], d30114Value, d30114Offsets_left, d30114Offsets_top);
		}
		
		var d30115Offset = jsonStr[birthInfoTs[17]];
		if(d30115Offset != undefined) {
			var d30115Offsets = d30115Offset.split(";");
			var d30115Offsets_left = d30115Offsets[0];
			var d30115Offsets_top = d30115Offsets[1];
			var d30115Value = vd301[birthInfoTs[17]];
			//母亲民族
			if(d30115Value == null || "" == d30115Value || d30115Value == undefined){
				d30115Value = "//" ;
			}
			createDiv(birthInfoTs[17], d30115Value, d30115Offsets_left, d30115Offsets_top);
		}
		
		var d30121mOffset = jsonStr[birthInfoTs[18]];
		if(d30121mOffset != undefined) {
			var d30121mOffsets = d30121mOffset.split(";");
			var d30121mOffsets_left = d30121mOffsets[0];
			var d30121mOffsets_top = d30121mOffsets[1];
			var d30121mValue = vd301["d30121"];
			//母亲家庭住址
			if(d30111Value == "///" && (d30121mValue == null || "" == d30121mValue || d30121mValue == undefined)){
				d30121mValue = "//////////////////" ;
			}
			createDiv(birthInfoTs[18], d30121mValue, d30121mOffsets_left, d30121mOffsets_top);
		}
		
		var d30134idZhOffset = jsonStr[birthInfoTs[19]];
		var d30134paZhOffset = jsonStr[birthInfoTs[20]];
		var d30144Offset = jsonStr[birthInfoTs[21]];
		var d30134Value = vd301["d30134"];
		var d30144Value = vd301["d30144"];
		
		if(d30134Value == "1") {
			if(d30134idZhOffset != undefined) {
				var d30134idZhOffsets = d30134idZhOffset.split(";");
				var d30134idZhOffset_left = d30134idZhOffsets[0];
				var d30134idZhOffset_top = d30134idZhOffsets[1];
				
				createDiv(birthInfoTs[19], symbol, d30134idZhOffset_left, d30134idZhOffset_top);
			}
		} else if(d30134Value == "3") {
			if(d30134paZhOffset != undefined) {
				var d30134paZhOffsets = d30134paZhOffset.split(";");
				var d30134paZhOffset_left = d30134paZhOffsets[0];
				var d30134paZhOffset_top = d30134paZhOffsets[1];
				
				createDiv(birthInfoTs[20], symbol, d30134paZhOffset_left, d30134paZhOffset_top);
			}
		} else if(d30134Value == "4") {
			if(d30144Offset != undefined) {
				var d30144Offsets = d30144Offset.split(";");
				var d30144Offset_left = d30144Offsets[0];
				var d30144Offset_top = d30144Offsets[1];
				
				createDiv(birthInfoTs[21], d30144Value, d30144Offset_left, d30144Offset_top);
			}
		}
		
		
		
		var d30112Offset = jsonStr[birthInfoTs[22]];
		if(d30112Offset != undefined) {
			var d30112Offsets = d30112Offset.split(";");
			var d30112Offsets_left = d30112Offsets[0];
			var d30112Offsets_top = d30112Offsets[1];
			var d30112Value = vd301[birthInfoTs[22]];
			//母亲身份证号
			if(d30112Value == null || "" == d30112Value || d30112Value == undefined){
				d30112Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[22], d30112Value, d30112Offsets_left, d30112Offsets_top);
		}
		
		var d30116Value = vd301[birthInfoTs[23]];
		var d30116Offset = jsonStr[birthInfoTs[23]];
		if(d30116Offset != undefined) {
			var d30116Offsets = d30116Offset.split(";");
			var d30116Offsets_left = d30116Offsets[0];
			var d30116Offsets_top = d30116Offsets[1];
			//父亲姓名
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined){
				d30116Value = "///" ;
			}
			createDiv(birthInfoTs[23], d30116Value, d30116Offsets_left, d30116Offsets_top);
		}
		
		var d30118Offset = jsonStr[birthInfoTs[24]];
		if(d30118Offset != undefined) {
			var d30118Offsets = d30118Offset.split(";");
			var d30118Offsets_left = d30118Offsets[0];
			var d30118Offsets_top = d30118Offsets[1];
			var d30118Value = vd301[birthInfoTs[24]];
			//父亲年龄
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30118Value == null || "" == d30118Value || d30118Value == undefined){
				d30118Value = "//" ;
			}
			createDiv(birthInfoTs[24], d30118Value, d30118Offsets_left, d30118Offsets_top);
		}
		
		var d30119Offset = jsonStr[birthInfoTs[25]];
		if(d30119Offset != undefined) {
			var d30119Offsets = d30119Offset.split(";");
			var d30119Offsets_left = d30119Offsets[0];
			var d30119Offsets_top = d30119Offsets[1];
			var d30119Value = vd301[birthInfoTs[25]];
			//父亲国籍
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30119Value == null || "" == d30119Value || d30119Value == undefined){
				d30119Value = "//" ;
			}
			createDiv(birthInfoTs[25], d30119Value, d30119Offsets_left, d30119Offsets_top);
		}
		
		var d30120Offset = jsonStr[birthInfoTs[26]];
		if(d30120Offset != undefined) {
			var d30120Offsets = d30120Offset.split(";");
			var d30120Offsets_left = d30120Offsets[0];
			var d30120Offsets_top = d30120Offsets[1];
			var d30120Value = vd301[birthInfoTs[26]];
			//父亲民族
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30120Value == null || "" == d30120Value || d30120Value == undefined){
				d30120Value = "//" ;
			}
			createDiv(birthInfoTs[26], d30120Value, d30120Offsets_left, d30120Offsets_top);
		}
		
		var d30121fOffset = jsonStr[birthInfoTs[27]];
		if(d30121fOffset != undefined) {
			var d30121fOffsets = d30121fOffset.split(";");
			var d30121fOffsets_left = d30121fOffsets[0];
			var d30121fOffsets_top = d30121fOffsets[1];
			var d30148Value = vd301["d30148"];
			//父亲家庭住址
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30116Value == "///" && (d30148Value == undefined || "" == d30148Value || d30148Value == undefined)){
				d30148Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[27], d30148Value, d30121fOffsets_left, d30121fOffsets_top);
		}
		
		
		var d30135idZhOffset = jsonStr[birthInfoTs[28]];
		var d30135paZhOffset = jsonStr[birthInfoTs[29]];
		var d30145Offset = jsonStr[birthInfoTs[30]];
		var d30135Value = vd301["d30135"];
		var d30145Value = vd301["d30145"];
		if(d30135Value == "1") {
			if(d30135idZhOffset != undefined) {
				var d30135idZhOffsets = d30135idZhOffset.split(";");
				var d30135idZhOffset_left = d30135idZhOffsets[0];
				var d30135idZhOffset_top = d30135idZhOffsets[1];
				
				createDiv(birthInfoTs[28], symbol, d30135idZhOffset_left, d30135idZhOffset_top);
			}
		} else if(d30135Value == "3") {
			if(d30135paZhOffset != undefined) {
				var d30135paZhOffsets = d30135paZhOffset.split(";");
				var d30135paZhOffset_left = d30135paZhOffsets[0];
				var d30135paZhOffset_top = d30135paZhOffsets[1];
				
				createDiv(birthInfoTs[29], symbol, d30135paZhOffset_left, d30135paZhOffset_top);
			}
		} else {
			if(d30145Offset != undefined) {
				var d30145Offsets = d30145Offset.split(";");
				var d30145Offset_left = d30145Offsets[0];
				var d30145Offset_top = d30145Offsets[1];
				createDiv(birthInfoTs[30], d30145Value, d30145Offset_left, d30145Offset_top);
			}
		}
		
		var d30117Offset = jsonStr[birthInfoTs[31]];
		if(d30117Offset != undefined) {
			var d30117Offsets = d30117Offset.split(";");
			var d30117Offsets_left = d30117Offsets[0];
			var d30117Offsets_top = d30117Offsets[1];
			var d30117Value = vd301[birthInfoTs[31]];
			//父亲身份证号
			if(d30116Value == null || "" == d30116Value || d30116Value == undefined || d30117Value == null || "" == d30117Value || d30117Value == undefined){
				d30117Value = "//////////////////" ;
			}
			createDiv(birthInfoTs[31], d30117Value, d30117Offsets_left, d30117Offsets_top);
		}
		
		var d30125Value = vd301[birthInfoTs[32]];
		var d30125Offset = jsonStr[birthInfoTs[32]];
		if(d30125Offset != undefined) {
			var d30125Offsets = d30125Offset.split(";");
			var d30125Offset_left = d30125Offsets[0];
			var d30125Offset_top = d30125Offsets[1];
			createDiv(birthInfoTs[32], d30125Value, d30125Offset_left, d30125Offset_top);
		}
		
		var d30136Value = vd301[birthInfoTs[33]];
		var d30136Offset = jsonStr[birthInfoTs[33]];
		if(d30136Offset != undefined) {
			var d30136Offsets = d30136Offset.split(";");
			var d30136Offset_left = d30136Offsets[0];
			var d30136Offset_top = d30136Offsets[1];
			createDiv(birthInfoTs[33], "", d30136Offset_left, d30136Offset_top);
		}
		
		var d30127Value = vd301[birthInfoTs[34]];
		var d30127Offset = jsonStr[birthInfoTs[34]];
		if(d30127Offset != undefined) {
			var d30127Offsets = d30127Offset.split(";");
			var d30127Offset_left = d30127Offsets[0];
			var d30127Offset_top = d30127Offsets[1];
			createDiv(birthInfoTs[34], "", d30127Offset_left, d30127Offset_top);
		}
		
		var d30128Value = vd301[birthInfoTs[35]];
		var regS = /(\d{4})-(\d{2})-(\d{2})/; 
		var timeVS = regS.exec(d30128Value);
		var yearS = timeVS[1];
		var monthS = timeVS[2];
		var dateS = timeVS[3];
		
		var d30128OffsetYear = jsonStr[birthInfoTs[35]];
		if(d30128OffsetYear != undefined) {
			var d30128OffsetYears = d30128OffsetYear.split(";");
			var d30128OffsetYear_left = d30128OffsetYears[0];
			var d30128OffsetYear_top = d30128OffsetYears[1];
			createDiv(birthInfoTs[35], yearS, d30128OffsetYear_left, d30128OffsetYear_top);
		}
		
		var d30128OffsetMonth = jsonStr[birthInfoTs[36]];
		if(d30128OffsetMonth != undefined) {
			var d30128OffsetMonths = d30128OffsetMonth.split(";");
			var d30128OffsetMonths_left = d30128OffsetMonths[0];
			var d30128OffsetMonths_top = d30128OffsetMonths[1];
			createDiv(birthInfoTs[36], monthS, d30128OffsetMonths_left, d30128OffsetMonths_top);
		}
		
		var d30128OffsetDate = jsonStr[birthInfoTs[37]];
		if(d30128OffsetDate != undefined) {
			var d30128OffsetDates = d30128OffsetDate.split(";");
			var d30128OffsetDates_left = d30128OffsetDates[0];
			var d30128OffsetDates_top = d30128OffsetDates[1];
			createDiv(birthInfoTs[37], dateS, d30128OffsetDates_left, d30128OffsetDates_top);
		}
		
		var d30126Value = vd301[birthInfoTs[38]];
		var d30126Offset = jsonStr[birthInfoTs[38]];
		if(d30126Offset != undefined) {
			var d30126Offsets = d30126Offset.split(";");
			var d30126Offset_left = d30126Offsets[0];
			var d30126Offset_top = d30126Offsets[1];
			createDiv(birthInfoTs[38], d30126Value, d30126Offset_left, d30126Offset_top);
		}
	}, "json");
});

function createDiv(id, value, offset_left, offset_top)
{
	if(id == "d30107" || id == "d30107S" || id == "d30107T") {
		$("body").append($("<div></div>").attr("id", id).append(value));
	} else {
		$("body").append($("<div></div>").attr("id", id).text(value));
	}
	
	$("#" + id).css({"position":"absolute", "font-size":"15px"});
	$("#" + id).offset({left:offset_left, top:offset_top});
}