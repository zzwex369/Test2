<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>早孕建册率</title>
<!--  http://localhost:7002/fybjxt/chart/echarts_pie.jsp -->
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/esl.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
</head>
<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div style="height: 400px; width: 980px;">
		<div id="main" style="height: 400px; width: 650px; float:left"></div>
		<div style="float:right;margin-top: 200px;width: 330px;"><img src="../image/chart_picture/fn001_zyjcl.png" /></div>
	</div>
	<input type="hidden" id="institution" value="${param.institution}"/>
	<input type="hidden" id="date_start" value="${param.date_start}"/>
	<input type="hidden" id="date_end" value="${param.date_end}"/>
	<script type="text/javascript">
	var myChart; 	
	// 路径配置
        require.config({
            paths:{ 
                'echarts' : '../js/echarts',
                'echarts/chart/pie' : '../js/echarts'
            }
        });
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/pie' // 加载饼形图用pie
            ],
            function DrawEChart(ec) {
                // 基于准备好的dom，初始化echarts图表
                myChart = ec.init(document.getElementById('main')); 
                
                var options = {
                	    title : {
                	        text: '早孕建册率',
                	        subtext: '按地区统计/按单位统计',
                	        //x:'center'
                	    },
                	    tooltip : {
                	        trigger: 'item',
                	        formatter: "{a} <br/>{b} : {c} ({d}%)"
                	    },
                	    legend: {
                	        //orient : 'vertical',
                	        //x : 'left',
                	        data:['建册人数', '未建册数']
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : true,
                	    series : [
                	        {
                	            name:'统计',
                	            type:'pie',
                	            radius : '55%',
                	            center: ['50%', '60%'],
                	            data:[
                	                {value:350, name:'建册人数'},
                	                {value:50, name:'未建册数'}
                	            ]
                	        }
                	    ]
                };
                // 为echarts对象加载数据 
                myChart.setOption(options); 
                myChart.hideLoading();
                getChartData();//ajax后台交互
            }
        );
    </script>
	<script type="text/javascript">
        function getChartData() {
        	var institution = document.getElementById("institution").value;
        	var date_start = document.getElementById("date_start").value;
        	var date_end = document.getElementById("date_end").value;
            //获得图表的options对象
            var options = myChart.getOption();
            //通过Ajax获取数据
            $.ajax({
                type : "post",
                async : false, //同步执行
                url : "${pageContext.request.contextPath}/echarts_pie.do?institution=" + institution + "&date_start=" + date_start + "&date_end=" + date_end,
                data : {},
                dataType : "json", //返回数据形式为json
                scriptCharset: 'utf-8',
                success : function(result) {
                    if (result) {
                    	//result = encodeURI(encodeURI(result)); 
                        options.legend.data = result.legend;
                        options.series[0].data = result.series[0].data;
  						//alert(result.legend);//注释......
  						//alert(result.series[0].data);//注释......
                        myChart.hideLoading();
                        myChart.setOption(options);
                    }
                },
                error : function(errorMsg) {
                    alert("不好意思，图表请求数据失败啦!");
                    myChart.hideLoading();
                }
            });
        }
    </script>
</body>