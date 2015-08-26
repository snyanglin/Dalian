<!--  
	@updateAuthor: [xu_haibo@founder.com]
	@updateDate:   [2015-6-16 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技防检查信息</title>
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
		<input type="hidden" name="dwmc" id="dwmc"  />
		<input type="hidden" name="ywlbdm" id="ywlbdm" value="${entity.ywlbdm}"/>
		<input type="hidden" name="rwid" id="rwid" value="${rwid}" />
		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<tr class="dialogTr" id="tr1">
				<td width="23%" class="dialogTd" align="right">监督检查人员：</td>
				<td width="33%" class="dialogTd">
					<input class="easyui-validatebox" type="text" name="jcry" id="jcry"
						data-options="required:true,validType:['maxLength[50]'],tipPosition:'right'"
						style="width:200px" value="${entity.jcry}" />
				</td>
				<td width="21%" class="dialogTd" align="right">监督检查时间：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" name="jcsj" id="jcsj" style="width:200px;"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" value="${entity.jcsj}"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="23%" class="dialogTd" align="right">被检查单位（场所）名称：</td>
				<td width="33%" class="dialogTd">
					<input class="easyui-combobox" type="text" id="dw-box" readonly="readonly"  data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true"
						style="width:200px;" />
				</td>
				<td width="21%" class="dialogTd" align="right">单位性质：</td>
				<td width="30%" class="dialogTd">
					<input class='easyui-combobox' type='text' id='jjlxdm' name='jjlxdm' value="${entity.jjlxdm}" style="width:200px;"
			    	        data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:true,method:'get',tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="21%" class="dialogTd" align="right">地址：</td>
				<td width="54%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_dwdzmlpxz}" 
						data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true">
					<input type='hidden' name='dz_dwdzmlpdm' id="dz_dwdzmlpdm" value="${entity.dz_dwdzmlpdm}"/>
					<input type='hidden' name='dz_dwdzmlpxz' id="dz_dwdzmlpxz" value="${entity.dz_dwdzmlpxz}"/>
				</td>
				<td>
					<input class="easyui-combobox" id="jzd2"  style="width:200px;" value="${fn:replace(entity.dz_dwdzxz, entity.dz_dwdzmlpxz, '')}" 
			    	 	data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true,tipPosition:'left'">
			    	<input type='hidden' name='dz_dwdzdm' id='dz_dwdzdm' value="${entity.dz_dwdzdm}" />
			    	<input type='hidden' name='dz_dwdzssxdm' id='dz_dwdzssxdm' value="${entity.dz_dwdzssxdm}" />
			    	<input type='hidden' name='dz_dwdzxz' id='dz_dwdzxz' value="${entity.dz_dwdzxz}" /> 
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="23%" class="dialogTd" align="right">被检查单位法定代表人姓名：</td>
				<td width="33%" class="dialogTd">
						<input class="easyui-validatebox" type="text" name="fddbrxm" id="fddbrxm" value="${entity.fddbrxm}"
						data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"
						style="width:200px;" />
				</td>
				<td width="22%" class="dialogTd" align="right">联系电话：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" name="fddbrlxdh" id="fddbrlxdh" type="text" style="width:200px;" data-options="required:false,validType:'phone',tipPosition:'left'" value="${entity.fddbrlxdh}"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="23%" class="dialogTd" align="right">被检查单位分管负责人姓名：</td>
				<td width="33%" class="dialogTd">
						<input class="easyui-validatebox" type="text" name="dwfzr" id="dwfzr" value="${entity.dwfzr}"
						data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"
						style="width:200px;" />
				</td>
				<td width="22%" class="dialogTd" align="right">联系电话：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" name="dwfzrlxdh" id="dwfzrlxdh" type="text" style="width:200px;" data-options="required:false,validType:'phone',tipPosition:'left'" value="${entity.dwfzrlxdh}"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="23%" class="dialogTd" align="right">被检查单位（协助检查）人员：</td>
				<td width="33%" class="dialogTd">
						<input class="easyui-validatebox" type="text" name="xcfzr" id="xcfzr" value="${entity.xcfzr}"
						data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"
						style="width:200px;" />
				</td>
				<td width="22%" class="dialogTd" align="right">联系电话：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" name="xcfzrlxdh" id="xcfzrlxdh" type="text" style="width:200px;" data-options="required:false,validType:'phone',tipPosition:'left'" value="${entity.xcfzrlxdh}"/>
				</td>
			</tr>
			<tr>
				<td width="23%" class="dialogTd" align="right">被检查人签名：</td>
				<td width="33%" class="dialogTd">
					<input class="easyui-validatebox" type="text" name="bjcryxm" id="bjcryxm" value="${entity.bjcryxm}"
						data-options="required:false,validType:['maxLength[100]'],tipPosition:'right'"
						style="width:200px;" />
				</td>
				<td width="22%" class="dialogTd" align="right">联系电话：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" name="bjcrylxdh" id="bjcrylxdh" type="text" style="width:200px;" data-options="required:false,validType:'phone',tipPosition:'left'" value="${entity.bjcrylxdh}"/>
				</td>
			</tr>
			</tr>
			<tr class="dialogTr">
				<td width="23%" class="dialogTd" align="right" style="vertical-align: top;">
					<br />检查内容和情况记录：
				</td>
				<td width="78%" class="dialogTd" colspan="3">
					<jsp:include page="/WEB-INF/pages/sydw/jfjcTemp.jsp"></jsp:include>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="23%" class="dialogTd" align="right">检查结果：</td>
				<td width="33%" class="dialogTd"  colspan="3">
					<textarea id="jcjg" name="jcjg" class="easyui-validatebox" style="width: 634px;height:60px;"
						data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.jcjg}</textarea>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="23%" class="dialogTd" align="right">整改或处罚意见：</td>
				<td width="33%" class="dialogTd"  colspan="3">
					<textarea id="zghcfyj" name="zghcfyj" class="easyui-validatebox" style="width: 634px; height:60px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zghcfyj}</textarea>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="23%" class="dialogTd" align="right">检查情况：</td>
				<td width="33%" class="dialogTd"  colspan="3">
					<textarea id="bz" class="easyui-validatebox"  name="bz" style="width:634px;height: 60px;">${entity.bz}</textarea>
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
	var  list = ${list};
	var mainTabID = "${mainTabID}";
	var flag = "${flag}";
	var dwmc = "${dwmc}";
	function doInit(paramArray) {
		initAddressSearch('jzd1', {fxjdm:fxjdm,pcsdm:pcsdm,zrqdm:zrqdm}, 'dz_dwdzmlpdm', 'dz_dwdzmlpxz', 'jzd2', {text:'dz_dwdzxz',dzxzqh:'dz_dwdzssxdm',id:'dz_dwdzdm'}, null, null);
		$("#dwmc").val(paramArray["dwmc"]);
		$("#dw-box").combobox("setText",paramArray["dwmc"]);
		if(paramArray["dwmc"]==null||paramArray["dwmc"]==''){
			$("#dwmc").val(dwmc);
			$("#dw-box").combobox("setText",dwmc);
		}
		//$("#ywlbdm").val(paramArray["ywlbdm"]);
		//由于页面不需要复用，直接业务列别写死14
		$("#ywlbdm").val(14);
		setInputReadonly("dw-box", true);
		$('#zgfs').find('input[type="text"]').each(function(i,o){
			$(o).attr("readonly","readonly");
			$(o).addClass("inputReadonly");
			$(o).next(".combo").addClass("inputReadonly");
		});
				//检查内容和情况记录赋值
		if(list!=""){
			$("input[type=checkbox][id='ch_ddc442bde6e14a55838408a281dcb31e']").attr("checked",false);
			for(var i=0;i<list.length;i++){
				var type = list[i]; 
				if(type.list!=""){
					for(var j=0;j<type.list.length;j++){
						var data = type.list[j];
						if(data!=""){
							if(data.def){
								$("input[type=checkbox][id='ch_"+data.id+"'][value='"+data.def+"']").attr("checked","checked");
								if(data.def=="1"&&data.id=="ddc442bde6e14a55838408a281dcb31e"){
								if(flag=='checked'){
									$("#zt").combobox("loadData",[{id:"110",text:"复查检查"}]);
									$("#zt").combobox("setValue","110");
									$("#zt").combobox("setText","复查检查");
								}else{
									if($("#zt").val()==120||$("#zt").val()==110){
										$("#zt").combobox("loadData",[{id:"110",text:"复查检查"}]);
										$("#zt").combobox("setValue","110");
										$("#zt").combobox("setText","复查检查");
									}else{
										$("#zt").combobox("loadData",[{id:"99",text:"日常检查"}]);
										$("#zt").combobox("setValue","99");
										$("#zt").combobox("setText","日常检查");
									}
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
		}else{
			if(flag=='checked'){
				$("#zt").combobox("loadData",[{id:"110",text:"复查检查"}]);
				$("#zt").combobox("setValue","110");
				$("#zt").combobox("setText","复查检查");
			}else{
				if($("#zt").val()==120||$("#zt").val()==110){
					$("#zt").combobox("loadData",[{id:"110",text:"复查检查"}]);
					$("#zt").combobox("setValue","110");
					$("#zt").combobox("setText","复查检查");
				}else{
					$("#zt").combobox("loadData",[{id:"99",text:"日常检查"}]);
					$("#zt").combobox("setValue","99");
					$("#zt").combobox("setText","日常检查");
				}
			}
			$('#zgfs').find('input[type="text"]').each(function(i,o){
				$(o).attr("readonly","readonly");
				$(o).addClass("inputReadonly");
				$(o).next(".combo").addClass("inputReadonly");
			});
		};
				//检查结果 合格和不合格单击事件
		$("input:checkbox[id='ch_ddc442bde6e14a55838408a281dcb31e']").click(function(){

			$('#zgfs').find('input[type="text"]').each(function(i,o){
				$(o).attr("readonly","readonly");
				$(o).addClass("inputReadonly");
				$(o).next(".combo").addClass("inputReadonly");
			});
			if(this.value=="0"){
				if(this.checked){
					if(flag=='checked'){
						$("#zt").combobox("loadData",[{id:"100",text:"转执法办案"}]);
						$("#zt").combobox("setValue","100");
						$("#zt").combobox("setText","转执法办案");
					}else{
						$("#zt").combobox("loadData",[{id:"80",text:"责令限期整改通知书"}]);
						$("#zt").combobox("setValue","80");
						$("#zt").combobox("setText","责令限期整改通知书");
					}
				}
			}
			if(this.value=="1"){
				if(this.checked){
					if(flag=='checked'){
						$("#zt").combobox("loadData",[{id:"110",text:"复查检查"}]);
						$("#zt").combobox("setValue","110");
						$("#zt").combobox("setText","复查检查");
					}else{
						if($("#zt").val()==120||$("#zt").val()==110){
							$("#zt").combobox("loadData",[{id:"110",text:"复查检查"}]);
							$("#zt").combobox("setValue","110");
							$("#zt").combobox("setText","复查检查");
						}else{
							$("#zt").combobox("loadData",[{id:"99",text:"日常检查"}]);
							$("#zt").combobox("setValue","99");
							$("#zt").combobox("setText","日常检查");
						}
					}
				}
			}
		});
		checkboxToRadio();
		if(paramArray["mode"]=='view'){
			$('#dataForm').find('input[type="text"]').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
				$(o).next(".combo").addClass("inputReadonly");
			});
			$('#dataForm').find('textarea').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
			});
			$('#dataForm').find('input[type="checkbox"]').each(function(i,o){
				$(o).attr('disabled','disabled');
			});
			$('#orgbutton1').hide();
		}else if(paramArray["mode"]=='select'){
			//单位选择组件
			initDepartmentSearch('dw-box', {glpcsid: ''}, 'dwid', 'dwmc', null, null);
		}else{
			//$("#tr1").find('input[type="text"]').each(function(i,o){
			//	$(o).attr('readonly','readonly');
			//	$(o).addClass('inputReadonly');
			//	$(o).next(".combo").addClass("inputReadonly");
			//});
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
				//var bz = $("#bz_" + dataid).text();
				var bz = '';
				jcxparamsMap += "{\"dataid\":\""+ dataid + "\",\"def\":\"" + def + "\",\"bz\":\"" + bz + "\"},";
			});
			jcxparamsMap += "],";
			jcxparamsMap = jcxparamsMap.replace("},]", "}]}");
		});
		jcxparamsMap += "]";
		jcxparamsMap = jcxparamsMap.replace("},]", "}]");
		$("#jcxmx").val(jcxparamsMap);
		//校验检查结果必填
		var checkboxs = $("input:checkbox[id='ch_ddc442bde6e14a55838408a281dcb31e']:checked");
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
		var editUrl = contextPath + "/forward/sydw|jfzlxqzgxxbAdd?jcid="+arr["saveID"]+"&mainTabID="+mainTabID+"&flag=none";
		if(arr["ZT"]=="80"){
			editUrl = contextPath + "/forward/sydw|jfzlxqzgxxbAdd?jcid="+arr["saveID"]+"&mainTabID="+mainTabID+"&flag=none";
			openFlag = true;
		}else if (arr["ZT"]=="110"){
			editUrl = contextPath + "/forward/sydw|jffcyjsAdd?jcid="+arr["saveID"]+"&mainTabID="+mainTabID+"&flag=none";
			openFlag = true;
		}else if(arr["ZT"]=="100"){
			alert("移交执法办案！");
			editUrl = contextPath + "/forward/sydw|jffcyjsAdd?jcid="+arr["saveID"]+"&mainTabID="+mainTabID+"&flag=none";
			openFlag = true;
		}
		if(openFlag){
			window.top.openWindowWithSave(false, null, window, 
		   		{dwid:"${entity.dwid}",jcid:arr["saveID"],dwmc:$("#dwmc").val()}, 
		   		{
		   		title: '录入通知书',
		   		url: editUrl,
		   		width: 880,
		   		height:500
		   		}, 
		   		null, null,null
		   	);
		}
		executeTabPageMethod(mainTabID, "queryButton()");
	}
	
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