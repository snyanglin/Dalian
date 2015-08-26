<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增非法运营车辆</title>

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
		 
		 <form action="<%=basePath%>ffyycltjb/save" id="ffyycltjbForm" name="ffyycltjbForm" method="post" >
	    	  <div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/> 
			  <input type='hidden' id="slfzdm" name="slfzdm" value="${entity.slfzdm}"/> 
		      <input type='hidden' id="slzdm" name="slzdm" value="${entity.slzdm}"/> 
			  <input type='hidden' id="slzxdm" name="slzxdm" value="${entity.slzxdm}"/> 
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
				    	<td width="250" class="dialogTd" align="right">统计类别：</td>
				    	<td width="850" class="dialogTd" colspan="3">
				    		<input class="easyui-combobox" id="tjlb" name="tjlb" value="${entity.tjlb}" 
				    		style="width:870px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_TJLB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:tjlbChange"/>
		    	        </td>
						</td> 
	    	      </tr> 
	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">司机身份证号码：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" id="sjsfzhm" name="sjsfzhm" value="${entity.sjsfzhm}" 
				    		style="width:300px;float:left" data-options="required:true,charSet:'halfUpper',validType:['sfzh']" maxlength="18"/>
				    		<div class="lodingimg" id="sjsfzhmDiv"></div>
		    	        </td>
				    	<td width="250" class="dialogTd" align="right">司机姓名：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" id="sjxm" name="sjxm" value="${entity.sjxm}" 
				    		maxlength="30" style="width:300px;" data-options="required:true,validType:['maxLength[30]']"/>
						</td> 
	    	      </tr>  
	    	      <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right">司机电话：</td>
				    	<td width="" class="dialogTd">
				    		<input class="easyui-validatebox" id="sjdh" name="sjdh" value="${entity.sjdh}" 
				    		maxlength="1000" style="width:300px;" data-options="required:true,validType:['phone'],tipPosition:'right'"/>
		    	        </td>
				    	<td width="250" class="dialogTd" align="right">车牌照号码：</td>
				    	<td width="300" class="dialogTd">
				    		<input class="easyui-validatebox" id="cpzhm" name="cpzhm" value="${entity.cpzhm}" 
				    		style="width:300px;"data-options="required:true,validType:['maxLength[20]'],tipPosition:'right'"/>
						</td> 
	    	      </tr> 
	    	      <tr class="dialogTr" id="tr1">
				    	<td width="" class="dialogTd" align="right">案件编号：</td>
				    	<td width=""  class="dialogTd">
				    	<span id="ajbhSpan">
				    			<input class="easyui-validatebox" id="ajbh" name="ajbh" value="${entity.ajbh}" 
				    			maxlength="32" style="width:300px;" data-options="required:false,validType:['maxLength[32]'],tipPosition:'right'"/>
				    			<div class="lodingimg" id="ajbhDiv"></div>
				    			</span>
		    	        </td>
	    	      </tr>  

	    	      <tr class="dialogTr" id="tr2">
				    	<td width="" class="dialogTd" align="right">处罚部门：</td>
				    	<td width="" class="dialogTd" colspan="3">
				    	<span id="cfbmSpan">
				    		<input class="easyui-combobox" id="cfbm" name="cfbm" value="${entity.cfbm}" 
				    		maxlength="32" style="width:300px;"data-options="required:false,
				    		url: contextPath + '/common/searchOrgListChildren?orgCode=<%=userOrgCode %>',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
				    		</span>
		    	        </td>
	    	      </tr> 
	    	      <tr class="dialogTr" id="tr0">

				    	<td  class="dialogTd" align="right" valign="top">车型：</td>
				    	<td  class="dialogTd" colspan="3">
				    	<span id="cxSpan">
				    		<textarea id="cx" name="cx" class="easyui-validatebox" style="width: 870px; height:100px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'车型描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.cx}</textarea>
						</span>
						</td> 
	    	      </tr> 
	    	      <tr class="dialogTr" id="tr3">
				    	<td width="" class="dialogTd" align="right" valign="top">处罚结果：</td>
				    	<td width="" class="dialogTd" colspan="3" >
				    	<span id="cfjg">
				    		<textarea id="cfjg" name="cfjg" class="easyui-validatebox" style="width:870px; height:100px;"
							data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'处罚结果不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.cfjg}</textarea>
							</span>
						</td>
	    	      </tr>
	    	       <tr class="dialogTr">
				    	<td width="" class="dialogTd" align="right" valign="top">备注：</td>
				    	<td width="" class="dialogTd" colspan="3" >
				    		<textarea id="bz" name="bz" class="easyui-validatebox" style="width:870px; height:100px;"
							data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.bz}</textarea>
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
$(function(){
	$("#sjsfzhm").bind("blur",function(e){	check();});
	$("#ajbh").bind("blur",function(e){	check2();});
	HIDE();
	$('#ffyycltjbForm').form({  
	
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
				if("01" == $('#tjlb').val()) $('#cxSpan,#cfbmSpan,#cfjgspan').html('');
				else if("02" ==  $('#tjlb').val()) $('#cfbmSpan,#cfjgSpan').html('');
				else if("03" ==  $('#tjlb').val()) $('#cxSpan,#ajbhSpan').html('');
				$('#ffyycltjbForm').submit();
			}
		});
	});
	
	$('#backButton').click(function(){
		
		closeSelf();
	});
	
	$('#resetBotton').click(function(){
		$('#ffyycltjbForm').form('reset');
		$('#tr0,#tr1,#tr2,#tr3').hide();
		
	});
	
	
	if ($('#id').val() != '') setInputReadonlys();
	
});

	function clearValue(){
	
		$("#sjxm").val('');
		$("#sjdh").val('');
		$("#cpzhm").val('');
	}

	function check(){
		clearValue();
		var sfzh = $("#sjsfzhm").val(); 
		if(!$("#sjsfzhm").validatebox("isValid")){
			return;
		}
		$("#sjsfzhmDiv").show();
		$.ajax({
			type:"POST",
			url:contextPath+"/common/tinfo",
			dataType:"json",
			data:{id:$("#sjsfzhm").val()},
			success:function(data){
				if (data) {
					$("#sjxm").val(data.JBRXM);
					$("#sjdh").val(data.JBRLXFS);
					$("#cpzhm").val(data.CZZCP);
					$("#sjxm,#sjdh,#cpzhm").validatebox("validate");
				}
			},
			complete:function(){
				_zjhm = $("#sjsfzhm").val();
				$('#dataForm').form('validate');
				$("#sjsfzhmDiv").hide();
			}
		});
	}
	
	function check2(){
		var ajbh = $("#ajbh").val(); 
		if(!$("#ajbh").validatebox("isValid")){
			return;
		}
		$("#ajbhDiv").show();
		$.ajax({
			type:"POST",
			url:contextPath+"/ffyycltjb/queryAjxxByAjbh",
			dataType:"json",
			data:{ajbh:$("#ajbh").val()},
			success:function(data){
				if (data.ajbh=='0000') {
					topMessagerAlert(null,"该案件编号所对应案件不存在");
					$('#ajbh').val('');
				}
			},
			complete:function(){
				_zjhm = $("#ajbh").val();
				$('#dataForm').form('validate');
				$("#ajbhDiv").hide();
			}
		});
	}
	
function setInputReadonlys() {
	setInputReadonly('sjsfzhm', true);
	setInputReadonly('tjlb', true);
	setInputReadonly('sjxm', true);
	setInputReadonly('sjdh', true);
	setInputReadonly('cpzhm', true);
	setInputReadonly('ajbh', true);
	setInputReadonly('cx', true);
	setInputReadonly('cfbm', true);
	setInputReadonly('cfjg', true);
	setInputReadonly('bz', true);
	$('#resetBotton').hide();
	$('#saveButton').hide();
}

	function tjlbChange(newValue,oldValue){
		tjlbOptionChange(newValue)
	}
	
	function tjlbOptionChange(optionValue){
		if("01" == optionValue)	{
			$('#tr1').show();
			$('#tr0,#tr2,#tr3').hide();
		}
		else if("02" == optionValue)	{
			$('#tr0,#tr1').show();
			$('#tr2,#tr3').hide();
		}
		else if("03" == optionValue)	{
			$('#tr1,#tr0').hide();
			$('#tr2,#tr3').show();
		}
	}
tjlbOptionChange($('#tjlb').val());
function HIDE(){
	
	$('#tr0,#tr1,#tr2,#tr3').hide();
}
</script>
</body>
</html>