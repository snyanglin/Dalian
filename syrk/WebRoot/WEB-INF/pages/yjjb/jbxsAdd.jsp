<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>举报线索</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>
<script type="text/javascript" src="<%=basePath%>/js/yjjb.js"></script>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
<body style="margin-top:0px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;">
    	<tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>xsjbxxb/save" id="jbxxForm" name="jbxxForm" method="post" >
	    	  <div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/> 
	    	  <!-- 坐标x，y和三个组织机构的代码 -->
	    	  <input type='hidden' id="entity_zbx" name="xsdzzbx" value="${entity.xsdzzbx}"/> 
	    	  <input type='hidden' id="entity_zby" name="xsdzzby" value="${entity.xsdzzby}"/>
	    	  <!-- 点击保存标注后才将内容保存到entity_zbx和entity_zby 
	    	  <input type='hidden' id="entity_zbxYs" name="xsdzzbxYs"/> 
	    	  <input type='hidden' id="entity_zbyYs" name="xsdzzbyYs"/> 
	    	  -->
	    	  
			  <input type='hidden' id="slfzdm" name="slfzdm" value="${entity.slfzdm}"/> 
		      <input type='hidden' id="slzdm" name="slzdm" value="${entity.slzdm}"/> 
			  <input type='hidden' id="slzxdm" name="slzxdm" value="${entity.slzxdm}"/> 
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
				    	<td width="100" class="dialogTd" align="right">身份证号：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" id="jbrsfzh" name="jbrsfzh" value="${entity.jbrsfzh}" 
				    		style="width:300px;float:left" data-options="required:true,charSet:'halfUpper',validType:['sfzh']" maxlength="18"/>
				    		<div class="lodingimg" id="yrjbxxDiv"></div>
						</td> 
						<td width="250" class="dialogTd" align="right">姓名：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrxm" name="jbrxm" value="${entity.jbrxm}"
		    	 			maxlength="30" style="width:300px;" data-options="required:true,validType:['maxLength[30]']"/>
		    	        </td>
	    	      </tr> 
   	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">性别：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-combobox" id="jbrxb" name="jbrxb" value="${entity.jbrxb}" 
				    		style="width:300px;" data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td width="" class="dialogTd" align="right">出生日期：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrsr" name="jbrsr" value="${entity.jbrsr}"
		    	 			maxlength="10" style="width:300px;" data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'"
		    	 			onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"  />
		    	        </td>
	    	      </tr> 
	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">单位：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-combobox" id="jbrdwdm" name="jbrdwdm" value="${entity.jbrdwdm}" 
				    		style="width:300px;" data-options="required:false,url: contextPath + '/common/tcdic',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:czcChange"/>
						</td>
						<input type='hidden' name='jbrdw' id="jbrdw" value="${entity.jbrdw}"/> 
						<td width="" class="dialogTd" align="right">手机号码：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrmobile" name="jbrmobile" value="${entity.jbrmobile}"
		    	 			maxlength="1000" style="width:300px;" data-options="required:true,validType:['phone'],tipPosition:'right'"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
	    	      		<td width="" class="dialogTd" align="right">联系方式：</td>
	    	      		<td width="" class="dialogTd"  colspan="3">
				    		<input class="easyui-validatebox" type="text"  name="jbrlxfs" value="${entity.jbrlxfs}" 
		    	 			maxlength="1000" style="width:870px;"/>
		    	 			</td>
			      </tr>
			      <!-- 
			      <c:forEach var="item" items="${listlxfs}" varStatus="i">
		    	       	<tr class="dialogTr">
		    	      		<td width="" class="dialogTd" align="right">联系方式：</td>
		    	      		<td width="" class="dialogTd"  colspan="3">
					    		<input class="easyui-validatebox" type="text"  name="jbrlxfs" value="${entity.jbrlxfs}" 
			    	 			maxlength="1000" style="width:845px;"/>
			    	 			</td>
		    	      		
					    	<td width="" class="dialogTd"  colspan="3">
					    		<input class="easyui-validatebox" type="text"  name="jbrlxfsList" value="${item}" 
			    	 			maxlength="1000" style="width:845px;" data-options="required:false,validType:['maxLength[1000]'],tipPosition:'right'"/>
			    	 			<c:choose>
				    	 			<c:when test="${i.index == '0'}"> <a class="addLine_btn" href="javascript:void(0);" onclick="addcontract(this);" title="增加一个联系方式">&nbsp;</a></c:when>
				    	 			<c:otherwise><a class="delLine_btn" href="javascript:void(0);" onclick="removeS(this);" title="删除当前联系方式">&nbsp;</a></c:otherwise>
			    	 			</c:choose>
			    	        </td>
			    	        
		    	      	</tr>
	    	       </c:forEach>
				   -->
	    	       
	    	      <tr class="dialogTr" id="taxiCp">
				    	<td width="" class="dialogTd" align="right">出租车车牌：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" id="czzcp" name="czzcp" value="${entity.czzcp}" 
				    		style="width:300px;" data-options="required:false,validType:['maxLength[20]'],tipPosition:'right'"/>
						</td> 
						<td width="" class="dialogTd" align="right">从业资格证：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="cyzgz" name="cyzgz" value="${entity.cyzgz}"
		    	 			maxlength="20" style="width:300px;" data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
						<td width="" class="dialogTd" align="right">居住地址：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrxjzdz" name="jbrxjzdz" value="${entity.jbrxjzdz}"
		    	 			maxlength="100" style="width:300px;" data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"/>
		    	        </td>
		    	        <td width="" class="dialogTd" align="right">户籍地址：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" id="hjdz" name="hjdz" value="${entity.hjdz}" 
				    		style="width:300px;" data-options="required:false,validType:['maxLength[100]'],
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
						  <input class="easyui-combobox" id="jzd1" style="width:560px;" value="${entity.xsdzmlpxz}" 
						  data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type='hidden' name='xsdzmlpdm' id="xsdzmlpdm" value="${entity.xsdzmlpdm}"/>
						    	<input type='hidden' name='xsdzmlpxz' id="xsdzmlpxz" value="${entity.xsdzmlpxz}"/>
						  </td>
						<td width="" class="dialogTd" >
						<input class="easyui-combobox" id="jzd2" style="width:300px;" value='${fn:replace(entity.xsdzxz, entity.xsdzmlpxz, "")}'
						 data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type="hidden" name="xsdzdm" id="xsdzdm" value="${entity.xsdzdm}"/>
						<input type="hidden" name="xsdzssxdm" id="xsdzssxdm" value="${entity.xsdzssxdm}"/>
					    <input type='hidden' name='xsdzxz' id="xsdzxz" value="${entity.xsdzxz}"/>
						</td>
		    		
	    	    </tr>
	    	    <tr>
	    	
	    	    <tr class="dialogTr">
						<td width="" class="dialogTd" align="right" valign="top">线索地址描述：</td>
				    	<td width="" class="dialogTd" colspan="3" >
				    		<textarea id="xsdzms" name="xsdzms" class="easyui-validatebox" style="width: 870px; height:48px;"
				    		 onblur="xsdzmsOnblur();" onfocus="xsdzmsOnFocus();"
							data-options="validType:['maxLength[1000]'],invalidMessage:'线索地址描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.xsdzms}</textarea>
						</td>
	    	    </tr>
	    	    <!-- ************************************************* -->
	    	      <tr class="dialogTr">
		    	    <td width="" class="dialogTd" align="right">选择责任区：</td>
					<td width="" class="dialogTd">
		    	    	<a id="mapBotton" type="button" class="l-btn l-btn-small">
			    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
								<span class="l-btn-text">选择责任区</span>
								<span class="l-btn-icon icon-search"> </span>
							</span>
			    		</a>
					</td>
	    	       </tr>

	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right" valign="top">举报内容：</td>
				    	<td width="" class="dialogTd" colspan="3" >
				    		<textarea id="jbnr" name="jbnr" class="easyui-validatebox" style="width:868px; height:230px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.jbnr}</textarea>
						</td>
	    	      </tr> 	      
	    		</table>
		    </div>
		  </form>
		</div>
	    </div>
	    </div>
		<div style="height:6px;font-size:1px;"></div>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
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

var message = "标准地址无法描述的地址信息在此栏录入...";
function doInit(paramArray) {

	setReadOnly();
}

function setReadOnly(){

}

function check(){
	clearValue();
	var sfzh = $("#jbrsfzh").val(); 
	if(!$("#jbrsfzh").validatebox("isValid")){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:contextPath+"/common/tinfo",
		dataType:"json",
		data:{id:$("#jbrsfzh").val()},
		success:function(data){
			if (data) {
				$("#jbrxm").val(data.JBRXM);
				$("#jbrsr").val(data.JBRSR);
				$("#jbrxb").combobox('setValue',data.JBRXB);
				$("#jbrdwdm").combobox('setValue',data.JBRDWDM);
				$("#jbrdw").val(data.JBRDW);
				$("#jbrmobile").val(data.JBRLXFS);
				$("#czzcp").val(data.CZZCP);
				$("#cyzgz").val(data.CYZGZ);
				$("#jbrxjzdz").val(data.JBRXJZDZ);
				$("#hjdz").val(data.HJDZ);
				$("#jbrxm,#jbrmobile,#czzcp,#cyzgz,#jbrxjzdz,#hjdz").validatebox("validate");
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

	$("#jbrxm").val('');
	$("#jbrsr").val('');
	$("#jbrxb").combobox('setValue','');
	$("#jbrdwdm").combobox('setValue','');
	$("#jbrdw").val('');
	$("#jbrmobile").val('');
	$("#czzcp").val('');
	$("#cyzgz").val('');
	$("#jbrxjzdz").val('');
	$("#hjdz").val('');
}
$(function(){
	//$('.datebox :text').attr('readonly','readonly');
	//地址查询
	initAddressSearch('jzd1', {}, 'xsdzmlpdm', 'xsdzmlpxz', 'jzd2', {text:'xsdzxz',dzxzqh:'xsdzssxdm',id:'xsdzdm'}, null, null);
	if($("#id").val() == ''){
		$("#xsdzms").append(message);
		$("#xsdzms").css({color:"GRAY"});
	}
	//map标注
	$('#mapBotton').click(function(){  biaozhu();});
	
	$("#jbrsfzh").bind("blur",function(e){	check();});
	$('#jbxxForm').form({  
	
        onSubmit:function(){
        	if($('#xsdzdm').val()== "" && $("#slfzdm").val()== ""){
        		alert("请选择线索发现地址，或选择责任区！");
        		return false;
        	}
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            
            	topMessagerAlert(null,json.message);
            }else{
            	$("#id").val(json.saveID); 
            	executeTabPageMethod(mainTabID, "reloadDg");
				topMessagerAlert(null, "保存成功","success");
            	closeSelf();
            }
        }  
    });   
	
	$('#saveButton').click(function(){
	
		topMessager.confirm('操作确认', '您是否保存任务信息？',  function(r) {
		
			if (r) {
			
				if($("#xsdzms").val()==message){
					
					$("#xsdzms").val('');
				}
				
				$('#jbxxForm').submit();
			}
		});
	});
	
	$('#backButton').click(function(){
		
		closeSelf();
	});
	
	$('#resetBotton').click(function(){
	
		//document.forms["jbxxForm"].reset();
		$('#jbxxForm').form('reset');
	});
});
	function biaozhu(){
		var point = {
			x:$('#entity_zbx').val(),
			y:$('#entity_zby').val()
		}
		var url = contextPath+'/forward/map|mapZrq?bz=true&zbx='+point.x+'&zby='+point.y;
		//var paramArray = [];
		
		/*
		openWindow(false, null, url, 
	   		paramArray, 
	   		{
		   		title:'地图标注（鼠标点击左键标注位置，右键退出标注模式）',
		   		maximizable: false,
		   		width: 850,	
		   		height: 400
	   		}
	   	);
	   	*/
		var dataOptions = {
	   		title:'地图标注（鼠标点击左键标注位置，右键退出标注模式）',
	   		url:url,
	   		width:850,
	   		height:500
	   	};
	   	NSopenWindow(false,'',window,null,dataOptions,'您是否确认所选择的责任区？','saveBz',null);
	}

	function saveBz(old,data) {
		$(jbxxForm.slfzdm).val(data.slfzdm);
  		$(jbxxForm.slzdm).val(data.slzdm);
  		$(jbxxForm.slzxdm).val(data.slzxdm);
  		$(jbxxForm.xsdzzbx).val(data.zbx);
  		$(jbxxForm.xsdzzby).val(data.zby);
	}
	function czcChange(){
		
		var dwmc = $("#jbrdwdm").combobox('getText');
		if(dwmc){
			$("#jbrdw").val(dwmc);
		}
	}
	/*
	function addcontract(obj){
		
		
		var $this = $(obj);
		var li = '<tr>'+
					'<td width="100px;" class="dialogTd" align="right">联系方式：</td>'+
			    	'<td width="" class="dialogTd" colspan="3" align="left">'+
			    		'<input class="easyui-validatebox lxfs" type="text"  name="jbrlxfsList" maxlength="1000" style="width:845px;" />'+
			 			' <a class="delLine_btn" href="javascript:void(0);" onclick="removeS(this);" title="删除当前联系方式">&nbsp;</a>'+
			        '</td>'	+
		        '</tr>';
		    // 在下一个tr前添加li
			$("#taxiCp").before(li);
		
		$('.lxfs').validatebox({
			required: true,
			validType:['maxLength[1000]'],
			tipPosition:'right'
		});
		
	}
	*/
	/*
	function removeS(obj){
		var $this = $(obj);
		$this.parent().parent().remove();
	}
	*/
	
	function xsdzmsOnblur(){
		
		if($("#xsdzms").val()==''){
			
			$("#xsdzms").val(message);
			$("#xsdzms").css({color:"GRAY"});
		}
	}
	
	function xsdzmsOnFocus(){
		
		if($("#xsdzms").val()==message){
			
			$("#xsdzms").val('');
		}
		
		$("#xsdzms").css({color:"BLACK"});
	}
</script>
</body>
</html>