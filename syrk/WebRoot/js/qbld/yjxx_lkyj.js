if(typeof Yjxx =="undefined" || !Yjxx){
	Yjxx = {};
}
/**
 * @title:initLkyjQueryHtml
 * @description:初始化价值临控控预警级别选择框
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:05
 */
Yjxx.initLkyjQueryHtml = function(type){
	Yjxx.type = type;
	var jbhtml = "<input type='checkbox' name='zljb' value='1' onclick='Yjxx.queryLkyjList();'  checked/>一级"+
	"<input type='checkbox' name='zljb' value='2' onclick='Yjxx.queryLkyjList();' checked/>二级"+
	"<input type='checkbox' name='zljb' value='3' onclick='Yjxx.queryLkyjList();'' checked/>三级"
	$(".yjjbCheckBox").html(jbhtml);
	Yjxx.initLkyjSimpleQuery();
}
/**
 * @title:initLkyjSimpleQuery
 * @description:初始化加载临控预警级别简单查询
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:36
 */
Yjxx.initLkyjSimpleQuery = function(){
	var queryhtml  = '<div id="simpleQuery">'+
			'<div><input id="where_all"/></div>'+
			'<div><a href="#" id="simpleQueryButton" onclick="Yjxx.queryLkyjList();">查询</a>'+
			'<a href="#" id="toggleButton" onclick="Yjxx.initLkyjAdvancedQuery()"  >精确查询</a></div>'+
			'</div>';
	$("#queryDiv").html(queryhtml);
	$("#simpleQueryButton").linkbutton({
			iconCls:"icon-search"
	} ) 
	$("#toggleButton").linkbutton({
		plain:true
	} ) 
	$(window).resize();
	Yjxx.queryLkyjList();
}
/**
 * @title:initLkyjAdvancedQuery
 * @description:初始化加载临控预警级别简单查询
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:56
 */
Yjxx.initLkyjAdvancedQuery = function(){
	var queryhtml = '<div id="advancedQuery">'+
	'<table border=0>'+
	'<tr><td colspan=2 class="queryType"><a href="#" class="easyui-linkbutton" id="toggleButton" onclick="Yjxx.initLkyjSimpleQuery()" >模糊查询</a></td></tr>'+
	'<tr><td class="whereName">指令类型</td><td><input class="whereInput" id="where_lkzllx"></td></tr>'+
	'<tr><td class="whereName">申请单位</td><td><input id="where_sqdwjgdm" style="display:none"><input class="whereInput" id="where_sqdwjg" onclick="public_singleSelectOrg(\'\', \'01\', \'\', \'03,04\', \'where_sqdwjgdm\', \'where_sqdwjg\', \'\', false, false, \'\', window, \'\', \'\')"></td></tr>'+
	'<tr><td class="whereName">指令发布时间</td><td><input class="whereInput" id="where_zlfbsjB" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" >-'+
	'	<input class="whereInput" id="where_zlfbsjE" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})"></td></tr>'+
	'<tr><td colspan=2 class="queryButton"><a href="#" id="advancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.queryLkyjList();" >查询</a>'+
	'										<a href="#" id="clearAdvancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.clearLkyjAdvancedQueryValue();" >重置</a></td></tr>'+
	'</table></div>';
	$("#queryDiv").html(queryhtml);
	$("#advancedQueryButton").linkbutton({
		iconCls:"icon-search"
	} ) 
	$("#clearAdvancedQueryButton").linkbutton({
		iconCls:"icon-reload"
	} ) 
	$("#toggleButton").linkbutton({
		plain:true
	} ) 
	$("#where_lkzllx").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYLSBKZLLX.js',
		dataFilter:'.{2}',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'200'
	})
	
	$(window).resize();
}

/**
 * @method:clearLkyjAdvancedQueryValue
 * @package:syrk/js/qbld	
 * @description:清空高级查询条件
 * @author:Li_Zhenzhong
 * @date:2015-5-15上午10:40:28
 */
Yjxx.clearLkyjAdvancedQueryValue = function(){
	$("#where_sqdwjgdm").val("");
	$("#where_sqdwjg").val("");
	$("#where_lkzllx").combobox("setValue","");
	$("#where_zlfbsjB").val("");
	$("#where_zlfbsjE").val("");
}
/**
 * @method:queryLkyjList
 * @package:syrk/js/qbld
 * @description:临控预警查询
 * @author:li_zhenzhong
 * @param total 总数
 * @param begin 开始记录序号
 * @param end 结束记录序号
 * @param page 当前页数
 * @date:2015-5-8下午5:10:06
 */
Yjxx.queryLkyjList = function(total,begin,end,page){
	var checkObj = $(":checkBox");
	var num = checkObj.length
	var yjjb = ""; 
	for(var i = 0;i<num;i++){
		if(checkObj[i].checked)
		yjjb+=checkObj[i].value+",";
	}
	var param = "";
	if(document.getElementById("where_all")){
		var value = $("#where_all").val();
		var reg = new RegExp("^[0-9a-zA-Z]*$");
		var xm ="";
		var sfzh = "";
		if(reg.test(value)){
			sfzh = value
		}else{
			xm = value;
		}
		param = {"zljsdw":userOrgCode,
				"lkzljb":yjjb.substring(0, yjjb.length-1),
				"qsfkzt":Yjxx.type,
				"bbkrxm":xm,
				"bbkrzjhm":sfzh,
				"total":total,
				"rownum":10,
				"begin":begin,
				"end":end,
				"page":page}
	 }else{
		 param = {"zljsdw":userOrgCode,
					"lkzljb":yjjb.substring(0, yjjb.length-1),
					"qsfkzt":Yjxx.type,
					"sqdwjgdm":$("#where_sqdwjgdm").val(),
					"zlfbsjB":$("#where_zlfbsjB").val(),
					"zlfbsjE":$("#where_zlfbsjE").val(),
					"total":total,
					"rownum":10,
					"begin":begin,
					"end":end,
					"page":page}
	 }
	var url = contextPath+'/lkyj/queryLkyjList';
	var fajax = new FrameTools.Ajax(url,Yjxx.queryLkyjList_back);
	fajax.send(param);
};

/**
 * @method:queryLkyjList_back
 * @package:syrk/js/qbld	
 * @description:解析临空预警结果，并显示列表
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午5:35:05
 */
Yjxx.queryLkyjList_back = function(json){
	var  rsHtml = "<table class='listTable'>";
		rsHtml+="<tr class='countInfo'>" +
		"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>条预警信息</td>"+
		"</tr>";
	var rows = json.rows;
		num = rows.length
		for(var  i = 0;i<num;i++){
			var row = rows[i];
		rsHtml+="<tr class='infoOne_tr' onclick='Yjxx.clickListToChangeColor(this);Yjxx.initOtherDivShow();Yjxx.queryOneLkyjInfo(\""+row.lkzlbh+"\")'>";
		/**
	     * 显示预警信息颜色级别
	     */
		switch(parseInt(row.lkzljb)){//根据级别显示不同颜色
			case 1: rsHtml += "<td class='color1'></td>";break;
			case 2: rsHtml += "<td class='color2'></td>";break;
			case 4: rsHtml += "<td class='color3'></td>";break;
			case 5: rsHtml += "<td class='color4'></td>";break;
			default:rsHtml += "<td class='color0'></td>";break;
		}
		rsHtml+= "<td class='infoBody' onclick=''>"+"姓名:"+ row.bbkrxm+"  <br> " +
						"身份证号:"+ row.bbkrzjhm+"<br>" +
						"发布时间:"+row.zlfbsj+"</div<td>";
		/**
		 * 显示预警信息签收反馈状态
		 */
		switch(parseInt(row.qsfkzt)){//row.b_state
			case 0: rsHtml += "<td class='infoState'>待签收<br>"+Yjxx.countTime(row.qssx)+"</td>";break;
			case 1: rsHtml += "<td class='infoState'>待反馈<br>"+Yjxx.countTime(row.scczfksx)+"</td>";break;
			case 2: rsHtml += "<td class='infoState'>已反馈</td>";break;
			default:rsHtml += "<td class='infoState'>本条数据状态错误</td>";break;
		}
		"</tr>" ;
		}
		rsHtml += "<tr class='fyTr'><td colspan=4 >"+Yjxx.showfy(json.total,json.rownum,json.page,"Yjxx.queryCkyjList")+"</td></tr>";
		rsHtml+="</table>";
	$("#InfoList").html(rsHtml);
	Yjxx.initChangeListColor();
};

/**
 * @method:queryOneLkyjInfo
 * @package:syrk/js/qbld	
 * @description:查询临控预警详情
 * @param lkzlbh
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午5:42:54
 */
Yjxx.queryOneLkyjInfo = function(lkzlbh){
	Yjxx.indexInfoObj = null;
	var url = contextPath+'/lkyj/queryLkyj';
	var fajax = new FrameTools.Ajax(url,Yjxx.showOneLkyjInfo);
	fajax.send({"lkzlbh":lkzlbh});
}

/**
 * @method:showOneLkyjInfo
 * @package:syrk/js/qbld	
 * @description:显示临控预警详情
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午5:44:34
 */
Yjxx.showOneLkyjInfo = function(json){
	if(json==null)
		json = Yjxx.indexInfoObj;
	if(Yjxx.indexInfoObj==null)
		Yjxx.indexInfoObj = json;
	else if(Yjxx.indexInfoObj != json ){
		$("#backButtonTd").html("<a href='#' id='backButton' onclick='Yjxx.showOneLkyjInfo()' >返回</a>");
	}else{
		$("#backButtonTd").html("");
	}
	$("#infoTitle").html("姓名："+json.bbkrxm);
	$("#opButtonTd").html("<a href='#' id='qsfkButton'></a>")
	$("#oneInfoDiv").height($(".infoTr").height()-5);
	$("#oneInfoDiv").html(Yjxx.buildLkyjInfoHtml(json));
	
    if(Yjxx.indexInfoObj == json ){
 	   	if(json.qsfkzt!=0){
	 	   	$("#qsfkButton").linkbutton({
				text:'反馈'
			} );
	    	$("#qsfkButton").click(Yjxx.showLkyjFkFrom);
 	   	}else{
	   		$("#qsfkButton").linkbutton({
				text:'签收'
			} );
	    	$("#qsfkButton").click(function(){Yjxx.lkyjQs();})
   		}
    }
}
/**
 * @method:buildLkyjInfoHtml
 * @package:syrk/js/qbld	
 * @description:创建临控预警详细信息
 * @param json
 * @returns {String}
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午5:49:43
 */
Yjxx.buildLkyjInfoHtml = function(json){
	var  html = "<table class='infoOneTable'>" +
			"<tr><td class='infoTypeTd'>被<br>布<br>控<br>人</td>" +
			"	<td>" +
			"		<table class='infoBodyTable'>" +
			"			<tr><td class='infoName'>性别</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXBDM.js', json.bbkrxb)+"</td><td class='infoName'>出生日期</td><td class='infoValue'>"+json.bbkrcsrq+"</td><td id='imgTd' rowspan=6><img style='width:150px;height:185px;' src='"+contextPath + "/ckyj/queryQbldZpSingle.jpg?sfzh="+json.bbkrzjhm + "'></img></td></tr>" +
			"			<tr><td class='infoName'>证件类型</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYZJLX.js', json.bbkrzjlx)+"</td><td class='infoName'>证件号码</td><td class='infoValue'> "+json.bbkrzjhm+"</td></tr>" +
			"			<tr><td class='infoName'>临控指令编号</td><td class='infoValue' colspan=3>"+json.lkzlbh+"</td></tr>" +
			"			<tr><td class='infoName'>临控指令类型</td><td class='infoValue' colspan=3>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYLSBKZLLX.js', json.lkzllx)+"</td></tr>" +
			"			<tr><td class='infoName'>指令接收单位</td><td class='infoValue' colspan=3>"+json.zljsdw+"</td></tr>" +
			"			<tr><td class='infoName'>指令发布时间</td><td class='infoValue' colspan=3>"+json.zlfbsj.substring(0,4)+"/"+json.zlfbsj.substring(4,6)+"/"+json.zlfbsj.substring(6,8)+" "+json.zlfbsj.substring(8,10)+":"+json.zlfbsj.substring(10,12)+":"+json.zlfbsj.substring(12,14)+"</td></tr>" +
			"			<tr><td class='infoName'>签收时限</td><td class='infoValue'>"+json.qssx.substring(0,4)+"/"+json.qssx.substring(4,6)+"/"+json.qssx.substring(6,8)+" "+json.qssx.substring(8,10)+":"+json.qssx.substring(10,12)+":"+json.qssx.substring(12,14)+"</td>" +
					"		<td class='infoName'>首次处置反馈时限</td><td class='infoValue' colspan=2>"+json.scczfksx.substring(0,4)+"/"+json.scczfksx.substring(4,6)+"/"+json.scczfksx.substring(6,8)+" "+json.scczfksx.substring(8,10)+":"+json.scczfksx.substring(10,12)+":"+json.scczfksx.substring(12,14)+"</td></tr>" +
			"			<tr><td class='infoName'>申请人姓名</td><td class='infoValue'>"+json.sqrxm+"</td><td class='infoName'>申请人公民身份号码</td><td class='infoValue' colspan=2>"+json.sqrsfzh+"</td></tr>" +
			"			<tr><td class='infoName'>申请人电话</td><td class='infoValue'>"+json.sqrlxdh+"</td><td class='infoName'>申请单位</td><td class='infoValue' colspan=2>"+json.sqdw+"</td></tr>" +
			"			<tr><td class='infoName'>发布人姓名</td><td class='infoValue'>"+json.fbrxm+"</td><td class='infoName'>发布责任单位</td><td class='infoValue' colspan=2>"+json.fbzrdw+"</td></tr>" +
			"			<tr><td class='infoName'>处置措施</td><td class='infoValue' colspan=4>"+json.czcsyq+"</td></tr>" +
			"			<tr><td class='infoName'>执法依据</td><td class='infoValue' colspan=4>"+json.zfyj+"</td></tr>" +
			"		</table>" +
			"	</td>" +
			"</tr>"+
			"<tr><td class='infoTypeTd'>活<br>动<br>信<br>息</td>" +
			"	<td>" +
			"		<table class='infoBodyTable'>" +
			"			<tr><td class='infoName'>登记姓名</td><td class='infoValue'>"+json.djxm+"</td><td id='mapTd' colspan=2 rowspan=8><iframe id='mapDiv' src='qbld|map'></iframe></td></tr>" +
			"			<tr><td class='infoName'>登记性别</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXBDM.js', json.djxb)+"</td></tr>" +
			"			<tr><td class='infoName'>登记证件号码</td><td class='infoValue'>"+json.djzjhm+"</td></tr>" +
			"			<tr><td class='infoName'>登记出生日期</td><td class='infoValue'>"+json.djcsrq+"</td></tr>" +
			"			<tr><td class='infoName'>预警指令级别</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYLKZLJB.js', json.lkzljb)+"</td></tr>" +
			"			<tr><td class='infoName'>活动发生时间</td><td class='infoValue'>"+json.hdfssj.substring(0,4)+"/"+json.hdfssj.substring(4,6)+"/"+json.hdfssj.substring(6,8)+" "+json.hdfssj.substring(8,10)+":"+json.hdfssj.substring(10,12)+":"+json.hdfssj.substring(12,14)+"</td></tr>" +
			"			<tr><td class='infoName'>活动发生地社会场所</td><td class='infoValue' ><a href='#' onclick='Yjxx.openMapWindow(\""+json.zbx+"\",\""+json.zby+"\");'>"+json.hdfsddssshcsdm+"</a></td></tr>" +
			"			<tr><td class='infoName'>活动发生地祥址</td><td class='infoValue'>"+json.hdfsddxz+"</td></tr>" +
			"			<tr><td class='infoName'>发生地公安机关</td><td class='infoValue'>"+json.hdfsddssgajg+"</td><td class='infoName'>动态信息提供单位</td><td class='infoValue'>"+json.dtxxtgdw+"</td></tr>" +
			"			<tr><td class='infoName'>信息比对时间</td><td class='infoValue'>"+json.xxbdsj+"</td><td class='infoName'>信息比对单位</td><td class='infoValue'>"+json.xxbddw+"</td></tr>" +
			"			<tr><td class='infoName'>活动相关信息</td><td class='infoValue' colspan=3>"+json.hdxgxx+"</td></tr>" +
			"			<tr><td class='infoName'>签收人</td><td class='infoValue'>需要关联签收表</td><td class='infoName'>签收时间</td><td class='infoValue'>需要关联签收表</td></tr>" +
			"			<tr><td class='infoName'>签收单位</td><td class='infoValue' colspan=3>需要关联签收表</td></tr>" +
			"		</table>" +
			"	</td>" +
			"</tr>"+
			"</table>";
	return html;
};

/**
 * @method:lkyjQs
 * @package:syrk/js/qbld	
 * @description:临控预警签收
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午6:40:31
 */
Yjxx.lkyjQs = function(){
	var url = contextPath+'/lkyj/updateLkyjxxbAndSaveQsb';
	var fajax = new FrameTools.Ajax(url,Yjxx.lkyjQs_back);
	fajax.send({"lkzlbh":Yjxx.indexInfoObj.lkzlbh});
};
/**
 * @method:lkyjQs_back
 * @package:syrk/js/qbld	
 * @description:签收成功后改变为待反馈状态
 * @param qsRs
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午6:42:07
 */
Yjxx.lkyjQs_back = function(qsRs){
	if(qsRs.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"签收成功",
			time:3000,
			showType:'slide'
		})
		$("#qsfkButton").unbind("click");
		$("#qsfkButton").linkbutton({text:"反馈"});
		$("#qsfkButton").click(Yjxx.showLkyjFkFrom);
		Yjxx.QueryDyjCount();
	}
}
/**
 * @title:showCkyjFkFrom
 * @description:显示反馈表单
 * @author:li_zhenzhong
 * @date:2015-4-29下午4:44:23
 */
Yjxx.showLkyjFkFrom = function(){
	Yjxx.changeOtherDivShow();
	$("#otherInfoDiv").html("<div id='otherInfoListDiv'></div>");
	$("#otherInfoListDiv").tabs({
		width:'100%',
		height:'100%',
		border:false,
		height:$("#otherInfoDiv").height()
	});
	fkHtml = "<table class='addCzfkTable'>" +
	"			<tr><td class='infoName red'>目标发现状态</td><td class='infoValue' colspan=3><div onclick='Yjxx.changeYjxxCzfkTypeHtml(0,this)' class ='fxzt' id='fxzt_wfx'>未发现</div>" +
	"				<div class ='fxzt' id='fxzt_yfx'  onclick='Yjxx.changeYjxxCzfkTypeHtml(1,this)'>已发现</div><input id='czfk_mbfxzt' style='display:none' value='0'></td></tr>" +
	"			<tr class='yfxTr'><td class='infoName red'>发现责任民警姓名</td><td class='yfxTr'  class='infoValue'><input id='czfk_fxmbzrmjxm' readonly placeholder='点击选择发现责任民警'  onclick='public_singleSelectOrgUser(\"\", \"\", \"\", \"\", \"\",\"\", \"czfk_fxmbzrmjsfzh\", \"czfk_fxmbzrmjxm\", \"\", \"czfk_fxmbzrdwjgdm\", \"czfk_fxmbzrdw\", \"\", false, \"\", window, \"\", \"\")' ></td>" +
	"							<td class='infoName red'>发现责任民警身份证号</td><td class='infoValue'><input id='czfk_fxmbzrmjsfzh' placeholder='自动填写' readonly></td></tr>" +
	"			<tr class='yfxTr'><td class='infoName red'>发现责任单位</td><td class='yfxTr'  class='infoValue' colspan=3><input id='czfk_fxmbzrdw' placeholder='自动填写' readonly><input id='czfk_fxmbzrdwjgdm' style='display:none' ></td></tr>" +
	"			<tr class='yfxTr'><td class='infoName red'>处置责任民警姓名</td><td class='yfxTr'  class='infoValue'><input id='czfk_czzrmjxm' readonly placeholder='点击选择处置责任民警' onclick='public_singleSelectOrgUser(\"\", \"\", \"\", \"\", \"\",\"\", \"czfk_czzrmjsfzh\", \"czfk_czzrmjxm\", \"\", \"czfk_czzrdwjgdm\", \"czfk_czzrdw\", \"\", false, \"\", window, \"\", \"\")'></td>" +
	"							<td class='infoName red'>处置责任民警身份证号</td><td class='infoValue'><input id='czfk_czzrmjsfzh' readonly placeholder='自动填写'></td></tr>" +
	"			<tr class='yfxTr'><td class='infoName red'>处置责任单位</td><td class='yfxTr'  class='infoValue' colspan=3><input id='czfk_czzrdw' readonly placeholder='自动填写'><input id='czfk_czzrdwjgdm' style='display:none' ></td></tr>" +
	"			<tr class='yfxTr'><td class='infoName red'>处置时间</td><td  class='yfxTr' class='infoValue'><input id='czfk_czsj' onclick='WdatePicker({skin:\"whyGreen\",dateFmt:\"yyyyMMddHHmmss\"})'></td>" +
	"							<td class='infoName red'>处置地点区划</td><td class='infoValue'><input id='czfk_czddqh' value='510104,510106'></td></tr>" +
	"			<tr class='yfxTr'><td class='infoName red'>处置地点祥址</td><td class='yfxTr'  class='infoValue' colspan=3><input id='czfk_czddxz' ></td></tr>" +
	"			<tr class='yfxTr'><td class='infoName red'>采取处置措施</td><td  class='yfxTr' class='infoValue'><input id='czfk_cqczcs' ></td>" +
	"							<td class='infoName red'>处置结果/细类</td><td class='infoValue'><input id='czfk_czjg' ><input id='czfk_czcsxl' style='display:none'></td></tr>" +
	
	"			<tr class='yfxTr'><td class='infoName'>尿检信息</td><td class='infoValue' colspan=3>毒品种类：<input id='czfk_nj_dpzl' style='width:150px'>尿检结果：<input id='czfk_nj_njjg' style='width:150px'><a href='#' id='add_njxx' onclick='Yjxx.addCkyj_njxx();'>添加</a>" +
	"								<table id='czfk_xdchnjxxDiv'><tr><td class='dpInfoName'>毒品种类</td><td class='dpInfoName'>尿检结果</td></tr></table>" +
	"								<input id='czfk_xdchnjxx' style='display:none'>" +
	"								</td></tr>" +
	"			<tr class='yfxTr'><td class='infoName'>物品信息</td><td class='infoValue' colspan=3>毒品种类：<input id='czfk_wp_dpzl' style='width:150px'>缴获数量（克）：<input id='czfk_wp_jhsl' style='width:150px'><a href='#' id='add_wpxx' onclick='Yjxx.addCkyj_wpxx();'>添加</a>" +
	"								<table id='czfk_xcchwpxxDiv'><tr><td class='dpInfoName'>毒品种类</td><td class='dpInfoName'>缴获数量（克）</td></tr></table>" +
	"								<input id='czfk_xcchwpxx' style='display:none'>" +
	"								</td></tr>" +
	"			<tr><td class='infoName red'>处置经过描述</td><td class='infoValue' colspan=3><textarea id='czfk_czjgms' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" +
	"			<tr><td class='opButtonTd' colspan=4><a href='#' id='addCzfkButton' onclick='Yjxx.addLkyjCzfk();'>提交</a><a href='#' id='refButton'>清空</a></td></tr>" +
	"</table>";
	$("#otherInfoListDiv").tabs('add',{
		title:'反馈信息',
		content:fkHtml
	});
	$("#otherInfoListDiv").tabs('add',{
		title:'反馈记录',
		content:'<div id="fkjlListDiv">123</div>'
	});
	
	$("#czfk_yjcsyy").combobox({
		url: contextPath + '/common/dict/D_QBLD_YJYY.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:250
	});
	initMbcszylxSelect = function(newVal){
		if(newVal==50||newVal==70){
			$("#czfk_mbcszylx").combobox('enable');
		}else{
			if($("#czfk_mbcszylx").val()!=""){
				$("#czfk_mbcszylx").combobox("clear");
			}
			$("#czfk_mbcszylx").combobox('disable');
		}
		
	}
	$("#czfk_mbcszylx").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYCSZYLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:250
	})
	$("#czfk_lxzcgzpg").combobox({
		url: contextPath + '/common/dict/D_QBLD_CKYJLXZCGZDM.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:250,
		onChange:initMbcszylxSelect
	});
	
	
	$("#czfk_czddqh").combotree({
		url:contextPath + '/common/dict/D_BZ_XZQH_MUNICIPAL.js',
		onlyLeaf:true,
		multiple:false,
		required:true,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		onSelect:function(obj){
			$("#czfk_czddxz").val(obj.text)
			}
	})
	
	
	
	$("#czfk_nj_dpzl").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYCSZYLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200
	})
	$("#czfk_nj_dpzl").combobox({
		url: contextPath + '/common/dict/D_QBLD_DPZL.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200
	})
	$("#czfk_wp_dpzl").combobox({
		url: contextPath + '/common/dict/D_QBLD_DPZL.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200
	})
	$("#czfk_nj_njjg").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYXDNJJGDM.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200
	})
	
	/**
	 * 初始化处置结果下拉框
	 */
	initCzjgSelect = function(val){
		$("#czfk_czjg").combobox({
			url: contextPath + '/common/dict/D_QBLD_ZDRYYJCZJGLX.js',
			dataFilter:val+'[^0]',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:100,
			onChange:function(val){
				if(val==11){
					$("#wzhyyTr").show();
				}
				else{
					$("#wzhyyTr").hide();
					$("#czfk_wzhyy").val("");
				}
			}
		});
		if(val==2){
			$("#czfk_czcsxl").next('.combo').show();
			
		}else{
			$("#czfk_czcsxl").next('.combo').hide();
		}
		
	}
	$("#czfk_cqczcs").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYCZCSLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:250,
		onChange:initCzjgSelect
	})
	$("#czfk_czcsxl").combobox({
				url: contextPath + '/common/dict/D_QBLD_ZDRYGKCSLX.js',
				dataFilter:'.{3}',
				valueField:'id',
				textField:'text',
				selectOnNavigation:false,
				method:'get',
				tipPosition:'left',
				width:150
			});
	if(Yjxx.indexInfoObj.yjjb == 1){
		$("#czfk_cqczcs").combobox("setValue","1");
	}
		
	$("#czfk_czcsxl").next('.combo').hide();
	
   $("#add_njxx").linkbutton({
	   iconCls:'icon-add'
   } ) 
    $("#add_wpxx").linkbutton({
	   iconCls:'icon-add'
   } ) 
   
   $("#addCzfkButton").linkbutton({
	   iconCls:'icon-save'
   } ) 
   $("#refButton").linkbutton({
	iconCls:'icon-reload'
   } )
   
   
   $("#fxzt_wfx").click();
   Yjxx.queryLkyjFkList();
   $("#otherInfoListDiv").tabs('select',0);
};
/**
 * @method:addLkyjCzfk
 * @package:syrk/js/qbld	
 * @description:是增加临控预警反馈表
 * @author:Li_Zhenzhong
 * @date:2015-5-17下午6:17:42
 */
Yjxx.addLkyjCzfk = function(){
	var param;
	/**
	 * 获取表单内容,并拼成JSON对象
	 */
	var inputObjs = $(".addCzfkTable input")
	var length = inputObjs.length;
	var param = "({";
	for(var i = 0; i < length ; i++){
		var obj = inputObjs[i];
		if(obj.id&&obj.id.indexOf("czfk_")!=-1&&$(obj).val()!=""){
			param +="'"+obj.id.replace("czfk_","")+"':'"+ $(obj).val()+"',";
		}
	}
	var textObjs = $(".addCzfkTable textarea")
	length = textObjs.length;
	for(var i = 0; i < length ; i++){
		var obj = textObjs[i];
		if(obj.id.indexOf("czfk_")!=-1&&$(obj).val()!="")
			param +="'"+obj.id.replace("czfk_","")+"':'"+ $(obj).val()+"',";
	}
	param+="'lkzlbh':'"+Yjxx.indexInfoObj.lkzlbh+"'})";
	param = eval(param);
	var url = contextPath+'/lkyj/updateLkyjxxbAndSaveFkb';
	var fajax = new FrameTools.Ajax(url,Yjxx.addLkyjCzfk_back);
	fajax.send(param);
};
/**
 * @method:addLkyjCzfk_back
 * @package:syrk/js/qbld	
 * @description:反馈提交提示信息
 * @param fkRs
 * @author:Li_Zhenzhong
 * @date:2015-5-17下午6:19:23
 */
Yjxx.addLkyjCzfk_back = function(fkRs){
	if(fkRs.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"反馈提交成功",
			time:3000,
			showType:'slide'
		})
		$("#fxzt_wfx").click();
		$('#fkjlListDiv').datagrid('reload');
		Yjxx.QueryDyjCount();
	}
};
/**
 * @method:querylkyjFkList
 * @package:syrk/js/qbld	
 * @description:查询临控预警反馈列表
 * @param yjxxbh
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午6:43:02
 */
Yjxx.queryLkyjFkList = function(){
	$('#fkjlListDiv').datagrid({
		idField:'czfkxxbh',
		fit:true,
		fitColumns : true,
		pagination : true,
		singleSelect : true,
		showFooter:true,
		striped:true,
		rownumbers:true,
		url:contextPath+"/lkyj/queryLkyjFkList",
		queryParams:{"lkzlbh":Yjxx.indexInfoObj.lkzlbh},
		pageSize:10,
		columns:[[
	  		    {field:'fksj',title:'反馈时间',width:$('#otherInfoDiv').width()*.24,align:'center'},    
	  		    {field:'fkdw',title:'反馈单位',width:$('#otherInfoDiv').width()*.24,align:'center'},    
	  		    {field:'fkrxm',title:'反馈人',width:$('#otherInfoDiv').width()*.24,align:'center'},
	  		    {field:'czcsxl',title:'处置结果',width:$('#otherInfoDiv').width()*.24,align:'center'}
 	    ]],
 		onClickRow:function(index,row){
 			Yjxx.showMoreLkFkInfo(row);
		}
	});
}
Yjxx.showMoreLkFkInfo = function(obj){
	var fkHtml = "<table class='addCzfkTable'>" +
	"			<tr><td class='infoName'>目标发现状态</td><td class='infoValue' colspan=3>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYMBFXZT.js', obj.mbfxzt)+"</td></tr>" ;
	if(obj.mbfxzt!=0){
		var time;
		if(obj.czsj!=null){
			time = obj.czsj;
			time = time.substring(0,4)+"/"+time.substring(4,6)+"/"+time.substring(6,8)+" "+time.substring(8,10)+":"+time.substring(10,12)+":"+time.substring(12,14);
		}
		fkHtml += "			<tr ><td class='infoName'>发现责任民警姓名</td><td   class='infoValue'>"+obj.fxmbzrmjxm+"</td>" +
		"							<td class='infoName'>发现责任民警身份证号</td><td class='infoValue'>"+obj.fxmbzrmjsfzh+"</td></tr>" +
		"			<tr ><td class='infoName'>发现责任单位</td><td   class='infoValue' colspan=3>"+obj.fxmbzrdw+"</td></tr>" +
		"			<tr ><td class='infoName'>处置责任民警姓名</td><td  class='infoValue'>"+obj.czzrmjxm+"</td>" +
		"							<td class='infoName'>处置责任民警身份证号</td><td class='infoValue'>"+obj.czzrmjsfzh+"</td></tr>" +
		"			<tr ><td class='infoName'>处置责任单位</td><td   class='infoValue' colspan=3>"+obj.czzrdw+"</td></tr>" +
		"			<tr ><td class='infoName'>处置时间</td><td  class='infoValue'>"+time+"</td>" +
		"							<td class='infoName'>处置地点区划</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_BZ_XZQH_MUNICIPAL.js', obj.czddqh)+"</td></tr>" +
		"			<tr ><td class='infoName'>处置地点祥址</td><td class='infoValue' colspan=3>"+obj.czddxz+"</td></tr>" +
		"			<tr ><td class='infoName'>采取处置措施</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYCZCSLX.js', obj.cqczcs)+"</td>" +
		"							<td class='infoName'>处置结果/细类</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYYJCZJGLX.js', obj.czjg)+
		 (obj.czcsxl!=""?"/" +window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYGKCSLX.js', obj.czcsxl):"")+
		"</td></tr>" ;
	}
	fkHtml += "			<tr><td class='infoName'>处置经过描述</td><td class='infoValue' colspan=3>"+obj.czjgms+"</textarea></td></tr></table>";
	var  tab  = $("#otherInfoListDiv").tabs('getTab','历史反馈');
	if(tab){
		 $("#otherInfoListDiv").tabs('update',{
			 tab:tab,
			 options:{
				 content:fkHtml
			 }
		 })
		  $("#otherInfoListDiv").tabs('select','历史反馈');
	}
	else{
		$("#otherInfoListDiv").tabs('add',{
		    id:obj.czfkbh,
			title:'历史反馈',
			closable:true,
			content:fkHtml
		});
	}
}