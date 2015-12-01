/**
 * 
 * @description:物防添加
 * @author: tian_chengwei@founder.com      
 * @date:2015-06-02
 * 
 *  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */


$(document).ready(function(){
	var mainTabID = $("#mainTabID").val();
});
//物防种类点击给文本框赋值
function onSelect(record){
	$('#entity_wfzl').val(record.id);
}
//打开标注页面
function mapBz(){
	var url = contextPath+'/forward/zafffwqz|wfxxMapBz';
	var paramArray = [];
	openWindow(false,'win9', url, 
   		paramArray, 
   		{
	   		title:'地图标注（鼠标点击左键标注位置）',
	   		maximizable: false,
	   		width: 850,	
	   		height: 560
   		}
   	);
}
//关闭标注页面，只能在上级页面关闭，打开窗口里嵌入了Iframe,调用dialog无法关闭页面
function closeMap(){
	$('#win9').dialog('close');
}

$(function(){
	//单位选择组件
	initDepartmentSearch('dw-box', {glpcsid: ''}, 'dwid', 'dwmc', null, null);
	//如从单位入口进入，初始化单位信息
	$("#dwmc").val($("#crdwmc").val());
	$("#dwid").val($("#crdwid").val());
	$("#dw-box").val($("#crdwmc").val());
	if($("#dwid").val() !=""){
	setInputReadonly("dw-box", true);
	}
	//管辖责任区、管辖派出所只读
	setInputReadonly("gxzrq", true);
	setInputReadonly("gxpcs", true);
	
	initAddressSearch('wfdz1', {}, 'wfdzmlpdm', 'wfdzmlpxz', 'wfdz2', {text:'wfdzxz',dzxzqh:'wfdzssxdm',id:'wfdzdm',dzzbx:'entity_zbx',dzzby:'entity_zby'}, null, null);
	$('#wfxxForm').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            	topMessagerAlert(null,json.message);
            }else{
            	topMessagerShow(null,json.message);
            	$("#entity_id").val(json.saveID); 
            	if($("#dwid").val() == ""){
	            	executeTabPageMethod(mainTabID, "reloadDg");
            	}else{
            		executeTabPageMethod(mainTabID, "child_edit_menu_complete", $("#infoUrl").val());
            	}
            	executeTabPageMethod(mainTabID, "location.reload()");
            	closeSelf();
            	locateMainPage(mainTabID);
            }
        }  
    });   
	$('#saveBotton').click(function(){
		if($('#wfxxForm').form('validate')){
			topMessager.confirm('操作确认', '您是否保存物防信息？',  function(r) {
				if (r) {
					if(isvalidDwid()==true){
						$('#wfxxForm').submit();	
					}else{
						topMessagerShow(null,"无此单位，请在单位管理进行维护！");
					}
					
				}
			});
		}
	});
	//调用标注地图页面
	$('#mapBotton').click(function(){
		mapBz();
	});
	$('#resetBotton').click(function(){
	    //$("input[id!='gxzrq'][id!='gxpcs'][id!='dw-box']").val("");
	     //单位入口进入页面后，单位下来禁止清空
	     if(document.getElementById("dw-box").readOnly == false){
	     $("#dw-box").combobox("setValue","");
	     }
	     $('#entity_wfzl').combobox("setValue","");
	     $('#wfdz1').combobox("setValue","");
	     $("#entity_sl").val("");
	     $("#entity_azrq").val("");
	     $("#wfdz2").combobox("setValue","");
	     $("#entity_zbx").val("");
	     $("#entity_zby").val("");
		 $("textarea").val("");
	});
});
	
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
			var openFrame = main_center.contentWindow.frames.document.getElementById("main_left");//.contentWindow;
			eval("openFrame." + method + "()");
		}
	}
	catch (err) {}
}
//获取单位ID
function isvalidDwid(){
	var flag = false;
	if($("#dwid").val() !=  ""){
		flag = true;
	}
	return flag;
}