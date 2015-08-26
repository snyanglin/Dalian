<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String orglevel = "";
    String ssFsxCode = "";
    String ssPcsCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        orglevel = userInfo.getUserOrgLevel();
        ssFsxCode = (String) userInfo.getExtendMap().get("ssFsxCode");
        ssPcsCode = (String) userInfo.getExtendMap().get("ssPcsCode");
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>地址统计</title>
    <script type="text/javascript">
      	var userOrgCode = "<%=userOrgCode%>";
      	var userOrgName = "<%=userOrgName%>";
      	var orglevel = "<%=orglevel%>";
      	var ssFsxCode = "<%=ssFsxCode%>";
      	var ssPcsCode = "<%=ssPcsCode%>";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzCount/dzCount.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'center',split:true,border:false" style="height:auto">
        <!-- 查询列表 -->
        <table id="dzCountTable"></table>
        <!-- 查询条件 -->
        <div id="datagridToolbar" style="padding: 5px;height: auto;">
           <form id="queryForm">
	           <table cellspacing="0" cellpadding="0" border="0">
                 <tr class="dialogTr">
	                 <td class="dialogTd" style="width:90px" align="right">管辖分(县)局：</td>
				     <td class="dialogTd" style="width:140px" align="right">
						 <input type="text" name="gxsxj" id ="gxsxj" class="easyui-combobox"
					            data-options="valueField:'id',textField:'text',method:'get',selectOnNavigation:false,isTopLoad:false,
					                          url:contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',
					            			  onChange:function(newValue, oldValue){var parentOrgCode = $('#gxsxj').combobox('getValue');
					                                  if(parentOrgCode==''){
					                                 	 $('#gxpcs').combobox('loadData',[]);
					                                 	 $('#gxzrq').combobox('loadData',[]);
					                                  }else{
					                                  	 var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode='+parentOrgCode;
					                                  	 $('#gxpcs').combobox('reload', url);
					                                  }}" style="width:140px;"/>
				     </td>
				     <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
				     <td class="dialogTd" style="width:85px;" align="right">管辖派出所：</td>
					 <td class="dialogTd" style="width:140px;" align="right"> 
					     <input type="text" name='gxpcs' id="gxpcs" class="easyui-combobox"
					            data-options="valueField:'id',textField:'text',method:'get',selectOnNavigation:false,isTopLoad:false,
				         					  onChange:function(newValue, oldValue){var parentOrgCode = $('#gxpcs').combobox('getValue');
				         		                       if(parentOrgCode==''){
				         		                          $('#gxzrq').combobox('loadData', []);
				         		                       }else{
				         		                         var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=50&parentOrgCode='+parentOrgCode;    
	   													 $('#gxzrq').combobox('reload', url);
				         		                       }}" style="width:140px;"/>
					 </td>
					 <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
					 <td class="dialogTd" style="width:85px;" align="right">管辖责任区：</td>
					 <td class="dialogTd" style="width:140px;" align="right"> 
						 <input type="text" id="gxzrq" name="gxzrq" class="easyui-combobox" data-options="valueField:'id',textField:'text',method:'get',selectOnNavigation:false,isTopLoad:false" style="width:140px;"/>
					 </td>
					 <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
                 </tr>
                 <tr>
                     <td style="width:90px" align="right">统计时间：</td>
                     <td colspan="7">
                         <input type="radio" name="radioName" value="0" style="vertical-align: middle;" onclick="DzCount.timeReadonly();">本日&nbsp;
                         <input type="radio" name="radioName" value="1" style="vertical-align: middle;" onclick="DzCount.timeReadonly();">本周&nbsp;
                         <input type="radio" name="radioName" value="2" style="vertical-align: middle;" onclick="DzCount.timeReadonly();">本月&nbsp;
                         <input type="radio" name="radioName" value="3" style="vertical-align: middle;" onclick="DzCount.timeReadonly();">本季&nbsp;
                         <input type="radio" name="radioName" value="4" style="vertical-align: middle;" onclick="DzCount.timeReadonly();">本年&nbsp;
                         <input type="radio" name="radioName" value="5" style="vertical-align: middle;" onclick="DzCount.timeReadonly();">自定义：
                         <input type="text" name="kssj" id="kssj" class="easyui-validatebox" style="width:110px;vertical-align: middle;" value=""
							    onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'%y-%M-%d'})" data-options="required:false,tipPosition:'left',
							    validType:['date[\'yyyy-MM-dd\']']"/>
					     &nbsp;至&nbsp;
	  					 <input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width:110px;vertical-align: middle;" value=""
							    onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd', maxDate:'%y-%M-%d'})" data-options="required:false,tipPosition:'left',
							    validType:['date[\'yyyy-MM-dd\']']"/>
                     </td>
                     <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
                     <td class="toolbarTd" align="left">
						<a class="easyui-linkbutton" iconCls="icon-search" onclick="DzCount.queryButton();">统计</a>
						<a class="easyui-linkbutton" iconCls="icon-reload" onclick="DzCount.clearCase();">重置</a>
					 </td>
                 </tr>
	           </table>
           </form>
        </div>
     </div>
  </body>
</html>