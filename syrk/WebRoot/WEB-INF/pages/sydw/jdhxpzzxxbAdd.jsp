<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 下午13:15:54]
	@updateAuthor: [star]
	@updateDate:   [2015-6-5 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>剧毒化学品资质信息</title>
</head>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/jdhxpzzxxbAdd.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>jdhxpzzxxb/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;margin-top:10px;text-align: center;">
  			<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
	    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
	    		<input type="hidden" name="flag" id="flag" value="${flag}" />
			   	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">安全责任人姓名：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'" type='text' 
						name='anquanzerenren' style="width:200px;" value="${entity.anquanzerenren}" />
					</td>
					<td width="20%" class="dialogTd" align="right">安全责任人联系电话：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox"  data-options="validType:['phone'],required:false,tipPosition:'left'" type="text" id="anquanzerenren_dhhm" name="anquanzerenren_dhhm" maxlength="30" style="width:200px;" value="${entity.anquanzerenren_dhhm}"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">库房安防等级：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-combobox ' data-options="url: contextPath + '/common/dict/BD_D_KFAFDJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type='text' 
						name='anfangdengji' style="width:200px;" value="${entity.anfangdengji}" />
					</td>
					<td width="20%" class="dialogTd" align="right">从业人员总数：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox"  data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'" type="text" id="congyerenshu" name="congyerenshu" maxlength="100" style="width:200px;" value="${entity.congyerenshu}"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">上级机关（公安）名称：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="required:false ,validType:['maxLength[200]'],tipPosition:'right'" type='text' 
						name='shangjijiguan'  style="width:200px;" value="${entity.shangjijiguan}" />
					</td>
			    </tr>
			    <tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">组织机构代码证：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="required:false ,validType:['maxLength[50]'],tipPosition:'right'" type='text' 
						name='jgdmz' style="width:200px;" value="${entity.jgdmz}" />
					</td>
					<td width="20%" class="dialogTd" align="right">组织机构代码证有效期：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox"   type="text" id="jgdmz_yxq" name="jgdmz_yxq" maxlength="100" style="width:200px;" value="${entity.jgdmz_yxq}"
						data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" 
						data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">安监颁发证件号：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="required:false ,tipPosition:'right'" type='text' 
						id="ajz" name='ajz' style="width:200px;" value="${entity.ajz}" />
					</td>
					<td width="20%" class="dialogTd" align="right">安监颁发证件有效期：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox"  type="text" id="ajz_yxq" name="ajz_yxq" maxlength="100" style="width:200px;" value="${entity.ajz_yxq}" 
						data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" 
						data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">环保资质号：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="required:false ,tipPosition:'right'" type='text' 
						name='hbzz' style="width:200px;" value="${entity.hbzz}" />
					</td>
					<td width="20%" class="dialogTd" align="right">环保资质有效期：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox"   type="text" id="hbzz_yxq" name="hbzz_yxq" style="width:200px;" value="${entity.hbzz_yxq}"
						data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" 
						data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
					</td>
			    </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>