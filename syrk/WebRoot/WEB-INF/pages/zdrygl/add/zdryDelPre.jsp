<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>重点人员撤管</title>
</head>

<div class="easyui-layout" data-options="fit:true">

        <form action="<%=basePath%>zdryzb/saveCg"  id="dataForm" name="dataForm" method="post" >
	    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdry.id}" />
	    	<input type="hidden" id="zdrygllxdm_old"  value="${zdry.zdrygllxdm}" />	    	
    	
    	<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="${zdry.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" style="width:200px;" readonly="readonly" value="${zdry.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">已列管类型：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    			<input class="easyui-validatebox inputreadonly" type="text"  id="ylglx" style="width:200px;" readonly="readonly"  value="${zdrylxmc}"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr" id="cgyyText">
		    	<td width="20%" class="dialogTd" align="right" >撤管原因：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="cgyy" name="ywsqyy" style="width: 628px;" data-options="required:true,validType:['maxLength[100]','unnormal']" />
		    	</td>
	    	</tr>
		   <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">撤管类型：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm"   style="width:200px;" value=""
					data-options="url: contextPath +'/common/dict/BD_D_ZDRYGLLX.js',dataFilter:'${kcgStr }',  
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zdrylxChange"/>

	    			<input type="text" name="zdryZdryzb.zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:420px;"
	    			data-options="onlyLeaf:true,valueField:'id',textField:'text',
	    			multiple:false,required:false,panelWidth:400,method:'get',lines:true,tipPosition:'left'" >
	    			<!-- <A href="#" onclick="viewWorkflowDialog();">查看流程图</a> --> 	    			
		    	</td>
		    </tr>
		    
	    	
		    </table>
 			<!-- 这里引用公用列管信息模块 -->
		    <%@include file="/WEB-INF/pages/zdrygl/add/zdryLgLxInc.jsp"%>
		     <!-- 列管公共信息 -->
	    	<table id="ggDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;">
	    	
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgrqText">业务办理日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ywclsj" id="ywclsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="${blrq}" readonly="readonly" /></td>
		    	<td width="20%" class="dialogTd" align="right" id="lgrText">业务办理人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="ywblr_xm" name="ywblr_xm" style="width:200px;" value="${userName}" readonly="readonly" />
		    	</td>
	    	</tr>	    	
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="ywfqyy" name="zdryLczywblb.ywfqyy" style="width: 628px;" data-options="required:false,validType:['maxLength[100]','unnormal']" /></td>
	    	</tr>	    	
	    	</table>
	    </div>		    	
   		 </form>
</div>
	    
<script type="text/javascript" >
var mainTabID = "${mainTabID}";
var lcg="cg";//zdryLgLxInc.jsp更改类型的时候使用
var kcgStr="${kcgStr }";
$(document).ready(function(){
    if(kcgStr=="999999")//不能撤为其他类型，只能注销
    	setComboRequired("zdrygllxdm", false);
});

function beforeSubmit() {
	var obj=$("#fzxzdm").combotree("tree");
	var nodes=[];
	 nodes=obj.tree('getChecked');
	 var selectedItemArray=[];
	 if(nodes){
		 var length=0;
		 for(var i=0;i<nodes.length;i++){
			    if(!nodes[i].children){
                     length++;
				 }
			}
         if(length>5){
            alert("犯罪性质最多选择5条！");
            $("#fzxzdm").combotree("clear");
            return false;
          }
	}
	
   
}

function afterSubmit() {
	closeSelf();
	executeTabPageMethod(mainTabID, "queryButton()");
}
function viewWorkflowDialog(){
	var zdrygllxdm = $("#zdrygllxdm").val();
	var processDefinitionKey =null;
	$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>wf/getProcDefId/1/" + zdrygllxdm,
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
