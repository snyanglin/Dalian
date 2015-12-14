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
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
   <div id="scroll_main_ssjl">
		<div id="scroll_content_ssjl">      
		<div class="rtcontpadding"> 
			<!-- 实时警力 -->
			<div id="reason">
			<!--警力统计-->
			<div class="rt_title"><strong>警力统计</strong></div>
			<div class="input_selectbg" id="ssjl_zzjg">
				<input type="hidden" id="ssjl_gpszzjg_dm" />
				<input type="text" id="ssjl_gpszzjg_mc" class="zzjg_slect input_select" style="width:225px;"  onExit="Ssjl.fireZzjgdmFunc()"/>
				<div class="clear" id="ssjl_gpszzjg_data_Div"></div>
			</div>
			<div class="clear"></div>
			<dl class="table_tj" id="jl_tj">
			 <dt><span>&nbsp;</span><a>空闲</a><a>处警</a></dt>
			<!-- yichu begin
			<dd><span>警车</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>
			<dd><span>GPS对讲机</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>
			<dd><span>警务通</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>
			<dd><span>350M</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>
			<dd><span>全部</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd> 
			yichu end -->
			<!-- <dt><span>&nbsp;</span><a>空闲</a><a>出警</a><a>处置</a></dt>
			<dd><span>车</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>
			<dd><span>电话</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>
			<dd><span>移动端</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>
			<dd><span>全部</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd> -->
			</dl>
			<!--/警力统计-->
			<div id="ssjl_closexh" class="ssjl_closexh"  style="padding:5px 0">
			<a onclick="Ssjl.clear()" class="btnab" href="javascript:;"  style="margin:0;">清除警力</a>
			<div id="ssjl_xqnw_query" style="float:right;">
			<a onclick="Ssjl.xqwjl()" class="btnabbig btnabbig_disabled" title="辖区外空闲警力" disabled="" href="javascript:;">辖区外空闲警力</a>
			<a onclick="Ssjl.xqnjl()" class="btnabbig btnabbig_disabled" title="辖区内空闲警力" disabled="" href="javascript:;">辖区内空闲警力</a>
			</div>
			</div>
			<!--综合查询-->
			<div class="rt_title"><strong>空间查询</strong></div>
			<div class="rt_contli">
			<a href="javascript:void(0)" class="btna bnt_hfx" title="框查" onclick="Ssjl.jlSpatialquery('drawRect');"></a>
			<a href="javascript:void(0)" class="btna bnt_hyx"  title="圆查" onclick="Ssjl.jlSpatialquery('drawCircle');"></a>
			<a href="javascript:void(0)" class="btna bnt_dbx"  title="多边形查" onclick="Ssjl.jlSpatialquery('drawPolygon');"></a>
			<div class="lineb"></div>
			<div class="div_cont" id="ssjl_zb">
			周边<input type="hidden" id="ssjl_distanceDM" name="distanceDM" />
			<input type="text" id="ssjl_distance" name="distance" class="all_slect" style="width:140px"/> 米
			</div>
			<div class="clear"></div>
			<div style="overflow:hidden;">
			<a href="javascript:void(0)" class="btna bnt_bd" onclick="Ssjl.jlAroundQuery('drawPoint')"></a>
			<a href="javascript:void(0)" class="btna bnt_hx" onclick="Ssjl.jlAroundQuery('drawPolyline')"></a>
			<a href="javascript:void(0)" class="btna bnt_hm" onclick="Ssjl.jlAroundQuery('drawPolygon')"></a>
			</div>
			<div class="clear"></div>
			</div>
			<div class="linec"></div>
			<!--/综合查询-->
			<!--关键字查询-->
			<div class="rt_title"><strong>关键字查询</strong></div>
			<div class="rt_contli">
			<input class="input_searchgjzb" type="text" value=""  id="search" /><a href="javascript:void(0)" class="btn_gjz" onclick="Ssjl.jlKeySearch()"></a>
			<div class="clear"></div>
			</div>
			<div class="linec"></div>
			<!--/关键字查询-->
			<!--轨迹设置-->
			<div class="rt_title"><strong>轨迹设置</strong></div>
			<div class="rt_contli">
			<!--select 框-->
			<div class="div_cont" id="ssjl_sjgj">轨迹时间(分钟)&nbsp;&nbsp;<input type="hidden" id="timeIntervalDM" name="timeIntervalDM" /><input type="text" id="timeInterval" name="timeInterval"  class="all_slect" style="width:125px;" />
			<div style="overflow:hidden;margin:5px 0 5px 0;"><a onclick="Ssjl.clearLsgj()" class="btnab" href="javascript:;"  style="margin:0 0 5px 0;float:left;">清除轨迹</a></div>
			</div>
			<!--/select 框-->
			<div class="linec"></div>
			<!--/轨迹设置-->
			</div>
			<!--空白div增加屏幕高度，完整显示下拉-->
			<div style="height:60px;"></div>
			</div>
			<div id="resultdiv" style="display:none">
			<!--轨迹结果-->
			<div class="rt_title"><div class="lf" id="result_count"></div><a class="btnab" style="float:right;margin:1px -5px 1px 0;" href="javascript:void(0)" onclick="Ssjl.backto()">返回</a></div>
			<dl class="table_result">
			<dt><span class="span1">警员姓名</span><span class="span2">车牌号码</span><span class="span3">所属分组</span></dt>
			<dd id="results"></dd>
			</dl>
			<div class="linec"></div>
			<!--/轨迹结果-->
			</div>
			<input type="hidden" id="ssjl_dataInputx" value=""/>
			<input type="hidden" id="ssjl_dataInputy" value=""/>
			</div> 
		</div>
	</div>
<!-- /实时警力 -->
<script type="text/javascript">
//_MapApp.clear();
//var dwbh = "${UserSession.zzjgdm}";
var dwbh = "${UserSession.ywjgdm}";
	Ssjl.init(dwbh);

	 $(document).ready(function() {
		ScrollBarTool.init("scroll_main_ssjl", "scroll_content_ssjl",0); 
		$(window).resize(ScrollBarTool.debounce(function() {
			ScrollBarTool.init("scroll_main_ssjl", "scroll_content_ssjl",0, true); 
		}, 500)); 
});	    
</script>
 </body>
</html>
