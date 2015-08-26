<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建并关联案件</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>

</head>
<body  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;">
    	<tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>ajxxb/saveAjxx" id="ajxxForm" name="ajxxForm" method="post" >
	    	  <div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
	    	  <input type='hidden' name='mainTabID' id="mainTabID" value="${mainTabID}"/> 
	    	  <input type='hidden' name='xsId' id="xsId" value="${xsId}"/> 
	    	  <input type='hidden' name='id' id="id" value="${newCaseId}"/> 
	    	  <table id="tableAll" border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
				    	<td width="100" class="dialogTd" align="right">案件编号：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" id="ajbh" name="ajbh" value="${ajbh}" 
				    		style="width:300px;"  data-options="required:true,validType:['maxLength[26]']"/>
						</td> 
						<td width="250" class="dialogTd" align="right">案件名称：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="ajmc" name="ajmc"
		    	 			maxlength="30" style="width:300px;" data-options="required:true,validType:['maxLength[30]']"/>
		    	        </td>
	    	      </tr> 
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">案件类型：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="ajlx" name="ajlx"
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td width="" class="dialogTd" align="right">受理时间：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="slsj" name="slsj"
		    	 			maxlength="10" style="width:300px;" data-options="required:true,validType:['date[\'yyyy-MM-dd HH:mm:ss\']'],tipPosition:'right'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s'})" />
		    	        </td>
						<!-- 
						<td id="tdAjztFir" width="20%" class="dialogTd" align="right">案件状态：</td>
						<td id="tdAjztSec" width="30%" class="dialogTd">
				    		<span  id="rdo0"><input type="radio" name="ajzt" value="0" id="radio0"/>受案</span>
							<span  id="rdo1"><input type="radio" name="ajzt" value="1" id="radio1"/>立案</span>
							<span  id="rdo2"><input type="radio" name="ajzt" value="2" id="radio2"/>破案</span>
							<span  id="rdo3"><input type="radio" name="ajzt" value="3" id="radio3"/>行政处罚</span>
						</td> 
						 -->
			      </tr> 
	   		      <tr class="dialogTr">
						<td  class="dialogTd" align="right" valign="top">简要信息：</td>
				    	<td class="dialogTd" colspan="3" >
				    		<textarea id="jyxx" name="jyxx" class="easyui-validatebox" style="width: 870px; height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'简要信息描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.jyxx}</textarea>
						</td>
	    	      </tr>
	    	       <tr class="dialogTr">
						<td  class="dialogTd" align="right">附件：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="fjlxSel" name="fjlxSel"
				    		style="width:300px;" data-options="url: contextPath + '/common/dict/D_BZ_FJLX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
				    	<td  class="dialogTd" colspan="3">
							<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="generalNum();">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">添加附件&nbsp;&nbsp;</span>
								</span>
							</a>	
						</td>
	    	      </tr>
	    	      <tr>
	    	      	<td colspan="4"><ul id="fjli"></ul></td>
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
		</div>
	</td>
</tr>
</table>
</div>
<script type="text/javascript">
$(function(){
	$('#saveButton').click(function(){
		checkAjNumber();
	});
	
	$('#backButton').click(function(){
		closeSelf();
	});
	
});

/*
function showAjzt(newValue, oldValue){
	if( newValue == undefined || newValue == '2') {
		$("#tdAjztFir").hide();
		$("#tdAjztSec").hide();
		if(newValue == '2'){
			$("#radio2").attr("checked",true);
		}
	}else if( newValue == '0') {
		$("#tdAjztFir").show();
		$("#tdAjztSec").show();
		$("#rdo0").show();
		$("#rdo1").show();
		$("#rdo2").show();
		$("#rdo3").hide();
	}else if( newValue == '1') {
		$("#tdAjztFir").show();
		$("#tdAjztSec").show();
		$("#rdo0").show();
		$("#rdo1").hide();
		$("#rdo2").hide();
		$("#rdo3").show();
	}
}
*/


//uploadFileEdit(lybm, lyid, '0')

function checkAjNumber(){
	var ajbh = $("#ajbh").val();
	$.ajax({
		type:"GET",
		sync:true,
		// 根据线索编号查询已关联案件数据
		// 参考：url:contextPath+"/bzdz/ifExistCh",
		url:contextPath+"/ajxxb/ifExistAjNum",
		// 传入线索编号
		data:{ajbh:ajbh},
		dataType:'json',
		success:function(data){
			if(data.sta == "0"){
				//var ajztVal = $("input[name='ajzt']:checked").val();
				//if(ajztVal == undefined || ajztVal == null || ajztVal == '' ) {
				//	topMessager.alert('', '案件状态不能为空！');
				//	return;
				//} else {
					topMessager.confirm('操作确认', '您是否保存案件信息？',  function(r) {
						if (r) {
							$('#ajxxForm').form('submit',{
								success:function(data){
									var json = $.parseJSON(data);
									if(json.status=='success'){
										executeTabPageMethod(json.tabId,'reloadDg')
										topMessagerAlert(null, "保存成功","success");
										closeSelf();
									}
									else topMessagerAlert(null, "保存失败");
								}
							});
							//ajaxSave();
							//$('#ajxxForm').submit();
						}
					});
				//}
			}else {
				topMessager.alert('', '案件编号重复，请输入其它案件编号！');
				return;
				
			}
		}
	});
}

/**
 * 生成附件编号
 */
function generalNum(){
	if($("#fjlxSel").val() == "" || $("#fjlxSel").val() == null) {
		alert("请选择附件类型");
	} else {
		$.ajax({
			type:"GET",
			sync:true,
			url:contextPath+"/fjajgxb/generalNum",
			dataType:'json',
			success:function(data){
				addFJ(data.fujianFLid);
			}
		});
	}
	
}
/**
 * 动态添加附件
 */
function addFJ(val) {
	var valLx=$("#fjlxSel").val();
	var valR = "";
	if(valLx == '0') {
		valR = "立案决定书";
	} else if(valLx == '1') {
		valR = "破案告知书";
	} else if(valLx == '2') {
		valR = "拘留证或取保候审决定书等类似法律文书";
	} else if(valLx == '3') {
		valR = "犯罪嫌疑人第一次讯问笔录";
	} else if(valLx == '4') {
		valR = "举报人询问笔录";
	} else if(valLx == '5') {
		valR = "必须的其他证明文书材料";
	}
	var li = '<li style="border:none;">'+
		'<table width="100%" cellpadding="0" cellspacing="10" style="background:#F2FAFF;border:1px solid #DEE8ED; ">'+
			'<tr>'+
				'<td width="90" align="right">附件类型：</td>'+
				'<td class="dialogTd">'+valR+'</td>'+
				'<td><input name="fjlx" value="'+valLx+'" type="hidden" /></td>'+
				'<td><span class="close" onclick="removeli(this,\''+val+'\')"></span><td>'+
			'</tr>'+
			'<tr>'+
				'<td  align="right">附件名称：</td>'+
				'<td class="dialogTd"><input class="easyui-validatebox fjmc" name="fjmc" style="width:300px;" /></td>'+
				'<td><input name="fjid" value="'+val+'" type="hidden" /></td>'+
			'</tr>'+
			'<tr>'+
				'<td align="right" valign="top">附件描述：</td>'+
				'<td colspan="3" ><textarea id="fjms" name="fjms" class="easyui-validatebox fjdes" style="width:815px; height:48px;"></textarea></td>'+
			'</tr>'+
			'<tr>'+
				'<td  align="right">附件文件：</td>'+
				'<td colspan="3">'+
					'<a class="l-btn l-btn-small" href="javascript:uploadThis(\''+val+'\')" group="" >'+
						'<span class="l-btn-left l-btn-icon-left">'+
							'<span class="l-btn-text">附件文件管理</span>'+
							'<span class="l-btn-icon icon-attach"></span>'+
						'</span>'+
					'</a>'+
				'</td>'+
			'</tr>'+
		'</table>'+
	'</li>';
	
	$('#fjli').append(li);
	$('.fjmc').validatebox({
		required: true,
		validType:['maxLength[30]']
	})
	$('.fjdes').validatebox({
		validType:['maxLength[1000]'],
		invalidMessage:'简要信息描述不能超过1000个汉字，请重新输入！',
		tipPosition:'left'
	})
}
function removeli(obj,val){
	var $this = $(obj);
	if(confirm('是否删除')){
		$this.parents('li').remove();
		$.ajax({
			type:"GET",
			url:contextPath+"/ajxxb/deleteFj",
			dataType:"json",
			data:"lyid="+val,
			success:function(data){
			}
		});
	}
}
/**
 * 调用添加附件的upload方法
 */
function uploadThis(val){
	uploadFileEdit('YJJB_FJAJGXB', val, '0')
}

</script>
</body>
</html>