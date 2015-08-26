<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员编辑</title>
</head>
<div class="easyui-layout" data-options="fit:true">	
    <form action="<%=basePath%>zdryEdit/zdryZL"  id="dataForm" name="dataForm" method="post">     
    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdryVO.zdryZdryzb.id}" />    	    	
    	<input type="hidden" id="yzdrylbmc" name="yzdrylbmc" value="${zdryVO.zdryZdryzbVO.zdrylbmc}" />    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" style="width:200px;" readonly="readonly"  value="${zdryVO.zdryZdryzbVO.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" style="width:200px;" readonly="readonly" value="${zdryVO.zdryZdryzbVO.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员管理类型：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		${zdryVO.zdryZdryzbVO.zdrygllxmc}
				</td>	
			</tr>
			<tr class="dialogTr"> 	
	    		<td width="20%" class="dialogTd" align="right">重点人员已列管类别：</td>
	    		<td width="30%" class="dialogTd" colspan="3">
	    			${zdryVO.zdryZdryzbVO.zdrylbmc}
		    	</td>
		    </tr>
		    
		    <tr class="dialogTr"> 		    	
	    		<td width="20%" class="dialogTd" align="right">重点人员转类类别：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    			<c:if test="${sfkzl }">
		    			<input type="text" name="zdryZdryzb.zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:400px;"
		    			data-options="onlyLeaf:true,valueField:'lbdm',textField:'bz',
		    			multiple:false,required:true,panelWidth:400,method:'get',lines:true,tipPosition:'left'" />
	    			</c:if>
		    		<c:if test="${!sfkzl }">
		    			<c:if test="${ glzt == '7' }">
		    				<font color="red">该 重点人员正在转类申请中，不可转类</font>
		    			</c:if>
		    			<c:if test="${ glzt != '7' }">
		    				<font color="red">该 重点人员管理类型 不可转类</font>
		    			</c:if>
		    		</c:if>		    		
		    	</td>
		    </tr>
		    
		    </table> 		
	    		    	
	    </div>
    </form>
    
</div>
<script type="text/javascript" >

var zdrylb='${zdryVO.zdryZdryzb.zdrylb}';
var sfkzl=${sfkzl};
function doInit(paramArray) {	
	zdrylxChange('${zdryVO.zdryZdryzb.zdrygllxdm}');
}

function beforeSubmit() {
	if(sfkzl){//可转类	
		if(zdrylb==$("#zdrylbStr").val()){
			alert("不可转换为已列管类型");
			return false;
		}
	}else{
		alert("该类型不可转类");
		return false;
	}
}

function afterSubmit() {
	parent.location.reload();
}

function zdrylxChange(newVal){

	if(typeof(newVal)!="undefined"){
		setInputReadonly("zdrylbStr", true);	
		$('#zdrylbStr').combotree('tree').tree('loadData', ['']);
		var strAry=newVal.split('/');
		var lbdm_p=strAry[0];
		var group=strAry[1];
		
		$.ajax({
			async:false,
			type:"GET",
			url:"<%= basePath%>zdryzb/queryZdryChildLbList",
			dataType:"json",
			data:"lbdm_p="+lbdm_p,
			success:function(data){
				if (data && data.length>0) {
					setInputReadonly("zdrylbStr", false);
					$('#zdrylbStr').combotree('tree').tree('loadData', data);
				}else{				
					$('#zdrylbStr').combotree('tree').tree('loadData', ['']);
				}				
			}
		}); 
			
	}
				
				
}
</script>
</html>