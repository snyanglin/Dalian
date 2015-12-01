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
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/qbld/xscj.css" />
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/main.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/xscj.js" ></script>
    <script type="text/javascript">
    	var userOrgName = "<%=userOrgName%>";
   		var userName = "<%=userName%>";
    	bodyHeight=0;
    	$(function(){
    		Xscj.initQueryHtml();
    		Xscj.queryXscjList();
    		
    		bodyHeight = $(document).height();
    		$(window).resize();
 		});
 		$(window).resize(function() {
			$("#InfoList").css("height",bodyHeight-200);
			$("#infoDiv").css("height",bodyHeight-70);
			$("#otherDiv").css("width",$(document).width()-310);
		});
    </script>
  </head>
  <body>
  		<table class="bodyTable" border=0>
  			<tr>
  				<td class="queryList">
  					<form id="queryFrom">
  					<table border=0 width='100%' height='100%'>
  						<tr class="whereTr"> 
  							<td class="whereName">
  								标题
  							</td>
  							<td>
  								<input  class="whereInput" id="where_bt"/>
  							</td>
  						</tr>
  						<tr class="whereTr"> 
  							<td class="whereName">
  								紧急程度
  							</td>
  							<td >
  								<input type="checkbox" name="where_jjcd" value='1' checked><span class='color4'>一般</span><input type="checkbox" value='4' name="where_jjcd" checked><span class='color3'>重要</span><input type="checkbox" value='8' name="where_jjcd" checked><span class='color1'>紧急</span>
  							</td>
  						</tr>
  					<tr class="whereTr"> 
  							<td class="whereName">
  								来源
  							</td>
  							<td>
  								<input   id="where_xsly">
  							</td>
  						</tr>
  						<tr class="whereTr"> 
  							<td class="whereName">
  								报送时间
  							</td>
  							<td>
  								<input class="whereInput" id="where_bssjB" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})" ><br>
  								-<br>
								<input class="whereInput" id="where_bssjE" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})">
  							</td>
  						</tr>
						<tr class="whereTr"> 
  							<td colspan=2  align='center'>
  								<a href="#" class="easyui-linkbutton" onclick="Xscj.queryXscjList();" iconCls="icon-search">查询</a>
								<a href="#" class="easyui-linkbutton" onclick="document.forms['queryFrom'].reset();" iconCls="icon-reload">重置</a>
								<a href="#" class="easyui-linkbutton" onclick="Xscj.initAddXscjHtml();" iconCls="icon-add">新建</a>
  							</td>
  						</tr>
  						<tr class="infoListTr">
  							<td colspan=2 class="infoListTd"><div id="InfoList">共有0条预警信息</div></td>
  						</tr>
  					</table>
  					</form>
  				</td>
  				<td class="infoTd">
  					<div id="infoDiv">
  						<form id="infoform" method="post">
	  					<table class='infoOneTable'>
	  						<tr><td class='infoTypeTd' colspan=2>线索采集</td></tr>
							<tr>
								<td>
									<table class='infoBodyTable'>
										<tr><td class='infoName  red'>标题</td><td class='infoValue' colspan=3><input id="xscj_bt"  name="bt" maxlength=200 placeholder="最多填写200个文字"></td></tr>
										<tr><td class='infoName  red'>紧急程度<input id="xscj_jjcd" name="jjcd" value="1" class="notNull" style="display:none"></td>
											<td class='infoValue' id="jjcd_td"></td>
											<td class='infoName  red'>是否发生<input id="xscj_sfyfs" name="sfyfs" value="0" class="notNull" style="display:none"></td>
											<td class='infoValue' id="sfyfs_td"></td></tr>
										<tr><td class='infoName  red'>线索来源</td><td class='infoValue' id="xsly_td"><input id="xscj_xsly" name="xsly"  class="notNull"></td>
											<td class='infoName  red'>是否续报<input id="xscj_sfxb" name="sfxb" value="0"  class="notNull" style="display:none"></td>
											<td class='infoValue' id="sfxb_td"></td></tr>
										<tr id="sbxx_tr" style="display:none">
											<td class='infoName  red'>首报编号</td><td class='infoValue'><input id="xscj_xbyjlid" name="xbyjlid" class="notNull"></td>
											<td class='infoName  red'>首报标题</td><td class='infoValue'><input id="xscj_bt" name="bt" class="notNull" placeholder="自动填写" disabled="disabled"></td></tr>
										<tr id="fssj_tr" style="display:none">
											<td class='infoName  red'>开始时间</td><td class='infoValue'><input id="xscj_b_assj_ks" name="b_assj_ks"  class="notNull" placeholder="点击请选择日期" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})"></td>
											<td class='infoName'>结束时间</td><td class='infoValue'><input id="xscj_b_assj_js" name="b_assj_js"  placeholder="点击请选择日期" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})"></td></tr>
										<tr><td class='infoName  red'>正文</td><td class='infoValue' colspan=3><textarea id='xscj_xxzw' name="xxzw"  maxlength=2000 placeholder="最多填写2000个文字"></textarea></td></tr>
										<tr><td class='infoName'>采集人</td><td class='infoValue'><input id="xscj_cjr" name="cjr" value="<%=userName%>"></td>
											<td class='infoName'>采集单位</td><td class='infoValue'><input id="xscj_cjdwmc" name="cjdwmc" value="<%=userOrgName%>"></td></tr>
										<tr><td class='infoName'>联系电话</td><td class='infoValue' colspan=3><input id="xscj_"  name="" value="无字段"></td></tr>
									</table>
								</td>
							</tr>
							<tr id="optr" style="display:none">
								<td align="center" colspan=2>
									<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="Xscj.addXscjInfo();">提交</a>
									<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Xscj.infoFromReset();" >重置</a>
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
