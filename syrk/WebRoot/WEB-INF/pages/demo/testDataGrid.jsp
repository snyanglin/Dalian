<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
</head>

<body>
<div style="margin:20px 0;"></div>
<table align="center" class="easyui-datagrid" id="dataList" title="DataGrid with Toolbar" 
		data-options="rownumbers:true,singleSelect:true,url:contextPath + '/common/jeasyui/demo/datagrid_data1.js',method:'get',
		toolbar:'#tb',pagination:true,resizeHandle:'right',fitColumns:true,pageSize:getPageSize(),pageList:[getPageSize(),getPageSize()*2]">
	<thead>
		<tr>
			<th data-options="field:'itemid',width:80">Item ID</th>
			<th data-options="field:'productid',width:100">Product</th>
			<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
			<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
			<th data-options="field:'attr1',width:200">Attribute</th>
			<th data-options="field:'status',width:60,align:'center'">Status</th>
		</tr>
	</thead>
</table>
<div id="tb" style="text-align:right;" width="100%">
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
<a href="#" class="easyui-linkbutton" title="query" data-options="iconCls:'icon-query',plain:true">查询</a>
</div>
</body>
</html>
<script type="text/javascript">

document.getElementById("dataList").style.width = document.body.clientWidth - 20;
document.getElementById("dataList").style.height = getPageSize() * 25 + 114;

function getPageSize() {
	var pageSize = 0;
	var dataRowHeight = document.body.clientHeight - 150;
	if (dataRowHeight > 0) {
		pageSize = Math.floor(dataRowHeight / 25);
	}  	
	if (pageSize < 5) {
		pageSize = 5;
	}
	return pageSize;
}


	var toolbar = [{
			text:'Add',
			iconCls:'icon-add',
			handler:function(){alert('add');aaa();}
		},{
			text:'Cut',
			iconCls:'icon-cut',
			handler:function(){alert('cut')}
		},'-',{
			text:'Save',
			iconCls:'icon-save',
			handler:function(){alert('save')}
		}];

	function aaa(){
	   var dg = $('#dataList');
       dg.datagrid('loadData',[]);
       dg.datagrid({pagePosition:$('#p-pos').val()});
       dg.datagrid('getPager').pagination({pageSize:20,layout:['first','prev','sep','manual','sep','next','last','sep']});
    }
    
    /*
      $(function () {

            //加载信息
            $('#dataList').datagrid({
                url: contextPath + '/common/jeasyui/demo/datagrid_data1.json',
                loadMsg: '数据装载中......',
                singleSelect: true,
                columns: [[
                { field: 'itemid', title: '部门名称', width: $(this).width() * 0.1 },
                { field: 'productid', title: '部门负责人', width: $(this).width() * 0.1 },
                { field: 'listprice', title: '联系电话', width: $(this).width() * 0.1 },
                { field: 'unitcost', title: '备注', width: $(this).width() * 0.1 },
                { field: 'attr1', title: '备注', width: $(this).width() * 0.1 },
                { field: 'status', title: '备注', width: $(this).width() * 0.1 }
                ]],
                pagination: true,
                rownumbers: true
            });
            var p = $('#dataList').datagrid('getPager');
            $(p).pagination({
                pageSize: 15,//每页显示的记录条数，默认为10           
                pageList: [15, 30, 45],//可以设置每页记录条数的列表           
                beforePageText: '第',//页数文本框前显示的汉字           
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
            });
        });
	*/
	
</script>
