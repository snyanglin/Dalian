<!--  
	@Author:       [xu_haibo@founder.com.cn]
	@CreateDate:   [2015-6-14 下午13:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>人防信息</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
		<script type="text/javascript" src="<%=contextPath%>/js/aqff/rfxx/aqffRfxxinfo.js"></script>
	</head>
<body class="easyui-layout">
	<div data-options="region:'center', split:true" style="width:85%border-width: 0px;margin:0 0 0;" align="center" class="bodybg">
		<div data-options="region:'north', split:true" >
			<table height="60%" width="85%"  style="margin:0 auto;border: 1">
				<tr>
					<td height="100%" valign="top" align="center">
						<div class="pop_conta">
							<div class="pop_contb">
								<div class="pop_contc">
									<form action="<%=basePath%>rfxxb/saveRfxx" id="dataForm" name="dataForm" method="post">
										<input type="hidden" id="flag" value="${flag}">
											<table border="0" cellpadding="0" cellspacing="10" width="width:500px;" align="center" border-collapse="collapse">
												<input type="hidden" id="pk" name="id" value="${entity.id}" />
												<input type="hidden" id="xldx" name="xldx" value="${entity.xldx}" />
												<input type="hidden" id="xldy" name="xldy" value="${entity.xldy}" />
												<input type="hidden" id="xlqy" name="xlqy" value="${entity.xlqy}" />
												<tr class="dialogTr" >
													<td width="200px" class="dialogTd" align="right">组织名称：</td>
													<td width="200px" class="dialogTd">
											    		${entity.zzmc}
										   	        </td>
											        <td width="200px" class="dialogTd" align="right">组织类别：</td>
											    	<td width="200px" class="dialogTd">
											    		<script type="text/javascript">
											    			document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_ZZLB.js', "${entity.zzlbdm}"));
											    		</script>
													</td> 
												</tr>
												<tr class="dialogTr">
												   	<td width="200px" class="dialogTd" align="right">组织地址：</td>
												   	<td width="200px" class="dialogTd" colspan="2">
												    	${entity.dz_zzdzmlpxz}
												    	<input type='hidden' name='dz_zzdzmlpdm' id=dz_zzdzmlpdm value="${entity.dz_zzdzmlpdm}"/>
												    	<input type='hidden' name='dz_zzdzmlpxz' id="dz_zzdzmlpxz" value="${entity.dz_zzdzmlpxz}"/>
												   	</td>
												   	<td  class="dialogTd">
												    	${fn:replace(entity.dz_zzdzxz, entity.dz_zzdzmlpxz, "")}
												    	<input type='hidden' name='dz_zzdzdm' id="dz_zzdzdm" value="${entity.dz_zzdzdm}"/>
												    	<input type='hidden' name='dz_zzdzssxqdm' id="dz_zzdzssxqdm" value="${entity.dz_zzdzssxqdm}"/>
												    	<input type='hidden' name='dz_zzdzxz' id="dz_zzdzxz" value="${entity.dz_zzdzxz}"/>
												   	</td>
												  	<td width="200px" class="dialogTd" align="right">隶属关系：</td>
												   	<td width="200px" class="dialogTd">
												   		<script type="text/javascript">
												   			document.write(window.top.getDictName(contextPath + '/common/dict/D_ZAFF_LSGX.js', "${entity.lsggdm}"));
												   		</script>
													</td> 
												</tr>
												<tr class="dialogTr">
											    	<td width="200px" class="dialogTd" align="right">防范组织形式：</td>
											    	<td width="200px" class="dialogTd">
											    		<script type="text/javascript">
											    			document.write(window.top.getDictName(contextPath + '/common/dict/D_ZAFF_ZZXS.js', "${entity.ffzzxsdm}"));
											    		</script>
													</td> 
													<td width="200px" class="dialogTd" align="right">组建日期：</td>
													<td width="200px" class="dialogTd">
														${entity.zjrq}
													</td>
													<td width="200px" class="dialogTd" align="right">经费来源：</td>
											    	<td width="200px" class="dialogTd">
											    		<script type="text/javascript">
											    			document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_JFLY.js', "${entity.jflydm}"));
											    		</script>
									    	        </td>
												</tr>	
												<tr class="dialogTr">
						    	      			<td width="200px" class="dialogTd" align="right">防范方式：</td>
										    	<td width="200px" class="dialogTd">
										    		<script type="text/javascript">
										    			document.write(window.top.getDictName(contextPath + '/common/dict/D_ZAFF_FFFS.js', "${entity.fffsdm}"));
										    		</script>
										    	</td>
										    	<td width="200px" class="dialogTd" align="right">是否治安承包：</td>
										    	<td width="200px" class="dialogTd">
										    		<script type="text/javascript">
										    			document.write(window.top.getDictName(contextPath + '/common/dict/D_BZ_SF.js', "${entity.sfzacbdm}"));
										    		</script>
										    	</td>
										    	<td width="200px" class="dialogTd" align="right">携带装备：</td>
										    		<input type="hidden" id="hxdsb" value="${entity.xdzbdm}"/>
										    	<td id="xdzb" valign="top"width="200px" class="dialogTd" rowspan="3" border="1px"  >
												</td> 
											</tr>
											<tr class="dialogTr">
												<td colspan="2" align="right">	 
										    		<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"   onclick="pointbiaozhu();">巡逻点</a>&nbsp;&nbsp;
													<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"   onclick="areabiaozhu();">巡逻区域</a>
												</td>
										 		<td width="200px" class="dialogTd" align="right" >巡逻区域：</td>
										    	<td width="200px" class="dialogTd">
										    		<script type="text/javascript">
										    			document.write(window.top.getDictName(contextPath + '/common/dict/D_ZAFF_DYLB.js', "${entity.xlqydm}"));
										    		</script>
								    	        </td>
											</tr >
											<tr class="dialogTr">
										    	<td width="200px" class="dialogTd" align="right">组织联系方式：</td>
										    	<td width="200px" class="dialogTd">
								    	        	${entity.zzlxfs}
								    	        </td>
										    	<td width="200px" class="dialogTd" align="right">组织传真号码：</td>
										    	<td width="200px" class="dialogTd">
										    		${entity.zzczhm}
												</td> 
											</tr>
											<tr class="dialogTr">
										    	<td width="200px" class="dialogTd" align="right">责任范围：</td>
										    	<td width="200px" class="dialogTd">
										    		<script type="text/javascript">
										    			document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_ZRFWDM.js', "${entity.zrfwdm}"));
										    		</script>
												</td> 
												<td width="200px" class="dialogTd" align="right">防范部位：</td>
										    	<td width="200px" class="dialogTd">
										    		<script type="text/javascript">
										    			document.write(window.top.getDictName(contextPath + '/common/dict/D_ZAFF_DYLB.js', "${entity.ffbwdm}"));
										    		</script>
								    	        </td>
								    	        <td width="200px" class="dialogTd" align="right">地域类别：</td>
										    	<td width="200px" class="dialogTd">
										    		<script type="text/javascript">
										    			document.write(window.top.getDictName(contextPath + '/common/dict/D_ZAFF_DYLB.js', "${entity.dylbdm}"));
										    		</script>
								    	        </td>
											</tr>
											<tr class="dialogTr">
										    	<td width="200px" class="dialogTd" align="right">作用情况：</td>
										    	<td width="600px" class="dialogTd"  colspan="6">
										    		${entity.zyqk}
												</td> 
											</tr>
											<tr class="dialogTr">
									    	    <td width="200px" class="dialogTd" align="right">备注：</td>
									    	    <td width="600px" class="dialogTd" colspan="5">
									    	    	${entity.bz}
												</td>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</div> 
					</td>
				</tr>
			</table>
		</div> 
		<div data-options="region:'center', split:true" style="width:1080px; margin:0 0 0;border-width: 0px; height:250px;">
			<div class="easyui-tabs" style="height: auto;" id="xxk" style="width:1080px;">  
				<div title="组织人员名单"  >
		    		<div id="dg1" data-options="region:'center',split:true,title:'人防成员',border:true" style="height:250px;width:1080px;">
						<table id="dg0" class="easyui-datagrid" data-options="url: contextPath +'/rfxxb/queryRfcyxx?rfid=${entity.id}',
		            		singleSelect:false,
		            		fitColumns:false,
		            		toolbar:'#datagridToolbar',
		            		border:false,
		            		sortName:'xt_zhxgsj',
		            		sortOrder:'asc',
		            		idField:'id',
		            		pageSize:getAutoPageSize(),
		            		selectOnCheck:true,
		            		checkOnSelect:true,
		            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						    <thead>
						        <tr>	        
						        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
						        	 <th data-options="field:'zjhm',width:200,align:'left',sortable:true,halign:'center'">证件号码</th>
						        	 <th data-options="field:'xm',width:100,align:'left',sortable:true,halign:'center'">姓名</th>
						        	 <th data-options="field:'xbdm',width:100,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
						        	 <th data-options="field:'zjlxdm',width:200,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+ '/common/dict/D_BZ_CYZJ.js'">证件类型</th>
						        	 <th data-options="field:'dz_jzdzxz',width:350,align:'left',sortable:true,halign:'center'">居住地址</th>
						            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
								</tr>
						    </thead>
						</table>
						<div id="datagridToolbar"  style="padding:5px;height:20px;width:100%" >
							<!-- 表格工具条按钮 -->
							<form id="queryForm">
								<table cellspacing="0" cellpadding="0" border="0" width="100%">
									<tbody>
										<tr>
											<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
											</td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</body>
</html>
