<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JeasyUI测试</title>
	</head>

	<body style="margin-top: 20px;">

	在逃人员比对：<input type="text" id="sfzh" value="210219196410175717"/>

	<input type="button" value="查询" onclick="queryOnclick()"/>

	<p/>
	
	比对结果：<textarea id="result" rows="50" cols="100"></textarea>

<script type="text/javascript">

function queryOnclick() {
	$('#result').val('正在查询中......');
	$.ajax({
		type: 'get',
		dataType: 'json',
		url: contextPath + '/provinceService/QueryEscapedCriminalByID',
		data: 'ztrysfzh=' + $('#sfzh').val(), 
		success: function(data) {
			if (data.length) {
				var sb = new StringBuffer();
				for (var i = 0; i < data.length; i++) { 
					var result = data[i];
					for (var item in result) {
						sb.append(item + " = " + result[item] + "\n");
					}
					sb.append("\n\n");
				}
				$('#result').val(sb.toString());
			}
			else {
				$('#result').val('查询无数据！');
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert("error");
		}
	});
	
}

/*
$(document).ready(function() {

	$.getJSON('http://10.78.17.238:8093/lbs?bean=QueryPersonInfoByID&content={"root":[{"condition":{"czrkgmsfhm":"210219196410175717"},"offset":"0","count":"1"}]}&callback=?',function(data) {
			alert("22");
		}
	);

});

// 辽宁省厅服务测试
$.ajax({
	//crossDomain: true,
	type: 'get',
	//async: false,
	dataType: 'jsonp',
	jsonp: 'jsonpCallback',
	jsonpCallback: QueryPersonInfoByID,
	url: 'http://10.78.17.238:8093/lbs?bean=QueryPersonInfoByID&content={"root":[{"condition":{"czrkgmsfhm":"210219196410175717"},"offset":"0","count":"1"}]}',
	success: function(data) {
		alert("1");
		var dataJson = $.parseJSON(data);
		var b = 0;
	},
	error: function(XMLHttpRequest, textStatus, errorThrown) {
		alert("error");
	}
});

function QueryPersonInfoByID(data) {
	alert("2");
}
*/

</script>

</body>
</html>