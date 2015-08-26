<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 上午8:51:54]
	@updateAuthor: [star]
	@updateDate:   [2015-6-4 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/sydwfjEdit.js"></script>
<html>
<head>
<title>附件管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/zpfjFjxxb/queryList',toolbar:'#datagridToolbar',rownumbers:true,
            		border:false,selectOnCheck:false,sortName:'xt_cjsj',sortOrder:'asc',idField:'id',pageSize:10,queryParams:{lybm:'${lybm}',lyid:'${lyid}'}">
				    <thead>
				        <tr>
				            <th data-options="field:'wjhzlx',width:10,align:'center',halign:'center',sortable:true">附件类型</th>
				            <th data-options="field:'wjmc',width:30,align:'left',halign:'center',sortable:true">附件名称</th>
				            <th data-options="field:'wjdx',width:10,align:'right',halign:'center',sortable:true">附件字节</th>
				            <th data-options="field:'wjdxsm',width:10,align:'center',halign:'center'">附件大小</th>
				            <th data-options="field:'wjxzcs',width:10,align:'center',halign:'center',sortable:true">下载次数</th>
				            <th data-options="field:'process',width:10,align:'center',halign:'center',formatter:processFormater">下载</th>
				        </tr>
				    </thead>
				</table>
				
				<div id="datagridToolbar" style="padding: 0px; height: 150px; width: 100%; vertical-align: top;">
					<form name="dataform" action="<%=basePath%>zpfjFjxxb/save" method="post" enctype="multipart/form-data">
						<input type='hidden' name='lybm' value="${lybm}"/>
						<input type='hidden' name='lyid' value="${lyid}"/>
						<input type='hidden' name='lyms' value="${lyms}"/>
						<input type='hidden' name='fileOnly' id='fileOnly' value="${fileOnly}"/>
	          			<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tbody>
								<tr>
									<td width="20%" align="right" valign="top" class="dialogTd" style="padding-top: 13px; padding-right: 20px;">新上传的附件：
										<br/><br/>
										<input type="button" id="upload_add_but" value="增加一个附件" onclick="upload_add()" style="font: 9pt 宋体; color: #034277; background-color: #CDE1F9; border: #2E81E7 1px solid; height: 20px; width: 100px; cursor: pointer;">
									</td>
									<td width="80%" class="dialogTd" valign="top">
										<div style="overflow-y: auto; vertical-align: top; width: 100%; height: 150;" id="uploadDiv">
											<table border="0" cellpadding="0" cellspacing="0" width="100%" id="uploadTable">
								              	<tr>
								                 	<td height="30" class="dialogTd">01、<input type="file" name="uploadFile" id="upload1" style="width:560px;" class="easyui-validatebox" data-options="tipPosition:'left',invalidMessage:'请选择图片格式的文件！'" /></td></td>
								              	</tr>
							              	</table>
						              	</div>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
        </div>
    </div>   
    
    <div style="display:none;">
	    <form name="downloadform" id="downloadform" action="<%=basePath%>zpfjFjxxb/download" target="submitFrame" method="post">
	    	<input type="hidden" name="id" id="downloadID"/>
	    </form>
	</div>
	<iframe name="submitFrame" id="submitFrame" src="" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" width="0" height="0" style="z_index: 60; display:none;"></iframe>
	
</body>

<script type="text/javascript">
var fileType = "${fileType}";
</script>  

</html>