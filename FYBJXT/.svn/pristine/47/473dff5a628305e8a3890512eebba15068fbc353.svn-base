<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
<title>妊娠图</title>  <!--  http://localhost:7002/fybjxt/chart/echarts_line.jsp -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/esl.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>  
</head>
  
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="main" style="height:400px;width:950px"></div>
  
  
    <script type="text/javascript" language="javascript">
        var myChart;
        var eCharts;
  
        require.config({
            paths : {
                'echarts' : '../js/echarts' ,
                'echarts/chart/line' : '../js/echarts' //需要的组件
            }
        });
  
        require(
            [ 'echarts',
              'echarts/chart/line'
            ],
            DrawEChart //异步加载的回调函数绘制图表
        );
  
        //创建ECharts图表方法
        function DrawEChart(ec) {
            eCharts = ec;
            myChart = eCharts.init(document.getElementById('main'));
            myChart.showLoading({
                text : "图表数据正在努力加载..."
            });
            //定义图表options
            var options = {
                title : {
                    text : "妊娠图",
                    subtext : "产妇姓名",
 //                   sublink : "http://www.baidu.com"
                },
                tooltip : {
                    trigger : 'axis'
                },
                legend : {
                    data : [ "宫高上限", "实际宫高", "宫高下限" ]
                },
                toolbox : {
                    show : true,
                    feature : {
                        mark : {
                            show : true
                        },
                        dataView : {
                            show : true,
                            readOnly : false
                        },
                        magicType : {
                            show : true,
                            type : [ 'line', 'bar' ]
                        },
                        restore : {
                            show : true
                        },
                        saveAsImage : {
                            show : true
                        }
                    }
                },
                calculable : true,
                xAxis : [ {
                    type : 'category',
                    boundaryGap : false,  
                    data : [ '25周', '30周', '35周', '40周' ]
                } ],
                yAxis : [ {
                    type : 'value',
                    axisLabel : {
                        formatter : '{value} cm'
                    },
                    splitArea : {
                        show : true
                    }
                } ],
                grid : {
                    width : '90%'
                },
                series : [ 
                {
                    name : '宫高上限',
                    type : 'line',
                    data : [ 25, 29, 35, 37 ]//必须是Integer类型的,String计算平均值会出错  
                },
                {
                    name : '实际宫高',
                    type : 'line',
                    data : [ 22, 26, 31, 33 ]//必须是Integer类型的,String计算平均值会出错  
                },
                {
                    name : '宫高下限',
                    type : 'line',
                    data : [ 19, 23, 27, 29 ]//必须是Integer类型的,String计算平均值会出错  
                }]
            };
            myChart.setOption(options); //先把可选项注入myChart中
            myChart.hideLoading();
            getChartData();//ajax后台交互 
        }
    </script>
  
  
    <script type="text/javascript">
        function getChartData() {
            //获得图表的options对象
            var options = myChart.getOption();
            //通过Ajax获取数据
            $.ajax({
                type : "post",
                async : false, //同步执行
                url : "${pageContext.request.contextPath}/echarts.do?name='aaa'",
                data : {},
                dataType : "json", //返回数据形式为json
                scriptCharset: 'utf-8',
                success : function(result) {
                    if (result) {
                    	//result = encodeURI(encodeURI(result)); 
                        options.legend.data = result.legend;
                        options.xAxis[0].data = result.category;
                        options.series[0].data = result.series[0].data;
                        options.series[1].data = result.series[1].data;
                        options.series[2].data = result.series[2].data;
  						//alert(result.legend);//注释......
  						//alert(result.category);//注释......
  						//alert(result.series[0].data);//注释......
  						//alert(result.series[1].data);//注释......
  						//alert(result.series[2].data);//注释......
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
</html>