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
    <title>消息回复或转发</title>
    <script type="text/javascript">
    //加载页面
    function sysMessageload(){
    	if("${entity.hfbz}"==2){
    		document.getElementById("trId").style.display = "";
    		setComboRequired('jsrssdwdm', true);
    	}else{
    		setComboRequired('jsrssdwdm', false);
    	}
    };
    </script>
  </head>
  <body onload="sysMessageload()">
     <form action="<%=basePath%>sysMessage/updateReply" id="dataForm" name="dataForm" method="post">
        <div data-options="region:'center',split:true" style="border-width: 0px;">
           <table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
              <input type="hidden" name="id" value="${entity.id}"/>
              <input type="hidden" name="xxnr" value="${entity.xxnr}"/>
              <input type="hidden" name="hfbz" value="${entity.hfbz}"/>
              <input type="hidden" name="ywurl" value="${entity.ywurl}"/>
              <input type="hidden" name="fsrssdw" value="${entity.fsrssdw}"/>
              <input type="hidden" name="fsrssdwdm" value="${entity.fsrssdwdm}"/>
              <tr class="dialogTr" id="trId" style="display: none;">
				 <td width="30%" class="dialogTd" align="right">转发责任区：</td>
				 <td width="70%" class="dialogTd"> 
				  	 <input type="hidden" name="jsrssdw" id="jsrssdw" value="">
					 <input id="jsrssdwdm" name="jsrssdwdm" class="easyui-combobox" data-options="valueField:'id',textField:'text',tipPosition:'left',
					        url:'<%=contextPath%>/gzjk/queryOrgLowest?orgCode=<%=userOrgCode%>',onSelect:function(rec){$('#jsrssdw').val(rec.text);}" style="width:240px;"/>
				 </td>
              </tr>
              <tr class="dialogTr">
                 <td width="30%" class="dialogTd" align="right">${title}</td>
                 <td width="70%" class="dialogTd">
                      <textarea class="easyui-validatebox" id="hfnr" name="hfnr" style="width: 240px; height:100px;overflow: auto;"
						    data-options="required:true,validType:['maxLength[80]'],invalidMessage:'回复内容不能超过80个汉字，请重新输入！',tipPosition:'left'"></textarea>
                 </td>
              </tr>
           </table>
        </div>
     </form>
  </body>
  <script type="text/javascript">
	//保存后（必写此方法可为空,否则弹出框保存失败）
  	function afterSubmit(arr){
  		$("#editWindow").dialog('close');
  		parent.$("#editWindow").dialog('close');
  		parent.$("#dg").datagrid('load');
  		executeTabPageMethod("0","refresh_message");
 	};
  	//保存前（必写此方法可为空,否则弹出框保存失败）
    function beforeSubmit(){
       var xxnr = "${entity.xxnr}";
       var len = 200 - xxnr.length;
       if(len<=0){
    	   topMessager.show({
				title: MESSAGER_TITLE,
				msg: '回复内容已经超出最大200个汉字，请重新输入！',
				timeout:2500
			});
    	   return false;
       }
    };
  </script>
</html>