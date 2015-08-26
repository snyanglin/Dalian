<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    String xzqhdm = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
        if(!"".equals(userOrgCode)&&userOrgCode!=null){
        	xzqhdm = userOrgCode.substring(0,6);
        }
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>地名新增</title>
  </head>
  <body>
      <form action="<%=basePath%>dm/editDm" id="dataForm" name="dataForm" method="post">
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
			                              <input type="text" id="dmxzqh_${status.index}" name="dmxzqhbArray[${status.index}].xzqhdm" value="${dmxzqhb.xzqhdm}" class="easyui-combobox"
			                                data-options="required:true,url:contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',method:'get',
			                                valueField:'id',textField:'text',selectOnNavigation:false" style="width:430px"/>
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
			                             <input type="text" id ="dmFxjdm_${status.index}"  name="dmzzjgbArray[${status.index}].fxjdm" value="${dmzzjgb.fxjdm}" class="easyui-combobox" 
										           data-options="required:true,valueField:'id',textField:'text',url:'<%=basePath%>gzjk/queryOrg'" style="width:160px;"/>
			                         </td>
			                         <td width="13%" class="dialogTd" align="right">管辖派出所：</td>
			                         <td width="38%" class="dialogTd">
			                              <input type="text" id="dmPcsdm_${status.index}" name="dmzzjgbArray[${status.index}].pcsdm" value="${dmzzjgb.pcsdm}" class="easyui-combobox" 
			                                       data-options="required:true,valueField:'id',textField:'text',url:'<%=basePath%>gzjk/queryOrgLower?orgCode=${dmzzjgb.fxjdm}'" style="width:170px"/>
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
         <!-- 地名ID -->
         <input type="hidden" id="dmid" name="dmid" value="${entity.dmid}">
         <input type="hidden" id="dmdm" name="dmdm" value="${entity.dmdm}">
         <input type="hidden" id="olddmmc" name="olddmmc" value="${entity.dmmc}">
      </form>
  </body>
  <script type="text/javascript">
  //初始化页面
  $(function(){
	//设置只读属性
	  onloadReadonly();
  });
  function onloadReadonly(){
	//地名类型【只读】
	setInputReadonly('dmlx', true);
	var dmXzqhCount = parseInt("${dmxzqhbArrayLength}");
	var dmZzjgCount = parseInt("${dmzzjgbArrayLength}");
	//行政区划【只读】
	for(var i=0;i<dmXzqhCount;i++){
		setInputReadonly("dmxzqh_"+i, true);
	}
	//管辖分(县)局、管辖派出所【只读】
	for(var j=0;j<dmZzjgCount;j++){
		setInputReadonly("dmFxjdm_"+j, true);
		setInputReadonly("dmPcsdm_"+j, true);
	}
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