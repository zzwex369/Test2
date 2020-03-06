package com.xyw.sys.custom.component
{
	import com.xyw.sys.custom.skin.CustomTitleWindowSkin;
	import com.xyw.sys.model.ComboBoxDataRequest;
	import com.xyw.sys.model.SystemUser;
	
	import flash.display.DisplayObject;
	import flash.display.DisplayObjectContainer;
	import flash.display.Sprite;
	import flash.events.ErrorEvent;
	import flash.events.Event;
	import flash.external.ExternalInterface;
	import flash.geom.Point;
	import flash.net.FileReference;
	import flash.net.URLRequest;
	import flash.utils.ByteArray;
	
	import flex.lang.reflect.Method;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.controls.DateField;
	import mx.controls.ToolTip;
	import mx.core.Container;
	import mx.core.FlexGlobals;
	import mx.core.IFlexDisplayObject;
	import mx.core.IUIComponent;
	import mx.effects.easing.Elastic;
	import mx.events.CloseEvent;
	import mx.events.FlexMouseEvent;
	import mx.managers.PopUpManager;
	import mx.managers.ToolTipManager;
	import mx.messaging.AbstractConsumer;
	import mx.rpc.AbstractOperation;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	import mx.utils.StringUtil;
	
	import spark.components.BorderContainer;
	import spark.components.CheckBox;
	import spark.components.ComboBox;
	import spark.components.DataGrid;
	import spark.components.DropDownList;
	import spark.components.Group;
	import spark.components.Label;
	import spark.components.RadioButton;
	import spark.components.SkinnableContainer;
	import spark.components.TextArea;
	import spark.components.TextInput;
	import spark.components.TitleWindow;
	import spark.components.gridClasses.GridColumn;
	import spark.components.supportClasses.GroupBase;
	import spark.core.IViewport;
	import spark.modules.Module;
    
	/**
	 * @author libo
	 * 创建时间：Aug 11, 2017 11:21:03 AM
	 */
	public class CompMethod
	{
		public function CompMethod()
		{
		}
		public static const MAIN:Object =FlexGlobals.topLevelApplication;
		/**
		 * 读卡
		 *  sex 性别可以为null 则不验证性别
		 * 0，姓名  1性别  2民族  3 生日  4 地址  5 证号 6 编码
		 **/
		public static function read_card(sex:String=null):Array
		{
			var arr:Array ;
			var str:String = ExternalInterface.call("parent.readCard");
			if(!str||!str.length){	
				Alert.show("读卡失败，无法得到身份证信息！","系统提示");
				return null;
			}else 
			{
				arr = str.split(",");
				var app:Object=FlexGlobals.topLevelApplication;
				var rcPermission:String=app.paramPermission.rcPermission;
				if(rcPermission=='1')
				{
					var rcCode:String=app.systemUser.rcCode;//读卡器编码
					if(arr[6]!=rcCode)
					{
						Alert.show("非法的读卡器设备！","系统提示");
						return null;
					}
				}
				if(sex&&sex!=arr[1])
				{
					Alert.show("请读"+sex+"性身份证","系统提示");
					return null;
				}	
			}
			return arr;
			
		}
		
		
		/**
		 * 读卡
		 *  
		 * 0，姓名  1性别  2民族  3 生日  4 地址  5 证号
		 **/
		public static function readCard():Array
		{
			var str:String = ExternalInterface.call("parent.readCard");
			if(str != null && str.length != 0){	
				var array:Array = str.split(",");
				return array;
			}
			return null;
		}
		
		/***************身份证性别判断*********************/
		public static function sex(_sex:String,idCardSex:String):Boolean
		{
				var message:Alert;
				if("男"==_sex)
				{
					if(idCardSex!=_sex)
					{
					 message=Alert.show("请读男性身份证","系统提示");	
					 return false;
					}
				}else
				{
					if(idCardSex!=_sex)
					{
						message=Alert.show("请读女性身份证","系统提示");	
						return false;
					}
				}
				return true;
		}
		/****************年龄算法********************/
		public static function getAge(idCardNumber:String):String
		{
			if(idCardNumber != ""){
				if(idCardNumber.length >= 16){
					var year:Number = Number(idCardNumber.substr(6,4));
					var month:Number = Number(idCardNumber.substr(10,2));
					var day:Number = Number(idCardNumber.substr(12,2));
					var date:Date = new Date();
					var nowMonth:Number = date.month + 1;
					var age:Number = date.fullYear - year;
					if(month > nowMonth || month == nowMonth && day > date.date){
						age=age - 1;;
					}
						return age+"";
				}
		}
			return ""
	}

	/****************根据出生日期年龄算法********************/
		public static function _getAge(birthdayVal:*):String
		{		
				var birthday:Date=(birthdayVal is Date)?birthdayVal:DateField.stringToDate(birthdayVal,'YYYY-MM-DD');
				var year:Number = birthday.fullYear;
				var month:Number = birthday.month;
				var day:Number = birthday.date;
				var date:Date = new Date();
				var nowDay:Number = date.date;
				var nowMonth:Number = date.month + 1;
				var nowYear:Number = date.fullYear;
				var age:Number;
				if(nowMonth < month){
					age = nowYear - year - 1;
				}else if(nowMonth == month){
					if(day > nowDay){
						age = nowYear - year -1;
					}else{
						age = nowYear - year;
					}
				}else if(nowMonth > month){
					age = nowYear - year;
				}
				return age.toString();
		}

		/**
		 * 根据身份证号得到出生日期
		 */
		public static function getBirthday(idCardNumber:String):String
		{
			if(idCardNumber != ""){
				if(idCardNumber.length >= 16){
					var year:Number = Number(idCardNumber.substr(6,4));
					var month:Number = Number(idCardNumber.substr(10,2));
					var day:Number = Number(idCardNumber.substr(12,2));	
					var dateStr:String=year+"-"+month+"-"+day;
					return dateStr;
				}
			}
			return null;
		}
		
		/****************选择对应的信息********************/
		public static function getDropDownListSelectedIndex(arrayCollection:*,
															defaultValue:String,
															flag:Boolean=false):int
		{
			arrayCollection=arrayCollection is ArrayCollection?arrayCollection:ArrayCollection(arrayCollection);
			var len:uint = arrayCollection.length;
			var i:uint = 0;
			var index:int = 0;
			var comboBoxDataP:Object =new Object();
			if(!flag)
			{
				while(i < len) {
					comboBoxDataP= arrayCollection.getItemAt(i);
					if(comboBoxDataP.data == defaultValue) {
						index = arrayCollection.getItemIndex(comboBoxDataP);
						break;
					}
					i++;
				}
				//民族
			}else if(flag)
			{
				
				defaultValue=(defaultValue=="穿青人")?defaultValue:defaultValue+"族";
				while(i < len) {
					comboBoxDataP = arrayCollection.getItemAt(i);
					if(comboBoxDataP.label == defaultValue) {
						index = arrayCollection.getItemIndex(comboBoxDataP);
						break;
					}
					i++;
				}
			}
			return index;
		}
		/*******************验证地址选项是否选择到最下级*****************/
		public static function validateAreaCode(areaCode:String,
												provinceCode:String,
												flag:Boolean=false):Boolean
		{
			if(areaCode == "" || areaCode.length == 0){
				return false;
			} else if(areaCode.length < 9){
				return false;
			} else if(areaCode.length == 9){
				if(!flag)
				{
					if(areaCode.substr(0,4) == provinceCode){
						return false;
					} else {
						return true;
					}
				}else
					return true;
			} else {
				return true;
			}
		}
		/*****************关闭功能*******************/
		public static function closeWindow(popUp:IFlexDisplayObject):void
		{
			PopUpManager.removePopUp(popUp);
		}
		
		/**
		 *验证是否含有子节点
		 */
		public static function hasNumEles(child:Object):void
		{
			if(child is Array || child is ArrayCollection)
			{
				for(var j:int=0;j<child.length;j++)
				{
					hasNumEles(child[j]);
				}
			}
			else if (child is Container && Container(child).getChildren()
				||child is BorderContainer||child is GroupBase)
			{
				
				for(var i:uint=0;i<child.numElements;i++)
				{	
					var _child:Object=child.getElementAt(i);
					hasNumEles(_child);
				}
			}			
			else
				doClearEle(child);
		}
		
		/**
		 * 恢复初始化状态
		 */
		public static function doClearEle(child:Object):void
		{
			
			if (child is RadioButton){ 
				RadioButton(child).selected=false; 
			}else if(child is TextInput){
				TextInput(child).text="";
			}else if(child is TextArea){
				TextArea(child).text="";
			}else if(child is DropDownList){
				DropDownList(child).selectedIndex=0;
			}else if(child is CheckBox){
				CheckBox(child).selected=false;
			}else if(child is DateField)
			{
				DateField(child).text="";
			}else if(child is ComboBox)
			{
				var comboBox:ComboBox=ComboBox(child);
				if(comboBox.dataProvider&&comboBox.dataProvider.getItemAt(0).label=="选择")
					comboBox.selectedIndex=0;
				else
					comboBox.textInput.text=null;
			}
		}
		
		public static function saveEleVale(child:Object):Object
		{
			var value:Object=""; 
			if(child is TextInput){
				value =TextInput(child).text;
			}else if(child is DropDownList){
				value =DropDownList(child).selectedItem.data;
			}else if(child is DateField)
			{
				value =DateField(child).text;
			}
			return value;
		}

		/****************遍历重置组件********************/
		public static function _walk(ui:Object):void 
		{ 
			for(var i:uint=0;i<ui.numElements;i++)
			{	
				var child:Object=ui.getElementAt(i);
				if (child is Container && Container(child).getChildren()||child is BorderContainer||child is GroupBase) { 
					_walk(child); 
				} else 
					doClearEle(child);
			}							
		}
		/*****************返回消息功能*******************/
		public static function resultHandler(event:ResultEvent):void
		{
			var message:Alert=event.result.state==true?
				Alert.show(event.result.promptMessage,"系统提示"):
				Alert.show(event.result.errorMessage,"系统提示");
		}
		
		/******************创建错误提示信息面板******************/
		public static function showTip(objId:Object,
									   objType:String,
									   errorString:String,
									   tip:ToolTip):Array
		{
			// objType  1.textInput  2.DropDownList  3.地址
			tip=destoryTip(tip);
			var arr:Array;
			var flag:Boolean=false;
			if("1"==objType)
				flag=(StringUtil.trim(objId.text)=="")?true:false;
			else if("2"==objType)
				flag=(objId.selectedIndex==0)?true:false;
			else if("3"==objType)
				flag=true;
			if(flag)
			{
				if(tip == null)
				{
					var point:Point = new Point(objId.x, objId.y);
					point = objId.localToGlobal(point);
					tip = ToolTipManager.createToolTip(errorString,point.x - objId.x, 
						point.y - 35 ,'errorTipAbove', objId as IUIComponent) as ToolTip;
					/*					tip =ToolTipManager.createToolTip(errorString,objId.getBounds(objId.root).x + objId.width,objId.getBounds(objId.root).y, 'errorTipAbove', objId as IUIComponent) as ToolTip
					*/					tip.styleName = 'errorTip';
				}	
			}
			return arr=[objId,objType,errorString,tip];
		}
		/*******************删除错误信息面板指针*****************/
		public static function  destoryTip(tip:ToolTip):ToolTip
		{
			if(tip)
				ToolTipManager.destroyToolTip(tip);
			tip = null;
			return tip;
		}
		/*******************设置样式名称*****************/
		public static function addStyleName(ui:Object):void
		{
			for(var i:int=0;i<ui.numElements;i++)
			{
				var child:Object=ui.getElementAt(i);
				if(child is Group  ||child is SkinnableContainer ||child is Container && Container(child).getChildren())
					addStyleName(child);				
				else if(child is Label)
				{
					if(!Label(child).styleName)
						child.styleName="myLabel";					
				}
			}
		}
		
		/****************设置鼠标滑轮控制滚动条速度********************/
		public static  function setMouseWheelSpeed(event:FlexMouseEvent,
												   scroller:Object):void
		{
			event.preventDefault();  
			var modifier:int = 5;  
			var delta:Number = Number(event.delta) * modifier;  //正 delta 值指示向上滚动；负值指示向下滚动
			var viewport:IViewport = scroller.verticalScrollBar.viewport;  
			var vPos:Number = viewport.verticalScrollPosition;  //滚动条的位置 ，最上面是0
			var maximum:Number = scroller.verticalScrollBar.maximum;  
			if (delta < 0)     
				scroller.verticalScrollBar.viewport.verticalScrollPosition =  Math.min(vPos - delta, maximum) ;  //返回参数最小的哪个          
			else  
				scroller.verticalScrollBar.viewport.verticalScrollPosition = Math.max(vPos - delta, 0);  //返回参数最大的哪个 
		}
		
		/****************刷新index********************/
		public static  function _refreshIndex(module:Object,
											  path:String=null):void
		{
			var vbox:Object=module.parent;
			var superTabNavigator:Object=module.parent.parent; 
			module.parentApplication.contentLabel=vbox.label;
			superTabNavigator.removeElement(vbox);
			module.parentApplication.loadModule(path?path:vbox.automationName);
		}
		
		/****************验证********************/
		public static  function validate(status:String,
										 id:Object,
										 str:String):Boolean
		{	
			/*
			*参数一 1代表text  2代表下拉框
			*/
			if("1"==status)
			{
				if(!id.text)
				{
					Alert.show("请输入"+str,"系统提示");
					return true;
				}
			
			}else if("2"==status)
			{
				if(!id.selectedIndex)
				{
					Alert.show("请选择"+str,"系统提示");
					return true;
				}
			}
			return false;
		}
		
		/****************弹出TitleWindow********************/
		public static  function popUpTitleWindow(window:TitleWindow,
												 parent:DisplayObjectContainer,
												 modal:Boolean=false):void
		{
			var app:Object=FlexGlobals.topLevelApplication
			window.setStyle("skinClass",Class(com.xyw.sys.custom.skin.CustomTitleWindowSkin));
			window.owner =parent;
			PopUpManager.addPopUp(window,parent,modal);
			var x:Number = (app.mdiCanvas.width-window.width)/2;
			var y:Number = (app.mdiCanvas.height-window.height)/2;
			window.move(x,y);
			if(!window.hasEventListener(ErrorEvent.ERROR))
				window.addEventListener(ErrorEvent.ERROR,app.errorHandler);
		}
		
		/**
		 * 设置禁选日期范围
		 * date 日期
		 * day 天数
		 * 返回 日期+天数的禁止范围
		 */
		public static function getRangeStart(date:Date,day:Number=1):Date
		{
			return new Date(date.time+=24*60*60*1000*day);
			
		}
		
		/**
		 * 得到单选框value 值
		 * idArr 组件数组
		 * index 下标 
		 * 
		 */
		public static function getRadioButtonValue(idArr:*,index:int=0):String
		{
			var value:String='';
			if(!index)
				idArr=idArr is Array?idArr:[idArr];
			for(var i:int=0;i<idArr[index].numElements;i++)
			{
				var radioButton:Object=idArr[index].getElementAt(i);
				if(radioButton is RadioButton)
				{
					if(radioButton.selected)
					{
						value=radioButton.value.toString();
						break;
					}
				}else
					continue;
			}
			if(idArr.length==index+1)
				return value;
			return value?value:getRadioButtonValue(idArr,++index);
			
		}
		
		
		/**
		 * 根据值设置对应的单选框
		 * idArr 组件数组
		 * val   对应值
		 * index 下标 
		 * 
		 */
		public static function setRadioButtonSelect(idArr:*,
													val:String,
													index:int=0):RadioButton
		{
			var selectButton:RadioButton=null;
			if(!val)
				return selectButton;
			if(!index)
				idArr=idArr is Array?idArr:[idArr];
			for(var i:int=0;i<idArr[index].numElements;i++)
			{
				var radioButton:Object=idArr[index].getElementAt(i);
				if(radioButton is RadioButton)
				{
					if(val==radioButton.value.toString())
					{
						selectButton=RadioButton(radioButton);
						radioButton.selected=true;
						break;
					}
				}else
					continue;
			}
			if(idArr.length==index+1)
				return selectButton;
			else
				return setRadioButtonSelect(idArr,val,++index);
		}
		
		
		/**
		 * 得到单选框CheckBox   AutomationName 值
		 * idArr 组件数组
		 * index 下标 
		 * valResult 是否没有选择 false 未选择 true 已选择
		 */
		public static function getCheckBoxAutomationName(idArr:*,
														 value:String='',
														 index:int=0,
														 valResult:Boolean=false):Array
		{
			if(!index)
				idArr=idArr is Array?idArr:[idArr];
			for(var i:int=0;i<idArr[index].numElements;i++)
			{
				var checkBox:Object=idArr[index].getElementAt(i);
				if(checkBox is CheckBox)
				{
					
					if(checkBox.selected)
					{
						valResult=true;
						value+=checkBox.automationName;
					}else
						value+='0';
					value+=',';
				}
			}
			return idArr.length==index+1?[valResult,value]:getCheckBoxAutomationName(idArr,value,++index,valResult);	
		}
		
		/**
		 * 根据值设置对应的多选框
		 * idArr 组件数组
		 * val   对应值
		 * index 下标 
		 * 
		 */
		public static function setCheckBoxAutomationName(idArr:*,
														 val:String,
														 index:int=0):void
		{
			if(!val)
				return ;
			var valArr:Array=val.split(',');
			var valStatus:Boolean;
			if(!index)
				idArr=idArr is Array?idArr:[idArr];
			for(var i:int=0;i<idArr[index].numElements;i++)
			{
				var checkBox:Object=idArr[index].getElementAt(i);
				if(checkBox is CheckBox)
				{
					for(var j:int=0;j<valArr.length;j++)
					{
						valStatus=Boolean(Number(valArr[j]));
						if(valArr[j]==checkBox.automationName||!valStatus)
						{					
							checkBox.selected=valStatus?valStatus:checkBox.selected;
							valArr.splice(j,1);
							j--;
						}
					}
				}
			}
			if(idArr.length==index+1)
				return;
			else
				return setCheckBoxAutomationName(idArr,valArr.toString(),++index);
		}		
			
		
		/**
		 * 将date 类型转换为字符串
		 * 
		 */
		public static function setStrDate(item:Object, column:GridColumn):String
		{
			var fieldDate:Date=item[column.dataField] as Date;
			return DateField.dateToString(fieldDate,'YYYY-MM-DD');
		}
		/**
		 * s601_04 转换 是否
		 * 
		 */
		public static function setStrSF(item:Object, column:GridColumn):String
		{
			return item[column.dataField]=='1'?'是':'否';
		}
		
		/**
		 * 控制转换 是否
		 * 
		 */
		public static function setNullSF(item:Object, column:GridColumn):String
		{
			return item[column.dataField]?'是':'否';
		}
		
		/**
		 * 得到对应的机构名称
		 * 
		 */
		public static function setInstitutionLabel(item:Object,column:GridColumn):String
		{
			var institution:String=item[column.dataField] as String;
			return doInstitutionLabel(institution);
		}
		
		/**
		 * 根据机构代码得到对应的机构名称
		 */
		public static function doInstitutionLabel(institution:String):String
		{
			var comboBoxDataList:ArrayCollection=FlexGlobals.topLevelApplication.
				comboBoxDataList.wholeInstitutionCode;
			var idx:uint=CompMethod.getDropDownListSelectedIndex(comboBoxDataList,institution);
			return comboBoxDataList.getItemAt(idx).label;
		}
		
		/**
		 * 下载文件
		 * 1.url 文件链接 
		 * 2.文件名字 带后缀
		 * 3.prefix 路径前缀 http://www.xywdzkj.com/csyxzm/
		 */
		public static function downLoadFiles(url:String,
											 fileName:String,
											 prefix:String='http://www.xywdzkj.com/csyxzm/'):void
		{
			var URL:String = url;
			var downloadURL:URLRequest = new URLRequest(prefix+URL);
			var downloadFile:FileReference = new FileReference();
			downloadFile.addEventListener(Event.COMPLETE, 
				function completeHandler(event:Event):void {
					Alert.show("下载成功！");
				});
			var suffix:String=url.substring(url.lastIndexOf('.'));
			downloadFile.download(downloadURL,fileName+suffix);
		}
		
		/**
		 * 获取后台数据 用于字典表
		 * sqlArr
		 * 
		 * sql:String,sql语句
		 * flag:String,标识
		 * showPrompt:Boolean 是否添加请选择项
		 * 
		 * 
		 * remoteArr
		 * 
		 * destination:String, Java service bean id
		 * operationMethod:String, 请求的方法名称
		 * resultMethod:Function,  返回结果方法
		 * faultMethod:Function    失败返回方法
		 * 示例  CompMethod.getComboBoxData(["select e705_04,t.e705_03 from E705 t where e705_11='"+
					systemUser.institutionCode+"'","E705",true],
			["systemService","getComboBoxData",getComboBoxDataHandler,null])
		 */
		public static function getComboBoxData(sqlArr:Array,remoteArr:Array):void
		{
			var comboBoxDataRequest:ComboBoxDataRequest = new ComboBoxDataRequest();
			comboBoxDataRequest.showPrompt = sqlArr[2];
			comboBoxDataRequest.sql =sqlArr[0] ;
			comboBoxDataRequest.flag = sqlArr[1];
			customRemoteObject(remoteArr,comboBoxDataRequest);
		}
		
		
		/**
		 * 获取后台数据
		 * 
		 * remoteArr
		 * 
		 * destination:String, Java service bean id
		 * operationMethod:String, 请求的方法名称
		 * resultMethod:Function,  返回结果方法
		 * faultMethod:Function    失败返回方法
		 */
		public static function customRemoteObject(remoteArr:Array,val:Object):void
		{
			var remote:RemoteObject=new RemoteObject();
			remote.destination=remoteArr[0];
			remote.endpoint=FlexGlobals.topLevelApplication.contextRoot+"/messagebroker/amf";
			remote.showBusyCursor=true;
			var service:AbstractOperation = remote.getOperation(remoteArr[1]);  
			service.addEventListener(ResultEvent.RESULT, remoteArr[2]);
			if(remoteArr[3])
				service.addEventListener(FaultEvent.FAULT, remoteArr[3]);
			service.send(val);
		}
		
		/**
		 * 删除信息提示，按钮 默认是否 提示信息默认   是否要删除这条信息
		 */
		public static function delConfirm(delFunction:Function,
										  param:*=null,
										  text:String="是否要删除这条信息"):void
		{
			Alert.show(text,"系统提示",3,Sprite(FlexGlobals.topLevelApplication),
				function(event:CloseEvent):void
			{
					if(event.detail==1)
						param?delFunction(param):delFunction();
				
			});
		
		}
		
		/**
		 * 操作信息提示，
		 */
		public static function operationConfirm(operationFunction:Function,
												param:*=null,
												text:String=""):void
		{
			CompMethod.delConfirm(operationFunction,param,text);
			
		}
		
		/**
		 * 判断开始时间是否大于结束时间，是 为true, 否 false 
		 */
		public static function getTimeSpace(timeStart:DateField,
											timeEnd:DateField,
											isShow:Boolean=true,
											showMessage:String="开始时间不能大于结束时间！"):Boolean
		{
			var result:Boolean=false;
			var start:Number=DateField.stringToDate(timeStart.text,'YYYY-MM-DD').time;
			var end:Number=DateField.stringToDate(timeEnd.text,'YYYY-MM-DD').time;
			if(end-start<0)
			{
				result=true;
				if(isShow)
					Alert.show(showMessage,"系统提示");
			}
			return result;
		}
		
		
		/**
		 * Flex深度复制
		 */
		public static function cloneObject(obj:Object):*
		{
			var copier:ByteArray = new ByteArray();
			copier.writeObject(obj);
			copier.position = 0;
			return copier.readObject();
		}
		
		
		/**
		 * 得到对应后缀字段
		 */
		public static function getObjSuffixField(val:*,
												 valArr:Array,
												 suffixFieldArr:Array):*
		{
			for (var i:int=0;i<valArr.length;i++)
			{
				if(val==valArr[i])
					return suffixFieldArr[i];
			}
			return null;
		}
		
		
		/**
		 * 得到对应后缀字段
		 */
		public static function getObjFieldVal(valArr:Array):*
		{
			for (var i:int=0;i<valArr.length;i++)
			{
				if(valArr[i])
					return valArr[i];
			}
			return null;
		}
		
		/**
		 * 验证操作信息机构是否与登录账号一致 
		 *  return true 一致  false 不一致
		 */
		public static function isSameInstitution(paramArr:Array,
												 text:String="不是该账号录入的信息无法进行信息操作！"):Boolean
		{
			if(!CompMethod.correctArr(paramArr,2))
				return false;
			var result:Boolean=true;
			var systemUser:SystemUser=FlexGlobals.topLevelApplication.systemUser;
			var code:String=paramArr[0]?systemUser.userCode:systemUser.institutionCode;
			if(code!=paramArr[1])
			{
				result=false;
				Alert.show(text,"系统提示");
			}
			return result;
		}
		
		/**
		 *	选择当前登录的账号机构序号（下拉框使用）
		 * ids  下拉框数组 多个 dropDownList
		 *  
		 */
		public static function getDefaultCode(ids:*,isDefaultSelect:Boolean=true):void
		{
			ids=ids is Array ? ids:[ids]
			var app:Object=FlexGlobals.topLevelApplication;
			var comboBoxDataList:ArrayCollection = app.comboBoxDataList.wholeInstitutionCode;
			var idx:int=getDropDownListSelectedIndex(comboBoxDataList,app.systemUser.institutionCode);
			for(var i in ids)
			{
				ids[i].dataProvider=comboBoxDataList;
				ids[i].selectedIndex=isDefaultSelect?idx:0;
			}
		}
		
		/*计算一个月中有多少天
		* @author wangfeng
		* @date 2013年4月9日 15:47:58 
		*/ 
		public static function dayCount(year:Number,month:Number):int 
		{ 
			var result:int = 0; 
			if(1==month || 3==month || 5==month|| 7==month || 8==month || 10==month || 12==month) 
			{ 
				result = 31; 
			}else if(4==month || 6==month || 9==month || 11==month) 
			{ 
				result = 30;     
			}else if(2==month) 
			{ 
				if((year % 4 == 0 && year %100 !=0) || year % 400 == 0) 
				{ 
					result = 29; 
				}else 
				{ 
					result = 28; 
				} 
			} 
			return result;   
		}  
		
		/**
		 *   验证对象是否为空  
		 *   item 对象  text 提示
		 *   return false 空    true 有
		 */
		public static function isSelectItem(item:Object,
											text:String="请选择要操作的行！"):Boolean
		{
			if(!item){
				Alert.show(text,"系统提示");
				return false;
			}
			return true;
		}
		
		
		/**
		 *   验证对象是否上传 
		 *   item 对象 
		 *   status 上传标志 默认 1
		 * 	 text 提示
		 *   return false 上传   true 未上传
		 */
		public static function isUpload(item:String,
										status:String,
										text:String="该信息已经上传至省平台，无法进行任何操作！"):Boolean
		{
			if(StringUtil.trim(item)==status){
				Alert.show(text,"系统提示");
				return false;
			}
			return true;
		}
		
		/**
		 * 验证修改和删除 是否未选择 一条记录  是否 为录入机构修改和删除， 删除时并弹出提示消息
		 * item 选择的一条记录
		 * fieldArr 0 录入机构字段  1 上传字段
		 * objFunction 删除或修改的 函数
		 * param 函数参数
		 * isDel 是否为删除 函数
		 * status 上传标志 默认 1
		 * isUserCode   true 用 用户编码来验证是否有修改 删除权限 false 用 机构编码来验证是否有修改 删除权限 
		 */
		public static function modifyOrDel(item:Object,
										   fieldArr:Array,
										   objFunction:Function,
										   param:*=null,
										   isDel:Boolean=false,
										   status:String='1',
										   isUserCode:Boolean=true):void
		{
			if(!CompMethod.correctArr(fieldArr,2))
				return ;
			if(!CompMethod.isSelectItem(item))
				return ;
			if(!CompMethod.isUpload(item[fieldArr[1]],status))
				return ;
			if(!CompMethod.isSameInstitution([isUserCode,item[fieldArr[0]]]))
				return ;
			isDel?CompMethod.delConfirm(objFunction,param):param!=null?objFunction(param):objFunction();
			
		}
		
		/**
		 * 通用查询方法
		 * initParam 查询条件方法
		 * req 请求对象  
		 * remoteArr 最少三个内容  0 Java service Bean 对象  1 Java 方法  2 flex 指定的返回结果方法 3 请求是失败的 方法 （可以不用） 
		 * 例子  CompMethod.query(initQueryParam,new E304Request(),
		 * 					  ['e304Service','queryPhasesE304',queryPhasesE304Handler]
		 * 					  ,pageIdx,pageSize);
		 */
		public static function query(initParam:Function,
									 req:Object,
									 remoteArr:Array,
									 pageIdx:uint=1,
									 pageSize:uint=20):void
		{
			var result:*=initParam(req);
			if(result!=undefined&&!result)//是否为Boolean
				return ;
			if(!CompMethod.correctArr(remoteArr,3))
				return ;
			req.parameterPageindex=pageIdx;
			req.parameterPagesize=pageSize;
			CompMethod.customRemoteObject(remoteArr,req);
		}
		
		/**
		 * 查询返回结果集
		 * resp 结果对象
		 * paramArr 参数数组 三位字段  0 结果集 1数量 2 错误消息 
		 * dataGrid dataGrid数据显示  主键
		 * pageBar pageBar分页 主键
		 * pageFunction 分页函数
		 * pageSize 每页多少个数量
		 * 例子  CompMethod.queryHandler(event.result,['ve304s','rowCount','errorMessage'],e304Data,pagerBar,pagerFunction);
		 */
		public static function queryHandler(resp:Object,
										    paramArr:Array,
											dataGrid:Object,
											pageBar:Object,
											pageFunction:Function,
											pageSize:uint=20 ):void
		{
			if(!CompMethod.correctArr(paramArr,3))
				return ;
			dataGrid.dataProvider=null;
			var rowCount:Number = resp[paramArr[1]];
			
			pageBar.enabled = rowCount;	
			
			if(resp[paramArr[2]]){
				Alert.show(resp[paramArr[2]],"系统提示");
				return;
			}
			
			if(!rowCount)
			{
				Alert.show("暂无数据！","系统提示");
				return ;
			}	
			
			var restltArr:ArrayCollection =resp[paramArr[0]];
			pageBar.pageSize = pageSize;
			pageBar.dataGrid = dataGrid;  
			pageBar.rowCount = rowCount;
			pageBar.resultData = restltArr;
			pageBar.dataBind();
			pageBar.pagerFunction = pageFunction;
			
			
		}
		
		/**
		 * 添加  修改 删除 返回方法
		 * resp 结果对象
		 * paramArr 参数数组 两位字段  0 错误消息 1 消息类型   添加  修改 删除  
		 * isAlert 弹出框关闭后运行 方法  true  是  false 否
		 * button 保存或修改按钮
		 * completeFunction 成功后返回方法
		 * 例子  CompMethod.CUDHandler(event.result,['errorMessage','删除'],refresh,button,false);
		 */
		public static function CUDHandler(resp:Object,
										  paramArr:Array,  
										  completeFunction:Function=null,
										  button:Object=null,
										  isAlert:Boolean=true):void
		{   
			if(button)
				button.enabled=true;
			if(!CompMethod.correctArr(paramArr,2))
				return ;
			 if(resp[paramArr[0]]) {
				Alert.show(resp[paramArr[0]],"系统提示");
				return;
			}
			if(!isAlert)
			{
				completeFunction();
				completeFunction=null;
			}
			Alert.show(paramArr[1]+"成功！ ","系统提示",1,
				FlexGlobals.topLevelApplication.mdiCanvas,
				function():void{completeFunction()});
			
		}
		
		/**
		 * 是否为合法的数组
		 *   
		 */
		public static function correctArr(paramArr:Array,
										  length:uint):Boolean
		{  
			if(!paramArr||paramArr.length<length)
				return false;
			return true;
		}
		
		/**
		 * 为下拉框去设置选项
		 * 返回选择的内容   label 
		 */
		public static function setDropDownListIdx(id:Object,
												  arrayCollection:*,
												  defaultValue:String,
												  flag:Boolean=false):String
		{  
			id.selectedIndex=getDropDownListSelectedIndex(arrayCollection,defaultValue,flag);
			return id.selectedItem.data;
		}
		
		/**
		 * pagebar 导出当前页
		 */
		public static function exportEXCEL(dg:DataGrid, name:String):void
		{
			ExportExcel.loadDGInExcel(dg,name,FlexGlobals.topLevelApplication.contextRoot + '/print/ExcelExport.jsp');
		}
		
		/**
		 * title 提示字段标签
		 * 验证值（数字或字符串）是否符合数字格式
		 * val 字符串或数字
		 * min 最小值
		 * max 最大值
		 * isPoint 是否含有小数点 default false
		 * pmax 小数点最大位数  default 1
		 * 非法返回 false  合法 true 
		 */
		public static function validateNum(title:String,val:*,
										   min:uint,
										   max:uint,
										   isPoint:Boolean=false,
										   pmax:uint=1):Boolean
		{
			var num:Number=val is Number ?val:Number(val);
			var numstr:String=val is Number ?val..toString():val;
			var hasPoint:Boolean=numstr.indexOf('.')!=-1?true:false;
			if(isNaN(num))
			{
				Alert.show(title+"值不是一个数字！","系统提示");
				return false;
			}
			if(num<min||num>max)
			{
				Alert.show(title+"值不能小于"+min+"或大于"+max+"！","系统提示");
				return false;
			}
			if(hasPoint&&!isPoint)
			{
				Alert.show(title+"值不能含有小数位！","系统提示");
				return false;
			}
			if(isPoint&&hasPoint)
			{
				var length:int=(numstr.substring(numstr.indexOf('.')+1)).length;
				if(length>pmax)
				{
					Alert.show(title+"值小数位个数不能大于"+pmax+"！","系统提示");
					return false;
				}
			}
			return true;
		}
		
		//反射得到对象的属性  FlexGlobals.topLevelApplication
//		var properties:XMLList = describeType(vl306).accessor;
//		trace(properties.toString());
//		for each(var propertyInfo:XML in properties)  
//		{  
//			var propertyName:String = propertyInfo.@name; 
//			trace(vl306[propertyName]);
//		} 
	}
}