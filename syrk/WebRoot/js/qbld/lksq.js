if(typeof Lksq =="undefined" || !Lksq){
	Lksq = {};
}
Lksq.listObj;//临控人员查询结果集合

/**
 * @method:initQueryHtml
 * @package:syrk/js/qbld	
 * @description:初始化临控申请页面
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:32:57
 * 
 */
Lksq.initQueryHtml = function(){
	/**
	 * 加载布控执行状态下拉框
	 */
	$("#where_bkzxzt").combobox({
		url: contextPath + '/common/dict/D_QBLD_XXBKZXZT.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bbkrzjlx").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYZJLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bc_bkjb").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYLKZLJB.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bc_cccs").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYCZCSLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bbkrxb").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYXBDM.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bc_gklx").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYGKLX.js',
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
			$(inputObjs[i]).attr("disabled",true);
	}
};

/**
 * @method:queryLksqList
 * @package:syrk/js/qbld	
 * @description:查询临控申请记录
 * @param total
 * @param begin
 * @param end
 * @param page
 * @author:Li_Zhenzhong
 * @date:2015-5-11上午10:57:26
 */
Lksq.queryLksqList = function(total,begin,end,page){
	var checkObj = $("#queryFrom :checkBox");
	var num = checkObj.length
	var gklx = ""; 
	for(var i = 0;i<num;i++){
		if(checkObj[i].checked)
			gklx+=checkObj[i].value+",";
	}
	var param = {  
					"bbkrxm":$("#where_bbkrxm").val(),
					"bbkrzjhm":$("#where_bbkrzjhm").val(),
					"bkzxzt":$("#where_bkzxzt").val(),
					"bc_gklx":gklx.substring(0, gklx.length-1),
					"bkqssjB":$("#where_bkqssjB").val(),
					"bkqssjE":$("#where_bkqssjE").val(),
					"total":total,
					"rownum":10,
					"begin":begin,
					"end":end,
					"page":page}
	var url = contextPath+'/lksq/queryLksqList';
	var fajax = new FrameTools.Ajax(url,Lksq.queryLksqList_back);
	fajax.send(param);
};
/**
 * @method:queryLksqList_back
 * @package:syrk/js/qbld	
 * @description:生成临控申请列表
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-11上午10:57:52
 */
Lksq.queryLksqList_back = function(json){
	Lksq.listObj = json.rows;
	var num = Lksq.listObj.length;
	var  rsHtml = "<table class='listTable'>"+
		"<tr class='countInfo'>" +
		"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>条临控申请</td>"+
		"</tr>";
	for(var  i = 0;i<num;i++){
		var row = Lksq.listObj[i];
		rsHtml+="<tr class='infoOne_tr' onclick='Main.clickListToChangeColor(this);Lksq.queryOneLksqInfo("+i+")'>"+
				"<td class='infoBody' onclick=''>"+"姓名:"+ row.bbkrxm+"  <br> " +
						"证件号码:"+ row.bbkrzjhm+"<br>" +
						"发布时间:"+row.bc_fbsj+"</div></td>"+
				"</tr>" ;
		}
		rsHtml+="</table>";
	$("#InfoList").html(rsHtml);
	Main.initChangeListColor();
};
/**
 * @method:queryOneLksqInfo
 * @package:syrk/js/qbld	
 * @description:查询单条申请信息
 * @param index
 * @author:Li_Zhenzhong
 * @date:2015-5-13上午10:31:02
 */
Lksq.queryOneLksqInfo = function(index){
	var obj = Lksq.listObj[index];
	for(key in obj){
		var val = obj[key];
		if(val!=""&&val!=null){
			switch(key){
			case 'bbkrzjlx':$("#lksq_bbkrzjlx").combobox('setValue', val);break;
			case 'bc_bkjb':$("#lksq_bc_bkjb").combobox('setValue', val);break;
			case 'bc_cccs':$("#lksq_bc_cccs").combobox('setValue', val);break;
			case 'bbkrxb':$("#lksq_bbkrxb").combobox('setValue', val);break;
			case 'bc_gklx':$("#lksq_bc_gklx").combobox('setValue', val);break;
			default:break;
			}
			if('bkqssj,bkjzsj,bc_sqsj,bc_fbsj,'.indexOf(key)!=-1){
				val = val.substring(0,4)+"/"+val.substring(4,6)+"/"+val.substring(6,8)+" "+val.substring(8,10)+":"+val.substring(10,12)+":"+val.substring(12,14) ;
			}
		}
		$("#lksq_"+key).val(val);
	}
	$("#lksq_zp").attr("src",contextPath + "/ckyj/queryQbldZpSingle.jpg?sfzh="+obj.bbkrzjhm );
	
	var inputObjs = $(".infoOneTable :input")
	var num = inputObjs.length
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",true);
			$("#opTr").hide();
	}
};
/**
 * @method:initAddLksqHtml
 * @package:syrk/js/qbld	
 * @description:初始化临控申请表
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:59:48
 */
Lksq.initAddLksqHtml = function(){
	document.forms['infoFrom'].reset();
	var inputObjs = $(".infoOneTable :input")
	var num = inputObjs.length
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",false);
			$("#opTr").show();
	}
	$("#lksq_bc_fbdw").val(userOrgName);
	$("#lksq_bc_fbr").val(userName);
	$("#lksq_yjdwmc").val(userOrgName);
	$("#lksq_yjrmc").val(userName);
	$("#lksq_bc_fbsj").val(Lksq.show_cur_times());
	
}
/**
 * @method:addLksqInfo
 * @package:syrk/js/qbld	
 * @description:添加临控申请
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:34:06
 */
Lksq.addLksqInfo = function(){
	var inputObjs = $(".infoOneTable .notNull ")
	var num = inputObjs.length
	for(var i = 0;i<num;i++){
		if($(inputObjs[i]).val()==""){
			alert("红色标题信息必须填写！");
			return;
		}
	}
	var time1 = $("#lksq_bkqssj").val();
	var time2 = $("#lksq_bkjzsj").val();
	
	time1 = time1.substring(0,4)+"/"+time1.substring(4,6)+"/"+time1.substring(6,8)+" "+time1.substring(8,10)+":"+time1.substring(10,12)+":"+time1.substring(12,14);
 	time2 = time2.substring(0,4)+"/"+time2.substring(4,6)+"/"+time2.substring(6,8)+" "+time2.substring(8,10)+":"+time2.substring(10,12)+":"+time2.substring(12,14);
	var date1 = new Date(time1);
	var date2 = new Date(time2);
	var date3 = date2.getTime()-date1.getTime();
	if(date3<0){
		alert("布控截止时间必须大于布控起始时间！");
		return;
	}
	var days = Math.ceil(date3/(24*3600*1000));
	$("#lksq_bkts").val(days);
	$("#infoFrom").form('submit',{
		dataType:'json',
		url:contextPath +'/lksq/saveLksqb',	
		success:Lksq.addLksqInfo_back
	});
};
/**
 * @method:addLksqInfo_back
 * @package:syrk/js/qbld	
 * @description:申请返回结果
 * @param rsJson
 * @author:Li_Zhenzhong
 * @date:2015-5-27上午10:42:05
 */
Lksq.addLksqInfo_back = function(rsJson){
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

Lksq.show_cur_times = function(){
//获取当前日期
 var date_time = new Date();
 //年
 var year = date_time.getFullYear();
  //判断小于10，前面补0
   if(year<10){
  year="0"+year;
 }
 //月
 var month = date_time.getMonth()+1;
  //判断小于10，前面补0
  if(month<10){
month="0"+month;

 }
 //日
 var day = date_time.getDate();
  //判断小于10，前面补0
   if(day<10){
  day="0"+day;
 }
 //时
 var hours =date_time.getHours();
  //判断小于10，前面补0
    if(hours<10){
  hours="0"+hours;
 }
 //分
 var minutes =date_time.getMinutes();
  //判断小于10，前面补0
    if(minutes<10){
  minutes="0"+minutes;
 }
 //秒
 var seconds=date_time.getSeconds();
  //判断小于10，前面补0
    if(seconds<10){
  seconds="0"+seconds;
 }
 //拼接年月日时分秒
 return year+month+day+hours+minutes+seconds;
}
	