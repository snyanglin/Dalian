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
    	<input type="hidden" id="id" name="id" value="${zdryZb.id}" />    	    	

	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" style="width:200px;" readonly="readonly"  value="${zdryZb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" style="width:200px;" readonly="readonly" value="${zdryZb.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员类型：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox inputreadonly" type="text" style="width:250px;" readonly="readonly"  value="${zdrylxmc}"/>			    		    		
				</td>	
			</tr>					    
		    <tr class="dialogTr"> 		    	
	    		<td width="20%" class="dialogTd" align="right">重点人员转类类别：</td>
	    		<td width="80%" class="dialogTd" colspan="3">	    			
		    			<input type="text" name="zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:390px;"
	    			data-options="onlyLeaf:true,valueField:'id',textField:'text',
	    			multiple:false,required:true,panelWidth:400,method:'get',lines:true,tipPosition:'left'" >	
		    	</td>
		    </tr>
		    
		    </table> 		
	    		    	
	    </div>
    </form>
    
</div>
<script type="text/javascript" >

var zdrylb='${zdryZb.zdrylb}';
function doInit(paramArray) {	
	zdrylxChange('${zdryZb.zdrygllxdm}');
}

function beforeSubmit() {	
	if(zdrylb==$("#zdrylbStr").val()){
		alert("不可转换为已列管类型");
		return false;	
	}
}

function afterSubmit() {
	parent.location.reload();
}

function zdrylxChange(newVal){

	if(typeof(newVal)!="undefined"){
		setInputReadonly("zdrylbStr", true);	
		$('#zdrylbStr').combotree('tree').tree('loadData', '');		
		
		$.ajax({
			async:false,
			type:"GET",
			url:"<%= basePath%>zdryzb/queryZdryChildLbList",
			dataType:"json",
			data:"lbdm_p="+newVal,
			success:function(data){
				if (data && data.length>0) {
					setInputReadonly("zdrylbStr", false);
					$('#zdrylbStr').combotree('tree').tree('loadData', data);
					$('#zdrylbStr').combotree('setValue', zdrylb);
				}else{				
					$('#zdrylbStr').combotree('tree').tree('loadData', '');
				}				
			}
		}); 
			
	}		
}
</script>
</html>