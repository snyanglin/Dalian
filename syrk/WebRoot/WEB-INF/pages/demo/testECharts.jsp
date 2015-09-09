<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="ECharts">
    <meta name="author" content="zhang_guoliang@founder.com">
	<title>echarts例子</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/jquery1.11.min.js"></script>
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
	<script type="text/javascript" src="<%=request.getContextPath()%>/common/echarts/html5shiv.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/common/echarts/respond.min.js"></script>
    <![endif]-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/common/echarts/echarts-all.js"></script>
	<script type="text/javascript">
	$(function(){
		//基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('main'));
		var option = {
			tooltip : {
				show : true
			},
			legend : {
				data : [ '销量' ]
			},
			xAxis : [ {
				type : 'category',
				data : [ "衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子" ]
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				"name" : "销量",
				"type" : "bar",
				"data" : [ 5, 20, 40, 10, 10, 20 ]
			} ]
		};
		//为echarts对象加载数据 
		myChart.setOption(option);
		window.onresize = myChart.resize;
	});
	</script>
</head>
<body>
	<div id="main" style="height:400px;width: 100%;"></div>
</body>
</html>