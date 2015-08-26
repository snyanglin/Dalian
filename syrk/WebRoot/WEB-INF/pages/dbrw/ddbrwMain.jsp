<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>待督办任务</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/dbrw.css">
    <script type="text/javascript" src="<%=contextPath%>/js/dbrw/tab.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/flashChart/swfobject.js"></script>
    
    <script type="text/javascript">
    	<!--
    		
    	-->
    </script>
</head>
  
<body> 

<div id="mainDiv" style="padding:10px;">

	<div style="border:1px solid #dbdbdb; padding:10px; margin-bottom:10px; background-color: #FFFFFF; height:auto;">
		<div style="width:100%;">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td><img src="<%=contextPath%>/images/dbrw/dubanrenwu_title.png" width="123" height="40" />
					</td>
					<td align="right" valign="bottom" style="padding-right: 10px;">
						<div class="more">
							<a href="#" onclick="openDbrw('/dbrwVL/mainMore')">更多&gt;&gt;</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div style="width:100%; height:152px; overflow:hidden; border: 1px solid #dbdbdb;">
			<div style="width:100%; height:152px;">
				<table id="dbrwlist" class="easyui-datagrid" data-options="pagination:false,border:false"></table>
			</div>
		</div>
	</div>

	<div style="border:1px solid #dbdbdb; padding:10px; margin-bottom:10px; background-color: #FFFFFF; height:auto;">
		<div class="dbrwTitle" ><img src="<%=contextPath%>/images/dbrw/zhongdiangongzuo_title.jpg" width="123" height="40" /></div>
		
		<div class="title_son">
			<div class="title_son_text">重点人员</div>
			<div class="title_img"><img src="<%=contextPath%>/images/zhangkaiBtn.png" onclick="dispayHidden('syrk_zdryDiv')" width="10" height="8" onMouseOver="this.src='<%=contextPath%>/images/zhangkaiBtn_over.png'" onMouseOut="this.src='<%=contextPath%>/images/zhangkaiBtn.png'"  /></div>
			<div class="duban_time_wrap">
				<ul>
					<li class="default" id="zdry_wdb" onclick="dbztClick_zdry(this, 'wdb');">未督办</li>
					<li class="default" id="zdry_dbz" onclick="dbztClick_zdry(this, 'dbz');">督办中</li>
					<li class="default" id="zdry_ydb" onclick="dbztClick_zdry(this, 'ydb');">已督办</li>
				</ul>
			</div>
		</div> 
		<div id="syrk_zdryDiv" style="width:100%; height: 200;">
		    <div style="width: 28%; height:auto; float:left; overflow:hidden; padding-top: 25px;">
		        <div id="queryZdryChart" style="float:left;"></div>
		    </div>
		    <div style="width: 70%; padding-top: 10px; float: right; height:auto;">
		    	<div class="title_son_wrap" style="padding-right:10px;">
	           		<div class="red_title" id="zdryDivTitle"></div>
	           		<div class="more" id="syrk_zdryDbDiv"><a href='javascript:void(0)' onclick="addTask('${zdry}', 'zdry')" ><img src="<%=contextPath%>/images/dbrw/duban_btn.png"></a></div>
	          	</div>
		     	<div style="width:100%; height:152px; border: 1px solid #dbdbdb;">
					<table id="syrk_zdry" class="easyui-datagrid" data-options="pagination:false,border:false"></table>
		     	</div>
		    </div>
	    </div>

		<div class="title_son">
			<div class="title_son_text6">高危地区人员</div>
			<div class="title_img"><img src="<%=contextPath%>/images/zhangkaiBtn.png" onclick="dispayHidden('syrk_gwryDiv')" width="10" height="8" onMouseOver="this.src='<%=contextPath%>/images/zhangkaiBtn_over.png'" onMouseOut="this.src='<%=contextPath%>/images/zhangkaiBtn.png'"  /></div>
			<div class="duban_time_wrap">
				<ul>
					<li class="default" id="gwry_wdb" onclick="dbztClick_gwry(this, 'wdb')">未督办</li>
					<li class="default" id="gwry_dbz" onclick="dbztClick_gwry(this, 'dbz')">督办中</li>
					<li class="default" id="gwry_ydb" onclick="dbztClick_gwry(this, 'ydb')">已督办</li>
				</ul>
			</div>
		</div> 
		<div id="syrk_gwryDiv" style="width:100%; height: 200;">
		    <div style="width: 28%; height:auto; float:left; overflow:hidden; padding-top: 25px;">
		        <div id="queryGwryChart" style="float:left;"></div>
		    </div>
		    <div style="width: 70%; padding-top: 10px; float: right; height:auto;">
		    	<div class="title_son_wrap" style="padding-right:10px;">
	           		<div class="red_title" id="gwryDivTitle"></div>
	           		<div class="more" id="syrk_gwryDbDiv"><a href='javascript:void(0)' onclick="addTask('${gwry}', 'gwry')" ><img src="<%=contextPath%>/images/dbrw/duban_btn.png"></a></div>
	          	</div>
		     	<div style="width:100%; height:152px; border: 1px solid #dbdbdb;">
					<table id="syrk_gwry" class="easyui-datagrid" data-options="pagination:false,border:false"></table>
		     	</div>
		    </div>
	    </div>
	    
	    <div class="title_son">
			<div class="title_son_text">实有人口</div>
			<div class="title_img"><img src="<%=contextPath%>/images/zhangkaiBtn.png" onclick="dispayHidden('syrkDiv')" width="10" height="8" onMouseOver="this.src='<%=contextPath%>/images/zhangkaiBtn_over.png'" onMouseOut="this.src='<%=contextPath%>/images/zhangkaiBtn.png'"  /></div>
			<div class="duban_time_wrap">
				<ul>
					<li class="default" id="syrk_wdb" onclick="dbztClick_syrk(this, 'wdb')">未督办</li>
					<li class="default" id="syrk_dbz" onclick="dbztClick_syrk(this, 'dbz')">督办中</li>
					<li class="default" id="syrk_ydb" onclick="dbztClick_syrk(this, 'ydb')">已督办</li>
				</ul>
			</div>
		</div> 
		<div id="syrkDiv" style="width:100%; overflow:hidden; height: 182; border-left: 1px solid #dbdbdb; border-right: 1px solid #dbdbdb; border-bottom: 1px solid #dbdbdb;">
			<div class="tabTitle">
				<ul id="tz_">
					<li class="hovertab" id="tz_1" onclick="HoverLi(1);">未知居住地户籍人员（${syrk_wzjzdCount }）</li>
					<li class="normaltab" id="tz_2" onclick="HoverLi(2);">无业人员（${syrk_wyryCount }）</li>
					<li class="normaltab" id="tz_3" onclick="HoverLi(3);">有业无居住地人员（${syrk_yywjzdCount }）</li>
				</ul>
				<div id="syrkDbDiv" style="width:70px; font-size:12px; color:#999999; float:right; text-align:center; padding-top:4px; padding-right:6px;"><a href='javascript:void(0)' onclick="addTaskSyrk()" ><img src="<%=contextPath%>/images/dbrw/duban_btn.png"></a></div>
			</div>
			<div id="tzc_01" loaded="true">
				<div style="width:100%; height:152px;">
			    	<table id="syrk_wzjzdhjry"></table>  
			    </div>
			</div>
	        <div id="tzc_02" class="rwdb_undis">
	        	<div style="width:100%; height:152px;">
	         		<table id="syrk_wyry"></table> 
	         	</div>
	        </div>
	        <div id="tzc_03" class="rwdb_undis">
	        	<div style="width:100%; height:152px;">
	          		<table id="syrk_yywjzdry"></table> 
	          	</div>
	        </div>
	    </div>
	    
		<div class="title_son">
			<div class="title_son_text">实有单位</div>
			<div class="title_img"><img src="<%=contextPath%>/images/zhangkaiBtn.png" onclick="dispayHidden('sydwlistDiv')" width="10" height="8" onMouseOver="this.src='<%=contextPath%>/images/zhangkaiBtn_over.png'" onMouseOut="this.src='<%=contextPath%>/images/zhangkaiBtn.png'"  /></div>
			<div class="duban_time_wrap">
				<ul>
					<li class="default" id="sydw_wdb" onclick="dbztClick_sydw(this, 'wdb')">未督办</li>
					<li class="default" id="sydw_dbz" onclick="dbztClick_sydw(this, 'dbz')">督办中</li>
					<li class="default" id="sydw_ydb" onclick="dbztClick_sydw(this, 'ydb')">已督办</li>
				</ul>
			</div>
		</div> 
		<div id="sydwlistDiv" style="width:100%; height: 200;">
		    <div style="width: 28%; height:auto; float:left; overflow:hidden; padding-top: 25px;">
		        <div id="querySydwChart" style="float:left;"></div>
		    </div>
		    <div style="width: 70%; padding-top: 10px; float: right; height:auto;">
		    	<div class="title_son_wrap" style="padding-right:10px;">
	           		<div class="red_title" id="sydwDivTitle"></div>
	           		<div class="more" id="sydwlistDbDiv"><a href='javascript:void(0)' onclick="addTaskSydw()" ><img src="<%=contextPath%>/images/dbrw/duban_btn.png"></a></div>
	          	</div>
		     	<div style="width:100%; height:152px; border: 1px solid #dbdbdb;">
					<table id="sydwlist" class="easyui-datagrid" data-options="pagination:false,border:false"></table>
		     	</div>
		    </div>
	    </div>

		<div class="title_son">
			<div class="title_son_text">实有房屋</div>
			<div class="title_img"><img src="<%=contextPath%>/images/zhangkaiBtn.png" onclick="dispayHidden('syfwlistDiv')" width="10" height="8" onMouseOver="this.src='<%=contextPath%>/images/zhangkaiBtn_over.png'" onMouseOut="this.src='<%=contextPath%>/images/zhangkaiBtn.png'"  /></div>
			<div class="duban_time_wrap">
				<ul>
					<li class="default" id="syfw_wdb" onclick="dbztClick_syfw(this, 'wdb')">未督办</li>
					<li class="default" id="syfw_dbz" onclick="dbztClick_syfw(this, 'dbz')">督办中</li>
					<li class="default" id="syfw_ydb" onclick="dbztClick_syfw(this, 'ydb')">已督办</li>
				</ul>
			</div>
		</div> 
		<div id="syfwlistDiv" style="width:100%; height: 200;">
		    <div style="width: 28%; height:auto; float:left; overflow:hidden; padding-top: 25px;">
		        <div id="querySyfwChart" style="float:left;"></div>
		    </div>
		    <div style="width: 70%; padding-top: 10px; float: right; height:auto;">
		    	<div class="title_son_wrap" style="padding-right:10px;">
	           		<div class="red_title" id="syfwDivTitle"></div>
	           		<div class="more" id="syfwlistDbDiv"><a href='javascript:void(0)' onclick="addTaskSyfw()" ><img src="<%=contextPath%>/images/dbrw/duban_btn.png"></a></div>
	          	</div>
		     	<div style="width:100%; height:152px; border: 1px solid #dbdbdb;">
					<table id="syfwlist" class="easyui-datagrid" data-options="pagination:false,border:false"></table>
		     	</div>
		    </div>
	    </div>

		<!-- 
	    <div class="title_son">
			<div class="title_son_text">标准地址</div>
			<div class="title_img"><img src="<%=contextPath%>/images/zhangkaiBtn.png" onclick="dispayHidden('bzdzDiv')" width="10" height="8" onMouseOver="this.src='<%=contextPath%>/images/zhangkaiBtn_over.png'" onMouseOut="this.src='<%=contextPath%>/images/zhangkaiBtn.png'"  /></div>
			<div class="duban_time_wrap">
				<ul>
					<li class="default" id="bzdz_wdb" onclick="dbztClick_bzdz(this, 'wdb')">未督办</li>
					<li class="default" id="bzdz_dbz" onclick="dbztClick_bzdz(this, 'dbz')">督办中</li>
					<li class="default" id="bzdz_ydb" onclick="dbztClick_bzdz(this, 'ydb')">已督办</li>
				</ul>
			</div>
		</div> 
		<div id="bzdzDiv" style="width:100%; overflow:hidden; height: 182; border-left: 1px solid #dbdbdb; border-right: 1px solid #dbdbdb; border-bottom: 1px solid #dbdbdb;">
			<div class="tabTitle">
				<ul id="dz_" >
					<li class="hovertab" id="dz_1" onclick="HoverLiDz(1);">未标注门楼牌（${bzdz_wbzmlpCount }）</li>
					<li class="normaltab" id="dz_2" onclick="HoverLiDz(2);">无层户门楼牌（${bzdz_wchmlpCount }）</li>
					<li class="normaltab" id="dz_3" onclick="HoverLiDz(3);">无人居住建筑物（${bzdz_wrjzjzwCount }）</li>
					<li class="normaltab" id="dz_4" onclick="HoverLiDz(4);">无标准地址对应户籍（${bzdz_wbzdzdyhjdzCount }）</li>
					<li class="normaltab" id="dz_5" onclick="HoverLiDz(5);">缺少的门楼牌号（${bzdz_qsdmlphCount }）</li>
				</ul>
				<div id="bzdzDbDiv" style="width:60px; font-size:12px; color:#999999; line-height:32px; float:right; text-align:center; padding-top:4px;"><a href='javascript:void(0)' onclick="addTaskBzdz()" ><img src="<%=contextPath%>/images/dbrw/duban_btn.png"></a></div>
			</div>
			<div id="dzc_01" loaded="true">
				<div style="width:100%; height:152px;">
			    	<table id="bzdz_wbzmlp"></table>  
			    </div>
			</div>
	        <div id="dzc_02" class="rwdb_undis">
	        	<div style="width:100%; height:152px;">
	         		<table id="bzdz_wchmlp"></table> 
	         	</div>
	        </div>
	        <div id="dzc_03" class="rwdb_undis">
	        	<div style="width:100%; height:152px;">
	          		<table id="bzdz_wrjzjzw"></table> 
	          	</div>
	        </div>
	        <div id="dzc_04" class="rwdb_undis">
	        	<div style="width:100%; height:152px;">
	          		<table id="bzdz_wbzdzdyhjdz"></table> 
	          	</div>
	        </div>
	        <div id="dzc_05" class="rwdb_undis">
	        	<div style="width:100%; height:152px;">
	          		<table id="bzdz_qsdmlph"></table> 
	          	</div>
	        </div>
	    </div>
	     -->
 
	</div>

 
	<div style="border:1px solid #dbdbdb; padding:10px; margin-bottom:10px; background-color: #FFFFFF; height:auto;">
		<div style="width:100%;">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td><img src="<%=contextPath%>/images/dbrw/richangdongtai_title.png" width="123" height="40" /></td>
					<td align="right" valign="bottom" style="padding-right: 10px;">
					</td>
				</tr>
			</table>
		</div>
		
		
		<div class="title_son">
			<div style="font-size:14px; color:#474747; font-weight:bold; line-height:32px;">统计图/纠错统计</div>
		</div> 
		<div style="width:100%; height: 348;">
			
  			<div class="duban_time_wrap" style="width: 60%; height:auto; float:left; overflow:hidden; padding-top: 20px;">
	            <ul>
					<li class="default" id="a" onclick="changeCensuss(this, 'Total')">综合</li>
					<li class="default" id="b" onclick="changeCensuss(this, 'Syrk')">实有人口</li>
					<li class="default" id="c" onclick="changeCensuss(this, 'Zdry')">重点人员</li>
					<li class="default" id="d" onclick="changeCensuss(this, 'Sydw')">实有单位</li>
					<li class="default" id="e" onclick="changeCensuss(this, 'Sydw')">实有房屋</li>
					<li class="default" id="f" onclick="changeCensuss(this, 'Bzdz')">标准地址</li>
				</ul>
				<div style="width:100%; height:300px; overflow:hidden; border: 1px solid #dbdbdb;">
					<iframe id="iframes" width="100%" height="100%" nosize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/sqjw%7CflashChartCensus"></iframe>
				</div>
			</div>
		  	<div style="width: 39%; height:auto; float: right; overflow:hidden; padding-top: 20px;">
		   		<div style="height: 25px;"></div>
		   		<div id="tableDiv" style="width:100%; height:300px; border: 1px solid #dbdbdb;">
					<table id="jctj" class="easyui-datagrid" data-options="pagination:false,border:false,method:'get',
							url: '<%=request.getContextPath()%>/dbrwMain/queryJctjList',
							fitColumns:true,
							pageSize:5,
							pageList:[5]">
					    <thead>
					        <tr>
					         <th data-options="field:'fqrbmid',width:100,align:'right',halign:'center',hidden:true">部门Id</th>
					            <th data-options="field:'fqrbm',width:100,align:'right',halign:'center'">部门</th>
					            <th data-options="field:'yearsum_fq',width:100,align:'center',halign:'center',formatter:openJctjDetailUrlByFqrbmid">本月纠错次数</th>
					            <th data-options="field:'monthsum_fq',width:100,align:'center',halign:'center',formatter:openJctjDetailUrlByFqrbmid">本年度纠错次数</th>
					         <th data-options="field:'yearsum_cl',width:100,align:'center',halign:'center',formatter:openJctjDetailUrlByClrbmid">本月被纠错次数</th>
					            <th data-options="field:'monthsum_cl',width:100,align:'center',halign:'center',formatter:openJctjDetailUrlByClrbmid">本年度被纠错次数</th>
					        </tr>
					    </thead>
					</table>
		   		</div>
	  		</div>
 		</div>
 
	</div>
	
</div>

<script type="text/javascript" >
var syrk_dbztCard = "";
var syrk_dbbutton = "${syrk_wzjzd}";
var bzdz_dbztCard = "";
var bzdz_dbbutton = "${bzdz_wbzmlp}";

var figConditions = {};  
	

var addTaskSydw_dbmxid = "";//实有单位督办模型id
var addTaskSyfw_dbmxid = "";//实有房屋督办模型id

var syrkSelected = 1;
var bzdzSelected = 1;

function refreshMain() {
	location.href =  contextPath + '/dbrwMain/main';
}

function getWindowSize() { // 兼容模式下取浏览器窗口有效高度（去除上下菜单、边框等）
	var _pageWidth = window.innerWidth;
	var _pageHeight = window.innerHeight;
	var scrollHeight = 0;
	if (typeof _pageWidth != "number"){ 
		if(document.compatMode == "number"){ 
			_pageWidth = document.documentElement.clientWidth; 
			_pageHeight = document.documentElement.clientHeight; 
		}
		else{ 
			_pageWidth = document.body.clientWidth; 
			_pageHeight = document.body.clientHeight; 
		} 
	}
	if (document.documentElement && document.documentElement.scrollHeight) {
		scrollHeight = document.documentElement.scrollHeight;
	}
	else {
		scrollHeight = document.body.scrollHeight;
	}
	return {width: _pageWidth,height: _pageHeight,scrollHeight: scrollHeight};
}

function bodyResize() {
	var windowSize = getWindowSize();
	if (windowSize.scrollHeight > windowSize.height) {
		document.getElementById('mainDiv').style.width = windowSize.width - 38;
	}
	else {
		document.getElementById('mainDiv').style.width = windowSize.width - 20;
	}
}

$(document).ready(function(){
	
	if (!IE) {
		bodyResize();
	}
	
	$(window).resize(function() {
		if (!IE) {
			bodyResize();
		}
		$("#dbrwlist").datagrid('resize', {});
		$("#syrk_zdry").datagrid('resize', {});
		$("#syrk_gwry").datagrid('resize', {});
		$("#sydwlist").datagrid('resize', {});
		$("#syfwlist").datagrid('resize', {});
		
		$("#jctj").datagrid('resize', {});
		
		if (syrkSelected == 1) {
			$("#syrk_wzjzdhjry").datagrid('resize', {});
		}
		else if (syrkSelected == 2) {
			$("#syrk_wyry").datagrid('resize', {});
		}
		else if (syrkSelected == 3) {
			$("#syrk_yywjzdry").datagrid('resize', {});
		}

		/*
		if (bzdzSelected == 1) {
			$("#bzdz_wbzmlp").datagrid('resize', {});
		}
		else if (bzdzSelected == 2) {
			$("#bzdz_wchmlp").datagrid('resize', {});
		}
		else if (bzdzSelected == 3) {
			$("#bzdz_wrjzjzw").datagrid('resize', {});
		}
		else if (bzdzSelected == 4) {
			$("#bzdz_wbzdzdyhjdz").datagrid('resize', {});
		}
		else if (bzdzSelected == 5) {
			$("#bzdz_qsdmlph").datagrid('resize', {});
		}
		*/
		
	});
	
    $("#dbrwlist").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDbrwList",
		method:'get',
		pagination:false,
		fitColumns:true,
		border:false,
		pageSize:5,
		pageList:[5],
	    columns:[[   
	        {field:"rwbt",title:"任务标题",width:200,align:'left',halign:'center',formatter:dbrwStyler }, 
	        {field:"dbrwfqdwmc",title:"督办任务发起单位",width:100,halign:'center'},
	        {field:"rwfqsj",title:"任务发起时间",width:100,align:'center',halign:'center'},
	        {field:"rwkssj",title:"任务开始时间",width:100,align:'center',halign:'center'},  
	        {field:"rwjssj",title:"任务结束时间",width:100,align:'center',halign:'center'}, 
	        {field:"rwsm",title:"任务说明",width:100,align:'center',halign:'center'}, 
	        {field:"rwsjzl",title:"任务数据总量",width:50,align:'center',halign:'center'}, 
	        {field:"rwzt",title:"任务状态",width:50,align:'center',halign:'center', formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DBRW_RWZT.js'},
	        {field:'true',title:'操作',width:40,align:'center',formatter:selectDbrwmx} 
    	]]
	});

    var vdata = new Date();
	var mili = vdata.getMilliseconds();
	
	tzc_01_Load("${syrkDbzt}");
	dbztClick("syrk_${syrkDbzt}");
	syrk_dbztCard = "${syrkDbzt}";
	if ('${syrkDbzt}' == "wdb") {
		$('#syrkDbDiv').show();
	}
	else {
		$('#syrkDbDiv').hide();
	}
	
	showZdryList("重点人员（${zdryCount }）", "9AD87AE4A63F4B089F52544CC3E4B07E", "all", "${zdryDbzt}");
	dbztClick("zdry_${zdryDbzt}");
	 //重点人员饼状图
	swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","queryZdryChart","100%","168px;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/dbrwMain/queryZdryChart?dbzt=${zdryDbzt}&time="+mili},{wmode:"transparent"});
	if ('${zdryDbzt}' == "wdb") {
		$('#syrk_zdryDbDiv').show();
	}
	else {
		$('#syrk_zdryDbDiv').hide();
	}
	
	showGwryList("高危地区人员（${gwdqCount }）", "DC4A5D794B2D42E9862B5B978D1B21BA", "all", "${gwdqDbzt}");
	dbztClick("gwry_${gwdqDbzt}");
	//高危人员柱状图
	swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","queryGwryChart","100%","168px;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/dbrwMain/queryGwryChart?dbzt=${gwdqDbzt}&time="+mili},{wmode:"transparent"});
	if ('${gwdqDbzt}' == "wdb") {
		$('#syrk_gwryDbDiv').show();
	}
	else {
		$('#syrk_gwryDbDiv').hide();
	}
	
	showSydwList("${sydwVo.name}（${sydwVo.zs}）", "${sydwVo.typev}", "${sydwVo.dbmxid}", "${sydwVo.dbzt}");
	dbztClick("sydw_${sydwVo.dbzt}");
	//实有单位饼状图
	swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","querySydwChart","100%","168px;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/dbrwMain/querySydwChart?dbzt=${sydwVo.dbzt}&time="+mili},{wmode:"transparent"});
	if ('${sydwVo.dbzt}' == "wdb") {
		$('#sydwlistDbDiv').show();
	}
	else {
		$('#sydwlistDbDiv').hide();
	}
	
	showSyfwList("${syfwVo.typev}", "${syfwVo.dbmxid}", "${syfwVo.name}（${syfwVo.zs}）", "${syfwVo.dbzt}");
	dbztClick("syfw_${syfwVo.dbzt}");
	//实有房屋饼状图
	swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","querySyfwChart","100%","168px;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/dbrwMain/querySyfwChart?dbzt=${syfwVo.dbzt}&time="+mili},{wmode:"transparent"});
	if ('${syfwVo.dbzt}' == "wdb") {
		$('#syfwlistDbDiv').show();
	}
	else {
		$('#syfwlistDbDiv').hide();
	}
	
	/*
	dzc_01_Load("${bzdzDbzt}");
	dbztClick("bzdz_${bzdzDbzt}");
	bzdz_dbztCard = "${bzdzDbzt}";
	if ('${bzdzDbzt}' == "wdb") {
		$('#bzdzDbDiv').show();
	}
	else {
		$('#bzdzDbDiv').hide();
	}
	*/
	
	//setTimeout("init()", 3000);
	//默认曲线图显示综合，颜色为蓝色选中颜色
	changeCensuss(document.getElementById("a"), 'Total');
});

function dbrwStyler(value, rowData, index){
	return "<font style='font-weight:bold;'>"+value+"</font>";
}

function init() {
	//$(window).resize();
}

//督办任务查询按钮
function selectDbrwmx(val,row,index){
	var url = "/dbrwVL/main?id="+row["id"];
	return '<div id="dbrwck" class="dbrwck" ><a href="javascript:void(0)" onclick="openDbrw(\''+url+'\')")>查看</a></div>';
}

/**
 * 
 * @Description: TODO(未知居住地户籍人员)
 * @param dbzt 督办状态
 * @throws
 */
function tzc_01_Load(dbzt) {
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"身份证号",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"姓名",width:50,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"性别",width:50,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"年龄",width:50,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"户籍地址",width:150,halign:'center'}, 
	        {field:"ddbsjx6",title:"居住地址",width:150,halign:'center'},
	        {field:'true',title:'操作',width:40,align:'center',formatter:openSyrkSelectUrl} 
	    ]];
	}else{
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"身份证号",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"姓名",width:50,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"性别",width:50,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"年龄",width:50,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"户籍地址",width:150,halign:'center'}, 
	        {field:"ddbsjx6",title:"居住地址",width:150,halign:'center'},
	        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
	        {field:'true',title:'操作',width:40,align:'center',formatter:openSyrkSelectUrl} 
	    ]];
	}

	$("#syrk_wzjzdhjry").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid=F86AE4A6E6754464A8AB3EF48D1D5F6E",
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data 
	}); 
	
	tzc_01_Load_count(dbzt, "F86AE4A6E6754464A8AB3EF48D1D5F6E");
}
function tzc_01_Load_count(dbzt, dbmxid){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwMain/getTypeCount",
		dataType:"json",
		data:"dbzt="+dbzt+"&dbmxid="+dbmxid,
		success:function(data){
			var name = $("#tz_1").html();
			var newName = name.substr(0, name.indexOf("（"))+"（"+data.count+"）";
			$("#tz_1").html(newName);
		}
	});
}

/**
 * 
 * @Description: TODO(无业人员)
 * @param dbzt 督办状态
 * @throws
 */
function tzc_02_Load(dbzt) {
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
			{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			{field:"ddbsjx1",title:"身份证号",width:100,align:"center",halign:'center'}, 
			{field:"ddbsjx2",title:"姓名",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx3",title:"性别",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx4",title:"年龄",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx5",title:"户籍地址",width:150,halign:'center'}, 
			{field:"ddbsjx6",title:"居住地址",width:150,halign:'center'}, 
			{field:"ddbsjx7",title:"联系电话",width:100,halign:'center'},
			{field:'true',title:'操作',width:40,align:'center',formatter:openSyrkSelectUrl} 
	    ]];
	}else{
		data = [[    
			{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			{field:"ddbsjx1",title:"身份证号",width:100,align:"center",halign:'center'}, 
			{field:"ddbsjx2",title:"姓名",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx3",title:"性别",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx4",title:"年龄",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx5",title:"户籍地址",width:150,halign:'center'}, 
			{field:"ddbsjx6",title:"居住地址",width:150,halign:'center'}, 
			{field:"ddbsjx7",title:"联系电话",width:100,halign:'center'},
			{field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
			{field:'true',title:'操作',width:40,align:'center',formatter:openSyrkSelectUrl} 
	    ]];
	}
	
	$("#syrk_wyry").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid=A7D9858777F146DA80D9C0D426E94B1C",
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data 
	}); 
	
	tzc_02_Load_count(dbzt, "A7D9858777F146DA80D9C0D426E94B1C");
}
function tzc_02_Load_count(dbzt, dbmxid){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwMain/getTypeCount",
		dataType:"json",
		data:"dbzt="+dbzt+"&dbmxid="+dbmxid,
		success:function(data){
			var name = $("#tz_2").html();
			var newName = name.substr(0, name.indexOf("（"))+"（"+data.count+"）";
			$("#tz_2").html(newName);
		}
	});
}

/**
 * 
 * @Description: TODO(有业无居住地人员)
 * @param dbzt 督办状态
 * @throws
 */
function tzc_03_Load(dbzt) {
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
			{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			{field:"ddbsjx1",title:"身份证号",width:100,align:"center",halign:'center'}, 
			{field:"ddbsjx2",title:"姓名",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx3",title:"性别",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx4",title:"年龄",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx5",title:"工作单位",width:150,halign:'center'}, 
			{field:"ddbsjx6",title:"户籍地址",width:150,halign:'center'}, 
			{field:"ddbsjx7",title:"联系电话",width:100,halign:'center'},
			{field:'true',title:'操作',width:40,align:'center',formatter:openSyrkSelectUrl} 
	    ]];
	}else{
		data = [[    
			{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			{field:"ddbsjx1",title:"身份证号",width:100,align:"center",halign:'center'}, 
			{field:"ddbsjx2",title:"姓名",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx3",title:"性别",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx4",title:"年龄",width:50,align:"center",halign:'center'}, 
			{field:"ddbsjx5",title:"工作单位",width:150,halign:'center'}, 
			{field:"ddbsjx6",title:"户籍地址",width:150,halign:'center'}, 
			{field:"ddbsjx7",title:"联系电话",width:100,halign:'center'},
			{field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
			{field:'true',title:'操作',width:40,align:'center',formatter:openSyrkSelectUrl} 
	    ]];
	}
	
	$("#syrk_yywjzdry").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid=718DD320402249BB99B6840926EE8408",
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data 
	});
	
	tzc_03_Load_count(dbzt, "718DD320402249BB99B6840926EE8408");
}
function tzc_03_Load_count(dbzt, dbmxid){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwMain/getTypeCount",
		dataType:"json",
		data:"dbzt="+dbzt+"&dbmxid="+dbmxid,
		success:function(data){
			var name = $("#tz_3").html();
			var newName = name.substr(0, name.indexOf("（"))+"（"+data.count+"）";
			$("#tz_3").html(newName);
		}
	});
}

//查询列表“查看”打开url
function openSyrkSelectUrl(val,row,index){
	var url = row["dataurl"];
	if (url == null || url == "") {
		return "";
	}
	else {
		var menuTitle = row['ddbsjx2'];
		if (menuTitle == null || menuTitle == "") {
			menuTitle = "查看信息";
		}
		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\""+ menuTitle +"\", \""+url+"\")')>查看</a></div>";
	}
}

function openJctjDetailUrlByFqrbmid(val,row,index){
	var fqrbmid = row["fqrbmid"];
	var url = "/RuleYwxtgzrwlsjlb/showList?fqrbmid="+fqrbmid;
	return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"纠错信息详细列表\", \""+url+"\")')>"+val+"</a></div>";
	
	
}
function openJctjDetailUrlByClrbmid(val,row,index){
	var rwclrbmid = row["fqrbmid"];
	var url = "/RuleYwxtgzrwlsjlb/showList?rwclrbmid="+rwclrbmid;
	return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"纠错信息详细列表\", \""+url+"\")')>"+val+"</a></div>";
	
	
}

/**
 * 
 * @Description: TODO(实有房屋)
 * @param type 实有房屋类型
 * @param dbmxid 待办模型id
 * @param name 待办列表名称
 * @param dbzt 督办状态
 * @throws
 */
function showSyfwList(type, dbmxid, name, dbzt){ 
	 
	var newName = name;
	if(name.indexOf("（") != -1){
		newName = name.substr(0, name.indexOf("（"));
	}
	var url = "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid="+dbmxid;
	var data = [];
	if(type == "wrjz"){//无人居住
		addTaskSyfw_dbmxid = "${syfw_wrjz}";
		if(dbzt == "wdb"){
			data = [[    
			         {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			         {field:"ddbsjx1",title:"房屋地址",width:280,halign:'center'}, 
			         {field:"ddbsjx2",title:"面积",width:70,align:"center",halign:'center'}, 
			         {field:"ddbsjx3",title:"房屋类型",width:100,align:"center",halign:'center'}, 
			         {field:"ddbsjx4",title:"房屋结构",width:100,halign:'center'}, 
			         {field:"ddbsjx5",title:"房屋用途",width:150,halign:'center'},
			         {field:'true',title:'操作',width:40,align:'center',formatter:openSyfwSelectUrl} 
			     ]] ;
		}else{
			data = [[    
			         {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			         {field:"ddbsjx1",title:"房屋地址",width:280,halign:'center'}, 
			         {field:"ddbsjx2",title:"面积",width:70,align:"center",halign:'center'}, 
			         {field:"ddbsjx3",title:"房屋类型",width:100,align:"center",halign:'center'}, 
			         {field:"ddbsjx4",title:"房屋结构",width:100,halign:'center'}, 
			         {field:"ddbsjx5",title:"房屋用途",width:150,halign:'center'},
			         {field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
			         {field:'true',title:'操作',width:40,align:'center',formatter:openSyfwSelectUrl} 
			     ]] ;
		}
	}
	if(type == "dj"){//独居出租房屋
		addTaskSyfw_dbmxid = "${syfw_dj}";
		if(dbzt == "wdb"){
			data = [[    
			        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			        {field:"ddbsjx1",title:"房屋地址",width:200,halign:'center'}, 
			        {field:"ddbsjx2",title:"面积",width:50,align:"center",halign:'center'}, 
			        {field:"ddbsjx3",title:"居住人身份证号",width:100,align:"center",halign:'center'}, 
			        {field:"ddbsjx4",title:"姓名",width:50,align:"center",halign:'center'}, 
			        {field:"ddbsjx5",title:"性别",width:50,align:"center",halign:'center'}, 
			        {field:"ddbsjx6",title:"年龄",width:50,align:"center",halign:'center'}, 
			        {field:"ddbsjx7",title:"户籍地址",width:150,halign:'center'}, 
			        {field:"ddbsjx8",title:"工作单位",width:100,halign:'center'}, 
			        {field:"ddbsjx9",title:"联系电话",width:100,halign:'center'},
			        {field:'true',title:'操作',width:40,align:'center',formatter:openSyfwSelectUrl} 
				 ]]  ;
		}else{
			data = [[    
			        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			        {field:"ddbsjx1",title:"房屋地址",width:200,halign:'center'}, 
			        {field:"ddbsjx2",title:"面积",width:50,align:"center",halign:'center'}, 
			        {field:"ddbsjx3",title:"居住人身份证号",width:100,align:"center",halign:'center'}, 
			        {field:"ddbsjx4",title:"姓名",width:50,align:"center",halign:'center'}, 
			        {field:"ddbsjx5",title:"性别",width:50,align:"center",halign:'center'}, 
			        {field:"ddbsjx6",title:"年龄",width:50,align:"center",halign:'center'}, 
			        {field:"ddbsjx7",title:"户籍地址",width:150,halign:'center'}, 
			        {field:"ddbsjx8",title:"工作单位",width:100,halign:'center'}, 
			        {field:"ddbsjx9",title:"联系电话",width:100,halign:'center'},
			        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
			        {field:'true',title:'操作',width:40,align:'center',formatter:openSyfwSelectUrl} 
				 ]]  ;
		}
	}
	if(type == "qj"){//群居出租房屋
		addTaskSyfw_dbmxid = "${syfw_qj}";
		if(dbzt == "wdb"){
			data = [[    
			         {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			         {field:"ddbsjx1",title:"房屋地址",width:300,halign:'center'}, 
			         {field:"ddbsjx2",title:"面积",width:100,align:"center",halign:'center'}, 
			         {field:"ddbsjx3",title:"现居住人数",width:100,halign:'center'}, 
			         {field:"ddbsjx4",title:"现居住人信息",width:200,halign:'center'},
			         {field:'true',title:'操作',width:40,align:'center',formatter:openSyfwSelectUrl} 
			     ]];
		}else{
			data = [[    
		         {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
		         {field:"ddbsjx1",title:"房屋地址",width:300,halign:'center'}, 
		         {field:"ddbsjx2",title:"面积",width:100,align:"center",halign:'center'}, 
		         {field:"ddbsjx3",title:"现居住人数",width:100,halign:'center'}, 
		         {field:"ddbsjx4",title:"现居住人信息",width:200,halign:'center'},
		         {field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
		         {field:'true',title:'操作',width:40,align:'center',formatter:openSyfwSelectUrl} 
		     ]];
		}
	}
	
	$("#syfwlist").datagrid({    
		url: url,
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns: data,
    	onLoadSuccess: function(data) {
    		$("#syfwDivTitle").html(newName+"（"+data.total+"）");
		} 
	});
}	

//查询列表“查看”打开url
function openSyfwSelectUrl(val,row,index){
	var url = row["dataurl"];
	if (url == null || url == "") {
		return "";
	}
	else {
		var menuTitle = row['ddbsjx1'];
		if (menuTitle == null || menuTitle == "") {
			menuTitle = "查看信息";
		}
		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\""+ menuTitle +"\", \""+url+"\")')>查看</a></div>";
	}
}

/**
 * 
 * @Description: TODO(高危人员列表)
 * @param name 待办列表名称
 * @param dbmxid 待办模型id
 * @param urlType 查询范围（all-查询所有）
 * @param dbzt 督办状态
 * @throws
 */
function showGwryList(name, dbmxid, urlType, dbzt){
	var newName = name;
	if(name.indexOf("（") != -1){
		newName = name.substr(0, name.indexOf("（"));
	}
	
	figConditions['gwry'] = "&ddbsjx1="+newName;

	var url = encodeURI("<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid="+dbmxid+"&ddbsjx1="+newName);
	if(urlType == "all"){
		url = encodeURI("<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid="+dbmxid);
		figConditions['gwry'] = "";
	}
	
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
  	      	{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			{field:"ddbsjx1",title:"高危地区",width:100,align:"center",halign:'center'},
            {field:"ddbsjx2",title:"身份证号",width:100,align:"center",halign:'center'},
  	        {field:"ddbsjx3",title:"姓名",width:50,align:"center",halign:'center'},
  	        {field:"ddbsjx4",title:"性别",width:50,align:"center",halign:'center'},
  	        {field:"ddbsjx5",title:"年龄",width:40,align:"center",halign:'center'},
  	        {field:"ddbsjx6",title:"户籍地址",width:150,halign:'center'},
  	        {field:"ddbsjx7",title:"居住地址",width:150,halign:'center'},
  	        {field:"ddbsjx8",title:"工作单位",width:100,halign:'center'},
  	        {field:"ddbsjx9",title:"联系电话",width:100,halign:'center'},
  	        {field:'true',title:'操作',width:40,align:'center',formatter:openGyrwSelectUrl} 
	    ]];
	}else{
		data = [[    
  	      	{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			{field:"ddbsjx1",title:"高危地区",width:100,align:"center",halign:'center'},
            {field:"ddbsjx2",title:"身份证号",width:100,align:"center",halign:'center'},
  	        {field:"ddbsjx3",title:"姓名",width:50,align:"center",halign:'center'},
  	        {field:"ddbsjx4",title:"性别",width:50,align:"center",halign:'center'},
  	        {field:"ddbsjx5",title:"年龄",width:40,align:"center",halign:'center'},
  	        {field:"ddbsjx6",title:"户籍地址",width:150,halign:'center'},
  	        {field:"ddbsjx7",title:"居住地址",width:150,halign:'center'},
  	        {field:"ddbsjx8",title:"工作单位",width:100,halign:'center'},
  	        {field:"ddbsjx9",title:"联系电话",width:100,halign:'center'},
  	        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
  	        {field:'true',title:'操作',width:40,align:'center',formatter:openGyrwSelectUrl} 
	    ]];
	}

	$("#syrk_gwry").datagrid({    
		url: url,
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data,
    	onLoadSuccess: function(data) {
    		$("#gwryDivTitle").html(newName+"（"+data.total+"）");
		}     
	}); 
}

//查询列表“查看”打开url
function openGyrwSelectUrl(val,row,index){
	var url = row["dataurl"];
	if (url == null || url == "") {
		return "";
	}
	else {
		var menuTitle = row['ddbsjx3'];
		if (menuTitle == null || menuTitle == "") {
			menuTitle = "查看信息";
		}
		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\""+ menuTitle +"\", \""+url+"\")')>查看</a></div>";
	}
}

/**
 * 
 * @Description: TODO(重点人员列表)
 * @param name 待办列表名称
 * @param dbmxid 待办模型id
 * @param urlType 查询范围（all-查询所有）
 * @param dbzt 督办状态
 * @throws
 */
function showZdryList(name, dbmxid, urlType, dbzt){
	var newName = name;
	if(name.indexOf("（") != -1){
		newName = name.substr(0, name.indexOf("（"));
	}
	
	figConditions['zdry'] = "&ddbsjx1="+newName;

	var url = encodeURI("<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid="+dbmxid+"&ddbsjx1="+newName);
	if(urlType == "all"){
		url = encodeURI("<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid="+dbmxid);
		figConditions['zdry'] = "";
	}
	
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			{field:"ddbsjx1",title:"重点人员类别",width:100,align:"center",halign:'center'},
	        {field:"ddbsjx2",title:"身份证号",width:100,align:"center",halign:'center'},
	        {field:"ddbsjx3",title:"姓名",width:50,align:"center",halign:'center'},
	        {field:"ddbsjx4",title:"性别",width:50,align:"center",halign:'center'},
	        {field:"ddbsjx5",title:"年龄",width:50,align:"center",halign:'center'},
	        {field:"ddbsjx6",title:"户籍地址",width:150,halign:'center'},
	        {field:"ddbsjx7",title:"居住地址",width:150,halign:'center'},
	        {field:"ddbsjx8",title:"工作单位",width:100,halign:'center'},
	        {field:"ddbsjx9",title:"联系电话",width:100,halign:'center'},
	        {field:'true',title:'操作',width:40,align:'center',formatter:openZdrySelectUrl} 
	    ]];
	}else{
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
			{field:"ddbsjx1",title:"重点人员类别",width:100,align:"center",halign:'center'},
	        {field:"ddbsjx2",title:"身份证号",width:100,align:"center",halign:'center'},
	        {field:"ddbsjx3",title:"姓名",width:50,align:"center",halign:'center'},
	        {field:"ddbsjx4",title:"性别",width:50,align:"center",halign:'center'},
	        {field:"ddbsjx5",title:"年龄",width:50,align:"center",halign:'center'},
	        {field:"ddbsjx6",title:"户籍地址",width:150,halign:'center'},
	        {field:"ddbsjx7",title:"居住地址",width:150,halign:'center'},
	        {field:"ddbsjx8",title:"工作单位",width:100,halign:'center'},
	        {field:"ddbsjx9",title:"联系电话",width:100,halign:'center'},
	        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
	        {field:'true',title:'操作',width:40,align:'center',formatter:openZdrySelectUrl} 
	    ]];
	}
	
	
	$("#syrk_zdry").datagrid({    
		url: url,
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
		columns:data,
    	onLoadSuccess: function(data) {
    		$("#zdryDivTitle").html(newName+"（"+data.total+"）");
		}  
	}); 
}

//查询列表“查看”打开url
function openZdrySelectUrl(val,row,index){
	var url = row["dataurl"];
	if (url == null || url == "") {
		return "";
	}
	else {
		var menuTitle = row['ddbsjx3'];
		if (menuTitle == null || menuTitle == "") {
			menuTitle = "查看信息";
		}
		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\""+ menuTitle +"\", \""+url+"\")')>查看</a></div>";
	}
}

/**
 * 
 * @Description: TODO(实有单位列表)
 * @param name 待办列表名称
 * @param type 实有房屋类型
 * @param dbmxid 待办模型id
 * @param dbzt 督办状态
 * @throws
 */
function showSydwList(name, type, dbmxid, dbzt){
	 
	var newName = name;
	if(name.indexOf("（") != -1){
		newName = name.substr(0, name.indexOf("（"));
	}
	
	var url = "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid="+dbmxid;
	var data = [];
	if(type == "ldxjdqy"){//从业人员流动性较大企业
		addTaskSydw_dbmxid = "${sydw_ldxjd}";
		
		if(dbzt == "wdb"){
			data = [[    
					{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
					{field:"ddbsjx1",title:"单位名称",width:200,halign:'center'},
					{field:"ddbsjx2",title:"单位类型",width:120,align:"center",halign:'center'},
					{field:"ddbsjx3",title:"单位地址",width:200,halign:'center'},
					{field:"ddbsjx4",title:"联系电话",width:80,halign:'center'},
					{field:"ddbsjx5",title:"新进人数",width:80,align:"center",halign:'center'},
					{field:"ddbsjx6",title:"离职人数",width:80,align:"center",halign:'center'},
					{field:'true',title:'操作',width:40,align:'center',formatter:openSydwSelectUrl} 
			     ]]; 
		}else{
			data = [[    
					{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
					{field:"ddbsjx1",title:"单位名称",width:200,halign:'center'},
					{field:"ddbsjx2",title:"单位类型",width:120,align:"center",halign:'center'},
					{field:"ddbsjx3",title:"单位地址",width:200,halign:'center'},
					{field:"ddbsjx4",title:"联系电话",width:80,halign:'center'},
					{field:"ddbsjx5",title:"新进人数",width:80,align:"center",halign:'center'},
					{field:"ddbsjx6",title:"离职人数",width:80,align:"center",halign:'center'},
					{field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
					{field:'true',title:'操作',width:40,align:'center',formatter:openSydwSelectUrl} 
			     ]]; 
		}
	}

	if(type == "wrqy"){//无人企业
		addTaskSydw_dbmxid = "${sydw_wcyry}";
		
		if(dbzt == "wdb"){
			data = [[    
					{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
					{field:"ddbsjx1",title:"单位名称",width:200,halign:'center'},
					{field:"ddbsjx2",title:"单位类型",width:100,align:"center",halign:'center'},
					{field:"ddbsjx3",title:"单位地址",width:200,halign:'center'},
					{field:"ddbsjx4",title:"联系电话",width:100,halign:'center'},
					{field:'true',title:'操作',width:40,align:'center',formatter:openSydwSelectUrl} 
			     ]];
		}else{
			data = [[    
					{field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
					{field:"ddbsjx1",title:"单位名称",width:200,halign:'center'},
					{field:"ddbsjx2",title:"单位类型",width:100,align:"center",halign:'center'},
					{field:"ddbsjx3",title:"单位地址",width:200,halign:'center'},
					{field:"ddbsjx4",title:"联系电话",width:100,halign:'center'},
					{field:"dbfknr",title:"反馈内容",width:100,halign:'center'},
					{field:'true',title:'操作',width:40,align:'center',formatter:openSydwSelectUrl} 
			     ]];
		}
	}
	$("#sydwlist").datagrid({    
		url: url,
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
    	columns:data,
    	onLoadSuccess: function(data) {
    		$("#sydwDivTitle").html(newName+"（"+data.total+"）");
		}
	});
}

//查询列表“查看”打开url
function openSydwSelectUrl(val,row,index){
	var url = row["dataurl"];
	if (url == null || url == "") {
		return "";
	}
	else {
		var menuTitle = row['ddbsjx1'];
		if (menuTitle == null || menuTitle == "") {
			menuTitle = "查看信息";
		}
		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\""+ menuTitle +"\", \""+url+"\")')>查看</a></div>";
	}
}

//督办任务，更多打开页面
function openDbrw(url){
	menu_open('更多督办任务', url);
}

function addTaskSyrk(){ 
	addTask(syrk_dbbutton, '');
}

function addTaskBzdz(){ 
	addTask(bzdz_dbbutton, '');
}

//督办打开页面
function addTask(ddbrwid, condiTions) {
	var url = contextPath+"/dbrwDdbrwb/startAdd?id="+ddbrwid;
	if (condiTions != "") {
		var parameter2 = figConditions[condiTions];
		if("undefined" != typeof(parameter2) && "" != parameter2 && null != parameter2){
			url = url + parameter2;
		}
	}
	if(ddbrwid != ""){
		var dataOptions = {
			title: '新建督办任务',
			url: encodeURI(url),
			width: 850,
			height: 606
		};
		openWindowWithSave(false, "", window, null, dataOptions, "您是否要保存督办任务？", "refreshMain", null);
	}else{
		alert("没有可发布的任务!");
	}
}

function addTaskSydw(){
	addTask(addTaskSydw_dbmxid, '');
}
function addTaskSyfw(){
	addTask(addTaskSyfw_dbmxid, '');
}

function changeCensuss(thisObject, flag) { // 督办状态切换
	$(thisObject).parent().find('li').attr('class', 'default');
	$(thisObject).attr('class', 'checked');
	document.getElementById("iframes").src = "<%=contextPath%>/forward/sqjw|flashChartCensus?flag=" + flag;
}

function dbztClick_zdry(thisObject, vtype) { // 督办状态切换
	$(thisObject).parent().find('li').attr('class', 'default');
	$(thisObject).attr('class', 'checked');
	if (vtype == "wdb") {
		$('#syrk_zdryDbDiv').show();
	}
	else {
		$('#syrk_zdryDbDiv').hide();
	}

	var vdata = new Date();
	var mili = vdata.getMilliseconds();
	swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","queryZdryChart","100%","168px;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/dbrwMain/queryZdryChart?dbzt="+vtype+"&time="+mili},{wmode:"transparent"});
	showZdryList("重点人员", "9AD87AE4A63F4B089F52544CC3E4B07E", "all", vtype);
}

function dbztClick_gwry(thisObject, vtype) { // 督办状态切换
	$(thisObject).parent().find('li').attr('class', 'default');
	$(thisObject).attr('class', 'checked');
	if (vtype == "wdb") {
		$('#syrk_gwryDbDiv').show();
	}
	else {
		$('#syrk_gwryDbDiv').hide();
	}

	var vdata = new Date();
	var mili = vdata.getMilliseconds();
	swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","queryGwryChart","100%","168px;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/dbrwMain/queryGwryChart?dbzt="+vtype+"&time="+mili},{wmode:"transparent"});
	showGwryList("高危地区人员", "DC4A5D794B2D42E9862B5B978D1B21BA", "all", vtype);
}

function dbztClick_sydw(thisObject, vtype) { // 督办状态切换
	$(thisObject).parent().find('li').attr('class', 'default');
	$(thisObject).attr('class', 'checked');
	if (vtype == "wdb") {
		$('#sydwlistDbDiv').show();
	}
	else {
		$('#sydwlistDbDiv').hide();
	}

	var vdata = new Date();
	var mili = vdata.getMilliseconds();
	swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","querySydwChart","100%","168px;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/dbrwMain/querySydwChart?dbzt="+vtype+"&time="+mili},{wmode:"transparent"});
	showSydwList("无人企业", "wrqy", "3BC189E54F99495EB87411255C1D8A9A", vtype);
}

function dbztClick_syfw(thisObject, vtype) { // 督办状态切换
	$(thisObject).parent().find('li').attr('class', 'default');
	$(thisObject).attr('class', 'checked');
	if (vtype == "wdb") {
		$('#syfwlistDbDiv').show();
	}
	else {
		$('#syfwlistDbDiv').hide();
	}
	
	var vdata = new Date();
	var mili = vdata.getMilliseconds();
	swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","querySyfwChart","100%","168px;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/dbrwMain/querySyfwChart?dbzt="+vtype+"&time="+mili},{wmode:"transparent"});
	showSyfwList("wrjz", "15D9845505C14BEF8F3C658986536318", "空置房屋", vtype);
}

function dbztClick_syrk(thisObject, vtype) { // 督办状态切换
	$(thisObject).parent().find('li').attr('class', 'default');
	$(thisObject).attr('class', 'checked');

	if (vtype == "wdb") {
		$('#syrkDbDiv').show();
	}
	else {
		$('#syrkDbDiv').hide();
	}

	syrk_dbztCard = vtype;
	HoverLi(1);
	
	tzc_02_Load_count(vtype, "A7D9858777F146DA80D9C0D426E94B1C");
	tzc_03_Load_count(vtype, "718DD320402249BB99B6840926EE8408");
}

function dbztClick(param) {
	$("#"+param).attr('class', 'checked');
}

function dispayHidden(divID) {
	if ($('#'+divID).attr('isShow') != 'hide') {
		$('#'+divID).hide();
		$('#'+divID).attr('isShow', 'hide');
	}
	else {
		$('#'+divID).show();
		$('#'+divID).attr('isShow', 'show');
		$(window).resize();
	}
}


function HoverLi(z) { 
	syrkSelected = z;
	for (var i = 1; i <= 3; i++) {
		if (i != z) {
			getObject('tz_' + i).className = 'normaltab';
			getObject('tzc_0' + i).className = 'rwdb_undis';
		}
	}
	getObject('tz_' + z).className = 'hovertab';
	getObject('tzc_0' + z).className = 'rwdb_dis';

	if (syrkSelected == 1) {
		tzc_01_Load(syrk_dbztCard);
		syrk_dbbutton = "${syrk_wzjzd}";
		$("#syrk_wzjzdhjry").datagrid('resize', {});
	}
	else if (syrkSelected == 2) {
		tzc_02_Load(syrk_dbztCard);
		syrk_dbbutton = "${syrk_wyry}";
		$("#syrk_wyry").datagrid('resize', {});
	}
	else if (syrkSelected == 3) {
		tzc_03_Load(syrk_dbztCard);
		syrk_dbbutton = "${syrk_yywjzd}";
		$("#syrk_yywjzdry").datagrid('resize', {});
	}
}

function dbztClick_bzdz(thisObject, vtype) { // 督办状态切换
	$(thisObject).parent().find('li').attr('class', 'default');
	$(thisObject).attr('class', 'checked');

	if (vtype == "wdb") {
		$('#dzbzDbDiv').show();
	}
	else {
		$('#dzbzDbDiv').hide();
	}
	dzbz_dbztCard = vtype;
	HoverLiDz(1);
}

function HoverLiDz(z) { 
	bzdzSelected = z;
	for (var i = 1; i <= 5; i++) {
		if (i != z) {
			getObject('dz_' + i).className = 'normaltab';
			getObject('dzc_0' + i).className = 'rwdb_undis';
		}
	}
	getObject('dz_' + z).className = 'hovertab';
	getObject('dzc_0' + z).className = 'rwdb_dis';

	if (bzdzSelected == 1) {
		dzc_01_Load(bzdz_dbztCard);
		bzdz_dbbutton = "${bzdz_wbzmlp}";
		$("#bzdz_wbzmlp").datagrid('resize', {});
	}
	else if (bzdzSelected == 2) {
		dzc_02_Load(bzdz_dbztCard);
		bzdz_dbbutton = "${bzdz_wchmlp}";
		$("#bzdz_wchmlp").datagrid('resize', {});
	}
	else if (bzdzSelected == 3) {
		dzc_03_Load(bzdz_dbztCard);
		bzdz_dbbutton = "${bzdz_wrjzjzw}";
		$("#bzdz_wrjzjzw").datagrid('resize', {});
	}
	else if (bzdzSelected == 4) {
		dzc_04_Load(bzdz_dbztCard);
		bzdz_dbbutton = "${bzdz_wbzdzdyhjdz}";
		$("#bzdz_wbzdzdyhjdz").datagrid('resize', {});
	}
	else if (bzdzSelected == 5) {
		dzc_05_Load(bzdz_dbztCard);
		bzdz_dbbutton = "${bzdz_qsdmlph}";
		$("#bzdz_qsdmlph").datagrid('resize', {});
	}
	
}

/**
 * 
 * @Description: TODO(未标注门楼牌)
 * @param dbzt 督办状态
 * @throws
 */
function dzc_01_Load(dbzt) {
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"门楼牌",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"创建时间",width:60,halign:'center'}, 
	        {field:"ddbsjx6",title:"创建人",width:60,halign:'center'}
	    ]];
	}else{
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"门楼牌",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"创建时间",width:60,halign:'center'}, 
	        {field:"ddbsjx6",title:"创建人",width:60,halign:'center'},
	        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'}
	    ]];
	}

	$("#bzdz_wbzmlp").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid=06C63C87B17C8812E053E105500A282C",
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data 
	}); 
	
	dzc_01_Load_count(dbzt, "06C63C87B17C8812E053E105500A282C");
}

/**
 * 
 * @Description: TODO(无层户门楼牌)
 * @param dbzt 督办状态
 * @throws
 */
function dzc_02_Load(dbzt) {
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"门楼牌",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"创建时间",width:60,halign:'center'}, 
	        {field:"ddbsjx6",title:"创建人",width:60,halign:'center'}
	    ]];
	}else{
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"门楼牌",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"创建时间",width:60,halign:'center'}, 
	        {field:"ddbsjx6",title:"创建人",width:60,halign:'center'},
	        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'}
	    ]];
	}

	$("#bzdz_wchmlp").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid=06C63C87B17D8812E053E105500A282C",
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data 
	}); 
	
	dzc_02_Load_count(dbzt, "06C63C87B17D8812E053E105500A282C");
}

/**
 * 
 * @Description: TODO(无人居住建筑物)
 * @param dbzt 督办状态
 * @throws
 */
function dzc_03_Load(dbzt) {
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"门楼牌",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"创建时间",width:60,halign:'center'}, 
	        {field:"ddbsjx6",title:"创建人",width:60,halign:'center'}
	    ]];
	}else{
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"门楼牌",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"创建时间",width:60,halign:'center'}, 
	        {field:"ddbsjx6",title:"创建人",width:60,halign:'center'},
	        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'}
	    ]];
	}

	$("#bzdz_wrjzjzw").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid=06C63C87B17E8812E053E105500A282C",
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data 
	}); 

	dzc_03_Load_count(dbzt, "06C63C87B17E8812E053E105500A282C");
}

/**
 * 
 * @Description: TODO(无标准地址对应户籍地址)
 * @param dbzt 督办状态
 * @throws
 */
function dzc_04_Load(dbzt) {
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"户籍地址",width:150,halign:'center'} 
	    ]];
	}else{
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"户籍地址",width:150,halign:'center'}, 
	        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'}
	    ]];
	}

	$("#bzdz_wbzdzdyhjdz").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid=06C63C87B17F8812E053E105500A282C",
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data 
	}); 

	dzc_04_Load_count(dbzt, "06C63C87B17F8812E053E105500A282C");
}

/**
 * 
 * @Description: TODO(缺少的门楼牌号)
 * @param dbzt 督办状态
 * @throws
 */
function dzc_05_Load(dbzt) {
	var data = [];
	if(dbzt == "wdb"){
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"街路巷",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"缺少门楼牌号",width:100,align:"center",halign:'center'}
	    ]];
	}else{
		data = [[    
	        {field:"sszrqmc",title:"所属责任区",width:100,halign:'center'},
	        {field:"ddbsjx1",title:"分县局",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx2",title:"派出所",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx3",title:"责任区",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx4",title:"街路巷",width:100,align:"center",halign:'center'}, 
	        {field:"ddbsjx5",title:"缺少门楼牌号",width:100,align:"center",halign:'center'}, 
	        {field:"dbfknr",title:"反馈内容",width:100,halign:'center'}
	    ]];
	}

	$("#bzdz_qsdmlph").datagrid({    
		url: "<%=request.getContextPath() %>/dbrwMain/queryDdbrwsjmxbList?dbzt="+dbzt+"&dbmxid=06C63C87B1808812E053E105500A282C",
		method:'get',
		pagination:false,
		fitColumns:true,
		pageSize:5,
		pageList:[5],
		border:false,
	    columns:data 
	}); 

	dzc_05_Load_count(dbzt, "06C63C87B1808812E053E105500A282C");
}

function dbztClick_bzdz(thisObject, vtype) { // 督办状态切换
	$(thisObject).parent().find('li').attr('class', 'default');
	$(thisObject).attr('class', 'checked');

	if (vtype == "wdb") {
		$('#bzdzDbDiv').show();
	}
	else {
		$('#bzdzDbDiv').hide();
	}

	bzdz_dbztCard = vtype;
	HoverLiDz(1);
	
	dzc_02_Load_count(vtype, "06C63C87B17D8812E053E105500A282C");
	dzc_03_Load_count(vtype, "06C63C87B17E8812E053E105500A282C");
	dzc_04_Load_count(vtype, "06C63C87B17F8812E053E105500A282C");
	dzc_05_Load_count(vtype, "06C63C87B1808812E053E105500A282C");
}

function dzc_01_Load_count(dbzt, dbmxid){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwMain/getTypeCount",
		dataType:"json",
		data:"dbzt="+dbzt+"&dbmxid="+dbmxid,
		success:function(data){
			var name = $("#dz_1").html();
			var newName = name.substr(0, name.indexOf("（"))+"（"+data.count+"）";
			$("#dz_1").html(newName);
		}
	});
}

function dzc_02_Load_count(dbzt, dbmxid){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwMain/getTypeCount",
		dataType:"json",
		data:"dbzt="+dbzt+"&dbmxid="+dbmxid,
		success:function(data){
			var name = $("#dz_2").html();
			var newName = name.substr(0, name.indexOf("（"))+"（"+data.count+"）";
			$("#dz_2").html(newName);
		}
	});
}

function dzc_03_Load_count(dbzt, dbmxid){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwMain/getTypeCount",
		dataType:"json",
		data:"dbzt="+dbzt+"&dbmxid="+dbmxid,
		success:function(data){
			var name = $("#dz_3").html();
			var newName = name.substr(0, name.indexOf("（"))+"（"+data.count+"）";
			$("#dz_3").html(newName);
		}
	});
}

function dzc_04_Load_count(dbzt, dbmxid){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwMain/getTypeCount",
		dataType:"json",
		data:"dbzt="+dbzt+"&dbmxid="+dbmxid,
		success:function(data){
			var name = $("#dz_4").html();
			var newName = name.substr(0, name.indexOf("（"))+"（"+data.count+"）";
			$("#dz_4").html(newName);
		}
	});
}

function dzc_05_Load_count(dbzt, dbmxid){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwMain/getTypeCount",
		dataType:"json",
		data:"dbzt="+dbzt+"&dbmxid="+dbmxid,
		success:function(data){
			var name = $("#dz_5").html();
			var newName = name.substr(0, name.indexOf("（"))+"（"+data.count+"）";
			$("#dz_5").html(newName);
		}
	});
}

</script>
   
</body>
</html>
