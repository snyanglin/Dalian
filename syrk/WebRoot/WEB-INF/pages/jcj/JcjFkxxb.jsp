<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>接处警反馈信息</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>jcj/saveFkxxb" id="syfwForm" name="dataForm" method="post">
	    <input type="hidden" name="jjbh" value="${entity.jjbh }"/>
	    <input type="hidden" name="xzqhdm" value="${entity.xzqhdm }"/>
	    <input type="hidden" name="cjdbh" value="${entity.cjdbh }"/>
		<div data-options="region:'center', split:true"
			style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%"
				align="left">
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">警情类别:</td>
					<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jqlbdm" name="jqlbdm" style="width:200px;"  value="${entity.jqlbdm }"
							data-options="required:true,panelWidth:280,url: contextPath + '/common/dict/D_JCJ_JQLBDM.js',multiple:false,method:'get',editable:true,lines:true" />
					</td>

					<td width="20%" class="dialogTd" align="right">警情等级:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="jqdjdm" name="jqdjdm"
						style="width:200px;" value="${entity.jqdjdm }"
						data-options="url: contextPath + '/common/dict/D_JCJ_JQDJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'" />
					</td>
				</tr>


				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">警情发生时间:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="jqfs_sj" id="jqfs_sj" class="easyui-validatebox"
						style="width: 200px;" value="${entity.jqfs_sj }"
						data-options="required:true"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s'})" />
					</td>

					<td width="20%" class="dialogTd" align="right">警情结束时间:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="jqjs_sj" id="jqjs_sj" class="easyui-validatebox"
						style="width: 200px;" value="${entity.jqjs_sj }"
						data-options="required:true"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'jqfs_sj\') || \'%y-%M-%d %h:%m:%s\'}'})" />
					</td>
				</tr>





				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">到达现场时间:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="ddxc_sj" id="ddxc_sj" class="easyui-validatebox"
						style="width: 200px;" value="${entity.ddxc_sj }"
						data-options="required:true"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'jqfs_sj\') || \'%y-%M-%d %h:%m:%s\'}'})" />
					</td>

					<td width="20%" class="dialogTd" align="right">处理完毕时间:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="clwb_sj" id="clwb_sj" class="easyui-validatebox"
						style="width: 200px;" value="${entity.clwb_sj }"
						data-options="required:true"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'ddxc_sj\') || \'%y-%M-%d %h:%m:%s\'}'})" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出警情况:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="cjqk" name="cjqk"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[150]'],invalidMessage:'出警情况不能超过150个汉字，请重新输入！',tipPosition:'right'">${entity.cjqk }</textarea>
					</td>
				</tr>


				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">处理结果:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="cljgdm" name="cljgdm"
						style="width:200px;" value="${entity.cljgdm }"
						data-options="url: contextPath + '/common/dict/D_JCJ_CLJGDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'" />
					</td>

					<td width="20%" class="dialogTd" align="right">警情状态:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="jqztdm" name="jqztdm"
						style="width:200px;" value="${entity.jqztdm }"
						data-options="url: contextPath + '/common/dict/D_JCJ_JQZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'c'" />
					</td>

				</tr>



				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">处理结果:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="cljg" name="cljg"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[300]'],invalidMessage:'处理结果不能超过300个汉字，请重新输入！',tipPosition:'right'">${entity.cljg }</textarea>
					</td>
				</tr>


				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出动车辆情况:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="cdclqk" name="cdclqk"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[100]'],invalidMessage:'出动车辆情况不能超过100个汉字，请重新输入！',tipPosition:'right'">${entity.cdclqk }</textarea>
					</td>
				</tr>



				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出动人员情况:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="cdryqk" name="cdryqk"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[100]'],invalidMessage:'出动人员情况不能超过100个汉字，请重新输入！',tipPosition:'right'">${entity.cdryqk }</textarea>
					</td>
				</tr>

				<tr class="dialogTr">

					<td width="20%" class="dialogTd" align="right">抓获人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="zh_rs" id="zh_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.zh_rs }" value="0"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>

					<td width="20%" class="dialogTd" align="right">涉案人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="sa_rs" id="sa_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.sa_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>
				</tr>


				<tr class="dialogTr">

					<td width="20%" class="dialogTd" align="right">救助人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="jz_rs" id="jz_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.jz_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>

				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">救助人数说明:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="jzrssm" name="jzrssm"
							style="width:620px; height:48px;" value="${entity.jz_rs }"
							data-options="required:false,validType:['maxLength[100]'],invalidMessage:'救助人数说明不能超过100个汉字，请重新输入！',tipPosition:'right'">${entity.jzrssm }</textarea>
					</td>
				</tr>


				<tr class="dialogTr">

					<td width="20%" class="dialogTd" align="right">逃跑人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="jj_rf" id="jj_rf" class="easyui-validatebox"
						style="width: 200px;" value="${entity.jj_rf }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>

					<td width="20%" class="dialogTd" align="right">解救人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="jj_rs" id="jj_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.jj_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">解救人数说明:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="jjrssm" name="jjrssm"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[500]'],invalidMessage:'解救人数说明不能超过500个汉字，请重新输入！',tipPosition:'right'">${entity.jjrssm }</textarea>
					</td>
				</tr>



				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">死亡人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="sw_rs" id="sw_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.sw_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>

					<td width="20%" class="dialogTd" align="right">受伤人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="ss_rs" id="ss_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.ss_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">受伤人数说明:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="ssrssm" name="ssrssm"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[250]'],invalidMessage:'受伤人数说明不能超过250个汉字，请重新输入！',tipPosition:'right'">${entity.ssrssm }</textarea>
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">死亡人数说明:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="swrssm" name="swrssm"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[250]'],invalidMessage:'死亡人数说明不能超过500个汉字，请重新输入！',tipPosition:'right'">${entity.swrssm }</textarea>
					</td>
				</tr>



				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">待救援人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="djy_rs" id="djy_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.djy_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>

					<td width="20%" class="dialogTd" align="right">出警受伤人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="cjryss_rs" id="cjryss_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.cjryss_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出警死亡人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="cjrysw_rs" id="cjrysw_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.cjrysw_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">经济损失:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="jjssqk" name="jjssqk"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[250]'],invalidMessage:'经济损失不能超过250个汉字，请重新输入！',tipPosition:'right'">${entity.jjssqk }</textarea>
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">挽回经济损失:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="whjjssqk" name="whjjssqk"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[250]'],invalidMessage:'挽回经济损失不能超过250个汉字，请重新输入！',tipPosition:'right'">${entity.whjjssqk }</textarea>
					</td>
				</tr>


				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否破获刑事案件:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="sfphxsaj" name="sfphxsaj"
						style="width:200px;" value="${entity.sfphxsaj }"
						data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>

					<td width="20%" class="dialogTd" align="right">是否查处治安案件:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="sfcczaaj" name="sfcczaaj"
						style="width:200px;" value="${entity.sfcczaaj }"
						data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否解决纠纷:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="sfjjjf" name="sfjjjf"
						style="width:200px;" value="${entity.sfjjjf }"
						data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					<td width="20%" class="dialogTd" align="right">留置审查人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="cjrysw_rs" id="cjrysw_rs" class="easyui-validatebox"
						style="width: 200px;" value="${entity.cjrysw_rs }"
						data-options="validType:['numeric[\'i\']']" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">警情处理结果:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="jqcl_jg" name="jqcl_jg"
							style="width:620px; height:48px;"
							data-options="required:true,validType:['maxLength[1000]'],invalidMessage:'警情处理结果不能超过1000个汉字，请重新输入！',tipPosition:'right'">${entity.jqcl_jg }</textarea>
					</td>
				</tr>


				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">损失情况描述:</td>
					<td width="80%" class="dialogTd" colspan="3"><textarea
							class="easyui-validatebox" id="ssqkms" name="ssqkms"
							style="width:620px; height:48px;"
							data-options="required:false,validType:['maxLength[500]'],invalidMessage:'损失情况描述不能超过500个汉字，请重新输入！',tipPosition:'right'">${entity.ssqkms }</textarea>
					</td>
				</tr>

				<tr>
					<td width="20%" class="dialogTd" align="right">天气:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="tqdm" name="tqdm"
						style="width:200px;" value="${entity.tqdm }"
						data-options="url: contextPath + '/common/dict/D_JCJ_TQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">火灾原因:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="hzyydm" name="hzyydm"
						style="width:200px;" value="${entity.hzyydm }"
						data-options="url: contextPath + '/common/dict/D_BZ_QHYYFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					<td width="20%" class="dialogTd" align="right">灾害事故类型:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="zhsglxdm" name="zhsglxdm"
						style="width:200px;" value="${entity.zhsglxdm }"
						data-options="url: contextPath + '/common/dict/D_JCJ_HZCSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
				</tr>
				
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">起火物:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id=" " name="qhwdm"
						style="width:200px;" value="${entity.hzyydm }"
						data-options="url: contextPath + '/common/dict/D_BZ_QHWFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					<td width="20%" class="dialogTd" align="right">起火建筑结构:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="zhsglxdm" name="zhsglxdm"
						style="width:200px;" value="${entity.zhsglxdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_JZWJGLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
				</tr>
				

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">火灾场所:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="hzcsdm" name="hzcsdm"
						style="width:200px;" value="${entity.hzcsdm }"
						data-options="url: contextPath + '/common/dict/D_JCJ_HZCSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					<td width="20%" class="dialogTd" align="right">火灾等级:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="hzdjdm" name="hzdjdm"
						style="width:200px;" value="${entity.hzdjdm }"
						data-options="url: contextPath + '/common/dict/D_JCJ_HZDJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'" />
					</td>

				</tr>

				<tr class="dialogTr">


					<td width="20%" class="dialogTd" align="right">第一出动时间:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="dycd_sj" id="dycd_sj" class="easyui-validatebox"
						style="width: 200px;" value="${entity.dycd_sj }"
						data-options="required:false"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s'})" />
					</td>

					<td width="20%" class="dialogTd" align="right">第一到场时间:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="dydc_sj" id="dydc_sj" class="easyui-validatebox"
						style="width: 200px;" value="${entity.dydc_sj }"
						data-options="required:false"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'dycd_sj\') || \'%y-%M-%d %h:%m:%s\'}'})" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">火场扑灭时间:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="hcpm_sj" id="hcpm_sj" class="easyui-validatebox"
						style="width: 200px;" value="${entity.hcpm_sj }"
						data-options="required:false"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'dydc_sj\') || \'%y-%M-%d %h:%m:%s\'}'})" />
					</td>

					<td width="20%" class="dialogTd" align="right">撤离时间:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="cl_sj" id="cl_sj" class="easyui-validatebox"
						style="width: 200px;" value="${entity.cl_sj }"
						data-options="required:false"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'hcpm_sj\') || \'%y-%M-%d %h:%m:%s\'}'})" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">现场总指挥:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="xczzh" id="xczzh" class="easyui-validatebox" maxlength="50"
						style="width: 200px;" value="${entity.xczzh }"
						data-options="required:false" />
					</td>

					<td width="20%" class="dialogTd" align="right">出动水枪数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="cdsqs" id="cdsqs" class="easyui-validatebox"
						style="width: 200px;" value="${entity.cdsqs }"
						data-options="validType:['numeric[\'i\']']" />
					</td>
				</tr>



				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否重点单位:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="sfzddw" name="sfzddw"
						style="width:200px;" value="${entity.sfzddw }"
						data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>

					<td width="20%" class="dialogTd" align="right">重点单位名称:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="zd_dwmc" id="zd_dwmc" class="easyui-validatebox"
						style="width: 200px;" value="${entity.zd_dwmc }"
						data-options="required:false" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">下落不明人数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="xlbm_rs" id="xlbm_rs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.xlbm_rs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>

					<td width="20%" class="dialogTd" align="right">道路交通事故形态:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="dljtsgxtdm"
						name="dljtsgxtdm" style="width:200px;"
						value="${entity.dljtsgxtdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_JTSGXTFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否装载危险品:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="sfwhp" name="sfwhp"
						style="width:200px;" value="${entity.sfwhp }"
						data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>

					<td width="20%" class="dialogTd" align="right">交通事故初查原因:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="sgccyydm" name="sgccyydm"
						style="width:200px;" value="${entity.sgccyydm }"
						data-options="url: contextPath + '/common/dict/D_BZ_JTSGYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>
				</tr>


				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">能见度:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="njddm" name="njddm"
						style="width:200px;" value="${entity.njddm }"
						data-options="url: contextPath + '/common/dict/D_JCJ_NJDDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>

					<td width="20%" class="dialogTd" align="right">道路路面状况:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="dllmzkdm" name="dllmzkdm"
						style="width:200px;" value="${entity.dllmzkdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_DLLMZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>
				</tr>



				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">损坏机动车数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="shjdcs" id="shjdcs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.shjdcs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>

					<td width="20%" class="dialogTd" align="right">损坏非机动车数:</td>
					<td width="30%" class="dialogTd"><input type="text"
						name="shfjdcs" id="shfjdcs" class="easyui-validatebox"
						style="width: 200px;" maxlength="4" value="${entity.shfjdcs }"
						data-options="required:true,validType:['numeric[\'i\']']" />
					</td>
				</tr>


				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">道路类型:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="dllxdm" name="dllxdm"
						style="width:200px;" value="${entity.dllxdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_DLLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					</td>
				</tr>

			</table>

		</div>
	</form>
</div>
</body>
</html>
<script type="text/javascript">

function doInit(paramArray) {
	windowID = paramArray['windowID'];
	var id="${entity.id}";
	if(id !=null &&id !=""){
		dialogSaveButtonHide(windowID);
	}
	
	dialogResetButtonHide(windowID);
	dialogButtonIsLoad(windowID);
}

function beforeSubmit(){}

function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#pk").val(arr["saveID"]);
	}
	//refreshJbxx();
	window.parent.location.reload();
}
</script>