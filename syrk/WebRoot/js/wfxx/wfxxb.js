/**
 * 
 * @description:物防信息列表操作
 * @author: tian_chengwei@founder.com      
 * @date:2015-06-02
 * 
 *  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
 var markerArr = new Array();
///----------查询功能页方法--------------
function passwordOnkeyPress(obj) {
 obj.style.color = "black";
 //f_check_fullToHalfUpper(obj);
 var keycode = event.keyCode;
   if (keycode == 13) {
	   searchMain();
   }
}
//点击输入框后，清除文本内容		
function setDzqc(obj){
	obj.value="";
}
	
//精确查询
function detailSearch(){
	$("#win").window("open"); 
	//$("#win").show();
}
//添加跳转
function wfxxbAdd(){
	menu_open('物防新增', '/wfxxb/addWfxxb?'+"&mainTabID="+getMainTabID());
}

function searchMain(){
	if (IE) {
		parent.frames["main_center"].WfxxMap.clearGraph();
	}else{
		var obj = parent.frames.document.getElementById("main_center").contentWindow;
		obj.WfxxMap.clearGraph();
	}

	var condition = document.getElementById("condition").value;
	if(condition=="请输入物防数量、地址信息"){
		condition="";
	}
	var reloadUrl  = contextPath + '/wfxx/queryWf';;
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	condition= $.trim(condition);
	$('#dg').datagrid('reload',{condition:condition});  
	$('#dg').datagrid("clearSelections");
}
//----精确查询框方法---------
function closeWindow(obj){
	$("#"+obj).window("close"); 
}
//查询按钮
function queryButton(){
	var wfzl = $("#wfzl").val();
	var dz_wfdzxz = $("#dz_wfdzxz").val();
	var azrq = $("#azrq").val();
	var ms = $("#ms").val();
	var wflx = $("#wflx").val();
	var reloadUrl  = contextPath + '/wfxx/queryWf';;
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	
	$("#dg").datagrid(
			'reload',
			{    
				'wfzl':wfzl,
				'dz_wfdzxz':dz_wfdzxz,   
				'azrq':azrq,
				'ms':ms,
				'wflx':wflx
			});
	closeWindow('win');
}
//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
//---------------框查-----

function onSelectRow(rowIndex, data){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	if(typeof(markerArr[rowIndex])!="undefined" && markerArr[rowIndex]!="" && markerArr[rowIndex]!="null"){
		if (IE) {
			parent.frames["main_center"].WfxxMap.centerByPoint(markerArr[rowIndex],19,null);
		}else{
			var obj = parent.frames.document.getElementById("main_center").contentWindow;
			obj.WfxxMap.centerByPoint(markerArr[rowIndex],19,null);
		}
	}else{
		topMessagerShow(null,"此记录无坐标，请进行标注！");
	}
}


//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	
	var html = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;';
			if(row.zbx!=null && row.zbx!="" && typeof(row.zbx)!="undefined"){
				html +='<a class="link" href="javascript:void(0)" onclick=""><font color="gray">标注</font></a>&nbsp;';
			}else{
				html +='<a class="link" href="javascript:void(0)" onclick="doBz(this,'+index+')">标注</a>&nbsp;';
			}
			html += '<a class="link" href="javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
		   return html;
}
//标注信息,在wfxx.js中调用controller中的updateWf
function doBz(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	if (IE) {
		parent.frames["main_center"].WfxxMap.drawPoint(rowData.id);
	}else{
		var obj = parent.frames.document.getElementById("main_center").contentWindow;
		obj.WfxxMap.drawPoint(rowData.id);
	}
}
// 修改单条
function doEdit(linkObject, index) {
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/wfxxb/addWfxxb?id="+rowData.id +"&mainTabID="+getMainTabID();
	menu_open("物防信息修改" ,editUrl);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/wfxx/delete';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要注销数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

//空间查询重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var zbz = document.getElementById("zbz").value;
	var type = document.getElementById("type").value;
	var mapRadius = document.getElementById("mapRadius").value;
	var reloadUrl = contextPath + '/wfxx/queryWfxxOnPT';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid(
			'reload',
			{    
				'zbz': zbz,   
				'type': type ,
				'mapRadius':mapRadius
			});
}
//页面载入画点
function loadPoints(){
	if(typeof(parent.frames["main_center"].WfxxMap)=="undefined"){
	}else{
		parent.frames["main_center"].WfxxMap.clearMarkers();
	}
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	for(var i=0;i<len;i++){
		var dz = rows[i].dz_wfdzxz;
		if(rows[i].zbx!=null && rows[i].zbx!=""){
			var marker =null;
			if (IE) {
				marker =  parent.frames["main_center"].addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,34,34,false,rows[i].dz_wfdzdm,null);
			}
			else {
				var obj = parent.frames.document.getElementById("main_center").contentWindow;
				marker = obj.addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,32,32,false,rows[i].dz_wfdzdm,null);
			}
			markerArr[i] = marker;
		}else{
			//alert("无坐标");
		}
	};
	
}
//添加后刷新页面
function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}
