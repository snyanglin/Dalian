/**
 * 警情辖区选择触发
 * 
 *
 * require jQuery
 * require dictionary
 * require GeoQuery
 */

var Jqxq={
	/**
	 * 是否点击辖区
	 */
	isClickXq : false,
	/**
	 * 辖区
	 */
	xqpolygon:[],
	checkXqPolygon:{},
	/**
	 * 初始化
	 */
	init:function(){
		//var zzjgdm = SysConfig.T_USER_LOGIN_ORGID_ZD;
		var zzjgdm = ywjgdm;
		Dictionary.initDictTree({url: "dictionary/getOrganizationDictTreeJSON.f", zdbh: "D_ORG1", zdmc: "组织机构", zzjgdm: zzjgdm, auth: "", dictDataDivId: "jqxq_data_Div"}, function() {
			Dictionary.beforeCreateDictTree({createCount: 1, zdbh: "D_ORG1", treeData: data_D_ORG1, dictDataDivId: "jqxq_data_Div"});
			Dictionary.createDictTree({dictObject: D_ORG1, treeData: data_D_ORG1_1, isLeaf: false, dictHiddenId: "jqksxq_dm", dictShowId: "jqxq_mc",initVal: zzjgdm, "dictContainerReferenceObjectId": "portal_zzjg" ,useCheckbox:true}, function() {
				$("#jqxq_mcDiv").width($("#index_xqDiv").width() - 60);
				$("#jqxq_mcDiv").height($("#jqxq_mcDiv").height() * 2);
			});
		});
//       $("#show_hide_xq").bind("click",function(){
//    	   Jqxq.show_hide_xq();
//       });
	},
	/**
	 * 选择组织机构触发函数
	 */
	triggerFunc:function(){
		var dwdm=$("#jqxq_dm").val();
//		if($("#show_hide_xq").hasClass("btn_xqtog")){
//			Jqxq.hide_xq();
//			Jqxq.show_xq();
//		};
		//Jqxq.isClickXq = true;// 是否点击辖区

//		if ("#71c8ff" == $("#jrjq").css('color'))
//		{
//			Jrjq.countZzjgdm = dwdm;
//			Jrjq.initFun();
//		}

	},
	/**
	 * 显示或隐藏辖区
	 */
	show_hide_xq:function(){
			if(!$("#show_hide_xq").hasClass("btn_xqtog")){
				Jqxq.xqpolygon=[];
				Jqxq.show_xq();
			}else{
				Jqxq.hide_xq();
				
			}
			$("#show_hide_xq").toggleClass("btn_xqtog");
	},
	/**
	 * 显示辖区
	 */
	show_xq:function(){
		GeoQuery.getOrganizationBoundaryCoordinates($("#jqxq_dm").val(), function(boundaryCoordinates){			
			if(boundaryCoordinates!=""&& typeof boundaryCoordinates!="undefined"){
				var pPolygon=new Polygon(boundaryCoordinates,"#ff00FF", 3,0.5,"blue");
				_MapApp.addOverlay(pPolygon);
				Jqxq.xqpolygon.push(pPolygon);
			}else{
				SysTool.alert("该辖区边界未采集");
			}
			
		});
	},
	/**
	 * 清除辖区
	 */
	hide_xq:function(){
		for(var i=0;i<Jqxq.xqpolygon.length;i++){
			_MapApp.removeOverlay(Jqxq.xqpolygon[i]);
		};
		Jqxq.xqpolygon=[];
	},
	/**
	 * 切换各种警情状态后，如果有辖区，保留辖区
	 */
	keep_xq:function(){
		if(Jqxq.xqpolygon.length>0){
			for(var i=0;i<Jqxq.xqpolygon.length;i++){
				Jqxq.xqpolygon[i].setFillColor("blue");
				Jqxq.xqpolygon[i].setColor("#ff00FF");
				_MapApp.addOverlay(Jqxq.xqpolygon[i]);
			};
		}
	},
	/**
	 * 地图增加辖区显示
	 * @param 辖区代码
	 * @param boundaryCoordinates 边界坐标
	 */
	add_xq:function(xqdm,boundaryCoordinates){
		if(boundaryCoordinates!=""&& typeof boundaryCoordinates!="undefined"){
			var pPolygon=new Polygon(boundaryCoordinates,"#ff00FF", 3,0.5,"blue");
			_MapApp.addOverlay(pPolygon);
			Jqxq.checkXqPolygon[xqdm]=pPolygon;
			Jqxq.xqpolygon.push(pPolygon);//保留时使用
		}
	},
	/**
	 * 根据辖区代码清除相应辖区
	 * @param xqdm
	 */
	remove_xq:function(xqdm){
		_MapApp.removeOverlay(Jqxq.checkXqPolygon[xqdm]);
		var index=$.inArray(Jqxq.checkXqPolygon[xqdm],Jqxq.xqpolygon);//删除数组里已删除的辖区
		Jqxq.xqpolygon.splice(index, 1);
		delete Jqxq.checkXqPolygon[xqdm];
	}
};