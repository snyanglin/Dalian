<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>上级指定列管</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdrySjzdlcg/sjzdlgSave" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="ryid" name="ryid" value="${entity.ryid }" />
    	<input type="hidden" id="dzdmStr" name="dzdmStr"/>
    	<input type="hidden" id="jzdzzbidStr" name="jzdzzbidStr"/>
	    <div data-options="region:'center', split:true" style="width:600px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">已列管类别：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    		<p id="ylglb" style="width: 574px;" align="left">${zdrylx}</p>
			    	</td>
			    </tr>
			    <tr class="dialogTr"> 
			    	<td width="20%" class="dialogTd" align="right">指定列管类型：</td>
			    	<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdrygllxdm" style="width:200px;" "
						data-options="url: contextPath +  '/common/dict/BD_D_ZDRYLBDM.js',
						valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zdrylxChange"/>
					</td>
					<td width="50%" class="dialogTd" colspan="2" align="left">
			    		<input type="checkbox" id="sfjmCheckbox" name="sfjmCheckbox"/>
			    		<input type="hidden" id="sfjm" name="sfjm"/>
			    		是否加密
			    	</td>
			    </tr>
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
		    		<td width="80%" class="dialogTd" colspan="3">
		    			<input type="text" name="zdrylbStr" id="zdrylbStr"  class="easyui-combotree" style="width:602px;"
		    			data-options="url: contextPath + '/common/dict/DL_D_ZDRYLBDM.js',onlyLeaf:true,dataFilter:'',
		    			multiple:true,required:false,panelWidth:602,
		    			method:'get',editable:true,lines:true" >
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" value="${entity.xm}" id="xm" style="width:200px;" readonly="readonly" /></td>
					<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" value="${entity.zjhm}" id="zjhm" style="width:200px;" readonly="readonly" /></td>
			    </tr>
			    <c:if test="${hjdz != null}">
				    <tr class="dialogTr">
			    		<td width="20%" class="dialogTd" align="right">户籍地址：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    		<input class="easyui-validatebox" type="text" id="dz_hjdzxz" name="dz_hjdzxz" value="${hjdz.DZXZ}" maxlength="50" 
				    			style="width: 540px;" data-options=""/>
				    		<!--  
				    		<a class="easyui-linkbutton" onclick="$('#tr_hjdz_dtl_1').toggle();$('#tr_hjdz_dtl_2').toggle();$('#text_add').toggle();$('#text_sub').toggle();"><font id="text_add">+</font><font hidden="true" id="text_sub">-</font></a>
				    		-->
				    		<c:if test="${fn:substring(hjdz.DZDM, 0, 4) != '2102'}">
				    			<input type="checkbox" id="hjdzCheckbox" name="" onclick="return false"/>
				    		</c:if>
				    		<c:if test="${fn:substring(hjdz.DZDM, 0, 4) == '2102'}">
				    			<input type="checkbox" checked="checked" id="hjdzCheckbox" name="" onclick="return false"/>
				    		</c:if>
				    	</td>
				    </tr>
				    <tr class="dialogTr" id="tr_hjdz_dtl_1">
				    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="" value="${hjdz.PCS}" style="width:200px;" readonly="readonly"/>
				    		<input type="hidden" name="ygxpcsdm" id="ygxpcsdm" value=""/>
				    	</td>
						<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxzrq" name="" value="${hjdz.ZRQ}" style="width:200px;" readonly="readonly"/>
				    		<input type="hidden" name="ygxzrqdm" id="ygxzrqdm" value=""/>	
				    	</td>
				    </tr>
				    <tr class="dialogTr" id="tr_hjdz_dtl_2">
				    	<td width="20%" class="dialogTd" align="right">管辖民警：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="" value="${hjdz.gxmj}" style="width:200px;" readonly="readonly"/>
				    		<input type="hidden"  name="ygxmjdm" id="ygxmjdm" value=""/>	
				    	</td>
						<td width="20%" class="dialogTd" align="right">联系电话：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="gxmjlxdh" name="" value="${hjdz.gxmjlxdh}" style="width:200px;" readonly="readonly" /></td>
				    </tr>
			    </c:if>
			    <c:forEach var="jzdz" begin="0" items="${jzdzList}" varStatus="status">
			    	<tr class="dialogTr">
			    		<td width="20%" class="dialogTd" align="right">现居住地址${status.index+1}：</td>
				    	<td width="80%" class="dialogTd" colspan="3">
				    		<input class="easyui-validatebox" type="text" id="dz_hjdmlpxz" name="dz_hjdmlpxz" value="${jzdz.DZXZ}" maxlength="50" 
				    			style="width: 540px;" data-options=""/>
				    		<!--  
				    		<a class="easyui-linkbutton" onclick="$('#tr_hjdz_dtl_1_${status.index}').toggle();$('#tr_hjdz_dtl_2_${status.index}').toggle();$('#text_add_${status.index}').toggle();$('#text_sub_${status.index}').toggle();"><font id="text_add_${status.index}">+</font><font hidden="true" id="text_sub_${status.index}">-</font></a>
				    		-->
				    		<input type="checkbox" id="jzdzCheckbox${status.index}" name="jzdzCheckbox${status.index}"/>
				    	</td>
			    	</tr>
			    	<tr class="dialogTr" id="tr_hjdz_dtl_1_${status.index}">
				    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxpcs" name="" value="${jzdz.PCS}" style="width:200px;" readonly="readonly"/>
				    		<input type="hidden" name="xgxpcsdm" id="xgxpcsdm" value=""/>
				    	</td>
						<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxzrq" name="" value="${jzdz.ZRQ}" style="width:200px;" readonly="readonly"/>
				    		<input type="hidden" name="xgxzrqdm" id="xgxzrqdm" value=""/>
				    	</td>
				    </tr>
				    <tr class="dialogTr" id="tr_hjdz_dtl_2_${status.index}">
				    	<td width="20%" class="dialogTd" align="right">管辖民警：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxpcs" name="" value="${jzdz.gxmj}" style="width:200px;" readonly="readonly"/>
				    		<input type="hidden"  name="xgxmjdm" id="xgxmjdm" value=""/>
				    	</td>
						<td width="20%" class="dialogTd" align="right">联系电话：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="xgxmjlxdh" name="" value="${jzdz.gxmjlxdh}" style="width:200px;" readonly="readonly" /></td>
				    </tr>
			    </c:forEach>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" id="bz" class="easyui-validatebox" style="width: 602px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${bz}</textarea></td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

var hjdzJson = eval(${hjdzJson});
var jzdzJsonList = eval('${jzdzJsonList}');
var dzdmStr = "";
var jzdzzbidStr = "";
var dzCheckedList = new Array();
function doInit(paramArray) {
	if((jzdzJsonList == undefined || jzdzJsonList.length == 0) && hjdzJson == null){
		//$('#'+paramArray['windowID']).dialog('destroy');
		alert("该人员暂无地址,无法执行列管操作!");
		return;
	}
}

function beforeSubmit() {
	if(document.getElementById('sfjmCheckbox').checked){
		$('#sfjm').val('1');
	}else{
		$('#sfjm').val('0');
	}
	if(document.getElementById('hjdzCheckbox') && document.getElementById('hjdzCheckbox').checked){
		dzdmStr += hjdzJson.DZDM;
		dzdmStr += ',';
		jzdzzbidStr += hjdzJson.JZDZZBID;
		jzdzzbidStr += ',';
		//已勾选地址
		dzCheckedList.length += 1;
		dzCheckedList[dzCheckedList.length-1] = hjdzJson;
	}
	for(var i = 0; i < jzdzJsonList.length; i++){
		if(document.getElementById('jzdzCheckbox'+i) && document.getElementById('jzdzCheckbox'+i).checked){
			dzdmStr += jzdzJsonList[i].DZDM;
			dzdmStr += ',';
			jzdzzbidStr += jzdzJsonList[i].JZDZZBID;
			jzdzzbidStr += ',';
			//已勾选地址
			dzCheckedList.length += 1;
			dzCheckedList[dzCheckedList.length-1] = jzdzJsonList[i];
		}
	}
	//无地址,不列管
	if(dzCheckedList.length < 1){
		//$('#'+paramArray['windowID']).dialog('destroy');
		alert("请选择要列管的居住地址!");
		return false;
	}
	if(dzdmStr.length > 0){
		$('#dzdmStr').val(dzdmStr.substring(0, dzdmStr.length-1));
		$('#jzdzzbidStr').val(jzdzzbidStr.substring(0, jzdzzbidStr.length-1));
	}
	
	//判断是否有一个责任区勾选多个地址
	for(i in dzCheckedList){
		if(dzCheckedList.hasOwnProperty(i)){
			var zrqdm = dzCheckedList[i].ZRQDM;
			for(var j = i+1; j < dzCheckedList.length; j++){
				if(zrqdm == dzCheckedList[j].ZRQDM){//地址所属责任区相同
					alert("同一责任区下的居住地址只能选择一个");
					return false;
				}
			}
		}
	}
}

function afterSubmit() {
	dzdmStr = "";
	jzdzzbidStr = "";
	dzCheckedList = new Array();
}

$(document).ready(function(){
	
});

function zdrylxChange(newVal,oldVal){

	if(typeof(newVal)!="undefined"){
	setInputReadonly("zdrylbStr", false);
	$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>zdryLcg/getZdrylbdmExceptYlg",
		dataType:"json",
		data:"zdrylxdm="+newVal+"&syrkid="+$("#syrkid").val(),
		success:function(data){
		if (data) {
				$('#zdrylbStr').combotree('tree').tree('setDataFilter', data);
			}else{
				setInputReadonly("zdrylbStr", true);
				$('#zdrylbStr').combotree('tree').tree('setDataFilter', "999999");
				}
		if(newVal == "1") {
			$("#jgdxDiv").show();
			$("#zdrkDiv").hide();
			$("#zszhjsbrDiv").hide();
			$("#fzcfryDiv").hide();
			$("#ggDiv").show();
			//监管类别
			setComboRequired("jglbdm", true);
			//判决机关
			$("#pjjgmc").validatebox({required:true});
			//监管单位
			$("#jgdwmc").validatebox({required:true});
			//犯罪性质
			setComboRequired("fzxzdm", true);
			//重点人口管理方法
			setComboRequired("glffdm", false);
			//列管来源
			setComboRequired("lglydm", false);
			//精神病类别
			setComboRequired("jsblbdm", false);
			
		} else if(newVal == "2") {
			$("#jgdxDiv").hide();
			$("#zdrkDiv").show();
			$("#zszhjsbrDiv").hide();
			$("#fzcfryDiv").hide();
			$("#ggDiv").show();
			//监管类别
			setComboRequired("jglbdm", false);
			//判决机关
			$("#pjjgmc").validatebox({required:false});
			//监管单位
			$("#jgdwmc").validatebox({required:false});
			//犯罪性质
			setComboRequired("fzxzdm", false);
			//重点人口管理方法
			setComboRequired("glffdm", true);
			//列管来源
			setComboRequired("lglydm", true);
			//精神病类别
			setComboRequired("jsblbdm", false);
			
		} else if(newVal == "3") {
			$("#jgdxDiv").hide();
			$("#zdrkDiv").hide();
			$("#zszhjsbrDiv").show();
			$("#fzcfryDiv").hide();
			$("#ggDiv").show();
			//监管类别
			setComboRequired("jglbdm", false);
			//判决机关
			$("#pjjgmc").validatebox({required:false});
			//监管单位
			$("#jgdwmc").validatebox({required:false});
			//犯罪性质
			setComboRequired("fzxzdm", false);
			//重点人口管理方法
			setComboRequired("glffdm", false);
			//列管来源
			setComboRequired("lglydm", false);
			//精神病类别
			setComboRequired("jsblbdm", true);
			
		} else if(newVal == "4") {
			$("#jgdxDiv").hide();
			$("#zdrkDiv").hide();
			$("#zszhjsbrDiv").hide();
			$("#fzcfryDiv").show();
			$("#ggDiv").show();
			//监管类别
			setComboRequired("jglbdm", false);
			//判决机关
			$("#pjjgmc").validatebox({required:false});
			//监管单位
			$("#jgdwmc").validatebox({required:false});
			//犯罪性质
			setComboRequired("fzxzdm", false);
			//重点人口管理方法
			setComboRequired("glffdm", false);
			//列管来源
			setComboRequired("lglydm", false);
			//精神病类别
			setComboRequired("jsblbdm", false);
		} 
		else {
			$("#jgdxDiv").hide();
			$("#zdrkDiv").hide();
			$("#zszhjsbrDiv").hide();
			$("#fzcfryDiv").hide();
			$("#ggDiv").hide();
		}
		}
	});
	 if(newVal == "6"||newVal == "5"){
		$("#jgdxDiv").hide();
		$("#zdrkDiv").hide();
		$("#zszhjsbrDiv").hide();
		$("#fzcfryDiv").hide();
		$("#ggDiv").show();
		
		//取消必填验证
		//监管类别
		setComboRequired("jglbdm", false);
		//判决机关
		$("#pjjgmc").validatebox({required:false});
		//监管单位
		$("#jgdwmc").validatebox({required:false});
		//犯罪性质
		setComboRequired("fzxzdm", false);
		//重点人口管理方法
		setComboRequired("glffdm", false);
		//列管来源
		setComboRequired("lglydm", false);
		//精神病类别
		setComboRequired("jsblbdm", false);
					
		var name = $("#xm").val();
		var cglb= window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYLBDM.js', $("#cglxdm").val());
		var cghlb= window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYLBDM.js', newVal);
		$("#ywfqyy").val( "申请将【"+name+"】的重点人员管理类别“"+cglb+"”撤管为“"+cghlb+"”管理。");
	}
	 if(newVal == "6"){
		 setInputReadonly("zdrylbStr", true);
		setComboRequired("zdrylbStr", false);
	 }
	}
}
</script>
</html>