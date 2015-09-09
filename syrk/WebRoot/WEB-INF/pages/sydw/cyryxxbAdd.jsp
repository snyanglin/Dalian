<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>从业人员</title>
</head>
<script type="text/javascript">
	var sflzdm = "${entity.sflzdm }";
	var gjdm = "${entity.gjdm}";
</script>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/cyryxxbAdd.js"></script>
<body>
	<div style="width: 98%;height: 100%;" align="center">
    <form action="<%=basePath%>cyryxxb/save" id="dataForm" name="dataForm" method="post" onsubmit="alert('ssss')">
        <input type="hidden" name="dwid" id="dwid" value="${entity.dwid }"  />
    	<input type="hidden" name="id" id="id" value="${entity.id }" /><!-- 从业人员id -->
    	<input type="hidden" name="ryid" id="ryid" value="${entity.ryid}"/>
    	<input type="hidden" name="jjlxr_ryid" id="jjlxr_ryid" value="${entity.jjlxr_ryid }" /><!-- 紧急情况联系人ID -->
    	<div class="easyui-accordion" data-options="multiple:true" style="width:820px;margin-left: 20px;margin-top: 10px;margin-right: 5px;margin-bottom: 10px;"> 
    		<div title="基本信息" id="baseInfoTypeDiv" data-options="selected:true" style="overflow:auto;padding:10px;">   
    		<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
			    	<td width="30%" class="dialogTd">
			    	 	<input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:200px;" value="${entity.cyzjdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
			    	<td width="30%" class="dialogTd" align="left">
			    	  	<input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm }" maxlength="30" 
			    		data-options="required:true,tipPosition:'left'"/>
			    		<div class="lodingimg" id="yrjbxxDiv"></div>
			    	</td>
		    	</tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xm" name="xm" style="width:200px;" value="${entity.xm }" maxlength="20" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${entity.xbdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input type="text" name="csrq" id="csrq" class="easyui-validatebox" style="width: 200px;" value="${entity.csrq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">民族：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:200px;" value="${entity.mzdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">文化程度：</td>
			    	<td width="30%" class="dialogTd">
			    		<input type="text" name="whcddm" id="whcddm" class="easyui-combotree" style="width:200px;" value="${entity.whcddm }"
		    			data-options="url: contextPath + '/common/dict/D_BZ_WHCD.js',onlyLeaf:true,dataFilter:'',multiple:false,required:false,panelWidth:200,method:'get',
		    			editable:true,lines:true,tipPosition:'right'">
					</td>
					<td width="20%" class="dialogTd" align="right">国籍：</td>
			    	<td width="30%" class="dialogTd">
			    		<input type="text" name="gjdm" id="gjdm" value="" class="easyui-combobox" style="width:200px;" value="${entity.gjdm }"
		    			data-options="url: contextPath + '/common/dict/D_BZ_SJGGHDQMCDM.js',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'">
			    	</td>
			    </tr>
				<!--  dz_hjdmlpxz;dz_hjdmlpdm -->	
				<tr class="dialogTr" id="hjdz">
					<td width="20%" class="dialogTd" align="right" >户籍地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
						<input class="easyui-combobox" id="hjd1" style="width:400px;" value="${entity.dz_hjdmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type='hidden' name='dz_hjdmlpdm' id="dz_hjdmlpdm" value="${entity.dz_hjdmlpdm}"/>
						<input type='hidden' name='dz_hjdmlpxz' id="dz_hjdmlpxz" value="${entity.dz_hjdmlpxz}"/>
					</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-combobox" id="hjd2" style="width:200px;" value='${fn:replace(entity.dz_hjdxz, entity.dz_hjdmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    <input type='hidden' name='dz_hjddm' id='dz_hjddm' value="${entity.dz_hjddm}" />
					    <input type='hidden' name='dz_hjdxzqhdm' id='dz_hjdxzqhdm' value="${entity.dz_hjdxzqhdm}" />
					    <input type='hidden' name='dz_hjdxz' id='dz_hjdxz' value="${entity.dz_hjdxz}" /> 
					</td>
				</tr>
			   <tr class="dialogTr" id="jzdz">
					<td width="20%" class="dialogTd" align="right">现居地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
						<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_xzzdmlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type='hidden' name='dz_xzzdmlpdm' id="dz_xzzdmlpdm" value="${entity.dz_xzzdmlpdm}"/>
						<input type='hidden' name='dz_xzzdmlpxz' id="dz_xzzdmlpxz" value="${entity.dz_xzzdmlpxz}"/>
					</td>
					<td width="30%" class="dialogTd">
					    <input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_xzzxz, entity.dz_xzzdmlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    <input type='hidden' name='dz_xzzdm' id='dz_xzzdm' value="${entity.dz_xzzdm}" />
					    <input type='hidden' name='dz_xzzxzqhdm' id='dz_xzzxzqhdm' value="${entity.dz_xzzxzqhdm}" />
					    <input type='hidden' name='dz_xzzxz' id='dz_xzzxz' value="${entity.dz_xzzxz}" /> 
				    </td>	
				</tr>
    		</table>
    		</div>
    		
    		<div title="从业信息" id="cyryInfoTypeDiv" data-options="selected:true" style="overflow:auto;padding:10px;">  
    		<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
    			<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">简历：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<textarea name="jl" id="jl" class="easyui-validatebox" style="width: 595px; height:48px;"
						data-options="validType:['maxLength[4000]'],invalidMessage:'简历不能超过4000个汉字，请重新输入！',required:false,tipPosition:'left'">${entity.jl }</textarea></td>
	    		</tr>
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">所在部门：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input class="easyui-validatebox" type="text" id="szbmmc" name="szbmmc" style="width:595px;" value="${entity.szbmmc }" 
			    		maxlength="50" data-options="required:false,tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">职业类别：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-combotree" type="text" id="zylbdm" name="zylbdm" style="width:200px;" value="${entity.zylbdm}"
					data-options="required:false,tipPosition:'right',url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true"/>
				    </td>
					<td width="20%" class="dialogTd" align="right">聘用时间：</td>
			    	<td width="30%" class="dialogTd">
			    	<input type="text" name="pyrq" id="pyrq" class="easyui-validatebox" style="width: 200px;" value="${entity.pyrq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;" value="${entity.lxdh }" maxlength="18"
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">劳务性质：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-validatebox" type="text" id="lwxz" name="lwxz" style="width:200px;" value="${entity.lwxz }" 
			    		maxlength="50"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">劳务合同签署公司：</td>
		    		<td width="80%" class="dialogTd"  colspan="3">
						<input type="hidden" name="sslwgsid" id="sslwgsid" value="${entity.sslwgsid}"/>
						<input type="hidden" name="sslwgsmc" id="sslwgsmc" value="${entity.sslwgsmc}"/>
						<input type="text" id="gzdw-box" name="gzdw-box" value="${entity.sslwgsmc}" maxlength="50" class="easyui-combobox" 
							style="width:595px;" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',
							textField:'text',selectOnNavigation:false,required:false"   />
					</td>
			    </tr>
			    <tr class="dialogTr">
		    		<td width="20%" class="dialogTd" align="right">是否离职：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-combobox" type="text" id="sflzdm" name="sflzdm" style="width:200px;" value="${entity.sflzdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:lzCheck"/>
			    	</td>
		    		<td width="20%" class="dialogTd" align="right">离职日期：</td>
			    	<td width="30%" class="dialogTd">
			    	<input type="text" name="lz_rq" id="lz_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.lz_rq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">离职原因：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input class="easyui-validatebox" type="text" id="lzyy" name="lzyy" style="width:595px;" value="${entity.lzyy }" 
			    		maxlength="1000" data-options="required:false,tipPosition:'left'"/>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">离职去向：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    	<input class="easyui-validatebox" type="text" id="lzqx" name="lzqx" style="width:595px;" value="${entity.lzqx }" 
			    		maxlength="100" data-options="required:false,tipPosition:'left'"/>
			    	</td>
		    	</tr>
    		</table> 
    		</div>
    		
    		<div title="紧急联系人信息" id="jjlxrInfoTypeDiv" data-options="" style="overflow:auto;padding:10px;">   
    		<table border="0" cellpadding="0" cellspacing="10" style="width: 100%;" align="center">
    			<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-combobox" type="text" id="jjlxr_cyzjdm" name="jjlxr_cyzjdm" style="width:200px;" value="${entity.jjlxr_cyzjdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-validatebox" type="text" id="jjlxr_zjhm" name="jjlxr_zjhm" style="width:200px;float:left;" value="${entity.jjlxr_zjhm }" maxlength="30" 
			    		data-options="required:false,tipPosition:'left'"/><div class="lodingimg" id="jjlxrDiv" ></div>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-validatebox" type="text" id="jjlxr_xm" name="jjlxr_xm" style="width:200px;" value="${entity.jjlxr_xm }" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-combobox" type="text" id="jjlxr_xbdm" name="jjlxr_xbdm" style="width:200px;" value="${entity.jjlxr_xbdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">电话：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-validatebox" type="text" id="jjlxr_lxdh" name="jjlxr_lxdh" style="width:200px;" value="${entity.jjlxr_lxdh }" maxlength="18"
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">与从业人员其关系：</td>
			    	<td width="30%" class="dialogTd">
			    	<input class="easyui-combobox" type="text" id="ycyrygxdm" name="ycyrygxdm" style="width:200px;" value="${entity.ycyrygxdm}"
						data-options="url: contextPath + '/common/dict/D_BZ_RYGX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
		    		</td>
			    </tr>
    		</table>
    		</div>
    	</div>
    </form>
    </div>
</body>	
</html>