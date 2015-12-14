<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@ include file="/WEB-INF/pages/gpsControl.html"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    String id = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
        id = ""+userInfo.getUserOrgId();
    }
 %>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    var userOrgCode = "<%=userOrgCode%>"; 
    var userOrgName = "<%=userOrgName%>";
    var bjzbz = "<%=bjzbz%>";
    var id = "<%=id%>";
    
   	var openFlag = false;//地图是否放大
    function bs(){
    	if(openFlag == false){
    	    //$("#lay").layout("collapse","west");
    		$("#up").css("height","650px");
    	    $("#down").css("height","1");
    	    //bigger
    	    openFlag = true;
    	}else if(openFlag == true){
    	    //$("#lay").layout("expand","west");
    		$("#up").css("height","450px");
    	    $("#down").css("height","250px");
    		openFlag = false;
    	}
    };
    
</script>
</HEAD>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
		<div style="width: 100%; height: 80%; ">
            <ul id="tree" class="easyui-tree"></ul>      
	    </div>
	    <center style="padding-top: 0px;">
	    <hr>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" 
			    iconCls="icon-search" onclick="selOrg();">确定</a>
			&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton" 
			 	iconCls="icon-reload" onclick="clearPoints();">移除</a>
	    </center>
    </div>
</body>
<script type="text/javascript">
	<!--
	$(function(){
		createTree();
	});
	
	function clearPoints(){
		javascript: parent.frames.document.getElementById('biz_center').contentWindow.XjMap.removeMark();
	}
	
	function createTree(){
		$("#tree").tree({
			url : "<%=basePath%>homePage/jsonTree?id=" + id + "&orgcode=" + userOrgCode,
			method: 'GET',
			animate: true,
			checkbox: true,
			lines: true,
			cache: false,
			onBeforeExpand: function(node){
				if(node){
					$('#tree').tree('options').url = "<%=basePath%>homePage/jsonTree?id=" + node.id + "&orgcode=" + userOrgCode;
				}
			}
		});
	}
	
	function selOrg(){
		clearPoints();
		var node = $("#tree").tree("getChecked");
		var temp = "";
		pnodes = "";
		for(var i=0; i<node.length; i++){
			if($("#tree").tree("isLeaf", node[i].target)){
				var root = $("#tree").tree("getRoot", node[i].target);
				var pnode = $("#tree").tree("getParent", node[i].target);
				if(pnode.checked){
					if(pnode.orgcode==root.orgcode && temp!=node[i].orgcode){
						pnodes += node[i].orgcode + ",";
						temp = node[i].orgcode;
					} else if(temp != pnode.orgcode){
						pnodes += pnode.orgcode + ",";
						temp = node[i].orgcode;
					}
				} else if(temp!=node[i].orgcode){
					pnodes += node[i].orgcode + ",";
					temp = node[i].orgcode;
				}
			}
		}
		pnodes = pnodes.substring(0, pnodes.length-1);
		//window.parent.zdParm(pnodes, 'tree');
		//document.getElementById("biz_center").src = "<%=contextPath%>/forward/sqjw|xjhomePcs?orgcodes=" + pnodes;
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.XjMap.queryXjZzjg(pnodes);
	}
	
	-->
</script>

</HTML>