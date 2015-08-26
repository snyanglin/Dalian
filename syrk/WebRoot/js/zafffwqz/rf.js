function checkSave(){
	var ffzzxsdm = parent.document.getElementById("ffzzxsdm").value;
	if((ffzzxsdm=="" &&rfid=="") || (ffzzxsdm==""&& rfid==null) &&(ffzzxsdm==""&&typeof(rfid)=="undefined") || (ffzzxsdm==""&&rfid=="###########")){
		 $.messager.alert('添加问题','请先添加人防信息，再添加成员 !','error');
		 return false;
	}else if(ffzzxsdm!="" && ffzzxsdm!=null){
		return true;
	}
	
}

function rfcyAdd(){
	
	if(checkSave()){
		$("#cancel").window("open");
		
		var ryid = $("#ryid").val("");
		var fzrxm = $("#fzrxm").val("");
		var zjhm = $("#zjhm").val("");
		var csrq = $("#csrq").val("");
		var xbdm = $("#xbdm").combobox('setValue','');
		
		//var dz_ffzrrjzdzmlpdm = $("#dz_ffzrrjzdzmlpdm").val("");
		//var dz_jzdzmlpxz = $("#dz_jzdzmlpxz").val("");
		//var dz_jzdzdm = $("#dz_jzdzdm").val("");
		//var dz_jzdzssxdm = $("#dz_jzdzssxdm").val("");
		//var dz_jzdzxz = $("#dz_jzdzxz").val("");
		initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
		$("#cyzjdm").combobox('setValue', '111');
		$("#icon-ok").unbind();
		$("#icon-ok").click(function(){
			insertRow();
		});
	}
	
	
}


function initDg(){
	 $('#cydg').datagrid({
		url: contextPath+'/rfxx/queryRfcyxx',
 		singleSelect:true ,
 		queryParams:{rfid:rfid},
 		toolbar:'#datagridToolbar',
 		height:200,
		columns:
		    [[{field:"xm",title:"姓名",width:10,align:"center"},
			  {field:'xbdm',title:"性别",	width:5,align:'center',halign:'center',sortable:true,
		    	formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js' },
		    	
			  {field:'cyzjdm',title:"证件种类",width:10,align:'center',	halign:'center',sortable:true,
		    		formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_CYZJ.js'},
		    		
			  {field:'zjhm',title:"证件号码"	,width:15,align:'center',sortable:true,halign:'center'},		  
			  {field:'csrq',title:"出生日期",width:10,align:'center',sortable:true,halign:'center'},
			  {field:'dz_jzdzxz',title:"居住地址",width:35,align:'center',sortable:true,halign:'center'},
			  {field:"opt",	title:"操作",width:15,align:"center",
			    formatter:function(value,rowData,rowIndex){
			     	return "<a href='javascript:editRow(\""+rowIndex+"\")'>编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:deleteRow(\""+rowIndex+"\")'>删除</a>&nbsp;"
		       }}]]
	});
}

function insertRow(){
	
	 $('#cydg').datagrid('selectAll');  	  
	  var rows = $('#cydg').datagrid('getSelections'); 
	  
	var rfid = $("#rfid").val();
	var ryid = $("#ryid").val();
	var xm = $("#xm").val();
	var zjhm = $("#zjhm").val();
	var csrq = $("#csrq").val();
	var xbdm = $("#xbdm").combobox('getValue');
	var cyzjdm = $("#cyzjdm").combobox('getValue');
	
	var dz_ffzrrjzdzmlpdm = $("#dz_ffzrrjzdzmlpdm").val();
	var dz_jzdzmlpxz = $("#dz_jzdzmlpxz").val();
	var dz_jzdzdm = $("#dz_jzdzdm").val();
	var dz_jzdzssxdm = $("#dz_jzdzssxdm").val();
	var dz_jzdzxz = $("#dz_jzdzxz").val();
	  
	  for(var i=0;i<rows.length;i++){
	   if(rows[i].zjhm == zjhm){
		   $.messager.alert('添加问题','该成员已经存在，您可以删除后再添加!','error');
	     $('#cydg').datagrid('unselectAll'); 
	     return false;
	   }}
	  $('#cydg').datagrid('unselectAll');
	  
	  var rows1 = $('#cydg').datagrid('getRows');
	  
	  if(zjhm=="" || zjhm==null){
		  $.messager.alert('添加问题','请输入证件号码','error')
		  return false;
	  }
	  var jzd1 = $("#jzd1").combobox('getValue');
	  if(jzd1==""){
		  $.messager.alert('添加问题','请输入居住地址','error');
		  return false;
	  }
	  
	  $('#cydg').datagrid('insertRow',{index:rows1.length+1,row:{
		  		rfid:rfid,
		  		ryid:ryid,
		  		xm:xm,
		  		zjhm:zjhm,
		  		csrq:csrq,
		  		xbdm:xbdm,
		  		cyzjdm:cyzjdm,
		  		dz_ffzrrjzdzmlpdm:dz_ffzrrjzdzmlpdm,
		  		dz_jzdzmlpxz:dz_jzdzmlpxz,
		  		dz_jzdzdm:dz_jzdzdm,
		  		dz_jzdzssxdm:dz_jzdzssxdm,
		  		dz_jzdzxz:dz_jzdzxz
		  }		  
	  });
	  
	  $("#cancel").window("close");
}

function deleteRow(){
	
	var row =  $('#cydg').datagrid('getSelected');
	if(row){
		var rowIndex = $('#cydg').datagrid("getRowIndex",row);
			 $('#cydg').datagrid('deleteRow',rowIndex);
	}
	
}

function editRow(rowIndex){
	// var deleted = JSON.stringify($('#cydg').datagrid('getChanges',"deleted"));
	 //alert("deleted:"+deleted)
	// var inserted = JSON.stringify($('#cydg').datagrid('getChanges',"inserted"));
	// alert("inserted:"+inserted);
	 $('#cydg').datagrid('selectAll');  	  
	 var rows = $('#cydg').datagrid('getSelections');
	  
	var obj =  $('#cydg').datagrid('getSelected');
	 	$("#cancel").window("open");
		$("#rfid").val(obj.rfid);
		$("#ryid").val(obj.ryid);
		$("#xm").val(obj.xm);
		$("#zjhm").val(obj.zjhm);
		
		$("#csrq").val(obj.csrq);
		$("#xbdm").combobox('setValue',obj.xbdm);
		$("#cyzjdm").combobox('setValue',obj.cyzjdm);
		//$("#fzrcyzjdm").combobox('setValue', obj.fzrcyzjdm);
 
		  
	 	$("#icon-ok").click(function(){
	 		
	 		var rfid = $("#rfid").val();
	 		var ryid = $("#ryid").val();
	 		var xm = $("#xm").val();
	 		var zjhm = $("#zjhm").val();
	 		var csrq = $("#csrq").val();
	 		var xbdm = $("#xbdm").combobox('getValue');
	 		var cyzjdm = $("#cyzjdm").combobox('getValue');
	 		
	 		var dz_ffzrrjzdzmlpdm = $("#dz_ffzrrjzdzmlpdm").val();
	 		var dz_jzdzmlpxz = $("#dz_jzdzmlpxz").val();
	 		var dz_jzdzdm = $("#dz_jzdzdm").val();
	 		var dz_jzdzssxdm = $("#dz_jzdzssxdm").val();
	 		var dz_jzdzxz = $("#dz_jzdzxz").val();
	 		
	 		if(dz_jzdzdm){
	 			dz_jzdzdm="";
	 		}
	 		if(dz_jzdzxz){
	 			dz_jzdzxz="";
	 		}
	 		var jzd1 = $("#jzd1").combobox('getValue');
	 		if(jzd1==""){
	 			$.messager.alert('添加问题','请输入居住地址','error');
	 			return false;
	 		}
	 		
	 		//for(var i=0;i<rows.length;i++){
	 		//   if(rows[i].fzrzjhm == fzrzjhm){
	 		 //    alert('该成员已经存在，您可以删除后再添加!');
	 		 //    $('#cydg').datagrid('unselectAll'); 
	 		 //    return false;
	 		  // }}
	 		 if(zjhm !=obj.zjhm){
	 			 $('#cydg').datagrid('deleteRow',rowIndex);
	 		 }else{
	 			 $('#cydg').datagrid('deleteRow',rowIndex);
	 			rowIndex =rowIndex + 1;
	 		 }
	 		$('#cydg').datagrid('insertRow',{index:rowIndex,row:{
		  		rfid:rfid,
		  		ryid:ryid,
		  		xm:xm,
		  		zjhm:zjhm,
		  		csrq:csrq,
		  		xbdm:xbdm,
		  		cyzjdm:cyzjdm,
		  		dz_ffzrrjzdzmlpdm:dz_ffzrrjzdzmlpdm,
		  		dz_jzdzmlpxz:dz_jzdzmlpxz,
		  		dz_jzdzdm:dz_jzdzdm,
		  		dz_jzdzssxdm:dz_jzdzssxdm,
		  		dz_jzdzxz:dz_jzdzxz
		  }});
	 	$("#cancel").window("close");
	 		
		});
	 	
	 	
}

function rfcySave(){
	 var inserted = JSON.stringify($('#cydg').datagrid('getChanges',"inserted"));
	 alert("inserted:"+inserted);
	 
	 var deleted = JSON.stringify($('#cydg').datagrid('getChanges',"deleted"));
	 alert("deleted:"+deleted);
}

//刷新左页面的方法
function executeTabPageMethodLeft(mainTabID, method) {
	if (!mainTabID || mainTabID == "" || !method || method == "") {
		return;
	}
	try {
		var openFrameID = "main_tab" + mainTabID;
		if (IE) {
			var openFrame = window.top.document.frames["main_frame"].main_center.frames(openFrameID);
			openFrame =openFrame.frames['main_left'];
			eval("openFrame." + method + "()");
		}
		else {
			var main_center = window.top.document.getElementById("main_frame").contentWindow.frames.document.getElementById("main_center");
			var openFrame1 = main_center.contentWindow.frames.document.getElementById(openFrameID).contentWindow;
			var openFrame = contentWindow.frames.document.getElementById("main_left").contentWindow;
			eval("openFrame." + method + "()");
		}
	}
	catch (err) {}
}