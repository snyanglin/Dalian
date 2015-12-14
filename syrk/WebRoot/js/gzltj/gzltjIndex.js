var kssj= $('#gzltj_index_kssj').val();
var jssj=$('#gzltj_index_jssj').val();
//要查询的等级 按分局查是1级，按派出所查是2级，按责任区查是3级
var level = 1;
//要查询的单位组织代码
var queryOrgCode="";
var queryUrl="";
//第几次查询，第一次查询时 从新加载datagrid，第二次之后就指更换参数就可以
var queryCount=1;
//导航条名称
var gzltj_indexDh_str=""
$(function() {
	//页面刚初始化时　默认查询的是自己所在的组织下的工作量统计
	if (userOrgLevel == "10" || userOrgLevel == "20" || userOrgLevel == "30"
		|| userOrgLevel == "40") {
	   level = 1;
	   queryOrgCode=level1Code;

	   gzltj_indexDh_str = '&nbsp;' + level1Name + '&nbsp;';

    } else if (userOrgLevel == "21" || userOrgLevel == "31"
		|| userOrgLevel == "41") {
	   level = 2;
	   queryOrgCode=level2Code;

	   gzltj_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
			+ 'onclick=dhClick(1)>'
			+ level1Name
			+ '</a>&nbsp;>>&nbsp;' + level2Name + '&nbsp;';
	   
    } else if (userOrgLevel == "32" || userOrgLevel == "42") {
	   level = 3;
	   queryOrgCode=level3Code;

	   gzltj_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
			+ 'onclick=dhClick(1)>'
			+ level1Name
			+ '</a>&nbsp;>>&nbsp;'
			+ '<a class="link" href="javascript:javascript:void(0)" '
			+ 'onclick=dhClick(2)>'
			+ level2Name
			+ '</a>&nbsp;>>'
			+ '<a class="link" href="javascript:javascript:void(0)" '
			+ 'onclick=dhClick(3)>'
			+ level3Name
			+ '</a>&nbsp;&nbsp;';

    } else if (userOrgLevel = "50") {
 	  queryOrgCode=level4Code;

	  level = 3;
	  gzltj_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
			+ 'onclick=dhClick(1)>'
			+ level1Name
			+ '</a>&nbsp;>>&nbsp;'
			+ '<a class="link" href="javascript:javascript:void(0)" '
			+ 'onclick=dhClick(2)>'
			+ level2Name
			+ '</a>&nbsp;>>'
			+ '<a class="link" href="javascript:javascript:void(0)" '
			+ 'onclick=dhClick(3)>'
			+ level3Name
			+ '</a>&nbsp;&nbsp;';
    }
	
    query();
});
// 点击查询按钮方法
function query() {
	kssj= $('#gzltj_index_kssj').val();
	jssj=$('#gzltj_index_jssj').val();
	if (kssj == "") {
		topMessagerAlert('', '请选择开始时间！');
		return false;
	}
	if (jssj == "") {
		topMessagerAlert('', '请选择结束时间！');
		return false;
	}
	queryUrl = basePath + 'gzltj/count?startDate='
		+ kssj + '&level=' + level + '&endDate='
		+ jssj + '&orgCode='+queryOrgCode;
	 this.loadInfo(queryUrl);
	 
	 //导航条名称
	document.getElementById("gzltj_indexDh").innerHTML = gzltj_indexDh_str;

}
function loadInfo(queryUrl) {
	if(queryCount>1){
		$('#gzltj_index_infoList').datagrid({
			url : queryUrl
		});
	}
	else{
     $('#gzltj_index_infoList').datagrid({
			url : queryUrl,
			toolbar : '#datagridToolbar',
			method : 'post',
			fitColumns : false,
			pagination : false,
			columns : [ [ {
				title : "单位",field : 'gxfjname',rowspan : 3,width : 200,formatter : gzltj_dwOnclick},        
				{title : "实有人口",colspan : 18}, 
				{title : "实有房屋",colspan : 6}, 
				{title : "实有单位",colspan : 6}], 
			   [{title : "人户一致",rowspan : 1,colspan : 3,width : 155}, 
			    {title : "人户分离",rowspan : 1,colspan : 3,width : 155},
			    {title : "寄住人口",rowspan : 1,colspan : 3,width : 155},
			    {title : "流动人口",rowspan : 1,colspan : 3,width : 155}, 
			    {title : "境外人员",rowspan : 1,colspan : 3,width : 155}, 
			    {title : "未落户人员",rowspan : 1,colspan : 3,width : 155}, 
			    {title : "出租房屋",rowspan : 1,colspan : 3,width : 155}, 
			    {title : "承租人",rowspan : 1,colspan : 3,width : 155}, 
			    {title : "单位基本信息",rowspan : 1,colspan : 3,width : 155}, 
			    {title : "从业人员",rowspan : 1,colspan : 3,width : 155}],
			   [{field : "rhyz_add",title : "新增",rowspan : 1,width : 40}, 
			    {field : "rhyz_update",title : "修改",rowspan : 1,width : 40},
			    {field : "rhyz_delete",title : "注销",rowspan : 1,width : 40},
                {field : "rhfl_add",title : "新增",rowspan : 1,width : 40},
                {field : "rhfl_update",title : "修改",rowspan : 1,width : 40},
                {field : "rhfl_delete",title : "注销",rowspan : 1,width : 40},
                {field : "jzrk_add",title : "新增",rowspan : 1,width : 40},
                {field : "jzrk_update",title : "修改",rowspan : 1,width : 40},
                {field : "jzrk_delete",title : "注销",rowspan : 1,width : 40},
                {field : "ldrk_add",title : "新增",rowspan : 1,width : 40}, 
                {field : "ldrk_update",title : "修改",rowspan : 1,width : 40},
                {field : "ldrk_delete",title : "注销",rowspan : 1,width : 40},
                {field : "jwry_add",title : "新增",rowspan : 1,width : 40},
                {field : "jwry_update",title : "修改",rowspan : 1,width : 40},
                {field : "jwry_delete",title : "注销",rowspan : 1,width : 40},
                {field : "wlhry_add",title : "新增",rowspan : 1,width : 40},
                {field : "wlhry_update",title : "修改",rowspan : 1,width : 40},
                {field : "wlhry_delete",title : "注销",rowspan : 1,width : 40},
                {field : "czfw_add",title : "新增",rowspan : 1,width : 40},
                {field : "czfw_update",title : "修改",rowspan : 1,width : 40}, 
                {field : "czfw_delete",title : "注销",rowspan : 1,width : 40},
                {field : "czr_add",title : "新增",rowspan : 1,width : 40}, 
                {field : "czr_update",title : "修改",rowspan : 1,width : 40}, 
                {field : "czr_delete",title : "注销",rowspan : 1,width : 40},
                {field : "dw_add",title : "新增",rowspan : 1,width : 40},
                {field : "dw_update",title : "修改",rowspan : 1,width : 40}, 
                {field : "dw_delete",title : "注销",rowspan : 1,width : 40},
                {field : "cyry_add",title : "新增",rowspan : 1,width : 40}, 
                {field : "cyry_update",title : "修改",rowspan : 1,width : 40}, 
                {field : "cyry_delete",title : "注销",rowspan : 1,width : 40}] 
			],
			onLoadSuccess : function() {
			}
		});
	  }
	queryCount++;
}


function gzltj_dwOnclick(val, row, index) {
	var returnStr = "";
	if (row.gxfjdm != "合计") {
		if (level == 1) {
            returnStr = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick=xzQuery("'
						+ row.gxfjdm
						+ '","'
						+ row.gxfjname
						+ '")>'
						+ row.gxfjname + '</a>&nbsp;';
			}
		 else if (level == 2) {

			returnStr = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick=xzQuery("'
					+ row.gxpcsdm
					+ '","'
					+ row.gxpcsname
					+ '")>'
					+ row.gxpcsname + '</a>&nbsp;';

		} else if (level == 3) {
				returnStr = '&nbsp;' + row.gxzrqname + '&nbsp;';
			
		}
	}else{
		returnStr='&nbsp;' +"合计"+ '&nbsp;';
	}
	return returnStr;
}
function xzQuery(orgCode, orgName) {
	if(level<3){
		level++;
	}
	//level此时不可能等于1
    if(level=="2"){
		  gzltj_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(1)>'
				+ level1Name
				+ '</a>&nbsp;>>&nbsp;' + orgName + '&nbsp;';
		  level2Name=orgName;
		  level2Code=orgCode;
		
	}else if(level=="3"){
		 gzltj_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(1)>'
				+ level1Name
				+ '</a>&nbsp;>>&nbsp;'
				+ '<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(2)>'
				+ level2Name
				+ '</a>&nbsp;>>'
				+ '<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(3)>'
				+ orgName
				+ '</a>&nbsp;&nbsp;';
		  level3Name=orgName;
		  level3Code=orgCode;
	}
	
	queryOrgCode=orgCode;
    
	query();
	
}
function dhClick(queryLevel) {
	if(queryLevel==1){
		level=1;
		gzltj_indexDh_str = '&nbsp;' + level1Name + '&nbsp;';
		queryOrgCode=level1Code;

	}else if(queryLevel==2){
		level=2;
		queryOrgCode=level2Code;
		gzltj_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(1)>'
				+ level1Name
				+ '</a>&nbsp;>>&nbsp;' + level2Name + '&nbsp;';
	}else if(queryLevel==3){
		level=3;
		queryOrgCode=level3Code;
		gzltj_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(1)>'
				+ level1Name
				+ '</a>&nbsp;>>&nbsp;'
				+ '<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(2)>'
				+ level2Name
				+ '</a>&nbsp;>>'
				+ '<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(3)>'
				+ level3Name
				+ '</a>&nbsp;&nbsp;';
	}
    
	query();
}

var idTmr = "";
function gzltj_index_toExcel(){
	
	exportUrl = basePath + 'gzltj/gzltjb_export?startDate='
	+ kssj + '&level=' + level + '&endDate='
	+ jssj + '&orgCode='+queryOrgCode;
	
	location.href=exportUrl;
}

function gzltj_index_toExcel1() {
	try {
		var gzltj_cols = $('#gzltj_index_infoList').datagrid('getColumnFields');
		var gzltj_rows = gzltj_index_infoData.rows;
		var exApp = new ActiveXObject("Excel.Application");
		var oWB = exApp.Workbooks.Add();
		var exSheet = exApp.ActiveWorkBook.WorkSheets(1);
		for ( var j = 0; j < gzltj_rows.length; j++) {
			for ( var k = 0; k < gzltj_cols.length; k++) {
				var gzltj_col = $('#gzltj_index_infoList').datagrid(
						'getColumnOption', gzltj_cols[k]);
				console.log("gzltj_col" + gzltj_col);
				var fn = gzltj_col.field;
				console.log("fn:" + fn);
				if (fn == "gxfjname") {
					if (level == "2") {
						fn = "gxpcsname";
					} else if (level == "3") {
						fn = "gxpczrqname";

					}
				}
				var fTitle = gzltj_col.title;
				var fv = gzltj_rows[j][fn];
				exSheet.Cells(3, k + 1).value = fTitle;
				exSheet.Cells(j + 4, k + 1).value = fv;

			}
		}
		// 单位合并
		exSheet.Range(exSheet.Cells(1, 1), exSheet.Cells(3, 1)).Merge();

		exSheet.Cells(1, 2).value = "实有人口";
		exSheet.Range(exSheet.Cells(1, 2), exSheet.Cells(1, 19)).Merge();

		exSheet.Cells(1, 20).value = "实有房屋";
		exSheet.Range(exSheet.Cells(1, 20), exSheet.Cells(1, 25)).Merge();
		exSheet.Cells(1, 26).value = "实有单位";
		exSheet.Range(exSheet.Cells(1, 26), exSheet.Cells(1, 31)).Merge();
		exSheet.Cells(2, 2).value = "人户一致";
		exSheet.Range(exSheet.Cells(2, 2), exSheet.Cells(2, 4)).Merge();
		exSheet.Cells(2, 5).value = "人户分离";
		exSheet.Range(exSheet.Cells(2, 5), exSheet.Cells(2, 7)).Merge();
		exSheet.Cells(2, 8).value = "寄住人口";
		exSheet.Range(exSheet.Cells(2, 8), exSheet.Cells(2, 10)).Merge();
		exSheet.Cells(2, 11).value = "流动人口";
		exSheet.Range(exSheet.Cells(2, 11), exSheet.Cells(2, 13)).Merge();
		exSheet.Cells(2, 14).value = "境外人员";
		exSheet.Range(exSheet.Cells(2, 14), exSheet.Cells(2, 16)).Merge();
		exSheet.Cells(2, 17).value = "未落户人员";
		exSheet.Range(exSheet.Cells(2, 17), exSheet.Cells(2, 19)).Merge();
		exSheet.Cells(2, 20).value = "出租房屋";
		exSheet.Range(exSheet.Cells(2, 20), exSheet.Cells(2, 22)).Merge();
		exSheet.Cells(2, 23).value = "承租人";
		exSheet.Range(exSheet.Cells(2, 23), exSheet.Cells(2, 25)).Merge();
		exSheet.Cells(2, 26).value = "单位基本信息";
		exSheet.Range(exSheet.Cells(2, 26), exSheet.Cells(2, 28)).Merge();
		exSheet.Cells(2, 29).value = "从业人员";
		exSheet.Range(exSheet.Cells(2, 29), exSheet.Cells(2, 31)).Merge();
		var fName = exApp.Application.GetSaveAsFilename("工作量统计.xls",
				"Excel Spreadsheets(*.xls),*.xls");
		oWB.SaveAs(fName);
		exApp.Quit();
		exApp = null;
		idTmr = window.setInterval("Cleanup();", 10);
	} catch (e) {
		console.log(e.message);
		topMessagerAlert('', '请设置浏览器的安全级别，启用ActiveX控件！');

	}
}
function Cleanup() {
	window.clearInterval(idTmr);
	CollectGarbage();
}