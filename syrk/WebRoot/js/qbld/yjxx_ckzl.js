if(typeof Yjxx =="undefined" || !Yjxx){
	Yjxx = {};
}
/**
 * @title:initCkzlQueryHtml
 * @description:初始化价值常控预警级别选择框
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:05
 */
Yjxx.initCkzlQueryHtml = function(type){
	Yjxx.type = type;
	var jbhtml = "<input type='checkbox' name='zljb' onclick='Yjxx.queryCkzlList();' value='11' checked/>红色"+
	"<input type='checkbox' name='zljb' value='13' onclick='Yjxx.queryCkzlList();' checked/>黄色"+
	"<input type='checkbox' name='zljb' value='14' onclick='Yjxx.queryCkzlList();'  checked/>蓝色"
	$(".yjjbCheckBox").html(jbhtml);
	Yjxx.initCkzlSimpleQuery();
}
/**
 * @title:initCkzlSimpleQuery
 * @description:初始化加载预警指令级别简单查询
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:36
 */
Yjxx.initCkzlSimpleQuery = function(){
	var queryhtml  = '<div id="simpleQuery">'+
			'<div><input id="where_all" maxlength=200  placeholder="姓名或身份证号查询"/></div>'+
			'<div><a href="#" id="simpleQueryButton" onclick="Yjxx.queryCkzlList();">查询</a>'+
			'<a href="#" id="toggleButton" onclick="Yjxx.initCkzlAdvancedQuery()"  >精确查询</a></div>'+
			'</div>';
	$("#queryDiv").html(queryhtml);
	$("#simpleQueryButton").linkbutton({
			iconCls:"icon-search"
	} ) 
	$("#toggleButton").linkbutton({
		plain:true
	} ) 
	$(window).resize();
	Yjxx.queryCkzlList();
}
/**
 * @title:initCkzlAdvancedQuery
 * @description:初始化加载常控预警级别简单查询
 * @author:li_zhenzhong
 * @date:2015-4-24上午9:57:56
 */
Yjxx.initCkzlAdvancedQuery = function(){
	var queryhtml = '<div id="advancedQuery">'+
	'<table border=0>'+
	'<tr><td colspan=2 class="queryType"><a href="#" class="easyui-linkbutton" id="toggleButton" onclick="Yjxx.initCkzlSimpleQuery()" >模糊查询</a></td></tr>'+
	'<tr><td class="whereName">指令编号</td><td><input class="whereInput" id="where_yjzlbh" ></td></tr>'+
	'<tr><td class="whereName">指令标题</td><td><input class="whereInput" id="where_zlbt" maxlength=18></td></tr>'+
	'<tr><td class="whereName">指令发布时间</td><td><input class="whereInput" id="where_fbsjB" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" >-'+
	'											<input class="whereInput" id="where_fbsjE" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})"></td></tr>'+
	'<tr><td colspan=2 class="queryButton"><a href="#" id="advancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.queryCkzlList();" >查询</a>'+
	'										<a href="#" id="clearAdvancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.clearCkzlAdvancedQueryValue();" >重置</a></td></tr>'+
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
	$(window).resize();
}
/**
 * @method:clearCkzlAdvancedQueryValue
 * @package:syrk/js/qbld	
 * @description:清空常控指令
 * @author:Li_Zhenzhong
 * @date:2015-5-15上午10:43:23
 */
Yjxx.clearCkzlAdvancedQueryValue = function(){
	$("#where_yjzlbh").val("");
	$("#where_zlbt").val("");
	$("#where_fbsjB").combobox("setValue","");
	$("#where_fbsjE").val("");
}
/**
 * queryCkzlList
 * @description:常控预警指令查询
 * @author:li_zhenzhong
 * @param total 总数
 * @param begin 开始记录序号
 * @param end 结束记录序号
 * @param page 当前页数
 * @date:2015-4-21下午4:12:07
 */
Yjxx.queryCkzlList = function(total,begin,end,page){
	var checkObj = $(":checkBox");
	var num = checkObj.length
	var zljb = ""; 
	for(var i = 0;i<num;i++){
		if(checkObj[i].checked)
		zljb+=checkObj[i].value+",";
	}
	var param = "";
	if(document.getElementById("where_all")){
		var value = $("#where_all").val();
		var reg = new RegExp("^[0-9a-zA-Z]*$");
		var zlbt ="";
		var Ckzlbh = "";
		if(reg.test(value)){
			Ckzlbh = value
		}else{
			zlbt = value;
		}
		param = {"xfjsdw":userOrgCode,
				"zljb":zljb.substring(0, zljb.length-1),
				"qsfkzt":Yjxx.type,
				"zlbt":zlbt,
				"yjzlbh":Ckzlbh,
				"total":total,
				"rows":10,
				"begin":begin,
				"end":end,
				"page":page}
	 }else{
		 param = {"xfjsdw":userOrgCode,
					"zljb":zljb.substring(0, zljb.length-1),
					"qsfkzt":Yjxx.type,
					"zlbt":$("#where_zlbt").val(),
					"yjzlbh":$("#where_yjzlbh").val(),
					"fbsjB":$("#where_fbsjB").val(),
					"fbsjE":$("#where_fbsjE").val(),
					"total":total,
					"rows":10,
					"begin":begin,
					"end":end,
					"page":page}
	 }
	var url = contextPath+'/ckyjzl/queryCkyjzlList';
	var fajax = new FrameTools.Ajax(url,Yjxx.queryCkzlList_back);
	fajax.send(param);
};
/**
 * @title:queryCkzlList_back
 * @description:解析预警指令结果,并显示列表
 * @author:li_zhenzhong
 * @param json
 * @date:2015-4-20下午6:59:50
 */
Yjxx.queryCkzlList_back = function(json){
	var  rsHtml = "<table class='listTable'>";
	rsHtml+="<tr class='countInfo'>" +
	"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>条预警信息</td>"+
	"</tr>";
	var rows = json.rows;
	num = rows.length
	for(var  i = 0;i<num;i++){
		var row = rows[i];
	rsHtml+="<tr class='infoOne_tr' onclick='Yjxx.clickListToChangeColor(this);Yjxx.initOtherDivShow();Yjxx.queryOneCkzlInfo(\""+row.yjzlbh+"\");'>";
	/**
     * 显示预警信息颜色级别
     */
	switch(parseInt(row.zljb)){
		case 11: rsHtml += "<td class='color1'></td>";break;
		case 13: rsHtml += "<td class='color3'></td>";break;
		case 14: rsHtml += "<td class='color4'></td>";break;
		default:rsHtml += "<td class='color0'></td>";break;
	}
	rsHtml+= "<td class='infoBody' >"+"标题:"+ row.zlbt+"  <br> " +
					"指令编号:"+ row.yjzlbh+"<br>" +
					"发布时间:"+row.fbsj+"</div<td>";
	/**
	 * 显示预警信息签收反馈状态
	 */
	switch(parseInt(row.qsfkzt)){//row.b_state
		case 0: rsHtml += "<td class='infoState'>待签收<br>"+Yjxx.countTime(row.qssx)+"</td>";break;
		case 1: rsHtml += "<td class='infoState'>待反馈<br>"+Yjxx.countTime(row.fksx)+"</td>";break;
		case 2: rsHtml += "<td class='infoState'>已反馈</td>";break;
		default:rsHtml += "<td class='infoState'>本条数据状态错误</td>";break;
	}
	"</tr>" ;
	}
	rsHtml += "<tr class='fyTr'><td colspan=4 >"+Yjxx.showfy(json.total,json.rownum,json.page,"Yjxx.queryCkzlList")+"</td></tr>";
	rsHtml+="</table>";
$("#InfoList").html(rsHtml);
Yjxx.initChangeListColor();
};


/**
 * @title:queryOneCkzlInfo
 * @description:查询常控指令详情
 * @author:li_zhenzhong
 * @param guid
 * @date:2015-4-30上午10:41:26
 */
Yjxx.queryOneCkzlInfo = function(yjzlbh){
	Yjxx.indexInfoObj = null;
	var url = contextPath+'/ckyjzl/queryCkyjzl';
	var fajax = new FrameTools.Ajax(url,Yjxx.showOneCkzlInfo);
	fajax.send({"yjzlbh":yjzlbh});
}
/**
 * @title:showOneCkzlInfo
 * @description:显示预警指令详细信息
 * @author:li_zhenzhong
 * @param num
 * @date:2015-4-23上午9:21:49
 */
Yjxx.showOneCkzlInfo = function(json){
	if(json==null)
		json = Yjxx.indexInfoObj;
	if(Yjxx.indexInfoObj==null)
		Yjxx.indexInfoObj = json;
	else if(Yjxx.indexInfoObj != json ){
		$("#backButtonTd").html("<a href='#' id='backButton' onclick='Yjxx.showOneCkyjInfo()' >返回</a>")
	}else{
		$("#backButtonTd").html("");
	}
	$("#infoTitle").html("标题："+json.zlbt);
	$("#asInfoButton").html("<a href='#' id='lsListButton' onclick='Yjxx.queryOtherInfo(function(){Yjxx.queryCkzlList_yjxx(\""+json.yjxxbh+"\")})' ></a>")
	$("#opButtonTd").html("<a href='#' id='documentButton' onclick='window.open(\""+json.yjzlbh+"\")'></a> <a href='#' id='qsfkButton'></a>")
	$("#oneInfoDiv").height($(".infoTr").height()-5);
	$("#oneInfoDiv").html(Yjxx.buildCkzlInfoHtml(json));
	
	$("#documentButton").linkbutton({
		   text:'查看附件'
	   } )
    if(Yjxx.indexInfoObj == json ){
    	$("#lsListButton").linkbutton({
	   		text:'预警信息'
 	   	} ) 
 	   	if(json.qsfkzt!=0){
	 	   	$("#qsfkButton").linkbutton({
				text:'反馈'
			} );
	    	$("#qsfkButton").click(Yjxx.showCkzlFkFrom);
 	   	}else{
	   		$("#qsfkButton").linkbutton({
				text:'签收'
			} );
	    	$("#qsfkButton").click(function(){Yjxx.ckzlQs();})
   		}
    }
};
/**
 * @title:buildCkzlInfoHtml
 * @description:创建预警指令详细信息
 * @author:li_zhenzhong
 * @returns {String}
 * @date:2015-4-23上午9:20:31f
 */
Yjxx.buildCkzlInfoHtml = function(json){
	var  html = "<table class='infoBodyTable'>" +
			"			<tr><td class='infoName'>指令编号</td><td class='infoValue'>"+json.zlbt+"</td><td class='infoName'>级别</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYZLJB.js', json.zljb)+"</td></tr>" +
			"			<tr><td class='infoName'>指令发布单位</td><td class='infoValue'>"+json.zlfbdw_mc+"</td><td class='infoName'>指令发布人</td><td class='infoValue'>"+json.zlfbrxm+"</td></tr>" +
			"			<tr><td class='infoName'>指令发布时间</td><td class='infoValue'>"+json.fbsj+"</td><td class='infoName'>下发接受单位</td><td class='infoValue'>"+json.xfjsdw+"</td></tr>" +
			"			<tr><td class='infoName'>研判意见</td><td class='infoValue' colspan=3>"+json.ypyj+"</td></tr>" +
			"			<tr><td class='infoName'>研判结论</td><td class='infoValue' colspan=3>"+json.ypjl+"</td></tr>" +
			"			<tr><td class='infoName'>查控要求</td><td class='infoValue' colspan=3>"+json.ckyq+"</td></tr>" +
			"			<tr><td class='infoName'>签收时限</td><td class='infoValue'>"+json.qssx.substring(0,4)+"/"+json.qssx.substring(4,6)+"/"+json.qssx.substring(6,8)+" "+json.qssx.substring(8,10)+":"+json.qssx.substring(10,12)+":"+json.qssx.substring(12,14)+"</td>" +
			"				<td class='infoName'>反馈时限</td><td class='infoValue'>"+json.fksx.substring(0,4)+"/"+json.fksx.substring(4,6)+"/"+json.fksx.substring(6,8)+" "+json.fksx.substring(8,10)+":"+json.fksx.substring(10,12)+":"+json.fksx.substring(12,14)+"</td></tr>" +
			"</table>";
	return html;
}
/**
 * @method:queryCkzlList_yjxx
 * @package:syrk/js/qbld	
 * @description::查询指令关联预警信息
 * @param yjxxbh
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午2:35:46
 */
Yjxx.queryCkzlList_yjxx = function(yjxxbh){
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
		queryParams:{"yjxxbh":yjxxbh},
		pageSize:10,
		columns:[[
	  		    {field:'zdryxm',title:'人员姓名',width:100,align:'center'},    
	  		    {field:'sfzh',title:'证件号码',width:100,align:'center'},    
	  		    {field:'zdryxl',title:'人员类型',width:100,align:'center',
	  		    	formatter:function(value,rec){
	  		    		var zdryxl = "";
	  		    		if(value.indexOf(",")!=-1){
	  		    			var zdryArr = value.split(",");
	  		    			var num = zdryArr.length;
	  		    			for(var i=0;i<num;i++){
	  		    				zdryxl+= window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXL.js', zdryArr[i])+","
	  		    			}
	  		    			zdryxl = zdryxl.substring(0,zdryxl.length-1)
	  		    		}else{
	  		    			zdryxl = window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXL.js',value);
	  		    		}
	  		    		return zdryxl;
	  		    		}},
	  		    {field:'yjjsdw',title:'接收单位',width:100,align:'center'},
	  		    {field:'yjfbsj',title:'预警时间',width:100,align:'center'},     
	  		    {field:'qsfkzt',title:'当前状态',width:100,align:'center',formatter:function(value,rec){
	  		    	return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYQSZT.js', value)
	  		    	}
	  		    }
  	    ]],
  		onClickRow:function(index,row){
  			Yjxx.showOneCkyjInfoFromCkzl(row);
		}
	  	});
}
/**
 * @method:showOneCkyjInfoFromCkzl
 * @package:syrk/js/qbld	
 * @description:查看单条关联预警指令
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午2:39:13
 */
Yjxx.showOneCkyjInfoFromCkzl = function(json){
	if(json==null)
		json = Yjxx.indexInfoObj;
	if(Yjxx.indexInfoObj==null)
		Yjxx.indexInfoObj = json;
	else if(Yjxx.indexInfoObj != json ){
		$("#backButtonTd").html("<a href='#' id='backButton' onclick='Yjxx.showOneCkzlInfo()' >返回</a>");
	}else{
		$("#backButtonTd").html("");
	}
	$("#infoTitle").html("姓名："+json.zdryxm);
	$("#asInfoButton").html("");
	$("#opButtonTd").html("<a href='#' id='documentButton' onclick='window.open(\""+json.yjzlbh+"\")");
	$("#oneInfoDiv").height($(".infoTr").height()-5);
	$("#oneInfoDiv").html(Yjxx.buildCkyjInfoHtml(json));
	
	$("#documentButton").linkbutton({
		   text:'电子档案'
	   })
}
/**
 * @method:ckzlQs
 * @package:syrk/js/qbld	
 * @description:常控预警指令签收
 * @param yjzjbh
 * @author:Li_Zhenzhong
 * @date:2015-5-7下午5:18:56
 */
Yjxx.ckzlQs = function(){
	var url = contextPath+'/ckyjzl/updateCkyjzlbAndSaveQsb';
	var fajax = new FrameTools.Ajax(url,Yjxx.ckzlQs_back);
	fajax.send({"yjzlbh":Yjxx.indexInfoObj.yjzlbh});
};
/**
 * @method:ckzlQs_back
 * @package:syrk/js/qbld	
 * @description:签收成功后改变为待反馈状态
 * @param qsRs
 * @author:Li_Zhenzhong
 * @date:2015-5-7下午4:19:25
 */
Yjxx.ckzlQs_back = function(qsRs){
	if(qsRs.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"签收成功",
			time:3000,
			showType:'slide'
		})
		$("#qsfkButton").unbind("click");
		$("#qsfkButton").linkbutton({text:"反馈"});
		$("#qsfkButton").click(Yjxx.showCkzlFkFrom);
		Yjxx.QueryDyjCount();
	}
}
/**
 * @method:showCkzlFkFrom
 * @package:syrk/js/qbld	
 * @description:显示反馈表单
 * @author:Li_Zhenzhong
 * @date:2015-5-7下午4:19:34
 */
Yjxx.showCkzlFkFrom = function(){
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
	"				<div class ='fxzt' id='fxzt_yfx'  onclick='Yjxx.changeYjxxCzfkTypeHtml(1,this)'>已发现</div><input id='czfk_mbfxzt' style='display:none' value='0'></td></tr>" ;
	if(Yjxx.indexInfoObj.zljb == 11){
		fkHtml +="			<tr class='wfxTr'><td class='infoName red'>预警产生的原因</td><td  class='infoValue' colspan=3><input id='czfk_yjcsyy'></td></tr>" +
				"			<tr id='qtyyTr' ><td class='infoName red'>其他原因</td><td  class='infoValue' colspan=3><textarea id='czfk_qtyy' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" ;
	}
	fkHtml +="			<tr class='yfxTr'><td class='infoName red'>发现责任民警姓名</td><td   class='infoValue'><input id='czfk_fxmbzrmjxm' readonly placeholder='点击选择发现责任民警'  onclick='public_singleSelectOrgUser(\"\", \"\", \"\", \"\", \"\",\"\", \"czfk_fxmbzrmjsfzh\", \"czfk_fxmbzrmjxm\", \"\", \"czfk_fxmbzrdwjgdm\", \"czfk_fxmbzrdw\", \"\", false, \"\", window, \"\", \"\")' ></td>" +
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
			"								</td></tr>" ;
	if(Yjxx.indexInfoObj.zljb != 11){
		fkHtml +="			<tr class='yfxTr'><td class='infoName red'>活动目的：</td><td  class='infoValue' colspan=3><input id='czfk_hdmd'></td></tr>" +
				"			<tr class='yfxTr'><td class='infoName red'>通讯方式：</td><td  class='infoValue' colspan=3><input type='checkbox'  id='czfk_txfs_sf' style='width:20px;' onclick='Yjxx.changeShowType(this)' value='0'>有<input style='width:80%;display:none'  id='czfk_txfs' placeholder='请填写通讯方式' ></td></tr>" +
				"			<tr class='yfxTr'><td class='infoName red'>随身物品：</td><td  class='infoValue' colspan=3><input type='checkbox' id='czfk_sswp_sf' style='width:20px;' onclick='Yjxx.changeShowType(this)' value='0'>有<input style='width:80%;display:none'  id='czfk_sswp' placeholder='请填写随身物品' ></td></tr>" +
				"			<tr class='yfxTr'><td class='infoName red'>交通工具：</td><td  class='infoValue' colspan=3><input type='checkbox' id='czfk_jtgj_sf' style='width:20px;' onclick='Yjxx.changeShowType(this)' value='0'>有<input style='width:80%;display:none'  id='czfk_jtgj' placeholder='请填写交通工具' ></td></tr>" +
				"			<tr class='yfxTr'><td class='infoName red'>同行人员：</td><td  class='infoValue' colspan=3><input type='checkbox'  id='czfk_txryqk_sf' style='width:20px;' onclick='Yjxx.changeShowType(this)'value='0' >有<input style='width:80%;display:none'  id='czfk_txryqk' placeholder='请填写同行人员' ></td></tr>" ;
	}			
	
	fkHtml +="			<tr><td class='infoName red'>处置经过描述</td><td class='infoValue' colspan=3><textarea id='czfk_czjgms' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" +
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
		content:'<div id="fkjlListDiv"></div>'
	});
	if(Yjxx.indexInfoObj.zljb == 11){
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
	}
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
	if(Yjxx.indexInfoObj.zljb != 11){
		$("#czfk_hdmd").combobox({
			url: contextPath + '/common/dict/D_QBLD_HDMD.js',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:250
		})
	}
	
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
				}
				else{
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
  $("#otherInfoListDiv").tabs('select',0);
    $("#fxzt_wfx").click();
   Yjxx.queryCkzlFkList();
};
/**
 * @method:changeShowType
 * @package:syrk/js/qbld	
 * @description:改变反馈中显示文本输入框显示状态
 * @param obj
 * @author:Li_Zhenzhong
 * @date:2015-5-19上午9:08:43
 */
Yjxx.changeShowType = function(obj){
	if(obj.checked){
		$("#"+obj.id.replace("_sf","")).show();
		$(obj).val(1);
	}
	else {
		$(obj).val(0);
		$("#"+obj.id.replace("_sf","")).hide();
	}
	$("#"+obj.id.replace("_sf","")).val("");
}
/**
 * @method:addCkzlCzfk
 * @package:syrk/js/qbld	
 * @description:常控预警信息反馈
 * @author:Li_Zhenzhong
 * @date:2015-5-9下午5:19:57
 */
Yjxx.addCkzlCzfk = function(){
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
	param+="'yjzlbh':'"+Yjxx.indexInfoObj.yjzlbh+"'})";
	param = eval(param);
	var url = contextPath+'/ckyjzl/updateCkyjzlbAndSaveFkb';
	var fajax = new FrameTools.Ajax(url,Yjxx.addCkzlCzfk_back);
	fajax.send(param);
};
/**
 * @method:addCkzlCzfk_back
 * @package:syrk/js/qbld	
 * @description:反馈提交提示信息
 * @param fkRs
 * @author:Li_Zhenzhong
 * @date:2015-5-9下午5:23:26
 */
Yjxx.addCkzlCzfk_back = function(fkRs){
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
 * @method:queryCkzlFkList
 * @package:syrk/js/qbld	
 * @description:查询常控指令反馈列表
 * @param yjzlbh
 * @author:Li_Zhenzhong
 * @date:2015-5-7下午4:10:18
 */
Yjxx.queryCkzlFkList = function(){
	$('#fkjlListDiv').datagrid({
		idField:'czfkxxbh',
		fit:true,
		fitColumns : true,
		pagination : true,
		singleSelect : true,
		showFooter:true,
		striped:true,
		rownumbers:true,
		url:contextPath+"/ckyjzl/queryCkyjzlFkList",
		queryParams:{"yjzlbh":Yjxx.indexInfoObj.yjzlbh},
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


