<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员列撤管</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action=""  id="dataForm" name="dataForm" method="post" enctype="multipart/form-data" >
    	<input type="text" id="syrkid" name="zdryZdryzb.syrkid" value="${zdryZdryzbVO.syrkid}" />
    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdryZdryzbVO.id}" />
    	<input type="hidden" id="zdryLczywblb.ywblr_id" name="zdryLczywblb.ywblr_id" value="${ywblr_id}" />
    	<input type="hidden" id="zdryHsbId" name="zdryHsbId" value="${zdryHsbId}" />

	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="${zdryZdryzbVO.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" style="width:200px;" readonly="readonly" value="${zdryZdryzbVO.zjhm}"/></td>
		    </tr>
		     <c:if test="${ displayStr != null && displayStr != ''}">
		       <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">已列管类型：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		${displayStr}
		    	</td>
		    </tr>
		    </c:if>
		    <c:if test="${ ywlx == 2}">
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">撤管类型：</td>
		    	<td width="30%" class="dialogTd" colspan="3">
		    	<input class="easyui-combobox" type="text"  id="cglxdm" name="cglxdm"   style="width:200px;" value=""
					data-options="url: contextPath +  '/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js',dataFilter:'${filterZdStr}',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:getcghlx"/>
		    	</td>
		    </tr>



	    	</c:if>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">重点人员管理类型：</td>
		    	<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm"   style="width:200px;"
						   data-options="url: contextPath +'/common/dict/BD_D_ZDRYGLLX.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zdrylxChange"/>
				</td>
		    </tr>

		      <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
	    		<td width="80%" class="dialogTd" colspan="3"><input type="text" name="zdrylbStr" id="zdrylbStr" class="easyui-combotree" style="width:619px;"
					data-options="onlyLeaf:true,valueField:'id',textField:'text',
	    			multiple:false,required:true,panelWidth:400,method:'get',lines:true,tipPosition:'left'" />
		    	</td>
		    </tr>
		    	       <tr id="sqsbzdrycg">
	    	<td width="20%" class="dialogTd" align="right">撤管原因：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cgyy" name="zdrySqsbzdryxxb.cgyydm" style="width:200px;" value="${zdryVO.zdrySqsbzdryxxb.cgyydm}"
					data-options="url: contextPath + '/common/dict/BD_D_ZDRKCGYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
		    	</td>
	    	</tr>
		    </table>
 		<!-- 这里引用公用列管信息模块 -->
		    <%@include file="/WEB-INF/pages/zdrygl/add/zdryLgLxInc.jsp"%>
		     <!-- 列管公共信息 -->
	    	<table id="ggDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;">

	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgrqText">业务办理日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ywclsj" id="ywclsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="${ywclsj}" readonly="readonly" /></td>
		    	<td width="20%" class="dialogTd" align="right" id="lgrText">业务办理人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="ywblr_xm" name="ywblr_xm" style="width:200px;" value="${ywblr_xm }" readonly="readonly" />
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="ywfqyy" name="ywfqyy" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']" /></td>
	    	</tr>

	    	</table>

	    </div>
    </form>
</div>
<script type="text/javascript" >
var placeVersion = "<%=SystemConfig.getString("PlaceVersion")%>";

var ywlx='${ywlx}';
var lcg="lg";
if(ywlx==2){
    lcg="cg";
}
var filterStr='${filterStr}';
var filterZdStr='${filterZdStr}';
var xfbmdm='${xfbmdm}';
var mainTabID = "${mainTabID}";
$(document).ready(function(){

	$("#jgdxDiv").hide();
	$("#zdrkDiv").hide();
	$("#zszhjsbrDiv").hide();
	$("#fzcfryDiv").hide();
	$("#ggDiv").hide();
	$("#sqjzryDiv").hide();
	$("#sqsbzdryDiv").hide();
	$("#sqsbzdrycg").hide();

	$("#nrsxdxDiv").hide();

	setInputReadonly("zdrylbStr", true);
    if(placeVersion=="辽宁省厅版"){
    	//去掉重复列管
    	if(filterStr&&filterStr!=""){
    		$('#zdrygllxdm').combobox('setDataFilter', '[^'+filterStr);
    	}else{
        	//暂不考虑07和08 涉环保 涉枪爆
    		$('#zdrygllxdm').combobox('setDataFilter', '^(01|02|03|04|06|08)$');
    		//$("#jbxx_cyzjdm").combobox("setDataFilter", "[111]");

    	}
     }else if(placeVersion=="大连版"){
         //alert(filterStr);
    	if(filterStr&&filterStr!=""){
     		$('#zdrygllxdm').combobox('setDataFilter', '[^'+filterStr+'|1|6]');
     	}else{
     		$('#zdrygllxdm').combobox('setDataFilter', '^0[1-8]{1,1}$');
     		//$("#jbxx_cyzjdm").combobox("setDataFilter", "[111]");
     	}


     }

    $('#zdrygllxdm').combobox('setValue', '${zdrygllxdm}');
    $('#zdrylbStr').combobox('setValue', '${zdrylbdm}');

	var zdryHsbId = $("#zdryHsbId").val();
	if(zdryHsbId != null && zdryHsbId != ""){
		$('#zdrylbStr').combotree('setValue', '${zdrylbdm}');
		$('#glffdm').combobox('setValue', '${glffdm}');
		$('#lglydm').combobox('setValue', '${lglydm}');
	}

});


function doInit(paramArray) {
	var windowID = paramArray['windowID'];
	if(ywlx=="1"){
		$("#dataForm").attr("action","<%=basePath%>zdryHsb/saveLg");
	}else if(ywlx=="2"){
		$("#dataForm").attr("action","<%=basePath%>zdryHsb/saveCg");
		var data=$("#cglxdm").combobox("getData");

		//if(data.length==1){
		//	$("#cglxdm").combobox("select",data[0].id);
		//}

	}
	//如果列管类型为监管，不准所有列管
	if(xfbmdm=="ZA"&&filterStr=="1"&&ywlx=="1"){
		$('#zdrygllxdm').combobox('setDataFilter', '999');
		alert("此人已被列‘监管对象’或正在申请中，不可再列管其他类型");
		parent.$("#"+windowID).window("close");
	}else if(xfbmdm=="ZA"&&filterStr&&ywlx=="1"){
		$('#zdrygllxdm').combobox('setDataFilter', '999');
		alert("此人已被本辖区列管或正在申请中，不可再列管其他类型");
		parent.$("#"+windowID).window("close");
	}
	if(filterZdStr=='9999'&&ywlx=="2"){
		alert("此人所有重点人员类型状态都为进行中状态不可再撤管和转递");
	}

}

function beforeSubmit() {
	var obj=$("#fzxzdm").combotree("tree");
	var nodes=[];
	 nodes=obj.tree('getChecked');
	 var selectedItemArray=[];
	 if(nodes){
		 var length=0;
		 for(var i=0;i<nodes.length;i++){
			    if(!nodes[i].children){
                     length++;
				 }
			}
         if(length>5){
            alert("犯罪性质最多选择5条！");
            $("#fzxzdm").combotree("clear");
            return false;
          }
	}


}

function afterSubmit() {

	if(ywlx=="2"){
		closeSelf();
		executeTabPageMethod(mainTabID, "queryButton()");
	}else{
	parent.location.reload();
	}
}




/**
 * 根据撤管类型,得到撤管后的类型,大类选择
 */
function getcghlx(newValue,oldValue){
	var name = $("#xm").val();
	if(newValue){
		if(placeVersion=="辽宁省厅版"){
			//alert(newValue);
			var cglx=newValue;
			var zdrylx="06|09";
			if(cglx=="01"){
				zdrylx="02|06"
			}
			else if(cglx=="06"){
				zdrylx="09"
			}else if(cglx=="08"){
                zdrylx="06|09";
                $("#sqsbzdrycg").show();
			}
			//alert(zdrylx);
			$('#zdrygllxdm').combobox('setDataFilter', zdrylx);



             if(cglx=="08"){
            	 $("#sqsbzdrycg").show();
            		setComboRequired("cgyy",true);
             }else{
            	 $("#sqsbzdrycg").hide();
            	 setComboRequired("cgyy",false);
             }

			if(zdrylx=='09'){
				setComboRequired("zdrylbStr", false);
			}
		}else if(placeVersion=="大连版"){
			var cglx=newValue;
			var zdrylx="08|09";
			if(cglx=="01"){
				zdrylx="02|07"
			}else if(cglx=="02"||cglx=="03"||cglx=="04"||cglx=="05"||cglx=="06"){
				zdrylx="07"
			}
			else if(cglx=="07"||cglx=="08"){
				zdrylx="09"
			}
			$('#zdrygllxdm').combobox('setDataFilter', zdrylx);
			if(zdrylx=='06'){
			//$('#zdrygllxdm').combobox('setValue', zdrylx);
			setComboRequired("zdrylbStr", false);
		}

	 }
		}

}





</script>