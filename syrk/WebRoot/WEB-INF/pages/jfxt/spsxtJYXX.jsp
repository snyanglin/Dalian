<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>视频摄像头简要信息</title>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>

<script type="text/javascript" src="<%=contextPath%>/common/jfxt/yysxShow.js"></script>
</head>
  
<body style="margin-top:0px" class="bodybg">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
	    <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    		<form>
    		
  		
		
	    <input type="hidden" id="id" name="id" value="${entity.id }"/>
  		<input type="hidden" id="sfrw" name="sfrw" value="${entity.sfrw }"/>
  		
  		<tr class="dialogTr">
	  		<td width="20%" class="dialogTd" align="right">摄像头编号：</td>
		    <td width="30%" class="dialogTd"><input type="text" id="sxtbhGA" name="sxtbh" value="${entity.sxtbh}" class="inputReadonly" style="width:200px;"
		    	 />
			</td>
	  		<td width="20%" class="dialogTd" align="right">管理单位：</td>
		    <td width="30%" class="dialogTd"><input type="text" id="sxtgldw" name="sxtgldw" class="inputReadonly" style="width:200px;"/>
		    </td>
	    </tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">视频建设单位：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-combobox" type="text" id="dwbm" name="dwbm" value="${entity.dwbm}" style="width:200px;"  maxlength="30"		    	        	
				data-options="mode:'remote',isTopLoad:false,url:'<%=basePath%>idName/getSpdwIdNameByCondition',required:true,valueField: 'id',textField:'name',onLoadSuccess: function(){},onSelect: selectedItem" />	    	        	
		    </td>
  	        <td width="20%" class="dialogTd" align="right">视频监控系统：</td>
	    	<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type='text' name="jkxt" id="jkxt" value="${entity.jkxt }" style="width:200px;"
				 data-options="required:true, valueField:'jkxt',textField:'xtmc', onSelect: selectedJKXT"/></td>
			</tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">点位名称：</td>
	    	<td width="30%" class="dialogTd">
	    		<input type="hidden" name="dwmcOld" id="dwmcOld" value="${entity.dwmc}" />
	    		<input type="text" name="dwmc" id="dwmc"  value="${entity.dwmc }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper'" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">点位俗称：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="dwsc" id="dwsc"  value="${entity.dwsc }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper'" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">系统ID编码：</td>
	    	<td width="30%" class="dialogTd">
	    		<input type="text" name="xtidbm" id="xtidbm"  value="${entity.xtidbm }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:false,charSet:'halfUpper'" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">摄像头IP地址：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="sxtip" id="sxtip"  value="${entity.sxtip }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:false,charSet:'halfUpper'" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">所在社区：</td>
			<td width="30%" class="dialogTd" >
			
		    <input type="hidden" id="orgcode1" name="sszrq" value="${entity.sszrq }"  />
	    	<input type="text" id="orgname1" name="orgname1" style="width:380px;" value="" />
	   		<input type="hidden" id="orgid1" name="orgid1" value=""  />
	    	</td>
		    <td width="20%" class="dialogTd" align="right">所在区域：</td>	
		    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="dlqy" name='dlqy' value="${entity.dlqy }" style="width:200px;"  maxlength="30"
		    	data-options="url:'<%=basePath %>sptgl/getSzdlqy?curTime='+(new Date()).getTime(),textField:'meaning',valueField:'code',required:true"/>
		    </td>
		</tr>
 	    <tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">标准地址：</td>
			<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-combobox" id="fzdz1" style="width:380px;" value="${entity.azbw_rw_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type='hidden' name='azbw_rw_mlpdm' id="azbw_rw_mlpdm" value="${entity.azbw_rw_mlpdm}"/>
				<input type='hidden' name='azbw_rw_mlpxz' id="azbw_rw_mlpxz" value="${entity.azbw_rw_mlpxz}"/>
			</td>
			<td width="30%" class="dialogTd">
				<input class="easyui-combobox" id="fzdz2" style="width:200px;" value="${fn:replace(entity.azbw_rw_dzxz, entity.azbw_rw_mlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type='hidden' name='azbw_rw_dzdm' id='azbw_rw_dzdm' value="${entity.azbw_rw_dzdm}" />
				<input type='hidden' name='azbw_rw_dzxz' id='azbw_rw_dzxz' value="${entity.azbw_rw_dzxz}" /> 
			</td>
		</tr>
 	    <tr class="dialogTr">
    	<td width="20%" class="dialogTd" align="right">安装部位：</td>
    	<td width="70%" class="dialogTd" colspan="3"><input type="text" name="azbw" id="azbw"  value="${entity.azbw }" class="easyui-validatebox" style="width:380px;"
    		    data-options="required:true" maxlength="20"  /><br>
  	        	
	    </td>		    	        
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">经度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jd" id="jdGA"  value="${entity.jd }" class="easyui-validatebox" style="width:200px;"
    		    readonly="readonly" data-options="required:true" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">纬度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="wd" id="wdGA"  value="${entity.wd }" class="easyui-validatebox" style="width:200px;"
    		    readonly="readonly" data-options="required:true" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">朝向：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="cx" id="cxGA"  value="${entity.cx }" class="easyui-validatebox" style="width:200px;"
    		  readonly="readonly"  data-options="required:true" maxlength="20"  />
	    	</td><td width="20%" class="dialogTd" align="right">监控角度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jkjd" id="jkjdGA"  value="${entity.jkjd }" class="easyui-validatebox" style="width:200px;"
    		  readonly="readonly"  data-options="required:true" maxlength="20"  /><input type="hidden" id="pic_locationGA" name="pic_location"  value="${entity.pic_location }" >
	    	</td>
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">点位高度(米)：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="dwgd" id="dwgd"  value="${entity.dwgd }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper',validType:['numeric']" maxlength="4"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">室内室外：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="sb_snsw" name='sb_snsw' value="${entity.sb_snsw}" style="width:200px;" 
		    	data-options="url: contextPath + '/common/dict/jfxt/D_JF_SNSW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/>
		   	</td>
	    </tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">枪机球机：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="sb_qjqjSH" name='sb_qjqj' value="${entity.sb_qjqj}" style="width:200px;" 
		    	data-options="url: contextPath + '/common/dict/jfxt/D_JF_QJQJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td> 
	    	 
	    	<td width="20%" class="dialogTd" align="right">固定可动：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="sb_gdSH" name='sb_gd' value="${entity.sb_gd}" style="width:200px;" 
		    	data-options="url: contextPath + '/common/dict/jfxt/D_JF_GDKD.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/>
		    </td> 
	    </tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">标清高清：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combotree' type='text' id="sbgqsxSH" name='sbgqsx' value="${entity.sbgqsx}" style="width:200px;"
	    	 	data-options="url: contextPath + '/common/dict/jfxt/D_JF_ResolutionTree.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:200,method:'get',editable:true,lines:true,required:true">
	     	</td>
	    	<td width="20%" class="dialogTd" align="right">夜视非夜视：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combotree' type='text' id="sbyssxSH" name='sbyssx' value="${entity.sbyssx}" style="width:200px;"
	    	    data-options="url: contextPath + '/common/dict/jfxt/D_JF_SighTree.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:200,method:'get',editable:true,lines:true,required:true">
	    	</td>
	    </tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right"><span class="sxtjtbjbs">镜头变焦倍数：</span></td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jtbs" id="jtbs"  value="${entity.jtbs }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper',validType:['numeric']" maxlength="4"  />
	    	</td>
		<td width="20%" class="dialogTd" align="right">应用属性：</td>
	    	<td width="30%" class="dialogTd">
	    		<!-- 实际的应用属性  -->
	    		<input type="hidden" id="yysx" name="yysx"  value="${entity.yysx}" />
	    		<input class='easyui-combotree' id="yysx_xs" name='yysx_xs'  value="${entity.yysx_xs}"  style="width:200px;"
	    	 	data-options="url: contextPath + '/common/dict/jfxt/D_JF_PropertyTree.js',onlyLeafCheck:true,dataFilter:'',multiple:true,panelWidth:200,method:'get',editable:true,lines:true,required:true,onBeforeCheck:beforeCheckComboTree"/>
	    	</td>
		</tr>
	    </form>
	    </table>
	    </div>

	    </div>
	    </div>	    
	    </div>

<script type="text/javascript">
initAddressSearch('fzdz1', {}, 'azbw_rw_mlpdm', 'azbw_rw_mlpxz', 'fzdz2', {text:'azbw_rw_dzxz',id:'azbw_rw_dzdm'}, null, null);

$(document).ready(function(){
		
		public_getOrgName('orgcode1', 'orgname1');
			//获得下拉tree中选取的所有值
			var selectedValue=getComboTreeValue();
        	//计算应用属性字段的值        	
        	var appProperty=comboProperty(selectedValue);

});
function  selectedItem(rec){
	var url = '<%=basePath %>sptgl/getSpjkxtByDw?curTime='+(new Date()).getTime()+'&dwbm='+rec.id;
	//var url = '<%=basePath %>nvrInfo/getNVRByPt?curTime='+(new Date()).getTime()+'&dwbm='+rec.id;
	//alert(rec.id); 
	//$("#jkxt").combobox('clear');
	$('#jkxt').combobox('reload', url);
	//var d=rec.id;
	//$("#dwbmSH").val(d);
	//$("#dwbmGA").val(d);
	
}
function  selectedJKXT(rec){
	var mlwsx=rec.lwsx;
	//alert(mlwsx);
	var j=rec.jkxt;
	//$("#jkxtSH").val(j);
	//$("#jkxtGA").val(j);
	//$('#sfrwSH').val(mlwsx);
	//$('#sfrw').val(mlwsx);
//alert(mlwsx);
	//getWindow(mlwsx);
}


function showPic(){
	var pic_l=$("#pic_locationSH").val();
    var hsUrl = "/sptgl/showPicJsp?";
	hsUrl+="path="+pic_l;
	menu_open("摄像头照片",hsUrl);
}

window.onload=function(){
	getSsjgdmName();
	var myid=$('#id').val();
	if(!(myid==''||myid=='undefined')){
		setValue();
	}
	var mydwbm=$('#dwbm').val();
	//alert(mydwbm);
	var url = '<%=basePath %>sptgl/getSpjkxtByDw?dwbm='+mydwbm;
	//var url = '<%=basePath %>nvrInfo/getNVRByPt?dwbm='+mydwbm;
	$('#jkxt').combobox('reload', url);
	
}
//获得管理部门
function getSsjgdmName(){

$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/getSsjgdmName",
		dataType:"json",
		success:function(data) {
		//alert(data.ORGNAME);
			$("#sxtgldw").val(data.ORGNAME);
		},
		complete:function() {
		},
		error:function() {
		}
	});

}
</script>

<script type="text/javascript">

//重写内部下拉树
function beforeCheckComboTree(node,checked){
	//alert(node.text+","+checked);
	var t = $('#yysx_xs').combotree('tree');	// 获取树对象
	//var n = t.tree('getSelected');

	var rootNode=t.tree('getRoot');//根节点
	var parentNode=t.tree('getParent',node.target);
	if(parentNode==null)
		return false;
	if(parentNode==rootNode)
		return true;
	var childrenNode=t.tree('getChildren',parentNode.target);
	var childCount=childrenNode.length;//儿子数
	for(var i=0;i<childCount;i++){
		var currentNode=childrenNode[i];
		if(currentNode!=node){
			//currentNode.checked='checked';
			//取消选中状态					
			t.tree('update', {
				target: currentNode.target,
				checked: false
			});
		}//end if
	}//end for
}					

var propertyArray=[
['1001'],
['1401'],
['2301'],
['2201','2202','2203'],
['1604'],
['2901'],
['1801','1802','1803'],
['2403'],
['2101','2102'],
['2302'],
['00000'],
['00000']
];

//根据选择的应用属性组合为省厅要求的应用属性
function comboProperty(selectedAttr){
	var result="";
	for(var i=0;i<propertyArray.length;i++){
		var bFound=false;
		for(var j=0;j<propertyArray[i].length;j++){
			var theItem=propertyArray[i][j];
			if(selectedAttr.indexOf(theItem)>-1){
				bFound=true;
				break;
			}
		}//end for(j)
		result+=bFound?'1':'0';
	}//end for(i)
	return result;
}

//获得下拉tree中检取的所有值
function getComboTreeValue(){
	var selectedValue = $('#yysx_xs').combotree('getValues');
	var result=selectedValue.join(',');
	//alert("selectedValue="+result);
	return 	result;
		
}
	
//alert(comboProperty('1001,2302,2403,2202'));
//设置属性值
function setValue(){
	
	var v=$('#dwbm').val();
	var opts=$('#dwbm').combobox('options');
	var url=opts.url+"?q="+v;
	$.getJSON(url,function(data){
		$('#dwbm').combobox('setValue', data[0].id);
		$('#dwbm').combobox('setText', data[0].name);
	})
	
}
</script>	
<script type="text/javascript">
var g_filterOrgCode="210200000000";//全局变量

$(document).ready(function() { // 初始化部门名称
	public_getOrgName('orgcode', 'orgname');
	setFilterOrgCode();//获得初始过滤组织机构
});


//点击按钮后调用
function selectOrganization(){
	//第四个参数取值:01--社区,04--责任区
	public_singleSelectOrg(g_filterOrgCode, '01', '', '01', 'orgcode1', 'orgname1', 'orgid1', false, false, '', window, 'onOrgSelected', '');
	
}
//为全局变量赋值
function setFilterOrgCode(){
	url=contextPath+"/idName/getFilterOrgCode";
	$.getJSON(url,function(orgCode){
		g_filterOrgCode=orgCode;
		//alert(orgCode);
	})
}

function onOrgSelected(orgCodeInputID) {
	alert(orgCodeInputID);
}
</script>
</body>
</html>
