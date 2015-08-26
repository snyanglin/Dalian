<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人员档案</title>
<script type="text/javascript" src="<%=contextPath%>/js/syrkinfo-mould.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<style>
.nameTable{ width:500px;height:auot;overflow:hidden;}
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
						<table width="100%">
							<tr>
								<td valign="top" align="center" style="width:200px;">
									<div class="pphoto_1" style="text-align: center;" >
										<div>
											<img id="topPhotoid" width="160"
												height="200" alt="" />
										</div>
									</div>
									<div style="padding-left: 15px;">
										<c:if test="${mode != 'view'}">
										    <a href="javascript:void(0);" info="ryid_main,RY_RYJBXXB,ryid_main,人员基本信息表"
											class="addphoto"></a>
										</c:if>
									</div>
								</td>
								<td valign="top">
									<div class="pinfo1" >
									<ul><li style="padding:0px;" >
									<table cellpadding="0" cellspacing="0" class="nameTable" style="margin-left: 10px" >
									<tr>
										<td colspan="4" align="left" valign="top" >
											<strong><span id="jbxx_xm" style="padding-left: 56px;">${ry.xm }</span>
											<c:if test="${zdry != ''}">
											<span>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="openZdrk('${ry.xm }','${ry.id}','${syrkid}')">
											
											<script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/DL_D_ZDRYGLLXDM.js', "${zdry}"));</script>
											</a></span>
											</c:if>
											</strong>
										</td>
									 </tr>
									 <tbody id="jbxxInfo">
									 <tr>
									      <th  align="right" width="100">证件种类：</th>
										  <td width="120"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/KX_D_CYZJDM.js', "${ry.cyzjdm}"));</script></td>
										  <th  align="right" width="100">证件号码：</th>
										  <td width="120"> ${ry.zjhm}</td>
									 </tr>
									 <tr >
									      <th  align="right" width="100">出生日期：</th>
										  <td width="90">${ry.csrq}</td>
										  <th  align="right" width="100">性别：</th>
										  <td width="120"><script type="text/javascript"> document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', "${ry.xbdm}"));</script></td>
									 </tr>
									 <tr>
									      <th  align="right" width="100">联系电话：</th>
										  <td width="90">${lxdh}</td>
										  <th  align="right" width="100">民族：</th>
										  <td width="120"> <script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js', "${ry.mzdm}"));</script></td>
									 </tr>
									 <tr >
									      <th  align="right" width="100">国籍：</th>
										  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${ry.gjdm}"));</script></td>
										  <th  align="right" width="100">外文姓名：</th>
										  <td width="120"> ${ry.wwx}  ${ry.wwm}</td>
									 </tr>
									 <tr >
									      <th  align="right" width="100">籍贯：</th>
										  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XZQHDM.js', "${ry.jgssxdm}"));</script></td>
										  <th  align="right" width="100">籍贯国家：</th>
										  <td width="120"><script type="text/javascript"> document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${ry.jggjdqdm}"));</script></td>
									 </tr>
									 <tr >
									      <th  align="right" width="100">户籍地址：</th>
										  <c:choose>
										  <c:when test="${ry.hjd_dzxz !=null}">
										  <td  colspan="3" width="270">${ry.hjd_dzxz }</td>	
										  </c:when>
										  <c:otherwise>
										  <td  colspan="3" width="270">${ry.hjd_mlpxz}</td>	
										  </c:otherwise>
										  </c:choose>
										  </td>
									 </tr>
									 </tbody>
									 <tbody id="jwryInfo">
									     <tr>
										     <th align="right" width="100">国籍（地区）：</th>
											 <td width="120"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${jwry.gjdm}"));</script></td>
											 <th align="right" width="100">证件种类：</th>
											 <td width="120"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/KX_D_CYZJDM.js', "${jwry.cyzjdm}"));</script></td>
										 </tr>
									     <tr>
											 <th align="right" width="100">证件号码：</th>
											 <td width="120">${jwry.zjhm}</td>
											 <th align="right" width="100">中文姓名：</th>
											 <td width="120">${jwry.xm}</td>
										 </tr>
										 <tr>
											 <th align="right" width="100">外文姓：</th>
											 <td width="120">${jwry.wwx}</td>
											 <th align="right" width="100">外文名：</th>
											 <td width="120">${jwry.wwm}</td>
										 </tr>
										 <tr>
										     <th align="right" width="100">性别：</th>
											 <td width="120"><script type="text/javascript"> document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', "${jwry.xbdm}"));</script></td>
										     <th align="right" width="100">出生日期：</th>
											 <td width="90">${jwry.csrq}</td>
										 </tr>
										 <tr>
										     <th align="right" width="100">签证（注）种类：</th>
											 <td width="120"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/ZA_D_QZZLDM.js', "${jwry.qzjlxkzldm}"));</script></td>
											 <th align="right" width="100">签证（注）号码：</th>
											 <td width="120">${jwry.qzjlxkh}</td>
										 </tr>
										 <tr>
										     <th align="right" width="100">入境日期：</th>
											 <td width="120">${jwry.rjrq}</td>
											 <th align="right" width="100">停留有效日期：</th>
											 <td width="120">${jwry.qztjl_jzrq}</td>
										 </tr>
										 <tr>
										     <th align="right" width="100">现住址：</th>
											 <td width="340" colspan="3">${jwry.jzd_dzxz}</td>
										 </tr>
									 </tbody>
									</table>
									<!--可隐藏部分 -->
									<div id="moreInfo" />
									<table cellpadding="0" cellspacing="0" class="nameTable" style="margin-left: 10px;"> 
									 <tr >
									      <th  align="right" width="100">出生国家：</th>
										  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${ry.csdgjhdqdm}"));</script></td>
										  <th  align="right" width="100">出生地：</th>
										  <td width="120"> <script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XZQHDM.js', "${ry.csdssxdm}"));</script></td>
									 </tr>
									  <tr >
									      <th  align="right" width="100">曾用名：</th>
										  <td width="90">${ry.cym}</td>
										  <th  align="right" width="100">学历：</th>
										  <td width="120"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XLDM.js', "${ry.xldm}"));</script></td>
									 </tr>
									  <tr >
									      <th  align="right" width="100">婚姻状况：</th>
										  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_HYZKDM.js', "${ry.hyzkdm}"));</script></td>
										  <th  align="right" width="100">政治面貌：</th>
										  <td width="120"> <script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_ZZMMDM.js', "${ry.zzmmdm}"));</script></td>
									 </tr>
									   <tr >
									      <th  align="right" width="100">宗教信仰：</th>
										  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/ZA_D_ZJXYDM.js', "${ry.zjxydm}"));</script></td>
										  <th  align="right" width="100">兵役状况：</th>
										  <td width="120"> <script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/ZA_D_BYQKDM.js', "${ry.byzkdm}"));</script></td>
									 </tr>
									   <tr >
									      <th  align="right" width="100">血型：</th>
										  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/ZA_D_XXDM.js', "${ry.xxdm}"));</script></td>
										  <th  align="right" width="100">职业类别：</th>
										  <td width="120"> <script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_ZYLBDM.js', "${ry.zylbdm}"));</script></td>
									 </tr>
									  <tr >
									      <th  align="right" width="100">职业：</th>
										  <td width="120">${ry.zy}</td>
									 </tr>
									  </table>
									 </div>
							        <!-- 可隐藏部分end -->		
									</li>
								    </ul> 	
								   <a href="javascript:void(0);" class="" onclick="moreInfoMethod();" id="moreButton" style="margin-left: 70px;width: 40px">更多</a>													
								</div>
							</td>
							
						</tr>
					</table>
	<input type="hidden" id="formPara" value='"1":"1"' /><!-- 表单提交附加参数 json-->
	<input type="hidden" id="serverPara" value="syrkid=${syrkid}" /><!-- 业务办理附加参数-->
	<input type="hidden" id="queryPara" value="ryid=${ry.id }" /><!-- 表单查询附加参数 -->
	<input type="hidden" id="mode_"	 value="${mode }" />
	<input type="hidden" id="ryid_main"	 value="${ry.id }" />
	<input type="hidden" id="serverListPara"  value="syrklx=${syrklx}" />
	
	
<div class="clear"></div>
<div class="editdiv"><a href="javascript:void(0);" class="savebtn">档案编辑完成</a><a href="javascript:void(0);" class="editbtn" style="display:none">编辑档案信息</a></div>

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
</div>
<div class="rt_view">
<div class="rttitle" >可增加信息</div>
<ul class="rtul" id="serverAddInfo">
</ul>
</div>

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
var syrkJson='${syrkJson}';
var infoPara = {
		mainUrl:"/syrkEdit/queryRyzsxx",
		mainPara:"rylbdm="+$("#rylbdm_").val()+"&syrkJson="+syrkJson,
		queryUrl:"/syrkEdit/service/",
		queryPara:$("#queryPara").val(),
		serverMenuUrl:"/syrkEdit/queryYwglgn",
		serverMenuPara:$("#serverListPara").val()+"&syrkJson="+syrkJson,
		zpUrl:"/zpfjPtryzp/queryZpById.jpg",
		editPara:"ryid="+$("#ryid_main").val()+"&"+$("#serverPara").val(),
		editIframePara:'{"ryid":"'+$("#ryid_main").val()+'",'+$("#formPara").val()+'}',
		serverOpenPara:"ryid="+$("#ryid_main").val()+";"+$("#serverPara").val(),
		serverPara:"ryid="+$("#ryid_main").val()+"&"+$("#serverPara").val(),
		serverIframePara:'{"ryid":"'+$("#ryid_main").val()+'",'+$("#formPara").val()+'}',
		add_childInfo_para:"ryid="+$("#ryid_main").val(),
		add_childInfo_iframePara:'{"ryid":"'+$("#ryid_main").val()+'",'+$("#formPara").val()+'}',
		edit_childInfo_para:$("#ryzdry").val(),
		edit_childInfo_iframePara:'{"ryid":"'+$("#ryid_main").val()+'",'+$("#formPara").val()+'}',
		del_childInfo:"/syrkEdit/delete_xxzsnrb"
	};
$(document).ready(function(){
	/***************境外人员，页面初开始**************************/
	if(${syrkywlxdm}=="4"){
		$("#jbxxInfo").hide();
		$("#moreButton").hide();
	}else{
		$("#jwryInfo").hide();
	}
	/***************境外人员，页面初结束**************************/
	$("#moreInfo").hide();
	var mode_ = $("#mode_").val();
 	if(mode_=="view"){
 		$("#server_Menu").hide();
 		$("a.info_editbtn").remove();
	}else{
 		$("a.editbtn").show();
		$("a.savebtn").click(save_view);
		$("a.info_editbtn").click(editEnable);
		$("a.editbtn").click(edit_view);
		getServerMenu(1);
		getServerMenu(2);
	}
	/***************固定事件注册，页面初始化**************************/
	$("a.up_btn").click(up_down);
	sylbIcon();
	$(".addphoto").click(addPhoto);
	$(".morephoto").click(morePhoto);
	iterateDict($("div.lf_conta").eq(1));
	$(".rt").show();
	$(".rt_view").hide();
	document.getElementById("topPhotoid").src = contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid=${ry.id}&zjhm=${ry.zjhm}&cyzjdm=${ry.cyzjdm}";
});


function moreInfoMethod(){
	var moreButtonVal=$("#moreButton").html();
	if(moreButtonVal=="更多"){
	$("#moreInfo").show();
	$("#moreButton").html("收缩");
	}else if (moreButtonVal=="收缩"){
		$("#moreInfo").hide();
		$("#moreButton").html("更多");
	}
}

function refreshPhoto(){
	location.reload();
}
function openZdrk(xm,ryid,syrkid){
	var editUrl = "/zdry/"+ryid+"/"+syrkid+"/view";
	if($("#mode_").val()=="view"){
		editUrl += "?mode=view";
	}
	menu_open(xm,editUrl);
}
</script>
</html>
    