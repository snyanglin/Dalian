<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>物防信息</title>
</head>
<body style="margin-top:20px" class="bodybg">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    			<form action="<%=basePath%>wfxxb/saveWfxxb" id="jbxxForm" name="jbxxForm" method="post">
	    		  <input type='hidden' name='id' id="entity_id" value="${entity.id}"/>
	    		  <!-- 点击保存标注后才将内容保存到entity_zbx和entity_zby -->
		    	  <input type='hidden' id="entity_zbxYs" name="xsdzzbxYs"/> 
		    	  <input type='hidden' id="entity_zbyYs" name="xsdzzbyYs"/> 
	    		  <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">装备类别：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" id="entity_zblbdm" name="zblb" value="${entity.zblb}" 
				    		style="width:200px;"  maxlength="20" data-options="required:true,validType:['maxLength[20]'],valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
						</td> 
				    	<td width="20%" class="dialogTd" align="right">装备类型：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" id="entity_zblxdm" name="zblx" value="${entity.zblx}" 
				    		style="width:200px;" maxlength="20" data-options="required:true,validType:['maxLength[20]'],
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">装备数量：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="entity_zbsl" name="zbsl" value="${entity.zbsl}"
		    	        	style="width: 200px;" maxlength="8" data-options="validType:['naturalNumber','maxLength[8]']"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">装备运行状态：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-combobox" id="entity_zbyxztdm" name="zbyxztdm" value="${entity.zbyxztdm}" 
				    		style="width:200px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_SF.js',
				    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
						</td> 
	    	      </tr>
	    	      
	    	       <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">装备位置地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="jzd1" style="width:380px;" value="${entity.dz_zbwzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_zbwzdzmlpdm' id="zbwzdzmlpdm" value="${entity.dz_zbwzdzmlpdm}"/>
				    	<input type='hidden' name='dz_zbwzdzmlpxz' id="zbwzdzmlpxz" value="${entity.dz_zbwzdzmlpxz}"/>
			    	</td>
			    	
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_zbwzdzxz, entity.dz_zbwzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_zbwzdzdm' id="zbwzdzdm" value="${entity.dz_zbwzdzdm}"/>
				    	<input type='hidden' name='dz_zbwzdzssxdm' id="zbwzdzssxdm" value="${entity.dz_zbwzdzssxdm}"/>
				    	<input type='hidden' name='dz_zbwzdzxz' id="zbwzdzxz" value="${entity.dz_zbwzdzxz}"/>
			    	</td>
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">防范单位名称：</td>
		    	 		<td width="80%" class="dialogTd" colspan="3">
		    	 			<input class="easyui-validatebox" type="text" id="entity_ffdwmc" name="ffdwmc"
		    	 			value="${entity.ffdwmc}" maxlength="100" style="width:595px;" data-options="tipPosition:'left'"/>
		    	 		</td>
	    	      </tr>
	    	     
	    	       <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">防范单位地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="fzd1" style="width:380px;" value="${entity.dz_ffdwdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_ffdwdzmlpdm' id="ffdwdzmlpdm" value="${entity.dz_ffdwdzmlpdm}"/>
				    	<input type='hidden' name='dz_ffdwdzmlpxz' id="ffdwdzmlpxz" value="${entity.dz_ffdwdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="fzd2" style="width:200px;" value='${fn:replace(entity.dz_ffdwdzxz, entity.dz_ffdwdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_ffdwdzdm' id="ffdwdzdm" value="${entity.dz_ffdwdzdm}"/>
				    	<input type='hidden' name='dz_ffdwdzssxdm' id="ffdwdzssxdm" value="${entity.dz_ffdwdzssxdm}"/>
				    	<input type='hidden' name='dz_ffdwdzxz' id="ffdwdzxz" value="${entity.dz_ffdwdzxz}"/>
			    	</td>
	    	      </tr>
	    	      <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right"></td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<a id="mapBotton" type="button" class="l-btn l-btn-small">
				    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
									<span class="l-btn-text">标注</span>
									<span class="l-btn-icon icon-search"> </span>
								</span>
				    		</a>
						</td>
	    	       </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">坐标X：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="entity_zbx" name="zbx" value="${entity.zbx}"
		    	        	style="width: 200px;" readonly="readonly"/>	
						</td>
				    	<td width="20%" class="dialogTd" align="right">坐标Y：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="entity_zby" name="zby" value="${entity.zby}"
		    	        	style="width: 200px;" readonly="readonly"/>
						</td> 
	    	      </tr>
	    	      <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">备注：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="entity_bz" name="bz" class="easyui-validatebox" rows="3" style="width:595px; height:52px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
						</td>
	    	       </tr>
    			</form>
	    		</table>
		    </div>
		</div>
	    </div>
	    </div>

		<div style="height:6px;font-size:1px;"></div>
				    
		
		 	</form>
		    
		</div>
		</div>
		</div>
		
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="resetBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">重置</span>
					<span class="l-btn-icon icon-reset"> </span>
				</span>
			</a>
		</div>

    	</td></tr></table>
</div>
</body>
</html>
<script type="text/javascript" >
var mainTabID = "${mainTabID}";
	/*
	function doInit(paramArray) {
		//$("#dwmc").val(paramArray["dwmc"]);
		//$("#dwid").val(paramArray["dwid"]);
		//zrrdm_init();
	}
	function beforeSubmit() {
	 
	}
	
	function afterSubmit(arr) {
		if(arr["saveID"]){
			$("#entity_id").val(arr["saveID"]);
		}
	}
	*/
	
	function biaozhu(){
		var url = contextPath+'/forward/map|mapBz';
		var paramArray = [];
		openWindow(false, null, url, 
	   		paramArray, 
	   		{
		   		title:'地图标注（鼠标点击左键标注位置，右键退出标注模式）',
		   		maximizable: false,
		   		width: 850,	
		   		height: 400
	   		}
	   	);
	}
	$(function(){
		
		initAddressSearch('jzd1', {}, 'zbwzdzmlpdm', 'zbwzdzmlpxz', 'jzd2', {text:'zbwzdzxz',dzxzqh:'zbwzdzssxdm',id:'zbwzdzdm'}, null, null);
		initAddressSearch('fzd1', {}, 'ffdwdzmlpdm', 'ffdwdzmlpxz', 'fzd2', {text:'ffdwdzxz',dzxzqh:'ffdwdzssxdm',id:'ffdwdzdm'}, null, null);
		$('#jbxxForm').form({  
	        onSubmit:function(){
	            return $(this).form('validate');  
	        },  
	        success:function(data){  
	            var json = $.parseJSON(data);
	            if(json.status != 'success'){
	            	topMessagerAlert(null,json.message);
	            }else{
	            	topMessagerShow(null,json.message);
	            	$("#entity_id").val(json.saveID); 
	            	executeTabPageMethodLeft(mainTabID, "reloadDg");
					topMessagerAlert(null, "保存成功","success");
	            	closeSelf();
	            }
	        }  
	    });   
		$('#saveBotton').click(function(){
			topMessager.confirm('操作确认', '您是否保存物防信息？',  function(r) {
				if (r) {
					$('#jbxxForm').submit();
				}
			});
		});
		$('#mapBotton').click(function(){
			biaozhu();
		});
		$('#resetBotton').click(function(){
			$("input").val("");
			$("textarea").val("");
		});
	});
	
	
	//刷新左页面的方法
function executeTabPageMethodLeft(mainTabID, method) {
	if (!mainTabID || mainTabID == "" || !method || method == "") {
		return;
	}
	try {
		var openFrameID = "main_tab" + mainTabID;
		if (IE) {
			var openFrame = window.top.document.frames["main_frame"].main_center.frames(openFrameID);
			openFrame =openFrame.frames['main_left'];
			eval("openFrame." + method + "()");
		}
		else {
			var main_center = window.top.document.getElementById("main_frame").contentWindow.frames.document.getElementById("main_center");
			var openFrame1 = main_center.contentWindow.frames.document.getElementById(openFrameID).contentWindow;
			var openFrame = contentWindow.frames.document.getElementById("main_left").contentWindow;
			eval("openFrame." + method + "()");
		}
	}
	catch (err) {}
}
</script>