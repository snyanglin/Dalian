<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>修改视频摄像头</title>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
<style type="text/css">
	.hr1{border:2px solid #82C4FE;width:100%; height:2px;}
	.gaTable_c{background:#DC4D22; border:0px solid #72BA9D;} 
</style>
<script type="text/javascript" src="<%=contextPath%>/common/jfxt/yysxShow.js"></script>
</head>
  
<body style="margin-top:20px" class="bodybg">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    			<form action="<%=basePath%>sptgl/save" id="sxtAddForm" name="sxtAddForm" method="post">
	    	    <input type="hidden" id="id" name="id" value="${entity.id}"/>
  		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
  		<tr class="dialogTr">
  			<td width="20%" class="dialogTd" align="right">摄像头条码：</td>
	    	<td width="30%" class="dialogTd"><input type="text" id="tm" name="tm" value="${entity.tm }" class="easyui-validatebox  inputreadonly" style="width:200px;"
	    		 readonly="readonly"/></td>
	    	<td width="20%" class="dialogTd" align="right">所属公安机构：</td>
	    	<td width="30%" class="dialogTd"><input type="text" id="ssjgdm" name="ssjgdm" class="inputReadonly" style="width:200px;"
	    		/></td>
  		</tr>
  		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">视频建设单位：</td>
	    	<td width="30%" class="dialogTd">
				    		<input class='easyui-combobox' type='text' id="dwbm" name='dwbm' value="${entity.dwbm }" style="width:200px;"  maxlength="30"
		    	        	data-options="url:'<%=basePath %>sptgl/getSpsxtJsdw?curTime='+(new Date()).getTime(),textField:'dwmc',valueField:'dwbm',required:true, onSelect: selectedItem"/></td>
	    	
            <td width="20%" class="dialogTd" align="right">视频监控系统：</td>
	    	<td width="30%" class="dialogTd">
	    					<input class="easyui-combobox" type='text' name="jkxt" id="jkxt" value="${entity.jkxt }" style="width:200px;"
	    					 data-options="required:true,  valueField:'jkxt',textField:'xtmc'" ></td>
		</tr>
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">管理部门：</td>
			<td width="30%" class="dialogTd" colspan="2">
				<input type="hidden" id="sxtgldw" name="sxtgldw" value="${entity.sxtgldw}"/>
				<input type="text" name="sxtgldwstr" id="sxtgldwstr"  class="easyui-validatebox" style="width:370px;"
    		    data-options="required:true" maxlength="200"  />
    		    <input type="hidden" id="orgid1" name="orgid1" value="" style="width: 100;" />
    		</tr><td>
    		    <input type="button" id="orgbutton1" value="选择管理部门" onClick="public_singleSelectOrg('', '01', '', '', 'sxtgldw', 'sxtgldwstr', 'orgid1', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 100px;font-family:宋体;font-size:9pt;" />
			</td>
		</tr>
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">所在社区：</td>
			<td width="30%" class="dialogTd">
				<input class='easyui-combobox' type='text' name="sszrq" id="sszrq"	value="${entity.sszrq }" style="width:200px;" 
   	        	data-options="url:'<%=basePath %>sptgl/getSxtZrq',textField:'orgName',valueField:'orgCode',required:true"/>
		    </td>

	    	<td width="20%" class="dialogTd" align="right">所在区域：</td>
	    	<td width="30%" class="dialogTd">
				    		<input class='easyui-combobox' type='text' id="dlqy" name='dlqy' value="${entity.dlqy }" style="width:200px;"  maxlength="30"
		    	        	data-options="url:'<%=basePath %>sptgl/getSzdlqy?curTime='+(new Date()).getTime(),textField:'meaning',valueField:'code',required:true"/></td>
	    	
	    </tr>
	        <tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">安装部位：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="azbw" id="azbw"  value="${entity.azbw }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">照片详情：</td>
	    	<td><input type="hidden" name="pic_location" id="pic_location"  value="${entity.pic_location }" />
		    <img src ="<%=contextPath%>/images/onebit_38.png" style="cursor: pointer;height:32px" onclick="showPic();"/>
			</td>
				    		
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">经度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jd" id="jd"  value="${entity.jd }" class="easyui-validatebox" style="width:200px;"
    		    readonly="readonly" data-options="required:true" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">纬度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="wd" id="wd"  value="${entity.wd }" class="easyui-validatebox" style="width:200px;"
    		    readonly="readonly" data-options="required:true" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">朝向：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="cx" id="cx"  value="${entity.cx }" class="easyui-validatebox" style="width:200px;"
    		    readonly="readonly" data-options="required:true" maxlength="20"  />
	    	</td><td width="20%" class="dialogTd" align="right">监控角度：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jkjd" id="jkjd"  value="${entity.jkjd }" class="easyui-validatebox" style="width:200px;"
    		    readonly="readonly" data-options="required:true" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">固定可动：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="sb_gd" name='sb_gd' value="${entity.sb_gd}" style="width:200px;" 
		    	                data-options="url: contextPath + '/common/dict/jfxt/D_JF_GD.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td> 
	    	 
    		<td width="20%" class="dialogTd" align="right">枪机球机：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="sb_qjqj" name='sb_qjqj' value="${entity.sb_qjqj}" style="width:200px;" 
		    	                data-options="url: contextPath + '/common/dict/jfxt/D_JF_QJQJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td> 
	    	 
	    </tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">室内室外：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combobox' type='text' id="sb_snsw" name='sb_snsw' value="${entity.sb_snsw}" style="width:200px;" 
		    	                data-options="url: contextPath + '/common/dict/jfxt/D_JF_SNSW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td> 
	    	      
	    	<td width="20%" class="dialogTd" align="right">夜视非夜视：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combotree' type='text' id="sbyssx" name='sbyssx' value="${entity.sbyssx}" style="width:200px;"
	    	 					data-options="url: contextPath + '/common/dict/jfxt/D_JF_SighTree.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:200,method:'get',editable:true,lines:true,required:true"></td>
	    	
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">标清高清：</td>
	    	<td width="30%" class="dialogTd"><input class='easyui-combotree' type='text' id="sbgqsx" name='sbgqsx' value="${entity.sbgqsx}" style="width:200px;"
	    	 					data-options="url: contextPath + '/common/dict/jfxt/D_JF_ResolutionTree.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:200,method:'get',editable:true,lines:true,required:true"></td>
	    	
	    
	      	<td width="20%" class="dialogTd" align="right">应用属性：</td>
	    	<td width="30%" class="dialogTd">
	    		<!-- 实际的应用属性  -->
	    		<input type="hidden" id="yysx" name="yysx"  value="${entity.yysx}" >
	    		<input class='easyui-combotree' id="yysx_xs" name='yysx_xs'  value="${entity.yysx_xs}"  style="width:200px;"
	    	 	data-options="url: contextPath + '/common/dict/jfxt/D_JF_PropertyTree.js',onlyLeafCheck:true,dataFilter:'',multiple:true,panelWidth:200,method:'get',editable:true,lines:true,required:true,onBeforeCheck:beforeCheckComboTree"></td>
	    		<span id="beforeId"></span>
	    	</td>  	
	     </tr>
	     </table>
	     <hr class="hr1">
		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" id="gazjTable">
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">点位名称：</td>
	    	<td width="30%" class="dialogTd">
	    	<input type="hidden" name="dwmcOld" id="dwmcOld" value="${entity.dwmc}" />
	    	<input type="text" name="dwmc" id="dwmc"  value="${entity.dwmc }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper'" maxlength="20"  />
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">点位俗称：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="dwsc" id="dwsc"  value="${entity.dwsc }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper'" maxlength="20"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">点位高度(米)：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="dwgd" id="dwgd"  value="${entity.dwgd }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper',validType:['numeric']" maxlength="4"  />
	    	</td><td width="20%" class="dialogTd" align="right">关联点位数量(个)：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="gldw" id="gldw"  value="${entity.gldw }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper',validType:['numeric']" maxlength="4"  />
	    	</td>
	    </tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">镜头变焦倍数：</td>
	    	<td width="30%" class="dialogTd"><input type="text" name="jtbs" id="jtbs"  value="${entity.jtbs }" class="easyui-validatebox" style="width:200px;"
    		    data-options="required:true,charSet:'halfUpper',validType:['numeric']" maxlength="4"  />
	    	</td>
	    </tr>
   </table>
	    	    <div style="height:1px;font-size:1px;"></div>
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 5px; display:block;">
			<a id="saveButton"  class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;
			<a id="backBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="exitOnclick()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">后退</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
		</div>
	    </table>	    
</div>

<script type="text/javascript">
$(function(){
	public_getOrgName('sxtgldw', 'sxtgldwstr');
	$('#sxtAddForm').form({  
        onSubmit:function(){
        	var returnVal=checksxtDWmc();//检查点位名称是否重名
        	if(returnVal==-1){//错误
        		return false;//阻止提交
        	}
        	
        	var dwmcOld=$('#dwmcOld').val();
        	var dwmc=$('#dwmc').val();
        	if(dwmcOld!=dwmc){//修改了原单位名称
        		if(returnVal>0){
        			alert('点位名称重名啦！请重新填写！');
        			return false;
        		}
        	}
        	
        	
        	//获得下拉tree中选取的所有值
			var selectedValue=getComboTreeValue();
			//$('#yysx_xs').val(selectedValue);//写应用属性显示值
        	//计算应用属性字段的值        	
        	var appProperty=comboProperty(selectedValue);
        	$('#yysx').val(appProperty);//写应用属性值
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status == 'success'){
          	    //保存成功后跳转到列表列表页面（这里也可以添加一些其他页面流程）
          	    var url = contextPath+"/forward/jfxt|spsxtList";
          	    parent.document.getElementById("mainAreaId").src = url;
            }else{
            	topMessagerAlert(null,json.message);
            }
        }  
    });   
	
	$('#saveButton').click(function(){
		//getSelectedProperty();			
		topMessager.confirm('操作确认', '您是否保存摄像头信息？',  function(r) {
			if (r) {
				$('#sxtAddForm').submit();
			}
		});
	});	
});
function exitOnclick(){
    //后退到列表
    var url = contextPath+"/forward/jfxt|spsxtList";
    parent.document.getElementById("mainAreaId").src = url;
} 
function  selectedItem(rec){
	var url = '<%=basePath %>sptgl/getSpjkxtByDw?curTime='+(new Date()).getTime()+'&dwbm='+rec.dwbm;
	//alert(rec.dwbm); 
	$('#jkxt').combobox('reload', url);
	var mgazj=rec.sfgazj;

	checkGazj(mgazj);
}

window.onload=function(){
	getSsjgdmName();
	var mydwbm=$('#dwbm').val();
	//alert(mydwbm);
	var url = '<%=basePath %>sptgl/getSpjkxtByDw?dwbm='+mydwbm;
	$('#jkxt').combobox('reload', url);
	//getComboTreeValue();
	modifycheckGazj();
}
function modifycheckGazj(){
	var opt=$('#dwbm').combobox('options');
	var data=$('#dwbm').combobox('getData');
	var mdwbm=$('#dwbm').val();
	var mzj="";
	for(var i=0;i<data.length;i++){
		if(data[i][opt.valueField]==mdwbm){
		//alert(data[i][opt.valueField]+','+data[i][opt.textField]);
		//alert(data[i]['sfgazj']);
			mzj=data[i]['sfgazj'];
			break;
		}
	}
	checkGazj(mzj);	
}

	//获得选择的应用属性
	function getSelectedProperty(){
		var selectedProperty="";//保存选择的结果
		//alert('hhhhh');
		var cbObject=document.getElementsByName('yysxCB');
		for(var i=0;i<cbObject.length;i++){
			if(cbObject[i].checked){//被选择
				selectedProperty+="1";
			}
			else{
				selectedProperty+="0";
			}
			
		}
		//alert("选择的内容:"+selectedProperty);
		//可将此值写入隐藏域中，以便提交到后台处理	
		$('#yysx').val(selectedProperty);
		//alert($('#yysx').val());	
	}
	function setProperty(){
		var currentState=$('#yysx').val();
		var stateLength=currentState.length;
		var cbObject=document.getElementsByName('yysxCB');
		for(var i=0;i<stateLength;i++){
			//alert(currentState.substr(i,1));
			if(currentState.substr(i,1)=="1"){			
				cbObject[i].checked=true;
			}
			else{
				cbObject[i].checked=false;
				
			}
		}
	}	
function checkGazj(zjO){
var zj=(zjO=='1')?true:false;
	//alert(zj);
	setRequired('dwmc',zj);
	setRequired('dwsc',zj);
	setRequired('dwgd',zj);
	setRequired('gldw',zj);
	setRequired('jtbs',zj);
	if(zjO=="0"){
		document.getElementById("gazjTable").className='gaTable_c';
	}
	else{document.getElementById("gazjTable").className='';}
}

//设置是否为必录项 
function setRequired(tagId,isVerify){
	var options=$('#'+tagId).validatebox('options');
	options['required']=isVerify;
}
function showPic(){
	var pic_l=$("#pic_location").val();
    var hsUrl = "/sptgl/showPicJsp?";
	hsUrl+="path="+pic_l;
	menu_open("摄像头照片",hsUrl);
}

function checksxtDWmc(){
	var dwmc=$("#dwmc").val();
	//alert(dwmc);
	if(stringTrim(dwmc)==""){
		alert('点位名称不允许为空');	
		return -1;	
	}
	var mydata="";
	mydata={dwmc:dwmc};
	var retVal=-1;
	$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/checkSameName",
		dataType:"json",
		data:mydata,
		async:false,//强制同步		
		success:function(affectedRow) {
			retVal=affectedRow;
		},
		error:function() {
			retVal= -1;
		}
	});	
	return retVal;
}


function getSsjgdmName(){

$.ajax({
		type:"POST",
		url:"<%=basePath%>sptgl/getSsjgdmName",
		dataType:"json",
		success:function(data) {
		//alert(data.ORGNAME);
			$("#ssjgdm").val(data.ORGNAME);
		},
		complete:function() {
		},
		error:function() {
		}
	});

}
</script>
<script type="text/javascript">

//重写内部下拉树
	function beforeCheckComboTree(node,checked){
			//alert(node.text+","+checked);
			var t = $('#yysx_xs').combotree('tree');	// 获取树对象
			//var n = t.tree('getSelected');

			var rootNode=t.tree('getRoot');//根节点
			var parentNode=t.tree('getParent',node.target);
			if(parentNode==null)
				return false;
			if(parentNode==rootNode)
				return true;
			var childrenNode=t.tree('getChildren',parentNode.target);
			var childCount=childrenNode.length;//儿子数
			//alert(parentNode.text+",children:"+childCount);
			//alert("childCount:"+childrenNode.length);
			for(var i=0;i<childCount;i++){
				var currentNode=childrenNode[i];
				if(currentNode!=node){
					//currentNode.checked='checked';
					//取消选中状态					
					t.tree('update', {
						target: currentNode.target,
						checked: false
					});
				}//end if
			}//end for
	}					

var propertyArray=[
['1001'],
['1401'],
['2301'],
['2201','2202','2203'],
['1604'],
['2901'],
['1801','1802','1803'],
['2403'],
['2101','2102'],
['2302'],
['00000'],
['00000']
];

//根据选择的应用属性组合为省厅要求的应用属性
function comboProperty(selectedAttr){
	var result="";
	for(var i=0;i<propertyArray.length;i++){
		var bFound=false;
		for(var j=0;j<propertyArray[i].length;j++){
			var theItem=propertyArray[i][j];
			if(selectedAttr.indexOf(theItem)>-1){
				bFound=true;
				break;
			}
		}//end for(j)
		result+=bFound?'1':'0';
	}//end for(i)
	return result;
}

	//获得下拉tree中检取的所有值
	function getComboTreeValue(){
		var selectedValue = $('#yysx_xs').combotree('getValues');
		var result=selectedValue.join(',');
		alert("selectedValue="+result);
		return 	result;
			
	}
	
//alert(comboProperty('2701,2801,2905'));
</script>
</body>
</html>
