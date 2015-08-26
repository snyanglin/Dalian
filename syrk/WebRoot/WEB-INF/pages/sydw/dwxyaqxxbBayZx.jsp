<%@page import="javax.ws.rs.core.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>保安员信息</title>
</head>
<div  class="easyui-layout" data-options="fit:true" >
    <form action="" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<input type="hidden" id="xt_zxbz" name="xt_zxbz" value="${entity.xt_zxbz}" />
				<input type="hidden" id="xt_zhxgrxm" name="xt_zhxgrxm" value="${entity.xt_zhxgrxm}" />
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="zjlxdm" name="zjlxdm" style="width:200px;" value="${entity.zjlxdm }" disabled
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
			    	<td width="30%" class="dialogTd" align="left">
			    		<input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm }" maxlength="30" disabled
			    		data-options="required:true,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div>
			    	</td>
		    	</tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xm" name="xm" style="width:200px;" value="${entity.xm }" maxlength="20" disabled
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">曾用名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="cym" name="cym" style="width:200px;" value="${entity.cym }" maxlength="20" disabled
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${entity.xbdm }" disabled
						data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">民族：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:200px;" value="${entity.mzdm }" disabled
						data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="csrq" name="csrq" style="width:200px;" value="${entity.csrq }" maxlength="20" disabled
			    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">文化程度：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combotree" type="text" id="xldm" name="xldm" value="${entity.xldm}" style="width:200px;" disabled
						data-options="required:true,url: contextPath + '/common/dict/D_BZ_WHCD.js',onlyLeaf:true,multiple:false,required:false,panelWidth:220,
						method:'get',editable:true,lines:true"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">兵役状况：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="byzkdm" name="byzkdm" style="width:200px;" value="${entity.byzkdm }" maxlength="20" disabled
			    		data-options="url: contextPath + '/common/dict/ZA_D_BYQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">婚姻状况：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="hyzkdm" name="hyzkdm" style="width:200px;" value="${entity.hyzkdm }" maxlength="20" disabled
						data-options="url: contextPath + '/common/dict/GB_D_HYZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">身高（CM）：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="sg" name="sg" style="width:200px;" value="${entity.sg }" maxlength="20" disabled
			    		data-options="required:false,validType:['naturalNumberRange[1,300]'],tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">血型：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xxdm" name="xxdm" style="width:200px;" value="${entity.xxdm }" maxlength="20" disabled
						data-options="url: contextPath + '/common/dict/ZA_D_XXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">健康状况：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="jkzkdm" name="jkzkdm" style="width:200px;" value="${entity.jkzkdm }" maxlength="20" disabled
			    		data-options="url: contextPath + '/common/dict/D_RK_JKZK.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">政治面貌：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="zzmmdm" name="zzmmdm" style="width:200px;" value="${entity.zzmmdm }" maxlength="20" disabled
						data-options="url: contextPath + '/common/dict/GB_D_ZZMMDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">户籍地省市县：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="hjdssxdm" name="hjdssxdm" style="width:200px;" value="${entity.hjdssxdm }" maxlength="20" disabled
			    		data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',required:false,valueField:'id',textField:'text',selectOnNavigation:false"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">户籍地详址：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="hjdxz" name="hjdxz" style="width:200px;" value="${entity.hjdxz }" maxlength="40" disabled
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">现住址省市县：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xzzssxdm" name="xzzssxdm" style="width:200px;" value="${entity.xzzssxdm }" maxlength="20" disabled
			    		data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',required:false,valueField:'id',textField:'text',selectOnNavigation:false"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">现住址详址：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xzzxz" name="xzzxz" style="width:200px;" value="${entity.xzzxz }" maxlength="40" disabled
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;" value="${entity.lxdh }" maxlength="18" disabled
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">报名日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="bmrq" name="bmrq" style="width:200px;" value="${entity.bmrq }" maxlength="20" disabled
			    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">准考证号：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zkzh" name="zkzh" style="width:200px;" value="${entity.zkzh }" maxlength="20" disabled
						data-options="required:false,validType:['letterOrNum'],tipPosition:'left'"/>
					</td>
			    	<td width="20%" class="dialogTd" align="right">考试地点：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="ksdd" name="ksdd" style="width:200px;" value="${entity.ksdd }" maxlength="40" disabled
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">考试时间：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="kssj" name="kssj" style="width:200px;" value="${entity.kssj }" maxlength="20" disabled
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
			    	<td width="20%" class="dialogTd" align="right">考试成绩：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="kscj" name="kscj" style="width:200px;" value="${entity.kscj }" maxlength="20" disabled
			    		data-options="required:false,validType:['naturalNumberRange[1,100000]'],tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr>
				    <td align="center" colspan="5">
		      			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="cancel('info_bayxxb')">注销</a>
			       	</td>
		       	</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function cancel(url){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var id = $("#pk").val();
	var deleteUrl = contextPath + '/sydwgl/calcle_xxzsnrb';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:id,url:url},
				success:function(data) {
				  alert("注销成功");
				  window.parent.$('#windowWithoutSave').dialog('close');
				}
			});
		}
	});
};

</script>
