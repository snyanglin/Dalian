<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
</head>

<body>
	
	<table width="100%" cellpadding="0" cellspacing="0" border="0"><tr>
	<td align="left">
		<input style="width:200px;" class="easyui-combobox" id="search" name="search"
				data-options="mode:'remote',method:'post',panelHeight: 22,
					valueField:'id',textField:'text',selectOnNavigation:false">
		<input type="button" value="取值" onclick="getSearchID()"/>
	</td>
	</tr>
	</table>
    
   	
<script type="text/javascript">

$('#search').combobox({
	url: '<%=basePath%>jlx/search',
	loader: function(param, success, error) {
		var opts = $(this).combobox('options');
		if (!opts.url) return false;
		if (!param.q || param.q == "") {
			var data = [];
			success(data);
			return;
		}
		$.ajax({
			type: opts.method,
			url: opts.url,
			data: param,
			dataType: 'json',
			success: function(data) {
				opts.loaded = true;
				success(data);
			},
			error: function() {
			}
		});
	},
	onLoadSuccess: function() { 
	},
	filter: function(q, row) {
		return true;
	},
	formatter: function(row) {
		var opts = $(this).combobox('options');
		if (opts.maxValueLength == 0) { // 自动调整宽度与高度
			var data = $(this).combobox('getData');
			var optionTextMaxLen = 0; // text的最大长度
			for (var i = 0; i < data.length; i++){
				var tempRow = data[i];
				var sLen = getGBLength(tempRow[opts.textField]);
				if (sLen > optionTextMaxLen) {
					optionTextMaxLen = sLen;
				}
			}
			opts.maxValueLength = 1;
			autoPanelWidth = (optionTextMaxLen + 8) * 6;
			autoPanelWidth = autoPanelWidth < opts.width ? opts.width : autoPanelWidth;
			var autoPanelHeight = data.length;
			if (data.length > 10) {
				autoPanelHeight = 10;
			}
			else if (autoPanelHeight < 2) {
				autoPanelHeight = 2;
			}
			var itemHeight = 20;
			if (IE && IE_VERSION <= 9) {
				itemHeight = 18;
			}
			$(this).combo('panel').panel('resize',{width:autoPanelWidth ,height: autoPanelHeight * itemHeight + 2});	
		}
		return row[opts.textField];
	},
	loadFilter: function(data) {
		return data;
	}
});

function getSearchID() {
	var selectID = document.getElementById('search').value;
	alert(selectID);
}

</script>
  
</body>
</html>