package com.xyw.sys.custom.component
{

	/**
	 * 正则类
	 */
	public class CustomRegex
	{
		/**
		 * 通用身份证序号 1
		 */
		public static const COMMON_CARD:uint = 0x0001;
		
		/**
		 * 手机号码序号 2
		 */
		public static const CELLPHONE:uint = 0x0002;
		
		/**
		 * 验证固话号码序号 3
		 */
		public static const TELEPHONE:uint = 0x0003;
		
		/**
		 * 日期格式序号 4
		 */
		public static const DATE:uint = 0x0004;
		
		/**
		 * 通用身份证正则
		 */
		private var common_card:RegExp = /^(\d{18,18}|\d{15,15}|\d{17,17}X|\d{17,17}x)$/g;
		
		/**
		 * 手机号码
		 */
		private var cellphone:RegExp = /^1(3|4|5|6|7|8|9)\d{9}$/;
		
		/**
		 * 验证固话号码
		 */
		private var telephone:RegExp = /^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$/;
		
		
		/**
		 * 日期格式验证 YYYY-MM-DD  YYYY-MM-D YYYY-M-DD YYYY-M-D /^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/;
		 */
		private var date:RegExp = /^(19|20)\d{2}\-((0?[1-9])|(1[0-2]))\-((0?[1-9])|([1-2]\d)|3[01])$/;
		
		private  static const regexpArr:Array=["common_card","cellphone","telephone","date"];

	
	
		/**
		 * idx 正则下标  0 身份证  1 手机号 2 固定电话  3日期格式
		 * component 验证的组件或者字符串
		 * return false 不匹配  true 匹配 
		 */
		public static function testRegExp(idx:uint,component:*):Boolean
		{
			var regExp:RegExp=new CustomRegex()[regexpArr[idx-1]];
			return regExp.test(component is String?component:component.text);
		}
	}
}