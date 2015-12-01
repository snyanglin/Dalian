<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>案件办理</title>
<script type="text/javascript" src="<%=contextPath%>/js/syrkinfo-mould.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>
</head>
<body class="bodybg">
	<div id="div_main" class="easyui-layout" data-options="" style="height:90%">
	
	
		<div id="div_west" class="easyui-panel" data-options="region:'west'" style="width:800px">
		<div class="bodydiv">
		<div class="bodyer">
		<div class="lf">
		<!--框-->
		
		<div class="pinfo">
			<strong><span id="jbxx_xm">test11</span><span id="jbxx_cym">test22</span></strong>
			<ul>
		    <li><span>性别：</span><span id="jbxx_xbdm">test1</span>&nbsp;&nbsp;&nbsp;&nbsp;
		    <span>出生日期：</span><span id="jbxx_csrq">test2</span>&nbsp;&nbsp;&nbsp;&nbsp;
		    <span>民族：</span><span id="jbxx_mzdm">test3</span></li> 
		    </ul> 														
		</div>
			
		<div class="clear"></div>
		<div class="editdiv"><a href="javascript:void(0);" class="savebtn">档案编辑完成</a><a href="javascript:void(0);" class="editbtn"  style="display:none">新增</a></div>
		
		<!--/框-->
		
		<!--基础信息-->
		<div class="lf_conta cont_edit">
		<div class="lf_contb">
		<div class="lf_contc">
		<dl class="infodl">
		<dt><div class="dllf info_jbxx">嫌疑人</div><a class="up_btn down_btn" href="javascript:void(0);"></a><a class="info_editbtn" href="javascript:void(0);">编辑</a><a class="info_savebtn" href="javascript:void(0);">保存</a></dt>
		<dd class="infoshow">
		    <ul>
		  	<li><span class="spantitle">籍贯：</span><span name="jgssxdm" class="edit_word input_w2">test4</span></li> 
		    <li><span class="spantitle">政治面貌：</span><span name="zzmmdm" class="edit_word input_w2">test5</span></li>
		    </ul>
		<div class="clear"></div>
		</dd>
		</dl>
		</div>
		</div>
		</div>
		<!--/基础信息-->
		
		<div class="clear"></div>
		</div>
		</div>
		</div>
		
		</div>
		<div id="div_center" class="easyui-panel" data-options="region:'center'" style="width:300px">办案历程</div>
		<div id="div_east" class="easyui-panel" data-options="region:'east'" style="width:500px">案件导航办理区域</div>
		<!-- 
		<div id="div_center" data-options="region:'center'" style="width:700px">
			<div id="div_center_west" data-options="region:'west'" style="width:200px">办案历程</div>
			<div id="div_center_center" class="easyui-panel" data-options="region:'center'" style="width:500px">案件导航办理区域</div>
		</div>
		
		<div id="div_btn" data-options="region:'south'">
			<a id="btn_next" href="javascript:void(0)">下一页</a>
			<a id="btn_back" href="javascript:void(0)">返回</a>
		</div>
		 -->
	</div>
	<a id="btn_next" href="javascript:void(0)">下一页</a>
</body>

<script type="text/javascript">

//当前屏幕分辨率
var fbl = window.screen.availWidth;
var div_main = $('#div_main');
var div_west = $('#div_west');
var div_center = $('#div_center');
//var div_center_west = $('#div_center_west');
//var div_center_center = $('#div_center_center');
var div_east = $('#div_east');
var div_west_ = $('#div_west').clone();//document.getElementById('div_west');
var div_center_ =  document.getElementById('div_center');
var div_east_ =  document.getElementById('div_east');
var pageNum = 1;



var infoPara = {
		mainUrl:"/sydwgl/queryDwzsxx",
		mainPara:"sydwlx="+$("#sydwlx").val(),
		
		queryUrl:"/sydwgl/service/",
		queryPara:$("#queryPara").val(), //dwid 单位ID
		
		serverMenuUrl:"/sydwgl/queryYwglgn",
		serverMenuPara:"sydwlx="+$("#sydwlx").val(), //实有单位类型
		
		zpUrl:"/zpfjPtryzp/queryZpById.jpg",
		
		editPara:"dwid="+$("#dwid").val(), //编辑参数
		editIframePara:'{'+$("#formPara").val()+'}', 
		
		serverPara:$("#serverPara").val(),  //业务办理参数        id 单位ID， dwmc 单位名称
		serverIframePara:'{'+$("#formPara").val()+'}',
		
		add_childInfo_para: $("#serverPara").val(),
		add_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		
		edit_childInfo_para:$("#serverPara").val(),
		edit_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		
		del_childInfo:"/sydwgl/delete_xxzsnrb"
	};
	
$(document).ready(function(){
	//当前为第二页时，不允许手动展开第一页面板
	div_west.panel({onBeforeExpand:function(){
		if(pageNum == 2){
			return false;
		}
	}});

	/***************根据当前分辨率调整页面布局*************************/
	
	if(fbl < 1330){
		//div_west.panel({fit:true});
		div_west.panel("maximize");
		div_center.hide();
		div_east.hide();
		$('#btn_next').bind("click", nextPage);
	}else{
		$('#btn_next').hide();
		//div_west.panel("resize", {width:800});
		//div_center.panel("resize", {width:300});
		//div_east.panel("resize", {width:500});
	}
	
	/***************固定事件注册，页面初始化**************************/
	
	$("a.up_btn").click(up_down);
	sylbIcon();
	iterateDict($("div.lf_conta").eq(1));
		
	$(".rt").show();
	$(".rt_view").hide();
		
});

function nextPage(){
$('#btn_next').text('返回');
$('#btn_next').unbind();
$('#btn_next').bind("click", backPage);

div_main.layout('collapse', 'west');
div_west.hide();
div_center.attr("width", "300px");
div_center.show();
div_east.show();

pageNum = 2;

/*
	div_west.attr("style", "width:200px");
	div_center_.attr("data-options", "region:'west'");
	div_center_.replaceAll('#div_west').end().show();
	
	div_center.attr("style", "width:500px");
	div_east_.attr("data-options", "region:'center'");
	div_east.replaceAll('#div_center').end().show();
	
	

	div_west.replaceWith(div_center);
	div_center.show();
	div_center.replaceWith(div_east);
	div_east.show();

	div_west.attr("data-options", "region:'east'");
	div_west.hide();
	div_center.show();
	div_center.attr("data-options", "region:'west'");
	div_east.show();
	div_east.attr("data-options", "region:'center'");
*/
}

function backPage(){
	pageNum = 1;
	div_main.layout('expand', 'west');
	div_center.hide();
	div_east.hide();
	
	$('#btn_next').text('下一页');
	$('#btn_next').unbind();
	$('#btn_next').bind("click", nextPage);
}
</script>
</html>