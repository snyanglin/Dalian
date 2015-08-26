if(typeof RyJwryBzxxhsb == "undefined" || !RyJwryBzxxhsb){
	var RyJwryBzxxhsb = {};
};
/**
 * @title:Jquery
 * @description:初始化核实下发
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-06-15 15:57:53
 */
$(function(){
	//加载境外人员办证核实列表
	RyJwryBzxxhsb.onloadDatagrid();
});
/**
 * @title:onloadDatagrid
 * @description:加载境外人员办证核实列表
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-06-17 15:59:32
 */
RyJwryBzxxhsb.onloadDatagrid = function(){
	$("#dg").datagrid({
		url:contextPath+"/jwrybzxxhs/queryJwryHsxf",
		selectOnCheck:true,
		checkOnSelect:true,
		singleSelect:true,
		fitColumns:true,
		border:false,
		columns:[[
	          {field:'sjzt',title:'状态',width:40,align:'center',halign:'center',dictName:contextPath+'/common/dict/D_JWRY_BZHSZT.js',
	        	  formatter:function(value,row,index){
						var val = "";
						var opts = $(this);
						if (opts[0].dictName) {
							try {
								val = window.top.getDictName(opts[0].dictName, value);
								if(value=="0"){
									val = "<span style='color:red;'>"+val+"</span>";
								}else if(value=="1"){
									val = "<span style='color:green;'>"+val+"</span>";
								}
							}
							catch (err) {}
						}
						return val;
				  }
	          },
	          {field:'paperType',title:'证件种类',width:70,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_JWRY_CRJ_ZJZLB.js'},
	          {field:'paperNO',title:'证件号码',width:70,align:'center',halign:'center'},
	          {field:'surnameEN',title:'英文姓',width:60,align:'center',halign:'center'},
	          {field:'firstnameEN',title:'英文名',width:60,align:'center',halign:'center'},
	          {field:'nameCH',title:'中文姓名',width:60,align:'center',halign:'center'},
	          {field:'gender',title:'性别',width:40,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_JWRY_CRJ_XBB.js'},
	          {field:'birthday',title:'出生日期',width:60,align:'center',halign:'center'},
	          {field:'inhabiDetailAddr',title:'居住地',width:120,align:'center',halign:'center'},
	          {field:'workplaceDetailAddr',title:'工作地',width:120,align:'center',halign:'center'},
	          {field:'sjddrq',title:'数据到达日期',width:80,align:'center',halign:'center'},
	          {field:'op',title:'操作',width:90,align:'center',halign:'center',formatter:RyJwryBzxxhsb.datagridProcessFormater}
		]],
		toolbar:'#datagridToolbar',
		rownumbers:true
	});
};
/**
 * @title:queryButton
 * @description:查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-06-17 16:12:35
 */	
RyJwryBzxxhsb.queryButton = function(){
	var paperType = document.getElementById("paperType").value;
	var paperNO = document.getElementById("paperNO").value;
	var surnameEN = document.getElementById("surnameEN").value;
	var firstnameEN = document.getElementById("firstnameEN").value;
	var inhabiDetailAddr = document.getElementById("inhabiDetailAddr").value;
	var workplaceDetailAddr = document.getElementById("workplaceDetailAddr").value;
	var sjzt = document.getElementById("sjzt").value;
	//加载查询列表
	$('#dg').datagrid('load',{    
		'paperType':paperType,
		'paperNO':paperNO,
		'surnameEN':surnameEN,
		'firstnameEN':firstnameEN,
		'inhabiDetailAddr':inhabiDetailAddr,
		'workplaceDetailAddr':workplaceDetailAddr,
		'sjzt':sjzt
	});
};
/**
 * @title:clearCase
 * @description:重置查询条件
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-06-18 10:51:43
 */
RyJwryBzxxhsb.clearCase = function(){
	$("#queryForm").form("reset");
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-06-25 10:29:54
 */
RyJwryBzxxhsb.datagridProcessFormater = function(val,row,index){
    if(row.sjzt=="0"){
    	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="RyJwryBzxxhsb.openJzdSh('+index+')">居住地核实</a>&nbsp;'+
    	       '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="RyJwryBzxxhsb.openSh('+index+')">退回上级</a>&nbsp;';
    }else if(row.sjzt=="1"){
    	return '&nbsp;已核实反馈&nbsp;';
    }
};
/**
 * @title:openJzdSh
 * @description:打开居住地核实页面
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-08-10 09:39:32
 */
RyJwryBzxxhsb.openJzdSh = function(index){
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var url = contextPath + "/jwrybzxxhs/openJzdSh?personNO="+rowData.personNO+"&inhabiBusinessNO="+rowData.inhabiBusinessNO;
	openWindowWithSave(false, null,this.Window, 
		{}, 
   		{
   		title:'居住地信息核实反馈',
   		url:url,
   		maximizable:false,
   		width:700,
   		height:630
   		}, 
   		'您确定要保存吗？',null,null
   	);
};