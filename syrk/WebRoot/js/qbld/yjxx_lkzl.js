if(typeof Yjxx =="undefined" || !Yjxx){
	Yjxx = {};
}
/**
 * @method:initLkzlQueryHtml
 * @package:syrk/js/qbld	
 * @description:初始化价值临控指令级别选择框
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午6:56:51
 */
Yjxx.initLkzlQueryHtml = function(type){
	Yjxx.type = type;
	var jbhtml = "<input type='checkbox' name='zljb' value='1' onclick='Yjxx.queryLkzlList();' checked/>一级"+
	"<input type='checkbox' name='zljb' value='2' onclick='Yjxx.queryLkzlList();' checked/>二级"+
	"<input type='checkbox' name='zljb' value='3' onclick='Yjxx.queryLkzlList();'' checked/>三级"
	$(".yjjbCheckBox").html(jbhtml);
	Yjxx.initLkzlSimpleQuery();
}
/**
 * @method:initLkzlSimpleQuery
 * @package:syrk/js/qbld	
 * @description:初始化加载临控指令级别简单查询
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午6:57:30
 */
Yjxx.initLkzlSimpleQuery = function(){
	var queryhtml  = '<div id="simpleQuery">'+
			'<div><input id="where_all"/></div>'+
			'<div><a href="#" id="simpleQueryButton" onclick="Yjxx.queryLkzlList();">查询</a>'+
			'<a href="#" id="toggleButton" onclick="Yjxx.initLkzlAdvancedQuery()"  >精确查询</a></div>'+
			'</div>';
	$("#queryDiv").html(queryhtml);
	$("#simpleQueryButton").linkbutton({
			iconCls:"icon-search"
	} ) 
	$("#toggleButton").linkbutton({
		plain:true
	} ) 
	$(window).resize();
	Yjxx.queryLkzlList();
}
/**
 * @method:initLkzlAdvancedQuery
 * @package:syrk/js/qbld	
 * @description:初始化加载临控指令级别简单查询
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午6:58:05
 */
Yjxx.initLkzlAdvancedQuery = function(){
	var queryhtml = '<div id="advancedQuery">'+
	'<table border=0>'+
	'<tr><td colspan=2 class="queryType"><a href="#" class="easyui-linkbutton" id="toggleButton" onclick="Yjxx.initLkyjSimpleQuery()" >模糊查询</a></td></tr>'+
	'<tr><td class="whereName">指令类型</td><td><input class="whereInput" id="where_lkzllx"></td></tr>'+
	'<tr><td class="whereName">申请单位</td><td><input id="where_sqdwjgdm" style="display:none"><input class="whereInput" id="where_sqdwjg" onclick="public_singleSelectOrg(\'\', \'01\', \'\', \'03,04\', \'where_sqdwjgdm\', \'where_sqdwjg\', \'\', false, false, \'\', window, \'\', \'\')"></td></tr>'+
	'<tr><td class="whereName">指令发布时间</td><td><input class="whereInput" id="where_zlfbsjB" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})" >-'+
	'	<input class="whereInput" id="where_zlfbsjE" onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyyMMddHHmmss\'})"></td></tr>'+
	'<tr><td colspan=2 class="queryButton"><a href="#" id="advancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.queryLkzlList();" >查询</a>'+
	'										<a href="#" id="clearAdvancedQueryButton" class="easyui-linkbutton" onclick="Yjxx.clearLkzlAdvancedQueryValue();" >重置</a></td></tr>'+
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
 * @method:clearLkzlAdvancedQueryValue
 * @package:syrk/js/qbld	
 * @description:清空高级查询条件
 * @author:Li_Zhenzhong
 * @date:2015-5-15上午10:40:28
 */
Yjxx.clearLkzlAdvancedQueryValue = function(){
	$("#where_sqdwjgdm").val("");
	$("#where_sqdwjg").val("");
	$("#where_lkzllx").combobox("setValue","");
	$("#where_zlfbsjB").val("");
	$("#where_zlfbsjE").val("");
}

/**
 * @method:queryLkzlList
 * @package:syrk/js/qbld	
 * @description:临控指令查询
 * @author:li_zhenzhong
 * @param total 总数
 * @param begin 开始记录序号
 * @param end 结束记录序号
 * @param page 当前页数
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午6:58:44
 */
Yjxx.queryLkzlList = function(total,begin,end,page){
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
	var url = contextPath+'/lkyjzl/queryLkyjzlList';
	var fajax = new FrameTools.Ajax(url,Yjxx.queryLkzlList_back);
	fajax.send(param);
};

/**
 * @method:queryLkzlList_back
 * @package:syrk/js/qbld	
 * @description:解析临空指令结果，并显示列表
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午7:00:22
 */
Yjxx.queryLkzlList_back = function(json){
	var  rsHtml = "<table class='listTable'>";
		rsHtml+="<tr class='countInfo'>" +
		"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>条预警信息</td>"+
		"</tr>";
	var rows = json.rows;
		num = rows.length
		for(var  i = 0;i<num;i++){
			var row = rows[i];
		rsHtml+="<tr class='infoOne_tr' onclick='Yjxx.clickListToChangeColor(this);Yjxx.initOtherDivShow();Yjxx.queryOneLkzlInfo(\""+row.lkzlbh+"\")'>";
		/**
	     * 显示预警信息颜色级别
	     */
		switch(parseInt(row.lkzljb)){//根据级别显示不同颜色
			case 1: rsHtml += "<td class='color1'></td>";break;
			case 2: rsHtml += "<td class='color2'></td>";break;
			case 3: rsHtml += "<td class='color3'></td>";break;
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
		rsHtml += "<tr class='fyTr'><td colspan=4 >"+Yjxx.showfy(json.total,json.rownum,json.page,"Yjxx.queryLkzlList")+"</td></tr>";
		rsHtml+="</table>";
	$("#InfoList").html(rsHtml);
	Yjxx.initChangeListColor();
};

/**
 * @method:queryOneLkzlInfo
 * @package:syrk/js/qbld	
 * @description:查询临控指令详情
 * @param lkzlbh
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午7:00:56
 */
Yjxx.queryOneLkzlInfo = function(lkzlbh){
	Yjxx.indexInfoObj = null;
	var url = contextPath+'/lkyjzl/queryLkyjzl';
	var fajax = new FrameTools.Ajax(url,Yjxx.showOneLkzlInfo);
	fajax.send({"lkzlbh":lkzlbh});
}

/**
 * @method:showOneLkzlInfo
 * @package:syrk/js/qbld	
 * @description:显示临控指令详情
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午7:03:19
 */
Yjxx.showOneLkzlInfo = function(json){
	if(json==null)
		json = Yjxx.indexInfoObj;
	if(Yjxx.indexInfoObj==null)
		Yjxx.indexInfoObj = json;
	else if(Yjxx.indexInfoObj != json ){
		$("#backButtonTd").html("<a href='#' id='backButton' onclick='Yjxx.showOneLkyjInfo()' >返回</a>")
	}else{
		$("#backButtonTd").html("");
	}
	$("#infoTitle").html("姓名："+json.bbkrxm);
	$("#opButtonTd").html("<a href='#' id='qsfkButton'></a>")
	$("#oneInfoDiv").height($(".infoTr").height()-5);
	$("#oneInfoDiv").html(Yjxx.buildLkzlInfoHtml(json));
	
   if(Yjxx.indexInfoObj == json ){
 	   	if(json.qsfkzt!=0){
	 	   	$("#qsfkButton").linkbutton({
				text:'反馈'
			} );
	    	$("#qsfkButton").click(Yjxx.showLkzlFkFrom);
 	   	}else{
	   		$("#qsfkButton").linkbutton({
				text:'签收'
			} );
	    	$("#qsfkButton").click(function(){Yjxx.lkzlQs();})
   		}
    }
}

/**
 * @method:buildLkzlInfoHtml
 * @package:syrk/js/qbld	
 * @description:创建临控指令详细信息
 * @param json
 * @returns {String}
 * @author:Li_Zhenzhong
 * @date:2015-5-8下午7:03:05
 */
Yjxx.buildLkzlInfoHtml = function(json){
	var  html = "<table class='infoOneTable'>" +
			"<tr><td class='infoTypeTd'>被<br>布<br>控<br>人</td>" +
			"	<td>" +
			"		<table class='infoBodyTable'>" +
			"			<tr><td class='infoName'>被布控人性别</td><td class='infoValue'>"+json.bbkrxb+"</td><td class='infoName'>被布控人出生日期</td><td class='infoValue'>"+json.bbkrcsrq+"</td>" +
					"<td id='imgTd' rowspan=6><img style='width:150px;height:185px;' src='"+contextPath + "/ckyj/queryQbldZpSingle.jpg?sfzh="+json.bbkrzjhm + "'></img></td></tr>" +
			"			<tr><td class='infoName'>被布控人证件类型</td><td class='infoValue'>"+json.bbkrzjlx+"</td><td class='infoName'>被布控人证件号码</td><td class='infoValue'> "+json.bbkrzjhm+"</td></tr>" +
			"			<tr><td class='infoName'>被布控人其它特征信息</td><td class='infoValue' colspan=4>"+json.bbkrqttzxx+"</td></tr>" +
			"			<tr><td class='infoName'>布控起始时间</td><td class='infoValue'>"+json.bkqssj+"</td><td class='infoName'>布控截止时间</td><td class='infoValue'> "+json.bkjzsj+"</td></tr>" +
			"			<tr><td class='infoName'>临控指令类型</td><td class='infoValue'>"+json.lkzllx+"</td><td class='infoName'>临控指令级别</td><td class='infoValue'> "+json.lkzljb+"</td></tr>" +
			"			<tr><td class='infoName'>申请人姓名</td><td class='infoValue'>"+json.sqrxm+"</td><td class='infoName'>申请人电话</td><td class='infoValue'> "+json.sqrlxdh+"</td></tr>" +
			"			<tr><td class='infoName'>申请单位</td><td class='infoValue' colspan=4>"+json.sqdw+"</td></tr>" +
			"			<tr><td class='infoName'>发布人姓名</td><td class='infoValue'>"+json.fbrxm+"</td><td class='infoName'>发布责任单位</td><td class='infoValue' colspan=2>"+json.fbzrdw+"</td></tr>" +
			"			<tr><td class='infoName'>指令发布时间</td><td class='infoValue' colspan=4>"+json.zlfbsj+"</td></tr>" +
			"			<tr><td class='infoName'>布控撤控事由</td><td class='infoValue' colspan=4>"+json.bxcksy+"</td></tr>" +
			"			<tr><td class='infoName'>签收时限</td><td class='infoValue'>"+json.fbrxm+"</td><td class='infoName'>首次处置反馈时限</td><td class='infoValue' colspan=2>"+json.fbzrdw+"</td></tr>" +
			"			<tr><td class='infoName'>处置措施</td><td class='infoValue' colspan=4>"+json.czcsyq+"</td></tr>" +
			"			<tr><td class='infoName'>执法依据</td><td class='infoValue' colspan=4>"+json.zfyj+"</td></tr>" +
			"			<tr><td class='infoName'>备注</td><td class='infoValue' colspan=4>"+json.bz+"</td></tr>" +
			"			<tr><td class='infoName'>签收人</td><td class='infoValue'>关联签收信息</td><td class='infoName'>签收时间</td><td class='infoValue' colspan=2>关联签收信息</td></tr>" +
			"			<tr><td class='infoName'>签收单位</td><td class='infoValue' colspan=4>关联签收信息</td></tr>" +
			"		</table>" +
			"	</td>" +
			"</tr>"+
			"</table>";
	return html;
};

Yjxx.lkzlQs = function(){
	var url = contextPath+'/lkyjzl/updateLkyjzlbAndSaveQsb	';
	var fajax = new FrameTools.Ajax(url,Yjxx.lkzlQs_back);
	fajax.send({"lkzlbh":Yjxx.indexInfoObj.lkzlbh});
};
Yjxx.lkzlQs_back = function(qsRs){
	if(qsRs.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"签收成功",
			time:3000,
			showType:'slide'
		})
		$("#qsfkButton").unbind("click");
		$("#qsfkButton").linkbutton({text:"反馈"});
		$("#qsfkButton").click(Yjxx.showLkzlFkFrom);
		Yjxx.QueryDyjCount();
	}
}
Yjxx.showLkzlFkFrom = function(){
	Yjxx.changeOtherDivShow();
	$("#otherInfoDiv").html("<div id='otherInfoListDiv'></div>");
	$("#otherInfoListDiv").tabs({
		width:'100%',
		height:'100%',
		border:false,
		height:$("#otherInfoDiv").height()
	});
	fkHtml = "<table class='addCzfkTable'>" +
	"			<tr><td class='infoName red'>处置经过描述</td><td class='infoValue' colspan=3><textarea id='czfk_czjgms' maxlength=200 placeholder='最多填写200个文字'></textarea></td></tr>" +
	"			<tr><td class='opButtonTd' colspan=4><a href='#' id='addCzfkButton' onclick='Yjxx.addLkzlCzfk();'>提交</a><a href='#' id='refButton'>清空</a></td></tr>" +
	"</table>";
	$("#otherInfoListDiv").tabs('add',{
		title:'反馈信息',
		content:fkHtml
	});
	$("#otherInfoListDiv").tabs('add',{
		title:'反馈记录',
		content:'<div id="fkjlListDiv">123</div>'
	});
	
	   $("#addCzfkButton").linkbutton({
		   iconCls:'icon-save'
	   } ) 
	   $("#refButton").linkbutton({
		iconCls:'icon-reload'
	   } )
	   
	   
	 $("#fxzt_wfx").click();
	 Yjxx.queryLkzlFkList();
	 $("#otherInfoListDiv").tabs('select',0);
}




/**
 * @method:addLkzlCzfk
 * @package:syrk/js/qbld	
 * @description:是增加临控预警反馈表
 * @author:Li_Zhenzhong
 * @date:2015-5-17下午6:17:42
 */
Yjxx.addLkzlCzfk = function(){
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
	var url = contextPath+'/lkyjzl/updateLkyjzlbAndSaveFkb';
	var fajax = new FrameTools.Ajax(url,Yjxx.addLkzlCzfk_back);
	fajax.send(param);
};
Yjxx.addLkzlCzfk_back = function(fkRs){
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
Yjxx.queryLkzlFkList = function(){
	$('#fkjlListDiv').datagrid({
		idField:'czfkxxbh',
		fit:true,
		fitColumns : true,
		pagination : true,
		singleSelect : true,
		showFooter:true,
		striped:true,
		rownumbers:true,
		url:contextPath+"/lkyjzl/queryLkyjzlFkList",
		queryParams:{"lkzlbh":Yjxx.indexInfoObj.lkzlbh},
		pageSize:10,
		columns:[[
	  		    {field:'fksj',title:'反馈时间',width:$('#otherInfoDiv').width()*.24,align:'center'},    
	  		    {field:'fkdw',title:'反馈单位',width:$('#otherInfoDiv').width()*.24,align:'center'},    
	  		    {field:'fkrxm',title:'反馈人',width:$('#otherInfoDiv').width()*.24,align:'center'},
	  		    {field:'czcsxl',title:'处置结果',width:$('#otherInfoDiv').width()*.24,align:'center'}
 	    ]],
 		onClickRow:function(index,row){
 			Yjxx.showMoreLkzlFkInfo(row);
		}
	});
}
Yjxx.showMoreLkzlFkInfo = function(obj){
	var fkHtml = "<table class='addCzfkTable'>"
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