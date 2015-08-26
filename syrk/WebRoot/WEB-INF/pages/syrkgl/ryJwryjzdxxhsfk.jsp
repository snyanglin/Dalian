<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>境外人员居住地信息核实反馈</title>
    <script type="text/javascript">
       //设置只读属性
       function readonly(){
    	   setInputReadonly("paperType", true);
    	   setInputReadonly("gender", true);
    	   setInputReadonly("nationality", true);
    	   setInputReadonly("resideReason", true);
       };
    </script>
  </head>
  <body class="easyui-layout" data-options="fit:true" onload="readonly();">
      <form action="<%=basePath%>jwrybzxxhs/reporteInhabitancyInfo" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="personNO" value="${jbxx.personNO}" />
    	<input type="hidden" name="inhabiBusinessNO" value="${jbxx.inhabiBusinessNO}" />
    	<input type="hidden" name="dataSource" value="${jzdxx.dataSource}" />
    	<input type="hidden" name="inhabiResidence" value="${jzdxx.inhabiResidence}" />
    	<input type="hidden" name="inhabiPoliceStation" value="${jzdxx.inhabiPoliceStation}" />
    	<input type="hidden" name="archiveUnit" value="${jzdxx.archiveUnit}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
	      	<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	      	    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class="easyui-combobox" type="text" id="paperType" value="${jbxx.paperType}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_JWRY_CRJ_ZJZLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">证件号码：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.paperNO}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">英文姓：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.surnameEN}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">英文名：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.firstnameEN}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">中文姓名：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.nameCH}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">性别：</td>
		            <td width="30%" class="dialogTd">
		                <input class="easyui-combobox" type="text" id="gender" value="${jbxx.gender}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_JWRY_CRJ_XBB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.birthday}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">国籍/地区：</td>
		            <td width="30%" class="dialogTd">
		                <input class="easyui-combobox" type="text" id="nationality" value="${jbxx.nationality}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_JWRY_GJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件签发日期：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.signDay}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">证件有效期：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.expiredDay}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">居留事由：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class="easyui-combobox" type="text" id="resideReason" value="${jbxx.resideReason}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_JWRY_JLSY.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">居留证许可号码：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.residePermitNO}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">居留许可发证日期：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.residePermitAssignDay}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">居留许可有效期至：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.residePermitExpiredDay}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">签证停留有效期：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.localizePeriod}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">常住人员联系电话：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.resideContactTel}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">采集时间：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly"  type='text' value="${jbxx.reportTime}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">采集单位名称：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox inputreadonly' readonly="readonly"  type='text' value="${jbxx.reportOrgName}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">采集人：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.reportTime}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">数据到达日期：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' value="${jbxx.sjddrq}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			        <td width="20%" class="dialogTd" align="right">居住状态类型：</td>
		            <td width="80%" class="dialogTd" colspan="3">
		            	<input class="easyui-combobox" type="text" id="inhabiState" name="inhabiState" value="${jzdxx.inhabiState}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_JWRY_JZZTLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">居住地详细地址：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	    <input class='easyui-validatebox inputreadonly' readonly="readonly" type='text' name="inhabiDetailAddr" value="${jzdxx.inhabiDetailAddr}" style="width:100%;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主姓名：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox' type='text' name="houseOwner" value="${jzdxx.houseOwner}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">房主性别：</td>
		            <td width="30%" class="dialogTd">
		            	<input class="easyui-combobox" type="text" name="gender" value="${jzdxx.gender}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_JWRY_CRJ_XBB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox' type='text' name="paperNo" value="${jzdxx.paperNo}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">房主工作单位：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox' type='text' name="workplace" value="${jzdxx.workplace}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
			    	<td width="30%" class="dialogTd">
			    	    <input class='easyui-validatebox' type='text' name="tel" value="${jzdxx.tel}" style="width:200px;float:left;"/>
			    	</td>
				    <td width="20%" class="dialogTd" align="right">房屋性质：</td>
		            <td width="30%" class="dialogTd">
		            	<input class='easyui-validatebox' type='text' name="houseType" value="${jzdxx.houseType}" style="width:200px;float:left;"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    		<textarea name="remarks" class="easyui-validatebox" style="width: 100%; height:48px;overflow: auto;"
							data-options="validType:['maxLength[250]'],invalidMessage:'备注不能超过250个汉字，请重新输入！',tipPosition:'right'">${jwry.remarks}</textarea>
					</td>
			    </tr>
	      	</table>
	    </div>
	  </form>
  </body>
</html>