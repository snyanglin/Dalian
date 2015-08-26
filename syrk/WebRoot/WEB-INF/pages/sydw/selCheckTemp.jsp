<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-11上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位检查模板选择</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>dwjcxxb/saveCheckTemp" id="dataForm" name="dataForm" method="post">
			<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
			<input type="hidden" name="dwmc" id="dwmc" value="${entity.dwmc}" />
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
					<input type="hidden" name="id" id="pk" value="${entity.id}" />
					<tr class="dialogTr" id="tr1">
						<td width="18%" class="dialogTd" align="right">单位名称：</td>
						<td width="34%" class="dialogTd">
							<input class="easyui-combobox" type="text" id="dw-box" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true"
								style="width:200px;" />
						</td>
						<td class="dialogTd" align="right" style="width:16%;white-space: nowrap;">单位类型：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
								style="width:200px;" data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:190,
								method:'get',editable:true,lines:true,required:true,tipPosition:'left'"/>
						</td>
					</tr>
					<tr class="dialogTr" id="tr1">
						<td width="18%" class="dialogTd" align="right" style="vertical-align: top;"></br>检查模板：</td>
						<td width="34%" class="dialogTd" colspan="3">
							<input type="hidden" id="url" name="url" value="dwjcxxb/add"/>
							<input type="radio" name="ywlbdm" checked value="04" openurl="dwjcxxb/add"/>治安/内保 <a class="easyui-linkbutton" url="" iconCls="icon-preview" style="margin-left:330px;" onclick="preview('04');">查看</a></br>
							<input type="radio" name="ywlbdm" value="11" openurl="dwjcxxb/addXf"/>三级消防单位 <a class="easyui-linkbutton" url="" iconCls="icon-preview" style="margin-left:312px;" onclick="preview('11');">查看</a></br>
							<input type="radio" name="ywlbdm" value="12" openurl="dwjcxxb/add"/>环保单位 <a class="easyui-linkbutton" url="" iconCls="icon-preview" style="margin-left:336px;" onclick="preview('12');">查看</a></br>
							<input type="radio" name="ywlbdm" value="13" openurl="dwjcxxb/add"/>保安单位 <a class="easyui-linkbutton" url="" iconCls="icon-preview" style="margin-left:336px;" onclick="preview('13');">查看</a></br>
							<input type="radio" name="ywlbdm" value="14" openurl="dwjcxxb/addJf"/>技防单位 <a class="easyui-linkbutton" url="" iconCls="icon-preview" style="margin-left:336px;" onclick="preview('14');">查看</a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
	var mainTabID = "${mainTabID}";
	var rwid = "${rwid}";
	function doInit(paramArray) {
		initDepartmentSearch('dw-box', {glpcsid: ''}, 'dwid', 'dwmc', null, null);
		$("input:radio").click(function(){
			$("#url").val($(this).attr("openurl"));
		});
		var lf = (window.parent.document.body.clientWidth-600)*0.5;
		var tp = (window.parent.document.body.clientHeight-300)*0.5;
		window.parent.$("#"+paramArray['windowID']).window({width:600,height:300,left:lf,top:tp});
		$("#dwmc").val(paramArray["dwmc"]);
		$("#dw-box").combobox("setText",paramArray["dwmc"]);
		$("#dwlbdm").combotree("setValue",paramArray["dwlbdm"]);
		if(paramArray["dwmc"]!=""&&paramArray["dwmc"]!=null){
			$("#tr1").find('input[type="text"]').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
				$(o).next(".combo").addClass("inputReadonly");
			});
		}
	}
	function beforeSubmit() {
		
	}

	function afterSubmit(arr) {
		var url = arr["entity"].url;
		var editUrl = basePath+url+"?dwid="+arr["entity"].dwid+"&dwlbdm="+arr["entity"].dwlbdm+"&ywlbdm="+arr["entity"].ywlbdm+"&rwid="+rwid+"&mainTabID="+mainTabID;
		window.top.openWindowWithSave(false, null, window, 
	   		{dwmc:arr["entity"].dwmc,dwlbdm:arr["entity"].dwlbdm,ywlbdm:arr["entity"].ywlbdm}, 
	   		{
	   		title: '单位检查信息',
	   		url: editUrl,
	   		width: 880,
	   		inline:true,
	   		height:500
	   		}, 
	   		null, null,null
	   	);
	}
	
	//通用预览
	function preview(ywlbdm){
		var sydwlxdm = $("#dwlbdm").combotree("getValue");
		var sydwlx = $("#dwlbdm").combotree("getText");
		if (sydwlxdm=="") {
			topMessagerAlert('', '请选择要预览的单位类型！');
			return;
		}
		var editUrl = contextPath + "/dwjctemp/queryDwjcTemp";
		var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		editUrl = editUrl + "sydwlx=" + sydwlxdm +"&ywlbdm="+ywlbdm;
		if(ywlbdm=="11"){
			editUrl = contextPath + "/forward/sydw|xfjcTemp";
		}
		window.top.datagridView('dg', 'itemWindow', 
	   		null,
	  		{
	   		title: '单位检查模板预览：' + sydwlx,
	   		url: editUrl,
	   		width: 700,
	   		height: 520,
	   		inline:true
	   		}
		);
	}
</script>

