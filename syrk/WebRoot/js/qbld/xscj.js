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
	var inputObjs = $(".infoOneTable :input")
	var num = inputObjs.length
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
	var num = checkObj.length
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
					"page":page}
	var url = contextPath+'/xs/queryXsList';
	var fajax = new FrameTools.Ajax(url,Xscj.queryXscjList_back);
	fajax.send(param);
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
	Xscj.listObj = json.rows;
	var num = Xscj.listObj.length;
	var  rsHtml = "<table class='listTable'>"+
		"<tr class='countInfo'>" +
		"<td colspan=4 >共有<font color='#17a9ff'>"+num+"</font>条线索信息</td>"+
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
						"线索来源:"+ row.xsly+"<br>" +
						"报送时间:"+row.bssj+"</div></td>"+
				"</tr>" ;
		}
	
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
			switch(key){
			case 'xsly':val=window.top.getDictName(contextPath + '/common/dict/D_QBLD_XSCJLY.js', val);break;
			case 'sfyfs':val=val==1?"是":"否";if(val=="是"){$("#fssj_tr").show()};break;
			case 'sfxb':val=val==1?"是":"否";if(val=="是"){$("#sbxx_tr").show()};break;
			case 'jjcd':val=window.top.getDictName(contextPath + '/common/dict/D_QBLD_XSCJJJCD.js', 1);break;
			default:break;
			}
			if('b_assj_ks,b_assj_js,'.indexOf(key)!=-1){
				val = val.substring(0,4)+"/"+val.substring(4,6)+"/"+val.substring(6,8)+" "+val.substring(8,10)+":"+val.substring(10,12)+":"+val.substring(12,14) ;
			}
		}
		if('jjcd,sfyfs,sfxb,xsly'.indexOf(key)!=-1){
			$("#"+key+"_td").html(val);
		}else
		$("#xscj_"+key).val(val);
	}
	
	var inputObjs = $(".infoOneTable :input")
	var num = inputObjs.length
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
	var html = "<input type='radio' name='jjcd_radio' style='width:15px;height:15px;' onchange='$(\"#xscj_jjcd\").val(1)' checked>一般 "+
	"<input type='radio' name='jjcd_radio' style='width:15px;height:15px;' onchange='$(\"#xscj_jjcd\").val(4)'>重要 "+
	"<input type='radio' name='jjcd_radio' style='width:15px;height:15px;' onchange='$(\"#xscj_jjcd\").val(8)'>紧急 ";
	$("#jjcd_td").html(html);
	html="<input type='checkbox' style='width:15px;height:15px;' onclick='Xscj.toggleSfyfs(this);'>是"
	$("#sfyfs_td").html(html);
	html="<input type='checkbox' style='width:15px;height:15px;' onclick='Xscj.toggleSfxb(this);'>是"
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
	var inputObjs = $(".infoOneTable :input")
	var num = inputObjs.length
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",false);
	}
	Xscj.infoFromReset();
	$("#optr").show();
	$("#xscj_cjdwmc").val(userOrgName);
	$("#xscj_cjr").val(userName);
}
Xscj.toggleSfyfs = function(obj){
	if(obj.checked){
		$("#fssj_tr").show();
		$("#xscj_sfyfs").val(1)
		
	}else{
		$("#fssj_tr").hide();
		$("#xscj_sfyfs").val(0)
		$("#xscj_xbyjlid").val("");
		$("#xscj_xbyjlbt").val("");
	}
}
Xscj.toggleSfxb = function(obj){
	if(obj.checked){
		$("#sbxx_tr").show();
		$("#xscj_sfxb").val(1)
	}else{
		$("#sbxx_tr").hide();
		$("#xscj_sfxb").val(0)
		$("#xscj_b_assj_js").val("");
	}
}
/**
 * @method:addXscjInfo
 * @package:syrk/js/qbld	
 * @description:添加线索
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:34:06
 */
Xscj.addXscjInfo = function(){
	var inputObjs = $(".infoOneTable .notNull ")
	var num = inputObjs.length;
	for(var i = 0;i<num;i++){
		if(inputObjs[i].id=="xscj_xbyjlid"||inputObjs[i].id=="xscj_bt"){
			if($("#xscj_sfxb").val()==1){
				if($(inputObjs[i]).val()==""){
					alert("红色标题信息必须填写！");
					return;
				}
			}
		}else{
			if(inputObjs[i].id=="xscj_b_assj_ks"){
				if($("#xscj_sfyfs").val()==1){
					if($(inputObjs[i]).val()==""){
						alert("红色标题信息必须填写！");
						return;
					}
				}
			}else{
				if($(inputObjs[i]).val()==""){
					alert("红色标题信息必须填写！");
					return;
				}
			}
		}
		
	}
	var time1 = $("#xscj_b_assj_ks").val();
	var time2 = $("#xscj_b_assj_js").val();
	if(time2!=""){
		time1 = time1.substring(0,4)+"/"+time1.substring(4,6)+"/"+time1.substring(6,8)+" "+time1.substring(8,10)+":"+time1.substring(10,12)+":"+time1.substring(12,14);
	 	time2 = time2.substring(0,4)+"/"+time2.substring(4,6)+"/"+time2.substring(6,8)+" "+time2.substring(8,10)+":"+time2.substring(10,12)+":"+time2.substring(12,14);
		var date1 = new Date(time1);
		var date2 = new Date(time2);
		var date3 = date2.getTime()-date1.getTime();
		if(date3<0){
			alert("布控截止时间必须大于布控起始时间！");
			return;
		}
	}
	
	$("#infoform").form('submit',{
		dataType:'json',
		url:contextPath +'/xs/saveXscjb',	
		success:Xscj.addXscjInfo_back
	});
};

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
}