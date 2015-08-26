
var dwlx = [110,210,211,221,222,240,260,270,310];//剧毒化学品、旅店业、宾馆旅店、【公章刻制业、非机构印章刻制业】、机动车修理业、旧货业、典当业、歌舞娱乐场所

//js本地图片预览，兼容ie[6-9]、火狐、Chrome17+、Opera11+、Maxthon3
function PreviewImage(fileObj, imgPreviewId, divPreviewId) {
	var allowExtention = ".jpg,.bmp,.gif,.png"; //允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
	var extention = fileObj.value.substring(fileObj.value.lastIndexOf(".") + 1).toLowerCase();
    var browserVersion = window.navigator.userAgent.toUpperCase();
    if (allowExtention.indexOf(extention) > -1) {
        if (fileObj.files) {//HTML5实现预览，兼容chrome、火狐7+等
           if (window.FileReader) {
              var reader = new FileReader();
              reader.onload = function (e) {
                  document.getElementById(imgPreviewId).setAttribute("src", e.target.result);
              };
             reader.readAsDataURL(fileObj.files[0]);
           } else if (browserVersion.indexOf("SAFARI") > -1) {
              alert("不支持Safari6.0以下浏览器的图片预览!");
           }
        } else if (browserVersion.indexOf("MSIE") > -1) {
           if (browserVersion.indexOf("MSIE 6") > -1) {//ie6
              document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
           } else {//ie[7-9]
              fileObj.select();
              if (browserVersion.indexOf("MSIE 9") > -1)
              fileObj.blur(); //不加上document.selection.createRange().text在ie9会拒绝访问
              var newPreview = document.getElementById(divPreviewId + "New");
              if (newPreview == null) {
                  newPreview = document.createElement("div");
                  newPreview.setAttribute("id", divPreviewId + "New");
                  newPreview.style.width = document.getElementById(imgPreviewId).width + "px";
                  newPreview.style.height = document.getElementById(imgPreviewId).height + "px";
                  newPreview.style.border = "solid 1px #d2e2e2";
               }
               newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
               var tempDivPreview = document.getElementById(divPreviewId);
               tempDivPreview.parentNode.insertBefore(newPreview, tempDivPreview);
               tempDivPreview.style.display = "none";
            }
         } else if (browserVersion.indexOf("FIREFOX") > -1) {//firefox
               var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
               if (firefoxVersion < 7) {//firefox7以下版本
                   document.getElementById(imgPreviewId).setAttribute("src", fileObj.files[0].getAsDataURL());
               } else {//firefox7.0+                    
                   document.getElementById(imgPreviewId).setAttribute("src", window.URL.createObjectURL(fileObj.files[0]));
               }
         } else {
              document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
         }
     } else {
         alert("仅支持" + allowExtention + "为后缀名的文件!");
         fileObj.value = ""; //清空选中文件
         if (browserVersion.indexOf("MSIE") > -1) {
         fileObj.select();
         document.selection.clear();
     }
     fileObj.outerHTML = fileObj.outerHTML;
  }
	return fileObj.value;    //返回路径 
};

/**
 * @title:onRadioClick
 * @description:单位标准地址输入后判断单位地址描述是【禁用】还是【启用】
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-03-11 11:19:34
 */
var radioBz = 0; 
function onRadioClick(bz){
	 radioBz = bz;
	 if(bz==0){
		 setInputReadonly('jzd1', false);
		 setInputReadonly('jzd2', false);
		 setInputReadonly('dzms_mldz', true);
		 setInputReadonly('dzms_chdz', true);
		 //必填校验
		 setComboRequired('jzd1', true);
		 setComboRequired('jzd2', true);
		 setComboRequired('dzms_mldz', false);
		 document.getElementById("dtbdButton").disabled = "disabled";
		 //重置单位地址描述
		 $("#dzms_mldz").combobox("clear");
		 $("#dzms_dwdzmlpdm").val("");
		 $("#dzms_dwdzmlpxz").val("");
		 $("#dzms_chdz").val("");
		 $("#dzms_sspcsmc").val("地址描述所属派出所");
		 $("#dzms_sszrqmc").val("地址描述所属责任区");
		 $("#dzms_sspcsdm").val("");
		 $("#dzms_sszrqdm").val("");
		 $("#entity_zbx").val("");
		 $("#entity_zby").val("");
	 }else if(bz==1){
		 setInputReadonly('jzd1', true);
		 setInputReadonly('jzd2', true);
		 setInputReadonly('dzms_mldz', false);
		 setInputReadonly('dzms_chdz', false);
		 //必填校验
		 setComboRequired('jzd1', false);
		 setComboRequired('jzd2', false);
		 setComboRequired('dzms_mldz', true);
		 document.getElementById("dtbdButton").disabled = "";
		 //重置单位标准地址
		 $("#jzd1").combobox("clear");
		 $("#dz_dwdzmlpdm").val("");
		 $("#dz_dwdzmlpxz").val("");
		 $("#jzd2").combobox("clear");
		 $("#dz_dwdzdm").val("");
		 $("#dz_dwdzssxdm").val("");
		 $("#dz_dwdzxz").val("");
	 }
};



//增加单位别名
function addDwbm(){
	var tr1 = $('<tr id="dwbm1Tr'+ dwbmCount +'"><td  height="10"></td></tr>');
	var tr2 = $('<tr id="dwbm2Tr'+ dwbmCount +'" height="24"></tr>');
	
	var td1 = $('<td width="15%" class="dialogTd" align="right">单位别名：</td>');
	
	var td3 = $('<td width="86%" id="dwbmTd'+ dwbmCount +'" colspan="3" class="dialogTd"></td>');
	var td3HTML = new StringBuffer();
	td3HTML.append('<input class="easyui-validatebox" type="text" name="dwbmxxbArray['+dwbmCount+'].dwbm" id="dwbm1_'+ dwbmCount +'" maxlength="50" style="width:560px;" data-options="tipPosition:\'left\'"/>');
	td3HTML.append('&nbsp;<a class="delLine_btn" href="javascript:void(0);" onclick="delDwbm('+ dwbmCount +')" title="注销当前单位别名"></a>');
	td3.html(td3HTML.toString());
	tr2.append(td1);
	tr2.append(td3);
	$('#dwbmTable').append(tr1);
	$('#dwbmTable').append(tr2);
	$.parser.parse('#dwbmTd' + dwbmCount);
	dwbmCount++;
}
//删除单位别名
function delDwbm(bmNo){
	setInputReadonly('dwbm' + bmNo, true);
	$("#xt_zxbz" + bmNo).val("1");
	$("#dwbm1Tr" + bmNo).hide();
	$("#dwbm2Tr" + bmNo).hide();
	$("#dwbm1_" + bmNo).val("");
}

//是否办理营业执照 隐藏或者显示相关项
function sfblyyzzdmOnchange(newVal, oldVal) {
	if (!newVal) {
		return;
	}
	if ($("#dwjbxxb_sfblyyzzdm").combobox('getValues') == "1") {
		setInputReadonly('dwjbxxb_yyzzdm', false);
		setInputReadonly('dwjbxxb_yyzzqsrq', false);
		setInputReadonly('dwjbxxb_yyzzjzrq', false);
		setInputReadonly('dwjbxxb_yyzzfzjg', false);
		setInputReadonly('dwjbxxb_zczj', false);
		setInputReadonly('dwjbxxb_zzjgzh', false);
		setInputReadonly('dwjbxxb_swdjzh', false);
		setInputReadonly('dwjbxxb_yyzzfzjgid',false);
	}else {
		setInputReadonly('dwjbxxb_yyzzdm', true);
		setInputReadonly('dwjbxxb_yyzzqsrq', true);
		setInputReadonly('dwjbxxb_yyzzjzrq', true);
		setInputReadonly('dwjbxxb_yyzzfzjg', true);
		setInputReadonly('dwjbxxb_zczj', true);
		setInputReadonly('dwjbxxb_zzjgzh', true);
		setInputReadonly('dwjbxxb_swdjzh', true);
		setInputReadonly('dwjbxxb_yyzzfzjgid', true);
		$("#dwjbxxb_yyzzfzjgid").val("");
		$("#dwjbxxb_yyzzdm").val("");
		$("#dwjbxxb_yyzzqsrq").val("");
		$("#dwjbxxb_yyzzjzrq").val("");
		$("#dwjbxxb_yyzzfzjg").val("");
		$("#dwjbxxb_zczj").val("");
		$("#dwjbxxb_zzjgzh").val("");
		$("#dwjbxxb_swdjzh").val("");
	}
}


function doInit(paramArray) {
}
function beforeSubmit() {
}
function afterSubmit() {
	var pk = $("#dwjbxxb_id").val();
	if(pk!=""){
	parent.location.reload();
	}
	
}
function exit_onclick() {
	executeTabPageMethod(mainTabID, "reloadDg");
	closeSelf();
}


$(document).ready(function(){
	
	sfblyyzzdmOnchange($("#dwjbxxb_sfblyyzzdm").val(), "");
	initAddressSearch('jzd1', {fxjdm:fxjdm,pcsdm:pcsdm,zrqdm:zrqdm}, 'dz_dwdzmlpdm', 'dz_dwdzmlpxz', 'jzd2', {text:'dz_dwdzxz',dzxzqh:'dz_dwdzssxdm',id:'dz_dwdzdm'}, null, null);
	//单位地址描述门楼地址选中【zhang_gouliang@founder.com】
	initAddressSearch('dzms_mldz', {}, 'dzms_dwdzmlpdm', 'dzms_dwdzmlpxz',null,null, null, null);
	//默认地址描述为只读模式
	setInputReadonly('dzms_mldz', true);
	setInputReadonly('dzms_chdz', true);
	setInputReadonly('dzms_sspcsmc', true);
	setInputReadonly('dzms_sszrqmc', true);
	setInputReadonly('entity_zbx', true);
	setInputReadonly('entity_zby', true);
	//必填验证
	setComboRequired('jzd1', true);
	setComboRequired('jzd2', true);
	var pk = $("#dwjbxxb_id").val();
	setInputReadonly('dwjbxxb_dwmc', true);
	setInputReadonly('jzd1', true);
	setInputReadonly('jzd2', true);
	$("#_method").val("put");
	if ($('#nextDwid').val() != "") {
		$('#save2Text').html('核实并下一条');
	}
	$("#jbxxForm").attr("action",contextPath+"/sydw/"+pk);
	sfblyyzzdmOnchange("");
	$("#save2Botton").bind("click",function() {
		if ($("#jbxxForm").form('validate')) {
			if(radioBz==0){
				if($("#dz_dwdzdm").val() == ""){
					topMessager.alert('', '请先选择有效的单位地址！');
					$("#jzd2").find("input.combo-text").first().focus();
					return;
				}
			}else{
				if($("#entity_zbx").val() == ""||$("#dzms_sspcsmc").val()=="地址描述所属派出所"){
					topMessager.alert('', '请进行标点获取地址描述所属派出所、责<br><br>任区、坐标信息！');
					return;
				}
			}
			if ($("#dwjbxxb_yyzzqsrq").val() != "" && $("#dwjbxxb_yyzzjzrq").val() != "" && $("#dwjbxxb_yyzzqsrq").val() >  $("#dwjbxxb_yyzzjzrq").val()) {
				topMessager.alert('', '营业执照截止日期必须大于起始日期，请重新输入！');
				$("#jzrk_jzksrq").focus();
				return;
			}
			var bottonObject = this;
			if (buttonDisabled(bottonObject) == false) {
				return false;
			}	
			topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
				if (r) {
					var formObject = $("#jbxxForm");
					formObject.form('submit',{
						dataType : 'json',
						onSubmit: function() {
						},
						success: function(result) {
							buttonEnabled(bottonObject);
							result = parseReturn(result);
							if (result.status == 'success') { // 返回成功后执行的方法
								if ($('#nextDwid').val() != "") {
									var openUrl = contextPath + "/dwjbxxb/createHs";
											openUrl += "?dwidString=" + $("#dwidString").val();
											openUrl += "&dwid=" + $("#nextDwid").val();
											openUrl += "&mainTabID=" + mainTabID;
											executeTabPageMethod(mainTabID, "reloadDg");
											location.href = openUrl;
									}else{
										exit_onclick();
										}
									}
									else {
										topMessager.alert(MESSAGER_TITLE, result.message, 'error');
									}
						}
					});			
				}
				else {
					buttonEnabled(bottonObject);
				}
			});
		}
	});
	//地图标点【标识0返回X、Y坐标，1返回X、Y坐标并所属派出所、责任区信息】
	$("#dtbdButton").click(function(){
		var zbx = $("#entity_zbx").val();
		var zby = $("#entity_zby").val();
		var url = contextPath+"/forward/map|mapBz?bz=1&zbx="+zbx+"&zby="+zby;
		var paramArray = [];
		openWindow(false, null, url, 
	   		paramArray, 
	   		{
		   		title:"地图标注（鼠标点击左键标注位置，右键退出标注模式）",
		   		maximizable: false,
		   		width: 700,	
		   		height:400
	   		}
	   	);
	});
	
	if(dzms_sspcsdm!=""&&dzms_zbx!=""){
		onRadioClick(1);
		$("input[name=dzRadio][value=1]").attr("checked",true);
		$("#dzms_sspcsmc").val(dzms_sspcsmc);
		$("#dzms_sszrqmc").val(dzms_sszrqmc);
	}else{
		onRadioClick(0);
	}
	//判断
	if(dz_dwdzdm!=""){
		document.getElementById("dwbzdzRadio").disabled = "disabled";
		document.getElementById("dwdzmsRadio").disabled = "disabled";
		setInputReadonly('jzd1', true);
		setInputReadonly('jzd2', true);
	}
	//新增页面作为修改界面时显示图片
	if(id!=""){
		document.getElementById("imgHeadPhoto").src = contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id="+id;
	}
});