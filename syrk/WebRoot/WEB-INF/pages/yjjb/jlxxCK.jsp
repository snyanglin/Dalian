<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<%@ page import="com.founder.framework.base.entity.SessionBean"%>

<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>举报奖励审批</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
<body  class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	    	<div style="margin:0px auto;width:1209px;">
		    	<div style="width:880px;float:left;">
			    	<table height="100%" style="margin:0 auto;">
			    		<tr><td height="100%" valign="top" align="center">
						<div class="pop_conta">
						<div class="pop_contb">
						<div class="pop_contc">
					 
					 <form action="<%=basePath%>jbjlspb/sp" id="jbxxForm" name="jbxxForm" method="post" >
				    	  <div data-options="region:'center', split:true" style="width:880px; border-width: 0px;">
						  <input type='hidden' id="btnType" name="btnType"/>
						  <input type='hidden' id="spid" name="id" value="${jbjlspb.id}"/>
						  <input type='hidden' id="jlid" name="jlxxbid" value="${jlxxb.id}"/>
						  <input type='hidden' id="xsbh" name="xsbh" value="${xsjbxxb.id}"  />
						  <input type='hidden' id="ajbh" name="ajbh" value="${ajxxb.ajbh}"  />
				    	  <table border="0" cellpadding="0" cellspacing="10" width="100%"  style="margin:0 auto;">
				    	      <tr class="dialogTr">
							    	<td width="100" class="dialogTd" align="right">线索编号：</td>
							    	<td width="300" class="dialogTd">
							    		<div style="float:left;"><a class="link" href="javascript:javascript:void(0)" onclick="viewXs()">${xsjbxxb.id}</a></div>
							    		<div class="lodingimg" id="yrjbxxDiv"></div>
									</td> 
									<td width="130" class="dialogTd" align="right">案件编号：</td>
							    	<td width="300" class="dialogTd">
							    		<a class="link" href="javascript:javascript:void(0)" onclick="viewCase()">${ajxxb.ajbh}</a>
					    	        </td>
				    	      </tr> 
				    	      <tr class="dialogTr">
							    	<td  class="dialogTd" align="right">身份证号：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-validatebox" id="jbrsfzh" name="jbrsfzh" readOnly="readOnly" value="${xsjbxxb.jbrsfzh}" 
							    		style="width:180px;" />
							    		<div class="lodingimg" id="yrjbxxDiv"></div>
									</td> 
									<td  class="dialogTd" align="right">姓名：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-validatebox" type="text" id="jbrxm" name="jbrxm" readOnly="readOnly" value="${xsjbxxb.jbrxm}"
					    	 			maxlength="30" style="width:180px;" />
					    	        </td>
				    	      </tr> 
			   	    	      <tr class="dialogTr">
							    	<td  class="dialogTd" align="right">性别：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-combobox" id="jbrxb" name="jbrxb" readOnly="readOnly" value="${xsjbxxb.jbrxb}" 
							    		style="width:180px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',
							    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td> 
									<td  class="dialogTd" align="right">出生日期：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-validatebox" type="text" id="jbrsr" name="jbrsr" readOnly="readOnly" value="${xsjbxxb.jbrsr}"
					    	 			maxlength="10" style="width:180px;" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" />
					    	        </td>
				    	      </tr> 
				    	      <tr class="dialogTr">
							    	<td  class="dialogTd" align="right">单位：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-combobox" id="jbrdwdm" name="jbrdwdm" readOnly="readOnly" value="${xsjbxxb.jbrdwdm}" 
							    		style="width:180px;" data-options="required:true,url: contextPath + '/common/tcdic',
							    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:czcChange"/>
									</td>
									<input type='hidden' name='jbrdw' id="jbrdw" value="${xsjbxxb.jbrdw}"/> 
									<td  class="dialogTd" align="right">手机号码：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-validatebox" type="text" id="jbrmobile" name="jbrmobile" readOnly="readOnly" value="${xsjbxxb.jbrmobile}"
					    	 			maxlength="1000" style="width:180px;"/>
					    	        </td>
				    	      </tr>
				    	      <tr class="dialogTr">
				    	      		<td  class="dialogTd" align="right">联系方式：</td>
				    	      		<td  class="dialogTd"  colspan="3">
							    		<input class="easyui-validatebox" type="text" readOnly="readOnly" id="jbrlxfs" name="jbrlxfs" value="${xsjbxxb.jbrlxfs}" 
					    	 			maxlength="1000" style="width:630px;"/>
					    	 			</td>
						      </tr>
						      <!-- 
				    	      <c:forEach var="item" items="${listlxfs}" varStatus="i">
					    	  		<tr class="dialogTr">
					    	      		<td  class="dialogTd" align="right">联系方式：</td>
								    	<td  class="dialogTd"  colspan="3">
								    		<input class="easyui-validatebox" type="text"  readOnly="readOnly"name="jbrlxfsList" value="${item}" 
						    	 			maxlength="1000" style="width:630px;" data-options="required:false,validType:['maxLength[1000]'],tipPosition:'right'"/>
						    	        </td>
					    	      	</tr>
				    	      </c:forEach>
				    	      -->
				    	      <tr class="dialogTr">
							    	<td  class="dialogTd" align="right">出租车车牌：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-validatebox" id="czzcp" name="czzcp" readOnly="readOnly" value="${xsjbxxb.czzcp}" 
							    		style="width:180px;"/>
									</td> 
									<td  class="dialogTd" align="right">从业资格证：</td>
							    	<td class="dialogTd">
							    		<input class="easyui-validatebox" type="text" id="cyzgz" name="cyzgz" readOnly="readOnly" value="${xsjbxxb.cyzgz}"
					    	 			maxlength="20" style="width:180px;"/>
					    	        </td>
				    	      </tr>
				    	      <tr class="dialogTr">
									<td  class="dialogTd" align="right">居住地址：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-validatebox" type="text" id="jbrxjzdz" name="jbrxjzdz" readOnly="readOnly" value="${xsjbxxb.jbrxjzdz}"
					    	 			maxlength="100" style="width:180px;"/>
					    	        </td>
					    	        <td  class="dialogTd" align="right">户籍地址：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-validatebox" id="hjdz" name="hjdz" readOnly="readOnly" value="${xsjbxxb.hjdz}" 
							    		style="width:180px;" />
									</td> 
				    	      </tr>	   
				    	      <tr class="dialogTr">
							    	<td  class="dialogTd" align="right">线索类型：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-combobox" id="xslx" name="xslx" readOnly="readOnly" value="${xsjbxxb.xslx}" 
							    		style="width:180px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XSLX.js',
							    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td> 
									<td  class="dialogTd" align="right">举报信息性质：</td>
							    	<td  class="dialogTd">
							    		<input class="easyui-combobox" type="text" id="jbxxxz" name="jbxxxz" readOnly="readOnly" value="${xsjbxxb.jbxxxz}"
					    	 			maxlength="20" style="width:180px;" data-options="url: contextPath + '/common/dict/D_BZ_AJLB.js',
							    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					    	        </td>
				    	      	</tr> 
								<tr class="dialogTr">
			
			    					<td  class="dialogTd" align="right">线索发现地址：</td>
								 	<td class="dialogTd" colspan="2">
									  	<input class="easyui-combobox" id="jzd1" style="width:440px;" readOnly="readOnly" value="${xsjbxxb.xsdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
									    	<input type='hidden' name='xsdzmlpdm' id="xsdzmlpdm" value="${xsjbxxb.xsdzmlpdm}"/>
									    	<input type='hidden' name='xsdzmlpxz' id="xsdzmlpxz" value="${xsjbxxb.xsdzmlpxz}"/>
									</td>
									<td  class="dialogTd" >
										<input class="easyui-combobox" id="jzd2" style="width:180px;" readOnly="readOnly" value="${fn:replace(xsjbxxb.xsdzxz, xsjbxxb.xsdzmlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
										<input type="hidden" name="xsdzdm" id="xsdzdm" value="${xsjbxxb.xsdzdm}"/>
										<input type="hidden" name="xsdzssxdm" id="xsdzssxdm" value="${xsjbxxb.xsdzssxdm}"/>
									    <input type='hidden' name='xsdzxz' id="xsdzxz" value="${xsjbxxb.xsdzxz}"/>
									</td>
				    	    	</tr>
					    	    <tr class="dialogTr">
									<td  class="dialogTd" align="right" valign="top">线索地址描述：</td>
							    	<td class="dialogTd" colspan="3" >
							    		<textarea id="xsdzms" name="xsdzms" readOnly="readOnly" class="easyui-validatebox" style="width:630px; height:48px;"
										data-options="tipPosition:'left'" >${xsjbxxb.xsdzms}</textarea>
									</td>
					    	    </tr>
					    	    <tr class="dialogTr">
					    	    	<td id="tdAjztFir" class="dialogTd" align="right">协助方式：</td>
									<td id="tdAjztSec"  class="dialogTd" readOnly="readOnly">
							    		<span id="rdo0"><input type="radio" name="xzfs" value="0" id="radio0" disabled="disabled"/>提供线索</span>
										<span id="rdo1"><input type="radio" name="xzfs" value="1" id="radio1" disabled="disabled"/>抓获现行</span>
										<span id="rdo2"><input type="radio" name="xzfs" value="2" id="radio2" disabled="disabled"/>抓获逃犯</span>
										<span id="rdo3"><input type="radio" name="xzfs" value="3" id="radio3" disabled="disabled"/>其它</span>
									</td>
								</tr>
								<tr class="dialogTr">
							    	<td  class="dialogTd" align="right">内容：</td>
							    	<td  class="dialogTd" colspan="3" >
							    		<textarea readOnly="readOnly" id="jlxxbbz" name="jlxxbbz" class="easyui-validatebox" style="width:630px; height:48px;"
										data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',
										tipPosition:'left'" >${jlxxb.bz}</textarea>
									</td>
					    	    </tr> 
					    	    <tr class="dialogTr">
									<td  class="dialogTd" align="right">办案单位：</td>
									  	<td  class="dialogTd">
									  		<input class="easyui-validatebox" type="text" id="xt_lrrbm" readOnly="readOnly" name="xt_lrrbm"
										 			maxlength="100" style="width:180px;" value="${ajxxb.xt_lrrbm} "/>
										 </td>
										 <td  class="dialogTd" align="right">办案民警：</td>
								  	<td  class="dialogTd">
								  		<input class="easyui-validatebox" id="xt_lrrxm" name="xt_lrrxm" readOnly="readOnly"
								  		style="width:180px;" value="${ajxxb.xt_lrrxm}"/>
									</td> 
						        </tr>
					    	    <tr class="dialogTr">
							    	<td  class="dialogTd" align="right" valign="top">查证处理结果：</td>
							    	<td  class="dialogTd" colspan="3" >
							    		<textarea readOnly="readOnly" id="slfzcljg" name="slfzcljg" class="easyui-validatebox" style="width:630px; height:48px;"
										data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',
										tipPosition:'left'" >${jlxxb.slfzcljg}</textarea>
									</td>
					    	    </tr> 
					    	    
					    	    <tr class="dialogTr" id = "slzcljgTr">
							    	<td  class="dialogTd" align="right" valign="top">受理站审核：</td>
							    	<td  class="dialogTd" colspan="3" >
							    		<textarea readOnly="readOnly" id="slzcljg" name="slzcljg" class="easyui-validatebox" style="width:630px; height:48px;"
										data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',
										tipPosition:'left'" >${jlxxb.slzcljg}</textarea>
									</td>
					    	    </tr> 
					    	    
					    	    <tr class="dialogTr" id="slzxcljgTr" >
							    	<td  class="dialogTd" align="right" valign="top">受理中心意见：</td>
							    	<td  class="dialogTd" colspan="3" >
							    		<textarea readOnly="readOnly" id="slzxcljg" name="slzxcljg" class="easyui-validatebox" style="width:630px; height:48px;"
										data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',
										tipPosition:'left'" >${jlxxb.slzxcljg}</textarea>
									</td>
			 
					    	    </tr class="dialogTr" > 
					    	    <tr id="jljeTr">
					    	    	<td  class="dialogTd" align="right">奖励金额：</td>
									<td  class="dialogTd">
								  		<input readOnly="readOnly"class="easyui-validatebox" id="jlje" name="jlje" "
								  		style="width:180px;data-options="validType:['money']"" value="${jlxxb.jlje }"/>
									</td>
								</tr>
									
								<tr class="dialogTr">
									<td  class="dialogTd" align="right">附件：</td>
							    	<td class="dialogTd">
										<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="uploadFileView('YJJB_JBXXB', '${jlxxb.id}', '0')">
											<span class="l-btn-left l-btn-icon-left">
												<span class="l-btn-text">申请表附件</span>
												<span class="l-btn-icon icon-attach"></span>
											</span>
										</a>	
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
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">关 闭&nbsp;&nbsp;</span>
								<span class="l-btn-icon icon-cancel"> </span>
							</span>
						</a>
					</div>
			</td>
			</tr>
			</table>
			</div>
			<div style="float:left;width:250px;min-height:200px;margin-left:25px;*margin-left:5px;">
				<ul class="colli">
					<c:forEach var="item" items="${list}">
					<li>
						<c:choose>
							<c:when test="${item.spzt=='1' }">
								<c:if test="${item.xt_lrsjV != null && item.spdwV != null}">
									<div>审批流转至：${item.spdwV}</div>
									<div>时间：${item.xt_lrsjV}</div>
									<div>${item.spdw}审批处理</div>
									<div>处理状态：已处理</div>
									<div>审批回复：${item.sphf}</div>
								</c:if>
								<c:if test="${item.xt_lrsjV == null && item.spdwV == null}">
									<div>审批流转至：${jbjlxxb.xt_lrrbm}</div>
									<div>时间：${item.xt_zhxgsj}</div>
									<div>操作：${item.spdw}审批处理</div>
									<div>处理状态：已处理</div>
									<div>审批回复：${item.sphf}</div>
								</c:if>
							</c:when>
							<c:otherwise>
								<div>时间：${item.xt_lrsj}</div>
								<div>操作：${item.spdw}收到奖励审批</div>
								<div>处理状态：待处理</div>
							</c:otherwise>
						</c:choose>
					</li>
					</c:forEach>
					<li>
						<div>时间：${jbjlxxb.xt_lrsj}</div>
						<div>操作：${jbjlxxb.xt_lrrbm}的${jbjlxxb.xt_lrrxm}向${sqdwUpName}发起奖励申请</div>
					</li>
				</ul>
			</div>
	</div>
</div>
<script type="text/javascript" src="<%=contextPath%>/js/jwzhold.js"></script>
<script type="text/javascript">

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
	setInputReadonly('jlxxbbz', true);
	setInputReadonly('xt_lrrbm', true);
	setInputReadonly('xt_lrrxm', true);
	setInputReadonly('slfzcljg', true);
	setInputReadonly('slzcljg', true);
	setInputReadonly('slzxcljg', true);
	setInputReadonly('jlje', true);
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
		url:contextPath+"/common/tinfo",
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
	//$('.datebox :text').attr('readonly','readonly');
	//地址查询
	initAddressSearch('jzd1', {}, 'xsdzmlpdm', 'xsdzmlpxz', 'jzd2', {text:'xsdzxz',dzxzqh:'xsdzssxdm',id:'xsdzdm'}, null, null);
	
	setXZFS();
	
	if("${orglevel}" == "00"){// 分站
		
		// 隐藏jlje
		/*
		$("#doDY").hide();
		$("#jljeTr").hide();
		$("#slzcljgTr").hide();
		$("#slzxcljgTr").hide();
		*/
	}else if ("${orglevel}" == "01"){ //站
		// 隐藏
		/*
		$("#doDY").hide();
		$("#jljeTr").hide();
		$("#slzxcljgTr").hide();
		*/
		// 只读
		$('#jlxxbbz').attr('readonly','readonly');
		$('#slfzcljg').attr('readonly','readonly');
	}else if ("${orglevel}" == "02"){ //中心
		// 只读
		$('#jlxxbbz').attr('readonly','readonly');
		$('#slfzcljg').attr('readonly','readonly');
		$('#slzcljg').attr('readonly','readonly');
	}else{ // 未知
		
		// 隐藏jlje
		/*
		$("#doDY").hide();
		$("#jljeTr").hide();
		$("#slzcljgTr").hide();
		$("#slzxcljgTr").hide();
		*/
		// 只读
		$('#jlxxbbz').attr('readonly','readonly');
		$('#slfzcljg').attr('readonly','readonly');
		$('#slzcljg').attr('readonly','readonly');
	}
	//map标注
	$('#mapBotton').click(function(){  biaozhu();});
	
	$("#jbrsfzh").bind("blur",function(e){	check();});
	$('#jbxxForm').form({  
	
        onSubmit:function(){
        
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            
            	topMessagerAlert(null,json.message);
            }else{
            
            	$("#id").val(json.saveID); 
            	executeTabPageMethod(mainTabID, "reloadDg");
				topMessagerAlert(null, "保存成功","success");
            	closeSelf();
            }
        }  
    });   

	//打印
	$('#doDY').click(function(){
	
		topMessager.confirm('操作确认', '您是否打印该页？',  function(r) {
		
			if (r) {
				// 打印审批页
				doDYSPY();
			}
		});
	});
	
	//确认递转
	$('#doTY').click(function(){
	
		topMessager.confirm('操作确认', '您是否同意该申请？',  function(r) {
		
			if (r) {
				$("#btnType").val("1");
				$('#jbxxForm').submit();
			}
		});
	});

	//交给上级递转
	$('#doJJ').click(function(){
	
		topMessager.confirm('操作确认', '您是否拒绝该申请？',  function(r) {
			
			if (r) {
				$("#btnType").val("0");
				$('#jbxxForm').submit();
			}
		});
	});
	
	$('#saveButton').click(function(){
	
		topMessager.confirm('操作确认', '您是否保存任务信息？',  function(r) {
		
			if (r) {
			
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
				$("#jbxxForm").submit();
			}
		});
	});
	
	
	function doDYSPY(){
		
		var hsUrl = "/jbjlspb/openDY?";
		hsUrl+="id="+"${jbjlspb.id}"+"&mainTabID="+getMainTabID();
		menu_open("举报奖励申请审批",hsUrl);
	}
	
	function setXZFS(){
		
		var xzfs = "${jbjlxxb.xzfs}";
		if(xzfs == 0){
			
			$("#radio0").attr("checked",true);
		}else if(xzfs == 1){
			
			$("#radio1").attr("checked",true);
		}else if(xzfs == 2){
			
			$("#radio2").attr("checked",true);
		}else {
			
			$("#radio3").attr("checked",true);
		}
	}
	
	function viewCase(){
		if('${ajSource}'=='0'){
			cancelBubble(); // 阻止冒泡，不然要执行onClickRow
			var hsUrl = "/ajxxb/viewCase?"
			hsUrl+="ajId="+'${ajxxb.ajbh}'+"&xsbh="+'${xsjbxxb.id}'+"&showFlag="+'0'+"&mainTabID="+getMainTabID();
			menu_open("查看案件",hsUrl);
		}else{
			JWZH.AJXX('${alarm}','0000','${ajxxb.ajbh}')
		}
		
	}
	
	function viewXs(){
		
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/xsjbxxb/openView?";
		hsUrl+="id="+'${xsjbxxb.id}'+"&mainTabID="+getMainTabID();
		//mainTabID=1
		menu_open("查看线索",hsUrl);
		
  	}
</script>
</body>
</html>