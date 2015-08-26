if(typeof DzBuildingRoomRoom == "undefined" || !DzBuildingRoom){
	var DzBuildingRoom = {};
};
/**
 * @title:Jquery
 * @description:初始化房间信息展现
 * @author: zhang_guoliang@founder.com
 * @param       
 * @date:2015-05-08 17:32:42
 */
$(function(){
	//加载人口列表
	DzBuildingRoom.initRyList();
});
/**
 * @title:initRyList
 * @description:加载人口列表
 * @author: zhang_guoliang@founder.com
 * @param       
 * @date:2015-05-08 17:33:32
 */
DzBuildingRoom.initRyList = function(){
	$("#ryList").datagrid({
		url:contextPath+"/syrkGl/querySyrk",
		delayCountUrl:contextPath+'/syrkGl/querySyrkCount',
		queryParams:{jzd_dzid:chdzid},
		singleSelect:true,
		showFooter:true,
		fitColumns:false,
		nowrap:true,
		border:false,
		columns:[[
		          {field:'syrkywlxdm',title:'人员类型',width:90,align:'center',
		        	  formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SYRKYWLXDM.js'
		          },
		          {field:'zjhm',title:'证件号码',width:145,align:'center'},
		          {field:'xm',title:'姓名',width:90,align:'center'},
		          {field:'xbdm',title:'性别',width:90,align:'center',
		        	  formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XBDM.js'
		          },
		          {field:'csrq',title:'出生日期',width:100,align:'center'},
		          {field:'process',title:'操作',width:90,align:'center',formatter:DzBuildingRoom.datagridRk}
		]],
		onSelect:function(rowIndex, rowData){
			if(rowData !=undefined){
				$("#xm").html(rowData.xm);
				$("#zjzl").html(window.top.getDictName(contextPath + '/common/dict/KX_D_CYZJDM.js', rowData.cyzjdm));
				$("#zjhm").html(rowData.zjhm);
				$("#csrq").html(rowData.csrq);
				$("#xb").html(window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', rowData.xbdm));
				$("#mz").html(window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js', rowData.mzdm));
				$("#gj").html(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', rowData.gjdm));
				$("#jg").html(window.top.getDictName(contextPath + '/common/dict/GB_D_XZQHDM.js', rowData.jgssxdm));
				$("#jggj").html(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', rowData.jggjdqdm));
				if(rowData.hjd_dzxz!=null){
					$("#hjdz").html(rowData.hjd_dzxz);
				}else{
					$("#hjdz").html(rowData.hjd_mldzxz);
				}
				if(rowData.jzd_dzxz!=null){
					$("#jzdz").html(rowData.jzd_dzxz);
				}else{
					$("#jzdz").html(rowData.jzd_mldzxz);
				}
				$("#thphoto").html("<img width='132'height='160' alt='' src='"+contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid="+rowData.ryid+"&zjhm="+rowData.zjhm+"&cyzjdm="+rowData.cyzjdm+"'/>");
			}
		},
		onLoadSuccess:function(data){
		    $("#ryList").datagrid("selectRow",0);
		    DzBuildingRoom.querySyrkZp(data.rows);
		},
		pageSize:5,
		pageList:[5,10,15,20],
		pagination:true,
		rownumbers:true
	});
};
/**
 * @title:querySyrkZp
 * @description:展现人口列表照片
 * @author: zhang_guoliang@founder.com
 * @param       
 * @date:2015-05-09 17:13:35
 */
DzBuildingRoom.querySyrkZp = function(json){
	var htmlText = "";
	$.each(json,function(i){
		htmlText += "<li><img width='132'height='160' alt='' src='"+contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid="+json[i].ryid+"&zjhm="+json[i].zjhm+"&cyzjdm="+json[i].cyzjdm+"'/></li>";
	});
	$("#xjzryzp").html(htmlText);
};
/**
 * @title:datagridProcessFormater
 * @description:人口列表操作
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 15:26:45
 */	
DzBuildingRoom.datagridRk = function(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzBuildingRoom.doSyrkXq('+index+')">详情</a>&nbsp;';
};
/**
 * @title:datagridProcessFormater
 * @description:单位列表操作
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-09 18:56:35
 */
DzBuildingRoom.datagridDw = function(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzBuildingRoom.doSyDwXq('+index+')">详情</a>&nbsp;';
};
/**
 * @title:doSyrkXq
 * @description:实有人口【详情】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
DzBuildingRoom.doSyrkXq = function(index){
    cancelBubble(); 
	var rows = $('#ryList').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkEdit/"+rowData.ryid+"/"+rowData.id+"/view?mode=view";
	menu_open("实有人口【"+rowData.xm+"】",editUrl);
};
/**
 * @title:doSyDwXq
 * @description:实有单位【详情】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-09 19:16:32
 */
DzBuildingRoom.doSyDwXq = function(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl/view?id="+rowData.id+"&mode=view";
	menu_open("实有单位信息【"+rowData.dwmc+"】",editUrl);
};