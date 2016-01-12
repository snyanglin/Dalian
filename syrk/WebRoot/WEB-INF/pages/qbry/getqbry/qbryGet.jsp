<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

    <form  id ="addForm"
     action="<%=basePath%>qbryManager/qbryget" method="post">

     <table>

<tr class="dialogTr">

	<td width="20%" class="dialogTd" align="right">部级重点人员编号：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bjzdrybh" name="bjzdrybh" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="131415962"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">姓名：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xm" name="xm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="张三"/></td>
	<td width="20%" class="dialogTd" align="right">姓名拼音：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xmhypy" name="xmhypy" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="zhangsan"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">外文姓名：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wwxm" name="wwxm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="Zhangth"/></td>
	<td width="20%" class="dialogTd" align="right">性别代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xbdm" name="xbdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="1"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">出生日期：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="csrq" name="csrq" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="19890501"/></td>
	<td width="20%" class="dialogTd" align="right">国籍代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gjdm" name="gjdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="156"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">公民身份证号：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gmsfhm" name="gmsfhm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="510125198905016988"/></td>
	<td width="20%" class="dialogTd" align="right">其他证件号码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="qtzjhm" name="qtzjhm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">民族代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="mzdm" name="mzdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="1"/></td>
	<td width="20%" class="dialogTd" align="right">籍贯省市县(区)代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jgssxdm" name="jgssxdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="1"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">户籍地：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="hjd" name="hjd" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="大连市沙河口"/></td>
	<td width="20%" class="dialogTd" align="right">现住地：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xzd" name="xzd" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="成都市锦江区"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">现住地派出所名称：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xzdpcsmc" name="xzdpcsmc" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="白山路派出所"/></td>
	<td width="20%" class="dialogTd" align="right">现住地派出所代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xzdpcsdm" name="xzdpcsdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="210204410000
"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">居住地：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzd" name="jzd" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="大连市沙河口"/></td>
	<td width="20%" class="dialogTd" align="right">管辖单位名称：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gxdwmc" name="gxdwmc" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="大连市公安局 "/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">管辖单位机构代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gxdwdm" name="gxdwdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="210200000000"/></td>
	<td width="20%" class="dialogTd" align="right">立案单位名称：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ladwmc" name="ladwmc" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="大连市公安局"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">立案单位机构代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ladwdm" name="ladwdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="210200000000
"/></td>
	<td width="20%" class="dialogTd" align="right">立案时间：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lasj" name="lasj" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">部级重点人员入库时间：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bjzdryrksj" name="bjzdryrksj" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">情报人员类别（小类）：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zdrylb" name="zdrylb" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="51502020205"/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">情报人员管理类型代码（大类）：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zdrygllxdm" name="zdrygllxdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value="10"/></td>
	<td width="20%" class="dialogTd" align="right">有效性：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="yxx" name="yxx" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">ETL时间：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="etldate" name="etldate" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	</tr>

</table>
<input type="submit" value="提交">
<input type="reset"  value="重置">
</form>
</body>




</html>
