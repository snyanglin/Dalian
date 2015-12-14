<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/qbld/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgName = "";
    String userName = "";
    if(userInfo!=null){
        userOrgName = userInfo.getUserOrgName();
        userName = userInfo.getUserName();
    }
 %>
<html>
  <head>
    <title>预警信息</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/qbld/yjxx.css" />
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/qbld/lksq.css" />
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/main.js" ></script>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/lksq.js" ></script>
    <script type="text/javascript">
    	var userOrgName = "<%=userOrgName%>";
   		var userName = "<%=userName%>";
    	bodyHeight=0;
    	$(function(){
    		Lksq.initQueryHtml();
    		Lksq.queryLksqList();
    		bodyHeight = $(document).height();
    		$(window).resize();
 		});
 		$(window).resize(function() {
			$("#InfoList").css("height",bodyHeight-250);
			$("#infoDiv").css("height",bodyHeight-10);
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
  								姓名
  							</td>
  							<td>
  								<input  class="whereInput" id="where_bbkrxm" />
  							</td>
  						</tr>
  						<tr class="whereTr"> 
  							<td class="whereName">
  								证件号码
  							</td>
  							<td>
  								<input  class="whereInput" id="where_bbkrzjhm" />
  							</td>
  						</tr>
  						<tr class="whereTr"> 
  							<td class="whereName">
  								指令级别
  							</td>
  							<td>
  								<input type="checkbox" name="where_bc_gklx" value='1' checked>一级<input type="checkbox" value='2' name="where_bc_gklx" checked>二级<input type="checkbox" value='3' name="where_bc_gklx" checked>三级
  							</td>
  						</tr>
  						<tr class="whereTr"> 
  							<td class="whereName">
  								执行状态
  							</td>
  							<td >
  								<input id="where_bkzxzt">
  							</td>
  						</tr>
  						<tr><td class="whereName">申请时间</td><td><input class="whereInput" id="where_bkqssjB"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})" ><br>-<br>
																	<input class="whereInput" id="where_bkqssjE" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})"></td></tr>
						<tr class="whereTr"> 
  							<td colspan=2  align='center'>
  								<a href="#" class="easyui-linkbutton" onclick="Lksq.queryLksqList();" iconCls="icon-search">查询</a>
								<a href="#" class="easyui-linkbutton" onclick="document.forms['queryFrom'].reset();" iconCls="icon-reload">重置</a>
								<a href="#" class="easyui-linkbutton" onclick="Lksq.initAddLksqHtml();" iconCls="icon-add">新建</a>
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
  						<form id="infoFrom" method="post">
	  					<table class='infoOneTable'>
	  						<tr><td class='infoTypeTd' colspan=2 >临控申请</td></tr>
							<tr><td class='infoTypeTd'>人<br>员<br>信<br>息</td>
								<td>
									<table class='infoBodyTable'>
										<tr><td class='infoName  red'>证件类型</td><td class='infoValue'><input id="lksq_bbkrzjlx" name="bbkrzjlx" class="notNull"></td><td class='infoName  red'>证件号码</td><td class='infoValue'><input id="lksq_bbkrzjhm" class="notNull"   name="bbkrzjhm" maxlength="18"></td><td id='imgTd' rowspan=6><img id="lksq_zp" style='width:150;height:185px'></img></td></tr>
										<tr><td class='infoName  red'>姓名</td><td class='infoValue'><input id="lksq_bbkrxm" name="bbkrxm" class="notNull" maxlength="15"></td><td class='infoName  red'>性别</td><td class='infoValue'><input id="lksq_bbkrxb" class="notNull"   name="bbkrxb"></td></tr>
										<tr><td class='infoName  red'>出生日期</td><td class='infoValue'><input id="lksq_bbkrcsrq" name="bbkrcsrq" class="notNull"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMdd'})"></td><td class='infoName'>身高</td><td class='infoValue'><input id="lksq_bc_sg" name="bc_sg"  maxlength=56 ></td></tr>
										<tr><td class='infoName'>体貌特征</td><td class='infoValue' colspan=3><textarea id='lksq_bc_tmtz' maxlength=128 name="bc_tmtz" placeholder="最多填写128个文字"></textarea></td></tr>
										<tr><td class='infoName'>户籍地祥址</td><td class='infoValue' colspan=3><input id="lksq_bc_hjzz" name="bc_hjzz" maxlength=128 placeholder="最多填写128个文字"> </td></tr>
										<tr><td class='infoName'>现住地祥址</td><td class='infoValue' colspan=3><input id="lksq_bc_xzz" name="bc_xzz" maxlength=128 placeholder="最多填写128个文字"> </td></tr>
									</table>
								</td>	
							</tr>
							<tr>
								<td class='infoTypeTd'>布<br>控<br>信<br>息</td>
								<td>
									<table class='infoBodyTable'>
										<tr><td class='infoName  red'>布控类型</td><td class='infoValue'><input value="私密布控"></td><td class='infoName  red'>预警人</td><td class='infoValue'><input id="lksq_yjrmc" class="notNull"  value="<%=userName%>"  name="yjrmc"></td></tr>
										<tr><td class='infoName  red'>预警单位</td><td class='infoValue' colspan=3><input id="lksq_yjdwmc"  class="notNull" value="<%=userOrgName%>"   name="yjdwmc"></td></tr>
										<tr><td class='infoName  red'>指令级别</td><td class='infoValue'><input id="lksq_bc_bkjb"  class="notNull" name="bc_bkjb"></td><td class='infoName  red'>管控级别(类型)</td><td class='infoValue'><input id="lksq_bc_gklx" class="notNull"   name="bc_gklx"></td></tr>
										<tr><td class='infoName  red'>起始时间</td><td class='infoValue'><input id="lksq_bkqssj"  class="notNull" name="bkqssj"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})"></td>
										<td class='infoName  red'>截止时间</td><td class='infoValue'><input id="lksq_bkjzsj" name="bkjzsj" class="notNull"   onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})"><input id="lksq_bkts" name="bkts"  style="display:none"></td></tr>
										<tr><td class='infoName  red'>处置措施</td><td class='infoValue' colspan=3><input id="lksq_bc_cccs" class="notNull"  name="bc_cccs"></td></tr>
										<tr><td class='infoName'>短信号码</td><td class='infoValue' colspan=3><input id="lksq_sqrlxhm1" name="sqrlxhm1" maxlength="40"  placeholder='多个已;号隔开'  ></td></tr>
										<tr><td class='infoName  red'>布控原因</td><td class='infoValue' colspan=3><textarea id='lksq_bkyy' class="notNull"  name="bkyy" maxlength=512 placeholder="最多填写512个文字"></textarea></td></tr>
										<tr><td class='infoName  red'>处置要求</td><td class='infoValue' colspan=3><textarea id='lksq_czyq' class="notNull"  name="czyq" maxlength=512 placeholder="最多填写512个文字"></textarea></td></tr>
										<tr><td class='infoName  red'>执法依据</td><td class='infoValue' colspan=3><textarea id='lksq_zfyj' class="notNull"  name="zfyj" maxlength=512 placeholder="最多填写512个文字"></textarea></td></tr>
										<tr><td class='infoName'>备注</td><td class='infoValue' colspan=3><textarea id='lksq_bz' name="bz" maxlength=200 placeholder="最多填写200个文字"></textarea></td></tr>
									</table>
								</td>
							</tr>
							<tr>
								<td class='infoTypeTd'>申<br>请<br>信<br>息</td>
								<td>
									<table class='infoBodyTable'>
										<tr><td class='infoName  red'>申请人</td><td class='infoValue' ><input id="lksq_sqrxm" class="notNull"  name="sqrxm" readonly placeholder='点击选择发现责任民警'  onclick='public_singleSelectOrgUser("", "", "", "", "","", "lksq_sqrsfhm", "lksq_sqrxm", "", "lksq_sqdwjgdm", "lksq_sqdw", "", false, "", window, "", "")' >
												<input id="lksq_sqrsfhm" name="sqrsfhm" style="display:none"></td>
											<td class='infoName'>联系电话</td><td class='infoValue' ><input id="lksq_sqrlxhm" name="sqrlxhm"  maxlength="40"  placeholder='多个已;号隔开'  ></td></tr>
										<tr><td class='infoName'>申请时间</td><td class='infoValue'><input id="lksq_bc_sqsj" name="bc_sqsj" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMddHHmmss'})"></td>
											<td class='infoName  red'>申请单位</td><td class='infoValue'><input id="lksq_sqdw" class="notNull"  name="sqdw" readonly placeholder='自动填写' ><input id="lksq_sqdwjgdm" name="sqdwjgdm"  style="display:none"></td></tr>
										
										<tr><td class='infoName'>发布时间</td><td class='infoValue'><input id="lksq_bc_fbsj" name="bc_fbsj"></td><td class='infoName'>发布单位</td><td class='infoValue'><input id="lksq_bc_fbdw" name="bc_fbdw" value="<%=userOrgName%>" ></td></tr>
										<tr><td class='infoName'>发布人</td><td class='infoValue'   ><input id="lksq_bc_fbr" name="bc_fbr" value="<%=userName%>"></td>
											<td class='infoName'>联系电话</td><td class='infoValue'  ><input id="lksq_bc_fbrlxdh" name="bc_fbrlxdh"></td></tr>
									</table>
								</td>
							</tr>
							<tr id="opTr" style="display:none">
								<td align="center" colspan=2>
									<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="Lksq.addLksqInfo();">提交</a>
									<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="document.forms['infoFrom'].reset();" >重置</a>
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
