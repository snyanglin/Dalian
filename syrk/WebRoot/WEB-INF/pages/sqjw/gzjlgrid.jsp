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
    <title>首页_工作记录</title>
  </head>
  <body onload="loadGzjl2();" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
      <div id="gzjlDiv" style="width: 100%;height: 100%;"></div>
  </body>
  <script type="text/javascript">
      var zzjgdm = "<%=userOrgCode%>";
      
      function loadGzjl2(){
    	loadGzjl();
      	window.setInterval("loadGzjl()", 60000);
      }
      
      /**
	   * @title:loadGzjl
	   * @description:初始化工作记录
	   * @author: zhang_guoliang@founder.com
	   * @param  
	   * @param   
	   * @date:2014-07-10 15:11:25
	   */
      function loadGzjl(){
         $("#gzjlDiv").mask("正在查询,请等待...");
		 var fajax =new FrameTools.Ajax(contextPath+"/homePage/queryGzjlDate",initGzjl_back);
		 fajax.send();
      }
      /**
	   * @title:initGzjl_back
	   * @description:初始化工作记录_回调函数
	   * @author: zhang_guoliang@founder.com
	   * @param  
	   * @param   
	   * @date:2014-07-10 15:12:54
	   */
      function initGzjl_back(data){
         var time = data[0].split("-");
		 $("#gzjlDiv").datagrid({
				height:290,
				width:$("#gzjlDiv").width(),
				idField:"id",
				//treeField:"gzjlnr",
				border:false,
				fitColumns:true,
				pagination:false,
				onBeforeLoad:function(node,param){
					$("#gzjlDiv").mask("正在查询,请等待...");
				},
				onLoadSuccess:function(node,data){
					$("#gzjlDiv").unmask();
				},
				columns:[
			         [{title:"工作内容",width:150,field:"gzjlnr",rowspan:"3"},
			          {title:"工作记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id='dtime'>"+data[0]+"</span>&nbsp;&nbsp;<img id='imgId'  onClick=\"WdatePicker({skin:'default',el:'dtime',dateFmt:'yyyy-MM-dd',errDealMode:2,maxDate:'"+data[0]+"',minDate:'"+data[2]+"',onpicked:function(){queryGzjlListByTime()}})\" src='"+contextPath+"/common/datepicker/skin/datePicker.gif' width:'16' heigth='22' align='absmiddle' style='cursor:pointer'/>",colspan:6}],
			         [{title:"<span id='yue'>"+time[1]+"</span>月" + "<span id='ri'>"+time[2]+"</span>日",
			        	  width:85,
			        	  colspan:2,
			        	 // field:"ri",
			        	  align:"center",
			        	  formatter:function(C,D){
			        		  var F=D.ri;
			        		  if(F=="0"){
			        			  return "0";
			        		  }else{
			        			  return"<a style='cursor:hand;' href=\"javascript:gzjlDetailWindow('day',\'"+D.id+"\');\">"+F+"</a>";
			        		  }
			        	  }
			          },
			         
			         {
			        	 title:"<span id='yue_1'>"+time[1]+"</span>月",
			        	 width:85,
			        	 colspan:2,
			        	 //field:"yue",
			        	 align:"center",
			        	 formatter:function(C,D){
			        		 var F=D.yue;
			        		 if(F=="0"){
			        			 return "0";
			        		}else{
			        			return "<a style='cursor:hand;' href=\"javascript:gzjlDetailWindow('month',\'"+D.id+"\');\">"+F+"</a>";
			        		}
			        	 }
			         },{
			        	 title:"<span id='nian'>"+time[0]+"</span>年",
			        	 width:85,
			        	 colspan:2,
			        	// field:"nian",
			        	 align:"center",
			        	 formatter:function(C,D){
			        		 var F=D.nian;
			        		 if(F=="0"){
			        			 return "0";
			        		 }else{
			        			 return "<a style='cursor:hand;' href=\"javascript:gzjlDetailWindow('year',\'"+D.id+"\');\">"+F+"</a>";
			        		 }
			        	}
			         }
			    ]
			    ,
			     [{title:"新增",width:40,align:"center",field:"rixz"},{title:"注销",width:45,align:"center",field:"rizx"},
			       {title:"新增",width:40,align:"center",field:"yuexz"},{title:"注销",width:45,align:"center",field:"yuezx"},
			       {title:"新增",width:40,align:"center",field:"nianxz"},{title:"注销",width:45,align:"center",field:"nianzx"}
			     ]
			  ]
		   });
		   queryGzjlList(data[0]);
        }
        /**
		  * @title:queryGzjlList
		  * @description:加载工作记录数据
		  * @author: zhang_guoliang@founder.com
		  * @param  
		  * @param   
		  * @date:2014-07-10 16:04:15
		  */
        function queryGzjlList(time){
            var params = {zzjgdm:zzjgdm,dTime:time};
			var fajax = new FrameTools.Ajax(contextPath+"/homePage/queryGzjlList",queryGzjlList_back);
			fajax.send(params);	
        }
        /**
		  * @title:queryGzjlList_back
		  * @description:加载工作记录数据_回调函数
		  * @author: zhang_guoliang@founder.com
		  * @param  
		  * @param   
		  * @date:2014-07-10 16:07:24
		  */
        function queryGzjlList_back(data){
           $("#gzjlDiv").datagrid("loadData",data);
        }
		 /**
		  * @title:queryGzjlListByTime
		  * @description:点击事件控件时，触发的工作计划的查询函数
		  * @author: zhang_guoliang@founder.com
		  * @param  
		  * @param   
		  * @date:2014-07-11 14:36:21
		  */
		function queryGzjlListByTime(){
			var rq = $dp.cal.getDateStr();
			var rs = rq.split("-");
			$("#yue").text(rs[1]);
			$("#ri").text(rs[2]);
			$("#zhou").text($dp.cal.getP("W","WW") );
			$("#yue_1").text(rs[1]);
			$("#nian").text(rs[0]);
			queryGzjlList($dp.cal.getDateStr());
		};
		 /**
		  * @title: gzjlDetailWindow
		  * @description:工作记录的详细列表
		  * @author: zhang_guoliang@founder.com
		  * @param  
		  * @param   
		  * @date:2014-07-14 22:29:43
		  */
	    function gzjlDetailWindow(type,code){
	        parent.$("#gzjlInfoDiv").show();
			parent.$("#gzjlInfoDiv").window({
				title:"工作记录详情",
				width:750,
				height:345,
				top:450,
				modal:true,
				minimizable:false,
				maximizable:false,
				draggable:false
			});
			queryGzjlDetailList(type,code);
		};
		/**
		  * @title: queryGzjlDetailList
		  * @description:查询工作记录列表
		  * @author: zhang_guoliang@founder.com
		  * @param  
		  * @param   
		  * @date:2014-07-14 22:37:47
		  */
		function queryGzjlDetailList(type,code){
		    var day = $("#nian").text()+"-"+$("#yue").text()+"-"+$("#ri").text();
			var week = $("#zhou").text();
			var month = $("#yue").text();
			var year = $("#nian").text();
			parent.$("#gzjlInfoTable").datagrid({
				width:"100%",
				height:"100%",
				nowrap:true,  
				striped:true, 
				pagination:true, 
				singleSelect:false,  
				fitColumns:true,
				rownumbers:true,
				pageSize:10,
				fit:true,  
				url:contextPath+"/homePage/queryGzjlXqList",
				queryParams:{zzjgdm:zzjgdm,code:code,day:day,week:week,month:month,year:year,type:type},
				columns:[[
				           {field:'operatecondition',title : '工作描述',width : 360},
						   {field:'operatetime',title:'操作时间',width : 130}
						]]
			});
		};
    </script>
    <style type="text/css">
     a{text-decoration:none;}
    </style>
</html>