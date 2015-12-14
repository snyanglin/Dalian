<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/qbld/commonInclude.jsp"%>
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
    <title>预警信息</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/qbld/yjxx.css" />
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/yjxx.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/yjxx_ckyj.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/yjxx_ckzl.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/yjxx_lkyj.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/yjxx_lkzl.js" ></script>
    <script type="text/javascript">
    	var userOrgCode = "<%=userOrgCode%>";
    	var userOrgName = "<%=userOrgName%>";
   		var userName = "<%=userName%>";
    	bodyHeight=0;
    	$(function(){
    		Yjxx.QueryDyjCount();
    		$(".yjCountDiv div").hover(function(){
    			Yjxx.changeDCountColor(this)
    		},function(){
    			Yjxx.changeDCountColor(this)
    		})
    		bodyHeight = $(document).height();
    		$(window).resize();
    		$("#ckyj_dqs").click();
 		});
 		$(window).resize(function() {
			$("#InfoList").css("height",bodyHeight-$("#countTr").height()-$("#whereTr").height()-25);
			$("#otherDiv").css("width",$(document).width()-310);
		});
    </script>
  </head>
  <body>
  		<table class="bodyTable" border=0>
  			<tr>
  				<td class="queryList">
  					<table border=0>
  						<tr id="countTr">
  							<td>
  								<div class='yjCountDiv'>
	  								<div class="yjTitle" id="ckyj" onclick="Yjxx.initCkyjQueryHtml();Yjxx.clickDcountToChangeColor(this)" >常控预警</div>
	  								<div class="yj_dqs" id="ckyj_dqs"  onclick="Yjxx.initCkyjQueryHtml(0);Yjxx.clickDcountToChangeColor(this)">待签收</div>
	  								<div class="yj_dfk" id="ckyj_dfk" onclick="Yjxx.initCkyjQueryHtml(1);Yjxx.clickDcountToChangeColor(this)">待反馈</div>
			  					</div>
			  					<div class='yjCountDiv'>
		  							<div class="yjTitle" id="ckzl" onclick="Yjxx.initCkzlQueryHtml();Yjxx.clickDcountToChangeColor(this)">预警指令</div>
	  								<div class="yj_dqs" id="ckzl_dqs" onclick="Yjxx.initCkzlQueryHtml(0);Yjxx.clickDcountToChangeColor(this)">待签收</div>
	  								<div class="yj_dfk" id="ckzl_dfk" onclick="Yjxx.initCkzlQueryHtml(1);Yjxx.clickDcountToChangeColor(this)">待反馈</div>
			  					</div>
			  					<div class='yjCountDiv'>
		  							<div class="yjTitle" id="lkyj" onclick="Yjxx.initLkyjQueryHtml();Yjxx.clickDcountToChangeColor(this)">临控预警</div>
	  								<div class="yj_dqs" id="lkyj_dqs" onclick="Yjxx.initLkyjQueryHtml(0);Yjxx.clickDcountToChangeColor(this)">待签收</div>
	  								<div class="yj_dfk" id="lkyj_dfk" onclick="Yjxx.initLkyjQueryHtml(1);Yjxx.clickDcountToChangeColor(this)">待反馈</div>
			  					</div>
			  					<div class='yjCountDiv'>
		  							<div class="yjTitle" id="lkzl" onclick="Yjxx.initLkzlQueryHtml();Yjxx.clickDcountToChangeColor(this)">临控指令</div>
	  								<div class="yj_dqs" id="lkzl_dqs" onclick="Yjxx.initLkzlQueryHtml(0);Yjxx.clickDcountToChangeColor(this)">待签收</div>
	  								<div class="yj_dfk" id="lkzl_dfk" onclick="Yjxx.initLkzlQueryHtml(1);Yjxx.clickDcountToChangeColor(this)">待反馈</div>
			  					</div>
  							</td>
  							<td>
  								<div class="yjjbCheckBox">
  								</div>
  							</td>
  						</tr>
  						<tr id="whereTr"> 
  							<td colspan=2>
  								<div id="queryDiv">
  								</div>
  							</td>
  						</tr>
  						<tr class="infoListTr">
  							<td colspan=2 class="infoListTd"><div id="InfoList">共有0条预警信息</div></td>
  						</tr>
  					</table>
  				</td>
  				<td class="infoTd">
  					<table class="infoTable" >
    	  				<tr class="titleTr"><td id='backButtonTd'></td><td id='infoTitle'>描述</td><td id='asInfoButton'></td></tr>
    					<tr class="infoTr"><td colspan=3><div id="oneInfoDiv">详情</div></td></tr>
    					<tr class="opTr"><td colspan=3 id='opButtonTd'>操作</td></tr>
    				</table>
  				</td>
  				<div id="otherDiv">
    					<div class="toggleOtherDiv" onclick="Yjxx.changeOtherDivShow()">弹出</div>
    					<div id="otherInfoDiv"><div id="otherInfoListDiv"></div></div>
    			</div>
    			<iframe id="bigMapDiv" style="display:none;width:800;height:600" src=""/>
  			</tr>
  		</table>
  </body>
</html>
