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
					parent.frames["main_center"].$("#ywlbdm").val(node.py);
					var sydwlx = node.id.replace("_"+node.py,"");
					parent.frames["main_center"].$("#sydwlx").val(sydwlx);
					parent.frames["main_center"].$("#sydwlx-box").combotree("setValue",node.id);
					parent.frames["main_center"].queryButton();
				}else{
					var obj = parent.frames.document.getElementById("main_center").contentWindow;
					obj.$("#ywlbdm").val(node.py);
					var sydwlx = node.id.replace("_"+node.py,"");
					obj.$("#sydwlx").val(sydwlx);
					obj.$("#sydwlx-box").combotree("setValue",node.id);
					obj.queryButton();
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
            <div data-options="region:'center',split:true,title:'单位类型',border:false" style="height:auto">
				<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="bodyTd" valign="top">
							<div style="z-index: 15; overflow-y: auto;height: 100%;">
								<table  border="0" cellpadding="0" cellspacing="0" align="center" style="top: 0;width: 100%;">
									<tbody>
										<tr>
											<td nowrap id="menuTd" style="padding-left: 2px; padding-right: 2px;">
												<ul  class="easyui-tree" id="menuTree" data-options="url: contextPath + '/common/dict/BD_D_MDWLXDM.js',method:'get',lines:true"></ul>
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

