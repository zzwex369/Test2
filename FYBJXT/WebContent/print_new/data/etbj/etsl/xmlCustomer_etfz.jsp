<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>
<%
 //  System.out.println(">>>>>>>>>>");
	String sql = "select E701_01,E701_02,E701_03,E701_04,E701_05,E701_06,E701_07,E701_08,E701_09,E701_10,"+
	"E701_11,E701_12,E701_13,E701_14,E701_15,E701_16,E701_17,E701_18,E701_19,E701_20,"+
	"E701_21,E701_22,E701_23,"+
	"E701_30,E701_31,E701_32,E701_33,E701_34,E701_35,"+
	"E70107_ZH,E70110_ZH,E70111_ZH,E70114_ZH,E70118_ZH,E70122_ZH,E70131_ZH,E70135_ZH,E70115_ZH,E70116_ZH,"+
	"E702_01,E702_02,E702_03,E702_04,E702_04ZH,E702_05,E702_06,E702_07,E702_08,E702_09,E702_10,"+
	"E702_11,E702_12,E702_13,E702_14,E702_15,E702_16,E702_17,E702_18,E702_19,E702_20,"+
	"E702_21,E702_22,E702_23,E702_24,E702_25,E702_26,E702_27,E702_28,E702_29,E702_30,"+
	"E702_31,E702_32,E702_33,E702_34,E702_35,E702_36,E702_37,E702_38,E702_39,E702_40,"+
	"E702_41,E702_42,E702_43,E702_44,E702_45,E702_46,E702_47,E702_48,E702_49,E702_50,"+
	"E702_51,E702_52,E702_53,E702_54,E702_55,E702_56,E702_57,E702_58,E702_59,E702_60,"+
	"E702_61,E702_62,E702_63,E702_64,E702_65,E702_66,E702_67,E702_68,E702_69,E702_70,"+
	"E702_71,E702_72,E702_73,"+
	"E703_16,E703_18,E703_22,E703_25,"+
	"E702_08ZH,E702_09ZH,E702_60ZH,E702_61ZH,E702_68ZH,E702_71ZH,"+
	"E703_16ZH,E703_22ZH,"+
	"E703_25ZH,la_02  from"+
	" v_e702 t,LA302_03 l where t.e702_66 = l.la_01(+) and t.e702_01='"+ request.getParameter("e70201")+"'"; 
   //System.out.println(sql);

%>
<%
XML_GenOneRecordset(response,sql);
%>