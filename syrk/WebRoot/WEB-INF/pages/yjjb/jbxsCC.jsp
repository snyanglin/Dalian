<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>初查线索</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
<style>
.thWidth{width:20%;}
</style>
</head>
<body  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;">
    	<tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>xsjbxxb/saveCC" id="jbxxForm" name="jbxxForm" method="post" >
	    	  <div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
	    	  
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/> 
	    	  <input  type='hidden' id="xsdzzbx" name="xsdzzbx" value="${entity.xsdzzbx}"/> 
	    	  <input  type='hidden' id="xsdzzby" name="xsdzzby" value="${entity.xsdzzby}"/> 
	    	  <!-- 初查显示线索地址 -->
	    	  <input  type='hidden' id="entity_zbx" name="sldzzbx" value="${entity.sldzzbx}"/> 
	    	  <input  type='hidden' id="entity_zby" name="sldzzby" value="${entity.sldzzby}"/> 
	    	  <!-- 点击保存标注后才将内容保存到entity_zbx和entity_zby -->
	    	  <input type='hidden' id="entity_zbxYs" name="xsdzzbxYs"/> 
	    	  <input type='hidden' id="entity_zbyYs" name="xsdzzbyYs"/> 
	    	  <!-- input type='hidden' id="fcjg" name="fcjg" value="${entity.fcjg}"/ --> 
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">

	    	      <tr class="dialogTr">
				    	<td width="100"  class="dialogTd" align="right">身份证号：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" id="jbrsfzh" name="jbrsfzh" value="${entity.jbrsfzh}" 
				    		style="width:300px;" data-options="required:true,charSet:'halfUpper',validType:['sfzh']" maxlength="18"/>
				    		<div class="lodingimg" id="yrjbxxDiv"></div>
						</td> 
						<td width="250" class="dialogTd" align="right">姓名：</td>
				    	<td width="300"  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrxm" name="jbrxm" value="${entity.jbrxm}"
		    	 			maxlength="30" style="width:300px;" data-options="required:true,validType:['maxLength[30]']"/>
		    	        </td>
	    	      </tr> 
   	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">性别：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-combobox" id="jbrxb" name="jbrxb" value="${entity.jbrxb}" 
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td width="" class="dialogTd" align="right">出生日期：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrsr" name="jbrsr" value="${entity.jbrsr}"
		    	 			maxlength="20" style="width:300px;" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" />
		    	        </td>
	    	      </tr> 
	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">单位：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" id="jbrdw" name="jbrdw" value="${entity.jbrdw}" 
				    		style="width:300px;" data-options="required:true,validType:['maxLength[100]'],tipPosition:'right'"/>
						</td> 
						<td width="" class="dialogTd" align="right">手机号码：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrmobile" name="jbrmobile" value="${entity.jbrmobile}"
		    	 			maxlength="300" style="width:300px;" data-options="required:true,validType:['maxLength[1000]'],tipPosition:'right'"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
	    	      		<td width="" class="dialogTd" align="right">联系方式：</td>
	    	      		<td width="" class="dialogTd"  colspan="3">
				    		<input class="easyui-validatebox inputReadonly" type="text" readOnly="readOnly" name="jbrlxfs" value="${entity.jbrlxfs}" 
		    	 			maxlength="1000" style="width:870px;"/>
		    	 			</td>
			      </tr>
			      <!-- 
	    	      <c:forEach var="item" items="${listlxfs}" varStatus="i">
		    	       	<tr class="dialogTr">
		    	      		<td width="" class="dialogTd" align="right">联系方式：</td>
					    	<td width="" class="dialogTd"  colspan="3">
					    		<input class="easyui-validatebox inputReadonly" type="text"  readOnly="readOnly" name="jbrlxfsList" value="${item}" 
			    	 			maxlength="1000" style="width:870px;" data-options="required:false,validType:['maxLength[1000]'],tipPosition:'right'"/>
			    	        </td>
		    	      	</tr>
	    	       </c:forEach>
	    	       -->
	    	       
	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">出租车车牌：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" id="czzcp" name="czzcp" value="${entity.czzcp}" 
				    		style="width:300px;" data-options="required:true,validType:['maxLength[10]'],tipPosition:'right'"/>
						</td> 
						<td width="" class="dialogTd" align="right">从业资格证：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="cyzgz" name="cyzgz" value="${entity.cyzgz}"
		    	 			maxlength="300" style="width:300px;" data-options="required:true,validType:['maxLength[10]'],tipPosition:'right'"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
						<td width="" class="dialogTd" align="right">居住地址：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrxjzdz" name="jbrxjzdz" value="${entity.jbrxjzdz}"
		    	 			maxlength="100" style="width:300px;" data-options="required:true,validType:['maxLength[100]'],tipPosition:'right'"/>
		    	        </td>
		    	        <td width="" class="dialogTd" align="right">户籍地址：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" id="hjdz" name="hjdz" value="${entity.hjdz}" 
				    		style="width:300px;" data-options="required:true,validType:['maxLength[100]'],
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
						</td> 
	    	      </tr>	   
	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">线索类型：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-combobox" id="xslx" name="xslx" value="${entity.xslx}" 
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XSLX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td width="" class="dialogTd" align="right">举报信息性质：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-combobox" type="text" id="jbxxxz" name="jbxxxz" value="${entity.jbxxxz}"
		    	 			maxlength="20" style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
		    	        </td>
	    	      </tr> 
       		    <tr class="dialogTr">

    				<td width="" class="dialogTd" align="right">线索发现地址：</td>
					 <td width="" class="dialogTd" colspan="2">
						  <input class="easyui-combobox" id="jzd1" style="width:560px;" value="${entity.xsdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type='hidden' name='xsdzmlpdm' id="xsdzmlpdm" value="${entity.xsdzmlpdm}"/>
						    	<input type='hidden' name='xsdzmlpxz' id="xsdzmlpxz" value="${entity.xsdzmlpxz}"/>
						  </td>
						<td width="" class="dialogTd" >
						<input class="easyui-combobox" id="jzd2" style="width:300px;" value="${fn:replace(entity.xsdzxz, entity.xsdzmlpxz, '')}" 
						data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type="hidden" name="xsdzdm" id="xsdzdm" value="${entity.xsdzdm}"/>
						<input type="hidden" name="xsdzssxdm" id="xsdzssxdm" value="${entity.xsdzssxdm}"/>
					    <input type='hidden' name='xsdzxz' id="xsdzxz" value="${entity.xsdzxz}"/>
						</td>
		    		
	    	    </tr>
	   		      <tr class="dialogTr">
						<td width="" class="dialogTd" align="right">线索地址描述：</td>
				    	<td width="" class="dialogTd" colspan="3" >
				    		<textarea id="xsdzms" name="xsdzms" class="easyui-validatebox" style="width:870px;height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'线索地址描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.xsdzms}</textarea>
						</td>
	    	      </tr>
	    	    <!-- ************************************************* -->
	    	      <tr class="dialogTr" id="mapZRQ">
	    	      	<td width="" class="dialogTd" align="right" valign="top">所属派出所：</td>
		    	    <td width="" class="dialogTd"  colspan="3">
		    	    	<div title="地图信息" style="height:500px;" >  
						<iframe width="868" height="100%" id="mapIframe" name ="mapIframe" style="border:1px solid #ccc;" 
								src="<%=basePath%>/forward/map|mapZrq?zbx=${entity.xsdzzbx}&zby=${entity.xsdzzby}">
						</iframe>
						</div>
					</td>
	    	       </tr>
	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right" valign="top">举报内容：</td>
				    	<td width="" class="dialogTd" colspan="3" >
				    		<textarea id="jbnr" name="jbnr" class="easyui-validatebox" style=" width:870px;height:180px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.jbnr}</textarea>
						</td>
	    	      </tr> 	      
	    		   <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">初查结果：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-combobox" id="ccjg" name="ccjg" value="${entity.ccjg}" 
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_DCJG.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:ccjgChange"/>
						</td> 
						<td class="dialogTd"  id="printButton">
							<a   class="l-btn l-btn-small" href="javascript:void(0)" group="">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">打印3日反馈单</span>
									<span class="l-btn-icon icon-print"> </span>
								</span>
							</a>
						</td>

	    	      </tr>
	    	      
	    	      <!-- 查看关联案件 -->
	    	      <tr class="dialogTr" id="ajckglaj" >
		    	    <td width="" class="dialogTd" align="right"></td>
					<td width="" class="dialogTd">
		    	    	<a id="ckglaj" type="button" class="l-btn l-btn-small">
			    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
								<span class="l-btn-text">查看关联案件</span>
								<span class="l-btn-icon icon-search"> </span>
							</span>
			    		</a>
					</td>
	    	       </tr>
	    	       
	    	       <!-- 关联案件 -->
	    	       <tr class="dialogTr" id="ajglaj" >
		    	    <td width="" class="dialogTd" align="right"></td>
					<td width="" class="dialogTd">
		    	    	<a id="glaj" type="button" class="l-btn l-btn-small">
			    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
								<span class="l-btn-text">关联案件</span>
								<span class="l-btn-icon icon-search"> </span>
							</span>
			    		</a>
					</td>
	    	       </tr>
	    	       <!-- 初查结果 -->
	    	       <tr class="dialogTr" id ="ccbzTr">
				    	<td width="" class="dialogTd" align="right">原因说明：</td>
				    	<td width="" class="dialogTd" colspan="3" >
				    		<textarea id="ccbz" name="ccbz" class="easyui-validatebox" style="width: 760px; height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.ccbz}</textarea>
						</td>
	    	      </tr> 
	    	      <!-- 
	    	       <!-- 递转地址 --><!-- 
	    	      <tr class="dialogTr" id="dzdz" >

    				<td width="" class="dialogTd" align="right">递转地址：</td>
					 <td width="" class="dialogTd" colspan="2">
						  <input class="easyui-combobox" id="jzd3" style="width:450px;" value="${entity.sldzmlpxz}" 
						  data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type='hidden' name='sldzmlpdm' id="sldzmlpdm" value="${entity.sldzmlpdm}"/>
						    	<input type='hidden' name='sldzmlpxz' id="sldzmlpxz" value="${entity.sldzmlpxz}"/>
						  </td>
						<td width="" class="dialogTd" >
						<input class="easyui-combobox" id="jzd4" style="width:300px;" value="${fn:replace(entity.sldzxz, entity.sldzmlpxz, '')}"
						data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type="hidden" name="sldzdm" id="sldzdm" value="${entity.sldzdm}"/>
						<input type="hidden" name="sldzssxdm" id="sldzssxdm" value="${entity.sldzssxdm}"/>
					    <input type='hidden' name='sldzxz' id="sldzxz" value="${entity.sldzxz}"/>
						</td>
	    	    </tr>
	   		      <tr class="dialogTr" id="dzdzddms">
						<td width="" class="dialogTd" align="right">地点描述：</td>
				    	<td width="" class="dialogTd" colspan="3" >
				    		<textarea id="sldzms" name="sldzms" class="easyui-validatebox" style="width: 760px; height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'地址描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.sldzms}</textarea>
						</td>
	    	      </tr>	    	    
	    	    <tr class="dialogTr" id="dzdzbz" >
		    	    <td width="" class="dialogTd" align="right">选择责任区：</td>
					<td width="" class="dialogTd">
		    	    	<a id="mapBottonFC" type="button" class="l-btn l-btn-small">
			    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
								<span class="l-btn-text">选择责任区</span>
								<span class="l-btn-icon icon-search"> </span>
							</span>
			    		</a>
					</td>
	    	     </tr>
	    	     
				<tr class="dialogTr">
					<td width="" class="dialogTd" align="right">受理站：</td>
			    	<td width="" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="slfz" name="slfz" value="210200000000"
	    	 			maxlength="300" style="width:300px;" data-options="valueField: 'id',textField: 'text',width:300,
	    	 			url: contextPath + '/common/dict/D_BZ_SLZ.js',onChange: slzchange"/>
	    	        </td>
	    	        <td width="" class="dialogTd" align="right">受理分站：</td>
			    	<td width="" class="dialogTd">
			    		<input class="easyui-combobox" id="slz" name="slz" value="${slz}" 
			    		style="width:300px;" data-options="required:true,validType:['maxLength[100]'],
			    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
					</td> 
	    	      </tr>
	    	       -->
				</table>
		    </div>
		    
	    		
		  </form>
		</div>
	    </div>
	    </div>
		<div style="height:6px;font-size:1px;"></div>
		<div id="saveDiv" style="text-align:center;  padding: 10px 0; display:block;">
		
			<a id="saveButton"  class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">关闭</span>
					<span class="l-btn-icon icon-cancel"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="resetBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">重置</span>
					<span class="l-btn-icon icon-reset"> </span>
				</span>
			</a>
		</div>

</td>
</tr>
</table>
</div>
<script type="text/javascript">

function doInit(paramArray) {

}

function setReadOnlys(){

	setInputReadonly('jbrsfzh', true);
	setInputReadonly('jbrxm', true);
	setInputReadonly('jbrxb', true);
	setInputReadonly('jbrsr', true);
	$('#jbrsr').removeAttr("onclick");
	setInputReadonly('jbrdw', true);
	setInputReadonly('jbrmobile', true);
	setInputReadonly('czzcp', true);
	setInputReadonly('cyzgz', true);
	setInputReadonly('hjdz', true);
	setInputReadonly('jbrxjzdz', true);
	setInputReadonly('xslx', true);
	setInputReadonly('jbxxxz', true);
	setInputReadonly('jzd1', true);
	setInputReadonly('jzd2', true);
	setInputReadonly('xsdzms', true);
	setInputReadonly('jbnr', true);
	setInputReadonly('entity_zbx', true);
	setInputReadonly('entity_zby', true);
}

function check(){
    clearValue();
	var hm = $("#jbrsfzh").val(); 
	if(!$("#jbrsfzh").validatebox("isValid")){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#jbrsfzh").val()+"&cyzjdm=111",
		success:function(data){
		if (data && data.ryjbxxb) {
			$("#jbrxm").val(data.ryjbxxb.xm);
		}
		},
		complete:function(){
			_zjhm = $("#jbrsfzh").val();
			$('#dataForm').form('validate');
			$(".lodingimg").hide();
		}
	});
}
function clearValue(){

	$("#jbrxm").val("");
}
$(function(){
	
	setReadOnlys();
	//地址查询
	initAddressSearch('jzd1', {}, 'xsdzmlpdm', 'xsdzmlpxz', 'jzd2', {text:'xsdzxz',dzxzqh:'xsdzssxdm',id:'xsdzdm'}, null, null);
	initAddressSearch('jzd3', {}, 'sldzmlpdm', 'sldzmlpxz', 'jzd4', {text:'sldzxz',dzxzqh:'sldzssxdm',id:'sldzdm'}, null, null);
	
	// 隐藏递转地址相关选项
	allHide();
	// 默认隐藏打印按钮
	$("#printButton").hide();
	var ccjg=$("#ccjg").val();
	if(ccjg == 40){
		
		//dzdzShow();
	}else if(ccjg==20){
		
		var xsbh = "${entity.id}";
		$.ajax({
			type:"GET",
			sync:true,
			// 根据线索编号查询已关联案件数据
			// 参考：url:contextPath+"/bzdz/ifExistCh",
			url:contextPath+"/xsajgxb/ifExistAj",
			// 传入线索编号
			data:{xsbh:xsbh},
			dataType:'json',
			success:function(json){
				if(json<1){
					// 没有关联案件，线索“案件关联”按钮
					$("#ajglaj").show();
				}else{
					// 已关联案件，显示“查看关联案件”按钮
					$("#ajckglaj").show();
				}
			}
		});
	} else if(ccjg == 30){

		$("#ccbzTr").show();
	}
	
	
	//map标注
	$('#mapBotton').click(function(){  biaozhu();});
	
	$('#mapBottonFC').click(function(){  biaozhu();});
	
	//$("#jbrsfzh").bind("blur",function(e){	check();});
	$('#jbxxForm').form({  
	
        onSubmit:function(){
        
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            
            	topMessagerAlert(null,json.message);
            }else{
            
            	//$("#id").val(json.saveID); 
            	executeTabPageMethod(mainTabID, "reloadDg");
				topMessagerShow(null, "保存成功");
            	//closeSelf();
            	if($("#ccjg").val() == '40'){
            		
            		closeSelf();
            	}else{
            		
            		$("#printButton").show();
            	}
            }
        }  
    });   
	
	$('#saveButton').click(function(){
	
		if($("#ccjg").val() == '00'){
			
			topMessagerAlert("请重新选择初查结果","您的初查处理结果不可以为【待处理】");
			return false;
		}
		topMessager.confirm('操作确认', '您是否保存任务信息？',  function(r) {
		
			if (r) {
			
				
				$('#jbxxForm').submit();
			}
		});
	});
	
	// 关联案件
	$('#glaj').click(function(){
		
		glaj();
	});
	
	// 查看关联案件
	$('#ckglaj').click(function(){
		
		ckglaj();
	});
	
	$('#backButton').click(function(){
		
		closeSelf();
	});
	
	
	$('#printButton').click(function(){
		
		openPrint();
	});
	
	$('#resetBotton').click(function(){
	
		//document.forms["jbxxForm"].reset();
		$('#jbxxForm').form('reset');
	});
});
/*
	function biaozhu(){
		var point = {
			x:$('#entity_zbx').val(),
			y:$('#entity_zby').val()
		}
		var url = contextPath+'/forward/map|mapZrq?zbx='+point.x+'&zby='+point.y;
		var paramArray = [];
		openWindow(false, null, url, 
	   		paramArray, 
	   		{
		   		title:'地图标注（鼠标点击左键标注位置，右键退出标注模式）',
		   		maximizable: false,
		   		width: 850,	
		   		height: 400
	   		}
	   	);
	}
	*/
	function ccjgChange(newValue, oldValue){
		
		allHide();
		
		// 显示递转地址相关选项
		if(newValue == 40){
			
			//dzdzShow();
		}else if(newValue == 20){
			
			var xsbh = "${entity.id}";
			$.ajax({
				type:"GET",
				sync:true,
				// 根据线索编号查询已关联案件数据
				// 参考：url:contextPath+"/bzdz/ifExistCh",
				url:contextPath+"/xsajgxb/ifExistAj",
				// 传入线索编号
				data:{xsbh:xsbh},
				dataType:'json',
				success:function(json){
					if(json<1){
						// 没有关联案件，线索“案件关联”按钮
						alert("请关联案件");
						$("#ajglaj").show();
					}else{
						// 已关联案件，显示“查看关联案件”按钮
						$("#ajckglaj").show();
					}
				}
			});
		} else if(newValue == 30){
			
			$("#ccbzTr").show();
		}
	}
	
	function slzchange(newValue, oldValue){
		
		var url = contextPath+"/common/queryDownOrg?orgCode=" + newValue;
		$('#slz').combobox('reload', url);
		
	}
	// 隐藏初查相关选项
	function allHide(){
		
		$("#dzdz").hide();
		$("#dzdzbz").hide();
		$("#dzdzddms").hide();
		
		$("#ajckglaj").hide();
		$("#ajglaj").hide();
		
		$("#ccbzTr").hide();
		
	}
	
	// 线索地址相关选项
	function dzdzShow(){
		
		$("#dzdz").show();
		$("#dzdzbz").show();
		$("#dzdzddms").show();
	}
	
	function glaj(){
		
		var hsUrl = '/forward/yjjb|glyyaj?xsId=${entity.id}&alarm=${alarm}';
		menu_open('关联已有案件',hsUrl);
	}
	
	function ckglaj(){
		
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = '/xsjbxxb/openXgaj?';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="xsId="+${entity.id}+"&mainTabID="+getMainTabID();
		//mainTabID=1
		menu_open("相关案件列表",hsUrl);
	}
	
	function openPrint(){
		
		var hsUrl = '/xsjbxxb/openPrint?';
		hsUrl+="id="+$("#id").val()+"&mainTabID="+getMainTabID();
		hsUrl+="&flag='3'";
		menu_open('打印3日反馈单',hsUrl);
	}
</script>
</body>
</html>