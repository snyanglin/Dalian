/*!
 * 报表统计
 * znjg - v1.0.0 (2014-07-24 11:06)
 * Copyright(c) 2014 founder
 */

/**
 * @deprecated 警情统计
 * @author yubo
 */
var jjtj = {

	

	

	/**
	 * 初始化
	 */
	initFun : function() {

		var jgdm = SysTool.getTxtVal("jtjj_jgdm");
		var fxsjs = SysTool.getTxtVal("jtjj_fxsjs");  
		var fxsje =SysTool.getTxtVal("jtjj_fxsje"); 
		this.jtjjquery(jgdm,fxsjs,fxsje);
	},

	
	
	/**
	 * 交通警情展现
	 * @param jgdm  中队机构代码
	 * @param starttime 开始时间
	 * @param endtime 结束时间
	 */
	jtjjquery: function(jgdm,fxsjs,fxsje) { 
		var param1 = {};
		alert(jgdm+fxsjs);
		param1['jqsszddm'] = jgdm;
		param1['starttime'] = fxsjs;
		param1['endtime'] = fxsje;
		$('#jtjjxxgrid').datagrid({
			fit: true, 
			height: 400,
			title:false,
			singleSelect : true,
			rownumbers : true,
			fitColumns : false,
			nowrap : true,
			border : false,
			showFooter:true,
			pagination : true,
			remoteSort:true,
			queryParams : {
			param : JSON.stringify(param1),
			jqsszddm :jgdm

			},
			url : 'jqxx/queryJqxxInfo.f',
			columns : [ [ {
				field : 'jjrdwmc',
				title : '所属辖区',
				width : 180,
				align: 'left',
				halign:'center'
			}, {
				field : 'zhddcount',
				title : '事故总次数',
				width : 100,
				sortable : true,
				align : 'center'
			 
			} ] ],
			onLoadSuccess : function(row) {//当表格成功加载时执行 
			}
		});
	}
}





