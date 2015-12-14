<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>地址建筑物查看And维护页面</title>
    <script type="text/javascript">
      var mainTabID = "${mainTabID}";
      var mldzid = "${mldzid}";
      //type 0为可编辑、1为只读
      var type = "${type}";
      //dzChb地址层户表 0为层户地址对象表、1为层户地址审核表 
      var dzChb = "${dzChb}";
      //chType层户结构 0为编辑、1为只读
      var chType = "${chType}";
    </script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzBuilding/dzBuilding.js"></script>
  </head>
  <body style="overflow: auto;border: 0px;text-align: center;">
     <div id="chjgAddDsDiv" style="text-align: center;margin-top: 10px;"></div>
	 <div id="chjgAddDxDiv" style="text-align: center;margin-top: 10px;margin-bottom: 10px;"></div>
	 <div style="text-align: center;font-size: 14px;font-weight: bold;color: red;">
	        ${entity.dzmc}
	        <a id="zxcjId" href="javascript:DzBuilding.chjgZxcj();" style="font-size: 14px;font-weight: bold;">【注销重建】</a>
	 </div>
	 <!-- 修改地上单元基本信息 -->
	 <div id='showRightDiv' class="lou_wrap">
		<table cellpadding="0" cellspacing="0" border="0" class="lou_table" >
			<tr>
				<td align="right">修改单元名称：</td>
				<td>
				    <input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
				       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
				       id="xg_dsdymc" name="xg_dsdymc" data-options="validType:['naturalNumberRange[1,99]']" maxlength="2"/>
					<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateDymc();">
				</td>
			</tr>
			<tr>
				<td align="right">修改地上层数：</td>
				<td>
					<input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
				       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
				       id="xg_dslcs" name="xg_dslcs" data-options="validType:['naturalNumberRange[1,150]']" maxlength="3"/>
					<input type='button' id='dInfoBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateCS();">
				</td>
			</tr>
			<tr>
				<td align="right">修改地上户数：</td>
				<td>
					<input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
				       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
				       id="xg_dshs" name="xg_dshs" data-options="validType:['naturalNumberRange[1,999]']" maxlength="3"/>
					<input type='button' id='dInfoBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateHs();">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				  <div style="width:100%;height:auto;margin-top:5px">
	                   <input type="button" value="关闭" onClick="DzBuilding.hiddenCalendar();" class="lou_close"/>
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
					<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateClHs();">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				  <div style="width:100%;height:auto;margin-top:5px">
	                   <input type="button" value="关闭" onClick="DzBuilding.hiddenCalendar();" class="lou_close"/>
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
					<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateFjmc();">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input id="dshbfjid" type='button' class='lou_closeBig' style='cursor:hand;' value='合并房间' onclick="DzBuilding.changeRoomHb(1);">
					<input id="dsexitid" type='button' class='lou_closeBig' style='cursor:hand;display: none;' value='退出合并' onclick="DzBuilding.changeRoomTcHb(1);">
				</td>
			</tr>
			<tr id="dsqxfjbhId" style="display: none;">
				<td colspan="2">
					<input id="dshbfjid" type='button' class='lou_closeBig' style='cursor:hand;' value='取消此房间合并关联' onclick="DzBuilding.changeRoomQxHb(1);">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				  <div style="width:100%;height:auto;margin-top:5px">
	                  <input type="button" value="关闭" onClick="DzBuilding.hiddenCalendar();" class="lou_close"/>
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
					<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateDxDymc();">
				</td>
			</tr>
			<tr>
				<td align="right">修改地下层数：</td>
				<td>
					<input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
				       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
				       id="xg_dxlcs" name="xg_dxlcs" data-options="validType:['naturalNumberRange[1,20]']" maxlength="2"/>
					<input type='button' id='dInfoBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateDxCS();">
				</td>
			</tr>
			<tr>
				<td align="right">修改地下户数：</td>
				<td>
					<input type="text" class="easyui-validatebox" style="width: 40px;background-color: #fff;font-size: 14px;
				       font-family: Arial, Helvetica, sans-serif;height: 20px;line-height: 14px;color: #000;text-indent: 3px;" 
				       id="xg_dxhs" name="xg_dxhs" data-options="validType:['naturalNumberRange[1,99]']" maxlength="2"/>
					<input type='button' id='dInfoBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateDxHs();">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				  <div style="width:100%;height:auto;margin-top:5px">
	                  <input type="button" value="关闭" onClick="DzBuilding.hiddenCalendar();" class="lou_close"/>
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
					<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateDxClHs();">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				  <div style="width:100%;height:auto;margin-top:5px">
	                   <input type="button" value="关闭" onClick="DzBuilding.hiddenCalendar();" class="lou_close"/>
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
					<input type='button' id='udDyBtn' class='lou_xiugai' style='cursor:hand;' value='修改' onclick="DzBuilding.sendUpdateDxFjmc();">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input id="dxhbfjid" type='button' class='lou_closeBig' style='cursor:hand;' value='合并房间' onclick="DzBuilding.changeRoomHb(0);">
					<input id="dxexitid" type='button' class='lou_closeBig' style='cursor:hand;display: none;' value='退出合并' onclick="DzBuilding.changeRoomTcHb(0);">
				</td>
			</tr>
			<tr id="dxqxfjbhId" style="display: none;">
				<td colspan="2">
					<input id="dshbfjid" type='button' class='lou_closeBig' style='cursor:hand;' value='取消此房间合并关联' onclick="DzBuilding.changeRoomQxHb(0);">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				  <div style="width:100%;height:auto;margin-top:5px">
	                  <input type="button" value="关闭" onClick="DzBuilding.hiddenCalendar();" class="lou_close"/>
	              </div>
				</td>
			</tr>
		</table>
	  </div>
  </body>
</html>