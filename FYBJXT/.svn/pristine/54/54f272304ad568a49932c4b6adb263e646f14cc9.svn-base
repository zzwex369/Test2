var divId = "";
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
	
    var userCode = $("#userCode").val();
    var printinfoValue = "BIRTH_PRINTINFOBF_NEW_" + userCode;
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
		
		var printInfoValue = "BIRTH_PRINTINFOBF_NEW_" + userCode;
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