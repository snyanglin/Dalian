<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
/******************************************************************************
 * @JSPName:      [wfxxbAdd.jsp]   
 * @Description:  [物防添加页面]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-06-03]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-06-03(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 
  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="<%=contextPath%>/js/wfxx/wfxxAdd.js"></script>
		<title>物防信息添加</title>
		<script>
		var mainTabID = "${mainTabID}";
		</script>
	</head>
<body style="margin-top:20px" class="bodybg">
	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">   	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">		
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    	  <form action="<%=basePath%>wfxxb/saveWfxxb" id="wfxxForm" name="wfxxForm" method="post">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">  			
	    		  <input type='hidden' name='id' id="entity_id" value="${entity.id}"/>
	    		  <input type='hidden' name='crdwmc' id="crdwmc" value="${dwmc}"/>
	    		  <input type='hidden' name='crdwid' id="crdwid" value="${dwid}"/>
	    		  <input type='hidden' name='infoUrl' id="infoUrl" value="${infoUrl}"/>
	    		  <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" id="gxzrq" name="gxzrq" value="${gxzrq}" 
				    		style="width:200px;" maxlength="20"/>
						</td> 
				    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" id="gxpcs" name="gxpcs" value="${gxpcs}" 
				    		style="width:200px;"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
			          <td width="20%" class="dialogTd" align="right">单位：</td>
			    	  <td width="80%" class="dialogTd" colspan="3">
			    	      <input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
			    	      <input type="hidden" id="dwmc" name="dwmc" />
			    	      <input class="easyui-combobox" type="text" id="dw-box" name="dw-box" 
		    	      			data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',
		    	      			textField:'text',selectOnNavigation:false,required:true" name="dw-box" value="${dwmc}" maxlength="50" style="width:595px;"/></td>
		    	  </tr>
	    		  <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">物防种类：</td>
				    	<td width="30%" class="dialogTd">
							<input class="easyui-combobox" id="entity_wfzl" name="wfzl" style="width:200px;" value="${entity.wfzl}"
								data-options="url:contextPath+'/common/dict/D_ZAFF_WFZL.js',valueField:'id',
								textField:'text',selectOnNavigation:false,method:'get',required:true,onSelect:onSelect,tipPosition:'right'"/>
						</td> 
				    	<td width="20%" class="dialogTd" align="right">数量：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" id="entity_sl" name="sl" value="${entity.sl}" 
				    		style="width:200px;" maxlength="20" data-options="required:true,validType:['numeric[\'i\']']"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">安装日期：</td>
				    	<td width="30%" class="dialogTd">
		    	        	<input class="easyui-validatebox" type="text" id="entity_azrq" name="azrq" style="width:200px;" value="${entity.azrq }"
							data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    	        </td>
	    	      </tr>
	    	      <tr class="dialogTr">
			    	   <td width="20%" class="dialogTd" align="right">描述：</td>
					   <td width="80%" class="dialogTd" colspan="3">
						   <textarea class="easyui-validatebox" id="entity_ms" name="ms" style="width:595px; height:48px;"
						   			data-options="validType:['maxLength[500]'],invalidMessage:'描述不能超过500个汉字，请重新输入！',required:false,tipPosition:'left'">${entity.ms}</textarea>
					   </td>
	    	      </tr>
	    	       <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">物防地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
				    	<input class="easyui-combobox" id="wfdz1" style="width:380px;" value="${entity.dz_wfdzmlpxz}" 
				    		data-options="required:false,mode:'remote',method:'post',panelHeight: 22,
				    		valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_wfdzmlpdm' id="wfdzmlpdm" value="${entity.dz_wfdzmlpdm}"/>
				    	<input type='hidden' name='dz_wfdzmlpxz' id="wfdzmlpxz" value="${entity.dz_wfdzmlpxz}"/>
			    	</td>
			    	<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="wfdz2" style="width:200px;" value='${fn:replace(entity.dz_wfdzxz, entity.dz_wfdzmlpxz, "")}' 
				    			data-options="required:false,mode:'remote',method:'post',panelHeight: 22,
				    			valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_wfdzdm' id="wfdzdm" value="${entity.dz_wfdzdm}"/>
				    	<input type='hidden' name='dz_wfdzssxdm' id="wfdzssxdm" value="${entity.dz_wfdzssxdm}"/>
				    	<input type='hidden' name='dz_wfdzxz' id="wfdzxz" value="${entity.dz_wfdzxz}"/>
			    	</td>
	    	      </tr>
	    	      <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right"></td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<a id="mapBotton" type="button" class="l-btn l-btn-small">
				    			<span class="l-btn-left l-btn-icon-left" href="javascript:void(0)">
									<span class="l-btn-text">标注</span>
									<span class="l-btn-icon icon-search"> </span>
								</span>
				    		</a>
						</td>
	    	       </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">坐标X：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="entity_zbx" name="zbx" value="${entity.zbx}"
		    	        			style="width: 200px;" readonly="readonly"/>	
						</td>
				    	<td width="20%" class="dialogTd" align="right">坐标Y：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class="easyui-validatebox" type="text" id="entity_zby" name="zby" value="${entity.zby}"
		    	        			style="width: 200px;" readonly="readonly"/>
						</td> 
	    	      </tr>
	    	      <tr class="dialogTr">
			    	    <td width="20%" class="dialogTd" align="right">备注：</td>
			    	    <td width="80%" class="dialogTd" colspan="3">
			    	    	<textarea id="entity_bz" name="bz" class="easyui-validatebox" rows="2" style="width:595px; height:52px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
						</td>
	    	     	  </tr>
	    			</table>
	    		</form>
		    </div>
		</div>
	    </div>
	    </div>
		<div style="height:6px;font-size:1px;"></div>	
		</form>    
		</div>
		</div>
		</div>		
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="resetBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">重置</span>
					<span class="l-btn-icon icon-reset"> </span>
				</span>
			</a>
		</div>
      </td>
    </tr>
 </table>
</div>
</body>
</html>
