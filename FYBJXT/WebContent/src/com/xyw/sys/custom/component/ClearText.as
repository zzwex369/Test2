// ActionScript file
package com.xyw.sys.custom.component
{
	import flash.utils.describeType;
	
	import mx.controls.Alert;

	public class ClearText
	{
		public function ClearText()
		{
		}
		public function _clearText(obj:Object,objId:String,boolean:Boolean=false):void
		{
			//将当前页面解析成xml
			var instanceInfo:XML = describeType(obj);
			var textInputs:XMLList = instanceInfo.accessor.(@type=="spark.components::TextInput");
			var dateFields:XMLList = instanceInfo.accessor.(@type=="mx.controls::DateField");
			// 遍历TextInput信息
			for each(var textInputInfo:XML in textInputs) {
				// 获取TextInput的id
				var textInputName:String = textInputInfo.@name;
				obj[textInputName].text="";
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