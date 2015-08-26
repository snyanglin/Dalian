<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>巡逻任务</title>
  </head>
  <body onload="" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
      		<table id="dg" style="width: 100%; height: 100%;"
	            url="<%=request.getContextPath()%>/homePage/queryXllx"
	            pagination="true" 
	            sortOrder="desc"
	            rownumbers="false"
	            singleSelect="true" 
	            fitColumns="true">
		        <thead>
		            <tr>
		                <th field="linename" align="center" width="70" rowspan="2" fixed=true><span class="sp">巡逻路线</span></th>
		                <th field="" align="center" width="23" colspan="4" fixed=true><span class="sp">周  一</span></th>
		                <th field="" align="center" width="23" colspan="4" fixed=true><span class="sp">周  二</span></th>
		                <th field="" align="center" width="23" colspan="4" fixed=true><span class="sp">周  三</span></th>
		                <th field="" align="center" width="23" colspan="4" fixed=true><span class="sp">周  四</span></th>
		                <th field="" align="center" width="23" colspan="4" fixed=true><span class="sp">周  五</span></th>
		                <th field="" align="center" width="23" colspan="4" fixed=true><span class="sp">周  六</span></th>
		                <th field="" align="center" width="23" colspan="4" fixed=true><span class="sp">周  日</span></th>
		            </tr>
		            <tr>
		            	<th field="zao" align="center" width="23" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng" align="center" width="23" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci" align="center" width="23" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou" align="center" width="23" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao2" align="center" width="23" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng2" align="center" width="23" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci2" align="center"  width="23" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou2" align="center" width="23" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao3" align="center" width="23" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng3" align="center" width="23" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci3" align="center" width="23" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou3" align="center" width="23" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao4" align="center" width="23" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng4" align="center" width="23" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci4" align="center" width="23" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou4" align="center" width="23" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao5" align="center" width="23" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng5" align="center" width="23" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci5" align="center" width="23" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou5" align="center" width="23" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao6" align="center" width="23" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng6" align="center" width="23" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci6" align="center" width="23" styler="chi" fixed=true><span class="ci">迟</span></th>
		                <th field="lou6" align="center" width="23" styler="lou" fixed=true><span class="lou">漏</span></th>
		                <th field="zao7" align="center" width="23" styler="zao" fixed=true><span class="zao">早</span></th>
		                <th field="zheng7" align="center" width="23" styler="zheng" fixed=true><span class="zheng">正</span></th>
		                <th field="ci7" align="center" width="23" styler="chi" fixed=true ><span class="ci">迟</span></th>
		                <th field="lou7" align="center" width="23" styler="lou" fixed=true><span class="lou">漏</span></th>
		            </tr>
		        </thead>
    		</table>
  </body>
  <script type="text/javascript">
      var zzjgdm = "<%=userOrgCode%>";
      
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
    	  var flag = getParm("a");
    	  //alert(flag);
          $('#dg').datagrid({
              view: detailview,
              detailFormatter:function(index,row){
                  return '<div style="height:150px"><table class="ddv" id="sub">'
                 + ' <thead>' 
		                + '<th field="dates" align="center" width="70" fixed=true><span class="sp">巡逻时间</span></th>' 
		                + '<th field="z1" align="center" width="23" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh1" align="center" width="23" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch1" align="center" width="23" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + ' <th field="l1" align="center" width="23" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z2" align="center" width="23" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + ' <th field="zh2" align="center" width="23" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + ' <th field="ch2" align="center"  width="23" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + ' <th field="l2" align="center" width="23" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + ' <th field="z3" align="center" width="23" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + ' <th field="zh3" align="center" width="23" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '  <th field="ch3" align="center" width="23" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l3" align="center" width="23" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z4" align="center" width="23" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + '<th field="zh4" align="center" width="23" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch4" align="center" width="23" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + ' <th field="l4" align="center" width="23" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + '<th field="z5" align="center" width="23" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + ' <th field="zh5" align="center" width="23" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch5" align="center" width="23" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l5" align="center" width="23" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + ' <th field="z6" align="center" width="23" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + ' <th field="zh6" align="center" width="23" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch6" align="center" width="23" styler="chis" fixed=true><span class="cis">迟</span></th>' 
		                + '<th field="l6" align="center" width="23" styler="lous" fixed=true><span class="lous">漏</span></th>' 
		                + ' <th field="z7" align="center" width="23" styler="zaos" fixed=true><span class="zaos">早</span></th>' 
		                + ' <th field="zh7" align="center" width="23" styler="zhengs" fixed=true><span class="zhengs">正</span></th>' 
		                + '<th field="ch7" align="center" width="23" styler="chis" fixed=true ><span class="cis">迟</span></th>' 
		                + ' <th field="l7" align="center" width="23" styler="lous" fixed=true><span class="lous">漏</span></th>' 
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
    	  return "background-color: '#4dc2ed'; color: white; font-size: 11px;"
    	  	 //+ "background-image: -moz-linear-gradient(top, #FFF, #000); "
    		 //+ "background-image: -webkit-gradient(linear, left, top, left bottom, color-stop(0, #FF0000)); "
    		 //+ "filter: progid:DXImageTransform.Microsoft.gradient(startColors='white', endColorstr='#00FF00', GradientType='0')";
      }
      
      function zheng(){
    	  return "background-color: '#85d021'; color: white; font-size: 11px;";
      }
      
      function chi(){
    	  return "background-color: '#ffb543'; color: white; font-size: 11px;";
      }
      
      function lou(){
    	  return "background-color: '#ff7a7b'; color: white; font-size: 11px;";
      }
      
      function zaos(){
    	  return "background-color: '#D1E9E9'; color: black; font-size: 11px;"
    	  	 //+ "background-image: -moz-linear-gradient(top, #FFF, #000); "
    		 //+ "background-image: -webkit-gradient(linear, left, top, left bottom, color-stop(0, #FF0000)); "
    		 //+ "filter: progid:DXImageTransform.Microsoft.gradient(startColors='white', endColorstr='#00FF00', GradientType='0')";
      }
      
      function zhengs(){
    	  return "background-color: '#F5FFE8'; color: black; font-size: 11px;";
      }
      
      function chis(){
    	  return "background-color: '#FFFAF4'; color: black; font-size: 11px;";
      }
      
      function lous(){
    	  return "background-color: '#FFF3EE'; color: black; font-size: 11px;";
      }
  </script>
  
    <style type="text/css">
     a{text-decoration:none;}
     span.sp{font-size: 11px; font-weight: bold;}
     span.zao{font-size: 9px; color: '#4dc2ed'; font-weight: bold;}
     span.zheng{font-size: 9px; color: '#85d021'; font-weight: bold;}
     span.ci{font-size: 9px; color: '#ffb543'; font-weight: bold;}
     span.lou{font-size: 9px; color: '#ff7a7b'; font-weight: bold;}
     span.zaos{font-size: 7px; color: '#4dc2ed'; font-weight: normal;}
     span.zhengs{font-size: 7px; color: '#85d011'; font-weight: normal;}
     span.cis{font-size: 7px; color: '#ffb533'; font-weight: normal;}
     span.lous{font-size: 7px; color: '#ff7a6b'; font-weight: normal;}
    </style>
    
</html>