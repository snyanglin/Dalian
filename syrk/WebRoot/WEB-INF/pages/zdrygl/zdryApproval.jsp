<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员审批</title>
</head>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryApproval/${approvalMethod}" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="taskId" name="taskId""  value="${workflowId}" />
    	<input type="hidden" id="workflowId" name="workflowId""  value="${workflowId}" />
    	<input type="hidden" id="executionId" name="executionId""  value="${executionId}" />
    	<input type="hidden" id="ryid" name="zdryZdryzb.ryid" value="" />
 
    	
    
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center"></tr>
			${renderedTaskForm}

			<c:choose>
			   <c:when test="${splx=='1'}"> 
				<!-- 提交到岗位 -->
				<input type="hidden" name="nextsplx" id="nextsplx1" value="1" />     
			   </c:when>
			   <c:otherwise>
				<!-- 提交到人员 -->
				<input type="hidden" name="nextsplx" id="nextsplx0" value="0"   />
			   </c:otherwise>
			</c:choose>
			<c:if test="${splx!=null}">
				<tr class="dialogTr"  id="PoDiv">
					<td width="20%" class="dialogTd" align="right">审批岗位：</td>
					<td>
						<input type="hidden"   id="nextSpposId" name="nextSpposId" value="${position.id}" style="width: 100;" />
						<input type="hidden" id="nextSppos" name="nextSppos" value="${position.posid}" style="width: 100;" />
						<input type="text" id="posname12" name="posname12" style="width: 200;" value="${position.posname}" />
						<input type="hidden" id="nextSpOrgCode" name="nextSpOrgCode" value="${org.orgcode}" style="width: 100;" />
						<input type="button" id=orgbutton12" value="选择" onClick="SelectOrgPos()" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    			</td>
				</tr>
			
				<c:if test="${splx=='2'}">
				    <tr class="dialogTr"  id="UsDiv">
					<td width="20%" class="dialogTd" align="right">审批人员：</td> 
					
					<td>
					    <input type="text" id="username12" name="username12" style="width: 200;" value="" />
						<input type="hidden" id="nextSpUserId" name="nextSpUserId" value="" style="width: 100;" />
					    <input type="button" id=orgbutton12" value="选择"  onClick="SelectOrgUser()"  style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
					</td>
				    </tr>
				</c:if>
			</c:if>
	    </table>
	    	
	    	  <div style="margin: 0 auto;"></div>   
	    	
	    	
	    	<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
	    	
				<a id="saveBotton" class="l-btn l-btn-small"
					href="javascript:void(0)" group=""> <span
					class="l-btn-left l-btn-icon-left"> <span class="l-btn-text">保存</span>
						<span class="l-btn-icon icon-save"> </span> </span> </a>
			  
			  <a id="close" class="l-btn l-btn-small"
					href="javascript:void(0)" group=""> <span
					class="l-btn-left l-btn-icon-left"> <span class="l-btn-text">关闭</span>
						<span class="l-btn-icon icon-save"> </span> </span> </a>
			</div>
	  	
	    	
    </form>
</div>

<script type="text/javascript" >

	var agreeOrgCode;
	var disagreeOrgCode;
	var agreeOrglevel;
	var disagreeOrglevel;
	var orgCode;
	var orglevel;
	
	$(document).ready(function(){
	
	/* if($("#zdrylxmc").val()=="社区矫正人员"||$("#zdrylxmc").val()=="非正常上访重点人员"
					||$("#zdrylxmc").val()=="其他关注对象" || $("#sqlx").val()=="请假审批")
	{
	$("#nextsplxDiv").hide(); */
	/* $("#PoDiv").hide();
	$("#UsDiv").hide(); */
	/* }
	else{ */
			$("#nextsplxDiv").hide();
			/* $("#PoDiv").hide();
			$("#UsDiv").hide();  */
			
		//	alert($("#agree").val());
	
		if(($("#agree").val()!="NoChoice")&&($("#disagree").val()!="NoChoice")){
			getAgreeOrgCode();
			getDisagreeOrgCode();
	
			$("#nextsplxDiv").show();
			/* $("#PoDiv").show(); */
			/* $("#nextsplx0").bind("click", function(event) { $("#UsDiv").show();	});
			$("#nextsplx1").bind("click", function(event) { $("#UsDiv").hide(); }); */
			$("#spjg0").bind("click", function(event) { $("#UsDiv").hide(); $("#PoDiv").show(); orgCode=disagreeOrgCode;orglevel=disagreeOrglevel;});
			$("#spjg1").bind("click", function(event) { $("#UsDiv").hide(); $("#PoDiv").show(); orgCode=agreeOrgCode;orglevel=agreeOrglevel;	}); 
	
	
		}
		if(($("#agree").val()!="NoChoice")&&($("#disagree").val()=="NoChoice")){
			getAgreeOrgCode();
			orgCode=agreeOrgCode;  
			orglevel=agreeOrglevel;
			$("#nextsplxDiv").show();
			/* $("#PoDiv").show(); */
			/* $("#nextsplx0").bind("click", function(event) {$("#UsDiv").show();  });
			$("#nextsplx1").bind("click", function(event) { $("#UsDiv").hide(); }); */
			$("#spjg0").bind("click", function(event) { $("#UsDiv").hide(); $("#PoDiv").hide(); $("#nextsplxDiv").hide();});
			$("#spjg1").bind("click", function(event) { $("#UsDiv").hide(); $("#PoDiv").show(); $("#nextsplxDiv").show(); }); 
		}
		if(($("#agree").val()=="NoChoice")&&($("#disagree").val()!="NoChoice")){

			getDisagreeOrgCode();
			orgCode=disagreeOrgCode;
			orglevel=disagreeOrglevel;
			/* $("#nextsplx0").bind("click", function(event) { $("#PoDiv").hide(); $("#UsDiv").show();  });
			$("#nextsplx1").bind("click", function(event) { $("#UsDiv").hide(); $("#PoDiv").show(); });  */
			$("#spjg0").bind("click", function(event) { $("#UsDiv").hide(); $("#PoDiv").show(); $("#nextsplxDiv").show();});
			$("#spjg1").bind("click", function(event) { $("#UsDiv").hide(); $("#PoDiv").hide(); $("#nextsplxDiv").hide(); }); 
	
			}

		
		loadclearSelect();
		$("#spjg1").bind("click", function(event) { 
			if($("#nextsplx1")=="1"){
				/*提交到岗位*/
				$("#UsDiv").hide(); $("#PoDiv").show();
			}else{
				$("#UsDiv").show(); $("#PoDiv").show();
			}
		});
		$("#spjg0").bind("click", function(event) { 
			if($("#nextsplx0")=="0"){/*提交到个人*/
				$("#UsDiv").hide(); $("#PoDiv").hide(); 
			}else{
				$("#UsDiv").hide(); $("#PoDiv").hide(); 
			}
			
		}); 
		$("#saveBotton").bind("click",function() {
			var formObject =$("#dataForm");
			if(!formObject.form('validate')){
				return false;
			}
			formObject.form('submit',{
				dataType : 'json',
				onSubmit: function() {
				},
				success: function(result) {
				//	alert("212");
					doSubmitResult(result, null, null);
					window.parent.refresh();
					window.parent.$('#windowWithoutSave').dialog('close');
					
				}
			});	
		});
		$("#close").bind("click",function() {
					window.parent.$('#windowWithoutSave').dialog('close');
		
			});
		});



	function getAgreeOrgCode() {
		var su = true;
		var agree = $("#agree").val();
		if(agree==null) return;
		$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>zdryApproval/getApprovalOrgCode",
		dataType:"json",
		data:"condition="+$("#agree").val(),
		success:function(data){
			if (data) {
				agreeOrgCode=data.orgOrganization.orgcode;
				agreeOrglevel=data.orgOrganization.orglevel;
					}
				}
			});
		}
	function getDisagreeOrgCode() {
		var su = true;
		var agree = $("#disagree").val();
		if(agree==null) return;
		$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>zdryApproval/getApprovalOrgCode",
		dataType:"json",
		data:"condition="+$("#disagree").val(), 
		success:function(data){
				if (data) {
				disagreeOrgCode=data.orgOrganization.orgcode;
				disagreelevel=data.orgOrganization.orglevel;
				}
			}
		});
	}
	
	function openZdrk(){
	
		var editUrl = "/zdrygl/"+ryid+"/"+syrkid+"/view?mode=view";
		menu_open(xm,editUrl);
		window.parent.$('#windowWithoutSave').dialog('close');
	}
	
	function clearSelect(){
	
		 $("#nextSpposId").val("");
		 $("#posidE").val("");
		 $("#posname12").val("");
		 $("#nextSpOrgCode").val("");
		 $("#nextSpUserId").val("");
		 $("#username12").val("");    
		
	}
	function loadclearSelect(){
		$("#nextsplx0").bind("click", function(event) { clearSelect(); });
		$("#nextsplx1").bind("click", function(event) { clearSelect(); });
		$("#spjg0").bind("click", function(event) { clearSelect();});
		$("#spjg1").bind("click", function(event) { clearSelect();});
	}
	
	
	
	function SelectOrgUser(){
		alert("..SelectOrgUser..");
		var posid=$("#nextSppos").val();
		//alert(posid);
		if(posid==""){
			alert("请选择岗位");
			return false;
		}
	 			public_singleSelectOrgUser(orgCode, '01', orglevel, '', posid, '', 'nextSpUserId', 'username12', '', '', '', '', false, '', window, 'onOrgUserSelected', '')
	 			
	}
	
	function SelectOrgPos(){
		alert("..SelectOrgPos..");
		public_singleSelectOrgPos(orgCode, '01', orglevel, '', '','', 'nextSpposId', 'posname12', 'nextSpOrgCode', '', '', false, '', window, 'onOrgPosSelected','nextSppos')
		 
	}
	
function changeSpjg(newValue , oldValue){

	var sqyj = $("#sqyj").val();
	var spyj=sqyj.substring(2,sqyj.length);
		if(newValue=="1"){
			$("#spyj").val("同意"+spyj) ;
		}else{
			$("#spyj").val("拒绝"+spyj) ;
		}
	
}

function onOrgPosSelected(posidInputID) {
	//alert(posidInputID);
}

function onOrgUserSelected(userIDInputID) {
	//alert(userIDInputID);
}









	
</script>