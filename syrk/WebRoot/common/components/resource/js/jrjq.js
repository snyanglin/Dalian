/*!
 * 今日警情统计
 * znjg - v1.0.0 (2014-04-01 14:50)
 * Copyright(c) 2014 yangyongfei
 */
/**
 * 全局对象
 */
var Jrjq = {
		
		/**
		 * 统计的组织机构
		 */
		countZzjgdm : "",
		
		/**
		 * 初始化
		 */
		initFun : function(){
			Jrjq.initZzjg();//初始化今日警情组织结构
			
			
		},
		
		/**
		 * 构建图形统计
		 */
		creatPhotoCount : function(data){
			SysTool.loading.unmask();
			Jrjq.creatJqlbColumn(data.jqlxList);
			Jrjq.creatJqslColumn(data.jqslList);
			Jrjq.creatJqztPie(data.jqztList);
			Jrjq.creatMydPie(data.mydList);
			
			ScrollBarTool.init("scroll_main_jrjq", "scroll_content_jrjq", 0); 
			$(window).resize(ScrollBarTool.debounce(function() {
				ScrollBarTool.init("scroll_main_jrjq", "scroll_content_jrjq", 0, true); 
			}, 500)); 
		},
		
		/**
		 * 构建警情类别柱状图
		 */
		creatJqlbColumn : function(data){
			var xml = '<chart labelDisplay="WRAP" slantLabels="1" rotateLabels="1" baseFontColor="black" baseFontSize="11" caption="警情类型统计" useRoundEdges="0" bgColor="FFFFFF,FFFFFF" showBorder="0">';
			$.each(data,function(key,value){
				var obj = data[key];
				xml = xml + '<set label="' + obj.dataSetName + '" value="' + obj.dataSetNum + '"/>';
			});
			xml = xml + "</chart>";
			var jqlxChar = new FusionCharts("common/components/FusionCharts/Charts/Column2D.swf", "jrjq_chart_jqlx"+Math.random(), "295", "270", "0", "1" );

			jqlxChar.setXMLData(xml);
			jqlxChar.render("jrjq_jqlx");
		},
		
		/**
		 * 组织机构警情处置数量统计柱状图
		 */
		creatJqslColumn : function(data){
			var xml = '<chart labelDisplay="WRAP" slantLabels="1" rotateLabels="1" baseFontColor="black" baseFontSize="11" caption="处置警情数" useRoundEdges="0" bgColor="FFFFFF,FFFFFF" showBorder="0">';
			$.each(data,function(key,value){
				var obj = data[key];
				xml = xml + '<set label="' + obj.dataSetName + '" value="' + obj.dataSetNum + '"/>';
			});
			xml = xml + "</chart>";
			var jqslChar = new FusionCharts("common/components/FusionCharts/Charts/Column2D.swf", "jrjq_chart_jqsl"+Math.random(), "295", "270", "0", "1" );
			jqslChar.setXMLData(xml);
			jqslChar.render("jrjq_jqsl");
		},
		
		/**
		 * 当前组织机构警情处置状态统计饼状图
		 */
		creatJqztPie : function(data){
			var flag = false;
			var xml = '<chart caption="'+"警情处置状态统计"+'" showPercentageInLabel="1" showValues="1" showLabels="0" showLegend="1" showPercentValues="1">';
			if (undefined != data)
			{
				$.each(data,function(key,value){
					flag = true;
					var obj = data[key];
					var color = "";
					if ("未定位" == obj.dataSetName)
					{
						color = "#666666";
						xml = xml + '<set color="'+color+'" label="' + obj.dataSetName + '" value="' + obj.dataSetNum + '"/>';
					}
					else if ("未派警" == obj.dataSetName)
					{
						color = "#e40000";
						xml = xml + '<set color="'+color+'" label="' + obj.dataSetName + '" value="' + obj.dataSetNum + '"/>';
					}
					else if ("已派警" == obj.dataSetName)
					{
						color = "#ff7e00";
						xml = xml + '<set color="'+color+'" label="' + obj.dataSetName + '" value="' + obj.dataSetNum + '"/>';
					}
					else if ("处置中" == obj.dataSetName)
					{
						color = "#003ce9";
						xml = xml + '<set color="'+color+'" label="' + obj.dataSetName + '" value="' + obj.dataSetNum + '"/>';
					}
					else if ("已完成" == obj.dataSetName)
					{
						color = "#309e00";
						xml = xml + '<set color="'+color+'" label="' + obj.dataSetName + '" value="' + obj.dataSetNum + '"/>';
					}
				});
			}
			if (flag)
			{
				$("#jrjq_jqzt").width("300px");
				$("#jrjq_jqzt").height("270px");
				xml = xml + "</chart>";
				var chart = new FusionCharts("common/components/FusionCharts/Charts/Pie2D.swf", "jrjq_chart_jqzt"+Math.random(), "295", "270", "0", "1" );
	            chart.setXMLData(xml);
	            chart.render("jrjq_jqzt");
			}
			else
			{
				$("#jrjq_jqzt").html(" ");
				$("#jrjq_jqzt").width("0px");
				$("#jrjq_jqzt").height("0px");
			}
		},
		
		/**
		 * 警情处置满意度统计饼状图
		 */
		creatMydPie : function(data){
			var flag = false;
			var xml = '<chart caption="'+"警情处置满意度统计"+'" showPercentageInLabel="1" showValues="1" showLabels="0" showLegend="1" showPercentValues="1">';
			if (undefined != data)
			{
				$.each(data,function(key,value){
					flag = true;
					var obj = data[key];
					xml = xml + '<set label="' + obj.dataSetName + '" value="' + obj.dataSetNum + '"/>';
				});
			}
			if (flag)
			{
				$("#jrjq_myd").width("300px");
				$("#jrjq_myd").height("270px");
				xml = xml + "</chart>";
				var chart = new FusionCharts("common/components/FusionCharts/Charts/Pie2D.swf", "jrjq_chart_myd"+Math.random(), "295", "270", "0", "1" );
	            chart.setXMLData(xml);
	            chart.render("jrjq_myd");
			}
			else
			{
				$("#jrjq_myd").html(" ");
				$("#jrjq_myd").width("0px");
				$("#jrjq_myd").height("0px");
			}
		},
		/**
		 * 初始化组织机构
		 */
		initZzjg:function(){
			var zzjgdm = ywjgdm;
			Dictionary.initDictTree({url: "dictionary/getOrganizationDictTreeJSON.f", zdbh: "D_ORG1", zdmc: "组织机构", zzjgdm: zzjgdm, auth: "1", dictDataDivId: "jrjq_zzjg_data_Div"}, function() {
				Dictionary.beforeCreateDictTree({createCount: 1, zdbh: "D_ORG1", treeData: data_D_ORG1, dictDataDivId: "jrjq_zzjg_data_Div"});
				Dictionary.createDictTree({dictObject: D_ORG1, treeData: data_D_ORG1_1, isLeaf: false, dictHiddenId: "jrjq_zzjg_dm", dictShowId: "jrjq_zzjg_mc",initVal: zzjgdm, "dictContainerReferenceObjectId": "jrjq_zzjg" }, function() {
					Jrjq.countZzjgdm=$("#jrjq_zzjg_dm").val();
					SysTool.loading.mask('scroll_main_jrjq', '35%');
					var param = {"url" : "count/countTodayJq.f","data":{"mydzd":"dcjgpgz","zzjgdm":Jrjq.countZzjgdm}};
					SysTool.ajax(param, Jrjq.creatPhotoCount);
				});
			});
		},
		/**
		 * 组织机构触发函数
		 */
		zzjgFireFunc:function(){
			Jrjq.countZzjgdm=$("#jrjq_zzjg_dm").val();
			SysTool.loading.mask('scroll_main_jrjq', '35%');
			var param = {"url" : "count/countTodayJq.f","data":{"mydzd":"dcjgpgz","zzjgdm":Jrjq.countZzjgdm}};
			SysTool.ajax(param, Jrjq.creatPhotoCount);
		}
};
Jrjq.initFun();
