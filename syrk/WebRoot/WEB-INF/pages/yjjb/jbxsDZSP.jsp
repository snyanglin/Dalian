<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审批处理</title>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
		<table height="100%" style="margin:0 auto;">
			<tr>
				<td height="100%" valign="top" align="center">
					<div class="pop_conta">
						<div class="pop_contb">
							<div class="pop_contc">
								<form action="<%=basePath%>xsdzspb/choose" id="xsdzspbForm" name="xsdzspbForm" method="post" >
									<div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
										<input type='hidden' name='xsbh' id="xsbh" value="${entity.id}"/> 
										<input type='hidden' id="sqbh" name="sqbh" value="${sqbh}"/> 
										<input type='hidden' id="id" name="id" value="${spbh}"/> 
										<input type='hidden' id="btnType" name="btnType"/>
										<!-- 坐标x，y和三个组织机构的代码 -->
										<input type='hidden' id="entity_zbx" name="entity_zbx"/> 
										<input type='hidden' id="entity_zby" name="entity_zby"/> 
										<!-- 点击保存标注后才将内容保存到entity_zbx和entity_zby -->
								    	<input type='hidden' id="entity_zbxYs" name="xsdzzbxYs"/> 
								    	<input type='hidden' id="entity_zbyYs" name="xsdzzbyYs"/> 
										<input type='hidden' id="slfzdm" name="slfzdm"/> 
										<input type='hidden' id="slzdm" name="slzdm"/> 
										<input type='hidden' id="slzxdm" name="slzxdm"/> 
										<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
								   
									    	<tr class="dialogTr">
												<td width="20%" class="dialogTd" align="right">线索类型：</td>
												<td width="30%" class="dialogTd">
													<input class="easyui-combobox" id="xslx" name="xslx" readonly="readonly" value="${entity.xslx}" 
											  		style="width:300px" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XSLX.js',
											  		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
												</td> 
												<td width="20%" class="dialogTd" align="right">举报信息性质：</td>
									  			<td width="30%" class="dialogTd">
											  		<input class="easyui-combobox" type="text" id="jbxxxz" name="jbxxxz" readonly="readonly" value="${entity.jbxxxz}"
												 			maxlength="20" style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLB.js',
											  		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
										        </td>
									      	</tr> 
									 		<tr class="dialogTr">
												<td width="20%" class="dialogTd" align="right">线索发现地址：</td>
												<td width="50%" class="dialogTd" colspan="2">
													<input class="easyui-combobox" id="jzd1" style="width:300px;" value="${entity.xsdzmlpxz}" readonly="readonly" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
													<input type='hidden' name='xsdzmlpdm' id="xsdzmlpdm" value="${entity.xsdzmlpdm}"/>
													<input type='hidden' name='xsdzmlpxz' id="xsdzmlpxz" value="${entity.xsdzmlpxz}"/>
												</td>
												<td width="30%" class="dialogTd" >
													<input class="easyui-combobox" id="jzd2" style="width:300px;" value='${fn:replace(entity.xsdzxz, entity.xsdzmlpxz, "")}' readonly="readonly" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
													<input type="hidden" name="xsdzdm" id="xsdzdm" value="${entity.xsdzdm}"/>
													<input type="hidden" name="xsdzssxdm" id="xsdzssxdm" value="${entity.xsdzssxdm}"/>
													<input type='hidden' name='xsdzxz' id="xsdzxz" value="${entity.xsdzxz}"/>
												</td>
									      	</tr>
											<tr class="dialogTr">
												<td width="20%" class="dialogTd" align="right">线索地址描述：</td>
											 	<td width="80%" class="dialogTd" colspan="3" >
											 		${entity.xsdzms}
												</td>
										    </tr>
										    <tr class="dialogTr">
											  	<td width="20%" class="dialogTd" align="right">举报内容：</td>
											  	<td width="80%" class="dialogTd" colspan="3" >
												  	${entity.jbnr}
												</td>
										    </tr> 
								    	    <!-- 递转信息 -->
									    	<tr class="dialogTr">
												<td width="20%" class="dialogTd" align="right">申请递转至：</td>
												<td width="30%" class="dialogTd">
													<input class="easyui-validatebox" id="pcs" name="pcs" readonly="readonly" value="${pcs}" 
											  		style="width:300px" data-options="required:true"/>
												</td> 
									      	</tr>
								    	  <!-- 递转地址 -->
							    	      <tr class="dialogTr" id="dzdz" >
						    				<td width="" class="dialogTd" align="right">递转地址：</td>
											<td width="" class="dialogTd" colspan="2">
											  <input class="easyui-combobox" id="jzd3" style="width:450px;" value="${entity.sldzmlpxz}" 
											  data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',
											  selectOnNavigation:false">
										      <input type='hidden' name='sldzmlpdmCC' id="sldzmlpdm" value="${entity.sldzmlpdm}"/>
										      <input type='hidden' name='sldzmlpxzCC' id="sldzmlpxz" value="${entity.sldzmlpxz}"/>
											</td>
											<td width="" class="dialogTd" >
												<input class="easyui-combobox" id="jzd4" style="width:300px;" value='${fn:replace(entity.sldzxz, entity.sldzmlpxz, "")}'
													   data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',
													   selectOnNavigation:false">
												<input type="hidden" name="sldzdmCC" id="sldzdm" value="${entity.sldzdm}"/>
												<input type="hidden" name="sldzssxdmCC" id="sldzssxdm" value="${entity.sldzssxdm}"/>
											    <input type='hidden' name='sldzxzCC' id="sldzxz" value="${entity.sldzxz}"/>
											</td>
							    	    </tr>
							    	    <tr class="dialogTr" id="mapZRQ">
							    	      	<td width="" class="dialogTd" align="right" valign="top">派出所：</td>
								    	    <td width="" class="dialogTd" align="right" colspan="3">
								    	    	<div title="地图信息" style="height:500px;" >  
												<iframe width="100%" height="100%" id="mapIframe" name ="mapIframe" 
														src="<%=basePath%>/forward/map|mapZrq?zbx=${entity.sldzzbx}&zby=${entity.sldzzby}">
												</iframe>
												</div>
											</td>
							    	    </tr>
										    <tr class="dialogTr">
												<td width="20%" class="dialogTd" align="right">审批意见：</td>
											 	<td width="80%" class="dialogTd" colspan="3" >
											 		<textarea id="sphf" name="sphf" class="easyui-validatebox" style="width: 820px; height:48px;"
													data-options="validType:['maxLength[1000]'],invalidMessage:'线索地址描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" ></textarea>
												</td>
											</tr>     
										</table>
									</div>
								</form>
							</div>
				 		</div>
					</div>
					<div style="height:6px;font-size:1px;"></div>
					<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
						<a id="doIt"  class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">同意递转&nbsp&nbsp&nbsp&nbsp</span>
							</span>
						</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="upDoIt" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">拒绝递转&nbsp&nbsp&nbsp&nbsp</span>
							</span>
						</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">关闭</span>
								<span class="l-btn-icon icon-back"> </span>
							</span>
						</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript">

function doInit(paramArray) {

	setReadOnly();
}

function setReadOnly(){

}

function check(){
	clearValue();
	var sfzh = $("#jbrsfzh").val(); 
	if(!$("#jbrsfzh").validatebox("isValid")){
		return;
	}
	$(".lodingimg").show();
	
	$.ajax({
		type:"POST",
		url:"http://10.80.1.246/car/tinfo",
		dataType:"json",
		data:{id:$("#jbrsfzh").val()},
		success:function(data){
			if (data) {
				$("#jbrxm").val(data.JBRXM);
				$("#jbrsr").val(data.JBRSR);
				$("#jbrxb").combobox('setValue',data.JBRXB);
				$("#jbrdwdm").combobox('setValue',data.JBRDWDM);
				$("#jbrdw").val(data.JBRDW);
				$("#jbrmobile").val(data.JBRLXFS);
				$("#czzcp").val(data.CZZCP);
				$("#cyzgz").val(data.CYZGZ);
				$("#jbrxjzdz").val(data.JBRXJZDZ);
				$("#hjdz").val(data.HJDZ);
				$("#jbrxm,#jbrmobile,#czzcp,#cyzgz,#jbrxjzdz,#hjdz").validatebox("validate");
			}
		},
		complete:function(){
			_zjhm = $("#jbrsfzh").val();
			$('#dataForm').form('validate');
			$(".lodingimg").hide();
		}
	});
}
function clearValue(){

	$("#jbrxm").val('');
	$("#jbrsr").val('');
	$("#jbrxb").combobox('setValue','');
	$("#jbrdwdm").combobox('setValue','');
	$("#jbrdw").val('');
	$("#jbrmobile").val('');
	$("#czzcp").val('');
	$("#cyzgz").val('');
	$("#jbrxjzdz").val('');
	$("#hjdz").val('');
}
$(function(){
	//地址查询
	initAddressSearch('jzd1', {}, 'xsdzmlpdm', 'xsdzmlpxz', 'jzd2', {text:'xsdzxz',dzxzqh:'xsdzssxdm',id:'xsdzdm'}, null, null);
	initAddressSearch('jzd3', {}, 'sldzmlpdm', 'sldzmlpxz', 'jzd4', {text:'sldzxz',dzxzqh:'sldzssxdm',id:'sldzdm'}, null, null);
	//map标注
	//$('#mapBotton').click(function(){  biaozhu();});
	$('#xsdzspbForm').form({

				onSubmit : function() {

					return $(this).form('validate');
				},
				success : function(data) {
					var json = $.parseJSON(data);
					if (json.status != 'success') {

						topMessagerAlert(null, json.message);
					} else {

						$("#id").val(json.saveID);
						executeTabPageMethod(mainTabID, "reloadDg");
						topMessagerAlert(null, "保存成功","success");
						closeSelf();
					}
				}
			});
	//同意递转
	$('#doIt').click(function(){
	
		topMessager.confirm('操作确认', '您是否确认同意递转？',  function(r) {
		
			if (r) {
				$("#btnType").val("1");
				$('#xsdzspbForm').submit();
			}
		});
	});

	//拒绝递转
	$('#upDoIt').click(function(){
	
		topMessager.confirm('操作确认', '您是否确认拒绝递转？',  function(r) {
			
			if (r) {
				$("#btnType").val("2");
				$('#xsdzspbForm').submit();
			}
		});
	});
	
	//关闭当前页面
	$('#backButton').click(function(){
		closeSelf();
	});
	
	if(${theHighest} == '0'){
		$('#upDoIt').show();
	}else if(${theHighest} == '1'){
		$('#upDoIt').hide();
	}

	
}); 

//	function biaozhu(){
//		var point = {
//			x:'${entity.xsdzzbx}',
//			y:'${entity.xsdzzby}'
//		}
//		var url = contextPath+'/forward/map|mapZrq?zbx='+point.x+'&zby='+point.y;
//		var paramArray = [];
//		openWindow(false, null, url, 
//	   		paramArray, 
//	   		{
//		   		title:'地图标注（鼠标点击左键标注位置，右键退出标注模式）',
//		   		maximizable: false,
//		   		width: 850,	
//		   		height: 400
//	   		}
//	   	);
//	}

	function addLxfs() {
		
		var tr1 = $('<tr id="lxfs1Tr'+ JrdwCount +'"><td height="10"></td></tr>');
		var tr2 = $('<tr id="lxfs2Tr'+ JrdwCount +'" height="24"></tr>');
		
		var td2 = $('<td width="20%"  class="dialogTd" align="right">联系方式：</td>');
		
		var td1 = $('<td width="30%" id="lxfsTd'+ JrdwCount +'" class="dialogTd"></td>');
		var td1HTML = new StringBuffer();
		td1HTML.append('&nbsp;<input class="easyui-combobox" name="JrdwArray['+JrdwCount+'].zzyhlbdm" id="lxfs1_'+ JrdwCount +'"  type="text"   style="width:200px;float:left;" data-options="required:true,url: contextPath + \'/common/dict/D_DW_ZZYHLB.js\',valueField:\'id\',textField:\'text\',selectOnNavigation:false,method:\'get\',tipPosition:\'right\'"/>');
		td1HTML.append('&nbsp;&nbsp;');
		
		td1.html(td1HTML.toString());
		
		tr2.append(td2);
		tr2.append(td1);

		
		$('#lxfsArray').append(tr1);
		$('#lxfsArray').append(tr2);
		
		$.parser.parse('#lxfsTd' + JrdwCount);
		JrdwCount++;
	}

	function delLxfs(dzNo) {
		setInputReadonly('lxfs' + dzNo, true);
		$("#xt_zxbz" + dzNo).val("1");
		$("#lxfs1Tr" + dzNo).hide();
		$("#lxfs2Tr" + dzNo).hide();
	}
	
	function czcChange(){
		
		var dwmc = $("#jbrdwdm").combobox('getText');
		if(dwmc){
			alert(dwmc);
			$("#jbrdw").val(dwmc);
		}
	}
</script>
</body>
</html>