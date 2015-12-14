<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
</head>

<body scroll="auto"> 

<form id="dataform" method="post">
<table cellpadding="2" cellspacing="2" border="0" width="100%">
	<tr>
		<td align="right" width="20%">性别：</td>	
		<td width="80%">
			<input type="text" name="xb" id="xb" value="1,2" class="easyui-combobox" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/D_BZ_XB.js',dataFilter: '2|3|4',required:true,method:'get',
					valueField:'id',textField:'text',selectOnNavigation:false">
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">行政区划：</td>	
		<td width="80%">
    	<input type="text" name="xzqh" id="xzqh" value="510104" class="easyui-combotree" style="width:200px;"
    		data-options="url: contextPath + '/common/dict/D_BZ_XZQH_MUNICIPAL.js',onlyLeaf:true,dataFilter:'02$|03$',multiple:false,required:true,panelWidth:320,
						method:'get',editable:true,lines:true">
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">无引号：</td>	
		<td width="80%">
			<input type="text" name="noMark" id="noMark" class="easyui-validatebox" style="width: 200px;" 
				data-options="required:true,charSet:'upper',validType:['noMark','maxLength[10]']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">自然数：</td>	
		<td width="80%">
			<input type="text" name="naturalNumber" id="naturalNumber" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['naturalNumber']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">自然数：</td>	
		<td width="80%">
			<input type="text" name="naturalNumber" id="naturalNumber" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['naturalNumberRange[1,100]']"/>（1到100）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">整数：</td>	
		<td width="80%">
			<input type="text" name="numeric1" id="numeric1" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['numeric[\'i\']']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">整数：</td>	
		<td width="80%">
			<input type="text" name="numericRange1" id="numericRange1" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['numericRange[\'i\',0,-5,5]']"/>（-5到5）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">浮点数：</td>	
		<td width="80%">
			<input type="text" name="numeric2" id="numeric2" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['numeric[\'f\',3]']"/>（3位小数）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">浮点数：</td>	
		<td width="80%">
			<input type="text" name="numericRange2" id="numericRange2" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['numericRange[\'f\',3,-3.141,8.326]']"/>（3位小数，在-3.141到8.326）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">货币金额：</td>	
		<td width="80%">
			<input type="text" name="money" id="money" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['money']"/>（2位小数）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">英文字母：</td>	
		<td width="80%">
			<input type="text" name="letter" id="letter" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['letter', 'maxLength[10]']"/>（最长10位）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">英文字母或数字：</td>	
		<td width="80%">
			<input type="text" name="letterOrNum" id="letterOrNum" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['letterOrNum']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">小写字母或数字：</td>	
		<td width="80%">
			<input type="text" name="lowerLetterOrNum" id="lowerLetterOrNum" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['lowerLetterOrNum']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">大写字母或数字：</td>	
		<td width="80%">
			<input type="text" name="upperLetterOrNum" id="upperLetterOrNum" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['upperLetterOrNum']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">英文字母或空格：</td>	
		<td width="80%">
			<input type="text" name="letterOrSpace" id="letterOrSpace" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['letterOrSpace']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">纯中文汉字：</td>	
		<td width="80%">
			<input type="text" name="chinese" id="chinese" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['chinese']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">汉字、英文字母或数字：</td>	
		<td width="80%">
			<input type="text" name="chsOrNumOrLetter" id="chsOrNumOrLetter" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['chsOrNumOrLetter']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">变量：</td>	
		<td width="80%">
			<input type="text" name="variable" id="variable" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['variable']"/>（由字母、数字、下划线组成）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">数据源jndi：</td>	
		<td width="80%">
			<input type="text" name="jndi" id="jndi" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['jndi']"/>（字母、数字、下划线、反斜杠组成）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">java类名：</td>	
		<td width="80%">
			<input type="text" name="javaClass" id="javaClass" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['javaClass']"/>（完整的java类名）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">ip地址：</td>	
		<td width="80%">
			<input type="text" name="ip" id="ip" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['ip']"/>（4段ip地址）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">端口号：</td>	
		<td width="80%">
			<input type="text" name="port" id="port" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['port']"/>（1到65534）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">文件夹名称：</td>	
		<td width="80%">
			<input type="text" name="folder" id="folder" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['folder']"/>（不包含特殊字符）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">文件名：</td>	
		<td width="80%">
			<input type="text" name="fileName" id="fileName" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['fileName']"/>（不能包含字符 \\/:*?\"<>|）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">图片文件输入：</td>	
		<td width="80%">
			<input type="text" name="imgFile" id="imgFile" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['imgFile']"/>（后辍为：JPG,JPEG,GIF,PNG,BMP）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">图片文件上传：</td>
		<td width="80%">
			<input type="file" name="uploadFile" id="uploadFile" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['imgFile']"/>（后辍为：JPG,JPEG,GIF,PNG,BMP）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">email地址：</td>
		<td width="80%">
			<input type="text" name="email" id="email" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['email']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">url地址：</td>	
		<td width="80%">
			<input type="text" name="url" id="url" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['url']"/>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">电话号码：</td>
		<td width="80%">
			<input type="text" name="phone" id="phone" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['phone']"/>（固定电话或移动电话）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">移动电话：</td>
		<td width="80%">
			<input type="text" name="mobile" id="mobile" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['mobile']"/>（1[3|4|5|8]开始的12位数字）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">邮政编码：</td>
		<td width="80%">
			<input type="text" name="zipCode" id="zipCode" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['zipCode']"/>（6位数字）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">包含某个字符串：</td>	
		<td width="80%">
			<input type="text" name="contains" id="contains" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['contains[\'中国\']']"/>（包含“中国”）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">以某个字符串开始：</td>	
		<td width="80%">
			<input type="text" name="startsWith" id="startsWith" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['startsWith[\'我们\']']"/>（以“我们”开始）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">以某个字符串结束：</td>	
		<td width="80%">
			<input type="text" name="endsWith" id="endsWith" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['endsWith[\'人\']']"/>（以“人”结束）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期1：</td>	
		<td width="80%">
			<input type="text" name="date1" id="date1" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyy\']']"/>（格式：yyyy）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期2：</td>
		<td width="80%">
			<input type="text" name="date2" id="date" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyyMM\']']"/>（格式：yyyyMM）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期3：</td>
		<td width="80%">
			<input type="text" name="date3" id="date3" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyy-MM\']']"/>（格式：yyyy-MM）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期4：</td>
		<td width="80%">
			<input type="text" name="date4" id="date4" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyyMMdd\']']"/>（格式：yyyyMMdd）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期5：</td>
		<td width="80%">
			<input type="text" name="date5" id="date5" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期6：</td>
		<td width="80%">
			<input type="text" name="date6" id="date6" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyyMMddHH\']']"/>（格式：yyyyMMddHH）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期7：</td>
		<td width="80%">
			<input type="text" name="date7" id="date7" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyy-MM-dd HH\']']"/>（格式：yyyy-MM-dd HH）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期8：</td>
		<td width="80%">
			<input type="text" name="date8" id="date8" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyyMMddHHmm\']']"/>（格式：yyyyMMddHHmm）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期9：</td>
		<td width="80%">
			<input type="text" name="date9" id="date9" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyy-MM-dd HH:mm\']']"/>（格式：yyyy-MM-dd HH:mm）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期10：</td>
		<td width="80%">
			<input type="text" name="date10" id="date10" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyyMMddHHmmss\']']"/>（格式：yyyyMMddHHmmss）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期11：</td>
		<td width="80%">
			<input type="text" name="date11" id="date11" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['date[\'yyyy-MM-dd HH:mm:ss\']']"/>（格式：yyyy-MM-dd HH:mm:ss）
		</td>
	</tr>
	<tr>
		<td colspan="2" height="20"></td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择1：</td>
		<td width="80%">
			<input type="text" name="dateChoice1" id="dateChoice1" class="easyui-validatebox" style="width: 200px;" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择2：</td>
		<td width="80%">
			<input type="text" name="dateChoice2" id="dateChoice2" class="easyui-validatebox" style="width: 200px;" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
				data-options="validType:['date[\'yyyy-MM-dd HH:mm:ss\']']"/>（格式：yyyy-MM-dd HH:mm:ss）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择3：</td>
		<td width="80%">
			<input type="text" name="dateChoice3" id="dateChoice3" class="easyui-validatebox" style="width: 200px;"
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd，小于等于当前日期）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择4：</td>
		<td width="80%">
			<input type="text" name="dateChoice4" id="dateChoice4" class="easyui-validatebox" style="width: 200px;"
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd，大于等于当前日期）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择5：</td>
		<td width="80%">
			<input type="text" name="dateChoice5" id="dateChoice5" class="easyui-validatebox" style="width: 200px;"
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-\#{%d-1}'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd，小于当前日期）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择6：</td>
		<td width="80%">
			<input type="text" name="dateChoice6" id="dateChoice6" class="easyui-validatebox" style="width: 200px;"
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-\#{%d+1}'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd，大于当前日期）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择7：</td>
		<td width="80%">
			<input type="text" name="dateChoice7" id="dateChoice7" class="easyui-validatebox" style="width: 200px;" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s'})"
				data-options="validType:['date[\'yyyy-MM-dd HH:mm:ss\']']"/>（格式：yyyy-MM-dd HH:mm:ss，小于等于当前日期时间）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择8：</td>
		<td width="80%">
			<input type="text" name="dateChoice8" id="dateChoice8" class="easyui-validatebox" style="width: 200px;" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d %H:%m:%s'})"
				data-options="validType:['date[\'yyyy-MM-dd HH:mm:ss\']']"/>（格式：yyyy-MM-dd HH:mm:ss，大于等于当前日期时间）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择9：</td>
		<td width="80%">
			<input type="text" name="dateChoice9" id="dateChoice9" class="easyui-validatebox" style="width: 200px;" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'dateChoice1\')}'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd，小于等于“日期选择1”，当“日期选择1”有值时生效）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择10：</td>
		<td width="80%">
			<input type="text" name="dateChoice10" id="dateChoice10" class="easyui-validatebox" style="width: 200px;" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'dateChoice1\')}'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd，小于等于“日期选择1”，当“日期选择1”有值时生效）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择11：</td>
		<td width="80%">
			<input type="text" name="dateChoice11" id="dateChoice11" class="easyui-validatebox" style="width: 200px;" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'dateChoice1\') || \'%y-%M-%d\'}'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd，小于等于当前日期时间和“日期选择1”中最大的日期）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">日期选择12：</td>
		<td width="80%">
			<input type="text" name="dateChoice12" id="dateChoice12" class="easyui-validatebox" style="width: 200px;" 
				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'dateChoice1\') || \'%y-%M-%d\'}'})"
				data-options="validType:['date[\'yyyy-MM-dd\']']"/>（格式：yyyy-MM-dd，大于等于当前日期时间和“日期选择1”中最小的日期）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">身份证号码：</td>
		<td width="80%">
			<input type="text" name="sfzh" id="sfzh" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['sfzh']"/>（18位身份证号码）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">身份证号码不为空：</td>	
		<td width="80%">
			<input type="text" name="notEmpty" id="notEmpty" class="easyui-validatebox" style="width: 200px;" 
				data-options="required:true,validType:['notEmpty[\'sfzh\']'],invalidMessage:'身份证号码不为空！'"/>（根据另一个输入框校验）
		</td>
	</tr>	
	<tr>
		<td align="right" width="20%">密码1：</td>	
		<td width="80%">
			<input type="password" name="password1" id="password1" class="easyui-validatebox" style="width: 200px;" 
				/>
		</td>
	</tr>	
	<tr>
		<td align="right" width="20%">与密码1相同值：</td>	
		<td width="80%">
			<input type="password" name="equals" id="equals" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['equals[\'id\',\'password1\']']"/>
		</td>
	</tr>	
	<tr>
		<td align="right" width="20%">行政区划（本市）：</td>	
		<td width="80%">
	    	<input type="text" name="xzqh11" id="xzqh11" class="easyui-combobox" style="width:200px;"
	    		data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',required:true,
							method:'get',valueField:'id',textField:'text',selectOnNavigation:false">（测试显示位置 ）
		</td>
	</tr>
	
	<tr>
		<td align="right" width="20%">文本框：</td>	
		<td width="80%">
			<textarea name="textarea" class="easyui-validatebox" cols="20" rows="3" style="width: 200px; height:48px;"
			data-options="validType:['maxLength[20]']"></textarea>（只能输入20个字符）
		</td>
	</tr>
	<tr>
		<td align="right" width="20%">测试复选：</td>	
		<td width="80%">
			<input type="checkbox" name="checkbox" value="checkbox1" id="checkbox1"/>checkbox1
			<input type="checkbox" name="checkbox" value="checkbox2" id="checkbox2"/>checkbox2
			<input type="checkbox" name="checkbox" value="checkbox3" id="checkbox3"/>checkbox3
			<input type="radio" name="rad" value="radio1" id="radio1"/>radio1
			<input type="radio" name="rad" value="radio2" id="radio2"/>radio2
			<input type="radio" name="rad" value="radio3" id="radio3"/>radio3
		</td>
	</tr>	
	<tr>
		<td align="right" width="20%">测试提交：</td>	
		<td width="80%">
			<input type="button" id="button1" value="button"/>
			<input type="reset" id="button2" value="reset"/>
			<input type="submit" id="button3" value="submit"/>
		</td>
	</tr>	

</table>
</form>	

<br><br>

<input type="button" value="validate" onclick="alert($('#dataform').form('validate'));"/>

<input type="button" value="enableValidation" onclick="$('#dataform').form('enableValidation');$('#dataform').form('validate');"/>

<input type="button" value="disableValidation" onclick="$('#dataform').form('disableValidation')"/>

<input type="button" value="readonly" onclick="formReadonly('dataform', true)"/>
	
<input type="button" value="notReadonly" onclick="formReadonly('dataform', false)"/>


<script type="text/javascript">

function body_onload() {
	$('#dataform').form({  
        onSubmit:function(){
        	alert($(this).form('validate'));
        	alert("111")
            return $(this).form('validate');  
        },  
        success:function(data){  
            alert(data);  
        }  
    });   
} 

function destroyTopWindow() {
	try {
		window.top.destroyWindow('www');
	}
	catch (err) {}
}

// 页面加载完成事件
window.onload = function() {
	body_onload();
	destroyTopWindow();
}

// 页面退出事件
window.onbeforeunload = function() {
	destroyTopWindow();
}
</script>
  
</body>
</html>