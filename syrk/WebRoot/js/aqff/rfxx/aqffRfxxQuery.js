// @Author:       [xu_haibo@founder.com.cn]
//页面关闭方法
function closeWindow(){
	$("#win").window("close"); 
}
//精确查询方法
function detailSearch(){
	$("#win").show();
	$("#win").window("open"); 
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return  '<a class="link" href="javascript:javascript:void(0)" onclick="open_rfxx_info(this, '+index+')">查看</a>';
}
// 查询单条
function open_rfxx_info(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/rfxxb/queryRfxxInfo?id="+rowData.id;
	menu_open("人防信息查看",editUrl);
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
//模糊查询
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
	var reloadUrl = contextPath + '/rfxxb/queryMHRfInfo';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	condition= $.trim(condition);
	$('#dg').datagrid('load',{ffzrrxm:condition});
	$('#dg').datagrid("clearSelections");
}
//坐标标注方法
function onSelectRow(rowIndex, data){
	mapPointAndArea(data);
}
//精确查询按钮
function queryButton(){
	var fj = "0";
	var pcs = "0";
	var zrq = "0";
	if($("#cc1").val()!=""){
		fj=$("#cc1").val();
	}
	if($("#cc2").val()!=""){
		pcs=$("#cc2").val();
	}
	if($("#cc3").val()!=""){
		zrq=$("#cc3").val();
	}
	if (fj=="210200000000") {
			fj="0";
			pcs="0";
			zrq = "0";
	}
	var zzjglx;
	if (fj=="0" && pcs=="0"){zzjglx=11;}
	if (fj!="0" && pcs=="0"){zzjglx=12;}
	if (fj!="0" && pcs!="0"){zzjglx=13;}
	var url ="<%=contextPath%>/ReportEmitter?rpt=YXSJTJB.brt&params=";
	url = url+"ORG_FJ="+fj+";ORG_PCS="+pcs+";ORG_ZRQ="+zrq+";zzjglx="+zzjglx+"fj="+fj.substring(0,6)+"pcs="+pcs.substring(0, 8);
	fj=fj.substring(0,6);
	pcs=pcs.substring(0, 8)
	var zzmc = document.getElementById("zzmc").value;
	var zzlbdm = document.getElementById("zzlbdm").value;
	var ffzzxsdm = document.getElementById("ffzzxsdm").value;
	var dz_zzdzmlpxz = document.getElementById("dz_zzdzmlpxz").value;
	var ffzrrryly = document.getElementById("ffzrrryly").value;
	var sfzacbdm = document.getElementById("sfzacbdm").value;
	zzmc= $.trim(zzmc);
	if(fj==0){
		fj='';
	}
	if(pcs==0){
		pcs='';
	}
	if(zrq==0){
		zrq='';
	}
	dz_zzdzmlpxz= $.trim(dz_zzdzmlpxz);
	var reloadUrl = contextPath + '/rfxxb/queryJQRfInfo';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
		$('#dg').datagrid(
			'load',
			{    
				'zzmc':zzmc,
				'zzlbdm':zzlbdm,
				'ffzzxsdm':ffzzxsdm,
				'dz_zzdzmlpxz':dz_zzdzmlpxz,
				'sfzacbdm':sfzacbdm,
				'fj':fj,
				'pcs':pcs,
				'zrq':zrq,
				'ffzrrryly':ffzrrryly,
				'sfck':1
			});
	closeWindow("win");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
	$("#cc2").combobox("setValue","");
	$("#cc3").combobox("setValue","");
}
//坐标标注
function mapPointAndArea(data) {
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}
	else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	mapWindow.RfxxMap.moveMapToBjzbz();
	if(data.xldx!=''){
		if (IE) {
			marker = mapWindow.addMarker(data.ffzzmc,data.xldx,data.xldy,"location.png",null,null,34,34,false,null,null);
			if(data.xlqy && data.xlqy!="undefined"){
				mapWindow.showarea(data.xlqy);
			}
		} else{
			marker = mapWindow.addMarker(data.ffzzmc,data.xldx,data.xldy,"location.png",null,null,34,34,false,null,null);
		}
	}
}