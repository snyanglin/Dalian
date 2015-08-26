/**
 * 
 * @description:矛盾调节添加
 * @author: tian_chengwei@founder.com     
 * @date:2015-06-02
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 * quersion:应将重复使用语句抽取成独立方法
 */

$(document).ready(function(){
	initDepartmentSearch('dwmc', {glpcsid: ''}, 'tjdwid', 'tjdwmc', {});
});
//进入页面后调用此函数
function doInit(paramArray) {
	var flag = document.getElementById("flag").value;
	if(flag=="add"){
		$("#tjjgdm").combobox("setValue","3");
	}else {
		fstj();
	}
	
}
//根据是否条件控制文本是否可编辑
function fstj(){
	var gx=$("#tjjgdm").combobox("getText");
	if(gx=="未解决"){
		setInputReadonly('wtjgzjh',false);	
	}

}
//保存调节信息后，之行此函数，刷新TABLE，调用父页面的tjxList();
function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	parent.tjxList();	
}
