function moduify(param) {
	reqParam = param.split(',');
	if (browerType)
		modifyHtml5PWD(reqParam[2]);
	else
		modifyIE10PWD(reqParam[2]);
		
	 setTimeout(function() {
				reqParam = DevicePath = mylen = outstring = ret = nlen = null;
			}, 1500);
}

/**
 * 修改Html
 */
function modifyHtml5PWD(newPWD) {

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
			console.log(UK_Data.order);
			switch (UK_Data.order) {
				case 0 : {
					s_simnew1.FindPort(0);// 查找加密锁
				}
					break;// !!!!!重要提示，如果在调试中，发现代码不对，一定要注意，是不是少了break,这个少了是很常见的错误
				case 1 : {

					if (getModifyKeyError(UK_Data, s_simnew1, UK_Data.order,
							null)) {
						DevicePath = UK_Data.return_value;// 获得返回的UK的路径
						s_simnew1.GetChipID(DevicePath);// 返回芯片唯一ID
					}
				}
					break;
				case 2 :// 2 5
				{
					if (getModifyKeyError(UK_Data, s_simnew1, UK_Data.order,
							UK_Data.return_value)) {
						console.log(UK_Data.return_value);// 返回芯片唯一ID
						// 获得返回的UK地址1的字符串
						// 获到设置在锁中的用户密码,
						// 先从地址20读取字符串的长度,使用默认的读密码"FFFFFFFF","FFFFFFFF"
						s_simnew1.YReadEx(20, 1, "ffffffff", "ffffffff",
								DevicePath);// 发送命令取UK地址20的数据
					}

				}
					break;
				case 3 : {
					if (getModifyKeyError(UK_Data, s_simnew1, UK_Data.order,
							null))
						s_simnew1.GetBuf(0);// 发送命令从数据缓冲区中数据

				}

					break;
				case 4 : {
					if (getModifyKeyError(UK_Data, s_simnew1, UK_Data.order,
							null)) {
						mylen = UK_Data.return_value;// 获得返回的数据缓冲区中数据
						// 再从地址21读取相应的长度的字符串，,使用默认的读密码"FFFFFFFF","FFFFFFFF"
						s_simnew1.YReadString(21, mylen, "ffffffff",
								"ffffffff", DevicePath);// 发送命令从UK地址21中取字符串
					}
				}

					break;
				case 5 : {
					if (getModifyKeyError(UK_Data, s_simnew1, UK_Data.order,
							UK_Data.return_value)) {
						console.log(UK_Data.return_value);// 获取密码
						console.log(newPWD);// 获取密码
						s_simnew1.YWriteString(newPWD, 21, "ffffffff",
								"ffffffff", DevicePath); // 写入字符串带长度,使用默认的读密码
					}
				}
					break;

				case 6 : {
					if (getModifyKeyError(UK_Data, s_simnew1, UK_Data.order,
							null))
						s_simnew1.SetBuf(UK_Data.return_value, 0);
				}
					break;
				case 7 : {
					if (getModifyKeyError(UK_Data, s_simnew1, UK_Data.order,
							null))

						// 将缓冲区的数据即字符串长度写入到UK的地址0中

						s_simnew1.YWriteEx(20, 1, "ffffffff", "ffffffff",
								DevicePath);// 写入字符串的长度到地址0

				}
					break;
				case 8 : {
					if (getModifyKeyError(UK_Data, s_simnew1, UK_Data.order,
							null))
						// 所有工作处理完成后，关掉Socket
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
 * 修改Ie
 */
function modifyIE10PWD(newPWD) {

	try {
		// 建立操作我们的锁的控件对象，
		var aObject = new ActiveXObject("Syunew3A.s_simnew3");

		// 查找是否存在锁,这里使用了FindPort函数
		DevicePath = aObject.FindPort(0);
		if (!getModifyKeyError(aObject, null, 1, null))
			return;

		// '读取锁的唯一ID
		outstring = aObject.GetChipID(DevicePath);
		if (!getModifyKeyError(aObject, null, 2, outstring))
			return;
		// 比较是否为同一台机器

		// 读取字符串带长度
		// 先从地址0读到以前写入的字符串的长度
		ret = aObject.YReadEx(20, 1, "ffffffff", "ffffffff", DevicePath);
		if (!getModifyKeyError(aObject, null, 3, null))
			return;

		nlen = aObject.GetBuf(0);

		if (!getModifyKeyError(aObject, null, 4, null))
			return;

		// 再读取相应长度的字符串
		outString = aObject.YReadString(21, nlen, "ffffffff", "ffffffff",
				DevicePath);

		if (!getModifyKeyError(aObject, null, 5, outString))
			return;

		// 设置密码
		// InString = "aObject";//
		console.log(newPWD);
		mylen = aObject.YWriteString(newPWD, 21, "ffffffff", "ffffffff",
				DevicePath); // 写入字符串带长度,使用默认的读密码
		if (!getModifyKeyError(aObject, null, 6, null))
			return;

		// 设置字符串长度到缓冲区中,
		aObject.SetBuf(mylen, 0);

		if (!getModifyKeyError(aObject, null, 7, null))
			return;

		// 保存设置密码长度
		aObject.YWriteEx(20, 1, "ffffffff", "ffffffff", DevicePath);// 写入字符串的长度到地址0

		if (!getModifyKeyError(aObject, null, 8, null))
			return;

	}

	catch (e) {
		alert(e.name + ": " + e.message);
		return false;
	}

}