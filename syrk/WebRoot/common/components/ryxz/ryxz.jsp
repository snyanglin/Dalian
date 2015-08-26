<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="${basePath}" />
		<title>人员选择</title>
		<!--  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">-->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<!-- 人员选择 -->
		<script type="text/javascript" src="common/components/ryxz/js/ryxz.js"></script>	
		<link rel="stylesheet" href="common/components/ryxz/css/ryxz.css" type="text/css"></link>
		<script type="text/javascript" >
			var param =eval("("+decodeURI("${param.param1}")+")");//将字符串转换为json对象
			var ryxz=new Ryxz();
			ryxz.initRyxz(param);
		</script>	
	</head>
<body>
	<div style="overflow:hidden;padding:10px 10px 0">
		<div id="yrxz_search" style="clear:both;">
		</div>
		<div style="float:right;margin:-9px -7px 0 0;">
				<a class="btnab"  href="javascript:void(0);" onclick="ryxz.query('yrxz_itemselector_left');">查询</a>
				<a class="btnab"  href="javascript:void(0);" onclick="ryxz.clearInput();">重置</a>
		</div>
	</div>
	<div id="body" class="qwgl_pzgl_ryxz">	
		<!-- 此div的作用是放入单位查询框，如果存在的话 -->
		<div id="yrxz_search_dw" style="float:none;overflow:hidden;"></div>
		<!-- 人员选择容器 -->
		<div id="yrxz_itemselector" class="itemselector" style="float:none;overflow:hidden;">
					
					<div class="itemselector_data"><div id="yrxz_itemselector_left" ></div></div>
					<div id="" class="itemselectorbtn">	
						<a class="itemselectorbtna" href="javascript:void(0);" onclick="ryxz.choseAffirm('yrxz_itemselector_left');" title="选中"></a>
						<a class="itemselectorbtnb" href="javascript:void(0);" onclick="ryxz.deleteAffirm('yrxz_itemselector_left');" title="移除"></a>
					</div>
					<div class="itemselector_data" ><div id="yrxz_itemselector_right"></div></div>
		</div>
		<!-- 确认按钮 -->
		<div id="yrxz_confirm_buttorn" style="float:none;overflow:hidden;padding:10px 0 0">
				<a class="btnab"  href="javascript:void(0);" onclick="ryxz.getChosenData(param);" style="margin-right:0;">确认</a>
				<a class="btnab"  href="javascript:void(0);" onclick="ryxz.closeWindow();">取消</a>
		</div>
	</div>
</body>
</html>