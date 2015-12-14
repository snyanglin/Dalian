<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="${basePath}" />
		<title>装备关联</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<!-- 装备关联 -->
		<script type="text/javascript" src="common/components/zbgl/js/zbgl.js"></script>
		<!-- easyUI类库 -->
		<link rel="stylesheet" href="common/components/zbgl/css/zbgl.css" type="text/css"></link>
		<script type="text/javascript" > 
			//var param =eval(${param.param1});//将字符串转换为json对象
			//var param =eval("("+"${param.param1}"+")");//将字符串转换为json对象
			var param =eval("("+decodeURI("${param.param1}")+")");//将字符串转换为json对象
			var zbgl=new Zbgl();
			zbgl.initZbgl();
		</script>	
	</head>
<body >
	<div id="zbgl_body" class="qwgl_pzgl_ryxz">
		<!-- 人员，装备选择容器 -->
		<div id="zbgl_itemselector" class="itemselector">
				<div id="zbgl_zblxList" style="padding:0 0 0 290px;"></div>
			<div class="itemselector_data" style="margin:0 22px 0 0;">
				<div id="zbgl_itemselector_left" ></div>
			</div>
			<div class="itemselector_data" >	
				<div id="zbgl_itemselector_right"></div>
			</div>
			<div class="itemselectorbtn">	
				<a class="zbgl_bdbtn" href="javascript:void(0);" onclick="zbgl.affirm()" title="关联"></a>
				<a class="zbgl_jbbtn" href="javascript:void(0);" onclick="zbgl.openLock()" title="解除"></a>
			</div>
		</div>
		<input id="zbgl_yr_zb_mapData" type="hidden"/>
		<!-- 人员装备选择匹配容器 -->
		<div id="zbgl_yr_zb_map"  style="float:none;overflow:hidden;"></div>
		<!-- 确认取消按钮 -->
		<div style="float:none;overflow:hidden;">
				<a class="btnab"  href="javascript:void(0);" onclick="zbgl.getChosenData();" style="margin-right:0;">确认</a>
				<a class="btnab"  href="javascript:void(0);" onclick="zbgl.closeWindow();">取消</a>
		</div>
	</div>
</body>
</html>
 