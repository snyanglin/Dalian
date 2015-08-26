var khnf= "";
var khz="";
//要查询的等级 按分局查是1级，按派出所查是2级，按责任区查是3级
var level = 1;
//要查询的单位组织代码
var queryOrgCode="";
//查询的组织机构等级：fj、pcs、zrq
var zzjgdj="fj";
var queryUrl="";

//第几次查询，第一次查询时 从新加载datagrid，第二次之后就指更换参数就可以
var queryCount=1;
//导航条名称
var zakh_indexDh_str=""
$(function() {	
	//页面刚初始化时　默认查询的是自己所在的组织下的工作量统计
	if (userOrgLevel == "10" || userOrgLevel == "20" || userOrgLevel == "30"
		|| userOrgLevel == "40") {
	   level = 1;
	   queryOrgCode=level1Code;
	   zzjgdj="fj";
	   zakh_indexDh_str = '&nbsp;' + level1Name + '&nbsp;';
    } else if (userOrgLevel == "21" || userOrgLevel == "31"
		|| userOrgLevel == "41") {
	   level = 2;
	   queryOrgCode=level2Code;
	   zzjgdj="pcs";
	   zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
			+ 'onclick=dhClick(2)>'
			+ level2Name
			+ '</a>&nbsp;';
	   
    } else if (userOrgLevel == "32" || userOrgLevel == "42") {
	   level = 3;
	   queryOrgCode=level3Code;
	   zzjgdj="zrq";
	   
	   zakh_indexDh_str = '&nbsp;'
			+ level3Name
			+ '&nbsp;';


    } else if (userOrgLevel = "50") {
 	  queryOrgCode=level4Code;
 	  zzjgdj="zrq";
	  level = 3;
	  zakh_indexDh_str = '&nbsp;'+ level4Name+ '&nbsp;';
			
	  
    }
	
	//初始化时 默认选中年份和周期（本年和前一个星期）
	var yeardata=$("#zakh_index_khnf").combobox('getData');
	if(yeardata.length>0){
		$("#zakh_index_khnf").combobox('select',yeardata[yeardata.length-1].id);
		$("#zakh_index_khz").combobox("setValue", "111");

	}
	var year = $('#zakh_index_khnf').combobox('getValue');
	
    var url =contextPath+'/zakhgetweek/zakhWeekJson?year='+year;
	$("#zakh_index_khz").combobox('reload', url);
	
	var weekdata=$("#zakh_index_khz").combobox('getData');
	if(weekdata.length>0){
		$("#zakh_index_khz").combobox("setValue", data[weekdata.length-1].id);

	}
	
    query();
});
// 点击查询按钮方法
function query() {
	khnf= $('#zakh_index_khnf').combobox('getValue');
	khz=$('#zakh_index_khz').combobox('getValue');
	if (khnf == "") {
		topMessagerAlert('', '请选择查询年份');
		return false;
	}
	if (khz == "") {
		topMessagerAlert('', '请选择考核周！');
		return false;
	}
	 queryUrl=basePath+'zakh/count?khnf='+khnf+'&khz='+khz+'&zzjgdj='+zzjgdj+'&orgid='+queryOrgCode;

	 this.loadInfo(queryUrl);	 
	 //导航条名称
	document.getElementById("zakh_indexDh").innerHTML = zakh_indexDh_str;

}
function loadInfo(queryUrl) {
	if(queryCount>1){
		$('#zakh_index_infoList').datagrid({
			url : queryUrl
		});
	}
	else{
		$('#zakh_index_infoList').datagrid({
			url:queryUrl,
			toolbar:'#datagridToolbar',
			method:'post',
			fitColumns:true,
			fit: true,
			pagination:true,
			pageSize:24,
			pageList:[24,45,60],
			loader:zakh_fy,
			columns:[[
		    {title:'排名',field:'zakh_pm',width:50,align:'center',halign:'center'},
		    {title:'单位机构',field:'zakh_dwjg',width:150,align:'center',halign:'center',formatter:zakh_dwjgOnclick},
		    {title:'考核项目',field:'zakh_khx',width:150,align:'center',halign:'center'},
		    {title:'本周扣分',field:'zakh_kfs',width:150,align:'center',halign:'center'},
		    {title:'累计扣分',field:'zakh_ljkfs',width:150,align:'center',halign:'center'},
		    {title:'考核得分',field:'zakh_dfs',width:150,align:'center',halign:'center'},
		    {title:'总分数',field:'zakh_zfs',width:150,align:'center',halign:'center'},
		    {title:'详情',field:'xq',width:150,align:'center',halign:'center',formatter:datagridProcessFormater},
		    {field:'zakh_zzjgid',hidden:true}
			]],
			onLoadSuccess:function(){
				zakh_hbDyg();
				$('#zakh_index_infoList').datagrid("getPager").pagination({displayMsg:"",showPageList:false,showRefresh:false});
		    }
		});
	  }
	queryCount++;
}

var cacheFlag=1;
var zakh_index_infoData=null;
/**
 * 分页
 * @param param
 * @param success
 * @param error
 * @returns {Boolean}
 */
function zakh_fy(param,success,error){
	var that=$(this);
	var opts=that.datagrid("options");
	if(!opts.url){
		return false;
	}
	var cache=that.data().datagrid.cache;
	if(cacheFlag==0){
		if(!cache){
			$.ajax({
				type:opts.method,
				url:opts.url,
				dataType:"json",
				success:function(data){
					zakh_index_infoData=data;
					that.data().datagrid['cache']=data;
					success(bulidData(data));
				},
				error:function(){
					error.apply(this,arguments);
				}
			});
		}else{
			success(bulidData(cache));
		}
	}else{
		$.ajax({
			type:opts.method,
			url:opts.url,
			dataType:"json",
			success:function(data){
				zakh_index_infoData=data;
				that.data().datagrid['cache']=data;
				success(bulidData(data));
			},
			error:function(){
				error.apply(this,arguments);
			}
		});
	}
	function bulidData(data){
		var temp=$.extend({},data);
		var tempRows=[];
		var start=(param.page-1)*parseInt(param.rows);
		var end=start+parseInt(param.rows);
		var rows=data.rows;
		for(var i=start;i<end;i++){
			if(rows[i]){
				tempRows.push(rows[i]);
			}else{
				break;
			}
		}
		temp.rows=tempRows;
		return temp;
	}
}
function zakh_dwjgOnclick(val, row, index) {
	var returnStr = "";
		if (level == 1||level == 2) {
            returnStr = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick=xzQuery("'
						+ row.zakh_zzjgid
						+ '","'
						+ row.zakh_dwjg
						+ '")>'
						+ row.zakh_dwjg + '</a>&nbsp;';
			}
        else if (level == 3) {
				returnStr = '&nbsp;' + row.zakh_dwjg + '&nbsp;';
			
		}
	
	return returnStr;
}
function xzQuery(orgCode, orgName) {
	if (level < 3) {
		level++;
	}
	if (userOrgLevel == "10" || userOrgLevel == "20" || userOrgLevel == "30"
			|| userOrgLevel == "40") {
		// level此时不可能等于1
		if (level == "2") {
			zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(1)>'
					+ level1Name
					+ '</a>&nbsp;>>&nbsp;'
					+ orgName + '&nbsp;';
			level2Name = orgName;
			level2Code = orgCode;
			zzjgdj = "pcs";
		} else if (level == "3") {
			zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(1)>'
					+ level1Name
					+ '</a>&nbsp;>>&nbsp;'
					+ '<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(2)>'
					+ level2Name
					+ '</a>&nbsp;>>'
				    + orgName + '&nbsp;';
			level3Name = orgName;
			level3Code = orgCode;
			zzjgdj = "zrq";
		}
	} else if (userOrgLevel == "21" || userOrgLevel == "31"
			|| userOrgLevel == "41") {
		// level此时不可能等于1
		if (level == "2") {
			zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
				+ 'onclick=dhClick(2)>'
				+ level2Name
				+ '</a>&nbsp;'				
			level2Name = orgName;
			level2Code = orgCode;
			zzjgdj = "pcs";
		} else if (level == "3") {
			zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(2)>'
					+ level2Name
					+ '</a>&nbsp;>>&nbsp;'
					+ '<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(3)>'
					+ orgName
					+ '</a>&nbsp;'
					
			level3Name = orgName;
			level3Code = orgCode;
			zzjgdj = "zrq";
		}
		
	}
	queryOrgCode = orgCode;

	query();

}
function dhClick(queryLevel) {
	if (userOrgLevel == "10" || userOrgLevel == "20" || userOrgLevel == "30"
			|| userOrgLevel == "40") {
		if (queryLevel == 1) {
			level = 1;
			zakh_indexDh_str = '&nbsp;' + level1Name + '&nbsp;';
			queryOrgCode = level1Code;
			zzjgdj = "fj";

		} else if (queryLevel == 2) {
			level = 2;
			queryOrgCode = level2Code;
			zzjgdj = "pcs";
			zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(1)>'
					+ level1Name
					+ '</a>&nbsp;>>&nbsp;'
					+ level2Name + '&nbsp;';
		} else if (queryLevel == 3) {
			level = 3;
			queryOrgCode = level3Code;
			zzjgdj = "zrq";
			zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(1)>'
					+ level1Name
					+ '</a>&nbsp;>>&nbsp;'
					+ '<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(2)>'
					+ level2Name
					+ '</a>&nbsp;>>' + level3Name + '&nbsp;';
		}
	} else if (userOrgLevel == "21" || userOrgLevel == "31"
			|| userOrgLevel == "41") {
		// 分局人查看 不可能查看到第一级的
		if (queryLevel == 2) {
			level = 2;
			queryOrgCode = level2Code;
			zzjgdj = "pcs";
			zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(2)>' + level2Name + '</a>&nbsp;';
		} else if (queryLevel == 3) {
			level = 3;
			queryOrgCode = level3Code;
			zzjgdj = "zrq";
			zakh_indexDh_str = '&nbsp;<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(2)>'
					+ level2Name
					+ '</a>&nbsp;>>&nbsp;'
					+ '<a class="link" href="javascript:javascript:void(0)" '
					+ 'onclick=dhClick(3)>' + level3Name + '</a>&nbsp;';
		}

	}

	query();
}
function zakhYear_onChange(newValue, oldValue) {
	var year = $('#zakh_index_khnf').combobox('getValue');
	if (year != "") {
		var url =contextPath+'/zakhgetweek/zakhWeekJson?year='+year;
	    $("#zakh_index_khz").combobox('reload', url);
		$("#zakh_index_khz").combobox('setValue',"");
	}
	
}

var datagridProcessFormater = function(val, row, index) {
	if(row.zakh_khx=="基础信息采集")
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick=zakh_index_ck("'+row.zakh_zzjgid+'","'+row.zakh_dwjg+'")>查看</a>&nbsp;';
	else
		return '&nbsp;查看&nbsp;';
};
function zakh_index_ck(zakh_zzjgId,zakh_zzjgName){
	$('#zakh_index_xqWin').window({title:zakh_zzjgName});
	zakh_index_onloadXq(zakh_zzjgId);
	$('#zakh_index_xqWin').window('open');
}
function zakh_index_onloadXq(zakh_zzjgId){
	var year=$('#zakh_index_khnf').combobox('getValue');
	var week=$('#zakh_index_khz').combobox('getValue');
	var zakh_index_queryUrl="";
	zakh_index_queryUrl=basePath+'zakh/countXX?year='+year+'&week='+week+'&orgid='+zakh_zzjgId;
	$('#zakh_index_xqList').datagrid({
		url:zakh_index_queryUrl,
		method:'post',
		striped: false,
		singleSelect:true,
		selectOnCheck:false,
		fitColumns:true,
		checkOnSelect:false,
		border:false,
		fit: true,
		pagination:false, 
		columns:[[
	    {title:'考核项',field:'zakh_xq_khx',width:50,align:'center',halign:'center'},
	    {title:'考核细项',field:'zakh_xq_khxx',width:50,align:'center',halign:'center'},
	    {title:'考核项小类',field:'zakh_xq_khxl',width:50,align:'center',halign:'center'},
	    {title:'各项已采集数',field:'zakh_xq_ycjs',width:50,align:'center',halign:'center'},
	    {title:'各项注销数',field:'zakh_xq_kfz',width:50,align:'center',halign:'center'},
	    {title:'采集有效数',field:'zakh_xq_cjzs',width:50,align:'center',halign:'center'},
	    {title:'常量数',field:'zakh_xq_cls',width:50,align:'center',halign:'center'}
		]],
		onLoadSuccess:function(){
			var rows= $('#zakh_index_xqList').datagrid('getRows');
			var opts = $('#zakh_index_xqList').datagrid('getColumnFields');
			for(var i=0;i<opts.length;i++){
				var col=$('#zakh_index_xqList').datagrid('getColumnOption',opts[i]);
				var cName=col.field;
				var num=0;
				var sum=1;
				for(var j=0;j<rows.length;j++){
					if((j+1)<rows.length && cName!="zakh_xq_ycjs" && cName!="zakh_xq_kfz" && rows[j][cName]==rows[j+1][cName]){
						sum=sum+1;
						$('#zakh_index_xqList').datagrid('mergeCells',{
							index:num,
							field:cName,
							rowspan:sum
						});
					}else{
						num=0;
						num=num+j+1;
						sum=1;
					}
			
				}
			}
	    }
	});
	
}
function zakh_hbDyg(){
	var totalNums=$('#zakh_index_infoList').datagrid('getData').total;
	if(totalNums==0){
		topMessagerAlert('', '此时间内没有数据！');
		return;
	}
	for(var i=0;i<totalNums;i++){
		if(i%3==0){
			$('#zakh_index_infoList').datagrid('mergeCells',{
				index:i,
				field:'zakh_pm',
				rowspan:3
			});
			$('#zakh_index_infoList').datagrid('mergeCells',{
				index:i,
				field:'zakh_dwjg',
				rowspan:3
			});
		}
	}
}
function zakh_toExcel(){
	exportUrl =basePath+'zakh/zakh_export?khnf='+khnf+'&khz='+khz+'&zzjgdj='+zzjgdj+'&orgid='+queryOrgCode;
	location.href=exportUrl;
}

