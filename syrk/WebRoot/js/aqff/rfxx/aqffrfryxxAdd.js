// @Author:       [xu_haibo@founder.com.cn]
$(document).ready(function(){
	initDepartmentSearch('gzdws', {glpcsid: ''}, 'dwid', 'gzdw', null, null);
	selectDwmc();
	if(states=='update'){
		setInputReadonly('zjhm',true);
		setInputReadonly('xbdm',true);
		setInputReadonly('xm',true);
		setInputReadonly('zjlxdm',true);
		//setInputReadonly('whcddm',true);
		//setInputReadonly('zzmmdm',true);

		 $("#zjhm").val(zjhm);
		 $("#zjlxdm").combobox("setValue",zjlxdm);
		 $("#xm").val(xm);
		 $("#xbdm").combobox("setValue",xbdm);
		 $("#whcddm").combobox("setValue",whcddm);
		 $("#zzmmdm").combobox("setValue",zzmmdm);
		 $("#rylydm").combotree("setValue",rylydm);
		 if(zznzw=='undefined'){
			 zznzw='';
		 }
		 $("#zznzw").val(zznzw);
		 if(lxfs=='undefined'){
			 lxfs='';
		 }
		 $("#lxfs").val(lxfs);
		 if(cjsj=='undefined'){
			 cjsj='';
		 }
		 $("#cjsj").val(cjsj);
		 if(dz_jzdzmlpdm=='undefined'){
			 dz_jzdzmlpdm='';
		 }
		 if(dz_jzdzmlpxz=='undefined'){
			 dz_jzdzmlpxz='';
		 }
		 if(dz_jzdzdm=='undefined'){
			 dz_jzdzdm='';
		 }
		 if(dz_jzdzssxqdm=='undefined'){
			 dz_jzdzssxqdm='';
		 }
		 if(dz_jzdzxz=='undefined'){
			 dz_jzdzxz='';
		 }
		 $("#fzd3").combobox("setValue",dz_jzdzmlpxz);
		 $("#fzd4").combobox("setValue",dz_jzdzxz);
		 $("#dz_jzdzmlpdm").val(dz_jzdzmlpdm);
		 $("#dz_jzdzmlpxz").val(dz_jzdzmlpxz);
		 $("#dz_jzdzdm").val(dz_jzdzdm);
		 $("#dz_jzdzssxqdm").val(dz_jzdzssxqdm);
		 $("#dz_jzdzxz").val(dz_jzdzxz);
		 $("#cylbdm").combobox("setValue",cylbdm);
		 if(bz=='undefined'){
			 bz='';
		 }
		 $("#bz").val(bz);
		 if(gzdw=='undefined'){
			 gzdw='';
		 }
		 $("#gzdws").combobox("setValue",gzdw);
		 $("#gzdw").val(gzdw);
		 $("#dwid").val(dwid);
		 $("#id").val(id);
		 $("#index").val(index);
		 var sss= dz_jzdzxz.replace(dz_jzdzmlpxz,'');
	}
	initAddressSearch('fzd3', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'fzd4', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxqdm',id:'dz_jzdzdm'}, null, null);
	 $("#fzd3").combobox("setValue",dz_jzdzmlpxz);
	 $("#fzd4").combobox("setValue",sss);
});

function yzqk(param){
	alert(1212);
}
//保存前（必写此方法可为空,否则弹出框保存失败）
function afterSubmit(arr) {
	 var zjhm = $("#zjhm").val();
	 var zjlxdm = $("#zjlxdm").combobox("getValue");
	 var xm = $("#xm").val();
	 var xbdm = $("#xbdm").combobox("getValue");
	 var whcddm = $("#whcddm").combobox("getValue");
	 var zzmmdm = $("#zzmmdm").combobox("getValue");
	 var rylydm = $("#rylydm").combobox("getValue");
	 var zznzw = $("#zznzw").val();
	 var lxfs = $("#lxfs").val();
	 var cjsj = $("#cjsj").val();
	 var dz_jzdzmlpdm = $("#dz_jzdzmlpdm").val();
	 var dz_jzdzmlpxz = $("#dz_jzdzmlpxz").val();
	 var dz_jzdzdm = $("#dz_jzdzdm").val();
	 var dz_jzdzssxqdm = $("#dz_jzdzssxqdm").val();
	 var dz_jzdzxz = $("#dz_jzdzxz").val();
	 var cylbdm = $("#cylbdm").combobox("getValue");
	 var bz = $("#bz").val();
	 var gzdw =  $("#gzdw").val();
	 var dwid =  $("#dwid").val();
	 var id =  $("#id").val();
	 var index =  $("#index").val();
	 var methodSty = zjhm+"@"+zjlxdm+"@"+xm+"@"+xbdm+"@"+whcddm+"@"+zzmmdm+"@"+rylydm+"@"+zznzw+"@"+lxfs+"@"+cjsj+"@"+dz_jzdzmlpdm+"@"+dz_jzdzmlpxz+"@"+dz_jzdzdm+"@"+dz_jzdzssxqdm+"@"+dz_jzdzxz+"@"+cylbdm+"@"+bz+"@"+gzdw+"@"+dwid+"@"+id;
	executeTabPageMethod1(mainTabID, "reloadDg",methodSty);
	 var methodStyindex = zjhm+"@"+zjlxdm+"@"+xm+"@"+xbdm+"@"+whcddm+"@"+zzmmdm+"@"+rylydm+"@"+zznzw+"@"+lxfs+"@"+cjsj+"@"+dz_jzdzmlpdm+"@"+dz_jzdzmlpxz+"@"+dz_jzdzdm+"@"+dz_jzdzssxqdm+"@"+dz_jzdzxz+"@"+cylbdm+"@"+bz+"@"+gzdw+"@"+dwid+"@"+id+"@"+index;
	executeTabPageMethod1(mainTabID, "updaterows",methodStyindex);
}
$(function(){
	$('#rfryxxForm').form({  
		url:contextPath+"/rfxxb/saveRfcyxx",
        onSubmit:function(){
            return $('#rfryxxForm').form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            	topMessagerAlert(null,json.message);
            }else{
            	$("#id").val(json.saveID); 
            	topMessagerShow(null,json.message);
            	//executeTabPageMethod(mainTabID, "reloadDg");
            	closeSelf();
            }
        }  
    });   
});
function executeTabPageMethod1(mainTabID, method,methodSty) {
	if (!mainTabID || mainTabID == "" || !method || method == "") {
		return;
	}
	try {
		var openFrameID = "main_tab" + mainTabID;
		if (IE) {
			var openFrame = window.top.document.frames["main_frame"].main_center.frames(openFrameID);
			eval("openFrame." + method + "(\'"+methodSty+"\')");
		}
		else {
			var main_center = window.top.document.getElementById("main_frame").contentWindow.frames.document.getElementById("main_center");
			var openFrame = main_center.contentWindow.frames.document.getElementById(openFrameID).contentWindow;
			eval("openFrame." + method + "(\'"+methodSty+"\')");
		}
	}
	catch (err) {}
}
//证件类型验证绑定
function validateZjhm(param){
	$('#zjhm').val("");
	if(param.id=='111'){
		$('#zjhm').validatebox({validType:'sfzh'});
		$('#zjhm').bind("blur",function(e){checkZjhm();});
	}else{
		$('#zjhm').validatebox({validType:'maxLength[30]'});
		$('#zjhm').unbind("blur");
		cancelJzhmCtr();
	}
}
//根据证件类型与号码 ，进行人员比对，复用
function checkZjhm(){
	if ($('#zjhm').validatebox("isValid")){
		var zjhm = $('#zjhm').val();
		var yzcf=0;
		var zjhmsz = zjhms.split(",");
		for(var j=0;j<zjhmsz.length;j++){
			if(zjhmsz[j]==zjhm){
				yzcf=1;
			}
		}
		if(yzcf==1){
			topMessagerAlert(null,zjhm+"此证件号码重复！");
			$('#zjhm').val("");
			return;
		}

		$.ajax({
			type:"POST",
			url: contextPath + "/ryRyjbxxb/dataApply",
			dataType:"json",
			data:"zjhm=" + $("#zjhm").val() + "&zjlxdm=" + $("#zjlxdm").combobox("getValue"),
			success:function(data) {
				if(data.ryRyjbxxb.xm!=''){
					$('#xm').val(data.ryRyjbxxb.xm);
					setInputReadonly('xm',true);
				}else{
					topMessager.confirm('操作确认', '实有人口中无此人是否添加？',  function(r) {
						if (r) {
							 SyrkGl.map._MapApp.closeInfoWindow();
							 menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID()+'&invokeJSMethod=SyrkGl.queryButton');
						}
					});
				}
				if(data.ryRyjbxxb.xbdm!=''){
					$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
					setInputReadonly('xbdm',true);
				}
				
				if(data.ryRyjbxxb.jzd_xzqhdm!=''){
					$("#dz_jzdzmlpdm").val(data.ryRyjbxxb.jzd_mlpdm);
					$("#dz_jzdzmlpxz").val(data.ryRyjbxxb.jzd_mlpxz);
					$("#dz_jzdzdm").val(data.ryRyjbxxb.jzd_dzid);
					$("#dz_jzdzssxqdm").val(data.ryRyjbxxb.jzd_xzqhdm);
					$("#dz_jzdzxz").val(data.ryRyjbxxb.jzd_dzxz);
					$("#fzd3").combobox("setValue",data.ryRyjbxxb.jzd_mlpxz);
					var dzxz=data.ryRyjbxxb.jzd_dzxz;
					var ss = dzxz.replace(data.ryRyjbxxb.jzd_mlpxz,"");
					$("#fzd4").combobox("setValue",ss);
				}
				if(data.ryRyjbxxb.xldm!=''){
					$("#whcddm").combobox("setValue",data.ryRyjbxxb.xldm);//学历代码
				}
				if(data.ryRyjbxxb.lxdh!=''){
					$("#lxfs").val(data.ryRyjbxxb.lxdh);//联系电话
				}
				if(data.ryRyjbxxb.zzmmdm!=''){
					$("#zzmmdm").combobox("setValue",data.ryRyjbxxb.zzmmdm);//政治面貌代码
				}
			}
		});	
	}else{
		cancelJzhmCtr();
	}
}
//取消绑定
function cancelJzhmCtr(){
	$('#xm').val('');
	setInputReadonly('xm',false);
	$('#xbdm').val('');
	setInputReadonly('xbdm',false);
	$('#zzmmdm').val('');
	//setInputReadonly('zzmmdm',false);
	$('#zjhm').val('');
	setInputReadonly('zjhm',false);
	$('#whcddm').val('');
	//setInputReadonly('whcddm',false);
}
function selectDwmc(){
	$("#gzdws").combobox("setValue",dwmc);
}