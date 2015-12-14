<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重点人员档案</title>
<script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryinfo-mould.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>
<style>
.nameTable{ width:420px;height:auto;overflow:hidden;}
.nameTable tr{height:auto;}
.nameTable th{line-height:26px; color:#666;font-weight:normal;word-wrap:break-all;}
.nameTable td{line-height:20px; color:#333;word-wrap:break-all; }
</style>
</head>

<body class="bodybg">
<div class="head"><div class="logo"></div></div>
<div class="bodydiv">
<div class="bodyer">
<div class="lf">
<!--框-->
<div class="lf_conta">
<div class="lf_contb">
<div class="lf_contc">


<div class="pinfo1">
<div class="pphoto">
<div>
<img class="topPhoto" id="topPhotoid" width="162" height="200" alt="" /></div>
    <c:if test="${mode != 'view'}">
       <!--  <a href="javascript:void(0);" class="morephoto"></a>--><a href="javascript:void(0);" info="ryid_main,RK_RYJBXXB,ryid_main,人员基本信息表" class="addphoto"></a>
    </c:if>

</div>
<table >
	<tr>
		<td colspan="2" align="left"><strong><span id="dwmc_dw">${zdry.xm }</span><span>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="openSyrk('${zdry.xm }','${zdry.ryid}','${zdry.syrkid}')">实有人口管理</a></span></strong></td>
	</tr>
	<tr>
		<td>
				<table cellpadding="0" cellspacing="0" class="nameTable" >
					<tr>
						<th  align="right" width="130">已列管类型：</th>
						<td width="270" colspan="3">
							<span id="zdrylxTag">
								${zdrylx }
								<c:if test="${zdrylxMore != null}">
									<a href="#" onclick="showZdryLxMore()">更多</a>
								</c:if>
							</span>
							<c:if test="${zdrylxMore != null}">
								<span id="zdrylxTagMore" style="display:none">
									${zdrylxMore }
									<a href="#" onclick="showZdryLxLess()">收起</a>
								</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<th  align="right" width="130">证件号码：</th> <td width="90">${zdry.zjhm }</td>
						<th  align="right" width="100">证件种类：</th>
							<td width="80"> <script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/KX_D_CYZJDM.js', "${zdry.cyzjdm}"));</script></td>
					</tr>
					<tr>
						<th  align="right" width="130">性别：</th>
							<td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', "${zdry.xbdm}"));</script></td>
						<th  align="right" width="100">民族：</th>
							<td width="80"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js', "${zdry.mzdm}"));</script></td>
					</tr>
					<tr>
						<th  align="right" width="130">出生日期：</th> <td width="270" colspan="3">${zdry.csrq }</td> 						
					</tr>
					<tr>
						<th  align="right" width="130">户籍地址：</th> <td width="270" colspan="3">${zdry.hjd_dzxz }</td>
					</tr>
					<tr>
						<th  align="right" width="130">居住地址：</th> <td width="270" colspan="3">${zdry.jzd_dzxz }</td>
					</tr>
					<tr>
						<th  align="right" width="130">主要问题及现实表现：</th> <td width="270" colspan="3">${zdry.zywtjxsbx }</td>
					</tr>
				</table>
		</td>
	</tr>
</table>
</div>
	<!-- 页面打开模式 -->
	<input type="hidden" id="mode_"  value="${mode}" />	
	<input type="hidden" id="formPara" value='"xm":"${zdry.xm}","sfzh":"${zdry.zjhm}"' /><!-- 表单提交附加参数 -->
	<input type="hidden" id="serverListPara" value="rylbdm=${zdry.zdrygllxdm}" /><!-- 业务功能获取参数 -->
	<input type="hidden" id="serverPara" value="ryid=${zdry.ryid}&syrkid=${zdry.syrkid}&id=${zdry.id}" /><!-- 业务办理附加参数  -->
	<input type="hidden" id="queryPara" value="ryid=${zdry.ryid}&id=${zdry.id}" /><!-- 表单查询附加参数 -->
	<input type="hidden" id="ryzdry" value="ryid=${zdry.ryid}" />
	<input type="hidden" id="sfzh" value="${zdry.zjhm}" />
	<input type="hidden"  id="ryid_main" value="${zdry.ryid}" />
	<input type="hidden"  id="zdryId" value="${zdry.id}" />
	
<div class="clear"></div>
<div class="editdiv"><a href="javascript:void(0);" class="savebtn">档案编辑完成</a><a href="javascript:void(0);" class="editbtn"  style="display:none">编辑档案信息</a></div>

</div>
</div>
</div>
<!--/框-->

</div>
<div class="rt" style="display:none">
<!--右侧框-->
<div class="rt_conta">
<div class="rt_contb">
<div class="rt_contc">

<div class="rt_server">
<div class="rttitle" id="server_Menu">业务办理</div>
<ul class="rtul" id="serverMenu"> 
</ul>
<c:if test="${zdrylxList!= null}">
<div class="rttitle" >关系人</div>
<ul class="rtul" >
</ul>
<div class="rttitle" >关联信息</div>
<ul class="rtul" id="relationMessage" style="text-align:center">
</ul>
<div class="rttitle" >活动轨迹</div>
<div class="rtshow"><div class="timelinebody"><div class="timeliall"></div></div><div class="clear"></div></div>
</c:if>
</div>
<!-- <div class="rt_view">
<div class="rttitle" >可增加信息</div>
<ul class="rtul" id="serverAddInfo">
</ul>
</div> -->

</div>
</div>
</div>
<!--/右侧框-->
</div>
<div class="clear"></div>
</div>
</div>
</body>
<script type="text/javascript">
//重点人员类型
var zdrylxJson='${zdrylxJson}';

var infoPara = {
		mainUrl:"/zdryEdit/queryRyzsxx",
		mainPara:"zdrylxJson="+zdrylxJson,
		queryUrl:"/zdryEdit/service/",
		queryPara:$("#queryPara").val(),
		serverMenuUrl:"/zdryEdit/queryYwglgn",
		serverMenuPara:$("#serverListPara").val()+"&zdrylxJson="+zdrylxJson,
		zpUrl:"/zpfjPtryzp/queryZpById.jpg",
		editPara:"ryid="+$("#ryid_main").val(),
		editIframePara:'{"ryid":"'+$("#ryid_main").val()+'",'+$("#formPara").val()+'}',
		serverPara:$("#serverPara").val(),
		serverIframePara:'{"ryid":"'+$("#ryid_main").val()+'",'+$("#formPara").val()+'}',
		add_childInfo_para: $("#ryzdry").val(),
		add_childInfo_iframePara:'{"ryid":"'+$("#ryid_main").val()+'",'+$("#formPara").val()+'}',
		edit_childInfo_para:$("#ryzdry").val(),
		edit_childInfo_iframePara:'{"ryid":"'+$("#ryid_main").val()+'",'+$("#formPara").val()+'}',
		del_childInfo:"/zdryEdit/delete_xxzsnrb"
	};
$(document).ready(function(){
	var mode_ = $("#mode_").val();
 	if(mode_=="view"){
 		$("#server_Menu").hide();
 		$("a.info_editbtn").remove();
	}else{
 		$("a.editbtn").show();
 		$("a.savebtn").click(save_view);
		$("a.info_editbtn").click(editEnable);
		$("a.editbtn").click(edit_view);
		getServerMenuNew(1);
		//getServerMenu(2);
	}
	/***************固定事件注册，页面初始化**************************/
	$("a.up_btn").click(up_down);
	sylbIcon();
	$(".addphoto").click(addPhoto);
	$(".morephoto").click(morePhoto);
	iterateDict($("div.lf_conta").eq(1));
		
	$(".rt").show();
	$(".rt_view").hide();
	
	
	/**********自己定义方法*************************/
	var zdrylx = "${zdrylxList}";
	if($("#timelinebody") && zdrylx != ""){
		loadActivityTrace();
		//loadRelationMessage();
	}
	document.getElementById("topPhotoid").src = contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid=${zdry.ryid}&zjhm=${zdry.zjhm}&cyzjdm=${zdry.cyzjdm}";
	
});

/**
 * 获取功能表 1,业务办理，2，可增加信息
 */
function getServerMenuNew(gnlxdm){
 	var menu= null ;
	$.ajax({
		type:"post",
		url:contextPath+infoPara.serverMenuUrl,
		dataType:"json",
		data:infoPara.serverMenuPara+"&gnlxdm="+gnlxdm,
		success:function(data){
		 	if("1" == gnlxdm){
		 	  menu = $("#serverMenu");
		 	}else if("2" == gnlxdm){
			  menu = $("#serverAddInfo");
			}
			$(menu).empty();
			$.each(data,function(i,item){
				if("1" == gnlxdm){
				  $(menu).append(serverMenuHtml(item));
				}else if("2" == gnlxdm){
				  $(menu).append(serverLXRHtml(item));
				}
			}); 
			
		},
		complete:function(){
			if(menu){
				if("1" == gnlxdm){					
					$(menu).find("a.doServer").click(doServerMenu);					
				}else if("2" == gnlxdm){
					$(menu).find("a.addInfo").click(addInfoHtml_nav);
				}
			};
		}
	});
}

function doServerMenu(){	
	var editUrl = $(this).attr("url");
	var confirmmsg = $(this).attr("confirmmsg");
	editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	editUrl = editUrl + infoPara.serverPara;
	var paramArray = $.parseJSON(infoPara.serverIframePara);
	
	if($(this).attr("title")=="动态记实" || $(this).attr("title")=="撤管重点人员"){
		menu_open($(this).attr("title"), editUrl);
	}else{
		infoOpen(contextPath+editUrl,$(this).attr("title"),paramArray, confirmmsg , "edit_complete");
	}		
}

function loadActivityTrace() { // 显示活动轨迹
	$.ajax({
		type: 'POST',
		url: contextPath + '/rkRyhdgjb/queryList',
		data: "zjhm="+$("#sfzh").val(),
		success: function(data) {
			var dataJson = $.parseJSON(data);
			if (dataJson.length > 0) {
				var sb = new StringBuffer();
				for (var i = 0; i < dataJson.length; i++) {
					var dataObject = dataJson[i];
					var gjkssj = dataObject['gjkssj'];
					var gjdd = dataObject['gjdd'];
					var gjsm = dataObject['gjsm'];
					sb.append('<div class="timelicont"><div class="timelidiv">');
					sb.append('<a class="timetitle">'+ gjdd +'</a>');
					sb.append('<div class="jqsjmsinfo"><div><span>' + gjsm + '</span></div></div>');
					sb.append('<div class="timedate"><span>' + gjkssj + '</span></div>');
					sb.append('<div class="timeicon"></div><div class="timesjx"></div>');
					sb.append('</div></div>');
				}
				$('.timeliall').append(sb.toString());
			}
		},
		error: function() {
		}
	});
}

function loadRelationMessage() { // 显示关联信息
	$.ajax({
		type: 'POST',
		url: contextPath + '/relationRyxx/queryList',
		data: "sfzh="+$("#sfzh").val(),
		success: function(data) {
			var dataJson = $.parseJSON(data);
			if (dataJson.length > 0) {
				var sb = new StringBuffer();
				for (var i = 0; i < dataJson.length; i++) {
					var dataObject = dataJson[i];
					var typeName = dataObject['typeName'];
					sb.append('<div class="rtul_title">' + typeName);
					var listArray = dataObject['list'];
					for (var j = 0; j < listArray.length; j++) {
						sb.append('<div class="rtshowxx">' + listArray[j].title + '</div><div class="rtshowSplit"></div>');
					}
					sb.append('</div>');
				}
				$('#relationMessage').append(sb.toString());
			}
		},
		error: function() {
		}
	});
}

function openSyrk(xm,ryid,syrkid){
	var editUrl = "/syrkEdit/"+ryid+"/"+syrkid+"/view";
	if($("#mode_").val()=="view"){
		editUrl += "?mode=view";
	}
	menu_open("实有人口【"+xm+"】",editUrl);
}


function showZdryLxMore(){
	$("#zdrylxTagMore").show();
	$("#zdrylxTag").hide();
}

function showZdryLxLess(){
	$("#zdrylxTagMore").hide();
	$("#zdrylxTag").show();
}
</script>
</html>
    