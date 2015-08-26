<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.xjpt.controller.XjController"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String httpURI = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
    
    httpURI = new XjController().getURL();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>巡逻任务</title>
  </head>
  <body onload="" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
      		<table id="dg" style="width: 100%; height: 100%;"
	            url="<%=request.getContextPath()%>/homePage/queryXllx?flag=now"
	            pagination="true" 
	            sortOrder="desc"
	            rownumbers="true"
	            singleSelect="true" 
	            pageSize=10
            	pageList=[10,20,100]
	            fitColumns="true">
		        <thead>
		            <tr>
		                <th field="linename" align="center" width="80" rowspan="2" fixed=true formatter='getLine'><span class="sp">巡逻路线</span></th>
		                <th field="lineid" align="center" width="80" rowspan="2" fixed=true hidden><span class="sp">巡逻id</span></th>
		                <th field="" align="center" width="50" colspan="4" fixed=true><span class="sp">周  一</span></th>
		                <th field="" align="center" width="50" colspan="4" fixed=true><span class="sp">周  二</span></th>
		                <th field="" align="center" width="50" colspan="4" fixed=true><span class="sp">周  三</span></th>
		                <th field="" align="center" width="50" colspan="4" fixed=true><span class="sp">周  四</span></th>
		                <th field="" align="center" width="50" colspan="4" fixed=true><span class="sp">周  五</span></th>
		                <th field="" align="center" width="50" colspan="4" fixed=true><span class="sp">周  六</span></th>
		                <th field="" align="center" width="50" colspan="4" fixed=true><span class="sp">周  日</span></th>
		            </tr>
		            <tr>
		            	<th field="zao" align="center" width="50" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng" align="center" width="50" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci" align="center" width="50" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou" align="center" width="50" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao2" align="center" width="50" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng2" align="center" width="50" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci2" align="center"  width="50" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou2" align="center" width="50" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao3" align="center" width="50" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng3" align="center" width="50" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci3" align="center" width="50" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou3" align="center" width="50" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao4" align="center" width="50" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng4" align="center" width="50" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci4" align="center" width="50" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou4" align="center" width="50" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao5" align="center" width="50" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng5" align="center" width="50" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci5" align="center" width="50" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou5" align="center" width="50" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao6" align="center" width="50" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng6" align="center" width="50" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci6" align="center" width="50" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou6" align="center" width="50" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao7" align="center" width="50" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng7" align="center" width="50" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci7" align="center" width="50" styler="chi" fixed=true ><span class="ci">迟</span></th>
		                <th field="lou7" align="center" width="50" styler="lou" fixed=true><span class="lou">漏</span></th>
		            </tr>
		        </thead>
    		</table>
  </body>
  <script type="text/javascript">
      var zzjgdm = "<%=userOrgCode%>";
      var flags = "now";
      function getParm(name){
    	  var flag = ""; 
	  	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	  	  var r = window.location.search.substr(1).match(reg);
	  	  if(r != null){
	  		  flag = unescape(r[2]);
	  	  } 
	  	  return flag;
      }
      
      $(function(){
    	  var flags = getParm("flag")!='' ? getParm("flag") : 'now';
    	  //alert(flags)
    	  //alert(flag);
          $('#dg').datagrid({
              view: detailview,
              url: "<%=request.getContextPath()%>/homePage/queryXllx?flag=" + flags,
              detailFormatter:function(index,row){
                  return '<div style="height:200px"><table class="ddv" id="sub">'
                 + ' <thead>' 
                 + '<tr>' 
		                + '<th field="dates" align="center" width="80" fixed=true><span>巡逻时间</span></th>' 
		                + '<th field="z1" align="center" width="50" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh1" align="center" width="50" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch1" align="center" width="50" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l1" align="center" width="50" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z2" align="center" width="50" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh2" align="center" width="50" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch2" align="center"  width="50" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l2" align="center" width="50" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z3" align="center" width="50" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh3" align="center" width="50" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch3" align="center" width="50" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l3" align="center" width="50" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z4" align="center" width="50" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh4" align="center" width="50" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch4" align="center" width="50" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l4" align="center" width="50" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z5" align="center" width="50" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh5" align="center" width="50" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch5" align="center" width="50" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l5" align="center" width="50" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z6" align="center" width="50" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh6" align="center" width="50" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch6" align="center" width="50" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l6" align="center" width="50" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z7" align="center" width="50" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh7" align="center" width="50" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch7" align="center" width="50" styler="chis" fixed=true ><span class="cis">迟</span></th>' 
		                + '<th field="l7" align="center" width="50" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		            + '</tr>' 
		            + ' </thead>' 
                  + '</table></div>';
              },
              rowStyler: function(index,row){
					//return 'height:200px;';     
			  },
              onExpandRow: function(index,row){
                  var ddv = $(this).datagrid('getRowDetail',index).find('table.ddv');
                  ddv.datagrid({
                      url:'<%=request.getContextPath()%>/homePage/queryXllxs?flag='+row.userid,
                      fitColumns:true,
                      singlSelect:true,
                      rownumbers:false,
                      loadMsg:'向着胜利前进...',
                      height:'auto',
                      border:true,
                      pagination:false, 
                      fit:true,
                      
                      onResize:function(){
                    	  $('#dg').datagrid('fixDetailRowHeight',index);
                      },
                      onLoadSuccess:function(){
                    	  setTimeout(
                    	  function(){
                    		  $('#dg').datagrid('fixDetailRowHeight',index);
                    	  }, 
                    	  0);
                      }
                  });
                  $('#dg').datagrid('fixDetailRowHeight',index);
              }
          });
          
          $(window).resize(function() {
      		$("#dg").datagrid('resize', {});
      	  });
          
      });
      
      function z(val){
       	return "<span style='background-color: #4dc2ed; color: white>" + val + "</span>";  
      }
      
      function zao(){
    	  return "background-color: '#4dc2ed'; color: white; "
    	  	 //+ "background-image: -moz-linear-gradient(top, #FFF, #000); "
    		 //+ "background-image: -webkit-gradient(linear, left, top, left bottom, color-stop(0, #FF0000)); "
    		 //+ "filter: progid:DXImageTransform.Microsoft.gradient(startColors='white', endColorstr='#00FF00', GradientType='0')";
      }
      
      function zheng(){
    	  return "background-color: '#85d021'; color: white;";
      }
      
      function chi(){
    	  return "background-color: '#ffb543'; color: white;";
      }
      
      function lou(){
    	  return "background-color: '#ff7a7b'; color: white;";
      }
      
      function zaos(){
    	  return "background-color: '#D1E9E9'; color: black; "
    	  	 //+ "background-image: -moz-linear-gradient(top, #FFF, #000); "
    		 //+ "background-image: -webkit-gradient(linear, left, top, left bottom, color-stop(0, #FF0000)); "
    		 //+ "filter: progid:DXImageTransform.Microsoft.gradient(startColors='white', endColorstr='#00FF00', GradientType='0')";
      }
      
      function zhengs(){
    	  return "background-color: '#F5FFE8'; color: black;";
      }
      
      function chis(){
    	  return "background-color: '#FFFAF4'; color: black;";
      }
      
      function lous(){
    	  return "background-color: '#FFF3EE'; color: black;";
      }
      
      function getLine(val,row,index){
		var lineid = row["lineid"];
		var url = "<%=httpURI%>/basic/LineDetail.jsp?lineID="  + lineid;
		return "<div class='dbrwck' ><a href='javascript:void(0)' onclick='menu_open(\"巡逻路线详细信息\", \""+url+"\")')>"+val+"</a></div>";
      }
      
  </script>
  
    <style type="text/css">
     a{text-decoration:none;}
     span.sp{font-size: 12px; font-weight: bold;}
     span.zao{font-size: 12px; color: '#4dc2ed'; font-weight: bold;}
     span.zheng{font-size: 12px; color: '#85d021'; font-weight: bold;}
     span.ci{font-size: 12px; color: '#ffb543'; font-weight: bold;}
     span.lou{font-size: 12px; color: '#ff7a7b'; font-weight: bold;}
     span.zaos{font-size: 11px; color: '#4dc2ed'; font-weight: normal;}
     span.zhengs{font-size: 11px; color: '#85d011'; font-weight: normal;}
     span.cis{font-size: 11px; color: '#ffb533'; font-weight: normal;}
     span.lous{font-size: 11px; color: '#ff7a6b'; font-weight: normal;}
    </style>
    
</html>