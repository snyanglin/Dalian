<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${basePath}"/>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
</head>
<body>
	<div id="contentOuterDiv" style="height:100%;">
		<div id="contentInnerDiv" style="height:100%">
			<div class="bg_search">
				<div class="input_search" id="keywordDiv">
					<input type="text" id="keyword" class="txt_input_search" value="" /><a id="keywordBtn" href="javascript:void(0);" title="搜索" class="btn_input_search"></a>
				</div>
				<a id="advancedSearchBtn" href="javascript:void(0);" class="btn_retrieval"></a>
			</div>
			<div class="new_alarm">
				<span id="totalCountSpan"></span><a href="javascript:void(0);" class="btn_new" id="newAlarmButton"></a>
			</div>
			<div id="scroll_main_jqlb">
				<div id="scroll_content_jqlb">  
					<!-- 警情列表容器div -->
					<div id="contentDivId" class="lf_dllict"></div>
					<!--/ 警情列表容器div -->
					<!-- 警情事件回放容器 -->
					<div id="jqsjDiv" style="display:none">
						<div class="jqhf_title"><span class="backspan"></span><a class="backbtn" onclick="javascript:Jqcz.backTo()">返回</a><div class="jqhf_mc" id="jqhf_title" title=""></div></div>
						<div id="jqsjcontent"></div>
					</div>
					<!-- /警情事件回放容器 -->
				</div>
			</div>
		</div>
	</div>
	<!-- 高级检索容器div -->
	<div id="advancedSearchDiv" class="advancedSearch_div">
		<dl class="advancedSearch_dl">
			<dt class="advancedSearch_dt"><strong>高级检索</strong></dt>
			<dd>
				<label>
					警情类别：<input type="hidden" id="advancedSearch_jqssdldm"/><input type="text" id="advancedSearch_jqssdlmc" class="all_slect" style="width:95px;"/>
							  <input type="hidden" id="advancedSearch_jqsszldm"/><input type="text" id="advancedSearch_jqsszlmc" class="all_slect" style="width:95px;"/>
				              <input type="hidden" id="advancedSearch_jqssxldm"/><input type="text" id="advancedSearch_jqssxlmc" class="all_slect" style="width:98px;"/>
				</label>
				<label>
					警情类型：<input type="hidden" id="advancedSearch_jqlxdm"/><input type="text" id="advancedSearch_jqlxmc" class="all_slect" style="width:117px;"/>
				</label>
				<label>
					接警人员：<input type="text" id="advancedSearch_jjrxm" class="all_inputtext" style="width:117px;"/>
				</label>
				<label>
					报警人员：<input type="text" id="advancedSearch_bjrxm" class="all_inputtext" style="width:117px;"/>
				</label>
				<label>
					报警电话：<input type="text" id="advancedSearch_bjdh" class="all_inputtext" style="width:117px;"/>
				</label>
				<label>
	         		报警时间：<input type="text" id="advancedSearch_jjsjq" class="all_inputtext" style="width:117px;" onfocus="new WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'advancedSearch_jjsjz\')||\'%y-%M-%d\'}',onpicked:function(){$dp.$('advancedSearch_jjsjz').click();}})"/>
	         	</label>
	         	<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至：<input type="text" id="advancedSearch_jjsjz" class="all_inputtext" style="width:117px;" onfocus="new WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'advancedSearch_jjsjq\')}',maxDate:'%y-%M-%d'})"/></label>
				<label style="display: none;">
					警情时间：<input type="hidden" id="advancedSearch_bjsjq"/><input type="text" id="advancedSearch_bjsjqmc" class="all_slect" style="width:117px;"/>
				</label>
				<label>
					<%-- 警情地址：<input type="text" id="advancedSearch_jqafdd" class="all_inputtext" style="width:117px;"/> --%>
					管辖大队：
						<input type="hidden" id="advancedSearch_jqssdddm" />
						<input type="text" id="advancedSearch_zzjgmc" class="tips_slect" style="width:290px;" />
				</label>
				<label>
					<%-- 警情地址：<input type="text" id="advancedSearch_jqafdd" class="all_inputtext" style="width:117px;"/> --%>
					警情地址：<input type="text" id="advancedSearch_jqafdd" class="all_inputtext" style="width:300px;"/>
				</label>
				<label>
					警情信息：<input type="text" id="advancedSearch_jqxx" class="all_inputtext" style="width:300px;"/>
				</label>
				<label>
					<a id="doAdvancedSearchBtn" href="javascript:void(0);" class="advancedSearch_btn">查&nbsp;&nbsp;&nbsp;&nbsp;询</a>
					<a id="doAdvancedResetBtn" href="javascript:void(0);" class="advancedSearch_btn">重&nbsp;&nbsp;&nbsp;&nbsp;置</a>
				</label>
			</dd>
			</dl>
	</div>
	<!-- 高级检索容器div -->
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$(window).resize(ScrollBarTool.debounce(function() {
			ScrollBarTool.init("scroll_main_jqlb", "scroll_content_jqlb", 84, 1); 
		}, 500)); 
	});
</script>
</html>