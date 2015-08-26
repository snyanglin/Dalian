<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知公告信息</title>
<style type="text/css">
a:hover{text-decoration:underline;}
*{font-family:宋体}
</style>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
var zjtk = '${entity.zjtk }';
</script>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:false">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center" style="width:800px">
    	
		<div class="pop_conta" >
		<div class="pop_contb">
		<div class="pop_contc">
		 
		 <form action="<%=basePath%>tzgg/save" id="jbxxForm" name="jbxxForm" method="post">
	    	  <div data-options="region:'center', split:true" style="width:800px;" border-width: 0px;">
	    	  
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/>  
	    	  <input type='hidden' name='fbztdm' id="fbztdm" value=""/>
		 
	    	  <div data-options="region:'center', split:true" style="width:800px;" border-width: 0px;">
	    	  
	    	  <input type='hidden' name='id' id="id" value="${entity.id}"/>  
	    	  <input type='hidden' name='fbztdm' id="fbztdm" value=""/>
	    	  
	    	  <table border="0" cellpadding="0" cellspacing="10" style="width:800px" align="center">
	    	  	<tr class="dialogTr">
	    	  		<td width="100%" class="dialogTd" align="center"  style="height:30px;weight:800px;font-size:16px;font-weight:bold;color:red;">
	    	  			&nbsp;&nbsp;${entity.ggbt}
					</td>
				</tr>
				<tr class="dialogTr" >
	    	  		<td width="100%" class="dialogTd" align="center"  style="height:10px;weight:400px;color:#666666;">
	    	  			作者：${entity.xt_lrrxm}&nbsp;&nbsp;部门：${entity.xt_lrrbm}&nbsp;&nbsp;发布时间：${entity.xt_cjsj}
					</td>
				</tr>
				<tr class="dialogTr">
			    <td width="100%" class="dialogTd" align="center"  colspan="3" style="width:800px;letter-spacing:5px;text-align:justify;line-height:17pt;font-size:14px; height:82px;border:0px solid;border-color:#95B8E7;">
			    	   <p style="text-align:justify;line-height:17pt;font-family:'宋体';font-size:14px;word-break:pre;word-wrap:break-word;word-spacing: 1px; white-space:pre-wrap;text-indent: 2em;"> 
			    	   		${entity.ggnr}</p>
				</td>
				</tr>
				
				<tr class="dialogTr" id="receiveUnit">
			    	    <td width="70%" class="dialogTd" align="center"  colspan="3"  style="font-size:14px;width:80%; height:82px;border:0px solid;border-color:#95B8E7;">
							<div id="jsbm" name="jsbm" style='padding:20px;font-size:14px;letter-spacing:5px;text-align:justify;line-height:17pt;'></div>
						</td>
				</tr>

				
				 <tr class="dialogTr" id="bzContent">
			    	    <td width="100%" class="dialogTd" align="center"   colspan="3"  style="width:80%; height:82px;border:0px solid;border-color:#95B8E7;font-size:14px;letter-spacing:5px;text-align:justify;line-height:17pt;">
			    	    &nbsp;&nbsp;${entity.bz}
						</td>
	    	       </tr>
	    	       
	    	       <tr class="dialogTr" >
			    	    <td width="100%" class="dialogTd"  align='left'>
			    	    	<span style="height:30px;width:700px;border:0px solid;border-color:#95B8E7;font-size:14px;">&nbsp;&nbsp;链接页面：
			    	    	<a href ="${entity.ljym }" target="_blank">${entity.ljym }</a></span>
						<!-- <input type="checkbox" name ="zjtk" id="zjtk" value="0" disabled="disabled">直接弹开 -->
						</td>
	    	       </tr>
				<tr class="dialogTr">
			    	    <td width="100%" class="dialogTd" align="left"   colspan="3" style="font-size:14px;width:80%; height:82px;border:0px solid;border-color:#95B8E7;">
							&nbsp;&nbsp;附件下载： <span id="tzggFj" style="font-size:14px"></span>
						</td>
				</tr>
	    		</table>
		    </div>
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
					<span class="l-btn-text">关闭</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
		</div>

</td>
</tr>
</table>
</div>

 <div style="display:none;">
	    <form name="downloadform" id="downloadform" action="<%=basePath%>zpfjFjxxb/download" target="submitFrame" method="post">
	    <input type="hidden" name="id" id="downloadID"/>
	    </form>
	</div>
<script type="text/javascript">
$(function(){
	
	if(mode=="inFo"){
		$("#receiveUnit").hide();
		$("#bzContent").hide();
	}
	if(zjtk=='0'){
		$("#zjtk").attr("checked",true)
	}
	$('#backButton').click(function(){
		if(mode=="inFo"){
			window.close();
		}else{
			closeSelf();
		}
	});
	
});

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
					jsbmid+=json[i].jsbmid+",";;
					jsbm+=json[i].jsbm +",";
				}
				jsbm = jsbm.substring(0,jsbm.lastIndexOf(","));
				$("#jsbm").html(jsbm);
				$("#jsbmid").val(jsbmid);
			}
		});
	}
		
}

function downLoad(id){
	$('#downloadID').val(id);
	$('#downloadform').form('submit', {
		success: function(result) {
			if (result) {
				result = parseReturn(result);
				if (result.status == 'success') {
				}
				else {
					topMessager.alert('', result.message);
				}
			}
		}
	});

}
function queryFj(){
	var id1 = $("#id").val();
	if(id1!=""){
		$.ajax({
			type:"GET",
			sync:true,
			url:contextPath+"/tzgg/queryFj",
			data:{lybm:'SYS_TZGGB',lyid:id1},
			dataType:'json',
			success:function(json){
				var html ="";
				if(json.length>0){
					html ="<table style='padding:3px;font-size:14px;' border='0' cellpadding='0' cellspacing='2' width='50%' align='center'>";
					//html+="<tr height='10px'><td width='20%'>序号</td><td width='60%'>文件名称</td></tr>";
					for(var i=0;i<json.length;i++){
						var fjid= json[i].id+"";
						html+="<tr ><td><img src='"+contextPath+"/images/attachment.png' rowspan='2' /></td>"
							  +"<td><a href='javascript:void(0);' onclick='downLoad(\""+fjid+"\")'>"+json[i].wjmc+"</a> <font color='#666666'>("+json[i].wjdx+"K)</font></td></tr>";
						html+="<tr ><td></td><td><a href='javascript:void(0);' onclick='downLoad(\""+fjid+"\")'>下载</a></td><td></td></tr>";
					}
					html+="</table>";
				}else{
					html="附件暂无";
				}
				
				$("#tzggFj").html(html);
			}
		});
	}
		
}
queryByTzggId();
queryFj();
</script>

</body>
</html>