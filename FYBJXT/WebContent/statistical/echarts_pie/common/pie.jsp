<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title></title>
	
	
</head>
<body style="height: 100%; margin: 0" onload='showPie()'>
	<input type="hidden" id="data" value="${param.data}" />
	<div id="container" style="height: 800px"></div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
	<script type="text/javascript">
	
  /**
	*param 数组  0饼状图高度   1 title.text 2 title.subtext 3 array
	*	
	*/
	function showPie() {
		
		var param=$("#data").val().split(',');
		$("#data").remove();
		if(!param[0])
			return ;
		$(document).attr("title",decodeURIComponent(param[1]));
		var dom = document.getElementById("container");
		dowHeight=window.getComputedStyle(dom).height;
		dom.style.height=param[0]?param[0]+'px':dowHeight;
		var myChart = echarts.init(dom);
		var option = {
			tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
			title: {
		        text: decodeURIComponent(param[1]),
		        subtext: decodeURIComponent(param[2]),
		        left: 'center',
				top:10,
		    },
		    legend: {
		        orient: 'horizontal',
				left: 'center',
		        bottom:80
		    },
		    series: [
		        {
		            name:decodeURIComponent(param[3]),
		            type:'pie',
		            radius: ['0%', param[4]],
					//selectedMode: 'single',
		            label: {
		                normal: {
		                    formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
		                    backgroundColor: '#eee',
		                    borderColor: '#aaa',
		                    borderWidth: 1,
		                    borderRadius: 4,
		                    rich: {
		                        a: {
		                            color: '#999',
		                            lineHeight: 22,
		                            align: 'center'
		                        },
		                         abg: {
		                            backgroundColor: '#333',
		                             width: '100%',
		                             align: 'right',
		                             height: 22,
		                             borderRadius: [4, 4, 0, 0]
		                         },
		                        hr: {
		                            borderColor: '#aaa',
		                            width: '100%',
		                            borderWidth: 0.5,
		                            height: 0
		                        },
		                        b: {
		                            fontSize: 16,
		                            lineHeight: 33
		                        },
		                        per: {
		                            color: '#eee',
		                            backgroundColor: '#334455',
		                            padding: [2, 4],
		                            borderRadius: 2
		                        }
		                    }
		                }
		            },
		            data:[
			                {value:param[5], name:decodeURIComponent(param[6])},
			                {value:param[7], name:decodeURIComponent(param[8])},
            			]
		        }
		    ]
		};
		if (option && typeof option === "object") {
		    myChart.setOption(option, true);
		}
	}
</script>
</body>