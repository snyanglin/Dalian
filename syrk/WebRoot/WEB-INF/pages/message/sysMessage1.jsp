<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
	String userOrgCode = "";
	String userID = "";
	if(userInfo != null){
		userID = userInfo.getUserId();
		userOrgCode = userInfo.getUserOrgCode();
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>系统消息</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/sysMessage/queryList?xxlb=1',toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,checkOnSelect:true,border:false,
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<!-- <th data-options="checkbox:true,align:'center',halign:'center'"></th> -->
				            <th data-options="field:'xxlb',width:10,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_SYS_XXLB.js'">信息类别</th>
				            <th data-options="field:'xxnr',width:80,align:'left',halign:'center',sortable:true,formatter:process">消息内容</th>
				            <th data-options="field:'sfck',width:10,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_SF.js'">是否查看</th>
				            <th data-options="field:'cksj',width:20,align:'center',halign:'center',sortable:true">查看时间</th>
				            <th data-options="field:'fssj',width:20,align:'center',halign:'center',sortable:true">发送时间</th>
				            <th data-options="field:'fsr',width:10,align:'center',halign:'center',sortable:true">发送人</th>
				            <th data-options="field:'fsrssdw',width:20,align:'left',halign:'center',sortable:true">发送人单位</th>
				            <th data-options="field:'jsr',width:10,align:'center',halign:'center',sortable:true">接收人</th>
				            <th data-options="field:'jsrssdw',width:20,align:'left',halign:'center',sortable:true">接收人单位</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
					<tr>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="datagridQuery(this, 'queryWindow', 
					    		null,
					    		{
					    		title: '系统消息查询条件',
					    		url: contextPath + '/sysMessage/query',
					    		width: 850,
					    		height: 320
					    		})">查询</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<!-- <td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="datagridAdd(this, 'addWindow', 
					    		null,
					    		{
					    		title: '系统参数新增',
					    		url: contextPath + '/sysMessage/add',
					    		width: 850,
					    		height: 320
					    		},
   								'您是否要保存数据？'
					    		)">添加</a>
						</td> 
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
					    		'csmc',
					    		{
					    		url: contextPath + '/sysMessage/view'
					    		})">批量查看</a>
						</td>-->
					</tr>
					</tbody>
					</table>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">
var userOrgCode = "<%=userOrgCode%>";
function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;';
}

function process(val, row, index) { // 自定义操作生成
    if(row.xxlb == '3' || row.xxlb == '4'){
       if(row.bool ==0){
          return "&nbsp;<a class='link' href='javascript:javascript:void(0)' onclick='title_onclick2("+row.id+",\""+row.ywurl+"\")'>"+row.xxnr+"</a>&nbsp";
       }else{
          return "&nbsp;<a class='link' href='javascript:javascript:void(0)' onclick='hrefUrl("+row.id+",\""+row.ywurl+"\")'>"+row.xxnr+"</a>&nbsp";
       }
       
    }else if(row.xxlb == '2'){
        return "&nbsp;<a class='link' href='javascript:javascript:void(0)' onclick='title_onclick("+row.id+",\""+row.ywurl+"\",\""+row.xxbt+"\")'>"+row.xxnr+"</a>&nbsp";
    }else{
       return row.xxnr;
    }
}
//弹出窗口打开!
function title_onclick2(xxID,str) {
	//先更新查看状态;
	updateTzggZt(xxID);
	var strArray =new Array;
	if(str.indexOf("?")>0){
		strArray = str.split("?");
		var url = '<%=contextPath %>' +"/tzgg/tzggInfo?id="+strArray[0]+"&mode=inFo&xxID="+xxID;
		window.open(url,'通知公告',"");
	}else{
		var url = '<%=contextPath %>' +"/tzgg/tzggInfo?id="+str+"&mode=inFo&xxID="+xxID;
		window.open(url,'通知公告',"");
	}
}
function hrefUrl(xxID,url){
	//先更新查看状态;
	updateTzggZt(xxID);
	window.open(url,'通知公告',"");
}
//ajax修改查看消息的状态
function updateTzggZt(xxid){
    $.ajax({
       type:"POST",
       url :contextPath+"/tzgg/view",
       data:{id:xxid},
       dataType:'json',
       success:function(data){
    	   
       }
    });
}
//ajax修改消息状态
function editMsgStar(xxid){
    $.ajax({
       type:"POST",
       url :"<%=basePath%>sysMessage/update",
       data:{id:xxid},
       dataType:"json",
       success:function(data){
       }
    });
}
function title_onclick(xxID, ywurl,xxbt) {
  editMsgStar(xxID);
  if(null != ywurl && "" != ywurl){
     menu_open(xxbt, "/"+ywurl);
  }else{
     window.top.openWindow(false,'', '<%=contextPath %>' +"/sysMessage/view?id="+xxID, {document: document}, {title: '消息信息',    
	    width: 850,   
	    height: 420,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true});
  }
}
// 行单击
function doOnClickRow(rowIndex, rowData) {
	var editUrl = contextPath + '/sysMessage/edit';
	var opts = $(this).datagrid('options');
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(opts.id, 'editWindow', 
   		null,
  		{
   		title: '消息列表',
   		url: editUrl,
   		maximizable: true,
   		width: 850,
   		height: 320
   		}
   	);
}

// 修改单条
function doView(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/sysMessage/view';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(datagrid_ID, 'editWindow', 
   		null,
  		{
   		title: '消息信息',
   		url: editUrl,
   		width: 850,
   		height: 320
   		},
   		'您是否要保存数据？',
   		rowData.xxbt,
   		rowData.ywurl,
   		rowData.id
   	);
}

// datagrid 修改
// 默认在本页面中弹出，不缓存页面
// paramArray 可以传入参数（如：{document:document, param1: 'test1', param2: 2}）
// dataOptions jquery.window中的data-options定义参数
// submitConfirm 提交确认提示信息（为空则不出现确认框）
// xxbt 消息标题（用于处理【标准地址维护】判断）
function datagridEdit(datagrid_ID, windowID, paramArray, dataOptions, submitConfirm,xxbt,ywurl,id) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	dataOptions.datagrid_ID = datagrid_ID;
	if (!dataOptions.title) {
		dataOptions.title = '修改';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "editWindow";
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	if(xxbt=="标准地址维护"){
		var zbz = ywurl.split(",");
		if(userOrgCode.substring(8, 12)!="0000"){
			if(zbz[5]=="1"){
				if(zbz[0]==null||zbz[0]==""){
					dataOptions.buttons = [{
           				text: '实有单位编辑',
           				iconCls: 'icon-home',
           				handler: function(){
           					window.top.$('#' + windowID).dialog('close');
           					var editUrl = "/sydwgl/view?id="+zbz[1];
           					menu_open("实有单位编辑",editUrl);
           				}
           			},{
               			text: '地址定位',
               			iconCls: 'icon-biaodian',
               			handler: function(){
               				var url = contextPath+"/forward/map|mapBz?bz=2&title="+encodeURI(zbz[2])+"&zbx="+zbz[3]+"&zby="+zbz[4];
               				var paramArray = [];
               				openWindow(false, null, url, 
               			   		paramArray, 
               			   		{
               				   		title:"地址定位",
               				   		maximizable: false,
               				   		width: 850,	
               				   		height:560
               			   		}
               			   	);
               			}
               		}];
				}else{
					dataOptions.buttons = [{
           				text: '实有人口编辑',
           				iconCls: 'icon-user',
           				handler: function(){
           					window.top.$('#' + windowID).dialog('close');
           					var editUrl = "/syrkEdit/"+zbz[1]+"/"+zbz[0]+"/view";
           					menu_open("实有人口编辑",editUrl);
           				}
           			},{
               			text: '地址定位',
               			iconCls: 'icon-biaodian',
               			handler: function(){
               				var url = contextPath+"/forward/map|mapBz?bz=2&title="+encodeURI(zbz[2])+"&zbx="+zbz[3]+"&zby="+zbz[4];
               				var paramArray = [];
               				openWindow(false, null, url, 
               			   		paramArray, 
               			   		{
               				   		title:"地址定位",
               				   		maximizable: false,
               				   		width: 850,	
               				   		height:560
               			   		}
               			   	);
               			}
               		}];
				}
			}else{
				dataOptions.buttons = [
             			{
             				text: '转发至所长',
             				iconCls: 'icon-user',
             				handler: function(){
             					var editUrl = contextPath + "/sysMessage/viewReply?id="+id+"&hfbz=0";
             					openWindowWithSave(false, null,this.Window, 
             				   		{}, 
             				   		{
             						title:"转发至所长",
             				   		url: editUrl,
             				   		maximizable: false,
             				   		width: 380,	
                   				height:190
             				   		}, 
             				   		null, null
             					);
             				}
             			},
             			{
             				text: '回复',
             				iconCls: 'tree-leaf',
             				handler: function(){
             					var editUrl = contextPath + "/sysMessage/viewReply?id="+id+"&hfbz=1";
             					openWindowWithSave(false, null,this.Window, 
             				   		{}, 
             				   		{
             						title:"消息回复",
             				   		url: editUrl,
             				   		maximizable: false,
             				   		width: 380,	
                   				height:190
             				   		}, 
             				   		null, null
             					);
             				}
             			},
             			{
             				text: '打开地址管理',
             				iconCls: 'icon-home',
             				handler: function(){
             					window.top.$('#' + windowID).dialog('close');
              					menu_open('地址管理', "/forward/bzdz|dzManage|dzManage");
             				}
             			},
                 		{
                 			text: '地址定位',
                 			iconCls: 'icon-biaodian',
                 			handler: function(){
                 				var url = contextPath+"/forward/map|mapBz?bz=2&title="+encodeURI(zbz[2])+"&zbx="+zbz[3]+"&zby="+zbz[4];
                 				var paramArray = [];
                 				openWindow(false, null, url, 
                 			   		paramArray, 
                 			   		{
                 				   		title:"地址定位",
                 				   		maximizable: false,
                 				   		width: 850,	
                 				   		height:560
                 			   		}
                 			   	);
                 			}
                 		}
                 	];
			}
		}else{
			dataOptions.buttons = [
          			{
          				text: '转发至责任区',
          				iconCls: 'icon-user',
          				handler: function(){
          					var editUrl = contextPath + "/sysMessage/viewReply?id="+id+"&hfbz=2";
          					openWindowWithSave(false, null,this.Window, 
          				   		{}, 
          				   		{
          						title:"转发至责任区",
          				   		url: editUrl,
          				   		maximizable: false,
          				   		width:400,	
                				height:290
          				   		}, 
          				   		null, null
          					);
          				}
          			},
               		{
               			text: '地址定位',
               			iconCls: 'icon-biaodian',
               			handler: function(){
               				var url = contextPath+"/forward/map|mapBz?bz=2&title="+encodeURI(zbz[2])+"&zbx="+zbz[3]+"&zby="+zbz[4];
               				var paramArray = [];
               				openWindow(false, null, url, 
               			   		paramArray, 
               			   		{
               				   		title:"地址定位",
               				   		maximizable: false,
               				   		width: 850,	
               				   		height:560
               			   		}
               			   	);
               			}
               		}
               	];
		}
		
	}else{
		dataOptions.buttons = [
      		{
      			text: '上一条',
      			iconCls: 'icon-moveLeft',
      			handler: function() {
      				var bottonObject = this;
      				var iframeObject = window.frames[windowID + '_iframe'];
      				if (iframeObject.contentWindow) {
      					iframeObject = iframeObject.contentWindow;
      				}
      				iframeObject.viewPrev();
      			}
      		},
      		{
      			text: '下一条',
      			iconCls: 'icon-moveRight',
      			handler: function() {
      			   var iframeObject = window.frames[windowID + '_iframe'];
      				if (iframeObject.contentWindow) {
      					iframeObject = iframeObject.contentWindow;
      				}
      				iframeObject.viewNext();
      			}
      		}
      	];
	}
	openWindow(false, windowID, dataOptions.url, paramArray, dataOptions);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/sysMessage/delete';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = "csmc"; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要删除数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

</script>  

</html>