<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:v="urn:schemas-microsoft-com:vml">
	<head>
		<base href="<%=basePath%>">
		<title>辖区概况</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<style type="text/css">
			.div_info_item {
				width: 40px;
				height: 40px;
				background-color: #97c5ff;
				text-align: center;
				font-size: 12px;
				line-height: 20px;
				font-weight: normal;
			}
			
			td.info_item{
				word-wrap:break-word;
				word-break:normal;
				width: 42px;
				padding-left: 7px;
			}
			
			td.info_item_not_break:{
				padding-left: 7px;
			}
		</style>
	</head>

	<body>
		<div id="scroll_main_gps">
			<div id="scroll_content_gps">
				<div class="rtcontpadding">
					<!--辖区概况-->
					<div id="reason">
						<div class="input_selectbg" id="ssjl_zzjg">
							<input type="hidden" id="ssjl_gpszzjg_dm" />
							<input type="text" id="ssjl_gpszzjg_mc"
								class="zzjg_slect input_select" style="width: 225px;"
								onExit="xqgk.showXqgk($('#ssjl_gpszzjg_dm').val())" />
							<div class="clear" id="ssjl_gpszzjg_data_Div"></div>
						</div>

						<div class="clear"></div>

						<div>
							1. 实有人口【<span id="val_syrkTotal">0</span>】
							<table>
								<tr> 
									<td class="info_item"> <div class="div_info_item">常住<br>人口</div> </td>
									<td class="info_item"> <div class="div_info_item">寄住<br>人口</div> </td>
									<td class="info_item"> <div class="div_info_item">流动<br>人口</div> </td>
									<td class="info_item"> <div class="div_info_item">未落<br>户</div> </td>
									<td class="info_item"> <div class="div_info_item">境外<br>人员</div> </td>
								</tr>
								<tr>
									<td class="info_item" id="val_czrkCount">0</td>
									<td class="info_item" id="val_jzrkCount">0</td>
									<td class="info_item" id="val_ldrkCount">0</td>
									<td class="info_item" id="val_wlhrkCount">0</td>
									<td class="info_item" id="val_jwryCount">0</td>
								</tr>
							</table>
						</div>

						<div>
							2. 实有单位【<span id="val_sydwTotal" >0</span>】
							<table>
								<tr>
									<td class="info_item"> <div class="div_info_item">旅店<br>业</div> </td>
									<td class="info_item"> <div class="div_info_item">特种<br>行业</div> </td>
									<td class="info_item"> <div class="div_info_item">娱乐<br>场所</div> </td>
									<td class="info_item"> <div class="div_info_item">其他<br>行业</div> </td>
								</tr>

								<tr>
									<td class="info_item" id="val_ldyCount">0</td>
									<td class="info_item" id="val_tzhyCount">0</td>
									<td class="info_item" id="val_ylcsCount">0</td>
									<td class="info_item" id="val_qthyCount">0</td>
								</tr>
							</table>
						</div>

						<div>
							3. 实有房屋【<span id="val_syfwTotal">0</span>】
							<table>
								<tr>
									<td class="info_item"> <div class="div_info_item">实有<br>房屋</div> </td>
									<td class="info_item"> <div class="div_info_item">出租<br>房屋</div> </td>
								</tr>

								<tr>
									<td class="info_item" id="val_syfwCount">0</td>
									<td class="info_item" id="val_czfwCount">0</td>
								</tr>
							</table>
						</div>
						
						<div>
							4. 标准地址【<span id="val_bzdzTotal">0</span>】
							<table>
								<tr>
									<td class="info_item"> <div class="div_info_item">标准<br>地址</div> </td>
								</tr>
								<tr>
									<td class="td.info_item_not_break" id="val_bzdzCount">0</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

<script type="text/javascript">

	var dwbh = "${userSession.userOrgCode}";
	
	/**
	var cacheOrgCode = $("#cache_orgCode").val();
	if (cacheOrgCode) {
		dwbh = cacheOrgCode;
	} 
	*/

	xqgk.init(dwbh);

	$(document).ready(
			function() {
				ScrollBarTool.init("scroll_main_gps", "scroll_content_gps", 0,
						true);
				$(window).resize(
						ScrollBarTool.debounce(function() {
							ScrollBarTool.init("scroll_main_gps",
									"scroll_content_gps", 0, true);
						}, 500));

			});
</script>
	</body>
</html>
