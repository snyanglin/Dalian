<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userid = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userid = userInfo.getUserId();
    }
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>首页_巡区统计</title>
    
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
      
      function init(){
     	 flags = getParm("flag")!="" ? getParm("flag") : "month" ;
    	  alert();
     	 isGrade(flags);
      }
      
      function openTab(val,row,index){
    		var userName = row["userName"];
    		var url = "/forward/query|xj_zdrkQueryMain?userName="+userName;
    		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"纠错信息详细列表\", \""+url+"\")')>"+val+"</a></div>";
      }
      
      function isGrade(flags) {
    		var data = [];
   			data = [[    
   		        {field:"userName",title:"巡逻员姓名",width:100,align:"center",halign:'center'},
   		        {field:"evalDate",title:"考核区间",width:100,align:"center",halign:'center'}, 
   		        {field:"score",title:"得分",width:100,align:"center",halign:'center'}, 
   		        {field:"rankings3",title:"派出所排名",width:100,align:"center",halign:'center'}, 
   		        {field:"rankings2",title:"分局排名",width:100,align:"center",halign:'center'}, 
   		        {field:"rankings1",title:"市局排名",width:100,align:"center",halign:'center', formatter:openTab},
				{field:"userid",title:"userid",width:100,align:"center",halign:'center',hidden:true}
   		    ]];
   			var url = "<%=request.getContextPath()%>/homePage/queryXjXlY";
       		datagrid("#xlyGrid", url, data, "1", flags);
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
  			pageSize:getAutoPageSize(5),
      		pageList:[getAutoPageSize(5), getAutoPageSize(5) * 2],
  			border:false,
  			singleSelect:true,
      		fitColumns:false,
      		border: 1,
  		    columns:data 
  		}); 
      }
      
      -->
    </script>
  </head>
  <body onload="init();" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
    
        <table id="xlyGrid" ></table>
                    
  </body>
</html>