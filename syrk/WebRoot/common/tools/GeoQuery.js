/*!
 * 地理信息空间查询组件
 * @require sysconfig.js
 * GeoQuery - v1.0.0 (2014-03-12 09:30)
 * Copyright(c) 2014 founder
 */

if (ezbuilderAPI === undefined|| typeof EzMap =="undefined"||typeof SysConfig=="undefined") {
	SysTool.alert("GeoQuery.js所需组件未引入");
}else{
	ezbuilderAPIAjax.setClientUrl(SysConfig.EZBUILDER_CLIENT_URL);//客户端url地址
}

/**
 * @classDescription 地理信息查询全局对象
 * @author pan
 */
var GeoQuery={
	/**
	 * {Array}  结果集 
	 * {Object} resultSet 单个图层结果以对象封装
	 * {String} id 图层名称
	 * {String} result 结果集是json字符串
	 * {String} store 数据库用户名
	 * [{id:"",result:"",store:""}]
	 */
	resultSet:[],
	/**
	 * 弹出气泡框marker详细信息内容，用于扩展功能的信息提取 形式如：[{"fieldName:mc","fieldValue":value}]
	 */
	marker_info:[],
	marker_count:"",
	/**
	 * 加载更多信息
	 */
	more_data_info:[],
	/**
	 * 所有的叠加对象
	 */
	allOverlays:[],
	/**
	 * 图片title
	 */
	img_title:"",
	/**
	 * 详细信息显示等级
	 */
	xxinfo_level:3,
	/**
	 * 详细信息显示的字段
	 */
	xxinfo_field:[],
	/**
	 * 每个图层叠加对象单独存放[{"VIDEO_PT":[markers]}]
	 */
	eachOverlays:[],
	currentImageAlias:[],
	/**
	 * 空间数据空间查询
	 * @param {Object} options   参数对象
	 * options参数说明
	 * {Array(String)} tablename 查询图层的表名,单个图层查询可以简写为{String}如："video_pt" 
	 * {String} gisusername 图层所在数据库用户，SysConfig里
	 * {Array(String)} layertype 查询图层类型如：point,polyline,polygon,图层类型顺序须与图层表名一一对应，如果多个图层为一种类型可简写为{String}如："point" 
	 * {String} primaryfield 初始查询图层id,默认为"OBJECTID"
	 * {String} subFields 查询图层其余字段,格式为"mc:mc", 可以定义别名如"mc:名称",默认为""
	 * {String} coords 空间查询的坐标串如"x,y,x,y",圆形较特殊"x,y,r"
	 * {String} featurelimit 查询返回结果限制,默认返回全部结果
	 * {String}	beginrecord 查询开始条数,默认为"1"
	 * {Array(String)} nameField 查询中文字段，该内容顺序须与图层名一一对应，如多个图层为同一字段可以简写为{String}如"mc"
	 * {String} orderByClause 排序条件字段，默认为objectid
	 * {String} where 该属性可以将空间查询与属性查询结合，默认为"1=1",无属性限制
	 * {Array(String)} x 图层x坐标字段名,与图层名一一对应,默认为zbx
	 * {Array(String)} y 图层y坐标字段名,与图层名一一对应,默认为zby
	 * {String} mapserviceurl mapService地址
	 * {Boolean} iscluster 聚合功能，默认为true
	 * {Number} mapWidth 地图的宽度值
	 * {String} extent 地图视野坐标串
	 * {Number} distance 聚合的像素值，默认为30
	 * {String} querytype 查询类型 "extent":框查，"circle":圆查，"polygon":多边形查询
	 * @param {Function} callback 回调函数
	 */
	spatialQuery:function(options,callback){
		//MapBubble.closeBubble();
			//ezbuilderAPIAjax.setClientUrl(SysConfig.EZBUILDER_CLIENT_URL);
			var i=arguments[2]||0;
			var queryobj=new ezbuilderAPI.jtsQuery.QueryObj();
			var query=new ezbuilderAPI.jtsQuery();
	        queryobj.tablename=typeof (options.tablename) ==="string"?options.tablename:(options.tablename)[i];//必须要设定的参数
		    queryobj.gisusername=SysConfig.GIS_DB_USERNAME||"gis";
		    queryobj.layertype=typeof (options.layertype) ==="string"?options.layertype:(options.layertype)[i];//必须要设定的参数
		    queryobj.primaryfield=options.primaryfield||"OBJECTID";//必须要设定的参数
		    queryobj.subFields=options.subFields||"";//要查询的字段以及别名，可选
		    queryobj.coords=options.coords;//必须要设定的参数  //查询的范围对象坐标串
		    queryobj.featurelimit=options.featurelimit||"100000"; //查询时限制的条数
		    queryobj.beginrecord=options.beginrecord||"1";
		    queryobj.nameField=typeof (options.nameField) ==="string"?options.nameField:(options.nameField)[i];//必须设定
		   queryobj.orderByClause=options.orderByClause||"OBJECTID";
		   queryobj.where=typeof(options.where)==="string"?options.where:(typeof (options.where)==="undefined")?"1=1":(options.where)[i];
		    queryobj.xfieldname=typeof (options.x) ==="string"?options.x:(typeof (options.x)==="undefined")?"zbx":(options.x)[i];
			queryobj.yfieldname=typeof (options.y) ==="string"?options.y:(typeof (options.y)==="undefined")?"zby":(options.y)[i];
			queryobj.mapserviceurl=options.mapserviceurl||"";//如果是线图层或面图层则必须设置
			queryobj.iscluster=(options.iscluster==false)?false:true;//是否需要展现点聚合功能
		    queryobj.mapWidth=options.mapWidth;//地图的宽度像素值（聚合时需要的参数）
		    queryobj.extent=options.extent;
		    queryobj.distance=options.distance||30;//默认为30
		      
		    	  switch(options.querytype){
			     	case "extent":
						query.extentquery(queryobj,function(json){
							var tempResult={
									id: queryobj.tablename,
									result:json.resultJson,
									store:queryobj.gisusername
							};
							GeoQuery.resultSet.push(tempResult);
							 i++;
							 if(i<(typeof options.tablename ==="string"?1:options.tablename.length)){
								 GeoQuery.spatialQuery(options,callback,i);
							 }else{
								 callback(GeoQuery.resultSet);
								 GeoQuery.resultSet=[];
							 }
				         });
						break;
					case "circle":
						query.circlequery(queryobj,function(json){
							var tempResult={
									id: queryobj.tablename,
									result:json.resultJson,
									store:queryobj.gisusername
							};
							GeoQuery.resultSet.push(tempResult);
							 i++;
							 if(i<(typeof options.tablename ==="string"?1:options.tablename.length)){
								 
								 GeoQuery.spatialQuery(options,callback,i);
							 }else{
								 callback(GeoQuery.resultSet);
								 GeoQuery.resultSet=[];
							 }
				         });
						break;
					case "polygon":
						query.polygonzbquery(queryobj,function(json){
							var tempResult={
									id: queryobj.tablename,
									result:json.resultJson,
									store:queryobj.gisusername
							};
							GeoQuery.resultSet.push(tempResult);
							 i++;
							 if(i<(typeof options.tablename ==="string"?1:options.tablename.length)){
								 
								 GeoQuery.spatialQuery(options,callback,i);
							 }else{
								 callback(GeoQuery.resultSet);
								 GeoQuery.resultSet=[];
							 }
				         });
						break;
			     	}
		    
		
	},
	/**
	 * 空间数据周边查询
	 * @param {Object} options   参数对象
	 *  options参数说明
	 * {Array(String)} tablename 查询图层的表名,单个图层查询可以简写为{String}如："video_pt" 
	 * {String} gisusername 图层所在数据库用户，同ezbuilder配置的数据库一样
	 * {Array(String)} layertype 查询图层类型如：point,polyline,polygon,图层类型顺序须与图层表名一一对应，如果多个图层为一种类型可简写为{String}如："point" 
	 * {String} primaryfield 初始查询图层id,默认为"OBJECTID"
	 * {String} subFields 查询图层其余字段,格式为"mc:mc", 可以定义别名如"mc:名称",默认为""
	 * {String} coords 周边查询的坐标串如"x,y,x,y"
	 * {Number} radius 周边查询距离，单位为度，实际距离需用map的getDegree方法转换
	 * {String} featurelimit 查询返回结果限制,默认返回全部结果
	 * {String}	beginrecord 查询开始条数,默认为"1"
	 * {Array(String)} nameField 查询中文字段，该内容顺序须与图层名一一对应，如多个图层为同一字段可以简写为{String}如"mc"
	 * {String} orderByClause 排序条件字段，默认为objectid
	 * {String} where 该属性可以将周边查询与属性查询结合，默认为"1=1",无属性限制
	 * {Array(String)} x 图层x坐标字段名,与图层名一一对应,默认为zbx
	 * {Array(String)} y 图层y坐标字段名,与图层名一一对应,默认为zby
	 * {Boolean} iscluster 聚合功能，默认为true
	 * {Number} mapWidth 地图的宽度值
	 * {String} extent 地图视野坐标串
	 * {Number} distance 聚合的像素值，默认为30
	 * {String} querytype 查询类型 "pointAround":点周边，"lineAround":线周边，"polygonAround":面周边查询
	 * @param {Function} callback 回调函数
	 * 该函数未提供图层不存在的异常机制，不会返回结果为0
	 */
	aroundQuery:function(options,callback){
		//MapBubble.closeBubble();
		var i=arguments[2]||0;
		var queryobj=new ezbuilderAPI.jtsQuery.QueryObj();
		var query=new ezbuilderAPI.jtsQuery();
		queryobj.tablename=typeof (options.tablename) ==="string"?options.tablename:(options.tablename)[i];
		queryobj.gisusername=SysConfig.GIS_DB_USERNAME||"gis";
		queryobj.layertype=typeof (options.layertype) ==="string"?options.layertype:(options.layertype)[i];
		queryobj.primaryfield=options.primaryfield||"OBJECTID";
		queryobj.subFields=options.subFields||"";
		queryobj.coords=options.coords;
		queryobj.nameField=typeof (options.nameField) ==="string"?options.nameField:(options.nameField)[i];
		queryobj.featurelimit=options.featurelimit||"1000000";
		queryobj.beginrecord=options.beginrecord||"1";
		queryobj.orderByClause=options.orderByClause||"OBJECTID";
		queryobj.radius=options.radius;
		queryobj.where=typeof(options.where)==="string"?options.where:(typeof (options.where)==="undefined")?"1=1":(options.where)[i];
		queryobj.xfieldname=typeof (options.x) ==="string"?options.x:(typeof (options.x)==="undefined")?"zbx":(options.x)[i];
		queryobj.yfieldname=typeof (options.y) ==="string"?options.y:(typeof (options.y)==="undefined")?"zby":(options.y)[i];
		queryobj.mapserviceurl=options.mapserviceurl||"";//如果是线图层或面图层则必须设置
		queryobj.iscluster=(options.iscluster==false)?false:true;
	    queryobj.mapWidth=options.mapWidth;
	    queryobj.extent=options.extent;
	    queryobj.distance=options.distance||30;
	    switch(options.querytype){
     	case "pointAround":
			query.pointzbquery(queryobj,function(json){
				var tempResult={
						id: queryobj.tablename,
						result:json.resultJson,
						store:queryobj.gisusername
				};
				GeoQuery.resultSet.push(tempResult);
				 i++;
				 if(i<(typeof options.tablename ==="string"?1:options.tablename.length)){
					 GeoQuery.aroundQuery(options,callback,i);
				 }else{
					 callback(GeoQuery.resultSet);
					 GeoQuery.resultSet=[];
				 }
				
	         });
			break;
		case "lineAround":
			query.linezbquery(queryobj,function(json){
				var tempResult={
						id: queryobj.tablename,
						result:json.resultJson,
						store:queryobj.gisusername
				};
				GeoQuery.resultSet.push(tempResult);
				 i++;
				 if(i<(typeof options.tablename ==="string"?1:options.tablename.length)){
					 
					 GeoQuery.aroundQuery(options,callback,i);
				 }else{
					 callback(GeoQuery.resultSet);
					 GeoQuery.resultSet=[];
				 }
	         });
			break;
		case "polygonAround":
			query.polygonzbquery(queryobj,function(json){
				var tempResult={
						id: queryobj.tablename,
						result:json.resultJson,
						store:queryobj.gisusername
				};
				GeoQuery.resultSet.push(tempResult);
				 i++;
				 if(i<(typeof options.tablename ==="string"?1:options.tablename.length)){
					 
					 GeoQuery.aroundQuery(options,callback,i);
				 }else{
					 callback(GeoQuery.resultSet);
					 GeoQuery.resultSet=[];
				 }
	         });
			break;
     	}
	},
	/**
	 * 空间数据属性查询
	 * @param {Object} options   参数对象
	 *  options参数说明
	 * {Array(String)} tablename 查询图层的表名,单个图层查询可以简写为{String}如："video_pt" 
	 * {String} gisusername 图层所在数据库用户，同ezbuilder配置的数据库一样
	 * {Array(String)} layertype 查询图层类型如：point,polyline,polygon,见SysConfig.layertype,图层类型顺序须与图层表名一一对应，如果多个图层为一种类型可简写为{String}如："point" 
	 * {String} primaryfield 初始查询图层id,默认为"OBJECTID"
	 * {String} subFields 查询图层其余字段,格式为"mc:mc", 可以定义别名如"mc:名称",默认为""
	 * {String} featurelimit 查询返回结果限制,默认返回全部结果
	 * {String}	beginrecord 查询开始条数,默认为"1"
	 * {Array(String)} nameField 查询中文字段，该内容顺序须与图层名一一对应，如多个图层为同一字段可以简写为{String}如"mc"
	 * {String} orderByClause 排序条件字段，默认为objectid
	 * {String} where 属性条件，默认为"1=1",无属性限制
	 * {Array(String)} x 图层x坐标字段名,与图层名一一对应,默认为zbx
	 * {Array(String)} y 图层y坐标字段名,与图层名一一对应,默认为zby
	 * {Boolean} iscluster 聚合功能，默认为true
	 * {Number} mapWidth 地图的宽度值
	 * {String} extent 地图视野坐标串
	 * {Number} distance 聚合的像素值，默认为30
	 * {String} querytype 查询类型 "attribute":属性查询
	 * @param {Function} callback 回调函数
	 */
	attributeQuery:function(options,callback){
		//MapBubble.closeBubble();
		var i=arguments[2]||0;
		var queryobj=new ezbuilderAPI.jtsQuery.QueryObj();
		var query=new ezbuilderAPI.jtsQuery();
		queryobj.tablename=typeof (options.tablename) ==="string"?options.tablename:(options.tablename)[i];
		queryobj.gisusername=SysConfig.GIS_DB_USERNAME||"gis";
		queryobj.layertype=typeof (options.layertype) ==="string"?options.layertype:(options.layertype)[i];
		queryobj.primaryfield=options.primaryfield||"OBJECTID";
		queryobj.subFields=options.subFields||"";
		queryobj.nameField=typeof (options.nameField) ==="string"?options.nameField:(options.nameField)[i];
		queryobj.featurelimit=options.featurelimit||"100000";
		queryobj.beginrecord=options.beginrecord||"1";
		queryobj.orderByClause=options.orderByClause||"OBJECTID";
		queryobj.where=typeof(options.where)==="string"?options.where:(typeof (options.where)==="undefined"||(options.where[i]=="undefined"))?"1=1":(options.where)[i];
		queryobj.xfieldname=typeof (options.x) ==="string"?options.x:(typeof (options.x)==="undefined")?"zbx":(options.x)[i];//线或面的时候需设置为空("")
		queryobj.yfieldname=typeof (options.y) ==="string"?options.y:(typeof (options.y)==="undefined")?"zby":(options.y)[i];//线或面的时候需设置为空("")
		queryobj.mapserviceurl=options.mapserviceurl||"";//如果是线图层或面图层则必须设置
		queryobj.iscluster=(options.iscluster==false)?false:true;
	    queryobj.mapWidth=options.mapWidth;
	    queryobj.extent=options.extent;
	    queryobj.distance=options.distance||30;
	    switch(options.querytype){
	    case "attribute":
	    	query.wherequery(queryobj,function(json){
	    		var tempResult={
						id: queryobj.tablename,
						result:json.resultJson,
						store:queryobj.gisusername
				};
				GeoQuery.resultSet.push(tempResult);
				 i++;
				 if(i<(typeof options.tablename ==="string"?1:options.tablename.length)){
					 GeoQuery.attributeQuery(options,callback,i);
				 }else{
					 callback(GeoQuery.resultSet);
					 GeoQuery.resultSet=[];
				 }
	         });
			break;
	    }
	},
	
	
	
	
	/**
	 * 通过EzMapService获得查询结果（返回json）
	 * @param layer 图层名称
	 * @param nameField  要显示的字段名
	 * @param subFields
	 * @param where 查询筛选条件，如:"name like '%社区%'"
	 * @param orderBy  设置查询的order by条件
	 * @param begin  要查询的开始记录
	 * @param limit 要返回的记录个数
	 * @param callback 回调函数
	 * @param queryType 设置查询类型。取值为1~7，具体含义如1：点查询；2：拉筐查询;3：圆形查询;4:多边形查询;5:周边查询;6:模糊查询(默认)；7:属地模糊查询
	 */
	getQueryResultFromMapService : function(layer, nameField, queryType, where, orderBy, begin, limit, callback){
		var aQuery = new QueryObject();
		aQuery.featurelimit = limit; 
		aQuery.beginrecord = begin; 
		aQuery.queryType = queryType;
		aQuery.dispField = nameField;
		aQuery.addSubFields(nameField);
		aQuery.orderByClause = orderBy;
		aQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + layer;
		aQuery.where = where;
		_MapApp.clearLayers();
		_MapApp.query(aQuery, function(vBIsOK, vRequestObj) {
			var dwLayers = _MapApp.getQueryResult(vRequestObj);
			var features = dwLayers[0].features;
			var count = dwLayers[0].maxRecord;
			var data = {};
			data.count = count;
			data.jsonlist = [];
			var filedArray = nameField.split(",");
			for(var j = 0; j < features.length; j++)
			{
				var linezb = features[j].linestr;
				var json = {};
				json["SHAPE"] = linezb;
				json["CJRY"] = features[j].getFieldValue("CJRY");
				json["CJRQ"] = features[j].getFieldValue("CJRQ");
				$.each(filedArray,function(key,value){
					json[value] = features[j].getFieldValue(value);
				});
				data.jsonlist.push(json);
			}
			callback(data);
		});
	},
	
	/**
	 * 空间数据处理
	 * @param {Array(Object)} resultSet 结果集
	 * @param map 地图对象
	 */
	dataProcess:function(resultSet,add){
		GeoQuery.resultSet=[];//清空结果集
		var isAdd=add||false;
		if(!isAdd){
			GeoQuery.allOverlays=[];
			GeoQuery.eachOverlays=[];
		}
		
//		if(this.marker_count>1){
//			MapBubble.closeBubble();
//		};
	   for(var i=0;i<resultSet.length;i++){
				var sResult=eval("("+resultSet[i].result+")");
				if(sResult.count==0){
					continue;
				}else{
					var eachData={};
					var jsonlist=eval("("+sResult.jsonlist+")");
					var markers=this.createMarker({resultSet : resultSet[i]}, jsonlist, function(){});
					eachData[resultSet[i].id]=markers;
					GeoQuery.allOverlays.push(markers);
					GeoQuery.eachOverlays.push(eachData);
				}
			};
		
	},

	/**
	 * 加载气泡内容
	 * @param dataJson
	 */
	loadBubbleContent : function(dataJson) {
		var tablename=dataJson["tablename"];
		var owner=dataJson["username"];
		var count=dataJson["count"];
		var objecid=dataJson["objectid"];
        if(count==1){ //一条数据的时候
//        	$("#bubbleContent").empty();
//			$("#bubbleInfo").empty();
			$("#bubbleContent").html('');
			$("#bubbleInfo").html('');
			GeoQuery.getDisplayField(tablename, owner,objecid,"bubbleContent");
        }else{
        	var msg="";
        	//$("#bubbleContent").empty();
        	$("#bubbleContent").html('');
        	var list = dataJson["clusterList"];
    		 GeoQuery.more_data_info=list;//存入聚合的信息
    		 var firstObjid="";
        	for(var n=0;n<list.length;n++){
        		var title=list[n].title;
        		var idname="oneMarkerInfo_"+list[n].ID;
        		if(n==0){
        			firstObjid=list[n].ID;
        		}
        		msg+="<div id='"+idname+"'>"+(n+1)+". <a class='oneMarkerInfo' objid='"+list[n].ID+"'"  +
        			" href='javascript:void(0)'>"+title+"</a></div>";
        		if(n>8){
        			msg+="<div count='"+(n+1)+"'><a id='more_data_info' class='loadmore loadmorenobod' href='javascript:GeoQuery.getMoreData(\""+tablename+"\",\""+owner+"\");'>加载更多>></a></div>";

        			break;
        		}
        	}	
        	
    		$("#bubbleContent").append(msg);
        	
    		$("#gn_div").remove();
    		GeoQuery.click_hover_fireEvent(tablename, owner,firstObjid);
    		GeoQuery.info_click(tablename, owner);
    		
        }	
	},
	
	/**
	 * 修改气泡
	 * @param dataJson
	 */
	changeBubble : function(dataJson) {
		var count=dataJson["count"];
		if(count > 1) {
			
			if(count <= 10) {
				if(count <=2 ) {
					$("#tips").css({
						"height" : 160,
						"min-height" : 180,
						"max-height" : 180
					});
					$("#tips").find(".tips_ct").css({
						"height" : 180-30,
						"min-height" : 180-30,
						"max-height" : 180-30
					});
				} else {
					$("#tips").css({
						"height" : count * 24 +140,
						"min-height" : 2 * 24 +140,
						"max-height" : count * 24 +140
					});
					$("#tips").find(".tips_ct").css({
						"height" : (count * 24) +140-30,
						"min-height" : (2 * 24) +140-30,
						"max-height" : (count * 24) +140-30
					});
				}
			}else{
				$("#tips").css({
					"height" : 10 * 24 +140 + 30,
					"min-height" : 2 * 24 +140 + 30,
					"max-height" : 10 * 24 +140 + 30
				});
				$("#tips").find(".tips_ct").css({
					"height" : (10 * 24) +140,
					"min-height" : (2 * 24) +140,
					"max-height" : (10 * 24) +140
				});
			}
			
			
			MapBubble.setMarkerPostion(MapBubble.currMarker, {moveMode : "movetoshow"}, function() {
//				MapBubble.currMarker = marker;
				MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
			});
			GeoQuery.marker_count=count;
		}else{
			GeoQuery.marker_count="";
		}
		$("#gn_div").show();
		
	},
	
	/**
	 * 创建marker
	 * @param param
	 * @param jsonlist
	 * @param callback
	 * @returns {Array}
	 */
	createMarker : function(param, jsonlist, callback) {
		var imageUrl="";
		var resultSet = param.resultSet;
		for(var k=0;k<SysConfig.GIS_LAYER_ICONS.length;k++){
			if((resultSet.id).toUpperCase()==((SysConfig.GIS_LAYER_ICONS)[k].id).toUpperCase()){
				imageUrl=(SysConfig.GIS_LAYER_ICONS)[k].url;
				break;
			}
		};
		var markerArray = new Array();
		for (var i = 0; i < jsonlist.length; i++) {
			var json = jsonlist[i];
			var clusterPoint=json.centerpoint;
			var clusterCount=json.count;
			var clusterList=json.clusterlist;
			var clusterPointArray = clusterPoint.split(",");
			var title = clusterList[0].title;
			if(clusterCount > 1){
				title = clusterCount+"条";
			}
			
			json["tablename"] = resultSet.id;
			json["username"] = resultSet.store;
			json["count"] = clusterCount;
			json["objectid"] = clusterList[0].ID;
			json["clusterList"] = clusterList;
			
			var marker = {dataJson:json,
					id:clusterList[0].ID,
					titleName:title,
					x:clusterPointArray[0],
					y:clusterPointArray[1],
					iconUrl:imageUrl,
					iconWidth:32,
					iconHeight:32,
					iconLeftOffset:0,
					iconTopOffset:-13
				};
			
			
			markerArray.push(marker);
		}
		var markerParam = {markerArray:markerArray,
					contentType:"html",
					contentValue:GeoQuery.bubbleHtml(clusterCount),
					contentCallback:"GeoQuery.loadBubbleContent",
					eventFuncJson:{"click":"GeoQuery.changeBubble"},
					bubbleShowEvent:"click",
					titleShowEvent:"mouseover",
					bubbleWidth:420,
					bubbleHeight:180,
					moveMode:"movetoshow"
				};
		var returnMarkerArray = MapBubble.addMarker(markerParam);
		
		callback(returnMarkerArray);
		return returnMarkerArray;
	},
	
	
	/**
	 * 获取机构边界坐标
	 * @param {String} orgCode 机构代码
	 * @param {Function} callback 回调函数
	 */
	getOrganizationBoundaryCoordinates: function(orgCode, callback) {
		var boundaryCoordinates = "";// 边界坐标
		var org = new ezbuilderAPI.organization();
        org.getonezzjg(orgCode, function(json) {
            var objs = eval("("+json.resultJson+")");
            for (var i = 0; i < objs.length; i++) {
            	boundaryCoordinates = objs[i]["BJZBZ"];
            }
            callback(boundaryCoordinates);
        });
	},
	/**
	 * 获取机构一级子节点边界坐标
	 * @param {String} orgCode 机构代码
	 * @param {Function} callback 回调函数
	 */
	getOneChildOrganizationCoordinates:function(orgCode, callback){
       var org=new ezbuilderAPI.organization();
       var jsonObj={};
//       var bjzbArray=[];
       org.getonechildzzjg(orgCode,function(json){
    	   var objs = eval("("+json.resultJson+")");
           for (var i = 0; i < objs.length; i++) {
        	  zzjgdm=objs[i]["ZZJGDM"];
           	boundaryCoordinates = objs[i]["BJZBZ"];
           	jsonObj[zzjgdm]=boundaryCoordinates;
//           	bjzbArray.push(boundaryCoordinates);
           }
           callback(jsonObj);
       });
	},
	/**
	 * 显示气泡框里属性信息
	 * @param tablename 图层名
	 * @param owner 所在数据库用户
	 * @param list  聚合列表
	 * @param divid div元素ID
	 */
	getDisplayField:function(tablename,owner,id,divid){
		GeoQuery.currentImageAlias=[];
		var msg="";
		//$("#"+divid).empty();
		$("#"+divid).html('');
		 var ezmanager=new ezbuilderAPI.Ezmanager();
		ezmanager.getFieldProperty(tablename,owner,function(json){
			GeoQuery.xxinfo_field=[];
            var objs = eval("("+json.resultJson+")");
            var fieldProperty=objs[0]["fieldProperty"];
            var where="";
            var titleField="";
            for(var i=0;i<fieldProperty.length;i++){
            	if(fieldProperty[i]["dispLevel"]<=2&&fieldProperty[i]["fieldName"]!="OBJECTID"){//气泡等级	
            			msg+="<div class='tips_sxdiv'><span class='tips_sxspan'>"+(fieldProperty[i]["aliasName"]||fieldProperty[i]["fieldName"])+"：</span><span id='"+(fieldProperty[i]["aliasName"]||fieldProperty[i]["fieldName"])+"'></span></div>";
            	}
            	if(fieldProperty[i]["dispLevel"]==1&&fieldProperty[i]["fieldName"]!="OBJECTID"){
            		titleField=(fieldProperty[i]["aliasName"]||fieldProperty[i]["fieldName"]);
            	}
            	if(fieldProperty[i]["dispLevel"]<=GeoQuery.xxinfo_level){
            		GeoQuery.xxinfo_field.push((fieldProperty[i]["aliasName"]||fieldProperty[i]["fieldName"]));
            	}
            	for(var c=0;c<SysConfig.GIS_LAYER_ICONS.length;c++){
            		if(SysConfig.GIS_LAYER_ICONS[c]["id"]==tablename.toUpperCase()&&typeof SysConfig.GIS_LAYER_ICONS[c]["image_field"]!="undefined"){
            			var image=SysConfig.GIS_LAYER_ICONS[c]["image_field"];
            			if($.inArray(fieldProperty[i]["fieldName"],image)!=-1){
            				GeoQuery.currentImageAlias.push((fieldProperty[i]["aliasName"]||fieldProperty[i]["fieldName"]));//记录图片字段的别名
            			}
            			break;
            		}
            	}
            }
            $("#"+divid).append(msg);
            where="objectid="+id;
            //气泡框值
            GeoQuery.getDataInfo(tablename, owner, where, function(objs){
            		GeoQuery.marker_info=[];
            	var image_field=[];
            	for(var c=0;c<SysConfig.GIS_LAYER_ICONS.length;c++){
            		if(SysConfig.GIS_LAYER_ICONS[c]["id"]==tablename.toUpperCase()&&typeof SysConfig.GIS_LAYER_ICONS[c]["image_field"]!="undefined"){
            			image_field=SysConfig.GIS_LAYER_ICONS[c]["image_field"];
            			break;
            		}
            	}
            	var srcStr="";//多图片的地址
            	var titleValue="";//图片弹出框名称
            	for(var i=0;i<objs.length;i++){
            		 var property={};
  					var mc=objs[i]["mc"];//字段名称,如果在Ezspatial里设置的有别名则返回的是别名
  					var value=objs[i]["value"];//字段值
  					property["fieldName"]=mc;
  					property["fieldValue"]=value;
  					GeoQuery.marker_info.push(property);
  					if(titleField==mc){
  						titleValue=value;//显示的名称与marker的名称对应
  						GeoQuery.img_title=value;
  					}
  					if($.inArray(mc,image_field)!=-1||$.inArray(mc,GeoQuery.currentImageAlias)!=-1){//图片字段
  						if(value.replace(/(^\s*)|(\s*$)/g, "")!=""){//排除空格
//	  						$("#"+mc).html("<a href='javascript:;' class='morephoto'>"+image_field.length+"张</a>");
	  						if(value.toUpperCase().indexOf("<?XML")!=-1&&value.toUpperCase().indexOf("HTTP://")==-1){
	  							var xmlDom = $.parseXML(value);
	  							var pictures=$(xmlDom).find("file");
	  							$("#"+mc).html("<a href='javascript:;' class='morephoto'>"+pictures.length+"张</a>");
	  							for(var g=0;g<pictures.length;g++){
	  								var imgpath=$($(pictures[g]).find("path")).text();
	  								if(srcStr!=""){
			  							srcStr+=";"+SysConfig.IMAGESHOW_ROOTPATH+imgpath;//多图片
			  						}else{
				  						srcStr=SysConfig.IMAGESHOW_ROOTPATH+imgpath;
			  						}
	  							}
	  						}else{
	  							$("#"+mc).html("<a href='javascript:;' class='morephoto'>"+image_field.length+"张</a>");
	  							if(srcStr!=""){
		  							srcStr+=";"+value;//多图片(多字段的情况下)
		  						}else{
			  						srcStr=value;
		  						}
	  						}
	  						$("#"+mc).click(function(){
	  							SysTool.showPicture(titleValue, srcStr);
	  						});
  						}else{
  							$("#"+mc).text("空");
  						}
  						
  					}else{
  						$("#"+mc).attr("title",value);
	  					$("#"+mc).text(value);
  					}
	  				if(divid="eachContent"){//悬停时属性列表宽度计算
	  					if($("#"+mc).parent().width()>185){
	  						$($("#"+mc).parent()).width(380);
	  					}else{
	  						$($("#"+mc).parent()).width(185);
	  					}
	  					
	  				}
  					
                  }
            	  $("#otherinfo").attr("href","javascript:GeoQuery.showDataInfo('"+tablename+"','"+owner+"','"+where+"')");
            	 var bubble_extend=SysConfig.JCXX_BUBBLE_EXTEND;
            	 for(var j=0;j<bubble_extend.length;j++){
            		 if(tablename.toUpperCase()==(bubble_extend[j].id).toUpperCase()){
            			 var content=bubble_extend[j].content;
            			 var funcname=bubble_extend[j].funcname;
            			 for(var m=0;m<content.length;m++){
            				 var func = funcname[m]+"(\""+id+"\")";//默认传入的是objectid
            				 $("#gn_div").append("<div class='btn_tipsdwbl' href='javascript:;'><a class='btn_tipsdwbr' href='javascript:"+func+"'>"+content[m]+"</a></div>");
            			 }
		            	  
	            	  } 
            	 }

                 $("#each_info").show();
            });
        });
	},
	/**
	 * 查询气泡里字段值
	 * @param tablename
	 * @param username
	 * @param where
	 * @param func
	 */
	getDataInfo:function(tablename,username,where,func){
		var dataquery=new ezbuilderAPI.dataQuery();
        var layerename=tablename;
        var gisuser=username;
        var w=where;
        dataquery.getXqInfo(layerename,gisuser,w,function(json){
            var objs = eval("("+json.resultJson+")");
           func(objs);
        });
	},
	/**
	 * 详细信息
	 * @param tablename
	 * @param owner
	 * @param where
	 */
	showDataInfo:function(tablename,owner,where){ 
		GeoQuery.getDataInfo(tablename, owner, where, function(objs){
			var datainfo="";
			var image_field=[];
			var has_img=false;
        for(var c=0;c<SysConfig.GIS_LAYER_ICONS.length;c++){
        		if(SysConfig.GIS_LAYER_ICONS[c]["id"]==tablename.toUpperCase()&&typeof SysConfig.GIS_LAYER_ICONS[c]["image_field"]!="undefined"){
        			image_field=SysConfig.GIS_LAYER_ICONS[c]["image_field"];
        			break;
        		}
        	}
        var srcStr="";//多图片的地址
    	var titleValue=GeoQuery.img_title;//图片弹出框名称
      	  for(var i=0;i<objs.length;i++){
				var mc=objs[i]["mc"];
				var value=objs[i]["value"];
				var imgvalue="";
				if($.inArray(mc,GeoQuery.xxinfo_field)==-1){
					continue;
				}
				if($.inArray(mc,image_field)!=-1||$.inArray(mc,GeoQuery.currentImageAlias)!=-1){//图片字段
				
					if(value.replace(/(^\s*)|(\s*$)/g, "")!=""){
//  						imgvalue="<a href='javascript:;' class='morephoto'>"+image_field.length+"张</a>";
  						has_img=true;
  						if(value.toUpperCase().indexOf("<?XML")!=-1&&value.toUpperCase().indexOf("HTTP://")==-1){
  							var xmlDom = $.parseXML(value);
  							var pictures=$(xmlDom).find("file");
  							imgvalue="<a href='javascript:;' class='morephoto'>"+pictures.length+"张</a>";
  							for(var g=0;g<pictures.length;g++){
  								var imgpath=$($(pictures[g]).find("path")).text();
  								if(srcStr!=""){
		  							srcStr+=";"+SysConfig.IMAGESHOW_ROOTPATH+imgpath;//多图片
		  						}else{
			  						srcStr=SysConfig.IMAGESHOW_ROOTPATH+imgpath;
		  						}
  							}
  						}else{
  							imgvalue="<a href='javascript:;' class='morephoto'>"+image_field.length+"张</a>";
  							if(srcStr!=""){
	  							srcStr+=";"+value;//多图片(多字段的情况下)
	  						}else{
		  						srcStr=value;
	  						}
  						}
					}else{
						has_img=true;
						imgvalue="空";
						}
				}
				if(has_img){
					datainfo+="<div class='tips_sxdiv' id='mcli"+i+"'><span class='tips_sxspan' style='width:100px'>"+mc+"：</span><span onclick='SysTool.showPicture(\""+titleValue+"\",\""+srcStr+"\");'>"+imgvalue+"</span></div>";
				}else{
					datainfo+="<div class='tips_sxdiv' id='mcli"+i+"'><span class='tips_sxspan' style='width:100px'>"+mc+"：</span><span title="+value+">"+value+"</span></div>";
				}
            }
      	SysTool.window.open({
			width : 500,
			height: 460,
			title : '详细信息',
			html : "<div class='tips_show_1' style='height:420px;overflow:auto'>"+datainfo+"</div>"
		}, function(){			
			for(var j=0;j<objs.length;j++){
				if($("#mcli"+j).width()>230){
					$("#mcli"+j).width(460);
				}else{
					$("#mcli"+j).width(230);
				}
			}	
		});
      });
		
	},
	/**
	 * 气泡框
	 * @param count
	 * @returns {String}
	 */
	bubbleHtml:function(count){
		var html="";
			html="<div class='tips' style='background:#f2f9ff;'><div class='tips_top'><div class='tips_title'><strong>&nbsp;&nbsp;属性信息</strong></div></div>" +
			"<div class='tips_ct'>" +
			"<div id='scroll_main_jcxx'><div id='scroll_content_jcxx'>" +
			"<div class='tips_show_1'>"+
			"<div id='bubbleContent' class='bubbleContent'></div>" +
			"<div id='gn_div' style='clear:both;overflow:hidden;margin:0 0 5px;'><a id='otherinfo' style='float:right' href='javascript:;' class='btn_tipsdw'>详细信息</a></div>"+
			"<div id='bubbleInfo' style='height:30px;'></div>"+
			"</div></div>" +
			"</div></div></div>";
		return html;
	},
	/**
	 * 加载更多
	 * @param tablename
	 * @param owner
	 * @param marker
	 */
	getMoreData:function(tablename,owner,marker){
		var start=$("#more_data_info").parent().attr("count");
		var msg="";
		var end=0;
		var isAll=false;//判断是否加载完
		if(GeoQuery.more_data_info.length<(parseInt(start)+10)){
			 end=GeoQuery.more_data_info.length;
			 isAll=true;
		 }else{
			 end=parseInt(start)+10;
		 }
		$("#more_data_info").remove();
		for(var i=parseInt(start);i<end;i++){
			var title=GeoQuery.more_data_info[i].title;
			var idname="oneMarkerInfo_"+GeoQuery.more_data_info[i].ID;
			 msg+="<div id='"+idname+"'>"+(i+1)+". <a class='oneMarkerInfo' href='javascript:GeoQuery.click_hover_fireEvent(\""+tablename+"\",\""+owner+"\",\""+GeoQuery.more_data_info[i].ID+"\");' id='"+GeoQuery.more_data_info[i].ID+"'>"+title+"</a></div>";
			 if(i==end-1){
				 if(!isAll){
					 msg+="<div count='"+(i+1)+"'><a id='more_data_info' class='loadmore loadmorenobod' href='javascript:GeoQuery.getMoreData(\""+tablename+"\",\""+owner+"\");'>加载更多>></a></div>";
					 break; 
				 }
				
			 }
		}
		$("#bubbleContent").append(msg);
		ScrollBarTool.init("scroll_main_jcxx", "scroll_content_jcxx", 0); 

	},
	/**
	 * 鼠标单击查询属性信息
	 */
	info_click:function(tablename, owner){
		$(".oneMarkerInfo").click(function(){
			var that=this;
			$("#each_info").remove();
			GeoQuery.click_hover_fireEvent(tablename, owner,that);
		});
		//$("#each_info").remove();
	},
	/**
	 * 鼠标悬停事件
	 * @param tablename
	 * @param owner
	 */
	info_hover:function(tablename, owner){
		var hoverTimer=null;
		$(".oneMarkerInfo").hover(function(){
			$("#each_info").remove();
			var that=this;
			hoverTimer = setTimeout(function(){// 延时处理
				GeoQuery.click_hover_fireEvent(tablename, owner,that);
			}, 400);
		},function(){
			clearTimeout(hoverTimer);
		});


	},
	/**
	 * 鼠标悬停或单击触发事件，查询属性信息
	 * @param tablename 表名
	 * @param owner 数据库用户
	 * @param that 悬停对象
	 */
	click_hover_fireEvent:function(tablename,owner,that){
		var info_div="<div class='each_info' id='each_info' style='display:none'><div class='sanjiaox'></div>" +
		"<div id='eachContent'></div>" +
		"<div id='gn_div' style='clear:both;overflow:hidden;margin:0 0 5px;'><a id='otherinfo' style='float:right' href='javascript:;' class='btn_tipsdw'>详细信息</a></div></div>";
		$("#each_info").remove();//删除
		var objid="";
		if(typeof that==="string"){
			 objid=that;
		}else{
			 objid=$(that).attr("objid");
		}
		$("#oneMarkerInfo_"+objid).append(info_div);
		GeoQuery.getDisplayField(tablename, owner, objid, "eachContent");
	}

};