<%@page import="com.founder.framework.config.SystemConfig"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.founder.framework.utils.DateUtils" %>
<%
String contextPath = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";

String systemDate = DateUtils.getSystemDateString();
String systemDateTime = DateUtils.getSystemDateTimeString();
%>
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
var basePath = "<%=basePath%>";
</script>

<!-- EasyUI 1.3.6 扩展 -->
<script type="text/javascript" src="<%=contextPath%>/common/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/json2.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/tools.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery1.11.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.form.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.panel.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.combo.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.combobox.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.combotree.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.window.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.tooltip.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.messager.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.easyui.extend.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.easyui.extend.validatebox.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/business.tools.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/workflow.tools.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/datagrid-detailview.js"></script>

<!-- 公共部分 --> 
<!-- 
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/common.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/ccsSearch.js"></script>
-->
<script type="text/javascript" src="<%=contextPath%>/js/tools/loadmask/jquery.loadmask.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/tools/toolsAjax/frameMain.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/appParameter.js"></script>

<!-- 样式部分 -->
<!-- 
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/js/libs/easyui/easyui.css" />
-->
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/js/tools/loadmask/jquery.loadmask.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/jeasyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/jeasyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/jeasyui/themes/custom.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/syrk.css"></link>
<!-- 
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/reeasyui.css" />
-->

<script type="text/javascript">
var systemDate = "<%=systemDate%>";
var systemDateTime = "<%=systemDateTime%>";
var MOS_SOCKET_IP 	= "<%=SystemConfig.getString("websocket.ip")%>";
var MOS_SOCKET_SERVER_PROT = "<%=SystemConfig.getString("websocket.serverprot")%>";
var jwzhMap = "<%=SystemConfig.getString("map")%>";
var centerZbx = "<%=SystemConfig.getString("centerZbx")%>";
var centerZby = "<%=SystemConfig.getString("centerZby")%>";
var minx = "<%=SystemConfig.getString("minx")%>";
var miny = "<%=SystemConfig.getString("miny")%>";
var maxx = "<%=SystemConfig.getString("maxx")%>";
var maxy = "<%=SystemConfig.getString("maxy")%>";
</script>