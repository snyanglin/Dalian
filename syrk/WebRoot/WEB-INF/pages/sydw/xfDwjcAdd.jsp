<!--  
	@updateAuthor: [yuguangli@founder.com]
	@updateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位检查信息</title>
<style>
.thhead {
	text-align: center;
	background: #e1e1e1;
	border: 1px solid #cccccc;
}

.tdbr {
	border-right: 1px solid #95B8E7;;
	border-bottom: 1px solid #95B8E7;;
}

.tdb {
	border-bottom: 1px solid #95B8E7;
}
.tdr {
	border-right: 1px solid #95B8E7;
}
</style>
</head>
<body>
	<form action="<%=basePath%>dwjcxxb/save" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
		<table border="0" cellpadding="0" cellspacing="10" width="845px" align="center">
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<input type="hidden" name="ywlbdm" id="ywlbdm" value="11"/>
			<input type="hidden" name="rwid" id="rwid" value="${rwid}" />
			<tr class="dialogTr">
				<td width="16%" class="dialogTd" align="right">单位(场所)名称：</td>
				<td width="36%" class="dialogTd">
					<input class="easyui-validatebox inputreadonly" type="text" id="dwmc" name="dwmc" readonly="readonly"  style="width:200px;"  value="${entity.dwmc}"/>
				</td>
				<td width="18%" class="dialogTd" align="right">法定代表人/主要负责人：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" name="dwfzr" id="dwfzr"
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
						style="width:200px" value="${entity.dwfzr}" />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="16%" class="dialogTd" align="right">地址：</td>
				<td width="54%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="jzd1" style="width:200px;" value="${entity.dz_dwdzmlpxz}" 
						data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true">
					<input type='hidden' name='dz_dwdzmlpdm' id="dz_dwdzmlpdm" value="${entity.dz_dwdzmlpdm}"/>
					<input type='hidden' name='dz_dwdzmlpxz' id="dz_dwdzmlpxz" value="${entity.dz_dwdzmlpxz}"/>
								
					<input class="easyui-combobox" id="jzd2"  style="width:80px;" value='${fn:replace(entity.dz_dwdzxz, entity.dz_dwdzmlpxz, "")}' 
			    	 	data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true">
			    	<input type='hidden' name='dz_dwdzdm' id='dz_dwdzdm' value="${entity.dz_dwdzdm}" />
			    	<input type='hidden' name='dz_dwdzssxdm' id='dz_dwdzssxdm' value="${entity.dz_dwdzssxdm}" />
			    	<input type='hidden' name='dz_dwdzxz' id='dz_dwdzxz' value="${entity.dz_dwdzxz}" /> 
			    	　　　　&nbsp;单位性质：	<!-- 对应单位的经营性质 -->		
				</td>
				<td width="30%" class="dialogTd">
					<input class='easyui-combobox' type='text' id='jjlxdm' name='jjlxdm' value="${entity.jjlxdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:true,method:'get',tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="16%" class="dialogTd" align="right">使用的建筑面积：</td>
				<td width="36%" class="dialogTd">
					<input class="easyui-validatebox" type="text" name="sydjzmj" id="sydjzmj" style="width:200px;"
						data-options="validType:['numeric[\'f\',2]'],required:false,tipPosition:'right'"  value="${entity.sydjzmj}"/>
				</td>
				<td width="18%" class="dialogTd" align="right">使用的建筑具体层数：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" name="sydjzjtcs" id="sydjzjtcs" type="text" style="width:200px;" data-options="required:false,validType:['naturalNumberRange[1,100]'],tipPosition:'left'" value="${entity.sydjzjtcs}"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="16%" class="dialogTd" align="right">所在建筑高度：</td>
				<td width="36%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="szjzgd" name="szjzgd"  value="${entity.szjzgd}" 
						data-options="validType:['numeric[\'f\',2]'],required:false,tipPosition:'right'" maxlength="10" style="width: 200px;"/> 
				</td>
				<td width="18%" class="dialogTd" align="right">监督检查人员：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" name="jcry" id="jcry" data-options="required:false,validType:['maxLength[100]'],tipPosition:'left'" value="${entity.jcry}" style="width:200px" />
				</td>
			</tr>
			<tr>
				<td width="16%" class="dialogTd" align="right">单位随同检查人员：</td>
				<td width="36%" class="dialogTd">
					<input class="easyui-validatebox" type="text" name="xcfzr" id="xcfzr" value="${entity.xcfzr}"
						data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"
						style="width:200px;" />
				</td>
				<td width="18%" class="dialogTd" align="right">检查日期：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" name="jcsj" id="jcsj" style="width:200px;"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" value="${entity.jcsj}"/>
				</td>
			</tr>
			</tr>
			<tr class="dialogTr">
				<td width="16%" class="dialogTd" align="right" style="vertical-align: top;">
					<br />检查内容和情况记录：
				</td>
				<td width="84%" class="dialogTd" colspan="3">
					<jsp:include page="/WEB-INF/pages/sydw/xfjcTemp.jsp"></jsp:include>
				</td>
			</tr>
			<tr>
				<td width="16%" class="dialogTd" align="right">检查情况：</td>
				<td width="84%" class="dialogTd" colspan='3'>
					<textarea id="jcjg" name="jcjg" class="easyui-validatebox" style="width: 650px;height:48px;"
						data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.jcjg}</textarea>
				</td>
			</tr>
			<tr>
				<td width="16%" class="dialogTd" align="right">整改或处罚意见：</td>
				<td width="84%" class="dialogTd" colspan='3'>
					<textarea id="zghcfyj" name="zghcfyj" class="easyui-validatebox" style="width: 650px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zghcfyj}</textarea>
				</td>
			</tr>
			<tr>
				<td width="16%" class="dialogTd" align="right">备注：</td>
				<td width="84%" class="dialogTd" colspan='3'>
					<textarea id="bz" name="bz" class="easyui-validatebox" style="width:650px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script type="text/javascript">
	var fxjdm = "${fxjdm}";
	var pcsdm = "${pcsdm}";
	var zrqdm = "${zrqdm}";
	var list = ${list};
	var mainTabID = "${mainTabID}";
	var flag = "${flag}";
	function doInit(paramArray) {
		if(paramArray["mode"]=="view"){
			$("#zt").combobox('reload',contextPath + '/common/dict/BD_D_DWZAJCZTDM.js');  
			$("#zt").combobox("setValue","${entity.zt}");
		}
		if(paramArray["dwmc"]){
			$("#dwmc").val(paramArray["dwmc"]);
			$("#ywlbdm").val(paramArray["ywlbdm"]);
		}
		checkboxToRadio();
		initAddressSearch('jzd1', {fxjdm:fxjdm,pcsdm:pcsdm,zrqdm:zrqdm}, 'dz_dwdzmlpdm', 'dz_dwdzmlpxz', 'jzd2', {text:'dz_dwdzxz',dzxzqh:'dz_dwdzssxdm',id:'dz_dwdzdm'}, null, null);
		//检查内容和情况记录赋值
		if(list!=""){
			$("input[type=checkbox][id='ch_a446ffe0b10c494db6b2b12b832fc8ca']").attr("checked",false);
			for(var i=0;i<list.length;i++){
				var type = list[i]; 
				if(type.list!=""){
					for(var j=0;j<type.list.length;j++){
						var data = type.list[j];
						if(data!=""){
							if(data.def){
								$("input[type=checkbox][id='ch_"+data.id+"'][value='"+data.def+"']").attr("checked","checked");
								if(data.def=="1"&&data.id=="a446ffe0b10c494db6b2b12b832fc8ca"){
									if("${entity.zt}"==40){
										$("#zt").combobox("loadData",[{id:"40",text:"复查检查"}]);
										$("#zt").combobox("setValue","40");
										$("#zt").combobox("setText","复查检查");
									}else{
										$("#zt").combobox("loadData",[{id:"99",text:"日常检查"}]);
										$("#zt").combobox("setValue","99");
										$("#zt").combobox("setText","日常检查");
										
									}
									$('#zgfs').find('input[type="text"]').each(function(i,o){
										$(o).attr("readonly","readonly");
										$(o).addClass("inputReadonly");
										$(o).next(".combo").addClass("inputReadonly");
									});
								}
							}
							if(data.bz){
								$("#bz_"+data.id).val(data.bz);
							}
						}
					}
				}
			}
			var checkboxs = $("input:checkbox[id='ch_cfbb02a6fe8c424f8502fb1c7cbb8e62']:checked");
			var def = "";
			if (checkboxs.length == 1) {
				def = checkboxs[0].value;
				$("#fxdxld").val(Number(def)+1);
			}
		}else{
			if(flag=="checked"){
				$("#zt").combobox("loadData",[{id:"40",text:"复查检查"}]);
				$("#zt").combobox("setValue","40");
				$("#zt").combobox("setText","复查检查");
			}else{
				$("#zt").combobox("loadData",[{id:"99",text:"日常检查"}]);
				$("#zt").combobox("setValue","99");
				$("#zt").combobox("setText","日常检查");
			}
			$('#zgfs').find('input[type="text"]').each(function(i,o){
				$(o).attr("readonly","readonly");
				$(o).addClass("inputReadonly");
				$(o).next(".combo").addClass("inputReadonly");
			});
		}
		//移送公安消防机构处理的内容  单击事件填写第几项
		$("input:checkbox[id='ch_cfbb02a6fe8c424f8502fb1c7cbb8e62']").click(function(){
			$("#fxdxld").val("");
			var checkboxs = $("input:checkbox[id='ch_cfbb02a6fe8c424f8502fb1c7cbb8e62']:checked");
			var def = "";
			if (checkboxs.length == 1) {
				def = checkboxs[0].value;
				$("#fxdxld").val(Number(def)+1);
			}
		});
		//检查结果 合格和不合格单击事件
		$("input:checkbox[id='ch_a446ffe0b10c494db6b2b12b832fc8ca']").click(function(){
			$("#zt").combobox("loadData",[{id:"99",text:"日常检查"}]);
			$("#zt").combobox("setValue","99");
			$("#zt").combobox("setText","日常检查");
			$('#zgfs').find('input[type="text"]').each(function(i,o){
				$(o).attr("readonly","readonly");
				$(o).addClass("inputReadonly");
				$(o).next(".combo").addClass("inputReadonly");
			});
			if(this.value=="0"){
				if(this.checked&&flag=="checked"){
					$("#zt").combobox("loadData",[{id:"100",text:"转执法办案"}]);
					$("#zt").combobox("setValue","100");
					$('#zgfs').find('input[type="text"]').each(function(i,o){
						$(o).attr("readonly","readonly");
						$(o).addClass("inputReadonly");
						$(o).next(".combo").addClass("inputReadonly");
					});
				}else if(this.checked){
					$("#zt").combobox('reload',contextPath + '/common/dict/BD_D_ZGFSDM.js');  
					$("#zt").combobox("setValue","");
					$("#zt").combobox("setText","");
					$('#zgfs').find('input[type="text"]').each(function(i,o){
						$(o).attr("readonly",false);
						$(o).removeClass("inputReadonly");
						$(o).next(".combo").removeClass("inputReadonly");
					});
				}
			}
		});
		if(paramArray["mode"]=="view"){
			$('#dataForm').find('input[type="text"]').each(function(i,o){
				$(o).attr("readonly","readonly");
				$(o).addClass("inputReadonly");
				$(o).next(".combo").addClass("inputReadonly");
			});
			$('#dataForm').find('textarea').each(function(i,o){
				$(o).attr("readonly","readonly");
				$(o).addClass("inputReadonly");
			});
			$('#dataForm').find('input[type="checkbox"]').each(function(i,o){
				$(o).attr("disabled","disabled");
			});
			$('#orgbutton1').hide();
		}else if(paramArray["mode"]=="select"){
			//单位选择组件
			initDepartmentSearch("dw-box", {glpcsid: ''}, 'dwid', 'dwmc', null, null);
		}
	}
	function beforeSubmit() {
		var jcxparamsMap = "[";
		$("input:hidden[id^='type_']").each(function(index, domEle) {
			var typeid = $(domEle).val();
			jcxparamsMap += "{\"typeid\":\"" + typeid + "\",\"list\":[";
			$("input:hidden[id='data_" + typeid + "']").each(function(index, domEle) {
				var dataid = $(domEle).val();
				var checkboxs = $("input:checkbox[id='ch_" + dataid + "']:checked");
				var def = "";
				if (checkboxs.length == 1) {
					def = checkboxs[0].value;
				};
				var bz = $("#bz_" + dataid).text();
				jcxparamsMap += "{\"dataid\":\""+ dataid + "\",\"def\":\"" + def + "\",\"bz\":\"" + bz + "\"},";
			});
			jcxparamsMap += "],";
			jcxparamsMap = jcxparamsMap.replace("},]", "}]}");
		});
		jcxparamsMap += "]";
		jcxparamsMap = jcxparamsMap.replace("},]", "}]");
		$("#jcxmx").val(jcxparamsMap);
		//校验检查结果必填
		var checkboxs = $("input:checkbox[id='ch_a446ffe0b10c494db6b2b12b832fc8ca']:checked");
		if (checkboxs.length == 0) {
			topMessager.alert('', '检查结果必填项！');
			return false;
		}
	}

	function afterSubmit(arr) {
		if (arr["saveID"]) {
			$("#pk").val(arr["saveID"]);
		}
		var openFlag = false;
		var editUrl = contextPath + "/forward/sydw|zlxqzgxxbAdd?jcid="+arr["saveID"]+"&mainTabID="+mainTabID;
		if(arr["ZT"]=="10"){
			editUrl = contextPath + "/forward/sydw|zlxqzgxxbAdd?jcid="+arr["saveID"]+"&mainTabID="+mainTabID;
			openFlag = true;
		}else if(arr["ZT"]=="20"){
			editUrl = contextPath + "/forward/sydw|zdhzyhzgAdd?jcid="+arr["saveID"]+"&mainTabID="+mainTabID;
			openFlag = true;
		}else if(arr["ZT"]=="30"){
			editUrl = contextPath + "/forward/sydw|lscfzgAdd?jcid="+arr["saveID"]+"&mainTabID="+mainTabID;
			openFlag = true;
		}else if(arr["ZT"]=="100"){
			alert("走执法办案！");
		}
		if(openFlag){
			window.top.openWindowWithSave(false, null, window, 
		   		{dwid:"${entity.dwid}",jcid:arr["saveID"],dwmc:$("#dwmc").val()}, 
		   		{
		   		title: '录入整改通知书',
		   		url: editUrl,
		   		width: 880,
		   		height:500
		   		}, 
		   		null, null,null
		   	);
		}
		executeTabPageMethod(mainTabID, "queryButton()");
	}
	//多选框模拟 单选
	function checkboxToRadio() {
		checkboxs = $("input:checkbox[id^='ch_']");
		for (i = 0; i < checkboxs.length; i++) {
			checkboxs[i].onclick = function() {
				for (j = 0; j < checkboxs.length; j++) {
					if (this.id == checkboxs[j].id && this.value != checkboxs[j].value && checkboxs[j].checked == true) {
						checkboxs[j].checked = false;
					}
				}
			};
		};
	};
</script>