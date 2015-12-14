<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.xjpt.com.founder.noreas.authorityManager.AuthorityManagerUtils"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<% 	
	SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
	String uid=userInfo.getUserId();
	String[] orgcodes=AuthorityManagerUtils.getUserOrgCodes(uid);
	String orgcode="",pcscode="";
	if("0".equals(orgcodes[0])){
		orgcode="";
	}else if("1".equals(orgcodes[0])){
		orgcode="210200000000";
	}else if("2".equals(orgcodes[0])){
		orgcode=orgcodes[1];
	}else{
		orgcode=orgcodes[0];
		pcscode=orgcodes[1];
	}
	String authority=AuthorityManagerUtils.getUserAuthority(uid);
%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v = "urn:schemas-microsoft-com:vml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<script type="text/javascript">
			var org="<%=orgcode%>";
			var pcs="<%=pcscode%>";
			var aut="<%=authority%>";
			var mapWin=null;

			$(function(){
				if (IE) {
					mapWin = parent.frames["biz_center"];
				}else {
					mapWin = parent.frames.document.getElementById("biz_center").contentWindow;
				}
			});

			function alermAnalyse_query(){
				var dept1='210200000000';
				var dept2=$("#dept2").val();
				var dept3=$("#dept3").val();
				var bdate=$("#bdate").val();
				var edate=$("#edate").val();
				var alermType1=$("#alermType1").val();
				var alermType2=$("#alermType2").val();
				var dept=dept3==''?dept2==''?dept1:dept2:dept3;
				if(edate==''||bdate==''){
					alert('请选择日期！');
					return;
				}
				if(edate<bdate){
					alert('结束日期不能小于开始日期！');
					return;
				}
				var parm = '?dept='+dept+'&btime='+bdate+'&etime='+edate+'&cjfs='+alermType1+'&jqlb='+alermType2;
				window.parent.zdParm(parm, "jqfx");
				$.ajax({
					url:'<%=basePath %>/forward/query|analysis_getPoint',
					type:"post",
					dataType:"json",
					beforeSend:mapWin.alermAnalysis_ajaxLoading,
					data:{
						dept:dept,
						btime:bdate,
						etime:edate,
						cjfs:alermType1,
						jqlb:alermType2
					},
					success:function(res){
//						alert(res);
						if(res)
							mapWin.alermAnalysis_getHotPic();
						mapWin.alermAnalysis_ajaxLoadEnd();
					}
				});
			}
			
			function alermAnalyse_close(){
				mapWin.alermAnalysis_close();
			}
		</script>
	</head>
	<body class="easyui-layout" data-options="fit:true">  
	    <div data-options="region:'center',border:false">
	    	<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<tr class="dialogTr" style="display:none">
					<td width="30%" class="dialogTd" align="right">一级部门：</td>
					<td width="70%" class="dialogTd" >
						<select id="dept1" class="easyui-combobox" style="width: 132px">
							<option id="210200000000">大连市公安局</option>
						</select>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="30%" class="dialogTd" align="right" style="color:#222222;font-size: 12px">分&nbsp;&nbsp;&nbsp;&nbsp;局：</td>
					<td width="70%" class="dialogTd" >
						<input id="dept2" class="easyui-combobox" data-options="    
					        valueField: 'id',    
					        textField: 'text',    
					        url: '<%=basePath %>/forward/query|patrolLine_getDept?pid=210200000000',    
					        onSelect: function(rec){ 
					        	var url=url ='<%=basePath %>/forward/query|patrolLine_getDept?pid='+rec.id;    
					            $('#dept3').combobox('clear');    
					            $('#dept3').combobox('reload', url);
					        }" />   
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="30%" class="dialogTd" align="right" style="color:#222222;font-size: 12px">派&nbsp;出&nbsp;所：</td>
					<td width="70%" class="dialogTd" >
						<input id="dept3" class="easyui-combobox" data-options="
							valueField:'id',
							textField:'text',onSelect:function(rec){}" />  
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="30%" class="dialogTd" align="right" style="color:#222222;font-size: 12px">巡&nbsp;&nbsp;&nbsp;&nbsp;区：</td>
					<td width="70%" class="dialogTd" >
						<input id="dept4" class="easyui-combobox" data-options="
							valueField:'id',
							textField:'text'" />  
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="30%" class="dialogTd" align="right" style="color:#222222;font-size: 12px">开始日期：</td>
					<td width="70%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="bdate" 
						data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'%y-%M-%d'})"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="30%" class="dialogTd" align="right" style="color:#222222;font-size: 12px">结束日期：</td>
					<td width="70%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="edate" 
						data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'%y-%M-%d'})"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="30%" class="dialogTd" align="right" style="color:#222222;font-size: 12px">处警方式：</td>
					<td width="70%" class="dialogTd" >
						<select id="alermType1" class="easyui-combobox" style="width: 130px" >
							<option value="11">巡逻发现</option>
							<option value="12">110指令</option>
							<option value="13">派出所直接接警</option>
							<option value="14">群众举报</option>
						</select>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="30%" class="dialogTd" align="right" style="color:#222222;font-size: 12px">警情类别：</td>
					<td width="70%" class="dialogTd" >
						<select id="alermType2" class="easyui-combobox" style="width: 130px" >
							<option value="21">救助群众</option>
							<option value="22">调节纠纷</option>
							<option value="23">治安案件</option>
							<option value="24">刑事案件</option>
						</select>
					</td>
				</tr>
				<tr class="dialogTr">
					<td class="dialogTd" align="center" colspan="2">
						<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-query" onclick="alermAnalyse_query()">查询</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-no" onclick="alermAnalyse_close()">关闭</a>
					</td>
				</tr>
			</table>
	    </div>
	</body>
</html>