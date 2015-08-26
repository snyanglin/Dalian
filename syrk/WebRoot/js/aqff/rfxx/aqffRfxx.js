// @Author:       [xu_haibo@founder.com.cn]
///----------注销方法--------------
init_del_div();
function init_del_div(){
	$('#del_div').window({    
		title:'注销',
	    width:200,    
	    height:150,    
	    modal:true   
	}); 
	$("#winDel").window('close');
}
var delIdx ="";
function del_div_qd(){
	doDelete(null, delIdx);
}
function del_div_qx(){
	$("#winDel").window('close');
}
function open_del_div (btn,idx){
	delIdx=idx;
	$("#winDel").show();
	$("#winDel").window('open');
}
//页面关闭方法
function closeWindow(){
	$("#win").window("close"); 
}
//精确查询
function detailSearch(){
	$("#win").show();
	$("#win").window("open"); 
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;'+
		   '<a class="link" href="javascript:javascript:void(0)" onclick="open_del_div(this, '+index+')">注销</a>';
}
// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/rfxxb/addRfxx?id="+rowData.id+"&mainTabID="+getMainTabID();
	menu_open("人防信息编辑",editUrl);
}
//删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/rfxxb/deleteRfxx';
	var datagrid_ID = 'dg';
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	
	var xt_zxyy = document.getElementById("xt_zxyy").value;
	if(xt_zxyy!="" ){
		if(xt_zxyy.length>100){
			return;
		}else{
			topMessager.confirm('','您确认要注销数据吗？',function(r) {    
				if (r) {	
					var opts = $('#' + datagrid_ID).datagrid("options");
					var rows = $('#' + datagrid_ID).datagrid('getData');
					var rowData = rows.rows[index];
					var postData = {
						"id":rowData.id,
						"xt_zxyy":$("#xt_zxyy").val()
					};
					$.ajax({
						url: deleteUrl,
						type: 'POST',
						data: postData
					}).done(function(result) {
						$("#winDel").window('close');
						doSubmitResult(result, null, datagrid_ID);
						$('#dg').datagrid('reload');
					});
					var mapWindow = null;
					if (IE) {
						mapWindow = parent.frames["biz_center"];
					}
					else {
						mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
					}
					mapWindow.RfxxMap.moveMapToBjzbz();
					
				}
			});
		}
	}
}
//按下enter
function passwordOnkeyPress(obj) {
	 obj.style.color = "black";
	 var keycode = event.keyCode;
	   if (keycode == 13) {
		   searchMain();
	   }
	}
//按下enter,清空
function setDzqc(obj){
	obj.value="";
}
//人防信息添加
function rfAdd(){
	var hsUrl = "/rfxxb/addRfxx?";
	hsUrl+="&mainTabID="+getMainTabID();
	menu_open("人防信息新增",hsUrl);
}
//人防信息模糊查询
function searchMain(){
	if (IE) {
	}else{
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.RfxxMap.clearGraph();
	}
	var condition = document.getElementById("condition").value;
	if(condition=="请输入人员姓名、身份证号、组织名称"){
		condition="";
	}
	var reloadUrl = contextPath + '/rfxxb/queryMHRf';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	condition= $.trim(condition);
	$('#dg').datagrid('load',{ffzrrxm:condition});
	$('#dg').datagrid("clearSelections");
}
//点击列表显示坐标方法
function onSelectRow(rowIndex, data){
	mapPointAndArea(data);
}
//查询按钮
function queryButton(){
	var ffzrrxm = document.getElementById("ffzrrxm").value;
	var ffzrrzjhm = document.getElementById("ffzrrzjhm").value;
	var zzmc = document.getElementById("zzmc").value;
	var zzlbdm = document.getElementById("zzlbdm").value;
	var ffzzxsdm = document.getElementById("ffzzxsdm").value;
	var ffzrrryly = document.getElementById("ffzrrryly").value;
	var dz_zzdzmlpxz = document.getElementById("dz_zzdzmlpxz").value;
	ffzrrxm= $.trim(ffzrrxm);
	zzmc= $.trim(zzmc);
	var reloadUrl = contextPath + '/rfxxb/queryJQRf';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
		$('#dg').datagrid(
			'load',
			{    
				'ffzrrxm':ffzrrxm,
				'ffzrrzjhm':ffzrrzjhm,
				'zzmc':zzmc,
				'zzlbdm':zzlbdm,
				'ffzzxsdm':ffzzxsdm,
				'ffzrrryly':ffzrrryly,
				'dz_zzdzmlpxz':dz_zzdzmlpxz,
				'sfck':0
			});
	closeWindow("win");
}
//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
//重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var zbz = document.getElementById("zbz").value;
	var type = document.getElementById("type").value;
	var mapRadius = document.getElementById("mapRadius").value;
	var reloadUrl = contextPath + '/sydwcx/queryDwDzOnPT';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid(
			'load',
			{    
				'zbz': zbz,   
				'type': type ,
				'mapRadius':mapRadius
			});
}
//重置加载
function loadGrid(){
	$('#dg').datagrid('load',{zbz:null,type:null,mapRadius:null,rows:21});  
	$('#dg').datagrid("clearSelections");
}
//标点方法
function mapPointAndArea(data) {
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}
	else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	mapWindow.RfxxMap.moveMapToBjzbz();
		if (IE) {
			if(data.xldx!=''){
				marker = mapWindow.addMarker(data.ffzzmc,data.xldx,data.xldy,"location.png",null,null,34,34,false,null,null);
			}
			if(data.xlqy && data.xlqy!="undefined"){
				mapWindow.showarea(data.xlqy);
			}
		} else{
			if(data.xldx!=''){
				marker = mapWindow.addMarker(data.ffzzmc,data.xldx,data.xldy,"location.png",null,null,34,34,false,null,null);
			}
		}
}
//重载页面
function reloadDg() {
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}
function checks(obj){
	obj.value=obj.value.trim();
}

String.prototype.trim = function () {
	return this.replace(/^\s*(.+)/gi,"$1").replace(/\s*$/gi,"");
};