<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人员档案</title>
<%-- <script type="text/javascript" src="<%=contextPath%>/js/syrkinfo-mould.js"></script> --%>
<%-- <script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script> --%>

<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>

<%-- <script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script> --%>
<style>
.nameTable{ width:500px;height:auto;overflow:hidden;}
.nameTable tr{height:auto;}
.nameTable th{line-height:26px; color:#666;font-weight:normal;word-wrap:break-all;font-size:1.2rem;}
.nameTable td{line-height:20px; color:#333;word-wrap:break-all;font-size:1.2rem; }


/*本页面自定义样式 ******/
.operate-btns{width:100%;margin-top:20px;margin-bottom:20px;text-align:center;padding-left:80px;}
#operate-track{width:400px;height:400px;margin:0 auto;}
/********************/

</style>
</head>

<body class="bodybg" >
<div class="head"><div class="logo"></div></div>
<div class="bodydiv">
<div class="bodyer">
<div class="lf">
<!--框-->
<div class="lf_conta">
<div class="lf_contb">
<div class="lf_contc">
					<table width="100%" style="margin-left:100px;">
							<tr >
								<td valign="top" >
									<div class="pinfo1" >
									<ul>
										<li style="padding:0px;" >
										<table cellpadding="0" cellspacing="0" class="nameTable"  >
										 <tbody id="jbxxInfo">
											 <tr>
											      <th  align="right" >姓名：</th>
												  <td >${qbry.xm}</td>
												  <th  align="right" >证件号码：</th>
												  <td > ${qbry.gmsfhm}</td>
											 </tr>
											 <tr >
											      <th  align="right" >性别：</th>
												  <td width="90"><script type="text/javascript">  document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', "${qbry.xbdm}"));</script></td>
												  <th  align="right" >国籍：</th>
												  <td width="120"><script type="text/javascript">  document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${qbry.gjdm}"));</script></td>
											 </tr>
											 <tr>
											      <th  align="right" >参考居住地址(居住地)：</th>
												  <td  colspan="3" width="270">${qbry.jzd}</td>
											 </tr>
											 <tr>
											      <th  align="right" >实际居住地址(现住地)：</th>
												  <td  colspan="3" width="270">${qbry.xzd}</td>
											 </tr>
											 <tr >
											      <th  align="right" >户籍地址：</th>
												  <td  colspan="3" width="270">${qbry.hjd}</td>
											 </tr>
											 <tr >
											      <th  align="right" >立案单位：</th>
												  <td width="90">${qbry.ladwmc}</td>
												  <th  align="right" >立案时间：</th>
												  <td width="120">${qbry.lasj}</td>
											 </tr>
											 <tr >
												  <th  align="right" >入部省库时间：</th>
												  <td width="120" colspan="3">${qbry.bjzdryrksj}</td>
											 </tr>
											 <tr>
											 	<td colspan="6">
											 		<hr style="width:600px;"/>
											 	</td>
											 </tr>
											 <tr >
											      <th  align="right" >当前级别：</th>
											      <td ><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_ORG_ORGLEVEL.js', "${qbry.dqjb}"));</script></td>
												  <th  align="right" >下发状态：</th>
												  <td ><script type="text/javascript">  document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_QBRYGLZT.js', "${qbry.glzt}"));</script></td>
											 </tr>
											 <tr >
											      <th  align="right" >责任单位：</th>
												  <c:if test="${qbry.dqjb == '10'}">
											      	<td width="90">${qbry.qbzdmc}</td>
											      </c:if>
												  <c:if test="${qbry.dqjb == '21'}">
											      	<td width="90">${qbry.qbddmc}</td>
											      </c:if>
											      <c:if test="${qbry.dqjb == '32'}">
											      	<td width="90">${qbry.qbpcsmc}</td>
											      </c:if>
											      <c:if test="${qbry.dqjb == '50'}">
											      	<td width="90">${qbry.qbzrqmc}</td>
											      </c:if>
												  <th  align="right" >责任人：</th>
												  <td width="120" >${qbry.xt_zhxgrxm}</td>
											 </tr>
										 </tbody>
										</table>
									</li>
								    </ul> 	
								</div>
							</td>
						</tr>
					</table>
					<div style="width:700px;height:210px;margin-left:60px;border:1px solid #ccc;">
						<!-- 业务操作记录  start -->
						<table id="operate-track"  class="easyui-datagrid" style="width:100%;height:200px;margin-left:20px;" title='业务操作记录表' 
			              	data-options="url:'<%=contextPath%>/qbryManager/ywList/${qbry.gmsfhm}',
			              	selectOnCheck:true,
			        		checkOnSelect:true,
			        		rownumbers:true,
			        		border:false,
			        		sortName:'',
			        		sortOrder:'desc',
			        		pageSize:5,
			        		pageList:[5],
			        		singleSelect:true,
			        		fitColumns:true">
					        <thead>
					          	<tr>
						            <th data-options="field:'czlb',width:100,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBYWCZLX.js'">操作类别</th>
						            <th data-options="field:'xt_lrsj',width:150,align:'center',sortable:true,halign:'center'">操作时间</th>
						            <th data-options="field:'czyj',width:200,align:'center',sortable:true,halign:'center'">操作原因</th>
						            <th  data-options="field:'mbbmmc',width:100,align:'center',halign:'center',sortable:true">目标部门</th>
						            <th  data-options="field:'xt_lrrbm',width:100,align:'center',halign:'center',sortable:true">操作部门</th>
						            <th  data-options="field:'xt_lrrxm',width:100,align:'center',halign:'center',sortable:true">操作人</th>
						        </tr>
					       </thead>
				       </table>
					<!-- 业务操作记录  end -->
					</div>
</div>
</div>
</div>
<!--/框-->
</div>
</div>
</div>
</body>
</html>
    
