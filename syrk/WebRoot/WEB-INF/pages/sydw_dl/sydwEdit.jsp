<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位档案</title>
<script type="text/javascript" src="<%=contextPath%>/js/sydwinfo-mould.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>
<style>
.nameTable{ width:400px;height:auot;overflow:hidden;}
.nameTable tr{height:auto;}
.nameTable th{line-height:26px; color:#666;font-weight:normal;word-wrap:break-all;}
.nameTable td{line-height:20px; color:#333;word-wrap:break-all; }
</style>
</head>

<body class="bodybg">
<div class="head"><div class="logo"></div></div>
<div class="bodydiv">
<div class="bodyer">
<div class="lf">
<!--框-->
<div class="lf_conta">
<div class="lf_contb">
<div class="lf_contc">


								<table >
									<tr>
										<td colspan="2" align="center">
											<strong><span id="dwmc_dw">${dw.dwmc }</span><span></span>
										</strong>
										</td>
									</tr>
									<tr>
										<td>
										<div class="pinfo1">

									<ul><li style="padding:0px;">
									<table cellpadding="0" cellspacing="0" class="nameTable" >
									 <tr >
									    	        <th  align="right" width="130">单位类型：</th>
											    	    <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_DW_DWLB.js', "${dw.dwlbdm}"));</script></td>
										    	  <th  align="right" width="100">联系电话：</th>
											    	    <td width="80"> ${dw.lxdh}</td>
										    	   </tr>
										    	   	 <tr >
									    	        <th  align="right" width="130">单位地址：</th>
											    	         <c:choose>
											    	            <c:when test="${dw.dz_dwdzxz !=null}">
											    	                 <td  colspan="3" width="270">${dw.dz_dwdzxz }</td>	
											    	            </c:when>
											    	            <c:otherwise>
											    	                 <td  colspan="3" width="270">${dw.dzms_dwdzmlpxz}${dw.dzms_chdz}</td>	
											    	            </c:otherwise>
											    	         </c:choose>
											    	         
											    	         
											    	         
										    	   </tr>
										    	 <tr >
									    	        <th  align="right" >单位状态：</th>
											    	    <td ><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_DW_DWZTDM.js', "${dw.dwztdm}"));</script></td>
										    	  <th  align="right">单位编码：</th>
											    	    <td >${dw.zagldwbm}</td>
										    	   </tr>
										    	    <tr class="">
									    	        <th  align="right" >开业日期：</th>
											    	    <td >${dw.kyrq}</td>
										    	  <th  align="right"  >营业时间：</th>
											    	    <td >${dw.yysj}</td>
										    	   </tr>
										    	    <tr >
									    	        <th   align="right" width="130">经营范围（主营）：</th>
											    	    <td  colspan="3" width="270">${dw.jyfwzy }</td>
										    	   </tr>
										    	    <tr >
									    	        <th  align="right" >经营面积(平方米)：</th>
											    	    <td  >${dw.jymj_mjpfm}</td>
										    	  <th  align="right">是否重点单位：</th>
											    	    <td ><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.zddwbs}"));</script></td>
										    	   </tr>
										    	       <tr>
									    	        <th  align="right" >是否外资单位：</th>
											    	    <td  class=""><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.sfwzdwdm}"));</script></td>
										    	  <th   align="right">是否涉外单位：</th>
											    	    <td ><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_GG_SF.js', "${dw.sfswdwdm}"));</script></td>
										    	   </tr>
									</table>
									</li>
									
									
								    </ul> 														
								
								</div>
										</td>
										<td>
											<div class="pphoto_1">
												<div>
													<div id="uploadFileImageDiv" style="width: 240px; height:180px; border: 1px solid #86B6CF; text-align: center;"></div>
													<!--  <img  id="topPhotoid" width="240"
														height="180" alt="" />-->
												</div>
												<c:if test="${mode != 'view'}">
												    <a href="javascript:void(0);" info="dwid,DW_DWJBXXB,单位基本信息表"
													class="addphoto"></a>
												</c:if>
											</div>
										</td>
									</tr>
								</table>

								
	<input type="hidden" id="dwlbdm2"  value="${dw.dwlbdm}"/>
	<input type="hidden" id="formPara" value='"dwmc":"${dw.dwmc}"' /><!-- 表单提交附加参数 json-->
	<input type="hidden" id="serverPara" value="dwid=${dw.id }&dwmc=${dw.dwmc}" /><!-- 业务办理附加参数-->
	<input type="hidden" id="queryPara" value="dwid=${dw.id }" /><!-- 表单查询附加参数 -->
	<input type="hidden" id="mode_"	 value="${mode }" />
<div class="clear"></div>
<div class="editdiv"><a href="javascript:void(0);" class="savebtn">档案编辑完成</a><a href="javascript:void(0);" class="editbtn" style="display:none">编辑档案信息</a></div>

</div>
</div>
</div>
<!--/框-->

<!--基础信息-->
<div class="lf_conta cont_edit">
<div class="lf_contb">
<div class="lf_contc">
<dl class="infodl">
<dt><div class="dllf info_jbxx">基本信息补充</div><a class="up_btn down_btn" href="javascript:void(0);"></a><a class="info_editbtn" href="javascript:void(0);">编辑</a><a class="info_savebtn" href="javascript:void(0);">保存</a></dt>
<dd class="infoshow">
    <ul>
    <li><span class="spantitle">上级单位：</span><span  name="sjdwmc" class="edit_word input_w1">${dw.sjdwmc}</span></li> 
  	<li><span class="spantitle">单位别名：</span><span  name="dwbm" class="edit_word input_w1">${dw.dwbm}</span></li> 
  	<li><span class="spantitle">单位英文名称：</span><span  name="dwbm" class="edit_word input_w2">${dw.dwywmc}</span></li> 
  	<li><span class="spantitle">单位英文缩写：</span><span name="yyzzh" class="edit_word input_w2">${dw.dwywsx}</span></li> 
  	<li><span class="spantitle">单位类型：</span><span dict="/common/dict/D_DW_DWLB" name="dwlbdm" class="edit_word input_w2">${dw.dwlbdm}</span></li> 
  	
  	<li><span class="spantitle">是否办理营业执照：</span><span name="sfblyyzzdm" dict="/common/dict/D_GG_SF" class="edit_word input_w2">${dw.sfblyyzzdm}</span></li> 
  	<li><span class="spantitle">营业执照号：</span><span name="yyzzh" class="edit_word input_w2">${dw.yyzzh}</span></li> 
  	<li><span class="spantitle">执照起始日期：</span><span name="yyzzyxq_qsrq" class="edit_word input_w2">${dw.yyzzyxq_qsrq}</span></li> 
	<li><span class="spantitle">执照截止日期：</span><span name="yyzzyxq_jzrq" class="edit_word input_w2">${dw.yyzzyxq_jzrq}</span></li> 
	<li><span class="spantitle">执照发证机关：</span><span name="yyzzfzjg" class="edit_word input_w2">${dw.yyzzfzjg}</span></li>
	<li><span class="spantitle">执照发证机关ID：</span><span name="yyzzfzjgid" class="edit_word input_w2">${dw.yyzzfzjgid}</span></li>
  	<li><span class="spantitle">组织机构证号：</span><span name="zzjgdm" class="edit_word input_w2">${dw.zzjgdm}</span></li> 
	<li><span class="spantitle">税务登记证号：</span><span name="swdjhm" class="edit_word input_w2">${dw.swdjhm}</span></li> 
  	<li><span class="spantitle">注册资金(万元)：</span><span name="zczb" class="edit_word input_w2">${dw.zczb}</span></li> 
  	<li><span class="spantitle">传真：</span><span name="czhm" class="edit_word input_w2">${dw.czhm}</span></li> 
  	<li><span class="spantitle">经营范围（兼营）：</span><span  name="jyfwjy" class="edit_word input_w1">${dw.jyfwjy}</span></li> 
  	<li><span class="spantitle">经营方式：</span><span name="jyfsdm" dict="/common/dict/D_DW_JYFSDM" class="edit_word input_w2">${dw.jyfsdm}</span></li> 
  	<li><span class="spantitle">经营类型：</span><span name="jjlxdm" dict="/common/dict/D_BZ_JYXZDM" class="edit_word input_w2">${dw.jjlxdm}</span></li> 
  	<li><span class="spantitle">停业日期：</span><span name="tyrq01" class="edit_word input_w2">${dw.tyrq01}</span></li> 
  	<li><span class="spantitle">是否有房屋鉴定：</span><span name="sfyfwjddm" dict="/common/dict/D_GG_SF" class="edit_word input_w2">${dw.sfyfwjddm}</span></li> 
  	<li><span class="spantitle">是否有消防鉴定：</span><span name="sfyxfjddm" dict="/common/dict/D_GG_SF" class="edit_word input_w2">${dw.sfyxfjddm}</span></li> 
	<li><span class="spantitle">鉴定时间：</span><span name="jdsj" class="edit_word input_w2">${dw.jdsj}</span></li> 
	<li><span class="spantitle">核定容纳人数：</span><span name="hdrnrs" class="edit_word input_w2">${dw.hdrnrs}</span></li> 
	<li><span class="spantitle">周期性营业：</span><span name="sfzqxyydm" dict="/common/dict/D_GG_SF" class="edit_word input_w2">${dw.sfzqxyydm}</span></li> 
	<li><span class="spantitle">周期性规律：</span><span name="zqxyygl" class="edit_word input_w1">${dw.zqxyygl}</span></li> 
	<li><span class="spantitle">网址：</span><span name="wz" class="edit_word input_w1">${dw.wz}</span></li>
	<li><span class="spantitle">备注：</span><span name="bz" class="edit_word input_w1">${dw.bz}</span></li>
    <input type="hidden" name="id" id="dwid" value="${dw.id }" /><input type='hidden' name='openUrl' value='/dwjbxxb_dl/create' />
    </ul>
<div class="clear"></div>
</dd>
</dl>
</div>
</div>
</div>
<!--/基础信息-->



<div class="lf_conta cont_edit">
<div class="lf_contb">
<div class="lf_contc">
<dl class="infodl">
<dt><div class="dllf">从业人员</div><a class="up_btn down_btn" href="javascript:void(0);"></a></dt>
<dd style="height:310px;">
	<div style="height:290px;width:718px;">
    <table id="cyry_datagrid" class="easyui-datagrid"   data-options="url:'<%=contextPath%>/sydwgl_dl/cyryxxb_query_new?dwid=${dw.id}',pagination:false,fitColumns:true,singleSelect:true,
    toolbar:'#cyry_datagrid_toolbar'" border="0" style="height:200px;">
    	<thead>   
	        <tr>
        		<th data-options="field:'xm',width:60,align:'center',fixed:true">姓名</th>
	        	<th data-options="field:'zjhm',width:120,align:'center',fixed:true">身份证号码</th>
	        	<th data-options="field:'xbdm',width:40,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
	            <th data-options="field:'csrq',width:70,align:'center',fixed:true">出生日期</th>
	            <th data-options="field:'pyrq',width:70,align:'center',fixed:true">入职时间</th>   
	            <th data-options="field:'dz_xzzxz',width:230,align:'center'">居住地址</th>
	            <th data-options="field:'dz_xzzdm',hidden:true"></th>
	            <th data-options="field:'process',width:150,align:'center',fixed:true,formatter:datagridProcessFormater">操作</th>   
	        </tr>   
	    </thead>   
    </table>
    <div id="cyry_datagrid_toolbar" style="padding:2px;height:40px">
		<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
			<tr>
				<td align="right">
					<a id="addCyryBtn" href="javascript:void(0)" class="easyui-linkbutton" style="display:none"  iconCls="icon-add"  onclick="add_cyryxxb();">新增</a>
					<!-- <a id="importCyryBtn" href="javascript:void(0)" class="easyui-linkbutton" style="display:none"  iconCls=""  onclick="import_cyryxxb();">导入</a> -->
					<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls=""  onclick="export_cyryxxb();">导出</a>
				</td>
			</tr>
		</table>
	</div>
    </div>
    <div style="height:20px;">
    	<table border="0" cellpadding="0" cellspacing="5" width="100%"	align="center">
    		<tr>
    			<td align="right">
    				<a href="javascript:void(0)" style="height:25px;matop:5px" onclick="show_more_cyry();">更多...</a>
    			</td>
    		</tr>
    	</table>
    </div>
</dd>
</dl>
</div>
</div>
</div>



</div>
<div class="rt" style="display:none">
<!--右侧框-->
<div class="rt_conta">
<div class="rt_contb">
<div class="rt_contc">

<div class="rt_server">
<div class="rttitle" id="server_Menu">业务办理</div>
<ul class="rtul" id="serverMenu"> 
</ul>
<c:if test="${jqdtjl!=null && fn:length(jqdtjl)!=0 }">
<div class="rttitle" >近期动态</div>
<div class="rtshow"><div class="timelinebody">
<div class="timeliall">
<c:forEach var="dwjqdtjlb" items="${jqdtjl}">
	<div class="timelicont">
		<div class="timelidiv">
			<a class="timetitle">${dwjqdtjlb.jlsm}</a>
			<div class="jqsjmsinfo" style="display: none;">
				<div>
					<span></span>
				</div>
			</div>
			<div class="timedate">
				<span>${dwjqdtjlb.jlsj}</span>
			</div>
			<div class="timeicon"></div>
			<div class="timesjx"></div>
		</div>
	</div>
</c:forEach>
</div></div><div class="clear"></div></div>
</c:if>


</div>
<div class="rt_view">
<div class="rttitle" >可增加信息</div>
<ul class="rtul" id="serverAddInfo">
</ul>
</div>

</div>
</div>
</div>
<!--/右侧框-->
</div>
<div class="clear"></div>
</div>
</div>
</body>
<script type="text/javascript">
var pcsdm = "${pcsdm}";
var pcsmc = "${pcsmc}";
var fsxdm = "${fsxdm}";
var fsxmc = "${fsxmc}";
var dsjdm = "${dsjdm}";
var dsjmc = "${dsjmc}";

var infoPara = {
		mainUrl:"/sydwgl_dl/queryDwzsxx",
		mainPara:"sydwlx="+$("#dwlbdm2").val(),
		
		queryUrl:"/sydwgl_dl/service/",
		queryPara:$("#queryPara").val(), //dwid 单位ID
		
		serverMenuUrl:"/sydwgl_dl/queryYwglgn",
		serverMenuPara:"sydwlx="+$("#dwlbdm2").val(), //实有单位类型
		
		zpUrl:"/zpfjPtryzp/queryZpById.jpg",
		
		editPara:"dwid="+$("#dwid").val(), //编辑参数
		editIframePara:'{'+$("#formPara").val()+'}', 
		
		serverPara:$("#serverPara").val(),  //业务办理参数        id 单位ID， dwmc 单位名称
		serverIframePara:'{'+$("#formPara").val()+'}',
		
		add_childInfo_para: $("#serverPara").val(),
		add_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		
		edit_childInfo_para:$("#serverPara").val(),
		edit_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		
		del_childInfo:"/sydwgl_dl/delete_xxzsnrb"
	};
$(document).ready(function(){
	
	var mode_ = $("#mode_").val();
 	if(mode_=="view"){
 		$("#server_Menu").hide();
 		$("a.info_editbtn").remove();
	}else{
 		$("a.editbtn").show();
		$("a.savebtn").click(save_view).click(toggleCyryBtn);
		$("a.info_editbtn").click(editEnable);
		$("a.editbtn").click(edit_view).click(toggleCyryBtn);
		getServerMenu(1);
		getServerMenu(2);
	}
	
	/***************固定事件注册，页面初始化**************************/
	
	$("a.up_btn").click(up_down);
	sylbIcon();
	$(".addphoto").click(addFile);
	iterateDict($("div.lf_conta").eq(1));
		

	$(".rt").show();
	$(".rt_view").hide();
		
	/**********自己定义方法*************************/
	//loadActivityTrace();
	//loadRelationMessage();
	var dwid = $("#dwid").val();
	//document.getElementById("topPhotoid").src = contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id=${dw.id }";
	uploadFileImageView('DW_DWJBXXB', dwid, 'uploadFileImageDiv', 240, 180, contextPath + '/common/skin/images/empty_ryzp.jpg');
});

function toggleCyryBtn(){
	$('#addCyryBtn').toggle();
	$('#importCyryBtn').toggle();
}

function show_more_cyry(){
	var url = contextPath + '/sydwgl_dl/cyryxxb_query_more?dwid=${dw.id}&mode='+$("#mode_").val();
	openWindow(false, 'show_more_cyry_win', url, {"_p":$("#cyry_datagrid")}, {title:'从业人员详细列表', modal:true, width:720, height:600});
	
}

function import_cyryxxb(){
	var url = contextPath + '/cyrydrrwxxb_dl/createPage?dwid=${dw.id}';
	openWindow(false, 'cyry_import_win', url, null, {title:'导入任务列表', width:720, height:600});
	
	
}

function export_cyryxxb(){
	location.href=contextPath+'/sydwgl_dl/cyryxxb_export?dwid=${dw.id}';
}

function add_cyryxxb(){
	openWindowWithSaveNext(false, null, window, 
   		{"_p":$("#cyry_datagrid")}, 
   		{
   		title: '从业人员新增',
   		url: '<%=contextPath%>/cyryxxb_dl/createPage?dwid=${dw.id}',
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

function afterSubmitSuccess(){
	$('#cyry_datagrid').datagrid('reload');
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">修改</a>&nbsp;'+
		   	'<a class="link" href="javascript:javascript:void(0)" onclick="doCancel(this,'+index+')">注销</a>';
}

//查看单条
function doView(linkObject, index) {
	var rows = $('#cyry_datagrid').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = '<%=contextPath%>/cyryxxb_dl/view?id='+rowData.ryid+'&jzdzdm='+rowData.dz_xzzdm+'&zdryid='+'&jzdzzbid='+rowData.ryid;
	//menu_open("实有人口－" + rowData.xm,editUrl);
	$.ajax({
		url:'<%=contextPath%>/cyryxxb_dl/checkIfIsSyrk?id='+rowData.ryid,
		dataType:'json',
		success:function(data){
			if(!data){
				$.messager.alert('提示','非实有人口无法进行查看','info');
			}else{
				openWindow(false, 'cyryView_', editUrl, null, {
			   		title: '从业人员',
			   		width: 880,
			   		inline:true,
			   		height:500
			   		});
			}
		}
	});
}

//编辑【从业人员】
function doEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '修改 从业人员',
   		url: '<%=contextPath%>/cyryxxb_dl/createPage?dwid=${dw.id}&id='+$('#cyry_datagrid').datagrid('getData').rows[index].id,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//注销【从业人员】
function doCancel(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/cyryxxb_dl/delete';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:$('#cyry_datagrid').datagrid('getData').rows[index].id}
			}).done(function(result) {
				$('#cyry_datagrid').datagrid('reload');
			});
		}
	});
}

function closeUploadIframe(){
	$("cyry_import_win").dialog('close');
}

function refreshPhoto(){
	location.reload();
}
</script>
</html>
    