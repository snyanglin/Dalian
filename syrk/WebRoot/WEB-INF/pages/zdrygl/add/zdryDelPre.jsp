<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>重点人员撤管</title>
</head>

<body style="margin-top:20px; margin-bottom:10px" class="bodybg" onload="startup()">
<div data-options="region:'center',split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc"> 
 		<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">

        <form action="<%=basePath%>zdryzb/saveCg"  id="dataForm" name="dataForm" method="post" >
	    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdry.id}" />
	    	<input type="hidden" id="zdrygllxdm_old"  value="${zdry.zdrygllxdm}" />	    	
    	
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
		    	<input class="easyui-validatebox " type="text" id="cgyy" name="ywsqyy" style="width: 596px;" data-options="required:false,validType:['maxLength[100]','unnormal']" />
		    	</td>
	    	</tr>
	    	<!--
	    	<tr class="dialogTr" id="cgyyZd" style="display:none">
		    	<td width="20%" class="dialogTd" align="right" >撤管原因：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-combobox" type="text" id="cgyyCombo" style="width:200px;" 
								data-options="url:contextPath +'/common/dict/BD_D_ZDRYCGYY.js',
								valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:changeCgyy"/>
				</td>
			</tr>
			-->
		   <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">撤管类型：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm"   style="width:200px;" value=""
					data-options="url: contextPath +'/common/dict/BD_D_ZDRYGLLX.js',dataFilter:'${kcgStr }',  
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:zdrylxChange"/>

	    			<input type="text" name="zdryZdryzb.zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:390px;"
	    			data-options="onlyLeaf:true,valueField:'id',textField:'text',
	    			multiple:false,required:false,panelWidth:400,method:'get',lines:true,tipPosition:'left'" >	    			
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
	    	</table>
	    		    	
   		 </form>
	    </div>
	</div>
			
		</div>
	    </div>
	    
	    <div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
			<a id="saveButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="saveCgForm(this)">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>			
		</div>	     
	   
	</td></tr></table>
</div>
</body>
<script type="text/javascript" >
var mainTabID = "${mainTabID}";
var xzqh = "<%=SystemConfig.getString("systemXzqh")%>";
var gllxdm_old = $("#zdrygllxdm_old").val();
function startup(){
	$("#jgdxDiv").hide();
	$("#zdrkDiv").hide();
	$("#zszhjsbrDiv").hide();
	$("#fzcfryDiv").hide();
	$("#sqjzryDiv").hide();
	$("#sqsbzdryDiv").hide();
	$("#sgafzdryDiv").hide();
	//$("#ggDiv").hide();	
	//initCgyy();
};
/*
function initCgyy(){		
	if(xzqh == "210000"){//沈阳
		if(gllxdm_old ==  "01"){//社区矫正
			$('#cgyyCombo').combobox('setDataFilter', '1[0-9][0-9]');
		}else if(gllxdm_old ==  "02"){//重点人口
			$('#cgyyCombo').combobox('setDataFilter', '2[0-9][0-9]');
		}else if(gllxdm_old ==  "03"){//肇事肇祸精神病人
			$('#cgyyCombo').combobox('setDataFilter', '3[0-9][0-9]');
		}else if(gllxdm_old ==  "08"){//涉枪涉爆重点人员
			$('#cgyyCombo').combobox('setDataFilter', '4[0-9][0-9]');
		}else{//手动输入
			$('#cgyyText').show();
			$('#cgyyZd').hide();
		}
	}else{
		$('#cgyyText').show();
		$('#cgyyZd').hide();
	}
	
}
*/

function changeCgyy(newValue, oldValue){
	if(newValue == undefined ) return;
	showGroup();
	if(gllxdm_old ==  "01"){//社区矫正
		if(newValue == "100"){//期满
			$('#zdrygllxdm').combobox('setDataFilter', '02|06');//撤管原因选择“期满”时只能再列为重点人口、其他关注对象
			$('#zdrylbStr').combotree('tree').tree('loadData', '');
		}else if(newValue == "101" || newValue == "102" || newValue == "103"){//死亡|收监|其他
			$('#zdrygllxdm').combobox('setDataFilter', '999999');//撤管原因选择“死亡”、“收监”、“其他”时只能注销
			$('#zdrylbStr').combotree('tree').tree('loadData', '');
		}else{
			$('#zdrygllxdm').combobox('setDataFilter', '');
			$('#zdrylbStr').combotree('tree').tree('loadData', '');
		}		
	}else if(gllxdm_old ==  "02"){//重点人口
		if(newValue == "206"){//转列其他关注对象
			$('#zdrygllxdm').combobox('setDataFilter', '06');//当撤管原因为转列其他关注对象时只可再列为其他关注对象；
			$('#zdrylbStr').combotree('tree').tree('loadData', '');
		}else{
			$('#zdrygllxdm').combobox('setDataFilter', '999999');//撤管原因选择其他选项时只能注销
			$('#zdrylbStr').combotree('tree').tree('loadData', '');
		}
	}
	
}

//保存按钮
function saveCgForm(bottonObject){
	var formObject = $("#dataForm");	
	if (formObject.form('validate')) {
		if(confirm("您是否要保存当前的数据？")){
			//防止重复提交		
			if (buttonDisabled(bottonObject) == false) {
				return false;
			}
			
			$('#cgyy').val($('#cgyyCombo').combobox('getText'));
			$("#dataForm").form("submit",{
				url:document.dataForm.action,
				dataType : "json",
				onSubmit: function() {},
				success: function(result) {				
					buttonEnabled(bottonObject);
					result = parseReturn(result);
					if (result.status == "success") { // 返回成功后执行的方法
						alert("撤管申请成功");
						closeSelf();
					}
					else {
						topMessager.alert(MESSAGER_TITLE, result.message, "error");
					}
				}
			});	
		}else{			
			return false;
		}		
				
	}else{
		return false;
	}
		
}

</script>

</html>
