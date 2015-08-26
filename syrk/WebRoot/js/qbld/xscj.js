if(typeof Xscj =="undefined" || !Xscj){
	Xscj = {};
}
Xscj.listObj;//线索查询结果集合

/**
 * @method:initQueryHtml
 * @package:syrk/js/qbld	
 * @description:初始化线索
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:32:57
 */
Xscj.initQueryHtml = function(){

	$("#where_xsly").combobox({
		url: contextPath + '/common/dict/D_QBLD_XSCJLY.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:200
	});
	var inputObjs = $(".infoOneTable :input");
	var num = inputObjs.length;
	/**
	 * 将所有收入框设置为不可编辑状态
	 */
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",true);
	}
};

/**
 * @method:queryXscjList
 * @package:syrk/js/qbld	
 * @description:查询线索记录
 * @param total
 * @param begin
 * @param end
 * @param page
 * @author:Li_Zhenzhong
 * @date:2015-5-11上午10:57:26
 */
Xscj.queryXscjList = function(total,begin,end,page){
	var checkObj = $("#queryFrom :checkBox");
	var num = checkObj.length;
	var jjcd = ""; 
	for(var i = 0;i<num;i++){
		if(checkObj[i].checked)
			jjcd+=checkObj[i].value+",";
	}
	var param = { 
					"bt":$("#where_bt").val(),
					"xsly":$("#where_xsly").val(),
					"jjcd":jjcd.substring(0, jjcd.length-1),
					"bssjB":$("#where_bssjB").val(),
					"bssjE":$("#where_bssjE").val(),
					"total":total,
					"rownum":10,
					"begin":begin,
					"end":end,
					"page":page};
	var url = contextPath+'/xs/queryXsList';
	var fajax = new FrameTools.Ajax(url,Xscj.queryXscjList_back);
	fajax.send(param);
	$(document.body).mask("努力加载中...");
};
/**
 * @method:queryXscjList_back
 * @package:syrk/js/qbld	
 * @description:生成线索列表
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-11上午10:57:52
 */
Xscj.queryXscjList_back = function(json){
	$(document.body).unmask();
	Xscj.listObj = json.rows;
	var num = Xscj.listObj.length;
	var  rsHtml = "<table class='listTable'>"+
		"<tr class='countInfo'>" +
		"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>条线索信息</td>"+
		"</tr>";
	
	for(var  i = 0;i<num;i++){
		var row = Xscj.listObj[i];
		rsHtml+="<tr class='infoOne_tr' onclick='Main.clickListToChangeColor(this);Xscj.queryOneXscjInfo("+i+")'>";
		switch(parseInt(row.jjcd)){//根据级别显示不同颜色
		case 1: rsHtml += "<td class='color4'></td>";break;
		case 4: rsHtml += "<td class='color3'></td>";break;
		case 8: rsHtml += "<td class='color1'></td>";break;
		default:rsHtml += "<td class='color0'></td>";break;
		}
		
		rsHtml+="<td class='infoBody' onclick=''>"+"标题:"+ row.bt+"  <br> " +
						"线索来源:"+ window.top.getDictName(contextPath + '/common/dict/D_QBLD_XSCJLY.js', row.xsly)+"<br>" +
						"报送时间:"+row.bssj.substring(0,4)+"/"+row.bssj.substring(4,6)+"/"+row.bssj.substring(6,8)+" "+row.bssj.substring(8,10)+":"+row.bssj.substring(10,12)+":"+row.bssj.substring(12,14)+"</div></td>"+
				"</tr>" ;
		}
	rsHtml += "<tr class='fyTr'><td colspan=4 >"+Yjxx.showfy(json.total,json.rownum,json.page,"Xscj.queryXscjList")+"</td></tr>";
		rsHtml+="</table>";
	$("#InfoList").html(rsHtml);
	Main.initChangeListColor();
};
/**
 * @method:queryOneXscjInfo
 * @package:syrk/js/qbld	
 * @description:查询单条线索信息
 * @param index
 * @author:Li_Zhenzhong
 * @date:2015-5-13上午10:31:02
 */
Xscj.queryOneXscjInfo = function(index){
	Xscj.infoFromReset();
	var obj = Xscj.listObj[index];
	for(key in obj){
		var val = obj[key];
		if(val!=""&&val!=null){
			/**
			 * 对字典项进行翻译，并显示关联字段
			 */
			switch(key){
			case 'xsly':val=window.top.getDictName(contextPath + '/common/dict/D_QBLD_XSCJLY.js', val);break;
			case 'sfyfs':val=val==1?"是":"否";if(val=="是"){$("#fssj_tr").show();};break;
			case 'sfxb':val=val==1?"是":"否";if(val=="是"){$("#sbxx_tr").show();};break;
			case 'jjcd':val=window.top.getDictName(contextPath + '/common/dict/D_QBLD_XSCJJJCD.js', val);break;
			default:break;
			}
			/**
			 * 将14位时间格式转化为易读的标准格式
			 */
			if('b_assj_ks,b_assj_js,'.indexOf(key)!=-1){
				val = val.substring(0,4)+"/"+val.substring(4,6)+"/"+val.substring(6,8)+" "+val.substring(8,10)+":"+val.substring(10,12)+":"+val.substring(12,14) ;
			}
		}
		/**
		 * 部分字段显示文本，部分字段显示下拉框
		 */
		if('jjcd,sfyfs,sfxb,xsly'.indexOf(key)!=-1){
			$("#"+key+"_td").html(val);
		}else
		$("#xscj_"+key).val(val);
	}
	var inputObjs = $(".infoOneTable :input");
	var num = inputObjs.length;
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",true);
			$("#optr").hide();
	}
};
/**
 * @method:initAddXscjHtml
 * @package:syrk/js/qbld	
 * @description:初始化线索表
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:59:48
 */
Xscj.initAddXscjHtml = function(){
	var html = '<input id="xscj_jjcd" name="jjcd"  class="notNull">';
	$("#jjcd_td").html(html);
	$("#xscj_jjcd").combobox({
		url: contextPath + '/common/dict/D_QBLD_XSCJJJCD.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	
	html="<input type='checkbox' style='width:15px;height:15px;' id='sfyfs_checkbox' onclick='Xscj.toggleSfyfs(this);'>是";
	$("#sfyfs_td").html(html);
	html="<input type='checkbox' style='width:15px;height:15px;' id='sfxb_checkbox' onclick='Xscj.toggleSfxb(this);'>是";
	$("#sfxb_td").html(html);
	
	html='<input id="xscj_xsly" name="xsly"  class="notNull">';
	$("#xsly_td").html(html);
	$("#xscj_xsly").combobox({
		url: contextPath + '/common/dict/D_QBLD_XSCJLY.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	var inputObjs = $(".infoOneTable :input");
	var num = inputObjs.length;
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",false);
	}
	Xscj.infoFromReset();
	$("#optr").show();
	$("#xscj_cjdwmc").val(userOrgName);
	$("#xscj_cjr").val(userName);
};
/**
 * @method:toggleSfyfs
 * @package:syrk/js/qbld	
 * @description:根据是否已发生状态显示不同信息
 * @param obj
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午11:34:09
 */
Xscj.toggleSfyfs = function(obj){
	if(obj.checked){
		$("#fssj_tr").show();
		$("#xscj_sfyfs").val(1);
	}else{
		$("#fssj_tr").hide();
		$("#xscj_sfyfs").val(0);
		$("#xscj_xbyjlid").val("");
		$("#xscj_xbyjlbt").val("");
		$("#xscj_b_assj_ks").val("");
		$("#xscj_b_assj_js").val("");
	}
};
/**
 * @method:toggleSfyfs
 * @package:syrk/js/qbld	
 * @description:根据是否续报状态显示不同信息
 * @param obj
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午11:34:09
 */
Xscj.toggleSfxb = function(obj){
	if(obj.checked){
		$("#sbxx_tr").show();
		$("#xscj_sfxb").val(1);
	}else{
		$("#sbxx_tr").hide();
		$("#xscj_sfxb").val(0);
		$("#xscj_b_assj_js").val("");
	}
};
/**
 * @method:addXscjInfo
 * @package:syrk/js/qbld	
 * @description:添加线索
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:34:06
 */
Xscj.addXscjInfo = function(){
	var inputObjs = $(".infoOneTable .notNull ");
	var num = inputObjs.length;
	for(var i = 0;i<num;i++){
		/**
		 * 当是否续保为状态为1时，预警id和标题字段值必须填写
		 */
		if(inputObjs[i].id=="xscj_xbyjlid"||inputObjs[i].id=="xscj_bt"){
			if($("#xscj_sfxb").val()==1){
				if($(inputObjs[i]).val()==""){
					$.messager.alert("提示","红色标题信息必须填写！");
					return;
				}
			}
		}else{
			/**
			 * 当是否发生为状态为1时，发生时间字段值必须填写
			 */
			if(inputObjs[i].id=="xscj_b_assj_ks"){
				if($("#xscj_sfyfs").val()==1){
					if($(inputObjs[i]).val()==""){
						$.messager.alert("提示","红色标题信息必须填写！");
						return;
					}
				}
			}else{
				if($(inputObjs[i]).val()==""){
					$.messager.alert("提示","红色标题信息必须填写！");
					return;
				}
			}
		}
		
	}
	var time1 = $("#xscj_b_assj_ks").val();
	var time2 = $("#xscj_b_assj_js").val();
	/**
	 * 判断发生结束时间必须大于开始时间
	 */
	if(time2!=""){
		time1 = time1.substring(0,4)+"/"+time1.substring(4,6)+"/"+time1.substring(6,8)+" "+time1.substring(8,10)+":"+time1.substring(10,12)+":"+time1.substring(12,14);
	 	time2 = time2.substring(0,4)+"/"+time2.substring(4,6)+"/"+time2.substring(6,8)+" "+time2.substring(8,10)+":"+time2.substring(10,12)+":"+time2.substring(12,14);
		var date1 = new Date(time1);
		var date2 = new Date(time2);
		var date3 = date2.getTime()-date1.getTime();
		if(date3<0){
			$.messager.alert("提示","布控截止时间必须大于布控起始时间！");
			return;
		}
	}
	$.messager.confirm('确认对话框', '您是否确定要提交数据？', function(r){
		if (r){
			$("#infoform").form('submit',{
				dataType:'json',
				url:contextPath +'/xs/saveXscjb',	
				success:Xscj.addXscjInfo_back
			});
		}
	});
	
};
/**
 * @method:addXscjInfo_back
 * @package:syrk/js/qbld	
 * @description:添加线索返回状态
 * @param rsJson
 * @author:Li_Zhenzhong
 * @date:2015-6-25上午11:39:18
 */
Xscj.addXscjInfo_back = function(rsJson){
	rsJson = parseReturn(rsJson);
	if(rsJson.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"新增申请成功",
			time:3000,
			showType:'slide'
		});
	}
	Xscj.infoFromReset();
	Xscj.queryXscjList();
};
/**
 * @method:infoFromReset
 * @package:syrk/js/qbld	
 * @description:重置表单信息
 * @author:Li_Zhenzhong
 * @date:2015-5-27下午4:39:02
 */
Xscj.infoFromReset = function(){
	document.forms['infoform'].reset();
	$("#sbxx_tr").hide();
	$("#fssj_tr").hide();
};
/**
 * @method:seletSbxsxx
 * @package:syrk/js/qbld	
 * @description:选着设置续报原纪录信息
 * @param xbyjlid 
 * @param xbyjlbt
 * @author:Li_Zhenzhong
 * @date:2015-7-6下午2:49:18
 */
Xscj.seletSbxsxx = function(obj){
	for(key in obj){
		var val = obj[key];
		if(val!=""&&val!=null){
			/**
			 * 对字典项进行翻译，并显示关联字段
			 */
			switch(key){
			case 'xsly':$("#xscj_xsly").combobox("setValue",val);;break;
			case 'sfyfs':if(val==1){
							if($("#sfyfs_checkbox").attr("checked")!="checked")
								$("#sfyfs_checkbox").click();
						}else{
							if($("#sfyfs_checkbox").attr("checked")=="checked")
								$("#sfyfs_checkbox").click();
						}break;
			case 'sfxb':break;
			case 'jjcd':$("#xscj_jjcd").combobox("setValue",val);;break;
			default:$("#xscj_"+key).val(val);break;
			}
		}
	}
	$("#xscj_xbyjlbt").val(obj.bt);
	$("#xscj_xbyjlid").val(obj.jlid);
	$('#win').window('close');
};
/**
 * @method:queryXbxs
 * @package:syrk/js/qbld	
 * @description:查询续报线索
 * @author:Li_Zhenzhong
 * @date:2015-7-30下午3:18:11
 */
Xscj.queryXbxs = function(){
	$('#infoGrid').datagrid('load', { 
		bt:$("#where_bt1").val()
	});
}