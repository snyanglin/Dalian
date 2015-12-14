// @Author:       [xu_haibo@founder.com.cn]
//多选框初始化
function initXDZB(){
	var xdsb = $('#hxdsb').val();
	$('input[name="xdzbdm"]').each(function(idx,obj){
		if(xdsb.indexOf(obj.value)!=-1){
			$(obj).attr('checked','checked');
		}
	});
}
//标注点坐标方法
function pointbiaozhu(){
	var url = contextPath+'/forward/aqff|mapPointBz?xldx='+$('#xldx').val()+'&xldy='+$('#xldy').val();
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
//标注区域坐标方法
function areabiaozhu(){
	var url = contextPath+'/forward/aqff|mapAreaBz?xlqy='+$('#xlqy').val();
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
//form表单绑定按钮
$(function(){
	$('#dataForm').form({  
        onSubmit:function(){
			if($("#fzd3").combobox("getValue")==''){
				$("#fzd3").combobox("setValue","");
				$("#fzd4").combobox("setValue","");
				$("#dz_zzdzmlpdm").val("");
				$("#dz_zzdzmlpxz").val("");
				$("#dz_zzdzdm").val("");
				$("#dz_zzdzssxqdm").val("");
				$("#dz_zzdzxz").val("");
			}
			var deletes = $('#dg0').datagrid('getChanges',"deleted");
			var jsondeleted = JSON.stringify(deletes);
			if(deletes!=''){
				$("#rydelete").val(jsondeleted);
			}else{
				$("#rydelete").val("[]");
			}
        	var rows = $('#dg0').datagrid('getRows');
        	var jsonrows = JSON.stringify(rows);
        	$("#ryAll").val(jsonrows);
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
            	executeTabPageMethod(mainTabID, "location.reload()");
            	closeSelf();
            }
        }  
    });   
	$('#saveBotton').click(function(){
		if ($("#dataForm").form('validate')){
			var rows = $('#dg0').datagrid('getRows');
			if($("#dz_zzdzdm").val() == ""&&$("#dz_zzdzmlpxz").val()!=""){
				topMessager.alert('', '请先选择有效的单位地址！');
				$("#jzd3").find("input.combo-text").first().focus();
				return;
			}
			if(rows==''){
				topMessager.alert('', '保存失败！组织最少应存在一个人。');
			}else{
				topMessager.confirm('操作确认', '您是否保存人防信息？',  function(r) {
					if (r) {
						
						$('#dataForm').submit();
						
					}
				});
			}
		}
	});
	$('#backBotton').click(function(){
		closeSelf();
	});
	$('#resetBotton').click(function(){
			$("#dataForm").form('reset');
	});
	var flag = document.getElementById("flag").value;
	if(flag=="update"){
		if(ryList){
			$("#dg0").datagrid("loadData",ryList);
		}
	}
});
//操作按钮
function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="editRow(this,'+index+')">编辑</a>&nbsp'
	+'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="deleteRow(this,'+index+')">删除</a>&nbsp;';
}
//删除单条
function deleteRow(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	topMessager.confirm('','您确认要注销数据吗？',function(r) {    
		if (r) {	
			$("#dg0").datagrid("deleteRow",index);
		}
	});
}
// 修改单条
function editRow(linkObject, index) {
	var rfid = document.getElementById("pk").value;
	var rows = $('#dg0').datagrid('getRows');
	//alert(rows[index].id);
	//var objs=$("#dg0").datagrid("getRowIndex",rows[index].id);
	//alert(objs);
	var zjhm = rows[index].zjhm;
	var zjlxdm = rows[index].zjlxdm;
	var xm = rows[index].xm;
	var xbdm = rows[index].xbdm;
	var whcddm = rows[index].whcddm;
	var zzmmdm = rows[index].zzmmdm;
	var rylydm =rows[index].rylydm;
	var zznzw = rows[index].zznzw;
	var lxfs = rows[index].lxfs;
	var cjsj = rows[index].cjsj;
	var dz_jzdzmlpdm = rows[index].dz_jzdzmlpdm;
	var dz_jzdzmlpxz = rows[index].dz_jzdzmlpxz;
	var dz_jzdzdm = rows[index].dz_jzdzdm;
	var dz_jzdzssxqdm = rows[index].dz_jzdzssxqdm;
	var dz_jzdzxz = rows[index].dz_jzdzxz;
	var cylbdm = rows[index].cylbdm;
	var bz = rows[index].bz;
	var gzdw =  rows[index].gzdw;
	var dwid =  rows[index].dwid;
	var id =  rows[index].id;

	var editUrl = contextPath + '/rfxxb/addRfryxx?rfid='+rfid+'&mainTabID='+getMainTabID()+'&states=update'
	+'&zjhm='+zjhm+'&zjlxdm='+zjlxdm+'&xm='+xm+'&xbdm='+xbdm+'&whcddm='+whcddm+'&zzmmdm='+zzmmdm+'&rylydm='+rylydm+'&zznzw='+zznzw
	+'&lxfs='+lxfs+'&cjsj='+cjsj+'&dz_jzdzmlpdm='+dz_jzdzmlpdm+'&dz_jzdzmlpxz='+dz_jzdzmlpxz+'&dz_jzdzdm='+dz_jzdzdm+'&dz_jzdzssxqdm='+dz_jzdzssxqdm
	+'&dz_jzdzxz='+dz_jzdzxz+'&cylbdm='+cylbdm+'&bz='+bz+'&gzdw='+gzdw+'&dwid='+dwid+'&id='+id+'&index='+index;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	editUrl = encodeURI(encodeURI(editUrl));
	datagridAdd(obj, 'addWindow', null,{
		title : '人防人员信息',
		url : editUrl,
		width : 850,
		height : 530
	}, '您是否要保存数据？');
}
//新增人员
function rfryxxAdd(obj){
	var rows = $('#dg0').datagrid('getRows');
	var zjhms=[];
	for(var i=0;i<rows.length;i++){
		zjhms[i]=rows[i].zjhm;
	}
	var rfid = document.getElementById("pk").value;
	var editUrl = contextPath + '/rfxxb/addRfryxx?rfid='+rfid+'&mainTabID='+getMainTabID()+'&states=add&zjhms='+zjhms;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	datagridAdd(obj, 'addWindow', null,{
		title : '人防人员信息',
		url : editUrl,
		width : 850,
		height : 530
	}, '您是否要保存数据？');
	//rfryList();
}
//原有功能不可删除
function beforeSubmit() {
}
//原有功能不可删除
function afterSubmit(arr) {
	parent.reloadDg();
}
//重载页面
function reloadDg(methodSty) {
	var strs = methodSty.split('@');
	//if(strs[19]!=0){
	//	$("#dg0").datagrid("deleteRow",strs[18]);
	//}
	$('#dg0').datagrid('insertRow',{
		index: 4,	// 索引从0开始
		row: {
			zjhm: strs[0],
			zjlxdm:strs[1],
			xm:strs[2],
			xbdm:strs[3],
			whcddm:strs[4],
			zzmmdm:strs[5],
			rylydm:strs[6],
			zznzw:strs[7],
			lxfs:strs[8],
			cjsj:strs[9],
			dz_jzdzmlpdm:strs[10],
			dz_jzdzmlpxz:strs[11],
			dz_jzdzdm:strs[12],
			dz_jzdzssxqdm:strs[13],
			dz_jzdzxz:strs[14],
			cylbdm:strs[15],
			bz:strs[16],
			gzdw:strs[17],
			dwid:strs[18],
			id:strs[19]
		}
	});
}
//重载页面
function updaterows(strss) {
	
	var strs = strss.split('@');
	$("#dg0").datagrid("deleteRow",strs[20]);
	var rows = $('#dg0').datagrid('getRows');
	$("#dg0").datagrid("loadData",rows);
	/*$('#dg0').datagrid('updateRow',{
	//$('#dg0').datagrid('insertRow',{
		index: strs[20],
		row: {
			zjhm: strs[0],
			zjlxdm:strs[1],
			xm:strs[2],
			xbdm:strs[3],
			whcddm:strs[4],
			zzmmdm:strs[5],
			rylydm:strs[6],
			zznzw:strs[7],
			lxfs:strs[8],
			cjsj:strs[9],
			dz_jzdzmlpdm:strs[10],
			dz_jzdzmlpxz:strs[11],
			dz_jzdzdm:strs[12],
			dz_jzdzssxqdm:strs[13],
			dz_jzdzxz:strs[14],
			cylbdm:strs[15],
			bz:strs[16],
			gzdw:strs[17],
			dwid:strs[18]
		}
	});*/
	//var rows = $('#dg0').datagrid('getRows');
	//$("#dg0").datagrid("loadData",rows);
}
function rfryList(){
	var reloadUrl  =  contextPath +'/rfxxb/queryRfcyxx';
	var opt = $('#dg0').datagrid('options');
	opt.url = reloadUrl;
	var id=$("#pk").val();
	$('#dg0').datagrid('load',{rfid:id});
}

function checks(obj){
	obj.value=obj.value.trim();
}

String.prototype.trim = function () {
	return this.replace(/^\s*(.+)/gi,"$1").replace(/\s*$/gi,"");
};