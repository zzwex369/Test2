var divId = "";
var contextRoot = "/fybjxt";
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
	
    var areaCode = $("#userCode").val();
    var printinfoValue = "BIRTH_PRINTINFO_NEW_" + areaCode;
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
    
	$("#changeButton").click(function(){
	    var flag= confirm("是否要恢复系统默认设置参数？");
	    if(flag){		
			var printInfoValue = "BIRTH_PRINTINFO_NEW_" + areaCode;
			var jsonParamStr = "{\"flag\":\"change\", \"BIRTH_PRINTINFO_NEW\":\"" + printinfoValue + "\"}";
			$.post(contextRoot + "/SavePropertyServletNew", $.parseJSON(jsonParamStr), function(data) {
		    if(data.flag){
				alert(data.message);
				window.location.reload();
		    }else{
				alert(data.message);
		    }
		}, "json");
	   }
	});
	
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
		
		var printInfoValue = "BIRTH_PRINTINFO_NEW_" + areaCode;
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