if(typeof DzCount == "undefined" || !DzCount){
	var DzCount = {};
};
DzCount.gxsxjCode = "";
DzCount.gxsxjName = "";
DzCount.gxpcsCode = "";
DzCount.sfxz = false;//是否下钻
/**
 * @title:Jquery
 * @description:初始化地址统计
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-05-11 16:00:43
 */
$(function(){
	//加载地址统计列表
	DzCount.onloadDatagrid();
	//设置只读属性
	DzCount.onloadReadonly();
	//键盘回车进行统计
	$("body").bind("keydown",function(e){
        if(e.keyCode==13){
        	DzCount.queryButton();
        }		
	});
});
/**
 * @title:onloadDatagrid
 * @description:地址统计列表
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-05-11 16:04:45
 */
DzCount.onloadDatagrid = function(){
	$("#dzCountTable").datagrid({
		url:contextPath+"/dz/queryDzTjList",
		queryParams:{orgcode:userOrgCode,orglevel:orglevel},
		selectOnCheck:true,
		checkOnSelect:true,
		singleSelect:true,
		fitColumns:true,
		border:false,
		columns:[[
	          {field:'orgname',title:'单位',width:140,align:'center',halign:'center',formatter:DzCount.orgNameOnclick},
	          {field:'xjdz',title:'新建地址（条）',width:100,align:'center',halign:'center'},
	          {field:'zxdz',title:'注销地址（条）',width:100,align:'center',halign:'center'},
	          {field:'yxdz',title:'当前机构下有效地址（条）',width:160,align:'center',halign:'center'}
		]],
		toolbar:'#datagridToolbar',
		rownumbers:true
	});
	$('#dzCountTable').datagrid('getPager').pagination({
		displayMsg:'共 {total} 条记录',
		layout:['refresh'],
		buttons: [{
			id:'dcid',
			text:'导出',
			iconCls:'icon-xls',
			handler:function(){
				DzCount.queryButton(2);
				$('#dcid').linkbutton('disable');
				setTimeout(function(){
					$('#dcid').linkbutton('enable');
				}, 6000);
			}
		},'-',{
			id:'xzid',
			text:userOrgName,
			handler:function(){
			}
		}]
	});
};
/**
 * @title:orgNameOnclick
 * @description:单位名称下钻
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2015-05-12 13:54:47
 */
DzCount.orgNameOnclick = function(val, row, index){
	var gxsxj = "";var gxpcs = "";var gxzrq = "";
	if(row.orglevel=="21"){
		return "<a class='link' href='javascript:javascript:void(0)' onclick='DzCount.orgNameXz(\""+row.orgcode+"\",\""+gxpcs+"\",\""+gxzrq+"\",\""+row.orgname+"\")'>"+val+"</a>";
	}else if(row.orglevel=="32"){
		return "<a class='link' href='javascript:javascript:void(0)' onclick='DzCount.orgNameXz(\""+gxsxj+"\",\""+row.orgcode+"\",\""+gxzrq+"\",\""+row.orgname+"\")'>"+val+"</a>";
	}
	return val;
};
/**
 * @title:orgNameXz
 * @description:统计列表下钻
 * @author: zhang_guoliang@founder.com
 * @param tyle 1为查询、2为导出 默认为查询  
 * @date:2015-05-12 13:54:47
 */
DzCount.orgNameXz = function(gxsxj,gxpcs,gxzrq,orgname){
	var redio = $('input[name="radioName"]:checked').val();
	var kssj = document.getElementById("kssj").value;
	var jssj = document.getElementById("jssj").value;
	if(redio == undefined){
		redio = "";
	}
	if(redio=="5"){
		if(kssj==""||jssj==""){
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '请选择自定义时间段，进行数据统计。',
				timeout:3500
			});
			return;
		}
	}
	//加载查询列表
	$('#dzCountTable').datagrid('load',{    
		'gxsxj':gxsxj,
		'gxpcs':gxpcs,
		'gxzrq':gxzrq,
		'redio':redio,
        'kssj':kssj,
        'jssj':jssj
	});
	DzCount.sfxz = true;
	var str = "";
	//记录返回按钮
	if(gxsxj!=""){
		DzCount.gxsxjCode = gxsxj;
		DzCount.gxsxjName = orgname;
		gxsxj = "";
		if(orglevel=="10"){
			DzCount.gxpcsCode = "";
			str = "<a class='link' href='javascript:javascript:void(0)' onclick='DzCount.orgNameXz(\""+gxsxj+"\",\""+gxpcs+"\",\""+gxzrq+"\",\""+userOrgName+"\")'>"+userOrgName+"</a>&nbsp;<<&nbsp;" +
      	  		  ""+orgname;
		}else if(orglevel=="21"){
			DzCount.sfxz = false;
			str = userOrgName;
		}
	}else if(gxpcs!=""){
		if(DzCount.gxsxjName==""){
			DzCount.gxsxjCode = $('#gxsxj').combobox('getValue');
			DzCount.gxsxjName = $('#gxsxj').combobox('getText');
		}
		DzCount.gxpcsCode = gxpcs;
		gxpcs = "";
		  if(orglevel=="10"){
			  str = "<a class='link' href='javascript:javascript:void(0)' onclick='DzCount.orgNameXz(\""+gxsxj+"\",\""+gxpcs+"\",\""+gxzrq+"\",\""+userOrgName+"\")'>"+userOrgName+"</a>&nbsp;<<&nbsp;" +
		        	"<a class='link' href='javascript:javascript:void(0)' onclick='DzCount.orgNameXz(\""+DzCount.gxsxjCode+"\",\""+gxpcs+"\",\""+gxzrq+"\",\""+DzCount.gxsxjName+"\")'>"+DzCount.gxsxjName+"</a>&nbsp;<<&nbsp;" +
		        	""+orgname;
		  }else if(orglevel=="21"){
			  str = "<a class='link' href='javascript:javascript:void(0)' onclick='DzCount.orgNameXz(\""+DzCount.gxsxjCode+"\",\""+gxpcs+"\",\""+gxzrq+"\",\""+DzCount.gxsxjName+"\")'>"+DzCount.gxsxjName+"</a>&nbsp;<<&nbsp;" +
		        	""+orgname;
		  }
	}else{
		DzCount.sfxz = false;
		str = userOrgName;
	}
	$("#xzid").linkbutton({text:str});
};
/**
 * @title:onloadReadonly
 * @description:设置只读属性
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-05-12 10:07:43
 */
DzCount.onloadReadonly = function(){
	//自定义开始时间
	setInputReadonly('kssj', true);
	//自定义结束时间
	setInputReadonly('jssj', true);
	//组织机构选择
	if(orglevel == "50"){
		//管辖分(县)局【只读】
		setInputReadonly('gxsxj', true);
		//管辖派出所【只读】
		setInputReadonly('gxpcs', true);
		//管辖责任区【只读】
		setInputReadonly('gxzrq', true);
		$('#gxsxj').combobox('setValue', ssFsxCode);
		$('#gxpcs').combobox('setValue', ssPcsCode);
		$('#gxzrq').combobox('setValue', userOrgCode);
	}else if(orglevel == "32"){
		//管辖分(县)局【只读】
		setInputReadonly('gxsxj', true);
		//管辖派出所【只读】
		setInputReadonly('gxpcs', true);
		$('#gxsxj').combobox('setValue', ssFsxCode);
		$('#gxpcs').combobox('setValue', ssPcsCode);
	}else if(orglevel == "21"){
		//管辖分(县)局【只读】
		setInputReadonly('gxsxj', true);
		$('#gxsxj').combobox('setValue', ssFsxCode);
	}
};
/**
 * @title:timeReadonly
 * @description:时间统计设置只读属性
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-05-12 10:07:43
 */
DzCount.timeReadonly = function(){
	var value = $('input[name="radioName"]:checked').val();
	if(value=="5"){
		//自定义开始时间
		setInputReadonly('kssj', false);
		//自定义结束时间
		setInputReadonly('jssj', false);
	}else{
		//自定义开始时间
		setInputReadonly('kssj', true);
		//自定义结束时间
		setInputReadonly('jssj', true);
		//重置时间为空
	    document.getElementById("kssj").value = "";
		document.getElementById("jssj").value = "";
	}
};
/**
 * @title:queryButton
 * @description:统计查询按钮
 * @author: zhang_guoliang@founder.com
 * @param tyle 1为查询、2为导出 默认为查询  
 * @date:2015-05-12 13:54:47
 */
DzCount.queryButton = function(tyle){
	var	gxsxj = document.getElementById("gxsxj").value;
	var	gxpcs = document.getElementById("gxpcs").value;
	var	gxzrq = document.getElementById("gxzrq").value;
	var redio = $('input[name="radioName"]:checked').val();
	var kssj = document.getElementById("kssj").value;
	var jssj = document.getElementById("jssj").value;
	if(redio == undefined){
		redio = "";
	}
	if(redio=="5"){
		if(kssj==""||jssj==""){
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '请选择自定义时间段，进行数据统计。',
				timeout:3500
			});
			return;
		}
	}
	if(tyle=='2'){
		var rows =  $('#dzCountTable').datagrid("getRows");
		if(rows.length == 0){
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '无导出数据，请进行统计。',
				timeout:3500
			});
			return;
		}else{
			if(DzCount.sfxz){
				if(DzCount.gxpcsCode!=""){
					gxpcs = DzCount.gxpcsCode;
				}else if(DzCount.gxsxjCode!=""){
					gxsxj = DzCount.gxsxjCode;
				}
			}
			var field = JSON.stringify($('#dzCountTable').datagrid("getColumnFields"));
			var title = JSON.stringify($('#dzCountTable').datagrid("options").columns);
			location.href = contextPath+'/dz/queryDzTjList_export?title='+title+'&field='+field+'&gxsxj='+gxsxj+'&gxpcs='+gxpcs+'&gxzrq='+gxzrq+'&redio='+redio+'&kssj='+kssj+"&jssj="+jssj;
		}
	}else{
		//加载查询列表
		$('#dzCountTable').datagrid('load',{    
			'gxsxj':gxsxj,
			'gxpcs':gxpcs,
			'gxzrq':gxzrq,
			'redio':redio,
	        'kssj':kssj,
	        'jssj':jssj
		});
		$("#xzid").linkbutton({text:userOrgName});
		DzCount.gxsxjCode = "";
		DzCount.gxpcsCode = "";
		DzCount.gxsxjName = "";
		DzCount.sfxz = false;
	}
};
/**
 * @title:clearCase
 * @description:重置查询条件
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-05-12 14:14:00
 */
DzCount.clearCase = function(){
	if(orglevel == "32"){
		//重置责任区下拉框
		$('#gxzrq').combobox('setValue', '');
	}else if(orglevel == "21"){
		//重置派出所下拉框
		$('#gxpcs').combobox('setValue', '');
	}else if(orglevel == "10"){
		//重置分局下拉框
		$('#gxsxj').combobox('setValue', '');
	}
	//自定义开始时间
	setInputReadonly('kssj', true);
	//自定义结束时间
	setInputReadonly('jssj', true);
	//重置时间为空
    document.getElementById("kssj").value = "";
	document.getElementById("jssj").value = "";
	//重置单选框
	$("input[name=radioName]").attr("checked",false);
};