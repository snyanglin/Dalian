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
   
    	<input type="hidden" id="id" name="id" value="${zdryZb.zdryZdryzb.id}" />
    	<input type="hidden" id="zdryZdryzb.id" name="zdryZdryzb.id" value="${zdryZb.zdryZdryzb.id}" />
    	<input type="hidden" id="zdryZdryzbVO.id" name="zdryZdryzbVO.id" value="${zdryZb.zdryZdryzb.id}" />
    	<input type="hidden" id="lxdh" name="zdryZdryzb.zdrylb" value="${zdryZb.zdryZdryzb.zdrylb}" />
    	<input type="hidden" id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm" value="${zdryZb.zdryZdryzb.zdrygllxdm}" />
    	
    	<input type="hidden" id="zdrylbmc" name="zdryZdryzbVO.zdrylbmc" value="${zdryVO.zdryZdryzbVO.zdrylbmc}" />    
    	<input type="hidden" id="yzdrylbmc" name="zdryZdryzbVO.zdrygllxmc" value="${zdrylxmc}" /> 
    	<input type="hidden" id="yzdrylb" name="zdryZdryzbVO.zdrylb" value="${zdryZb.zdryZdryzb.zdrylb}" />
	  	 <input type="hidden" id="xzdrylbmc" name="xzdrylbmc" />   
    	
    	
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" style="width:200px;" name="xm"readonly="readonly"  value="${zdryZb.zdryZdryzb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" style="width:200px;" name="zjhm" readonly="readonly" value="${zdryZb.zdryZdryzb.zjhm}"/></td>
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
		    			<input type="text" name="zdryZdryzb.zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:300px;"
	    			data-options="onlyLeaf:true,valueField:'id',textField:'text',
	    			multiple:false,required:true,panelWidth:400,method:'get',lines:true,tipPosition:'left'" >	
		    	</td>
		    </tr>
		 <!--    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">流程图:</td>
		    	<td width="30%" class="dialogTd" colspan="3"><a href="#" onclick="viewWorkflowDialog();">查看</a> </td>		    	
		    </tr> -->
		    
		    </table> 		
	    		    	
	    </div>
    </form>
    
</div>
<script type="text/javascript" >

var zdrylb='${zdryZb.zdryZdryzb.zdrylb}';
function doInit(paramArray) {	
	zdrylxChange('${zdryZb.zdryZdryzb.zdrygllxdm}');
}

function beforeSubmit() {	
	if(zdrylb==$("#zdrylbStr").val()){
		alert("不可转换为已列管类型");
		return false;	
	}
	var zdrylbmc=$("#zdrylbStr").combotree('getText');
	$("#xzdrylbmc").val(zdrylbmc);
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
function viewWorkflowDialog(){
	var zdrygllxdm = $("#zdrygllxdm").val();
	var processDefinitionKey =null;
	$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>wf/getProcDefId/5/" + zdrygllxdm,
		dataType:"json",
		success:function(data){
			if (data && data.length>0) {
				processDefinitionKey = data;
				var url = '/syrk/diagram/diagram/' + processDefinitionKey;
				var result=window.open(url,'_blank','modal=yes,height=600px,width=900px,resizable=yes,z-look=yes,alwaysRaised=yes'); 
				window.onfocus=function (){result.focus();};
			}else{
				alert("Workflow is not found.");
			}				
		}
	});   
	
}
</script>
</html>