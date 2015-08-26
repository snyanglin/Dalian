<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->	
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三级消防单位信息</title>
</head>

<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/dwxfAdd.css"></link>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/dwxfAdd.js"></script>
<body style="overflow-y:auto">
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>dwownsydw/saveXf" id="dataForm"
			name="dataForm" method="post">
			<input type="hidden" name="zddwzzjgdm" id="zddwzzjgdm"
				value="${entity.zddwzzjgdm}" /> <input type="hidden"
				name="zddwzzjgname" id="zddwzzjgname" value="${entity.zddwzzjgname}" />
			<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
			<input type="hidden" name="bsf" id="bsf" value="${entity.bsf}" />
			<div data-options="region:'center', split:true"
				style="border-width: 0px;margin-top:5px;text-align: center;">
				<table border="0" cellpadding="0" cellspacing="5" width="100%"
					align="center">
					<input type="hidden" name="id" id="pk" value="${entity.id}" />
					<input type="hidden" name="flag" id="flag" value="${flag}" />
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">监管单位类别：</td>

						<td width="30%" class="dialogTd"><input
							class='easyui-combobox' type='text' id='jgdwlb' name='jgdwlb'
							value="${entity.jgdwlb}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/BD_D_DWXFLB.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get',onChange:xfOnchange" />
						</td>



						<td width="20%" class="dialogTd" align="right">消防管辖：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options=" validType:['maxLength[50]'],tipPosition:'right'"
							type='text' name='xfgx' style="width:200px;"
							value="${entity.xfgx}" /></td>

					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">单位使用名称：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options=" validType:['maxLength[50]'],tipPosition:'right'"
							type='text' name='dwsymc' style="width:200px;"
							value="${entity.dwsymc}" /></td>
						<td width="20%" class="dialogTd" align="right">建筑管理单位：</td>
						<td width="30%" class="dialogTd"><input
							class="easyui-combobox"
							data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
							type="text" id="jzgldw" name="jzgldw" style="width:200px;"
							value="${entity.jzgldw}" /></td>

					</tr>

					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">上级单位：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options=" validType:['maxLength[50]'],tipPosition:'right'"
							type='text' name='sjdw' style="width:200px;"
							value="${entity.sjdw}" /></td>
						<td width="20%" class="dialogTd" align="right">行政区域：</td>


						<td width="30%" class="dialogTd"><input type="text"
							name="xzqy" id="xzqy" class="easyui-combotree"
							value="${entity.xzqy}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_BZ_XZQH_PROVINCE.js',onlyLeaf:true,dataFilter:'',multiple:false,panelWidth:320,
							method:'get',editable:true,lines:true">
						</td>

					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">分管级别：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-combobox' type='text' id='fgjb' name='fgjb'
							value="${entity.fgjb}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/D_FW_XFGLJB.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" />
						</td>
						<td width="20%" class="dialogTd" align="right">火灾危险性：</td>
                        <td width="30%" class="dialogTd"><input
							class='easyui-combobox' type='text' id='hzwxx' name='hzwxx'
							value="${entity.hzwxx}" style="width:200px;"
							data-options="url: contextPath + '/common/dict/BD_D_DWXFHZWXJBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" />
						</td>

					</tr>

					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">消防安全管理人姓名：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options=" validType:['maxLength[50]'],tipPosition:'left'"
							type='text' name='xfaqglrxm' style="width:200px;"
							value="${entity.xfaqglrxm}" /></td>
						<td width="20%" class="dialogTd" align="right">消防安全管理人身份证号：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox ' data-options=" tipPosition:'right'"
							type='text' id='xfaqglrsfzh' name='xfaqglrsfzh'
							style="width:200px;" value="${entity.xfaqglrsfzh}" /></td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">消防安全管理人联系方式：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options="required:false,validType:['phone']" type='text'
							name='xfaqglrlxfs' style="width:200px;" maxlength="30"
							value="${entity.xfaqglrlxfs}" /></td>
						<td width="20%" class="dialogTd" align="right">消防安全责任人姓名：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options=" validType:['maxLength[50]'],tipPosition:'left'"
							type='text' name='xfaqzrrxm' style="width:200px;"
							value="${entity.xfaqzrrxm}" /></td>

					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">消防安全责任人身份证号：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox ' data-options=" tipPosition:'right'"
							type='text' id='xfaqzrrsfzh' name='xfaqzrrsfzh'
							style="width:200px;" value="${entity.xfaqzrrsfzh}" /></td>
						<td width="20%" class="dialogTd" align="right">消防安全责任人联系方式：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options="required:false,validType:['phone']" type='text'
							name='xfaqzrrlxfs' style="width:200px;" maxlength="30"
							value="${entity.xfaqzrrlxfs}" /></td>

					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">固定资产(万元)：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options="validType:['numeric[\'f\',2]'],invalidMessage:'注册资金为两位小数的金额，请重新输入！',tipPosition:'right'"
							type='text' name='gdzc' style="width:200px;"
							value="${entity.gdzc}" /></td>
						<td width="20%" class="dialogTd" align="right">在册职工数：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'"
							type='text' name='zczgs' style="width:200px;"
							value="${entity.zczgs}" /></td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">占地面积(平方米)：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options=" validType:['numeric[\'f\',2]'],invalidMessage:'占地面积为两位小数的金额，请重新输入！',tipPosition:'right'"
							type='text' name='zdmj' style="width:200px;"
							value="${entity.zdmj}" /></td>
						<td width="20%" class="dialogTd" align="right">建筑面积(平方米)：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options="validType:['numeric[\'f\',2]'],invalidMessage:'建筑面积为两位小数的金额，请重新输入！',tipPosition:'left'"
							type='text' name='jzmj' style="width:200px;"
							value="${entity.jzmj}" /></td>
					</tr>

					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">地理情况：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options=" validType:['maxLength[50]'],tipPosition:'right'"
							type='text' name='dlqk' style="width:200px;"
							value="${entity.dlqk}" /></td>
						<td width="20%" class="dialogTd" align="right">自动消防情况：</td>
						<td width="30%" class="dialogTd"><input
							class="easyui-combobox"
							data-options="url: contextPath + '/common/dict/BD_D_ZDXFQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
							type="text" id="zdxfqk" name="zdxfqk" style="width:200px;"
							value="${entity.zdxfqk}" /></td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">地理坐标X：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options="validType:['numeric[\'f\',8]'],tipPosition:'right'"
							type='text' name='dlzbx' style="width:200px;" maxlength="30"
							value="${entity.dlzbx}" /></td>
						<td width="20%" class="dialogTd" align="right">地理坐标Y：</td>
						<td width="30%" class="dialogTd"><input
							class='easyui-validatebox '
							data-options=" validType:['numeric[\'f\',8]'],tipPosition:'left'"
							type='text' name='dlzby' style="width:200px;" maxlength="30"
							value="${entity.dlzby}" /></td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">备注：</td>
						<td width="80%" class="dialogTd" colspan="3"><textarea
								class="easyui-validatebox" type="text"
								data-options="validType:['maxLength[300]'],required:false ,tipPosition:'left'"
								id="bz" name="bz" style="width:625px;height: 50px;">${entity.bz}</textarea>
						</td>
					</tr>
				</table>
				<span style="width: 200px;">&nbsp;</span>
				<div id='panel_center' style="display:none;">
					<fieldset style="width: 90%;">
						<legend>重点单位信息</legend>
						<span style="width: 200px;">&nbsp;</span><br> 
						<input type="radio" value='1' name='xfid' id='xfidk1' checked onclick='showxfzzjg(1);'>人员密集场所
						<span style='width:80px;'>&nbsp;</span>
						<input type="radio" value='2' name='xfid' id='xfidk2' onclick='showxfzzjg(2);'>国家机关
						<span style='width:50px;'>&nbsp;</span>
						<input type="radio" value='3' name='xfid' id='xfidk3' onclick='showxfzzjg(3);'>广播电台/电视台和邮政/通讯枢纽 
						<input type="radio" value='4' name='xfid' id='xfidk4' onclick='showxfzzjg(4);'>发电厂(站)和电网经营企业
						<span style='width:40px;'>&nbsp;</span><br /> 
						<input type="radio" value='5' name='xfid' id='xfidk5' onclick='showxfzzjg(5);'>易燃易爆化学物品的生产/充装/储存/供应/销售单位
						<input type="radio" value='6' name='xfid' id='xfidk6' onclick='showxfzzjg(6);'>重要的科研单位 
						<input type="radio" value='7' name='xfid' id='xfidk7' onclick='showxfzzjg(7);'>高层公共建筑
						<input type="radio" value='8' name='xfid' id='xfidk8' onclick='showxfzzjg(8);'>城市地下铁道/地下隧道等地下建筑<br />
						<input type="radio" value='9' name='xfid' id='xfidk9' onclick='showxfzzjg(9);'>粮/棉/木材/百货等物资仓库和堆场
						<span style='width:90px;'>&nbsp;</span> 
						<input type="radio" value='10' name='xfid' id='xfidk10' onclick='showxfzzjg(10);'>国家和省级重点工程的施工现场
						<span style='width:225px;'>&nbsp;</span><br /> 
						<input type="radio" value='11' name='xfid' id='xfidk11' onclick='showxfzzjg(11);'>其他发生火灾可能性较大以及一旦发生火灾可能造成人身重大伤害或者重大财产损失的单位
						<span style='width:215px;'>&nbsp;</span> 
						<input type="hidden" id="hidLeft" name="hidLeft" value=" ${tempMenu}" />
						<div data-options="region:'center',split:true" style="width:720px; border-width: 0px; ">
							<table border="0" cellspacing="0" cellpadding="0" align="center">
								<tbody>
									<tr>
										<td>
											<table border="0" cellpadding="2" cellspacing="0"
												width="100%">
												<tr>
													<td align="left" id="tdunvalid" valign="top" width="320">
														<table border="0" cellspacing="0" cellpadding="0"
															width="100%">
															<tr>
																<td align="right">
																	<div id="treeDiv" class="easyui-panel"
																		style="padding:5px; width: 320px; height: 280px;"
																		onselectstart="return false;">
																		<ul class="easyui-tree" id="treeSelect"
																			data-options="method:'get',lines:true,checkbox:true"></ul>
																	</div></td>
															</tr>
														</table></td>
													<td align="center" width="100">
														<table border="0" cellspacing="0">
															<tr>
																<td align="center" height="80"><button
																		onclick="button2_onclick()" tabindex="5"
																		class="buttonMultiSelect" TYPE="button">
																		<table border="0" cellspacing="0" cellpadding="0"
																			width="23">
																			<tr>
																				<td align="center" class="buttonAddSelect"></td>
																			</tr>
																			<tr>
																				<td height="2"></td>
																			</tr>
																		</table>
																	</button>
																</td>
															</tr>
															<tr>
																<td align="center" height="50"><button
																		onclick="button3_onclick()" tabindex="7"
																		class="buttonMultiSelect" TYPE="button">
																		<table border="0" cellspacing="0" cellpadding="0"
																			width="23">
																			<tr>
																				<td align="center" class="buttonRemoveSelect"></td>
																			</tr>
																			<tr>
																				<td height="2"></td>
																			</tr>
																		</table>
																	</button>
																</td>
															</tr>
															<tr>
																<td align="center" height="80"><button
																		onclick="button4_onclick()" tabindex="8"
																		class="buttonMultiSelect" TYPE="button">
																		<table border="0" cellspacing="0" cellpadding="0"
																			width="23">
																			<tr>
																				<td align="center" class="buttonRemoveAll"></td>
																			</tr>
																			<tr>
																				<td height="2"></td>
																			</tr>
																		</table>
																	</button>
																</td>
															</tr>
														</table></td>
													<td align="right" id="tdvalid" valign="top" width="340">
														<select id="select_valid" size="10" tabindex="10"
														class="inputSelect" style="width: 340px; height:320px;"
														multiple ondblclick="right_ondblclick(1)">
													</select></td>
												</tr>
												<tr>
													<td><br />重点单位认定时间： <input type="text"
														name="zddwrdsj" id="zddwrdsj" class="easyui-validatebox"
														style="width: 100px;" value="${entity.zddwrdsj}"
														data-options="required:false,validType:['date[\'yyyy-MM-dd \']']"
														data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'"
														onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
													<td>
												</tr>
												<br />
												<br />

											</table></td>
									</tr>
								</tbody>
							</table>
						</div>
					</fieldset>
				</div>
			</div>
	</div>
	</form>
</body>
<script type="text/javascript">
var selectedUserNodes = "${entity.zddwzzjgdm}";      //数据中重点单位组织机构 
var bsf_xf = "${entity.bsf}";                       //数据中选择图层分类 
</script>
</html>
