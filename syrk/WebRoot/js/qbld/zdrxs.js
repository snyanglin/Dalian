if(typeof Zdrxs =="undefined" || !Zdrxs){
	Zdrxs = {};
}
Zdrxs.zdryXsInfoObj = null;//写实重点人对象
Zdrxs.zszhjsbXxbh = "";//肇事肇祸级精神病写实信息编号
/**
 * @title:initSimpleQuery
 * @description:初始化加载临控预警级别简单查询
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:36
 */
Zdrxs.buildXsHtml = function(){
	$("#otherInfoListDiv").tabs({
		width:$(".infoBodyTable").width(),
		height:bodyHeight-$(".infoBodyTable").height()-100,
		border:false
	});
	$("#where_zdryxl").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYLB.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200
	});
};
/**
 * @method:queryZdryInfo
 * @package:syrk/js/qbld	
 * @description:查询重点人员信息
 * @param zjhm
 * @author:Li_Zhenzhong
 * @date:2015-6-18下午3:21:26
 */
Zdrxs.queryZdryInfo = function(zjhm){
	var param = {"sfzh":zjhm}
	var url = contextPath+'/zdry/queryZdry';
	var fajax = new FrameTools.Ajax(url,Zdrxs.queryZdryInfo_back);
	fajax.send(param);
};
/**
 * @method:queryZdryInfo_back
 * @package:syrk/js/qbld	
 * @description:显示重点人员详情
 * @param obj
 * @author:Li_Zhenzhong
 * @date:2015-6-18下午3:31:11
 */
Zdrxs.queryZdryInfo_back = function(obj){
	$("#zdryOpButtonTr").show();
	$("#zdrySxxx").show();
	while($("#otherInfoListDiv").tabs("tabs").length>0){
			$("#otherInfoListDiv").tabs("close",0);
	}
	$("#opInfoTr").hide();
	Zdrxs.zdryXsInfoObj = obj;
	for(key in obj){
		var val = obj[key];
		if(val!=""&&val!=null){
			switch(key){
				case 'xb':val = window.top.getDictName(contextPath + '/common/dict/D_QBLD_XB.js',val);break;
				case 'mz':val = window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js',val);break;
				case 'zdryxl':val = Zdrxs.getDicValues(val,',','D_QBLD_ZDRYXL');break;
				case 'gj':val = window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYGKCSLX.js',val);break;
				case 'tmtz':val = Zdrxs.getDicValues(val,'/','D_QBLD_TMTZ');break;
				default:break;
			}
			if('zjlasj,createdate,'.indexOf(key)!=-1){
				val = val.substring(0,4)+"/"+val.substring(4,6)+"/"+val.substring(6,8)+" "+val.substring(8,10)+":"+val.substring(10,12)+":"+val.substring(12,14) ;
			}
		}
		$("#zdry_"+key).html(val);
	}
	$("#zdry_zp").attr("src",contextPath + "/ckyj/queryQbldZpSingle.jpg?sfzh="+obj.sfzh );
};
/**
 * @method:queryZdryList
 * @package:syrk/js/qbld	
 * @description:查询重点人员列表
 * @param total
 * @param begin
 * @param end
 * @param page
 * @author:Li_Zhenzhong
 * @date:2015-6-1上午10:34:11
 */
Zdrxs.queryZdryList = function(total,begin,end,page){
	var checkObj = $("#queryFrom :checkBox");
	var num = checkObj.length
	var xszt = ""; 
	for(var i = 0;i<num;i++){
		if(checkObj[i].checked)
			xszt+=checkObj[i].value+",";
	}
	var param = {  
					"xm":$("#where_xm").val(),
					"sfzh":$("#where_sfzh").val(),
					"zdryxl":$("#where_zdryxl").val(),
					"createdateB":$("#where_createdateB").val(),
					"createdateE":$("#where_createdateE").val(),
					"gxdwjgdm":$("#where_gxdwjgdm").val(),
					"total":total,
					"rownum":10,
					"begin":begin,
					"end":end,
					"page":page}
	var url = contextPath+'/zdry/queryZdryList';
	var fajax = new FrameTools.Ajax(url,Zdrxs.queryZdryList_back);
	fajax.send(param);
};
/**
 * @method:queryZdryList_back
 * @package:syrk/js/qbld	
 * @description:根据查询结果显示重点人员信息列表
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-6-1上午10:34:27
 */
Zdrxs.queryZdryList_back = function(json){
	Zdrxs.listObj = json.rows;
	var num = Zdrxs.listObj.length;
	var  rsHtml = "<table class='listTable'>"+
		"<tr class='countInfo'>" +
		"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>个重点人</td>"+
		"</tr>";
	for(var  i = 0;i<num;i++){
		var row = Zdrxs.listObj[i];
		rsHtml+="<tr class='infoOne_tr' onclick='Main.clickListToChangeColor(this);Zdrxs.queryOneZdryInfo("+i+");'>";
		switch(parseInt(row.jjcd)){//根据级别显示不同颜色
		case 100: rsHtml += "<td class='color4'></td>";break;
		case 110: rsHtml += "<td class='color3'></td>";break;
		case 010: rsHtml += "<td class='color1'></td>";break;
		default:rsHtml += "<td class='color0'></td>";break;
		}
		rsHtml+="<td class='infoBody' onclick=''>"+"姓名:"+ row.xm+"  <br> " +
						"证件号码:"+ row.sfzh+"<br>" +
						"写实时间:"+row.xssj+"</div></td>"+
				"</tr>" ;
		}
		rsHtml += "<tr class='fyTr'><td colspan=4 >"+Yjxx.showfy(json.total,json.rownum,json.page,"Zdrxs.queryZdryList")+"</td></tr>";
		rsHtml+="</table>";
	$("#InfoList").html(rsHtml);
	Main.initChangeListColor();
};
/**
 * @method:queryOneZdryInfo
 * @package:syrk/js/qbld	
 * @description:显示重点人员详情
 * @param index
 * @author:Li_Zhenzhong
 * @date:2015-6-1下午5:09:36
 */
Zdrxs.queryOneZdryInfo = function(index){
	$("#zdryOpButtonTr").show();
	$("#zdrySxxx").show();
	while($("#otherInfoListDiv").tabs("tabs").length>0){
			$("#otherInfoListDiv").tabs("close",0);
	}
	$("#opInfoTr").hide();
	var obj = Zdrxs.listObj[index];
	Zdrxs.zdryXsInfoObj = obj;
	for(key in obj){
		var val = obj[key];
		if(val!=""&&val!=null){
			switch(key){
				case 'xb':val = window.top.getDictName(contextPath + '/common/dict/D_QBLD_XB.js',val);break;
				case 'mz':val = window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js',val);break;
				case 'zdryxl':val = Zdrxs.getDicValues(val,',','D_QBLD_ZDRYXL');break;
				case 'gj':val = window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYGKCSLX.js',val);break;
				case 'tmtz':val = Zdrxs.getDicValues(val,'/','D_QBLD_TMTZ');break;
				default:break;
			}
			if('zjlasj,createdate,'.indexOf(key)!=-1){
				val = val.substring(0,4)+"/"+val.substring(4,6)+"/"+val.substring(6,8)+" "+val.substring(8,10)+":"+val.substring(10,12)+":"+val.substring(12,14) ;
			}
		}
		$("#zdry_"+key).html(val);
	}
	$("#zdry_zp").attr("src",contextPath + "/ckyj/queryQbldZpSingle.jpg?sfzh="+obj.sfzh );
};
/** 
 * @method:getDicValues
 * @package:syrk/js/qbld	
 * @description:多值字典翻译
 * @param val 多值ID串
 * @param slipt 分割字符
 * @param dicname 字典代码
 * @author:Li_Zhenzhong
 * @date:2015-6-2上午9:59:30
 */
Zdrxs.getDicValues = function(val,slipt,dicname){
	var valStr = "";
	if(val&&slipt&&dicname){
		var valArr = val.split(slipt);
		if(valArr.length<=1)
			return window.top.getDictName(contextPath + '/common/dict/'+dicname+'.js',val)
		for(var i = 0;i<valArr.length-1;i++)
		valStr += window.top.getDictName(contextPath + '/common/dict/'+dicname+'.js',valArr[i])+slipt;
	}
	return valStr;
} 
/**
 * @method:initXsSelectVal
 * @package:syrk/js/qbld	
 * @description:加载写实字典项
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午3:11:23
 */
Zdrxs.initXsSelectVal = function(){
	$("#zdrxs_hsddqh").combotree({
		url:contextPath + '/common/dict/D_BZ_XZQH_MUNICIPAL.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%',
		onSelect:function(obj){
			$("#zdrxs_hsddxz").val(obj.text)
		}
	})
	$("#zdrxs_qwss").combotree({
		url:contextPath + '/common/dict/D_BZ_XZQH.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%'
	})
	$("#zdrxs_jzdqh").combotree({
		url:contextPath + '/common/dict/D_BZ_XZQH.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%'
	})
	
	$("#zdrxs_zkzt").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZKZT.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#zdrxs_zyjsnzt").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYZYJSNZT.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#zdrxs_wxjb").combobox({
		url: contextPath + '/common/dict/D_QBLD_WXJB.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#zdrxs_zy").combotree({
		url:contextPath + '/common/dict/GB_D_ZYLBDM.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%'
	})

	
	$("#zdrxs_sjsr").combobox({
		url: contextPath + '/common/dict/D_QBLD_SJSR.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	
	$("#zdrxs_jjly").combobox({
		url: contextPath + '/common/dict/D_QBLD_JJLY.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#zdrxs_sfjdbr").combobox({
		url: contextPath + '/common/dict/D_QBLD_SF.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#zdrxs_zjzt").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZJZT.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
}
/**
 * @method:initXsTab
 * @package:syrk/js/qbld	
 * @description:创建写实信息窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午3:25:25
 */
Zdrxs.initXsTab = function(){
	$("#opInfoTr").show();
	if($("#otherInfoListDiv").tabs('getTab','写实信息')==null){
		var html ='<table class="infoBodyTable" id="xs_Table"> '+
		 '	<tr><td class="infoName red">核实时间</td><td class="infoValue" ><input id="zdrxs_hssj" class="notNull" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" ></td>'+
		 '		<td class="infoName red">核实地点区划</td><td class="infoValue"><input id="zdrxs_hsddqh"  class="notNull" value="510104,510106"></td></tr>'+
		 '	<tr><td class="infoName red">核实地点名称</td><td class="infoValue"><input id="zdrxs_hsddmc" class="notNull"  maxlength=150></td>'+
		 '		<td class="infoName red">核实地点详址</td><td class="infoValue"><input id="zdrxs_hsddxz"  class="notNull" maxlength=300></td></tr>'+
		 '	<tr><td class="infoName red">在控状态</td><td class="infoValue"><input id="zdrxs_zkzt" class="notNull" ></td>'+
		 '		<td class="infoName red">在籍状态</td><td class="infoValue"><input id="zdrxs_zjzt" class="notNull" > </td></tr>'+
		 '	<tr><td class="infoName">离开时间</td><td class="infoValue"><input id="zdrxs_lksj" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" ></td>'+
		 '		<td class="infoName">去往省市</td><td class="infoValue"><input id="zdrxs_qwss"></td></tr>'+
		 '	<tr><td class="infoName red">危险级别（提示）</td><td class="infoValue"><input id="zdrxs_wxjb" class="notNull" > </td>'+
		 '		<td class="infoName">主要意向</td><td class="infoValue" ><input id="zdrxs_zyyx" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">职业</td><td class="infoValue"><input id="zdrxs_zy"></td>'+
		 '		<td class="infoName">实际收入</td><td class="infoValue"><input id="zdrxs_sjsr"> </td></tr>'+
		 '	<tr><td class="infoName">经济来源</td><td class="infoValue"><input id="zdrxs_jjly"></td>'+
		 '		<td class="infoName">联系方式</td><td class="infoValue"><input id="zdrxs_lxfs"> </td></tr>'+
		 '	<tr><td class="infoName">工作单位</td><td class="infoValue"><input id="zdrxs_gzdw" maxlength=150></td>'+
		 '		<td class="infoName">工作单位详址</td><td class="infoValue"> <input id="zdrxs_gzdwxz" maxlength=300></td></tr>'+
		 '	<tr><td class="infoName">现住地区划</td><td class="infoValue"><input id="zdrxs_jzdqh"></td>'+
		 '		<td class="infoName">现住地详址</td><td class="infoValue"><input id="zdrxs_jzdxz"> </td></tr>'+
		 '	<tr><td class="infoName">管辖单位</td><td class="infoValue">'+userOrgName+'</td>'+
		 '		<td class="infoName  red">是否见到本人</td><td class="infoValue"><input id="zdrxs_sfjdbr"  class="notNull" > </td></tr>'+
		 '	<tr><td class="infoName">核实情况描述（提示）</td><td class="infoValue" colspan=3><textarea id="zdrxs_xsqkms" maxlength=750></textarea></td></tr>'+
		 '	<tr><td class="infoName">属性信息</td><td class="infoValue" colspan=3>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openZtTab();">在逃</a>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openSwTab();">涉稳</a>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openSfTab();">涉访</a>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openSdXdTab();">涉毒-吸毒</a>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openSdFdTab();">涉毒-贩毒</a>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openSdZdTab();">涉毒-制毒</a>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openZdxsfzqkTab();">重大刑事犯罪前科</a>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openZszhjsbXsTab();">肇事肇祸精神病</a>'+
		 '	</td></tr>'+
		 '	<tr  align="center">'+
		 '		<td colspan=4>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'xs_Table\',\'zdrxs_\',\'/ryxs/saveRyxsb\');">提交</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reloadXsFrom();">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'写实信息\');">关闭</a>'+
		 '		</td>'+
		 ' </tr>'+
		 '	</table>';
		 $("#otherInfoListDiv").tabs('add',{
			 	id:'xs',
				title:'写实信息',
				closable:true,
				content:html
			});
		 Zdrxs.initXsSelectVal();
	}else{
		$("#otherInfoListDiv").tabs('select','写实信息');
	}
}
/**
 * @method:setSfjdbrVal
 * @package:syrk/js/qbld	
 * @description:设置是否见到本人
 * @param flag
 * @author:Li_Zhenzhong
 * @date:2015-6-3上午10:11:05
 */
Zdrxs.setSfjdbrVal = function(flag){
	flag = flag?1:0
	$("#zdrxs_sfjdbr").val(flag);
}
/**
 * @method:openZtTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员在逃信息窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午4:01:08
 */
Zdrxs.openZtTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','在逃信息')==null){
		var html ='<table class="infoBodyTable" id="zt_Table"> '+
		 '	<tr><td class="infoName">在逃类型</td><td class="infoValue"><input id="zdrxsZt_ztlx"></td>'+
		 '		<td class="infoName">立案时间</td><td class="infoValue" ><input id="zdrxsZt_lasj" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})"  ></td>'+
		 '		<td class="infoName">立案单位</td><td class="infoValue" ><input id="zdrxsZt_ladwdm" style="display:none"><input id="zdrxsZt_ladwmc" onClick="public_singleSelectOrg(\''+userOrgCode+'\', \'01\', \'32\', \'\', \'zdrxsZt_ladwdm\', \'zdrxsZt_ladwmc\', \'\', false, false, \'\', window, \'\', \'\')"></td></tr>'+
		 '	<tr><td class="infoName">逃跑时间</td><td class="infoValue" ><input id="zdrxsZt_tpsj" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" ></td>'+
		 '		<td class="infoName">逃跑方向</td><td class="infoValue"><input id="zdrxsZt_tpfx"></td>'+
		 '		<td class="infoName">立逃日期</td><td class="infoValue" ><input id="zdrxsZt_ltrq" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" ></td></tr>'+
		 '	<tr><td class="infoName">立逃单位</td><td class="infoValue"><input id="zdrxsZt_ltdwdm" style="display:none"><input id="zdrxsZt_ltdwmc" onClick="public_singleSelectOrg(\''+userOrgCode+'\', \'01\', \'32\', \'\', \'zdrxsZt_ltdwdm\', \'zdrxsZt_ltdwmc\', \'\', false, false, \'\', window, \'\', \'\')"></td>'+
		 '		<td class="infoName">案件类型</td><td class="infoValue" ><input id="zdrxsZt_ajlb"></td>'+
		 '		<td class="infoName">督捕级别</td><td class="infoValue"><input id="zdrxsZt_dbjb"></td>'+
		 '	<tr><td class="infoName">案情描述</td><td class="infoValue" colspan=5><textarea id="zdrxsZt_aqms" maxlength=1500 placeholder="最多填写1500个文字"></textarea></td></tr>' +
		 '	<tr  align="center">'+
		 '		<td colspan=6>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'zt_Table\',\'zdrxsZt_\',\'/zdry/saveZdryZtxxb\');">添加</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'zt_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'在逃信息\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="ztListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'zt',
			title:'在逃信息',
			closable:true,
			content:html
		});
		$("#zdrxsZt_ztlx").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZTLX.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsZt_tpfx").combotree({
			url:contextPath + '/common/dict/D_BZ_XZQH.js',
			onlyLeaf:true,
			multiple:false,
			panelWidth:320,
			method:'get',
			editable:true,
			lines:true,
			width:'100%'
		})
		$("#zdrxsZt_ajlb").combobox({
			url: contextPath + '/common/dict/D_QBLD_AJLB.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsZt_dbjb").combobox({
			url: contextPath + '/common/dict/D_QBLD_DBJB.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$('#ztListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdryZtList",
			queryParams:{"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'ztlx',title:'在逃类别',width:$("#otherInfoListDiv").width()*.24,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZTLX.js', value)}},   
						{field:'tpsj',title:'逃跑时间',width:$("#otherInfoListDiv").width()*.24,align:'center'},      
						{field:'tpfx',title:'逃跑方向',width:$("#otherInfoListDiv").width()*.24,align:'center',
		  		    		formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_BZ_XZQH.js', value)}}, 
						{field:'ltrq',title:'立逃日期',width:$("#otherInfoListDiv").width()*.24,align:'center'},   
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zdrxsZt_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','在逃信息');
	}
};
/**
 * @method:openSwTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员涉稳信息窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午4:01:41
 */
Zdrxs.openSwTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','涉稳信息')==null){
		var html ='<table class="infoBodyTable" id="sw_Table"> '+
		 '	<tr><td class="infoName">涉稳细类</td><td class="infoValue"><input id="zdrxsSw_sslbxl"></td>'+
		 '		<td class="infoName">所属组织</td><td class="infoValue"><input id="zdrxsSw_sszz"></td><tr>'+
		 '	<tr><td class="infoName">情况概述</td><td class="infoValue" colspan=3><textarea id="zdrxsSw_qkgs" maxlength=1500 placeholder="最多填写1500个文字"></textarea></td></tr>' +
		 '	<tr  align="center">'+
		 '		<td colspan=4>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'sw_Table\',\'zdrxsSw_\',\'/zdry/saveZdrySwxxb\');">添加</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'sw_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'涉稳信息\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="swListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'sw',
			title:'涉稳信息',
			closable:true,
			content:html
		});
		$("#zdrxsSw_sslbxl").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZDRYXL.js',
			dataFilter:'^02',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSw_sszz").combobox({
			url: contextPath + '/common/dict/D_QBLD_SSZZ.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$('#swListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdrySwList",
			queryParams:{"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'sslbxl',title:'涉稳细类',width:$("#otherInfoListDiv").width()*.25,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXL.js', value)}},            
						{field:'sszz',title:'所属组织',width:$("#otherInfoListDiv").width()*.25,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_SSZZ.js', value)}},       
						{field:'qkgs',title:'情况概述',width:$("#otherInfoListDiv").width()*.50,align:'center'},       
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zdrxsSw_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','涉稳信息');
	}
};
/**
 * @method:openSfTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员涉访信息窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午4:02:07
 */
Zdrxs.openSfTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','涉访信息')==null){
		var html ='<table class="infoBodyTable" id="sf_Table"> '+
		 '	<tr><td class="infoName">所属群体</td><td class="infoValue"><input id="zdrxsSF_ssqt"></td>'+
		 '		<td class="infoName">上访时间</td><td class="infoValue"><input id="zdrxsSF_sfsj"  onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" ></td>'+
		 '		<td class="infoName">上访地点</td><td class="infoValue"><input id="zdrxsSF_sfdd"></td><tr>'+
		 '	<tr><td class="infoName">包保单位名称</td><td class="infoValue"><input id="zdrxsSF_bbdwmc" maxlength=150></td>'+
		 '		<td class="infoName">包保领导</td><td class="infoValue"><input id="zdrxsSF_bbld" maxlength=150></td>'+
		 '		<td class="infoName">联系电话</td><td class="infoValue"><input id="zdrxsSF_lxdh" maxlength=300></td><tr>'+
		 '	<tr><td class="infoName">上访方式</td><td class="infoValue"><input id="zdrxsSF_sffs"></td>'+
		 '		<td class="infoName">处置结果</td><td class="infoValue"><input id="zdrxsSF_czjg"></td>'+
		 '		<td class="infoName">处置人员</td><td class="infoValue"><input id="zdrxsSF_czry maxlength=150"></td><tr>'+
		 '	<tr><td class="infoName">诉求级别</td><td class="infoValue"><input id="zdrxsSF_sqjb"></td>'+
		 '		<td class="infoName">是否息访</td><td class="infoValue"><input id="zdrxsSF_sfxf"></td>'+
		 '		<td class="infoName">预警级别</td><td class="infoValue"><input id="zdrxsSF_yjjb"></td><tr>'+
		 '	<tr><td class="infoName">主要原由</td><td class="infoValue" colspan=5><textarea id="zdrxsSF_zyyy" maxlength=1500 placeholder="最多填写1500个文字"></textarea></td></tr>' +
		 '	<tr><td class="infoName">上访过程描述</td><td class="infoValue" colspan=5><textarea id="zdrxsSF_sfgcms" maxlength=1500 placeholder="最多填写1500个文字"></textarea></td></tr>' +
		 '	<tr  align="center">'+
		 '		<td colspan=6>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'sf_Table\',\'zdrxsSF_\',\'/zdry/saveZdrySfxxb\');">添加</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'sf_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'涉访信息\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="sfListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'sf',
			title:'涉访信息',
			closable:true,
			content:html
		});
		$("#zdrxsSF_ssqt").combobox({
			url: contextPath + '/common/dict/D_QBLD_SSQT.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSF_sfdd").combotree({
			url:contextPath + '/common/dict/D_BZ_XZQH.js',
			onlyLeaf:true,
			multiple:false,
			panelWidth:320,
			method:'get',
			editable:true,
			lines:true,
			width:'100%'
		})
		$("#zdrxsSF_sffs").combobox({
			url: contextPath + '/common/dict/D_QBLD_SFFS.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSF_czjg").combobox({
			url: contextPath + '/common/dict/D_QBLD_CZJG.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSF_sqjb").combobox({
			url: contextPath + '/common/dict/D_QBLD_SQJB.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSF_yjjb").combobox({
			url: contextPath + '/common/dict/D_QBLD_YJJB.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSF_sfxf").combobox({
			url: contextPath + '/common/dict/D_QBLD_SF.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$('#sfListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdrySfList",
			queryParams:{"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'sfsj',title:'上访时间',width:$("#otherInfoListDiv").width()*.24,align:'center'},       
						{field:'sfdd',title:'上访地点',width:$("#otherInfoListDiv").width()*.24,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_BZ_XZQH.js', value)}},      
						{field:'sffs',title:'上访方式',width:$("#otherInfoListDiv").width()*.24,align:'center',
				  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_SFFS.js', value)}},      
						{field:'sjjb',title:'诉求级别',width:$("#otherInfoListDiv").width()*.24,align:'center',
					  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_SQJB.js', value)}},      
						{field:'cljg',title:'处置结果',width:$("#otherInfoListDiv").width()*.24,align:'center',
						  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_CZJG.js', value)}}      
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zdrxsSF_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','涉访信息');
	}
};
/**
 * @method:openSdXdTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员涉毒-吸毒信息窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午4:02:19
 */
Zdrxs.openSdXdTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','涉毒-吸毒信息')==null){
		var html ='<table class="infoBodyTable" id="sdxd_Table"> '+
		 '	<tr><td class="infoName">毒品种类</td><td class="infoValue"><input id="zdrxsSdXd_dpzl"></td>'+
		 '		<td class="infoName">毒品种类其他</td><td class="infoValue" colspan=3><input id="zdrxsSdXd_dpzlqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">毒品来源</td><td class="infoValue"><input id="zdrxsSdXd_dply"></td>'+
		 '		<td class="infoName">毒品来源其他</td><td class="infoValue" colspan=3><input id="zdrxsSdXd_dplyqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">毒资来源</td><td class="infoValue"><input id="zdrxsSdXd_dzly"></td>'+
		 '		<td class="infoName">毒资来源其他</td><td class="infoValue" colspan=3><input id="zdrxsSdXd_dzlyqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">吸食原因</td><td class="infoValue"><input id="zdrxsSdXd_xsyy"></td>'+
		 '		<td class="infoName">吸食次数</td><td class="infoValue"><input id="zdrxsSdXd_xscs" maxlength=3></td>'+
		 '		<td class="infoName">是否复吸</td><td class="infoValue"><input id="zdrxsSdXd_sffx"></td><tr>'+
		 '	<tr><td class="infoName">是否戒断</td><td class="infoValue"><input id="zdrxsSdXd_sfjd"></td>'+
		 '		<td class="infoName">戒断时间</td><td class="infoValue"><input id="zdrxsSdXd_jdsj"></td>'+
		 '		<td class="infoName">人员现状</td><td class="infoValue"><input id="zdrxsSdXd_ryxz" maxlength=150></td><tr>'+
		 '	<tr><td class="infoName">情况概述</td><td class="infoValue" colspan=5><input id="zdrxsSdXd_whhg" maxlength=750></td></tr>' +
		 '	<tr  align="center">'+
		 '		<td colspan=6>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'sdxd_Table\',\'zdrxsSdXd_\',\'/zdry/saveZdrySdXdxxb\');">添加</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'sdxd_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'涉毒-吸毒信息\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="sdxdListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'sdxd',
			title:'涉毒-吸毒信息',
			closable:true,
			content:html
		});
		$("#zdrxsSdXd_sffx").combobox({
			url: contextPath + '/common/dict/D_QBLD_SF.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdXd_sfjd").combobox({
			url: contextPath + '/common/dict/D_QBLD_SF.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdXd_dpzl").combobox({
			url: contextPath + '/common/dict/D_QBLD_DPZL.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdXd_dply").combobox({
			url: contextPath + '/common/dict/D_QBLD_XDDPLY.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdXd_dzly").combobox({
			url: contextPath + '/common/dict/D_QBLD_DZLY.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdXd_xsyy").combobox({
			url: contextPath + '/common/dict/D_QBLD_XSYY.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$("#zdrxsSdXd_jdsj").combobox({
			url: contextPath + '/common/dict/D_QBLD_JDSJ.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdXd_jdsj").combobox({
			url: contextPath + '/common/dict/D_QBLD_JDSJ.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdXd_ryxz").combobox({
			url: contextPath + '/common/dict/D_QBLD_RYXZ.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$('#sdxdListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdrySdXdList",
			queryParams:{"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'dpzl',title:'毒品种类',width:$("#otherInfoListDiv").width()*.19,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPZL.js', value)}},        
						{field:'dply',title:'毒品来源',width:$("#otherInfoListDiv").width()*.19,align:'center',
				  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_XDDPLY.js', value)}},       
						{field:'dzly',title:'毒资来源',width:$("#otherInfoListDiv").width()*.19,align:'center',
					  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_DZLY.js', value)}},        
						{field:'xsyy',title:'吸食原因',width:$("#otherInfoListDiv").width()*.19,align:'center',
						  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_XSYY.js', value)}},      
						{field:'ryxz',title:'人员现状',width:$("#otherInfoListDiv").width()*.19,align:'center',
							  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_RYXZ.js', value)}} 
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zdrxsSdXd_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','涉毒-吸毒信息');
	}
};
/**
 * @method:openSdZdTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员涉毒-制毒信息窗口
 * @author:Li_Zhenzhong
 * @date:2015-6-3下午5:54:11
 */
Zdrxs.openSdZdTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','涉毒-制毒信息')==null){
		var html ='<table class="infoBodyTable" id="sdzd_Table"> '+
		 '	<tr><td class="infoName">毒品种类</td><td class="infoValue"><input id="zdrxsSdZd_dpzl"></td>'+
		 '		<td class="infoName">毒品种类其他</td><td class="infoValue" colspan=3><input id="zdrxsSdZd_dpzlqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">制毒化学品</td><td class="infoValue"><input id="zdrxsSdZd_zdhxp"></td>'+
		 '		<td class="infoName">制毒化学品其他</td><td class="infoValue" colspan=3><input id="zdrxsSdZd_zdhxpqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">毒品去向</td><td class="infoValue"><input id="zdrxsSdZd_dpqx"></td>'+
		 '		<td class="infoName">毒品去向其他</td><td class="infoValue" colspan=3><input id="zdrxsSdZd_dpqxqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">毒资去向</td><td class="infoValue"><input id="zdrxsSdZd_shdzqx"></td>'+
		 '		<td class="infoName">毒资取向其他</td><td class="infoValue" colspan=3><input id="zdrxsSdZd_dzqxqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">贩毒地点</td><td class="infoValue" colspan=5><input id="zdrxsSdZd_fmdd"></td></tr>' +
		 '	<tr  align="center">'+
		 '		<td colspan=6>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'sdzd_Table\',\'zdrxsSdZd_\',\'/zdry/saveZdrySdZdxxb\');">添加</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'sdzd_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'涉毒-制毒信息\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="sdzdListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'sdzd',
			title:'涉毒-制毒信息',
			closable:true,
			content:html
		});
		$("#zdrxsSdZd_dpzl").combobox({
			url: contextPath + '/common/dict/D_QBLD_DPZL.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdZd_zdhxp").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZDHXP.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdZd_dpqx").combobox({
			url: contextPath + '/common/dict/D_QBLD_DPQX.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdZd_shdzqx").combobox({
			url: contextPath + '/common/dict/D_QBLD_DZQX.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$("#zdrxsSdZd_fmdd").combotree({
			url:contextPath + '/common/dict/D_BZ_XZQH.js',
			onlyLeaf:true,
			multiple:false,
			panelWidth:320,
			method:'get',
			editable:true,
			lines:true,
			width:'100%'
		})
		
		
		$('#sdzdListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdrySdZdList",
			queryParams:{"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'dpzl',title:'毒品种类',width:$("#otherInfoListDiv").width()*.24,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPZL.js', value)}},       
						{field:'zdhxp',title:'制毒化学品',width:$("#otherInfoListDiv").width()*.24,align:'center',
				  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDHXP.js', value)}},       
						{field:'dpqx',title:'制毒去向',width:$("#otherInfoListDiv").width()*.24,align:'center',
					  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPQX.js', value)}},       
						{field:'shdzqx',title:'毒资去向',width:$("#otherInfoListDiv").width()*.24,align:'center',
						  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_DZQX.js', value)}}
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zdrxsSdZd_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','涉毒-制毒信息');
	}
};
/**
 * @method:openSdFdTab
 * @package:syrk/js/qbld	
 * @description:涉毒-贩毒信息添加
 * @author:Li_Zhenzhong
 * @date:2015-6-4下午2:55:31
 */
Zdrxs.openSdFdTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','涉毒-贩毒信息')==null){
		var html ='<table class="infoBodyTable" id="sdfd_Table"> '+
		 '	<tr><td class="infoName">毒品种类</td><td class="infoValue"><input id="zdrxsSdFd_fmdpzl"></td>'+
		 '		<td class="infoName">毒品种类其他</td><td class="infoValue" ><input id="zdrxsSdFd_dplyqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">毒品来源</td><td class="infoValue"><input id="zdrxsSdFd_dply" maxlength=300></td>'+
		 '		<td class="infoName">毒品来源其他</td><td class="infoValue" ><input id="zdrxsSdFd_dplyqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">来源地</td><td class="infoValue" colspan=3><input id="zdrxsSdFd_lyd"></td></tr>'+
		 '	<tr><td class="infoName">贩卖毒品渠道</td><td class="infoValue"><input id="zdrxsSdFd_fmdpqd"></td>' +
		 '		<td class="infoName">毒品其他渠道</td><td class="infoValue" ><input id="zdrxsSdFd_dpqdqt" maxlength=150></td></tr>'+
		 '	<tr><td class="infoName">毒资去向</td><td class="infoValue"><input id="zdrxsSdFd_shdzqx"></td>'+
		 '		<td class="infoName">毒资取向其他</td><td class="infoValue"><input id="zdrxsSdFd_dzqxqt" maxlength=150></td></tr>'+
		 '	<tr  align="center">'+
		 '		<td colspan=4>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'sdfd_Table\',\'zdrxsSdFd_\',\'/zdry/saveZdrySdFdxxb\');">添加</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'sdfd_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'涉毒-贩毒信息\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="sdfdListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'sdfd',
			title:'涉毒-贩毒信息',
			closable:true,
			content:html
		});
		$("#zdrxsSdFd_fmdpzl").combobox({
			url: contextPath + '/common/dict/D_QBLD_DPZL.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdFd_dply").combobox({
			url: contextPath + '/common/dict/D_QBLD_FDDPLY.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdFd_fmdpqd").combobox({
			url: contextPath + '/common/dict/D_QBLD_FDQD.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdrxsSdFd_shdzqx").combobox({
			url: contextPath + '/common/dict/D_QBLD_DZQX.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$("#zdrxsSdFd_lyd").combotree({
			url:contextPath + '/common/dict/D_BZ_XZQH.js',
			onlyLeaf:true,
			multiple:false,
			panelWidth:320,
			method:'get',
			editable:true,
			lines:true,
			width:'100%'
		})
		
		
		$('#sdfdListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdrySdFdList",
			queryParams:{"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'dpzl',title:'毒品种类',width:$("#otherInfoListDiv").width()*.24,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPZL.js', value)}},          
						{field:'dply',title:'毒品来源',width:$("#otherInfoListDiv").width()*.24,align:'center',
				  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_FDDPLY.js', value)}},          
						{field:'fmdpqd',title:'贩卖毒品渠道',width:$("#otherInfoListDiv").width()*.24,align:'center',
					  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_FDQD.js', value)}},           
						{field:'shdzqx',title:'毒资去向',width:$("#otherInfoListDiv").width()*.24,align:'center',
						  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_DZQX.js', value)}}     
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zdrxsSdFd_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','涉毒-贩毒信息');
	}
};
/**
 * @method:openZdxsfzqkTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员重大刑事犯罪前科窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午4:02:31
 */
Zdrxs.openZdxsfzqkTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','重大刑事犯罪前科')==null){
		var html ='<table class="infoBodyTable" id="zdssfzqk_Table"> '+
		 '	<tr><td class="infoName">所属类别细类</td><td class="infoValue" colspan=5><input id="zdssfzqk_sslbxl"></td></tr>'+
		 '	<tr><td class="infoName">作案手段</td><td class="infoValue"><input id="zdssfzqk_zasd" maxlength=300></td>'+
		 '		<td class="infoName">作案工具</td><td class="infoValue"><input id="zdssfzqk_zagj" maxlength=300></td>'+
		 '		<td class="infoName">作案工具来源</td><td class="infoValue" ><input id="zdssfzqk_zagjly" maxlength=150></td></tr>'+
		 
		 '	<tr><td class="infoName">作案特点</td><td class="infoValue"><input id="zdssfzqk_zatd" maxlength=300></td>'+
		 '		<td class="infoName">选择对象</td><td class="infoValue"><input id="zdssfzqk_xzdx" maxlength=300></td>'+
		 '		<td class="infoName">选择物品</td><td class="infoValue" ><input id="zdssfzqk_xzwp" maxlength=150></td></tr>'+
		 
		 '	<tr><td class="infoName">选择处所</td><td class="infoValue"><input id="zdssfzqk_xzcs" maxlength=300></td>'+
		 '		<td class="infoName">是否踩点</td><td class="infoValue"><input id="zdssfzqk_sfcd" maxlength=300></td>'+
		 '		<td class="infoName">选择时机</td><td class="infoValue" ><input id="zdssfzqk_xzsj" maxlength=150></td></tr>'+
		 
		 '	<tr><td class="infoName">销赃渠道</td><td class="infoValue"><input id="zdssfzqk_xzqd" ></td>'+
		 ' 		<td class="infoName">销赃方法</td><td class="infoValue"><input id="zdssfzqk_xzff" ></td>'+
		 '		<td class="infoName">销赃地区</td><td class="infoValue" ><input id="zdssfzqk_xzdq" </td></tr>'+
		 
		 '	<tr><td class="infoName">管控注意事项</td><td class="infoValue" colspan=5><textarea id="zdssfzqk_gkzysx" maxlength=750 placeholder="最多填写750个文字"></textarea></td></tr>'+
		 
		 '	<tr><td class="infoName red">作案组织形式</td><td class="infoValue" colspan=5><input id="zdssfzqk_sfthza"></td></tr>'+

		 '	<tr><td class="infoName">结伙方式</td><td class="infoValue"><input id="zdssfzqk_jhfs" ></td>'+
		 '		<td class="infoName">作案地逗留方式</td><td class="infoValue"><input id="zdssfzqk_zaddlfs" ></td>'+
		 '		<td class="infoName">异地逗留方式</td><td class="infoValue" ><input id="zdssfzqk_yddlfs" ></td></tr>'+
		 '	<tr><td class="infoName">案前联系方式</td><td class="infoValue"><input id="zdssfzqk_aqlxfs"></td>'+
		 '		<td class="infoName">案前其他联系方式</td><td class="infoValue" colspan=3><input id="zdssfzqk_aqqtlxfs" maxlength=300></td></tr>'+
		 '	<tr><td class="infoName">案中联系方式</td><td class="infoValue"><input id="zdssfzqk_azlxfs" ></td>'+
		 '		<td class="infoName">案中其他联系方式</td><td class="infoValue" colspan=3><input id="zdssfzqk_azqtlxfs"  maxlength=300></td></tr>'+
		 '	<tr><td class="infoName">案后联系方式</td><td class="infoValue"><input id="zdssfzqk_ahlxfs"></td>'+
		 '		<td class="infoName">案后其他联系方式</td><td class="infoValue" colspan=3><input id="zdssfzqk_ahqtlxfs"  maxlength=300></td></tr>'+
		 
		 '	<tr  align="center">'+
		 '		<td colspan=6>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'zdssfzqk_Table\',\'zdssfzqk_\',\'/zdry/saveZdryZdxsfzqkxxb\');">添加</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'zdssfzqk_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'重大刑事犯罪前科\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="zdssfzqkListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'zdssfzqk',
			title:'重大刑事犯罪前科',
			closable:true,
			content:html
		});
		$("#zdssfzqk_sslbxl").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZDRYXL.js',
			dataFilter:'^05',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_zasd").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZASD.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_zagj").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZAGJ.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		
		$("#zdssfzqk_zatd").combobox({
			url: contextPath + '/common/dict/D_BZ_ZATD.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_xzdx").combobox({
			url: contextPath + '/common/dict/D_QBLD_XZDX.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_xzwp").combobox({
			url: contextPath + '/common/dict/D_BZ_XZWP.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_xzcs").combobox({
			url: contextPath + '/common/dict/D_QBLD_XZCS.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_sfcd").combobox({
			url: contextPath + '/common/dict/D_QBLD_SF.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_xzsj").combobox({
			url: contextPath + '/common/dict/D_QBLD_XZSJ.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_xzqd").combobox({
			url: contextPath + '/common/dict/D_QBLD_XZQD.js',
			dataFilter:'^1',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$("#zdssfzqk_xzff").combobox({
			url: contextPath + '/common/dict/D_QBLD_XZFF.js',
			dataFilter:'^2',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$("#zdssfzqk_xzdq").combobox({
			url: contextPath + '/common/dict/D_QBLD_XZDQ.js',
			dataFilter:'^3',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_sfthza").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZAZZXS.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_jhfs").combobox({
			url: contextPath + '/common/dict/D_QBLD_CYGX.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_zaddlfs").combobox({
			url: contextPath + '/common/dict/D_QBLD_DLFS.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$("#zdssfzqk_yddlfs").combobox({
			url: contextPath + '/common/dict/D_QBLD_DLFS.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$("#zdssfzqk_aqlxfs").combobox({
			url: contextPath + '/common/dict/D_QBLD_YTHLXFS.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_azlxfs").combobox({
			url: contextPath + '/common/dict/D_QBLD_YTHLXFS.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zdssfzqk_ahlxfs").combobox({
			url: contextPath + '/common/dict/D_QBLD_YTHLXFS.js',
			valueField:'id',
			multiple:true,
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$('#zdssfzqkListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdryZdxsfzqkList",
			queryParams:{"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'dpzl',title:'作案手段',width:$("#otherInfoListDiv").width()*.19,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPZL.js', value)}},             
						{field:'dply',title:'作案工具',width:$("#otherInfoListDiv").width()*.19,align:'center'},       
						{field:'fmdpqd',title:'作案特点',width:$("#otherInfoListDiv").width()*.19,align:'center'},       
						{field:'shdzqx',title:'作案对象',width:$("#otherInfoListDiv").width()*.19,align:'center'},   
						{field:'shdzqx',title:'管控注意事项',width:$("#otherInfoListDiv").width()*.19,align:'center'} 
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zdssfzqk_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','重大刑事犯罪前科');
	}
};
/**
 * @method:openZszhjsbXsTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员肇事肇祸精神病写实窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午4:02:42
 */
Zdrxs.openZszhjsbXsTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','肇事肇祸精神病')==null){
		var html ='<table class="infoBodyTable" id="zszhjsbXs_Table"> '+
		 '	<tr><td class="infoName">病人类别</td><td class="infoValue"><input id="zszhjsbXs_brlb"><input id="zszhjsbXs_xxbh" value=\"'+(new Date()).getTime()+'\"  style="display:none"></td>'+
		 '		<td class="infoName">现实状况</td><td class="infoValue" ><input id="zszhjsbXs_xszk" ></td></tr>'+
		 '	<tr><td class="infoName">病情描述</td><td class="infoValue" colspan=3><textarea id="zszhjsbXs_bqms" maxlength=1500></textarea></td></tr>'+
		 '	<tr><td class="infoName">主要病因</td><td class="infoValue" colspan=3><textarea id="zszhjsbXs_zyby" maxlength=1500></textarea></td></tr>'+
		 '	<tr><td class="infoValue" colspan=4>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openZszhjsbZdjlTab();">诊断记录</a>'+
		 '		<a href="#" class="easyui-linkbutton" iconCls="icon-attach" plain="true" onclick="Zdrxs.openZszhjsbZszhjlTab();">肇事肇祸记录</a>'+
		 '	</td></tr>'+
		 '	<tr  align="center">'+
		 '		<td colspan=4>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'zszhjsbXs_Table\',\'zszhjsbXs_\',\'/zdry/saveZdryZszhjsbxxb\');">添加</a>'+//TODO
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'zszhjsbXs_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'肇事肇祸精神病\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="zszhjsbXsListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'zszhjsbXs',
			title:'肇事肇祸精神病',
			closable:true,
			content:html
		});
		$("#zszhjsbXs_brlb").combobox({
			url: contextPath + '/common/dict/D_QBLD_BRLB.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zszhjsbXs_xszk").combobox({
			url: contextPath + '/common/dict/D_QBLD_XSZK.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
				
		$('#zszhjsbXsListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdryZszhjsbList",
			queryParams:{"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'brlb',title:'病人类别',width:$("#otherInfoListDiv").width()*.24,align:'center',
			  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_BRLB.js', value)}},              
						{field:'xszk',title:'现实状况',width:$("#otherInfoListDiv").width()*.24,align:'center',
				  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_XSZK.js', value)}},              
						{field:'bqms',title:'病情描述',width:$("#otherInfoListDiv").width()*.24,align:'center'},       
						{field:'zyby',title:'主要病因',width:$("#otherInfoListDiv").width()*.24,align:'center'}  
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zszhjsbXs_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','肇事肇祸精神病');
		Zdrxs.reset("zszhjsbXs_Table");
	}
};
/**
 * @method:openZszhjsbXsTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员肇事肇祸精神病诊断记录窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午4:02:42
 */
Zdrxs.openZszhjsbZdjlTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','肇事肇祸精神病-诊断记录')==null){
		var html ='<table class="infoBodyTable" id="zszhjsbZdjl_Table"> '+
		 '	<tr><td class="infoName">诊断时间</td><td class="infoValue"><input id="zszhjsbZdjl_zdsj" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})"></td>'+
		 '		<td class="infoName">诊断结果</td><td class="infoValue"><input id="zszhjsbZdjl_qzjg" maxlength=150></td>'+
		 '		<td class="infoName">诊断单号</td><td class="infoValue" ><input id="zszhjsbZdjl_zddh" maxlength=75>'+
		 '		<input id="zszhjsbZdjl_xxbh" value="'+$("#zszhjsbXs_xxbh").val()+'"  style="display:none"></td></tr>'+
		 
		 '	<tr><td class="infoName">确诊医院</td><td class="infoValue"><input id="zszhjsbZdjl_qzyy" maxlength=150></td>'+
		 '		<td class="infoName">确诊医师</td><td class="infoValue"><input id="zszhjsbZdjl_qzys" maxlength=75></td>'+
		 '		<td class="infoName">确诊医生联系电话</td><td class="infoValue" ><input id="zszhjsbZdjl_qzyslxdh" maxlength=75></td></tr>'+
		 
		 '	<tr><td class="infoName">鉴定人</td><td class="infoValue"><input id="zszhjsbZdjl_jdr" maxlength=75></td>'+
		 '		<td class="infoName">鉴定人联系电话</td><td class="infoValue" colspan=3><input id="zszhjsbZdjl_jdrlxdh" maxlength=75></td></tr>'+
		 
		 '	<tr><td class="infoName">诊断过程描述</td><td class="infoValue" colspan=5><textarea id="zszhjsbZdjl_zdgcms" maxlength=750></textarea></td></tr>'+
		 '	<tr  align="center">'+
		 '		<td colspan=6>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'zszhjsbZdjl_Table\',\'zszhjsbZdjl_\',\'/zdry/saveZdjlb\');">添加</a>'+//TODO
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'zszhjsbZdjl_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'肇事肇祸精神病-诊断记录\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="zszhjsbZdjlListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'zszhjsbZdjl',
			title:'肇事肇祸精神病-诊断记录',
			closable:true,
			content:html
		});
		$('#zszhjsbZdjlListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZdjlList",
			queryParams:{"xxbh":$('#zszhjsbXs_xxbh').val()},
			pageSize:10,
			columns:[[
						{field:'zdsj',title:'诊断时间',width:$("#otherInfoListDiv").width()*.24,align:'center'},       
						{field:'qzjg',title:'诊断结果',width:$("#otherInfoListDiv").width()*.24,align:'center'},       
						{field:'qzyy',title:'确诊医院',width:$("#otherInfoListDiv").width()*.24,align:'center'},       
						{field:'qzyslxdh',title:'确诊医师',width:$("#otherInfoListDiv").width()*.24,align:'center'}  
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zszhjsbZdjl_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','肇事肇祸精神病-诊断记录');
		Zdrxs.reset("zszhjsbZdjl_Table");
	}
};
/**
 * @method:openZszhjsbZszhjlTab
 * @package:syrk/js/qbld	
 * @description:打开写实人员肇事肇祸精神病肇事肇祸记录窗口
 * @author:Li_Zhenzhong
 * @date:2015-6-4下午5:35:54
 */
Zdrxs.openZszhjsbZszhjlTab = function(){
	if($("#otherInfoListDiv").tabs('getTab','肇事肇祸精神病-肇事肇祸记录')==null){
		var html ='<table class="infoBodyTable" id="zszhjsbZszhjl_Table"> '+
		 '	<tr><td class="infoName">肇事肇祸类别</td><td class="infoValue"><input id="zszhjsbZszhjl_zszhlb"></td>'+
		 '		<td class="infoName">事发时间</td><td class="infoValue"><input id="zszhjsbZszhjl_sfsj"  onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})"></td>'+
		 '		<td class="infoName">事发地点</td><td class="infoValue" ><input id="zszhjsbZszhjl_sfdd" maxlength=300>'+
		 '		<input id="zszhjsbZszhjl_xxbh" value="'+$("#zszhjsbXs_xxbh").val()+'"  style="display:none"></td></tr>'+
		 
		 '	<tr><td class="infoName">处理结果</td><td class="infoValue"><input id="zszhjsbZszhjl_cljg" maxlength=150></td>'+
		 '		<td class="infoName">鉴定机构</td><td class="infoValue"><input id="zszhjsbZszhjl_JDJG" maxlength=75></td>'+
		 '		<td class="infoName">鉴定结果</td><td class="infoValue" ><input id="zszhjsbZszhjl_JDJGBH" maxlength=75></td></tr>'+
		 
		 '	<tr><td class="infoName">鉴定单号</td><td class="infoValue"><input id="zszhjsbZszhjl_jddh" maxlength=150></td>'+
		 '		<td class="infoName">鉴定人</td><td class="infoValue"><input id="zszhjsbZszhjl_jdr" maxlength=75></td>'+
		 '		<td class="infoName">鉴定人联系电话</td><td class="infoValue" ><input id="zszhjsbZszhjl_jdrlxdh" maxlength=150></td></tr>'+
		 
		 '	<tr><td class="infoName">办案民警</td><td class="infoValue"><input id="zszhjsbZszhjl_bamj" readonly placeholder="点击选择发现责任民警"  onclick="public_singleSelectOrgUser(\'\', \'\', \'\', \'\', \'\',\'\', \'\', \'zszhjsbZszhjl_bamj\', \'\', \'zszhjsbZszhjl_ssgajgdm\', \'zszhjsbZszhjl_ssgajgmc\', \'\', false, \'\', window, \'\', \'\')"></td>'+
		 '		<td class="infoName">民警联系方式</td><td class="infoValue"><input id="zszhjsbZszhjl_mjlxfs" maxlength=150></td>'+
		 '		<td class="infoName">所属公安机关</td><td class="infoValue" ><input id="zszhjsbZszhjl_ssgajgmc" readonly><input id="zszhjsbZszhjl_ssgajgdm" style="display:none"></td></tr>'+
		 
		 '	<tr><td class="infoName">事件过程描述</td><td class="infoValue" colspan=5><textarea id="zszhjsbZszhjl_sjgcms" maxlength=1500></textarea></td></tr>'+
		 '	<tr  align="center">'+
		 '		<td colspan=6>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'zszhjsbZszhjl_Table\',\'zszhjsbZszhjl_\',\'/zdry/saveZsjlb\');">添加</a>'+//TODO
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'zszhjsbZszhjl_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'肇事肇祸精神病-肇事肇祸记录\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="zszhjsbZszhjlListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'zszhjsbZszhjl',
			title:'肇事肇祸精神病-肇事肇祸记录',
			closable:true,
			content:html
		});
		$("#zszhjsbZszhjl_zszhlb").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZSZHLB.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zszhjsbZszhjl_cljg").combobox({
			url: contextPath + '/common/dict/D_QBLD_CLJG.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#zszhjsbZszhjl_JDJGBH").combobox({
			url: contextPath + '/common/dict/D_QBLD_JDJG.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		
		$('#zszhjsbZszhjlListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryZsjlList",
			queryParams:{"xxbh":$('#zszhjsbXs_xxbh').val()},
			pageSize:10,
			columns:[[
						{field:'zszhlb',title:'肇事肇祸类别',width:$("#otherInfoListDiv").width()*.19,align:'center'},       
						{field:'sfdd',title:'事发地点',width:$("#otherInfoListDiv").width()*.19,align:'center'},       
						{field:'cljg',title:'处理结果',width:$("#otherInfoListDiv").width()*.19,align:'center'},       
						{field:'jdjgbh',title:'鉴定结果',width:$("#otherInfoListDiv").width()*.19,align:'center'},      
						{field:'sfsj',title:'事发时间',width:$("#otherInfoListDiv").width()*.19,align:'center'}  
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showInfo(row,"zszhjsbZszhjl_");
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','肇事肇祸精神病-肇事肇祸记录');
	}
};
/**
 * @method:openShgxrTab
 * @package:syrk/js/qbld	
 * @description:初始化社会关系人窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午5:40:14
 */
Zdrxs.openShgxrTab = function(){
	$("#opInfoTr").show();
	if($("#otherInfoListDiv").tabs('getTab','社会关系人')==null){
		$("#otherInfoListDiv").tabs('add',{
			title:'社会关系人',
			closable:true,
			content:"<div id='shgxrListDiv'></div>"
		});
		$('#shgxrListDiv').datagrid({
			idField:'shgxrbh',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryShgxrList",
			queryParams:{"zdry_zjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			toolbar: [{
				iconCls: 'icon-add',
				handler: function(){Zdrxs.showMoreShgxrInfo();}
			}],

			columns:[[
		  		    {field:'xm',title:'姓名',width:$('#otherInfoListDiv').width()*.24,align:'center'},
		  		    {field:'zjhm',title:'证件号码',width:$('#otherInfoListDiv').width()*.24,align:'center'},    
		  		    {field:'gx',title:'关系类型',width:$('#otherInfoListDiv').width()*.24,align:'center',
		  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYZK.js', value)}},
		  		    {field:'zdryxl',title:'重点人员细类',width:$('#otherInfoListDiv').width()*.24,align:'center',
		  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYZK.js', value)}}
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showMoreShgxrInfo(row);
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','社会关系人');
	}
};
/**
 * @method:showMoreShgxrInfo
 * @package:syrk/js/qbld	
 * @description:社会关系人信息
 * @param row
 * @author:Li_Zhenzhong
 * @date:2015-6-8上午10:52:59
 */
Zdrxs.showMoreShgxrInfo = function(row){
	if($("#otherInfoListDiv").tabs('getTab','社会关系人信息')==null){
		var html = "";
		html = Zdrxs.initShgxrHtml(row)
		$("#otherInfoListDiv").tabs('add',{
			title:'社会关系人信息',
			closable:true,
			content:html
		});
		Zdrxs.initShgxrSelectVal();
	}else{
		$("#otherInfoListDiv").tabs('select','社会关系人信息');
		html = Zdrxs.initShgxrHtml(row);
		var tab = $('#otherInfoListDiv').tabs('getSelected');  // 获取选择的面板
		tab.panel('refresh', html);
		Zdrxs.initShgxrSelectVal();
	}
}
/**
 * @method:initShgxrHtml
 * @package:syrk/js/qbld	
 * @description:初始化社会关系界面
 * @param row
 * @returns
 * @author:Li_Zhenzhong
 * @date:2015-6-10上午10:30:31
 */
Zdrxs.initShgxrHtml = function(row){
	if(row == null){
		html ="<table class='infoBodyTable' id='shgxr_Table'>" +
		"<tr><td class='infoName red'>证件类型</td><td class='infoValue' ><input id='shgxr_zjlx'  class='notNull' ></td>" +
		"	 <td class='infoName red' >证件号码</td><td class='infoValue' colspan=2><input id='shgxr_zjhm'   class='notNull' ></td><td id='shgxr_imgTd' rowspan=6><img></img></td></tr>" +
		"<tr><td class='infoName'>部级重点人员编号</td><td class='infoValue' ><input id='shgxr_bjzdrybh'> </td><td class='infoName'>省级重点人员编号</td><td class='infoValue'  colspan=2><input id='shgxr_sjzdrybh'> </td></tr>" +
		"<tr><td class='infoName red'>关系类型</td><td class='infoValue' ><input id='shgxr_gx'   class='notNull' ></td>" +
		"	 <td class='infoName red'>重点人员细类</td><td class='infoValue'  colspan=2><input id='shgxr_zdryxl'   class='notNull' > </td></tr>" +
		"<tr><td class='infoName red'>姓名</td><td class='infoValue' ><input id='shgxr_xm'   class='notNull' ></td>" +
		"	 <td class='infoName red'>性别</td><td class='infoValue'  colspan=2><input id='shgxr_xb'   class='notNull' > </td></tr>" +
		"<tr><td class='infoName red'>名族</td><td class='infoValue' ><input id='shgxr_mz'   class='notNull' ></td>" +
		"	 <td class='infoName red'>国籍</td><td class='infoValue'  colspan=2><input id='shgxr_gj' class='notNull' > </td></tr>" +
		"<tr><td class='infoName red'>户籍区划</td><td class='infoValue' ><input id='shgxr_hjqh'  class='notNull' ></td>" +
		"	 <td class='infoName red'>户籍地派出所</td><td class='infoValue'  colspan=2><input id='shgxr_hjdpcs' style='display:none'   class='notNull' ><input id='shgxr_hjdpcs'   class='notNull'  onclick='onclick='public_singleSelectOrg(\'"+userOrgCode+"\', \'01\', \'32\', \'\', \'shgxr_gxdwdm\', \'shgxr_hjdpcs\', \'\', false, false, \'\', window, \'\', \'\')''> </td></tr>" +
		"<tr><td class='infoName red'>户籍地祥址</td><td class='infoValue'  colspan=5><input id='shgxr_hjdxz'   class='notNull' ></td></tr>" +
		"<tr><td class='infoName'>入库时间</td><td class='infoValue' ><input id='shgxr_rksj' readonly></td><td class='infoName'>填报单位名称</td><td class='infoValue' colspan=3><input id='shgxr_tbdwmc' value='"+userOrgName+"' readonly> </td></tr>" +
		"<tr><td class='infoName'>曾用名</td><td class='infoValue' ><input id='shgxr_cym'></td>" +
		"	 <td class='infoName'>绰号</td><td class='infoValue' ><input id='shgxr_ch'></td>" +
		"	 <td class='infoName'>政治面貌</td><td class='infoValue' ><input id='shgxr_zzmm'> </td></tr>" +
		"<tr><td class='infoName'>宗教信仰</td><td class='infoValue' ><input id='shgxr_zjxy'></td>" +
		"	 <td class='infoName'>出生日期</td><td class='infoValue' ><input id='shgxr_csrq' onclick='WdatePicker({skin:\"whyGreen\",dateFmt:\"yyyyMMddHHmmss\"})'></td>" +
		"	 <td class='infoName'>婚姻状况</td><td class='infoValue' ><input id='shgxr_hyzk'> </td></tr>" +
		"<tr><td class='infoName'>文化程度</td><td class='infoValue' ><input id='shgxr_whcd'></td>" +
		"	 <td class='infoName'>身高(cm)</td><td class='infoValue' ><input id='shgxr_sg' maxlength=3></td>" +
		"	 <td class='infoName'>体重(KG)</td><td class='infoValue' ><input id='shgxr_tz' maxlength=3></td></tr>" +
		"<tr><td class='infoName'>足长(mm)</td><td class='infoValue' ><input id='shgxr_zc' maxlength=3></td>" +
		"	 <td class='infoName'>鞋号(mm)</td><td class='infoValue' ><input id='shgxr_xh' maxlength=3></td>" +
		"	 <td class='infoName'>口音</td><td class='infoValue' ><input id='shgxr_ky'> </td></tr>" +
		"<tr><td class='infoName'>特长</td><td class='infoValue' ><input id='shgxr_tc'></td>" +
		"	 <td class='infoName'>兴趣爱好</td><td class='infoValue' ><input id='shgxr_xxah'></td>" +
		"	 <td class='infoName'>体貌特征</td><td class='infoValue' ><input id='shgxr_tmtz'> </td></tr>" +
		"<tr><td class='infoName'>DNA</td><td class='infoValue' ><input id='shgxr_dna'></td>" +
		"	 <td class='infoName'>血型</td><td class='infoValue' ><input id='shgxr_xx'></td>" +
		"	 <td class='infoName'>指纹编号</td><td class='infoValue' ><input id='shgxr_zwbh'> </td></tr>" +
		"<tr><td class='infoName'>职业</td><td class='infoValue' ><input id='shgxr_zy'></td>" +
		"	 <td class='infoName'>实际收入</td><td class='infoValue' ><input id='shgxr_sjsr'></td>" +
		"	 <td class='infoName'>经济来源</td><td class='infoValue' ><input id='shgxr_jjly'> </td></tr>" +
		"<tr><td class='infoName'>特殊标记</td><td class='infoValue' colspan=5 ><input id='shgxr_tmtz_rtbw' style='width:100px'><input id='shgxr_tmtz_tsbj' style='width:100px'>" +
		"			<a href='#' class='easyui-linkbutton' iconCls='icon-add' onclick='$(\"#shgxr_tsbj\").val($(\"#shgxr_tsbj\").val()+$(\"#shgxr_tmtz_rtbw\").combobox(\"getText\")+\":\"+$(\"#shgxr_tmtz_tsbj\").combobox(\"getText\")+\",\")'>添加</a>"+
		"<br><input id='shgxr_tsbj'></td></tr>" +
		"<tr><td class='infoName'>联系方式</td><td class='infoValue' colspan=5 ><input  id='shgxr_tbdwd'></td></tr>" +
		"<tr><td class='infoName'>工作单位区划</td><td class='infoValue' ><input id='shgxr_gzdwqh'></td>" +
		"	 <td class='infoName'>工作单位</td><td class='infoValue'  colspan=3><input id='shgxr_gzdw'> </td></tr>" +
		"<tr><td class='infoName'>工作单位祥址</td><td class='infoValue' colspan=5><input  id='shgxr_gzdwxz'></td></tr>" +
		"<tr><td class='infoName'>现住地区划</td><td class='infoValue' ><input id='shgxr_xzdqh'></td>" +
		"	 <td class='infoName'>管辖单位</td><td class='infoValue' colspan=3 ><input id='shgxr_gxdwdm' style='display:none'><input id='shgxr_gxdw'  onclick='public_singleSelectOrg(\'210000000000\', \'01\', \'32\', \'\', \'shgxr_gxdwdm\', \'shgxr_gxdw\', \'\', false, false, \'\', window, \'\', \'\')'></td></tr>" +
		"<tr><td class='infoName'>现住地祥址</td><td class='infoValue' colspan=5 ><input id='shgxr_xzdxz'></td></tr>" +
		 "	<tr  align='center'>" +
		 "		<td colspan=6>" +
		 "			<a href='#' class='easyui-linkbutton' iconCls='icon-add' onclick='Zdrxs.saveZdryOtherInfo(\"shgxr_Table\",\"shgxr_\",\"/zdry/saveShgxrxxb\");'>添加</a>" +
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'shgxr_Table\');">重置</a>'+
		 "			<a href='#' class='easyui-linkbutton' iconCls='icon-cancel' onclick='Zdrxs.closeTab(\"社会关系人信息\");'>关闭</a>" +
		 "		</td>" +
		 "  </tr>" +
		 "	</table>" ;
	}else{
		html ="<table class='infoBodyTable' >" +
		"<tr><td class='infoName'>证件类型</td><td class='infoValue' >"+row.zjlx+"</td><td class='infoName' >证件号码</td><td class='infoValue' colspan=2>"+row.zjhm+"</td><td id='shgxr_imgTd' rowspan=6><img></img></td></tr>" +
		"<tr><td class='infoName'>部级重点人员编号</td><td class='infoValue' >"+row.bjzdrybh+"</td><td class='infoName'>省级重点人员编号</td><td class='infoValue'  colspan=2>"+row.sjzdrybh+"</td></tr>" +
		"<tr><td class='infoName'>关系类型</td><td class='infoValue' >"+row.gx+"</td><td class='infoName'>重点人员细类</td><td class='infoValue'  colspan=2>"+row.zdryxl+"</td></tr>" +
		"<tr><td class='infoName'>姓名</td><td class='infoValue' >"+row.xm+"</td><td class='infoName'>性别</td><td class='infoValue'  colspan=2>"+row.xb+"</td></tr>" +
		"<tr><td class='infoName'>名族</td><td class='infoValue' >"+row.mz+"</td><td class='infoName'>国籍</td><td class='infoValue'  colspan=2>"+row.gj+"</td></tr>" +
		"<tr><td class='infoName'>户籍区划</td><td class='infoValue' >"+row.hjqh+"</td><td class='infoName'>户籍地派出所</td><td class='infoValue'  colspan=2>"+row.hjdpcs+" </td></tr>" +
		"<tr><td class='infoName'>户籍地祥址</td><td class='infoValue'  colspan=5>"+row.hjdxz+"</td></tr>" +
		"<tr><td class='infoName'>入库时间</td><td class='infoValue' >"+row.rksj+"</td><td class='infoName'>填报单位名称</td><td class='infoValue' colspan=3>"+row.tbdwmc+"</td></tr>" +
		"<tr><td class='infoName'>曾用名</td><td class='infoValue' >"+row.cym+"</td>" +
		"	 <td class='infoName'>绰号</td><td class='infoValue' >"+row.ch+"</td>" +
		"	 <td class='infoName'>政治面貌</td><td class='infoValue' >"+row.zzmm+" </td></tr>" +
		"<tr><td class='infoName'>宗教信仰</td><td class='infoValue' >"+row.ZJXY+"</td>" +
		"	 <td class='infoName'>出生日期</td><td class='infoValue' >"+row.CSRQ+"</td>" +
		"	 <td class='infoName'>婚姻状况</td><td class='infoValue' >"+row.HYZK+" </td></tr>" +
		"<tr><td class='infoName'>文化程度</td><td class='infoValue' >"+row.whcd+"</td>" +
		"	 <td class='infoName'>身高(cm)</td><td class='infoValue' >"+row.sg+"</td>" +
		"	 <td class='infoName'>体重(KG)</td><td class='infoValue' >"+row.tz+"</td></tr>" +
		"<tr><td class='infoName'>足长(mm)</td><td class='infoValue' >"+row.zc+"</td>" +
		"	 <td class='infoName'>鞋号(mm)</td><td class='infoValue' >"+row.xh+"</td>" +
		"	 <td class='infoName'>口音</td><td class='infoValue' >"+row.ky+" </td></tr>" +
		"<tr><td class='infoName'>特长</td><td class='infoValue' >"+row.tc+"</td>" +
		"	 <td class='infoName'>兴趣爱好</td><td class='infoValue' >"+row.xxah+"</td>" +
		"	 <td class='infoName'>体貌特征</td><td class='infoValue' >"+row.tmtz+" </td></tr>" +
		"<tr><td class='infoName'>DNA</td><td class='infoValue' >"+row.dna+"</td>" +
		"	 <td class='infoName'>血型</td><td class='infoValue' >"+row.xx+"</td>" +
		"	 <td class='infoName'>指纹编号</td><td class='infoValue' >"+row.zwbh+" </td></tr>" +
		"<tr><td class='infoName'>职业</td><td class='infoValue' >"+row.zy+"</td>" +
		"	 <td class='infoName'>实际收入</td><td class='infoValue' >"+row.sjsr+"</td>" +
		"	 <td class='infoName'>经济来源</td><td class='infoValue' >"+row.jjly+" </td></tr>" +
		"<tr><td class='infoName'>特殊标记</td><td class='infoValue' colspan=5 >"+row.tsbj+"</td></tr>" +
		"<tr><td class='infoName'>联系方式</td><td class='infoValue' colspan=5 >"+row.tbdwd+"</td></tr>" +
		"<tr><td class='infoName'>工作单位区划</td><td class='infoValue' >"+row.gzdwqh+"</td>" +
		"	 <td class='infoName'>工作单位</td><td class='infoValue' >"+row.gzdw+" </td></tr>" +
		"<tr><td class='infoName'>工作单位祥址</td><td class='infoValue' colspan=5>"+shgxr_gzdwxz+"</td></tr>" +
		"<tr><td class='infoName'>现住地区划</td><td class='infoValue' >"+row.xzdqh+"</td>" +
		"	 <td class='infoName'>管辖单位</td><td class='infoValue' >"+row.gxdw+"</td></tr>" +
		"<tr><td class='infoName'>现住地祥址</td><td class='infoValue' colspan=5 >"+row.xzdxz+"</td></tr>" +
		"</table>" ;
	}
	return html;
}

/**
 * @method:initShgxrSelectVal
 * @package:syrk/js/qbld	
 * @description:初始化社会关系人字典选项
 * @author:Li_Zhenzhong
 * @date:2015-6-8下午3:50:13
 */
Zdrxs.initShgxrSelectVal = function(){
	$("#shgxr_tmtz_rtbw").combobox({
		url: contextPath + '/common/dict/D_QBLD_RTBW.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#shgxr_tmtz_tsbj").combobox({
		url: contextPath + '/common/dict/D_QBLD_TSBJ.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	
	
	$("#shgxr_zjlx").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZJLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#shgxr_gx").combobox({
		url: contextPath + '/common/dict/D_QBLD_GX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#shgxr_xb").combobox({
		url: contextPath + '/common/dict/D_QBLD_XB.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#shgxr_mz").combobox({
		url: contextPath + '/common/dict/D_BZ_MZ.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});

	$("#shgxr_gj").combotree({
		url:contextPath + '/common/dict/D_BZ_GJDQ.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%'
	})
	$("#shgxr_hjqh").combotree({
		url:contextPath + '/common/dict/D_BZ_XZQH.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%'
	})
	$("#shgxr_gzdwqh").combotree({
		url:contextPath + '/common/dict/D_BZ_XZQH.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%',
		onSelect:function(obj){
			$("#shgxr_gzdwxz").val(obj.text)
		}
		
	})
	$("#shgxr_xzdqh").combotree({
		url:contextPath + '/common/dict/D_BZ_XZQH.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%',
		onSelect:function(obj){
			$("#shgxr_xzdxz").val(obj.text)
		}
	})
	
	$("#shgxr_zzmm").combobox({
		url:contextPath + '/common/dict/D_QBLD_ZZMM.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})
	
	$("#shgxr_hyzk").combobox({
		url:contextPath + '/common/dict/D_QBLD_HYZK.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})

	$("#shgxr_whcd").combobox({
		url:contextPath + '/common/dict/D_QBLD_WHCD.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})
	$("#shgxr_zjxy").combobox({
		url:contextPath + '/common/dict/D_QBLD_ZJXY.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})
	$("#shgxr_ky").combobox({
		url:contextPath + '/common/dict/D_QBLD_KY.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})
	$("#shgxr_tc").combobox({
		url:contextPath + '/common/dict/D_QBLD_ZC.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})
	$("#shgxr_tmtz").combotree({
		url:contextPath + '/common/dict/D_QBLD_TMTZ.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%'
	})
	
	$("#shgxr_zy").combotree({
		url:contextPath + '/common/dict/D_BZ_ZYFLYDM.js',
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		width:'100%'
	})
	$("#shgxr_sjsr").combobox({
		url:contextPath + '/common/dict/D_QBLD_SJSR.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})
	$("#shgxr_jjly").combobox({
		url:contextPath + '/common/dict/D_QBLD_JJLY.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})
	$("#shgxr_xx").combobox({
		url:contextPath + '/common/dict/D_QBLD_XX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	})
}

/**
 * @method:openSaTab
 * @package:syrk/js/qbld	
 * @description:初始化涉案信息窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午5:40:42
 */
Zdrxs.openSaTab = function(){
	$("#opInfoTr").show();
	var html ='<table class="infoBodyTable" id="sa_Table"> '+
	 '	<tr><td class="infoName">案件编号</td><td class="infoValue" id="zdrxsSa_ajbh" ></td><td class="infoName">案件名称</td><td class="infoValue"  id="zdrxsSa_ajmc" ></td></tr>'+
	 '	<tr><td class="infoName">发案时间</td><td class="infoValue" id="zdrxsSa_fasj" ></td><td class="infoName">发案地点</td><td class="infoValue"  id="zdrxsSa_fadd" ></td></tr>'+
	 '	<tr><td class="infoName">简要案情</td><td class="infoValue" colspan=3><textarea id="zdrxsSa_jyaq" maxlength=1500></textarea></td></tr>'+
	 '	</table>'+
	 ' <div style="height:310px;overflow:auto"><div id="saListDiv"></div></div>';
	if($("#otherInfoListDiv").tabs('getTab','涉案信息')==null){
		$("#otherInfoListDiv").tabs('add',{
			id:'sa',
			title:'涉案信息',
			closable:true,
			content:html
		});
		$('#saListDiv').datagrid({
			idField:'xsxxbh',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/querySaxxList",
			queryParams:{"zdry_zjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
		  		    {field:'hssj',title:'案件编号',width:$('#otherInfoListDiv').width()*.24,align:'center'},    
		  		    {field:'hsddxz',title:'案件名称',width:$('#otherInfoListDiv').width()*.50,align:'center'},    
		  		    {field:'sfjdbr',title:'发案时间',width:$('#otherInfoListDiv').width()*.12,align:'center'},
		  		    {field:'zkzt',title:'发案地点',width:$('#otherInfoListDiv').width()*.12,align:'center'}
			    ]],
				onClickRow:function(index,row){
					$("#zdrxsSa_ajbh").html(row.hssj);
					$("#zdrxsSa_hsddxz").html(row.hsddxz);
					$("#zdrxsSa_sfjdbr").html(row.sfjdbr);
					$("#zdrxsSa_zkzt").html(row.zkzt);
					$("#zdrxsSa_jyaq").html(row.jyaq);
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','涉案信息');
	}
};
/**
 * @method:openClxxTab
 * @package:syrk/js/qbld	
 * @description:初始化车辆信息窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午5:40:59
 */
Zdrxs.openClxxTab = function(){
	$("#opInfoTr").show();
	if($("#otherInfoListDiv").tabs('getTab','车辆信息')==null){
		var html ='<table class="infoBodyTable" id="clxx_Table"> '+
		 '	<tr><td class="infoName red">车辆品牌</td><td class="infoValue"><input id="clxx_clpp"  class="notNull" ></td>'+
		 '	 	<td class="infoName red">车辆类型</td><td class="infoValue"><input id="clxx_cllx"  class="notNull" ></td>'+
		 '		<td class="infoName red">车辆颜色</td><td class="infoValue"><input id="clxx_clys"  class="notNull" ></td><tr>'+
		 '	<tr><td class="infoName red">车辆号码</td><td class="infoValue"><input id="clxx_clhm"  class="notNull" ></td>'+
		 '	 	<td class="infoName red">车辆来源</td><td class="infoValue"><input id="clxx_clly"  class="notNull" ></td>'+
		 '		<td class="infoName red">归属人</td><td class="infoValue"><input id="clxx_gsr"  class="notNull" ></td><tr>'+
		 '	<tr  align="center">'+
		 '		<td colspan=6>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveZdryOtherInfo(\'clxx_Table\',\'clxx_\',\'/zdry/saveClxxb\');">添加</a>'+//TODO
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="Zdrxs.reset(\'clxx_Table\');">重置</a>'+
		 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'车辆信息\');">关闭</a>'+
		 '		</td>'+
		 '  </tr>'+
		 '	</table>'+
		 ' <div style="height:310px;overflow:auto"><div id="clxxListDiv"></div></div>';
		$("#otherInfoListDiv").tabs('add',{
			id:'clxx',
			title:'车辆信息',
			closable:true,
			content:html
		});
		$("#clxx_cllx").combobox({
			url: contextPath + '/common/dict/D_QBLD_CLLX.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#clxx_clys").combobox({
			url: contextPath + '/common/dict/D_QBLD_YSDM.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$("#clxx_clys").combobox({
			url: contextPath + '/common/dict/D_QBLD_YSDM.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:'100%'
		});
		$('#clxxListDiv').datagrid({
			idField:'id',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/zdry/queryClxxList",
			queryParams:{"zjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
						{field:'clpp',title:'车辆品牌',width:$("#otherInfoListDiv").width()*.19},    
						{field:'cllx',title:'车辆类型',width:$("#otherInfoListDiv").width()*.19},    
						{field:'clys',title:'车辆颜色',width:$("#otherInfoListDiv").width()*.19}, 
						{field:'clhm',title:'车辆号码',width:$("#otherInfoListDiv").width()*.19},  
						{field:'gsr',title:'归属人',width:$("#otherInfoListDiv").width()*.19}    
			    ]],
				onClickRow:function(index,row){
					$("#clxx_clpp").html(row.clpp);
					$("#clxx_cllx").html(row.cllx);
					$("#clxx_clys").html(row.clys);
					$("#clxx_clhm").html(row.clhm);
					$("#clxx_clly").html(row.clly);
					$("#clxx_gsr").html(row.gsr);
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','车辆信息');
	}
}
/**
 * @method:initGxbgTab
 * @package:syrk/js/qbld	
 * @description:初始化管辖变更窗口
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午3:27:02
 */
Zdrxs.initGxbgTab = function(){
	$("#opInfoTr").show();
	if($("#otherInfoListDiv").tabs('getTab','管辖变更')==null){
	var html ='<table class="infoBodyTable" id="gxbg_Table"> '+
	 '	<tr><td class="infoName red">创建人</td><td class="infoValue" style="width:70%"><input id="gxbg_cjr"  style="display:none"  class="notNull" ><input id="gxbg_cjrxm"   class="notNull"  onclick="public_singleSelectOrgUser(\''+userOrgCode+'\', \'\', \'\', \'03,04\', \'\', \'\', \'gxbg_cjr\',\'zdrxs_cjrxm\', \'\', \'\', \'\', \'\', false, \'\', window, \'\', \'\')"></tr>'+
	 '	<tr><td class="infoName red">户籍地派出所</td><td class="infoValue" style="width:70%"><input id="gxbg_hjpcs"  style="display:none"   class="notNull" ><input id="gxbg_hjpcsmc" class="notNull" onClick="public_singleSelectOrg(\''+userOrgCode+'\', \'01\', \'32\', \'\', \'gxbg_hjpcs\', \'gxbg_hjpcsmc\', \'\', false, false, \'\', window, \'\', \'\')"></td></tr>'+
	 '	<tr><td class="infoName red">管辖派出所</td><td class="infoValue" style="width:70%"><input id="gxbg_gxpcs"  style="display:none"   class="notNull" ><input id="gxbg_gxpcsmc" class="notNull"  onClick="public_singleSelectOrg(\''+userOrgCode+'\', \'01\', \'32\', \'\', \'gxbg_gxpcs\', \'gxbg_gxpcsmc\', \'\', false, false, \'\', window, \'\', \'\')"></td></tr>'+
	 '	<tr  align="center">'+
	 '		<td colspan=2>'+
	 '			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="Zdrxs.saveGxbgInfo();">变更</a>'+
	 '			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="Zdrxs.closeTab(\'管辖变更\');">关闭</a>'+
	 '		</td>'+
	 ' </tr>'+
	 '	</table>';
	 $("#otherInfoListDiv").tabs('add',{
		    id:'gxbg',
			title:'管辖变更',
			closable:true,
			content:html
	 });
	 Zdrxs.initXsSelectVal();
	}else{
		$("#otherInfoListDiv").tabs('select','管辖变更');
	}
	var url=contextPath+'/zdry/queryGxbgList';
	var fajax = new FrameTools.Ajax(url,function(rsJson){
		var obj = rsJson.rows[0];
		$("#gxbg_cjr").val(obj.cjr);
		$("#gxbg_cjrxm").val(obj.cjrxm);
		$("#gxbg_hjpcs").val(obj.hjpcs);
		$("#gxbg_hjpcsmc").val(obj.hjpcsmc);
		$("#gxbg_gxpcs").val(obj.gxpcs);
		$("#gxbg_gxpcsmc").val(obj.gxpcsmc);
	});
	fajax.send({"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh});
}
/**
 * @method:saveGxbgInfo
 * @package:syrk/js/qbld	
 * @description:管辖变更
 * @author:Li_Zhenzhong
 * @date:2015-6-11上午10:44:10
 */
Zdrxs.saveGxbgInfo = function(){
	var url=contextPath+'/zdry/updateGxbg';
		if($("#gxbg_cjr").val()==""||$("#gxbg_hjpcs").val()==""||$("#gxbg_hjpcs").val()==""){
			alert("红色标题信息必须填写！");
			return;
		}
		 param = {
			"cjr":$("gxbg_cjr").val(),
			"hjpcs":$("gxbg_hjpcs").val(),
			"gxpcs":$("gxbg_gxpcs").val(),
			"zdryzjhm":Zdrxs.zdryXsInfoObj.sfzh
			}
	var fajax = new FrameTools.Ajax(url,Zdrxs.saveGxbgInfo_back);
	fajax.send(param);
}
/**
 * @method:saveGxbgInfo_back
 * @package:syrk/js/qbld	
 * @description:管辖变更结果显示
 * @param rsJson
 * @author:Li_Zhenzhong
 * @date:2015-6-11上午10:44:26
 */
Zdrxs.saveGxbgInfo_back = function(rsJson){
	if(rsJson.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"变更提交成功",
			time:3000,
			showType:'slide'
		})
	}else{
		alert("提交失败")
	}
}
/**
 * @method:closeTab
 * @package:syrk/js/qbld	
 * @description:关闭信息标签
 * @param title
 * @author:Li_Zhenzhong
 * @date:2015-5-29下午5:47:52
 */
Zdrxs.closeTab = function(title){
	$("#otherInfoListDiv").tabs("close",title);
	if($("#otherInfoListDiv").tabs("tabs").length<1){
		$("#opInfoTr").hide();
	}
}


Zdrxs.saveZdryOtherInfo = function(tableName,valName,url){
	var inputObjs = $(".infoBodyTable .notNull ")
	var num = inputObjs.length
	for(var i = 0;i<num;i++){
		if($(inputObjs[i]).val()==""){
			alert("红色标题信息必须填写！");
			return;
		}
	}
	var param;
	/**
	 * 获取表单内容,并拼成JSON对象
	 */
	var inputObjs = $("#"+tableName+" input")
	var length = inputObjs.length;
	var param = "({";
	for(var i = 0; i < length ; i++){
		var obj = inputObjs[i];
		if(obj.id&&obj.id.indexOf(valName)!=-1&&$(obj).val()!=""){
			param +="'"+obj.id.replace(valName,"")+"':'"+ $(obj).val()+"',";
		}
	}
	var textObjs = $("#"+tableName+" textarea")
	length = textObjs.length;
	for(var i = 0; i < length ; i++){
		var obj = textObjs[i];
		if(obj.id.indexOf(valName)!=-1&&$(obj).val()!="")
			param +="'"+obj.id.replace(valName,"")+"':'"+ $(obj).val()+"',";
	}
	var zdName = "";
	switch(tableName){
	case "clxx_Table": zdName = "zjhm";break;
	case "xs_Table": zdName = "zdry_zjhm";break;
	case "zt_Table": zdName = "zdryzjhm";break;
	case "sw_Table": zdName = "zdryzjhm";break;
	case "sf_Table": zdName = "zdryzjhm";break;
	case "sdxd_Table": zdName = "zdryzjhm";break;
	case "sdzd_Table": zdName = "zdryzjhm";break;
	case "sdfd_Table": zdName = "zdryzjhm";break;
	case "zszhjsbXs_Table": zdName = "zdryzjhm";break;
	case "shgxr_Table": zdName = "zdry_zjhm";break;
	default:break;
	}
	param+="'"+zdName+"':'"+Zdrxs.zdryXsInfoObj.sfzh+"'})";
	param = eval(param);
	var url = contextPath+url;
	var fajax = new FrameTools.Ajax(url,Zdrxs.saveZdryOtherInfo_back);
	fajax.send(param);
}

/**
 * @method:saveXsInfo_back
 * @package:syrk/js/qbld	
 * @description:写实返回信息
 * @param rsJson
 * @author:Li_Zhenzhong
 * @date:2015-6-2下午2:29:26
 */
Zdrxs.saveZdryOtherInfo_back = function(rsJson){
	if(rsJson.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"信息提交成功",
			time:3000,
			showType:'slide'
		})
		var tab = $('#otherInfoListDiv').tabs('getSelected');
		tableName = tab.panel('options').id;
		Zdrxs.reset(tableName+"_Table")
		$("#"+tableName+"ListDiv").datagrid("reload");
	}else{
		alert("写实提交失败")
	}
};

/**
 * @method:showZdrxsLsList
 * @package:syrk/js/qbld	
 * @description:历史写实记录
 * @author:Li_Zhenzhong
 * @date:2015-6-2下午5:05:46
 */
Zdrxs.showZdrxsLsList = function(){
	$("#opInfoTr").show();
	if($("#otherInfoListDiv").tabs('getTab','历史写实')==null){
		$("#otherInfoListDiv").tabs('add',{
			title:'历史写实',
			closable:true,
			content:'<div id="xsListDiv"></div>'
		});
		$('#xsListDiv').datagrid({
			idField:'xsxxbh',
			fit:true,
			fitColumns : true,
			pagination : true,
			singleSelect : true,
			showFooter:true,
			striped:true,
			rownumbers:true,
			url:contextPath+"/ryxs/queryRyxsList",
			queryParams:{"zdry_zjhm":Zdrxs.zdryXsInfoObj.sfzh},
			pageSize:10,
			columns:[[
		  		    {field:'hssj',title:'核实时间',width:$('#otherInfoListDiv').width()*.24,align:'center'},    
		  		    {field:'hsddxz',title:'核实地点',width:$('#otherInfoListDiv').width()*.50,align:'center'},    
		  		    {field:'sfjdbr',title:'是否见到本人',width:$('#otherInfoListDiv').width()*.12,align:'center',
		  		    	formatter:function(value,rec){return value==0?"是":"否"}},
		  		    {field:'zkzt',title:'在控状态',width:$('#otherInfoListDiv').width()*.12,align:'center',
		  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYZK.js', value)}}
			    ]],
				onClickRow:function(index,row){
					Zdrxs.showMoreXsInfo(row);
			}
		});
	}else{
		$("#otherInfoListDiv").tabs('select','历史写实');
	}
}
/**
 * @method:showMoreXsInfo
 * @package:syrk/js/qbld	
 * @description:显示历史详细信息
 * @param obj
 * @author:Li_Zhenzhong
 * @date:2015-6-2下午5:42:13
 */
Zdrxs.showMoreXsInfo = function(obj){
	/**
	 * 判断是否已打开历史写实信息标签，如果已打开则替换内容，否则新建标签
	 */
	if($("#otherInfoListDiv").tabs('getTab','历史写实信息')!=null){
		$("#otherInfoListDiv").tabs('select','历史写实信息');
		var html ='<table class="infoBodyTable" > '+
		 '	<tr><td class="infoName red">核实时间</td><td class="infoValue" >'+obj.hssj+'</td><td class="infoName red">核实地点区划</td><td class="infoValue">'+obj.hsddqh+'</td></tr>'+
		 '	<tr><td class="infoName red">核实地点名称</td><td class="infoValue">'+obj.hsddmc+'</td><td class="infoName red">核实地点详址</td><td class="infoValue">'+obj.hsddxz+'></td></tr>'+
		 '	<tr><td class="infoName red">在控状态</td><td class="infoValue">'+obj.zkzt+'</td><td class="infoName red">在籍状态</td><td class="infoValue">'+obj.zjzt+'</td></tr>'+
		 '	<tr><td class="infoName">离开时间</td><td class="infoValue">'+obj.lksj+'</td><td class="infoName">去往省市</td><td class="infoValue">'+obj.qwss+'</td></tr>'+
		 '	<tr><td class="infoName red">危险级别（提示）</td><td class="infoValue">'+obj.wxjb+'</td><td class="infoName">主要意向</td><td class="infoValue" >'+obj.zyyx+'</td></tr>'+
		 '	<tr><td class="infoName">职业</td><td class="infoValue">'+obj.zy+'</td><td class="infoName">实际收入</td><td class="infoValue">'+obj.sjsr+'</td></tr>'+
		 '	<tr><td class="infoName">经济来源</td><td class="infoValue">'+obj.jjly+'</td><td class="infoName">联系方式</td><td class="infoValue">'+obj.lxfs+'</td></tr>'+
		 '	<tr><td class="infoName">工作单位</td><td class="infoValue">'+obj.gzdw+'</td><td class="infoName">工作单位详址</td><td class="infoValue">'+obj.gzdwxz+'</td></tr>'+
		 '	<tr><td class="infoName">现住地区划</td><td class="infoValue"'+obj.jzdqh+'</td><td class="infoName">现住地详址</td><td class="infoValue">'+obj.jzdxz+'</td></tr>'+
		 '	<tr><td class="infoName">管辖单位</td><td class="infoValue">'+obj.gxdwmc+'</td><td class="infoName  red">是否见到本人</td><td class="infoValue">'+obj.sfjdbr+'</td></tr>'+
		 '	<tr><td class="infoName">核实情况描述（提示）</td><td class="infoValue" colspan=3>'+obj.hsqkms+'</td></tr>'+
		 '	</table>';
		$("#otherInfoListDiv").tabs('update',{
			tab:$("#otherInfoListDiv").tabs('getTab','历史写实信息'),
			options: {
				title: '历史写实信息',
				content: html  
			}
		});
	}else{
		var html ='<table class="infoBodyTable" > '+
		 '	<tr><td class="infoName red">核实时间</td><td class="infoValue" >'+obj.hssj+'</td><td class="infoName red">核实地点区划</td><td class="infoValue">'+obj.hsddqh+'</td></tr>'+
		 '	<tr><td class="infoName red">核实地点名称</td><td class="infoValue">'+obj.hsddmc+'</td><td class="infoName red">核实地点详址</td><td class="infoValue">'+obj.hsddxz+'></td></tr>'+
		 '	<tr><td class="infoName red">在控状态</td><td class="infoValue">'+obj.zkzt+'</td><td class="infoName red">在籍状态</td><td class="infoValue">'+obj.zjzt+'</td></tr>'+
		 '	<tr><td class="infoName">离开时间</td><td class="infoValue">'+obj.lksj+'</td><td class="infoName">去往省市</td><td class="infoValue">'+obj.qwss+'</td></tr>'+
		 '	<tr><td class="infoName red">危险级别（提示）</td><td class="infoValue">'+obj.wxjb+'</td><td class="infoName">主要意向</td><td class="infoValue" >'+obj.zyyx+'</td></tr>'+
		 '	<tr><td class="infoName">职业</td><td class="infoValue">'+obj.zy+'</td><td class="infoName">实际收入</td><td class="infoValue">'+obj.sjsr+'</td></tr>'+
		 '	<tr><td class="infoName">经济来源</td><td class="infoValue">'+obj.jjly+'</td><td class="infoName">联系方式</td><td class="infoValue">'+obj.lxfs+'</td></tr>'+
		 '	<tr><td class="infoName">工作单位</td><td class="infoValue">'+obj.gzdw+'</td><td class="infoName">工作单位详址</td><td class="infoValue">'+obj.gzdwxz+'</td></tr>'+
		 '	<tr><td class="infoName">现住地区划</td><td class="infoValue"'+obj.jzdqh+'</td><td class="infoName">现住地详址</td><td class="infoValue">'+obj.jzdxz+'</td></tr>'+
		 '	<tr><td class="infoName">管辖单位</td><td class="infoValue">'+obj.gxdw+'</td><td class="infoName  red">是否见到本人</td><td class="infoValue">'+obj.sfjdbr+'</td></tr>'+
		 '	<tr><td class="infoName">核实情况描述（提示）</td><td class="infoValue" colspan=3>'+obj.xsqkms+'</td></tr>'+
		 '	</table>';
		$("#otherInfoListDiv").tabs('add',{
			title:'历史写实信息',
			content:html
		});
	}
	
}
/**
 * @method:reset
 * @package:syrk/js/qbld	
 * @description:表单重置
 * @param tableName
 * @author:Li_Zhenzhong
 * @date:2015-6-9上午11:13:14
 */
Zdrxs.reset = function(tableName){
	var inputObjs = $("#"+tableName+" input")
	var length = inputObjs.length;
	for(var i = 0; i < length ; i++){
		$(inputObjs[i]).val("")
	}
	var textObjs = $("#"+tableName+" textarea")
	length = textObjs.length;
	for(var i = 0; i < length ; i++){
		$(textObjs[i]).val("")
	}
	switch(tableName){
	case 'zszhjsbXs_Table':  $("#zszhjsbXs_xxbh").val((new Date()).getTime());break;
	case 'zszhjsbZdjl_Table':  $("#zszhjsbZdjl_xxbh").val($("#zszhjsbXs_xxbh").val());break;
	case 'zszhjsbZszhjl_Table':  $("#zszhjsbZszhjl_xxbh").val($("#zszhjsbXs_xxbh").val());break;
	default:break;
	}
	
	
}
/**
 * @method:showInfo
 * @package:syrk/js/qbld	
 * @description:显示记录信息
 * @param row
 * @param type
 * @author:Li_Zhenzhong
 * @date:2015-6-9上午11:22:27
 */
Zdrxs.showInfo = function(row,type){
	for(key in row){
		var val = row[key];
		if(val!=""&&val!=null){
			if($("#"+type+key).attr("class")!=null&&$("#"+type+key).attr("class").indexOf("combobox")!=-1){
				$("#"+type+key).combobox("setValue",val);
			}else if($("#"+type+key).attr("class")!=null&&$("#"+type+key).attr("class").indexOf("combotree")!=-1){
				$("#"+type+key).combotree("setValue",val);
			}else if($("#"+type+key).attr("onclick")!=null&&$("#"+type+key).attr("onclick").indexOf("WdatePicker")!=-1){
				val = val.substring(0,4)+"/"+val.substring(4,6)+"/"+val.substring(6,8)+" "+val.substring(8,10)+":"+val.substring(10,12)+":"+val.substring(12,14) ;
				$("#"+type+key).val(val);
			}else{
				$("#"+type+key).val(val);
			}
		}else{
			if($("#"+type+key).attr("class")!=null&&$("#"+type+key).attr("class").indexOf("combobox")!=-1){
				$("#"+type+key).combobox("setValue","");
			}else if($("#"+type+key).attr("class")!=null&&$("#"+type+key).attr("class").indexOf("combotree")!=-1){
				$("#"+type+key).combotree("setValue","");
			}else
				$("#"+type+key).val("");
		}
	}
}