<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>举报奖励申请</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
<body  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;">
    	<tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>jbjlxxb/approval" id="jlxxForm" name="jlxxForm" method="post" >
	    	  <div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
	    	  <input class="easyui-validatebox" type="hidden" id="id" name="id" value="${id}"/>
	    	   <input class="easyui-validatebox" type="hidden" id="xsbh" name="xsbh" value="${entity.id}"/>
	    	    <input class="easyui-validatebox" type="hidden" id="ajbh" name="ajbh" value="${ajxxb.ajbh}"/>
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	      <tr class="dialogTr">
				    	<td width="100" class="dialogTd" align="right">线索编号：</td>
				    	<td width="300" class="dialogTd">
				    	   <div style="float:left"> <a class="link" href="javascript:javascript:void(0)" onclick="viewXs()">${entity.id}</a></div>
				    		<div class="lodingimg" id="yrjbxxDiv"></div>
						</td> 
						<td width="250"  class="dialogTd" align="right">案件编号：</td>
				    	<td width="300" class="dialogTd">
				    	<a class="link" href="javascript:javascript:void(0)" onclick="viewCase()">${ajxxb.ajbh}</a>
		    	        </td>
	    	      </tr> 
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">身份证号：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" id="jbrsfzh" name="jbrsfzh" readOnly="readOnly" value="${entity.jbrsfzh}" 
				    		style="width:300px;" />
				    		<div class="lodingimg" id="yrjbxxDiv"></div>
						</td> 
						<td  class="dialogTd" align="right">姓名：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrxm" name="jbrxm" readOnly="readOnly" value="${entity.jbrxm}"
		    	 			maxlength="30" style="width:300px;" />
		    	        </td>
	    	      </tr> 
   	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">性别：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox " id="jbrxb" name="jbrxb" readOnly="readOnly" value="${entity.jbrxb}" 
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td  class="dialogTd" align="right">出生日期：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrsr" name="jbrsr" readOnly="readOnly" value="${entity.jbrsr}"
		    	 			maxlength="10" style="width:300px;" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'"
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"  />
		    	        </td>
	    	      </tr> 
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">单位：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="jbrdwdm" name="jbrdwdm" readOnly="readOnly" value="${entity.jbrdwdm}" 
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/tcdic',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:czcChange"/>
						</td>
						<input type='hidden' name='jbrdw' id="jbrdw" value="${entity.jbrdw}"/> 
						<td  class="dialogTd" align="right">手机号码：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrmobile" name="jbrmobile" readOnly="readOnly" value="${entity.jbrmobile}"
		    	 			maxlength="1000" style="width:300px;"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
	    	      		<td  class="dialogTd" align="right">联系方式：</td>
	    	      		<td  class="dialogTd"  colspan="3">
				    		<input class="easyui-validatebox" type="text" id="jbrlxfs" name="jbrlxfs" value="${entity.jbrlxfs}" 
		    	 			maxlength="1000" style="width:870px;"/>
		    	 			</td>
			      </tr>
	    	      <!-- 
	    	      	<c:forEach var="item" items="${listlxfs}" varStatus="i">
		    	       	<tr class="dialogTr">
		    	      		<td  class="dialogTd" align="right">联系方式：</td>
					    	<td  class="dialogTd"  colspan="3">
					    		<input class="easyui-validatebox" type="text"  readOnly="readOnly" name="jbrlxfsList" value="${item}" 
			    	 			maxlength="1000" style="width:845px;" data-options="required:false,validType:['maxLength[1000]'],tipPosition:'right'"/>
			    	        </td>
		    	      	</tr>
	    	       </c:forEach>
	    	        -->
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">出租车车牌：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" id="czzcp" name="czzcp" readOnly="readOnly" value="${entity.czzcp}" 
				    		style="width:300px;"/>
						</td> 
						<td  class="dialogTd" align="right">从业资格证：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="cyzgz" name="cyzgz" readOnly="readOnly" value="${entity.cyzgz}"
		    	 			maxlength="20" style="width:300px;"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
						<td  class="dialogTd" align="right">居住地址：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="jbrxjzdz" name="jbrxjzdz" readOnly="readOnly" value="${entity.jbrxjzdz}"
		    	 			maxlength="100" style="width:300px;"/>
		    	        </td>
		    	        <td  class="dialogTd" align="right">户籍地址：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-validatebox" id="hjdz" name="hjdz" readOnly="readOnly" value="${entity.hjdz}" 
				    		style="width:300px;" />
						</td> 
	    	      </tr>	   
	    	      <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">线索类型：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" id="xslx" name="xslx" readOnly="readOnly" value="${entity.xslx}" 
				    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XSLX.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td> 
						<td  class="dialogTd" align="right">举报信息性质：</td>
				    	<td  class="dialogTd">
				    		<input class="easyui-combobox" type="text" id="jbxxxz" name="jbxxxz" readOnly="readOnly" value="${entity.jbxxxz}"
		    	 			maxlength="20" style="width:300px;" data-options="url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
		    	        </td>
	    	      	</tr> 
					<tr class="dialogTr">

    					<td  class="dialogTd" align="right">线索发现地址：</td>
					 	<td  class="dialogTd" colspan="2">
						  	<input class="easyui-combobox" id="jzd1" style="width:560px;" readOnly="readOnly" value="${entity.xsdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type='hidden' name='xsdzmlpdm' id="xsdzmlpdm" value="${entity.xsdzmlpdm}"/>
						    	<input type='hidden' name='xsdzmlpxz' id="xsdzmlpxz" value="${entity.xsdzmlpxz}"/>
						</td>
						<td  class="dialogTd" >
							<input class="easyui-combobox" id="jzd2" style="width:300px;" readOnly="readOnly" value='${fn:replace(entity.xsdzxz, entity.xsdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
							<input type="hidden" name="xsdzdm" id="xsdzdm" value="${entity.xsdzdm}"/>
							<input type="hidden" name="xsdzssxdm" id="xsdzssxdm" value="${entity.xsdzssxdm}"/>
						    <input type='hidden' name='xsdzxz' id="xsdzxz" value="${entity.xsdzxz}"/>
						</td>
	    	    	</tr>
		    	    <tr class="dialogTr">
						<td  class="dialogTd" align="right" valign="top">线索地址描述：</td>
				    	<td  class="dialogTd" colspan="3" >
				    		<textarea id="xsdzms" name="xsdzms" readOnly="readOnly" class="easyui-validatebox" style="width: 870px; height:48px;"
							data-options="tipPosition:'left'" >${entity.xsdzms}</textarea>
						</td>
		    	    </tr>
		    	    <tr class="dialogTr">
		    	    	<td id="tdAjztFir"  class="dialogTd" align="right">协助方式：</td>
						<td id="tdAjztSec"  class="dialogTd">
				    		<label id="rdo0"><input type="radio" name="xzfs" checked="true" value="0" id="radio0"/>提供线索</label>
							<label id="rdo1"><input type="radio" name="xzfs" value="1" id="radio1"/>抓获现行</label>
							<label id="rdo2"><input type="radio" name="xzfs" value="2" id="radio2"/>抓获逃犯</label>
							<label id="rdo3"><input type="radio" name="xzfs" value="3" id="radio3"/>其它</label>
						</td>
					</tr>
					<tr class="dialogTr">
				    	<td  class="dialogTd" align="right" valign="top">简要内容：</td>
				    	<td  class="dialogTd" colspan="3" >
				    		<textarea id="bz" name="bz" class="easyui-validatebox" style="width:870px; height:48px;"
				    		onblur="bzOnblur();" onfocus="bzOnFocus();"
							data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entityJB.bz}</textarea>
						</td>
		    	    </tr> 
		    	    <tr class="dialogTr">
						<td  class="dialogTd" align="right">办案单位：</td>
					  	<td  class="dialogTd">
					  		<input class="easyui-validatebox" type="text" id="lrrbm" name="lrrbm" readOnly="readOnly" value="${ajxxb.xt_lrrbm}"
						 			maxlength="100" style="width:300px;"/>
						</td>
						<td  class="dialogTd" align="right">办案民警：</td>
					  	<td  class="dialogTd">
					  		<input class="easyui-validatebox" id="lrrxm" name="lrrxm" readOnly="readOnly" value="${entityAj.xt_lrrxm}" style="width:300px;"/>
						</td> 
			        </tr>
			        <!--    		
		    	    <tr class="dialogTr">
				    	<td  class="dialogTd" align="right">查证处理结果：</td>
				    	<td  class="dialogTd" colspan="3" >
				    		<textarea id="bz" name="bz" class="easyui-validatebox" style="width:790px; height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entityJL.bz}</textarea>
						</td>
		    	    </tr> 
		    	     -->	
	    		</table>
		    </div>
		  </form>
		</div>
	    </div>
	    </div>
		<div style="height:6px;font-size:1px;"></div>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			<a id="summitApproval"  class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">提交申请&nbsp;&nbsp;</span>
				</span>
			</a>
		</div>
</td>
</tr>
</table>
</div>
<script type="text/javascript" src="<%=contextPath%>/js/jwzhold.js"></script>
<script type="text/javascript">

var message = "重点说明出租车从业人员在案件中起到的主要作用...";
function doInit(paramArray) {

	setReadOnly();
}

function setReadOnly(){
	setInputReadonly('jbrsfzh', true);
	setInputReadonly('jbrxm', true);
	setInputReadonly('jbrxb', true);
	setInputReadonly('jbrsr', true);
	$('#jbrsr').removeAttr("onclick");
	setInputReadonly('jbrdwdm', true);
	setInputReadonly('jbrmobile', true);
	setInputReadonly('jbrlxfs', true);
	setInputReadonly('czzcp', true);
	setInputReadonly('cyzgz', true);
	setInputReadonly('hjdz', true);
	setInputReadonly('jbrxjzdz', true);
	setInputReadonly('xslx', true);
	setInputReadonly('jbxxxz', true);
	setInputReadonly('jzd1', true);
	setInputReadonly('jzd2', true);
	setInputReadonly('xsdzms', true);
	setInputReadonly('lrrbm', true);
	setInputReadonly('lrrxm', true);
}

function check(){
	
	var sfzh = $("#jbrsfzh").val(); 
	if(!$("#jbrsfzh").validatebox("isValid")){
		return;
	}
	var msg = '';
	var rtn = true;
	$.ajax({
		type:"POST",
		url:contextPath+"/common/tinfo",
		dataType:"json",
		async:false,
		data:{id:$("#jbrsfzh").val()},
		success:function(data){
			if (data) {
				
				// 举报人姓名
				if((data.JBRXM ==null && $("#jbrxm").val() !='')
				|| (data.JBRXM !=null && $("#jbrxm").val() =='')
				|| (data.JBRXM !=null && $("#jbrxm").val() !='' && $("#jbrxm").val() != data.JBRXM)){
					
					msg += "<div style='float:left;width:130px;'>【举报人姓名】</div>";
				}
				
				// 举报人性别
				if((data.JBRXB ==null && $("#jbrxb").val() !='')
				|| (data.JBRXB !=null && $("#jbrxb").val() =='')
				|| (data.JBRXB !=null && $("#jbrxb").val() !='' && $("#jbrxb").combobox('getValue') != data.JBRXB)){
					
					msg += "<div style='float:left;width:130px;'>【举报人性别】</div>";
				}
				
				// 举报人生日
				if((data.JBRSR ==null && $("#jbrsr").val() !='')
				|| (data.JBRSR !=null && $("#jbrsr").val() =='')
				|| (data.JBRSR !=null && $("#jbrsr").val() !='' && $("#jbrsr").val() != data.JBRSR)){
					
					msg += "<div style='float:left;width:130px;'>【举报人生日】</div>";
				}
				
				// 举报人单位
				if((data.JBRDWDM ==null && $("#jbrdwdm").val() !='')
				|| (data.JBRDWDM !=null && $("#jbrdwdm").val() =='')
				|| (data.JBRDWDM !=null && $("#jbrdwdm").val() !='' && $("#jbrdwdm").combobox('getValue')  != data.JBRDWDM)){
					
					msg += "<div style='float:left;width:130px;'>【举报人单位】</div>";
				}
				
				// 举报人手机号
				if((data.JBRLXFS ==null && $("#jbrmobile").val() !='')
				|| (data.JBRLXFS !=null && $("#jbrmobile").val() =='')
				|| (data.JBRLXFS !=null && $("#jbrmobile").val() !='' && $("#jbrmobile").val() != data.JBRLXFS)){
					
					msg += "<div style='float:left;width:130px;'>【举报人手机号】</div>";
				}
				
				// 举报人出租车车牌
				if((data.CZZCP ==null && $("#czzcp").val() !='')
				|| (data.CZZCP !=null && $("#czzcp").val() =='')
				|| (data.CZZCP !=null && $("#czzcp").val() !='' && $("#czzcp").val() != data.CZZCP)){
					
					msg += "<div style='float:left;width:130px;'>【举报人出租车车牌】</div>";
				}
				
				// 举报人从业资格证
				if((data.CYZGZ ==null && $("#cyzgz").val() !='')
				|| (data.CYZGZ !=null && $("#cyzgz").val() =='')
				|| (data.CYZGZ !=null && $("#cyzgz").val() !='' && $("#cyzgz").val() != data.CYZGZ)){
					
					msg += "<div style='float:left;width:130px;'>【举报人从业资格证】</div>";
				}
				
				// 举报人现居住地址
				if((data.JBRXJZDZ ==null && $("#jbrxjzdz").val() !='')
				|| (data.JBRXJZDZ !=null && $("#jbrxjzdz").val() =='')
				|| (data.JBRXJZDZ !=null && $("#jbrxjzdz").val() !='' && $("#jbrxjzdz").val() != data.JBRXJZDZ)){
					
					msg += "<div style='float:left;width:130px;'>【举报人现居住地址】</div>";
				}
				
				// 举报人户籍地址
				if((data.HJDZ ==null && $("#hjdz").val() !='')
				|| (data.HJDZ !=null && $("#hjdz").val() =='')
				|| (data.HJDZ !=null && $("#hjdz").val() !='' && $("#hjdz").val() != data.HJDZ)){
					
					msg += "<div style='float:left;width:130px;'>【举报人户籍地址】</div>";
				}				

				if ("undefined" != typeof msg && msg != null && msg != ''){
					msg = '<div style="width:390px;">'+msg+'</div>';
					
					//msg+=""
					topMessager.show({
						title:'以下信息与出租车备案系统不一致',
						width:'390px',
						msg:msg,
						timeout:0
					});
					rtn = false;
				}
			}
		}
	});
	return rtn;
}
function clearValue(){

	$("#jbrxm").val('');
	$("#jbrsr").datebox('setValue','');
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
	//$('.datebox :text').attr('readonly','readonly');
	//地址查询
	initAddressSearch('jzd1', {}, 'xsdzmlpdm', 'xsdzmlpxz', 'jzd2', {text:'xsdzxz',dzxzqh:'xsdzssxdm',id:'xsdzdm'}, null, null);
	
	if($("#bz").val() == ''){
		$("#bz").append(message);
		$("#bz").css({color:"GRAY"});
	}
	
	//map标注
	$('#mapBotton').click(function(){  biaozhu();});
	
	//$("#jbrsfzh").bind("blur",function(e){	check();});
	$('#jlxxForm').form({  
        onSubmit:function(){
            if(check() && $(this).form('validate')){
            	return true;
            }else{
            	return false;
            }
        },  
        success:function(data){
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            	topMessagerAlert(null,json.message);
            }else{
            	$("#id").val(json.saveID); 
            	executeTabPageMethod(mainTabID, "reloadDg");
            	topMessagerShow(null, json.message);
            	closeSelf();
            }
        }  
    });   
	
	$('#saveButton').click(function(){
	
		topMessager.confirm('操作确认', '您是否保存任务信息？',  function(r) {
		
			if (r) {
			
				if($("#bz").val()==message){
					
					$("#bz").val('');
				}
				$('#jbxxForm').submit();
			}
		});
	});
	
	$('#backButton').click(function(){
		
		closeSelf();
	});
	
	$('#resetBotton').click(function(){
	
		//document.forms["jbxxForm"].reset();
		$('#jbxxForm').form('reset');
	});
	
	setReadOnly();
});

	
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
			$("#jbrdw").val(dwmc);
		}
	}
	
	//提交申请
	$("#summitApproval").click(function(){
		topMessager.confirm('操作确认', '您是否确定提交申请？',  function(r) {
			if (r) {
				$("#jlxxForm").submit();
			}
		});
	});
	
	function viewCase(){
		if('${ajSource}'=='0'){
			cancelBubble(); // 阻止冒泡，不然要执行onClickRow
			var hsUrl = "/ajxxb/viewCase?"
			hsUrl+="ajId="+'${ajxxb.ajbh}'+"&xsbh="+'${ajxxb.xsbh}'+"&showFlag="+'0'+"&mainTabID="+getMainTabID();
			menu_open("查看案件",hsUrl);
		}else{
			JWZH.AJXX('${alarm}','0000','${ajxxb.ajbh}')
		}
	}
	
	function viewXs(){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/xsjbxxb/openView?";
		hsUrl+="id="+'${entity.id}'+"&mainTabID="+getMainTabID();//这是线索编号
		//mainTabID=1
		menu_open("查看线索",hsUrl);
  	}
	
	function bzOnFocus(){
		
		if($("#bz").val()==message){
			
			$("#bz").val('');
		}
		
		$("#bz").css({color:"BLACK"});
	}
	
	function bzOnblur(){
		
		if($("#bz").val()==''){
			
			$("#bz").val(message);
			$("#bz").css({color:"GRAY"});
		}
	}
</script>
</body>
</html>