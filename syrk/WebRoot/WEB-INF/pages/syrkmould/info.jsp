<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>实有人口基本信息</title>
</head>

<!--基础信息-->
<div class="lf_conta">
<div class="lf_contb">
<div class="lf_contc">
<dl class="infodl">
<dt><div class="dllf info_jbxx">基本信息</div><a class="up_btn" href="javascript:void(0);"></a><a class="info_editbtn" href="javascript:void(0);">编辑</a><a class="info_savebtn" href="javascript:void(0);">保存</a></dt>
<dd class="infoshow">
    <ul>
    <li><span class='spantitle'>常用证件：</span><input class='easyui-combobox input_w2' type='text' name='cyzjdm' data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>证件号码：</span><input class='easyui-validatebox input_w2' type='text' name='zjhm' data-options="required:true,validType:['maxLength[30]']" /><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>外文姓：</span><input class='easyui-validatebox input_w2' type='text' name='wwx' data-options="required:false,validType:['maxLength[40]','english']" /><span class='edit_word input_w2'></span></li> 
    <li><span class='spantitle'>外文名：</span><input class='easyui-validatebox input_w2' type='text' name='wwm' data-options="required:false,validType:['maxLength[40]','english']" /><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>姓名：</span><input class='easyui-validatebox input_w2' type='text' name='xm' data-options="required:true,validType:['maxLength[20]','unnormal']" /><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>曾用名：</span><input class='easyui-validatebox input_w2' type='text' name='cym' data-options="required:false,validType:['maxLength[20]','unnormal']" /><span class='edit_word input_w2'></span></li> 
    <li><span class='spantitle'>性别：</span><input class='easyui-combobox input_w2' type='text' name='xbdm' data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/><span class='edit_word input_w2'></span></li> 
    <li><span class='spantitle'>民族：</span><input class='easyui-combobox input_w2' type='text' name='mzdm' data-options="required:false,url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>出生日期：</span><input class='easyui-validatebox input_w2' type='text' name='csrq' data-options="required:false,validType:['date['yyyy-MM-dd']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>国籍：</span><input class='easyui-combobox input_w2' type='text' name='gjdm' data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/><span class='edit_word input_w2'></span></li>
    
    <li><span class='spantitle'>出生地址：</span><input class="easyui-combobox input_w1" id="jbxx_csd" style="width:500px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false"><span class='edit_word input_w1'></span>
    	<input type='hidden' name='csdgjhdqdm' id="jbxx_csdgjhdqdm" /><input type='text' name='csdssxdm' id="jbxx_csdssxdm" /><input type='text' name='csdxz' id="jbxx_csdxz" /> </li>
    <li><span class='spantitle'>籍贯：</span><input class='easyui-validatebox input_w1' /><span class='edit_word input_w1'></span>
    	<input type='hidden' name='jggjdqdm' /><input type='hidden' name='jgssxdm' /></li>
    <li><span class='spantitle'>户籍地址：</span><input class='easyui-validatebox input_w1' /><span class='edit_word input_w1'></span>
    	<input type='hidden' name='dz_hjdzdm' /><input type='hidden' name='dz_hjdzssxdm' /><input type='hidden' name='dz_hjdzxz' /><input type='hidden' name='hjdpcsdm' /></li>
    <li><span class='spantitle'>居住地址：</span><input class='easyui-validatebox input_w1' /><span class='edit_word input_w1'></span>
    	<input type='hidden' name='dz_jzdzdm' /><input type='hidden' name='dz_jzdzssxdm' /><input type='hidden' name='dz_jzdzxz' /></li> 
	
	<li><span class='spantitle'>学历：</span><input class='easyui-combobox input_w2' type='text' name='xldm' data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>毕业院校：</span><input class='easyui-validatebox input_w2' type='text' name='byyx' data-options="required:false,validType:['maxLength[50]','unnormal']" /><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>毕业专业：</span><input class='easyui-validatebox input_w2' type='text' name='byzy' data-options="required:false,validType:['maxLength[50]','unnormal']" /><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>婚姻状况：</span><input class='easyui-combobox input_w2' type='text' name='hyzkdm' data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/><span class='edit_word input_w2'></span></li>
    <li><span class='spantitle'>政治面貌：</span><input class='easyui-combobox input_w2' type='text' name='zzmmdm' data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/><span class='edit_word input_w2'></span></li>     
    <li><span class='spantitle'>服务处所：</span><input class='easyui-validatebox input_w2' type='text' name='fwcs' data-options="required:false,validType:['maxLength[50]','unnormal']" /><span class='edit_word input_w2'></span><input type='hidden' name='fwcsid' /></li>
    <li><span class='spantitle'>职务：</span><input class='easyui-validatebox input_w2' type='text' name='zw' data-options="required:false,validType:['maxLength[20]','unnormal']" /><span class='edit_word input_w2'></span></li>
    
    </ul>
<div class="clear"></div>
</dd>
</dl>
</div>
</div>
</div>
<!--/基础信息-->

<script language="javascript">
$(".info_editbtn").click(function(){
	$(this).parent().parent().find(".edit_word").hide();
	$(this).parent().parent().find(".edit_input").show();
	$(this).hide();
	$(this).siblings(".info_savebtn").show();
});
$(".info_savebtn").click(function(){
	$(this).parent().parent().find(".edit_word").show();
	$(this).parent().parent().find(".edit_input").hide();
	$(this).siblings(".info_editbtn").show();
	$(this).hide();
});
$(".up_btn").click(function(){
	$(this).toggleClass("down_btn");
	$(this).parents("dl").find("dd").slideToggle("fast","linear");
});
$(".addfw_btn").click(function(){
	$(this).parent().siblings(".info_fw").append('<li class="add_li"><span class="spantitle"><input class="addspan_input" type="text" name="" value=""/>：</span><input class="input_w1" type="text" name="" value="这里是添加的信息"/><a class="savefw_btn" href="javascript:void(0);" onClick="savefw_info(this)">保存</a></li>');
});
function savefw_info(e){
		$(e).parent("li").removeClass("add_li");
		$(e).parent("li").html('<span class="spantitle">快递地址：</span><input class="edit_input input_w2" type="text" name="" value="大连市西岗区花园街38号1-1-3号"/><span class="edit_word input_w2">大连市西岗区花园街38号1-1-3号</span>');
}
initAddressSearch('jbxx_csd', {dzjb:'13'}, {text:'jbxx_csdxz',dzxzqh:'jbxx_csdssxdm'});
</script>