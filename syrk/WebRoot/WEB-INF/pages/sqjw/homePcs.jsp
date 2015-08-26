<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%@ include file="/WEB-INF/pages/gpsControl.html"%>
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
    <title>所长主页</title>
    <script type="text/javascript">
    var userOrgCode = "<%=userOrgCode%>"; 
    var userOrgName = "<%=userOrgName%>";
    var bjzbz = "<%=bjzbz%>";
    </script>
    <style type="text/css">
		.text1{width:100%; margin-left:10px;margin-right:10px; font-size:14px; color:#333; line-height:24px; text-indent:25px;}
		.text2{width:100%; text-align: center;}
		.bold{font-weight:bold;font-size:14px}
		.redText{color:#F00;font-weight:bold;font-size:14px;}
		.blueText{color:blue;font-weight:bold;cursor: pointer;font-size:14px;}
		.oneText{font-size:12px;background-color:#007be3;text-align:center;width:22px; height:22px;float:left;color:#fff;font-weight:bold;line-height:22px;}
		.textwrap{width:100%; margin:5px auto;height:auto;overflow:hidden;margin-left: 10px;margin-top: 10px;font-size:14px;}
		.title_big{font-size:17px; color:#333333;line-height:22px;font-weight:bold;}
    </style>
    <script type="text/javascript" charset="GB2312" src="<%=SystemConfig.getString("jwtsUrl")%>/profile/profile.js"></script>
    <script type="text/javascript" charset="GB2312" src="<%=SystemConfig.getString("jwtsUrl")%>/ezGpsLib/component/module/EzModuleAPI.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/floatWin/floatWin.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/sqjw/homePage/homePcs.js"></script>
  </head>
  <body class="easyui-layout">   
    <div data-options="region:'west',title:'资源区',split:true" style="width:250px;">
        <ul id="tt" class="easyui-tree">   
		    <li>   
		        <span><span id="orgZzjgmc" style="line-height: 17px;"><%=userOrgName%></span></span>   
		        <ul>   
		            <li>   
		                <span>实有人口<span id='syrkNumId'></span></span>   
		                <ul>   
		                    <li>   
		                        <span>常住人口<span id='czrkNumId'></span></span>   
		                    </li>   
		                    <li>   
		                        <span>寄住人口<span id='jzrkNumId'></span></span>   
		                    </li>   
		                    <li>   
		                        <span>流动人口<span id='ldrkNumId'></span></span>   
		                    </li>  
		                    <li>   
		                        <span>境外人口<span id='jwrkNumId'></span></span>   
		                    </li>
		                    <li>   
		                        <span>未落户人口<span id='wlhrkNumId'></span></span>   
		                    </li>
		                </ul>   
		            </li>
		            <li>   
		                <span>重点人员<span id='zdrkNumId'></span></span>   
		                <ul>   
		                    <li>   
		                        <span>法轮功<span id='flgNumId'></span></span>   
		                    </li>   
		                    <li>   
		                        <span>监管对象<span id='jgdxNumId'></span></span>   
		                    </li>   
		                    <li>   
		                        <span>吸毒人员<span id='xdryNumId'></span></span>   
		                    </li>  
		                    <li>   
		                        <span>上访人员<span id='sfryNumId'></span></span>   
		                    </li>
		                    <li>   
		                        <span>其他<span id='qtgzdxNumId'></span></span>   
		                    </li>
		                </ul>   
		            </li> 
		            <li>   
		                <span>实有单位<span id='dwzsNumId'></span></span>  
		                <ul>   
		                    <li>   
		                        <span>旅店<span id='dwldNumId'></span></span> 
		                    </li>   
		                    <li>   
		                        <span>网吧<span id='dwwbNumId'></span></span> 
		                    </li>   
		                </ul>   
		            </li>  
		            <li>   
		                <span>实有房屋<span id='fwzsNumId'></span></span> 
		                <ul>   
		                    <li>   
		                        <span>出租房<span id='fwczfNumId'></span></span> 
		                    </li>
		                    <li>   
		                        <span>空置房<span id='fwkzfNumId'></span></span> 
		                    </li>   
		                </ul>   
		            </li>  
		            <li>   
		                <span>警情</span>
		                <ul>   
		                    <li>   
		                        <span>本年（<span id='aqbnNumId' style="color: gray; font-weight: bold;"></span>）</span> 
		                    </li>   
		                    <li>   
		                        <span>本月（<span id='aqbyNumId' style="color: gray;font-weight: bold;"></span>）</span> 
		                    </li>
		                    <li>   
		                        <span>本周（<span id='aqbzNumId' style="color: gray;font-weight: bold;"></span>）</span> 
		                    </li>   
		                </ul>    
		            </li>  
		            <li>   
		                <span>案件</span>
		                <ul>   
		                    <li>   
		                        <span>本年（<span id='jqbzNumId' style="color: gray;font-weight: bold;"></span>）</span>
		                    </li>   
		                    <li>   
		                        <span>本月（<span id='jqbyNumId' style="color: gray;font-weight: bold;"></span>）</span>
		                    </li>
		                    <li>   
		                        <span>未破（<span id='jqwpNumId' style="color: gray;font-weight: bold;"></span>）</span>
		                    </li>   
		                </ul>    
		            </li>
		            <li>   
		                <span>天网（<span id='twNumId' style="color: blue;font-weight: bold;" onclick="HomePage.twspMap()"></span>）</span>   
		            </li>   
		            <li>   
		                <span>警力监控<span id='gpsNumId'></span></span>   
		            </li>
		        </ul>   
		    </li>   
		</ul>  
    </div>   
    <div data-options="region:'center',title:'地图区'" id="tdmapid">
         <div id="mapDiv" ></div>
         <div id="toolDiv" style="position: absolute;filter: alpha(opacity=90);"></div>
    </div>   
  </body>  
</html>