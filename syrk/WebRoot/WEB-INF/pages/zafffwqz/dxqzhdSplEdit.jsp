<!--  
	@Author:       [wu.w@founder.com.cn]
	@CreateDate:   [2015-5-15 上午8:51:54]
	* @review      : tian_chengwei@founder.com.cn
	* @reviewDate  : 20150604
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>大型群众性活动-审批类-编辑</title>
	</head>
	<body>
		<div class="easyui-layout" data-options="fit:true">
		    <form action="" id="dataForm" name="dataForm" method="post">
			    <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;" align="center">
		    		<input type="hidden" name="mode" id="mode" value="${mode}" />
		    		<input type="hidden" name="hdid" id="hdid" value="${hd.hdid}" />
		    		<input type="hidden" name="mainTabID" id="mainTabID" value="${mainTabID}" />
		    		<div style="width: 800px;padding: 10px 0 0 0" align="center">
		    			<div style="border-bottom: black 1px solid;width: 100%;padding: 10px 0 10px 10px" align="left">
		    				&nbsp;&nbsp;<span style="color: blue">大型活动基本信息</span>
		    			</div>
		    			<table style="border: 0;width: 100%;" cellpadding="0" cellspacing="10" >
		    				<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">活动类型：</td>
								<td width="30%" class="dialogTd">
									<input type="text" name="jbxx.hdlxdm" id="jbxx_hdlxdm" class="easyui-combobox" 
										   style="width:200px" value="${hd.jbxx.hdlxdm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_FG_HDLX.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">活动性质：</td>
								<td width="30%" class="dialogTd">
									<input type="text" name="jbxx.hdxzdm" id="jbxx_hdxzdm" class="easyui-combobox" 
										   style="width:200px" value="${hd.jbxx.hdxzdm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_FG_HDXZ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,method:'get'" />
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">活动名称：</td>
								<td width="30%" class="dialogTd">
					  				<input class="easyui-validatebox" type="text" style="width:200px" 
					  					   name="jbxx.hdmc" id="jbxx_hdmc" value="${hd.jbxx.hdmc}" 
					  					   data-options="required:true,validType:'maxLength[100]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">活动场次：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
					  					   name="jbxx.hdcc" id="jbxx_hdcc" value="${hd.jbxx.hdcc}" 
					  					   data-options="required:false,validType:['naturalNumber','maxLength[5]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">额定容量：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:160px" 
					  					   name="jbxx.edrl" id="jbxx_edrl" value="${hd.jbxx.edrl}" 
					  					   data-options="required:false,validType:['naturalNumber','maxLength[7]']"/>人
								</td> 
								<td width="20%" class="dialogTd" align="right">每场次预计人数：</td>
								<td width="30%" class="dialogTd">
									<input type="text" name="jbxx.mccyjrsdm" id="jbxx_mccyjrsdm" class="easyui-combobox" 
										   style="width:200px" value="${hd.jbxx.mccyjrsdm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_FG_MCCYJRS.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,method:'get'" />
								</td> 
							</tr>
							<tr class="dialogTr">
								<td width="20%" class="dialogTd" align="right">拟发售票数：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:160px" 
					  					   name="jbxx.nfsps" id="jbxx_nfsps" value="${hd.jbxx.nfsps}" 
					  					   data-options="required:false,validType:['naturalNumber','maxLength[10]']"/>张
								</td>
								<td width="20%" class="dialogTd" align="right">每场次实际人数：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
					  					   name="jbxx.mccsjrs" id="jbxx_mccsjrs" value="${hd.jbxx.mccsjrs}" 
					  					   data-options="required:false,validType:['naturalNumber','maxLength[10]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">
					  				<input type="radio" onclick="jbxx_hddd()" id="jbxx_dd_radio" name="jbxx_hdorlx" />活动地点：
					  			</td>
								<td width="50%" class="dialogTd" colspan="2">
									<input class="easyui-combobox" style="width:380px;"
										   id="jbxx_dz_mlpCombobox" value="${hd.jbxx.dz_hdddmlpxz}" 
										   data-options="required:false
										   				,mode:'remote'
										   				,method:'post'
										   				,panelHeight: 22
										   				,valueField:'id'
										   				,textField:'text'
										   				,selectOnNavigation:false">
							    	<input type='hidden' name='jbxx.dz_hdddmlpdm' 
							    		   id="jbxx_dz_hdddmlpdm" value="${hd.jbxx.dz_hdddmlpdm}"/>
							    	<input type='hidden' name='jbxx.dz_hdddmlpxz' 
							    		   id="jbxx_dz_hdddmlpxz" value="${hd.jbxx.dz_hdddmlpxz}"/>
							    	<input type='hidden' name='jbxx.dz_hdddssxdm' 
							    		   id="jbxx_dz_hdddssxdm" value="${hd.jbxx.dz_hdddssxdm}"/>
								</td>
								<td width="30%" class="dialogTd">
							    	<input class="easyui-combobox" style="width:200px;" 
							    		   id="jbxx_dz_mhcombobox" value="${fn:replace(hd.jbxx.dz_hdddxz, hd.jbxx.dz_hdddmlpxz, '')}" 
							    		   data-options="required:false
							    		   				,mode:'remote'
							    		   				,method:'post'
							    		   				,panelHeight: 22
							    		   				,valueField:'id'
							    		   				,textField:'text'
							    		   				,selectOnNavigation:false" />
							    	<input type='hidden' name='jbxx.dz_hddddzdm' id="jbxx_dz_hddddzdm" value="${hd.jbxx.dz_hddddzdm}"/>
							    	<input type='hidden' name='jbxx.dz_hdddxz' id="jbxx_dz_hdddxz" value="${hd.jbxx.dz_hdddxz}"/>
						    	</td>
							</tr>
							<tr class="dialogTr">
								<td width="20%" class="dialogTd" align="right">场地面积：</td>
								<td width="30%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:160px" 
					  					   name="jbxx.cdmj" id="jbxx_cdmj" value="${hd.jbxx.cdmj}" 
					  					   data-options="required:false,validType:['naturalNumber','maxLength[10]']"/>平方米
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">
					  				<input type="radio" onclick="jbxx_hdlx()" id="jbxx_lx_radio" name="jbxx_hdorlx" />活动路线：
					  			</td>
								<td width="40%" class="dialogTd">
									<input class="easyui-combobox" style="width:300px;"
										   id="jbxx_dz_hdlxksCombobox" value="${hd.jbxx.dz_hdlxqsmlpxz}" 
										   data-options="required:false
										   				,mode:'remote'
										   				,method:'post'
										   				,panelHeight: 22
										   				,valueField:'id'
										   				,textField:'text'
										   				,selectOnNavigation:false">
							    	<input type='hidden' name='jbxx.dz_hdlxqsmlpdm' 
							    		   id="jbxx_dz_hdlxqsmlpdm" value="${hd.jbxx.dz_hdlxqsmlpdm}"/>
							    	<input type='hidden' name='jbxx.dz_hdlxqsmlpxz' 
							    		   id="jbxx_dz_hdlxqsmlpxz" value="${hd.jbxx.dz_hdlxqsmlpxz}"/>
								</td> 
								<td width="40%" class="dialogTd" colspan="2">
									—&nbsp;&nbsp;<input class="easyui-combobox" style="width:300px;"
										   id="jbxx_dz_hdlxjsCombobox" value="${hd.jbxx.dz_hdlxjsmlpxz}" 
										   data-options="required:false
										   				,mode:'remote'
										   				,method:'post'
										   				,panelHeight: 22
										   				,valueField:'id'
										   				,textField:'text'
										   				,selectOnNavigation:false">
							    	<input type='hidden' name='jbxx.dz_hdlxjsmlpdm' 
							    		   id="jbxx_dz_hdlxjsmlpdm" value="${hd.jbxx.dz_hdlxjsmlpdm}"/>
							    	<input type='hidden' name='jbxx.dz_hdlxjsmlpxz' 
							    		   id="jbxx_dz_hdlxjsmlpxz" value="${hd.jbxx.dz_hdlxjsmlpxz}"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">里程：</td>
								<td width="30%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:160px" 
					  					   name="jbxx.lc" id="jbxx_lc" value="${hd.jbxx.lc}" 
					  					   data-options="required:false,validType:['naturalNumber','maxLength[6]']"/>米
								</td> 
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">补充说明：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:663px" 
					  					   name="jbxx.bcsm" id="jbxx_bcsm" value="${hd.jbxx.bcsm}" 
					  					   data-options="required:false,validType:'maxLength[100]'"/>
								</td> 
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">活动开始时间：</td>
								<td width="30%" class="dialogTd">
									<input type="text" class="easyui-validatebox " style="width:200px;" 
										   name="jbxx.hdkssj" id="jbxx_hdkssj" value="${hd.jbxx.hdkssj}" 
										   data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										   onclick="WdatePicker({skin:'whyGreen'
										   						,dateFmt:'yyyy-MM-dd'
										   						,maxDate:'#F{$dp.$D(\'jbxx_hdjssj\') }'})" />
								</td> 
								<td width="20%" class="dialogTd" align="right">活动结束时间：</td>
								<td width="30%" class="dialogTd">
									<input type="text" class="easyui-validatebox " style="width:200px;" 
										   name="jbxx.hdjssj" id="jbxx_hdjssj" value="${hd.jbxx.hdjssj}" 
										   data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										   onclick="WdatePicker({skin:'whyGreen'
										   						,dateFmt:'yyyy-MM-dd'
										   						,minDate:'#F{$dp.$D(\'jbxx_hdkssj\') }'})" />
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">活动主要内容：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:663px" 
					  					   name="jbxx.hdzynr" id="jbxx_hdzynr" value="${hd.jbxx.hdzynr}" 
					  					   data-options="required:false,validType:'maxLength[200]'"/>
								</td> 
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">处理结果：</td>
								<td width="30%" class="dialogTd">
									<input type="text" name="jbxx.cljgdm" id="jbxx_cljgdm" class="easyui-combobox" 
										   style="width:200px" value="${hd.jbxx.cljgdm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_FG_CLJG.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">备注：</td>
								<td width="80%" class="dialogTd" colspan="3" >
									<textarea class="easyui-validatebox" style="width: 663px; height:48px;" 
											  id="jbxx_bz" name="jbxx.bz"
											  data-options="validType:['maxLength[1000]']
											  				,invalidMessage:'备注不能超过1000个汉字，请重新输入！'
											  				,tipPosition:'left'" >${hd.jbxx.bz}</textarea>
								</td>
							</tr>
		    			</table>
		    		</div>
		    		<div style="width: 800px;padding: 10px 0 0 0" align="center">
		    			<div style="border-bottom: black 1px solid;width: 100%;padding: 10px 0 10px 10px" align="left">
		    				&nbsp;&nbsp;<span style="color: blue">承办方信息</span>
		    			</div>
		    			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		    				<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">活动承办者：</td>
								<td width="30%" class="dialogTd">
									<input type="text" name="cbf.hdcbzdm" id="cbf_hdcbzdm" class="easyui-combobox" 
										   style="width:200px" value="${hd.cbf.hdcbzdm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_FG_HDXZ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,onSelect:function(param){
										   					if(param.id=='3'){
										   						cbf_fr_col(true);
										   					}else{
										   						cbf_fr_col(false);
										   					}
										   				}
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">承办部门名称：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.cbbmmc" id="cbf_cbbmmc" value="${hd.cbf.cbbmmc}" 
						  					   data-options="required:false,validType:'maxLength[200]'"/>
								</td>
							</tr>
							<tr id="cbf_fr1" style="display: none" class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">法人姓名：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.frxm" id="cbf_fr" value="${hd.cbf.frxm}" 
						  					   data-options="required:false,validType:'maxLength[18]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
							<tr id="cbf_fr2" style="display: none" class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">法人证件种类：</td>
								<td width="30%" class="dialogTd">
					  				<input type="text" name="cbf.frzjzldm" id="cbf_frzjzldm" class="easyui-combobox" 
										   style="width:200px" value="${hd.cbf.frzjzldm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_BZ_CYZJ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,onSelect:function(param){
										   					validateZjhm(param,'cbf_fr');
										   				}
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">法人证件号码：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  				   name="cbf.frzjhm" id="cbf_frzjhm" value="${hd.cbf.frzjhm}" 
						  				   data-options="required:false,validType:['maxLength[30]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">活动负责人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdfzr" id="cbf_hdfzr" value="${hd.cbf.hdfzr}" 
						  					   data-options="required:false,validType:'maxLength[18]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">活动负责人职务：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdfzrzw" id="cbf_hdfzrzw" value="${hd.cbf.hdfzrzw}" 
						  					   data-options="required:false,validType:'maxLength[6]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">证件种类：</td>
								<td width="30%" class="dialogTd">
					  				<input type="text" name="cbf.hdfzrzjzldm" id="cbf_hdfzrzjzldm" class="easyui-combobox" 
										   style="width:200px" value="${hd.cbf.hdfzrzjzldm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_BZ_CYZJ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,onSelect:function(param){
										   					validateZjhm(param,'cbf_hdfzr');
										   				}
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">证件号码：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  				   name="cbf.hdfzrzjhm" id="cbf_hdfzrzjhm" value="${hd.cbf.hdfzrzjhm}" 
						  				   data-options="required:false,validType:['maxLength[30]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">联系电话：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdfzrlxdh" id="cbf_hdfzrlxdh" value="${hd.cbf.hdfzrlxdh}" 
						  					   data-options="required:false,validType:'phone'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">活动联系人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdlxr" id="cbf_hdlxr" value="${hd.cbf.hdlxr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">活动联系人职务：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdlxrzw" id="cbf_hdlxrzw" value="${hd.cbf.hdlxrzw}" 
						  					   data-options="required:false,validType:'maxLength[20]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">证件种类：</td>
								<td width="30%" class="dialogTd">
					  				<input type="text" name="cbf.hdlxrzjzldm" id="cbf_hdlxrzjzldm" class="easyui-combobox" 
										   style="width:200px" value="${hd.cbf.hdlxrzjzldm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_BZ_CYZJ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,onSelect:function(param){
										   					validateZjhm(param,'cbf_hdlxr');
										   				}
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">证件号码：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  				   name="cbf.hdlxrzjhm" id="cbf_hdlxrzjhm" value="${hd.cbf.hdlxrzjhm}" 
						  				   data-options="required:false,validType:['maxLength[30]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">联系电话：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdlxrlxdh" id="cbf_hdlxrlxdh" value="${hd.cbf.hdlxrlxdh}" 
						  					   data-options="required:false,validType:'phone'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">活动安全负责人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdaqfzr" id="cbf_hdaqfzr" value="${hd.cbf.hdaqfzr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">活动安全负责人职务：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdaqfzrzw" id="cbf_hdaqfzrzw" value="${hd.cbf.hdaqfzrzw}" 
						  					   data-options="required:false,validType:'maxLength[20]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">证件种类：</td>
								<td width="30%" class="dialogTd">
					  				<input type="text" name="cbf.hdaqfzrzjzldm" id="cbf_hdaqfzrzjzldm" class="easyui-combobox" 
										   style="width:200px" value="${hd.cbf.hdaqfzrzjzldm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_BZ_CYZJ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,onSelect:function(param){
										   					validateZjhm(param,'cbf_hdaqfzr');
										   				}
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">证件号码：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  				   name="cbf.hdaqfzrzjhm" id="cbf_hdaqfzrzjhm" value="${hd.cbf.hdaqfzrzjhm}" 
						  				   data-options="required:false,validType:['maxLength[30]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">联系电话：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="cbf.hdaqfzrlxdh" id="cbf_hdaqfzrlxdh" value="${hd.cbf.hdaqfzrlxdh}" 
						  					   data-options="required:false,validType:'phone'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
		    			</table>
		    		</div>
		    		<div style="width: 800px;padding: 10px 0 0 0" align="center">
		    			<div style="border-bottom: black 1px solid;width: 100%;padding: 10px 0 10px 10px" align="left">
		    				&nbsp;&nbsp;<span style="color: blue">使用场所信息</span>
		    			</div>
		    			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		    				<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">场所承租单位：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:595px" 
					  					   name="sycs.csczdw" id="sycs_csczdw" value="${hd.sycs.csczdw}" 
					  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">场所主要负责人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="sycs.cszyfzr" id="sycs_cszyfzr" value="${hd.sycs.cszyfzr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">场所主要负责人职务：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="sycs.cszyfzrzw" id="sycs_cszyfzrzw" value="${hd.sycs.cszyfzrzw}" 
						  					   data-options="required:false,validType:'maxLength[20]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">证件种类：</td>
								<td width="30%" class="dialogTd">
					  				<input type="text" name="sycs.cszyfzrzjzldm" id="sycs_cszyfzrzjzldm" class="easyui-combobox" 
										   style="width:200px" value="${hd.sycs.cszyfzrzjzldm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_BZ_CYZJ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,onSelect:function(param){
										   					validateZjhm(param,'sycs_cszyfzr');
										   				}
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">证件号码：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  				   name="sycs.cszyfzrzjhm" id="sycs_cszyfzrzjhm" value="${hd.sycs.cszyfzrzjhm}" 
						  				   data-options="required:false,validType:['maxLength[30]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">联系电话：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="sycs.cszyfzrlxdh" id="sycs_cszyfzrlxdh" value="${hd.sycs.cszyfzrlxdh}" 
						  					   data-options="required:false,validType:'phone'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">场所联系人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="sycs.cslxr" id="sycs_cslxr" value="${hd.sycs.cslxr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">场所联系人职务：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="sycs.cslxrzw" id="sycs_cslxrzw" value="${hd.sycs.cslxrzw}" 
						  					   data-options="required:false,validType:'maxLength[20]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">证件种类：</td>
								<td width="30%" class="dialogTd">
					  				<input type="text" name="sycs.cslxrzjzldm" id="sycs_cslxrzjzldm" class="easyui-combobox" 
										   style="width:200px" value="${hd.sycs.cslxrzjzldm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_BZ_CYZJ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,onSelect:function(param){
										   					validateZjhm(param,'sycs_cslxr');
										   				}
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">证件号码：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  				   name="sycs.cslxrzjhm" id="sycs_cslxrzjhm" value="${hd.sycs.cslxrzjhm}" 
						  				   data-options="required:false,validType:['maxLength[30]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">联系电话：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="sycs.cslxrlxdh" id="sycs_cslxrlxdh" value="${hd.sycs.cslxrlxdh}" 
						  					   data-options="required:false,validType:'phone'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
		    			</table>
		    		</div>
		    		<div style="width: 800px;padding: 10px 0 0 0" align="center">
		    			<div style="border-bottom: black 1px solid;width: 100%;padding: 10px 0 10px 10px" align="left">
		    				&nbsp;&nbsp;<span style="color: blue">现场临时设施建筑物搭建单位信息</span>
		    			</div>
		    			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		    				<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">单位名称：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:595px" 
					  					   name="lsjz.dwmc" id="lsjz_dwmc" value="${hd.lsjz.dwmc}" 
					  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">企业类型：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="lsjz.qylx" id="lsjz_qylx" value="${hd.lsjz.qylx}" 
						  					   data-options="required:false,validType:'maxLength[18]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">企业注册号：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="lsjz.qyzch" id="lsjz_qyzch" value="${hd.lsjz.qyzch}" 
						  					   data-options="required:false,validType:['letterOrNum','maxLength[50]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">主要负责人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="lsjz.zyfzr" id="lsjz_zyfzr" value="${hd.lsjz.zyfzr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">主要负责人职务：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="lsjz.zyfzrzw" id="lsjz_zyfzrzw" value="${hd.lsjz.zyfzrzw}" 
						  					   data-options="required:false,validType:'maxLength[20]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">联系电话：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="lsjz.zyfzrlxdh" id="lsjz_zyfzrlxdh" value="${hd.lsjz.zyfzrlxdh}" 
						  					   data-options="required:false,validType:'phone'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
		    			</table>
		    		</div>
		    		<div style="width: 800px;padding: 10px 0 0 0" align="center">
		    			<div style="border-bottom: black 1px solid;width: 100%;padding: 10px 0 10px 10px" align="left">
		    				&nbsp;&nbsp;<span style="color: blue">安保责任单位信息</span>
		    			</div>
		    			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		    				<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">安全许可单位：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:595px" 
					  					   name="abdw.abxkdw" id="abdw_abxkdw" value="${hd.abdw.abxkdw}" 
					  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">安全许可单位负责人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="abdw.aqxkdwfzr" id="abdw_aqxkdwfzr" value="${hd.abdw.aqxkdwfzr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">安保负责人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="abdw.abfzr" id="abdw_abfzr" value="${hd.abdw.abfzr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">安保联系人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="abdw.ablxr" id="abdw_ablxr" value="${hd.abdw.ablxr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">安保勤务等级：</td>
								<td width="30%" class="dialogTd">
									<input type="text" name="abdw.abqwdjdm" id="abdw_abqwdjdm" class="easyui-combobox" 
										   style="width:200px" value="${hd.abdw.abqwdjdm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_FG_ABQWDJ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,method:'get'" />
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">安全许可意见：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:595px" 
					  					   name="abdw.aqxkyj" id="abdw_aqxkyj" value="${hd.abdw.aqxkyj}" 
					  					   data-options="required:false,validType:'maxLength[1000]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">每场次安保种类：</td>
								<td width="30%" class="dialogTd">
									<input type="text" name="abdw.mccabzldmNS" id="abdw_mccabzldmNS" class="easyui-combobox" 
										   style="width:200px" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_FG_ABJL.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">每场次安保警力数：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:120px;" 
					  					   name="abdw.mccabjlsNS" id="abdw_mccabjlsNS"  
					  					   data-options="required:false,validType:['naturalNumber','maxLength[7]']"/>人
					  				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="abdw_mccabjlsNS_add" 
					  				   onclick="saveAbxq();" style="position:relative ; top:-5px;" data-options="plain:true" ></a>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">每场次安保详情：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<ul id="abdw_abxq" style="list-style: none"></ul>
									<input type="hidden" id="abdw_abxq_hid" value="${hd.abdw.abxq}"/>
								</td> 
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">雇佣保安员保安公司名称：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<input class="easyui-validatebox" type="text" style="width:595px" 
					  					   name="abdw.gybaybagsmc" id="abdw_gybaybagsmc" value="${hd.abdw.gybaybagsmc}" 
					  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">保安公司主要负责人：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="abdw.bagszyfzr" id="abdw_bagszyfzr" value="${hd.abdw.bagszyfzr}" 
						  					   data-options="required:false,validType:'maxLength[50]'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right">保安公司主要负责人职务：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="abdw.bagszyfzrzw" id="abdw_bagszyfzrzw" value="${hd.abdw.bagszyfzrzw}" 
						  					   data-options="required:false,validType:'maxLength[20]'"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">证件种类：</td>
								<td width="30%" class="dialogTd">
					  				<input type="text" name="abdw.bagszyfzrzjzldm" id="abdw_bagszyfzrzjzldm" class="easyui-combobox" 
										   style="width:200px" value="${hd.abdw.bagszyfzrzjzldm}" 
										   data-options="required:false
										   				,url: contextPath + '/common/dict/D_BZ_CYZJ.js'
										   				,valueField:'id'
										   				,textField:'text'
										   				,tipPosition:'left'
										   				,selectOnNavigation:false
										   				,onSelect:function(param){
										   					validateZjhm(param,'abdw_bagszyfzr');
										   				}
										   				,method:'get'" />
								</td> 
								<td width="20%" class="dialogTd" align="right">证件号码：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  				   name="abdw.bagszyfzrzjhm" id="abdw_bagszyfzrzjhm" value="${hd.abdw.bagszyfzrzjhm}" 
						  				   data-options="required:false,validType:['maxLength[30]']"/>
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">联系电话：</td>
								<td width="30%" class="dialogTd">
									<input class="easyui-validatebox" type="text" style="width:200px" 
						  					   name="abdw.bagszyfzrlxdh" id="abdw_bagszyfzrlxdh" value="${hd.abdw.bagszyfzrlxdh}" 
						  					   data-options="required:false,validType:'phone'"/>
								</td> 
								<td width="20%" class="dialogTd" align="right"></td>
								<td width="30%" class="dialogTd">
								</td>
							</tr>
							<tr class="dialogTr">
					  			<td width="20%" class="dialogTd" align="right">安保方案：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<span id="abdw_abfa_span">
										<input type="file" id="abdw_abfa" name="uploadFile" style="width:500px;" 
											   class="easyui-validatebox" id="cbf_abfa" 
											   data-options="tipPosition:'left',invalidMessage:'请选择图片格式的文件！'" />
									</span>
									<a class="easyui-linkbutton" data-options="iconCls:'icon-movedown'" style="margin-top: -8px" 
									   onclick="planDownload();">下载</a>
								</td> 
							</tr>
		    			</table>
		    		</div>
		    		<div style="width: 800px;padding: 10px 0 0 0" align="center">
		    			<div style="border-bottom: black 1px solid;width: 100%;padding: 10px 0 10px 10px" align="left">
		    				&nbsp;&nbsp;<span style="color: blue">活动及安保信息</span>
		    			</div>
		    			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		    				<tr class="dialogTr">
		    					<td>
		    						<fieldset style="border: black 1px solid">
		    							<legend style="color: blue">安全管理</legend>
		    							<div style="padding: 20px">
		    								<c:choose>
					  					   		<c:when test="${empty hd.hdab.aqjc}">
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'aqjc')"/>
				    								安全检查
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.aqjc" id="hdab_aqjc" 
							  					   		   value="${hd.hdab.aqjc}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次
					  					   		</c:when>
					  					   		<c:otherwise>
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'aqjc')" checked="checked"/>
				    								安全检查
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.aqjc" id="hdab_aqjc" value="${hd.hdab.aqjc}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次
					  					   		</c:otherwise>
					  					   	</c:choose>
					  					   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  					   	<c:choose>
					  					   		<c:when test="${empty hd.hdab.dczgaqyh}">
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'dczgaqyh')"/>
					  					   			督促整改安全隐患
							  						<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.dczgaqyh" id="hdab_dczgaqyh" 
							  					   		   value="${hd.hdab.dczgaqyh}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次 
					  					   		</c:when>
					  					   		<c:otherwise>
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'dczgaqyh')" 
					  					   				   checked="checked"/>
					  					   			督促整改安全隐患
							  						<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.dczgaqyh" id="hdab_dczgaqyh" value="${hd.hdab.dczgaqyh}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次 
					  					   		</c:otherwise>
					  					   	</c:choose>
					  					   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  					   	<c:choose>
					  					   		<c:when test="${hd.hdab.sfqddm=='on'}">
					  					   			<input type="checkbox" id="hdab_sfqddm" name="hdab.sfqddm" 
					  					   				   checked="checked"/>是否取缔
					  					   		</c:when>
					  					   		<c:otherwise>
					  					   			<input type="checkbox" id="hdab_sfqddm" name="hdab.sfqddm"/>是否取缔
					  					   		</c:otherwise>
					  					   	</c:choose>
		    							</div>
		    						</fieldset>
		    					</td>
							</tr>
							<tr class="dialogTr">
		    					<td>
		    						<fieldset style="border: black 1px solid">
		    							<legend style="color: blue">查处违法犯罪情况</legend>
		    							<div style="padding: 20px">
		    								<c:choose>
					  					   		<c:when test="${empty hd.hdab.jg}">
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'jg')"/>
				    								警告 
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.jg" id="hdab_jg" value="${hd.hdab.jg}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 人 
					  					   		</c:when>
					  					   		<c:otherwise>
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'jg')" checked="checked"/>
				    								警告 
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.jg" id="hdab_jg" value="${hd.hdab.jg}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 人 
					  					   		</c:otherwise>
					  					   	</c:choose>
		    								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    								<c:choose>
					  					   		<c:when test="${empty hd.hdab.fk}">
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'fk')"/>
				    								罚款 
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.fk" id="hdab_fk" value="${hd.hdab.fk}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 人
					  					   		</c:when>
					  					   		<c:otherwise>
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'fk')" checked="checked"/>
				    								罚款 
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.fk" id="hdab_fk" value="${hd.hdab.fk}"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 人
					  					   		</c:otherwise>
					  					   	</c:choose>
		    								<br/><br/>
		    								<c:choose>
					  					   		<c:when test="${hd.hdab.sfjldm=='on'}">
					  					   			<input type="checkbox" id="hdab_sfjldm" name="hdab.sfjldm" 
					  					   				   onclick="hdab_input_col(this,'jl',3)" checked="checked"/>
				    								拘留 	
				    								&nbsp;&nbsp;&nbsp;&nbsp;
				    								单处 
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.jldc" id="hdab_jl1" value="${hd.hdab.jldc}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次  
				    								&nbsp;&nbsp;&nbsp;&nbsp;
				    								并处罚款 
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.jlbcfk" id="hdab_jl2" value="${hd.hdab.jlbcfk}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次 
				    								&nbsp;&nbsp;&nbsp;&nbsp;
				    								责令禁进入 
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.jlzljjr" id="hdab_jl3" value="${hd.hdab.jlzljjr}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次
					  					   		</c:when>
					  					   		<c:otherwise>
					  					   			<input type="checkbox" id="hdab_sfjldm" name="hdab.sfjldm" 
					  					   				   onclick="hdab_input_col(this,'jl',3)"/>
				    								拘留 	
				    								&nbsp;&nbsp;&nbsp;&nbsp;
				    								单处 
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.jldc" id="hdab_jl1" 
							  					   		   value="${hd.hdab.jldc}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次  
				    								&nbsp;&nbsp;&nbsp;&nbsp;
				    								并处罚款 
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.jlbcfk" id="hdab_jl2" 
							  					   		   value="${hd.hdab.jlbcfk}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次 
				    								&nbsp;&nbsp;&nbsp;&nbsp;
				    								责令禁进入 
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.jlzljjr" id="hdab_jl3" 
							  					   		   value="${hd.hdab.jlzljjr}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次
					  					   		</c:otherwise>
					  					   	</c:choose>
		    							</div>
		    						</fieldset>
		    					</td>
							</tr>
							<tr class="dialogTr">
		    					<td>
		    						<fieldset style="border: black 1px solid">
		    							<legend style="color: blue">安全事故</legend>
		    							<div style="padding: 20px">
		    								<c:choose>
					  					   		<c:when test="${empty hd.hdab.qs}">
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'qs')"/>
				    								起数 
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.qs" id="hdab_qs" value="${hd.hdab.qs}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次 
					  					   		</c:when>
					  					   		<c:otherwise>
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'qs')" checked="checked"/>
				    								起数 
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.qs" id="hdab_qs" value="${hd.hdab.qs}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 次 
					  					   		</c:otherwise>
					  					   	</c:choose>
		    								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    								<c:choose>
					  					   		<c:when test="${empty hd.hdab.swrs}">
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'swrs')"/>
				    								伤亡人数 
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.swrs" id="hdab_swrs" 
							  					   		   value="${hd.hdab.swrs}" readonly="readonly"
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 人 
					  					   		</c:when>
					  					   		<c:otherwise>
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'swrs')" checked="checked"/>
				    								伤亡人数 
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.swrs" id="hdab_swrs" value="${hd.hdab.swrs}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 人 
					  					   		</c:otherwise>
					  					   	</c:choose>
		    								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    								<c:choose>
					  					   		<c:when test="${empty hd.hdab.jjss}">
					  					   			<input type="checkbox" onclick="hdab_input_col(this,'jjss')"/>
				    								经济损失 
				    								<input class="easyui-validatebox inputReadonly" type="text" style="width:80px" 
							  					   		   name="hdab.jjss" id="hdab_jjss" 
							  					   		   value="${hd.hdab.jjss}" readonly="readonly" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 元
					  					   		</c:when>
					  					   		<c:otherwise>
						  					   		<input type="checkbox" onclick="hdab_input_col(this,'jjss')" checked="checked"/>
				    								经济损失 
				    								<input class="easyui-validatebox" type="text" style="width:80px" 
							  					   		   name="hdab.jjss" id="hdab_jjss" value="${hd.hdab.jjss}" 
							  					   		   data-options="required:false
							  					   		   				,validType:['naturalNumber','maxLength[10]']"/> 元
					  					   		</c:otherwise>
					  					   	</c:choose>
		    							</div>
		    						</fieldset>
		    					</td>
							</tr>
		    			</table>
		    		</div>
			    	<c:if test="${mode!='view'}">
				    	<div align="center" style="width: 100%;margin: 20px 0 20px 0">
				    		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="save();" >保存</a>
				    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    		<a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="reset();" >重置</a>
				    	</div>
			    	</c:if>
			    </div>
		    </form>
		</div>
		<div style="display: none">
			<form id="abdw_file_form" action="" method="post" enctype="multipart/form-data">
					<div id="abdw_file_form_div"></div>
					<input type='text' name='lybm' value="DXQZXHDSPL_ZB_ABZRDWXXB"/>
					<input type='text' name='lyid' value="${hd.hdid}"/>
					<input type='text' name='lyms' value="活动方案"/>
					<input type='text' name='fileOnly' id='fileOnly' value="0"/>
			</form>
		</div>
	</body>
	<script type="text/javascript" src="<%=contextPath%>/js/zafffwqz/dxqzhdSplEdit.js"></script>
</html>