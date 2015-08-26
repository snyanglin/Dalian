<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- begin -->
	<script type="text/javascript" src="<%=contextPath%>/js/tools/flashChart/swfobject.js"></script>
	<!-- end -->
	
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/jzym.css" />
	<script type="text/javascript" src="<%=contextPath%>/js/jzym/jzymIndex.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/jzym/jrjq.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/jzym/jwts.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/jzym/ssyj.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/ssyj/FusionCharts.js"></script>
	<script type="text/javascript">
	  var userOrgCode = "<%=userOrgCode%>"; 
      var bjzbz = "<%=bjzbz%>";
      var userOrgName = "<%=userOrgName%>";
      $(function(){
  		$(window).resize();//调整页面布局
  		XjMap.loadMap();
  		XjMap.query("xqgk");
  	  });
      /*调整页面中窗口的大小*/
  	$(window).resize(function() {
  		$("#mapDiv").css("height",500);
  	});
      

	</script>
  </head>
  
  <body>
  	<table id='homepageTable'>
    	<tr>
    		<td class="moduleTd" >
    			<table class="moduleTable" width="100%">
    				<tr >
			    		<td >
							<div id="classDiv" class="classDiv">
							<div id="ssdtTitle" class="titleDiv">实时动态</div>
								<ul class="countUl">
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.query('xqgk')">
											<img src="<%=contextPath%>/images/navigator/czfwgl.png" border="0" alt="辖区概况" width="70" height="70"/><br><span>辖区概况</span>
										</a>
									</li>
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.query('jrjq')">
										<img src="<%=contextPath%>/images/navigator/znff.png" border="0" alt="今日警情" width="70" height="70"/><br><span>今日警情<label id="count"></label></span></a>
							
									</li>
									<!--  <li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.query('gzdt')">
										<img src="<%=contextPath%>/images/navigator/sydwhs.png" border="0" alt="工作动态" width="70" height="70"/><br><span>工作动态</span></a>
							
									</li>-->
									<li>
										<a class="lf_ddicon" href="http://10.80.8.179/Componentnew" target="_blank">
										<img src="<%=contextPath%>/images/navigator/sydwgl.png" border="0" alt="警务态势" width="70" height="70"/><br><span>警务态势</span></a>
									</li>
									
	    						</ul>
		    				</div>
						</td>
						<td  >
							<div id="classDiv" class="classDiv">
								<div id="cxtjTitle" class="titleDiv">查询统计</div>
								<ul class="countUl">
									
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.sstjChart()">
										<img src="<%=contextPath%>/images/navigator/lunbo-6.png" border="0" alt="三实统计" width="70" height="70"/><br><span>三实统计</span></a>
									</li>
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.drawChart('queryLdrkChart')">
										<img src="<%=contextPath%>/images/navigator/syrkzh.png" border="0" alt="流口统计" width="70" height="70"/><br><span>流口统计<label id="count"></label></span></a>
									</li>
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.drawChart('queryGzdxChart')">
										<img src="<%=contextPath%>/images/navigator/syrkhs.png" border="0" alt="工作动态" width="70" height="70"/><br><span>工作对象</span></a>
									</li>
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.drawChart('queryNlChart')">
										<img src="<%=contextPath%>/images/navigator/lunbo-2.png" border="0" alt="年龄统计" width="70" height="70"/><br><span>年龄统计</span></a>
									</li>
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.search()">
										<img src="<%=contextPath%>/images/navigator/dzlb.png" border="0" alt="全文检索" width="70" height="70"/><br><span>全文检索</span></a>
									</li>
									
	    						</ul>
		    				</div>
						</td>
						<!--<td  >
							<div id="classDiv" class="classDiv">
								<div id="fxgjTitle" class="titleDiv">分析工具</div>
								<ul class="countUl">
									  <li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.jqtjChart()">
										<img src="<%=contextPath%>/images/navigator/lunbo-2.png" border="0" alt="警情统计" width="70" height="70"/><br><span>警情统计</span></a>
									</li>
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.jqdbChart()">
										<img src="<%=contextPath%>/images/navigator/lunbo-2.png" border="0" alt="警情同比统计" width="70" height="70"/><br><span>警情同比统计</span></a>
									</li>
									<li>
										<a class="lf_ddicon" href="javascript:void(0)" onclick="XjMap.query('ssyj')">
										<img src="<%=contextPath%>/images/navigator/lunbo-6.png" border="0" alt="四色预警" width="70" height="70"/><br><span>四色预警</span></a>
									</li>
	    						</ul>
		    				</div>
						</td>-->
					</tr>
				</table>
			</td>
    	</tr>
    	<tr>
    	<td>
    			<table width="100%">
    				<tr>
			    		<td ><div id="mapDiv" ></div></td>
			    		<td class="InfoTd">
								<div id="infoShowDiv" class="infoShowDiv">
								</div>
						</td>
					</tr>
				</table>
			</td>
    	</tr>
    </table>
    
  </body>
</html>
