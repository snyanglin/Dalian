<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>新增(修改)公安自建平台</title>
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
    			<form action="<%=basePath%>platform/save" id="platformAddUpdateForm" name="platformAddUpdateForm" method="post">
					<!-- 表示新增还是修改 -->
					<input type="hidden" name="id" id="id" value="${entity.id}" />
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">平台名称：</td>
				    	<td width="30%" class="dialogTd">
				    	
				    		<input type="hidden" name="ssorgcode" id="ssorgcode" value="${entity.ssorgcode}" />
				    		<input type="hidden" name="ptmcOld" id="ptmcOld" value="${entity.ptmc}" />
				    		<input class='easyui-combobox'  id="ptmc" name='ptmc'  value="${entity.ptmc}" style="width:200px;"  maxlength="50"
		    	        		data-options="required:true,valueField:'name',textField:'name',url: contextPath + '/idName/getPlatformByOrgCode' ,formatter:onlyDisplayText,onSelect:setSsOrgCode"/>
		    	        </td>
		    	        <td width="20%" class="dialogTd" align="right">平台厂商：</td>
				    	<td width="30%" class="dialogTd">
				    	<input class='easyui-combobox'  id="ptcs" name='ptcs'  value="${entity.ptcs}" style="width:200px;"  maxlength="50"
		    	        		data-options="valueField:'id',textField:'text',url: contextPath + '/common/dict/jfxt/D_JF_SLPTCS.js'  "/>
		    	        </td> 	    	        
	    	      </tr>

	    	      <tr class="dialogTr">
		    	        	    	      
		    	        <td width="20%" class="dialogTd" align="right">中心服务器IP：</td>
				    	<td width="30%" class="dialogTd">
							<input type="text" name="zxfwqIp" id="zxfwqIp" class="easyui-validatebox"  value="${entity.zxfwqIp}" style="width: 200px;" 
								data-options="required:true,validType:['ip']"/>
		    	        </td> 
		    	        	    	      
		    	        <td width="20%" class="dialogTd" align="right">中心服务器端口号：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="zxfwqDkh" name='zxfwqDkh'  value="${entity.zxfwqDkh}" style="width:200px;" 
		    	        		data-options="required:true,validType:['numeric']" maxlength="4"/>
		    	        </td> 	    	      
	    	      </tr>	  	      
	    	      <tr class="dialogTr">
    	      
				    	<td width="20%" class="dialogTd" align="right">传输网络类型：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-combobox'  id="cswlLx" name='cswlLx'  value="${entity.cswlLx}" style="width:200px;"  maxlength="50"
		    	        		data-options="valueField:'id',textField:'text',url: contextPath + '/common/dict/jfxt/D_JF_CSWLLX.js',filterSet:[1,2],loadFilter:myFilter "/>
		    	        </td>
	    	      
	    	      </tr>	    	

	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">运维管理人员姓名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="ywglryXm" name='ywglryXm'  value="${entity.ywglryXm}" style="width:200px;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper'"/>
		    	        </td>
	    	      </tr>	
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">运维管理人员座机：</td>
				    	<td width="80%" colspan="3" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="ywglryTele" name='ywglryTele'  value="${entity.ywglryTele}" style="width:70%;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:['manyPhones']"/><span>多个号码之间用'/'分隔</span> 
		    	        </td>		    	      
	    	      </tr>    	      
	    	      
	    	      <tr class="dialogTr">

				    	<td width="20%" class="dialogTd" align="right">运维管理人员手机：</td>
				    	<td width="80%"  colspan="3" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="ywglryMobile" name='ywglryMobile'  value="${entity.ywglryMobile}" style="width:70%;"  maxlength="50"
		    	        		data-options="required:true,charSet:'halfUpper',validType:['manyMobils']"/><span>多个号码之间用'/'分隔</span> 
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
$(function(){

	//$('#platformAddUpdateForm').form("disableValidation");//禁止校验
   //保存前验证，保存成功以后操作事件
	$('#platformAddUpdateForm').form({  
        onSubmit:function(){
        	//检查平台名称是否全局唯一
        	var url=contextPath+"/platform/isUniqueForPlatformName";
        	var ptmc=$('#ptmc').val();
        	var params={'ptmc':ptmc};
        	//alert(url);
        	var retVal=getResponseByParameter(url,params);//encodeURIComponent(ptmc)
        	//alert(retVal);
        	if(!$('#id').val()){//新增
        		if(retVal>0){
        			alert('平台名称已存在');
        			return false;
        		}
        	}
        	else{//修改
        		//alert('修改'+params['ptmc']);
        		var ptmcOld=$('#ptmcOld').val();        		
        		if(ptmcOld!=ptmc){//修改了平台名称
        			if(retVal>0){
        				alert('平台名称重名啦！请重新填写！');
        				return false;
        			}
        		}     		
        	}
            return $(this).form('validate');//开始验证
        },  
        success:function(data){
            var json = $.parseJSON(data);
            if(json.status == 'success'){
          	    //保存成功后跳转到欢迎页面
          	    var url = contextPath+"/forward/jfxt|gaOwner|ga_welcome";
          	    parent.document.getElementById("mainAreaId").src = url;
             }else{
            	topMessagerAlert(null,json.message);
            }
        }  
    });
    //保存按钮绑定点击事件【注意：这里保存时候可以添加重复数据，是否要条件验证？】  
	$('#saveButton').click(function(){
		topMessager.confirm('操作确认', '您是否保存平台信息？',  function(r) {
			if (r) {
				$('#platformAddUpdateForm').submit();//提交表单
			}
		});
	});
	//初始化标准地址
	//initAddressSearch('jzrk_fzdz1', {}, 'dz_dwmlpdm', 'dz_dwmlpxz', 'jzrk_fzdz2', {text:'dz_dwdzxz',dzxzqh:'jzrk_dz_fzdzssxdm',id:'dz_dwdzdm'}, null, null);
	
	
});
//选择了新的单位类型
function selectDwlxChanged(record){
	//alert(record.id+","+record.text);
	$('#jslb').val(record.id.substring(0,2));
}
//选择了新的门楼牌
//function selectDwmlpxzChanged(record){
//	alert('here');
//}

//用标准地址填充全地址
//function fillWithBzdz(thisObj){
//	thisObj.value=$('#dz_dwdzxz').val();
//}



//function jbxx_dz_jzdz_onSelected() {
//	if (autoRklb == "") {
//		autoGllb = true;
//		autoSetRklb();
//		valiRepeat();
//	}
//}
//获得字典子集.
//要求：在需要过滤的combobox的data-options属性中添加子属性：1.filterSet。例如 filterSet:[2,4]
		//2.loadFilter:myFilter
	function myFilter(data){
			//var opts=$('#myComboBox').combobox('options');//
			var opts=$(this).combobox('options');//
			var valueName=opts['valueField'];
			var filterSet=opts.filterSet;//过滤数组
			//alert(filterSet.length+','+valueName);
			var resultSet=[];
			for(var i=0;i<data.length;i++){
				var theItem=data[i];
				var bFound=false;
				for(var j=0;j<filterSet.length;j++){
					if(theItem[valueName]==filterSet[j]){
						bFound=true;
						break;
					}
				}
				
				if(bFound){	
					resultSet.push(theItem);
				}
			
			}
			return resultSet;

		}


</script>


<script type="text/javascript" >
function onlyDisplayText(row) {
	var opts = $(this).combobox('options');
	return row[opts.valueField];
}
//选择了平台名称，设置其对应的隐藏域ssOrgCode
function setSsOrgCode(rowSet){
	$('#ssorgcode').val(rowSet.id);
	//alert(rowSet.id);
}



function getResponseByParameter22(urlRequest,params) {
	var meaning="";
    $.ajax({
        url:urlRequest, 
        data:params,
        cache : false, 
        async : false,//异步
        type : "POST",
        dataType : 'json',
        success : function(data){
           	alert(data);
        	meaning=data;
        },
        error:function(e){
        	meaning="";
        }
    });
	
	return meaning;

}
</script>

</body>
</html>
