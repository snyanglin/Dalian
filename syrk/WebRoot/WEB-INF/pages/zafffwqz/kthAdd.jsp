<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userName="";
    String userId="";
    String userBm="";
    String userBmId="";
    String pcs="";
    String pcsName="";
    if(userInfo!=null){
    	userBmId = userInfo.getUserOrgCode();
    	userBm= userInfo.getUserOrgName();
    	userName = userInfo.getUserName();
    	userId = userInfo.getUserId();
    	 pcs = (String)userInfo.getExtendMap().get("ssPcsCode");
    	 pcsName = (String)userInfo.getExtendMap().get("ssPcsName");
    }
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>恳谈会信息</title>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
var userName ='<%=userName%>';
var userId ='<%=userId%>';
var userBm ='<%=userBm%>';
var userBmId ='<%=userBmId%>';
var pcs ='<%=pcs%>';
var pcsName ='<%=pcsName%>';
</script>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>fwqz/saveKthb" id="jbxxForm" name="jbxxForm" method="post">
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    	  
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/> 
	    	  <input type='hidden' name='zzrid' id="zzrid" value="<%=userId%>"/> 
	    	  <input type='hidden' name='zzrdwid' id="zzrdwid" value="<%=userBmId%>"/>  
	    	  
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	  
	    	  <tr class="dialogTr">
				<td width="30%" class="dialogTd" align="right">召开时间：</td>
				<td width="10%" class="dialogTd"><input type="text" name="zksj" id="zksj" class="easyui-validatebox " style="width: 200px;" value="${entity.zksj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
					onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" /></td>
			    
			    <td width="20%" class="dialogTd" align="right">组织人：</td>
				<td width="30%" class="dialogTd" >
				    <input class="easyui-validatebox" type="text" id="zzr" name="zzr"
		    	 			value="${entity.zzr}" maxlength="20" style="width:200px;" data-options="required:true,validType:['maxLength[20]'],tipPosition:'left'"/>
	    	 </tr>
	    	  	<tr class="dialogTr">
	    	  		<td width="20%" class="dialogTd" align="right">组织人单位：</td>
	    	  		<td width="80%" class="dialogTd" align="left" colspan="3">
						<input class="easyui-validatebox" type="text" id="zzrdw" name="zzrdw"
		    	 			value="${entity.zzrdw}" maxlength="50" style="width:400px;" data-options="required:true,validType:['maxLength[50]'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
	    	  		<td width="20%" class="dialogTd" align="right">与会人：</td>
	    	  		<td width="80%" class="dialogTd" align="left" colspan="3">
						<input class="easyui-validatebox" type="text" id="yhr" name="yhr"
		    	 			value="${entity.yhr}" maxlength="50" style="width:400px;" data-options="required:true,validType:['maxLength[50]'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
	    	  		<td width="20%" class="dialogTd" align="right">会议内容：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="hynr" name="hynr" class="easyui-validatebox" rows="3" style="width:100%; height:82px;"
								data-options="required:false,validType:['maxLength[500]'],invalidMessage:'备注不能超过500个汉字，请重新输入！',tipPosition:'left'">${entity.hynr}</textarea>
						</td>
				</tr>				
				
				 <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">备注：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="entity_bz" name="bz" class="easyui-validatebox" rows="3" style="width:100%; height:82px;"
								data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
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
$(function(){
	
	$('#jbxxForm').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            	topMessagerAlert(null,json.message);
            }else{
            	topMessagerShow(null,json.message);
            	$("#id").val(json.saveID); 
            	
            	executeTabPageMethod(mainTabID, "reloadDg");
            	closeSelf();
            }
        }  
    });   
	
	$('#saveButton').click(function(){
		topMessager.confirm('操作确认', '您是否保存恳谈会信息？',  function(r) {
			if (r) {
				$('#jbxxForm').submit();
			}
		});
	});
	
	$('#backButton').click(function(){
		closeSelf();
	});
	$('#resetBotton').click(function(){
				$("#entity_bz").val("");
				$("#hynr").val("");
				$("#zksj").val("");
				$("#yhr").val("");
			
		});
});

function setValue(){
	
	$("#zzr").val(userName);
	$("#zzrdw").val(pcsName);
	
	$("#zzrid").val(userId);
	$("#zzrdwid").val(userBmId);
	
	setInputReadonly("zzr", true);
	setInputReadonly("zzrdw", true);
}

setValue();
</script>

</body>
</html>