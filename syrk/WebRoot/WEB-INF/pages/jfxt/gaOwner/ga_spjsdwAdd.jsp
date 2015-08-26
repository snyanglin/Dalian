<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>新增(修改)视频建设单位</title>
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
    			<form action="<%=basePath%>spjsdw/save" id="spjsdwUpdateForm" name="spjsdwUpdateForm" method="post">
					<!-- 表示新增还是修改 -->
					<input type="hidden" name="dwbm" id="dwbm" value="${entity.dwbm}" />
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
				    	<td width="30%" class="dialogTd">
				    		<input type="hidden" name="dwmcOld" id="dwmcOld" value="${entity.dwmc}" />
				    		<input class='easyui-validatebox'   type='text' id="dwmc" name='dwmc' value="${entity.dwmc}" style="width:200px;"  maxlength="30"
		    	        	data-options="required:true"/><div class="lodingimg" id="jbxxLoadDiv"></div>
		    	        </td>
		    	         <td width="20%" class="dialogTd" align="right">是否公安自建：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-combobox'  type='text' id="sfgazj" name='sfgazj'  value="${entity.sfgazj}" style="width:200px;" 
		    	        		data-options="url: contextPath + '/common/dict/jfxt/D_JF_GAZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left',onSelect:checkGazj"/>
		    	        </td> 
	    	        
	    	      </tr>

  	      
		 		<tr class="dialogTr">
					    	<td width="20%" class="dialogTd" align="right">单位标准地址：</td>
					    	<td width="50%" class="dialogTd" colspan="2">
						    	<input class="easyui-combobox" onblur="alert('665')" id="jzrk_fzdz1" style="width:380px;" value="${entity.dz_dwmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type='hidden' name='dz_dwmlpdm' id="dz_dwmlpdm" value="${entity.dz_dwmlpdm}"/>
						    	<input type='hidden' name='dz_dwmlpxz' id="dz_dwmlpxz" value="${entity.dz_dwmlpxz}"/>
					    	</td>
					    	<td width="30%" class="dialogTd">
						    	<input class="easyui-combobox" id="jzrk_fzdz2" style="width:200px;" value="${fn:replace(entity.dz_dwdzxz, entity.dz_dwmlpxz, '')}"
						    		data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						    	<input type='hidden' name='dz_dwdzdm' id='dz_dwdzdm' value="${entity.dz_dwdzdm}" />
						    	<!-- 
						    	<input type='hidden' name='entity.dz_fzdzssxdm' id='jzrk_dz_fzdzssxdm' value="${entity.dz_dwdzdm}" />
						    	 -->
						    	<input type='hidden' name='dz_dwdzxz' id='dz_dwdzxz' value="${entity.dz_dwdzxz}" /> 
					    	</td>
		   	       </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">单位地址(全地址)：</td>
				    	<td width="70%" class="dialogTd" colspan="3">
				    		<input class='easyui-validatebox' type='text' id="dwdz" name='dwdz' value="${entity.dwdz}" style="width:96%;"  maxlength="130" onfocus="fillWithBzdz(this)"
		    	        	data-options="required:true"/><br>
		    	        	<span>全地址=标准地址+'/'+附加地址说明.例：辽宁省大连市甘井子区顺河巷6号<font color='#FF0000'>/</font>西100米</span>
		    	        </td>		    	        
	    	      </tr>	  		

	    	          	      
	    	      <tr class="dialogTr">
    	      
				    	<td width="20%" class="dialogTd" align="right">单位类型：</td>
				    	<td width="30%" class="dialogTd">
				    		<!-- 建设类别 -->
				    		<input  type="hidden" name="jslb" id="jslb"  value="${entity.jslb}">
		    	        	<input type="text" name="dwlx" id="dwlx" value="${entity.dwlx}" class="easyui-combotree "  style="width:200px;" 
								data-options="required:true,url: contextPath + '/common/dict/jfxt/D_JF_IndustryTree.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true,
								onSelect:selectDwlxChanged	 "/>
		    	        </td>
	    	      
	    	      </tr>	    	

	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">业主姓名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="yzxm" name='yzxm'  value="${entity.yzxm}" style="width:200px;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper'"/>
		    	        </td>
		    	        <td width="20%" class="dialogTd" align="right">业主身份证号：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="yzsfzh" name='yzsfzh'  value="${entity.yzsfzh}" style="width:200px;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/>
		    	        </td>       
	    	        
	    	      </tr>	
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">业主手机：</td>
				    	<td width="80%" colspan="3" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="yzphone" name='yzphone'  value="${entity.yzphone}" style="width:70%;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:['manyMobils']"/><span>多个号码之间用'/'分隔</span> 
		    	        </td>		    	      
	    	      </tr>    	      
	    	      
	    	      <tr class="dialogTr">

				    	<td width="20%" class="dialogTd" align="right">业主座机：</td>
				    	<td width="80%"  colspan="3" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="yzzj" name='yzzj'  value="${entity.yzzj}" style="width:70%;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:['manyPhones']"/><span>多个号码之间用'/'分隔</span> 
		    	        </td>
		    	 </tr>	  	    	      

		    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">选择单位：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input type='hidden' name='noPolice.dwbm' id="noPolice_dwbm" value="${entity.dwbm}"/>
			    	<input type='hidden' name='noPolice.dwmc' id="noPolice_dwmc" value="${entity.dwmc}"/>
			    	<input class="easyui-combobox" type="text" id="noPolice_dwmc-box" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" name="noPolice.dwmc-box" value="${entity.dwmc}" maxlength="50" style="width:595px;"/></td>
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
$(function(){

/*
	$("#dwmc").bind("blur",function(e){
		if(stringTrim($('#dwmc').val())!=""){
			checkDWmc();
		}
		
	});
*/
	//$('#spjsdwUpdateForm').form("disableValidation");//禁止校验
   //保存前验证，保存成功以后操作事件
	$('#spjsdwUpdateForm').form({  
        onSubmit:function(){
        	//alert("submit:"+$('#jslb').length);
        	var returnVal=checkDWmc();
        	//alert("returnVal:"+returnVal);
        	if(returnVal==-1){//错误
        		return false;//阻止提交
        	}
        	
        	var dwbm=$('#dwbm').val();
        	if(dwbm!=null && (dwbm!='undefined')){//修改状态
        		var dwmcOld=$('#dwmcOld').val();
        		var dwmc=$('#dwmc').val();
        		if(dwmcOld!=dwmc){//修改了原单位名称
        			if(returnVal>0){
        				alert('单位名称重名啦！请重新填写！');
        				return false;
        			}
        		}
        	}
        	else{//新增状态
        		if(returnVal>0){
        			alert('单位名称重复');
        			return false;
        		}
        	}
            return $(this).form('validate');//开始验证
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
		topMessager.confirm('操作确认', '您是否保存视频建设单位信息？',  function(r) {
			if (r) {
				$('#spjsdwUpdateForm').submit();//提交表单
			}
		});
	});
	//初始化标准地址
	//initAddressSearch('jzd1', {}, 'jbxx_dz_hjdmlpdm', 'jbxx_dz_hjdmlpxz', 'jbxx_hjd2', {text:'jbxx_dz_hjdzxz',dzxzqh:'jbxx_dz_hjdzssxdm',id:'jbxx_dz_hjdzdm'}, null, null);
	//initAddressSearch('jbxx_jzd1', {zrqdm:'${zrqdm}'}, 'jbxx_dz_jzdmlpdm', 'jbxx_dz_jzdmlpxz', 'jbxx_jzd2', {text:'jbxx_dz_jzdzxz',dzxzqh:'jbxx_dz_jzdzssxdm',id:'jbxx_dz_jzdzdm'}, 'jbxx_dz_jzdz_onSelected', 'jbxx_dz_jzdz_onSelected');
	//initAddressSearch('jzrk_fzdz1', {}, 'entity_dz_dwmlpdm', 'entity_dz_dwmlpxz', 'jzrk_fzdz2', {text:'entity_dz_dwdzxz',dzxzqh:'jzrk_dz_fzdzssxdm',id:'entity_dz_dwdzdm'}, null, null);//OK
	initAddressSearch('jzrk_fzdz1', {}, 'dz_dwmlpdm', 'dz_dwmlpxz', 'jzrk_fzdz2', {text:'dz_dwdzxz',dzxzqh:'jzrk_dz_fzdzssxdm',id:'dz_dwdzdm'}, null, null);
	//initAddressSearch('ldrk_fzdz1', {}, 'ldrk_dz_fzdzmlpdm', 'ldrk_dz_fzdzmlpxz', 'ldrk_fzdz2', {text:'ldrk_dz_fzdzxz',dzxzqh:'ldrk_dz_fzdzssxdm',id:'ldrk_dz_fzdzdm'}, null, null);
	//initAddressSearch('jwry_fzdz1', {}, 'jwry_dz_fzdzmlpdm', 'jwry_dz_fzdzmlpxz', 'jwry_fzdz2', {text:'jwry_dz_fzdzxz',dzxzqh:'jwry_dz_fzdzssxdm',id:'jwry_dz_fzdzdm'}, null, null);
	//initAddressSearch('wlczrk_fzdz1', {}, 'wlczrk_dz_fzdzmlpdm', 'wlczrk_dz_fzdzmlpxz', 'wlczrk_fzdz2', {text:'wlczrk_dz_fzdzxz',dzxzqh:'wlczrk_dz_fzdzssxdm',id:'wlczrk_dz_fzdzdm'}, null, null);
	//初始化单位
	initDepartmentSearch('noPolice_dwmc-box', {glpcsid: ''}, 'noPolice_dwbm', 'noPolice_dwmc', {});
	
});
//选择了新的单位类型
function selectDwlxChanged(record){
	//alert(record.id+","+record.text);
	$('#jslb').val(record.id.substring(0,2));
}
//选择了新的门楼牌
function selectDwmlpxzChanged(record){
	alert('here');
}

//用标准地址填充全地址
function fillWithBzdz(thisObj){
	thisObj.value=$('#dz_dwdzxz').val();
}



function jbxx_dz_jzdz_onSelected() {
	if (autoRklb == "") {
		autoGllb = true;
		autoSetRklb();
		valiRepeat();
	}
}

</script>


<script type="text/javascript" >

function doInsert(){
	var xh=$('#xh').val();
	alert('prepare save data '+xh);
}
//根据选择的"是否公安自建"修改相应的标签属性
function checkGazj(rec){
	var zj=(rec.id=='0')?true:false;
	//alert(zj);
	setRequired('yzxm',zj);
	setRequired('yzsfzh',zj);
	setRequired('yzphone',zj);
	setRequired('yzzj',zj);
		
	/*
	if(zj=="0"){
		setRequired('yzxm',true);
		setRequired('yzsfzh',true);
		setRequired('yzphone',true);
		setRequired('yzzj',true);
	}
	else{
		setRequired('yzxm',false);
		setRequired('yzsfzh',false);
		setRequired('yzphone',false);
		setRequired('yzzj',false);
	}
	*/
}

//设置是否为必录项 
function setRequired(tagId,isVerify){
	var options=$('#'+tagId).validatebox('options');
	options['required']=isVerify;
}

window.onload=function(){

	/*
	var mydwbm=$("#dwbm").val();
	if (mydwbm.length>0){
		setInputReadonly('sfgazj',true);
	}
	*/
	
	var zj=$("#sfgazj").val();
	var zj=(zj=='0')?true:false;	
	//alert(zj);
	setRequired('yzxm',zj);
	setRequired('yzsfzh',zj);
	setRequired('yzphone',zj);
	setRequired('yzzj',zj);	
	
	/*
	if(zj=="1"){
	setInputReadonly('yzxm',true);
	setInputReadonly('yzsfzh',true);
	setInputReadonly('yzphone',true);
	setInputReadonly('yzzj',true);
	}
	else
	{
	setInputReadonly('yzxm',false);
	setInputReadonly('yzsfzh',false);
	setInputReadonly('yzphone',false);
	setInputReadonly('yzzj',false);
	}
	*/	
	//var fatherLayout=parent.parent.document.getElementById("mainLayout");
	//alert(fatherLayout.className);
	//$(fatherLayout).layout('collapse','west');
	//var workPanel=fatherLayout.layout('panel','center');
	//workPanel.panel('setTitle','新增视频建设单位');
	
	//alert('initlized');
}

/**
 * 检查建设单位名称是否重名
 */
function checkDWmc() {
	var dwmc=$("#dwmc").val();
	//alert(dwmc);
	if(stringTrim(dwmc)==""){
		alert('单位名称不允许为空');	
		return -1;	
	}

	
	//$("#jbxxLoadDiv").show();//提示正在进行
	var mydata="";
	mydata={dwmc:dwmc};
	var retVal=-1;
	$.ajax({
		type:"POST",
		url:"<%=basePath%>spjsdw/checkSameName",
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
</script>

</body>
</html>
