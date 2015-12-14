/**
 * 公共服务-装备关联
 * @author liuc
 * date 2014-10-29
 */
/**
 * 类型代码，全局变量
 * 如果放在Zbgl()里面就达不到全局变量效果，因为每次调用Zbgl()的时候，lxdm都会初始化一次
 */
var lxdm="";
var lxmc="";
function Zbgl()
{  
	/**
	 * 公共方法
	 * 装备关联初始化
	 */
	this.initZbgl=function()
	{
		createLeftDataGrid();//生成左边列表
		createZblxList();//生成装备类型选择
	};
	/**
	 * 创建左边datagrid,人员表格
	 * @return
	 */
	function createLeftDataGrid() 
	{
		$("#zbgl_itemselector_left").datagrid({
			 width: 270,
			 height: 218,//表格高度
	         singleSelect:true, //是否单选
	         rownumbers : false,//是否显示行号
	         nowrap: true,//是否把数据显示在一行
	         fitColumns : true,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
	         border: true,//是否显示边框
	         pagination: false,//是否分页
	         remoteSort: false,//是否远端排序，这会消耗带宽
	        queryParams:{jybhs:JSON.stringify(param.jybh)},
	     	url : 'components/zbgl/queryRyInfo.f',//查询地址
	         columns:[[
	                   	 { field: 'ZZJGDM', checkbox: true },
			             {field : 'JYXM',title : '姓名',align: 'left',sortable:true,width:40,halign:'center'}, 
			             {field : 'JYBH',title : '警号',align: 'left',sortable:true,width:40,halign:'center'},
			             {field : 'ZZJGMC',title : '单位',align : 'left',sortable:true,width:60,halign:'center'}
	                   ]],
	          onSelect:function()
	          {
	        		var mapRows=$("#zbgl_yr_zb_map").datagrid('getRows');
	        		var id="";//id作用是为了给一个标识符，让被选择的数据始终处在第一行
	        		$("#zbgl_itemselector_right").datagrid('uncheckAll');
					if(mapRows) 
					{
						var rightRow=$("#zbgl_itemselector_left").datagrid('getSelected');
						if(rightRow) 
						{
							$.each(mapRows,function(key,value) {
								if(value['jybh'] == rightRow['JYBH']&&value['zblx'] == lxdm)
								{
									id=value['id'];
								}
							});
						}
					} 
					$("#zbgl_itemselector_right").datagrid('reload',{
						zblxdm:lxdm,//将装备类型代码传递到后台	
						gjz:SysTool.getTxtVal("zbgl_search_gjz"),
						id:id,
						map_zbids:SysTool.getTxtVal("zbgl_yr_zb_mapData"),
						zbwhere:param.zbwhere,
						checkedRyJgdm:rightRow.ZZJGDM,
						isClickCheckBox: $( '#zbgl_xssy').is( ':checked' )?true:false
					});
	        }
		});
	}
	/**
	 * 创建右边表格,装备表格
	 * @return
	 */
	function createRightDataGrid() 
	{
		$("#zbgl_itemselector_right").datagrid({
			width: 486,
			 height: 218,//表格高度
	         singleSelect:true, //是否单选
	         rownumbers : false,//是否显示行号
	         nowrap: true,//是否把数据显示在一行
	         fitColumns : true   ,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
	         border: true,//是否显示边框
	         pagination: true,//是否分页
	         remoteSort: false,//是否远端排序，这会消耗带宽
	         pageSize : 5,//如果pagination为true，这个值才有意义，初始化页面大小
	         pageList : [5, 10, 15, 20, 30],
	        idField:"id",
	        queryParams:{
			zblxdm:lxdm,//将装备类型代码传递到后台	
			gjz:SysTool.getTxtVal("zbgl_search_gjz"),
			map_zbids:SysTool.getTxtVal("zbgl_yr_zb_mapData"),
			zbwhere:param.zbwhere,
			checkedRyJgdm:"",
			isClickCheckBox: false
			},
	     	url : 'components/zbgl/queryZbInfo.f',//查询地址
	         columns:[[
	                   	 {field:'id',hidden:true},
	                   	 { field: 'zbgldwdm', checkbox: true },
			             {field : 'zbmc',title : '装备名称',align: 'left',sortable:true,width:50,halign:'center'}, 
			             {field : 'zbxh',title : '装备型号',align: 'left',sortable:true,width:50,halign:'center'},
			             {field : 'zbgldw',title : '管理单位',align : 'left',sortable:true,width:100,halign:'center'}
	                   ]],
	         toolbar:[
							{
								text :'&nbsp;<span style="position:relative;top:-6px;left:2px;"  onclick="zbgl.onFocus(\'zbgl_search_gjz\')">关键字：</span>&nbsp;<input class="all_inputtext" type="text" style="width:75px;position:relative;top:-5px;"onMouseDown="zbgl.onFocus(\'zbgl_search_gjz\')" id="zbgl_search_gjz"/>' ,
								handler : function() {
								}
							},
							'-',
							{
								text : '查询',
								iconCls :'icon-search',
								handler : function() {
									var id="";
									var ryJgdm="";
									var mapRows=$("#zbgl_yr_zb_map").datagrid('getRows');
									if(mapRows) 
									{
										var rightRow=$("#zbgl_itemselector_left").datagrid('getSelected');
										if(rightRow)
										{
											$.each(mapRows,function(key,value) {
												if(value['jybh'] == rightRow['JYBH']&&value['zblx'] == lxdm)
												{
													id=value['id'];
												}
											});
											ryJgdm=rightRow.ZZJGDM;
										}
									}
									$("#zbgl_itemselector_right").datagrid('reload',{
										zblxdm:lxdm,//将装备类型代码传递到后台	
										gjz:SysTool.getTxtVal("zbgl_search_gjz"),
										id:id,
										map_zbids:SysTool.getTxtVal("zbgl_yr_zb_mapData"),
										checkedRyJgdm:ryJgdm,
										isClickCheckBox: $( '#zbgl_xssy').is( ':checked' )?true:false
									});
								}
							},
							'-',
							{
								text :'重置' ,
								iconCls : 'icon-undo',
								handler : function() {
									SysTool.setTxtVal("zbgl_search_gjz", null);
								}
							},
							'-',
							{
								text :'<input type="checkbox" id="zbgl_xssy" onclick="zbgl.clickCheckbox();" style="display:inline;margin:-3px 0 0;"/><span style="display:inline;float:left">显示所有</span>',
								handler : function() {
								}
							}
	                  ],
			onLoadSuccess:function()
			{
				     //如果关系已经匹配，那么勾选上该装备额
					//如果某装备被选中，那么消除它
					$("#zbgl_itemselector_right").datagrid('unselectAll');
					var selectedRows_map=$("#zbgl_yr_zb_map").datagrid('getRows');
					var ryRow=$("#zbgl_itemselector_left").datagrid('getSelected');
					if(ryRow)
					{
						for(var i=0;i<selectedRows_map.length;i++) 
						{  
							var dqyh=$("#zbgl_itemselector_right").datagrid('getRows');//获取当前页所有行
							var index=-1;
							if(dqyh.length != 0)
							{
								for(var j=0;j<dqyh.length;j++) 
								{
									if(dqyh[j]['id'] == selectedRows_map[i]['id'])
									{
										//通过id获取行号
										 index=$("#zbgl_itemselector_right").datagrid('getRowIndex',dqyh[j]);
										 break;
									}
								}
							     //当转到其他人员时，删除其他已选装备
								//当遇到匹配时，保留该装备
								if(selectedRows_map[i]['jybh'] == ryRow['JYBH']&&selectedRows_map[i]['zblx'] == lxdm) 
								{
									//勾选装备
									$("#zbgl_itemselector_right").datagrid('selectRecord',selectedRows_map[i]['id']);
									 continue;
								 }
								if(index != -1)
								{
									$("#zbgl_itemselector_right").datagrid('deleteRow',index);
								}
							}
						}
					}
				}
		});
		SysTool.changeIputStyle();
	}
	/**
	 * 输入框触发
	 * @param id
	 * @return
	 */
	this.onFocus=function(id)
	{ 
		$('#'+id).focus();  
	}
	/**
	 * 创建下方的表格,人员装备匹配表格
	 * @return
	 */
	function createDownDataGrid() 
	{
		if(param.data&&!isEmptyObject(param.data))
		{
			$("#zbgl_yr_zb_map").datagrid({
				 width: 780,
				 height: 218,//表格高度
		         singleSelect:false, //是否单选
		         rownumbers : false,//是否显示行号
		         nowrap: true,//是否把数据显示在一行
		         fitColumns : true,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
		         border: true,//是否显示边框
		         idField:"id",
		         pagination: false,//是否分页
		         remoteSort: false,//是否远端排序，这会消耗带宽
		        columns:[[
		                   	 { field: 'zzjgdm', checkbox: true },
		                   	 { field: 'zbgldwdm', hidden: true },
		                   	 {field:'id',hidden:true},//装备id值
		                   	 {field:'zblx',hidden:true},
				             {field : 'jyxm',title : '姓名',align: 'left',sortable:true,width:100,halign:'center'}, 
				             {field : 'jybh',title : '警号',align: 'left',sortable:true,width:100,halign:'center' },
				             {field : 'zzjgmc',title : '单位',align : 'left',sortable:true,width:110,halign:'center'},
				             {field : 'zblxmc',title : '装备类型',align : 'left',sortable:true,width:110,halign:'center'},
				             {field : 'zbmc',title : '装备名称',align: 'left',sortable:true,width:100,halign:'center'}, 
				             {field : 'zbxh',title : '装备型号',align: 'left',sortable:true,width:100,halign:'center'},
				             {field : 'zbgldw',title : '管理单位',align : 'left',sortable:true,width:110,halign:'center'},
				             {field:'cz',title:'操作',width:50,align:'center',
				            	 formatter :function(value, row, index) {
					            	 if (row.id) {
											return rowformater(value, row, index);
										}  
					             }
				             }
		                   ]]
			}).datagrid('loadData',{
				total:param.data.length,
				rows:getExistedRows()
			});
		setValue();//获取匹配关系,取出值放到页面上
		}
		else
			$("#zbgl_yr_zb_map").datagrid({
				 width: 680,
				 height: 218,//表格高度
		         singleSelect:false, //是否单选
		         rownumbers : false,//是否显示行号
		         nowrap: true,//是否把数据显示在一行
		         fitColumns : false,//是否 会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
		         border: true,//是否显示边框
		         pagination: false,//是否分页
		         remoteSort: false,//是否远端排序，这会消耗带宽
		        columns:[[
		                   	 { field: 'zzjgdm', checkbox: true },
		                   	 { field: 'zbgldwdm', hidden: true },
		                   	 {field:'zblx',hidden:true},
		                	 {field:'id',hidden:true},//装备id值
				             {field : 'jyxm',title : '姓名',align: 'left',width:100,halign:'center'}, 
				             {field : 'jybh',title : '警号',align: 'left',width:100,halign:'center'},
				             {field : 'zzjgmc',title : '单位',align : 'left',width:100,halign:'center'},
				             {field : 'zblxmc',title : '装备类型',align : 'left',width:110,halign:'center'},
				             {field : 'zbmc',title : '装备名称',align: 'left',width:100,halign:'center'}, 
				             {field : 'zbxh',title : '装备型号',align: 'left',width:100,halign:'center'},
				             {field : 'zbgldw',title : '管理单位',align : 'left',width:100,halign:'center'},
				             {field:'cz',title:'操作',width:50,align:'center',
				            	 formatter :function(value, row, index) {
					            	 if (row.id) {
											return rowformater(value, row, index);
										}  
					             }
				             }
		                   ]]
			});
	}
	/**
	 * 
	 * @param value
	 * @param row
	 * @param index
	 * @return
	 */
	function rowformater(value, row, index)
	{
		var c1="<div class=''><a class='link_broken' href='javascript:void(0);' onclick='zbgl.opereate(\""+index+ "\");' title='解除'></a>";
		return  c1;
	}
	/**
	 * 创建装备类型列表
	 * @return
	 */
	function createZblxList() 
	{
		var paramQuery={};
		paramQuery['url']='components/zbgl/queryZblxInfo.f';
		SysTool.ajax(paramQuery, function(data,status) {//ajax请求异步，有时有用，有时很蛋疼,如该例子中，设置了全局变量，在其后用它得不到值，就是异步造成的
			if("success" == status){
				var html="<div>";
				$.each(data,function(key,value){
					if(key == 0)
					{
						lxdm=value['zblxdm'];
						lxmc=value['zblxmc'];
						html1="<input type='hidden'  id='zblxdm_"+value['zblxdm']+"'  value='"+value['zblxdm']+"'/>" +
						"<input type='radio' name='radio' checked='checked' onclick='zbgl.clickRaido(&quot;"+value['zblxdm']+"&quot;,&quot;"+value['zblxmc']+"&quot;)' />"+value['zblxmc']+"&nbsp";
						}
					else
					{
						html1="<input type='hidden'  id='zblxdm_"+value['zblxdm']+"'  value='"+value['zblxdm']+"'/>" +
						"<input type='radio' name='radio'  onclick='zbgl.clickRaido(&quot;"+value['zblxdm']+"&quot;,&quot;"+value['zblxmc']+"&quot;)' />"+value['zblxmc']+"&nbsp";
					}
					html+=html1;
				});
				html=html+"</div>";
			$("#zbgl_zblxList").html(html);
			createDownDataGrid();//生成下边列表
			createRightDataGrid();//生成右边列表
			}
			else
			{
				SysTool.alert("查询数据库失败", "'");
			}
	   });
	}
	/** 
	 * 点击Radio触发方法
	 */
	this.clickRaido=function(cliceklxdm,clicklxmc) 
	{
		var id="";//装备id
		var ryJgdm="";//机构代码
		var mapRows=$("#zbgl_yr_zb_map").datagrid('getRows');
		if(mapRows)
		{
			var rightRow=$("#zbgl_itemselector_left").datagrid('getSelected');
			if(rightRow) 
			{
				$.each(mapRows,function(key,value) {
					if(value['jybh'] == rightRow['JYBH']&&value['zblx'] == cliceklxdm)
						id=value['id'];
				});
				ryJgdm=rightRow.ZZJGDM;
			}
		}
		lxdm=cliceklxdm;
		lxmc=clicklxmc;
		$("#zbgl_itemselector_right").datagrid('reload',{
			zblxdm:cliceklxdm,//将装备类型代码传递到后台	
			gjz:SysTool.getTxtVal("zbgl_search_gjz"),
			id:id,
			zbwhere:param.zbwhere,
			map_zbids:SysTool.getTxtVal("zbgl_yr_zb_mapData"),
			checkedRyJgdm:ryJgdm,
			isClickCheckBox: $( '#zbgl_xssy').is( ':checked' )?true:false
		});
	};
	/**
	 * 点击复选框触发的方法
	 */
	this.clickCheckbox=function() 
	{ 
		var id="";//装备id
		var ryJgdm="";//机构代码
		var mapRows=$("#zbgl_yr_zb_map").datagrid('getRows');
		if(mapRows)
		{
			var rightRow=$("#zbgl_itemselector_left").datagrid('getSelected');
			if(rightRow) 
			{
				$.each(mapRows,function(key,value) {
					if(value['jybh'] == rightRow['JYBH']&&value['zblx'] == lxdm)
						id=value['id'];
				});
				ryJgdm=rightRow.ZZJGDM;
			}
		}  
		$("#zbgl_itemselector_right").datagrid('reload',{
			zblxdm:lxdm,//将装备类型代码传递到后台	
			gjz:SysTool.getTxtVal("zbgl_search_gjz"),
			id:id,
			zbwhere:param.zbwhere,
			map_zbids:SysTool.getTxtVal("zbgl_yr_zb_mapData"),
			checkedRyJgdm:ryJgdm,
			isClickCheckBox: $( '#zbgl_xssy').is( ':checked' )?true:false
		}); 
	};
	/**
	 * 确认人员与装备匹配方法
	 */
	this.affirm=function() 
	{   
		var rows=$("#zbgl_yr_zb_map").datagrid('getRows');
		if("" != rows)
		{ 
			var row1=$("#zbgl_itemselector_left").datagrid('getChecked');
			var row2=$("#zbgl_itemselector_right").datagrid('getSelected');
			if(row1.length != 0){
				//当某个装备已被选择时，另一个人也就无法再选了
					if(row2 != null)
					{
						var temparray=JSON.parse(SysTool.getTxtVal("zbgl_yr_zb_mapData"));
						for(var i=0;i<temparray.length;i++) 
						{
							if(temparray[i]['id'] == row2['id']) 
							{
								if(temparray[i]['jyxm'] == row1[0]['JYXM'])
								{
									break;
								}
								else
								{
									SysTool.alert("该装备已被&quot;"+temparray[i]['jyxm']+"&quot;选择，所以无法被&quot;"+row1[0]['JYXM']+"&quot;再次选择", "");
									return;
								}
							}
						}
					}
					//当某个人第二次选中同一个装备时,删除前一次被选择的装备;
					 for(var i=0;i<rows.length;i++)
					 {
						 if(row1[0]['JYBH'] == rows[i]['jybh'])
						 {
							 if(lxdm == rows[i]['zblx'])
							 {
								 //只要某个人再次点击到相同装备类型下的装备时，上一次选择的装备即可删除。
								 var index=$("#zbgl_yr_zb_map").datagrid('getRowIndex',rows[i]);
								 $("#zbgl_yr_zb_map").datagrid('deleteRow',index);
							 }
						 }
					 }
			}
			 row();
		}
		else
		{
			row();
		}
		//获取所有匹配关系,取出值放到页面上
		setValue();
	}
	/**
	 * 此函数的作用是为了减少代码的重复，为了affirm()重用！
	 * 向匹配表中插入数据（人员+装备）
	 * @return
	 */
	function row()
	{ 
		var row1=$("#zbgl_itemselector_left").datagrid('getChecked');
		var row2=$("#zbgl_itemselector_right").datagrid('getChecked');
		if("" != row1&&"" != row2)
		{
			var row={};
			$.each(row1,function(key,value){
				row['zzjgdm']=value['ZZJGDM'];
			    row['jyxm']=value['JYXM'];
			    row['jybh']=value['JYBH'];
			   row['zzjgmc']=value['ZZJGMC'];
			});
			$.each(row2,function(key,value){
				row['zbgldwdm']=value['zbgldwdm'];
			    row['zbmc']=value['zbmc'];
			    row['zbxh']=value['zbxh'];
			   row['zbgldw']=value['zbgldw'];
			   row['id']=value['id'];
			});
			row['zblx']=lxdm;
			row['zblxmc']=lxmc;
			$("#zbgl_yr_zb_map").datagrid('insertRow',{
				index:0,
				row:row
			});
		}
		else
		{
			SysTool.alert("人员或装备二者都要选择之后，才能进行关联", "")
			return;
		}
	}
	/**
	 * 删除匹配关系
	 * @return
	 */
	function deletemap()
	{
		var selectedRow = $('#zbgl_yr_zb_map').datagrid('getSelections');
		if (!selectedRow || selectedRow.length  ==  0) 
		{
			SysTool.alert("请选择需要解除绑定的人员装备关联！");
			return;
		}
	    SysTool.confirm('确认要将选中的人员装备关联解除吗?', function(r) {
			if (r)
			{
				if (selectedRow) 
				{
					for (var i = selectedRow.length - 1; i >= 0; i--) 
					{
						var index = $("#zbgl_yr_zb_map").datagrid('getRowIndex', selectedRow[i]);
						$("#zbgl_yr_zb_map").datagrid('deleteRow', index);
					}
				}
			}
			//获取匹配关系,取出值放到页面上
			  setValue();
			   //解绑的时候，刷新装备列表，以显示解除绑定的装备
			    var mapRows=$("#zbgl_yr_zb_map").datagrid('getRows');
				var id="";//id作用是为了给一个标识符，让被选择的数据始终处在第一行
				var ryJgdm="";//人员机构代码
				$("#zbgl_itemselector_right").datagrid('uncheckAll');
				if(mapRows) 
				{
					var rightRow=$("#zbgl_itemselector_left").datagrid('getSelected');
					if(rightRow) 
					{
						$.each(mapRows,function(key,value) {
							if(value['jybh'] == rightRow['JYBH']&&value['zblx'] == lxdm)
								id=value['id'];
						});
						ryJgdm=rightRow.ZZJGDM;
					}
				} 
				$("#zbgl_itemselector_right").datagrid('reload',{
					zblxdm:lxdm,//将装备类型代码传递到后台	
					gjz:SysTool.getTxtVal("zbgl_search_gjz"),
					id:id,
					zbwhere:param.zbwhere,
					map_zbids:SysTool.getTxtVal("zbgl_yr_zb_mapData"),
					checkedRyJgdm:ryJgdm,
					isClickCheckBox: $( '#zbgl_xssy').is( ':checked' )?true:false
				});
	    });
	}
	/**
	 * 关闭页面
	 */
	this.closeWindow=function() 
	{
		SysTool.window.close();
	};
	/**
	 * 点击确认方法
	 */
	this.getChosenData=function() 
	{
		var data=$("#zbgl_yr_zb_map").datagrid('getRows');
		if("" != param.commitFun)
			eval(param.commitFun)(data,selectExistZb);
	};
	/**
	 * 传递进来的参数，将需要的匹配勾上
	 * @param zbidStr
	 * @return
	 */
	function selectExistZb(zbidStr)
	{
		var temp=zbidStr.split(",");
		for(var i=0;i<temp.length;i++) 
		{
			$("#zbgl_yr_zb_map").datagrid('selectRecord',temp[i]);
		}
	}
	/**
	 * 解除绑定
	 */
	this.openLock=function()
	{
		deletemap();
	};
	/**
	 * 操作
	 */
	this.opereate=function(index) 
	{
		$('#zbgl_yr_zb_map').datagrid('clearSelections');
	 	$('#zbgl_yr_zb_map').datagrid("selectRow", index);
		deletemap();
		$('#zbgl_yr_zb_map').datagrid('clearSelections');
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
	/**
	 * 此方法作用是为了代码复用，
	 * 获取匹配关系,取出值放到页面上
	 * @return
	 */
	function setValue() 
	{
		//获取匹配关系,取出值放到页面上
		var mapData=$("#zbgl_yr_zb_map").datagrid('getData');
		var temp=[];
		$.each(mapData.rows,function(key,value) {
			var tempObject={};
			tempObject['jybh']=value['jybh'];
			tempObject['id']=value['id'];
			tempObject['jyxm']=value['jyxm'];
			temp.push(tempObject);
		});
		SysTool.setTxtVal("zbgl_yr_zb_mapData", null);
		SysTool.setTxtVal("zbgl_yr_zb_mapData", JSON.stringify(temp));
	}
	/**
	 * 通过参数获取匹配值
	 * @return
	 */
	function getExistedRows() 
	{
		var re=[];
		$.ajax({
			 type: "post",  
			 url: "components/zbgl/query.f",
			 data: {'query':JSON.stringify(param.data)},	
			 dataType: "JSON",
			 async: false,//同步调用
			 success:function(data) {
		      	for(var i=0;i<data.length;i++)
		      	{
		      		var temp={};
		      		temp['zzjgdm']=data[i]['ZZJGDM'];
		      		temp['jyxm']=data[i]['JYXM'];
		      		temp['jybh']=data[i]['JYBH'];
		      		temp['zzjgmc']=data[i]['ZZJGMC'];
		      		temp['zbgldwdm']=data[i]['ZBGLDWDM'];
		      		temp['zbmc']=data[i]['ZBMC'];
		      		temp['zbxh']=data[i]['ZBXH'];
		      		temp['zbgldw']=data[i]['ZBGLDW'];
		      		temp['id']=data[i]['ID'];
		      		temp['zblx']=data[i]['ZBLX'];
		      		temp['zblxmc']=data[i]['ZBLXMC'];
		      	 	re.push(temp); 
		      	}
			}
		});
		return re;
	}
}






















