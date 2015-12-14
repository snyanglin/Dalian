<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String userName = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        userName = userInfo.getUserName();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>动态记实</title>
    <style>
    .infoBodyTable{
		min-width:600px;
		width:99%;
		border-collapse: collapse;
	}
	
	.infoBodyTable td{
		border:1px solid #000;
		height:30px;
	}
	.infoOneTable{
		width:100%;
		border-collapse: collapse;
	}
	.infoName{
		width:120px;
		text-align:center;
		background: #f4f4f4;
	}
	.red{
		color: red;
	}
	.infoValue{
		padding-left: 10px;
	}
	#otherInfoListDiv{
		overflow: none;
		border:1px solid #17a9ff;
	}
    </style>   

    <script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryDtjs.js" ></script>
    <script type="text/javascript">
    	userOrgCode = "<%=userOrgCode%>";
    	var userOrgName = "<%=userOrgName%>";
   		var userName = "<%=userName%>";
    	bodyHeight=0;
    	$(function(){
    		bodyHeight = $(document).height();
    		$(window).resize();
    		ZdryDtjs.buildXsHtml();
 		});
 		$(window).resize(function() {
			$("#InfoList").css("height",bodyHeight-200);
			
			$("#infoDiv").css("height",bodyHeight-25);
		});
    </script>
  </head>
  <body style="margin-top:20px; margin-bottom:10px" class="bodybg" onload="startup()">
	<div data-options="region:'center',split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
		<table height="100%" style="margin:0 auto;">
		<tr><td height="100%" valign="top" align="center">
			<div class="pop_conta">
			<div class="pop_contb">
			<div class="pop_contc"> 
	 		<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
  				<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	  				<tr><td>
						<table class='infoBodyTable'>
										<tr>
											<td class='infoName' width="20%">姓名</td><td width="30%" class='infoValue' id='zdry_sfzh'>${ryRyjbxxb.xm }</td>
											<td class='infoName' width="20%">证件号码</td><td width="30%" class='infoValue' id='zdry_sfzh'>${ryRyjbxxb.zjhm }</td>
										</tr>
										<tr>
											<td class='infoName'>记实查询</td>
											<td class='infoValue' colspan="3">
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.showZdrxsLsList();">历史写实</a>
											</td>											
										</tr>
										<tr>
											<td class='infoName'>动态记实</td>
											<td class='infoValue' colspan="3">
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true"  onclick="ZdryDtjs.initXsTab();">写实</a>
												<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true"  onclick="ZdryDtjs.initGxbgTab();">管辖变更</a> -->
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openShgxrTab();">社会关系人</a>
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openSaTab();">涉案信息</a>
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openClxxTab();">车辆信息</a>
											</td>											
										</tr>
										<tr>
											<td class='infoName'>动态记实-属性</td>
											<td class='infoValue' colspan="3">
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openZtTab();">在逃</a>
									 			<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openSwTab();">涉稳</a>
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openSfTab();">涉访</a>
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openSdXdTab();" style="display:none" id="sd-xdTag">涉毒-吸毒</a>
									 			<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openSdFdTab();">涉毒-贩毒</a>
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openSdZdTab();">涉毒-制毒</a>
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openZdxsfzqkTab();">重大刑事犯罪前科</a>
												<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="ZdryDtjs.openZszhjsbXsTab();">肇事肇祸精神病</a>
											</td>											
										</tr>																			
									</table>
					</td></tr>
							
					<tr id="opInfoTr">
						<td style="width:100%;height:100%;">
										<div id='otherInfoListDiv' ></div>
						</td>
					</tr>
				</table>
			</div>					
			</div>
		    </div>
		    </div>	
	    </td></tr></table>					
	</div>
  </body>
  <script type="text/javascript">  
  var syrk_zjhm='${ryRyjbxxb.zjhm }';
 
  function startup(){
	  var isXd=false;//是否吸毒
	  <c:forEach items="${zdryList}" var="item" varStatus="status">
	  	<c:if test="${item.zdrygllxdm == '02' && item.zdrylb == '020501'}">
	  		isXd=true;
	  	</c:if>
	  </c:forEach>
	  
	  if(isXd){
		  $("#sd-xdTag").show();
	  }
  }
  </script>
</html>
