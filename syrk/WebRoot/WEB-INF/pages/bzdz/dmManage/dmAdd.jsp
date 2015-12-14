<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    String xzqhdm = "";
    String orglevel = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        orglevel = userInfo.getUserOrgLevel();
        if(!"".equals(userOrgCode)&&userOrgCode!=null){
        	if(!"31".equals(orglevel)&&!"30".equals(orglevel)){
        		xzqhdm = userOrgCode.substring(0,6);
        	}
        }
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>地名新增</title>
  </head>
  <body>
      <form action="<%=basePath%>dm/saveDm" id="dataForm" name="dataForm" method="post">
         <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
            <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
               <tr class="dialogTr">
                  <td width="20%" class="dialogTd" align="right">地名类型：</td>
                  <td width="80%" class="dialogTd">
                      <input type="text" name="dmlx" id="dmlx"  value="${entity.dmlx}" class="easyui-combobox" style="width:430px;"
	    			   data-options="required:true,url:contextPath+'/common/dict/DZ_BZDZ_DMLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
                  </td>
               </tr>
               <tr class="dialogTr">
                  <td width="20%" class="dialogTd" align="right">地名名称：</td>
                  <td width="80%" class="dialogTd">
                      <input type="text" id="dmmc" name="dmmc" value="${entity.dmmc}" class="easyui-validatebox" style="width:430px;" 
		    		        data-options="required:true,tipPosition:'right',charSet:'halfUpper'" maxlength="30" />
                  </td>
               </tr>
               <tr class="dialogTr">
                  <td width="20%" class="dialogTd" align="right">关联图层：</td>
                  <td width="80%" class="dialogTd">
                      <input type="text" name="dlst" id="dlst"  value="${entity.dlst}" class="easyui-combobox" style="width:430px;"/>
                  </td>
               </tr>
               <tr class="dialogTr">
			    	<td class="dialogTd" colspan="2" width="100%">
			    	    <table border="0" cellpadding="0" cellspacing="5" style="width: 100%;" align="center" id="dmXzqhTable">
			               <c:forEach items="${dmxzqhbArray}" var="dmxzqhb" varStatus="status">
				                  <c:if test="${status.index > 0}">
				                     <tr id="dmXzqhTr1${status.index}"><td height="5"></td></tr>
				                  </c:if>
			                      <tr class="dialogTr" id="dmXzqhTr2${status.index}">
			                         <td width="20%" class="dialogTd" align="right">行政区划：</td>
			                         <td width="80%" class="dialogTd">
			                              <input type="text" id="dmxzqh_${status.index}" name="dmxzqhbArray[${status.index}].xzqhdm" class="easyui-combobox" data-options="required:true,url:contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',
			                                     method:'get',valueField:'id',textField:'text',selectOnNavigation:false,onLoadSuccess:function(){$('#dmxzqh_${status.index}').combobox('setValue','<%=xzqhdm%>');}" style="width:430px"/>
				                          <c:choose>
				                              <c:when test="${status.index == 0}"><a id="addid" class="addLine_btn" href="javascript:void(0);" title="增加一个行政区划" onclick="addDmXzqh();"></a></c:when>
				                              <c:otherwise><a class="delLine_btn" href="javascript:void(0);" title="注销当前行政区划" onclick="delXzqh('${status.index}')"></a></c:otherwise>
				                          </c:choose>
			                         </td>
			                      </tr>
			               </c:forEach>
			            </table>
			          </td>
			    </tr>
			    <tr class="dialogTr">
			    	<td class="dialogTd" colspan="2" width="100%">
			    	    <table border="0" cellpadding="0" cellspacing="5" style="width: 100%;" align="center" id="dmZzjgTable">
			               <c:forEach items="${dmzzjgbArray}" var="dmzzjgb" varStatus="status">
				                  <c:if test="${status.index > 0}">
				                     <tr id="dmZzjgTr1${status.index}"><td height="5"></td></tr>
				                  </c:if>
			                      <tr class="dialogTr" id="dmZzjgTr2${status.index}">
			                         <td width="20%" class="dialogTd" align="right">管辖分(县)局：</td>
			                         <td width="28%" class="dialogTd">
			                             <input type="text" name="dmzzjgbArray[${status.index}].fxjdm" id ="dmFxjdm_${status.index}" class="easyui-combobox" 
										           data-options="required:true,valueField:'id',textField:'text',url:'<%=basePath%>gzjk/queryOrg',onSelect:function(rec){
						                                           var url='<%=basePath%>gzjk/queryOrgLower?orgCode='+rec.id;$('#dmPcsdm_${status.index}').combobox('reload', url);},onLoadSuccess:function(){$('#dmFxjdm_${status.index}').combobox('setValue','<%=userOrgCode%>');}"  style="width:160px;"/>
			                         </td>
			                         <td width="13%" class="dialogTd" align="right">管辖派出所：</td>
			                         <td width="38%" class="dialogTd">
			                              <input type="text" id="dmPcsdm_${status.index}" name="dmzzjgbArray[${status.index}].pcsdm" class="easyui-combobox"  data-options="required:true,valueField:'id',textField:'text'" style="width:170px"/>
				                          <c:choose>
				                              <c:when test="${status.index == 0}"><a class="addLine_btn" href="javascript:void(0);" title="增加一个管辖单位" onclick="addDmGxdw();"></a></c:when>
				                              <c:otherwise><a class="delLine_btn" href="javascript:void(0);" title="注销当前管辖单位" onclick="delGxdw('${status.index}')"></a></c:otherwise>
				                          </c:choose>
			                         </td>
			                      </tr>
			               </c:forEach>
			            </table>
			         </td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备&nbsp;&nbsp;注：</td>
					<td width="80%" class="dialogTd">
					      <textarea class="easyui-validatebox" id="bz" name="bz" style="width: 430px; height:48px;overflow: auto;"
						         data-options="validType:['maxLength[500]'],invalidMessage:'备注不能超过500个汉字，请重新输入！',tipPosition:'left',required:false">${entity.bz}</textarea>
					</td>
		    	</tr>
            </table>
         </div>
      </form>
  </body>
  <script type="text/javascript">
  var dmXzqhCount = parseInt("${dmxzqhbArrayLength}");
  //增加一个行政区划
  function addDmXzqh(){
	  var tr1 = $('<tr id="dmXzqhTr1'+ dmXzqhCount +'"><td height="5"></td></tr>');
	  var tr2 = $('<tr class="dialogTr" id="dmXzqhTr2'+dmXzqhCount+'"></tr>');
      var td1 = $('<td width="20%" class="dialogTd" align="right">行政区划：</td>'); 	  
      var td2 = $('<td width="80%" class="dialogTd" id="xzqhTd'+ dmXzqhCount +'"></td>'); 
      var td2Html = new StringBuffer();
      td2Html.append("<input type='text' id='dmxzqh_"+dmXzqhCount+"' name='dmxzqhbArray["+dmXzqhCount+"].xzqhdm' class='easyui-combobox' data-options=\"required:true,url:contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',method:'get',valueField:'id',textField:'text',selectOnNavigation:false\" style='width:430px'/>");
      td2Html.append("&nbsp;<a class='delLine_btn' href='javascript:void(0);' onclick='delXzqh("+ dmXzqhCount +")' title='注销当前行政区划'></a>");
      td2.html(td2Html.toString());
      tr2.append(td1);
      tr2.append(td2);
      $('#dmXzqhTable').append(tr1);
      $('#dmXzqhTable').append(tr2);
  	  $.parser.parse('#xzqhTd' + dmXzqhCount);
      dmXzqhCount++;
  }
  //删除一个行政区划
  function delXzqh(xqNo){
	  $("#dmXzqhTr1" + xqNo).remove();
	  $("#dmXzqhTr2" + xqNo).remove();
  }
  var dmZzjgCount = parseInt("${dmzzjgbArrayLength}");
  //增加一个管辖单位
  function addDmGxdw(){
	  var tr1 = $('<tr id="dmZzjgTr1'+ dmZzjgCount +'"><td height="5"></td></tr>');
	  var tr2 = $('<tr class="dialogTr" id="dmZzjgTr2'+dmZzjgCount+'"></tr>');
      var td1 = $('<td width="20%" class="dialogTd" align="right">管辖分(县)局：</td>'); 	  
      var td2 = $('<td width="28%" class="dialogTd" id="zzjgTd1'+ dmZzjgCount +'"></td>'); 
      var td2Html = new StringBuffer();
      td2Html.append("<input type='text' id='dmFxjdm_"+dmZzjgCount+"' name='dmzzjgbArray["+dmZzjgCount+"].fxjdm' class='easyui-combobox' data-options=\"required:true,valueField:'id',textField:'text',url:contextPath+'/gzjk/queryOrg',onLoadSuccess:function(){$('#dmFxjdm_"+dmZzjgCount+"').combobox('setValue','<%=userOrgCode%>');},onSelect:function(rec){ var url=contextPath+'/gzjk/queryOrgLower?orgCode='+rec.id;$('#dmPcsdm_"+dmZzjgCount+"').combobox('reload', url);}\"  style='width:160px;'/>");
      td2.html(td2Html.toString());
      var td3 = $('<td width="13%" class="dialogTd" align="right">管辖派出所：</td>'); 	  
      var td4 = $('<td width="38%" class="dialogTd" id="zzjgTd2'+ dmZzjgCount +'"></td>'); 
      var td4Html = new StringBuffer();
      td4Html.append("<input type='text' id='dmPcsdm_"+dmZzjgCount+"' name='dmzzjgbArray["+dmZzjgCount+"].pcsdm' class='easyui-combobox'  data-options=\"required:true,valueField:'id',textField:'text'\" style='width:170px'/>");
      td4Html.append("&nbsp;<a class='delLine_btn' href='javascript:void(0);' onclick='delGxdw("+ dmZzjgCount +")' title='注销当前管辖单位'></a>");
      td4.html(td4Html.toString());
      tr2.append(td1);
      tr2.append(td2);
      tr2.append(td3);
      tr2.append(td4);
      $('#dmZzjgTable').append(tr1);
      $('#dmZzjgTable').append(tr2);
  	  $.parser.parse('#zzjgTd1' + dmZzjgCount);
  	  $.parser.parse('#zzjgTd2' + dmZzjgCount);
	  dmZzjgCount++;
  }
  //删除一个管辖单位
  function delGxdw(gxdwNo){
	  $("#dmZzjgTr1" + gxdwNo).remove();
	  $("#dmZzjgTr2" + gxdwNo).remove();
  }
  //保存前（必写此方法可为空,否则弹出框保存失败）
  function afterSubmit(arr) {
	  //刷新列表
	  parent.DmManage.queryButton();
  }
  //保存后（必写此方法可为空,否则弹出框保存失败）
  function beforeSubmit() {
  }
  </script>
</html>