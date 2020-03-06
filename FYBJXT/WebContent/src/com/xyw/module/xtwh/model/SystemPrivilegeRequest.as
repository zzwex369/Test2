package com.xyw.module.xtwh.model
{
	import com.xyw.sys.model.SystemPrivilege;

	[Bindable]
	[RemoteClass(alias="com.xyw.sys.model.SystemPrivilegeRequest"))]
	public class SystemPrivilegeRequest
	{
		public var systemPrivilege:SystemPrivilege;
		public function SystemPrivilegeRequest()
		{
		}
	}
}