<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>
<%
 //  System.out.println(">>>>>>>>>>");

String f30105=request.getParameter("f30105");


StringBuffer sql = new StringBuffer("select ");
sql.append("wm_concat(e702_08) as e702_08 ,wm_concat(nvl(e702_60,'-1')) as e702_60,wm_concat(nvl(e702_10,'-1')) as e702_10, ");
sql.append("wm_concat(e702_22) as e702_22,wm_concat(e702_26) as e702_26,wm_concat(e702_36) as e702_36, ");
sql.append("wm_concat(e702_37) as e702_37,wm_concat(e702_34) as e702_34,wm_concat(e702_35) as e702_35, ");
sql.append("wm_concat(e702_40) as e702_40,wm_concat(e702_41) as e702_41,wm_concat(e702_42) as e702_42, ");
sql.append("wm_concat(e702_43) as e702_43,wm_concat(e702_44) as e702_44,wm_concat(e702_45) as e702_45,   ");
sql.append("wm_concat(E701_08) as e701_08,wm_concat(E70111_ZH) as e70111_zh,wm_concat(nvl(E702_07,'-1')) as e702_07, ");
sql.append("wm_concat(nvl(E70107_ZH,'-1')) as e70107_zh,wm_concat(nvl(E701_09,'')) as e701_09,wm_concat(E702_04ZH) as e702_04ZH, ");
sql.append("wm_concat(E702_05) as e702_05,wm_concat(E702_06) as e702_06,wm_concat(nvl(E70115_ZH,'-1')) as e70115_zh   from (");

sql.append("select nvl2(e702_08,'0','-1') as e702_08,e702_60,e702_10,nvl2(e702_22,'-1','-1') as e702_22,nvl2(e702_26,'-1','-1') as e702_26, nvl2(e702_36,'-1','-1') as e702_36,nvl2(e702_37,'-1','-1') as e702_37,");
sql.append("nvl2(e702_34,'-1','-1') as e702_34,nvl2(e702_35,'-1','-1') as e702_35,nvl2(e702_40,'-1','-1') as e702_40,");
sql.append("nvl2(e702_41,'-1','-1') as e702_41,nvl2(e702_42,'-1','-1') as e702_42,nvl2(e702_43,'-1','-1') as e702_43, nvl2(e702_44,'-1','-1') as e702_44,nvl2(e702_45,'-1','-1') as e702_45,   ");
sql.append("nvl(E701_08,'-1') as e701_08,nvl2(E70111_ZH,'-1','-1') as e70111_zh, E702_07, E70107_ZH, E701_09,nvl2(E702_04ZH,'-1','-1') as e702_04ZH,nvl2(E702_05,'-1','-1') as e702_05,nvl2(E702_06,'-1','-1') as e702_06, E70115_ZH from( ");

sql.append("select E305_15 as e702_08,E305_95 as e702_60,e305_88 as e702_10,e305_90 as e702_22,e305_66 as e702_26,e305_71 as e702_36,e305_69 as e702_37,e305_67 as e702_34, ");
sql.append("e305_65 as e702_35,e305_63 as e702_40,e305_61 as e702_41,e305_59 as e702_42,e305_57 as e702_43,e305_55 as e702_44,e305_53 as e702_45, ");
sql.append("f301_05 as E701_08,e305_08 as E70111_ZH,e305_02 as E702_07,e305_03_zh as E70107_ZH,e305_04 as E701_09,e305_19 as E702_04ZH,e305_27 as E702_05, ");
sql.append("e305_28 as E702_06,e305_06 as E70115_ZH from V_E305 where f301_05 = '"+f30105+"' ) union all  ");

sql.append("select nvl(e702_08,'-1') as e702_08 ,e702_60,e702_10,nvl(e702_22,'-1') as e702_22,nvl(e702_26,'-1') as e702_26, nvl(e702_36,'-1') as e702_36,nvl(e702_37,'-1') as e702_37,nvl(e702_34,'-1') as e702_34,  ");
sql.append("nvl(e702_35,'-1') as e702_35,nvl(e702_40,'-1') as e702_40, nvl(e702_41,'-1') as e702_41,nvl(e702_42,'-1') as e702_42,nvl(e702_43,'-1') as e702_43, ");
sql.append("nvl(e702_44,'-1') as e702_44,nvl(e702_45,'-1') as e702_45, ");
sql.append("nvl2(E701_08,'-1','-1') as e701_08,nvl2(E70111_ZH,'-1','-1') as e70111_zh, E702_07, E70107_ZH, E701_09,nvl2(E702_04ZH,'-1','-1') as e702_04ZH,nvl2(E702_05,'-1','-1') as e702_05,nvl2(E702_06,'-1','-1') as e702_06, E70115_ZH from ( ");

sql.append("select e304_02 as e702_08,e304_98 as e702_60,e304_78 as e702_10,e304_61 as e702_22,e304_64 as e702_26,e304_88 as e702_36,e304_89 as e702_37, ");
sql.append("e304_90 as e702_34,e304_91 as e702_35,e304_92 as e702_40,e304_93 as e702_41,e304_94 as e702_42,e304_95 as e702_43,e304_96 as e702_44, ");
sql.append("e304_84 as e702_45,f301_05 as E701_08,e304_25 as E70111_ZH,e304_03 as E702_07,e304_54 as E70107_ZH,e304_55 as E701_09,e304_35 as E702_04ZH, ");
sql.append("e304_41 as E702_05,e304_42 as E702_06,e301_09_zh as E70115_ZH from ( ");
sql.append("select e304_02,e304_98,e304_78,e304_61,e304_64,e304_88,e304_89, e304_90,e304_91,e304_92,e304_93,e304_94,e304_95,e304_96, ");
sql.append("e304_84,f301_05,e304_25,e304_03,e304_54,e304_55,e304_35,e304_41,e304_42,e301_09_zh  ");
sql.append("from V_E304 where f301_05 = '"+f30105+"' and e304_02 = '1' union all ");
sql.append("select e304_02,e304_98,e304_78,e304_61,e304_64,e304_88,e304_89, e304_90,e304_91,e304_92,e304_93,e304_94,e304_95,e304_96, ");
sql.append("e304_84,f301_05,e304_25,e304_03,e304_54,e304_55,e304_35,e304_41,e304_42,e301_09_zh ");
sql.append("from V_E304 where f301_05 = '"+f30105+"' and e304_02 = '3' union all ");
sql.append("select e304_02,e304_98,e304_78,e304_61,e304_64,e304_88,e304_89, e304_90,e304_91,e304_92,e304_93,e304_94,e304_95,e304_96, ");
sql.append("e304_84,f301_05,e304_25,e304_03,e304_54,e304_55,e304_35,e304_41,e304_42,e301_09_zh ");
sql.append("from V_E304 where f301_05 = '"+f30105+"' and e304_02 = '6' union all ");
sql.append("select e304_02,e304_98,e304_78,e304_61,e304_64,e304_88,e304_89, e304_90,e304_91,e304_92,e304_93,e304_94,e304_95,e304_96, ");
sql.append("e304_84,f301_05,e304_25,e304_03,e304_54,e304_55,e304_35,e304_41,e304_42,e301_09_zh ");
sql.append("from V_E304 where f301_05 = '"+f30105+"' and e304_02 = '8' union all ");

sql.append("select e304_02,e304_98,e304_78,e304_61,e304_64,e304_88,e304_89, e304_90,e304_91,e304_92,e304_93,e304_94,e304_95,e304_96, ");
sql.append("e304_84,f301_05,e304_25,e304_03,e304_54,e304_55,e304_35,e304_41,e304_42,e301_09_zh ");
sql.append("from V_E304 where f301_05 = '"+f30105+"' and e304_02 = '12' union all ");
sql.append("select e304_02,e304_98,e304_78,e304_61,e304_64,e304_88,e304_89, e304_90,e304_91,e304_92,e304_93,e304_94,e304_95,e304_96, ");
sql.append("e304_84,f301_05,e304_25,e304_03,e304_54,e304_55,e304_35,e304_41,e304_42,e301_09_zh ");
sql.append("from V_E304 where f301_05 = '"+f30105+"' and e304_02 = '14' union all ");

sql.append("select e304_02,e304_98,e304_78,e304_61,e304_64,e304_88,e304_89, e304_90,e304_91,e304_92,e304_93,e304_94,e304_95,e304_96, ");
sql.append("e304_84,f301_05,e304_25,e304_03,e304_54,e304_55,e304_35,e304_41,e304_42,e301_09_zh ");
sql.append("from V_E304 where f301_05 = '"+f30105+"' and e304_02 = '16' union all ");
sql.append("select e304_02,e304_98,e304_78,e304_61,e304_64,e304_88,e304_89, e304_90,e304_91,e304_92,e304_93,e304_94,e304_95,e304_96, ");
sql.append("e304_84,f301_05,e304_25,e304_03,e304_54,e304_55,e304_35,e304_41,e304_42,e301_09_zh ");
sql.append("from V_E304 where f301_05 = '"+f30105+"' and e304_02 = '18')) union all ");

sql.append("select nvl(e702_08,'-1') as e702_08 ,e702_60,e702_10,nvl(e702_22,'-1') as e702_22,nvl(e702_26,'-1') as e702_26, nvl(e702_36,'-1') as e702_36,nvl(e702_37,'-1') as e702_37,nvl(e702_34,'-1') as e702_34, ");
sql.append("nvl(e702_35,'-1') as e702_35,nvl(e702_40,'-1') as e702_40, nvl(e702_41,'-1') as e702_41,nvl(e702_42,'-1') as e702_42,nvl(e702_43,'-1') as e702_43, ");
sql.append("nvl(e702_44,'-1') as e702_44,nvl(e702_45,'-1') as e702_45,  ");
sql.append("nvl(E701_08,'-1') as e701_08,nvl(E70111_ZH,'-1') as e70111_zh, E702_07, E70107_ZH, E701_09, nvl(E702_04ZH,'-1') as e702_04ZH,nvl(E702_05,'-1') as e702_05,nvl(E702_06,'-1') as e702_06, E70115_ZH  from ( ");

sql.append("select e702_08, e702_60,e702_10,e702_22,e702_26, e702_36,e702_37,e702_34,e702_35,e702_40, e702_41,e702_42,e702_43, e702_44, e702_45,  ");
sql.append("E701_08, E70111_ZH, E702_07, E70107_ZH, E701_09, E702_04ZH, E702_05, E702_06, E70115_ZH      ");
sql.append("from V_E702 where e701_19 = '"+f30105+"' and e702_08 between '20' and '23' and E702_09 = '1' union all  ");
sql.append("select e702_08 , e702_60,e702_10,e702_22,e702_26, e702_36,e702_37,e702_34,e702_35,e702_40, e702_41,e702_42,e702_43, e702_44, e702_45,  ");
sql.append("E701_08, E70111_ZH, E702_07, E70107_ZH, E701_09,E702_04ZH, E702_05, E702_06, E70115_ZH   ");
sql.append("from V_E702 where e701_19 = '"+f30105+"' and e702_08 between '24'and '27' and E702_09 = '1'  union all ");
sql.append("select e702_08 , e702_60,e702_10,e702_22,e702_26, e702_36,e702_37,e702_34, ");
sql.append("e702_35,e702_40, e702_41,e702_42,e702_43, e702_44, e702_45,E701_08, E70111_ZH, E702_07, E70107_ZH, E701_09, E702_04ZH, E702_05, E702_06,E70115_ZH  ");
sql.append("from V_E702 where e701_19 = '"+f30105+"' and e702_08 between '28'and '31' and E702_09 = '1' union all  ");

sql.append("select e702_08 , e702_60,e702_10,e702_22,e702_26, e702_36,e702_37,e702_34, e702_35,e702_40, e702_41,e702_42,e702_43, e702_44, e702_45, ");
sql.append("E701_08, E70111_ZH, E702_07, E70107_ZH, E701_09, E702_04ZH, E702_05, E702_06,E70115_ZH  ");
sql.append("from V_E702 where e701_19 = '"+f30105+"' and e702_08 >= '32' and E702_09 = '1')) ");



   //System.out.println(sql);

%>
<%
XML_GenOneRecordset(response,sql.toString());
%>