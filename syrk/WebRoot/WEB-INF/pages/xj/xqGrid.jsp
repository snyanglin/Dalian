<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.organization.role.bean.OrgRole"%>
<%@ page import="com.founder.framework.organization.right.service.OrgRightPublic"%>
<%@page import="com.founder.xjpt.controller.XjController"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
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
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>首页_巡区统计</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/tabstyle.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/flashChart/swfobject.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/tabChart/event.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/tabChart/tween.js"></script>
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
     	 isGrade(flags);
      }
      
       function openPCS(val,row,index){
	  		var userids = row["id"];
	  		var url = "<%=httpURI%>/evaluation/EvaluationDept_Rank.jsp?Identitycard=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=1&Evaldate=" + dateParm;
	  		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡区考核排名明细\", \""+url+"\")')>"+val+"</a></div>";
	    }
	    
	    function openFJ(val,row,index){
			var userids = row["id"];
			var url = "<%=httpURI%>/evaluation/EvaluationDept_Rank.jsp?LicensePlate=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=2&Evaldate=" + dateParm;
			return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡区考核排名明细\", \""+url+"\")')>"+val+"</a></div>";
	    }
	    
	    function openSJ(val,row,index){
			var userids = row["id"];
			var url = "<%=httpURI%>/evaluation/EvaluationDept_Rank.jsp?LicensePlate=" + userids + "&Totaltype=0&UserID=<%=userid%>&RankType=3&Evaldate=" + dateParm;
			return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡区考核排名明细\", \""+url+"\")')>"+val+"</a></div>";
	    }
	    
	    function getScore(val,row,index){
			var userids = row["id"];
			var url = "<%=httpURI%>/evaluation/EvaluationDept_Detail.jsp?LicensePlate=" + userids + "&Totaltype=0&Evaldate=" + dateParm;
			return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡区考核明细\", \""+url+"\")')>"+val+"</a></div>";
	    }
	    
      function isGrade(flags) {
    		var dataq = [];
   			dataq = [[    
   		        {field:"userName",title:"巡区名称",width:95,align:"center",halign:'center'},
   		        {field:"evalDate",title:"考核区间",width:95,align:"center",halign:'center'}, 
   		        {field:"score",title:"得分",width:95,align:"center",halign:'center', formatter:getScore}, 
   		        {field:"rankings3",title:"派出所排名",width:95,align:"center",halign:'center', formatter:openPCS}, 
   		        {field:"rankings2",title:"分局排名",width:95,align:"center",halign:'center', formatter:openFJ}, 
   		        {field:"rankings1",title:"市局排名",width:95,align:"center",halign:'center', formatter:openSJ},
   		        {field:"id",title:"deptid",width:95,align:"center",halign:'center',hidden:true}
   		    ]];
   			var url = "<%=request.getContextPath()%>/homePage/queryXjXlY";
       		datagrid("#xqGrid", url, dataq, "3", flags);
    	}
      
      //datagrid
      function datagrid(name, url, data, type, flags){
    	  $(name).datagrid({    
  			url: url,
  			method:'POST',
  			queryParams:{userid:userid, type: type, flag: flags},
  			selectOnCheck:true,
      		checkOnSelect:true,
  			pagination:true,
  			fitColumns:true,
  			rownumbers: 'true',
  			pageSize:getAutoPageSize(5),
      		pageList:[getAutoPageSize(5), getAutoPageSize(5) * 2],
  			border: 1,
  			singleSelect:true,
  		    columns:data 
  		}); 
      }
      
      -->
    </script>
  </head>
  <body onload="init();" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
    
        <table id="xqGrid" ></table>
                    
  </body>
</html>