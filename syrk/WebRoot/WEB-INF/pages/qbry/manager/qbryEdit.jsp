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
.operate-btns{width:400px;margin-left:180px;margin-top:20px;margin-bottom:20px;text-align:center;padding-left:80px;}
#operate-track{width:400px;height:400px;margin:0 auto;}
/********************/

</style>
</head>

<body class="bodybg" onload="startup()">
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
					
					<!-- 功能按钮 start -->
					<div class="operate-btns">
						<a id="sendDown" href="#" class="easyui-linkbutton" onclick="openCzWin(1)" style="display:none;">下发</a>
						<a id="sendBack" href="#" class="easyui-linkbutton" onclick="openCzWin(2)" style="display:none;">申请退回</a>
						<a id="sendBackCancel" href="#" class="easyui-linkbutton" onclick="openCzWin(3)" style="display:none;">撤销退回</a>
						<a id="syrkAdd" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addSyrk()" style="display:none;">新增实有人口</a>
						<a id="accept" href="#" class="easyui-linkbutton" onclick="openCzWin(9)" style="display:none;">接收</a>
					</div>			
					<!-- 功能按钮 end-->
					
					<!-- 情报人员操作窗口 -->
					<div id="czDiv" class="easyui-window" title="情报人员操作"  data-options="iconCls:'icon-search',
		                collapsible:false,minimizable:false,maximizable:false,
				        modal:true,closed:true,width:600,height:200">
				        <div id="datagridToolbar" style="padding: 0px; height: 150px; width: 100%; vertical-align: top;">
				        <form id ="acceptForm" >		 
				        	<input type="hidden" name="id" id="id" value="${qbry.id }" />
				            <input type="hidden" name="gmsfhm" id="gmsfhm" value="${qbry.gmsfhm }" />  
					        <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
						        
						        <tr class="dialogTr">
							    	<td width="20%" class="dialogTd" align="right">操作意见：</td>
							    	<td width="80%" class="dialogTd">
							    	    <textarea name="czyj" id="czyj" class="easyui-validatebox" style="width: 100%; height:48px;" data-options="required:false,validType:['maxLength[500]'],tipPosition:'left'"></textarea>
							    	</td>				    	
						    	</tr>
						    	<tr class="dialogTr" id="mbbmTr">
							    	<td width="20%" class="dialogTd" align="right">目标部门：</td>
							    	<td width="80%" class="dialogTd">
							    		<input class="easyui-combobox" type="text" id="mbbmdm"  style="width:180px;"
								            data-options="
								            url:'<%=contextPath%>/orgPublicSelect/queryComboBoxList?parentOrgCode='+${orgCode},
								            valueField:'id',
								            textField:'text',
								            selectOnNavigation:false,
								            method:'get',
								            required:true,
								            tipPosition:'right'"/>
							    	</td>				    	
						    	</tr>	
						    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							    	<td align="center" colspan="2">
							    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="czOk();">确定</a>
							    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="czWinClose()">关闭</a>
							    	</td>
						    	</tr>
					         </table>
					         
				        </form>
				        </div>
				   </div> 

</div>

</div>
</div>
<!--/框-->
</div>
</div>
</div>
</body>
<script type="text/javascript">
	var userOrgLevel='${orgLevel}';//用户级别，50（责任区）、32（派出所）、21（分县局）、10（市局）
	var qbry_dqjb='${qbry.dqjb}';//情报人员 当前级别
	var qbry_glzt='${qbry.glzt}';//情报人员 管理状态：1待下发、2退回申请中、3退回拒绝、9已接收
	var qbry_syrkid='${qbry.syrkid}';//情报人员 实有人口ID
	function startup(){
		//初始化方法，根据条件显示可操作按钮
		if(userOrgLevel != qbry_dqjb)//不是当前级别，不能操作
			return;
		
		//非责任区（50）级别，“待下发（1）”或“退回拒绝（3）”状态
		if(userOrgLevel != '50' && (qbry_glzt =='1' || qbry_glzt == '3')){
			$("#sendDown").show();
		}
		
		//“待下发（1）”状态
		if(qbry_glzt =='1'){
			$("#sendBack").show();
		}
		
		//“退回申请中（2）”状态
		if(qbry_glzt =='2'){
			$("#sendBackCancel").show();
		}
		
		//级别为责任区、实有人口id为空，表示没有实有人口
		if(userOrgLevel == '50' && qbry_syrkid == ''){
			$("#syrkAdd").show();
		}
		
		//级别为责任区、“待下发（1）”或“退回拒绝（3）”状态
		if(userOrgLevel == '50' && (qbry_glzt =='1' || qbry_glzt == '3')){
			$("#accept").show();
		}

	}
</script>

<script type="text/javascript">
	var czlx=0;
	
	
	function addSyrk(){
		var gmsfhm=$("#gmsfhm").val();
		 menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID()+'&zjhm='+gmsfhm);
	}
	
	function openCzWin(val){ //情报人员操作窗口
		czlx=val;
	
		if(czlx==1){//下发
			$("#mbbmTr").show();
		}else{
			$("#mbbmTr").hide();
		}
		
	
	
		$("#czyj").val("");
		$("#czDiv").window("open");
	}

	function czWinClose(){
		$("#czDiv").window("close");
	} 
	
	function czOk(){
		if(czlx==1){//下发
			sendDown();
		}
		
		if(czlx==2){//退回申请
			sendBack();
		}
		
		if(czlx==3){//退回撤销
			sendBackCancel();
		}
		
		if(czlx==9){//接收
			acceptQbry();
		}
	}
	
	function acceptQbry(){
		var qbryId=$("#id").val();
		var czyj=$("#czyj").val();
		$.ajax({
			type: "POST",
			url: contextPath +"/qbryManager/saveLg",
			dataType: "json",
			data:"id=" + qbryId + "&czyj=" + czyj,
			success: function(data) {
				if (data) {				
					if(data.status && data.status=="success"){
						alert("接收成功");
						window.location.reload();
					}else{
						if(data.message){
							alert("接收失败："+data.message);
						}else{
							alert("接收失败："+data);
						}
						
					}
				}else{
					alert("接收失败："+data);
				}
			},		
			error: function(data) {
				alert("接收失败："+data);
			}
		});	
	}
	

	function sendDown(){
		var qbryId=$("#id").val();
		var gmsfhm=$("#gmsfhm").val();
		var czyj=$("#czyj").val();
		var mbbmmc=	$("#mbbmdm").combobox('getText');
		var mbbmdm = $("#mbbmdm").val();

		$.ajax({
			type: "POST",
			url: contextPath +"/qbryManager/sendDown",
			dataType: "json",
			data:"id=" + qbryId +"&mbbmmc=" + mbbmmc + "&mbbmdm=" + mbbmdm+"&czyj="+czyj+"&gmsfhm="+gmsfhm,
			success: function(data) {
				if (data) {				
					if(data.status && data.status=="success"){
						alert("下发成功");
						window.location.reload();
					}else{
						if(data.message){
							alert("下发失败："+data.message);
						}else{
							alert("下发失败："+data);
						}
						
					}
				}else{
					alert("下发失败："+data);
				}
			},		
			error: function(data) {
				alert("下发失败："+data);
			}
		});	
	}

 	function sendBack(){
		var qbryId=$("#id").val();
		var czyj=$("#czyj").val();
		$.ajax({
			type: "POST",
			url: contextPath + "/qbryManager/sendBack",
			dataType: "json",
			data:"id=" + qbryId + "&czyj=" + czyj,
			success: function(data) {
				if (data) {				
					if(data.status && data.status=="success"){
						alert("退回成功");
						window.location.reload();
					}else{
						if(data.message){
							alert("退回失败："+data.message);
						}else{
							alert("退回失败："+data);
						}
						
					}
				}else{
					alert("退回失败："+data);
				}
			},		
			error: function(data) {
				alert("退回失败："+data);
			}
		});		 
 }
 	
 	function sendBackCancel(){
		var qbryId=$("#id").val();
		var czyj=$("#czyj").val();
		$.ajax({
			type: "POST",
			url: contextPath + "/qbryManager/sendBackCancel",
			dataType: "json",
			data:"id=" + qbryId + "&czyj=" + czyj,
			success: function(data) {
				if (data) {				
					if(data.status && data.status=="success"){
						alert("退回撤销成功");
						window.location.reload();
					}else{
						if(data.message){
							alert("退回撤销失败："+data.message);
						}else{
							alert("退回撤销失败："+data);
						}
						
					}
				}else{
					alert("退回撤销失败："+data);
				}
			},		
			error: function(data) {
				alert("退回撤销失败："+data);
			}
		});		 
 }
</script>
</html>
    
