<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.organization.role.bean.OrgRole"%>
<%@ page import="com.founder.framework.organization.right.service.OrgRightPublic"%>
<%@page import="com.founder.xjpt.controller.XjController"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userid = "";
    String httpURI = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userid = userInfo.getUserId();
    }
    httpURI = new XjController().getURL();
    //httpURI = "http://10.80.5.228:9080/DLGA_XJPT_V2";
    //get role begin
    String role = "";
	List<OrgRole> list = new OrgRightPublic().queryUserAssignRole(userid);
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		OrgRole orgRole = (OrgRole) iterator.next();
		String roleName = orgRole.getRolename();
		if("巡警-支队管理员".equals(roleName)){
			role = roleName;
		} else if("巡警-分局管理员".equals(roleName)){
			role = roleName;
		} else if("巡警-派出所管理员".equals(roleName)){
			role = roleName;
		} else if("巡警-巡逻员".equals(roleName)){
			role = roleName;
		}
	}
	System.out.println("rolanme: " + role);
	//get role end
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>首页_巡区统计</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/tabstyle.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/flashChart/swfobject.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/tabChart/event.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/tabChart/tween.js"></script>
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/jquery1.11.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/jquery.easyui.extend.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/common/jeasyui/themes/default/easyui.css" />
    
    <script type="text/javascript">
    <!--
     var orgcode = "<%=userOrgCode%>";
     var userid = "<%=userid%>";
     var contextPath = "<%=request.getContextPath()%>";
     var flags = "month";
     
   	 function getParm(name){
   		  var temp = "";
 	  	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
 	  	  var r = window.location.search.substr(1).match(reg);
 	  	  if(r != null){
 	  		  temp = unescape(r[2]);
 	  	  } 
 	  	  return temp;
       }
      
     //此处用于给金万码传月份参数 begin
     var now = new Date();
     var dateParm = now.getFullYear() + "-" + now.getMonth()+1;
     //此处用于给金万码传月份参数 end
     
      function init(){
     	flags = getParm("flag")!="" ? getParm("flag") : "month" ;
     	dateParm = flags.indexOf("-")==-1 ? dateParm : flags;
     	var role = "<%=role%>";
     	if (role != "巡警-巡逻员") {
     	    isGrade("grid");
		} else {
			isGrade("巡逻员");
		} 
      }
      
      function isGrade(type) {
    		if("grid" == type){
    			document.getElementById("xlyGrid").style.display = "";
    			document.getElementById("xlyGrid").src = "<%=request.getContextPath()%>/forward/sqjw|xlyGrid?flag=" + flags;
    			document.getElementById("xlcGrid").style.display = "";
    			document.getElementById("xlcGrid").src = "<%=request.getContextPath()%>/forward/sqjw|xlcGrid?flag=" + flags;
    			document.getElementById("xqGrid").style.display = "";
   				document.getElementById("xqGrid").src = "<%=request.getContextPath()%>/forward/sqjw|xqGrid?flag=" + flags;
    		}else{
    			document.getElementById("xly").style.display = "";
    			document.getElementById("xlc").style.display = "";
    			document.getElementById("xq").style.display = "";
    			drawChart("init");
    		}
    	}
      
      function drawChart(type){
    	  var vdata = new Date();
    	  var mini = vdata.getMilliseconds();
    	  //query
    	  if("" == "${begin}" && "" == "${entity.userName}" && "" == "${entityc.userName}" && "" == "${entityq.userName}"){
 	     	location.href = "<%=request.getContextPath()%>/homePage/queryXly?type=" + type + "&userid=" + userid + "&flag=" + flags + "&time" + mini;
      	  } 
      }
      
      //巡逻员
      function openPCS(userid){
  		var url = "<%=httpURI%>/evaluation/EvaluationEmployee_Rank.jsp?Identitycard=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=1&Evaldate=" + dateParm;
  		menu_open("巡逻员考核排名明细", url);
    }
    
    function openFJ(userids){
		var url = "<%=httpURI%>/evaluation/EvaluationEmployee_Rank.jsp?Identitycard=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=2&Evaldate=" + dateParm;
		menu_open("巡逻员考核排名明细", url);
    }
    
    function openSJ(userids){
		var url = "<%=httpURI%>/evaluation/EvaluationEmployee_Rank.jsp?Identitycard=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=3&Evaldate=" + dateParm;
		menu_open("巡逻员考核排名明细", url);
    }
    
    function getScore(userids){
		var url = "<%=httpURI%>/evaluation/EvaluationEmployee_Detail.jsp?Identitycard=" + userids + "&Totaltype=0&Evaldate=" + dateParm;
		menu_open("巡逻员考核明细", url);
    }
    
    //巡逻车
    function openPCS_c(userids){
	  		var url = "<%=httpURI%>/evaluation/EvaluationCar_Rank.jsp?Identitycard=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=1&Evaldate=" + dateParm;
	  		menu_open("巡逻车考核排名明细", url);
	    }
	    
	    function openFJ_c(userids){
			var url = "<%=httpURI%>/evaluation/EvaluationCar_Rank.jsp?LicensePlate=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=2&Evaldate=" + dateParm;
			menu_open("巡逻车考核排名明细", url);
	    }
	    
	    function openSJ_c(userids){
			var url = "<%=httpURI%>/evaluation/EvaluationCar_Rank.jsp?LicensePlate=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=3&Evaldate=" + dateParm;
			menu_open("巡逻车考核排名明细", url);
	    }
	    
	    function getScore_c(userids){
			var url = "<%=httpURI%>/evaluation/EvaluationCar_Detail.jsp?LicensePlate=" + userids + "&Totaltype=0&Evaldate=" + dateParm;
			menu_open("巡逻车考核明细", url);
	    }
	    
	    //巡区
	    function openPCS_x(val,row,index){
	  		var userids = row["id"];
	  		var url = "<%=httpURI%>/evaluation/EvaluationDept_Rank.jsp?Identitycard=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=1&Evaldate=" + dateParm;
	  		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡区考核排名明细\", \""+url+"\")')>"+val+"</a></div>";
	    }
	    
	    function openFJ_x(val,row,index){
			var userids = row["id"];
			var url = "<%=httpURI%>/evaluation/EvaluationDept_Rank.jsp?LicensePlate=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=2&Evaldate=" + dateParm;
			return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡区考核排名明细\", \""+url+"\")')>"+val+"</a></div>";
	    }
	    
	    function openSJ_x(val,row,index){
			var userids = row["id"];
			var url = "<%=httpURI%>/evaluation/EvaluationDept_Rank.jsp?LicensePlate=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=3&Evaldate=" + dateParm;
			return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡区考核排名明细\", \""+url+"\")')>"+val+"</a></div>";
	    }
	    
	    function getScore_x(val,row,index){
			var userids = row["id"];
			var url = "<%=httpURI%>/evaluation/EvaluationDept_Detail.jsp?LicensePlate=" + userids + "&Totaltype=0&Evaldate=" + dateParm;
			return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡区考核明细\", \""+url+"\")')>"+val+"</a></div>";
	    }
      -->
    </script>
  </head>
  <body onload="init();" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
    <div class="tabmain">
		<div id="outerWrap">
			<div id="sliderParent" style="display: none;"></div>
			<div class="blueline" id="blueline" style="top: 0px; "></div>
			<ul class="tabGroup" style="margin: 0;padding: 0;">
				 <li class="tabOption selectedTab"><font face="黑体">巡逻员考核</font></li>
				 <li class="tabOption" ><font face="黑体">巡逻车考核</font></li>
				 <li class="tabOption"><font face="黑体">巡区考核</font></li>
			</ul>
			<div id="container">
                 <div id="content">
                    <div class="tabContent selectedContent" style="padding-top:0; padding-bottom: 0; padding-left: 0; padding-right: 0;">
                    <div style="width:100%; height:260px;">
                       <iframe id="xlyGrid" name="xlyGrid" style="width: 100%;height: 100%; display: none;" noresize scrolling="no" frameborder="no" src="" ></iframe>
                       		<table width="100%" style="height: 250px; display: none;" border="0" id="xly">
                       			<colgroup>
                       				<col style="width:40%"/>
                       				<col style="width:60%"/>
                       			</colgroup>
                       			<tr>
                       				<td align="right">巡逻员姓名：</td>
                       				<td>
                       					<label id="">${entity.userName}</label>
                       				</td>
                       			</tr>
                       			<tr>
                       				<td align="right">考核区间：</td>
                       				<td>
                       					<label id="">${entity.evalDate}</label>
                       				</td>
                       			</tr>
                       			<tr>
                       				<td align="right">得分：</td>
                       				<td>
                       					<label id=""><a href="getScore('${entity.userid}');">${entity.score}</a>分</label>
                       				</td>
                       			</tr>
                       			<tr>
                       				<td align="right">派出所排名：</td>
                       				<td>
                       					<label id=""><a href="openPCS('${entity.userid}');">${entity.rankings3}</a>名</label>
                       				</td>
                       			</tr>
                       			<tr>
                       				<td align="right">分局排名：</td>
                       				<td>
                       					<label id=""><a href="openFJ('${entity.userid}');">${entity.rankings2}</a>名</label>
                       				</td>
                       			</tr>
                       			<tr>
                       				<td align="right">市局排名：</td>
                       				<td>
                       					<label id=""><a href="openSJ('${entity.userid}');">${entity.rankings1}</a>名</label>
                       				</td>
                       			</tr>
                       		</table>
                    </div>
                    </div>
                    <div class="tabContent" style="padding-top:0; padding-bottom: 0; padding-left: 0; padding-right: 0;">
                    <div style="width:100%; height:260px;">
                       <iframe id="xlcGrid" name="xlcGrid" style="width: 100%;height: 100%; display: none;" noresize scrolling="no" frameborder="no" src=""></iframe>
                       		<table width="100%" style="height: 250px; display: none;" border="0" id="xlc">
                       			<colgroup>
                       				<col style="width:40%"/>
                       				<col style="width:60%"/>
                       			</colgroup>
                       			<tr>
                       				<td align="right">巡逻车牌号：</td>
                       				<td>
										<label id="">${entityc.userName}</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">考核区间：</td>
                       				<td>
										<label id="">${entityc.evalDate}</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">得分：</td>
                       				<td>
										<label id=""><a href="getScore_c('${entity.userid}');">${entityc.score}</a>分</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">派出所排名：</td>
                       				<td>
										<label id=""><a href="getPCS_c('${entity.userid}');">${entityc.rankings3}</a>名</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">分局排名：</td>
                       				<td>
										<label id=""><a href="getFJ_c('${entity.userid}');">${entityc.rankings2}</a>名</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">市局排名：</td>
                       				<td>
										<label id=""><a href="getSJ_c('${entity.userid}');">${entityc.rankings1}</a>名</label>
									</td>
                       			</tr>
                       		</table>
                    </div>
                    </div>
                    <div class="tabContent" style="padding-top:0; padding-bottom: 0; padding-left: 0; padding-right: 0;">
                    <div style="width:100%; height:260px;">
                       <iframe id="xqGrid" name="xqGrid" style="width: 100%;height: 100%; display: none;" noresize scrolling="no" frameborder="no" src=""></iframe>
                       		<table width="100%" style="height: 250px; display: none;" border="0" id="xq">
                       			<colgroup>
                       				<col style="width:40%"/>
                       				<col style="width:60%"/>
                       			</colgroup>
                       			<tr>
                       				<td align="right">巡区名称：</td>
                       				<td>
										<label id="">${entityq.userName}</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">考核区间：</td>
                       				<td>
										<label id="">${entityq.evalDate}</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">得分：</td>
                       				<td>
										<label id=""><a href="openSource_x('${entity.userid}');">${entityq.score}</a>分</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">派出所排名：</td>
                       				<td>
										<label id=""><a href="openPCS_x('${entity.userid}');">${entityq.rankings3}</a>名</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">分局排名：</td>
                       				<td>
										<label id=""><a href="openFJ_x('${entity.userid}');">${entityq.rankings2}</a>名</label>
									</td>
                       			</tr>
                       			<tr>
                       				<td align="right">市局排名：</td>
                       				<td>
										<label id=""><a href="openSJ_x('${entity.userid}');">${entityq.rankings1}</a>名</label>
									</td>
                       			</tr>
                       		</table>
                    </div>
                    </div>
                    
                 </div>
	         </div>
		 </div>
	</div>
	<script type="text/javascript">
	<!--
	var container = document.getElementById('container');
	var content = document.getElementById('content');
	var oDivs = DOM.children(content, "div");
	oDivs[0].st = 0;
	for (var i = 1; i < oDivs.length; i++) {
	    oDivs[i].st = oDivs[i].offsetTop;
	}
	var oLis = DOM.getElesByClass("tabOption");
	var flag = 0;
	var upFlag = oLis.length;; (function() {
	    function fn(e) {
	        e = e || window.event;
	        if (e.wheelDelta) {
	            var n = e.wheelDelta;
	        } else if (e.detail) {
	            var n = e.detail * -1;
	        }
	        if (n > 0) {
	            container.scrollTop -= 12;
	        } else if (n < 0) {
	            container.scrollTop += 12;
	        }
	        slider.style.top = container.scrollTop * container.offsetHeight / content.offsetHeight + "px";
	        slider.offsetTop * (content.offsetHeight / container.offsetHeight);
	        var st = container.scrollTop;
	        if (st > this.preSt) {
	            for (var j = 0; j < oLis.length; j++) {
	                if (st < oDivs[j].st) break;
	            }
	            if (oLis[j - 2] && this.preLi !== j) {
	                if ((j) > (flag + 1)) {
	                    DOM.removeClass(oLis[j - 2], "selectedTab");
	                    DOM.addClass(oLis[j - 1], "selectedTab");
	                    animate(blueline, {
	                        top: (j - 1) * 48
	                    },
	                    500, 2);
	                }
	            }
	            flag = j - 1;
	        } else if (st < this.preSt) {
	            for (var j = oLis.length - 1; j >= 0; j--) {
	                if (st > oDivs[j].st) break;
	            }
	            if (oLis[j + 2] && this.preLi !== j) {
	                if (flag === undefined) return;
	                if ((j) < (flag)) {
	                    for (var k = 0; k < oLis.length; k++) {
	                        DOM.removeClass(oLis[k], "selectedTab");
	                    };
	                    DOM.addClass(oLis[j + 1], "selectedTab");
	                    animate(blueline, {
	                        top: (j + 1) * 48
	                    },
	                    500, 2);
	                    upFlag = j + 1;
	                }
	            }
	        }
	        this.preSt = st;
	        if (e.preventDefault) e.preventDefault();
	        return false;
	    }
	    container.onmousewheel = fn;
	    if (container.addEventListener) container.addEventListener("DOMMouseScroll", fn, false);
	    slider = document.createElement('span');
	    slider.id = "slider";
	    slider.style.height = container.offsetHeight * (container.offsetHeight / content.offsetHeight) + "px";
	    sliderParent.appendChild(slider);
	    on(slider, "mousedown", down);
	    var blueline = document.getElementById("blueline");
	    function changeTab() {
	        var index = DOM.getIndex(this);
	        //begin
	        //isGrade(index);
	        //end
	        for (var i = 0; i < oLis.length; i++) {
	            DOM.removeClass(oLis[i], "selectedTab");
	        }
	        DOM.addClass(this, "selectedTab");
	        animate(container, {
	            scrollTop: oDivs[index].st
	        },
	        500, 1);
	        var t = oDivs[index].st * container.offsetHeight / content.offsetHeight;
	        animate(slider, {
	            top: t
	        },
	        500);
	        animate(blueline, {
	            top: index * 48
	        },
	        500, 2);
	    }
	    var tabPannel1 = document.getElementById("outerWrap");
	    var oLis = DOM.children(DOM.children(tabPannel1, "ul")[0], "li");
	    for (var i = 0; i < oLis.length; i++) {
	        oLis[i].onclick = changeTab;
	    };
	})();
	-->
	</script>
  </body>
</html>