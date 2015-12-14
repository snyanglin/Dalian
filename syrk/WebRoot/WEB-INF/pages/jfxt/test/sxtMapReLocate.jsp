<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<title>调整摄像头位置</title>



</head>
  

<body class="easyui-layout">   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	    <div id="cc" class="easyui-layout" data-options="fit:true">   
		 	<!-- 地图区域start  -->   
		    <div data-options="region:'center',title:'中心地图区域',split:true" >
		    	<div id="map" > </div>
		    </div> 
		    <!-- 地图区域end  -->   
		    <!-- 东侧区域start  -->  
	    	<div data-options="region:'east',iconCls:'icon-reload',title:'东边',split:true" style="width:300px;">
				<table id="dg" class="easyui-datagrid" data-options="method:'post',toolbar:'#datagridToolbar',
					
		            method:'post',
		            singleSelect:true,
		            rownumbers:true,
		            selectOnCheck:true,
		            checkOnSelect:true,
		            border:false,
		            sortOrder:'asc',
		            sortName:'dwmc',
		            idField:'id',
		            pageSize:getAutoPageSize(),
		            pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						    <thead>
						        <tr>
						            <th data-options="field:'dwmc', width:15,	align:'left',	halign:'center',sortable:true">点位名称</th>
						            <th data-options="field:'jd', width:25,	align:'left',	halign:'center',sortable:true">经度</th>
						            <th data-options="field:'wd', width:15,	align:'left',halign:'center',sortable:true">纬度</th>
						            <th data-options="field:'process',width:10,align:'center',	halign:'center',formatter:datagridProcessFormater">重新定位</th>
						        </tr>

						    </thead>
						</table>
				<!-- 工具条  -->
				<div id="datagridToolbar" style="padding:5px;height:30px;width:100%">
				   	<table width="100%">				   	
				   	<tr>
					   	<td>开始日期：</td>
					   	<td>
					   		<input type="text" name="startDate" id="startDate"  class="easyui-validatebox "   style="width:100px;" value="2014-12-23"
							data-options="required:false,tipPosition:'right',validType:['date[\'yyyy-MM-dd\']']"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
					   	</td>
					</tr>
					<tr>
					   	<td>结束日期：</td>
					   	<td>
					   		<input type="text" name="endDate" id="endDate"  class="easyui-validatebox "   style="width:100px;"  value="2014-12-23"
							data-options="required:false,tipPosition:'right',validType:['date[\'yyyy-MM-dd\']']"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /></td>
					   	</td>
				    </tr>
			        <tr>
			        	<td>
			        	<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px" onclick="searchSxt();"/>
			        	</td>
			        </tr>				    
				    </table>
					
				</div>
    
    		</div>
    		<!-- 东侧区域end  --> 
    	</div>
    	<!-- div id="cc" end  -->  
    </div>
     <!-- data-options="region:'center'" end  -->
</body>      
<script type="text/javascript">

//自定义列--定位
function datagridProcessFormater(val, row, index) { // 自定义操作生成
  return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doLocation(this,'+index+')">详细信息</a>&nbsp;&nbsp;';
}
//开始定位

function doLocation(linkObject, index) {
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	alert(index+","+rowData['id']+","+rowData['dwmc']);

	alert(rows.length);	
}

	//根据条件搜索摄像头
	function searchSxt(){
		var startDate=$('#startDate').val();//开始日期
		var endDate=$('#endDate').val();//结束日期		
	
		var reloadUrl  = contextPath + '/sptgl/querySpsxtForMap2?locate=N';//没有坐标的摄像头
		alert(startDate+","+endDate+","+reloadUrl);
		var opt = $('#dg').datagrid('options');
		opt.url = reloadUrl;
		//opt1.url = reloadUrl;	
		alert(opt.url);	
		$('#dg').datagrid('reload',{startDate:startDate,endDate:endDate	});
	
	}

</script>
</html>
