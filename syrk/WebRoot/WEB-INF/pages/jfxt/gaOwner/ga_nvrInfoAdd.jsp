<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>新增(修改)视频监控系统</title>
<script type="text/javascript" src="<%=contextPath%>/common/dict/jfxt/js/codetranslate.js"></script> 
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
  
<body style="margin-top:20px" class="bodybg">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    			<form action="<%=basePath%>nvrInfo/save" id="nvrInfoAddUpdateForm" name="nvrInfoAddUpdateForm" method="post">
					<!-- 表示新增还是修改 -->
					<input type="hidden" name="id" id="id" value="${entity.id}" />
	    	      <tr class="dialogTr">
	    	      <td width="20%" class="dialogTd" align="right">所属平台：</td>
				    	<td width="30%" class="dialogTd">
				    		<input type="hidden" name="pt_idOld" id="pt_idOld" value="${entity.pt_id}" />
				    		<input class='easyui-combobox' type='text' id="pt_id" name='pt_id' value="${entity.pt_id}" style="width:200px;"  maxlength="30"
		    	        	data-options="url:'<%=basePath %>platform/getPlatformNameAndId?curTime='+(new Date()).getTime(),textField:'ptmc',valueField:'id',required:true"/>
		    	        	
		    	        </td>
	    	        
	    	      </tr>
	    	      
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">设备名称：</td>
				    	<td width="30%" class="dialogTd">
				    		<input type="hidden" name="sbMcOld" id="sbMcOld" value="${entity.sbMc}" />
				    		<input class='easyui-validatebox' type='text' id="sbMc" name='sbMc' value="${entity.sbMc}"  style="width:200px;"  maxlength="20"
		    	        		data-options="required:true"/>
		    	        </td>  	      
	    	      
	    	      </tr>

	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">存储时长：</td>
				    	<td width="30%" class="dialogTd">
							<input class='easyui-combobox' type='text' id="ccsc" name='ccsc' value="${entity.ccsc}" style="width:200px;" 
		    	                data-options="url: contextPath + '/common/dict/jfxt/D_JF_CCSC.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/>		    	        </td>	    	      
    	      
	    	      </tr>

	    	      
	    	      <tr class="dialogTr">
    	      
				    	<td width="20%" class="dialogTd" align="right">设备IP：</td>
				    	<td width="30%" class="dialogTd">
							<input type="text" name="sbIp" id="sbIp" class="easyui-validatebox"  value="${entity.sbIp}" style="width: 200px;" 
								data-options="required:true,validType:['ip']"/>
		    	        </td>	    	      
	    	      </tr>	 	    	      
 	    	  
	    	      	    	         	      
	    	      	  	 
	    	      	    	      
    			</form>
	    		</table>
			</div>
			
				
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
			
		</div>
	    </table>	    
</div>

<script type="text/javascript">
$(document).ready(function(){

	//$('#spjkxtUpdateForm').form("disableValidation");//禁止校验
   //保存前验证，保存成功以后操作事件

	//checkCount();//检查用户当前是否已经创建过建设单位
	$('#nvrInfoAddUpdateForm').form({  
        onSubmit:function(){
        	//检查同一平台下设备名称是否唯一
        	var url=contextPath+"/nvrInfo/isUniqueForPlatformName";
        	var pt_id=$('#pt_id').val();//平台id        	
        	var sbMc=$('#sbMc').val();//设备名称        	
        	var params={'pt_id':pt_id,'sbMc':sbMc};
        	//alert(pt_id+','+sbMc);
        	var retVal=getResponseByParameter(url,params);//encodeURIComponent(ptmc)
        	//alert(retVal);
        	if(!$('#id').val()){//新增
        		if(retVal>0){
        			alert('设备名称已存在');
        			return false;
        		}
        	}
        	else{//修改
        		//alert('修改'+params['sbMc']);
        		 var sbMcOld=$('#sbMcOld').val(); //原设备名称  
        		 var pt_idOld=$('#pt_idOld').val();
        		if((sbMcOld!=sbMc)||(pt_id!=pt_idOld)){//修改了设备名称
        			
        			if(retVal>0){
        				alert('在该平台下设备名称重名啦！请重新填写！');
        				return false;
        			}
        		}
        		
        		
        	}
        	
            return $(this).form('validate');  
        },  
        success:function(data){
            var json = $.parseJSON(data);
            if(json.status == 'success'){
          	    //保存成功后跳转到欢迎页面
          	    var url = contextPath+"/forward/jfxt|gaOwner|ga_welcome?message="+json.message;
          	    parent.document.getElementById("mainAreaId").src = url;
             }else{
            	topMessagerAlert(null,json.message);
            }
        }  
    });
    //保存按钮绑定点击事件【注意：这里保存时候可以添加重复数据，是否要条件验证？】  
	$('#saveButton').click(function(){
		topMessager.confirm('操作确认', '您是否保存NVR？',  function(r) {
			if (r) {
				$('#nvrInfoAddUpdateForm').submit();
			}
		});
	});
	
	
});
//检查拷贝方式
function checkCopyfs(){
	var result=true;
	if($("input[name='copyfs']:checked").length<1){		
		result=false;		
	}
	return result;
}

//根据特殊串(用,号分隔)重新设置控件
function setCheckbox(str){
	var sArray=str.split(",");
	var copyfsArray=document.getElementsByName("copyfs");
	for(var i=0;i<sArray.length;i++){
		var theValue=sArray[i];
		for(var j=0;j<copyfsArray.length;j++){
			if(copyfsArray[j].value==theValue){
				copyfsArray[j].checked=true;
			}
		}
	}
	
	
}

window.onload=function(){
	var str=$("#copyfsFromDB").val();
	if(!(str==undefined || str=='')){
		//alert(str);
		setCheckbox(str);	
	}
	modifycheckGazj();//修改页面下，设置公安自建属性。
	//$("#dwbm").combobox('refresh');//强制刷新
	
	initPtmcDisplay();//初始化平台名称显示值2014.11.23
}
function modifycheckGazj(){
	var opt=$('#dwbm').combobox('options');
	var data=$('#dwbm').combobox('getData');
	var mdwbm=$('#dwbm').val();
	var mzj="";
	for(var i=0;i<data.length;i++){
		if(data[i].dwbm==mdwbm){
		//alert(data[i][opt.valueField]+','+data[i][opt.textField]);
			mzj=data[i].sfgazj;
			break;
		}
	}
	checkGazj(mzj);	
}
function jbxx_dz_jzdz_onSelected() {
	if (autoRklb == "") {
		autoGllb = true;
		autoSetRklb();
		valiRepeat();
	}
}
function checkCount(){

$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/querySpjkxtCount",
		dataType:"json",
		success:function(data) {
		//alert(data.Spsxtvo.jkxtNum);
			if(data.Spsxtvo.jsdwNum=="0"){
				alert('没有你管理的视频建设单位，请首先录入它!');
				return false;
			}

		},
		complete:function() {
		},
		error:function() {
		}
	});

}
/**
 * 检查系统名称是否重名
 */
function checkXTmc22() {
	var myxh=$("#xh").val();
	//alert(myxh.length);
	//if(myxh!=""||myxh!=null)
	if(myxh.length>0)
	{
	//alert('hhhh');	
		return;	
	}

	if (!$("#xtmc").validatebox("isValid")){
		return;
	}
	var _xtmc = $("#xtmc").attr("xtmc");
	if (!_xtmc) {
		_xtmc = "";
	} 
	if($("#xtmc").val() == _xtmc){
		return;
	}
	$("#jbxxLoadDiv").show();
	var mydata="";
	mydata={dwbm:$("#dwbm").val(),xtmc:$("#xtmc").val()};
	$.ajax({
		type:"POST",
		url:"<%=basePath%>spjkxt/checkSameName",
		dataType:"json",
		data:mydata,
		success:function(data) {
			if(data.Spsxtvo.sameName!="0"){
				alert('监控系统名称重名啦！请重新添写！');
				return false;
			}
			
		},
		complete:function() {
			$("#xtmc").attr("xtmc", $("#xtmc").val());
			$("#jbxxLoadDiv").hide();
		},
		error:function() {
		}
	});	
}
function  selectedItem(rec){
	//alert(rec.sfgazj);
	var mgazj=rec.sfgazj;
	if(mgazj!="1"){
		mgazj="0";
	}
	checkGazj(mgazj);
	

	//var murl = '<%=basePath %>spjsdw/getGazjByDw?dwbm='+rec.dwbm;
	/*$.ajax({
		type:"POST",
		url:murl,
		dataType:"json",
		success:function(data) {
			var zj="";
			//alert("data[0]"+data[0]);
			if(data[0].gazj){zj=data[0].gazj;}
			else{zj="0";}
			alert(zj);
			$("#sfgazj").val(zj);
			checkGazj(zj);
			
		},
		complete:function() {
		},
		error:function() {
		}
	});	*/

}
function checkGazj(zj){
	
	//alert(zj);
	if(zj=="0"){
	setInputReadonly('idbm',true);
	setInputReadonly('sbcs',true);
	setInputReadonly('ptcs',true);
	setInputReadonly('lwsx',true);
	setInputReadonly('cswl',true);
	setInputReadonly('ipdz',true);
	setInputReadonly('ccip',true);
	}
	else{
	setInputReadonly('idbm',false);
	setInputReadonly('sbcs',false);
	setInputReadonly('ptcs',false);
	setInputReadonly('lwsx',false);
	setInputReadonly('cswl',false);
	setInputReadonly('ipdz',false);
	setInputReadonly('ccip',false);
	}
}


function checkXTmc() {
	var xtmc=$("#xtmc").val();
	var dwbm=$("#dwbm").val();
	//alert(dwmc);
	if(stringTrim(xtmc)==""){
		alert('系统名称不允许为空');	
		return -1;	
	}

	
	//$("#jbxxLoadDiv").show();//提示正在进行
	var mydata="";
	mydata={dwbm:dwbm,xtmc:xtmc};
	var retVal=-1;
	$.ajax({
		type:"POST",
		url:"<%=basePath%>spjkxt/checkSameName",
		dataType:"json",
		data:mydata,
		async:false,//强制同步		
		success:function(affectedRow) {
			/*
			if(data){
				alert('单位名称重名啦！请重新填写！');
				result=false;
			}
			else{
				result=true;
			}
			*/
			//alert("后台value:"+affectedRow);
			retVal=affectedRow;
		},
		error:function() {
			retVal= -1;
		}
	});	
	return retVal;
}
function checkKjGjTime(){
		var kjsj=$("#kjsj").val();	
		var gjsj=$("#gjsj").val();
		if(stringTrim(gjsj).length>1){
			if(stringTrim(kjsj).length<1){
				alert("开机时间不能为空！");
				return false;		
			}			
		}
		var kjDateTime=kjsj.split(':');
		var gjDateTime=gjsj.split(':');
		//alert(gjDateTime);
		var allKj=new Date(kjDateTime[0],kjDateTime[1]);
		var allGj=new Date(gjDateTime[0],gjDateTime[1]);
		if(allKj>allGj){
			alert('开机时间大于关机时间！请检查！');
			return false;
		}
}
//修改状态下，设置平台名称的显示值
function initPtmcDisplay(){
	pt_idValue=$('#pt_id').val();
	$('#pt_id').combobox('setValue',pt_idValue);
}
</script>
<script type="text/javascript">

</script>
</body>
</html>
