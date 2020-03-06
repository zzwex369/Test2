var divId = "";
var contextRoot = "/csyxzm";
$(document).ready(function(){
    
	var printInfo = new Array();
	var printInfoLabel  = new Array();
	
	printInfo[0] = "BIRTH_PRINTINFOHF_NEW";
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
	var userCode = $("#userCode").val();
    var printinfoValue = "BIRTH_PRINTINFOHF_NEW_" + userCode;
    var jsonParamStr = "{\"flag\":\"load\", \"BIRTH_PRINTINFO_NEW\":\"" + printinfoValue + "\"}";
	
	$.post(contextRoot + "/SavePropertyServletNew", $.parseJSON(jsonParamStr), function(data) {
		$.each(birthInfo, function(k, p){
			var birthInfoss = p.split(";");
			var birthInfoLabelss = birthInfoLabel[k].split(";");
			
			$.each(birthInfoss, function(j, q){
				var offset = data[q];
				if(offset != undefined) {
					var offsets = offset.split(";");
					var offset_left = offsets[0];
					var offset_top = offsets[1];
					createDiv(q, birthInfoLabelss[j], offset_left, offset_top);
				}
			});
		
		});
	}, "json");
    
    
	$("#addButton").click(function(){
		var printinfoValue = $("#printinfo option:selected").val();
		
		if(printinfoValue == "") {
			alert("请选择打印项!");
			return false;
		}
		
		var birthinfoValue = $("#birthinfo option:selected").val();
		if(birthinfoValue == "") {
			alert("请选择显示项!");
			return false;
		}
	
		var birthinfoText = $("#birthinfo option:selected").text();
		
		var divText = $("#" + birthinfoValue).text();
		if(divText != "") {
			alert("显示项 '" + birthinfoText + "' 不能重复添加!");
			return;
		}
		
		createDiv(birthinfoValue, birthinfoText, 350, 100);
	});
	
	$("#delButton").click(function(event){
		delLabel();
	});
	
	function delLabel() {
		if(divId != "") {
			$("#" + divId).remove();
		}
	}
	
	$("#saveButton").click(function(){
		
		var printInfoValue = "BIRTH_PRINTINFOHF_NEW_" + userCode;
		var jsonParamStr = "{\"flag\":\"save\",\"BIRTH_PRINTINFO_NEW\":\"" + printInfoValue + "\",\"";
		
		$.each($("div"), function(i, n){
			var offset = $(n).offset();
			var offset_left = offset.left;
			var offset_top = offset.top;
			var divId = $(n).attr("id");
			jsonParamStr = jsonParamStr + divId + "\":";
			jsonParamStr = jsonParamStr + "\"" + offset_left + ";" + offset_top + "\"";
			if($("div").length - 1 != i) { 
				jsonParamStr += ",\"";
			}
		});
		jsonParamStr += "}";
		$.post(contextRoot + "/SavePropertyServletNew", $.parseJSON(jsonParamStr), function(data){
			alert(data.flagValue);
		}, "json");
	});
	
	$.each(printInfo, function(i, n){
		$("#printinfo").append($("<option value='" + n + "'> " + printInfoLabel[i] + "</option>"));
	});
	
	$("#printinfo").change(function(){
		var printinfoValue = $("#printinfo option:selected").val();
		
		$.each(printInfo, function(i, n){
			
			//$("div").remove();
			
			if(printinfoValue == "") {
				$("#birthinfo").empty();
				
				$("#birthinfo").append($("<option>").val("").text("请选择"));
			} else if(printinfoValue == printInfo[i]){
				
				$("#birthinfo").empty();
				
				$("#birthinfo").append($("<option>").val("").text("请选择"));
				
				var birthInfos = birthInfo[i].split(";");
				var birthInfoLabels = birthInfoLabel[i].split(";");
				
				$.each(birthInfos, function(i, m){
					$("#birthinfo").append($("<option>").val(m).text(birthInfoLabels[i]));
				});
			}
		});
	});
});

function createDiv(id, label, offset_left, offset_top)
{
	$("body").append($("<div></div>").attr("id", id).text(label));
	
	$("#" + id).css({"position":"absolute", "cursor":"move", "border": "1px dotted #000000", "font-size":"12px"});
	$("#" + id).offset({left:offset_left, top:offset_top});
	
	$("#" + id).mousedown(function(event){ 
		divId = $(event.target).attr("id");
		$("div").css("background", "#FFFFFF");
		$("#" + divId).css("background", "#eeeeee");
		
		var offset=$("#" + divId).offset();   
		x1=event.clientX-offset.left;   
		y1=event.clientY-offset.top; 
		
		$(document).mousemove(function(event){
			if(!isNaN(event.clientX) && !isNaN(event.clientY)) {
			   $("#" + divId).css("left",(event.clientX-x1)+"px");   
			   $("#" + divId).css("top",(event.clientY-y1)+"px");   
			} 
		});   
		$("#" + divId).mouseup(function(event){   
		   $(document).unbind("mousemove");
		});   
	});
	
	$(document).keydown(function(event){
		
		var keyCodeValue = event.keyCode;
		var offsetValue = $("#" + divId).offset();
		
		if(keyCodeValue == 46) {
			if(divId != "") {
				$("#" + divId).remove();
			}
		}
		
		switch(keyCodeValue)
		{
			case 37 : $("#" + divId).offset({left:(offsetValue.left - 1)});
			break;
			case 38 : $("#" + divId).offset({top:(offsetValue.top - 1)});
			break;
			case 39 : $("#" + divId).offset({left:(offsetValue.left + 1)});
			break;
			case 40 : $("#" + divId).offset({top:(offsetValue.top + 1)}); 
			break;
		}
	});
}