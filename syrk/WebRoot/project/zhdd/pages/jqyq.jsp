<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${basePath}" />
<title>警情舆情</title>
</head>
<body>
	<%-- 警情舆情div --%>
	<div class="tips" id="jqyqDiv" class="tips_ct tips_jqyq_div">
		<div style="padding:10px 10px 0;">
			<label>
				<div class="lf"><span class="redcolor">*</span>舆情信息：</div>
				<input type="hidden" id="jqyq_jqyqid" />
				<input type="hidden" id="jqyq_jqbh" />
				<textarea id="jqyq_yqyjtzqk" rows="3" class="tips_jqyq_textarea"></textarea>
			</label>
			<br/>
			<label>
			<div style="padding:5px 5px 0 5px;overflow:hidden;">
			<div class="lf" style="display: none;" id="jqyq_yqsj_label"><span>发布时间：</span>&nbsp;<span id="jqyq_yqsj"></span></div>
			<br/>
			<div class="rt" style="margin:0 15px 0 0;">
				<a id="doJqyqSaveBtn" href="javascript:Jqyq.saveOrUpdateJqyq();" class="tips_jqyq_btn">保&nbsp;&nbsp;&nbsp;&nbsp;存</a>
				<a id="doJqyqCancelBtn" href="javascript:Jqyq.closeWindow();" class="tips_jqyq_btn" style="margin-right: 10px;">取&nbsp;&nbsp;&nbsp;&nbsp;消</a>
			</div>
			</div>
			</label>
			<br/>
		</div>
	</div>
	<%-- 警情舆情div --%>
</body>	
</html>