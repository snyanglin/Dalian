<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/qbld/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
	String zjhm = request.getParameter("zjhm");
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
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/qbld/zdrxs.css" />
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/main.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/yjxx.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/zdrxs.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/zdrxs.js" ></script>
    <script type="text/javascript">
    	userOrgCode = "<%=userOrgCode%>";
    	var userOrgName = "<%=userOrgName%>";
   		var userName = "<%=userName%>";
   		var zjhm =  "<%=zjhm%>";
    	bodyHeight=0;
    	$(function(){
    		bodyHeight = $(document).height();
    		$(window).resize();
    		$("#otherInfoListDiv").tabs({
    			width:$(".infoBodyTable").width(),
    			height:bodyHeight-$(".infoBodyTable").height()-100,
    			border:false
    		});
    		Zdrxs.queryZdryInfo(zjhm);
 		});
 		$(window).resize(function() {
			$("#infoDiv").css("height",bodyHeight-25);
		});
    </script>
  </head>
  <body>
  		<table class="bodyTable" border=0>
  			<tr>
  				<td class="infoTd">
  					<div id="infoDiv">
  						<form id="infoform">
	  					<table class='infoOneTable'>
	  						<tr><td class='infoTypeTd'  id='zdry_xm'>姓名</td></tr>
								<td>
									<table class='infoBodyTable'>
										<tr><td class='infoName'>证件号码</td><td class='infoValue' id='zdry_sfzh'></td><td class='infoName'>性别</td><td class='infoValue' id='zdry_xb'></td><td id='imgTd' rowspan=6><img id='zdry_zp' style='width:150;height:185px'></img></td></tr>
										<tr><td class='infoName'>部级编号</td><td class='infoValue' id='zdry_bjzdrybh'> </td><td class='infoName'>其他证件号码</td><td class='infoValue' id='zdry_qtzjhm'> </td></tr>
										<tr><td class='infoName'>民族</td><td class='infoValue' id='zdry_mz'></td><td class='infoName'>国籍</td><td class='infoValue' id='zdry_gj'> </td></tr>
										<tr><td class='infoName'>户籍地址详址</td><td class='infoValue' colspan=3 id='zdry_hjdxz'></td></tr>
										<tr><td class='infoName'>户籍派出所</td><td class='infoValue' colspan=3 id='zdry_hjdpcs'></td></tr>
										<tr><td class='infoName'>现居住地详址</td><td class='infoValue' id='zdry_xzdxz'  colspan=3></td></tr>
										<tr><td class='infoName'>部重点人员细类</td><td class='infoValue' id='zdry_zdryxl' colspan=4></td></tr>
										<tr><td class='infoName'>立案时间</td><td class='infoValue' id='zdry_zjlasj' ></td><td class='infoName'>创建时间</td><td class='infoValue' colspan=2 id='zdry_createdate' ></td></tr>
										<tr><td class="infoValue" colspan=5 ><div id="zdrySxxx" style="display:none">
											<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.showZdrxsLsList();">历史写实</a>
										 	<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openShgxrTab();">社会关系人</a>
										 	<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openSaTab();">涉案信息</a>
											<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openClxxTab();">车辆信息</a></div>
										 	</td></tr>
									</table>
								</td>	
							</tr>
							<tr id="zdryOpButtonTr" style="display:none;" align="center">
								<td>
									<a href="#" class="easyui-linkbutton" iconCls="icon-flowWrite" onclick="Zdrxs.initXsTab();">写实</a>
									<a href="#" class="easyui-linkbutton" iconCls="icon-flowEnd" onclick="Zdrxs.initGxbgTab();">管辖变更</a>
								</td>
							</tr>
							<tr id="opInfoTr" style="display:none;" >
								<td style="width:100%;height:100%;">
									<div id='otherInfoListDiv' ></div>
								</td>
							</tr>
							</table>
							</form>
					</div>
  				</td>
  			</tr>
  		</table>
  </body>
</html>
