<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>接处警档案</title>
<script type="text/javascript" src="<%=contextPath%>/js/jcjinfo-mould.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script>
</head>
 <script type="text/javascript">
       var mainTabID = "${mainTabID}";
     </script>
<body class="bodybg">
<div class="head"><div class="logo"></div></div>
<div class="bodydiv">
<div class="bodyer">
<div class="lf">
<!--框-->
<div class="lf_conta">
<div class="lf_contb">
<div class="lf_contc">

<div class="pphoto">
<div><img class="topPhoto" id="topPhotoid" width="180" height="180" alt="" /></div>
   <%--<a href="javascript:void(0);" info="jcjid,JCJ_JJXXB,接处警接警信息表"  class="addphoto"></a>
--%></div>
<div class="pinfo">
<strong><span>警情编号：</span><span id="jjbh">${jcj.jjbh }</span></strong>
	<ul>
	 <li><span>警情来源：</span><span id="jjlxdm"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_JCJ_JJLXDM.js', "${jcj.jjlxdm}"));</script>&nbsp;&nbsp;&nbsp;&nbsp;<span>报警时间：</span><span id="bj_sj">${jcj.bj_sj}</span></span></li>
	 <li><span>警情地址详址：</span><span id="jqdzxz">${jcj.jqdzxz }</span></li>
	 <li><span>警情地址描述：</span><span id="jqdzms">${jcj.jqdzms }</span></li>
	 <li><span>警情摘要：</span><span id="bjnr">${jcj.bjnr }</span></li>
	 <li><span>报警人姓名：</span><span id="bjr_xm">${jcj.bjr_xm}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>报警人性别：</span><span id="bjr_xbdm"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_BZ_XB.js', "${jcj.bjr_xbdm}"));</script></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>案件级别：</span><span id="jqdjdm">${jcj.eventlevel }</span></li>
	 <li><span>报警联系电话：</span><span id="bjr_lxdh">${jcj.bj_lxdh }</span></li>
	 
	
	
    </ul> 														
	<!--  <div class="moreinfo">
    </div>-->
</div>
	<input type="hidden" id="jcjlx"  value="${jcj.qszt}"/>
	<input type="hidden" id="formPara" value='"jjbh":"${jcj.jjbh}"' /><!-- 表单提交附加参数 json-->
	<input type="hidden" id="serverPara" value="jcjid=${jcj.id }&jjbh=${jcj.jjbh}&xzqhdm=${jcj.xzqhdm}&cjdbh=${cj.cjdbh}"  /><!-- 业务办理附加参数-->
	<input type="hidden" id="queryPara" value="jcjid=${jcj.id }&jjbh=${jcj.jjbh}&xzqhdm=${jcj.xzqhdm}" /><!-- 表单查询附加参数 -->
	<input type="hidden" id="mode_"	 value="${mode }" />
	
<div class="clear"></div>
<div class="editdiv"><a href="javascript:void(0);" class="savebtn">档案编辑完成</a><a href="javascript:void(0);" class="editbtn" style="display:none" id="bjdaxx">编辑档案信息</a><c:if test="${jcj.qszt == '0'}"><a href="javascript:qianshou();" class="savebtn1" id="qianshou">签收</a></c:if></div>

</div>
</div>
</div>
<!--/框-->

<!--基础信息-->
<div class="lf_conta cont_edit">
<div class="lf_contb">
<div class="lf_contc">
<dl class="infodl">
<dt><div class="dllf info_jbxx">签收信息</div><a class="up_btn down_btn" href="javascript:void(0);"></a><a class="info_savebtn" href="javascript:void(0);">保存</a></dt>
<dd class="infoshow">
    <ul>
     <li><span class="spantitle">签收单编号：</span><span name="bjr_xm" class="edit_word input_w2">${cj.cjdbh}</span><span class="spantitle">签收人姓名：</span><span name="bjr_gmsfhm" class="edit_word input_w2">${cj.cjy_xm}</span></li>
     <li><span class="spantitle">签收人编号：</span><span name="bj_lxdh" class="edit_word input_w2">${cj.cj_jybh}</span><span class="spantitle">签收时间：</span><span name="bjdhyh_xm" class="edit_word input_w2">${cj.xt_lrsj}</span></li>
    <input type="hidden" name="id" id="jcjid" value="${jcj.id }" /><input type='hidden' name='openUrl' value='/jcj/createEdit' />
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
</html>
<script type="text/javascript">
var infoPara = {
		mainUrl:"/jcj/queryJcjzsxx",
		mainPara:"jcjlx="+$("#jcjlx").val(),
		
		queryUrl:"/jcj/service/",
		queryPara:$("#queryPara").val(), //jcjid
		
		serverMenuUrl:"/jcj/queryYwglgn",
		serverMenuPara:"jcjlx="+$("#jcjlx").val(), //
		
		zpUrl:"/zpfjPtryzp/queryZpById.jpg",
		
		editPara:"jcjid="+$("#jcjid").val(),
		editIframePara:'{'+$("#formPara").val()+'}', 
		
		serverPara:$("#serverPara").val(),  //
		
		serverIframePara:'{'+$("#formPara").val()+'}',
		
		add_childInfo_para: $("#serverPara").val(),
		add_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		
		edit_childInfo_para:$("#serverPara").val(),
		edit_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		
		del_childInfo:"/jcj/delete_xxzsnrb"
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
	
	document.getElementById("topPhotoid").src = contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id=${fw.id }";
});
function qianshou(){
   $("#qianshou").hide();
   $.ajax({
		type:"POST",
		url:"<%=basePath%>jcj/saveCjxxb",
		dataType:"json",
		data:"jjbh=${jcj.jjbh}&xzqhdm=${jcj.xzqhdm}&orgseatno=${jcj.orgseatno}",
		complete:function() {
			location.reload();
			 executeTabPageMethod(mainTabID, "queryButton()");
		},
		error:function() {
		}
	});	
}



</script>

    