<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String orglevel ="";
    String fxjdm ="";
    String pcsdm ="";
    String zrqdm ="";
    String orgDj ="";
    Boolean panduan=true;
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        orglevel =userInfo.getUserOrgLevel();
        if("10".equals(orglevel) || "20".equals(orglevel) || "30".equals(orglevel) || "40".equals(orglevel)){// 市局 
        	orgDj ="1";
        }else if("21".equals(orglevel) || "31".equals(orglevel) || "41".equals(orglevel)){// 分局 
        	fxjdm =userInfo.getExtendValue("ssFsxCode");
        	orgDj ="2";
        }else if("32".equals(orglevel)){ //派出所 
        	fxjdm =userInfo.getExtendValue("ssFsxCode");
        	pcsdm =userInfo.getUserOrgCode();
        	orgDj ="3";
        }else if("50".equals(orglevel)){//责任区 
        	fxjdm =userInfo.getExtendValue("ssFsxCode");
        	pcsdm =userInfo.getExtendValue("ssPcsCode");
        	zrqdm =userInfo.getUserOrgCode();
        	orgDj ="4";
        }else{
        	panduan=false;
        }
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<link href="<%=contextPath%>/css/dbrw.css" rel="stylesheet"
	type="text/css" />
			<script type="text/javascript" src="<%=contextPath%>/js/tools/flashChart/swfobject.js"></script>
			<script type="text/javascript" src="<%=contextPath%>/common/websocket/jWebSocket.js"></script>
			<script type="text/javascript" src="<%=contextPath%>/common/websocket/jwsMosPlugIn.js"></script>
<style type="text/css">
.searchText {
	font-size: 13px;
	font-color: #222222;
	height: 30px;
	border: 1px solid #95B8E7;
	padding-left: 5px;
	padding-top: 10px;
	width: 200px;
}

.searchIcon {
	width: 28px;
	height: 28px;
	background: url('<%=contextPath%>/images/search_icon.png') no-repeat
		center;
	cursor: pointer;
}

.count_left {
	float: left;
}

.count_right {
	float: right;
}

.c_wrap {
	width: 100%;
	height: auto;
	overflow: hidden;
	margin: 0 auto;
}

.t_bg_wrap {
	width: 98%;
	height: 180px;
	float: left;
	background: url(<%=contextPath%>/images/dt_bg.png) repeat-x #f0ecec;
	margin: 10px 0 0 10px;
	border: 1px solid #e3e3e3;
}

.count_wrap {
	width: 98%;
	height: auto;
	overflow: hidden;
	float: left;
	margin: 10px 0 0 35px;
	display: inline;
}

.count_tr {
	width: 100%;
	height: 32px;
	float: left;
}

.count_jiao {
	background: url(<%=contextPath%>/images/right_bg.png) no-repeat;
	width: 40px;
	height: 165px;
	float: right;
	margin-top: -165px;
}

.count_title {
	width: 22%;
	min-width: 70px;
	float: left;
	line-height: 32px;
	color: #073d6b;
	text-align: left;
	height: 32px;
	font-size: 14px;
}

.count_type {
	width: 50%;
	min-width: 185px;
	line-height: 32px;
	float: left;
	height: 32px;
	font-size: 14px;
}

.count_number {
	float: left;
	width: 18px;
	height: 21px;
	border: 1px solid #d1dae3;
	background-color: #f5f5f5;
	display: block;
	color: #6395c7;
	line-height: 21px;
	font-size: 14px;
	text-align: center;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
	background: url(<%=contextPath%>/images/number_bg.png) repeat-x;
	margin: 4px 0 0 3px;
}

.count_title01 {
	background: url(<%=contextPath%>/images/bzdz_title.png) no-repeat;
	width: 100%;
	height: 30px;
	float: left;
	margin: 10px 0 0 10px;
	line-height: 30px;
}

.count_title02 {
	background: url(<%=contextPath%>/images/gzdtts_title.png) no-repeat;
	width: 100%;
	height: 30px;
	float: left;
	margin: 10px 0 0 10px;
	line-height: 30px;
}

.count_title20 {
	background: url(<%=contextPath%>/images/gzdtts_title1.png) no-repeat;
	width: 100%;
	height: 30px;
	float: left;
	margin: 10px 0 0 10px;
	line-height: 30px;
}

.count_title03 {
	background: url(<%=contextPath%>/images/zdry_title.png) no-repeat;
	width: 100%;
	height: 30px;
	float: left;
	margin: 10px 0 0 10px;
	line-height: 30px;
}

.count_title04 {
	background: url(<%=contextPath%>/images/sydw_title.png) no-repeat;
	width: 100%;
	height: 30px;
	float: left;
	margin: 10px 0 0 10px;
	line-height: 30px;
}

.count_title05 {
	background: url(<%=contextPath%>/images/syfw_title.png) no-repeat;
	width: 100%;
	height: 30px;
	float: left;
	margin: 10px 0 0 10px;
	line-height: 30px;
}

.count_number_red {
	float: left;
	width: 18px;
	height: 21px;
	border: 1px solid #f5c074;
	background-color: #f5f5f5;
	display: block;
	color: #ea3f11;
	line-height: 21px;
	font-size: 14px;
	text-align: center;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
	background: url(<%=contextPath%>/images/number_bg_red.png) repeat-x;
	margin: 4px 0 0 3px;
}

.count_comma {
	float: left;
	width: 6px;
	height: 21px;
	display: block;
	color: #6395c7;
	margin: 4px 0 0 3px;
	line-height: 21px;
	font-size: 14px;
	text-align: center;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
}

.count_comma_red {
	float: left;
	width: 6px;
	height: 21px;
	display: block;
	color: #ea3f11;
	margin: 4px 0 0 3px;
	line-height: 21px;
	font-size: 14px;
	text-align: center;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
}

.count_tiao {
	width: 15%;
	min-width: 30px;
	float: left;
	margin-left: 10px;
	font-size: 14px;
	color: #073d6b;
	line-height: 32px;
}

.c_t_wrap {
	width: 98%;
	height: auto;
	overflow: hidden;
	float: left;
	margin: 10px 0 0 10px;
}

.c_table {
	width: 100%;
	border: 1px solid #e8e8e8;
	height: auto;
	overflow: hidden;
}

.c_table tr.trBg {
	background-color: #f3f3f3
}

.c_table tr {
	background-color: #f9fcfc;
}

.c_table th {
	line-height: 30px;
	font-size: 12px;
	color: #324f85;
	background: url(<%=contextPath%>/images/tableTitle.png) repeat-x;
	font-weight: bold;
}

.c_table td {
	border-bottom: 1px dashed #e8e8e8;
	line-height: 30px;
	font-size: 12px;
	color: #000;
	font-weight: normal;
	text-align: center;
	background-color: #ffffff;
}

.c_table td.redText {
	color: #F00;
	background-color: #ffffe7;
}

.c_table td.tdgray {
	border-bottom: 1px dashed #eeeeee;
	line-height: 30px;
	font-size: 12px;
	color: #000;
	font-weight: normal;
	text-align: center;
	background-color: #f2f2f2;
}

.xxcx_wrap {
	width: 25%;
	height: 32px;
	float: right;
	line-height: 32px;
}

.btnBg {
	background: url(<%=contextPath%>/images/fdj_ico.png) no-repeat 10px
		center #007be3;
	color: #fff;
	font-weight: bold;
	line-height: 32px;
	font-size: 14px;
	border: 0px;
	width: 140px;
	height: 32px;
	cursor: pointer;
	text-indent: 45px;
	float: right;
}

.dept_wrap {
	width: 70%;
	float: left;
	height: 32px;
	margin-top: 5px;
}

.dept_text {
	font-size: 14px;
	color: #333;
	float: left;
	width: 70px;
	text-align: center;
	line-height: 32px;
}

.dept_Select {
	width: 300px;
	float: left;
	line-height: 32px;
}

.zongshu_table tr {
	height: 25px;
}

.zongshu_table th {
	font-size: 14px;
	color: #073d6b;
	line-height: 25px;
	text-align: right;
	font-weight: normal;
	width: 20%;
	min-width: 70px;
}

.zongshu_table td {
	font-size: 16px;
	color: #cc0000;
	font-weight: bold;
	width: 30%;
	min-width: 185px;
}

.td_count {
	font-size: 16px;
	color: #2e7bc9;
	font-family: "Times New Roman";
	line-height: 14px;
	width: auto;
	height: 14px;
	padding: 1px;
	background-color: #f7f7f7;
	text-align: center;
	border: 1px solid #d1dae3;
	letter-spacing: 2px;
}
</style>
<title></title>

<script type="text/javascript">
  var markerArr = new Array();
</script>
</head>
<body class="easyui-layout" data-options="fit:true"  onload="boydLoad()">
	<div class="c_t_wrap">
		<div>
			部门选择：<input type="text" name="orgList21" id="orgList21"  class="easyui-combobox" style="width:120px;" 
													data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
														valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList21_onChange">
					<input type="text" name="orgList22" id="orgList22"  class="easyui-combobox" style="width:120px;" 
											data-options="method:'get',
												valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList22_onChange">
				    <input type="text" name="orgList23" id="orgList23"  class="easyui-combobox" style="width:120px;" 
											data-options="method:'get',
												valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
				   <a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" onclick="fenxi();" group="">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">分析</span>
									<span class="l-btn-icon icon-reload"> </span>
								</span>
		</a>
		</div>
	</div>
	<div class="t_bg_wrap" style="width: 520px; height: 100px;overflow-x:hidden;margin-bottom: 8px;">
		<div
			style="width: 100%; height: auto; overflow: hidden; float: left;">
			<div class="count_title20"></div>
			<table cellpadding="0" cellspacing="0" width="100%"
				class="zongshu_table">
				<tr>
					<th style="font-size: 15px;margin-bottom: 10px;">实有人口：</th>
					<td><span class=" td_count" id="syrk"></span>
					</td>
					<th style="font-size: 15px;margin-bottom: 10px;">实有单位：</th>
					<td><span class=" td_count" id="sydw"></span>
					</td>
				</tr>
				<tr>
					<th style="font-size: 15px;">实有房屋：</th>
					<td><span class=" td_count" id="syfw"></span>
					</td>
					<th style="font-size: 15px;">重点人员：</th>
					<td><span class=" td_count" id="zdry"></span>
					</td>
				</tr>
				<tr>
					<th style="font-size: 15px;">门楼地址：</th>
					<td colspan="3"><span class=" td_count" id="bzdz"></span>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	
	
	<div class="t_bg_wrap" style="width: 520px; height: 100px;overflow-x:hidden;margin-bottom: 8px;">
		<div
			style="width: 100%; height: auto; overflow: hidden; float: left;">
			<div class="count_title02"></div>
			<table cellpadding="0" cellspacing="0" width="100%"
				class="zongshu_table">
				<tr>
					<th style="font-size: 15px;margin-bottom: 10px;">今日新增：</th>
					<td><span class=" td_count" id="rkAddCount"></span>
					</td>
					<th style="font-size: 15px;margin-bottom: 10px;">今日修改：</th>
					<td><span class=" td_count" id="rkEditCount"></span>
					</td>
			   </tr>
			   <tr>
					<th style="font-size: 15px;margin-bottom: 10px;">今日注销：</th>
					<td><span class=" td_count" id="rkDeleteCount"></span>
					</td>
			   </tr>
			</table>
		</div>
	</div>
	
	
	
	
	<div id="tt" class="easyui-tabs">
		<div title="整体情况">
			<div id="queryZtqkChart"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
var panduan = "<%=panduan%>"; 
var dwdm;
var orgDj = "<%=orgDj%>";
$('#tt').tabs({    
    border:false,
    width:$("#tt").parent().width(),
    height:$("#tt").parent().height()-225
}); 




//页面载入画点
function loadPoints(obj){
	//首先数组清空
	markerArr.splice(0,markerArr.length);
	if(typeof(parent.frames["biz_center"].GzjkMap)=="undefined"){
	}else{
		parent.frames["biz_center"].GzjkMap.clearMarkers();
	}
	var rows = $('#'+obj).datagrid("getRows");
	var len = rows.length;
	for(var i=0;i<len;i++){
		var title ="";
		if(rows[i].zbx!=null && rows[i].zbx!=""){
			var marker =null;
			if (IE) {
				marker =  parent.frames["biz_center"].addMarker(title,rows[i].zbx,rows[i].zby,"location.png",null,null,34,34,false,null,null);
			}
			else {
				var obj = parent.frames.document.getElementById("biz_center").contentWindow;
				marker = obj.addMarker(title,rows[i].zbx,rows[i].zby,"location.png",null,null,32,32,false,rows[i].jzdzdm,null);
			}
			markerArr[i] = marker;
		}else{
			//alert("人员无坐标");
		}
	};
}

function fenxi(){
	var zrq = $("#orgList23").val();
	var pcs = $("#orgList22").val();
	var fxj = $("#orgList21").val();
	if(zrq !=""){
		dwdm=zrq;
	}else if(pcs !=""){
		dwdm=pcs;
	}else if(fxj !=""){
		dwdm=fxj;
	}else{
		if(orgDj =="1"){
			dwdm="210200000000";
		}else if(orgDj =="2"){
			dwdm="<%=fxjdm%>";
		}else if(orgDj =="3"){
			dwdm="<%=pcsdm%>";
		}else if(orgDj =="4"){
			dwdm="<%=zrqdm%>";
		}
	}
	if(panduan == "false"){
		alert("无此权限！");
		return;
	}else{
		$.ajax({
			type:"POST",
			url:"<%=basePath%>gzjk/queryCount",
			dataType:"json",
			data:"dwdm="+dwdm,
			success:function(data) {
				if (data && data.gzdt) {
					$("#rkAddCount").text(data.gzdt.xz);//新增
					$("#rkEditCount").text(data.gzdt.xg);//修改
					$("#rkDeleteCount").text(data.gzdt.zx);//注销
					
					$("#syrk").text(data.gzdt.syrkCount);//注销
					$("#syfw").text(data.gzdt.syfwCount);//注销
					$("#sydw").text(data.gzdt.sydwCount);//注销
					$("#bzdz").text(data.gzdt.bzdzCount);//注销
					$("#zdry").text(data.gzdt.zdryCount);//注销
				}
			},
			complete:function() {
			},
			error:function() {
			}
		});	
	}
	showChart();
}
var orglevel = "<%=orglevel%>"; 
function boydLoad(){
	if(panduan=="false"){
		setInputReadonly('orgList21', true);
		setInputReadonly('orgList22', true);
		setInputReadonly('orgList23', true);
	}else{
		if(orgDj =="2"){//分局
			$("#orgList21").combobox("setValue","<%=fxjdm%>");
			setInputReadonly('orgList21', true);
		}else if(orgDj =="3"){//派出所
			$("#orgList21").combobox("setValue","<%=fxjdm%>");
			setInputReadonly('orgList21', true);
			
			$("#orgList22").combobox("setValue","<%=pcsdm%>");
			setInputReadonly('orgList22', true);
			
		}else if(orgDj =="4"){//责任区
			$("#orgList21").combobox("setValue","<%=fxjdm%>");
			setInputReadonly('orgList21', true);
			
			$("#orgList22").combobox("setValue","<%=pcsdm%>");
			setInputReadonly('orgList22', true);
			
			$("#orgList23").combobox("setValue","<%=zrqdm%>");
			setInputReadonly('orgList23', true);
		}
		
	}	
  
	fenxi();
	showChart();
}






function showChart(){
	var url = "<%=basePath%>/gzjk/queryZtqkChart?dwdm="+dwdm;
	swfobject.embedSWF("<%=basePath%>/js/tools/flashChart/open-flash-chart.swf","queryZtqkChart","100%","83%","9.0.0","expressInstall.swf",{"data-file":url},{wmode:"transparent"});
}




function orgList11_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList11').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList12').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#orgList12').combobox('reload', url);
	}
}

function orgList21_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList21').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList22').combobox('loadData', []);
		$('#orgList23').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#orgList22').combobox('reload', url);
	}
}

function orgList22_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList22').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList23').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=50&orgBizType=04&parentOrgCode=' + parentOrgCode;    
	    $('#orgList23').combobox('reload', url);
	}
}
</script>

</html>