<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${basePath}" />
<title>警情关联</title>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
</head>
<body>
	<!-- 警情关联div -->
	<div id="jqglDiv" class="tips_ct tips_jqgl_div">
		<div style="padding:10px 10px 0;overflow:hidden;">
			<label>
				警情编号：<input type="text" id="jqgl_jqbh" class="tips_jqgl_input" />
			</label>
			<label>
				报警电话：<input type="text" id="jqgl_bjdh" class="tips_jqgl_input" />
			</label>
			<label>
				报警时间：<input type="hidden" id="jqgl_bjsjq" /><input type="text" id="jqgl_bjsjqmc" class="tips_jqgl_input_select" />
			</label>
			<br/>
			<label>
				案发地点：<input type="text" id="jqgl_jqafdd" class="tips_jqgl_input" />
			</label>
			<label>
				警情信息：<input type="text" id="jqgl_jqxx" class="tips_jqgl_input" />
			</label>
			<label>
				警情状态：<input type="hidden" id="jqgl_jqzt" /><input type="text" id="jqgl_jqztmc" class="tips_jqgl_input_select" />
			</label>
			<br/>
			<label>
				<a id="doJqglQueryBtn" href="javascript:void(0);" class="tips_jqgl_btn">查&nbsp;&nbsp;&nbsp;&nbsp;询</a>
				<a id="doJqglResetBtn" href="javascript:Jqgl.resetJqglQueryCondition('jqglDiv');" class="tips_jqgl_btn">重&nbsp;&nbsp;&nbsp;&nbsp;置</a>
			</label>
		</div>
		<label class="rt jqgl_rtdiv">
		<div class="lf">关联警情数：<span id="jqglNumberSpan" class="redcolor">0</span>个</div>
		<div class="rt">
			<a id="doJqglConfirmBtn" href="javascript:Jqgl.beRelated();" class="tips_jqgl_btn">确&nbsp;&nbsp;&nbsp;&nbsp;认</a>
			<a id="doJqglCancelBtn" href="javascript:Jqgl.closeWindow();" class="tips_jqgl_btn">取&nbsp;&nbsp;&nbsp;&nbsp;消</a>
			<a id="doJqglClearBtn" href="javascript:Jqgl.clearBeRelated('jqglListDiv');" class="tips_jqgl_btn">清空重选</a>
		</div>
		</label>
		<!-- 警情列表div -->
		<div class="clear"></div>
		<div id="jqglListDiv" class="tips_jqgl_list_div"></div>
	</div>
	<!-- 警情关联div -->
</body>	
</html>