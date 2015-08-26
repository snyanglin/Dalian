<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>自动执行任务</title>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;">
    	<tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>zdzxrwb/saveZdzxrwb" id="jbxxForm" name="jbxxForm" method="post" >
	    	  <div data-options="region:'center', split:true" style="width:1200px; border-width: 0px;">
	    	  
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/> 
	    	  
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">任务名称：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" id="rwmc" name="rwmc" value="${entity.rwmc}" 
				    		style="width:400px;" data-options="required:true,validType:['maxLength[100]'],
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
						</td> 
						<td width="20%" class="dialogTd" align="right">执行方法：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="rwzxff" name="rwzxff" value="${entity.rwzxff}"
		    	 			maxlength="20" style="width:400px;" data-options="required:true,validType:['maxLength[500]'],tipPosition:'right'"/>
		    	        </td>
	    	      </tr> 
   	    	      <tr class="dialogTr">
	    	      		
				    	<td width="20%" class="dialogTd" align="right">任务说明：</td>
				    	<td width="30%" class="dialogTd">
				    	<input type="text" name="rwsm" id ="rwsm" value="${entity.rwsm}" 
				    	class="easyui-validatebox" data-options="required:false,validType:['maxLength[1000]'],tipPosition:'left'" style="width:400px;" />
		    	        </td>		
		    	        <td width="20%" class="dialogTd" align="right">任务状态：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" type="text" id="rwzt" name="rwzt"
		    	 			value="${entity.rwzt}" maxlength="50" style="width:400px;" 
		    	 			data-options="validType:['maxLength[1]'],url: contextPath + '/common/dict/D_ZDRW_RWZT.js',
		    	 			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
						</td>    	        
		    	       
	    	      </tr>
	    	       
	    	       <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">开始时间：</td>
				    <td width="30%" class="dialogTd">
		    	        <input class="easyui-validatebox" type="text" id="rwkssj" name="rwkssj" value="${entity.rwkssj}"
		    	        	style="width: 400px;" data-options="required:true,validType:['date[\'yyyy-MM-dd HH:mm:ss\']'],tipPosition:'left'"
		    	        	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
		    	        </td>
			    	<td width="20%" class="dialogTd" align="right">结束时间：</td>
			    	<td width="30%" class="dialogTd"> 
				    	<input class="easyui-validatebox" type="text" id="rwjssj" name="rwjssj" value="${entity.rwjssj}"
		    	        	style="width: 400px;" data-options="required:true,validType:['date[\'yyyy-MM-dd  HH:mm:ss\']'],tipPosition:'left'"
		    	        	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
			    	</td>
	    	      </tr>
	    	      <!-- ************************************************************************* -->
	    	      <tr class="dialogTr">
	    	     	<!-- TODO -->
	    	     	 <td width="20%" class="dialogTd" align="right">间隔类型：</td>
		    	 		<td width="30%" class="dialogTd" >
		    	 		 
		    	 			<input class="easyui-combobox" type="text" id="jglx" name="jglx" value="${entity.jglx}"
		    	        	style="width: 400px;" data-options="required:true,validType:['maxLength[1]'],
		    	        	url: contextPath + '/common/dict/D_ZDRW_JGLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
		    	        	tipPosition:'left',onChange:jglxChange"/>
		    	 		</td>
		    	 		<td width="20%" class="dialogTd" align="right">是否校验通过：</td>
		    	 		<td width="30%" class="dialogTd" >
		    	 			<input class="easyui-combobox" type="text" id="sfjytg" name="sfjytg" value="${entity.sfjytg}"
		    	        	style="width: 400px;display:none;" data-options="validType:['maxLength[1]'],
		    	        	url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
		    	        	tipPosition:'left'"/>
		    	 		</td>
	    	      </tr>	  
	    	      
	    	      <!-- 每隔 -->
	    	      <tr class="dialogTr" id="zx00">
	    	 		<td width="20%" class="dialogTd"  align="right">执行间隔：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-validatebox" type="text" id="zxjg" name="zxjg" value="${entity.zxjg}"
	    	 			 maxlength="50" style="width:400px;" 
	    	 			 data-options="validType:['naturalNumber','maxLength[10]'],invalidMessage:'执行间隔为10位以内的自然数，请重新输入！',tipPosition:'left'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">间隔单位：</td>
	    	 		<td width="30%" class="dialogTd" >
	    	 			<input class="easyui-combobox" type="text" id="jgdw" name="jgdw" value="${entity.jgdw}"
	    	        	style="width: 400px;" data-options="validType:['maxLength[19]'],tipPosition:'left',
	    	        	url: contextPath + '/common/dict/D_ZDRW_JGDW.js',valueField:'id',textField:'text',method:'get'"/>
	    	 		</td>
	    	      </tr>	 
	    	      <tr class="dialogTr" id="zx01">
	    	      	<td width="20%" class="dialogTd" align="right">首次执行时间：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-validatebox" type="text" id="sczxsj" name="sczxsj"
		    	 			value="${entity.sczxsj}" maxlength="50" style="width:400px;" data-options="required:false,validType:['maxLength[19]'],tipPosition:'left'"
		    	 			onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d'})"/>
						</td>
	    	      </tr>
	    	      
	    	      <!-- 每年-->   
	    	      <tr class="dialogTr" id="zx1">
	    	      	<td width="20%" class="dialogTd" align="right">执行月日：</td>
		    	 		<td width="30%" class="dialogTd" >
		    	 			<input class="easyui-validatebox" type="text" id="zxyr" name="zxyr" value="${entity.zxyr}"
		    	        	style="width: 400px;" data-options="validType:['date[\'MM-dd\']'],tipPosition:'left'"
		    	        	onclick="WdatePicker({skin:'whyGreen',dateFmt:'MM-dd'})"/>
		    	 		</td>
	    	      </tr>
	    	      <!-- 每季--> 
	    	      <tr class="dialogTr" id="zx2">
	    	      	 <td width="20%" class="dialogTd" align="right">执行季度月：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" type="text" id="zxjdy" name="zxjdy" value="${entity.zxjdy}"
		    	 			 maxlength="50" style="width:400px;" data-options="validType:['maxLength[1]'],tipPosition:'left',
		    	 			 url: contextPath + '/common/dict/D_ZDRW_JDU.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td>
	    	      </tr>
	    	      <!-- 每月 -->
	    	      <tr class="dialogTr" id="zx3">
				    	
		    	 		<td width="20%" class="dialogTd" align="right">执行日期：</td>
		    	 		<td width="30%" class="dialogTd" >
		    	 			<input class="easyui-validatebox" type="text" id="zxr" name="zxr" value="${entity.zxr}"
		    	        	style="width: 400px;" data-options="validType:['date[\'dd\']'],tipPosition:'left'"
		    	        	onclick="WdatePicker({skin:'whyGreen',dateFmt:'dd'})"/>
		    	 		</td>
	    	      </tr>
	    	      <!-- 每周 -->
	    	      <tr class="dialogTr" id="zx4">
		    	 		 <td width="20%" class="dialogTd" align="right">执行周：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" type="text" id="zxz" name="zxz" value="${entity.zxz}"
		    	 			 maxlength="50" style="width:400px;" data-options="validType:['maxLength[1]'],tipPosition:'left',
		    	 			 url: contextPath + '/common/dict/D_ZDRW_XQ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td>
	    	      </tr>

	    	      <tr class="dialogTr" id="zx5">
	    	      		<td width="20%" class="dialogTd" align="right">执行时间：</td>
		    	 		<td width="30%" class="dialogTd" >
		    	 			<input class="easyui-validatebox" type="text" id="zxsj" name="zxsj" value="${entity.zxsj}"
		    	        	style="width: 400px;" data-options="validType:['date[\'HH:mm:ss\']'],tipPosition:'left'"
		    	        	onclick="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm:ss'})"/>
		    	 		</td>
	    	      </tr>
  				  <tr>
  					<td width="20%" class="dialogTd" align="right">线程：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" type="text" id="thread" name="thread"
		    	 			value="${entity.thread}" maxlength="50" style="width:400px;" data-options="validType:['maxLength[1]'],
		    	 			url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
		    	 			tipPosition:'left'"/>
						</td>	    	      
		    	 		<td width="20%" class="dialogTd" align="right">备注：</td>
		    			<td width="80%" class="dialogTd" colspan="3" ><textarea id="bz" name="bz" class="easyui-validatebox" style="width: 400px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
		    	 		</td>
		    	 		</tr>
	    	      <!-- ************************************************************************* -->
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
					<span class="l-btn-text">取消</span>
					<span class="l-btn-icon icon-back"> </span>
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

function allHide(){
		//**************
		
		$("#zx00").hide();//0
		$("#zx01").hide();//0
		$("#zx1").hide();//1
		$("#zx2").hide();//2
		$("#zx3").hide();//3
		$("#zx4").hide();//4
		$("#zx5").hide();//5
}

// 选择不同的执行类型
function jglxChange(newValue, oldValue){

	if(newValue == 0){
		
		allHide();
		$("#zx00").show();
		$("#zx01").show();
	} else if(newValue == 1){
	
		allHide();
		$('#zx1').show();
		$('#zx5').show();
	} else if (newValue == 2){
	
		allHide();
		$('#zx2').show();
		$('#zx3').show();
		$('#zx5').show();
	} else if (newValue == 3){
	
		allHide();	
		$('#zx3').show();
		$('#zx5').show();
	} else if (newValue == 4){
	
		allHide();	
		$('#zx4').show();
		$('#zx5').show();
	} else if (newValue == 5){
	
		allHide();	
		$('#zx5').show();
	}
}

$(function(){
	
	allHide();
	
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
		
		document.forms["jbxxForm"].reset();
	});
});

</script>
</body>
</html>