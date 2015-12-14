<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonJzInclude.jsp"%>
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
	//地图是否放大
   	var openFlag = false;
    function bs(){
    	if(openFlag == false){
    		$("#up").css("height","690px");
    	    $("#down").css("height","1");
    	    //bigger
    	    openFlag = true;
    	}else if(openFlag == true){
    		$("#up").css("height","440px");
    	    $("#down").css("height","250px");
    	    //smaller
    		openFlag = false;
    	}
    };
    
    //全局变量组织机构代码
    var orgcodeTotal = userOrgCode;
    
    //是否显示四色预警切换图标
    var isFlag = false;
    var par = "";
    var fla = "";
    function ta(){
    	if(fla == 'ssyj_tj'){
   			document.getElementById("ssyj").contentWindow.showbegin_("0");
   			document.getElementById("img").src = "<%=contextPath%>/images/navigator/lunbo-2.png";
    	}else if(fla == 'ssyj'){
   			document.getElementById("ssyj").contentWindow.showbegin_("1");
   			document.getElementById("img").src = "<%=contextPath%>/images/navigator/bzdzhs.png";
    	}
    };
    
    //随侧边条点击切换左侧菜单
    var change1 = 0;
    var change2 = 0;
    function removerAcc(title){
    	if(title == 'ssdt'){
    		$("#_jqcx").addClass("lf_tabon");
    		$("#_jbxx").removeClass("lf_tabon");
    		$("#_jwts").removeClass("lf_tabon");
    		//document.getElementById("ssdt").src = "<%=contextPath%>/forward/jzym|ssdt|jzSsdtQueryList"
    		document.getElementById("acc").style.display = '';
    		document.getElementById("accs").style.display = 'none';
    		document.getElementById("accss").style.display = 'none';
    	} else if("cxtj"== title){
    		$("#_jqcx").removeClass("lf_tabon");
    		$("#_jbxx").addClass("lf_tabon");
    		$("#_jwts").removeClass("lf_tabon");
    		document.getElementById("acc").style.display = 'none';
    		document.getElementById("accs").style.display = '';
    		document.getElementById("accss").style.display = 'none';
    		if(change1 == 0){
	    		document.getElementById("jbxx").src = "<%=contextPath%>/forward/jzym|jqcx|jzJqQueryList";
	    		change1++;
    		}
    	} else if("fxgj"== title){
    		$("#_jqcx").removeClass("lf_tabon");
    		$("#_jbxx").removeClass("lf_tabon");
    		$("#_jwts").addClass("lf_tabon");
    		document.getElementById("acc").style.display = 'none';
    		document.getElementById("accs").style.display = 'none';
    		document.getElementById("accss").style.display = '';
    		if (change2 == 0) {
	    		document.getElementById("jqtj").src = "<%=contextPath%>/forward/jzym|jqtj|jzJqQuery"
				change2++;
			}
    		//document.getElementById("jwts").src = "<%=contextPath%>/forward/jzym|jwts|jwtsList";
    	}
    }
    
</script>
<style>
/*-- 左侧切换菜单 --*/
.lf_tabli{ width:36px; position:absolute; top:0; left:295px;top:28px; text-align:center; z-index:9999;}
.lf_tabli div{ display:block; width:36px; background:#f1e9dc; text-align:center; color:#2c3e50; position:relative;cursor:pointer;}
.lf_tabli .lf_tabon{ background:#f24f46; color:#f1e9dc;}

.lftab_jqcx{ display:block; width:36px; height:50px; background:url(<%=contextPath%>/jzym/tabicon_dxcx.png) center 15px no-repeat;}
.lf_tabon .lftab_jqcx{background:url(<%=contextPath%>/images/jzym/tabicon_dxcx_on.png) center 15px no-repeat;}
.lftab_ajcx{ display:block; width:36px; height:50px; background:url(<%=contextPath%>/images/jzym/tabicon_ajcx.png) center 15px no-repeat;}
.lf_tabon .lftab_ajcx{background:url(<%=contextPath%>/images/jzym/tabicon_ajcx_on.png) center 15px no-repeat;}

.lf_tabli .lftab_txt{display:block; width:20px; margin:0 auto; font-size:13.8px;letter-spacing:1px;word-wrap: break-word; }
.lf_tabli a.lftab_1{ display:block; width:36px; height:30px; background:none;}
.lf_tabli a.lftab_2{ background:url(<%=contextPath%>/images/jzym/lftab_2.png) center no-repeat;}
.lf_tabsanj{ display:block; width:13px; height:19px; position:absolute; left:-12px; top:45%; background:url(<%=contextPath%>/images/jzym/lf_tabsanj.png) no-repeat;display:none;}
.lf_tabon .lf_tabsanj{ display:block;}
.lf_tabon a.lftab_1{ background:url(<%=contextPath%>/images/jzym/lftab_1.png) center no-repeat;}

.shadow{margin-top:5px; border-bottom:2px solid  #8e8e8e; border-top:0px solid  #8e8e8e; border-right:2px solid  #8e8e8e;}
</style>
</HEAD>
<body>
	<div class="easyui-layout" style="" fit="true" id="lay">
		
        <!-- 左侧切换菜单 -->
        <div class="lf_tabli" style="display: ;" id="lf">
         	<div class="lf_tabon shadow" id="_jqcx" onclick="removerAcc('ssdt')" 
         		style="margin-top:5px;">
	          	<span class="lf_tabsanj"></span>
	          	<span style="height: 3px;"></span>
	          	<span class="lftab_txt" >实时动态</span>
	          	<span style="height: 3px;"></span>
         	</div>
         	<div class=" shadow" id="_jbxx"  onclick="removerAcc('cxtj')">
	          	<span class="lf_tabsanj"></span>
	          	<span style="height: 3px;"></span>
	          	<span class="lftab_txt" >查询统计</span>
	          	<span style="height: 3px;"></span>
         	</div>
         	<div class="shadow" id="_jwts" onclick="removerAcc('fxgj')">
	          	<span class="lf_tabsanj"></span>
	          	<span style="height: 3px;"></span>
	          	<span class="lftab_txt" >分析工具</span>
	          	<span style="height: 3px;"></span>
         	</div>
        </div>
       	<!-- /左侧切换菜单 -->
       	
       	<div id="th">
		<a href="javascript:void(0);" onclick="ta();" title="" id="tha" style="font-weight: bold; display: none; z-index:9999;">
			<span class="easyui-tooltip" id="chas" style="font-weight:'bold'">
				<img src="<%=contextPath%>/images/jzym/lf_tp_1b.png" height="16" width="16" border="0" id="img"></img>
			</span>
		</a>
		<a href="javascript:void(0);" onclick="ta();" title="" id="tha" style="font-weight: bold; display: none; z-index:9999;">
			<span class="easyui-tooltip" id="chas" style="font-weight:'bold'">
				<img src="<%=contextPath%>/images/jzym/lf_tp_3b.png" height="16" width="16" border="0" id="img"></img>
			</span>
		</a>
		<a href="javascript:void(0);" onclick="ta();" title="" id="tha" style="font-weight: bold; display: none; z-index:9999;">
			<span class="easyui-tooltip" id="chas" style="font-weight:'bold'">
				<img src="<%=contextPath%>/images/jzym/lf_tp_2b.png" height="16" width="16" border="0" id="img"></img>
			</span>
		</a>
		</div>
        <div data-options="region:'west',split:false, iconCls:'icon-back'" title="菜单" style="width:295px; overflow-y:hidden;" id="left" tools="#th">
        	<div class="easyui-accordion" style="width:292px; height:580px;" id="acc" data-options="animate:false">
		        <div title="实时动态" data-options="iconCls:''" style="padding:10px;" id=jqcx1>
		            <iframe id="ssdt" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|ssdt|jzSsdtQueryList"></iframe>
		            <!-- 
		            <iframe id="jq" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|ssdt|jzSsdtQueryList"></iframe>
		             -->     
		        </div>
		    </div>
		    <p>
		    <div class="easyui-accordion" style="width:292px; height:580px; " id="accs" data-options="animate:false">
		        <div title="警情查询" data-options="iconCls:''" style="padding:10px;" id='a'>
		            <iframe id="jbxx" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" 
		            	src="<%=contextPath%>/forward/jzym|jqcx|jzJqQueryList"></iframe>     
		        </div>
		        <div title="辖区统计" data-options="iconCls:''" style="padding:10px;" id='x'>
		            <iframe id="xqtj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" 
		            	src=""></iframe>     
		        </div>
		    </div>
		    <div class="easyui-accordion" style="width:292px; height:580px;" id="accss" data-options="animate:false">
		        <!--  
		        <div title="分析工具" data-options="iconCls:''" style="padding:10px;">
		            <iframe id="jwts" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>       
		        </div>
		        -->
		        <div title="警情统计" data-options="iconCls:''" style="padding:10px;" id="jqtj1 ">
		            <iframe id="jqtj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>     
		        </div>
		         <div title="警情同比分析" data-options="iconCls:''" style="padding:10px;" id="jqtb1">
		            <iframe id="jqdb" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>     
		        </div>
		        <div title="四色预警" data-options="iconCls:''" style="padding:10px;" id="ssyj1">
		            <iframe id="ssyj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>       
		        </div>
		    </div>
        </div>
        <div id="tt">
        <a href="javascript:void(0);" onclick="bs();" title="" id="big" style="font-weight: bold; display: none;"
			onmouseover="this.style.color='red'; this.style.fontSize='13';" onmouseout="this.style.color='green'; this.style.fontSize='12';">
			<span class="easyui-tooltip" id="more" style="font-weight:'bold'">>></span></a>
		&nbsp;&nbsp;	
		<a href="javascript:void(0);" onclick="ta();" title="" id="cha" style="font-weight: bold; display: none; z-index:9999;">
			<span class="easyui-tooltip" id="chas" style="font-weight:'bold'">
				<img src="<%=contextPath%>/images/navigator/lunbo-2.png" height="16" width="16" border="0" id="img"></img>
			</span>
		</a>
		</div>
        <div data-options="region:'center',iconCls:'icon-search'" title="展示" id="map" tools="#tt">
            <div class="easyui-layout" data-options="fit:true" id="show">
                <div data-options="region:'north',split:true,border:false" style="height:440px" id="up">
                	
                </div>
                <div data-options="region:'center',border:false" class="easyui-layout" id="downLayout" fit="true" style="height:" id="down" >
                	<div class="easyui-tabs" style="" id="tabs" fit="true" >
				        <div title="警情查询" style="padding:5px;">
				        	<iframe id="jqs" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				          <div title="在线警车" style="padding:5px;">
				        	<iframe id="jwts_" style="width: 100%;height: 160px;" noresize scrolling="no" frameborder="no" src=""></iframe>
				        </div>
				    </div>
                </div>
            </div>
            <!-- 统计图 -->
            <div class="easyui-layout" data-options="fit:true" id="chart" style="padding-left: 38px; display: none;">
            	
            </div>
               <!-- 恒星统计图 -->
            <div id="winser"   class="easyui-window" title="统计图" style="width:800px;height:400px;display:none"  data-options="iconCls:'icon-save',modal:false">   
               <div id="chartdiv1" align="center" ></div>
             </div>  
        </div>
    </div>
</body>
<script type="text/javascript">
	<!--
	//父页面全局变量
	var markerArrJq = new Array();
	var markerArrAj = new Array();
	var markerArrSj = new Array();
	var markerArrQysz = new Array();
	var markerArrZdrk = new Array();
	//用于子页面
	var options = "";
	var pnodes = "<%=userOrgCode%>";
	//子窗口调用的方法[查询页面参数长度都不长，这里采用url传参]
	function zdParm(parm, flag){
		if("jq" == flag){
			$("#up").css("height","440px");
    	    $("#down").css("height","250px");
    	    $("#tabs").tabs("select", "警情查询");
    	    //smaller
    	    //点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
			//document.getElementById('biz_center').contentWindow.XjMap.removeMark();
			document.getElementById("jqs").src = "<%=contextPath%>/forward/jzym|jqcx|jzJqQueryListDown" + parm;
			document.getElementById("up").innerHTML = 
				'<iframe id="biz_center" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|jzMap"></iframe>';
			document.getElementById("show").style.display = '';
			document.getElementById("chart").style.display = 'none';
		} else if("jqtj" == flag){
			//点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
			document.getElementById("chart").innerHTML = '<iframe id="charts" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|jqtj|jzChart"></iframe>';
			document.getElementById("charts").src = "<%=contextPath%>/forward/jzym|jqtj|jzChart" + parm;
			document.getElementById("show").style.display = 'none';
			document.getElementById("chart").style.display = '';
		} else if("jqdb" == flag){
			//点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
			document.getElementById("chart").innerHTML = '<iframe id="charts" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|jqdb|jzdbChart"></iframe>';
			document.getElementById("charts").src = "<%=contextPath%>/forward/jzym|jqdb|jzdbChart" + parm;
			document.getElementById("show").style.display = 'none';
			document.getElementById("chart").style.display = '';
		} else if("ssyj" == flag){
			par = parm;
			fla = flag;
			$("#up").css("height","690px");
    	    $("#down").css("height","1");
    	    //bigger
    	    //点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
    	    var obj = document.getElementById("biz_center").contentWindow;
    	    //责任区则不下钻
			 var zero8 = pnodes.substr(pnodes.length-8, pnodes.length);
			 var zero6 = pnodes.substr(pnodes.length-6, pnodes.length);
			 var zero4 = pnodes.substr(pnodes.length-4, pnodes.length);
			 if(zero8 != "00000000" && zero6 != "000000" && zero4 != "0000"){
				 return;
			 }
			obj.XjMap.queryXjZrq(parm);
			document.getElementById("show").style.display = '';
			document.getElementById("chart").style.display = 'none';
			document.getElementById("cha").style.display = "";
			document.getElementById("img").src = "<%=contextPath%>/images/navigator/lunbo-2.png";
		} else if("ssyj_tj" == flag){
			//点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
			par = parm;
			fla = flag;
			document.getElementById("chart").innerHTML 
				= '<iframe id="charts" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|ssyj|ssyjChart"></iframe>';
			document.getElementById("charts").src = "<%=contextPath%>/forward/jzym|ssyj|ssyjChart" + parm;
			document.getElementById("show").style.display = 'none';
			document.getElementById("chart").style.display = '';
			document.getElementById("cha").style.display = "";
			document.getElementById("img").src = "<%=contextPath%>/images/navigator/bzdzhs.png";
		} else if("jwts" == flag){
			$("#up").css("height","440px");
    	    $("#down").css("height","250px");
    	    $("#tabs").tabs("select", "在线警车");
    	    //smaller
			document.getElementById('biz_center').contentWindow.XjMap.removeMark();
			document.getElementById("jwts_").src = "<%=contextPath%>/forward/jzym|jwts|jwtsListDown" + parm;
			document.getElementById("show").style.display = '';
			document.getElementById("chart").style.display = 'none';
		} else if("xqgk" == flag){
			$("#up").css("height","690px");
    	    $("#down").css("height","1");
			//document.getElementById('biz_center').contentWindow.XjMap.removeMark();
			document.getElementById('biz_center').contentWindow.XjMap.queryXjZrqs(parm);
			document.getElementById("show").style.display = '';
			document.getElementById("chart").style.display = 'none';
		} else if("jrjq" == flag){
			$("#up").css("height","690px");
    	    $("#down").css("height","1");
			document.getElementById('biz_center').contentWindow.XjMap.removeMark();
			//add by wuw start
			//document.getElementById('biz_center').contentWindow.XjMap.queryXjZrqs(parm);
			//document.getElementById('biz_center').contentWindow.XjMap.initFloatWin_back();
			document.getElementById('biz_center').contentWindow.jrjq_showAlermInMap(parm);
			//add by wuw end
			document.getElementById("show").style.display = '';
			document.getElementById("chart").style.display = 'none';
		} else if("lktj" == flag){
			//点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
    		document.getElementById("chart").style.display = '';
    		document.getElementById("show").style.display = 'none';
			document.getElementById("chart").innerHTML = 
				'<iframe id="chartLktj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>';
			document.getElementById("chartLktj").src = "<%=contextPath%>/forward/jzym|xqtjChart|jzLktjChart" + parm;
		} else if("sstj" == flag){
			//点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
    		document.getElementById("chart").style.display = '';
    		document.getElementById("show").style.display = 'none';
			document.getElementById("chart").innerHTML = 
				'<iframe id="chartLktj" style="width: 100%;height: 20%;" noresize scrolling="no" frameborder="no" src=""></iframe>'
				+
				'<iframe id="chartLktj1" style="width: 100%;height: 60%;" noresize scrolling="no" frameborder="no" src=""></iframe>'
				+
				'<iframe id="chartLktj2" style="width: 100%;height: 20%;" noresize scrolling="no" frameborder="no" src=""></iframe>';
			document.getElementById("chartLktj1").src = "<%=contextPath%>/forward/jzym|xqtjChart|jzSstjChart" + parm;
		} else if("gzdx" == flag){
			//点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
    		document.getElementById("chart").style.display = '';
    		document.getElementById("show").style.display = 'none';
			document.getElementById("chart").innerHTML = 
				'<iframe id="chartLktj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>';
			document.getElementById("chartLktj").src = "<%=contextPath%>/forward/jzym|xqtjChart|jzGzdxChart" + parm;
		} else if("nltj" == flag){
			//点击时候，将gps查询停止
    		document.getElementById("jwts_").src = "";
    		document.getElementById("chart").style.display = '';
    		document.getElementById("show").style.display = 'none';
			document.getElementById("chart").innerHTML = 
				'<iframe id="chartLktj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>';
			document.getElementById("chartLktj").src = "<%=contextPath%>/forward/jzym|xqtjChart|jzNltjChart" + parm;
		} 
	}
	
	//恒星修改统计图：
		function zdParms_ssyj(josn){
	    document.getElementById("chartdiv1").innerHTML="";
        var data="";
	    var data=josn;
	    var myChart=new FusionCharts(contextPath+"/js/ssyj/swf/MSColumn2D.swf","统计结果","800","400");
	        myChart.setJSONData(data);
		    myChart.render("chartdiv1");
			 document.getElementById("winser").style.display="block";
			 $('#winser').window('open');  
	}
		function zdParm_chars(ssyj_zzjgdm,ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr){
             var mapWindow =frames["biz_center"];
             mapWindow.XjMap.queryXjChar(ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr);
	}
	
	//全局变量，用于限制第一次访问才刷新页面
	var num = 0;
	var num1 = 0;
	var num2 = 0;
	var num3 = 0;
	var num4 = 0;
	
	//是否伸缩
	var isExpand = "yes";
	$(function(){
		//在这里加载地图，显示的比较流畅
		document.getElementById("up").innerHTML = 
			'<iframe id="biz_center" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|jzMap"></iframe>';
		//初始化隐藏下边列表
	    $("#winser").window("close");  // close a window 
		$("#up").css("height","690px");
   	    $("#down").css("height","1");
		//左侧手风琴
		$("#accs").accordion({
			onSelect: function(res){
				if(res == '辖区统计'){
					if(num1 == 0){
						document.getElementById("xqtj").src = "<%=contextPath%>/forward/jzym|xqtj|jzXqtjQueryList";
					}
					document.getElementById("cha").style.display = "none";
					num1++;
				} 
			}
		});
		
		$("#accss").accordion({
			onSelect: function(res){
				if(res == '警情统计'){
					if(num2 == 0){
						document.getElementById("jqtj").src = "<%=contextPath%>/forward/jzym|jqtj|jzJqQuery";
					}
					document.getElementById("cha").style.display = "none";
					num2++;
				} else if(res == '警情同比分析'){
					if(num3 == 0){
						document.getElementById("jqdb").src = "<%=contextPath%>/forward/jzym|jqdb|jzJqdbQuery";
					}
					document.getElementById("cha").style.display = "none";
					num3++;
				} else if(res == '四色预警'){
					if(num4 == 0){
						document.getElementById("ssyj").src = "<%=contextPath%>/forward/jzym|ssyj|jzSsyjQueryList";
					}
					num4++;
				} 
			}
		});
		
		//跟随左侧手风琴菜单决定是否隐藏侧边条
		$("#map").resize(
			function(){
				var ttw = $("map").width();
				if(isExpand == "yes"){
					isExpand = "no";
					$("#lf").hide();
				} else if(isExpand == "no"){
					isExpand = "yes";
					$("#lf").show();	
				}
			}
		);
	});
	-->
</script>

</HTML>