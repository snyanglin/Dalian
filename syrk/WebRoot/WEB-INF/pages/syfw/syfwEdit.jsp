<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>房屋档案</title>
<script type="text/javascript" src="<%=contextPath%>/js/syfwinfo-mould.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script>
<style>
.nameTable{ width:430px;height:auot;overflow:hidden;}
.nameTable tr{height:auto;}
.nameTable th{line-height:26px; color:#666;font-weight:normal;word-wrap:break-all;}
.nameTable td{line-height:20px; color:#333;word-wrap:break-all; }
</style>
</head>

<body class="bodybg">
<div class="head"><div class="logo"></div></div>
<div class="bodydiv">
<div class="bodyer">
<div class="lf">
<!--框-->
<div class="lf_conta">
<div class="lf_contb">
<div class="lf_contc">

<table >
	<tr>
	<td width="430px">
	<div class="pinfo1">

	<ul><li style="padding:0px;">
	<table cellpadding="0" cellspacing="0" class="nameTable" style="table-layout:fixed" >
	   
   	   <tr >
  	        <th  align="right"  width="110">房屋性质：</th>
    	    <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/ZA_D_FWCQXZZLDM.js', "${fw.fwcqxzzldm}"));</script></td>
    	    <th  align="right" width="110">产权证号：</th>
    	    <td width="90" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title="${fw.fwcqzh}">${fw.fwcqzh}</td>
   	    </tr>
   	   	<tr >
   	   		<th align="right" width="110">房屋类别：</th>
    	    <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/ZA_D_FWLBDM.js', "${fw.fwlbdm}"));</script></td>
  	        <th  align="right" width="110">房屋用途：</th>
    	    <td  width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/ZA_D_FWYTDM.js', "${fw.fwytdm}"));</script></td>
   	   </tr>
   	   <tr>
   	   		<th  align="right" width="110" >房屋间数：</th>
  	   		<td width="90">${fw.fwjs} </td>
  	   		<th  align="right"  width="110">房屋面积：</th>
  	   		<td width="90"  style="white-space:nowrap;overflow:hidden" title="${fw.fwmj_mjpfm }（平方米） ">${fw.fwmj_mjpfm }（平方米） </td>
   	   </tr>
   	    <tr >
  	        <th  align="right"  width="110">房主姓名：</th>
    	    <td>${fw.fz_xm}</td>
   	  		<th  align="right" width="110">房主电话：</th>
    	    <td>${fw.fz_lxdh}</td>
   	   </tr>
   	    <tr >
  	        <th align="right" width="110" >房屋地址：</th>
    	    <td colspan="3" width="300">${fw.fwdz_dzxz } </td>
   	  	</tr>
	</table>
	</li>
    </ul> 														
	</div>
	</td>
	<td>
		<div class="pphoto_1">
			<div>
				<div id="uploadFileImageDiv" style="width: 240px; height:180px; border: 1px solid #86B6CF; text-align: center;"></div>
				<!--  <img  id="topPhotoid" width="240"
					height="180" alt="" />-->
			</div>
			<c:if test="${mode !='view'}">
			    	<a href="javascript:void(0);" info="fwid,SYFW_FWJBXXB,房屋基本信息表"
				class="addphoto"></a>
			</c:if>
		</div>
	</td>
	</tr>
</table>
	<input type="hidden" id="fwlxdm"  value="${fw.sfczfw}"/>
	<input type="hidden" id="formPara" value='"dz_fwdzxz":"${fw.fwdz_dzxz}","fwdz_dzid":"${ fw.fwdz_dzid}"' /><!-- 表单提交附加参数 json-->
	<input type="hidden" id="serverPara" value="fwid=${fw.id }" /><!-- 业务办理附加参数-->
	<input type="hidden" id="queryPara" value="fwid=${fw.id }" /><!-- 表单查询附加参数 -->
	<input type="hidden" id="mode_"	 value="${mode }" />
	
<div class="clear"></div>
<div class="editdiv"><a href="javascript:void(0);" class="savebtn">档案编辑完成</a><a href="javascript:void(0);" class="editbtn" style="display:none">编辑档案信息</a></div>

</div>
</div>
</div>
<!--/框-->

<!--基础信息-->
<div class="lf_conta cont_edit">
<div class="lf_contb">
<div class="lf_contc">
<dl class="infodl">
<dt><div class="dllf info_jbxx">基本信息</div><a class="up_btn down_btn" href="javascript:void(0);"></a><a class="info_editbtn" href="javascript:void(0);">编辑</a><a class="info_savebtn" href="javascript:void(0);">保存</a></dt>
<dd class="infoedit">
    <ul>
	<li><span class="spantitle">房主外文姓：</span><span name="fz_wwx" class="edit_word input_w2">${fw.fz_wwx}</span></li> 
	<li><span class="spantitle">房主外文名：</span><span name="fz_wwm" class="edit_word input_w2">${fw.fz_wwm}</span></li> 
	<li><span class="spantitle">居住人数：</span><span class="edit_word input_w2">${fw.jzrs}</span></li> 
	<li><span class="spantitle">托管人证件种类：</span><span name="tgr_cyzjdm"  dict="/common/dict/KX_D_CYZJDM"  class="edit_word input_w2">${fw.tgr_cyzjdm}</span></li> 
	<li><span class="spantitle">托管人证件号码：</span><span name="tgr_zjhm" class="edit_word input_w2">${fw.tgr_zjhm}</span></li> 
	<li><span class="spantitle">托管人姓名：</span><span name="tgr_xm" class="edit_word input_w2">${fw.tgr_xm}</span></li> 
	<li><span class="spantitle">托管人联系电话：</span><span name="tgr_lxdh" class="edit_word input_w2">${fw.tgr_lxdh}</span></li> 
	<li><span class="spantitle">托管人外文姓：</span><span name="tgr_wwx" class="edit_word input_w2">${fw.tgr_wwx}</span></li> 
	<li><span class="spantitle">托管人外文名：</span><span name="tgr_wwm" class="edit_word input_w2">${fw.tgr_wwm}</span></li> 
	<li><span class="spantitle">托管人与房主关系：</span><span name="tgr_yfzgx_rygxdm" dict="/common/dict/XZ_D_RYGXDM"  class="edit_word input_w2">${fw.tgr_yfzgx_rygxdm}</span></li>
	<li><span class="spantitle">是否出租房屋：</span><span name="sfczfw" dict="/common/dict/BD_D_SF"  class="edit_word input_w2">${fw.sfczfw}</span></li>
	<li><span class="spantitle">备注：</span><span name="bz" class="edit_word input_w1">${fw.bz}</span></li> 
    <input type="hidden" name="id" id="fwid" value="${fw.id }" /><input type='hidden' name='openUrl' value='/syfw/${fw.id }/edit' />
    </ul>
<div class="clear"></div>
</dd>
</dl>
</div>
</div>
</div>
<!--/基础信息-->



</div>
<div class="rt" style="display:none">
<!--右侧框-->
<div class="rt_conta">
<div class="rt_contb">
<div class="rt_contc">

<div class="rt_server">
<div class="rttitle" id="server_Menu">业务办理</div>
<ul class="rtul" id="serverMenu"> 
</ul>

</div>
<div class="rt_view">
<div class="rttitle" >可增加信息</div>
<ul class="rtul" id="serverAddInfo">
</ul>
</div>

</div>
</div>
</div>
<!--/右侧框-->
</div>
<div class="clear"></div>
</div>
</div>
</body>
<script type="text/javascript">
var infoPara = {
	mainUrl:"/syfw/queryFwzsxx",
	mainPara:"fwlxdm="+$("#fwlxdm").val(),
	
	queryUrl:"/syfw/service/",
	queryPara:$("#queryPara").val(), //fwid 单位ID
	
	serverMenuUrl:"/syfw/queryYwglgn",
	serverMenuPara:"fwlxdm="+$("#fwlxdm").val(), //实有房屋类型
	
	zpUrl:"/syfw/queryFwzp.jpg",
	
	editPara:"fwid="+$("#fwid").val(),
	editIframePara:'{'+$("#formPara").val()+'}', 
	
	serverPara:$("#serverPara").val(),  //id 房屋ID， fwmc 房屋名称
	serverIframePara:'{'+$("#formPara").val()+'}',
	
	add_childInfo_para: $("#serverPara").val(),
	add_childInfo_iframePara:'{'+$("#formPara").val()+'}',
	
	edit_childInfo_para:$("#serverPara").val(),
	edit_childInfo_iframePara:'{'+$("#formPara").val()+'}',
	
	del_childInfo:"/syfw/delete_xxzsnrb"
};
$(document).ready(function(){
	
	var mode_ = $("#mode_").val();
 	if(mode_=="view"){
 		$("#server_Menu").hide();
 		$("a.info_editbtn").remove();
	}else{
 		$("a.editbtn").show();
		$("a.savebtn").click(save_view);
		$("a.info_editbtn").click(editEnable);
		$("a.editbtn").click(edit_view);
		getServerMenu(1);
		getServerMenu(2);
	}
	
	/***************固定事件注册，页面初始化**************************/
	
		
	
	$("a.up_btn").click(up_down);
	sylbIcon();
	$(".addphoto").click(addFile);
	iterateDict($("div.lf_conta").eq(1));
		

	$(".rt").show();
	$(".rt_view").hide();
		
	/**********自己定义方法*************************/
	//loadActivityTrace();
	//loadRelationMessage();
	var fwid = $("#fwid").val();
	uploadFileImageView('SYFW_FWJBXXB', fwid, 'uploadFileImageDiv', 240, 180, contextPath + '/common/skin/images/empty_ryzp.jpg');
	//document.getElementById("topPhotoid").src = contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id=${fw.id }";
});
function refreshPhoto(){
	location.reload();
}
</script>
</html>
    