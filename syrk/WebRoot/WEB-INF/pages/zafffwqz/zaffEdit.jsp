<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>治安防范档案</title>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/zaffwinfo-mould.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>
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

<div class="pphoto">
<div><img name="" src="<%=contextPath%>/zpfjPtryzp/queryPtryzpSingle.jpg?ryid=1" width="162" height="200" alt=""/></div>
<!--  <a href="javascript:void(0);" class="morephoto"></a><a href="javascript:void(0);" class="addphoto"></a>-->
</div>
<div class="pinfo">
<strong><span id="jwsmcSpan">${entity.jwsmc }</span></strong>
	<ul>
    
    <li><span>警务室类别：</span><span id="jwslbSpan"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/D_BZ_SF.js', '1'));</script></span>
    </li> 
    <li><span>电话：</span><span id="dhSpan">${entity.jwsdh }</span>&nbsp;&nbsp;&nbsp;&nbsp;</li>
    <li><span>地址：</span><span id="dzSpan">${entity.dz_jwsdzxz }</span></li>
    </ul> 														
	<!--  <div class="moreinfo">
    </div>-->
</div>
	<input type="hidden" id="jwslb"  value="1"/>
	<input type="hidden" id="formPara" value='"jwsmc":"${entity.jwsmc}"' /><!-- 表单提交附加参数 json-->
	<input type="hidden" id="serverPara" value="jwsid=${entity.id }&jwsmc=${entity.jwsmc}&jwslb=1" /><!-- 业务办理附加参数-->
	<input type="hidden" id="queryPara" value="jwsid=${entity.id }" /><!-- 表单查询附加参数 -->
	
<div class="clear"></div>
<div class="editdiv"><a href="javascript:void(0);" class="savebtn">档案编辑完成</a><a href="javascript:void(0);" class="editbtn">编辑档案信息</a></div>

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
<dd class="infoshow">

    <ul>
    
	<li><span class='spantitle'>警务室名称：</span><span name='jwsmc' class='edit_word input_w2'>${entity.jwsmc}</span></li>
	<li><span class='spantitle'>警务室类别：</span><span name='jwslb' dict="/common/dict/D_BZ_SF" class='edit_word input_w2'>${entity.jwslb}</span></li> 
	<li><span class='spantitle'>警务室电话：</span><span name='jwsdh' class='edit_word input_w2'>${entity.jwsdh}</span></li>
	<li><span class='spantitle'>警务室面积：</span><span name='jwsmj'  class='edit_word input_w2'>${entity.jwsmj}</span></li>
	<li><span class='spantitle'>是否独立：</span><span name='sfdldm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'>${entity.sfdldm}</span></li>
	<li><span class='spantitle'>民警人数：</span><span name='mjrs' class='edit_word input_w2'>${entity.mjrs}</span></li>
	<li><span class='spantitle'>办公用品配置：</span><span name='bgyppz' class='edit_word input_w1'>${entity.bgyppz}</span></li>
	<li><span class='spantitle'>警务室地址：</span><span name='dz_jwsdzxz' class='edit_word input_w1'>${entity.dz_jwsdzxz}</span></li>
	<li><span class='spantitle'>计算机台数：</span><span name='jsjts' class='edit_word input_w2'>${entity.jsjts}</span></li>
	<li><span class='spantitle'>连接公安网台数：</span><span name='ljgawts' class='edit_word input_w2'>${entity.ljgawts}</span></li>
	<input type='hidden' name='id' id="jwsid" value="${entity.id }" /><input type='hidden' name='openUrl' value='/sqjwsxxb/addSqjwsxxb' />
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
<li><a href='javascript:void(0);'  onclick="menu_open('受理咨询求助', '/forward/zafffwqz|slzxqzList')" class='doServer' >受理咨询求助</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('矛盾调解', '/forward/zafffwqz|mdtjquery')" class='doServer' >矛盾调解</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('恳谈会', '/forward/zafffwqz|kthList')" class='doServer' >恳谈会</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('特殊群体关怀', '/forward/zafffwqz|tsqtghList')" class='doServer' >特殊群体关怀</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('出生证明', '/forward/zafffwqz|cszmquery')" class='doServer' >出生证明</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('无犯罪记录证明', '/forward/zafffwqz|wfzjlzmbquery')" class='doServer' >无犯罪记录证明</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('亲属关系证明', '/forward/zafffwqz|qsgxzmbquery')" class='doServer' >亲属关系证明</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('居住证明', '/forward/zafffwqz|jzzmbquery')" class='doServer' >居住证明</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('空挂证明', '/forward/zafffwqz|kgzmbquery')" class='doServer' >空挂证明</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('治安防范宣传', '/forward/zafffwqz|zaffxcList')" class='doServer' >治安防范宣传</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('人防', '/forward/zafffwqz|rfxxList')" class='doServer' >人防</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('物防', '/forward/zafffwqz|wfxxMain')" class='doServer' >物防</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('犬只管理', '/forward/zafffwqz|qzbquery')" class='doServer' >犬只管理</a></li>
<li><a href='javascript:void(0);'  onclick="menu_open('其它宠物管理', '/forward/zafffwqz|qtcwbquery')" class='doServer' >其它宠物管理</a></li>
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
		mainUrl:"/zaffgl/queryJwszsxx",
		mainPara:"",
		
		queryUrl:"/zaffgl/service/",
		queryPara:$("#queryPara").val(), //fwid 单位ID
		
		serverMenuUrl:"/zaffgl/queryYwglgn",
		serverMenuPara:"", 
		
		zpUrl:"/zpfjPtryzp/queryZpById.jpg",
		
		editPara:"jwsid="+$("#jwsid").val(),
		editIframePara:'{'+$("#formPara").val()+'}', 
		
		serverPara:$("#serverPara").val(),  //id 房屋ID， fwmc 房屋名称
		serverIframePara:'{'+$("#formPara").val()+'}',
		
		add_childInfo_para: $("#serverPara").val(),
		add_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		
		edit_childInfo_para:$("#serverPara").val(),
		edit_childInfo_iframePara:'{'+$("#formPara").val()+'}',
		
		del_childInfo:"/zaffgl/delete_xxzsnrb"
	};
$(document).ready(function(){
	$.ajax({
		type:"POST",
		async:false,
		url:"<%= basePath%>sqjbxxb/getSqjbxxb",
		dataType:"json",
		data:"jwsid=${entity.id }",
		success:function(data){
		
			if (data && data.sqjbxxb) {
				var formdata = $("#formPara").val() + ',"sqid":"'+ data.sqjbxxb.id +'"';
				$("#formPara").val(formdata);
			}
			infoPara.add_childInfo_iframePara='{'+$("#formPara").val()+'}';
		}
	});
	
	/***************固定事件注册，页面初始化**************************/
	$("a.info_editbtn").click(editEnable);
	$("a.up_btn").click(up_down);
	$("a.editbtn").click(edit_view);
	sylbIcon();
	iterateDict($("div.lf_conta").eq(1));
		
	$("a.savebtn").click(save_view);

	$(".rt").show();
	$(".rt_view").hide();
	//getServerMenu(1);
	getServerMenu(2);
		
	/**********自己定义方法*************************/
	
});

function setFormPara(){
	alert($("#formPara").val());
	infoPara.add_childInfo_iframePara='{'+$("#formPara").val()+'}';
}
</script>
</html>
    