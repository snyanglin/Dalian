/*!
 * 报表统计

 * znjg - v1.0.0 (2014-07-24 11:06)
 * Copyright(c) 2014 founder
 */

/**
 * @deprecated 警情报表统计
 * @author yubo
 */
var bbtj = {

	

	/**
	 * 统计分析日期类型
	 */
	fxzq : 1,

	

	/**
	 * 当前可选大队代码
	 */
	CRRENTENABLEDD : {},

	/**
	 * 初始化
	 */
	initFun : function() {

		$("input[name=zhddfxzq][value=1]").attr("checked",'checked');
		
		var yesterday=GetDateStr(-1); 
		var today=GetDateStr(0); 
	    $("#zdyday_s").val(yesterday);
		$("#zdyday_e").val(today);
		$("#zdyday_s").bind('click', null,function() {
			WdatePicker({
				dateFmt : 'yyyy-MM-dd HH:mm:ss',
				maxDate : $('#zdyday_e').val()
			});
		});
	
		bbtj.createYear();
		bbtj.createQuarter();
		bbtj.createMonth();
		bbtj.createWeek();
		bbtj.fxzqObjHide();
		bbtj.changeFxzq(1);
		this.bbtjQuery();
	},


	 /**
		 * 选择分析周期
		 * 
		 * @param v
		 */
	changeFxzq : function(v) {
		bbtj.fxzq = v;
		switch (v)
		{	
		case "5":
			bbtj.fxzqObjHide();
			$("#year_mc").show();
			break;
		case "4":
			bbtj.fxzqObjHide();
			$("#year_mc").show();
			$("#quarter_mc").show();
			break;
		case "3":
			bbtj.fxzqObjHide();
			$("#year_mc").show();
			$("#month_mc").show();
			break;
		case "2":
			bbtj.fxzqObjHide();
			$("#year_mc").show();
			$("#week_mc").show();
			break;
		case "1":
			bbtj.fxzqObjHide();
			$("#zdyday_s").show();
			$("#zdyday_e").show();
			$("#zdyday_q").show();
			$("#zdyday_z").show();
			break;
		default:
			bbtj.fxzqObjHide();
		    $("#zdyday_s").show();
		    $("#zdyday_e").show();
		    $("#zdyday_q").show();
		    $("#zdyday_z").show();
		}
	},
	
	
	/**
	 * 分析周期域隐藏
	 */
	fxzqObjHide : function() {
		$("#year_mc").hide();
		$("#quarter_mc").hide();
		$("#month_mc").hide();
		$("#week_mc").hide();
		$("#zdyday_s").hide();
		$("#zdyday_e").hide();
		$("#zdyday_q").hide();
		$("#zdyday_z").hide();
	},
	
	/**
	 * 返回年选择html（未用）
	 * 
	 * @returns {String}
	 */
	getYear : function(){
		var html = '';
		var thisYear = bbtj.getThisYear();
		html += '<select id="year" name="year" style="width:100px;">';
		for(var i = 0; i < 10; i++){
			html += '<option value="'+ (thisYear - i) +'">'+ (thisYear - i) +'年</option>';
		}
		html += '</select>';
		return html;
	},
	
	/**
	 * 创建年选择字典
	 */
	createYear : function() {
		var thisYear = bbtj.getThisYear();
		var array = new Array();
		var json;
		for(var i = 0; i < 10; i++){
			json = {dm:(thisYear - i)+",0",ct:(thisYear - i)+"年"};
			array.push(json);
		}
		var data = {list:array};
		Dictionary.createDictionaryList("year_mc", "zhdd_bbtj_div", thisYear, data, function(){
			
		});
	},
	
	/**
	 * 创建季选择字典
	 */
	createQuarter : function() {
		var array = new Array();
		var json;
		for(var i = 0; i < 4; i++){
			json = {dm:(i+1)+",0",ct:"第"+ (i+1) +"季度"};
			array.push(json);
		}
		var data = {list:array};
		Dictionary.createDictionaryList("quarter_mc", "zhdd_bbtj_div", 1, data, function(){
		});
	},
	
	/**
	 * 创建月选择字典
	 */
	createMonth : function() {
		var array = new Array();
		var json;
		for(var i = 0; i < 12; i++){
			json = {dm:(i+1)+",0",ct:(i+1) +"月"};
			array.push(json);
		}
		var data = {list:array};
		Dictionary.createDictionaryList("month_mc", "zhdd_bbtj_div", 1, data, function(){
		});
	},
	
	/**
	 * 创建周选择字典
	 */
	createWeek : function() {
		var array = new Array();
		var json;
		for(var i = 0; i < 52; i++){
			json = {dm:(i+1)+",0",ct:"第"+ (i+1) +"周"};
			array.push(json);
		}
		var data = {list:array};
		Dictionary.createDictionaryList("week_mc", "zhdd_bbtj_div", 1, data, function(){
		});
	},
	
	/**
	 * 返回季选择html（未用）
	 * 
	 * @returns {String}
	 */
	getQuarter : function(){
		var html = "";
		var thisYear = bbtj.getThisYear();
		html += '<select id="quarter" name="quarter" style="width:100px;">';
		for(var i = 0; i < 4; i++){
			html += '<option value="'+ (i+1) +'">第'+ (i+1) +'季度</option>';
		}
		html += '</select>';
		return html;
	},
	
	/**
	 * 返回月选择html（未用）
	 * 
	 * @returns {String}
	 */
	getMonth : function(){
		var html = "";
		var thisYear = bbtj.getThisYear();
		html += '<select id="month" name="month" style="width:100px;">';
		for(var i = 0; i < 12; i++){
			html += '<option value="'+ (i+1) +'">'+ (i+1) +'月</option>';
		}
		html += '</select>';
		return html;
	},
	
	/**
	 * 返回周选择html（未用）
	 * 
	 * @param year
	 * @returns {String}
	 */
	getWeek : function(year){
		var html = "";
		var thisYear = bbtj.getThisYear();
		html += '<select id="week" name="week" style="width:100px;">';
		for(var i = 0; i < 52; i++){
			html += '<option value="'+ (i+1) +'">第'+ (i+1) +'周</option>';
		}
		html += '</select>';
		return html;
	},
	
	/**
	 * 返回天选择html（未用）
	 * 
	 * @returns {String}
	 */
	getDay : function() {
		return "";
	},
	
	/**
	 * 取得当年年份（4位）
	 * 
	 * @returns
	 */
	getThisYear : function(){
		var dt = new Date(); 
		return dt.getFullYear();
	},
	
	/**
	 * 获取某年某周的开始日期
	 * 
	 * @param paraYear
	 * @param weekIndex
	 * @returns
	 */
	getBeginDateOfWeek : function(paraYear, weekIndex){
	    var firstDay = bbtj.getFirstWeekBegDay(paraYear);
	    var time=(weekIndex-1)*7*24*3600000;
	    var beginDay = firstDay;
	    beginDay.setTime(firstDay.valueOf()+time);
	    return bbtj.formatDate(beginDay);
	},
	
	/**
	 * 获取某年某周的结束日期
	 * 
	 * @param paraYear
	 * @param weekIndex
	 * @returns
	 */
	getEndDateOfWeek : function (paraYear, weekIndex){
	    var firstDay = bbtj.getFirstWeekBegDay(paraYear);
	    var time=(weekIndex-1)*7*24*3600000;
	    var weekTime = 6*24*3600000;
	    var endDay = firstDay;
	    endDay.setTime(firstDay.valueOf()+weekTime+time);
	    return bbtj.formatDate(endDay);
	},
	
	/**
	 * 获取某年的第一天
	 * 
	 * @param year
	 * @returns {Date}
	 */
	getFirstWeekBegDay : function (year) {
	    var tempdate = new Date(year, 0, 1);
	    var temp = tempdate.getDay();
	    if (temp == 1){
	       return tempdate;
	    }
	    temp = temp == 0 ? 7 : temp;
	    tempdate = tempdate.setDate(tempdate.getDate() + (8 - temp));
	    return new Date(tempdate);   
	},
	
	/**
	 * 格式化日期：yyyy-MM-dd
	 * 
	 * @param date
	 * @returns {String}
	 */
	formatDate : function(date) {       
	    var myyear = date.getFullYear();      
	    var mymonth = date.getMonth()+1;      
	    var myweekday = date.getDate();       
	          
	    if(mymonth < 10){      
	        mymonth = "0" + mymonth;      
	    }       
	    if(myweekday < 10){      
	        myweekday = "0" + myweekday;      
	    }      
	    return (myyear+"-"+mymonth + "-" + myweekday);       
	},
	
	
	
	/**
	 * 格式化日期：yyyy-MM-dd
	 * 
	 * @param date
	 * @returns {String}
	 */
	formatchDate : function(date) {       
	    var myyear = date.split("-")[0];      
	    var mymonth = date.split("-")[1];       
	    var myweekday = date.split("-")[2];    
	    var day = myweekday.substr(0, 2);
	    var hour = myweekday.substr(3, 9);
	    
	    return (myyear+"年"+mymonth + "月" + day+"日  "+hour);       
	},
	/**
	 * 大队警情统计
	 * 
	 * @param jqssdddm
	 *            大队机构代码
	 * @param starttime
	 *            开始时间
	 * @param endtime
	 *            结束时间
	 */
	bbtjQuery : function() {
		
		var yjfxzq = $('input[name="zhddfxzq"]:checked').val();
		var year_dm = $("#year_dm").val().replace(",0","");
		var quarter_dm = $("#quarter_dm").val().replace(",0","");
		var month_dm = $("#month_dm").val().replace(",0","");
		var week_dm = $("#week_dm").val().replace(",0","");
		var zdyday_s = $("#zdyday_s").val();
		var zdyday_e = $("#zdyday_e").val();
		var msg ="";
		 // 换算开始时间和结束时间
		if(yjfxzq=="5") {// 年
			fxsjs = (year_dm - 1) + "-12-21 00:00:00";
			fxsje = (year_dm) + "-12-20 23:59:59";
			msg= $("#year_mc").val();
		} else if(yjfxzq=="4"){// 季
			var year_s;
			var month_s = "";
			var month_e = "";
			if(quarter_dm=="1") {
				month_s = 12;
				year_s = year_dm - 1;
			} else {
				month_s = (quarter_dm - 1) * 3;
				year_s = year_dm;
			}
			month_e = quarter_dm * 3;
			msg= $("#year_mc").val()+$("#quarter_mc").val();
			fxsjs = year_s + "-"+month_s+"-21 00:00:00";
			fxsje = year_dm + "-"+month_e+"-20 23:59:59";
		}else if(yjfxzq=="3"){// 月
			var year_s;
			var month_s = "";
			var month_e = "";
			if(month_dm=="1"){
				month_s = 12;
				year_s = year_dm - 1;
			} else {
				month_s = month_dm - 1;
				year_s = year_dm;
			}
			month_e = month_dm;
			fxsjs = year_s +"-"+month_s+"-21 00:00:00";
			fxsje = year_dm +"-"+month_e+"-20 23:59:59";
			msg= $("#year_mc").val()+$("#month_mc").val();
		}else if(yjfxzq=="2"){// 周
			fxsjs = bbtj.getBeginDateOfWeek(year_dm, week_dm) + " 00:00:00";
			fxsje = bbtj.getEndDateOfWeek(year_dm, week_dm) + " 23:59:59";
			msg= $("#year_mc").val()+$("#week_mc").val();
		}else if(yjfxzq=="1"){// 自定义
			fxsjs = zdyday_s;
			fxsje = zdyday_e;
			if(zdyday_s=="" || zdyday_s==null) {
				SysTool.tooltips("zdyday_s", "请选择开始时间！", 'right', false); 
				return;
			}
			if(zdyday_e=="" || zdyday_e==null) {
				SysTool.tooltips("zdyday_e", "请选择结束时间！", 'right', false); 
				return;
			}
			
			msg= bbtj.formatchDate(zdyday_s)+" 至  "+bbtj.formatchDate(zdyday_e);
			
		}
		
		var param1 = {};
		
		param1['jqssdddm'] = SysConfig.T_USER_LOGIN_ORGID_ZD;
		param1['starttime'] = fxsjs;
		param1['endtime'] = fxsje;
		$('#bbtjgrid').datagrid({
			fit: true, 
			singleSelect : true,
			rownumbers : false,
			fitColumns : false,
			nowrap : true,
			border : false,
    		showFooter:true,
			pagination : false,
			remoteSort:true,
			queryParams : {
				param : JSON.stringify(param1),
				jqssdddm :SysConfig.T_USER_LOGIN_ORGID_ZD
  
			},
			url : 'jqxx/queryDdJqxxInfo.f',
			columns : [ [ {
				field : 'jjrdwmc',
				title : '所属大队辖区',
				width : 180,
				align: 'left',
				halign:'center'
			}, {
				field : 'zhddcount',
				title : '事故总次数',
				width : 100,
				sortable : true,
				align : 'center',
				formatter : function(value, row, index) {
						return formatOper(value, row, index,'zhddcount',fxsjs,fxsje,msg,"tjdd");
						
				}     
			}, {
				field : 'deadtotal',
				title : '死亡',
				width : 100,
				sortable : true,
				align : 'center',
				formatter : function(value, row, index) {
					return formatOper(value, row, index,'deadcount',fxsjs,fxsje,msg,"tjdd");
					
			} 
			}, {
				field : 'hurttotal',
				title : '伤人',
				width : 100,
				sortable : true,
				align : 'center',
				formatter : function(value, row, index) {
					return formatOper(value, row, index,'hurtcount',fxsjs,fxsje,msg,"tjdd");
					
			} 
			} ] ],

			onClickRow : function(rowIndex, rowData) {
	              if(rowData["jjrdwbh"]!='trouble'){
	            	  
	            	SysTool.setTxtVal("jjxx_bbtj_jgdm", rowData["jjrdwbh"]);
	            	bbtj.zdtjquery(rowData["jjrdwbh"],rowData["jjrdwmc"],fxsjs,fxsje,msg);
					}
				
			},
			onAfterRender:function(target){
				
			},
			onLoadSuccess : function(row) {// 当表格成功加载时执行
				$('#bbtjgrid').datagrid("selectRow", 0);	
				var rows = $('#bbtjgrid').datagrid("getRows");
				var alldeadcount = 0;
				var allzhddcount = 0;
				var allhurtcount = 0;
       			var alldxhurttotal = 0;
       			
       			var alllywtycount =0;
       			var allywxajbscount = 0;
       			var alljtsgcount = 0;
       			var alldlwfcount = 0;
       			var allqzqzcount = 0;
       			var alllbxccount = 0;
       			var alllothercount = 0;
       			
       			var alllschoolccount = 0;
       			var alllpolicecount = 0;
       			var alllwhclcount = 0;
       			
				var rowslength = rows.length;
			    for(var i=0;i<rowslength;i++){
			    	
			    	if (i == 0) {
			    		SysTool.setTxtVal("jjxx_bbtj_jgdm", rows[0].jjrdwbh);
						bbtj.zdtjquery(rows[0].jjrdwbh,rows[0].jjrdwmc,fxsjs,fxsje,msg);
					} 
			    	if(rows[i].jjrdwbh !='trouble'){
			    	alldeadcount += rows[i].deadtotal;
			    	allhurtcount += rows[i].hurttotal;
			    	allzhddcount += rows[i].zhddcount;
    		    	alldxhurttotal+= rows[i].dxhurttotal;
			    	
			    	
    		    	allywxajbscount+= rows[i].ywxajbscount;
    		    	alljtsgcount+= rows[i].jtsgcount;
    		    	alldlwfcount+= rows[i].dlwfcount;
    		    	allqzqzcount+= rows[i].qzqzcount;
    		    	alllbxccount+= rows[i].lbxccount;
    		    	
    		    	alllothercount+= rows[i].othercount;
    		    	}

			    	if(rows[i].jjrdwmc =='逃逸'){
			    	  alllywtycount= rows[i].zhddcount;
			    	}
			    	if(rows[i].jjrdwmc =='与学校相关的事故'){
			    		alllschoolccount= rows[i].zhddcount;
				    }
			    	if(rows[i].jjrdwmc =='军警车相关的事故'){
			    		alllpolicecount= rows[i].zhddcount;
				    }	
			    	if(rows[i].jjrdwmc =='危化品相关的事故'){
			    		alllwhclcount= rows[i].zhddcount;
				    }
			    }
			    var  jqks="";
			    
			
			     jqks+="<div class='datatjdiv'>"+msg+"，德阳支队指挥中心共接各类报警求助警情"+allzhddcount+"起，";
			     jqks+="有效警情"+allywxajbscount+"起。其中交通事故"+alljtsgcount+"起（"+"死亡事故"+alldeadcount+"起，"+"伤人事故"+allhurtcount+"起，"+"逃逸事故"+alllywtycount+"起，";
			     jqks+="与学校相关的交通事故"+alllschoolccount+"起，"+"与军警车相关的事故"+alllpolicecount+"起，";
			     jqks+="与危化品相关的事故"+alllwhclcount+"起，";
			     jqks+="其他交通事故"+alllothercount+"起），"+"道路违法"+alldlwfcount+"起，";
			     jqks+="群众求助"+allqzqzcount+"起，"+"内部协查"+alllbxccount+"起。</div>";
			     
			     $('#bbtjgrid').datagrid('appendRow',{
			    	jjrdwbh :'trouble',
			    	jjrdwmc: '伤人(合计)',
			      	zhddcount: allhurtcount,
			      	deadcount: '',
			      	hurtcount: ''
		        });
			     $('#bbtjgrid').datagrid('appendRow',{
				    	jjrdwbh :'trouble',
				    	jjrdwmc: '典型伤人(合计)',
				      	zhddcount: alldxhurttotal,
				      	deadcount: '',
				      	hurtcount: ''
			        });
			    $('#bbtjgrid').datagrid('appendRow',{
			    	jjrdwbh :'trouble',
			    	jjrdwmc: '死亡(合计)',
			      	zhddcount: alldeadcount,
			      	deadcount: '',
			      	hurtcount: ''
		        });
			    $('#bbtjgrid').datagrid('appendRow',{
			    	jjrdwbh :'trouble',
		        	jjrdwmc: jqks,
			        zhddcount: '',
			      	deadcount: '',
			      	hurtcount: ''
		        });
			    var  newrows=rowslength+3;
				var  newcolspan="";
				var  newfield="";
				
			    for(rowslength;rowslength<=newrows;rowslength++){
			    if(rowslength==newrows){
			    	newcolspan=4;
			    	newfield="jjrdwmc";
			    }
			    if(rowslength>=newrows-3 && rowslength< newrows){
			    	newcolspan=3;
			    	newfield="zhddcount";
			    }
			 
			    $('#bbtjgrid').datagrid("mergeCells", { // 进行合并
                    index: rowslength,
                    field: newfield,
                    rowspan: null,
                    colspan: newcolspan
                });
			    }
			    
// $('#bbtjgrid').datagrid('reloadFooter',[
//                          
// {jjrdwmc: '伤人（合计）', zhddcount: allhurtcount}
// // {zhddcount: allgather}
//			                    				
// ]);

			},
			toolbar : [{
				text : '导出Excel',
				iconCls : 'icon-dc',
				align:'right',
				handler : function() {
					Exproter("2","");
         	}
          }]
	
		});
		 
	
	},

	/**
	 * 中队警情统计
	 * 
	 * @param jgdm
	 *            中队机构代码
	 * @param starttime
	 *            开始时间
	 * @param endtime
	 *            结束时间
	 */
	zdtjquery : function(jgdm,jgmc,fxsjs,fxsje,msg){
		var param1 = {};
		param1['jqsszddm'] = jgdm;
		param1['starttime'] = fxsjs;
		param1['endtime'] = fxsje;
		$('#zhdd_bbtj_zd_query').datagrid({
			fit: true, 
			singleSelect : true,
			rownumbers : false,
			fitColumns : false,
			nowrap : true,
			border : false,
    		showFooter:true,
			pagination : false,
			remoteSort:true,
			queryParams : {
			param : JSON.stringify(param1),
				jqsszddm :jgdm
  
			},
			url : 'jqxx/queryZdJqxxInfo.f',
			columns : [ [ {
				field : 'jjrdwmc',
				title : '所属中队辖区',
				width : 180,
				align: 'left',
				halign:'center'
			}, {
				field : 'zhddcount',
				title : '事故总次数',
				width : 100,
				sortable : true,
				align : 'center',
				formatter : function(value, row, index) {
					return formatOper(value, row, index,'zhddcount',fxsjs,fxsje,msg,"tjzd");
					
			}    
			}, {
				field : 'deadtotal',
				title : '死亡',
				width : 100,
				sortable : true,
				align : 'center',
				formatter : function(value, row, index) {
					return formatOper(value, row, index,'deadcount',fxsjs,fxsje,msg,"tjzd");
					
			}    
			}, {
				field : 'hurttotal',
				title : '伤人',
				width : 100,
				sortable : true,
				align : 'center' ,
				formatter : function(value, row, index) {
					return formatOper(value, row, index,'hurtcount',fxsjs,fxsje,msg,"tjzd");
					
			}    
			} ] ],

			onClickRow : function(rowIndex, rowData) {
				
			},
			onAfterRender:function(target){
				
			},
			onLoadSuccess : function(row) {// 当表格成功加载时执行
				var rows = $('#zhdd_bbtj_zd_query').datagrid("getRows");
				var alldeadcount = 0;
				var allzhddcount = 0;
				var allhurtcount = 0;
				var alldxhurttotal = 0;
				
				var alllywtycount =0;
       			var allywxajbscount = 0;
       			var alljtsgcount = 0;
       			var alldlwfcount = 0;
       			var allqzqzcount = 0;
       			var alllbxccount = 0;
       			var alllothercount = 0;
       			
       			var alllschoolccount = 0;
       			var alllpolicecount = 0;
       			var alllwhclcount = 0;
				var rowslength = rows.length;
			    for(var i=0;i<rowslength;i++){

			    	if(rows[i].jjrdwbh !='trouble'){
			    	alldeadcount += rows[i].deadtotal;
			    	allhurtcount += rows[i].hurttotal;
			    	allzhddcount += rows[i].zhddcount;
			    	alldxhurttotal+= rows[i].dxhurttotal;
			    	
			    	allywxajbscount+= rows[i].ywxajbscount;
    		    	alljtsgcount+= rows[i].jtsgcount;
    		    	alldlwfcount+= rows[i].dlwfcount;
    		    	allqzqzcount+= rows[i].qzqzcount;
    		    	alllbxccount+= rows[i].lbxccount;
    		    	alllothercount+= rows[i].othercount;
    		    	}
			    	
			    	  if(rows[i].jjrdwmc =='逃逸'){
				    	  alllywtycount= rows[i].zhddcount;
				    	}
				    	if(rows[i].jjrdwmc =='与学校相关的事故'){
				    		alllschoolccount= rows[i].zhddcount;
					    }
				    	if(rows[i].jjrdwmc =='军警车相关的事故'){
				    		alllpolicecount= rows[i].zhddcount;
					     }	
			    		
				    	if(rows[i].jjrdwmc =='危化品相关的事故'){
				    		alllwhclcount= rows[i].zhddcount;
					   }	
			    }
			    
			    
			    var  jqks="";
			    
				 jqks+="<div class='datatjdiv'>"+msg+"，"+jgmc+"指挥中心共接各类报警求助警情"+allzhddcount+"起，";
			     jqks+="有效警情"+allywxajbscount+"起。其中交通事故"+alljtsgcount+"起（"+"死亡事故"+alldeadcount+"起，"+"伤人事故"+allhurtcount+"起，"+"逃逸事故"+alllywtycount+"起，";
			     jqks+="与学校相关的交通事故"+alllschoolccount+"起，"+"与军警车相关的事故"+alllpolicecount+"起，";
			     jqks+="与危化品相关的事故"+alllwhclcount+"起，";
			     jqks+="其他交通事故"+alllothercount+"起），"+"道路违法"+alldlwfcount+"起，";
			     jqks+="群众求助"+allqzqzcount+"起，"+"内部协查"+alllbxccount+"起。</div>";
			     
			    $('#zhdd_bbtj_zd_query').datagrid('appendRow',{
			    	jjrdwbh :'trouble',
			    	jjrdwmc: '伤人(合计)',
			    	zhddcount: allhurtcount,
			      	deadcount: '',
			      	hurtcount: ''
		        });
			    $('#zhdd_bbtj_zd_query').datagrid('appendRow',{
			    	jjrdwbh :'trouble',
			    	jjrdwmc: '典型伤人(合计)',
			    	zhddcount: alldxhurttotal,
			      	deadcount: '',
			      	hurtcount: ''
		        });
			    $('#zhdd_bbtj_zd_query').datagrid('appendRow',{
			    	jjrdwbh :'trouble',
			    	jjrdwmc: '死亡(合计)',
			      	zhddcount: alldeadcount,
			      	deadcount: '',
			      	hurtcount: ''
		        });
			    $('#zhdd_bbtj_zd_query').datagrid('appendRow',{
			    	jjrdwmc: jqks,
			      	zhddcount: '',
			      	deadcount: '',
			      	hurtcount: ''
		        });
			    
			    var  newrows=rowslength+3;
				var  newcolspan="";
				var  newfield="";
				
			    for(rowslength;rowslength<=newrows;rowslength++){
			    if(rowslength==newrows){
			    	newcolspan=4;
			    	newfield="jjrdwmc";
			    }
			    if(rowslength>=newrows-3 && rowslength< newrows){
			    	newcolspan=3;
			    	newfield="zhddcount";
			    }
			    $('#zhdd_bbtj_zd_query').datagrid("mergeCells", { // 进行合并
                    index: rowslength,
                    field: newfield,
                    rowspan: null,
                    colspan: newcolspan
                });
			    
			    }
			    
// $('#bbtjgrid').datagrid('reloadFooter',[
//                          
// {jjrdwmc: '伤人（合计）', zhddcount: allhurtcount}
// // {zhddcount: allgather}
//			                    				
// ]);

			},
			toolbar : [{
				text : '导出Excel',
				iconCls : 'icon-dc',
				align:'right',
				handler : function() {
					Exproter("1",jgmc);
         	}
          }]
		});
		 
	
	},

	/**
	 * 交通警情展现
	 * 
	 * @param jgdm
	 *            中队机构代码
	 * @param starttime
	 *            开始时间
	 * @param endtime
	 *            结束时间
	 */
	jtjjquery: function(jgdm,fxsjs,fxsje,fun,msg,subject,term){
		var param = {};
		param['jqsszddm'] = jgdm;
		param['starttime'] = fxsjs;
		param['endtime'] = fxsje;
		param['tjlx'] = fun;
		param['tjdx'] = subject;
		param['term'] = term;
		$('#jtjjxxgrid').datagrid({
			 height: 400,
			 singleSelect:false, 
	         rownumbers : false,
	         nowrap: true,
	         border: true,
	         pagination: true,
	         remoteSort: false,
	         border:false,
	         fitColumns : false,
	         pageSize : 10,
	         pageList : [10, 15, 20, 25, 30 ],
			 queryParams : {
				param : JSON.stringify(param),
				jqsszddm :jgdm
			},
			url : 'jqxx/queryJqxxInfo.f',
			columns : [ [ {
				field : 'jjxx',
				styler:function(value, row, index){
					return 'min-width:570px;border-left-width:1px';
				},
				title:false
			} ] ],
            onClickRow : function(rowIndex, rowData) {
				
			},
			onAfterRender:function(target){
				
			},
				
			onLoadSuccess : function(row) {// 当表格成功加载时执行
//				var rows = $('#jtjjxxgrid').datagrid("getRows");
				$("#zhdd_jqxxinfo_div").find(".datagrid-header").hide();
				$("#zhdd_jqxxinfo_div").find(".datagrid-toolbar").css("text-align","left");
			},
			toolbar : [{
							text : '导出Excel',
							iconCls : 'icon-dc',
							align:'right',
							handler : function() {
								   var dwmc = SysTool.getTxtVal("jjxx_bbtj_title");
									downloadfile(JSON.stringify(param),dwmc,msg);
                     	}
			}]
					
		});
	},
	/**
	 * 重置其他常用条件
	 * 
	 * @param isAll
	 *            是否全部
	 */
	resetOtherOpt : function(isAll) {
		var div = $('#zhdd_bbtj_query');
		div.find('.all_inputtext').val('');
		div.find('.tips_slect').val('');
		div.find('.all_slect').val('');
		if (typeof (isAll) !== 'undefined') {
			div.find('.all_inputtext').val('');
			div.find('.all_slect').val('');
			div.find('.tips_slect').val('');
		}
	}

};



function formatOper(val,row,index,fun,fxsjs,fxsje,msg,subject){  
	var rowvaule= "";
	if (fun == 'zhddcount') {
		rowvaule=row.zhddcount;
	}
	if (fun == 'deadcount') {
		rowvaule=row.deadtotal;
	}
	if (fun == 'hurtcount') {
		rowvaule=row.hurttotal;
	}
	
	return '<a href="javascript:;" onclick="Opermore(\'' +index + '\',\''+fxsjs+ '\',\''+ fxsje+'\',\''+ fun+ '\',\''+ msg+'\',\''+ subject+ '\')">'+rowvaule+'</a>';  
	
	}  
function Opermore(index,fxsjs,fxsje,fun,msg,type){  
	var subject=type;
	var row ="";
	 if(subject=="tjdd"){
    $('#bbtjgrid').datagrid('selectRow',index);
     row = $('#bbtjgrid').datagrid('getSelected');
	 }
	 if(subject=="tjzd"){
	  $('#zhdd_bbtj_zd_query').datagrid('selectRow',index);
	  row = $('#zhdd_bbtj_zd_query').datagrid('getSelected');
		}
    var jgmc=row.jjrdwmc;
    var jgdm=row.jjrdwbh;
    var term="1";
    var titleName =jgmc+"事故情况";
    if(subject=="tjdd"){
//    	//alert(jgdm);
    	if(jgdm=="trouble"){
        	jgdm=SysConfig.T_USER_LOGIN_ORGID_ZD;
        	subject="tjddtrouble";
        }
    }
    
    if(subject=="tjzd"){
     	
    	if(jgdm=="trouble"){
    		jgdm=SysTool.getTxtVal("jjxx_bbtj_jgdm");
        	subject="tjzdtrouble";
        }
    }
//    //alert(subject);
    if(jgmc=="与学校相关的事故"){
    	term='IFSCHOOL';
    	titleName="与学校相关的事故";
      }
    if(jgmc=="摩托车相关的事故"){
    	fun='IFMOTOR';
    	titleName="摩托车相关的事故";
      }
    if(jgmc=="出租车相关的事故"){
    	term='IFTAXI';
    	titleName="出租车相关的事故情况";
      }
    if(jgmc=="军警车相关的事故"){
    	term='IFPOLICE';
    	titleName="军警车相关的事故情况";
      }
    if(jgmc=="危化品相关的事故"){
    	term='SFSWHCL';
    	titleName="危化品相关的事故情况";
      }
    if(jgmc=="电动车相关的事故"){
    	term='IFELECTRIC';
    	titleName="电动车相关的事故情况";
      }
    if(jgmc=="白天（8:00-19:00）发生事故"){
    	term='daytime';
    	titleName="白天（8:00-19:00）发生事故情况";
      }
    if(jgmc=="夜间（19:00-8:00）发生事故"){
    	term='night';
    	titleName="夜间（19:00-8:00）发生事故情况";
      }
    if(jgmc=="逃逸"){
    	term='YWTY';
    	titleName="交通事故逃逸情况";
    	//alert(term);
      }
    if(jgmc=="伤人(合计)" ){
    	term='IFHURT';
    	titleName="伤人事故情况";
    	//alert(term);
      }
    if(jgmc=="死亡(合计)"){
    	term='IFDEAD';
    	titleName="死亡事故情况";
      	//alert(term);
      }
    if(jgmc=="典型伤人(合计)"){
    	term='IFDXHURT';
    	titleName="典型伤人事故情况";
    	//alert(term);
      }
   
    
    
//    var typenubmer=0;
//    var txt = '';
//    if (fun == 'zhddcount') {
//    	
//    	typenubmer="事故总数"+row.deadcount+"起："+"<br /> ";
//    	if(row.deadcount>0){
//    	typenubmer+="死亡事故"+row.deadcount+"起："+"<br />";
//    	}
//    	if(row.hurtcount>0){
//    	 typenubmer+="受伤事故"+row.hurtcount+"起："+"<br />";
//    	}
//    	if(row.dxhurttotal>0){
//       	 typenubmer+="典型伤人事故"+row.dxhurttotal+"起："+"<br />";
//       	}
//    	
//        	}
//    	
//	if (fun == 'deadcount') {
//		typenubmer="死亡事故："+row.deadcount+"起：";
//	}
//	if (fun == 'hurtcount') {
//		typenubmer="受伤事故"+row.hurtcount+"起：";
//	}
//    
//	txt += '<div><span style="font-size:9pt;font-family:宋体;color:#000060">'+"["+jgmc+"]" + '</span></div>';
//    txt += "<div>"+'<span style="font-size:9pt;font-family:宋体;color:#000060">'+typenubmer + '</span></div>';
// 
    
    SysTool.window
	.open({
		    width : 600,
		    height : 'auto',
			title : titleName,
			url : 'project/zhdd/pages/jtjjxx.jsp'
	
	}, function(html) {
// SysTool.setTxtVal("jtjj_jgdm", jgdm);
// SysTool.setTxtVal("jtjj_fxsjs", fxsjs);
// SysTool.setTxtVal("jtjj_fxsje", fxsje);
// SysTool.setTxtVal("jtjj_fun", fun);
//		$('#jgmcinfo').html(txt);
		SysTool.setTxtVal("jjxx_bbtj_title", titleName);
	
		bbtj.jtjjquery(jgdm,fxsjs,fxsje,fun,msg,subject,term);
	});
    
}  
function jtjjrowformater(value, row, index) {
	var jjsj= row.jjsj;
	var bjdh= " 报警电话："+row.bjdh+",";
	var jjxxinfo = row.jqxx;
	var info="";
	
	info+= jjsj+bjdh+jjxxinfo;
	
	return info;
}


function Exproter(type,jgmc) {
	 var rows=''; 
	 var oXL ="";//创建AX对象excel
	 try {
		 oXL = new ActiveXObject('Excel.Application');
     }catch (e) {
    	 SysTool.alert("无法启动Excel!\n请确认您的电脑中是否已经安装Excel，"+"并请将系统url地址设置为信任站点");
         return false;
     }
	 var oWB = oXL.Workbooks.Add(); //获取workbook对象
	 var oSheet = oWB.ActiveSheet; //激活当前sheet
	 if(type=='1'){
		
		 rows = $('#zhdd_bbtj_zd_query').datagrid('getRows');
		 oSheet.Cells(1, 1).value = jgmc+"统计情况：";
		 oSheet.Cells(2, 1).value = "所属中队辖区 ";
	 }
	 if(type=='2'){
		  rows = $('#bbtjgrid').datagrid('getRows');
		 oSheet.Cells(1, 1).value = "支队统计情况：";
		 oSheet.Cells(2, 1).value = "所属大队辖区 ";
	 }
	 
	 
	    //定义列宽  
	    oSheet.Columns('A:A').ColumnWidth = 30;  
	    oSheet.Columns('B:B').ColumnWidth = 15; 
	    oSheet.Columns('C:C').ColumnWidth = 15;  
	    oSheet.Columns('D:D').ColumnWidth = 15;  

	

 oSheet.Cells(2, 2).value = "事故总次数 ";
 oSheet.Cells(2, 3).value = "死亡 ";
 oSheet.Cells(2, 4).value = "伤人 ";
 for (var i = 0; i < rows.length; i++) {
	
	 if(i==rows.length-1){
	
		 var jjrdwmc=rows[i].jjrdwmc;
		 var newjjrdwmc=jjrdwmc.substr(23,jjrdwmc.length);
		 oSheet.Cells(i+3, 1).value = newjjrdwmc.replace(new RegExp('</div>', 'g'), '');
		 oSheet.Cells(i+3, 2).value ="";
		 oSheet.Cells(i+3, 3).value ="";
		 oSheet.Cells(i+3, 4).value ="";
		 oSheet.Rows(i + 3 +":"+i + 3).RowHeight =50; 
//		 
//		 oSheet.Range(oSheet.cells(i+3,1),oSheet.Cells(i+3,2)).Select;  
////		
//		 oSheet.Selection.Merge();//合并选取的单元格  
//		 oSheet.Selection.WrapText=true;//设置自动换行 
		 
//		 oSheet.Range(oSheet.cells(i,1),oSheet.cells(i,3)).select();
//		 oSheet.Selection.HorizontalAlignment = 3;

//		 oSheet.Selection.MergeCells = true;
		 }
	 
	 if(i<rows.length-1 && i>rows.length-5){
		 oSheet.Cells(i + 3, 1).value = rows[i].jjrdwmc;
		 oSheet.Cells(i + 3, 2).value = rows[i].zhddcount; 
	 } 
	 if(i<=rows.length-5){
		 oSheet.Cells(i + 3, 1).value = rows[i].jjrdwmc;
		 oSheet.Cells(i + 3, 2).value = rows[i].zhddcount;
		 oSheet.Cells(i + 3, 3).value = rows[i].deadtotal;
		 oSheet.Cells(i + 3, 4).value = rows[i].hurttotal;
	 }


 }
 oXL.Visible = true; //设置excel可见属性
 

}


function downloadfile(param,dwmc,msg) {
	//var  date1=bbtj.formatDate(new Date());
    var url = 'jqxx/exportDataToExcel.f?param='+param;  
	 var form=$("<form>");//定义一个form表单
	 form.attr("style","display:none");
	 form.attr("target","");
	 form.attr("method","post");
	 form.attr("action",url);
	 var input1=$("<input>");
	 input1.attr("type","hidden");
	 input1.attr("name","xslname");
	 input1.attr("value",dwmc+"（"+msg+"）");
	 var input2=$("<input>");
	 input2.attr("type","hidden");
	 input2.attr("name","titlename");
	 input2.attr("value",dwmc+"（"+msg+"）");
	 $("body").append(form);//将表单放置在web中
	 form.append(input1);
	 form.append(input2);
	 form.submit();//表单提交
}


function GetDateStr(AddDayCount) 
{ 
var dd = new Date(); 
dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期 
var y = dd.getYear(); 
var m = dd.getMonth()+1;//获取当前月份的日期 
var d = dd.getDate(); 
return y+"-"+m+"-"+d+" 08:00:00"; 
} 


