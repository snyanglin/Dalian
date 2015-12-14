<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>字典翻译测试页面</title>
<!-- 字典翻译需要的js库文件  -->
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/jf_sxtScript.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/dict/jfxt/js/JF_DIC_TRANSLATE.js"></script>

<script type="text/javascript">
	var mainTabID = '${mainTabID}';
	var mode = '${mode}';
</script>

<script type="text/javascript">
	function simpleDictionary(){
		alert("厂商："+JFXT.getSimpleDictionary('SLPTCS1'));
		alert("区域："+JFXT.getArea('1010'));
		alert("行业类别："+JFXT.getIndustry('4043'));
		alert("分辨率："+JFXT.getResolution('100'));	
		alert("夜视："+JFXT.getSight('101'));	
	}


</script>

</head>
<body style="margin-top:20px" class="bodybg">

<button onclick="alert(JFXT.getAppProperty('1002,1202'));">测试应用属性</button>
<button onclick="simpleDictionary()">测试简单字典</button>

</body>
</html>
