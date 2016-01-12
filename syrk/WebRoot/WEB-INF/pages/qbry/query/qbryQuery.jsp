<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgLevel = "";
    String userOrgName = "";
    
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgLevel = userInfo.getUserOrgLevel();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>重点人员管理</title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
    </script>
    <style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}
	.table-toolbar{
		width:100%;
	}
	.table-toolbar .td-title{
		text-align:right;
		padding-top:15px;
	}
	.table-toolbar .td-value{
		text-align:left;
		padding-top:15px;
	}
	#datagridToolbar{
		padding-bottom:20px;
	}
	.td-btns-container{
		border-top:1px solid #ccc;
		padding-top:20px;
		padding-bottom:20px;
	}
	.td-btns{
		padding-top:15px;
	}
	#reset-btn,
	#dzaddid{
		margin-left:25px;
	}
	.td-value input, 
	.td-value input{
		width:160px;
		height:22px;
	}
	</style>
    <script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryzbManage.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false" onload="startup()">
       <div data-options="region:'center',border:false" style="width:600px;height:auto;">
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/qbryManager/Qurey/queryList',
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:20,
		        		pageList:[10,20,30],
		        		singleSelect:true,
		        		fitColumns:true,
						toolbar:'#datagridToolbar'">
			        <thead>
			          <tr>
				            <th data-options="field:'zdrylb',width:100,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLB.js'">重点人员细类</th>
				            <th data-options="field:'xm',width:70,align:'center',sortable:true,halign:'center'">姓名</th>
				            <th data-options="field:'gmsfhm',width:100,align:'center',sortable:true,halign:'center'">身份证号码</th>
				            <th  data-options="field:'xbdm',width:30,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XBDM.js'">性别</th>
				            <th  data-options="field:'xzd',width:100,align:'center',halign:'center',sortable:true">现居住地址</th>
				            <th  data-options="field:'hjd',width:100,align:'center',halign:'center',sortable:true">户籍地址</th>
				            <th  data-options="field:'bjzdryrksj',width:100,align:'center',halign:'center',sortable:true">入部省库时间</th>
				            <th  data-options="field:'glzt',width:50,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBRYGLZT.js'">管理状态</th>
				            <th data-options="field:'process',align:'center',width:100,halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
			       </thead>
	       </table>
	       <div id="datagridToolbar" style="padding:5px;height:auto;">
	       <form id ="queryForm" >
			<table cellspacing = "0" cellpadding="0" class="table-toolbar">
				<tr>
					<td class="td-title">重点人员大类:</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="zdrygllxdm" name="zdrygllxdm" style="width:180px;" 
								data-options="url: contextPath +'/common/dict/BD_D_ZDRYGLLX.js', fzFilter:'QB', 
									valueField:'id',textField:'text',method:'get',onChange:zdrylbChange"/>
					</td>
					<td class="td-title">重点人员大细类:</td>
					<td class="td-value">
						<input class="easyui-combotree" type="text" id="zdrylbStr" name="zdrylb" style="width:180px;" 
								data-options="onlyLeaf:true,valueField:'id',textField:'text',
	    							multiple:false,panelWidth:400,method:'get',lines:true,tipPosition:'left'"/>
					</td>
					<td class="td-title">姓名：</td>
					<td class="td-value">
						<input type="text" name="xm" id="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					</td>
				</tr>
				<tr>
					<td class="td-title">身份证号码:</td>
					<td class="td-value">
						<input type="text" name="gmsfhm" id="gmsfhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					</td>
					<td class="td-title">性别:</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					</td>
					<td class="td-title">国籍：</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="gjdm" name="gjdm" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					</td>
				</tr>
				<tr>
					<td class="td-title">现居住地址:</td>
					<td class="td-value">
						<input type="text" name="xzd" id="xzd" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					</td>
					<td class="td-title">户籍地址:</td>
					<td class="td-value">
						<input type="text" name="hjd" id="hjd" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					</td>
					<td class="td-title">下发状态:</td>
					<td class="td-value" colspan="5">
						<input class="easyui-combobox" type="text" id="glzt" name="glzt" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/BD_D_QBRYGLZT.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					</td>
				</tr>
			
				<tr>
					<td class="td-title">责任单位(分局):</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="qbdd"  style="width:180px;"
								            data-options="
								            valueField:'id',
								            textField:'text',
								            selectOnNavigation:false,
								            method:'get',
								            tipPosition:'right',
								            onChange:qbddlbChange"/>
					</td>
					<td class="td-title">责任单位(派出所):</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="qbpcs"  style="width:180px;"
								            data-options="
								            valueField:'id',
								            textField:'text',
								            selectOnNavigation:false,
								            method:'get',
								            tipPosition:'right',
								            onChange:qbpcslbChange"/>
					</td>
					<td class="td-title">责任单位(责任区):</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="qbzrq"  style="width:180px;"
								            data-options="
								            valueField:'id',
								            textField:'text',
								            selectOnNavigation:false,
								            method:'get',
								            tipPosition:'right'"/>
					</td>
				</tr>
				<tr>
					<td class="td-btns" colspan="6" align="center">
						<div class="td-btns-container">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="queryButton()">查询</a>
							<a id="reset-btn" class="easyui-linkbutton" iconCls="icon-reset" href="javascript:void(0);" onclick="resetButton()">重置</a>
						</div>
					</td>
				</tr>
			</table>
			</form>
        </div>
	        
	  </div>
	  
	 
   </body>
</html>
<script type="text/javascript">
/**
 * @title:doUpdateAndXq
 * @description:地址维护
 * @author: zhang_guoliang@founder.com
 * @param type
 *            0为可编辑、1为只读，dzChb地址层户表 0为层户地址对象表、1为层户地址审核表
 * @date:2015-02-04 18:23:35
 */
doUpdateAndXq = function(linkObject, index) {
	// 阻止冒泡，不然要执行onClickRow
	cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	menu_open(rowData.xm + '', '/qbryManager/Detail/' + rowData.id + '/view?mainTabID=' + getMainTabID());
};

/**
 * @title:qbddlbChange
 * @description:分局类型变化
 * @author: QinXiaoYun
 */
qbddlbChange = function(newVal,oldVal){
	var qbddCode = $('#qbdd').combobox("getValue");
	if(qbddCode==''){//获取父级部门为空
		setInputReadonly('qbpcs',true);
		$('#qbpcs').combobox("setValue","");
	}
	else{
		setInputReadonly('qbpcs',false);
		$("#qbpcs").combobox({
			url:'<%=contextPath%>/orgPublicSelect/queryComboBoxList?parentOrgCode='+qbddCode
		});
	}
};

/**
 * @title:qbpcslbChange
 * @description:派出所类型变化
 * @author: QinXiaoYun
 */
qbpcslbChange = function(newVal,oldVal){
	var qbddCode = $('#qbpcs').combobox("getValue");
	if(qbddCode==''){//获取父级部门为空
		setInputReadonly('qbzrq',true);
		$('#qbzrq').combobox("setValue","");
	}
	else{
		setInputReadonly('qbzrq',false);
		$("#qbzrq").combobox({
			url:'<%=contextPath%>/orgPublicSelect/queryComboBoxList?parentOrgCode='+qbddCode
		});
	}
};

/**
 * @title:startup
 * @description:页面加载的时执行的函数
 * @author: QinXiaoYun
 */
startup = function (){
	//获取当前登录者的所属部门的级别
	var level = '<%=userOrgLevel%>';
	//获取当前登录者的所属部门的名称
	var curName = '<%=userOrgName%>';
	//获取部门的所属部门的代码
	var curCode = '<%=userOrgCode%>'; 
	
    var qbzdCode = '${qbzdCode}';
	var qbddCode = '${qbddCode}';
	var qbpcsCode = '${qbpcsCode}';
	
	
	if(qbzdCode!=''){
		$("#qbdd").combobox({
			url:'<%=contextPath%>/orgPublicSelect/queryComboBoxList?parentOrgCode='+qbzdCode
		});
	}
	if(qbddCode!=''){
		$("#qbpcs").combobox({
			url:'<%=contextPath%>/orgPublicSelect/queryComboBoxList?parentOrgCode='+qbddCode
		});
	}
	if(qbpcsCode!=''){
		$("#qbzrq").combobox({
			url:'<%=contextPath%>/orgPublicSelect/queryComboBoxList?parentOrgCode='+qbpcsCode
		});
	}
	
	if(level == '21'){//分局
		$("#qbdd").combobox('setValue',curCode);
		setInputReadonly('qbdd',true);
	} 
	if(level == '32'){//派出所，查到父级部门
		$("#qbdd").combobox('setValue',qbddCode);
		setInputReadonly('qbdd',true);
		$("#qbpcs").combobox('setValue',curCode);
		setInputReadonly('qbpcs',true);
	}
	
	if(level == "50"){//责任区，查到父级部门
		$("#qbdd").combobox('setValue',qbddCode);
		setInputReadonly('qbdd',true);
		$("#qbpcs").combobox('setValue',qbpcsCode);
		setInputReadonly('qbpcs',true);
		$("#qbzrq").combobox('setValue',curCode);
		setInputReadonly('qbzrq',true);
	}
	
};

/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:47:21
 */
datagridProcessFormater = function(val, row, index) {
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateAndXq(this, '
			+ index + ')">查看</a>&nbsp;';
};



/**
 * @title:queryButton
 * @description:精确查询【确定】
 * @author: QinXiaoYun
 */
queryButton = function(){
	var zdrygllxdm = document.getElementById("zdrygllxdm").value;
	//combotree的值
	var zdrylb = $("#zdrylbStr").combotree("getValue");
	
	var xm = document.getElementById("xm").value;
	var gmsfhm = document.getElementById("gmsfhm").value;
	var xbdm = document.getElementById("xbdm").value;
	var gjdm = document.getElementById("gjdm").value;
	var xzd = document.getElementById("xzd").value;
	var hjd = document.getElementById("hjd").value;
	
	var glzt = document.getElementById("glzt").value;
	
	//联动下拉框取值
	var qbdd = $('#qbdd').combobox("getValue"); 
	var qbpcs = $('#qbpcs').combobox("getValue");
	var qbzrq = $('#qbzrq').combobox("getValue");
	$('#dg').datagrid('load',{ 
		'zdrygllxdm':zdrygllxdm,
		'zdrylb':zdrylb,
		'xm':xm,
		'gmsfhm':gmsfhm,
		'xbdm':xbdm,
		'gjdm': gjdm,
		'xzd':xzd,
		'hjd':hjd,
		'glzt':glzt,
		'qbdd':qbdd,
		'qbpcs':qbpcs,
		'qbzrq':qbzrq
	});
	if(zdrygllxdm != null || zdrygllxdm != ""){
		document.getElementById("zdrygllxdm").value = zdrygllxdm;
	}
	//combotree设置值
	if(zdrylb != null || zdrylb != ""){
		$("#zdrylbStr").combotree("setValue",zdrylb);
	}
	if(xm != null || xm != ""){
		document.getElementById("xm").value = xm;
	}
	if(gmsfhm != null || gmsfhm != ""){
		document.getElementById("gmsfhm").value =  gmsfhm;
	}
	if(xbdm != null || xbdm != ""){
		document.getElementById("xbdm").value = xbdm;
	}
	if(gjdm != null || gjdm != ""){
		document.getElementById("gjdm").value = gjdm;
	}
	if(xzd != null || xzd != ""){
		document.getElementById("xzd").value = xzd;
	}
	if(hjd != null || hjd != ""){
		document.getElementById("hjd").value = hjd;
	}
	if(glzt != null || glzt != ""){
		document.getElementById("glzt").value = glzt;
	}
};



/**
 * @title:bmjbChange
 * @description:部门级别更改所触发的函数
 * @author: QinXiaoYun
 */
bmjbChange = function(newVal,oldVal){
	if(typeof(newVal)!="undefined"){
		setInputReadonly("zdrylbStr", true);	
		$('#zdrylbStr').combotree('tree').tree('loadData', '');		
		
		$.ajax({
			async:false,
			type:"GET",
			url:"<%= basePath%>zdryzb/queryZdryChildLbList",
			dataType:"json",
			data:"lbdm_p="+newVal,
			success:function(data){
				if (data && data.length>0) {
					setInputReadonly("zdrylbStr", false);
					$('#zdrylbStr').combotree('tree').tree('loadData', data);
				}else{		
					$('#zdrylbStr').combotree('tree').tree('loadData', '');
				}
			}
		}); 
	}
};

/**
 * @title:zdrylbChange 
 * @description:重点人员大类类型变化
 * @author: QinXiaoYun
 */
zdrylbChange = function(newVal,oldVal){

		if(typeof(newVal)!="undefined"){
			setInputReadonly("zdrylbStr", true);	
			$('#zdrylbStr').combotree('tree').tree('loadData', '');		
			
			$.ajax({
				async:false,
				type:"GET",
				url:"<%= basePath%>zdryzb/queryZdryChildLbList",
				dataType:"json",
				data:"lbdm_p="+newVal,
				success:function(data){
					if (data && data.length>0) {
						setInputReadonly("zdrylbStr", false);
						$('#zdrylbStr').combotree('tree').tree('loadData', data);
					}else{				
						$('#zdrylbStr').combotree('tree').tree('loadData', '');
					}
				}
			}); 
		}
};


/**
 * @title:resetButton 
 * @description:条件重置按钮（触发）
 * @author: QinXiaoYun
 */
resetButton = function(){
		$("#queryForm").form("reset");
		
		//获取当前登录者的所属部门的级别
		var level = '<%=userOrgLevel%>';
		//获取当前登录者的所属部门的名称
		var curName = '<%=userOrgName%>';
		//获取部门的所属部门的代码
		var curCode = '<%=userOrgCode%>'; 
		
	    var qbzdCode = '${qbzdCode}';
		var qbddCode = '${qbddCode}';
		var qbpcsCode = '${qbpcsCode}';
		
		if(level == '21'){//分局
			$("#qbdd").combobox('setValue',curCode);
			setInputReadonly('qbdd',true);
		} 
		if(level == '32'){//派出所，查到父级部门
			$("#qbdd").combobox('setValue',qbddCode);
			setInputReadonly('qbdd',true);
			$("#qbpcs").combobox('setValue',curCode);
			setInputReadonly('qbpcs',true);
		}
		
		if(level == "50"){//责任区，查到父级部门
			$("#qbdd").combobox('setValue',qbddCode);
			setInputReadonly('qbdd',true);
			$("#qbpcs").combobox('setValue',qbpcsCode);
			setInputReadonly('qbpcs',true);
			$("#qbzrq").combobox('setValue',curCode);
			setInputReadonly('qbzrq',true);
		}
	};
</script>