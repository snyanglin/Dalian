if(typeof RyJwryrczfb == "undefined" || !RyJwryrczfb){
	var RyJwryrczfb = {};
};
/**
 * @title:Jquery
 * @description:初始化走访下发
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-06-15 15:57:53
 */
$(function(){
	//加载境外人员办证走访列表
	RyJwryrczfb.onloadDatagrid();
	//设置只读属性
	RyJwryrczfb.onloadReadonly();
});
/**
 * @title:onloadReadonly
 * @description:设置只读属性
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-06-26 11:31:32
 */
RyJwryrczfb.onloadReadonly = function(){
	if(orglevel=="32"||orglevel=="50"){
		$('#jzd_gxdwdm').combobox('setValue', userOrgCode);
		$('#gzd_gxdwdm').combobox('setValue', userOrgCode);
		//居住地管辖单位【只读】
		setInputReadonly('jzd_gxdwdm', true);
		//工作地管辖单位【只读】
		setInputReadonly('gzd_gxdwdm', true);
	}else{
		$('#dg').datagrid('hideColumn','op');
	}
};
/**
 * @title:onloadDatagrid
 * @description:加载境外人员办证走访列表
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-06-17 15:59:32
 */
RyJwryrczfb.onloadDatagrid = function(){
	$("#dg").datagrid({
		url:contextPath+"/jwryrczf/queryJwryRczf",
		selectOnCheck:true,
		checkOnSelect:true,
		singleSelect:true,
		fitColumns:true,
		border:false,
		columns:[[
	          {field:'zt',title:'状态',width:60,align:'center',halign:'center',dictName:contextPath+'/common/dict/D_JWRY_RCZFZT.js',
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
	          {field:'cyzjdm',title:'证件种类',width:120,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/KX_D_CYZJDM.js'},
	          {field:'zjhm',title:'证件号码',width:120,align:'center',halign:'center'},
	          {field:'wwx',title:'外文姓',width:90,align:'center',halign:'center'},
	          {field:'wwm',title:'外文名',width:90,align:'center',halign:'center'},
	          {field:'xt_cjsj',title:'数据到达日期',width:90,align:'center',halign:'center'},
	          {field:'jzd_gxdwmc',title:'居住地管辖单位',width:160,align:'center',halign:'center'},
	          {field:'gzd_gxdwmc',title:'工作地管辖单位',width:160,align:'center',halign:'center'},
	          {field:'op',title:'操作',width:90,align:'center',halign:'center',formatter:RyJwryrczfb.datagridProcessFormater}
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
RyJwryrczfb.queryButton = function(){
	var cyzjdm = document.getElementById("cyzjdm").value;
	var zjhm = document.getElementById("zjhm").value;
	var wwx = document.getElementById("wwx").value;
	var wwm = document.getElementById("wwm").value;
	var jzd_gxdwdm = document.getElementById("jzd_gxdwdm").value;
	var gzd_gxdwdm = document.getElementById("gzd_gxdwdm").value;
	var zt = document.getElementById("zt").value;
	//加载查询列表
	$('#dg').datagrid('load',{    
		'cyzjdm':cyzjdm,
		'zjhm':zjhm,
		'wwx':wwx,
		'wwm':wwm,
		'jzd_gxdwdm':jzd_gxdwdm,
		'gzd_gxdwdm':gzd_gxdwdm,
		'zt':zt
	});
};
/**
 * @title:clearCase
 * @description:重置查询条件
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-06-18 10:51:43
 */
RyJwryrczfb.clearCase = function(){
	$("#queryForm").form("reset");
	if(orglevel=="32"||orglevel=="50"){
		$('#jzd_gxdwdm').combobox('setValue', userOrgCode);
		$('#gzd_gxdwdm').combobox('setValue', userOrgCode);
		//居住地管辖单位【只读】
		setInputReadonly('jzd_gxdwdm', true);
		//工作地管辖单位【只读】
		setInputReadonly('gzd_gxdwdm', true);
	}
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-06-25 10:29:54
 */
RyJwryrczfb.datagridProcessFormater = function(val,row,index){
    if(row.zt=="0"){
    	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="RyJwryrczfb.openHs('+index+')">走访核实</a>&nbsp;';
    }
};
/**
 * @title:openHs
 * @description:打开走访页面
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-06-25 10:29:54
 */
RyJwryrczfb.openHs = function(index){
    cancelBubble(); 
	//走访人
	setInputReadonly('zfr', true);
	//走访单位
	setInputReadonly('zfdw', true);
	$("#win").window("open"); 
	$("#bzxxForm").form("reset");
	//办证信息ID
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	$("#id").val(rowData.id);
};
/**
 * @title: qdbutton
 * @description:确定按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-06-25 14:57:32
 */
RyJwryrczfb.qdbutton = function(){
	$("#bzxxForm").form("submit",{
		dataType:"json",
		success: function(result){
			result = parseReturn(result);
			if(result.status == "success"){
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: result.message,
					timeout:1500
				});
				RyJwryrczfb.queryButton();
				RyJwryrczfb.closeSh();
			}else{
				topMessager.alert(MESSAGER_TITLE, result.message, "error");
			}
		}
	});
};
/**
 * @title:closeSh
 * @description:关闭走访页面
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-06-25 14:50:32
 */
RyJwryrczfb.closeSh = function(){
	$("#win").window("close"); 
};