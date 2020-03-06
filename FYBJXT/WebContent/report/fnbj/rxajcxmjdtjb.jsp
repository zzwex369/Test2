<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DtdHTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie6" lang="zh-cn"><![endif]-->
<!--[if IE 7 ]><html class="ie7" lang="zh-cn"><![endif]-->
<!--[if IE 8 ]><html class="ie8" lang="zh-cn"><![endif]-->
<!--[if IE 9 ]><html class="ie9" lang="zh-cn"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="" lang="zh-cn">
<!--<![endif]-->
<html lang="en">
<head>
    <!--强制用ie8标准模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
    <!--会强制浏览器按照最新的标准去渲染-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" >
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>农村妇女乳腺癌检查项目季度统计表</title>
    <style>
        body{
            font-family:'微软雅黑', '宋体';/*统一浏览器字体*/
            padding: 0;/*清空浏览器边距*/
            margin: 0;
            /* overflow: auto;/*页面滚动条*/
        }
        div{
            /*自动居中*/
            margin: auto;
            height: auto;
            text-align:center;
            zoom:1;
        }
        table{
            width:100%;
            margin: 8px auto;
            align: center;
        }
        tr{
            height:31px;
        }
        table td{
            padding: 2px;
        }
    </style>
</head>

<body>
<div style="width: 1200px">
    <div style="width: 1200px;margin-bottom:-15px">
        <h4>农村妇女乳腺癌检查项目季度统计表</h4>
         <p style="width: 100%">
         <span style="float: left">地区或机构名称:${list[37]}</span>
 		 <span style="float: right">日期:（${list[38] } 至  ${list[39] } ）</span>      
    	</p>
      
    </div>
    <div>
    <table border="1px" cellpadding="2" cellspacing="0">
        <tr>
            <td rowspan="3">项目县<br>（区）</td>
            <td  colspan="4">检查人数</td>
            <td colspan="7">乳腺彩色超声检查结果(BI-RADS 分级)<br>（人数）</td>
            <td  colspan="7">乳腺 X 线检查结果(BI-RADS 分级)<br>（人数）</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
            <td>9</td>
            <td>10</td>
            <td>11</td>
            <td>12</td>
            <td>13</td>
            <td>14</td>
            <td>15</td>
            <td>16</td>
            <td>17</td>
            <td>18</td>
        </tr>
        <tr>
            <td width="40px">年<br>度<br>任<br>务<br>数</td>
            <td>检<br>查<br>人<br>数</td>
            <td>检查人数中既往<br>接受过宫颈癌<br>检查的人数</td>
            <td>结<br>案<br>人<br>数</td>
            <td>实<br>查<br>人<br>数</td>
            <td>0级</td>
            <td>1级</td>
            <td>2级</td>
            <td>3级</td>
            <td>4级</td>
            <td>5级</td>
            <td>实<br>查<br>人<br>数</td>
            <td>0级</td>
            <td>1级</td>
            <td>2级</td>
            <td>3级</td>
            <td>4级</td>
            <td>5级</td>
        </tr>
        <tr>
            <td>${list[37]}</td> <!--  县区-->
            <td>${list[40]}</td> <!-- 年度任务数 -->
            <td>${list[0]}</td> <!-- 检查人数 -->
            <td>${list[1]}</td> <!-- 以前接受过检查 -->
            <td>${list[2]}</td> <!-- 结案人数 -->
            <td>${list[3]}</td> <!-- 彩超实查人数 -->
            <td>${list[4]}</td> <!--  彩超0级-->
            <td>${list[5]}</td> <!-- 彩超1级 -->
            <td>${list[6]}</td> <!--  彩超2级-->
            <td>${list[7]}</td> <!--  彩超3级-->
            <td>${list[8]}</td> <!--  彩超4级-->
            <td>${list[9]}</td> <!--  彩超5级-->
            <td>${list[10]}</td> <!--  X线实查人数-->
            <td>${list[11]}</td> <!--  X线0级-->
            <td>${list[12]}</td> <!--  X线1级-->
            <td>${list[13]}</td> <!--  X线2级-->
            <td>${list[14]}</td> <!--  X线3级-->
            <td>${list[15]}</td> <!--  X线4级-->
            <td>${list[16]}</td> <!--  X线5级-->            
        </tr>
    </table>

    <table border="1px" cellpadding="2" cellspacing="0">
        <tr>
            <td rowspan="2" colspan="3">乳腺良性疾病<br>（人数）</td>
            <td rowspan="2" colspan="8">组织病理检查<br>（人数）</td>
            <td rowspan="2" colspan="7">TNM 分期<br>（人数）</td>
            <td rowspan="2" colspan="2">治疗随访情况<br>（人数）</td>
            <td rowspan="2">备注</td>
        </tr>
        <tr></tr>
        <tr>
            <td>19</td>
            <td>20</td>
            <td>21</td>
            <td>22</td>
            <td>23</td>
            <td>24</td>
            <td>25</td>
            <td>26</td>
            <td>27</td>
            <td>28</td>
            <td>29</td>
            <td>30</td>
            <td>31</td>
            <td>32</td>
            <td>33</td>
            <td>34</td>
            <td>35</td>
            <td>36</td>
            <td>37</td>
            <td>38</td>
            <td>39</td>
        </tr>
        <tr>
            <td>乳腺纤<br>维腺瘤</td>
            <td>乳腺导管内<br>乳头状瘤</td>
            <td>其<br>他</td>
            <td>应<br>查<br>人<br>数</td>
            <td>实<br>查<br>人<br>数</td>
            <td>不典型<br>增生</td>
            <td>小叶<br>原位癌</td>
            <td>导管<br>原位癌</td>
            <td>浸润性<br>导管癌</td>
            <td>浸润性<br>小叶癌</td>
            <td>其他<br>恶性<br>肿瘤</td>
            <td>应分期<br>人数</td>
            <td>获得<br>分期<br>人数</td>
            <td>0期</td>
            <td>I期</td>
            <td>IIA期</td>
            <td>IIB期</td>
            <td>III 期<br>及以上</td>
            <td>随<br>访<br>人<br>数</td>
            <td>治<br>疗<br>人<br>数</td>
            <td rowspan="2"  width="200px"></td>
        </tr>
        <tr>
            <td>${list[17] }</td> <!-- 乳腺纤维腺瘤 -->
            <td>${list[18] }</td> <!-- 乳腺导管内乳头状瘤 -->
            <td>${list[19] }</td> <!-- 其他 -->
            <td>${list[20] }</td> <!-- 组织病理应查人数 -->
            <td>${list[36] }</td> <!-- 组织病理实查人数-->
            <td>${list[21] }</td> <!--  不典型增生-->
            <td>${list[22] }</td> <!--  小叶原位癌-->
            <td>${list[23] }</td> <!--  导管原位癌-->
            <td>${list[24] }</td> <!--  浸润性导管癌-->
            <td>${list[25] }</td> <!--  浸润性小叶癌-->
            <td>${list[26] }</td> <!--  其他恶性肿瘤-->
            <td>${list[27] }</td> <!--  应分期人数-->
            <td>${list[28] }</td> <!--  获得分期人数-->
            <td>${list[29] }</td> <!--  0期-->
            <td>${list[30] }</td> <!--  I期-->
            <td>${list[31] }</td> <!--  IIA期-->
            <td>${list[32] }</td> <!--  IIB期-->
            <td>${list[33] }</td> <!--  III期及以上-->
            <td>${list[34] }</td> <!--  随访人数-->
            <td>${list[35] }</td> <!--  治疗人数-->           
        </tr>
    </table>
</div>
</div>
</body>
</html>