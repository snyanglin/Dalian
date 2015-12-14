<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String orglevel = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        orglevel = userInfo.getUserOrgLevel();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>涉公安访人员下发</title>
    <script type="text/javascript">
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=orglevel%>";
    </script>
    
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
  	<form action="" id="xiaFaForm" method="post">
  		
  		<input type="hidden" name="id" value="${zdrySgafzdryxxb.id}"/>
  		
  		<table id="xiafaTable" border="0" cellpadding="0" cellspacing="10" width="auto" height="auto" align="center" delayParse="true">
	        <tr class="dialogTr">
		    	<td class="dialogTd item_title">姓名：</td>
		    	<td class="dialogTd item_context" >
		    		${zdrySgafzdryxxb.xm}
		    	</td>
		    	<td class="dialogTd item_title">身份证：</td>
		    	<td colspan="3" class="dialogTd">
		    		${zdrySgafzdryxxb.gmsfhm}
		    	</td>
	    	</tr>
	    	 <tr class="dialogTr">
		    	<td class="dialogTd item_title">市局：</td>
		    	<td class="dialogTd item_context">
					<input type="text" name="sssj" id="orgList11" value="${zdrySgafzdryxxb.sssj}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=10',required:true,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList11_onChange">
		    	</td>
		    	<td class="dialogTd item_title">市局领导：</td>
		    	<td class="dialogTd item_context">
		    		<input type="text" id="text_sjzrld"  value ="${zdrySgafzdryxxb.sjzrld}" name="sjzrld" class="easyui-validatebox" data-options="required:false" style="width: 80px" />
		    		<%-- <input type="hidden" name="sjzrld" id="value_sjzrld" value ="${zdrySgafzdryxxb.sjzrld}"> --%>
		    		<a id="userSelect_sjzrld" href="#" class="easyui-linkbutton" onclick="onOrgUserSelect('10','sjzrld','市局责任领导')" style="width: 50px;height: 20px">选择</a>  
		    	</td>
	    	</tr>
	    	
	    	<tr class="dialogTr">
		    	<td class="dialogTd item_title">分市县局：</td>
		    	<td class="dialogTd item_context">
					<input type="text" name="ssfj" id="orgList21" value="${zdrySgafzdryxxb.ssfj}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList21_onChange">
		    	</td>
		    	<td class="dialogTd item_title">分市县局领导：</td>
		    	<td class="dialogTd item_context">
			    	<input type="text" id="text_fjzrld" name="fjzrld" value ="${zdrySgafzdryxxb.fjzrld}" class="easyui-validatebox" data-options="required:false" style="width: 80px" />
		    		<%-- <input type="hidden" name="fjzrld" id="value_fjzrld" value ="${zdrySgafzdryxxb.fjzrld}"> --%>
		    		<a id="userSelect_fjzrld" href="#" class="easyui-linkbutton" onclick="onOrgUserSelect('21','fjzrld','分县局责任领导')" style="width: 50px;height: 20px">选择</a>
			    </td>
		    </tr>
			<tr class="dialogTr">
		    	<td class="dialogTd item_title">所属派出所：</td>
		    	<td class="dialogTd item_context">
					<input type="text" name="sspcs" id="orgList22" value="${zdrySgafzdryxxb.sspcs}" class="easyui-combobox" style="width:200px;" 
						data-options="required:true,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList22_onChange">
		    	</td>
		    	<td class="dialogTd item_title">派出所领导：</td>
		    	<td class="dialogTd item_context">
		    		<input type="text" id="text_pcszrld" name="pcszrld" value ="${zdrySgafzdryxxb.pcszrld}" class="easyui-validatebox" data-options="required:false" style="width: 80px" />
		    		<%-- <input type="hidden" name="pcszrld" id="value_pcszrld" value ="${zdrySgafzdryxxb.pcszrld}"> --%>
		    		<a id="userSelect_pcszrld" href="#" class="easyui-linkbutton" onclick="onOrgUserSelect('32','pcszrld','派出所责任领导')" style="width: 50px;height: 20px">选择</a>
		    	</td>
		    </tr>
			<tr class="dialogTr">
		    	<td class="dialogTd item_title">所属责任区：</td>
		    	<td class="dialogTd item_context">
					<input type="text" name="sszrq" id="orgList23" value="${zdrySgafzdryxxb.sszrq}" class="easyui-combobox" style="width:200px;" 
						data-options="required:true,method:'get',
							valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
		    	</td>
		    	<td class="dialogTd item_title">责任区民警：</td>
		    	<td class="dialogTd item_context">
		    		<input type="text" id="text_zrqmj" name="zrqmj" value ="${zdrySgafzdryxxb.zrqmj}" class="easyui-validatebox" data-options="required:false" style="width: 80px" />
		    		<%-- <input type="hidden" name="zrqmj" id="value_zrqmj" value ="${zdrySgafzdryxxb.zrqmj}"> --%>
		    		<a id="userSelect_zrqmj" href="#" class="easyui-linkbutton" onclick="onOrgUserSelect('50','zrqmj','责任区民警')" style="width: 50px;height: 20px">选择</a>
		    	</td>
		    </tr>
		    <tr class="dialogTr" style="width: 460px">
		    	<td colspan="4" align="right">
		    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SgafzdryGl.xiaFaButton();">确定</a>
		    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SgafzdryGl.closeWindow('ddtest');">关闭</a>
		    	</td>
	    	</tr>
         </table>
         <div id="winOrgUser"></div>
  	</form>
  </body>
</html>