<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看案件信息</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>

</head>
<body style="margin-top:0px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;">
    	<tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>ajxxb/updateDetail" id="jbxxForm" name="jbxxForm" method="post" >
		 		<input type='hidden' name='mainTabID' id="mainTabID" value="${mainTabID}"/> 
		 		<input type="hidden" id="id" name="id" value="${entity.id}"/>
		 		<input type="hidden" id="ajbh" name="ajbh" value="${entity.ajbh}"/>
		 		<input type="hidden" id="xsbh" name="xsbh" value="${xsbh}"/>
		 		<input type="hidden" id="showFlag" name="showFlag" value="${showFlag}"/>
	    	  <div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
				    	<td width="100" class="dialogTd" align="right">案件编号：</td>
				    	<td width="300" class="dialogTd">${entity.ajbh}</td> 
						<td width="250" class="dialogTd" align="right">案件名称：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="ajmc" name="ajmc" value="${entity.ajmc}"
		    	 			maxlength="30" style="width:300px;" data-options="required:true,validType:['maxLength[30]']"/>
		    	        </td>
	    	      </tr>
   	    	      <tr class="dialogTr">
				    	<td class="dialogTd" align="right">案件类型：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="ajlx" name="ajlx" value="${entity.ajlx}"
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td class="dialogTd" align="right">案件状态：</td>
				    	<td class="dialogTd">破案</td> 
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td  align="right" valign="top">简要信息：</td>
				    	<td class="dialogTd" colspan="3" >
				    		<textarea id="sajyxx" name="sajyxx" class="easyui-validatebox" style="width: 870px; height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'简要信息描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.sajyxx}</textarea>
						</td>
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">附件信息：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="fjlxSel" name="fjlxSel"
				    		style="width:300px;" data-options="url: contextPath + '/common/dict/D_BZ_FJLX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
				    	<td  class="dialogTd">
							<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="generalNum();">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">添加附件&nbsp;&nbsp;</span>
								</span>
							</a>	
						</td>
	    	      </tr> 
		    	  <tr>
		    	      	<td colspan="4">
		    	      		<ul id="fjli">
				    	      <c:forEach var="item" items="${fjajgxbList}" varStatus="status">
				    	      	<li style="border:none;">
		    	      				<table width="100%" cellpadding="0" cellspacing="10" style="background:#F2FAFF;border:1px solid #DEE8ED; ">
		    	      						  <tr class="dialogTr">
											    	<td width="87" align="right">附件类型：</td>
											    	<td class="dialogTd">
											    		<c:if test="${item.fjlx == '0'}">立案决定书</c:if>
											    		<c:if test="${item.fjlx == '1'}">破案告知书</c:if>
											    		<c:if test="${item.fjlx == '2'}">拘留证或取保候审决定书等类似法律文书</c:if>
											    		<c:if test="${item.fjlx == '3'}">犯罪嫌疑人第一次讯问笔录</c:if>
											    		<c:if test="${item.fjlx == '4'}">举报人询问笔录</c:if>
											    		<c:if test="${item.fjlx == '5'}">必须的其他证明文书材料</c:if>
													</td>
													<td><input name="fjlx" value="${item.fjlx}" type="hidden" /></td>
													<td><input name="fjVersion" value="${item.fjVersion}" type="hidden" /></td>
													<td><span class="close" onclick="removeli(this,'${item.id}')"></span><td>
								    	      </tr>
								    	      <tr class="dialogTr">
											    	<td  align="right">附件${status.index+1}：</td>
											    	<td class="dialogTd"><input class="easyui-validatebox fjmc" name="fjmc" style="width:300px;" value="${item.fjmc}"/></td>
													<td colspan="2"><input id="fjid" name="fjid" value="${item.id}" type="hidden" /></td>
								    	      </tr>
								    	      <tr class="dialogTr">
											    	<td align="right" valign="top">描述：</td>
											    	<td class="dialogTd" colspan="3" >
											    		<textarea id="fjms" name="fjms" class="easyui-validatebox fjdes" style="width: 815px; height:48px;">${item.fjms}</textarea>
											    	</td>
								    	      </tr>
								    	      <tr class="dialogTr">
											    	<td  align="right">文件内容：</td>
											    	<td colspan="3">
														<a class="l-btn l-btn-small" href="javascript:uploadThis('${item.id}')" group="" >
															<span class="l-btn-left l-btn-icon-left">
																<span class="l-btn-text">附件文件管理</span>
																<span class="l-btn-icon icon-attach"></span>
															</span>
														</a>
													</td>
								    	     </tr>
			    	      				</table>
				    	      		</li>
			    	      		</c:forEach>
		    	      		</ul>
		    	      	</td>
	    	       </tr>
	    		</table>
	    		
		    </div>
		  </form>
	    </div>
	    </div>
		<div style="height:6px;font-size:1px;"></div>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			<a id="saveButton"  class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>&nbsp;&nbsp;
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
$(function() {
	if(${showFlag}=='0'){
		setReadOnly();
	}
});
function doInit(paramArray) {
	setReadOnly();
}

function setReadOnly(){
	setInputReadonly('ajmc', true);
	setInputReadonly('ajlx', true);
	setInputReadonly('sajyxx', true);
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

$("#saveButton").click(function(){
	topMessager.confirm('操作确认', '您是否保存案件信息？',  function(r) {
		if (r) {
			$('#jbxxForm').form('submit',{
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
		}
	});
});

$('#backButton').click(function(){
	closeSelf();
});

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
	var li = '<li>'+
		'<table width="100%">'+
			'<tr>'+
				'<td style="width:100px" align="right">附件类型：</td>'+
				'<td>'+valR+'</td>'+
				'<td><input name="fjlx" value="'+valLx+'" type="hidden" /></td>'+
				'<td><input name="fjVersion" value="0" type="hidden" /></td>'+
				'<td><span class="close" id="xxxx" onclick="removeli(this,\''+val+'\')"></span><td>'+
			'</tr>'+
			'<tr>'+
				'<td style="width:100px" align="right">附件名称：</td>'+
				'<td><input class="easyui-validatebox fjmc" name="fjmc" style="width:300px;" /></td>'+
				'<td><input id="fjid" name="fjid" value="'+val+'" style="width:300px;" type="hidden" /></td>'+
			'</tr>'+
			'<tr>'+
				'<td style="width:100px" align="right">附件描述：</td>'+
				'<td colspan="2"><textarea id="fjms" name="fjms" class="easyui-validatebox fjdes" style="width: 805px; height:48px;"></textarea></td>'+
			'</tr>'+
			'<tr>'+
				'<td style="width:100px" align="right">附件文件：</td>'+
				'<td colspan="2">'+
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
		/*
		*考虑模块删除后，每点击保存，如果调用删除会丢失数据，所以不使用这个删除
		$.ajax({
			type:"GET",
			url:contextPath+"/ajxxb/deleteFj",
			dataType:"json",
			data:"lyid="+val,
			success:function(data){
			}
		});
		*/
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