window.onload = init;

function init()
{
	if(location.search.indexOf("debug") != -1) {
		document.getElementById("mainFrame").src="bin-debug/main.html";
	} else {
		//document.getElementById("mainFrame").src="bin-release/main.html";

		document.getElementById("mainFrame").src="bin-release/main.html?ran=" + Math.random();
	}
}

function readCard() {
	var CVR_IDCard = document.getElementById("CVR_IDCard");
	var strReadResult = CVR_IDCard.ReadCard();
	if(strReadResult == "0")
	{
	  var name = CVR_IDCard.Name;
	  var sex = CVR_IDCard.Sex;
	  var nation = CVR_IDCard.Nation;
	  
	  var born = CVR_IDCard.Born;
	  var year = born.substring(0,4);
	  var month = born.substring(5,7);
	  var day = born.substring(8,10);
	  var birthday = year + "-" + month + "-" + day;
	  
	  var address = CVR_IDCard.Address;
	  var cardNo = CVR_IDCard.CardNo;
	  var samid = CVR_IDCard.SAMID;
	  
	  var result = name + "," + sex + "," + nation + "," + birthday + "," + address + "," + cardNo+','+samid;
	  return result;
	 }else{
		alert(strReadResult);
	 }
}

function checkIdcard(num) { 
	num = num.toUpperCase();
	
	// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	//下面分别分析出生日期和校验位
	var len, re;
	len = num.length;
	if (len == 15) {
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
		var arrSplit = num.match(re);
		// 检查生日日期是否正确
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay) {
			return false;
		} else {
			// 将15位身份证转成18位
			// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			var nTemp = 0, i;
			num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
			for (i = 0; i < 17; i++) {
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			num += arrCh[nTemp % 11];
			return true;
		}
	}  
	
	if (len == 18) {
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
		var arrSplit = num.match(re);
		// 检查生日日期是否正确
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay) {
			return false;
		} else {
			var valnum;
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			var nTemp = 0, i;
			for (i = 0; i < 17; i++) {
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			valnum = arrCh[nTemp % 11];
			if (valnum != num.substr(17, 1)) {
				return false;
			}
			return true;
		}
	}
	
	return true;
}

