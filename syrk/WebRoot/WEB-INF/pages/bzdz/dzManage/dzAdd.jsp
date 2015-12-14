<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    String xzqhdm = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
        if(!"".equals(userOrgCode)&&userOrgCode!=null){
        	xzqhdm = userOrgCode.substring(0,6);
        }
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>地址新建</title>
     <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
       
       var mainTabID = "${mainTabID}";
       var dzBmCount = parseInt("${dzBmArrayLength}");
       //注销重建标识
       var buildingBz = "0";
     </script>
     <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
     <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzManage/dzAdd.js"></script>
     <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzBuilding/dzBuildingAdd.js"></script>
  </head>
  <body id="panelid" class="easyui-layout" data-options="fit:true">
     <div data-options="region:'west',title:'地址新建'" style="width:380px;">
         <form action="<%=basePath%>dz/saveDz" id="dataForm" name="dataForm" method="post">
            <table border="0" cellpadding="0" cellspacing="10" width="100%">
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">行政区划：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="hidden" name="xzqhmc" id="xzqhmc" value="">
		    	       <input type="text" id="xzqhdm" name="xzqhdm" class="easyui-combobox"
							  data-options="required:true,url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',
					                        method:'get',valueField:'id',textField:'text',selectOnNavigation:false,
					                        onLoadSuccess:function(){$('#xzqhdm').combobox('setValue','<%=xzqhdm%>');$('#xzqhmc').val($('#xzqhdm').combobox('getText'));},
					                        onSelect:function(rec){$('#xzqhmc').val(rec.text);$('#dmdm').combobox('reload');}" style="width:215px;"/>
				   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">地名：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="hidden" name="dmmc" id="dmmc" value="">
		    	       <input type="text" id="dmdm" name="dmdm" class="easyui-combobox" 
		    	            data-options="required:true,url:contextPath+'/dm/queryDictDm',valueField:'id',textField:'text',isTopLoad:false,
		    	            onBeforeLoad:function(param){param.xzqhdm=$('#xzqhdm').combobox('getValue');},
		    	            onChange:function(rec,oldValue){$('#dmmc').val($('#dmdm').combobox('getText'));DzAdd.setMlpqc();},
		    	            onSelect:function(rec){$('#dmmc').val(rec.text);DzAdd.setMlpqc();}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌前缀：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="hidden" name="mlphqzmc" id="mlphqzmc" value="">
		    	       <input type="text" id="mlphqz" name="mlphqz" class="easyui-combobox"
							data-options="url: contextPath + '/common/dict/DZ_BZDZ_MLPHQZ.js',valueField:'id',textField:'text',
							              selectOnNavigation:false,method:'get',tipPosition:'left',
							              onChange:function(rec,oldValue){$('#mlphqzmc').val($('#mlphqz').combobox('getText'));DzAdd.setMlpqc();},
							              onSelect:function(rec){$('#mlphqzmc').val(rec.text);DzAdd.setMlpqc();}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌号：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input class="easyui-validatebox" type="text" id="mlph" name="mlph" style="width:215px;" 
		    	              onkeyup="DzAdd.setMlpqc();" data-options="required:true,validType:['maxLength[40]']"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌后缀：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="hidden" name="mlphhzmc" id="mlphhzmc" value="号">
		    	       <input type="text" id="mlphhz" name="mlphhz" class="easyui-combobox" value="01"
							data-options="required:true,url: contextPath + '/common/dict/D_BZDZ_MLPHHZ.js',valueField:'id',textField:'text',
							              selectOnNavigation:false,method:'get',tipPosition:'left',
							              onChange:function(rec,oldValue){$('#mlphhzmc').val($('#mlphhz').combobox('getText'));DzAdd.setMlpqc();},
							              onSelect:function(rec){$('#mlphhzmc').val(rec.text);DzAdd.setMlpqc();}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌全称：</td>
		    	   <td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" id="mlphqc" name="mlphqc" style="width:215px;"/></td>
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
				                         <input class="easyui-validatebox" type="text" id="dzbm_${status.index}" name="dzBmArray[${status.index}].dzbm" style="width:215px;"/>
				                         <c:choose>
			                              	<c:when test="${status.index == 0}"><a class="addLine_btn" href="javascript:void(0);" title="增加一个地址别名" onclick="DzAdd.addDzBm();"></a></c:when>
			                              	<c:otherwise><a class="delLine_btn" href="javascript:void(0);" title="注销当前地址别名" onclick="DzAdd.delDzBm('${status.index}')"></a></c:otherwise>
			                             </c:choose>
				                     </td>
				                 </tr>
                       	    </c:forEach>
                       	</table>
                   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">责任区：</td>
		    	   <td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zrqmc" style="width:215px;" value="<%=userOrgName%>"/></td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">社区：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="sqdm" name="sqdm" class="easyui-combobox" 
		    	            data-options="url:contextPath+'/dm/queryDictSq',valueField:'id',textField:'text',isTopLoad:false" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">地图错误反馈：</td>
		    	   <td width="70%" class="dialogTd">
		    	      <textarea id="dtcwfk" name="dtcwfk" class="easyui-validatebox" style="width:215px;height:45px;overflow: auto;"
								data-options="validType:['maxLength[200]'],invalidMessage:'反馈内容不能超过200个汉字，请重新输入！',tipPosition:'left'"></textarea>
		    	   </td>
               </tr>
            </table>
            <!-- 地理位置 -->
            <input type='hidden' name='zbx' id="zbx" value=""/>
            <input type='hidden' name='zby' id="zby" value=""/>
            <!-- 生成层户机构 -->
            <!-- 地上信息 -->
            <input type='hidden' name='dsdys' id="dsdys" value=""/>
            <input type='hidden' name='dszdcs' id="dszdcs" value=""/>
            <input type='hidden' name='dszdhs' id="dszdhs" value=""/>
            <input type='hidden' name='dsdyjbxx' id="dsdyjbxx" value=""/>
            <input type='hidden' name='dslcjbxx' id="dslcjbxx" value=""/>
            <input type='hidden' name='dsfjjbxx' id="dsfjjbxx" value=""/>
            <!-- 地下信息 -->
            <input type='hidden' name='dxdys' id="dxdys" value=""/>
            <input type='hidden' name='dxzdcs' id="dxzdcs" value=""/>
            <input type='hidden' name='dxzdhs' id="dxzdhs" value=""/>
            <input type='hidden' name='dxdyjbxx' id="dxdyjbxx" value=""/>
            <input type='hidden' name='dxlcjbxx' id="dxlcjbxx" value=""/>
            <input type='hidden' name='dxfjjbxx' id="dxfjjbxx" value=""/>
         </form>
         <div id="buttonDiv" style="text-align: center;">
			<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">退出</span>
					<span class="l-btn-icon icon-back"></span>
				</span>
			</a>
			&nbsp;
			<a id="saveButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text" id="saveId">保存</span>
					<span class="l-btn-icon icon-save"></span>
				</span>
			</a>
			&nbsp;
			<a id="dtbdButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">标点</span>
					<span class="l-btn-icon icon-biaodian"></span>
				</span>
			</a>
			&nbsp;
			<a id="scchButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">生成层户</span>
					<span class="l-btn-icon icon-home"></span>
				</span>
			</a>
		</div>
     </div>
     <div data-options="region:'center',border:false">
        <div id="tt" class="easyui-tabs" data-options="border:false,fit:true">
           <div title="地图">
               <div id="mapDiv"></div>
	           <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
           </div>
           <div title="层户">
              <div class="easyui-layout" data-options="fit:true">
	               <div data-options="region:'west',border:false" style="width:255px;border-right: 1px solid #ccc9da;overflow: hidden;">
	                    <div class="scIco_title">生成层户结构</div>
	                    <form id="dataChForm" name="dataChForm">
						<!--begin:地上-->
						<div class="ds_wrapper1">
							<div class="ds_title" id="ds_class">
								<div class="ds_text">地上</div>
								<div class="ds_checkbox" id="dsBoxDiv"></div>
							</div>
							<div class="ds_con">
							 <ul>
							  <li>
							    <div class="text_W">单元数</div>
							    <div class="ds_btnCur" id="deldsdys">-</div>
							    <div class="ds_mid">
							       <input type="text" class="easyui-validatebox" style="width: 39px;float: left;border: none;background-color: #fff;font-size: 14px;
							       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
							       id="dszddys" name="dszddys" data-options="validType:['naturalNumberRange[1,20]']" maxlength="2" value="1" onkeyup="DzBuildingAdd.onloadDsCh();"/>
							    </div>
							    <div class="ds_btnCur" id="adddsdys">+</div>
							  </li>
							  <li>
							    <div class="text_W">楼层数</div>
							    <div class="ds_btnCur" id="deldslcs">-</div>
							    <div class="ds_mid">
							       <input type="text" class="easyui-validatebox" style="width: 39px;float: left;border: none;background-color: #fff;font-size: 14px;
							       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;"
							       id="dslcs" name="dslcs" data-options="validType:['naturalNumberRange[1,150]']" maxlength="3" value="1" onkeyup="DzBuildingAdd.onloadDsCh();"/>
							    </div>
							    <div class="ds_btnCur" id="adddslcs">+</div>
							  </li>
							  <li>
							    <div class="text_W">单层户数</div>
							    <div class="ds_btnCur" id="deldshs">-</div>
							    <div class="ds_mid">
							       <input type="text" class="easyui-validatebox" style="width: 39px;float: left;border: none;background-color: #fff;font-size: 14px;
							       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
							       id="dshs" name="dshs" data-options="validType:['naturalNumberRange[1,999]']" maxlength="3" value="1" onkeyup="DzBuildingAdd.onloadDsCh();"/>
							    </div>
							    <div class="ds_btnCur" id="adddshs">+</div>
							  </li>
							 </ul>
							</div>
						</div>
						<!--end:地上-->
						<!--begin:地上-->
						<div class="ds_wrapper">
							<div class="dx_titleGray" id="dx_class">
								<div class="ds_text">地下</div>
								<div class="ds_checkbox" id="dxBoxDiv"></div>
							</div>
							<div class="ds_con">
							 <ul>
							  <li>
							    <div class="text_W">单元数</div>
							    <div class="ds_btn" id="deldxdys" disabled="disabled">-</div>
							    <div class="ds_mid">
							       <input type="text" class="easyui-validatebox" style="width: 39px;float: left;border: none;background-color: #fff;font-size: 14px;
							       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
							       id="dxzddys" name="dxzddys" data-options="validType:['naturalNumberRange[1,20]']" maxlength="2" onkeyup="DzBuildingAdd.onloadDxCh();" disabled="disabled"/>
							    </div>
							    <div class="ds_btn" id="adddxdys" disabled="disabled">+</div>
							  </li>
							  <li>
							    <div class="text_W">楼层数</div>
							    <div class="ds_btn" id="deldxlcs" disabled="disabled">-</div>
							    <div class="ds_mid">
							       <input type="text" class="easyui-validatebox" style="width: 39px;float: left;border: none;background-color: #fff;font-size: 14px;
							       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
							       id="dxlcs" name="dxlcs" data-options="validType:['naturalNumberRange[1,20]']" maxlength="3" onkeyup="DzBuildingAdd.onloadDxCh();" disabled="disabled"/>
							    </div>
							    <div class="ds_btn" id="adddxlcs" disabled="disabled">+</div>
							  </li>
							  <li>
							    <div class="text_W">单层户数</div>
							    <div class="ds_btn" id="deldxhs" disabled="disabled">-</div>
							    <div class="ds_mid">
							       <input type="text" class="easyui-validatebox" style="width: 39px;float: left;border: none;background-color: #fff;font-size: 14px;
							       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
							       id="dxhs" name="dxhs" data-options="validType:['naturalNumberRange[1,99]']" maxlength="3" onkeyup="DzBuildingAdd.onloadDxCh();" disabled="disabled"/>
							    </div>
							    <div class="ds_btn" id="adddxhs" disabled="disabled">+</div>
							  </li>
							 </ul>
							</div>
						</div>
						<!--end:地上-->
						</form>
						<div class="btn_wrap">
							<input type="button" class="btn1" id="qdid" value="确 定" onclick="DzBuildingAdd.qdButton(0);"/>&nbsp;
							<input type="button" class="btn2" id="czid" value="重 置" onclick="DzBuildingAdd.czButton();"/>
						</div>
	               </div>
	               <div id="chjgId" data-options="region:'center',border:false">
	                    <div id="chjgAddDsDiv" style="text-align: center;margin-top: 10px;"></div>
	                    <div id="chjgAddDxDiv" style="text-align: center;margin-top: 10px;margin-bottom: 10px;"></div>
	                    <!-- 修改地上单元基本信息 -->
	                    <div id='showRightDiv' class="lou_wrap">
							<table cellpadding="0" cellspacing="0" border="0" class="lou_table" >
								<tr>
									<td align="right">修改单元名称：</td>
									<td>
									    <input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dsdymc" name="xg_dsdymc" data-options="validType:['naturalNumberRange[1,99]']" maxlength="2"/>
										<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateDymc();">
									</td>
								</tr>
								<tr>
									<td align="right">修改地上层数：</td>
									<td>
										<input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dslcs" name="xg_dslcs" data-options="validType:['naturalNumberRange[1,150]']" maxlength="3"/>
										<input type='button' id='dInfoBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateCS();">
									</td>
								</tr>
								<tr>
									<td align="right">修改地上户数：</td>
									<td>
										<input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dshs" name="xg_dshs" data-options="validType:['naturalNumberRange[1,999]']" maxlength="3"/>
										<input type='button' id='dInfoBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateHs();">
									</td>
								</tr>
								<tr >
									<td colspan="2">
									  <div style="width:100%;height:auto;margin-top:5px">
                                      <input type="button" value="关闭" onClick="DzBuildingAdd.hiddenCalendar();" class="lou_close"/>
                                      </div>
									</td>
								</tr>
							</table>
						  </div>
						  <div id='showRightHsDiv' class="lou_wrap">
							<table cellpadding="0" cellspacing="0" border="0" class="lou_table" >
								<tr>
									<td align="right">修改楼层户数：</td>
									<td>
									    <input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dslchs" name="xg_dslchs" data-options="validType:['naturalNumberRange[1,999]']" maxlength="3"/>
										<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateClHs();">
									</td>
								</tr>
								<tr >
									<td colspan="2">
									  <div style="width:100%;height:auto;margin-top:5px">
                                      <input type="button" value="关闭" onClick="DzBuildingAdd.hiddenCalendar();" class="lou_close"/>
                                      </div>
									</td>
								</tr>
							</table>
						  </div>
						  <div id='showRightHouseDiv' class="lou_wrap">
							<table cellpadding="0" cellspacing="0" border="0" class="lou_table" >
								<tr>
									<td align="right">修改房间名称：</td>
									<td>
									    <input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_fjmc" name="xg_fjmc" data-options="validType:['naturalNumberRange[1,999]']" maxlength="3"/>
										<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateFjmc();">
									</td>
								</tr>
								<tr >
									<td colspan="2">
									  <div style="width:100%;height:auto;margin-top:5px">
                                      <input type="button" value="关闭" onClick="DzBuildingAdd.hiddenCalendar();" class="lou_close"/>
                                      </div>
									</td>
								</tr>
							</table>
						  </div>
						  <!-- 修改地下单元基本信息（分开写比较清晰，否则判断太多）-->
						  <div id='showDxRightDiv' class="lou_wrap">
							<table cellpadding="0" cellspacing="0" border="0" class="lou_table" >
								<tr>
									<td align="right">修改单元名称：</td>
									<td>
									    <input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dxdymc" name="xg_dxdymc" data-options="validType:['naturalNumberRange[1,20]']" maxlength="2"/>
										<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateDxDymc();">
									</td>
								</tr>
								<tr>
									<td align="right">修改地下层数：</td>
									<td>
										<input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dxlcs" name="xg_dxlcs" data-options="validType:['naturalNumberRange[1,20]']" maxlength="2"/>
										<input type='button' id='dInfoBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateDxCS();">
									</td>
								</tr>
								<tr>
									<td align="right">修改地下户数：</td>
									<td>
										<input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dxhs" name="xg_dxhs" data-options="validType:['naturalNumberRange[1,99]']" maxlength="2"/>
										<input type='button' id='dInfoBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateDxHs();">
									</td>
								</tr>
								<tr >
									<td colspan="2">
									  <div style="width:100%;height:auto;margin-top:5px">
                                      <input type="button" value="关闭" onClick="DzBuildingAdd.hiddenCalendar();" class="lou_close"/>
                                      </div>
									</td>
								</tr>
							</table>
						  </div>
						  <div id='showDxRightHsDiv' class="lou_wrap">
							<table cellpadding="0" cellspacing="0" border="0" class="lou_table" >
								<tr>
									<td align="right">修改楼层户数：</td>
									<td>
									    <input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dxlchs" name="xg_dxlchs" data-options="validType:['naturalNumberRange[1,99]']" maxlength="2"/>
										<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateDxClHs();">
									</td>
								</tr>
								<tr >
									<td colspan="2">
									  <div style="width:100%;height:auto;margin-top:5px">
                                      <input type="button" value="关闭" onClick="DzBuildingAdd.hiddenCalendar();" class="lou_close"/>
                                      </div>
									</td>
								</tr>
							</table>
						  </div>
						  <div id='showDxRightHouseDiv' class="lou_wrap">
							<table cellpadding="0" cellspacing="0" border="0" class="lou_table" >
								<tr>
									<td align="right">修改房间名称：</td>
									<td>
									    <input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
									       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
									       id="xg_dxfjmc" name="xg_dxfjmc" data-options="validType:['naturalNumberRange[1,999]']" maxlength="3"/>
										<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuildingAdd.SendUpdateDxFjmc();">
									</td>
								</tr>
								<tr >
									<td colspan="2">
									  <div style="width:100%;height:auto;margin-top:5px">
                                      <input type="button" value="关闭" onClick="DzBuildingAdd.hiddenCalendar();" class="lou_close"/>
                                      </div>
									</td>
								</tr>
							</table>
						  </div>
	               </div>
               </div>
           </div>
        </div>
     </div>
  </body>
</html>