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
	var jbhtml = "<div class='jbdiv1'><input type='checkbox' name='zljb' onclick='Yjxx.queryCkzlList();' value='11' checked/>红色</div>"+
	"<div class='jbdiv3'><input type='checkbox' name='zljb' value='13' onclick='Yjxx.queryCkzlList();' checked/>黄色</div>"+
	"<div class='jbdiv4'><input type='checkbox' name='zljb' value='14' onclick='Yjxx.queryCkzlList();'  checked/>蓝色</div>";
	$(".yjjbCheckBox").html(jbhtml);
	Yjxx.initCkzlSimpleQuery();
};
/**
 * @title:initCkzlSimpleQuery
 * @description:初始化加载临控预警级别简单查询
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
	} ) ;
	$("#toggleButton").linkbutton({
		plain:true
	} ) ;
	$(window).resize();
	Yjxx.queryCkzlList();
};
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
	'<tr><td class="whereName">指令发布时间</td><td><input class="whereInput" id="where_fbsjB" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" ><br>-'+
	'											<input class="whereInput" id="where_fbsjE" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})"></td></tr>'+
	'<tr><td colspan=2 class="queryButton"><a href="#" id="advancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.queryCkzlList();" >查询</a>'+
	'										<a href="#" id="clearAdvancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.clearCkzlAdvancedQueryValue();" >重置</a></td></tr>'+
	'</table></div>';
	$("#queryDiv").html(queryhtml);
	$("#advancedQueryButton").linkbutton({
		iconCls:"icon-search"
	} ) ;
	$("#clearAdvancedQueryButton").linkbutton({
		iconCls:"icon-reload"
	} ) ;
	$("#toggleButton").linkbutton({
		plain:true
	} ) ;
	$(window).resize();
};
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
};
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
	var num = checkObj.length;
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
			Ckzlbh = value;
		}else{
			zlbt = value;
		}
		param = {
				"zljb":zljb.substring(0, zljb.length-1),
				"qsfkzt":Yjxx.type,
				"zlbt":zlbt,
				"yjzlbh":Ckzlbh,
				"total":total,
				"rows":10,
				"begin":begin,
				"end":end,
				"page":page};
	 }else{
		 param = {
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
					"page":page};
	 }
	var url = contextPath+'/ckyjzl/queryCkyjzlList';
	var fajax = new FrameTools.Ajax(url,Yjxx.queryCkzlList_back);
	fajax.send(param);
	$(document.body).mask("努力加载中...");
};
/**
 * @title:queryCkzlList_back
 * @description:解析预警指令结果,并显示列表
 * @author:li_zhenzhong
 * @param json
 * @date:2015-4-20下午6:59:50
 */
Yjxx.queryCkzlList_back = function(json){
	$(document.body).unmask();
	var  rsHtml = "<table class='listTable'>";
	rsHtml+="<tr class='countInfo'>" +
	"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>条预警信息<a href='#' id='exportButton' class='easyui-linkbutton' onclick='Yjxx.exportCkzlList();' >导出</a></td>"+
	"</tr>";
	var rows = json.rows;
	num = rows.length;
	/**
	 * 循环显示查询记录
	 */
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
$("#exportButton").linkbutton({
	iconCls:"icon-xls",
		plain:true
} ) ;
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
	$(document.body).mask("努力加载中...");
};
/**
 * @title:showOneCkzlInfo
 * @description:显示预警指令详细信息
 * @author:li_zhenzhong
 * @param num
 * @date:2015-4-23上午9:21:49
 */
Yjxx.showOneCkzlInfo = function(json){
	$(document.body).unmask();
	/**
	 * 传入显示对象为空时，显示当前显示对象
	 */
	if(json==null)
		json = Yjxx.indexInfoObj;
	
	/**
	 * 当前显示对象为空时，赋值传入的对象
	 */
	if(Yjxx.indexInfoObj==null)
		Yjxx.indexInfoObj = json;
	else if(Yjxx.indexInfoObj != json ){//如果传入对于与当前显示对象不同，则显示返回按钮
		$("#backButtonTd").html("<a href='#' id='backButton' onclick='Yjxx.showOneCkyjInfo()' >返回</a>");
	}else{
		$("#backButtonTd").html("");
	}
	$("#infoTitle").html("标题："+json.zlbt);
	$("#asInfoButton").html("<a href='#' id='lsListButton' onclick='Yjxx.queryOtherInfo(function(){Yjxx.queryCkzlList_yjxx(\""+json.yjxxbh+"\")})' ></a>");
	$("#opButtonTd").html("<a href='#' id='documentButton' onclick='window.open(\""+json.yjzlbh+"\")'></a> <a href='#' id='qsfkButton'></a>");
	$("#oneInfoDiv").height($(".infoTr").height()-5);
	$("#oneInfoDiv").html(Yjxx.buildCkzlInfoHtml(json));
	
	$("#documentButton").linkbutton({
		   text:'查看附件'
	   } );
	   /**
	 *如果显示为当前显示对象，则显示查看预警信息记录按钮
	 */
    if(Yjxx.indexInfoObj == json ){
    	$("#lsListButton").linkbutton({
	   		text:'预警信息'
 	   	} ) ;
 	   	/**
 	   	 * 预警级别为红色时显示操作按钮，不等于0则显示反馈，否则显示签收
 	   	 */
 	   	if(json.qsfkzt!=0){
	 	   	$("#qsfkButton").linkbutton({
				text:'反馈'
			} );
	    	$("#qsfkButton").click(Yjxx.showCkzlFkFrom);
 	   	}else{
	   		$("#qsfkButton").linkbutton({
				text:'签收'
			} );
	    	$("#qsfkButton").click(function(){Yjxx.ckzlQs();});
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
			"			<tr><td class='infoName'>指令编号</td><td class='infoValue'>"+json.yjzlbh+"</td><td class='infoName'>级别</td><td class='infoValue'>"+window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYZLJB.js', json.zljb)+"</td></tr>" +
			"			<tr><td class='infoName'>指令发布单位</td><td class='infoValue'>"+json.zlfbdw_mc+"</td><td class='infoName'>指令发布人</td><td class='infoValue'>"+json.zlfbrxm+"</td></tr>" +
			"			<tr><td class='infoName'>指令发布时间</td><td class='infoValue'>"+json.fbsj+"</td><td class='infoName'>下发接收单位</td><td class='infoValue'>"+json.xfjsdw+"</td></tr>" +
			"			<tr><td class='infoName'>研判意见</td><td class='infoValue' colspan=3>"+json.ypyj+"</td></tr>" +
			"			<tr><td class='infoName'>研判结论</td><td class='infoValue' colspan=3>"+json.ypjl+"</td></tr>" +
			"			<tr><td class='infoName'>查控要求</td><td class='infoValue' colspan=3>"+json.ckyq+"</td></tr>" +
			"			<tr><td class='infoName'>签收时限</td><td class='infoValue'>"+json.qssx.substring(0,4)+"/"+json.qssx.substring(4,6)+"/"+json.qssx.substring(6,8)+" "+json.qssx.substring(8,10)+":"+json.qssx.substring(10,12)+":"+json.qssx.substring(12,14)+"</td>" +
			"				<td class='infoName'>反馈时限</td><td class='infoValue'>"+json.fksx.substring(0,4)+"/"+json.fksx.substring(4,6)+"/"+json.fksx.substring(6,8)+" "+json.fksx.substring(8,10)+":"+json.fksx.substring(10,12)+":"+json.fksx.substring(12,14)+"</td></tr>";
			/**
			 * 判断是否显示签收人信息
			 */
			if(json.qsrxm){
				html += 	"			<tr><td class='infoName'>签收人</td><td class='infoValue'>"+json.qsrxm+
					"				</td><td class='infoName'>签收时间</td><td class='infoValue'>"+json.qssj+"</td></tr>" +
					"			<tr><td class='infoName'>签收单位</td><td class='infoValue' colspan=3>"+json.qsdw_mc+"</td></tr>";
			}	
			html += "</table>";
	return html;
};
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
	  		    				zdryxl+= window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXL.js', zdryArr[i])+",";
	  		    			}
	  		    			zdryxl = zdryxl.substring(0,zdryxl.length-1);
	  		    		}else{
	  		    			zdryxl = window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYXL.js',value);
	  		    		}
	  		    		return zdryxl;
	  		    		}},
	  		    {field:'yjjsdw',title:'接收单位',width:100,align:'center'},
	  		    {field:'yjfbsj',title:'预警时间',width:100,align:'center'},     
	  		    {field:'qsfkzt',title:'当前状态',width:100,align:'center',formatter:function(value,rec){
	  		    	return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYQSZT.js', value);
	  		    	}
	  		    }
  	    ]],
  		onClickRow:function(index,row){
  			Yjxx.showOneCkyjInfoFromCkzl(row);
		}
	  	});
};
/**
 * @method:showOneCkyjInfoFromCkzl
 * @package:syrk/js/qbld	
 * @description:查看单条关联预警指令
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午2:39:13
 */
Yjxx.showOneCkyjInfoFromCkzl = function(json){
	/**
	 * 传入显示对象为空时，显示当前显示对象
	 */
	if(json==null)
		json = Yjxx.indexInfoObj;
	/**
	 * 当前显示对象为空时，赋值传入的对象
	 */
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
	   });
};
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
	$(document.body).mask("努力加载中...");
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
	$(document.body).unmask();
	/**
	 * 签收成功则显示反馈按钮
	 */
	if(qsRs.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"签收成功",
			time:3000,
			showType:'slide'
		});
		$("#qsfkButton").unbind("click");
		$("#qsfkButton").linkbutton({text:"反馈"});
		$("#qsfkButton").click(Yjxx.showCkzlFkFrom);
		Yjxx.QueryDyjCount();
		Yjxx.queryCkzlList();
	}
};
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
	"				<div class ='fxzt' id='fxzt_yfx'  onclick='Yjxx.changeYjxxCzfkTypeHtml(1,this);$(\"#qtyyTr\").hide();'>已发现</div><input id='czfk_mbfxzt' style='display:none' value='0'></td></tr>" ;
/**
 * 指令类型为红时显示原因信息
 */
	if(Yjxx.indexInfoObj.zljb == 11){
		fkHtml +="			<tr class='wfxTr'><td class='infoName red'>预警产生的原因</td><td  class='infoValue' colspan=3><input id='czfk_yjcsyy'></td></tr>" +
				"			<tr id='qtyyTr'  style='display:none'><td class='infoName red'>其他原因</td><td  class='infoValue' colspan=3><textarea class='notNull' id='czfk_qtyy' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" ;
	}
	fkHtml +="			<tr class='yfxTr'><td class='infoName red'>发现责任民警姓名</td><td   class='infoValue'><input id='czfk_fxmbzrmjxm' class='notNull' readonly placeholder='点击选择发现责任民警'  onclick='public_singleSelectOrgUser(\"\", \"\", \"\", \"\", \"\",\"\", \"czfk_fxmbzrmjsfzh\", \"czfk_fxmbzrmjxm\", \"\", \"czfk_fxmbzrdwjgdm\", \"czfk_fxmbzrdw\", \"\", false, \"\", window, \"\", \"\")' ></td>" +
			"							<td class='infoName red'>发现责任民警身份证号</td><td class='infoValue'><input id='czfk_fxmbzrmjsfzh'class='notNull' placeholder='自动填写' readonly></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>发现责任单位</td><td   class='infoValue' colspan=3><input id='czfk_fxmbzrdw' class='notNull' placeholder='自动填写' readonly><input id='czfk_fxmbzrdwjgdm' style='display:none' ></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>处置责任民警姓名</td><td   class='infoValue'><input id='czfk_czzrmjxm' class='notNull'  readonly placeholder='点击选择处置责任民警' onclick='public_singleSelectOrgUser(\"\", \"\", \"\", \"\", \"\",\"\", \"czfk_czzrmjsfzh\", \"czfk_czzrmjxm\", \"\", \"czfk_czzrdwjgdm\", \"czfk_czzrdw\", \"\", false, \"\", window, \"\", \"\")'></td>" +
			"							<td class='infoName red'>处置责任民警身份证号</td><td class='infoValue'><input id='czfk_czzrmjsfzh' class='notNull'  readonly placeholder='自动填写'></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>处置责任单位</td><td   class='infoValue' colspan=3><input id='czfk_czzrdw' class='notNull'  readonly placeholder='自动填写'><input id='czfk_czzrdwjgdm' style='display:none' ></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>处置时间</td><td  class='infoValue'><input id='czfk_czsj' class='notNull'  onclick='WdatePicker({skin:\"whyGreen\",dateFmt:\"yyyyMMddHHmmss\"})'></td>" +
			"							<td class='infoName red'>处置地点区划</td><td class='infoValue'><input id='czfk_czddqh' class='notNull'  value='510104,510106'></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>处置地点祥址</td><td   class='infoValue' colspan=3><input class='notNull'  id='czfk_czddxz' ></td></tr>" +
			"			<tr class='yfxTr'><td class='infoName red'>采取处置措施</td><td   class='infoValue'><input id='czfk_cqczcs' class='notNull'  ></td>" +
			"							<td class='infoName red'>处置结果/细类</td><td class='infoValue'><input id='czfk_czjg'  class='notNull' ><input id='czfk_czcsxl'  class='notNull' style='display:none'><input id='czfk_zbxl' class='notNull'  style='display:none'></td></tr>" +
			"			<tr style='display:none' id='wzhyyTr'><td class='infoName red'>未抓获原因</td><td class='infoValue' colspan=3><textarea id='czfk_wzhyy' class='notNull'  maxlength=200 placeholder='最多填写200个文字'></textarea></td>" +
			"			<tr style='display:none' id='xcxxcjTr'><td class='infoName'>现场信息采集</td><td class='infoValue' colspan=3><textarea id='czfk_xcxxcj' maxlength=200 placeholder='最多填写200个文字'></textarea></td>" +
			"			<tr class='yfxTr'><td class='infoName'>吸毒查获尿检信息</td><td class='infoValue' colspan=3>毒品种类：<input id='czfk_nj_dpzl' style='width:150px'>尿检结果：<input id='czfk_nj_njjg' style='width:150px'><a href='#' id='add_njxx' onclick='Yjxx.addCkyj_njxx();'>添加</a>" +
			"								<table id='czfk_xdchnjxxDiv'><tr><td class='dpInfoName'>毒品种类</td><td class='dpInfoName'>尿检结果</td></tr></table>" +
			"								<input id='czfk_xdchnjxx' style='display:none'>" +
			"								</td></tr>" +
			"			<tr class='yfxTr'><td class='infoName'>现场查获物品信息</td><td class='infoValue' colspan=3>毒品种类：<input id='czfk_wp_dpzl' style='width:150px'>缴获数量（克）：<input id='czfk_wp_jhsl' style='width:150px'><a href='#' id='add_wpxx' onclick='Yjxx.addCkyj_wpxx();'>添加</a>" +
			"								<table id='czfk_xcchwpxxDiv'><tr><td class='dpInfoName'>毒品种类</td><td class='dpInfoName'>缴获数量（克）</td></tr></table>" +
			"								<input id='czfk_xcchwpxx' style='display:none'>" +
			"								</td></tr>" ;
	/**
	 * 指令类型不为红时显示交通情况
	 */
	if(Yjxx.indexInfoObj.zljb != 11){
		fkHtml +="			<tr class='yfxTr'><td class='infoName red'>活动目的：</td><td  class='infoValue' colspan=3><input id='czfk_hdmd'  class='notNull' ></td></tr>" +
				"			<tr class='yfxTr'><td class='infoName red'>通讯方式：</td><td  class='infoValue' colspan=3><input type='checkbox'   id='czfk_txfs_sf' style='width:20px;' onclick='Yjxx.changeShowType(this)' >有<input style='width:80%;display:none'  class='notNull' id='czfk_txfs' placeholder='请填写通讯方式' ></td></tr>" +
				"			<tr class='yfxTr'><td class='infoName red'>随身物品：</td><td  class='infoValue' colspan=3><input type='checkbox'   id='czfk_sswp_sf' style='width:20px;' onclick='Yjxx.changeShowType(this)' >有<input style='width:80%;display:none'  class='notNull' id='czfk_sswp' placeholder='请填写随身物品' ></td></tr>" +
				"			<tr class='yfxTr'><td class='infoName red'>交通工具：</td><td  class='infoValue' colspan=3><input type='checkbox'   id='czfk_jtgj_sf' style='width:20px;' onclick='Yjxx.changeShowType(this)' >有<input style='width:80%;display:none'  class='notNull' id='czfk_jtgj' placeholder='请填写交通工具' ></td></tr>" +
				"			<tr class='yfxTr'><td class='infoName red'>同行人员：</td><td  class='infoValue' colspan=3><input type='checkbox'   id='czfk_txryqk_sf' style='width:20px;' onclick='Yjxx.changeShowType(this)' >有<input style='width:80%;display:none'  class='notNull' id='czfk_txryqk' placeholder='请填写同行人员' ></td></tr>" ;
	}			
	
	fkHtml +="			<tr><td class='infoName red'>处置经过描述</td><td class='infoValue' colspan=3><textarea id='czfk_czjgms' class='notNull'  maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" +
	"			<tr><td class='infoName'>立案侦查工作评估</td><td class='infoValue'><input id='czfk_lxzcgzpg' ></td>" +
	"				<td class='infoName'>目标从事职业类型</td><td class='infoValue'><input id='czfk_mbcszylx' ></td></tr>" +
	"			<tr><td class='infoName'>工作评估依据</td><td class='infoValue' colspan=3><textarea id='czfk_lxzcgzpgyj' maxlength=450 placeholder='最多填写450个文字'></textarea></td></tr>" +
	"			<tr><td class='infoName'>处置反馈补充信息</td><td class='infoValue' colspan=3><textarea id='czfk_czfkbcxx' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" +
	"			<tr><td class='opButtonTd' colspan=4><a href='#' id='addCzfkButton' onclick='Yjxx.addCkzlCzfk();'>提交</a><a href='#' id='refButton'>清空</a></td></tr>" +
	"</table>";
	$("#otherInfoListDiv").tabs('add',{
		title:'反馈信息',
		content:fkHtml
	});
	$("#czfk_txfs_sf").val(0);
	$("#czfk_sswp_sf").val(0);
	$("#czfk_jtgj_sf").val(0);
	$("#czfk_txryqk_sf").val(0);
	
	$("#otherInfoListDiv").tabs('add',{
		title:'反馈记录',
		content:'<div id="fkjlListDiv"></div>'
	});
	/**
	 * 指令类型为红时显示预警原因
	 */
	if(Yjxx.indexInfoObj.zljb == 11){
		$("#czfk_yjcsyy").combobox({
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
			},
			onShowPanel:function(){
				if(this.flag){
					return;
				}else{
					this.flag = true;
					$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_YJYY.js'); 
				}
			}
		});
	}
	/**
	 *评估状态为50或70时，需要填写职业类型
	 */
	initMbcszylxSelect = function(newVal){
		if(newVal==50||newVal==70){
			$("#czfk_mbcszylx").combobox('enable');
		}else{
			if($("#czfk_mbcszylx").val()!=""){
				$("#czfk_mbcszylx").combobox("clear");
			}
			$("#czfk_mbcszylx").combobox('disable');
		}
		
	};
	$("#czfk_mbcszylx").combobox({
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:250,
		onShowPanel:function(){
			if(this.flag){
				return;
			}else{
				this.flag = true;
				$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_ZDRYCSZYLX.js'); 
			}
		}
	});
	$("#czfk_lxzcgzpg").combobox({
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:250,
		onChange:initMbcszylxSelect,
		onShowPanel:function(){
			if(this.flag){
				return;
			}else{
				this.flag = true;
				$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_CKYJLXZCGZDM.js'); 
			}
		}
	});
	if(Yjxx.indexInfoObj.zljb != 11){
		$("#czfk_hdmd").combobox({
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:250,
			onShowPanel:function(){
				if(this.flag){
					return;
				}else{
					this.flag = true;
					$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_HDMD.js'); 
				}
			}
		});
	}
	
	$("#czfk_czddqh").combotree({
		onlyLeaf:true,
		multiple:false,
		panelWidth:320,
		method:'get',
		editable:true,
		lines:true,
		onSelect:function(obj){
			$("#czfk_czddxz").val(obj.text);
			},
			onShowPanel:function(){
				if(this.flag){
					return;
				}else{
					this.flag = true;
					$(this).combotree('reload',  contextPath + '/common/dict/D_BZ_XZQH_MUNICIPAL.js'); 
				}
			}
	});
	
	
	
	$("#czfk_nj_dpzl").combobox({
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200,
		onShowPanel:function(){
			if(this.flag){
				return;
			}else{
				this.flag = true;
				$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_ZDRYCSZYLX.js'); 
			}
		}
	});
	$("#czfk_nj_dpzl").combobox({
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200,
		onShowPanel:function(){
			if(this.flag){
				return;
			}else{
				this.flag = true;
				$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_DPZL.js'); 
			}
		}
	});
	$("#czfk_wp_dpzl").combobox({
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200,
		onShowPanel:function(){
			if(this.flag){
				return;
			}else{
				this.flag = true;
				$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_DPZL.js'); 
			}
		}
	});
	$("#czfk_nj_njjg").combobox({
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200,
		onShowPanel:function(){
			if(this.flag){
				return;
			}else{
				this.flag = true;
				$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_ZDRYXDNJJGDM.js'); 
			}
		}
	});
	$("#czfk_zbxl").combobox({
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:150,
		onShowPanel:function(){
			if(this.flag){
				return;
			}else{
				this.flag = true;
				$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_GKZHXL.js'); 
			}
		}
	});
	/**
	 * 初始化处置结果下拉框
	 */
	initCzjgSelect = function(val){
		$("#czfk_czjg").combobox({
			dataFilter:val+'[^0]',
			valueField:'id',
			textField:'text',
			selectOnNavigation:false,
			method:'get',
			tipPosition:'left',
			width:100,
			onChange:function(val){
				/**
				 * 判断处置类型为未抓获时显示未抓获原因和现场采集属性
				 */
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
				/**
				 * 判断处置类型为已抓获时抓捕细类属性
				 */
				if(val==12){
					$("#czfk_zbxl").next('.combo').show();
				}else{
					$("#czfk_zbxl").next('.combo').hide();
					$("#czfk_zbxl").combobox("setValue","");
				}
			},
			onShowPanel:function(){
				if(this.flag){
					return;
				}else{
					this.flag = true;
					$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_ZDRYYJCZJGLX.js'); 
				}
			}
		});
		/**
		 * 处置场所细类
		 */
		if(val==2){
			$("#czfk_czcsxl").next('.combo').show();
			
		}else{
			$("#czfk_czcsxl").next('.combo').hide();
		}
	};
	$("#czfk_cqczcs").combobox({
		url:contextPath + '/common/dict/D_QBLD_ZDRYCZCSLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:250,
		onChange:initCzjgSelect
	});
	$("#czfk_czcsxl").combobox({
				dataFilter:'.{3}',
				valueField:'id',
				textField:'text',
				selectOnNavigation:false,
				method:'get',
				tipPosition:'left',
				width:150,
				onShowPanel:function(){
					if(this.flag){
						return;
					}else{
						this.flag = true;
						$(this).combobox('reload',  contextPath + '/common/dict/D_QBLD_ZDRYGKCSLX.js'); 
					}
				}
		});
	$("#czfk_czcsxl").next('.combo').hide();
	
   $("#add_njxx").linkbutton({
	   iconCls:'icon-add'
   } ) ;
    $("#add_wpxx").linkbutton({
	   iconCls:'icon-add'
   } ) ;
   
   $("#addCzfkButton").linkbutton({
	   iconCls:'icon-save'
   } ) ;
   $("#refButton").linkbutton({
	iconCls:'icon-reload'
   } );
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
};
/**
 * @method:addCkzlCzfk
 * @package:syrk/js/qbld	
 * @description:常控预警信息反馈
 * @author:Li_Zhenzhong
 * @date:2015-5-9下午5:19:57
 */
Yjxx.addCkzlCzfk = function(){
	var inputObjs = $(".addCzfkTable .notNull ");
	var num = inputObjs.length;
	var flag = false;//验证通过未false；不通过未true
	for(var i = 0;i<num;i++){
		if($(inputObjs[i]).val()==""){
			/**
			 * 反馈发现目标和未发现对不同的字段验证
			 */
			if($("#czfk_mbfxzt").val()==0){
				if("czfk_yjcsyy,czfk_qtyy,czfk_czjgms,".indexOf(inputObjs[i].id+",")!=-1){
					switch(inputObjs[i].id){
						case 'czfk_yjcsyy':Yjxx.indexInfoObj.zljb==1&&(flag=true);break; //当临控预警级别为“红色”时，预警产生原因不能为空。
						case 'czfk_qtyy':$("#czfk_yjcsyy").val()==9&&(flag=true);break;//当预警产生原因为“其他原因”时，其他原因不能为空
						default:flag=true;
					}
				}
			}else if("czfk_yjcsyy,czfk_qtyy,".indexOf(inputObjs[i].id+",")==-1){
				switch(inputObjs[i].id){
					case 'czfk_wzhyy':$("#czfk_czjg").val()==11&&(flag=true);break;//当处置结果为“未抓获”时，未抓获原因不能为空
					case 'czfk_zbxl':$("#czfk_czjg").val()==12&&(flag=true);break;//当处置结果为“已抓捕”时，抓捕细类不能为空
					case 'czfk_czcsxl':$("#czfk_cqczcs").val()==2&&(flag=true);break;//当处置结果为“管控”时，处置措施细类不能为空
					case 'czfk_txfs':$("#czfk_txfs_sf").val()==1&&(flag=true);break;//当通讯方式为“有”时，通选方式需要填写
					case 'czfk_jtgj':$("#czfk_jtgj_sf").val()==1&&(flag=true);break;//当交通工具为“有”时，交通工具需要填写
					case 'czfk_sswp':$("#czfk_sswp_sf").val()==1&&(flag=true);break;//当随身物品为“有”时，随身物品需要填写
					case 'czfk_txryqk':$("#czfk_txryqk_sf").val()==1&&(flag=true);break;//当同行人员为“有”时，同行人员需要填写
					default:flag=true;//其他字段不能为空
				}
			}
			if(flag){
				$.messager.alert("提示","红色标题信息必须填写！");
				return;
			}
		}
	}
	var param;
	/**
	 * 获取表单内容,并拼成JSON对象
	 */
	var inputObjs = $(".addCzfkTable input");
	var length = inputObjs.length;
	var param = "({";
	for(var i = 0; i < length ; i++){
		var obj = inputObjs[i];
		if(obj.id&&obj.id.indexOf("czfk_")!=-1&&$(obj).val()!=""){
			param +="'"+obj.id.replace("czfk_","")+"':'"+ $(obj).val()+"',";
		}
	}
	var textObjs = $(".addCzfkTable textarea");
	length = textObjs.length;
	for(var i = 0; i < length ; i++){
		var obj = textObjs[i];
		if(obj.id.indexOf("czfk_")!=-1&&$(obj).val()!="")
			param +="'"+obj.id.replace("czfk_","")+"':'"+ $(obj).val()+"',";
	}
	param+="'yjzlbh':'"+Yjxx.indexInfoObj.yjzlbh+"'})";
	param = eval(param);
	var url = contextPath+'/ckyjzl/updateCkyjzlbAndSaveFkb';
	$.messager.confirm('确认对话框', '您是否确定要提交数据？', function(r){
		if (r){
			var fajax = new FrameTools.Ajax(url,Yjxx.addCkzlCzfk_back);
			fajax.send(param);
			$(document.body).mask("努力加载中...");
		}
	});
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
	$(document.body).unmask();
	if(fkRs.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"反馈提交成功",
			time:3000,
			showType:'slide'
		});
		$("#fxzt_wfx").click();
		$('#fkjlListDiv').datagrid('reload');
		Yjxx.QueryDyjCount();
		Yjxx.queryCkzlList();
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
	  		    	formatter:function(value,rec){return window.top.getDictName(contextPath + '/common/dict/D_QBLD_ZDRYYJCZJGLX.js', value);}}
 	    ]],
 		onClickRow:function(index,row){
 			Yjxx.showMoreFkInfo(row);
 		}
	});
	
};


/**
 * @method:exportCkzlList
 * @package:syrk/js/qbld	
 * @description:导出记录
 * @author:Li_Zhenzhong
 * @date:2015-7-7下午5:17:59
 */
Yjxx.exportCkzlList = function(){
	var checkObj = $(":checkBox");
	var num = checkObj.length;
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
			Ckzlbh = value;
		}else{
			zlbt = value;
		}
		param = "zljb="+zljb.substring(0, zljb.length-1)+
				"&qsfkzt="+Yjxx.type+
				"&zlbt="+zlbt+
				"&yjzlbh="+Ckzlbh;
	 }else{
		 param = "zljb="+zljb.substring(0, zljb.length-1)+
			"&qsfkzt="+Yjxx.type+
			"&zlbt="+$("#where_zlbt").val()+
			"&yjzlbh="+$("#where_yjzlbh").val()+
			"&fbsjB="+$("#where_fbsjB").val()+
			"&fbsjE="+$("#where_fbsjE").val();
	 }
	var url=contextPath +"/ckyjzl/ckyjzlxxb_export?"+param;
	window.open(url);
};