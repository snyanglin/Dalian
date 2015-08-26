/*
 * 人员选择组件
 * znjg - v1.0.0 (2014-10-20 15:48)
 * Copyright(c) 2014 founder
 * @author liuc
 */
function Ryxz() 
{
	/*
	 * 人员选择初始化
	 * @param param 输入参数,json对象
	 * param 对象构造例子
	 * param={
		 			tablename:"T_PERSONNEL",//表名
		 			colums:{NAME:"jyxm",PoliceNum:"jybh",ORGNAME:"zzjgmc",TELEPHONE:"jydh",SFZ:"jysfz"},//其中jyxm，jybh，zzjgmc均为表T_PERSONNEL中字段
		 			pk:"guuid",//表中主键字段
		 			dw:"zzjgmc",//如果colums中没有单位字段，则dw为空，如果存在单位字段，则此处填写单位字段,此标记作用是是否显示单位查询输入框
		 			dwdm:"zzjgdm",//如果colums中没有单位字段，则dwdm为空，如果存在单位字段，则此处填写单位代码字段，此标记作用查询数据
		 			data:{},
		 					/*data表示已选择数据，如果不为空，初始化方法的时候，右边确认框应该出现这些数据
		 					 * data例子：
		 					 *  data={
		 			  						total:10;
		 			 						rows:[{JYXM:"王梅",JYBH:"P5485",ZZJGMC:"三中队"},{},{},...{}];
		 								}
		 			commitFun:function(){}
					}
	 */
	this.initRyxz=function(param) 
	{
			ryxz_gobal.flag=false;//确保打开页面时，是按照非点击“查询”方式查询的
			var colums=[];
			var i=0;
			$.each(param.colums,function(key,value) 
			{
				colums[i++]=value;
			});
			colums[i]=param.pk;
			var param1={};
			param1['url']='components/ryxz/queryInfo.f';
			param1['data']={
					tablename:param.tablename,
					colums:JSON.stringify(colums)
			};
			showQueryInput(param);
			//定义一个对象，其值为param.colums,并追加属性pk
			var t={};
			t=param.colums;
			t['pk']=param.pk;
			if(param.dwdm)
			{ 
				t['dwdm']=param.dwdm;
			}
			itemInitGridRight("yrxz_itemselector_right",param1,t,param);
			if(!param.dw&&param.xzlx)
			{
				onExistXzmc();
			}
			else 
			{
				itemInitGridLeft("yrxz_itemselector_left",param1,t,param);
			}
	};
	/**
	 * @param containerId datagrid容器id
	 * @param paramQuery 需要向后台传递参数的josn对象
	 * @param paramColums 形成列值的json对象
	 * @param paramSource最开始的数据
	 */
	function itemInitGridLeft(containerId,paramQuery,paramColums,paramSource) 
	{
			$("#"+containerId).datagrid(
			{
				 width: 350,
				 height: 377,//表格高度
		         singleSelect:false, //是否单选
		         rownumbers : false,//是否显示行号
		         nowrap: true,//是否把数据显示在一行
		         fitColumns : true,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
		         border: true,//是否显示边框
		         pagination: true,//是否分页
		         remoteSort: false,//是否远端排序，这会消耗带宽
		         pageSize : 10,//如果pagination为true，这个值才有意义，初始化页面大小
		         pageList : [10, 15, 20, 25, 30 ],
		         loadFilter:function(data)
		         {//获取数据源
						var dataRe={};
						dataRe.total=data.total;
						dataRe.rows=data.rows;
						var dataRows=$("#yrxz_itemselector_right").datagrid('getData').rows;
						SysTool.setTxtVal("yrxz_search_dwdmsData", JSON.stringify(data['dwdmList']));
						$.each(dataRe.rows,function(key1,value1) 
						{
							$.each(dataRows,function(key2,value2) 
							{
								if(value1[param.pk.toUpperCase()] == value2[param.pk.toUpperCase()]) 
								{
									dataRe.total--;
									 delete dataRe.rows[key1]//删除数组元素,减小相应长度
								}
							});
						});
						dataRe.rows=$.grep(dataRe.rows,function(x,i)
							{
							if(x != undefined&&x != null)
								return x;
							});
						return dataRe;
						},
		         queryParams :
		         {
						tablename:paramQuery.data.tablename,
						colums:paramQuery.data.colums,
						param:getQueryParam(paramSource),
						orgidField:paramSource.dwdm,
						existedData:JSON.stringify(getExistedData(paramSource)),//右边方框中已存在数据
						rywhere:param.rywhere
				 },
		         url :paramQuery.url,//查询地址
		         frozenColumns:getColums(paramColums,true),//冻结复选框列
		         columns : getColums(paramColums,false),
		         onDblClickRow:function(rowIndex,rowData)
		         {
					ryxz.choseAffirm("yrxz_itemselector_left");
				}
			});
			$("#yrxz_itemselector").find(".pagination-info").css("width","345px").css("text-align","right");
		}
	/**
	 * @param containerId datagrid容器id
	 * @param paramQuery 需要向后台传递参数的josn对象
	 * @param paramColums 形成列值的json对象
	 * @param paramSource最开始的数据
	 */
	function _itemInitGridLeft(containerId,paramQuery,paramColums,paramSource) 
	{
			$("#"+containerId).datagrid(
			{
				 width: 350,
				 height: 377,//表格高度
		         singleSelect:false, //是否单选
		         rownumbers : false,//是否显示行号
		         nowrap: true,//是否把数据显示在一行
		         fitColumns : true,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
		         border: true,//是否显示边框
		         pagination: true,//是否分页
		         remoteSort: false,//是否远端排序，这会消耗带宽
		         pageSize : 10,//如果pagination为true，这个值才有意义，初始化页面大小
		         pageList : [10, 15, 20, 25, 30 ],
		         loadFilter:function(data)
		         {//获取数据源
						var dataRe={};
						dataRe.total=data.total;
						dataRe.rows=data.rows;
						var dataRows=$("#yrxz_itemselector_right").datagrid('getData').rows;
						SysTool.setTxtVal("yrxz_search_dwdmsData", JSON.stringify(data['dwdmList']));
						$.each(dataRe.rows,function(key1,value1) 
						{
							$.each(dataRows,function(key2,value2)
							{
								if(value1[param.pk.toUpperCase()]  ==  value2[param.pk.toUpperCase()])
								{
									dataRe.total--;
									 delete dataRe.rows[key1]//删除数组元素,减小相应长度
								}
							});
						});
						dataRe.rows=$.grep(dataRe.rows,function(x,i)
						{
							if(x !=  undefined&& x !=  null)
							{
								return x; 
							}
							});
						return dataRe;
						},
		         queryParams :
		         {
						tablename:paramQuery.data.tablename,
						colums:paramQuery.data.colums,
						param:_getQueryParam(paramSource),
						orgidField:paramSource.dwdm,
						existedData:JSON.stringify(getExistedData(paramSource)),//右边方框中已存在数据
						rywhere:param.rywhere,
						isClickQuery:"yes"
					},
		         url :paramQuery.url,//查询地址
		         frozenColumns:getColums(paramColums,true),//冻结复选框列
		         columns : getColums(paramColums,false),
		         onDblClickRow:function(rowIndex,rowData){
					ryxz.choseAffirm("yrxz_itemselector_left");
				}
			});
			$("#yrxz_itemselector").find(".pagination-info").css("width","345px").css("text-align","right");
		}
	/**
	 * 初始化右边表格
	 * @param containerId
	 * @param paramQuery
	 * @param paramColums
	 * @param paramSource
	 * @return
	 */
		function itemInitGridRight(containerId,paramQuery,paramColums,paramSource)
		{
			if(paramSource.data&&!isEmptyObject(paramSource.data))
				$("#"+containerId).datagrid({
					 width: 330,
					 height: 377,//表格高度
			         singleSelect:false, //是否单选
			         rownumbers : false,//是否显示行号
			         nowrap: false,//是否把数据显示在一行
			         fitColumns : true,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
			         border: true,//是否显示边框
			         pagination: false,//是否分页
			         remoteSort: false,//是否远端排序，这会消耗带宽
			         frozenColumns:getColums(paramColums,true),//冻结复选框结列
			         columns : getColums(paramColums,false),
				     onDblClickRow:function(rowIndex,rowData){
						ryxz.deleteAffirm("yrxz_itemselector_left");
					}
				}).datagrid('loadData',paramSource.data);//加载本地数据，旧的行将被移除
			else
				$("#"+containerId).datagrid({
					 width: 330,
					 height: 377,//表格高度
			         singleSelect:false, //是否单选
			         rownumbers : false,//是否显示行号
			         nowrap: false,//是否把数据显示在一行
			         fitColumns : true,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
			         border: true,//是否显示边框
			         pagination: false,//是否分页
			         remoteSort: false,//是否远端排序，这会消耗带宽
			         frozenColumns:getColums(paramColums,true),//冻结复选框结列
			         columns : getColums(paramColums,false),
				     onDblClickRow:function(rowIndex,rowData){
						ryxz.deleteAffirm("yrxz_itemselector_left");
					}
				}); 
		}
	/**
	 * 用于获取datagrid的colums值
	 * @param paramColums 
	 * @param isFrosen 是否冻结复选框true:是，false：否
	 * @return columsArray数组
	 */
	function getColums(paramColums,isFrosen) 
	{
		if(isFrosen)
		{
			var columsArray=[];
			var columsArray1=[];
			var i=1;//数组计数器
			$.each(paramColums,function(key,value)
			{
				if(key == 'pk') 
				{
					columsArray[0]={field : value.toUpperCase(),checkbox:true};
				}
				else if(key == 'dwdm') 
				{
					columsArray[1]={field : value.toUpperCase(),title : key,align : 'center',hidden:true};
				}
			});
			columsArray1.push(columsArray);
			return columsArray1;
		}
		else
		{
			var columsArray=[];
			var columsArray1=[];
			var i=0;//数组计数器
			$.each(paramColums,function(key,value)
			{
				if(key != 'pk'&&key != 'dwdm') 
				{
					columsArray[i++]={field : value.toUpperCase(),title : key,width :20,align: 'left',halign:'center'};	
				}
			});
			columsArray1.push(columsArray);
			return columsArray1;
		}		
	}
	/**
	 * 获取右边方框中已存在数据
	 * @param 
	 * @return
	 */
	function getExistedData(param)
	{
		var existedData=[];
		var existedDataJson={};
		var data=$("#yrxz_itemselector_right").datagrid('getData');
		$.each(data.rows,function(key,value)
		{
			existedData.push(value[param.pk.toUpperCase()]);
		})
		existedDataJson[param.pk]=existedData;
		return existedDataJson;
	}
	/**
	 * 传递一个datagrid中选中的数据给另一个datagrid，且删除原datagrid中选中的数据
	 * @param containerIdSourece
	 * @param containerIdDesitination
	 * @return
	 */
	function transportItemsToAnother(containerIdSourece,containerIdDesitination) 
	{
		//从左往右移
		if(containerIdSourece == 'yrxz_itemselector_right') 
		{       
			    //如果有数据
				if(SysTool.getTxtVal("yrxz_search_dwdmsData") != "") 
				{
						var dwdms=JSON.parse(SysTool.getTxtVal("yrxz_search_dwdmsData"));
						var rows=$("#"+containerIdSourece).datagrid('getSelections');
						if (rows) 
						{
							for (var i = rows.length - 1; i >= 0; i--) 
							{
								var index = $("#"+containerIdSourece).datagrid('getRowIndex', rows[i]);
								$("#"+containerIdSourece).datagrid('deleteRow', index);
								var dwdm=rows[i][param.dwdm.toUpperCase()]
								//当能获取到组织机构代码时，执行比较，否则不执行
								$.each(dwdms,function(key,value)
								{
									if(value == dwdm)
									{
										addTtem(containerIdDesitination,rows[i]);
									}
								});
							}
						}
				}
				//如果没有数据
				else
				{
					var rows=$("#"+containerIdSourece).datagrid('getSelections');
					if (rows) 
					{
						for (var i = rows.length - 1; i >= 0; i--) 
						{
							var index = $("#"+containerIdSourece).datagrid('getRowIndex', rows[i]);
							$("#"+containerIdSourece).datagrid('deleteRow', index);
							addTtem(containerIdDesitination,rows[i]);
						}
					}
				}
		}
		//从右往左移
		else
		{
			var rows=$("#"+containerIdSourece).datagrid('getSelections'); 
			if (rows) 
			{
				for (var i=0;i<rows.length;i++)
				{
					var index = $("#"+containerIdSourece).datagrid('getRowIndex', rows[i]);
					$("#"+containerIdSourece).datagrid('deleteRow', index);
					addTtem(containerIdDesitination,rows[i]);
				}
			}
		}
	}
	/**
	  * 向datagrid结果集中添加数据
	 * @param containerId grid容器
	 * @param rows 在datagrid中追加一行数据
	 * @return 
	 */
	function addTtem(containerId,row) 
	{
		$("#"+containerId).datagrid('appendRow',row);
	}
	/**
	 * 确认选中方法
	 */
	this.choseAffirm=function(containerId) 
	{  
		//如果为true，表示用点击“查询”
		if(ryxz_gobal.flag)
		{ 
			if(!param.dw&&param.xzlx)
			{
				var colums=[];
				var i=0;
				$.each(param.colums,function(key,value) {
					colums[i++]=value;
				});
				var param1={};
				param1['url']='components/ryxz/queryInfo.f';
				param1['data']={
						tablename:param.tablename,
						colums:JSON.stringify(colums)
				};
				$("#dw_checkbox").prop("checked", true);
				transportItemsToAnother("yrxz_itemselector_left","yrxz_itemselector_right");
				$('#yrxz_itemselector_left').datagrid('load',{
					tablename:param1.data.tablename,
					colums:param1.data.colums,
					param:_getQueryParam(param),
					orgidField:param.dwdm,
					existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
					rywhere:param.rywhere,
					isClickQuery:"yes"
				});
			}
			else if(param.dw&&!param.xzlx)
			{
				var colums=[];
				var i=0;
				$.each(param.colums,function(key,value) {
					colums[i++]=value;
				});
				var param1={};
				param1['url']='components/ryxz/queryInfo.f';
				param1['data']={
						tablename:param.tablename,
						colums:JSON.stringify(colums)
				};
				$("#dw_checkbox").prop("checked", true);
				transportItemsToAnother("yrxz_itemselector_left","yrxz_itemselector_right");
				$('#yrxz_itemselector_left').datagrid('load',{
					tablename:param1.data.tablename,
					colums:param1.data.colums,
					param:_getQueryParam(param),
					orgidField:param.dwdm,
					existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
					rywhere:param.rywhere,
					isClickQuery:"yes"
				});
			}
			else if(param.dw&&param.xzlx)
			{
					var colums=[];
					var i=0;
					$.each(param.colums,function(key,value) {
						colums[i++]=value;
					});
					var param1={};
					param1['url']='components/ryxz/queryInfo.f';
					param1['data']={
							tablename:param.tablename,
							colums:JSON.stringify(colums)
					};
					$("#dw_checkbox").prop("checked", true);
					transportItemsToAnother("yrxz_itemselector_left","yrxz_itemselector_right");
					$('#yrxz_itemselector_left').datagrid('load',{
						tablename:param1.data.tablename,
						colums:param1.data.colums,
						param:_getQueryParam(param),
						orgidField:param.dwdm,
						existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
						rywhere:param.rywhere,
						isClickQuery:"yes"
					});
			}
			else{}
		}
		//如果用其他方式触发查询
		else
		{  
			if(!param.dw&&param.xzlx)
			{
				var query={};
				query['xzid']=SysTool.getTxtVal("ryxz_xzdm");
				transportItemsToAnother("yrxz_itemselector_left","yrxz_itemselector_right");
				$('#yrxz_itemselector_left').datagrid('load',{
					queryParam:getQueryParam(param),
					query:JSON.stringify(query),
					existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
					rywhere:param.rywhere
				});
			}
			else if(param.dw&&!param.xzlx)
			{
				var colums=[];
				var i=0;
				$.each(param.colums,function(key,value)
				{
					colums[i++]=value;
				});
				var param1={};
				param1['url']='components/ryxz/queryInfo.f';
				param1['data']={
						tablename:param.tablename,
						colums:JSON.stringify(colums)
				};
				$("#dw_checkbox").prop("checked", true);
				transportItemsToAnother("yrxz_itemselector_left","yrxz_itemselector_right");
				$('#yrxz_itemselector_left').datagrid('load',{
					tablename:param1.data.tablename,
					colums:param1.data.colums,
					param:getQueryParam(param),
					orgidField:param.dwdm,
					existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
					rywhere:param.rywhere
				});
			}
			else if(param.dw&&param.xzlx)
			{  
				if($('#radio_dw').is(':checked')) 
				{
					var colums=[];
					var i=0;
					$.each(param.colums,function(key,value) {
						colums[i++]=value;
					});
					var param1={};
					param1['url']='components/ryxz/queryInfo.f';
					param1['data']={
							tablename:param.tablename,
							colums:JSON.stringify(colums)
					};
					$("#dw_checkbox").prop("checked", true);
					transportItemsToAnother("yrxz_itemselector_left","yrxz_itemselector_right");
					$('#yrxz_itemselector_left').datagrid('load',{
						tablename:param1.data.tablename,
						colums:param1.data.colums,
						param:getQueryParam(param),
						orgidField:param.dwdm,
						existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
						rywhere:param.rywhere
					});
				}
				else
				{ 
					var query={};
					query['xzid']=SysTool.getTxtVal("ryxz_xzdm");
					transportItemsToAnother("yrxz_itemselector_left","yrxz_itemselector_right");
					$('#yrxz_itemselector_left').datagrid('load',{
						queryParam:getQueryParam(param),
						query:JSON.stringify(query),
						existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
						rywhere:param.rywhere
					});
				}
			}
			else{}
		}
	}
	/**
	 * 移除方法
	 */
	this.deleteAffirm=function(containerId) 
	{ 
		//如果为true，表示用点击“查询”查询
		if(ryxz_gobal.flag)
		{
			if(!param.dw&&param.xzlx)
			{
				var query={};
				query['xzid']=SysTool.getTxtVal("ryxz_xzdm");
				transportItemsToAnother("yrxz_itemselector_right","yrxz_itemselector_left");
				$('#yrxz_itemselector_left').datagrid('load',{
					queryParam:_getQueryParam(param),
					query:JSON.stringify(query),
					existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
					rywhere:param.rywhere,
					isClickQuery:"yes"
				});
			}
			else if(param.dw&&!param.xzlx) 
			{
				var colums=[];
				var i=0;
				$.each(param.colums,function(key,value) {
					colums[i++]=value;
				});
				var param1={};
				param1['url']='components/ryxz/queryInfo.f';
				param1['data']={
						tablename:param.tablename,
						colums:JSON.stringify(colums)
				};
				//定义一个对象，其值为param.colums,并追加属性pk
				$("#dw_checkbox").prop("checked", true);
				transportItemsToAnother("yrxz_itemselector_right","yrxz_itemselector_left");
				$('#yrxz_itemselector_left').datagrid('load',{
					tablename:param1.data.tablename,
					colums:param1.data.colums,
					param:_getQueryParam(param),
					orgidField:param.dwdm,
					existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
					rywhere:param.rywhere,
					isClickQuery:"yes"
				});	
			}
			else if(param.dw&&param.xzlx) 
			{
					var colums=[];
					var i=0;
					$.each(param.colums,function(key,value) {
						colums[i++]=value;
					});
					var param1={};
					param1['url']='components/ryxz/queryInfo.f';
					param1['data']={
							tablename:param.tablename,
							colums:JSON.stringify(colums)
					};
					//定义一个对象，其值为param.colums,并追加属性pk
					$("#dw_checkbox").prop("checked", true);
					transportItemsToAnother("yrxz_itemselector_right","yrxz_itemselector_left");
					$('#yrxz_itemselector_left').datagrid('load',{
						tablename:param1.data.tablename,
						colums:param1.data.colums,
						param:_getQueryParam(param),
						orgidField:param.dwdm,
						existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
						rywhere:param.rywhere,
						isClickQuery:"yes"
					});	
			}
			else{}
		}
		//否则用其他方式查询
		else
		{
			if(!param.dw&&param.xzlx)
			{
				var query={};
				query['xzid']=SysTool.getTxtVal("ryxz_xzdm");
				transportItemsToAnother("yrxz_itemselector_right","yrxz_itemselector_left");
				$('#yrxz_itemselector_left').datagrid('load',{
					queryParam:getQueryParam(param),
					query:JSON.stringify(query),
					existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
					rywhere:param.rywhere
				});
			}
			else if(param.dw&&!param.xzlx) 
			{
				var colums=[];
				var i=0;
				$.each(param.colums,function(key,value) {
					colums[i++]=value;
				});
				var param1={};
				param1['url']='components/ryxz/queryInfo.f';
				param1['data']={
						tablename:param.tablename,
						colums:JSON.stringify(colums)
				};
				//定义一个对象，其值为param.colums,并追加属性pk
				$("#dw_checkbox").prop("checked", true);
				transportItemsToAnother("yrxz_itemselector_right","yrxz_itemselector_left");
				$('#yrxz_itemselector_left').datagrid('load',{
					tablename:param1.data.tablename,
					colums:param1.data.colums,
					param:getQueryParam(param),
					orgidField:param.dwdm,
					existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
					rywhere:param.rywhere
				});	
			}
			else if(param.dw&&param.xzlx) 
			{
				if($('#radio_dw').is(':checked'))
				{
					var colums=[];
					var i=0;
					$.each(param.colums,function(key,value) {
						colums[i++]=value;
					});
					var param1={};
					param1['url']='components/ryxz/queryInfo.f';
					param1['data']={
							tablename:param.tablename,
							colums:JSON.stringify(colums)
					};
					//定义一个对象，其值为param.colums,并追加属性pk
					$("#dw_checkbox").prop("checked", true);
					transportItemsToAnother("yrxz_itemselector_right","yrxz_itemselector_left");
					$('#yrxz_itemselector_left').datagrid('load',{
						tablename:param1.data.tablename,
						colums:param1.data.colums,
						param:getQueryParam(param),
						orgidField:param.dwdm,
						existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
						rywhere:param.rywhere
					});	
				}
				else
				{
					var query={};
					query['xzid']=SysTool.getTxtVal("ryxz_xzdm");
					transportItemsToAnother("yrxz_itemselector_right","yrxz_itemselector_left");
					$('#yrxz_itemselector_left').datagrid('load',{
						queryParam:getQueryParam(param),
						query:JSON.stringify(query),
						existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
						rywhere:param.rywhere
					});
				}
			}
			else{}
		}
	}
	/**
	 * 关闭页面
	 */
	this.closeWindow=function()
	{
		SysTool.window.close();
	}
	/**
	 * 
	 * return  data  选中后的数据
	 * 返回数据例子
	 * data={
	 * 			total:10;
	 * 			rows:[{JYXM:"王梅",JYBH:"P5485",ZZJGMC:"三中队"},{},{},...{}];
	 * };
	 */
	this.getChosenData=function(param) 
	{
		var data=$("#yrxz_itemselector_right").datagrid('getData');
		eval(param.commitFun)(data);
	}
	/**
	 * 在页面上展示查询输入框，有几个字段，就展现几个
	 * 如果有单位字段，则单位输入框放在表格上面，否则不放
	 * @param param
	 * @return
	 */
	function showQueryInput(param) 
	{
		if(param.dw&&param.xzlx) 
		{
			var html="";
			$.each(param.colums,function(key,value) {
				html+=getHtml(key,value,param);
			});	
			$("#yrxz_search").html(html);
			var html2="";
			html2="<ul style='float:left;margin:0;padding:0;'>"+
				"<li><span><input type='radio' id='radio_dw' name='radio'  onclick='ryxz.radioDo(1)' checked='checked'/>&nbsp;单位</span>" +
				"<span><input type='radio' name='radio'  onclick='ryxz.radioDo(0)'/>&nbsp;小组</span></li>"+
				"<li id='xz' style='display:none;'><span>小组名称：&nbsp;</span><input id='ryxz_xzdm' type='hidden'/>" +
				"<input type='text' class='all_slect' readonly='readonly' id='ryxz_xz' style='width:275px'/></li>"+
				"<li id='dw'><span style='float:left;'>" +getDwmc(param)+"：</span>"+
				"<input type='hidden' id='yrxz_search_dwdmsData'/>"+
				"<input type='hidden' id='yrxz_search_dwdm'/>"+
				"<input type='text' readonly='readonly'  class='all_slect'  style='width:170px;float:left;'" +
				'id="yrxz_search_dwmc" onExit="ryxz.clickZzjg(\'yrxz_itemselector_left\');"/> '+
				"<div id='yrxz_search_dw_Div' style='display:none;float:left;' ></div>" +
				"<span style='float:left;'>&nbsp;&nbsp;显示下属机构人员：</span><input style='float:left;' type='checkbox'" +
				"id='dw_checkbox' onclick='ryxz.clickZzjg(&quot;yrxz_itemselector_left&quot;);' title='当勾选该复选框时,出现下属机构人员'/></li>" +
				"</ul>";
			$("#yrxz_search_dw").html(html2);
			Dictionary.initDictionaryList({"url": "dictionary/getXzmc.f", "data": {"zdbh": param.xzlx}, "dictShowId": "ryxz_xz", "dictContainerReferenceObjectId": "body", "initVal": ""}, function() {
				onExistXzmc();
			},function() 
			{
				var li = $('#body').find('li');
				if (li.length > 0)
				{
					
					var reg = new RegExp("^[0-9]*$");  
					var t=li.text().split("|")[0];
					var f=t.substring(t.length-7,t.length);
				    if(!reg.test(f))
				    {  
				    	$('#ryxz_xzdm').val("");
					 }
				    else
				   {
						$('#ryxz_xz').val(li.text().split("|")[1]);
						$('#ryxz_xzdm').val(f);
				   }
				}
			});
			initZzjg();
		}
		else if(!param.dw&&param.xzlx) 
		{
			var html="";
			$.each(param.colums,function(key,value) {
				html+=getHtml(key,value,param);
			});	
			$("#yrxz_search").html(html);
			var html2="<ul style='float:left;'>"+
			"<li><span>小组名称：&nbsp;</span><input id='ryxz_xzdm' type='hidden'/>" +
			"<input type='text' class='all_slect' readonly='readonly' id='ryxz_xz' style='width:275px'/></li>"+
			"</ul>";
			$("#yrxz_search_dw").html(html2);	
			 //用于表单输入
			Dictionary.initDictionaryList({"url": "dictionary/getXzmc.f", "data": {"zdbh": param.xzlx}, "dictShowId": "ryxz_xz", "dictContainerReferenceObjectId": "body", "initVal": ""}, function() {
				onExistXzmc();
			});
			initZzjg();
		}
		else if(param.dw&&!param.xzlx) 
		{
			var html1="";
			var html2="<ul style='float:left;margin:0;padding:0;'>"+
			"<li><span style='float:left;'>" +getDwmc(param)+"：</span>"+
			"<input type='hidden' id='yrxz_search_dwdmsData'/>"+
			"<input type='hidden' id='yrxz_search_dwdm'/>"+
			"<input type='text' readonly='readonly'  class='all_slect'  style='width:170px;float:left;'" +
			'id="yrxz_search_dwmc" onExit="ryxz.clickZzjg(\'yrxz_itemselector_left\');"/> '+
			"<div id='yrxz_search_dw_Div' style='display:none;float:left;' ></div>" +
			"<span style='float:left;'>&nbsp;&nbsp;显示下属机构人员：</span><input style='float:left;' type='checkbox'" +
			"id='dw_checkbox' onclick='ryxz.clickZzjg(&quot;yrxz_itemselector_left&quot;);' title='当勾选该复选框时,出现下属机构人员'/></li>" +
			"</ul>";
			$("#yrxz_search_dw").html(html2);	
			//组织机构初始化
			initZzjg();
			$.each(param.colums,function(key,value) {
				html1+=getHtml(key,value,param);
			});	
			$("#yrxz_search").html(html1);	
		}
		else
		{
			var html="";
			$.each(param.colums,function(key,value) {
				html+=getHtml(key,value,param);
			});	
			$("#yrxz_search").html(html);	
		}
	}
	/**
	 * 单选框点击事件的方法
	 */
	this.radioDo=function(tag)
	{
		ryxz_gobal.flag=false;
		if(tag == 1)
		{
			$("#xz").hide();
			$("#dw").show();
			var colums=[];
			var i=0;
			$.each(param.colums,function(key,value) {
				colums[i++]=value;
			});
			colums[i]=param.pk;
			var param1={};
			param1['url']='components/ryxz/queryInfo.f';
			param1['data']={
					tablename:param.tablename,
					colums:JSON.stringify(colums)
			};
			var t={};
			t=param.colums;
			t['pk']=param.pk;
			if(param.dwdm)
			{
				t['dwdm']=param.dwdm;
			}
			itemInitGridLeft("yrxz_itemselector_left",param1,t,param);
		}
		else if(tag == 0)
		{
			$("#dw").hide();
			$("#xz").show();
			onExistXzmc();
		}
	}
	/**
	 * 选择小组名称
	 */
	function onExistXzmc() 
	{
		ryxz_gobal.flag=false;
		var t={};
		t=param.colums;
		t['pk']=param.pk;
		if(param.dwdm != undefined&&param.dwdm != ""&&param.dwdm != null)
		{
			t['dwdm']=param.dwdm;
		}
		var query={};
		query['xzid']=SysTool.getTxtVal("ryxz_xzdm");
		$("#yrxz_itemselector_left").datagrid({
			 width: 340,
			 height: 377,//表格高度
	         singleSelect:false, //是否单选
	         rownumbers : false,//是否显示行号
	         nowrap: true,//是否把数据显示在一行
	         fitColumns : true,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
	         border: true,//是否显示边框
	         pagination: true,//是否分页
	         remoteSort: false,//是否远端排序，这会消耗带宽
	         pageSize : 10,//如果pagination为true，这个值才有意义，初始化页面大小
	         pageList : [10, 15, 20, 25, 30 ],
	         loadFilter:function(data)
	         {
					//获取数据源map:{"jyxm":"name","jybh":"policenum","guuid":"id"},map:{jyxm:name,jybh:policenum,guuid:id},
				    var dataRe={};
				    dataRe.total=data.total;
				    dataRe.rows=data.rows;
					if(data.total != 0) 
					{
						if(param.map)
						{
								var tempRows=data.rows;
								var tempArray=[];
								$.each(tempRows,function(key,value) {
									var temp={};
									$.each(param.map,function(key1,value1) {
										temp[key1.toUpperCase()]=value[value1];
									});
									tempArray.push(temp);
								});
						dataRe.rows=tempArray;
						}
					}
					var dataRows=$("#yrxz_itemselector_right").datagrid('getData').rows;
					SysTool.setTxtVal("yrxz_search_dwdmsData", JSON.stringify(data['dwdmList']));
					$.each(dataRe.rows,function(key1,value1) {
						$.each(dataRows,function(key2,value2) {
							if(value1[param.pk.toUpperCase()] == value2[param.pk.toUpperCase()]) 
							{
								dataRe.total--;
								 delete dataRe.rows[key1]//删除数组元素,减小相应长度
							}
						});
					});
					dataRe.rows=$.grep(dataRe.rows,function(x,i)
					   {
						if(x != undefined&&x != null)
						{
							return x;
						}
						});
					return dataRe;
					},
	         queryParams :{
					queryParam:getQueryParam(param),
					query:JSON.stringify(query),
					existedData:JSON.stringify(getExistedData(param))//右边方框中已存在数据
				},
	         url :'pzgl/xlxzcy/queryInfo.f',//查询地址
	         frozenColumns:getColums(t,true),//冻结复选框列
	         columns : getColums(t,false),
	         onDblClickRow:function(rowIndex,rowData){
				transportItemsToAnother("yrxz_itemselector_left","yrxz_itemselector_right");
			}
		});
	};
	/**
	 * 获取html内容
	 * @param key
	 * @param value
	 * @return
	 */
	function getHtml(key,value,param) {
		var html="<ul style='float:left;margin:0;padding:0;'><li><span>"+key+"：</span><input  id='yrxz_search_"+value+"' class='all_inputtext'  type='text' style='width:230px'/></li></ul>";
		if(param.dw == value)
		{
			return "";
		}
		return  html;
	}
	/**
	 * 当param.dw不为空时，返回单位名称
	 * @param param
	 * @return
	 */
	function getDwmc(param) {
		var dwmc="";
		for(var p in param.colums) {
			if(param.dw == param.colums[p])
			{
				return p;
			}
		}
	}
	/**
	 * 应用单位组织机构
	 * @return
	 */
	function initZzjg()
	{
		//应用单位组织机构树
		//应用于表单查询输入框
		Dictionary.initDictTree({url: "dictionary/getOrganizationDictTreeJSON.f", zdbh: "D_ORG_JJGXDW", zdmc: "组织机构", zzjgdm: ywjgdm, auth: "10", dictDataDivId: "yrxz_search_dw_Div"}, function(){
			Dictionary.beforeCreateDictTree({createCount: 1, zdbh: "D_ORG_JJGXDW", treeData: data_D_ORG_JJGXDW, dictDataDivId: "yrxz_search_dw_Div"});
			Dictionary.createDictTree({dictObject: D_ORG_JJGXDW, treeData: data_D_ORG_JJGXDW_1, isLeaf: false, dictHiddenId: "yrxz_search_dwdm", dictShowId: "yrxz_search_dwmc",initVal: jjrdwbh, dictContainerReferenceObjectId: "body"});
		});
	}
	/**
	 * 获取查询参数，用于发送后台
	 * @param param
	 * @return 
	 */	
	function getQueryParam(param) 
	{
		//当单位和小组都存在时
		if(param.dw&&param.xzlx)
		{
			//当单位被点击时
			if($('#radio_dw').is(':checked'))
			{
				var re={};
				$.each(param.colums,function(key,value) {
					if(key != 'pk')
					{
						re[""+value+""]=SysTool.getTxtVal("yrxz_search"+value);
					}
				});
				if(param.dwdm)
				{
					re[""+param.dwdm+""]=SysTool.getTxtVal("yrxz_search_dwdm");
					re['ischecked']=$("#dw_checkbox").attr("checked")?false:true;
				}
				return JSON.stringify(re);
			}
			//当小组被点击时
			else
			{
				var re={};
				$.each(param.colums,function(key,value)
				{
					if(key != 'pk') 
					{
						$.each(param.map,function(key1,value1) {
							if(value == key1)
							{
								re[""+value1+""]=SysTool.getTxtVal("yrxz_search"+value);
							}
						});
					}
				});
				return JSON.stringify(re);
			}
		}
		//当只有小组时
		else if(!param.dw&&param.xzlx)
		{
			var re={};
			$.each(param.colums,function(key,value)
			{
				if(key != 'pk') 
				{
					$.each(param.map,function(key1,value1)
					{
						if(value == key1)
						{
							re[""+value1+""]=SysTool.getTxtVal("yrxz_search"+value);
						}
					});
				}
			});
			return JSON.stringify(re);
		}
		//当只有单位时
		else if(param.dw&&!param.xzlx)
		{
			var re={};
			$.each(param.colums,function(key,value) 
		   {
				if(key != 'pk')
				{
					re[""+value+""]=SysTool.getTxtVal("yrxz_search"+value);
				}
			});
			if(param.dwdm)
			{
				re[""+param.dwdm+""]=SysTool.getTxtVal("yrxz_search_dwdm");
				re['ischecked']=$("#dw_checkbox").attr("checked")?false:true;
			}
			return JSON.stringify(re);
		}
		//当单位和小组都不存在时，几乎不可能
		else{}
	}
	/**
	 * 获取查询参数，用于发送后台,通过点击查询时用
	 * 此方法专门用于通过点击“查询”查询
	 * @param param
	 * @return 
	 */	
	function _getQueryParam(param) 
	{
		if(param.dw&&param.xzlx)
		{
			var re={};
			$.each(param.colums,function(key,value) 
			{
				if(key != 'pk')
				{
					re[""+value+""]=SysTool.getTxtVal("yrxz_search_"+value);
				}
			});
			if(param.dwdm)
			{
				re[""+param.dwdm+""]=SysTool.getTxtVal("yrxz_search_dwdm");
				re['ischecked']=$("#dw_checkbox").attr("checked")?false:true;
			}
			return JSON.stringify(re);
		}
		else if(!param.dw&&param.xzlx)
		{
			var re={};
			$.each(param.colums,function(key,value) 
			{
				if(key != 'pk')
				{
					re[""+value+""]=SysTool.getTxtVal("yrxz_search_"+value);
				}
			});
			if(param.dwdm)
			{
				re[""+param.dwdm+""]=SysTool.getTxtVal("yrxz_search_dwdm");
				re['ischecked']=$("#dw_checkbox").attr("checked")?false:true;
			}
			return JSON.stringify(re);
		}
		else if(param.dw&&!param.xzlx)
		{
			var re={};
			$.each(param.colums,function(key,value)
			{
				if(key != 'pk')
				{
					re[""+value+""]=SysTool.getTxtVal("yrxz_search_"+value);
				}
			});
			if(param.dwdm)
			{
				re[""+param.dwdm+""]=SysTool.getTxtVal("yrxz_search_dwdm");
				re['ischecked']=$("#dw_checkbox").attr("checked")?false:true;
			}
			return JSON.stringify(re);
		}
		else{}
	}
	/**
	 * 清空输入框，如果有数据的话
	 * @return
	 */
	this.clearInput=function() 
	{
		$.each(param.colums,function(key,value) {
			if(key != 'pk')
			{
				SysTool.setTxtVal("yrxz_search_"+value,null);
			}
		});
	};
	/**
	 * 对外提供的查询方法
	 */
	this.query=function(containerId) {
		ryxz_gobal.flag=true;
		if(param.dw&&param.xzlx)
		{
			if($('#radio_dw').is(':checked'))
			{
				var colums=[];
				var i=0;
				$.each(param.colums,function(key,value) {
					colums[i++]=value;
				});
				var param1={};
				param1['url']='components/ryxz/queryInfo.f';
				param1['data']={
						tablename:param.tablename,
						colums:JSON.stringify(colums)
				};
				//showQueryInput(param);
				$('#yrxz_itemselector_left').datagrid('load',{
					tablename:param1.data.tablename,
					colums:param1.data.colums,
					param:_getQueryParam(param),
					orgidField:param.dwdm,
					//右边方框中已存在数据
					existedData:JSON.stringify(getExistedData(param)),
					rywhere:param.rywhere,
					isClickQuery:"yes"
				});
			}
			else
			{
				var colums=[];
				var i=0;
				$.each(param.colums,function(key,value) {
					colums[i++]=value;
				});
				colums[i]=param.pk;
				var param1={};
				param1['url']='components/ryxz/queryInfo.f';
				param1['data']={
						tablename:param.tablename,
						colums:JSON.stringify(colums)
				};
				var t={};
				t=param.colums;
				t['pk']=param.pk;
				if(param.dwdm)
					t['dwdm']=param.dwdm;
				_itemInitGridLeft("yrxz_itemselector_left",param1,t,param);
			}
		}
		else if(!param.dw&&param.xzlx) 
		{
			var query={};
			query['xzid']=SysTool.getTxtVal("ryxz_xzdm");
			$('#yrxz_itemselector_left').datagrid('load',{
				queryParam:_getQueryParam(param),
				query:JSON.stringify(query),
				existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
				rywhere:param.rywhere,
				isClickQuery:"yes"
			});
		}
		else if(param.dw&&!param.xzlx) 
		{
			var colums=[];
			var i=0;
			$.each(param.colums,function(key,value) {
				colums[i++]=value;
			});
			var param1={};
			param1['url']='components/ryxz/queryInfo.f';
			param1['data']={
					tablename:param.tablename,
					colums:JSON.stringify(colums)
			};
			//showQueryInput(param);
			$('#yrxz_itemselector_left').datagrid('load',{
				tablename:param1.data.tablename,
				colums:param1.data.colums,
				param:_getQueryParam(param),
				orgidField:param.dwdm,
				existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
				rywhere:param.rywhere,
				isClickQuery:"yes"
			});
		}
		else{}
	};
	/**
	 * 对外提供的组织机构选择方法
	 */
	this.clickZzjg=function(containerId) 
	{
		ryxz_gobal.flag=false;
		var colums=[];
		var i=0;
		$.each(param.colums,function(key,value) {
			colums[i++]=value;
		});
		var param1={};
		param1['url']='components/ryxz/queryInfo.f';
		param1['data']={
				tablename:param.tablename,
				colums:JSON.stringify(colums)
		};
		//showQueryInput(param);
		$('#yrxz_itemselector_left').datagrid('load',{
			tablename:param1.data.tablename,
			colums:param1.data.colums,
			param:getQueryParam(param),
			orgidField:param.dwdm,
			existedData:JSON.stringify(getExistedData(param)),//右边方框中已存在数据
			rywhere:param.rywhere
		});
	};
	
	/**
	 * 判断一个对象是否为空对象
	 * @param o
	 * @return
	 */
	function isEmptyObject(o)
	{
	    for(var n in o)
	    {
	        return false;
	    }
	    return true;
	}
}
//定义flag，用于判断是哪种查询你方式,true为点击“查询”时查询
var ryxz_gobal = {flag:true};















