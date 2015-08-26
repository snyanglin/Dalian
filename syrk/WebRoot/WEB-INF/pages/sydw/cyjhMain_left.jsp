<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-6 上午8:51:54]
-->
<%@page pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" >
var data = [{"id":"01","text":"单位抽样计划","url":contextPath + "/cyjh/queryXfdwlxByJbdwlb"},{"id":"02","text":"本人检查任务","url":contextPath + "/forward/sydw|dwcyjcrwMain"},{"id":"03","text":"单位检查记录","url":contextPath + "/forward/sydw|rcjcMain"}];
(function ($) {
	var defaults = $.extend({}, $.fn.tree.defaults, {
		onClick: function(node) { // 点击结点事件
			var opts = $(this).tree('options');
			if (node.children) { // 增加只能选叶子结点时点击中间结点自动展开与折叠当前结点
				if (node.state == 'closed') {
					$(this).tree('expand', node.target);
				}else {
					$(this).tree('collapse', node.target);
				}
			}else {
				if (IE) {
					parent.frames["main_center"].location.href = node.url;
				}else{
					var obj = parent.frames.document.getElementById("main_center").contentWindow;
					obj.location.href = node.url;
				}
			}
		},
		
		onExpand: function(node) { // 展开结点事件
		},
		
		onCollapse: function(node) { // 折叠结点事件
		},
		
		onContextMenu: function(e, node) { // 鼠标右键事件
			e.preventDefault();
		}
	
	});

	$.extend($.fn.tree.defaults, defaults);

})(jQuery); 
</script>
</HEAD>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'抽样检查',border:false" style="height:auto">
				<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="bodyTd" valign="top">
							<div style="z-index: 15; overflow-y: auto;height: 100%;">
								<table  border="0" cellpadding="0" cellspacing="0" align="center" style="top: 0;width: 100%;">
									<tbody>
										<tr>
											<td nowrap id="menuTd" style="padding-left: 2px; padding-right: 2px;">
												<ul  class="easyui-tree" id="menuTree" data-options="data:data,method:'get',lines:true"></ul>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div>
        </div>
    </div>  
</BODY>
</HTML>