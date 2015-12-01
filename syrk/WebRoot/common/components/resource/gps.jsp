<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <base href="<%=basePath%>">
    <title>实时警力</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
   <div id="scroll_main_gps">
		<div id="scroll_content_gps">      
		<div class="rtcontpadding"> 
			<!-- 实时警力 -->
			<div id="reason">
			<!--警力统计-->
		<div class="rt_title" style="z-index:1999"><strong>警力统计</strong><span style="position:absolute;right:50px; top:0;"><font color="red" size="16" id="gpstjdjsid">5</font> 秒后自动更新</span><a href="javascript:gps.startCount($('#ssjl_gpszzjg_dm').val());" id="refreshgifId"></a></div>
			<div class="input_selectbg" id="ssjl_zzjg">
				<input type="hidden" id="ssjl_gpszzjg_dm" />
				<input type="text" id="ssjl_gpszzjg_mc" class="zzjg_slect input_select" style="width:225px;"  onExit="gps.startCount($('#ssjl_gpszzjg_dm').val())"/>
				<div class="clear" id="ssjl_gpszzjg_data_Div"></div>
			</div>
			<div class="clear"></div>
			<dl class="table_tj table_tj2" id="jl_tj">
			 <dt><span>类型</span><a style="margin-left: 25px;">在线</a><a>合计</a></dt>
			 <dd id="gps_type_counterid">
			 	<!-- <div><span>车</span><a href="javascript:;">3</a><a href="javascript:;">2</a><a href="javascript:;">1</a><a href="javascript:;">0</a></div>
			 	<div><span>车</span><a href="javascript:;">3</a><a href="javascript:;">2</a><a href="javascript:;">1</a><a href="javascript:;">0</a></div>
			 	<div><span>车</span><a href="javascript:;">3</a><a href="javascript:;">2</a><a href="javascript:;">1</a><a href="javascript:;">0</a></div>
			 	<div><span>车</span><a href="javascript:;">3</a><a href="javascript:;">2</a><a href="javascript:;">1</a><a href="javascript:;">0</a></div> -->
			 </dd>
			</dl>
			<!-- <dl class="table_tj table_tj2  table_tj3" id="jl_tj2">
			 <dt><a>总计</a><a>民警</a><a>协警</a><a>其它</a></dt>
			 <dd id="gps_person_counterid">
			 	<!-- <div><a href="javascript:;">3</a><a href="javascript:;">2</a><a href="javascript:;">1</a><a href="javascript:;">0</a></div> -->
			<!-- </dd>
			</dl> -->
			
			<!--快捷操作-->
			<div class="rt_title"><strong>快捷操作</strong></div>
			<div class="rt_contli">
			<div class="clear"></div>
				<a onclick="gps.synQuery()" class="btnab" href="javascript:;"  style="float:left;margin-bottom:5px;margin-top:5px;display:none">视野内</a>
				<a onclick="gps.xqnquery()" class="btnab" href="javascript:;"  style="float:left;margin-bottom:5px;margin-top:5px;display:none">辖区内</a>
				<a onclick="gps.xqwquery()" class="btnab" href="javascript:;"  style="float:left;margin-bottom:5px;margin-top:5px;display:none">辖区外</a>
				<a onclick="gps.xqnquery($('#ssjl_gpszzjg_dm').val())" class="btnab" href="javascript:;"  style="float:left;margin-bottom:5px;margin-top:5px;display:none">按机构</a>
				<a onclick="gps.clearGpsLsgj()" class="btnab" href="javascript:;"  style="float:left;margin-bottom:5px;margin-top:5px">清除轨迹</a>
				<a onclick="gps.clearGpsXlqy()" class="btnab" href="javascript:;"  style="float:left;margin-bottom:5px;margin-top:5px;display:none">清除巡区</a>
				<a onclick="gps.clear()" class="btnab" href="javascript:;"  style="float:left;margin-bottom:5px;margin-top:5px;">清空警力</a>
			<div class="clear"></div>
			</div>
			<!--/快捷操作-->
			
			<!--综合查询-->
			<div class="rt_title"><strong>空间查询</strong></div>
			<div class="rt_contli">
			<a href="javascript:void(0)" class="btna bnt_hfx" title="框查" onclick="gps.spatialquery('drawRect');"></a>
			<a href="javascript:void(0)" class="btna bnt_hyx"  title="圆查" onclick="gps.spatialquery('drawCircle');"></a>
			<a href="javascript:void(0)" class="btna bnt_dbx"  title="多边形查" onclick="gps.spatialquery('drawPolygon');"></a>
			<div class="lineb"></div>
			<div class="div_cont" id="ssjl_zb">
			周边<input type="hidden" id="ssjl_distanceDM" name="distanceDM" />
			<input type="text" id="around_distance" name="around_distance" class="all_slect" style="width:140px"/> 米
			</div>
			<div class="clear"></div>
			<div style="overflow:hidden;">
			<a href="javascript:void(0)" class="btna bnt_bd" onclick="gps.aroundQuery('drawPoint');"></a>
			<a href="javascript:void(0)" class="btna bnt_hx" onclick="gps.aroundQuery('drawPolyline');"></a>
			<a href="javascript:void(0)" class="btna bnt_hm" onclick="gps.aroundQuery('drawPolygon');"></a>
			</div>
			<div class="clear"></div>
			</div>
			<div class="linec"></div>
			<!--/综合查询-->
			<!--关键字查询-->
			<div class="rt_title"><strong>关键字查询</strong>(手机号)</div>
			<div class="rt_contli">
			<input class="input_searchgjzb" type="text" value=""   id="keywordsearch" /><a href="javascript:void(0)" class="btn_gjz" onclick="gps.keyWordQuery()"></a>
			<div class="clear"></div>
			</div>
			<div class="linec"></div>
			<!--/关键字查询-->
			<!--轨迹设置-->
			<div class="rt_title"><strong>轨迹设置</strong></div>
			<div class="rt_contli">
			<!--select 框-->
			<div class="div_cont" id="ssjl_sjgj">轨迹时间(分钟)&nbsp;&nbsp;<input type="hidden" id="timeIntervalDM" name="timeIntervalDM" /><input type="text" id="timeInterval" name="timeInterval"  class="all_slect" style="width:125px;" />
			<div style="overflow:hidden;margin:40px;"></div>
			<!-- <div style="overflow:hidden;margin:5px 0 5px 0;"><a onclick="gps.clearGpsLsgj()" class="btnab" href="javascript:;"  style="margin:0 0 5px 0;float:left;">清除轨迹</a></div>
			<div style="overflow:hidden;margin:5px 0 5px 0;"><a onclick="gps.clearGpsXlqy()" class="btnab" href="javascript:;"  style="margin:0 0 5px 0;float:left;">清除巡区</a></div>
			<div style="overflow:hidden;margin:5px 0 5px 0;"><a onclick="gps.clearAll()" class="btnab" href="javascript:;"  style="margin:0 0 5px 0;float:left;">清空地图</a></div> -->
			</div>
			<!--/select 框-->
			<div class="linec"></div>
			<!--/轨迹设置-->
			</div>
			<!--空白div增加屏幕高度，完整显示下拉-->
			<!-- div style="height:60px;" > < /div   -->
			</div>
			<div id="resultdiv" style="display:none">
			<!--轨迹结果-->
			<div class="rt_title"><div class="lf" id="result_count"></div><a class="btnab" style="float:right;margin:1px -5px 1px 0;" href="javascript:void(0)" onclick="gps.backto()">返回</a></div>
			<dl class="table_result">
			<dt><span class="span1">警员姓名</span><span class="span2">手机号</span><span class="span3">所属分组</span></dt>
			<dd id="results"></dd>
			</dl>
			<div class="linec"></div>
			<!--/轨迹结果-->
			</div>
			<input type="hidden" id="strCoodsX" value=""/>
			<input type="hidden" id="strCoodsY" value=""/>
			</div> 
		</div>
	</div>
<!-- /实时警力 -->
<script type="text/javascript">

	var dwbh = "${userSession.userOrgCode}";
	
    var isLoad = "${param.isLoad}";//是否从交通态势管理：周边警力-跳转标志
    var roadid= "${param.roadid}";//交通态势管理：路段ID
	gps.init(dwbh,isLoad,roadid); 

	$(document).ready(function() {
			ScrollBarTool.init("scroll_main_gps", "scroll_content_gps",0, true); 
			$(window).resize(ScrollBarTool.debounce(function() {
				ScrollBarTool.init("scroll_main_gps", "scroll_content_gps",0, true); 
			}, 500)); 
	});	
</script>
 </body>
</html>
