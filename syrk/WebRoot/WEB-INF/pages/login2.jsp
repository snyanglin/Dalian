<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/errorPage.jsp"%>
<%
String contextPath = request.getContextPath();
String errorMsg = (String)request.getAttribute("errorMessage");
String focus = (String)request.getAttribute("focus");
if (errorMsg == null) {
   errorMsg = "";
}
if (focus == null) {
   focus = "";
}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大连市公安局警务信息综合应用平台</title>
<link href="<%=contextPath%>/common/skin/login.css" rel="stylesheet" />
<script src="<%=contextPath%>/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="<%=contextPath%>/js/mine.js" type="text/javascript"></script>
<script type="text/javascript">
 function setTab(name,cursel,n){
 for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  menu.className=i==cursel?"hover":"";
  con.style.display=i==cursel?"block":"none";
 }
}

</script>
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG.js" ></script>
<script type="text/javascript"> 
DD_belatedPNG.fix(".img1,.bg1,img,background"); 
</script>   
<![endif]-->
</head> 
<body class="other_page">
<div class="login_nr_other">
  <div class="header">
    <form>
      <ul>
        <li>
          <input value="用户名" type="text" class="input2" />
        </li>
        <li>
          <input value="密码" type="text" class="input2" />
        </li>
        <li>
          <input type="submit" class="login_btn3" value="" />
        </li>
        <li>
          <input type="submit" class="login_btn4" value="" />
        </li>
        <li><img src="<%=contextPath%>/common/skin/images/hf2.png" width="14" height="14" class="hf img1" /></li>
      </ul>
    </form>
  </div>
  <div class="content_sear">
    <div id="lib_Tab2">
      <div class="lib_Menubox2">
        <ul>
          <li id="two1" onmouseover="setTab('two',1,8)">全部</li>
          <li id="two2" onmouseover="setTab('two',2,8)">人</li>
          <li id="two3" onmouseover="setTab('two',3,8)">地址</li>
          <li id="two4" onmouseover="setTab('two',4,8)" class="hover">案件</li>
          <li id="two5" onmouseover="setTab('two',5,8)">警情</li>
          <li id="two6" onmouseover="setTab('two',6,8)">法律法规</li>
          <li id="two7" onmouseover="setTab('two',7,8)">地图</li>
          <li id="two8" onmouseover="setTab('two',8,8)">图片</li>
        </ul>
      </div>
      <div class="lib_Contentbox2">
        <div id="con_two_1" class="clearfix" style=" display:none;">
          <input type="text" class="search_input" />
          <input type="button" class="search_btn" />
        </div>
        <div id="con_two_2" class="clearfix" style=" display:none;" >
          <input type="text" class="search_input" />
          <input type="button" class="search_btn" />
        </div>
        <div id="con_two_3" class="clearfix" style=" display:none;">
          <input type="text" class="search_input"  />
          <input type="button" class="search_btn" />
        </div>
        <div id="con_two_4" class="clearfix">
          <input type="text" class="search_input"  />
          <input type="button" class="search_btn" />
        </div>
        <div id="con_two_5" class="clearfix" style=" display:none;">
          <input type="text" class="search_input"  />
          <input type="button" class="search_btn" />
        </div>
        <div id="con_two_6" class="clearfix" style=" display:none;">
          <input type="text" class="search_input"  />
          <input type="button" class="search_btn" />
        </div>
        <div id="con_two_7" class="clearfix" style=" display:none;">
          <input type="text" class="search_input" />
          <input type="button" class="search_btn" />
        </div>
        <div id="con_two_8" class="clearfix" style=" display:none;">
          <input type="text" class="search_input"  />
          <input type="button" class="search_btn" />
        </div>
      </div>
    </div>
    <div class="sys_rukou bg1">
    <dl class="clearfix" style="margin-bottom:15px;"><dt>应用导航</dt><dd><a href="#">警用地理</a></dd><dd><a href="#">社区警务</a></dd><dd><a href="#">巡警应用</a></dd><dd><a href="#">执法办案</a></dd><dd><a href="#">指挥研判</a></dd><dd><a href="#">警用地理</a></dd><dd><a href="#">350兆</a></dd></dl>
    <dl><dt>其他系统</dt><dd><a href="#">常用人口信息</a></dd><dd><a href="#">DNA数据库</a></dd><dd><a href="#">公安信访信息管理</a></dd><dd><a href="#">信息共享与服务平台</a></dd><dd><a href="#">交通违法查询</a></dd><dd><a href="#">旅店业查询</a></dd></dl>
    
    </div>
  </div>
  
  <Div class="pic_right bg1">
  <div class="xuanze img1"><img src="<%=contextPath%>/common/skin/images/option.png" width="27" height="27" /></div>
  <ul>
  <li><img src="<%=contextPath%>/common/skin/images/pic-1.png" width="163" height="100" /></li>
  <li><img src="<%=contextPath%>/common/skin/images/pic_2.png" width="163" height="100" /></li>
  <li><img src="<%=contextPath%>/common/skin/images/pic_3.png" width="163" height="100" /></li>
  </ul>  
  </Div>
</div>
</body>
</html>
