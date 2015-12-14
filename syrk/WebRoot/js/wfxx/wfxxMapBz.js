var ezMap = null;
var ezMbr = null;
var markerObj = null;
var pointArray = null;
document.oncontextmenu = shuBiaoYouji;
var zbx =  parent.document.getElementById("entity_zbx").value;
var zby =  parent.document.getElementById("entity_zby").value
/**
  * @title:loadMap
  * @description:加载地图
  * @param：加载边界、点击进入标点状态     
  * @date:2015-03-11 10:23:32
  */
 function loadMap(){
	 ezMap = new FrameTools.Map();
	 ezMap.setProxy(contextPath + "/Proxy");
	 ezMap.setMapDiv("mapDiv");
	 ezMap.onloadMap();
	 ezMap.addOverView();
	 ezMap._MapApp.hideMapServer();
	 ezMap.showNewMapServer("mapDiv","ezMap");
	 if(bjzbz!="" && bjzbz!='null'){
		 moveMapToBjzbz();
     }
	 if(bz!=2){
    	 ezMap._MapApp.addMapEventListener(EzEvent.MAP_CLICK,function(obj){moveMapToDrawPoint();});
    	 queryButton();
	 }
	 if(zbx!=""&&zby!=""){
		 initMarker();
	 }
  };  
 /**
   * @title:loadMapBd
   * @description:加载当前用户所属机构的边界
   * @param：bjzbz【边界坐标值】     
   * @date:2015-03-11 14:45:53
   */
 function moveMapToBjzbz(){
	 ezMap._MapApp.clear();
	 var bj = bjzbz.split(";");
	 var bjnum = bj.length;
	 for(var j=0;j<bjnum;j++){
		 var gArr = bj[j];
		 var polyline = ezMap.initPolyline(gArr,"blue");
		 if(polyline){
			 ezMap._MapApp.addOverlay(polyline);
			 if(ezMbr==null){
				 ezMbr = polyline.getMBR();
			 }else{
				 ezMbr = MBR.union(ezMbr,polyline.getMBR());
			 }
		 }
	 }
	 ezMap._MapApp.centerAtMBR(ezMbr);
	 ezMap._MapApp.zoomOut();
 };
 /**
   * @title:moveMapToDrawPoint
   * @description:点击进入地图标注状态
   * @param：    
   * @date:2015-03-11 14:52:21
   */
 function moveMapToDrawPoint(){
	 ezMap._MapApp.changeDragMode("drawPoint",null,null,function(obj){
	 
	     if(ezMap.PtInPolygon(obj, bjzbz)==false){
	     topMessagerShow(null,"超出辖区范围,请重新标注!");
	     return;
	     }
		 pointArray = obj.split(",");
		 if(markerObj!=null){
			 ezMap._MapApp.removeOverlay(markerObj);
		 }
		 markerObj = ezMap.initMarker("",pointArray[0],pointArray[1],"jzw2.png",null,null,43,37);
		 ezMap._MapApp.addOverlay(markerObj);       		   
		     //返回调用标点的页面【调用页面需要定义：entity_zbx、entity_zby】
    		 parent.document.getElementById("entity_zbx").value = pointArray[0];
			 parent.document.getElementById("entity_zby").value = pointArray[1];
			topMessager.confirm('操作确认', '您是否保存坐标？',  function(r) {
		     if (r) {
		     //只能在上级页面关闭弹出页面			
				parent.closeMap();
			}
		});        		 
	 });
 };
 
 
 /**
   * @title:moveMapToDrawPoint_back
   * @description:标点_回调函数
   * @param：    
   * @date:2015-03-11 19:56:11
   */
 function moveMapToDrawPoint_back(json){
	 if(json){
		 var message = ""
		 if(json.pcsdm==null||json.pcsdm==""){
			 message = "该坐标点暂无所属责任区、派出所信息，<br><br>请重新标注！";
		 }else{
			 parent.document.getElementById("dzms_sszrqdm").value = json.zrqdm;
			 parent.document.getElementById("dzms_sszrqmc").value = json.zrqmc;
    		 parent.document.getElementById("dzms_sspcsdm").value = json.pcsdm;
			 parent.document.getElementById("dzms_sspcsmc").value = json.pcsmc;
			 //返回调用标点的页面【调用页面需要定义：entity_zbx、entity_zby】
    		 parent.document.getElementById("entity_zbx").value = pointArray[0];
			 parent.document.getElementById("entity_zby").value = pointArray[1];
			 message = "所属责任区："+json.zrqmc+"<br><br>所属派出所："+json.pcsmc;
		 }
		 topMessager.show({
			title: MESSAGER_TITLE,
			msg: message,
			timeout:3500
		 });
		 $(document.body).unmask();
	 }
 };
 /**
   * @title:shuBiaoYouji
   * @description:右键退出标注模式
   * @param：pan【地图漫游模式】    
   * @date:2015-03-11 15:05:24
   */
 function shuBiaoYouji(){
	 ezMap._MapApp.changeDragMode("pan", null, null, null);
	
 };
 /**
   * @title:queryButton
   * @description:加载标点按钮
   * @param：    
   * @date:2015-03-11 15:11:32
   */
 function queryButton(){
	 var html = "<div style='position:absolute;right:8px;top:80px;width:40px;'>" +
                "<img id='img2' onclick='moveMapToDrawPoint()' style='cursor:hand;' title='点编辑模式' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
                "</div>";
	 $("#mapDiv").append(html);
 };
 /**
   * @title:initMarker
   * @description:坐标X、坐标Y不为空情况下展现已标点
   * @param：    
   * @date:2015-03-11 20:29:56
   */
 function initMarker(){
	 var point = new Point(zbx,zby);
	 //star 判断标准地址坐标是否在辖区内
	 if(ezMap.PtInPolygon(obj, bjzbz)==false){
	     topMessagerShow(null,"超出辖区范围,请重新标注!");
	     return;
	     }
	 //end
	 markerObj = ezMap.initMarker(title,zbx,zby,"jzw2.png",null,null,43,37);
	 ezMap._MapApp.addOverlay(markerObj);
	 ezMap._MapApp.centerAtLatLng(point);
 };