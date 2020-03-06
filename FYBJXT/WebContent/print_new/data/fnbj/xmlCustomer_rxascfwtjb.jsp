<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
String date_start=request.getParameter("date_start");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
StringBuffer sql = new StringBuffer("select count(t.L402_01)  as 总数 ,");
sql.append("count(case when t.l402_13 ='1' then '以前接受过检查' end) as 以前接受过检查,");
sql.append("count(case when t.l402_148 is not null then '结案人数' end) as 结案人数,");
sql.append("count(case when t.l402_148 is not null and t.l402_84 is not null then '彩超实查人数' end) as 彩超实查人数,");
sql.append("count(case when t.l402_148 is not null and (t.l402_64='1' or t.l402_82='1') then '彩超0级' end) as 彩超0级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_64='2' or t.l402_82='2') then '彩超1级' end) as 彩超1级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_64='3' or t.l402_82='3') then '彩超2级' end) as 彩超2级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_64='4' or t.l402_82='4') then '彩超3级' end) as 彩超3级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_64='5' or t.l402_82='5') then '彩超4级' end) as 彩超4级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_64='6' or t.l402_82='6') then '彩超5级' end) as 彩超5级,");
sql.append("count(case when t.l402_102 is not null and t.l402_148 is not null then 'X线实查人数' end) as X线实查人数,");
sql.append("count(case when t.l402_148 is not null and (t.l402_87='1' or t.l402_94='1') then 'X线0级' end) as X线0级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_87='2' or t.l402_94='2') then 'X线1级' end) as X线1级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_87='3' or t.l402_94='3') then 'X线2级' end) as X线2级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_87='4' or t.l402_94='4') then 'X线3级' end) as X线3级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_87='5' or t.l402_94='5') then 'X线4级' end) as X线4级,");
sql.append("count(case when t.l402_148 is not null and (t.l402_87='6' or t.l402_94='6') then 'X线5级' end) as X线5级,");
sql.append("count(case when t.l402_148 is not null and t.l402_111='1'  then '乳腺纤维腺瘤' end) as 乳腺纤维腺瘤,");
sql.append("count(case when t.l402_148 is not null and t.l402_111='2'  then '乳腺导管内乳头状瘤' end) as 乳腺导管内乳头状瘤,");
sql.append("count(case when t.l402_148 is not null and t.l402_111='9' and t.l402_126 not like '%乳腺增生%' then '其他' end) as 其他,");
sql.append("count(case when t.l402_148 is not null and t.l402_64 in('4','5') and (t.l402_87 in('0','3') or t.l402_82 in('4','5') or t.l402_94 in('0','3')) then '组织病理应查人数' end) as 组织病理应查人数,");
sql.append("count(case when t.l402_148 is not null and t.l402_112 in('1','2') then '不典型增生' end) as 不典型增生,");
sql.append("count(case when t.l402_148 is not null and t.l402_105='1' and t.l402_106='1' then '组织病理实查人数' end) as 组织病理实查人数,");
sql.append("count(case when t.l402_148 is not null and t.l402_112='3'then '小叶原位癌' end) as 小叶原位癌,");
sql.append("count(case when t.l402_148 is not null and t.l402_110='4'then '导管原位癌' end) as 导管原位癌,");
sql.append("count(case when t.l402_148 is not null and t.l402_113='1'then '浸润性导管癌' end) as 浸润性导管癌,");
sql.append("count(case when t.l402_148 is not null and t.l402_113='2'then '浸润性小叶癌' end) as 浸润性小叶癌,");
sql.append("count(case when t.l402_148 is not null and t.l402_127 is not null then '其他恶性肿瘤' end) as 其他恶性肿瘤,");
sql.append("count(case when t.l402_148 is not null and t.l402_110 not in('1','2') then '应分期人数' end) as 应分期人数,");
sql.append("count(case when t.l402_148 is not null and (t.l402_115='1' or t.l402_118='1') then '获得分期人数' end) as 获得分期人数,");
sql.append("count(case when t.l402_148 is not null and (t.l402_116 like '0%' or t.l402_119 like '0%') then '0期' end)  零期,");
sql.append("count(case when t.l402_148 is not null and (t.l402_116 like 'I%' or t.l402_119 like 'I%') then 'I期' end) as 一期,");
sql.append("count(case when t.l402_148 is not null and (t.l402_116 like 'IIA%' or t.l402_119 like 'IIA%') then 'IIA期' end) as IIA期,");
sql.append("count(case when t.l402_148 is not null and (t.l402_116 like 'IIB%' or t.l402_119 like 'IIB%') then 'IIB期' end) as IIB期,");
sql.append("count(case when t.l402_148 is not null and (t.l402_116 like '%III%' or t.l402_119 like '%III%') then 'III期及以上' end) as III期及以上,");
sql.append("count(case when t.l402_148 is not null and t.l402_110 in('3','4','5') and t.l402_105='1' and months_between(t.l402_121,t.l402_109)>=3  then '随访人数' end) as 随访人数,");
sql.append("count(case when t.l402_148 is not null and t.l402_122='1' then '治疗人数' end) as 治疗人数,");
sql.append("d101.d101_02,d201_ms.d201_04, '"+date_start+"' as date_start,'"+date_end+"' as date_end from  L402 t,d101  d101,d201_ms d201_ms ");
sql.append("where to_char(t.L402_125,'yyyy-mm-dd')>= '"+date_start+"' and to_char(t.L402_125,'yyyy-mm-dd')<='"+date_end+"' and t.L402_44 is not null and t.L402_84 is not null ");
sql.append("and t.L402_123 like '"+institution+"%' and d101.d101_01=t.L402_123 and substr(t.l402_123,1,6)=d201_ms.d201_01 ");
sql.append("group by d101.d101_02,d201_ms.d201_04,d201_ms.d201_01 order by d201_ms.d201_01");

//System.out.println(sql.toString());
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>
