//@updateAuthor: [star]
var markerArr = new Array();
var dz_dwdzdmArr = new Array();
///----------查询功能页方法--------------
//精确查询
function closeWindow(){
	$("#win").window("close"); 
}

function detailSearch(){
	$("#win").show();
	$("#win").window("open"); 
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	var len = dwlx.length;
    for(var i=0;i<len;i++){
    	if(row.dwlbdm.indexOf(dwlx[i])==0){
    		return '<a class="link" href="javascript:javascript:void(0)" onclick="doView(this,'+index+')">查看</a>&nbsp;'+
				   '<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">注销</a>';
    	}
    }
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;'+
		   '<a class="link" href="javascript:javascript:void(0)" onclick="Delete(this, '+index+')">注销</a>';
}

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
function Delete(btn,idx){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	delIdx=idx;
	$("#winDel").window('open');
	$("#xt_zxyy").val("");
	$("#xt_zxyy").focus();
}

function del_div_qd(){
	doDelete(null, delIdx);
}
function del_div_qx(){
	$("#winDel").window('close');
}

//删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/sydw/deletesydwxx';
	var datagrid_ID = 'dg';
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	var xt_zxyy = document.getElementById("xt_zxyy").value;
	if(xt_zxyy!=""){
		if(xt_zxyy.length>100){
			return;
		}else{
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
			    var data = {
			        "id":rowData.id,
					"xt_zxyy":$("#xt_zxyy").val()
				};
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: data
				}).done(function(result) {
					$("#winDel").window('close');
					$('#dg').datagrid('reload');
					doSubmitResult(result, null, datagrid_ID);
				});
			}
		});
	}
  }
}

//修改单条
function doView(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl/view?id="+rowData.id+"&mode=partview";
	menu_open("实有单位详情",editUrl);
}

//修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl/view?id="+rowData.id;
	menu_open("实有单位编辑",editUrl);
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
//实有单位新增
function syrkAdd(){
	menu_open('实有单位新增', '/dwjbxxb/create');
}
//搜索功能
function searchMain(){
	if (IE) {
		parent.frames["biz_center"].SydwMap.clearGraph();
	}else{
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.SydwMap.clearGraph();
	}
	var condition = document.getElementById("condition").value;
	if(condition=="请输入单位名称、地址信息"){
		condition="";
	}
	var reloadUrl = contextPath + '/sydwcx/queryDw';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	
	condition= $.trim(condition);
	if(Globalsydwlx!=null && Globalsydwlx!="" && typeof(Globalsydwlx)!="undefined"){
		$('#dg').datagrid('load',{condition:condition,dwlbdm:Globalsydwlx}); 
	}else{
		$('#dg').datagrid('load',{condition:condition});
	}
	$('#dg').datagrid("clearSelections");
}
//----精确查询框方法---------
//单击行地图定位
function onSelectRow(rowIndex, data){
	if(typeof(markerArr[data.dz_dwdzmlpdm])!="undefined" && markerArr[data.dz_dwdzmlpdm]!="" && markerArr[data.dz_dwdzmlpdm]!=null){
		if(IE){
			parent.frames["biz_center"].SydwMap.centerByPoint(markerArr[data.dz_dwdzmlpdm],19,dz_dwdzdmArr[data.dz_dwdzmlpdm]);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.SydwMap.centerByPoint(markerArr[data.dz_dwdzmlpdm],19,dz_dwdzdmArr[data.dz_dwdzmlpdm]);
		}
	}else{
		alert("单位地址无坐标");
	}
}
//查询按钮
function queryButton(){
	var dwlbdm = document.getElementById("dwlbdm").value;
	var dwmc = document.getElementById("dwmc").value;
	var dz_dwdzxz = document.getElementById("dz_dwdzxz").value;
	var jyfwzy = document.getElementById("jyfwzy").value;
	var jyxzdm = document.getElementById("jyxzdm").value;
	dwmc= $.trim(dwmc);
	dz_dwdzxz= $.trim(dz_dwdzxz);
	var reloadUrl = contextPath + '/sydw/list';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	var dwdzzt = "0";
	var ybzdz = document.getElementById("ybzdz");
	var wbzdz = document.getElementById("wbzdz");
	if(ybzdz.checked==true&&wbzdz.checked==false){
		dwdzzt = "1";
	}else if(ybzdz.checked==false&&wbzdz.checked==true){
		dwdzzt = "2";
	}
	if(Globalsydwlx!=null && Globalsydwlx!="" && typeof(Globalsydwlx)!="undefined"){
		$('#dg').datagrid('load',{'dwlbdm':Globalsydwlx,'dwmc':dwmc,'dz_dwdzxz':dz_dwdzxz,'jyfwzy':jyfwzy,'jjlxdm':jyxzdm,'dwdzzt':dwdzzt});
	}else{
		$('#dg').datagrid('load',{'dwlbdm':dwlbdm,'dwmc':dwmc,'dz_dwdzxz':dz_dwdzxz,'jyfwzy':jyfwzy,'jjlxdm':jyxzdm,'dwdzzt':dwdzzt});
	}
	closeWindow("win");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}


//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
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
	$('#dg').datagrid('load',{'zbz': zbz,'type': type,'mapRadius':mapRadius});
}

//重置加载
function loadGrid(){
	$('#dg').datagrid('load',{zbz:null,type:null,mapRadius:null,rows:21});  
	$('#dg').datagrid("clearSelections");
}
//datagrid加载完成后事件，地图定位
function loadpoints1(data){
	//延迟加载统计
	beforeTableLoad(data,'dg');
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if (mapWindow.SydwMap) {
			mapPoint(mapWindow);
		}else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}
//地图定位
function mapPoint(mapWindow) {
	//markerArr = new Array();
	if (mapWindow.SydwMap) {
		mapWindow.SydwMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		var dwidsArray = [];
		for (var i = 0; i < len; i++) {
			dwidsArray.push("'" + rows[i].id + "'");
			if (rows[i].dz_dwdzdm != "undefined" && rows[i].dz_dwdzdm != "") {
				dz_dwdzdmArr[rows[i].dz_dwdzdm] = rows[i].dz_dwdzdm;
			}
		}
		if (len > 0) {
			$.ajax({
				type:"GET",
				sync:true,
				url:contextPath+"/sydwcx/queryZbByDzId",
				data:{dwids:dwidsArray.join(",")},
				dataType:'json',
				success:function(json){
					var len = json.length;
					for (var i = 0; i < len; i++) {
						
						if (json[i].zbx!=null && json[i].zbx!=""){
							var marker = null;
							if (IE) {
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							} else{
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							}
							markerArr[json[i].dz_dwdzdm] = marker;
							dz_dwdzdmArr[json[i].dz_dwdzdm] = json[i].dz_dwdzdm;
							console.log(json[i].dz_dwdzdm);
						}
					}
				}
			});
		}
	}
}
var dwlx = ["03","04","05","06","0201","0203"];