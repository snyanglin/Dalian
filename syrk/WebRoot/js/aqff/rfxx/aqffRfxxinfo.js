// @Author:       [xu_haibo@founder.com.cn]
initAddressSearch('fzd3', {}, 'dz_zzdzmlpdm', 'dz_zzdzmlpxz', 'fzd4', {text:'dz_zzdzxz',dzxzqh:'dz_zzdzssxqdm',id:'dz_zzdzdm'}, null, null);
var mainTabID = "${mainTabID}";
$(document).ready(function(){
	initXdzbShow();
	$("#xxk").show();
});
//展示携带装备
function initXdzbShow(){
	var xdzbs = $("#hxdsb").val().split(',');
	var xdzbString = '';
	for(var i=0;i<xdzbs.length;i++){
		if(xdzbs[i]==1){
			xdzbString=xdzbString+'胶皮警棍,';
		}else if(xdzbs[i]==2){
			xdzbString=xdzbString+'齐眉棍,';
		}else if(xdzbs[i]==3){
			xdzbString=xdzbString+'对讲机,';
		}else if(xdzbs[i]==4){
			xdzbString=xdzbString+'警用喷射器,';
		}else if(xdzbs[i]==5){
			xdzbString=xdzbString+'钢叉,';
		}else if(xdzbs[i]==6){
			xdzbString=xdzbString+'手电筒,';
		}else if(xdzbs[i]==7){
			xdzbString=xdzbString+'防刺背心,';
		}else if(xdzbs[i]==8){
			xdzbString=xdzbString+'防割手套,';
		}else{
			xdzbString='';
		}
	}
	$("#xdzb").html(xdzbString);
}
//坐标标注
function pointbiaozhu(){
	var url = contextPath+'/forward/aqff|mapPointBzInfo?xldx='+$('#xldx').val()+'&xldy='+$('#xldy').val();
	var paramArray = [];
	openWindow(true, 'pointbiaozhu', url, 
   		paramArray, 
   		{
	   		title:'巡逻点标注（鼠标点击左键标注位置，右键退出标注模式）',
	   		maximizable: false,
	   		width: 850,	
	   		height: 560
   		}
   	);
}
//区域标注
function areabiaozhu(){
	var url = contextPath+'/forward/aqff|mapAreaBzInfo?xlqy='+$('#xlqy').val();
	var paramArray = [];
	openWindow(true, 'areabiaozhu', url, 
   		paramArray, 
   		{
	   		title:'巡逻区域标注（鼠标点击左键标注位置，右键退出标注模式）',
	   		maximizable: false,
	   		width: 850,	
	   		height: 560
   		}
   	);
}
$(function(){
		$('#dataForm').form({  
	        onSubmit:function(){
	            return $(this).form('validate');  
	        },  
	        success:function(data){  
	            var json = $.parseJSON(data);
	            if(json.status != 'success'){
	            	topMessagerAlert(null,json.message);
	            }else{
	            	$("#pk").val(json.saveID); 
	            	if($("#pk").val()){
	            		$("#xxk").show();
	            		$('#dg0').datagrid('load',{
							rfid: $("#pk").val()
						});
	            	}
	            	topMessagerShow(null,json.message);
	            }
	        }  
	    });   
		$('#saveBotton').click(function(){
			if ($("#dataForm").form('validate')){
				topMessager.confirm('操作确认', '您是否保存人防信息？',  function(r) {
					if (r) {
						$('#dataForm').submit();
						executeTabPageMethod(mainTabID, "reloadDg");
					}
				});
			}
		});
		$('#backBotton').click(function(){
			closeSelf();
		});
		$('#resetBotton').click(function(){
				$("#dataForm").form('reset');
		});
});
//操作按钮
function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="checkRow(this,'+index+')">查看</a>&nbsp;';
}
// 修改单条
function checkRow(linkObject, index) {
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var editUrl = contextPath + '/rfxxb/RfryxxInfo';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		var idField = opts.idField;
		editUrl = editUrl + idField + "=" + rowData[idField]+'&states=update';
		datagridView(datagrid_ID, 'viewWindow', null, {
			title : '人防人员信息',
			url : editUrl,
			width : 750,
			height : 330
		}, '详细数据!');
}
function body_onload() {
$("#xxk").show();
	$('#dataform').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            alert(data);  
        }  
    });   
} 
// 页面加载完成事件
window.onload = function(){
	body_onload();
}
function beforeSubmit() {
}
function afterSubmit(arr) {
	parent.reloadDg();
}