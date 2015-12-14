
$(function(){    

	$("#dataList").hide();
	
	initGrid();
	
	initButtonBack();
	
	$("#query").click(function(){
		onClickQueryButton();
	});
	
	$("#reset").click(function(){
		$("#queryForm").form("reset");
	});

});  

function initButtonBack(){
	$("#buttonBack").click(function(){
		$("#searchDiv").show();
		$("#detailDiv").hide();
		$("#dataList").hide();
	});
}

function onClickQueryButton(){
	
	var zwxm = $("#zwxm").val();
	var sfzhm=$("#sfzhm").val();
	if(!zwxm &&!sfzhm){
		alert("中文姓名和身份证号至少输入一个");
		return false;
	}
	$("#detailDiv").hide();
	$("#searchDiv").hide();
	$("#dataList").show();
    
    $("#bbtjgrid").datagrid('load',{
    	'zwxm':zwxm,
    	'sfzhm':sfzhm        
	});
}

function initGrid(){

	var rowView = $.extend({},$.fn.datagrid.defaults.view,{
		renderRow:function(target,fields,frozen,rowIndex,rowData){
			var cc = [];
			var zwxm=rowData.zwx+rowData.zwm;
			 
			cc.push('<td colspan=' + fields.length + ' style="width:500;padding:5px;border:0;">');
			if(!frozen){

			    cc.push('<div style="width:80px;float:left;"> </div>');
				
				cc.push('<ul style="width: 210px;float:left;padding: 0;margin:0;margin-left:10px;">');
				cc.push('<li class="li_value" style="width: 70px">'+zwxm+'</li>');
				cc.push('<li class="li_value" style="width: 130px">'+rowData.xb+'</li>');
				cc.push('<li class="li_value" style="width:140px;">'+rowData.sfzhm+'</li>');
				//cc.push('<li class="li_value" style="width: 200px">'+rowData.gzdw+'</li>');
				cc.push('<li class="li_value" style="width:200px;height:auto;">'+rowData.xzz+'</li>');
				cc.push('<li class="li_value" style="width:200px;height:auto;">'+rowData.pcsszd+'</li>');
				cc.push('</ul>');
				
			/* 	cc.push('<div style="float:right;width:50px;height:99px> ');
				cc.push(' <a class="link" href="#" style="color:blue;text-decoration:underline;vertical-align: bottom;" onclick="showDetail('+rowData+')" >&nbsp详情&nbsp</a>');
				cc.push(' </div>'); */
			}
			cc.push(' </td>');
			return cc.join('');
		}
	});
	
	$('#bbtjgrid').datagrid({
		fit: false, 
		singleSelect : true,
		rownumbers : false,
		fitColumns : false,
		nowrap : true,
		border : false,
		idField:'sfzhm',
		pagination : true,
		pageSize:6,
		pageList:[6],
		queryParams : {
			rows:6,
			'zwxm':'${zwxm}',
			'sfzhm':'${sfzhm}'
		},
		url : path+'/zykc/queryFdbzcrjList',
		columns : [[ 
		{
			title:'',
			field:'XB',width:70,align:'left',
			halign:'center'
			
		}, {
			title : '',
			field:'zjhm',width:80,align:'left',
			halign:'center'
		}, {
			title : '',
			field:'zwx',
			width:40,align:'left',
			halign:'center'
		},{
			title : '',
			field:'XZZ',
			align:'left',halign:'center'
		}, {
			title : '',
			field:'PCSSZD',
			align:'left',halign:'center'
		}]],
		view:rowView,
		onLoadSuccess:function(node,data){
		   
		},
		onClickRow:function(index,row){
			    if(row){	
			    	$("#detailDiv").show();
			    	$("#sfzhm1").text(row.sfzhm);
			    	$("#zwm").text(row.zwx+row.zwm+"("+row.pyxm+")");
			    	$("#xb").text(row.xb);
			    	$("#hkszd").text(row.hkszd);
			    	$("#csd").text(row.csd);
			    	$("#dah").text(row.dah);
			    	$("#zjzl").text(row.zjzl);
			    	$("#zjhm1").text(row.zjhm);
			    	$("#pcsszd").text(row.pcsszd);
			    	$("#bbdwbm").text(row.bbdwbm);
			    	$("#bblxr").text(row.bblxr);
			    	$("#bblxdh").text(row.bblxdh);
			    	$("#gzdw").text(row.gzdw);
			    	$("#jtdh").text(row.jtdh);
			    	$("#mj").text(row.mj);
			    	$("#bbrq").text(row.bbrq);
			    	$("#bbqx").text(row.bbqx);
			    	$("#bbrylb").text(row.bbrylb);
			    	$("#flyj").text(row.flyj);
			    	$("#sfzdck").text(row.sfzdck);
			    	$("#bbyy").text(row.bbyy);
			    	$("#bz").text(row.bz);
			    	document.getElementById("topPhotoid").src = contextPath+"/zykc/queryFdbzcrjryPhoto.jpg?rydh="+row.rydh;

			    }  
			    else{
			    	$("#detailDiv").hide();
			    }
			 }
	});
}
