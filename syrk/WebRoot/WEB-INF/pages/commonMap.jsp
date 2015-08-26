<!-- 地图基本参数 -->
<script type="text/javascript">
    //地图EzServer服务路径
	var ezMapServer = "<%=SystemConfig.getString("EzMap")%>";
	//地图中心坐标点X,Y
	var centerAtLatLng = "<%=SystemConfig.getString("centerAtLatLng")%>";
	//地图全图范围（最小坐标X,Y最大坐标X,Y）
	var centerAtMBR = "<%=SystemConfig.getString("centerAtMBR")%>";
	//地图初始化级别、最大显示级别、级别偏移量
	var mapInitMaxZoom = "<%=SystemConfig.getString("mapInitMaxZoom")%>";
</script>
<script type="text/javascript" src="<%=SystemConfig.getString("ezServerClientUrl")%>/js/EzMapAPI.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/tools/map/map.js"></script>