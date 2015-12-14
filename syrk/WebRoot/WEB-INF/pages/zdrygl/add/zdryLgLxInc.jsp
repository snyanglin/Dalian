<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>		
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
String userOrgCode = "";
String pcsName = "";
String pcsCode="";
if (userInfo != null) {
	userOrgCode = userInfo.getUserOrgCode();
	pcsName=userInfo.getExtendValue("ssPcsName");
	pcsCode=userInfo.getExtendValue("ssPcsCode");
}

%>	    
		    <!-- 监管对象 -->
		    <table id="jgdxDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;display:none">
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">监管类别：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text" id="jglbdm" name="zdryJgdxxxb.jglbdm" style="width:200px;" value="${zdryVO.zdryJgdxxxb.jglbdm }"
					data-options="url: contextPath + '/common/dict/DL_D_JGLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:jglbChange"/>
				</td>
				<td width="20%" class="dialogTd" align="right"></td>
				<td width="30%" class="dialogTd"></td>
			</tr>
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">判决机关：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" data-options="required:false,tipPosition:'right'" type="text" name="zdryJgdxxxb.pjjgmc" id="pjjgmc" style="width: 200px;"  value="${zdryVO.zdryJgdxxxb.pjjgmc}"
					maxlength="50" value="" /></td>
				<td width="20%" class="dialogTd" align="right">监管单位：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox " data-options="required:false,tipPosition:'left'"  type="text" name="zdryJgdxxxb.jgdwmc" id="jgdwmc" style="width: 200px;" value="${zdryVO.zdryJgdxxxb.jgdwmc}" 
					maxlength="50" value=""/></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">犯罪性质：</td>
				<td width="80%" class="dialogTd" colspan="3"><input class="easyui-combotree" type="text" id="fzxzdm" name="zdryJgdxxxb.fzxzdm" style="width:628px;" value="${zdryVO.zdryJgdxxxb.fzxzdm}" delayParse="true"
					data-options="url: contextPath + '/common/dict/DL_D_FZXZDM.js',onlyLeaf:true,dataFilter:'^01|^02|^03|^04|^05|^06|^07|^08|^09|^10|^91|^92|^93|^94|^95|^96|^99999',multiple:true,method:'get',editable:true,lines:true"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">处理结果：</td>
				<td width="80%" class="dialogTd" colspan="3"><input class="easyui-combobox " type="text" name="zdryJgdxxxb.wfxyrcljgdm" id="wfxyrcljgdm" value="${zdryVO.zdryJgdxxxb.wfxyrcljgdm}" style="width:628px;"
					data-options="url: contextPath + '/common/dict/DL_D_JGLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',readonly:true"/>
			</tr>
			</table>
		    
		    
		    <!-- 重点人口 -->
		    <table id="zdrkDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;display:none">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">重点人员管理方法：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="glffdm" name="zdryZdrk.glffdm" style="width:200px;" value="${zdryVO.zdryZdrk.glffdm}"
					data-options="url: contextPath + '/common/dict/BD_D_ZDRKGLFFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/></td>
	    		<td width="20%" class="dialogTd" align="right">列管来源：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="lglydm" name="zdryZdrk.lglydm" style="width:200px;" value="${zdryVO.zdryZdrk.lglydm}"
					data-options="url: contextPath + '/common/dict/DL_D_LGLYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">纳入工作依据：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="zdryZdrk.nrgzyj" maxlength="100" style="width: 628px;" data-options="required:false" value="${zdryVO.zdryZdrk.nrgzyj}"/></td>
	    	</tr>
	    	</table>
	    	<!-- 肇事肇祸精神病人 -->
	    	<table id="zszhjsbrDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;display:none">
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">精神病类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jsblbdm" name="zdryZszhjsbrxxb.jsblbdm" style="width:200px;" value="${zdryVO.zdryZszhjsbrxxb.jsblbdm}"
					data-options="url: contextPath + '/common/dict/BD_D_JSBLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/></td>
	    		<td width="20%" class="dialogTd" align="right">&nbsp;</td>
	    		<td class="dialogTd">&nbsp;</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">精神病成因：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryZszhjsbrxxb.jsbcy" id="jsbcy" class="easyui-validatebox" style="width: 628px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'精神病成因不能超过1000个汉字，请重新输入！',tipPosition:'left'">${zdryVO.zdryZszhjsbrxxb.jsbcy}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">是否已肇事滋事：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfyzszsdm" name="zdryZszhjsbrxxb.sfyzszsdm" style="width:200px;" value="1" value="${zdryVO.zdryZszhjsbrxxb.sfyzszsdm}"
					data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		    	</td>
	    		<td width="20%" class="dialogTd" align="right">是否持精神类残疾证</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfcjslcjzdm" name="zdryZszhjsbrxxb.sfcjslcjzdm" style="width:200px;" value="0"  value="${zdryVO.zdryZszhjsbrxxb.sfcjslcjzdm}"
					data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left',onChange: sfQdcjzChange"/>
		    	</td>
		    </tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">鉴定机构：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="zdryZszhjsbrxxb.jdjg" id="jdjg" class="easyui-validatebox" style="width: 200px;" maxlength="50"  value="${zdryVO.zdryZszhjsbrxxb.jdjg}"
		    	data-options="validType:['maxLength[50]'],tipPosition:'right'" /></td>
	    		<td width="20%" class="dialogTd" align="right">证件取得时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="zdryZszhjsbrxxb.zjqdsj" id="zjqdsj" class="easyui-validatebox" style="width: 200px;" value="${zdryVO.zdryZszhjsbrxxb.zjqdsj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    	</td>
	    	</tr>
	    	
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">危险性评估登记：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryZszhjsbrxxb.wxxpgdj" id="wxxpgdj" class="easyui-validatebox" style="width: 628px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'危险性评估登记不能超过200个汉字，请重新输入！',tipPosition:'left'">${ zdryVO.zdryZszhjsbrxxb.wxxpgdj}</textarea></td>
	    	</tr>
	    	
	    	<tr  class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">记录人：</td>
		      <td width="30%" class="dialogTd">
		         <input class="easyui-validatebox" type="text" id="jlr" name="zdryZszhjsbrxxb.jlr" maxlength="50" style="width: 200px;" data-options="required:false" value="${zdryVO.zdryZszhjsbrxxb.jlr}"/>
		        </td>
	    	<td width="20%" class="dialogTd" align="right">肇事时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="zdryZszhjsbrxxb.zssj" id="zssj" class="easyui-validatebox" style="width: 200px;" value="${zdryVO.zdryZszhjsbrxxb.zssj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    	</td>
	    	</tr>
	    	
	    	
	    	
	    	
	    	<tr>
	    	<td width="20%" class="dialogTd" align="right">肇事地点：</td>
		    <td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox" type="text" id="zsdd" name="zdryZszhjsbrxxb.zsdd" maxlength="100" style="width: 628px;" data-options="required:false" value="${zdryVO.zdryZszhjsbrxxb.zsdd}"/>
		    	</td>
	    	</tr>
	    	
	    	
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">简要案情：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryZszhjsbrxxb.jyaq" id="jyaq" class="easyui-validatebox" style="width: 628px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'主要案情不能超过1000个汉字，请重新输入！',tipPosition:'left'">${ zdryVO.zdryZszhjsbrxxb.jyaq}</textarea></td>
	    	</tr>
	    	</table>
	    	
	    	
	    	<!-- 非正常访人员 -->
	    	<table id="fzcfryDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;display:none">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">交控部门：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input type="text" name="zdryFzcsfryxxb.jkbm" id="jkbm" class="easyui-validatebox" style="width: 628px;" maxlength="50"  value="${zdryVO.zdryFzcsfryxxb.jkbm}"
		    	data-options="validType:['maxLength[50]'],tipPosition:'right'" /></td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">交控级别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jkjbdm" name="zdryFzcsfryxxb.jkjbdm" style="width:200px;" value="${zdryVO.zdryFzcsfryxxb.jkjbdm}"
					data-options="url: contextPath + '/common/dict/DL_D_JKJBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		    	</td>
	    		<td width="20%" class="dialogTd" align="right">上访人员类别</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfrylbdm" name="zdryFzcsfryxxb.sfrylbdm" style="width:200px;"  value="${zdryVO.zdryFzcsfryxxb.sfrylbdm}" 
					data-options="url: contextPath + '/common/dict/DL_D_SFRYLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		    	</td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">信息上报：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryFzcsfryxxb.xxsb" class="easyui-validatebox" style="width: 628px; height:48px;" 
					data-options="validType:['maxLength[1000]'],invalidMessage:'信息上报不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left'">${zdryVO.zdryFzcsfryxxb.xxsb}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">上访原因：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryFzcsfryxxb.sfyy" class="easyui-validatebox" style="width: 628px; height:48px;" 
					data-options="validType:['maxLength[1000]'],invalidMessage:'上访原因不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left'">${zdryVO.zdryFzcsfryxxb.sfyy}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">已解决上访事项：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryFzcsfryxxb.yjjsfsx" class="easyui-validatebox" style="width: 628px; height:48px;" 
					data-options="validType:['maxLength[1000]'],invalidMessage:'已解决上访事项能超过1000个汉字，请重新输入！',required:false,tipPosition:'left'">${zdryVO.zdryFzcsfryxxb.yjjsfsx}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">未解决上访事项：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryFzcsfryxxb.wjjsfsx" class="easyui-validatebox" style="width: 628px; height:48px;" 
					data-options="validType:['maxLength[1000]'],invalidMessage:'未解决上访事项不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left'">${zdryVO.zdryFzcsfryxxb.wjjsfsx}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">制造舆论地点：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryFzcsfryxxb.zzyldd" class="easyui-validatebox" style="width: 628px; height:48px;" 
					data-options="validType:['maxLength[500]'],invalidMessage:'制造舆论地点不能超过500个汉字，请重新输入！',required:false,tipPosition:'left'">${zdryVO.zdryFzcsfryxxb.zzyldd}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">接访部门：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryFzcsfryxxb.jfbm" class="easyui-validatebox" style="width: 628px; height:48px;"
					data-options="validType:['maxLength[500]'],invalidMessage:'接访部门不能超过500个汉字，请重新输入！',required:false,tipPosition:'left'">${zdryVO.zdryFzcsfryxxb.jfbm}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">涉访处罚情况：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryFzcsfryxxb.cfqk" class="easyui-validatebox" style="width: 628px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'涉访处罚情况不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left'">${zdryVO.zdryFzcsfryxxb.cfqk}</textarea></td>
	    	</tr>
	    	</table>
	    		<!--纳入视线重点人员-->
	    	 <table id="nrsxdxDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;display:none">
		 
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">主要问题及表现：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdryNrsxdxxxb.zywtjxsbx" class="easyui-validatebox" style="width: 621px; height:48px;" 
					data-options="validType:['maxLength[500]'],invalidMessage:'主要问题及表现不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left'">${zdryVO.zdryNrsxdxxxb.zywtjxsbx}</textarea></td>
	    	</tr>
	    	</table>
	    	
	    	<!-- 社区矫正人员 -->
	    	 <table id="sqjzryDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;display:none">
		
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">监管单位机构名称：</td>
		    	<td width="80%" class="dialogTd"><input type="text" readonly="readonly" name="zdrySqjzryxxb.jgdw_gajgmc" id="jgdw_gajgmc" class="easyui-validatebox inputreadonly" style="width: 628px;" maxlength="50"  value="${zdryVO.zdryZszhjsbrxxb.jdjg}"
		    	data-options="validType:['maxLength[50]'],tipPosition:'right'" /></td>
	    	</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">犯罪性质：</td>
				<td width="80%" class="dialogTd" colspan="3"><input class="easyui-combotree" type="text" id="fzxzdm" name="zdrySqjzryxxb.fzxzdm" style="width:628px;" value="${zdryVO.zdryJgdxxxb.fzxzdm}" delayParse="true"
					data-options="url: contextPath + '/common/dict/DL_D_FZXZDM.js',onlyLeaf:false,dataFilter:'^01|^02|^03|^04|^05|^06|^07|^08|^09|^10|^91|^92|^93|^94|^95|^96|^99999',multiple:false,method:'get',editable:true,lines:true"/>
				</td>
			</tr>
			 <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">违法嫌疑人处理结果代码：</td>
		    	<td width="80%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="wfxyrcljgdm" name="zdrySqjzryxxb.wfxyrcljgdm"   style="width:628px;" value=""
					data-options="url: contextPath +  '/common/dict/XZ_D_WFXYRCLJGDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
		    </tr>
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">判决机关名称：</td>
		    	<td width="80%" class="dialogTd"><input type="text" name="zdrySqjzryxxb.pjjgmc" id="sqjzrypjjgmc" class="easyui-validatebox" style="width: 628px;" maxlength="50"  value="${zdryVO.zdryZszhjsbrxxb.jdjg}"
		    	data-options="validType:['maxLength[50]'],tipPosition:'right',required:false" /></td>
	    	</tr>
	    	<tr>
	    		<td width="20%" class="dialogTd" align="right">考验截止日期：</td>
		    	<td width="80%" class="dialogTd"><input type="text" name="zdrySqjzryxxb.ky_jzrq" id="sqjzryky_jzrq" class="easyui-validatebox" style="width: 200px;" value="${zdryVO.zdryZszhjsbrxxb.zjqdsj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})"/>
		    	</td>
	    	</tr>
	     	<tr id="scpjs">
	    		<td width="20%" class="dialogTd" align="right">上传判决书：</td>
		    	<td width="80%" class="dialogTd">	    	
                <input type="file" name="uploadFile" id="upload1" style="width:560px;" class="easyui-validatebox" data-options="tipPosition:'left',invalidMessage:'请选择要上传的判决书'" /></td></td>
		    	</td>
	    	</tr> 
			</table>
	    	  <!-- 涉枪涉爆重点人员 -->
		    <table id="sqsbzdryDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;display:none">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">重点人员管理方法：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sqsbzdryglffdm" name="zdrySqsbzdryxxb.glffdm" style="width:200px;" value="${zdryVO.zdrySqsbzdryxxb.glffdm}"
					data-options="url: contextPath + '/common/dict/BD_D_ZDRKGLFFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/></td>
	    		<td width="20%" class="dialogTd" align="right">列管来源：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sqsbzdrylglydm" name="zdrySqsbzdryxxb.lglydm" style="width:200px;" value="${zdryVO.zdrySqsbzdryxxb.lglydm}"
					data-options="url: contextPath + '/common/dict/DL_D_LGLYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">纳入工作依据：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="zdrySqsbzdryxxb.nrgzyj" maxlength="100" style="width: 628px;" data-options="required:false" value="${zdryVO.zdrySqsbzdryxxb.nrgzyj}"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">案件类别代码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sqsbzdryajlbdm" name="zdrySqsbzdryxxb.ajlbdm" style="width:200px;" value="${zdryVO.zdrySqsbzdryxxb.ajlbdm}"
					data-options="url: contextPath + '/common/dict/BD_D_SQSBZDRYSALBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/></td>
	    		
	    	</tr>
	    	
	    	</table>
	    

<script type="text/javascript" >
//大连用 还是省厅用
var placeVersion = "<%=SystemConfig.getString("PlaceVersion")%>";
var pcsName="<%=pcsName%>";

function jglbChange(newVal,oldVal){
	setInputReadonly("wfxyrcljgdm", true);
	if($("#jglbdm").combobox("getValue")){

		$("#wfxyrcljgdm").combobox("setValue",  $("#jglbdm").combobox("getValue"));
	}
	
	
}

function zdrylxChange(newVal,oldVal){

	if(typeof(newVal)!="undefined"){
		setInputReadonly("zdrylbStr", true);	
		$('#zdrylbStr').combotree('tree').tree('loadData', '');		
		
		$.ajax({
			async:false,
			type:"GET",
			url:"<%= basePath%>zdryzb/queryZdryChildLbList",
			dataType:"json",
			data:"lbdm_p="+newVal,
			success:function(data){
				if (data && data.length>0) {
					setInputReadonly("zdrylbStr", false);
					$('#zdrylbStr').combotree('tree').tree('loadData', data);
				}else{				
					$('#zdrylbStr').combotree('tree').tree('loadData', '');
				}
		
				if(newVal == "01") {
					$("#jgdxDiv").show();
					$("#zdrkDiv").hide();
					$("#zszhjsbrDiv").hide();
					$("#fzcfryDiv").hide();
					$("#ggDiv").show();
					$("#nrsxdxDiv").hide();
					//监管类别
					setComboRequired("jglbdm", true);
					//判决机关
					$("#pjjgmc").validatebox({required:true});
					//监管单位
					$("#jgdwmc").validatebox({required:true});
					//犯罪性质
					setComboRequired("fzxzdm", true);
					//重点人口管理方法
					setComboRequired("glffdm", false);
					//列管来源
					setComboRequired("lglydm", false);
					//精神病类别
					setComboRequired("jsblbdm", false);
					setInputReadonly("wfxyrcljgdm", true);
					
					if ($("#fzxzdm").attr("delayParse") == "true") {	
						$("#fzxzdm").find("input.easyui-combotree-delay").removeClass("easyui-combotree-delay").addClass("easyui-combotree");
						$.parser.parse("#fzxzdm");
						$("#fzxzdm").attr("delayParse", "false");
						//$("#czrk_lbsqk_lzd_gjhdqdm").combobox("setValue", "156");
					}
					
				} else if(newVal == "02" ||newVal == "03" ) {
					$("#jgdxDiv").hide();
					$("#zdrkDiv").show();
					$("#zszhjsbrDiv").hide();
					$("#fzcfryDiv").hide();
					$("#ggDiv").show();
					$("#nrsxdxDiv").hide();
					//监管类别
					setComboRequired("jglbdm", false);
					//判决机关
					$("#pjjgmc").validatebox({required:false});
					//监管单位
					$("#jgdwmc").validatebox({required:false});
					//犯罪性质
					setComboRequired("fzxzdm", false);
					//重点人口管理方法
					setComboRequired("glffdm", true);
					//列管来源
					setComboRequired("lglydm", true);
					//精神病类别
					setComboRequired("jsblbdm", false);
					
				} else if(newVal == "04"||newVal == "05") {
					$("#jgdxDiv").hide();
					$("#zdrkDiv").hide();
					$("#zszhjsbrDiv").show();
					$("#fzcfryDiv").hide();
					$("#ggDiv").show();
					$("#nrsxdxDiv").hide();
					//监管类别
					setComboRequired("jglbdm", false);
					//判决机关
					$("#pjjgmc").validatebox({required:false});
					//监管单位
					$("#jgdwmc").validatebox({required:false});
					//犯罪性质
					setComboRequired("fzxzdm", false);
					//重点人口管理方法
					setComboRequired("glffdm", false);
					//列管来源
					setComboRequired("lglydm", false);
					//精神病类别
					setComboRequired("jsblbdm", true);

					//默认是选择已肇事肇祸
					$("#jsblbdm").combobox("setValue", "1");
					setInputReadonly("jsblbdm", true);
					
				} else if(newVal == "06") {
					$("#jgdxDiv").hide();
					$("#zdrkDiv").hide();
					$("#zszhjsbrDiv").hide();
					$("#fzcfryDiv").show();
					$("#ggDiv").show();
					$("#nrsxdxDiv").hide();
					//监管类别
					setComboRequired("jglbdm", false);
					//判决机关
					$("#pjjgmc").validatebox({required:false});
					//监管单位
					$("#jgdwmc").validatebox({required:false});
					//犯罪性质
					setComboRequired("fzxzdm", false);
					//重点人口管理方法
					setComboRequired("glffdm", false);
					//列管来源
					setComboRequired("lglydm", false);
					//精神病类别
					setComboRequired("jsblbdm", false);
				} else if(newVal == "07"){
					$("#jgdxDiv").hide();
					$("#zdrkDiv").hide();
					$("#zszhjsbrDiv").hide();
					$("#fzcfryDiv").hide();
					$("#sqjzryDiv").hide();
					$("#nrsxdxDiv").show();
					$("#ggDiv").show();
					
				}else if(newVal == "09"||newVal == "08"){
						$("#jgdxDiv").hide();
						$("#zdrkDiv").hide();
						$("#zszhjsbrDiv").hide();
						$("#fzcfryDiv").hide();
						$("#sqjzryDiv").hide();
						$("#nrsxdxDiv").hide();
						$("#ggDiv").show();
						
						//取消必填验证
						//监管类别
						setComboRequired("jglbdm", false);
						//判决机关
						$("#pjjgmc").validatebox({required:false});
						//监管单位
						$("#jgdwmc").validatebox({required:false});
						//犯罪性质
						setComboRequired("fzxzdm", false);
						//重点人口管理方法
						setComboRequired("glffdm", false);
						//列管来源
						setComboRequired("lglydm", false);
						//精神病类别
						setComboRequired("jsblbdm", false);
	
					}else {
						$("#jgdxDiv").hide();
						$("#zdrkDiv").hide();
						$("#zszhjsbrDiv").hide();
						$("#fzcfryDiv").hide();
						$("#sqjzryDiv").hide();
						$("#nrsxdxDiv").hide();
						$("#ggDiv").hide();
					}


					if(lcg == "cg" && newVal !=null){
						var name = $("#xm").val();
						var cglb= window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYGLLX.js', $("#zdrygllxdm_old").val());
						var cghlb= window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYGLLX.js', newVal);
						$("#ywfqyy").val( "申请将【"+name+"】的重点人员管理类别“"+cglb+"”撤管为“"+cghlb+"”管理。");
					}else if(lcg == "lg" ){
						var name = $("#xm").val();
						var cglb= window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYGLLX.js', $("#cglxdm").val());
						var cghlb= window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYGLLX.js', newVal);
						$("#ywfqyy").val( "申请将【"+name+"】的重点人员列管为“"+cghlb+"”管理。");					
					}else{
						
					}
				}
			
		});

			
		}
}

//是否取得残疾证
function sfQdcjzChange(newValue, oldValue){
	if(newValue == "0"){//否
		document.getElementById("jdjg").value = "";
		document.getElementById("zjqdsj").value = "";
		setInputReadonly("jdjg", true);
		setInputReadonly("zjqdsj", true);
	}else{//是
		setInputReadonly("jdjg", false);
		setInputReadonly("zjqdsj", false);
		document.getElementById("jdjg").focus();
	}
}
$(document).ready(function(){

	$("#jgdw_gajgmc").val(pcsName);
	$("#sqsbzdryDiv").hide();
	
});

</script>