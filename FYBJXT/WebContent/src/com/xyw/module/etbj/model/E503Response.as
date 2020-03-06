// ActionScript file
package com.xyw.module.etbj.model
{
	import com.xyw.sys.model.MessageResponse;
	
	import mx.collections.ArrayCollection;
	/**
	 * @author libo
	 * 创建时间：Jun 17, 2017 11:44:51 AM
	 */
	[Bindable]
	[RemoteClass(alias="com.xyw.medical.etbj.model.E503Response")]
	public class E503Response  extends MessageResponse
	{
		public  var e50301:Number;
		public  var e502:E503;
		public  var  ve503:ArrayCollection;
		public  var  rowCount:Number;
		public  var  state:Boolean;
		
	}