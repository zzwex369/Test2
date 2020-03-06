// ActionScript file
package com.xyw.sys.custom.component
{
	import flash.utils.describeType;
	
	import mx.controls.Alert;
	
	public class ClearText1
	{
		public function ClearText1()
		{
		}
		public function _clearText(...args):void
		{
			var obj:Object=args[0];
			var objId:String;
			var boolean:Boolean=false;
			if(args.length>1)
			{
				objId=args[1];
				boolean=true;
			}	//将当前页面解析成xml
			var instanceInfo:XML = describeType(obj);
			var textInputs:XMLList = instanceInfo.accessor.(@type=="spark.components::TextInput");
			var dateFields:XMLList = instanceInfo.accessor.(@type=="mx.controls::DateField");
			// 遍历TextInput信息
			for each(var textInputInfo:XML in textInputs) {
				// 获取TextInput的id
				var textInputName:String = textInputInfo.@name;
				if(textInputName == "e301_23"){
					obj[textInputName].text=0;				
				}else if(textInputName == "e301_22"){
					obj[textInputName].text=0;					
				}else{
					obj[textInputName].text="";				
				}
			}
			if(boolean)
			{
				for each(var dateFieldInfo:XML in dateFields) {
					// 获取日期的id
					var dateFieldName:String = dateFieldInfo.@name;
					if(objId!=dateFieldName)
					{
						obj[dateFieldName].text="";
					}
				}
			}
		}
	}
}