<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <base href="<%=basePath%>">
    
    <title>基础信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
         
<div class="rtcontpadding"> 

<div class="padding6" id="layer_data_content">
</div>
<!-- <div id="no_data" style="display:none;">
无专题权限
</div> -->
<div class="input_selectbg" id="ssjl_zzjg">
				<input type="hidden" id="ssjl_jczyzzjg_dm" />
				<input type="text" id="ssjl_jczyzzjg_mc" class="zzjg_slect input_select" style="width:225px;" onExit="Jcxx.showJcxx($('#ssjl_jczyzzjg_dm').val())"/>
				<div class="clear" id="ssjl_jczyzzjg_data_Div"></div>
</div>
<!-- 基础信息 -->
<div class="padding6">
<a href="#" class="btnClick" id="tw" title="天网" onclick="Jcxx.tianwang();"><span class="tw">天网</span></a>

<a href="#" class="btnzy" id="kk" title="卡口" onclick="Jcxx.kakou();"><span class="kk">卡口</span></a>


</div> 
<div class="linec"></div>
<!--查询方式-->
<div class="rt_title"><strong>快捷查询</strong></div>
<div class="rt_contli" id="query_mode">
<div id="fast_query_mode"></div>
<a href="javascript:void(0)" class="btnfs bnt_xqn" id="xqSearch" title="辖区内查询" onclick="Jcxx.xqSearch();" ></a>
<a href="javascript:void(0)" class="btnfs bnt_syn" id="visionSearch" title="视野内查询"  onclick="Jcxx.visionSearch();"></a>

<a href="javascript:void(0)" class="btnfs bnt_fsqc" id="jcxx_clear" title="清除" onclick="Jcxx.clear();"></a>

<div class="clear" id="query_mode_clear"></div>
</div>
<div class="linec"></div>
<!--综合查询-->
<div class="rt_title"><strong>空间查询</strong></div>
<div class="rt_contli">
<a href="javascript:void(0)" class="btna bnt_hfx" title="框查" onclick="Jcxx.spatialQuery('drawRect');"></a>
<a href="javascript:void(0)" class="btna bnt_hyx" title="圆查" onclick="Jcxx.spatialQuery('drawCircle');"></a>
<a href="javascript:void(0)" class="btna bnt_dbx" title="多边形查" onclick="Jcxx.spatialQuery('drawPolygon');"></a>
<div class="lineb"></div>
<div class="div_cont" id="jcxx_all">
周边<input type="hidden" id="jcxx_distanceDM" name="distanceDM" />
<input type="text" id="jcxx_distance" name="distance" class="all_slect" /> 米
</div>
<a href="javascript:void(0)" class="btna bnt_bd" onclick="Jcxx.aroundQuery('drawPoint')"></a>
<a href="javascript:void(0)" class="btna bnt_hx" onclick="Jcxx.aroundQuery('drawPolyline')"></a>
<a href="javascript:void(0)" class="btna bnt_hm" onclick="Jcxx.aroundQuery('drawPolygon')"></a>
<div class="clear"></div>
</div>
<div class="linec"></div>
<!--/综合查询-->
<!--关键字查询-->
<div class="rt_title"><strong>关键字查询</strong></div>
<div class="rt_contli">
<input class="input_searchgjzb" type="text" value=""  id="jcxx_search" /><a href="javascript:void(0)" class="btn_gjz" onclick="Jcxx.mysearch()"></a>
<div class="clear"></div>
</div>
<div class="linec"></div>
<!--/关键字查询-->


<input type="hidden" id="dataInputx" value=""/>
<input type="hidden" id="dataInputy" value=""/>
<!-- /基础信息 -->
</div>

<script type="text/javascript">
   var isLoad = "${param.isLoad}";//是否从交通态势管理：周边资源-跳转标志
   var roadid= "${param.roadid}";//交通态势管理：路段ID
   var dwbh = "${userSession.userOrgCode}";
   Jcxx.init(isLoad,roadid,dwbh);
</script>
 </body>
</html>
