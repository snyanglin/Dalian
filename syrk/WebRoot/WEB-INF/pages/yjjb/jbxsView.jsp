<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增线索</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>
<script type="text/javascript" src="<%=basePath%>/js/yjjb.js"></script>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
<body  class="easyui-layout" data-options="fit:true">

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
			  <input type='hidden' id="slfzdm" name="slfzdm"/> 
		      <input type='hidden' id="slzdm" name="slzdm"/> 
			  <input type='hidden' id="slzxdm" name="slzxdm"/> 
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
				    	<td width="100" class="dialogTd" align="right">身份证号：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" id="jbrsfzh" name="jbrsfzh" readOnly="readOnly" value="${entity.jbrsfzh}" 
				    		style="width:300px;" data-options="required:true,charSet:'halfUpper',validType:['sfzh']" maxlength="18"/>
				    		<div class="lodingimg" id="yrjbxxDiv"></div>
						</td> 
						<td width="250" class="dialogTd" align="right">姓名：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrxm" name="jbrxm" readOnly="readOnly" value="${entity.jbrxm}"
		    	 			maxlength="30" style="width:300px;" data-options="required:true,validType:['maxLength[30]']"/>
		    	        </td>
	    	      </tr> 
   	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">性别：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="jbrxb" name="jbrxb" value="${entity.jbrxb}" readOnly="readOnly"
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td  class="dialogTd" align="right">出生日期：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrsr" name="jbrsr" value="${entity.jbrsr}" readOnly="readOnly"
		    	 			maxlength="10" style="width:300px;" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" />
		    	        </td>
	    	      </tr> 
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">单位：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="jbrdwdm" name="jbrdwdm" value="${entity.jbrdwdm}" readOnly="readOnly"
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/tcdic',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:czcChange"/>
						</td>
						<input type='hidden' name='jbrdw' id="jbrdw" value="${entity.jbrdw}"/> 
						<td  class="dialogTd" align="right">手机号码：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrmobile" name="jbrmobile" value="${entity.jbrmobile}" readOnly="readOnly"
		    	 			maxlength="1000" style="width:300px;" data-options="required:true,validType:['maxLength[1000]'],tipPosition:'right'"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
	    	      		<td  class="dialogTd" align="right">联系方式：</td>
	    	      		<td  class="dialogTd"  colspan="3">
				    		<input class="easyui-validatebox" type="text" readOnly="readOnly" id="jbrlxfs" name="jbrlxfs" value="${entity.jbrlxfs}" 
		    	 			maxlength="1000" style="width:870px;"/>
		    	 			</td>
			      </tr>
			      <!-- 
	    	      <c:forEach var="item" items="${listlxfs}" varStatus="i">
		    	       	<tr class="dialogTr">
		    	      		<td  class="dialogTd" align="right">联系方式：</td>
					    	<td  class="dialogTd"  colspan="3">
					    		<input class="easyui-validatebox" type="text" readOnly="readOnly" name="jbrlxfsList" value="${item}" 
			    	 			maxlength="1000" style="width:845px;" data-options="required:false,validType:['maxLength[1000]'],tipPosition:'right'"/>
			    	        </td>
		    	      	</tr>
	    	       </c:forEach>
	    	        -->
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">出租车车牌：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" id="czzcp" name="czzcp" value="${entity.czzcp}" readOnly="readOnly"
				    		style="width:300px;" data-options="required:true,validType:['maxLength[20]'],tipPosition:'right'"/>
						</td> 
						<td  class="dialogTd" align="right">从业资格证：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="cyzgz" name="cyzgz" value="${entity.cyzgz}" readOnly="readOnly"
		    	 			maxlength="20" style="width:300px;" data-options="required:true,validType:['maxLength[20]'],tipPosition:'right'"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
						<td  class="dialogTd" align="right">居住地址：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrxjzdz" name="jbrxjzdz" value="${entity.jbrxjzdz}" readOnly="readOnly"
		    	 			maxlength="100" style="width:300px;" data-options="required:true,validType:['maxLength[100]'],tipPosition:'right'"/>
		    	        </td>
		    	        <td  class="dialogTd" align="right">户籍地址：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" id="hjdz" name="hjdz" value="${entity.hjdz}" readOnly="readOnly"
				    		style="width:300px;" data-options="validType:['maxLength[100]'],
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
						</td> 
	    	      </tr>	   
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">线索类型：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="xslx" name="xslx" value="${entity.xslx}" readOnly="readOnly"
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XSLX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td  class="dialogTd" align="right">举报信息性质：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" type="text" id="jbxxxz" name="jbxxxz" value="${entity.jbxxxz}" readOnly="readOnly"
		    	 			maxlength="20" style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
		    	        </td>
	    	      </tr> 
       		    <tr class="dialogTr">

    				<td  class="dialogTd" align="right">线索发现地址：</td>
					 <td  class="dialogTd" colspan="2">
						  <input class="easyui-combobox" id="jzd1" style="width:560px;" value="${entity.xsdzmlpxz}" readOnly="readOnly" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type='hidden' name='xsdzmlpdm' id="xsdzmlpdm" value="${entity.xsdzmlpdm}"/>
						    	<input type='hidden' name='xsdzmlpxz' id="xsdzmlpxz" value="${entity.xsdzmlpxz}"/>
						  </td>
						<td  class="dialogTd" >
						<input class="easyui-combobox" id="jzd2" style="width:300px;" value="${fn:replace(entity.xsdzxz, entity.xsdzmlpxz, '')}" readOnly="readOnly" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type="hidden" name="xsdzdm" id="xsdzdm" value="${entity.xsdzdm}"/>
						<input type="hidden" name="xsdzssxdm" id="xsdzssxdm" value="${entity.xsdzssxdm}"/>
					    <input type='hidden' name='xsdzxz' id="xsdzxz" value="${entity.xsdzxz}"/>
						</td>
		    		
	    	    </tr>
	    	    	<tr class="dialogTr">
						<td  class="dialogTd" align="right">线索地址描述：</td>
				    	<td  class="dialogTd" colspan="3" >
				    		<textarea id="xsdzms" name="xsdzms" class="easyui-validatebox" style="width: 870px; height:48px;" readOnly="readOnly"
							data-options="validType:['maxLength[1000]'],invalidMessage:'线索地址描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.xsdzms}</textarea>
						</td>
	    	      </tr>
	    	    <!-- ************************************************* -->
	    	      <tr class="dialogTr">
		    	    <td  class="dialogTd" align="right">选择责任区：</td>
					<td  class="dialogTd">
		    	    	<a id="mapBotton" type="button" class="l-btn l-btn-small">
			    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
								<span class="l-btn-text">查看责任区</span>
								<span class="l-btn-icon icon-search"> </span>
							</span>
			    		</a>
					</td>
	    	       </tr>

	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">举报内容：</td>
				    	<td  class="dialogTd" colspan="3" >
				    		<textarea id="jbnr" name="jbnr" class="easyui-validatebox" style="width:870px; height:48px;" readOnly="readOnly"
							data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.jbnr}</textarea>
						</td>
	    	      </tr> 	      
	    		</table>
		    </div>
		  </form>
		</div>
	    </div>
	    </div>

</td>
</tr>
</table>
</div>
<script type="text/javascript">

function doInit(paramArray) {

	setReadOnly();
}

function setReadOnly(){
	setInputReadonly('jbrsfzh', true);
	setInputReadonly('jbrxm', true);
	setInputReadonly('jbrxb', true);
	setInputReadonly('jbrsr', true);
	$('#jbrsr').removeAttr("onclick");
	setInputReadonly('jbrdwdm', true);
	setInputReadonly('jbrmobile', true);
	setInputReadonly('jbrlxfs', true);
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
	$("#jbrsr").datebox('');
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
	
	//map标注
	$('#mapBotton').click(function(){  biaozhu();});
	
	$("#jbrsfzh").bind("blur",function(e){	check();});
	$('#jbxxForm').form({  
	
        onSubmit:function(){
        
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
	
	setReadOnly();
});
	function biaozhu(){
		var point = {
			x:$('#entity_zbx').val(),
			y:$('#entity_zby').val()
		}
		var url = contextPath+'/forward/map|mapZrq?zbx='+point.x+'&zby='+point.y;
		var dataOptions = {
	   		title:'地图标注（鼠标点击左键标注位置，右键退出标注模式）',
	   		url:url,
	   		width:850,
	   		height:500
	   	};
	   	NSopenWindow(false,'',window,null,dataOptions,'您是否确认所选择的责任区？','saveBz',null);
	}
	
	function saveBz(old,data) {
	}
	
	function addLxfs() {
		
		var tr1 = $('<tr id="lxfs1Tr'+ JrdwCount +'"><td height="10"></td></tr>');
		var tr2 = $('<tr id="lxfs2Tr'+ JrdwCount +'" height="24"></tr>');
		
		var td2 = $('<td width="20%"  class="dialogTd" align="right">联系方式：</td>');
		
		var td1 = $('<td width="30%" id="lxfsTd'+ JrdwCount +'" class="dialogTd"></td>');
		var td1HTML = new StringBuffer();
		td1HTML.append('&nbsp;<input class="easyui-combobox" name="JrdwArray['+JrdwCount+'].zzyhlbdm" id="lxfs1_'+ JrdwCount +'"  type="text"   style="width:200px;float:left;" data-options="required:true,url: contextPath + \'/common/dict/D_DW_ZZYHLB.js\',valueField:\'id\',textField:\'text\',selectOnNavigation:false,method:\'get\',tipPosition:\'right\'"/>');
		td1HTML.append('&nbsp;&nbsp;');
		
		td1.html(td1HTML.toString());
		
		tr2.append(td2);
		tr2.append(td1);

		
		$('#lxfsArray').append(tr1);
		$('#lxfsArray').append(tr2);
		
		$.parser.parse('#lxfsTd' + JrdwCount);
		JrdwCount++;
	}

	function delLxfs(dzNo) {
		setInputReadonly('lxfs' + dzNo, true);
		$("#xt_zxbz" + dzNo).val("1");
		$("#lxfs1Tr" + dzNo).hide();
		$("#lxfs2Tr" + dzNo).hide();
	}
	
	function czcChange(){
		
		var dwmc = $("#jbrdwdm").combobox('getText');
		if(dwmc){
			$("#jbrdw").val(dwmc);
		}
	}
</script>
</body>
</html>