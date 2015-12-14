<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>地址建筑物新建</title>
    <script type="text/javascript">
      var mainTabID = "${mainTabID}";
      var mldzid = "${mldzid}";
      //type 0为可编辑、1为只读
      var type = "${type}";
      //dzChb地址层户表 0为层户地址对象表、1为层户地址审核表 
      var dzChb = "${dzChb}";
      //标准地址新增或维护是否审核：0为禁用（默认）、1为启用
      var bzdzSh = "${bzdzSh}";
      //chType层户结构 0为编辑、1为只读
      var chType = "${chType}";
      //注销重建标识
      var buildingBz = "1";
    </script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzBuilding/dzBuildingAdd.js"></script>
  </head>
  <body style="overflow: auto;border: 0px;text-align: center;">
      <div class="easyui-layout" data-options="fit:true">
          <div data-options="region:'west',border:false" style="width:255px;border-right: 1px solid #ccc9da;overflow: hidden;">
               <div class="scIco_title">生成层户结构</div>
               <form action="<%=basePath%>dz/saveChDz" id="dataChForm" name="dataChForm" method="post">
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
					<!--begin:地下-->
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
					<!--end:地下-->
					<!-- 门楼地址ID -->
         			<input type='hidden' name='mldzid' id="mldzid" value="${mldzid}"/>
         			<input type='hidden' name='dzChb' id="dzChb" value="${dzChb}"/>
         			<input type='hidden' name='dzmc' id="dzmc" value="${entity.dzmc}"/>
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
					<div class="btn_wrap">
						<input type="button" class="btn1" id="qdid" value="保 存" onclick="DzBuildingAdd.qdButton();"/>&nbsp;
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
     </body>
</html>