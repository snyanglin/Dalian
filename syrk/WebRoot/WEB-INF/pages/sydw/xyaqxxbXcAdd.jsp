<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 上午8:51:54]
	@updateAuthor: [star]
	@updateDate:   [2015-6-4 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/xyaqxxbXcAdd.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校车信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>xyaqxxbXc/saveXyaqxxbXc" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="xyid" name="xyid" value="${entity.xyid}" />
    	<input type="hidden" id="lxdh" name="lxdh"/>
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				 <input type="hidden" id="pk" name="id" value="${entity.id}" />
				 <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">校车号牌：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xcjdchphm" name="xcjdchphm" style="width:200px;" value="${entity.xcjdchphm }" maxlength="20" 
			    			data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">自有或租赁：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="zyhzl" name="zyhzl" style="width:200px;" value="${entity.zyhzl }"
							data-options="url: contextPath + '/common/dict/D_DW_ZYHZL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left',onChange:onChangeZyhzl"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">核定载人数：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="hdzrs" name="hdzrs" style="width:200px;" value="${entity.hdzrs }" maxlength="20" 
			    			data-options="validType:'naturalNumber',required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">注册日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zcrq" name="zcrq" style="width:200px;" value="${entity.zcrq }"
							data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">专用标志编号：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zybzbh" name="zybzbh" style="width:200px;" value="${entity.zybzbh }" maxlength="20" 
			    			data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">检验有效期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="jyyxq" name="jyyxq" style="width:200px;" value="${entity.jyyxq }"
							data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">驾驶人证件种类：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="jsrzjlxdm" name="jsrzjlxdm" style="width:200px;" value="${entity.jsrzjlxdm }"
							data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:zjhmCheck" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">驾驶人证件号码：</td>
			    	<td width="30%" class="dialogTd" align="left">
			    		<input class="easyui-validatebox" type="text" id="jsrzjhm" name="jsrzjhm" style="width:200px;float:left;" value="${entity.jsrzjhm }" maxlength="30" 
			    			data-options="required:false,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div></td>
		    	</tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">驾驶人姓名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="jsrxm" name="jsrxm" style="width:200px;" value="${entity.jsrxm }" maxlength="20" 
			    			data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">驾驶人联系电话：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="jsrlxdh" name="jsrlxdh" style="width:200px;" value="${entity.jsrlxdh }" maxlength="18"
			    			data-options="validType:['phone'],required:false,tipPosition:'left'" />
			    	</td>
			    </tr>
			    <tr class="dialogTr" id="tr_zldw">
			    	<td width="20%" class="dialogTd" align="right">租赁单位：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
				    	<input type="hidden" id="zldwid" name="zldwid" value="${entity.zldwid}" />
				    	<input type='hidden' name='zldwmc' id="zldwmc" value="${entity.zldwmc}"/>
				    	<input class="easyui-combobox" type="text" id="zldw-box" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" name="zldw-box" value="${entity.zldwmc}" maxlength="50" style="width:628px;"/>
				</td>
		    	</tr>
			    <tr class="dialogTr" id="tr_zldwdh">
			    	<td width="20%" class="dialogTd" align="right">租赁单位电话：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zldwlxdh" name="zldwlxdh" style="width:200px;" value="${entity.zldwlxdh }" maxlength="18"
			    			data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">租赁单位法人：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zldwfrdbxm" name="zldwfrdbxm" style="width:200px;" value="${entity.zldwfrdbxm }"
							data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>