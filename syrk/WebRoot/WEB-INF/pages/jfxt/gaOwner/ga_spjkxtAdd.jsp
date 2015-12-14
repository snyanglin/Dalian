<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>新增(修改)视频监控系统</title>
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
    			<form action="<%=basePath%>spjkxt/save" id="spjkxtUpdateForm" name="spjkxtUpdateForm" method="post">
					<!-- 表示新增还是修改 -->
					<input type="hidden" name="xh" id="xh" value="${entity.xh}" />
	    	      <tr class="dialogTr">
	    	      <td width="20%" class="dialogTd" align="right">所属视频建设单位：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-combobox' type='text' id="dwbm" name='dwbm' value="${entity.dwbm}" style="width:200px;"  maxlength="30"
		    	        	data-options="url:'<%=basePath %>spjsdw/queryByPcsPoliceId?curTime='+(new Date()).getTime(),textField:'dwmc',valueField:'dwbm',required:true,onSelect: selectedItem"/>
		    	        	
		    	        </td>
	    	      
				    	
				    	<td width="20%" class="dialogTd" align="right">视频监控系统名称：</td>
				    	<input type="hidden" name="xtmcOld" id="xtmcOld" value="${entity.xtmc}" />
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="xtmc" name='xtmc' value="${entity.xtmc}" style="width:200px;"  maxlength="30"
		    	        	data-options="required:true"/><div class="lodingimg" id="jbxxLoadDiv"></div>
		    	        </td>		    	        
	    	      </tr>
	    	      
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">用户名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="xtyhm" name='xtyhm' value="${entity.xtyhm}"  style="width:200px;"  maxlength="20"
		    	        		data-options="required:true"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">系统密码：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="xtmm" name='xtmm'  value="${entity.xtmm}" style="width:200px;"  maxlength="50"
		    	        		data-options="required:true"/>
		    	        </td>	    	      
	    	      
	    	      </tr>

	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">录像最大保存天数：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="ccsc" name='ccsc'  value="${entity.ccsc}" style="width:200px;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:'naturalNumberRange[1,1000]'"/>
		    	        </td>	    	      
				    	<td width="20%" class="dialogTd" align="right">建设时间：</td>
				    	<td width="30%" class="dialogTd">
						<input type="text" name="jssj" id="jssj" value="${entity.jssj}" class="easyui-validatebox "   style="width:200px;"
							data-options="required:false,tipPosition:'right',validType:['date[\'yyyy-MM-dd HH:mm\']']"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})" /></td>
		    	        </td>	    	      
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">开机时间：</td>
				    	<td>
							<input type="text" name="kjsj" id="kjsj" value="${entity.kjsj}" class="easyui-timespinner "   style="width:200px;" 
							data-options="value:'08:30',required:false,validType:['date[\'HH:mm\']']"   /></td>
						</td>
				    	<td width="20%" class="dialogTd" align="right">关机时间：</td>
				    	<td>
							<input type="text" name="gjsj" id="gjsj" value="${entity.gjsj}" class="easyui-timespinner "   style="width:200px;" 
							data-options="value:'19:30',required:false,tipPosition:'right',validType:['date[\'HH:mm\']']"  /></td>
						</td>						
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">技术人员姓名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="jsryxm" name='jsryxm'  value="${entity.jsryxm}" style="width:200px;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper'"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">技术人员身份证号：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="jsrysfzh" name='jsrysfzh'  value="${entity.jsrysfzh}" style="width:200px;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/>
		    	        </td>		    	        
	    	      </tr>	    	      
	    	      
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">技术人员手机：</td>
				    	<td width="80%" colspan="3" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="jsryphone" name='jsryphone'  value="${entity.jsryphone}" style="width:70%;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:['manyMobils']"/><span>多个号码之间用'/'分隔</span>
		    	        </td>
	    	        
	    	      </tr>	  	    	      
	    	      <tr class="dialogTr">

				    	<td width="20%" class="dialogTd" align="right">技术人员座机：</td>
				    	<td  width="80%" colspan="3"  class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="jsryzj" name='jsryzj'  value="${entity.jsryzj}" style="width:70%;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:['manyPhones']"/><span>多个号码之间用'/'分隔</span>
		    	        </td>		    	        
	    	      </tr>	  	    
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">拷贝方式：</td>
				    	<td width="80%" colspan="3" class="dialogTd">
				    		<input type="hidden" id="copyfsFromDB" name="copyfsFromDB" value="${entity.copyfs}">
							<input type="checkbox" name="copyfs" value="U盘" id="copyfs1">U盘
							<input type="checkbox" name="copyfs"  value="移动硬盘" id="ydyp">移动硬盘
							<input type="checkbox" name="copyfs"  value="拆机拷贝" id="cjkb">拆机拷贝
							<input type="checkbox" name="copyfs"  value="网络下载" id="wlxz">网络下载
							<input type="checkbox" name="copyfs"  value="其它" id="qita">其它
							
		    	        </td>		    	        
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">平台ID：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="idbm" name='idbm'  value="${entity.idbm}" style="width:200px;"  maxlength="20"
		    	        		data-options="required:true,charSet:'halfUpper'"/>
		    	        </td>
				  
				 </tr>	
				 <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">所连平台厂商：</td>
				    	<td><input class='easyui-combobox'  id="ptcs" name='ptcs'  value="${entity.ptcs}" style="width:200px;"  maxlength="50"
		    	        		data-options="valueField:'id',textField:'text',url: contextPath + '/common/dict/jfxt/D_JF_SLPTCS.js'"/>
		    	        </td>	    	      
				    	<td width="20%" class="dialogTd" align="right">联网属性：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-combobox'  id="lwsx" name='lwsx'  value="${entity.lwsx}" style="width:200px;"  maxlength="50"
		    	        		data-options="valueField:'id',textField:'text',url: contextPath + '/common/dict/jfxt/connectNet.js'"/>
		    	        </td>	    	      
	    	      </tr>	 
	    	      
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">传输网络类型：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-combobox'  id="cswl" name='cswl'  value="${entity.cswl}" style="width:200px;"  maxlength="50"
		    	        		data-options="valueField:'id',textField:'text',url: contextPath + '/common/dict/jfxt/transferNet.js'"/>
		    	        </td>	    	      
				    	<td width="20%" class="dialogTd" align="right">平台IP：</td>
				    	<td width="30%" class="dialogTd">
							<input type="text" name="ipdz" id="ipdz" class="easyui-validatebox"  value="${entity.ipdz}" style="width: 200px;" 
								data-options="validType:['ip']"/>
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
	
	$("#xtmc").bind("blur",function(e){	
	
		checkXTmc();//检查系统名称是否重名
	});
	//$('#spjkxtUpdateForm').form("disableValidation");//禁止校验
   //保存前验证，保存成功以后操作事件

	checkCount();//检查用户当前是否已经创建过建设单位
	$('#spjkxtUpdateForm').form({  
        onSubmit:function(){
        	var rkjgj=checkKjGjTime();//检查开关机时间
        	if(rkjgj==false){
        		return false;
        	}
        	var returnVal=checkXTmc();
        	if(returnVal==-1){//错误
        		return false;//阻止提交
        	}
        	var result=checkCopyfs();
        	if(!result){
        		alert("拷贝方式不能为空！");
        		return false;//阻止提交
        	}
        	var xtmc=$('#xtmc').val();
        	if(xtmc!=null && (xtmc!='undefined')){//修改状态
        		var xtmcOld=$('#xtmcOld').val();
        		var xtmc=$('#xtmc').val();
        		if(xtmcOld!=xtmc){//修改了原单位名称
        			if(returnVal>0){
        				alert('系统名称重名啦！请重新填写！');
        				return false;
        			}
        		}
        	}
        	else{//新增状态
        		if(returnVal>0){
        			alert('系统名称重复');
        			return false;
        		}
        	}
        	
        	
        	
            return $(this).form('validate');  
        },  
        success:function(data){
            var json = $.parseJSON(data);
            if(json.status == 'success'){
          	    //保存成功后跳转到欢迎页面
          	    var url = contextPath+"/forward/jfxt|welcome";
          	    parent.document.getElementById("mainAreaId").src = url;
             }else{
            	topMessagerAlert(null,json.message);
            }
        }  
    });
    //保存按钮绑定点击事件【注意：这里保存时候可以添加重复数据，是否要条件验证？】  
	$('#saveButton').click(function(){
		topMessager.confirm('操作确认', '您是否保存视频监控系统？',  function(r) {
			if (r) {
				$('#spjkxtUpdateForm').submit();
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
</script>
<script type="text/javascript">

</script>
</body>
</html>
