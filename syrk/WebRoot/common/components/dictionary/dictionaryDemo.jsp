<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>字典组件demo</title>
	<link rel="stylesheet" type="text/css" href="project/zhdd/css/zhdd.css" />
	
	<script type="text/javascript" src="framework/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="framework/tree/scripts/jsframework.js"></script>
	<script type="text/javascript" src="common/tools/SysTool.js"></script>
	<script type="text/javascript" src="common/config/SysConfig.js"></script>
	<script type="text/javascript" src="common/components/dictionary/js/dictionary.js"></script>
</head>
<body style="background:#ccc"/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<div id="dictDemoDiv" style="position:relative;">
<select size="5">
<option>1sdfsf</option>
<option>2sdfsf</option>
<option>3sdfsf</option>
<option>4sdfsf</option>
<option>5sdfsf</option>
<option>6sdfsf</option>
<option>7sdfsf</option>
<option>8sdfsf</option>
<option>9sdfsf</option>
<option>10sdfsf</option>
<option>11sdfsf</option>
<option>12sdfsf</option>
<option>13sdfsf</option>
<option>14sdfsf</option>
<option>15sdfsf</option>
<option>16sdfsf</option>
</select>
	<label>性别：<input type="hidden" id="sexDM" name="sexDM" /><input type="text" id="sex" name="sex" class="tips_slect" />
    </label>
    
    <label>道路：<input type="hidden" id="dlDM" name="dlDM" /><input type="text" id="dl" name="dl" class="tips_slect" />
    </label>
          
    <label>路段：<input type="hidden" id="ldDM" name="ldDM" /><input type="text" id="ld" name="ld" class="tips_slect" />
    </label>

             
    <!-- <div class="clear" id="sexDataDiv"></div>
        <label>性别：<input type="hidden" id="sexDM" name="sexDM" /><input type="text" id="sex" name="sex" class="tips_slect" />
          <div class="selct_div" id="selectSex"></div></label>  
        <label>性别1：<input type="hidden" id="sexDM1" name="sexDM1" /><input type="text" id="sex1" name="sex1" class="tips_slect" />
          <div class="selct_div" id="selectSex1"></div>  </label> -->         
    
    <!-- <div class="clear" id="dlDataDiv"></div>
        <label>道路：<input type="hidden" id="dlDM" name="dlDM" /><input type="text" id="dl" name="dl" class="tips_slect" />
          <div class="selct_div" id="selectDl"></div> </label> 
          
    <div class="clear" id="ldDataDiv"></div>
        <label>路段：<input type="hidden" id="ldDM" name="ldDM" /><input type="text" id="ld" name="ld" class="tips_slect" />
          <div class="selct_div" id="selectLd"></div> </label>  -->
    
	
    <div class="clear" id="jqlbDataDiv"></div>
	<label>&nbsp;&nbsp;&nbsp;&nbsp;警情类别：<input type="hidden" name="jqlbDm" id="jqlbDm"/><input type="text" name="jqlb" id="jqlb" class="tips_slect" onExit="jqlb_exit();"/>
    </label> 
    <label>&nbsp;&nbsp;&nbsp;&nbsp;警情类别1：<input type="hidden" name="jqlbDm1" id="jqlbDm1"/><input type="text" name="jqlb1" id="jqlb1" class="tips_slect" onExit="jqlb1_exit();"/>
    </label> 
</div>
    
    <script type="text/javascript">
    	
    	/**
		 * 初始化字典列表
		 * @param {Object} param JSON对象（包括：url 请求url，data请求得参数（包括：zdbh 字典编号（字典表名）。），dictShowId 显示字典词条的input控件id，initVal 初始值。）
		 * @param {Function} callback 回调函数
		 */
    	Dictionary.initDictionaryList({url: "dictionary/getDictionaryListJSON.f", data: {"zdbh": "D_SEX"}, dictShowId: "sex", dictContainerReferenceObjectId: "dictDemoDiv", initVal: "sex1"}, function() {
    		alert("性别字典退出事件！");
    	});
    	
    	Dictionary.initDictionaryList({url: "dictionary/getDlDictionaryListJSON.f", data: {"zdbh": "JT_ROADITEM_PL", "xzqh": "510683"}, dictShowId: "dl", dictContainerReferenceObjectId: "dictDemoDiv", initVal: ""}, function() {
    		alert("道路字典退出事件！");
    		if ($("#ldDm").val() != "") {
    			$("#ldDm").val("");
    		}
    		if ($("#ld").val() != "") {
    			$("#ld").val("");
    		}
    		Dictionary.initDictionaryList({url: "dictionary/getLdDictionaryListJSON.f", data: {"zdbh": "JT_ROADSEGITEM_PL", "dldm": "10108"}, dictShowId: "ld", dictContainerReferenceObjectId: "dictDemoDiv", initVal: ""}, function() {
	    		alert("路段字典退出事件！");
	    	});
    	});
    	
		/**
		 * 初始化字典列表
		 * @param {Object} param JSON对象（包括：zdbh 字典编号（字典表名），zdmc 字典名称，dictDataDivId 放字典数据的DIV id）
		 * @param {Function} callback 回调函数
		 */
		//Dictionary.initDictList({zdbh: "D_SEX", zdmc: "性别", dictDataDivId: "sexDataDiv"}, function() {
			/**
			 * 生成字典列表
			 * @param {Object} param JSON对象（包括：dictArray 字典数据数组，listWidth 字典列表宽度，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id。）
			 * @param {Function} callback 回调函数
			 */
			//Dictionary.createDictList({dictArray: D_SEX.dictArray, listWidth: D_SEX.listWidth, dictShowId: "sex", dictSelectDivId: "selectSex"}, function(){});
			//Dictionary.createDictList({dictArray: D_SEX.dictArray, listWidth: D_SEX.listWidth, dictShowId: "sex1", dictSelectDivId: "selectSex1"}, function(){});
		//});
		
		/**
		 * 初始化字典列表
		 * @param {Object} param JSON对象（包括：zdbh 字典编号（字典表名），zdmc 字典名称，dictDataDivId 放字典数据的DIV id，xzqh 行政区划，dldm 道路代码）
		 * @param {Function} callback 回调函数
		 */
		//Dictionary.initDictList({zdbh: "JT_ROADITEM_PL", zdmc: "道路", dictDataDivId: "dlDataDiv", xzqh: "510683", dldm: ""}, function() {
			/**
			 * 生成字典列表
			 * @param {Object} param JSON对象（包括：dictArray 字典数据数组，listWidth 字典列表宽度，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id。）
			 * @param {Function} callback 回调函数
			 */
			//Dictionary.createDictList({dictArray: JT_ROADITEM_PL.dictArray, listWidth: JT_ROADITEM_PL.listWidth, dictShowId: "dl", dictSelectDivId: "selectDl"}, function(){
				//alert("道路选择退出事件！");
			///});
		//});
		
		/**
		 * 初始化字典列表
		 * @param {Object} param JSON对象（包括：zdbh 字典编号（字典表名），zdmc 字典名称，dictDataDivId 放字典数据的DIV id，xzqh 行政区划，dldm 道路代码）
		 * @param {Function} callback 回调函数
		 */
		//Dictionary.initDictList({zdbh: "JT_ROADSEGITEM_PL", zdmc: "路段", dictDataDivId: "ldDataDiv", xzqh: "", dldm: "10108"}, function() {
			/**
			 * 生成字典列表
			 * @param {Object} param JSON对象（包括：dictArray 字典数据数组，listWidth 字典列表宽度，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id。）
			 * @param {Function} callback 回调函数
			 */
			//Dictionary.createDictList({dictArray: JT_ROADSEGITEM_PL.dictArray, listWidth: JT_ROADSEGITEM_PL.listWidth, dictShowId: "ld", dictSelectDivId: "selectLd"}, function(){
				//alert("路段选择退出事件！");
			//});
		//});
		
		/**
		 * 调用树插件的函数（字典树需要）
		 */
		Dictionary.usingTreePlugin();
		/**
		 * 初始化字典树
		 * @param {Object} param JSON对象（包括：url 请求url，zdbh 字典编号（字典表名），zdmc 字典名称，dictDataDivId 放字典数据的DIV id）
		 * @param {Function} callback 回调函数
		 */
		Dictionary.initDictTree({url: "dictionary/getDictTreeJSON.f", zdbh: "D_JQLB", zdmc: "警情类别", dictDataDivId: "jqlbDataDiv"}, function() {
			/**
			 * 生成字典树前
			 * @param {Object} param JSON对象（包括：createCount 生成树次数，zdbh 字典编号（字典表名），treeData 树数据对象，dictDataDivId 放字典数据的DIV id)
			 * 
			 */
			Dictionary.beforeCreateDictTree({createCount: 1, zdbh: "D_JQLB", treeData: data_D_JQLB, dictDataDivId: "jqlbDataDiv"});
			/**
			 * 生成字典树
			 * @param {Object} param JSON对象（包括：dictObject 字典对象，treeData 树数据对象，isLeaf 是否只选叶子节点，dictHiddenId 隐藏字典代码的控件id，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id，initVal 初始值。）
			 */
			Dictionary.createDictTree({dictObject: D_JQLB, treeData: data_D_JQLB_1, isLeaf: false, dictHiddenId: "jqlbDm", dictShowId: "jqlb", dictContainerReferenceObjectId: "dictDemoDiv", initVal: "caseType122030104"});
			
			Dictionary.beforeCreateDictTree({createCount: 2, zdbh: "D_JQLB", treeData: data_D_JQLB, dictDataDivId: "jqlbDataDiv"});
			Dictionary.createDictTree({dictObject: D_JQLB, treeData: data_D_JQLB_2, isLeaf: true, dictHiddenId: "jqlbDm1", dictShowId: "jqlb1", dictContainerReferenceObjectId: "dictDemoDiv"});
		});
		/**
		 * 警情类别字典退出事件
		 */
		function jqlb_exit() {
			alert("警情类别");
		}
		
		/**
		 * 警情类别1字典退出事件
		 */
		function jqlb1_exit() {
		    // 警情类别1字典退出事件
		    /*警情类别1字典退出事件*/
			alert("警情类别1");
		}
	</script>
</body>
</html>