<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>待办任务列表</title>
</head>
<body class="easyui-layout" data-options="fit:true" > 
		
	 <div data-options="region:'center',border:false" style="height: 200px">
	  <form action="<%=basePath%>dbrwRwcl/saveFk" id="dataForm" name="dataForm" method="post">
	  	<br/><br/>
	  	
	  	<input type="hidden" id="id" name="id"  value="${entity.id}"/>
	  	<input type="hidden" id="dbrwid" name="dbrwid"  value="${entity.dbrwid}"/>
	  	<input type="hidden" id="dbfklxdm" name="dbfklxdm"  value="${entity.dbfklxdm}"/>
	  	
	 	<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	 	
	 	
			 <tr class="dialogTr">
							<td width="15%" class="dialogTd" align="right">反馈内容：</td>
							<td width="85%" class="dialogTd" colspan="3"><textarea name="dbfknr" id="dbfknr" maxlength="200" class="easyui-validatebox" 
								style="width: 613px; height:68px;"   >${entity.dbfknr}</textarea>
							</td>
			</tr>
			
			<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">数据处理人：</td>
							<td width="30%" class="dialogTd" >
								<input type="text" name="sjclr" id="sjclr" class="easyui-validatebox inputreadonly" 
							 	 	style="width: 205px;" value="${entity.sjclr}" readonly="readonly"/>
							</td>
							
							<td width="20%" class="dialogTd" align="right">数据处理时间：</td>
							<td width="30%" class="dialogTd">
										<input type="text" name="sjclsj" id="sjclsj" class="easyui-validatebox inputreadonly" 
							 	 			style="width: 205px;" value="${fn:substring(entity.sjclsj,0,10)}" readonly="readonly"/>
							</td>
			</tr>
		 
		 </table>
		 </form>
	 </div>
</body>



<script type="text/javascript">

$(function(){
	var dbfklxdm = $("#dbfklxdm").val();
	if(dbfklxdm == "1"){
		formReadonly("dataForm", true);
	}
});



function doInit(paramArray) {
	_p = paramArray["_p"];
}


function beforeSubmit() {
	
}


function afterSubmit(arr) {
		
}

</script>  

</html>