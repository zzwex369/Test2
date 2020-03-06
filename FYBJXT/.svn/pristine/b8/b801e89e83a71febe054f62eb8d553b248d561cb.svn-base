<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
String date_start=request.getParameter("date_start");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
StringBuffer sql = new StringBuffer();
sql.append("select count(t.L302_01) as 检查人数,");
sql.append("count(case when  t.L302_16 ='1' then '以前接受过宫颈癌检查的人数' end )as 以前人数,");
sql.append("count(case when  t.L302_132 is not null then '结案人数' end )as 结案人数,");
sql.append("count(case when  t.L302_101 ='1' and t.L302_132 is not null then '正常人数' end )as 正常人数,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_76  is not null then '巴氏分级报告人数' end )as 巴氏分级报告人数,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_73>='3'  then '巴氏分级IIB' end )as 巴氏分级IIB,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_76  is not null then '宫颈细胞学报告人数' end )as 宫颈细胞学报告人数,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='3'  then '不典型鳞状上皮细胞' end )as 不典型鳞状上皮细胞,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='3'  then '不除外高度鳞状上皮内病变' end )as 不除外高度鳞状上皮内病变,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='4'  then '低度鳞状上皮内病变' end )as 低度鳞状上皮内病变,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='5'  then '高度鳞状上皮内病变' end )as 高度鳞状上皮内病变,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='6'  then '鳞状细胞癌' end )as 鳞状细胞癌,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='7'  then '不典型腺上皮细胞' end )as 不典型腺上皮细胞,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='8'  then '不典型颈管腺细胞倾向瘤变' end )as 不典型颈管腺细胞倾向瘤变,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='9'  then '颈管原位癌' end )as 颈管原位癌,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_74='10'  then '腺癌' end )as 腺癌,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_82  is not null then '醋酸碘染色实查人数' end )as 醋酸碘染色实查人数,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_79='2' or t.L302_80='2') then '醋酸碘染色异常可疑' end )as 醋酸碘染色异常可疑,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_74='2' or t.L302_73>='3'or t.L302_79='2' or t.L302_80='2' or t.L302_34 in('3','6') or t.L302_36 in('3','6') ) then '阴道镜检查应查人数' end )as 阴道镜检查应查人数,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_92  is not null then '阴道镜检查实查人数' end )as 阴道镜检查实查人数,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_89='2' then '阴道镜检查异常可疑' end )as 阴道镜检查异常可疑,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_27='1' or t.L302_56='2' or t.L302_102 in('6','7','8','9','10','11','12')) then '生殖道感染总人数' end )as 生殖道感染总人数,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_28 like '%滴虫%阴道炎%'or t.L302_57='2' or t.L302_102='6' ) then '滴虫性阴道炎' end )as 滴虫性阴道炎,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_28 like '%细菌%阴道炎%'or  t.L302_57='4' or t.L302_102='8' ) then '细菌性阴道炎' end )as 细菌性阴道炎,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_28 like '%酵母菌%'or  t.L302_57='3' or t.L302_102='7'  ) then '外阴阴道假丝酵母菌病' end )as 外阴阴道假丝酵母菌病,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_57='1' or t.L302_102='9' ) then '外生殖器尖锐湿疣' end )as 外生殖器尖锐湿疣,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_57='5' or t.L302_102='11' ) then '黏液脓性宫颈炎' end )as 黏液脓性宫颈炎,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_57='6' or t.L302_102='12') then '宫颈息肉' end )as 宫颈息肉,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_57='9' then '阴道镜其他' end )as 阴道镜其他,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_56='7' or t.L302_102='10') then '子宫肌瘤' end )as 子宫肌瘤,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_102='14' then '其他良性疾病' end )as 其他良性疾病,");
sql.append("count(case when  t.L302_132 is not null  and (t.L302_79='2' or t.L302_80='2' or t.L302_90='3') then '组织病理应查' end )as 组织病理应查,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_98 is not null then '组织病理实查' end )as 组织病理实查,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_102='1' then '低级别鳞状上皮内病变' end )as 组织低级别鳞状上皮内病变,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_102='2' then '高级别鳞状上皮内病变' end )as 组织高级别鳞状上皮内病变,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_102='3' then '原位腺癌' end )as 原位腺癌,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_102='4' then '微小浸润癌' end )as 微小浸润癌,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_102='5' then '浸润癌' end )as 浸润癌,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_102='13' then '其他恶性肿瘤' end )as 其他恶性肿瘤,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_108='1' and t.L302_108 in('2','3','4','5') and months_between(t.L302_114,t.L302_107)>=3 then '随访人数' end )as 随访人数,");
sql.append("count(case when  t.L302_132 is not null  and t.L302_109='1' then '治疗人数' end )as 治疗人数,");
sql.append("d101.d101_02,d201_ms.d201_04, '"+date_start+"' as date_start,'"+date_end+"' as date_end from  L302 t,d101  d101,d201_ms d201_ms ");
sql.append("where to_char(t.L302_120,'yyyy-mm-dd')>='"+date_start+"' and to_char(t.L302_120,'yyyy-mm-dd')<='"+date_end+"' ");
sql.append("and t.L302_59 is not null and (t.L302_76 is not null or t.L302_82 is not null) ");
sql.append("and t.L302_118 like '"+institution+"%' and d101.d101_01=t.L302_118 and substr(t.L302_118,1,6)=d201_ms.d201_01 ");
sql.append("group by d101.d101_02,d201_ms.d201_04,d201_ms.d201_01 order by d201_ms.d201_01");

%>
<%
XML_GenOneRecordset(response,sql.toString());
%>
