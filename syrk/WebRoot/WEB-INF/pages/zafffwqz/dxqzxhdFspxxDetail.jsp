<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	</head>
	<div>
		<body style="border-collapse:collapse;padding:0 ;magin:0 ">
			<table border="0" width="80%" align="center"  border-collapse="collapse" padding="0" magin="0" >
				<H2 align="center" ><span style="font-weight:bold;font-size:30px">大型社会活动备案表</span></H2>
				<tr >
					<td width="15%"  align="left"  ><span style="font-weight:bold;">填报单位：</span></td>
					<td width="35%"  height="20px" align="left"  >${entity.tbdw}</td>
					<td width="50%"  align="right"  id="tbsj"></td>
				</tr>
			</table>
			<table border="3" width="80%" align="center"  border-collapse:collapse>
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				 <tr >
					<td width="20%"  align="center" colspan="2" >活 动 名 称：</td>
					<td width="80%"  align="left" height="50px" align="center"  colspan="4">&nbsp;&nbsp;${entity.hdmc}</td>
				</tr>
				 <tr >
					<td width="20%"  align="center" colspan="2">活 动 规 模：</td>
					<td width="80%" align="left"  height="50px" align="center"  colspan="4">&nbsp;&nbsp;${entity.hdgm}（人）</td>
				</tr>
				 <tr >
					<td width="20%"   align="center"colspan="2">活 动 地 点：</td>
					<td width="80%"  align="left"  height="50px" align="center"  colspan="4">&nbsp;&nbsp;${entity.hddd}</td>
				</tr>
				<tr >
					<td width="20%"  align="center"colspan="2">活动开始时间：</td>
					<td width="80%" align="left" height="50px" align="center"  colspan="4" id="hdkssj" >&nbsp;&nbsp;</td>	
				</tr>
				<tr >
					<td width="20%" align="center"colspan="2">活动结束时间：</td>
					<td width="80%" align="left"height="50px" align="center"  colspan="4"id="hdjssj" >&nbsp;&nbsp;
					${entity.hdjssj}</td>	
				</tr>
				 <tr >
					<td width="20%" align="center"colspan="2">举 办 单 位：</td>
					<td width="80%"  align="left" height="50px" align="center"  colspan="4">&nbsp;&nbsp;${entity.jbdw}</td>
				</tr>
				<tr >
					<td width="20%" align="center"colspan="2">承 办 单 位：</td>
					<td width="80%" align="left" height="50px" align="center"  colspan="4">&nbsp;&nbsp;${entity.cbdw}</td>
				</tr>
				<tr >
					<td width="20%"  align="center"colspan="2">承办单位负责人：</td>
					<td width="30%" align="left"  height="50px" align="center" >&nbsp;&nbsp;${entity.cbdwfzr}</td>
					<td width="20%"  align="center"colspan="2">联 系 方 式：</td>
					<td width="30%" align="left"  height="50px" align="center" >&nbsp;&nbsp;${entity.lxfs}</td>
				</tr>
				<tr >
	    			<td width="10%" align="center"colspan="0" >活动主要内容：</td>
			    	<td width="90%"  align="left" colspan="5"  height="170px" align="center" >&nbsp;&nbsp;${entity.hdzynr}</td>
	    		</tr>
	    		<tr >
	    			<td width="10%"  align="center">市(县/区)局意见：</td>
			    	<td width="90%"  align="left"colspan="5"  height="170px" align="center" >&nbsp;&nbsp;${entity.sxqjyj}</td>
	    		</tr>
	    		<tr >
	    			<td width="10%"  align="center">备   注：</td>
			    	<td width="90%"  align="left" colspan="5"   height="100px" align="center" >&nbsp;&nbsp;${entity.bz}</td>
	    		</tr>
	    	</table>
	    	<table border="0" width="80%" align="center"  border-collapse:collapse>
	    		<tr >
					<td width="10%"  align="center"><span style="font-weight:bold;">填表人：</span></td>
					<td width="65%"   height="20px" align="left" >${entity.tbr}</td>
					<td width="10%"  align="center"><span style="font-weight:bold;">审核人：</span></td>
					<td width="15%"   height="20px" align="left" >${entity.shr}</td>
				</tr>
				<tr>
					<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
						<a class="easyui-linkbutton" iconCls="icon-search" onclick="printBody();" >打印</a>
					</td>
				</tr>
			</table>
		</body>
	</div>
</html>
<script type="text/javascript" >
//活动开始时间，活动结束时间，填表时间 进行时间格式转换
function doInit() {
	var hdkssj =  "${entity.hdkssj}";
	var hdjssj =  "${entity.hdjssj}";
	var tbsj =  "${entity.tbsj}";
	if(hdkssj!=null){
		var hdkssjs =hdkssj.split("-");
		var hdkssjss = hdkssjs[0]+"年"+hdkssjs[1]+"月"+hdkssjs[2]+"日";
		document.getElementById("hdkssj").innerHTML='&nbsp;&nbsp;'+hdkssjss;
	}
	if(hdkssj!=null){
		var hdjssjs =hdkssj.split("-");
		var hdjssjss = hdjssjs[0]+"年"+hdjssjs[1]+"月"+hdjssjs[2]+"日";
		document.getElementById("hdjssj").innerHTML='&nbsp;&nbsp;'+hdjssjss;
	}
	if(hdkssj!=null){
		var tbsjs =tbsj.split("-");
		var tbsjsss = tbsjs[0]+"年"+tbsjs[1]+"月"+tbsjs[2]+"日";
		document.getElementById("tbsj").innerHTML='&nbsp;&nbsp;'+tbsjsss;
	}
}
function body_onload() {
	$('#dataform').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            alert(data);  
        }  
    });   
    
} 
//打印
function printBody(){
	pagesetup_null();
	window.print();
}
// 页面加载完成事件
window.onload = function() {
	doInit();
	body_onload();
}
//重置
function resetForm(){
	$("#jzqkms").val("");
	$("#gzjzsj").val("");
	$("#bz").val("");
}
</script>