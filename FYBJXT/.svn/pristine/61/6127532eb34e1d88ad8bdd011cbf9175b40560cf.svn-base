<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie6" lang="zh-cn"><![endif]-->
<!--[if IE 7 ]><html class="ie7" lang="zh-cn"><![endif]-->
<!--[if IE 8 ]><html class="ie8" lang="zh-cn"><![endif]-->
<!--[if IE 9 ]><html class="ie9" lang="zh-cn"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="" lang="zh-cn">
	<!--<![endif]-->
<html>
<head>
	<!--强制用ie8标准模式-->
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首发登记表</title>
<style type="text/css">
	@media print {
		.Noprint {
			display: none;
		}
	}
	div.Noprint {
		margin:50px;
	}
	* {
		padding:0px;
		margin:0px;
	}
	#content {
		margin-top:40px;
		width:700px;
	}
	#table1 {
		border-left:1px solid #000;
	}
	#table2 {
		border-left:1px solid #000;
		border-collapse:collapse;
	}
	table td {
		border-right:1px solid #000;
		border-bottom:1px solid #000;
		padding-top:3px;
		padding-bottom:3px;
		height:25px;
	}
	table thead {
		background:#bbb;
	}
	table {
	}
	#lookup {
		margin-top:5px;
		width:760px;
		position:relative;
		left:-10px;
	}
	#lookup_left,#lookup_right {
		float:left;
	}
	#lookup_right {
		width:720px;
	}
	.ie7 #table2 td
	{
		border: 1px solid #000;
	}
	</style>
</head>
 <body>
	<div align="center">
		<div id="content">
			<div align="center">
				<h2>《出生医学证明》首次签发登记表</h2>
			</div>
			<div>
			<div>
				<table id="table1" width="705" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<td width="705" colspan="6" align="center" style="border-top:1px solid #000"><h3>分娩信息</h3></td>
					</tr>
				</thead>
					<tr>
						<td width="100" nowrap="nowrap" align="center">产妇姓名</td>
						<td width="90" nowrap="nowrap" align="center">${requestScope.vd304.d30416}</td>
						<td width="112" nowrap="nowrap" align="center">住院病例号</td>
						<td width="403" colspan="3" nowrap="nowrap" align="center">${requestScope.vd304.d30410}</td>
					</tr>
					<tr>
						<td width="100" nowrap="nowrap" align="center">新生儿性别</td>
						<td width="90" nowrap="nowrap" align="center">${requestScope.vd304.d30403Zh}</td>
						<td width="112" nowrap="nowrap" align="center">出生时间</td>
						<td width="403" colspan="3" nowrap="nowrap" align="center">${requestScope.vd304.d30404}</td>
					</tr>
					<tr>
						<td width="100" nowrap="nowrap" align="center">出生孕周</td>
						<td width="90" nowrap="nowrap" align="center">${requestScope.vd304.d30406}<sup>+${requestScope.vd304.d30407}</sup>周</td>
						<td width="112" nowrap="nowrap" align="center">出生体重</td>
						<td width="151" nowrap="nowrap" align="center">${requestScope.vd304.d30409}克</td>
						<td width="118" nowrap="nowrap" align="center">出生身长</td>
						<td width="134" nowrap="nowrap" align="center">${requestScope.vd304.d30408}厘米</td>
					</tr>
					<tr>
						<td width="100" nowrap="nowrap" align="center">出生地点</td>
						<td width="353" colspan="3" align="center">${requestScope.vd304.d30405Zh}</td>
						<td width="118" nowrap="nowrap" align="center">医疗机构名称</td>
						<td width="134" align="center">${requestScope.vd304.d30411Zh}</td>
					</tr>
					<tr>
						<td colspan="6" style="padding:5px">
							<div align="left">
								<span> 以上内容由接生人填写，请核对正确无误后签字确认。</span>
							</div>
							<div align="right">
								<span>接生人员签字：　　　　　填表日期：　　　年　　月　　日</span>
							</div>
						</td>
					</tr>
				</table>
				</div>
				<div>
				<table width="705" cellpadding="0" cellspacing="0" id="table2">
				<thead>
					<tr>
						<td width="705" colspan="5" align="center" ><h3>新生儿姓名及父母相关信息</h3></td>
					</tr>
				</thead>
					<tr>
						<td width="190" colspan="2" nowrap="nowrap" align="center">婴儿姓名</td>
						<td width="515" colspan="3" nowrap="nowrap" align="center">${requestScope.vd304.d30402}</td>
					</tr>
					<tr>
						<td width="46" rowspan="5" nowrap="nowrap" align="center">母<br/>亲<br/>信<br/>息</td>
						<td width="144" nowrap="nowrap" align="center">姓名</td>
						<td width="112" nowrap="nowrap" align="center">${requestScope.vd304.d30416}</td>
						<td width="151" nowrap="nowrap" align="center">年龄</td>
						<td width="252" nowrap="nowrap" align="center">${requestScope.vd304.motherage}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">国籍</td>
						<td width="112" nowrap="nowrap" align="center">${requestScope.vd304.d30419Zh}</td>
						<td width="151" nowrap="nowrap" align="center">民族</td>
						<td width="252" nowrap="nowrap" align="center">${requestScope.vd304.d30420Zh}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">住址</td>
						<td width="515" colspan="3" align="center">${requestScope.vd304.d30421}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">有效身份证件类别</td>
						<td width="515" colspan="3" nowrap="nowrap" align="center">${requestScope.vd304.d30417Zh}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">有效身份证件号码</td>
						<td width="515" colspan="3" nowrap="nowrap" align="center">${requestScope.vd304.d30418}</td>
					</tr>
					<tr>
						<td width="190" colspan="2" nowrap="nowrap" align="center">结婚证编号</td>
						<td width="112" nowrap="nowrap" align="center">${requestScope.vd304.d30414}</td>
						<td width="151" nowrap="nowrap" align="center">亲子鉴定证明编号</td>
						<td width="252" nowrap="nowrap" align="center">${requestScope.vd304.d30415}</td>
					</tr>
					<tr>
						<td width="46" rowspan="5" nowrap="nowrap" align="center">父<br/>亲<br/>信<br/>息</td>
						<td width="144" nowrap="nowrap" align="center">姓名</td>
						<td width="112" nowrap="nowrap" align="center">${requestScope.vd304.d30422}</td>
						<td width="151" nowrap="nowrap" align="center">年龄</td>
						<td width="252" nowrap="nowrap" align="center">${requestScope.vd304.fatherage}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">国籍</td>
						<td width="112" nowrap="nowrap" align="center">${requestScope.vd304.d30425Zh}</td>
						<td width="151" nowrap="nowrap" align="center">民族</td>
						<td width="252" nowrap="nowrap" align="center">${requestScope.vd304.d30426Zh}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">住址</td>
						<td width="515" colspan="3" align="center">${requestScope.vd304.d30427}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">有效身份证件类别</td>
						<td width="515" colspan="3" nowrap="nowrap" align="center">${requestScope.vd304.d30423Zh}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">有效身份证件号码</td>
						<td width="515" colspan="3" nowrap="nowrap" align="center">${requestScope.vd304.d30424}</td>
					</tr>

					<tr>
						<td width="46" rowspan="3" nowrap="nowrap" align="center">领<br/>证<br/>人</td>
						<td width="144" nowrap="nowrap" align="center">姓名</td>
						<td width="112" nowrap="nowrap" align="center">${requestScope.vd304.d30428}</td>
						<td width="151" nowrap="nowrap" align="center">与新生儿关系</td>
						<td width="252" nowrap="nowrap" align="center">${requestScope.vd304.d30429Zh}</td>
					</tr>
					<tr>
						<td width="144" nowrap="nowrap" align="center">有效身份证件类别</td>
						<td width="112" nowrap="nowrap" align="center">${requestScope.vd304.d30430Zh}</td>
						<td width="151" nowrap="nowrap" align="center">有效身份证件号码</td>
						<td width="252" nowrap="nowrap" align="center">${requestScope.vd304.d30431}</td>
					</tr>
					<tr>
						<td width="659" colspan="4" align="left" style="padding:5px;">
							如果领证人不是新生儿母亲，必须提供新生儿母亲签字的委托书以及领证人本人有效身份证件原件。
						</td>
					</tr>
					<tr>
						<td width="705" colspan="5" style="padding:6px;">
							<div align="left"><h3>委托书</h3></div>
							<div align="left">
								<span>　　本人　　　　，于　　　年　　月　　日，在　　　　　　　（医院）分娩　　男　　女孩，现委托其与本人关系是：　　　　　　　身份证号是：　　　　　　　　　　　　</span>
								<span>，办理新生儿姓名为　　　　　的《出生医学证明》相关事宜。</span>
							</div>
							<div align="right">
								<span>委托人签名（产妇姓名加手印）：　　　　　委托日期：　　　年　　月　　日</span>
							</div>
						</td>
					</tr>
					<tr>
						<td width="705" colspan="5" style="padding:5px">
							<div align="left">
								以上内容由领证人填写，请核对正确无误后签字确认，并承担相应法律责任。《出生医学证明》一经签发，证件上的各项信息原则上不应变更。
							</div>
							<div align="right">
								<span>领证人签字：　　　　　填表日期：　　　年　　月　　日</span>
							</div>
						</td>
					</tr>
				</table>
			</div>
			</div>
			<div id="lookup" align="left">
				<div id="lookup_left">
					<span>注：</span>
				</div>
				<div id="lookup_right">
					<div><span>1.在本表背面粘贴《出生医学证明》存根、新生儿父母有效身份证、结婚证、亲子鉴定证明等复印件。</span></div>
					<div><span>2.所有项目要准确、字迹清楚、不能空项，若出现涂改，须由接生人或领证人签字并按红色手印确认。</span></div>
				</div>
			</div>

			<div class="Noprint" align="center">
				<OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
				<input type="button" value="执行打印" onclick='wb.execwb(6,6)' />
				<input type="button" value="打印设置" onclick="wb.execwb(8,1)"/> 
				<input type="button" value="打印预览" onclick='wb.execwb(7,1)' /> 
			</div>
		</div>
		
	</div>
 </body>
</html>