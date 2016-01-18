
    <%@ page language="java" contentType="text/html; charset=utf-8"  
        pageEncoding="utf-8"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
      
    <html>  
    <head>  
        <title>查看流程</title>  
    </head>  
    <body>  
        <div >  
          
            <img src="<c:url value='/diagram/findPic' />/${procDefId}" >  
            <!-- 给执行的节点加框 -->  
            <div style="position:absolute; border:2px solid red;left:${wfLeaveImag.x-59 }px;top:${wfLeaveImag.y-28 }px;width:${wfLeaveImag.width }px;height:${wfLeaveImag.height }px;"></div>  
        </div>  
      
    </body>  
    </html>
