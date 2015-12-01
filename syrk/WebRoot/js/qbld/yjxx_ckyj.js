if(typeof Yjxx =="undefined" || !Yjxx){
	Yjxx = {};
}


/**
 * @title:initCkyjQueryHtml
 * @description:初始化价值常控预警级别选择框
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:05
 */
Yjxx.initCkyjQueryHtml = function(type){
	Yjxx.type = type;
	if(type==0||type==1){
		jbhtml = "<input type='checkbox' name='yjjb' value='1' onclick='Yjxx.queryCkyjList();' checked disabled/>红色";
	} else{
		jbhtml = "<input type='checkbox' name='yjjb'  onclick='Yjxx.queryCkyjList();' value='1' checked/>红色"+
		"<input type='checkbox' name='yjjb' value='2'   onclick='Yjxx.queryCkyjList();' checked/>橙色"+
		"<input type='checkbox' name='yjjb' value='4'   onclick='Yjxx.queryCkyjList();' checked/>黄色"+
		"<input type='checkbox' name='yjjb' value='5'  onclick='Yjxx.queryCkyjList();'  checked/>蓝色";
	}
	$(".yjjbCheckBox").html(jbhtml);
	Yjxx.initCkyjSimpleQuery();
}
/**
 * @title:initSimpleQuery
 * @description:初始化加载常控预警级别简单查询
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:36
 */
Yjxx.initCkyjSimpleQuery = function(){
	var queryhtml  = '<div id="simpleQuery">'+
			'<div><input id="where_all" maxlength=18 placeholder="姓名或身份证号查询"></div>'+
			'<div><a href="#" id="simpleQueryButton" onclick="Yjxx.queryCkyjList();">查询</a>'+
			'<a href="#" id="toggleButton" onclick="Yjxx.initCkyjAdvancedQuery()"  >精确查询</a></div>'+
			'</div>';
	$("#queryDiv").html(queryhtml);
	$("#simpleQueryButton").linkbutton({
			iconCls:"icon-search"
	} ) 
	$("#toggleButton").linkbutton({
		plain:true
	} ) 
	$(window).resize();
	Yjxx.queryCkyjList();
}

/**
 * @title:initAdvancedQuery
 * @description:初始化加载常控预警级别简单查询
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:56
 */
Yjxx.initCkyjAdvancedQuery = function(){
	var queryhtml = '<div id="advancedQuery">'+
	'<table border=0>'+
	'<tr><td colspan=2 class="queryType"><a href="#" class="easyui-linkbutton" id="toggleButton" onclick="Yjxx.initCkyjSimpleQuery()" >模糊查询</a></td></tr>'+
	'<tr><td class="whereName">姓名</td><td><input class="whereInput" id="where_xm" maxlength=15></td></tr>'+
	'<tr><td class="whereName">证件号码</td><td><input class="whereInput" id="where_sfzh" maxlength=18></td></tr>'+
	'<tr><td class="whereName">人员类型</td><td><input id="where_lx" ></td></tr>'+
	'<tr><td class="whereName">预警发布时间</td><td><input class="whereInput" id="where_yjfbsjB" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" >-'+
	'	<input class="whereInput" id="where_yjfbsjE" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})"></td></tr>'+
	'<tr><td colspan=2 class="queryButton"><a href="#" id="advancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.queryCkyjList();" >查询</a>'+
	'										<a href="#" id="clearAdvancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.clearYjxxAdvancedQueryValue();" >重置</a></td></tr>'+
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
	$("#where_lx").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYLB.js',
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
 * @method:clearYjxxAdvancedQueryValue
 * @package:syrk/js/qbld	
 * @description:清空常控预警高级查询条件
 * @author:Li_Zhenzhong
 * @date:2015-5-15上午10:40:28
 */
Yjxx.clearYjxxAdvancedQueryValue = function(){
	$("#where_xm").val("");
	$("#where_sfzh").val("");
	$("#where_lx").combobox("setValue","");
	$("#where_yjfbsjB").val("");
	$("#where_yjfbsjE").val("");
}

/**
 * @title:queryCkyjList
 * @description:常控预警查询
 * @author:li_zhenzhong
 * @param total 总数
 * @param begin 开始记录序号
 * @param end 结束记录序号
 * @param page 当前页数
 * @date:2015-4-21下午4:12:07
 */
Yjxx.queryCkyjList = function(total,begin,end,page){
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
		param = {"yjjsdw":userOrgCode,
				"yjjb":yjjb.substring(0, yjjb.length-1),
				"qsfkzt":Yjxx.type,
				"zdryxm":xm,
				"sfzh":sfzh,
				"total":total,
				"rownum":10,
				"begin":begin,
				"end":end,
				"page":page}
	 }else{
		 param = {"yjjsdw":userOrgCode,
					"yjjb":yjjb.substring(0, yjjb.length-1),
					"qsfkzt":Yjxx.type,
					"zdryxm":$("#where_xm").val(),
					"sfzh":$("#where_sfzh").val(),
					"zdryxl":$("#where_lx").val(),
					"yjfbsjB":$("#where_yjfbsjB").val(),
					"yjfbsjE":$("#where_yjfbsjE").val(),
					"total":total,
					"rownum":10,
					"begin":begin,
					"end":end,
					"page":page}
	 }
	var url = contextPath+'/ckyj/queryCkyjList';
	var fajax = new FrameTools.Ajax(url,Yjxx.queryCkyjList_back);
	fajax.send(param);
};

/**
 * @title:queryCkyjList_back
 * @description:解析常控预警结果,并显示列表
 * @author:li_zhenzhong
 * @param json
 * @date:2015-4-20下午6:59:28
 */
Yjxx.queryCkyjList_back = function(json){
	var  rsHtml = "<table class='listTable'>";
		rsHtml+="<tr class='countInfo'>" +
		"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>条预警信息</td>"+
		"</tr>";
	var rows = json.rows;
		num = rows.length
		for(var  i = 0;i<num;i++){
			var row = rows[i];
		rsHtml+="<tr class='infoOne_tr' onclick='Yjxx.clickListToChangeColor(this);Yjxx.initOtherDivShow();Yjxx.queryOneCkyjInfo(\""+row.yjxxbh+"\")'>";
		/**
	     * 显示预警信息颜色级别
	     */
		switch(parseInt(row.yjjb)){//根据级别显示不同颜色
			case 1: rsHtml += "<td class='color1'></td>";break;
			case 2: rsHtml += "<td class='color2'></td>";break;
			case 4: rsHtml += "<td class='color3'></td>";break;
			case 5: rsHtml += "<td class='color4'></td>";break;
			default:rsHtml += "<td class='color0'></td>";break;
		}
		rsHtml+= "<td class='infoBody' onclick=''>"+"姓名:"+ row.zdryxm+"  <br> " +
						"身份证号:"+ row.sfzh+"<br>" +
						"预警时间:"+row.yjfbsj+"</div<td>";
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
 * @method:queryOneCkyjInfo
 * @package:syrk/js/qbld	
 * @description:查询常控预警详情
 * @param yjxxbh
 * @author:Li_Zhenzhong
 * @date:2015-5-6下午6:28:10
 */
Yjxx.queryOneCkyjInfo = function(yjxxbh){
	Yjxx.indexInfoObj = null;
	var url = contextPath+'/ckyj/queryCkyj';
	var fajax = new FrameTools.Ajax(url,Yjxx.showOneCkyjInfo);
	fajax.send({"yjxxbh":yjxxbh});
}

/**
 * @method:showOneCkyjInfo
 * @package:syrk/js/qbld	
 * @description:显示常控预警详情
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-6下午6:28:20
 */
Yjxx.showOneCkyjInfo = function(json){
	if(json==null)
		json = Yjxx.indexInfoObj;
	if(Yjxx.indexInfoObj==null)
		Yjxx.indexInfoObj = json;
	else if(Yjxx.indexInfoObj != json ){
		$("#backButtonTd").html("<a href='#' id='backButton' onclick='Yjxx.showOneCkyjInfo()' >返回</a>")
	}else{
		$("#backButtonTd").html("");
	}
	$("#infoTitle").html("姓名："+json.zdryxm);
	$("#asInfoButton").html("<a href='#' id='lsListButton' onclick='Yjxx.queryOtherInfo(function(){Yjxx.queryCkyjList_Ls(\""+json.sfzh+"\")})' ></a>")
	$("#opButtonTd").html("<a href='#' id='documentButton' onclick='window.open(\""+json.dtgjxxbh+"\")'></a> <a href='#' id='qsfkButton'></a>")
	$("#oneInfoDiv").height($(".infoTr").height()-5);
	$("#oneInfoDiv").html(Yjxx.buildCkyjInfoHtml(json));
	
	$("#documentButton").linkbutton({
		   text:'电子档案'
	   })
    if(Yjxx.indexInfoObj == json ){
    	$("#lsListButton").linkbutton({
	   		text:'历史'
 	   	} ) 
 	   	if(json.yjjb==1){
	 	   	if(json.qsfkzt!=0){
		 	   	$("#qsfkButton").linkbutton({
					text:'反馈'
				} );
		    	$("#qsfkButton").click(Yjxx.showCkyjFkFrom);
	 	   	}else{
		   		$("#qsfkButton").linkbutton({
					text:'签收'
				} );
		    	$("#qsfkButton").click(function(){Yjxx.ckyjQs();})
	   		}
 	   	}
    }
}
/**
 * @title:buildCkyjInfoHtml
 * @description:创建常控预警详细信息
 * @author:li_zhenzhong
 * @returns {String}
 * @date:2015-4-23上午9:20:31
 */
Yjxx.buildCkyjInfoHtml = function(json){
	var zdryxl = "";
	if(json.zdryxl.indexOf(",")!=-1){
		var zdryArr = json.zdryxl.split(",");
		var num = zdryArr.length;
		for(var i=0;i<num;i++){
			zdryxl+= window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXL.js', zdryArr[i])+","
		}
		zdryxl = zdryxl.substring(0,zdryxl.length-1)
	}else{
		zdryxl = window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXL.js', json.zdryxl);
	}
		
	var  html = "<table class='infoOneTable'>" +
			"<tr><td class='infoTypeTd'>基<br>本<br>信<br>息</td>" +
			"	<td>" +
			"		<table class='infoBodyTable'>" +
			"			<tr><td class='infoName'>公民身份证号</td><td class='infoValue'>"+json.sfzh+"</td>" +
					"		<td class='infoName'>民族</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js', json.mzdm)+"</td>" +
					"		<td id='imgTd' rowspan=6 ><img style='width:150px;height:185px;' src='"+contextPath + "/ckyj/queryQbldZpSingle.jpg?sfzh="+json.sfzh + "'></img></td></tr>" +
			"			<tr><td class='infoName'>性别</td><td class='infoValue'>"+ window.top.getDictName(contextPath + '/common/dict/D_QBLD_XB.js', json.xbdm) +"</td>" +
					"		<td class='infoName'>籍贯</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_XB.js', json.jgssxdm) +"</td></tr>" +
			"			<tr><td class='infoName'>其他证件号码</td><td class='infoValue' colspan=3>"+json.qtzjhm+"</td></tr>" +
			"			<tr><td class='infoName'>户籍地祥址</td><td class='infoValue' colspan=3>"+json.hjd_dzxz+" </td>" +
			"			<tr><td class='infoName'>现住地祥址</td><td class='infoValue' colspan=3>"+json.jzd_dzxz+" </td>" +
			"			<tr><td class='infoName'>管辖单位</td><td class='infoValue' colspan=3>"+json.gxpcsdm+"</td>" +
			"			<tr><td class='infoName'>立案单位</td><td class='infoValue'>缺少</td>" +
					"		<td class='infoName'>重点人细类</td><td class='infoValue' colspan=2>"+ window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXL.js',  json.zdryxl) +"</td></tr>" +
			"			<tr><td class='infoName'>入库时间</td><td class='infoValue'>"+json.rksj+"</td><td class='infoName'>有效性</td><td class='infoValue' colspan=2></td></tr>" +
			"		</table>" +
			"	</td>" +
			"</tr>"+
			"<tr><td class='infoTypeTd'>活<br>动<br>信<br>息</td>" +
			"	<td>" +
			"		<table class='infoBodyTable'>" +
			"			<tr><td class='infoName'>登记姓名</td><td class='infoValue'>"+json.djxm+"</td><td id='mapTd' colspan=2 rowspan=8><iframe id='mapDiv' src='qbld|map' ></iframe></td></tr>" +
			"			<tr><td class='infoName'>登记性别</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXBDM.js', json.djxb) +"</td></tr>" +
			"			<tr><td class='infoName'>登记证件号码</td><td class='infoValue'>"+json.djzjhm+"</td></tr>" +
			"			<tr><td class='infoName'>预警接受单位</td><td class='infoValue'>"+json.yjjsdw+"</td></tr>" +
			"			<tr><td class='infoName'>预警级别</td><td class='infoValue'>"+ window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYYJJB.js', json.yjjb) +"</td></tr>" +
			"			<tr><td class='infoName'>签收时限</td><td class='infoValue'>"+json.qssx.substring(0,4)+"/"+json.qssx.substring(4,6)+"/"+json.qssx.substring(6,8)+" "+json.qssx.substring(8,10)+":"+json.qssx.substring(10,12)+":"+json.qssx.substring(12,14)+"</td></tr>" +
			"			<tr><td class='infoName'>登记出生日期</td><td class='infoValue'>"+json.djcsrq+"</td></tr>" +
			"			<tr><td class='infoName'>活动发生时间</td><td class='infoValue'>"+ json.hdfssj.substring(0,4)+"/"+json.hdfssj.substring(4,6)+"/"+json.hdfssj.substring(6,8)+" "+json.hdfssj.substring(8,10)+":"+json.hdfssj.substring(10,12)+":"+json.hdfssj.substring(12,14)+"</td></tr>" +
			"			<tr><td class='infoName'>活动发生地祥址</td><td class='infoValue'>"+json.hdfsddxz+"</td><td class='infoName'>活动发生地社会场所</td><td class='infoValue'><a href='#' onclick='Yjxx.openMapWindow(\""+json.zbx+"\",\""+json.zby+"\");'>"+json.hdfsddssshcs+"</a></td></tr>" +
			"			<tr><td class='infoName'>发生地公安机关</td><td class='infoValue'>"+json.hdfsddssgajg+"</td><td class='infoName'>动态信息提供单位</td><td class='infoValue'>"+json.dtxxtgdw+"</td></tr>" +
			"			<tr><td class='infoName'>信息比对时间</td><td class='infoValue'>"+json.xxbdsj.substring(0,4)+"/"+json.xxbdsj.substring(4,6)+"/"+json.xxbdsj.substring(6,8)+" "+json.xxbdsj.substring(8,10)+":"+json.xxbdsj.substring(10,12)+":"+json.xxbdsj.substring(12,14) +"</td><td class='infoName'>信息比对单位</td><td class='infoValue'>"+json.xxbddw+"</td></tr>" +
			"			<tr><td class='infoName'>活动相关信息</td><td class='infoValue' colspan=3>"+json.hdxgxx+"</td></tr>" +
			"			<tr><td class='infoName'>备注</td><td class='infoValue' colspan=3>"+json.bz+"</td></tr>";
			
	if(json.qsrxm){
		html += 	"			<tr><td class='infoName'>签收人</td><td class='infoValue'>"+json.qsrxm+
			"				</td><td class='infoName'>签收时间</td><td class='infoValue'>"+json.qssj+"</td></tr>" +
			"			<tr><td class='infoName'>签收单位</td><td class='infoValue' colspan=3>"+json.qsdw+"</td></tr>";
	}	
	html += 	"		</table>" +
			"	</td>" +
			"</tr>"+
			"</table>";
	return html;
};

/**
 * @title:queryCkyjList_Ls
 * @description:查询人员历史信息
 * @author:li_zhenzhong
 * @param sfzh
 * @date:2015-4-27下午4:53:26
 */
Yjxx.queryCkyjList_Ls = function(sfzh){
	$('#otherInfoListDiv').datagrid({
		idField:'yjxxbh',
		fit:true,
		fitColumns : true,
		pagination : true,
		singleSelect : true,
		showFooter:true,
		striped:true,
		rownumbers:true,
		url:contextPath+"/ckyj/queryCkyjList",
		queryParams:{"qsfkzt":"2","sfzh":sfzh},
		pageSize:10,
		columns:[[
	  		    {field:'zdryxm',title:'人员姓名',width:100,align:'center'},    
	  		    {field:'sfzh',title:'证件号码',width:100,align:'center'},    
	  		    {field:'zdryxl',title:'人员类型',width:100,align:'center'},
	  		    {field:'yjjsdw',title:'接收单位',width:100,align:'center'},
	  		    {field:'yjfbsj',title:'预警时间',width:100,align:'center'},     
	  		    {field:'qsfkzt',title:'当前状态',width:100,align:'center'}
  	    ]],
  		onClickRow:function(index,row){
  			Yjxx.showOneCkyjInfo(row);
		}
	  	});
}



/**
 * @title:ckyjQs
 * @description:常控预警签收
 * @author:li_zhenzhong
 * @param yjxxbh
 * @date:2015-4-28上午9:03:03
 */
Yjxx.ckyjQs = function(){
	var url = contextPath+'/ckyj/updateCkyjxxbAndSaveQsb';
	var fajax = new FrameTools.Ajax(url,Yjxx.ckyjQs_back);
	fajax.send({"yjxxbh":Yjxx.indexInfoObj.yjxxbh});
};
/**
 * @title:ckyjQs_back
 * @description:签收成功后改变为待反馈状态
 * @author:li_zhenzhong
 * @param qsRs
 * @date:2015-4-28上午9:52:14
 */
Yjxx.ckyjQs_back = function(qsRs){
	if(qsRs.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"签收成功",
			time:3000,
			showType:'slide'
		})
		$("#qsfkButton").unbind("click");
		$("#qsfkButton").linkbutton({text:"反馈"});
		$("#qsfkButton").click(Yjxx.showCkyjFkFrom);
		Yjxx.QueryDyjCount();
		Yjxx.queryCkyjList();
	}
}
/**
 * @title:showCkyjFkFrom
 * @description:显示反馈表单
 * @author:li_zhenzhong
 * @date:2015-4-29下午4:44:23
 */
Yjxx.showCkyjFkFrom = function(){
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
			"			<tr class='wfxTr'><td class='infoName red'>预警产生的原因</td><td  class='infoValue' colspan=3><input id='czfk_yjcsyy'></td></tr>" +
			"			<tr id='qtyyTr' ><td class='infoName red'>其他原因</td><td  class='infoValue' colspan=3><textarea id='czfk_qtyy' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>发现责任民警姓名</td><td   class='infoValue'><input id='czfk_fxmbzrmjxm' readonly placeholder='点击选择发现责任民警'  onclick='public_singleSelectOrgUser(\"\", \"\", \"\", \"\", \"\",\"\", \"czfk_fxmbzrmjsfzh\", \"czfk_fxmbzrmjxm\", \"\", \"czfk_fxmbzrdwjgdm\", \"czfk_fxmbzrdw\", \"\", false, \"\", window, \"\", \"\")' ></td>" +
			"							<td class='infoName red'>发现责任民警身份证号</td><td class='infoValue'><input id='czfk_fxmbzrmjsfzh' placeholder='自动填写' readonly></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>发现责任单位</td><td   class='infoValue' colspan=3><input id='czfk_fxmbzrdw' placeholder='自动填写' readonly><input id='czfk_fxmbzrdwjgdm' style='display:none' ></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>处置责任民警姓名</td><td   class='infoValue'><input id='czfk_czzrmjxm' readonly placeholder='点击选择处置责任民警' onclick='public_singleSelectOrgUser(\"\", \"\", \"\", \"\", \"\",\"\", \"czfk_czzrmjsfzh\", \"czfk_czzrmjxm\", \"\", \"czfk_czzrdwjgdm\", \"czfk_czzrdw\", \"\", false, \"\", window, \"\", \"\")'></td>" +
			"							<td class='infoName red'>处置责任民警身份证号</td><td class='infoValue'><input id='czfk_czzrmjsfzh' readonly placeholder='自动填写'></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>处置责任单位</td><td   class='infoValue' colspan=3><input id='czfk_czzrdw' readonly placeholder='自动填写'><input id='czfk_czzrdwjgdm' style='display:none' ></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>处置时间</td><td  class='infoValue'><input id='czfk_czsj' onclick='WdatePicker({skin:\"whyGreen\",dateFmt:\"yyyyMMddHHmmss\"})'></td>" +
			"							<td class='infoName red'>处置地点区划</td><td class='infoValue'><input id='czfk_czddqh' value='510104,510106'></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>处置地点祥址</td><td   class='infoValue' colspan=3><input id='czfk_czddxz' ></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>采取处置措施</td><td   class='infoValue'><input id='czfk_cqczcs' ></td>" +
			"							<td class='infoName red'>处置结果/细类</td><td class='infoValue'><input id='czfk_czjg' ><input id='czfk_czcsxl' style='display:none'><input id='czfk_zbxl' style='display:none'></td></tr>" +
			"			<tr style='display:none' id='wzhyyTr'><td class='infoName red'>未抓获原因</td><td class='infoValue' colspan=3><textarea id='czfk_wzhyy' maxlength=200 placeholder='最多填写200个文字'></textarea></td>" +
			"			<tr style='display:none' id='xcxxcjTr'><td class='infoName'>现场信息采集</td><td class='infoValue' colspan=3><textarea id='czfk_xcxxcj' maxlength=200 placeholder='最多填写200个文字'></textarea></td>" +
			"			<tr class='yfxTr'><td class='infoName'>尿检信息</td><td class='infoValue' colspan=3>毒品种类：<input id='czfk_nj_dpzl' style='width:150px'>尿检结果：<input id='czfk_nj_njjg' style='width:150px'><a href='#' id='add_njxx' onclick='Yjxx.addCkyj_njxx();'>添加</a>" +
			"								<table id='czfk_xdchnjxxDiv'><tr><td class='dpInfoName'>毒品种类</td><td class='dpInfoName'>尿检结果</td></tr></table>" +
			"								<input id='czfk_xdchnjxx' style='display:none'>" +
			"								</td></tr>" +
			"			<tr class='yfxTr'><td class='infoName'>物品信息</td><td class='infoValue' colspan=3>毒品种类：<input id='czfk_wp_dpzl' style='width:150px'>缴获数量（克）：<input id='czfk_wp_jhsl' style='width:150px'><a href='#' id='add_wpxx' onclick='Yjxx.addCkyj_wpxx();'>添加</a>" +
			"								<table id='czfk_xcchwpxxDiv'><tr><td class='dpInfoName'>毒品种类</td><td class='dpInfoName'>缴获数量（克）</td></tr></table>" +
			"								<input id='czfk_xcchwpxx' style='display:none'>" +
			"								</td></tr>" +
			"			<tr><td class='infoName red'>处置经过描述</td><td class='infoValue' colspan=3><textarea id='czfk_czjgms' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" +
			"			<tr><td class='infoName'>立案侦查工作评估</td><td class='infoValue'><input id='czfk_lxzcgzpg' ></td>" +
			"				<td class='infoName'>目标从事职业类型</td><td class='infoValue'><input id='czfk_mbcszylx' ></td></tr>" +
			"			<tr><td class='infoName'>工作评估依据</td><td class='infoValue' colspan=3><textarea id='czfk_lxzcgzpgyj' maxlength=450 placeholder='最多填写450个文字'></textarea></td></tr>" +
			"			<tr><td class='infoName'>处置反馈补充信息</td><td class='infoValue' colspan=3><textarea id='czfk_czfkbcxx' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" +
			"			<tr><td class='opButtonTd' colspan=4><a href='#' id='addCzfkButton' onclick='Yjxx.addCkyjCzfk();'>提交</a><a href='#' id='refButton'>清空</a></td></tr>" +
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
		width:250,
		onChange:function(val){
			if(val==9){
				$("#qtyyTr").show();
			}else{
				$("#qtyyTr").hide();
			}
		}
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
	$("#czfk_zbxl").combobox({
		url: contextPath + '/common/dict/D_QBLD_GKZHXL.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:150
	});
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
					$("#xcxxcjTr").show();
				}else{
					$("#wzhyyTr").hide();
					$("#xcxxcjTr").hide();
					$("#czfk_wzhyy").val("");
					$("#czfk_xcxxcj").val("");
				}
				if(val==12){
					$("#czfk_zbxl").next('.combo').show();
				}else{
					$("#czfk_zbxl").next('.combo').hide();
					$("#czfk_zbxl").combobox("setValue","");
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
   Yjxx.queryCkyjFkList();
   $("#otherInfoListDiv").tabs('select',0);
};
/**
 * @method:addCkyj_njxx
 * @package:syrk/js/qbld	
 * @description:新增一条尿检纪录
 * @author:Li_Zhenzhong
 * @date:2015-5-11下午5:16:03
 */
Yjxx.addCkyj_njxx = function(){
	/**
	 * 严重增加记录是否正确
	 */
	if($("#czfk_nj_dpzl").val()==""||$("#czfk_nj_njjg").val()==""){
		$.messager.alert("提示:","种类和结果不能为空！","info");
		return;
	}
	if($("#czfk_xdchnjxx").val()=="")
		$("#czfk_xdchnjxx").val($("#czfk_nj_dpzl").val()+"/"+$("#czfk_nj_njjg").val());
	else{
		if($("#czfk_xdchnjxx").val().split(",").length>8){
			$.messager.alert("提示:","最多填写8项纪录！","info");
			return;
		}
		if($("#czfk_xdchnjxx").val().indexOf($("#czfk_nj_dpzl").val())!=-1){
			$.messager.alert("提示:","该类毒品已添加！","info");
			return;
		}
		/**
		 * 讲新增尿检信息加入指定字段中
		 */
		$("#czfk_xdchnjxx").val($("#czfk_xdchnjxx").val()+","+$("#czfk_nj_dpzl").val()+"/"+$("#czfk_nj_njjg").val());
	}
		
	/**
	 * 在尿检信息表格中增加一行信息
	 */
	var table =	document.getElementById("czfk_xdchnjxxDiv");
	var _tr=table.insertRow();	
	var _td=_tr.insertCell();
	_td.setAttribute("align","center");
	var _tn = document.createTextNode($("#czfk_nj_dpzl").combobox("getText"));
	_td.appendChild(_tn);
	_td=_tr.insertCell();
	_td.setAttribute("align","center");
	_tn = document.createTextNode($("#czfk_nj_njjg").combobox("getText"));
	_td.appendChild(_tn);	
	$("#czfk_dpzl").combobox("setValue","");
	$("#czfk_njjg").combobox("setValue","");
	
};
/**
 * @method:addCkyj_wpxx
 * @package:syrk/js/qbld	
 * @description:新增一条物品纪录
 * @author:Li_Zhenzhong
 * @date:2015-5-11下午5:16:29
 */
Yjxx.addCkyj_wpxx = function(){
	/**
	 * 严重增加记录是否正确
	 */
	var wpsl = $("#czfk_wp_jhsl").val();
	if($("#czfk_wp_dpzl").val()==""||wpsl==""){
		$.messager.alert("提示:","种类和数量不能为空！","info");
		return;
	}
	var reg = new RegExp("^[0-9]+(.[0-9]*)?$");
	if(!reg.test(wpsl)){
		$.messager.alert("提示:","数值格式错误，请重新填写！","info");
		return;
	}
	
	if(parseInt(wpsl)>9999999){
		$.messager.alert("提示:","数值过大，请重新填写！","info");
		return;
	}
	var zs = "";
	var xs = "";
	if(wpsl.indexOf(".")!=-1){
		var re = /([0-9]+.[0-9]{3})[0-9]*/;
		wpsl = wpsl.replace(re,"$1");
		var slarr = wpsl.split(".");
		zs =slarr[0];
		xs = slarr[1];

		while(zs.length<7){
			zs = " "+zs;
		}
		
		while(xs.length<3){
			xs+=" ";
		}
	}else{
		while(wpsl.length<7){
			wpsl = " "+wpsl;
		}
		zs = wpsl+"   ";
	}
	
	if($("#czfk_xcchwpxx").val()=="")
		$("#czfk_xcchwpxx").val('{"DP":'+$("#czfk_wp_dpzl").val()+'/'+zs+xs+'}');
	else{
		if($("#czfk_xcchwpxx").val().split(",").length>7){
			$.messager.alert("提示:","最多填写7项纪录！","info");
			return;
		}
		if($("#czfk_xcchwpxx").val().indexOf($("#czfk_wp_dpzl").val())!=-1){
			$.messager.alert("提示:","该类毒品已添加！","info");
			return;
		}
		/**
		 * 讲新增物品信息加入指定字段中
		 */
		var wpxx = $("#czfk_xcchwpxx").val();
		$("#czfk_xcchwpxx").val(wpxx.replace("}","")+","+$("#czfk_wp_dpzl").val()+"/"+zs+xs+"}");
	}
	/**
	 * 在物品信息表格中增加一行信息
	 */	
	var table =	document.getElementById("czfk_xcchwpxxDiv");
	var _tr=table.insertRow();	
	var _td=_tr.insertCell();
	_td.setAttribute("align","center");
	var _tn = document.createTextNode($("#czfk_wp_dpzl").combobox("getText"));
	_td.appendChild(_tn);
	_td=_tr.insertCell();
	_td.setAttribute("align","center");
	_tn = document.createTextNode($("#czfk_wp_jhsl").val());
	_td.appendChild(_tn);	
	$("#czfk_wp_dpzl").combobox("setValue","");
	$("#czfk_wp_jhsl").val("");
}
/**
 * @title:queryCkyjFkList
 * @description:查询常控预警反馈列表
 * @author:li_zhenzhong
 * @param yjxxbh
 * @date:2015-4-29下午4:53:30
 */
Yjxx.queryCkyjFkList = function(){
	$('#fkjlListDiv').datagrid({
		idField:'czfkxxbh',
		fit:true,
		fitColumns : true,
		pagination : true,
		singleSelect : true,
		showFooter:true,
		striped:true,
		rownumbers:true,
		url:contextPath+"/ckyj/queryCkyjFkList",
		queryParams:{"yjxxbh":Yjxx.indexInfoObj.yjxxbh},
		pageSize:10,
		columns:[[
	  		    {field:'fksj',title:'反馈时间',width:$('#otherInfoDiv').width()*.24,align:'center'},    
	  		    {field:'fkdw',title:'反馈单位',width:$('#otherInfoDiv').width()*.24,align:'center'},    
	  		    {field:'fkrxm',title:'反馈人',width:$('#otherInfoDiv').width()*.24,align:'center'},
	  		    {field:'czjg',title:'处置结果',width:$('#otherInfoDiv').width()*.24,align:'center',
	  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYYJCZJGLX.js', value)}}
 	    ]],
 		onClickRow:function(index,row){
 			Yjxx.showMoreFkInfo(row);
		}
	});
}
/**
 * @method:changeYjxxCzfkTypeHtml
 * @package:syrk/js/qbld	
 * @description:根据反馈内容显示不同数据项
 * @param val
 * @author:Li_Zhenzhong
 * @date:2015-5-6下午4:44:57
 * @return:void
 */
Yjxx.changeYjxxCzfkTypeHtml = function(val,obj){
	var a = Yjxx.clearYjxxCzfkValue();
	/*设置目标反馈状态数据值*/
	$("#czfk_mbfxzt").val(val);
	if(Yjxx.indexInfoObj.yjjb == 1 || Yjxx.indexInfoObj.zljb == 11){
		$("#czfk_cqczcs").combobox("setValue","1");
		$("#czfk_cqczcs").combobox("disable");
	}
	$(".fxzt").css("background-color","#e3e3e3");
	$(obj).css("background-color","#17a9ff");
	var showObj = null;
	var hideObj = null;
	if(val==0){
		showObj = $(".wfxTr");
		hideObj = $(".yfxTr");
	}else{
		showObj = $(".yfxTr");
		hideObj = $(".wfxTr");
	}
	for(var i = 0;i<showObj.length;i++){
		$(showObj[i]).show();
	}
	for(var i = 0;i<hideObj.length;i++){
		$(hideObj[i]).hide();
	}
}
/**
 * @method:clearYjxxCzfkValue
 * @package:syrk/js/qbld	
 * @description:制空预警信息处置反馈值
 * @author:Li_Zhenzhong
 * @date:2015-5-15上午9:56:22
 */
Yjxx.clearYjxxCzfkValue = function(){
	var inputObjs = $(".addCzfkTable input")
	var length = inputObjs.length;
	for(var i = 0; i < length ; i++){
		$(inputObjs[i]).val("")
	}
	var textObjs = $(".addCzfkTable textarea")
	length = textObjs.length;
	for(var i = 0; i < length ; i++){
		$(textObjs[i]).val("")
	}

	$("#czfk_xdchnjxxDiv").html("<tr><td class='dpInfoName'>毒品种类</td><td class='dpInfoName'>尿检结果</td></tr>");
	$("#czfk_xcchwpxxDiv").html("<tr><td class='dpInfoName'>毒品种类</td><td class='dpInfoName'>缴获数量（克）</td></tr>");
	return true;
}
/**
 * @method:addCkyjCzfk
 * @package:syrk/js/qbld	
 * @description:常控预警信息反馈
 * @author:Li_Zhenzhong
 * @date:2015-5-9下午5:19:57
 */
Yjxx.addCkyjCzfk = function(){
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
	param+="'yjxxbh':'"+Yjxx.indexInfoObj.yjxxbh+"'})";
	param = eval(param);
	var url = contextPath+'/ckyj/updateCkyjxxbAndSaveFkb';
	var fajax = new FrameTools.Ajax(url,Yjxx.addCkyjCzfk_back);
	fajax.send(param);
};
/**
 * @method:addCkyjCzfk_back
 * @package:syrk/js/qbld	
 * @description:反馈提交提示信息
 * @param fkRs
 * @author:Li_Zhenzhong
 * @date:2015-5-9下午5:23:26
 */
Yjxx.addCkyjCzfk_back = function(fkRs){
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
		Yjxx.queryCkyjList();
	}
};
/**
 * @method:showMoreFkInfo
 * @package:syrk/js/qbld	
 * @description:查看更多反馈信息
 * @param obj
 * @author:Li_Zhenzhong
 * @date:2015-5-9下午5:56:10
 */
Yjxx.showMoreFkInfo = function(obj){
	var fkHtml = "<table class='addCzfkTable'>" +
	"			<tr><td class='infoName'>目标发现状态</td><td class='infoValue' colspan=3>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYMBFXZT.js', obj.mbfxzt)+"</td></tr>" ;
	if(obj.mbfxzt==0){
		fkHtml += "			<tr ><td class='infoName'>预警产生的原因</td><td  class='infoValue' colspan=3>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_YJYY.js', obj.yjcsyy)+"</td></tr>" ;
	}else{
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
		 (obj.zbxl!=""?"/" +window.top.getDictName(contextPath + '/common/dict/D_QBLD_GKZHXL.js', obj.zbxl):"")+
		"</td></tr>" ;
	}
	if(obj.czjg==11){
		fkHtml +="			<tr ><td class='infoName'>未抓获原因</td><td   class='infoValue' colspan=3>"+obj.wzhyy+"</td></tr>" +
				"			<tr ><td class='infoName'>现场信息采集</td><td   class='infoValue' colspan=3>"+obj.xcxxcj+"</td></tr>";
	}
	if(obj.xdchnjxx!=""){
		fkHtml +="			<tr ><td class='infoName'>尿检信息</td><td   class='infoValue' colspan=3>";
		var njxxArr; 
		if(obj.xdchnjxx.indexOf(",")!=-1){
			var njxxArrs = obj.xdchnjxx.split(",");
			for(var i = 0;i < njxxArrs.length;i++){
				njxxArr = njxxArrs[i].split("/");
				fkHtml +=window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPZL.js', njxxArr[0])+"："+
					window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXDNJJGDM.js', njxxArr[1])+"；"
			}
			
		}else{
			njxxArr = obj.xdchnjxx.split("/");
			fkHtml +=window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPZL.js', njxxArr[0])+"："+
				window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXDNJJGDM.js', njxxArr[1]);
		}
		fkHtml +="</td></tr>" ;
	}
	if(obj.xcchwpxx!=""){
		var wpxx = obj.xcchwpxx.replace('{"DP":','').replace('}','');
		
		
		fkHtml +="			<tr ><td class='infoName'>物品信息</td><td   class='infoValue' colspan=3>";
		var wpxxArr; 
		if(wpxx.indexOf(",")!=-1){
			var wpxxArrs = wpxx.split(",");
			for(var i = 0;i < wpxxArrs.length;i++){
				wpxxArr = wpxxArrs[i].split("/");
				fkHtml +=window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPZL.js', wpxxArr[0])+"：";
				num = wpxxArr[1].substring(0,7)+"."+wpxxArr[1].substring(7,10);
				while(num.indexOf(" ")!=-1){
					num = num.replace(" ","");
				}
				if(num.charAt(num.length-1)=="."){
					num = num.substring(0, num.length);
				}
				fkHtml += num+"克；";
			}
			
		}else{
			wpxxArr = wpxx.split("/");
			fkHtml +=window.top.getDictName(contextPath + '/common/dict/D_QBLD_DPZL.js', wpxxArr[0])+"：";
			num = wpxxArr[1].substring(0,7)+"."+wpxxArr[1].substring(7,10);
			while(num.indexOf(" ")!=-1){
				num = num.replace(" ","");
			}
			if(num.charAt(num.length-1)=="."){
				num = num.substring(0, num.length);
			}
			fkHtml += num+"克";
		}
		fkHtml +="</td></tr>" ;
	}
	
	
	fkHtml +="			<tr><td class='infoName'>处置经过描述</td><td class='infoValue' colspan=3>"+obj.czjgms+"</textarea></td></tr>"+
		"			<tr><td class='infoName'>立案侦查工作评估</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_CKYJLXZCGZDM.js', obj.lxzcgzpg)+"</td>" + 
		"				<td class='infoName'>目标从事职业类型</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYCSZYLX.js', obj.mbcszylx)+"</td></tr>" +
		"			<tr><td class='infoName'>工作评估依据</td><td class='infoValue' colspan=3>"+obj.lxzcgzpgyj+"</td></tr>" +
		"			<tr><td class='infoName'>处置反馈补充信息</td><td class='infoValue' colspan=3>"+obj.czfkbcxx+"</td></tr>" +
		
		"</table>";
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

