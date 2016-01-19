
    <%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>当前任务</title>  
    </head>  
    <body>  
    <center>  
      
    <h3><font color="red">当前状态：</font><font color="blue">  
        <c:choose>  
            <c:when test="${assignee =='apply'}">申请提交</c:when>  
            <c:when test="${assignee =='leader'}">经理审批</c:when>  
            <c:when test="${assignee =='boss'}">老板批</c:when>  
              
        </c:choose>  
    </font> </h3>  
    <br><br>  
        <table border="1" bordercolor="blue" cellpadding="0" cellspacing="0">  
            <tr>  
                <th>taskid</th>  
                <th>任务</th>  
                <th>实例id</th>  
                <th>责任人</th>  
                <th>流程定义标识</th>  
                <th>流程实例标识</th>  
                <th>操作</th>  
            </tr>  
        <c:forEach items="${taskList }" var="task" varStatus="s">  
            <tr>  
                <td>${task.id }</td>  
                <td>${task.name }</td>  
                <td>${task.processInstanceId }</td>  
                <td>${task.assignee }</td>  
                <td>${task.processDefinitionId }</td>  
                <td>${task.executionId }</td>  
                <td>  
    <a href="<c:url value='/diagram/showImage' />/${task.processDefinitionId }/${task.processInstanceId }/${task.assignee}">查看流程图</a>  
                 </td>  
            </tr>  
        </c:forEach>  
        </table>  
    </center>  
    </body>  
    </html>
