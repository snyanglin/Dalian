<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>地址建筑物信息展现</title>
    <script type="text/javascript">
    	var dzmc = "${entity.dzmc}";
    	var mldzid = "${mldzid}";
    	var chdzid = "${chdzid}";
        var mainTabID = "${mainTabID}";
    </script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzBuilding/dzBuildingShow.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'north',border:false">
         <table border='0' cellpadding="0" cellspacing="0">
              <tr style="width:100%;height:80px" bgColor="#68C4F3">
                  <td style="width:100px;height:80px" align="right">
	             		<img src="<%=contextPath%>/images/bzdz/building/buildbg.png" style="width:80px;height:80px">
		          </td>
		          <td style="width:100%;height:80px">
		             <table>
		                <tr height="30px;">
		                  <td id="jzwjbxxDiv" style="font-size: 16px;font-family:'微软雅黑'; font-weight:normal;"></td>
		                </tr>
		                <tr height="30px;">
		                   <td style="font-size: 16px;font-family:'微软雅黑'; font-weight:normal;">图例：
				    			<img src="<%=contextPath%>/images/bzdz/building/czrk.png" style="width:20px;height:19px; vertical-align: middle;"/>&nbsp;常住人口&nbsp;&nbsp;
				    			<img src="<%=contextPath%>/images/bzdz/building/jzrk.png" style="width:20px;height:19px; vertical-align: middle;"/>&nbsp;寄住人口&nbsp;&nbsp;
				    			<img src="<%=contextPath%>/images/bzdz/building/zzrk.png" style="width:20px;height:20px; vertical-align: middle;"/>&nbsp;暂住人口&nbsp;&nbsp;
				    			<img src="<%=contextPath%>/images/bzdz/building/jwrk.png" style="width:20px;height:19px; vertical-align: middle;"/>&nbsp;境外人员&nbsp;&nbsp;
				    			<img src="<%=contextPath%>/images/bzdz/building/zdrk.png" style="width:20px;height:19px; vertical-align: middle;"/>&nbsp;重点人口&nbsp;&nbsp;
				    			<img src="<%=contextPath%>/images/bzdz/building/sydw.png" style="width:20px;height:19px; vertical-align: middle;"/>&nbsp;实有单位&nbsp;&nbsp;&nbsp;&nbsp;
	    		           </td>
		                </tr>
		             </table>
		          </td>
              </tr>
         </table>
     </div>
     <div data-options="region:'center',border:false" align="center">
         <div id="chjgAddDsDiv" style="margin-top: 10px;"></div>
	     <div id="chjgAddDxDiv" style="margin-top: 10px;margin-bottom: 10px;"></div>
	     <!-- 展示信息 -->
      	 <div id="winZsxx" style="display: none;">
		 	 <iframe id="fjZsxxFrame" style="width: 100%; height: 100%;" frameborder="0" src=""></iframe>
	     </div>
     </div>
  </body>
</html>