<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
			String f60103 = request.getParameter("f60103");
	 		String f60104 = request.getParameter("f60104");
	 		String f60109 = request.getParameter("f60109");
	 		String f60129 = request.getParameter("f60129");
	 		String f60141 = request.getParameter("f60141");
	 		String f60144 = request.getParameter("f60144");
	 		String f60155 = request.getParameter("f60155");
	 		String f60156 = request.getParameter("f60156");
	 		String f60163 = request.getParameter("f60163");
	 		String timeStr = request.getParameter("timeStr");
	 		String timeEnd = request.getParameter("timeEnd");
	 		String timeTag = request.getParameter("timeTag");
	 		String status = request.getParameter("status");
	 		String a = request.getParameter("a");
	 		String b = request.getParameter("b");
	 		String c = request.getParameter("c");
	        StringBuffer sql=new StringBuffer("select t.f601_03 as 姓名 ,t.f601_04 as 身份证号," +
				"t.f601_09 联系方式,t.f601_10 as 采血日体重,t.f601_18||'周'||t.f601_38||'天' as 孕周," +
				"t.f601_26 as 采血日期,t.f601_27 as 采血人,a.d101_02 as 采血单位,t.f601_33 as 录入人," +
				"t.f601_34 as 录入时间,c.z_02 as 收费方式,t.f601_55 条码号,b.d201_05 as 户口地址," +
				"t.f601_57 as 邮件日期 ,e.z_02 as 状态 ,t.f601_60 as 标本审核日期,t.f601_71 as 报告日期 ," +
				"t.f601_70 as 报告人,d.d101_02 报告单位 from f601 t ,d101 a ,d201_ms b,z501_07 c,d101 d," +
				"z601_02 e,f602 f  where t.f601_29=a.d101_01(+) and t.f601_56=b.d201_01(+) and t.f601_41=c.z_01(+) " +
				"and t.f601_73=d.d101_01(+) and t.f601_59=e.z_01(+) and t.f601_01=f.f602_02(+) ");
		if("2".equals(status)){
			if(!"".equals(f60103))
				sql.append(" and t.f601_03='"+f60103+"'");//姓名
			if(!"".equals(f60104))
				sql.append(" and t.f601_04='"+f60104+"'");//身份证号
			if(!"".equals(f60109))
				sql.append(" and t.f601_09='"+f60109+"'");//联系方式
			if(!"".equals(f60155))
				sql.append(" and t.f601_55='"+f60155+"'");//条码号		
		}else{
		//单位
			if(!"".equals(f60129)||!"".equals(f60163)){
				String param=f60129;
				String tag="t.f601_29";
				if(!"".equals(f60163)){
					param=f60163;
					tag="t.f601_63";
				}
				 if (param.length() == 14) {
					sql.append(" and "+tag+"= '");
					sql.append(param);
					sql.append("'");
				} else {
					sql.append(" and "+tag+" like '");
					sql.append(param);
					sql.append("%'");
				}
			}
			
			//地址
			if(!"".equals(f60144)||!"".equals(f60156)){
				String param=f60144;
				String tag="t.f601_44";
				if(!"".equals(f60156)){
					param=f60156;
					tag="t.f601_56";
				}
				 if (param.length() == 12) {
					sql.append(" and "+tag+"= '");
					sql.append(param);
					sql.append("'");
				} else {
					sql.append(" and "+tag+" like '");
					sql.append(param);
					sql.append("%'");
				}
			}
			
			if(a!=null){
				sql.append(" and f.f602_16 like '%"+a+"%'");
			}
			if(b!=null){
				sql.append(" and f.f602_18 like '%"+b+"%'");
			}
			if(c!=null){
				sql.append(" and f.f602_22 like '%"+c+"%'");
			}
			
			if(!"0".equals(f60141))
				  sql.append(" and t.f601_41='"+f60141+"'");//收费方式
			 sql.append(" and "+timeTag+">=to_date('"+timeStr+"','yyyy-mm-dd')");//日期
			 sql.append(" and "+timeTag+"<=to_date('"+timeEnd+"','yyyy-mm-dd')");//日期
			
		}
	//System.out.println(sql);

%>

<%
XML_GenOneRecordset(response,sql.toString());
%>
