<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@ include file="/WEB-INF/pages/gpsControl.html"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    String id = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
        id = ""+userInfo.getUserOrgId();
    }
 %>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath%>/js/ssyj/FusionCharts.js"></script>
<script type="text/javascript">
    var userOrgCode = "<%=userOrgCode%>"; 
    var userOrgName = "<%=userOrgName%>";
    var bjzbz = "<%=bjzbz%>";
    var id = "<%=id%>";
    
   	var openFlag = false;//地图是否放大
    function bs(){
    	if(openFlag == false){
    	    //$("#lay").layout("collapse","west");
    		$("#up").css("height","690px");
    	    $("#down").css("height","1");
    	    //bigger
    	    openFlag = true;
    	}else if(openFlag == true){
    	    //$("#lay").layout("expand","west");
    		$("#up").css("height","440px");
    	    $("#down").css("height","250px");
    		openFlag = false;
    	}
    };
    
    function help(){
    	$.messager.show({
			title: '图标说明',
			width: 650,
			height: 195,
			msg: '<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%" align="center" style="padding-left: 10px;">' +
	        ' <tr class="dialogTr"> ' +
			    	'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/aj_dao.png" border="0" width="25" height="25"></img>治安案件 ' +
					'</td> ' +
			    	'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/aj_fang.png" border="0" width="25" height="25"></img>刑事案件 ' +
					'</td> ' +
					'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/aj_pian.png" border="0" width="25" height="25"></img>其他 ' +
					'</td> ' +
			    	'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/sj.png" border="0" width="25" height="25"></img>事件 ' +
					'</td> ' +
					'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/zdrk.png" border="0" width="21" height="21"></img>重点人口 ' +
					'</td> ' +
		   '	</tr>	 ' +
		   	'<tr class="dialogTr"> ' +
			    	'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/jq_qz.png" border="0" width="25" height="25"></img>警情(救助群众) ' +
					'</td> ' +
					'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/jq_tj.png" border="0" width="25" height="25"></img>警情(调解纠纷) ' +
					'</td> ' +
			    	'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/jq_xs.png" border="0" width="25" height="25"></img>警情(刑事案件) ' +
					'</td> ' +
					'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/jq_za.png" border="0" width="25" height="25"></img>警情(治安案件) ' +
					'</td> ' +
					'<td width="20%" class="dialogTd" align="left"> ' +
						'<img src="<%=contextPath%>/images/map/icons/sj.png" border="0" width="25" height="25"></img>事件 ' +
					'</td> ' +
		   	'</tr> ' +
        ' </table> ' ,
			timeout: 20000,
			showType:'slide'
		});
    }
    
</script>
</HEAD>
<body>
	<div class="easyui-layout" style="" fit="true" id="lay">
		
        <div data-options="region:'west',split:false, iconCls:'icon-back'" title="菜单" style="width:295px; " id="left">
        
        	<div class="easyui-accordion" style="width:292px; height:633px;" id="acc" data-options="animate:false">
		        <div title="显示设置" data-options="iconCls:''" style="overflow:auto;padding:10px; ">
		            <iframe id="xssz" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/query|xjOption"></iframe>
		        </div>
		        <div title="区域范围" data-options="iconCls:''" style="padding:10px;">
					<iframe id="qyfw" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>
	    		</div>
		        <div title="重点人口" data-options="iconCls:''" style="padding:10px;">
		        	<iframe id="zdrk" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>
		        </div>
		        <div title="警情" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="jq" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>     
		        </div>
		        <div title="案件" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="aj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>         
		        </div>
		        <div title="事件" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="sj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>      
		        </div>
		        <div title="巡逻路线" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="xllx" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>        
		        </div>
		        <div title="巡逻车" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="xlc" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>        
		        </div>
		        <div title="巡逻员" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="xly" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>   
		        </div>
		        <div title="四色预警" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="ssyj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>       
		        </div>
		        <div title="警情分析" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="jqfx" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>       
		        </div>
		        <!-- 
		        <div title="可防性案件分析" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="kxxaj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>      
		        </div>
		         -->
		    </div>
        </div>
        <div id="tt">
        <a href="javascript:void(0);" onclick="bs();" title="" id="big" style="font-weight: bold;" 
			onmouseover="this.style.color='red'; this.style.fontSize='13';" onmouseout="this.style.color='green'; this.style.fontSize='12';">
			<span class="easyui-tooltip" id="more" style="font-weight:'bold'">>></span></a>
		&nbsp;&nbsp;	
		<a href="javascript:void(0);" onclick="help();" title="图标说明 " id="help" style="font-weight: bold;" 
			onmouseover="this.style.color='red'; this.style.fontSize='13';" onmouseout="this.style.color='green'; this.style.fontSize='12';">
			<img src="<%=contextPath%>/common/jeasyui/themes/icons/normal_tip.png" border="0"></img></a>
		</div>
        <div data-options="region:'center',iconCls:'icon-search'" title="地图" id="map" tools="#tt">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'north',split:true,border:false" style="height:440px" id="up">
                	
                </div>
                <div data-options="region:'center',border:false" class="easyui-layout" id="downLayout" fit="true" style="height:" id="down" >
                	<div class="easyui-tabs" style="" id="tabs" fit="true" >
				        <div title="重点人口" style="padding:5px;">
				        <!-- <%=contextPath%>/forward/query|xjQueryListDown -->
				            <iframe id="zdrks" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				        <div title="警情" style="padding:5px;">
				        	<iframe id="jqs" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				        <div title="案件" style="padding:5px;">
				        	<iframe id="ajs" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				        <div title="事件" style="padding:5px;">
				        	<iframe id="sjs" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				        <div title="巡逻路线" style="padding:5px;">
				        	<!-- add by wuw start -->
				        	<iframe id="xllxs" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        	<!-- add by wuw end -->
				        </div>
				        <div title="巡逻车" style="padding:5px;">
				        	<iframe id="xlc_" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				        <div title="巡逻员" style="padding:5px;">
				        	<iframe id="xly_" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				        <div title="四色预警" style="padding:5px;">
				        	<iframe id="ssyj_" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				         <!-- add by wuw 20150124 start -->
				        <div title="警情分析" style="padding:5px;">
				        	<iframe id="jqfxs" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				        <!-- add by wuw 20150124 end -->
				    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- hx -->
    <div id="winser"   class="easyui-window" title="统计图" style="width:800px;height:400px;display:none"   
        data-options="iconCls:'icon-save',modal:false">   
		 <div id="chartdiv1" align="center" ></div>
	</div>  
    <!-- hx -->
</body>
<script type="text/javascript">
	<!--
	//hx
	function zdParms(p1, p2){
		document.getElementById("ssyj_").contentWindow.init(p1, p2);
	}
	function zdParms_ssyj(josn){
	    document.getElementById("chartdiv1").innerHTML="";
        var data="";
	    var data=josn;
	    //var myChart=new FusionCharts(contextPath+"/js/ssyj/swf/Column2D.swf","统计结果","800","400");
	    var myChart=new FusionCharts(contextPath+"/js/ssyj/swf/MSColumn2D.swf","统计结果","800","400");
	        myChart.setJSONData(data);
		    myChart.render("chartdiv1");
			 document.getElementById("winser").style.display="block";
			 $('#winser').window('open');  
	}
	
	//修改
	function zdParm_tjt(kk,ssyj_zzjgdm,ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr){
	     var mapWindow =frames["biz_center"];
         mapWindow.XjMap.showcx_(kk,ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr);
	}
	
	//hx en
	
	//父页面全局变量
	var markerArrJq = new Array();
	var markerArrAj = new Array();
	var markerArrSj = new Array();
	var markerArrQysz = new Array();
	var markerArrZdrk = new Array();
	//用于子页面
	var options = "";
	var pnodes = "";
	//四色预警
	var allmark_FJ_ssyjs=new Array();
	var allmark_PCS_ssyjs=new Array();
	var allplane_FJ_ssyjs=new Array();
	var allplane_PCS_ssyjs=new Array();

	
	//子窗口调用的方法[查询页面参数长度都不长，这里采用url传参]
	function zdParm(parm, flag){
		if("zdrk" == flag){
			document.getElementById("zdrks").src = "<%=contextPath%>/forward/query|xjQueryListDown" + parm;
		} else if("jq" == flag){
			document.getElementById("jqs").src = "<%=contextPath%>/forward/query|xjJqQueryListDown" + parm;
		} else if("aj" == flag){
			document.getElementById("ajs").src = "<%=contextPath%>/forward/query|xjAjQueryListDown" + parm;
		} else if("sj" == flag){
			document.getElementById("sjs").src = "<%=contextPath%>/forward/query|xjSjQueryListDown" + parm;
		} else if("jq_clear" == flag){
			document.getElementById("jqs").contentWindow.clearPoints();
		} else if("aj_clear" == flag){
			document.getElementById("ajs").contentWindow.clearPoints();
		} else if("sj_clear" == flag){
			document.getElementById("sjs").contentWindow.clearPoints();
		} else if("zdrk_clear" == flag){
			//document.getElementById("zdrks").contentWindow.clearPoints();
		} else if("option" == flag){
			options = parm;
		} else if("msg" == flag){
			setOpt(parm);
		} 
		//hx
		 else if("xly" == flag){
				document.getElementById("xly_").src = "<%=contextPath%>/forward/query|xlyQueryListDown" + parm;
			} else if("xlc" == flag){
				document.getElementById("xlc_").src = "<%=contextPath%>/forward/query|xlcQueryListDown" + parm;
			}
		//hx
		
		//hx begin
		else if("ssyj" == flag){
			document.getElementById("ssyj_").src = "<%=contextPath%>/forward/query|xjSsyjQueryListDown" + parm;
		} else if("ssyj_clear" == flag){
			document.getElementById("ssyj_").contentWindow.clearPoints();
		}
		//hx end
		//add by wuw start
		else if('xllx' == flag){
			document.getElementById("xllxs").src = '<%=contextPath%>/forward/query|patrolLine_list' + parm;
		}//add by wuw end
		// add by wuw 20150124 start
		else if('jqfx' == flag){
			document.getElementById("jqfxs").src = '<%=contextPath%>/forward/query|alermAnalysis_list' + parm;
		}
		// add by wuw 20150124 end
	}
	
	//显示设置
	function setOpt(parm){
		var par = new Array();
		par = parm.split(",");
		var temp = ['qyfw', 'zdrk', 'jq', 'aj', 'sj', 'xlxl', 'xlc', 'xly', 'ssyj', 'jqfx', 'xljh', 'kffx'];
		for(var i=temp.length-1; i>=0; i--){
			for(var j=0; j<par.length; j++){
				if(temp[i] == par[j]){
					temp.splice(i, 1);
					break;
				}
			}
		}
		for(var i=0; i<temp.length; i++){
			if("zdrk" == temp[i]){
				if (document.getElementById("zdrks").src != "") {
					document.getElementById("zdrks").contentWindow.clearPoints();
				}
			} else if("jq" == temp[i]){
				if (document.getElementById("jqs").src != "") {
					document.getElementById("jqs").contentWindow.clearPoints();
				}
			} else if("aj" == temp[i]){
				if (document.getElementById("ajs").src != "") {
					document.getElementById("ajs").contentWindow.clearPoints();
				}
			} else if("sj" == temp[i]){
				if (document.getElementById("sjs").src != "") {
					document.getElementById("sjs").contentWindow.clearPoints();
				}
			} else if("qyfw" == temp[i]){
				if (document.getElementById("qyfw").src != "") {
					document.getElementById("qyfw").contentWindow.clearPoints();
				}
			} 
			//hx 
			else if("xly" == temp[i]){
				if (document.getElementById("xly_").src != "") {
					document.getElementById("xly_").contentWindow.clearPoints();
				}
			}  else if("xlc" == temp[i]){
				if (document.getElementById("xlc_").src != "") {
					document.getElementById("xlc_").contentWindow.clearPoints();
				}
			} 
			//hx
			
			//hx
			else if("ssyj" == temp[i]){
				if (document.getElementById("ssyj_").src != "") {
					document.getElementById("ssyj_").contentWindow.clearPoints();
				}
			}
		}
		$.messager.show({
			title: '系统消息',
			msg: "设置成功！",
			timeout: 2000,
			showType:'slide'
		});
	}
	
	//全局变量，用于限制第一次访问才刷新页面
	var num = 0;
	var num1 = 0;
	var num2 = 0;
	var num3 = 0;
	var num4 = 0;
	var num5 = 0;
	//add by wuw start
	var num6 = 0;
	var num10 = 0;
	var num11 = 0;
	//add by wuw end
	
	$(function(){
		//在这里加载地图，显示的比较流程
		document.getElementById("up").innerHTML = '<iframe id="biz_center" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/xj|xjMap"></iframe>';
		 //恒星
		$("#winser").window("close");  // close a window 
		//end
		
		//$("#acc").accordion('remove', '区域范围');
		//左侧手风琴
		$("#acc").accordion({
			onSelect: function(res){
				if(res == '显示设置'){
					if(num == 0){
						document.getElementById("xssz").src = "<%=contextPath%>/forward/query|xjOption";
					}
					num++;
				} else if(res == '区域范围'){
					if(num1 == 0){
						//createTree();
						document.getElementById("qyfw").src = "<%=contextPath%>/forward/query|orgTree";
					}
					num1++;
				} else if(res == '重点人口'){
					$("#tabs").tabs("select", res);
					if(num2 == 0){
						document.getElementById("zdrk").src = "<%=contextPath%>/forward/query|xjQueryList";
					}
					num2++;
				} else if(res == '警情'){
					$("#tabs").tabs("select", res);
					if(num3 == 0){
						document.getElementById("jq").src = "<%=contextPath%>/forward/query|xjJqQueryList";
					}
					num3++;
				} else if(res == '案件'){
					$("#tabs").tabs("select", res);
					if(num4 == 0){
						document.getElementById("aj").src = "<%=contextPath%>/forward/query|xjAjQueryList";
					}
					num4++;
				} else if(res == '事件'){
					$("#tabs").tabs("select", res);
					if(num5 == 0){
						document.getElementById("sj").src = "<%=contextPath%>/forward/query|xjSjQueryList";
					}
					num5++;
				} else if(res == '巡逻路线'){
					//add by wuw start
					$("#tabs").tabs("select", res);
					if(num6 == 0){
						document.getElementById("xllx").src = "<%=contextPath%>/forward/query|patrolLine_ope";
					}
					num6++;
					//add by wuw end
				} else if(res == '巡逻车'){
					$("#tabs").tabs("select", res);
					document.getElementById("xlc").src = "<%=contextPath%>/forward/query|xlcQueryList";
				} else if(res == '巡逻员'){
					$("#tabs").tabs("select", res);
					document.getElementById("xly").src = "<%=contextPath%>/forward/query|xlyQueryList";
				} else if(res == '四色预警'){
					$("#tabs").tabs("select", res);
					document.getElementById("ssyj").src = "<%=contextPath%>/forward/query|xjSsyjQueryList";
				} 
				else if(res == '警情分析'){
					//add by wuw 20150124 start
					$("#tabs").tabs("select", res);
					//add by wuw 20150124 end
					//add by wuw start
					if(num10 == 0){
						document.getElementById("jqfx").src = "<%=contextPath%>/forward/query|alermAnalysis_ope";
					}
					num10++;
					//add by wuw end
				} else if(res == '可防性案件分析'){
					//add by wuw start
					if(num11 == 0){
						document.getElementById("kxxaj").src = "<%=contextPath%>/forward/query|feasilistyCase_ope";
					}
					num11++;
					//add by wuw end
				} 
			}
		});
		
		//下方tab
		var tab = 0;
		var tab1 = 0;
		var tab2 = 0;
		var tab3 = 0;
		var tab4 = 0;
		var tab5 = 0;
		//add by wuw start
		var tab6 = 0;
		//add by wuw end
		//add by wuw 20150124 start
		var tab10 = 0;
		//add by wuw 20150124 end
		
		var date = new Date()
		var y = date.getFullYear();
		var m = date.getMonth()+1+'';
		if(m.length != 2){
			m = '0'+m;
		}
		var d = date.getDate()+'';
		if(d.length != 2){
			d = '0'+d;
		}
		var last = y + "-" + m + "-" + d;
		var par = "?fqsj=" + last + "&jssj=" + last;
		
		$("#tabs").tabs({
			onSelect: function(res){
				if(res == '显示设置'){
					if("0" == tab){
						document.getElementById("xssz").src = "<%=contextPath%>/forward/query|xjQueryList";
					}
					tab++;
				} else if(res == '区域范围'){
					//document.getElementById("qyfw").src = "<%=contextPath%>/forward/query|xjQueryList";
					if("0" == tab1){
					}
					tab1++;
				} else if(res == '重点人口'){
					if("0" == tab2){
						document.getElementById("zdrks").src = "<%=contextPath%>/forward/query|xjQueryListDown";
					}
						tab2++;
					//$("#acc").accordion("select", res);
				} else if(res == '警情'){
					if("0" == tab3){
						document.getElementById("jqs").src = "<%=contextPath%>/forward/query|xjJqQueryListDown" + par;
					}
						tab3++;
					//$("#acc").accordion("select", res);
				} else if(res == '案件'){
					if("0" == tab4){
						document.getElementById("ajs").src = "<%=contextPath%>/forward/query|xjAjQueryListDown" + par;
						tab4++;
					}
					//$("#acc").accordion("select", res);
				} else if(res == '事件'){
					if("0" == tab5){
						document.getElementById("sjs").src = "<%=contextPath%>/forward/query|xjSjQueryListDown" + par;
					}
					tab5++;
					//$("#acc").accordion("select", res);
				} else if(res == '巡逻路线'){
					//add by wuw start
					if("0" == tab6){
						document.getElementById("xllxs").src = "<%=contextPath%>/forward/query|patrolLine_list";
						tab6++;
					}
					//add by wuw end
				} else if(res == '巡逻车'){
					$("#tabs").tabs("select", res);
					document.getElementById("xlc_").src = "<%=contextPath%>/forward/query|xlcQueryListDown";
				} else if(res == '巡逻员'){
					$("#tabs").tabs("select", res);
					document.getElementById("xly_").src = "<%=contextPath%>/forward/query|xlyQueryListDown";
				} else if(res == '四色预警'){
					$("#tabs").tabs("select", res);
					document.getElementById("ssyj_").src = "<%=contextPath%>/forward/query|xjSsyjQueryListDown";
				} else if(res == '警情分析'){
					//document.getElementById("jqfx").src = "<%=contextPath%>/forward/query|xjQueryList";
					//add by wuw 20150124 start
					if("0" == tab10){
						document.getElementById("jqfxs").src = "<%=contextPath%>/forward/query|alermAnalysis_list";
						tab10++;
					}
					//add by wuw 20150124 end
				} else if(res == '可防性案件分析'){
					document.getElementById("kxxaj").src = "<%=contextPath%>/forward/query|xjQueryList";
				} 
			}
		});
		
		//tip
		$("#more").tooltip({
        	position: 'left',
        	content: '<span style="color:#fff"; font-size:"10"; >展开地图/收起地图</span>',
        	onShow: function(){
        		$(this).tooltip('tip').css({
        			backgroundColor: '#666',
        			borderColor: '#666'
        		});
        	}
        });
        $("#more").tooltip('show');
        
	});
	-->
</script>

</HTML>