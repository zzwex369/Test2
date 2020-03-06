var divId = "";
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
		var printInfoValue = $("#printinfo").val();
		var jsonParamStr = "{\"flag\":\"save\",\"BIRTH_PRINTINFO\":\"" + printInfoValue + "\",\"";
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
		$.post(contextRoot + "/SavePropertyServlet", $.parseJSON(jsonParamStr), function(data){
			alert(data.flagValue);
		}, "json");
	});
	
	$.each(printInfo, function(i, n){
		$("#printinfo").append($("<option value='" + n + "'> " + printInfoLabel[i] + "</option>"));
	});
	$("#printinfo").change(function(){
		var printinfoValue = $("#printinfo option:selected").val();
		
		$.each(printInfo, function(i, n){
			
			$("div").remove();
			
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
				
				var jsonParamStr = "{\"flag\":\"load\", \"BIRTH_PRINTINFO\":\"" + printinfoValue + "\"}";
				
				$.post(contextRoot + "/SavePropertyServlet", $.parseJSON(jsonParamStr), function(data) {
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