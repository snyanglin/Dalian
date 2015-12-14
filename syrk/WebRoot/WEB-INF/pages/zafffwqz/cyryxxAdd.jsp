<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人防成员信息</title>
</head>
  <body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">
   <table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%" align="center" style="margin:0px;padding:0px">
		        <tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">姓名：</td>
				    	<td width="70%" class="dialogTd"><input type="text" name="fzrxm" id="fzrxm" value="${entity.fzrxm}" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  style="width:150px;" /></td>
			    	</tr>
			   	<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="70%" class="dialogTd"><input type="text" name="fzrzjhm" id ="fzrzjhm" value="${entity.fzrzjhm}" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  style="width:150px;" /></td>
			    	</tr>	 	
			    	<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">性别：</td>
				    	<td width="70%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" value="${entity.xbdm}" style="width:150px;"
							data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
			    	</tr>	

					<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">常用证件：</td>
				    	<td width="70%" class="dialogTd"><input class="easyui-combobox" type="text" id="fzrcyzjdm" name="fzrcyzjdm" value="${entity.fzrcyzjdm}" style="width:150px;"
							data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
			    	</tr>			    				    	
			    	<tr class="dialogTr">
				    	<td width="30%" class="dialogTd" align="right">居住地：</td>
				    	<td width="70%" class="dialogTd"><input type="text" name="dz_jzdzxz" id ="dz_jzdzxz" value="${entity.dz_jzdzxz}" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  style="width:150px;" /></td>
			    	</tr>				    	
	       <tr>
	       		<td align="right">
	       			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updateHs();">确定</a>
					<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButtonCan()">重置</a>
					<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('cancel');">关闭</a>&nbsp;
	       		</td>
	       </tr>
        </table>
  </body>
</html>
