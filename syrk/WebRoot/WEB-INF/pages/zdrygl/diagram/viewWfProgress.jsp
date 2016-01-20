    <%@ page language="java" contentType="text/html; charset=gbk"  
        pageEncoding="gbk"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
      
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
    <html>  
    <head>  
        <title>查看流程</title>  
    </head>  
    <body>  
        <div >  
          	<input type="hidden" id="assignee" name="assignee" value="${assignee }">
            <img src="<c:url value='/diagram/drawPic' />/${procDefId}/${procIstid}" >  
            <!-- 给执行的节点加框 -->  
           <%--  <div style="position:absolute; border:2px solid red;left:${wfLeaveImag.x+10 }px;top:${wfLeaveImag.y+10 }px;width:${wfLeaveImag.width }px;height:${wfLeaveImag.height }px;"></div>   --%>
        </div>  
      		<hr>
      		可审批人员如下:<br>
      		
      	<div id="info">
      		<table border="1">
      			<tr>
      				
      				<td>姓名</td>
      				<td>人员ID</td>
      				<td>岗位</td>
      				<td>部门</td>
      			</tr>
      			<tr>
      				<td>王林</td>
      				<td>2313734834889</td>
      				<td>所长</td>
      				<td>管辖爬出所</td>
      			</tr>
      		</table>
      	</div>
    </body> 
    <script type="text/javascript">
    window.onload = function(){
    	var assignee=$("#assignee").val();
	    $.ajax({
			async:false,
			type:"GET",
			url:"<%= basePath%>orgUser/query/" + assignee,
			dataType:"json",
			success:function(data){
				if (data && data.length>0) {
					$("#info").val(data)
				}else{
					alert("未找到审批人，该部门或岗位下未分配人员");
				}				
			}
		});
    }
    </script> 
    </html>
	