<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>初查线索</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/yjjb.css"/>

<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
<body  class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	    <div style="margin:0px auto;width:1200px;">
	    	<div style="width:880px;float:left;">
		    	<table height="100%" style="margin:0 auto;">
		    	<tr><td height="100%" valign="top" align="center">
		    	
				<div class="pop_conta">
				<div class="pop_contb">
				<div class="pop_contc">
				 
				 <form action="<%=basePath%>xsjbxxb/saveFC" id="jbxxForm" name="jbxxForm" method="post" >
			    	  <div data-options="region:'center', split:true" style="width:880px; border-width: 0px;">
			    	  
			    	  <input type='hidden' name='id' id="id" value="${entity.id}"/> 
			    	  <input type='hidden' id="entity_zbx" name="xsdzzbx" value="${entity.xsdzzbx}"/> 
			    	  <input type='hidden' id="entity_zby" name="xsdzzby" value="${entity.xsdzzby}"/> 
			    	  <!-- 点击保存标注后才将内容保存到entity_zbx和entity_zby -->
			    	  <input type='hidden' id="entity_zbxYs" name="xsdzzbxYs"/> 
			    	  <input type='hidden' id="entity_zbyYs" name="xsdzzbyYs"/> 
			    	  <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			    	      <tr class="dialogTr">
						    	<td width="100" class="dialogTd" align="right">身份证号：</td>
						    	<td width="300" class="dialogTd">
						    		<input class="easyui-validatebox" id="jbrsfzh" name="jbrsfzh" value="${entity.jbrsfzh}" 
						    		style="width:300px;" data-options="required:true,charSet:'halfUpper',validType:['sfzh']" maxlength="18"/>
						    		<div class="lodingimg" id="yrjbxxDiv"></div>
								</td> 
								<td width="130" class="dialogTd" align="right">姓名：</td>
						    	<td width="300" class="dialogTd">
						    		<input class="easyui-validatebox" type="text" id="jbrxm" name="jbrxm" value="${entity.jbrxm}"
				    	 			maxlength="30" style="width:300px;" data-options="required:true,validType:['maxLength[30]']"/>
				    	        </td>
			    	      </tr> 
		   	    	      <tr class="dialogTr">
						    	<td class="dialogTd" align="right">性别：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-combobox" id="jbrxb" name="jbrxb" value="${entity.jbrxb}" 
						    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',
						    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
								</td> 
								<td class="dialogTd" align="right">出生日期：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-validatebox" type="text" id="jbrsr" name="jbrsr" value="${entity.jbrsr}"
				    	 			maxlength="20" style="width:300px;" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'"
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" />
				    	        </td>
			    	      </tr> 
			    	      <tr class="dialogTr">
						    	<td class="dialogTd" align="right">单位：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-validatebox" id="jbrdw" name="jbrdw" value="${entity.jbrdw}" 
						    		style="width:300px;" data-options="required:true,validType:['maxLength[100]'],tipPosition:'right'"/>
								</td> 
								<td class="dialogTd" align="right">手机号码：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-validatebox" type="text" id="jbrmobile" name="jbrmobile" value="${entity.jbrmobile}"
				    	 			maxlength="300" style="width:300px;" data-options="required:true,validType:['maxLength[1000]'],tipPosition:'right'"/>
				    	        </td>
			    	      </tr>
			    	      <tr class="dialogTr">
			    	      		<td width="" class="dialogTd" align="right">联系方式：</td>
			    	      		<td width="" class="dialogTd"  colspan="3">
						    		<input class="easyui-validatebox inputreadonly" type="text" readOnly="readOnly" name="jbrlxfs" value="${entity.jbrlxfs}" 
				    	 			maxlength="1000" style="width:750px;" />
				    	 		</td>
					      </tr>
					      <!-- 
					      <c:forEach var="item" items="${listlxfs}" varStatus="i">
				    	       	<tr class="dialogTr">
				    	      		<td width="" class="dialogTd" align="right">联系方式：</td>
							    	<td width="" class="dialogTd"  colspan="3">
							    		<input class="easyui-validatebox inputreadonly" type="text"  readOnly="readOnly" name="jbrlxfsList" value="${item}" 
					    	 			maxlength="1000" style="width:750px;" data-options="required:false,validType:['maxLength[1000]'],tipPosition:'right'"/>
					    	        </td>
				    	      	</tr>
			    	      </c:forEach>
			    	      -->
			    	      <tr class="dialogTr">
						    	<td class="dialogTd" align="right">出租车车牌：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-validatebox" id="czzcp" name="czzcp" value="${entity.czzcp}" 
						    		style="width:300px;" data-options="required:true,validType:['maxLength[10]'],tipPosition:'right'"/>
								</td> 
								<td class="dialogTd" align="right">从业资格证：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-validatebox" type="text" id="cyzgz" name="cyzgz" value="${entity.cyzgz}"
				    	 			maxlength="300" style="width:300px;" data-options="required:true,validType:['maxLength[10]'],tipPosition:'right'"/>
				    	        </td>
			    	      </tr>
			    	      <tr class="dialogTr">
								<td class="dialogTd" align="right">居住地址：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-validatebox" type="text" id="jbrxjzdz" name="jbrxjzdz" value="${entity.jbrxjzdz}"
				    	 			maxlength="100" style="width:300px;" data-options="required:true,validType:['maxLength[100]'],tipPosition:'right'"/>
				    	        </td>
				    	        <td class="dialogTd" align="right">户籍地址：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-validatebox" id="hjdz" name="hjdz" value="${entity.hjdz}" 
						    		style="width:300px;" data-options="required:true,validType:['maxLength[100]'],
						    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
								</td> 
			    	      </tr>	   
			    	      <tr class="dialogTr">
						    	<td class="dialogTd" align="right">线索类型：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-combobox" id="xslx" name="xslx" value="${entity.xslx}" 
						    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_XSLX.js',
						    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
								</td> 
								<td class="dialogTd" align="right">举报信息性质：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-combobox" type="text" id="jbxxxz" name="jbxxxz" value="${entity.jbxxxz}"
				    	 			maxlength="20" style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_AJLB.js',
						    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
				    	        </td>
			    	      </tr> 
		       		    <tr class="dialogTr">
		
		    				<td class="dialogTd" align="right">线索发现地址：</td>
							 <td class="dialogTd" colspan="2">
								  <input class="easyui-combobox" id="jzd1" style="width:440px;" value="${entity.xsdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
								    	<input type='hidden' name='xsdzmlpdm' id="xsdzmlpdm" value="${entity.xsdzmlpdm}"/>
								    	<input type='hidden' name='xsdzmlpxz' id="xsdzmlpxz" value="${entity.xsdzmlpxz}"/>
								  </td>
								<td class="dialogTd" >
								<input class="easyui-combobox" id="jzd2" style="width:300px;" value='${fn:replace(entity.xsdzxz, entity.xsdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
								<input type="hidden" name="xsdzdm" id="xsdzdm" value="${entity.xsdzdm}"/>
								<input type="hidden" name="xsdzssxdm" id="xsdzssxdm" value="${entity.xsdzssxdm}"/>
							    <input type='hidden' name='xsdzxz' id="xsdzxz" value="${entity.xsdzxz}"/>
								</td>
				    		
			    	    </tr>
			    	    <!-- ************************************************* -->
			    	      <tr class="dialogTr" id="mapZRQ">
			    	      	<td width="" class="dialogTd" align="right" valign="top">所属派出所：</td>
				    	    <td width="" class="dialogTd" colspan="3">
				    	    	<div title="地图信息" style="height:500px;" >  
								<iframe width="748" height="100%" id="mapIframe" name ="mapIframe" style="border:1px solid #ccc;"
										src="<%=basePath%>/forward/map|mapZrq?zbx=${entity.xsdzzbx}&zby=${entity.xsdzzby}">
								</iframe>
								</div>
							</td>
			    	    </tr>
			   		      <tr class="dialogTr">
								<td class="dialogTd" align="right" valign="top">线索地址描述：</td>
						    	<td  class="dialogTd" colspan="3" >
						    		<textarea id="xsdzms" name="xsdzms" class="easyui-validatebox" style="width: 750px; height:48px;"
									data-options="validType:['maxLength[1000]'],invalidMessage:'线索地址描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.xsdzms}</textarea>
								</td>
			    	      </tr>
			    	      <tr class="dialogTr">
						    	<td class="dialogTd" align="right" valign="top">举报内容：</td>
						    	<td class="dialogTd" colspan="3" >
						    		<textarea id="jbnr" name="jbnr" class="easyui-validatebox" style="width: 750px; height:48px;"
									data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.jbnr}</textarea>
								</td>
			    	      </tr> 	
			    	      
			    	      <!-- ***************************************************************************************************** -->
			    	      <tr class="dialogTr">
						    	<td class="dialogTd" align="right">初查结果：</td>
						    	<td class="dialogTd">
						    		<input class="easyui-combobox" id="ccjg" name="ccjg" value="${entity.ccjg}" 
						    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_DCJG.js',
						    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
								</td> 
								
								<td class="dialogTd"  id="printButton3">
									<a  class="l-btn l-btn-small" href="javascript:void(0)" group="">
										<span class="l-btn-left l-btn-icon-left">
											<span class="l-btn-text">打印3日反馈单</span>
											<span class="l-btn-icon icon-print"> </span>
										</span>
									</a>
								</td>
			    	      </tr>
			    	      
			    	      	    	      <!-- 查看关联案件 -->
			    	      <tr class="dialogTr" id="ajckglaj" >
				    	    <td class="dialogTd" align="right"></td>
							<td  class="dialogTd">
				    	    	<a id="ckglaj" type="button" class="l-btn l-btn-small">
					    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
										<span class="l-btn-text">查看关联案件</span>
										<span class="l-btn-icon icon-search"> </span>
									</span>
					    		</a>
							</td>
			    	       </tr>
			    	       
			    	       <!-- 关联案件 -->
			    	       <tr class="dialogTr" id="ajglaj" >
				    	    <td class="dialogTd" align="right"></td>
							<td  class="dialogTd">
				    	    	<a id="glaj" type="button" class="l-btn l-btn-small">
					    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
										<span class="l-btn-text">关联案件</span>
										<span class="l-btn-icon icon-search"> </span>
									</span>
					    		</a>
							</td>
			    	       </tr>
			    	       
			    	       <!-- 初查结果 -->
			    	       <tr class="dialogTr" id ="ccbzTr">
						    	<td class="dialogTd" align="right">原因说明：</td>
						    	<td  class="dialogTd" colspan="3" >
						    		<textarea id="ccbz" name="ccbz" class="easyui-validatebox" style="width: 660px; height:48px;"
									data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.ccbz}</textarea>
								</td>
			    	      </tr> 
			    	      
			    	       <!-- 递转地址 -->
			    	      <tr class="dialogTr" id="dzdz" >
		
		    				<td class="dialogTd" align="right">递转地址：</td>
							 <td class="dialogTd" colspan="2">
								  <input class="easyui-combobox" id="jzd3" style="width:400px;" value="${entity.sldzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
								    	<input type='hidden' name='sldzmlpdmCC' id="sldzmlpdm" value="${entity.sldzmlpdm}"/>
								    	<input type='hidden' name='sldzmlpxzCC' id="sldzmlpxz" value="${entity.sldzmlpxz}"/>
								  </td>
								<td width="50%" class="dialogTd" >
								<input class="easyui-combobox" id="jzd4" style="width:200px;" value='${fn:replace(entity.sldzxz, entity.sldzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
								<input type="hidden" name="sldzdmCC" id="sldzdm" value="${entity.sldzdm}"/>
								<input type="hidden" name="sldzssxdmCC" id="sldzssxdm" value="${entity.sldzssxdm}"/>
							    <input type='hidden' name='sldzxzCC' id="sldzxz" value="${entity.sldzxz}"/>
								</td>
			    	    </tr>
			    	    <tr class="dialogTr" id="dzdzbz" >
				    	    <td class="dialogTd" align="right"></td>
							<td  class="dialogTd">
				    	    	<a id="mapBottonCC" type="button" class="l-btn l-btn-small">
					    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
										<span class="l-btn-text">标注</span>
										<span class="l-btn-icon icon-search"> </span>
									</span>
					    		</a>
							</td>
			    	       </tr>
			   		      <tr class="dialogTr" id="dzdzddms">
								<td class="dialogTd" align="right" valign="top">地点描述：</td>
						    	<td  class="dialogTd" colspan="3" >
						    		<textarea id="sldzms" name="sldzmsCC" class="easyui-validatebox" style="width: 660px; height:48px;"
									data-options="validType:['maxLength[1000]'],invalidMessage:'地址描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.sldzms}</textarea>
								</td>
			    	      </tr>
			    	      <!-- ***************************************************************************************************** -->      
			    		   <tr class="dialogTr">
						    	<td class="dialogTd" align="right">复查结果：</td>
						    	<td class="dialogTd" >
						    		<input class="easyui-combobox" id="fcjg" name="fcjg" value="${entity.fcjg}" 
						    		style="width:300px;" data-options="required:true,url: contextPath + '/common/dict/D_BZ_DCJG.js',
						    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:fcjgChange"/>
								</td> 
								
								<td class="dialogTd"  id="printButton30">
									<a  class="l-btn l-btn-small" href="javascript:void(0)" group="">
										<span class="l-btn-left l-btn-icon-left">
											<span class="l-btn-text">打印30日反馈单</span>
											<span class="l-btn-icon icon-print"> </span>
										</span>
									</a>
								</td>
			    	      </tr>
			    	      <!-- 查看关联案件 -->
			    	      <tr class="dialogTr" id="ajckglajFC" >
				    	    <td class="dialogTd" align="right"></td>
							<td  class="dialogTd">
				    	    	<a id="ckglajFC" type="button" class="l-btn l-btn-small">
					    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
										<span class="l-btn-text">查看关联案件</span>
										<span class="l-btn-icon icon-search"> </span>
									</span>
					    		</a>
							</td>
			    	       </tr>
			    	       
			    	       <!-- 关联案件 -->
			    	       <tr class="dialogTr" id="ajglajFC" >
				    	    <td class="dialogTd" align="right"></td>
							<td  class="dialogTd">
				    	    	<a id="glajFC" type="button" class="l-btn l-btn-small">
					    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
										<span class="l-btn-text">关联案件</span>
										<span class="l-btn-icon icon-search"> </span>
									</span>
					    		</a>
							</td>
			    	       </tr>
			    	       <!-- 复查结果 -->
			    	       <tr class="dialogTr" id ="fcbzTr">
						    	<td class="dialogTd" align="right" valign="top">原因说明：</td>
						    	<td  class="dialogTd" colspan="3" >
						    		<textarea id="fcbz" name="ccbz" class="easyui-validatebox" style="width: 660px; height:48px;"
									data-options="validType:['maxLength[1000]'],invalidMessage:'举报内容不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.fcbz}</textarea>
								</td>
			    	      </tr> 
			    	      
			    	      <!-- 递转地址 -->
			    	      <tr class="dialogTr" id="dzdzFC" >
		
		    				<td class="dialogTd" align="right">递转地址：</td>
							 <td  class="dialogTd" colspan="2">
								  <input class="easyui-combobox" id="jzd3FC" style="width:400px;" value="${entity.sldzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
								    	<input type='hidden' name='sldzmlpdm' id="sldzmlpdmFC" value="${entity.sldzmlpdm}"/>
								    	<input type='hidden' name='sldzmlpxz' id="sldzmlpxzFC" value="${entity.sldzmlpxz}"/>
								  </td>
								<td width="50%" class="dialogTd" >
								<input class="easyui-combobox" id="jzd4FC" style="width:200px;" value='${fn:replace(entity.sldzxz, entity.sldzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
								<input type="hidden" name="sldzdm" id="sldzdmFC" value="${entity.sldzdm}"/>
								<input type="hidden" name="sldzssxdm" id="sldzssxdmFC" value="${entity.sldzssxdm}"/>
							    <input type='hidden' name='sldzxz' id="sldzxzFC" value="${entity.sldzxz}"/>
								</td>
			    	    </tr>
			    	    <tr class="dialogTr" id="dzdzbzFC" >
				    	    <td class="dialogTd" align="right"></td>
							<td  class="dialogTd">
				    	    	<a id="mapBottonFC" type="button" class="l-btn l-btn-small">
					    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
										<span class="l-btn-text">标注</span>
										<span class="l-btn-icon icon-search"> </span>
									</span>
					    		</a>
							</td>
			    	       </tr>
			   		      <tr class="dialogTr" id="dzdzddmsFC">
								<td class="dialogTd" align="right">地点描述：</td>
						    	<td class="dialogTd" colspan="3" >
						    		<textarea id="sldzmsFC" name="sldzms" class="easyui-validatebox" style="width: 660px; height:48px;"
									data-options="validType:['maxLength[1000]'],invalidMessage:'地址描述不能超过1000个汉字，请重新输入！',tipPosition:'left'" >${entity.sldzms}</textarea>
								</td>
			    	      </tr>
						</table>
				    </div>
				  </form>
				</div>
				
			    </div>
			    </div>
				<div style="height:6px;font-size:1px;"></div>
				<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
						<span class="l-btn-left l-btn-icon-left">
							<span class="l-btn-text">关闭</span>
							<span class="l-btn-icon icon-cancel"> </span>
						</span>
					</a>
				</div>
		</td>
		</tr>
		</table>
	</div>
	<div style="float:left;width:250px;min-height:200px; margin-left:25px;*margin-left:5px;">
		<ul class="colli">
			<c:forEach var="item1" items="${listSq}" varStatus="i">
				<c:forEach var="item2" items="${spAll[i.index]}">
					<c:if test="${item2.spztV == '0'}">
						<li>
							<div>${item2.xt_lrsjV}${item2.spdw}收到递转审批</div>
							<div>处理状态：${item2.spzt}</div>
						</li>
					</c:if>
					<c:if test="${item2.spztV == '1' || item2.spztV == '2'}">
						<c:if test="${item2.xt_lrsjV != null && item2.spdwV != null}">
							<li>
								<div>${item2.xt_lrsjV}由 ${item2.spdw}递转审批</div>
								<div>处理状态：${item2.spzt}</div>
								<div>审批回复：${item2.sphf}</div>
								<div>审批流转至：${item2.spdwV}</div>
							</li>
						</c:if>
						<c:if test="${item2.xt_lrsjV == null && item2.spdwV == null}">
							<li>
								<div>${item2.xt_zhxgsj}由 ${item2.spdw}递转审批</div>
								<div>处理状态：${item2.spzt}</div>
								<div>审批回复：${item2.sphf}</div>
								<div>审批流转至：${item2.zpsldw}</div>
							</li>
						</c:if>
						
					</c:if>
				</c:forEach>
				<li>${item1.sqsj}该审批由${item1.xt_lrrbm}的${item1.xt_lrrxm}向上级发起递转申请</li>
			</c:forEach>
			
		</ul>
		<!-- 
		<ul class="colli">
			<c:forEach var="item" items="${list}">
			<c:if test="${item.spztV == '0'}">
				<li>
					<div>${item.xt_lrsj}${item.spdw}收到递转审批</div>
					<div>审批状态：${item.spzt}</div>
				</li>
			</c:if>
			<c:if test="${item.spztV == '1' || item.spztV == '2'}">
				<c:if test="${item.xt_lrsjV != null && item.spdwV != null}">
					<li>
						<div>${item.xt_lrsjV}由${item.spdw}递转审批</div>
						<div>审批状态：${item.spzt}</div>
						<div>审批回复：${item.sphf}</div>
						<div>递转至：${item.spdwV}</div>                   
					</li>
				</c:if>
				<c:if test="${item.xt_lrsjV == null && item.spdwV == null}">
					<li>
						<div>${item.xt_zhxgsj}由${item.spdw}递转审批</div>
						<div>审批状态：${item.spzt}</div>
						<div>审批回复：${item.sphf}</div>
						<div>递转至：${item.zpsldw}</div>                   
					</li>
				</c:if>
			</c:if>
			</c:forEach>
			<li>该审批${entitySq.sqsj}由${entitySq.xt_lrrbm}的${entitySq.xt_lrrxm}向上级发起递转申请</li>
		</ul>
		 -->
	</div>
</div>
</div>


<script type="text/javascript">

function doInit(paramArray) {

}

function setReadOnlys(){

	setInputReadonly('jbrsfzh', true);
	setInputReadonly('jbrxm', true);
	setInputReadonly('jbrxb', true);
	setInputReadonly('jbrsr', true);
	$('#jbrsr').removeAttr("onclick");
	setInputReadonly('jbrdw', true);
	setInputReadonly('jbrmobile', true);
	setInputReadonly('czzcp', true);
	setInputReadonly('cyzgz', true);
	setInputReadonly('hjdz', true);
	setInputReadonly('jbrxjzdz', true);
	setInputReadonly('xslx', true);
	setInputReadonly('jbxxxz', true);
	setInputReadonly('jzd1', true);
	setInputReadonly('jzd2', true);
	setInputReadonly('xsdzms', true);
	setInputReadonly('jbnr', true);
	setInputReadonly('entity_zbx', true);
	setInputReadonly('entity_zby', true);
	
	// 初查结果 只读
	setInputReadonly('ccjg', true);
	setInputReadonly('ckglaj', true);
	setInputReadonly('glaj', true);
	setInputReadonly('ccbz', true);
	setInputReadonly('jzd3', true);
	setInputReadonly('jzd4', true);
	setInputReadonly('sldzms', true);
	
	// 复查结果 只读
	setInputReadonly('fcjg', true);
	setInputReadonly('glajFC', true);
	setInputReadonly('fcbz', true);
	setInputReadonly('jzd3FC', true);
	setInputReadonly('jzd4FC', true);
	setInputReadonly('sldzmsFC', true);
}

function check(){
    clearValue();
	var hm = $("#jbrsfzh").val(); 
	if(!$("#jbrsfzh").validatebox("isValid")){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+$("#jbrsfzh").val()+"&cyzjdm=111",
		success:function(data){
		if (data && data.ryjbxxb) {
			$("#jbrxm").val(data.ryjbxxb.xm);
		}
		},
		complete:function(){
			_zjhm = $("#jbrsfzh").val();
			$('#dataForm').form('validate');
			$(".lodingimg").hide();
		}
	});
}
function clearValue(){

	$("#jbrxm").val("");
}
$(function(){
	

	//地址查询
	initAddressSearch('jzd1', {}, 'xsdzmlpdm', 'xsdzmlpxz', 'jzd2', {text:'xsdzxz',dzxzqh:'xsdzssxdm',id:'xsdzdm'}, null, null);
	initAddressSearch('jzd3', {}, 'sldzmlpdm', 'sldzmlpxz', 'jzd4', {text:'sldzxz',dzxzqh:'sldzssxdm',id:'sldzdm'}, null, null);
	initAddressSearch('jzd3FC', {}, 'sldzmlpdmFC', 'sldzmlpxzFC', 'jzd4FC', {text:'sldzxzFC',dzxzqh:'sldzssxdmFC',id:'sldzdmFC'}, null, null);
	
	allHide();

	var ccjg=$("#ccjg").val();
	if(ccjg == 40){
		
		// dzdzShow();
	}else if(ccjg==20){
		
		var xsbh = "${entity.id}";
		$.ajax({
			type:"GET",
			sync:true,
			// 根据线索编号查询已关联案件数据
			// 参考：url:contextPath+"/bzdz/ifExistCh",
			url:contextPath+"/xsajgxb/ifExistAj",
			// 传入线索编号
			data:{xsbh:xsbh},
			dataType:'json',
			success:function(json){
				if(json<1){
					// 没有关联案件，线索“案件关联”按钮
					$("#ajglaj").show();
				}else{
					// 已关联案件，显示“查看关联案件”按钮
					$("#ajckglaj").show();
				}
			}
		});
	} else if(ccjg == 30){

		$("#ccbzTr").show();
	}
	
	// 复查结果
	allHideFC();
	var fcjg=$("#fcjg").val();
	if(fcjg == 20) {
		
		var xsbh = "${entity.id}";
		$.ajax({
			type:"GET",
			sync:true,
			// 根据线索编号查询已关联案件数据
			// 参考：url:contextPath+"/bzdz/ifExistCh",
			url:contextPath+"/xsajgxb/ifExistAj",
			// 传入线索编号
			data:{xsbh:xsbh},
			dataType:'json',
			success:function(json){
				if(json<1){
					// 没有关联案件，线索“案件关联”按钮
					$("#ajglajFC").show();
				}else{
					// 已关联案件，显示“查看关联案件”按钮
					$("#ajckglajFC").show();
				}
			}
		});
	}else if(fcjg == 30){
		
		$("#fcbzTr").show();
	} else if(fcjg == 40){
		
		//dzdzFCShow();
	}
	
	
	
	
	setReadOnlys();
	//map标注
	//$('#mapBotton').click(function(){  biaozhu();});
	//$('#mapBottonCC').click(function(){  biaozhu();});
	//$('#mapBotton').click(function(){  biaozhu();});
	//$("#jbrsfzh").bind("blur",function(e){	check();});
	$('#jbxxForm').form({  
	
        onSubmit:function(){
        
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            
            	topMessagerAlert(null,json.message);
            }else{
            
            	$("#id").val(json.saveID); 
            	
            	executeTabPageMethod(mainTabID, "reloadDg");
				topMessagerAlert(null, "保存成功","success");
            	closeSelf();
            }
        }  
    });   
	
	$('#saveButton').click(function(){
	
		topMessager.confirm('操作确认', '您是否保存任务信息？',  function(r) {
		
			if (r) {
			
				$('#jbxxForm').submit();
			}
		});
	});
	
	
	$('#printButton3').click(function(){
		
		openPrint3();
	});


	$('#printButton30').click(function(){
		
		openPrint30();
	});

	$('#backButton').click(function(){
		
		closeSelf();
	});
	
	$('#resetBotton').click(function(){
	
		//document.forms["jbxxForm"].reset();
		$('#jbxxForm').form('reset');
	});
});
	function biaozhu(){
		var url = contextPath+'/forward/map|mapBz';
		var paramArray = [];
		openWindow(false, null, url, 
	   		paramArray, 
	   		{
		   		title:'地图标注（鼠标点击左键标注位置，右键退出标注模式）',
		   		maximizable: false,
		   		width: 850,	
		   		height: 400
	   		}
	   	);
	}
	
	// 隐藏初查相关选项
	function allHide(){
		
		$("#dzdz").hide();
		$("#dzdzbz").hide();
		$("#dzdzddms").hide();
		
		$("#ajckglaj").hide();
		$("#ajglaj").hide();
		
		$("#ccbzTr").hide();
		
	}
	
	// 隐藏初查相关选项
	function allHideFC(){
		
		$("#dzdzFC").hide();
		$("#dzdzbzFC").hide();
		$("#dzdzddmsFC").hide();
		
		$("#ajckglajFC").hide();
		$("#ajglajFC").hide();
		
		$("#fcbzTr").hide();
		
	}
	
	// 线索地址相关选项
	function dzdzShow(){
		
		$("#dzdz").show();
		$("#dzdzbz").show();
		$("#dzdzddms").show();
	}
	
	// 线索地址相关选项
	function dzdzFCShow(){
		
		$("#dzdzFC").show();
		$("#dzdzbzFC").show();
		$("#dzdzddmsFC").show();
	}
	
	function fcjgChange(newValue, oldValue){
		
		allHideFC();
		if(newValue == 20) {
			
			var xsbh = "${entity.id}";
			$.ajax({
				type:"GET",
				sync:true,
				// 根据线索编号查询已关联案件数据
				// 参考：url:contextPath+"/bzdz/ifExistCh",
				url:contextPath+"/xsajgxb/ifExistAj",
				// 传入线索编号
				data:{xsbh:xsbh},
				dataType:'json',
				success:function(json){
					if(json<1){
						// 没有关联案件，线索“案件关联”按钮
						$("#ajglajFC").show();
					}else{
						// 已关联案件，显示“查看关联案件”按钮
						$("#ajckglajFC").show();
					}
				}
			});
		}else if (newValue == 30){
			
			$("#fcbzTr").show();
		}else if (newValue == 40){
			
			dzdzFCShow();
		}
	}
	
	function openPrint3(){
		
		var hsUrl = '/xsjbxxb/openPrint?';
		hsUrl+="id="+$("#id").val()+"&mainTabID="+getMainTabID();
		hsUrl+="&flag='3'";
		menu_open('打印30日反馈单',hsUrl);
	}

	function openPrint30(){
		
		var hsUrl = '/xsjbxxb/openPrint?';
		hsUrl+="id="+$("#id").val()+"&mainTabID="+getMainTabID();
		hsUrl+="&flag='30'";
		menu_open('打印30日反馈单',hsUrl);
	}

</script>
</body>
</html>