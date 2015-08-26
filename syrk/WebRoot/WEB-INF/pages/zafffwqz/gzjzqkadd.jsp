<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
/******************************************************************************
 * @JSPName:      [gzjzqkAdd.jsp]   
 * @Description:  [矛盾-跟踪进展添加页面]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-06-03]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-06-03(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>跟踪进展情况新增</title>
	</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>gzjzqkzb/saveGzjzqkzb" id="dataForm" name="dataForm" method="post">
					<input type="hidden" name="mdjfxxid" id="mdjfxxid" value="${entity.mdjfxxid}" />
	    		<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
					<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
							<input type="hidden" id="pk" name="id" value="${entity.id}" />
							<tr class="dialogTr">
								<td width="20%" class="dialogTd" align="right">跟踪进展人：</td>
								<td width="30%" class="dialogTd">
									<input  type="text" id="gzjzr" name="gzjzr" class="easyui-validatebox" style="width:200px;"maxlength="50" value="${entity.gzjzr}" /></td>
								<td width="20%" class="dialogTd" align="right">跟踪进展时间：</td>
								<td width="30%" class="dialogTd">
									<input  type="text" id="gzjzsj" name="gzjzsj" class="easyui-validatebox" style="width:200px;"maxlength="19" value="${entity.gzjzsj}" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
											data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"/></td>
							</tr>
							<tr class="dialogTr">
								<td width="20%" class="dialogTd" align="right">进展情况描述：</td>
								<td width="30%" class="dialogTd">
									<input  type="text" id="jzqkms" name="jzqkms" class="easyui-validatebox" style="width:200px;"
											data-options="required:false,tipPosition:'right'" maxlength="200" value="${entity.jzqkms}" /></td>
								<td width="20%" class="dialogTd" align="right">调解结果：</td>
								<td width="30%" class="dialogTd">
									<input type="text" name="tjjgdm" id="tjjgdm" value="${entity.tjjgdm}" class="easyui-combobox " style="width:200px;"
											data-options="required:true,url: contextPath + '/common/dict/D_FWQZ_TJJG.js',
											valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'" /></td>
							</tr>
							<tr class="dialogTr">
								<td width="20%" class="dialogTd" align="right">备注：</td>
	       						<td width="80%" class="dialogTd" colspan="3" >
	       							<textarea id="bz" name="bz" class="easyui-validatebox" style="width: 613px; height:48px;"
											data-options="validType:['maxLength[1000]'],
											invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</body>
</html>
<<script type="text/javascript">
//保存跟踪进展后，执行此函数刷新内容
function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	parent.gzjzqkList();	
}
</script>

