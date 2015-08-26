<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>新增视频摄像头</title>
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
  
<body style="margin-top:10px" class="bodybg">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;">
    	<tr>
    	<td height="100%" valign="top" align="center">
	    <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    
	    
  		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
  		
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
  		</table>
  		<!-- 社会资源窗口开始 -->
  		<div class="easyui-window" style="width:800px;height:480px;" id="winSH" title="社会资源" data-options="closable:false,maximizable:false,minimizable:false,collapsible:false,draggable:false">
  		<form action="<%=basePath%>sptgl/save" id="sxtAddFormSH" name="sxtAddFormSH" method="post">
  		<input type="hidden" id="idSH" name="id" value="${entity.id }"/>
  		<input type="hidden" id="dwbmSH" name='dwbm' value="${entity.dwbm }"/>
  		<input type="hidden" id="jkxtSH" name="jkxt" value="${entity.jkxt }"/>
  		<input type="hidden" id="sfrwSH" name="sfrw" value="${entity.sfrw }"/>
  		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" name="sxtAddWJR" id="sxtAddWJR" >
  		<tr class="dialogTr">
  		<td width="20%" class="dialogTd" align="right">摄像头编号：</td>
	    	<td width="30%" class="dialogTd"><input type="text" id="sxtbhSH" name="sxtbh" value="${entity.sxtbh}" class="easyui-validatebox" style="width:200px;"
	    		data-options="required:true,charSet:'halfUpper'" maxlength="13" /><div class="lodingimg" id="jbxxLoadDiv"></div></td>
	    
  		<td width="20%" class="dialogTd" align="right">管理单位：</td>
	    	<td width="30%" class="dialogTd"><input type="text" id="sxtgldwSH" name="sxtgldw" class="inputReadonly" style="width:200px;"
	    		/></td>
	    
  		</tr>
  		
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">安装部位：</td>
	    	<td width="70%" class="dialogTd" colspan="3"><input type="text" name="azbw" id="azbwSH"  value="${entity.azbw }" class="easyui-validatebox" style="width:380px;"
    		    data-options="required:true" maxlength="20"  />
	    	</td>
	    	
	    	
				    		
	    </tr>
	    
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">经度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jd" id="jdSH"  value="${entity.jd }" class="easyui-validatebox" style="width:200px;"
    		    readonly="readonly" data-options="required:true" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">纬度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="wd" id="wdSH"  value="${entity.wd }" class="easyui-validatebox" style="width:200px;"
    		    readonly="readonly" data-options="required:true" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">朝向：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="cx" id="cxSH"  value="${entity.cx }" class="easyui-validatebox" style="width:200px;"
    		  readonly="readonly"  data-options="required:true" maxlength="20"  />
	    	</td><td width="20%" class="dialogTd" align="right">监控角度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jkjd" id="jkjdSH"  value="${entity.jkjd }" class="easyui-validatebox" style="width:200px;"
    		  readonly="readonly"  data-options="required:true" maxlength="20"  />
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
	    	 	data-options="url: contextPath + '/common/dict/jfxt/D_JF_ResolutionTree.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:200,method:'get',editable:true,lines:true,required:true"></td>
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">夜视非夜视：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combotree' type='text' id="sbyssxSH" name='sbyssx' value="${entity.sbyssx}" style="width:200px;"
	    	    data-options="url: contextPath + '/common/dict/jfxt/D_JF_SighTree.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:200,method:'get',editable:true,lines:true,required:true"></td>
	    	</td>
	    </tr>
   		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">室内室外：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="sb_snswSH" name='sb_snsw' value="${entity.sb_snsw}" style="width:200px;" 
		    	data-options="url: contextPath + '/common/dict/jfxt/D_JF_SNSW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/>
		   	</td>
		</tr>
   		</table>
  		
  		
  		<!-- 按钮开始 -->
  		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 5px; display:block;">
			<a id="saveButtonSH"  class="l-btn l-btn-small" href="javascript:void(0)" >
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			
		</div>
		<!-- 按钮结束 -->
		</form>
  		</div>
  		<!-- 社会资源窗口结束 -->
	    <!-- 入公安网窗口开始 -->
	    <div class="easyui-window" style="width:800px;height:480px;" id="winGA" title="接入公安"  data-options="closable:false,maximizable:false,minimizable:false,collapsible:false,draggable:false">
	    <form action="<%=basePath%>sptgl/save" id="sxtAddFormGA" name="sxtAddFormGA" method="post">
	    <input type="hidden" id="id" name="id" value="${entity.id }"/>
	    <input type="hidden" id="dwbmGA" name='dwbm' value="${entity.dwbm }"/>
  		<input type="hidden" id="jkxtGA" name="jkxt" value="${entity.jkxt }"/>
  		<input type="hidden" id="sfrw" name="sfrw" value="${entity.sfrw }"/>
  		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" name="sxtAddJR" id="sxtAddJR" >
  		<tr class="dialogTr">
	  		<td width="20%" class="dialogTd" align="right">摄像头编号：</td>
		    <td width="30%" class="dialogTd"><input type="text" id="sxtbhGA" name="sxtbh" value="${entity.sxtbh}" class="easyui-validatebox" style="width:200px;"
		    	data-options="required:true,charSet:'halfUpper'" maxlength="13" /><div class="lodingimg" id="jbxxLoadDiv"></div>
			</td>
	  		<td width="20%" class="dialogTd" align="right">管理单位：</td>
		    <td width="30%" class="dialogTd"><input type="text" id="sxtgldw" name="sxtgldw" class="inputReadonly" style="width:200px;"/>
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
			<td width="20%" class="dialogTd" align="right">所在社区：</td>
			<td width="30%" class="dialogTd" >
			
		    <input type="hidden" id="orgcode1" name="sszrq" value="${entity.sszrq }"  />
	    	<input type="text" id="orgname1" name="orgname1" style="width:150px;" value="" class="easyui-validatebox"/>
	   		<input type="hidden" id="orgid1" name="orgid1" value=""  />
	    	<input type="button" id="orgbutton1" value="选择" onClick="selectOrganization()" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    
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
    		  readonly="readonly"  data-options="required:true" maxlength="20"  />
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
	    <div id="saveDiv" style="text-align:center; height:50px; padding-top: 5px; display:block;">
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
initAddressSearch('fzdz1', {}, 'azbw_rw_mlpdm', 'azbw_rw_mlpxz', 'fzdz2', {text:'azbw_rw_dzxz',id:'azbw_rw_dzdm'}, null, null);

$(document).ready(function(){
		//$('#sxtAddFormSH').form("disableValidation");//禁止校验
		//根据摄像头编码自动填充经纬度
		if ($("#sxtbhSH").val() != "") {
			$("#sxtbhSH").attr("sxtbhSH", $("#sxtbhSH").val());
		}
		$("#sxtbhSH").bind("blur",function(e){	
			checkTm("SH");
		});
	
		if ($("#sxtbhGA").val() != "") {
			$("#sxtbhGA").attr("sxtbhGA", $("#sxtbhGA").val());
		}
		$("#sxtbhGA").bind("blur",function(e){	
			checkTm("GA");
		});
		public_getOrgName('orgcode1', 'orgname1');
		//检查该用户下是否已有单位和监控系统
		checkCount();
		$('#sxtAddFormSH').form({
		 onSubmit:function(){
			if($('#dwbm').val()==""){
	        	alert("请选择建设单位！");
	        	return false;
	        }
	        if($('#jkxt').val()==""){
	        	alert("请选择监控系统！");
	        	return false;
	        }
	        return $(this).form('validate');  
        }, 
        success:function(data){
            var json = $.parseJSON(data);
            if(json.status == 'success'){
          	    //保存成功后跳转到列表列表页面（这里也可以添加一些其他页面流程）
          	    var url = contextPath+"/forward/jfxt|spsxtList";
          	    parent.document.getElementById("mainAreaId").src = url;
             }else{
            	topMessagerAlert(null,json.message);
            }
        }  
    }); 
		$('#sxtAddFormGA').form({  
        onSubmit:function(){
			var returnVal=checksxtDWmc();//检查点位名称是否重名
        	if(returnVal==-1){//错误
        		return false;//阻止提交
        	}
        	
        	var dwmc=$('#dwmc').val();
        	if(dwmc!=null && (dwmc!='undefined')){//修改状态
        		var dwmcOld=$('#dwmcOld').val();
        		var dwmc=$('#dwmc').val();
        		if(dwmcOld!=dwmc){//修改了原单位名称
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
	        	alert("请选择建设单位！");
	        	return false;
	        }
	        if($('#jkxt').val()==""){
	        	alert("请选择监控系统！");
	        	return false;
	        }
			return $(this).form('validate');        		  
        },  
        success:function(data){
            var json = $.parseJSON(data);
            if(json.status == 'success'){
          	    //保存成功后跳转到列表列表页面（这里也可以添加一些其他页面流程）
          	    var url = contextPath+"/forward/jfxt|spsxtList";
          	    parent.document.getElementById("mainAreaId").src = url;
             }else{
            	topMessagerAlert(null,json.message);
            }
        }  
    });
	$('#saveButtonSH').click(function(){	
		topMessager.confirm('操作确认', '您是否保存摄像头信息？',  function(r) {
			if (r) {
				$('#sxtAddFormSH').submit();
			}
		});
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
	var url = '<%=basePath %>sptgl/getSpjkxtByDw?curTime='+(new Date()).getTime()+'&dwbm='+rec.id;
	//alert(rec.id); 
	//$("#jkxt").combobox('clear');
	$('#jkxt').combobox('reload', url);
	var d=rec.id;
	$("#dwbmSH").val(d);
	$("#dwbmGA").val(d);
	
}
function  selectedJKXT(rec){
	var mlwsx=rec.lwsx;
	//alert(mlwsx);
	var j=rec.jkxt;
	$("#jkxtSH").val(j);
	$("#jkxtGA").val(j);
	$('#sfrwSH').val(mlwsx);
	$('#sfrw').val(mlwsx);
//alert(mlwsx);
	getWindow(mlwsx);
}
function checkCount(){

$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/querySpjkxtCount",
		dataType:"json",
		success:function(data) {
		//alert(data.Spsxtvo.jkxtNum);
			if(data.Spsxtvo.jsdwNum=="0"){
				alert('没有你管理的视频建设单位，请首先录入它!');
				return false;
			}
			if(data.Spsxtvo.jkxtNum=="0"){
				alert('没有你管理的视频监控系统，请首先录入它!');
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
	var pic_l=$("#pic_locationSH").val();
    var hsUrl = "/sptgl/showPicJsp?";
	hsUrl+="path="+pic_l;
	menu_open("摄像头照片",hsUrl);
}
function getWindow(mrw){
	if(mrw=='1'){
		$('#winGA').window('close');
		$('#winSH').window('open');
	}
	else{
		$('#winSH').window('close');
		$('#winGA').window('open');
	}
}
function showWindow(){
	var opt=$('#jkxt').combobox('options');
	var data=$('#jkxt').combobox('getData');
	var getvales=$('#jkxt').combobox('getValues');
	var myjkxt=$('#jkxt').val();
	alert(getvales.length);
	alert("opt"+opt);
	alert("data"+data+"----getvales"+getvales);
	alert("opt.valueField---"+opt.valueField);
	alert("opt.valueField---"+opt.jkxt);
	var mrw="";
	//mrw=data[0]['lwsx'];
	//alert("mrw"+mrw);
	/*for(var i=0;i<data.length;i++){
		alert('data[i][opt.valueField]'+data[i][opt.valueField]+'lwsx'+data[i]['lwsx']);
		if(data[i][opt.valueField]==myjkxt){
			mrw=data[i]['lwsx'];
			
			alert("sfrw"+mrw+'data[i][opt.valueField]'+data[i][opt.valueField]);
			break;
		}
	}*/
	//getWindow(mrw);
	
}
window.onload=function(){
	getSsjgdmName();
	var myid=$('#id').val();
	if(!(myid==''||myid=='undefined')){
		setValue();
	}
	var mydwbm=$('#dwbm').val();
	//alert(mydwbm);
	//var url = '<%=basePath %>sptgl/getSpjkxtByDw?dwbm='+mydwbm;
	//$('#jkxt').combobox('reload', url);
	//setLWSXValue(url);
	//根据是否入网显示window
	var myjkxt=$('#jkxt').val();

	if(!(myjkxt==undefined || myjkxt=='')){
		setLWSXValue();
	}
	
}
//获得管理部门
function getSsjgdmName(){

$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/getSsjgdmName",
		dataType:"json",
		success:function(data) {
		//alert(data.ORGNAME);
			$("#sxtgldwSH").val(data.ORGNAME);
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
function checksxtDWmc(){
	var dwmc=$("#dwmc").val();
	var dwbm=$("#dwbm").val();
	dwmc=stringTrim(dwmc);
	if(dwmc==""){
		alert('点位名称不允许为空');	
		return -1;	
	}
	var mydata="";
	mydata={dwmc:dwmc,dwbm:dwbm};
	
	var retVal=-1;
	$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/checkSameNameSH",
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
	//var v="210204000000";
	//$('#org').combobox('setValue', v)	;
	var v=$('#dwbm').val();//combobox('getText');
	var opts=$('#dwbm').combobox('options');
	var url=opts.url+"?q="+v;
	$.getJSON(url,function(data){
		$('#dwbm').combobox('setValue', data[0].id);
		$('#dwbm').combobox('setText', data[0].name);
	})
	//$('#dwbm').combobox('reload',url);
	//alert(url+"=="+v);
	
}
function setLWSXValue(){
	var v=$('#jkxt').val();//combobox('getText');
	//alert("v"+v);
	var url='<%=basePath %>spjkxt/queryLwsxByXh?xh='+v;
	$.getJSON(url,function(data){
		$('#jkxt').combobox('setValue', data.JKXT);
		$('#jkxt').combobox('setText', data.XTMC);
		getWindow(data.LWSX);
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
		//第四个参数取值:01--社区,04--责任区
		public_singleSelectOrg(g_filterOrgCode, '01', '', '', 'orgcode1', 'orgname1', 'orgid1', false, false, '', window, 'onOrgSelected', '');
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

function onOrgSelected(orgCodeInputID) {
	//alert(orgCodeInputID);
}
</script>

</body>
</html>
