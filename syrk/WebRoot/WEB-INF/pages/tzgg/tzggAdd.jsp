<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知公告</title>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
var zjtk = '${entity.zjtk }';
</script>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>tzgg/save" id="jbxxForm" name="jbxxForm" method="post">
	    	  <div data-options="region:'center', split:true" style="width:1000px; border-width: 0px;">
	    	  
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/>  
	    	  <input type='hidden' name='fbztdm' id="fbztdm" value=""/>
	    	  
	    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	  <tr class="dialogTr">
	    	  		<td width="20%" class="dialogTd" align="right">
	    	  			&nbsp;
	    	 		 </td>
	    	  		<td width="80%" class="dialogTd" align="left">
	    	  		<span style="height:10px;color:#666666;" id="remind">
	    	  				<img alt="" src="<%=contextPath%>/images/red_light.png">公告添加完成，可上传附件!</span>
					</td>
				</tr>
	    	  	<tr class="dialogTr">
	    	  		<td width="20%" class="dialogTd" align="right" style="font-size:14px;">公告标题：</td>
	    	  		<td width="80%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="ggbt" name="ggbt"
		    	 			value="${entity.ggbt}" maxlength="50" style="width:600px;font-size:14px;" data-options="required:true,validType:['maxLength[50]'],invalidMessage:'公告标题不能超过50个汉字，请重新输入！',tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right" style="font-size:14px;">公告类型：</td>
				    	<td width="80%" class="dialogTd"><input class="easyui-combobox" type="text" id="tzgglx" name="tzgglx" value="${entity.tzgglx}" style="width:150px;font-size:14px;"
							data-options="required:true,url: contextPath + '/common/dict/D_TZTG_TZTGLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
			    </tr>
				<tr class="dialogTr">
	    	  		<td width="20%" class="dialogTd" align="right" style="font-size:14px;">公告内容：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="ggnr" name="ggnr" class="easyui-validatebox" rows="3" style="width:800px; height:142px;font-size:14px;"
								data-options="required:true,validType:['maxLength[2000]'],invalidMessage:'公告内容不能超过2000个汉字，请重新输入！',tipPosition:'left'">${entity.ggnr}</textarea>
						</td>
				</tr>
					<tr class="dialogTr">
					   	<td width="20%" class="dialogTd" align="right" style="font-size:14px;">接收单位：</td>
					   	<td width="80%" class="dialogTd" colspan="3">
					   	<input type="hidden" id="orgid34" name="orgid34" value="" style="width: 100;font-size:14px;" />
					   	
					   	<textarea style="display:none" id="jsbmid" name="jsbmid" class="easyui-validatebox" rows="3" style="width:800px; height:82px;" 
								data-options="required:true,tipPosition:'left'">${entity.jsbmid}</textarea>
					   
					   	<textarea id="jsbm" name="jsbm" class="easyui-validatebox" rows="3" style="width:800px; height:82px;" readonly
								data-options="required:true,tipPosition:'left'" >${entity.jsbm}</textarea>
					  	<input type="button" id="orgbutton34" value="选择" onClick="public_multiSelectOrg('', '01', '', '01,02,03,04', 'jsbmid', 'jsbm', 'orgid34', true, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
					    </td>
				    </tr>	
				    	
				<tr class="dialogTr" id="attachment">
					<td width="20%" class="dialogTd" align="right" style="font-size:14px;">附件：</td>
					<td width="30%" class="dialogTd">
							<a id="attachmentButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" >
									<span class="l-btn-left l-btn-icon-left">
										<span class="l-btn-text">附件管理</span>
										<span class="l-btn-icon icon-attach"></span>
									</span>
								</a>
					</td>
				</tr>				
				 <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right" style="font-size:14px;">备注：</td>
			    	    <td width="80%" class="dialogTd" colspan="3" >
			    	    	<textarea id="entity_bz" name="bz" class="easyui-validatebox" rows="3" style="width:800px; height:82px;font-size:14px;"
								data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
						</td>
	    	       </tr>
	    	       
 					<tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right" style="font-size:14px;">链接页面:</td>
			    	    <td width="80%" class="dialogTd" >
			    	   		<input class="easyui-validatebox" type="text" id="ljym" name="ljym" onblur="checkLjym()"
		    	 				value="${entity.ljym }" maxlength="100" style="width:600px;font-size:14px;"  data-options="required:false,validType:['maxLength[100]'],tipPosition:'left'"/>
							<input type="checkbox" name ="zjtkBox" id="zjtkBox" checked="" onclick="checkLjym()">直接弹开
							<input type="hidden"  id="zjtk" name ="zjtk" value=""/>
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
			<a id="saveButton"  class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="sendButton" style="display:none" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">发布</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">取消</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
		</div>

</td>
</tr>
</table>
</div>
<script type="text/javascript">
function checkLjym(){
	var ljym = $("#ljym").val();
	if(ljym!="" && checkURL(ljym)){
		
	}else{
		topMessagerAlert("error","请输入有效网址","error");
		$("#ljym").val("");
		var s = ljym.substring(0,7);
		$("#ljym").val(s);
		$("#zjtkBox").attr("checked",false);
	}
}
function onOrgSelected(orgCodeInputID) {
	var jsbm = $("#jsbm").val();
	if(jsbm!="" && jsbm!=null){
		$("#jsbm").validatebox({required:false});
	}else{
		$("#jsbm").validatebox({required:true});
	}
}

$(function(){
	//接收单位置灰
	//setInputReadonly('jsbm',true);
	$("#jsbm").validatebox({novalidate:false});
	$("#jsbm").addClass("inputReadonly");
	
	if(mode=="add"){
		$("#remind").show();
	}else{
		$("#remind").hide();
	}
	
	if(zjtk=="0"){
		$("#zjtkBox").attr("checked",true);
	}else{
		$("#zjtkBox").attr("checked",false);
	}
	
	$('#jbxxForm').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            	topMessagerAlert(null,json.message);
            }else{
            	
            	$(document.body).unmask();
            	
            	$("#saveButton").hide();
            	$("#sendButton").show();
            	$("#attachment").show();
            	$("#id").val(json.saveID); 
            	topMessagerShow(null,json.message);
            	if(mode=="send"){
            		executeTabPageMethod(mainTabID, "reloadDg");
                	closeSelf();
            	}else{
            		
            	}
            	if(mode==""){
            		mode="send";
            	}
            	
            	alertMessage(mode);
            }
        }  
    });   
	
	$('#saveButton').click(function(){
		if($("#jbxxForm").form('validate')){
			topMessager.confirm('操作确认', '您是否保存通知公告信息？',  function(r) {
				if (r) {
					$("#fbztdm").val("1"); 
					if($('#zjtkBox').is(":checked")){
						$("#zjtk").val("0");
						document.getElementById("zjtk").value = 0;
					}else{
						$("#zjtk").val("1");
						document.getElementById("zjtk").value = 1;
					}
					
					$('#jbxxForm').submit();
					$(document.body).mask("加载中...");
				}
			});
		}else{
			
		}
	});
	
	$('#sendButton').click(function(){
		topMessager.confirm('操作确认', '发布通知公告信息？',  function(r) {
			if (r) {
				$("#fbztdm").val("0"); 
				mode="send";
				$('#jbxxForm').submit();
				$(document.body).mask("正在发布中...");
			}
		});
	});
	
	$('#backButton').click(function(){
		closeSelf();
	});
	
	$('#attachmentButton').click(function(){
		var id =$("#id").val();
		if(id!=null && id!=""){
			uploadFileEdit("SYS_TZGGB", ""+id+"", "通知公告-附件", "", "5", "1");
		}
		
	});
	
	
});
function alertMessage(mode){
	//保存成功提示框
	if(mode=="add"){
		topMessager.show({
			title: "通知公告添加",
			msg: "添加成功",
			timeout:1500
		});
	}else if(mode=="send"){
		topMessager.show({
			title: "通知公告发布",
			msg: "发布成功",
			timeout:1500
		});
	}
	
}
function switchButton(){
	if(mode=="add"){
		$("#saveButton").show();
		$("#attachment").hide();
		$("#ljym").val("http://");
	}else if(mode=="send"){
		$("#saveButton").hide();
		$("#sendButton").show();
		$("#attachment").show();
	}else if(mode=="edit"){
		$("#saveButton").show();
		$("#sendButton").hide();
		$("#attachment").show();
		
	}
}

function queryByTzggId(){
	var id = $("#id").val();
	if(id!=""){
		$.ajax({
			type:"GET",
			sync:true,
			url:contextPath+"/tzgg/queryByTzggId",
			data:{id:id},
			dataType:'json',
			success:function(json){
				var jsbmid ="";
				var jsbm ="";
				for(var i=0;i<json.length;i++){
					jsbmid+=json[i].jsbmid+",";
					jsbm+=json[i].jsbm +",";
				}
				
				//$("#jsbm").val(jsbm);
				if(jsbmid.lastIndexOf(",", jsbmid.length)>0){
					jsbmid = jsbmid.substring(0,jsbmid.length-1);
					$("#jsbmid").val(jsbmid);
				}else{
					$("#jsbmid").val(jsbmid);
				}
				if(jsbm.lastIndexOf(",", jsbm.length)>0){
					jsbm = jsbm.substring(0,jsbm.length-1);
					$("#jsbm").val(jsbm);
				}else{
					$("#jsbm").val(jsbm);
				}
				
				if(jsbm!="" && jsbm!=null){
					$("#jsbm").validatebox({required:false});
				}
				
			}
		});
	}
		
}

function checkURL(URL){
	var str=URL;
	//下面的代码中应用了转义字符"\"输出一个字符"/"
	var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/; 
	var objExp=new RegExp(Expression);
	if(objExp.test(str)==true){
	   return true;
	}else{
	   return false;
	}
}
queryByTzggId();
switchButton();
</script>

</body>
</html>