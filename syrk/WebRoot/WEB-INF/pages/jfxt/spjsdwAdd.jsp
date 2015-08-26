<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>新增(修改)视频建设单位</title>
<script type="text/javascript" src="<%=contextPath%>/common/dict/jfxt/js/codetranslate.js"></script>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
 <%
 SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
 String ssPcsID=userInfo.getExtendValue("ssPcsCode");//所属派出所ID
 System.out.println("ssPcsID=="+ssPcsID);
 %>
<body style="margin-top:20px" class="bodybg">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    			<form action="<%=basePath%>spjsdw/save" id="spjsdwAddUpdateForm" name="spjsdwUpdateForm" method="post">
					<!-- id为空:表示新增,否则表示修改  -->
					<input type="hidden" name="id" id="id" value="${entity.id}" />
					<!-- 社会视频资源   -->
					<input type="hidden" name="sfgazj" id="sfgazj" value="0" />

	    	      
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">视频单位名称：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<!-- 提交字段 -->
			    	<input type='hidden' name='dwbmOld' id="dwbmOld" value="${entity.dwbm}"/>
			    	<input type='hidden' name='dwbm' id="dwbm" value="${entity.dwbm}"/>
			    	<input type='hidden' name='dwmc' id="dwmc" value="${entity.dwmc}"/>
			    	<input class="easyui-combobox" data-options="required:true,editable:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" name="spdw-box" id="spdw-box" value="${entity.dwmc}" maxlength="50"  style="width:595px;" /></td>
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

	$('#spjsdwAddUpdateForm').form({  
        onSubmit:function(){
        	//检查单位是否选择
        	var dwbm=$('#dwbm').val();
        	if(dwbm.length!=32){
        		alert("单位必须选择");
        		return false;        	
        	}        	
        	//检查视频建设单位是否全局唯一
        	var isUnique=isUniqueForSpjsdw(dwbm);
        	if(!isUnique){
        		return false;//阻止提交
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
				$('#spjsdwAddUpdateForm').submit();//提交表单
			}
		});
	});
	//初始化单位
	//initDepartmentSearch('spdw-box', {glpcsid: ''}, 'dwbm', 'dwmc', {});
	initDepartmentSearch('spdw-box', {glpcsid: '<%=ssPcsID%>'}, 'dwbm', 'dwmc', {});
	
});
//选择了新的单位类型,更新大类(建设类别)
function selectDwlxChanged(record){
	//alert(record.id+","+record.text);
	$('#jslb').val(record.id.substring(0,2));
}
//检查视频建设单位是否全局唯一
function isUniqueForSpjsdw(dwbm){

     	var url=contextPath+"/spjsdw/isUniqueForSpjsdw";        	
     	var params={'dwbm':dwbm};
     	//alert(params['ptmc']);
     	var retVal=getResponseByParameter(url,params);//encodeURIComponent(ptmc)
     	//alert(retVal);
     	if(!$('#id').val()){//新增
     		if(retVal>0){
     			alert('单位名称已存在');
     			return false;
     		}
     	}
     	else{//修改
     		//alert('修改'+params['dwbm']);
     		var dwbmOld=$('#dwbmOld').val();        		
     		if(dwbmOld!=dwbm){//修改了单位名称
     			if(retVal>0){
     				alert('单位名称重名啦！请重新填写！');
     				return false;
     			}
     		}     		
     	}
		return true;
}
</script>


<script type="text/javascript" >



window.onload=function(){

	//alert('PCDID:'+'<%=ssPcsID%>');
	
}


</script>

</body>
</html>
