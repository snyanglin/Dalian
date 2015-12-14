<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>地址审核And详情页面</title>
    <script type="text/javascript">
      //以下参数主要是地图以及点气泡框用
      var bjzbz = "${entity.bjzbz}";
      var zbx = "${entity.zbx}";
	  var zby = "${entity.zby}";
	  var shztdm = "${entity.shztdm}";
	  var dzmc = "${entity.dzmc}";
	  var xt_cjsj = "${entity.xt_cjsj}";
	  var zrqmc = "${entity.zrqmc}";
	  var pcsmc = "${entity.pcsmc}";
	  var dzbmArr = "${dzBmArray}";
	  var mlphqc = "${entity.mlphqc}";
	  var mldzid = "${entity.mldzid}";
	  var mainTabID = "${mainTabID}";
	  var type = "${type}";
	  var dzChb = "${dzChb}";
	  var xt_lrrxm = "${entity.xt_lrrxm}";
	  var shrxm = "${entity.shrxm}";
	  var shsj = "${entity.shsj}";
	  var bz = "${entity.bz}";
	  var chType = "${chType}";
	  var title = "";
	  if(type=="0"){
		  title = "地址审核";
	  }else{
		  title = "地址详情";
	  }
    </script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzVerify/dzVerifyAndSee.js"></script>
  </head>
  <body id="panelid" class="easyui-layout" data-options="fit:true">
      <div data-options="region:'west',title:title" style="width:380px;">
          	<table border="0" cellpadding="0" cellspacing="10" width="100%">
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">行政区划：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="xzqhdm" name="xzqhdm" class="easyui-combobox"
							  data-options="required:true,url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',
					                        method:'get',valueField:'id',textField:'text',selectOnNavigation:false,
					                        onLoadSuccess:function(){$('#xzqhdm').combobox('setValue','${entity.xzqhdm}');}" style="width:215px;"/>
				   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">地名：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="dmmc" name="dmmc" class="easyui-validatebox" value="${entity.dmmc}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌前缀：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="mlphqz" name="mlphqz" class="easyui-combobox"
							data-options="url: contextPath + '/common/dict/DZ_BZDZ_MLPHQZ.js',valueField:'id',textField:'text',
							              selectOnNavigation:false,method:'get',tipPosition:'left',
							              onLoadSuccess:function(){$('#mlphqz').combobox('setValue','${entity.mlphqz}');}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌号：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input class="easyui-validatebox" type="text" id="mlph" name="mlph" style="width:215px;" value="${entity.mlph}" />
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌后缀：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="mlphhz" name="mlphhz" class="easyui-combobox"
							data-options="required:true,url: contextPath + '/common/dict/D_BZDZ_MLPHHZ.js',valueField:'id',textField:'text',
							              selectOnNavigation:false,method:'get',tipPosition:'left',
							              onLoadSuccess:function(){$('#mlphhz').combobox('setValue','${entity.mlphhz}');}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌全称：</td>
		    	   <td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" id="mlphqc" name="mlphqc" style="width:215px;" value="${entity.mlphqc}"/></td>
               </tr>
               <tr class="dialogTr">
                   <td class="dialogTd" colspan="2" width="100%">
                       	<table border="0" cellpadding="0" cellspacing="5" style="width: 100%;" align="center" id="dzBmTable">
                       	    <c:forEach items="${dzBmArray}" var="dzbmb" varStatus="status">
                       	         <c:if test="${status.index > 0}">
				                     <tr id="dzBmTr1${status.index}"><td height="5"></td></tr>
				                 </c:if>
				                 <tr class="dialogTr" id="dzBmTr2${status.index}">
				                     <td width="30%" class="dialogTd" align="right">地址别名：</td>
				                     <td width="70%" class="dialogTd">
				                         <input class="easyui-validatebox" type="text" id="dzbm${status.index}" name="dzbm" style="width:215px;" value="${dzbmb.dzbm}" />
				                     </td>
				                 </tr>
                       	    </c:forEach>
                       	</table>
                   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">责任区：</td>
		    	   <td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zrqmc" style="width:215px;" value="${entity.zrqmc}"/></td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">社区：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="sqmc" name="sqmc" class="easyui-validatebox" style="width:215px;" value="${entity.sqmc}"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">地图错误反馈：</td>
		    	   <td width="70%" class="dialogTd">
		    	      <textarea id="dtcwfk" name="dtcwfk" class="easyui-validatebox" style="width:215px;height:45px;overflow: auto;">${entity.dtcwfk}</textarea>
		    	   </td>
               </tr>
               <tr class="dialogTr" id="bhgyyid" style="display: none;">
                   <td width="30%" class="dialogTd" align="right">不合格原因：</td>
		    	   <td width="70%" class="dialogTd">
		    	      <textarea id="shbhgyy" name="shbhgyy" class="easyui-validatebox" style="width:215px;height:55px;overflow: auto;">${entity.shbhgyy}</textarea>
		    	   </td>
               </tr>
            </table>
            <div id="buttonDiv" style="text-align: center;">
				<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">退出</span>
						<span class="l-btn-icon icon-back"></span>
					</span>
				</a>
				<a id="hgButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" style="margin-left: 10px;">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text" id="saveId">合格</span>
						<span class="l-btn-icon icon-ok"></span>
					</span>
				</a>
				<a id="bhgButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" style="margin-left: 10px;">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">不合格</span>
						<span class="l-btn-icon icon-no"></span>
					</span>
				</a>
				<a id="ckchButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" style="margin-left: 10px;">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">查看层户</span>
						<span class="l-btn-icon icon-home"></span>
					</span>
				</a>
			</div>
			<div id="bhgWin" style="display: none;">
			  <form id="dataBhgForm" name="dataBhgForm">
			    <table border="0" cellpadding="0" cellspacing="10" width="100%">
				    <tr class="dialogTr">
	                   <td width="30%" class="dialogTd" align="right">不合格原因：</td>
			    	   <td width="70%" class="dialogTd" align="left">
			    	      <textarea id="shbhgyy1" name="shbhgyy1" class="easyui-validatebox" style="width:215px;height:80px;overflow: auto;"
			    	       data-options="required:true,validType:['maxLength[99]'],invalidMessage:'反馈内容不能超过100个汉字，请重新输入！',tipPosition:'right'"></textarea>
			    	   </td>
	                </tr>
                </table>
               </form> 
			</div>
      </div>
      <div data-options="region:'center',border:false">
         <div id="tt" class="easyui-tabs" data-options="border:false,fit:true">
            <div title="地图">
               <div id="mapDiv"></div>
	           <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
            </div>
            <div title="层户" id="chDivId"></div>
         </div>
      </div>
  </body>
</html>