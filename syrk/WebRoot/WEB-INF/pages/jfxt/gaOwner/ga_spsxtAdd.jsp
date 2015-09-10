<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>新增公安自建视频摄像头</title>
<%
	//交通治安分局:210280
	SessionBean sessionBean=(SessionBean)session.getAttribute("userSession");
	String userOrgCode=sessionBean.getUserOrgCode();
	
	
 %>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
var userOrgCode='<%=userOrgCode%>';
</script>

<script type="text/javascript" src="<%=contextPath%>/common/jfxt/yysxShow.js"></script>
</head>
  
<body style="margin-top:0px" class="bodybg">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;">
    	<tr>
    	<td height="100%" valign="top" align="center">
    	<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">公安自建平台：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-combobox" type="text" id="dwbm" name="dwbm" value="${entity.dwbm}" style="width:200px;"  maxlength="30"		    	        	
				data-options="url:'<%=basePath%>platform/getPlatformNameAndId?curTime='+(new Date()).getTime(),textField:'ptmc',valueField:'id',required:true,onSelect: selectedItem" />	    	        	
		    </td>
  	        <td width="20%" class="dialogTd" align="right">公安自建NVR：</td>
	    	<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type='text' name="jkxt" id="jkxt" value="${entity.jkxt }" style="width:200px;"
				 data-options="required:true, valueField:'id',textField:'sbmc', onSelect: selectedJKXT"/></td>
		</tr>
  		</table>
		<!-- 入公安网窗口开始 -->
	    <div class="easyui-window" style="width:800px;height:500px;" id="winGA" title="接入公安"  data-options="closable:false,maximizable:false,minimizable:false,collapsible:false,draggable:false">
	    <form action="<%=basePath%>sptgl/save" id="sxtAddFormGA" name="sxtAddFormGA" method="post">
	    <input type="hidden" id="id" name="id" value="${entity.id }"/>
	    <input type="hidden" id="dwbmGA" name='dwbm' value="${entity.dwbm }"/>
  		<input type="hidden" id="jkxtGA" name="jkxt" value="${entity.jkxt }"/>
  		<input type="hidden" id="sfrw" name="sfrw" value="${entity.sfrw }"/>
  		<input type="hidden" id="sxtbh" name="sxtbh" value="${entity.sxtbh }"/>
  		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" name="sxtAddJR" id="sxtAddJR" >
  		<tr class="dialogTr">
	  		
	  		<td width="20%" class="dialogTd" align="right">管理单位：</td>
		    <td width="30%" class="dialogTd"><input type="text" id="sxtgldw" name="sxtgldw" class="inputReadonly" style="width:200px;" readonly="readonly"/>
		    </td>
		    <td width="20%" class="dialogTd" align="right">
	    	<input type="button" id="PDAsxtZP" onclick="showPic();" value="查看照片"/>
	    
	    	</td>
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
	    		<input type="hidden" name="xtidbmOld" id="xtidbmOld" value="${entity.xtidbm}" />
	    		<input type="text" name="xtidbm" id="xtidbm"  value="${entity.xtidbm }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper'" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">摄像头IP地址：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="sxtip" id="sxtip"  value="${entity.sxtip }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper',validType:['ip']" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
			<td width="15%" class="dialogTd" align="right">所在责任区：</td>
			<td width="31%" class="dialogTd" >
			<!-- 用于过滤标准地址  -->
			<input type="hidden" id="pcsdmForAddress" name="pcsdmForAddress" />	
		    <input type="hidden" id="orgcode1" name="sszrq" value="${entity.sszrq}"/>
	    	<input type="text" id="orgname1" name="orgname1" style="width:90px;" value="" class="easyui-validatebox" readonly="readonly" data-options="required:true,charSet:'halfUpper'"/>
	   		<input type="hidden" id="orgid1" name="orgid1" value=""  />
	    	<input type="button" id="orgbutton1" value="选择" onClick="selectOrganization()" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    	<input type="checkbox" id="GSGL" name="GSGL"  onclick="setGsgl()">高速公路
		    </td>
		    <td width="20%" class="dialogTd" align="right">所在区域：</td>	
		    <td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="dlqy" name='dlqy' value="${entity.dlqy }" style="width:200px;"  maxlength="30"
		    	data-options="url:'<%=basePath %>sptgl/getSzdlqy?curTime='+(new Date()).getTime(),textField:'meaning',valueField:'code',required:true"/>
		    </td>
		</tr>
 	    <tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">标准地址：</td>
			<td width="50%" class="dialogTd" colspan="2">
			
				<input class="easyui-combobox" id="fzdz1" style="width:380px;" value="${entity.azbw_rw_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
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
    	<td width="30%" class="dialogTd" colspan="2"><input type="text" name="azbw" id="azbw"  value="${entity.azbw }" class="easyui-validatebox" style="width:380px;"
    		    data-options="required:true" maxlength="20"  />  	        	
	    </td>
	    <td width="50%" class="dialogTd" align="left">
	    	<button onclick="getSxtCoordinate();">获取坐标</button>
	    
	    </td>		    	        
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">经度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jd" id="jdGA"  value="${entity.jd }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:false" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">纬度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="wd" id="wdGA"  value="${entity.wd }" class="easyui-validatebox" style="width:200px;"
    		     data-options="required:false" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">朝向：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="cx" id="cxGA"  value="${entity.cx }" class="easyui-validatebox" style="width:200px;"
    		  data-options="required:false" maxlength="20"  />
	    	</td><td width="20%" class="dialogTd" align="right">监控角度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jkjd" id="jkjdGA"  value="${entity.jkjd }" class="easyui-validatebox" style="width:200px;"
    		  data-options="required:false" maxlength="20"  />
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
	    </table>
	    <!-- 按钮开始 -->
	    <div id="saveDiv" style="text-align:center; height:40px; padding-top: 0px; display:block;">
			<a id="saveButtonGA"  class="l-btn l-btn-small" href="javascript:void(0)" >
			<span class="l-btn-left l-btn-icon-left">
				<span class="l-btn-text">保存</span>
				<span class="l-btn-icon icon-save"> </span>
			</span>
			</a>			
		</div>
	    <!-- 按钮结束 -->
	    </form>
	    </div>
		<!-- 入公安网窗口结束 -->
	    <!-- 照片窗口开始 -->
	    <div class="easyui-window" style="width:200px;height:280px;" id="winPDA" title="摄像头照片"  data-options="closable:true,maximizable:false,minimizable:false,collapsible:false,draggable:false">
	    <div style="text-align: center;" >
	    <img alt="" src="" id="imgPDASxt" width="162" height="200"  >
	    <div >
			<a id="backBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="exitOnclick()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">返回</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
		</div>
	    </div>
	    </div>
		<!-- 照片窗口结束 -->
	    </div>
	    </td>
	    </tr>
	    </table>	    
	    </div>
<!-- 交通分局地铁警务室选择 开始   -->
<div id="metro" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"   
        data-options="iconCls:'icon-save',modal:true,closed:true">   
    <div>
    	选择地铁站点警务室:
		<input class='easyui-combobox' type='text' id="comboMetro" name='comboMetro' style="width:200px;" 
		    	data-options="url: contextPath + '/common/dict/jfxt/D_JF_DTZDJWS.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left' "/>
    	<button onclick="getSelectMetro()">选择</button>
    </div>    
</div>  
<!-- 交通分局地铁警务室选择 结束   -->
<script type="text/javascript">
	function getSelectMetro(){
		var selMetro=$('#comboMetro').combobox('getValue');
		var selMetroText=$('#comboMetro').combobox('getText');
		$('#orgcode1').val(selMetro);
		$('#orgname1').val(selMetroText);
		alert("你选择了:"+selMetro+","+selMetroText);
		$('#metro').dialog('close');//关闭
	}
</script>
<script type="text/javascript">
//document.getElementById("imgPDASxt").src = contextPath+"/sptgl/showPicJsp?sxtid=${entity.id}";
//根据责任区过滤标准地址
initAddressSearch('fzdz1', {pcsdm:'#pcsdmForAddress'}, 'azbw_rw_mlpdm', 'azbw_rw_mlpxz', 'fzdz2', {text:'azbw_rw_dzxz',id:'azbw_rw_dzdm'}, null, null);



$(document).ready(function(){
	//$('#sxtAddFormGA').form("disableValidation");//禁止校验	
	//if ($("#sxtbhGA").val() != "") {
		//	$("#sxtbhGA").attr("sxtbhGA", $("#sxtbhGA").val());
		//}
		//$("#sxtbhGA").bind("blur",function(e){	
		//	checkTm("GA");
		//});
		public_getOrgName('orgcode1', 'orgname1');
		//检查该用户下是否已有单位和监控系统
		//checkCount();
		
		$('#sxtAddFormGA').form({  
        	onSubmit:function(){
				//检查系统id编码是否重复
        		var retXTIDBM=checkXTIDBM();
            	if(retXTIDBM==-1){//错误
            		return false;//阻止提交
            	}
            	
            	var xtidbm=$('#xtidbm').val();
            	if(xtidbm!=null && (xtidbm!='undefined')){//修改状态
            		var xtidbmOld=$('#xtidbmOld').val();
            		var xtidbm=$('#xtidbm').val();
            		if(xtidbmOld!=xtidbm){//修改了原系统id编码
            			if(retXTIDBM>0){
            				alert('系统id编码重复啦！请重新填写！');
            				return false;
            			}
            		}
            	}
            	else{//新增状态
            		if(retXTIDBM>0){
            			alert('系统id编码重复啦！请重新填写！');
            			return false;
            		}
            	}
			
			
        	
        	var returnVal=checksxtDWmc();//检查点位名称是否重名
        	if(returnVal==-1){//错误
        		return false;//阻止提交
        	}
        	
        	var dwmc=$('#dwmc').val();
        	if(dwmc!=null && (dwmc!='undefined')){//修改状态
        		var dwmcOld=$('#dwmcOld').val();
        		var dwmc=$('#dwmc').val();
        		if(dwmcOld!=dwmc){//修改了原点位名称
        			if(returnVal>0){
        				alert('点位名称重名啦！请重新填写！');
        				return false;
        			}
        		}
        	}
        	else{//新增状态
        		if(returnVal>0){
        			alert('点位名称重名啦！请重新填写！');
        			return false;
        		}
        	}
		//获得下拉tree中选取的所有值
		var selectedValue=getComboTreeValue();
        	//计算应用属性字段的值        	
        	var appProperty=comboProperty(selectedValue);
        	$('#yysx').val(appProperty);//写应用属性值
        	if($('#dwbm').val()==""){
        		alert("请选择平台！");
        		return false;
        	}
        	if($('#jkxt').val()==""){
        		alert("请选择NVR！");
        		return false;
        	}
        	
		return $(this).form('validate');        		  
        },  
        success:function(data){
            var json = $.parseJSON(data);
            if(json.status == 'success'){
          	    //保存成功后跳转到列表列表页面（这里也可以添加一些其他页面流程）
          	    var url = contextPath+"/forward/jfxt|gaOwner|ga_spsxtList";
          	    parent.document.getElementById("mainAreaId").src = url;
             }else{
            	topMessagerAlert(null,json.message);
            }
        }  
    	});
	$('#saveButtonGA').click(function(){
		topMessager.confirm('操作确认', '您是否保存摄像头信息？',  function(r) {
			if (r) {
				$('#sxtAddFormGA').submit();
			}
		});
	});

});
/**
 * 根据摄像头条码 ，提取坐标、朝向信息
 */
function checkTm(fl) {
	if (!$("#sxtbh"+fl).validatebox("isValid")){
		return;
	}
	var _tm = $("#sxtbh"+fl).attr("sxtbh"+fl);
	if (!_tm) {
		_tm = "";
	} 
	if($("#sxtbh"+fl).val() == _tm){
		return;
	}
	$("#jbxxLoadDiv").show();
	$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/getSpsxtZB",
		dataType:"json",
		data:"tm="+$("#sxtbh"+fl).val(),
		success:function(data) {
			if(data.sxtZBxxVo.barcode=="haven"){
				alert('摄像头条码已存在');
				return false;
			}
			if(data.sxtZBxxVo.lon==null||data.sxtZBxxVo.lon==""){
		   		alert('经纬度坐标数据没有进入公安网，请与刑侦技术人员联系！');
		   	}
		   	else{
				$("#jd"+fl).val(data.sxtZBxxVo.lon);
				$("#wd"+fl).val(data.sxtZBxxVo.lat);
				$("#cx"+fl).val(data.sxtZBxxVo.telori);
				$("#jkjd"+fl).val(data.sxtZBxxVo.teldegree);
				//$("#pic_location"+fl).val(data.sxtZBxxVo.zpjl);
			}
		},
		complete:function() {
			$("#sxtbh"+fl).attr("sxtbh"+fl, $("#sxtbh"+fl).val());
			$("#jbxxLoadDiv").hide();
		},
		error:function() {
		}
	});	
}
function  selectedItem(rec){
	var url = '<%=basePath %>nvrInfo/getNVRByPt?curTime='+(new Date()).getTime()+'&dwbm='+rec.id;
	//alert(rec.id); 
	$('#jkxt').combobox('reload', url);
	var d=rec.id;
	$("#dwbmGA").val(d);
	
}
function  selectedJKXT(rec){
	//alert(mlwsx);
	var j=rec.id;
	$("#jkxtGA").val(j);
	$('#sfrw').val('0');
//alert(mlwsx);
}
function checkCount(){

$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/queryPTNVRCount",
		dataType:"json",
		success:function(data) {
		//alert(data.Spsxtvo.jkxtNum);
			if(data.Spsxtvo.jsdwNum=="0"){
				alert('没有你管理的平台，请首先录入它!');
				return false;
			}
			if(data.Spsxtvo.jkxtNum=="0"){
				alert('没有你管理的NVR，请首先录入它!');
				return false;
			}
			
		},
		complete:function() {
		},
		error:function() {
		}
	});

}
function showPic(){
	//var pic_l=$("#pic_locationSH").val();
    //var pic_sxtid=$('#id').val();
	//var hsUrl = "/sptgl/showPicJsp?sxtid="+pic_sxtid;
	//menu_open("摄像头照片",hsUrl);
	$('#winPDA').window('open');
}

window.onload=function(){
	$('#winPDA').window('close');
	getSsjgdmName();
	var myid=$('#id').val();
	if(myid==''||myid=='undefined'){
		//显示摄像头图片按钮
		document.getElementById("PDAsxtZP").style.display="none";
	}
	else{
		var hsUrl = "/sptgl/showPicJsp.jpg?sxtid="+myid;
		document.getElementById("imgPDASxt").src = contextPath+hsUrl;
		setSSZRQ();
	}
	var mydwbm=$('#dwbm').val();
	//alert(mydwbm);
	var url = '<%=basePath %>nvrInfo/getNVRByPt?dwbm='+mydwbm;
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
//所在责任区初始判断赋值，设为“高速公路”--2015.04.08
function setSSZRQ(){
	//alert('${entity.sszrq}');
	var mc_sszrq='${entity.sszrq}';
	if (mc_sszrq=='高速公路'){
		$("#orgname1").val('高速公路');
		//“选择”按钮无效
		document.getElementById('orgbutton1').disabled=true;
		//“高速公路”复选框勾选
		document.getElementById('GSGL').checked=true; 
	}
	
}
//“高速公路”复选框设置，勾选：所在责任区“选择”按钮无效，责任区设为高速公路；未选：所在责任区“选择”按钮有效--2015.04.08
function setGsgl(){
	var val_Gsgl=document.getElementById('GSGL').checked ? "Y":"N";
	if (val_Gsgl=="Y"){//按钮设为无效 
		document.getElementById('orgbutton1').disabled=true;
		$("#orgname1").val('高速公路');
		$("#orgcode1").val('高速公路');
	}
	else{
		document.getElementById('orgbutton1').disabled=false;
		$("#orgname1").val('');
	}
	
}
</script>
<script type="text/javascript">
function checksxtDWmc(){
	var dwmc=$("#dwmc").val();
	dwmc=stringTrim(dwmc);
	if(dwmc==""){
		alert('点位名称不允许为空');	
		return -1;	
	}
	var mydata="";
	mydata={dwmc:dwmc};
	var retVal=-1;
	$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/checkSameName",
		dataType:"json",
		data:mydata,
		async:false,//强制同步		
		success:function(affectedRow) {
			retVal=affectedRow;
		},
		error:function() {
			retVal= -1;
		}
	});	
	return retVal;
}

function checkXTIDBM(){
	var xtidbm=$("#xtidbm").val();
	xtidbm=stringTrim(xtidbm);
	if(xtidbm==""){
		alert('系统ID编码不允许为空');	
		return -1;	
	}
	var mydata="";
	mydata={xtidbm:xtidbm};
	//alert(xtidbm);
	var retVal=-1;
	$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/checkXTIDBM",
		dataType:"json",
		data:mydata,
		async:false,//强制同步		
		success:function(affectedRow) {
			retVal=affectedRow;
		},
		error:function() {
			retVal= -1;
		}
	});	
	return retVal;
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


//点击社区选择按钮后调用
function selectOrganization(){
	//检查当前用户是否为交通分局,是单独处理
	//userOrgCode="210280110000";
	if(userOrgCode.substring(0,6)=='210280'){
		$('#metro').dialog('open');
	}
	else{
		//第二个参数取值:01只能选择部门；=02只能选择工作组，为空可以选择部门和工作组
		//第三个参数取值:部门等级过滤（多个时用逗号分隔）
		//第四个参数取值:01--派出所,04--责任区，10--社区--2015.03.20修改
		public_singleSelectOrg(g_filterOrgCode, '01', '', '04', 'orgcode1', 'orgname1', 'orgid1', false, false, '', window, 'onOrgSelected', '');
	}
	
}
//为全局变量赋值
function setFilterOrgCode(){
	url=contextPath+"/idName/getFilterOrgCode";
	$.getJSON(url,function(orgCode){
		g_filterOrgCode=orgCode;
		//alert(orgCode);
	})
}

//将选择的责任区处理为所在的派出所，以便对标准地址过滤
function onOrgSelected() {
	var selOrgCode=$('#orgcode1').val();
	var selPcsdm=selOrgCode.substr(0,8)+'0000';//改为派出所
	$('#pcsdmForAddress').val(selPcsdm);
	//alert(selOrgCode+","+selPcsdm+"/"+$('#pcsdmForAddress').val());
	
}

//通过PGIS地图获得当前摄像头坐标
function getSxtCoordinate(){
	var theTabPageID=getMainTabID()//获得当前标签页ID
	//alert("theTabPageID="+theTabPageID);
	//var url="/forward/jfxt|sxtMapLocation?tabPageID="+theTabPageID;
	//menu_open("获得坐标",url );
	
	var url=contextPath+"/forward/jfxt|sxtMapLocation?tabPageID="+theTabPageID;
	var windowParams='width=850,height=650,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes,resizable=yes';
	//var windowParams='fullscreen=yes';
	window.open(url,'mapWindow',windowParams);
}
function exitOnclick(){
	$('#winPDA').window('close');
}
</script>
</body>
</html>
