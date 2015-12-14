<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>线索征集详细信息</title>
<style type="text/css">
.colli{
	margin:0;
	padding:0;
	margin-left:10px;
}
.colli li{
	list-style:none;
	margin:0;
	pause:0;
	text-align:left;
	background-repeat:no-repeat;
	background-position:top left;
	background-image:url("<%=contextPath%>/images/edit/timelineicon.png");
	padding-left:20px;
	margin-bottom:20px;
	
}
</style>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">
 <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
 	<table height="100%" style="margin:0 auto;">
 	
 		<tr><td height="100%" valign="top" align="center">
 		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
		 	<form  id="xszjForm" name="xszjForm" method="post" >
	    	  <div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
	    	  
	    	   <br><br><br>
	    	    <input type="hidden" id="id" name="id" value="${entity.id}"/>
	    	   <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
	    	     	 <td width="20%" class="dialogTd" align="right">申请人：</td>
	    	         <td width="30%" class="dialogTd">
				   <select  class="easyui-combobox"   id="sqr" name="sqr" 
				    		 style="width:300px;" data-options="required:true, selectOnNavigation:false,method:'get'" readonly >
				    		 <option value="${entity.sqr}" selected>${entity.xt_lrrxm}</option>
				    		 </select>
					</td> 
					<td width="20%" class="dialogTd" align="right">申请时间：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="sqsj" name="sqsj" value="${entity.sqsj}"
		    	 			style="width:300px;" data-options="required:true,validType:['date[\'yyyy-MM-dd HH:mm:ss\']'],tipPosition:'right'" 
		    	 			onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"  />
		    	        </td>
	    	      </tr>
	    	       <tr class="dialogTr">
	    	       <td width="20%" class="dialogTd" align="right">案件性质：</td>
	    	       <td width="30%" class="dialogTd">
				    		<input class="easyui-combobox" id="ajxz" name="ajxz" value="${entity.ajxz}" 
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
	    	       <td width="20%" class="dialogTd" align="right">联系方式：</td>
	    	         <td width="30%" class="dialogTd">
				   <input class="easyui-validatebox" type="text" id="sqrlxfs" name="sqrlxfs" value="${entity.sqrlxfs}"
		    	 			maxlength="1000" style="width:300px;" data-options="required:true,validType:['maxLength[1000]'],tipPosition:'right'"/>
					</td> 
	    	       </tr>
	    	         <tr class="dialogTr">
	    	       <td width="20%" class="dialogTd" align="right">申请单位：</td>
	    	       <td width="80%" class="dialogTd" colspan="3">
				    		<input  class="easyui-combobox"   id="sqdw" name="sqdw"  value="${entity.sqdw}"
				    		maxlength="100" style="width:820px;" data-options="required:true,
				    		url: contextPath + '/common/queryOrg',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" readonly/>
						</td> 
	    	       </tr> 
	    	         </tr>
	    	         <tr class="dialogTr">
	    	       <td width="20%" class="dialogTd" align="right">简要案情：</td>
	    	       <td width="80%" class="dialogTd" colspan="3">
				    		<textarea  class="easyui-validatebox"  id="jyaq" name="jyaq" 
				    		maxlength="1000" style="width:820px;height:48px" data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'简要案情不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.jyaq}</textarea>
						</td> 
	    	       </tr> 
	    	         <tr class="dialogTr">
	    	       <td width="20%" class="dialogTd" align="right">征集线索信息：</td>
	    	       <td width="80%" class="dialogTd" colspan="3">
				    		<textarea  class="easyui-validatebox"  id="zjdxsxx" name="zjdxsxx" 
				    		maxlength="1000" style="width:820px;height:48px" data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'征集线索信息不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.zjdxsxx}</textarea>
						</td> 
	    	       </tr> 
	    	         <tr class="dialogTr">
	    	       <td width="20%" class="dialogTd" align="right">备注：</td>
	    	       <td width="80%" class="dialogTd" colspan="3">
				    		<textarea  class="easyui-validatebox"  id="bz" name="bz" 
				    		maxlength="1000" style="width:820px;height:48px" data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.bz}</textarea>
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
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">关闭</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
		</div>
 		</td>
 		
 		</tr>
 	</table>
 	</div>
<script type="text/javascript">

$(function(){
	setInputReadonly('sqr', true);
	setInputReadonly('sqsj', true);
	$('#sqsj').removeAttr("onclick");
	setInputReadonly('ajxz', true);
	setInputReadonly('sqrlxfs', true);
	setInputReadonly('sqdw', true);
	setInputReadonly('jyaq', true);
	setInputReadonly('zjdxsxx', true);
	setInputReadonly('bz', true);
	
	$('#backButton').click(function(){
		
		closeSelf();
	});
	
});
</script>
</body>
</html>