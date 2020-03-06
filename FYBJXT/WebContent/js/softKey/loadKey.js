var changePlug = -1; // 监听插拔消息
var Pin = "123";// 使用默认的PIN码
var bConnect = 0;// 是否连接
var reqParam;// 0 key 1 pwd 修改使用
var browerType = 1; // 浏览器 类型 默认0 ie 10 以下 1 其他浏览器
var resultArr = new Array(9);// 0 是否连接 1 错误信息 2 keyId 3.用户身份信息  4 用户名 5 密码  6.加密结果 7权限 8随机时间
// 6.加密结果 7权限 8随机时间
var ran = (Math.random() * 65585 + 1).toString();// 生产随机数
var s_pnp, DevicePath, ret, n, mylen, ChipID, addr, outstring;
var digitArray = new Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'a', 'b', 'c', 'd', 'e', 'f');
var errorMessage = [
							"未发现加密锁，请插入加密锁.",
							"返回芯片唯一ID时出现错误，错误码为：",
				            "返回用户身份时出现错误，错误码为：",
				            "进行签名时出现错误，错误码为：",
							"读数据时错误，错误码为：",
							"调用GetBuf时错误，错误码为：",
							"读取用户名时错误，错误码为：",
							"读数据时错误，错误码为：",
							"调用GetBuf时错误，错误码为：",
							"读取用户密码时错误，错误码为：",
							"读数据时错误，错误码为：",
							"调用GetBuf时错误，错误码为：",
							"读取用户权限时错误，错误码为："
			            ];
	var modifyPwdError= [
						"未发现加密锁，请插入加密锁",
						"返回芯片唯一ID时出现错误，错误码为：",
						"返回读取密码字符串的长度时出现错误，错误码为：",
						"返回数据缓冲区中数据出现错误，错误码为：",
						"返回密码时出现错误，错误码为：",
						"设置密码出现错误，错误码为：",
						"设置字符串长度到缓冲区中错误，错误码为：",
						"设置密码长度出现错误，错误码为："
                    ];
					
	var modifyPmnError= [
						"未发现加密锁，请插入加密锁",
						"返回芯片唯一ID时出现错误，错误码为：",
						"设置权限出现错误，错误码为：",
						"设置字符串长度到缓冲区中错误，错误码为：",
						"设置权限长度出现错误，错误码为："
                    ];				
	var errorCode = [
						['-46', '使用控件时，输入的字符不能是空字符串'],
						['-47', '进行读写字符串时，地址空间超出'],
						['-51', '打开USB文件句柄失败(iKey）'],
						['-81', '输入的地址空间超出'],
						['-82', '写数据到加密锁储存器时错误，可能是写密码错误；'],
						['-83', '从加密锁读取数据时错误，可能是读密码错误'],
						['-88', '输入的地址空间超出'],
						['-92', '不存在指定的加密锁'], 
						['-93', '操作加密锁时错误']
					];

/**
 * 数组排序
 */
function sortResultArr() {
	var arr = new Array(9);//0 是否插入加密狗  1 异常信息 2 用户名 3 密码  4  用户身份信息 5 keyID 6 加密结果 7权限 8 随机数
	// 加密结果 7 随机数
	var sortRule = [0, 1, 5, 6, 3, 2, 4, 7, 8];
	for (var i = 0; i < sortRule.length; i++) {
		arr[i] = resultArr[sortRule[i]];
	}
	arr[0] = arr[arr.length - 2] ? true : false;
	var result = arr.join(',');
	DevicePath = ret = n = mylen = ChipID = null;
	// console.log(arr);
	console.log("sortResultArr>>>" + result)
	main.getKey(result);
}
/**
 * 得到加密狗数据
 */
function doLoadKey() {
	// 如果是IE10及以下浏览器，则跳过不处理，
	if (navigator.userAgent.indexOf("MSIE") > 0
			&& !navigator.userAgent.indexOf("opera") > -1) {
		browerType = 0;
		main = document.frames["mainFrame"].document.getElementById('main');
		getOtherPlug();
	} else {
		main = document.getElementById('mainFrame').contentDocument.main;
		getHtml5Plug();
	}
}

function loadKey() {
	doLoadKey();
	resultArr[resultArr.length - 1] = ran;
	setTimeout(sortResultArr, 1000);

}

/**
 * resultArr 设置对应值
 * 
 * @param {}
 *            idx resultArr 下标
 * @param {}
 *            val 下标对应值
 */
function setResult(idx, val) {
	if (!idx)// 如果未初始化 就初始化
	{
		if (val)// 插入 就从新加载
			loadKey();
		else {// 拔掉 发送消息
			main.getKey("false,'加密狗已拔出'");
			return;
		}
	}
	resultArr[idx] = val;
	return resultArr;
}

/**
 * 得到错误信息
 */
function getErrorMessage(code) {
	for (var i = 0; i < errorCode.length; i++) {
		var item = errorCode[i];
		if (item[0] == code)
			return item[1];
	}
	return code + " 未知原因！";
}

function toHex(n) {
	var result = ''
	var start = true;

	for (var i = 32; i > 0;) {
		i -= 4;
		var digit = (n >> i) & 0xf;

		if (!start || digit != 0) {
			start = false;
			result += digitArray[digit];
		}
	}

	return (result == '' ? '0' : result);
}

/**
 * getOther 使用监听事件
 * 
 * @param {}
 *            obj
 * @param {}
 *            name
 * @param {}
 *            func
 */
function addEvent(obj, name, func) {
	if (obj.attachEvent) {
		obj.attachEvent("on" + name, func);
	} else {
		obj.addEventListener(name, func, false);
		obj.addEventListener(name, func, true);
	}
}

function plugin() {
	return document.getElementById('pluginKey');
}
/**
 * 得到插拔结果并赋值
 */
function isGetPlug(val) {
	if (val != changePlug) {
		changePlug = val;
		setResult(0, val ? true : false);
	}
}

/**
 * 支持IE10及以下,chrome 45版以下等浏览器
 */
function getOtherPlug() {
	addEvent(plugin(), 'KeyPnp', function(IsOut) {
				isGetPlug(IsOut);
			});

	getIEKey();
}

/**
 * 只支持HTM5浏览器，例如IE11，edge，最新版Firefox,chrome等
 */
function getHtml5Plug() {
	try {
		if (!s_pnp)
			s_pnp = new SoftKey3W();// 创建UK类

		s_pnp.Socket_UK.onopen = function() {
			bConnect = 1;// 代表已经连接，用于判断是否安装了客户端服务
		}

		s_pnp.Socket_UK.onmessage = function got_packet(Msg) {
			var PnpData = JSON.parse(Msg.data);
			if (PnpData.type == "PnpEvent")// 如果是插拨事件处理消息
				isGetPlug(PnpData.IsIn);
		}

		s_pnp.Socket_UK.onclose = function() {

		}
		getHtml5Key();
	} catch (e) {
		alert(e.name + ": " + e.message);
		return false;
	}

}

/**
 * 保存错误信息
 * 
 * @param {}
 *            UK_Data
 * @param {}
 *            s_simnew1
 * @param {}
 *            error
 * @return {Boolean}
 */
function getKeyError(UK_Data, s_simnew1, idx, val) {
	if (UK_Data.LastError != 0) {
		var error = idx > 1 ? errorMessage[idx - 1]
				+ getErrorMessage(UK_Data.LastError) : errorMessage[idx - 1];
		setResult(1, error);
		if (s_simnew1)
			s_simnew1.Socket_UK.close();
		return false;
	}

	getKey(UK_Data, idx, val);
	return true;
}

/**
 * 保存错误信息
 * 
 * @param {}
 *            UK_Data
 * @param {}
 *            s_simnew1
 * @param {}
 *            error
 * @return {Boolean}
 */
function getModifyKeyError(UK_Data, s_simnew1, idx, val) {
	var isModifyPwd = reqParam[1] ? true : false;

	if (UK_Data.LastError != 0) {
		var errArr = isModifyPwd ? modifyPwdError : modifyPmnError;// 判断是否含有原密码
		// 有就是修改密码
		// 没有则是修改权限
		var error = idx > 1 ? errArr[idx - 1]
				+ getErrorMessage(UK_Data.LastError) : errArr[idx - 1];
		if (s_simnew1)
			s_simnew1.Socket_UK.close();
		// 返回数组信息
		console.log([false, error]);
		return false;
	}

	if (isModifyPwd) {
		if ((idx == 2 || idx == 5) && val != reqParam[idx % 2]) {
			console.log([false,
					idx == 2 ? '不是同一台机器无法修改密码' : '输入原密码与机器原密码不一致，无法修改']);
			return false;
		}
		if (idx == 8) {
			// 返回数组信息
			console.log([true, '']);
			return true;
		}

	} else {

		if (idx == 2 && val != reqParam[idx % 2]) {
			console.log([false, '不是同一台机器无法修改密码']);
			return false;
		}
		if (idx == 5) {
			// 返回数组信息
			console.log([true, '']);
			return true;
		}
	}

	return true;

}
/**
 * 
 * @param {}
 *            s_simnew1
 * @param {}
 *            idx 结果下标
 */
function getKey(UK_Data, idx, aObjectVal) {
	if ((idx > 1 && idx < 5) || idx == 7 || idx == 10 || idx == 13) {
		if (idx == 13)
			--idx;
		idx = idx > 5 ? Math.round(idx / 2) + 1 : idx;

		var arr = setResult(idx, aObjectVal
						? aObjectVal.toString()
						: UK_Data.return_value.toString());
		return arr;
	}

}

function getHtml5Key() {
	try {
		// 由于是使用事件消息的方式与服务程序进行通讯，
		// 好处是不用安装插件，不分系统及版本，控件也不会被拦截，同时安装服务程序后，可以立即使用，不用重启浏览器
		// 不好的地方，就是但写代码会复杂一些
		var s_simnew1 = new SoftKey3W(); // 创建UK类

		s_simnew1.Socket_UK.onopen = function() {
			s_simnew1.ResetOrder();// 这里调用ResetOrder将计数清零，这样，消息处理处就会收到0序号的消息，通过计数及序号的方式，从而生产流程
		}

		// 写代码时一定要注意，每调用我们的一个UKEY函数，就会生产一个计数，即增加一个序号，较好的逻辑是一个序号的消息处理中，只调用我们一个UKEY的函数
		s_simnew1.Socket_UK.onmessage = function got_packet(Msg) {
			var UK_Data = JSON.parse(Msg.data);
			if (UK_Data.type != "Process")
				return;// 如果不是流程处理消息，则跳过
			// alert(Msg.data);
			switch (UK_Data.order) {
				case 0 : {
					s_simnew1.FindPort(0);// 查找加密锁
				}
					break;// !!!!!重要提示，如果在调试中，发现代码不对，一定要注意，是不是少了break,这个少了是很常见的错误
				case 1 : {

					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null)) {
						DevicePath = UK_Data.return_value;// 获得返回的UK的路径
						s_simnew1.GetChipID(DevicePath);// 返回芯片唯一ID
					}

				}
					break;
				case 2 : {

					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null))
						// 从锁中取出用户身份，与签名后的数据一并送到服务端进行验证。以验证用户身份
						s_simnew1.GetSm2UserName(DevicePath);

				}
					break;
				case 3 : {

					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null))
						// 这里使用锁中的私钥对身份-用户名及消息-随机数的进行数字签名,使用默认的PIN码，返回签名后的数据
						s_simnew1.YtSign(ran, Pin, DevicePath);
				}
					break;
				case 4 : {

					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null)) {

						// 所有工作处理完成后，关掉Socket
						// s_simnew1.Socket_UK.close();
						// 获取设置在锁中的用户名
						// 先从地址0读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
						addr = 0;
						s_simnew1.YReadEx(addr, 1, "ffffffff", "ffffffff",
								DevicePath);// 发送命令取UK地址0的数据
					}
				}
					break;
				case 5 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null))
						s_simnew1.GetBuf(0);// 发送命令从数据缓冲区中数据

				}
					break;
				case 6 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null)) {
						mylen = UK_Data.return_value;// 获得返回的数据缓冲区中数据
						// 再从地址1读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
						addr = 1;
						s_simnew1.YReadString(addr, mylen, "ffffffff",
								"ffffffff", DevicePath);// 发送命令从UK地址1中取字符串
					}
				}
					break;
				case 7 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null)) {
						// 获得返回的UK地址1的字符串
						// 获到设置在锁中的用户密码,
						// 先从地址20读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
						addr = 20;
						s_simnew1.YReadEx(addr, 1, "ffffffff", "ffffffff",
								DevicePath);// 发送命令取UK地址20的数据
					}

				}
					break;
				case 8 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null))
						s_simnew1.GetBuf(0);// 发送命令从数据缓冲区中数据
				}
					break;
				case 9 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null)) {
						mylen = UK_Data.return_value;// 获得返回的数据缓冲区中数据
						// 再从地址21读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"

						addr = 21;
						s_simnew1.YReadString(addr, mylen, "ffffffff",
								"ffffffff", DevicePath);// 发送命令从UK地址21中取字符串
					}

				}
					break;
				case 10 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null)) {
						// 获得返回的UK地址1的字符串
						// 获到设置在锁中的用户权限,
						// 先从地址100读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
						addr = 100;
						s_simnew1.YReadEx(addr, 1, "ffffffff", "ffffffff",
								DevicePath);// 发送命令取UK地址20的数据
					}

				}
					break;
				case 11 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null))
						s_simnew1.GetBuf(0);// 发送命令从数据缓冲区中数据
				}
					break;
				case 12 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null)) {
						mylen = UK_Data.return_value;// 获得返回的数据缓冲区中数据
						// 再从地址101读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
						addr = 101;
						s_simnew1.YReadString(addr, mylen, "ffffffff",
								"ffffffff", DevicePath);// 发送命令从UK地址101中取字符串
					}

				}
					break;
				case 13 : {
					if (getKeyError(UK_Data, s_simnew1, UK_Data.order, null))
						s_simnew1.Socket_UK.close();
				}
					break;

			}
		}

		s_simnew1.Socket_UK.onclose = function() {

		}
		return true;
	}

	catch (e) {
		alert(e.name + ": " + e.message);
		return false;
	}
}

/**
 * ie 浏览器得到用户名密码 add 要读取的加密锁内部地址空间 idx 对应序号
 */
function getUserPwdPermission(aObject, add, idx) {
	ret = aObject.YReadEx(add, 1, "ffffffff", "ffffffff", DevicePath);
	mylen = aObject.GetBuf(0);
	// 再从地址1读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
	if (!getKeyError(aObject, null, idx, aObject.YReadString(1 + add, mylen,
					"ffffffff", "ffffffff", DevicePath)))
		return false;
	return true;
}

/**
 * 得到 ie 浏览器的加密狗信息
 * 
 * @return {Boolean}
 */
function getIEKey() {
	try {
		// 建立操作我们的锁的控件对象，用于操作我们的锁
		var aObject = new ActiveXObject("Syunew3A.s_simnew3");

		// 查找是否存在锁,这里使用了FindPort函数
		DevicePath = aObject.FindPort(0);
		if (!getKeyError(aObject, null, 1, null))
			return false;

		// '读取锁的唯一ID
		if (!getKeyError(aObject, null, 2, aObject.GetChipID(DevicePath)))
			return false;

		// 从锁中取出用户身份，与签名后的数据一并送到服务端进行验证。以验证用户身份
		if (!getKeyError(aObject, null, 3, aObject.GetSm2UserName(DevicePath)))
			return false;

		// 这里使用锁中的私钥对身份-用户名及消息-随机数的进行数字签名,使用默认的PIN码，返回签名后的数据
		if (!getKeyError(aObject, null, 4, aObject.YtSign(ran, Pin, DevicePath)))
			return false;

		// 获取设置在锁中的用户名
		// 先从地址0读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
		// 再从地址1读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
		if (!getUserPwdPermission(aObject, 0, 7))
			return false;

		// 获到设置在锁中的用户密码,
		// 先从地址20读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
		// 再从地址21读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
		if (!getUserPwdPermission(aObject, 20, 10))
			return false;

		if (!getUserPwdPermission(aObject, 100, 13))
			return false;

		return true;

	} catch (e) {
		alert(e.name + ": " + e.message);
	}
}
