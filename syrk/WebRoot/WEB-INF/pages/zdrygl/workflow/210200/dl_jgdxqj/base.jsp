<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		    
<tr class="dialogTr"> 
<td width="20%" class="dialogTd" align="right">申请类型：</td>
<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="sqlx" id="sqlx"    value="${varMap.sqlx}"  style="width:200px;" readonly="readonly" /></td>	    	
<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdrylxmc" id="zdrylxmc"  value="${varMap.zdrylxmc}" style="width:200px;" readonly="readonly" /></td>	    	
</tr>					
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right" id="cgrqText">申请日期：</td>
<td width="30%" class="dialogTd"><input type="text" name="createTime" id="createTime" class="easyui-validatebox inputreadonly"  value="${varMap.createTime}" style="width: 200px;"   readonly="readonly" /></td>
<td width="10%" class="dialogTd" align="right">申请人：</td>
<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="sqrName" id="sqrName"  value="${varMap.sqrName}" style="width:200px;" readonly="readonly" /></td>   	
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right" id="cgsqyjText">申请意见：</td>
<td width="80%" class="dialogTd" colspan="3">
<input class="easyui-validatebox inputreadonly" type="text" id="sqyj" name="sqyj"  value="${varMap.sqyj }"  style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  readonly="readonly"/></td>
</tr>

 <input type="hidden" id="agree" name="agree""  value="sjbm" />
 <input type="hidden" id="disagree" name="disagree" value="NoChoice" />
 <input type="hidden" id="zdrylx" name="zdrylx""  value="${varMap.zdrylx}" />
 <input type="hidden" id="sqlxdm" name="sqlxdm"  value="${varMap.sqlxdm}" />
 
 <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="xm" value="${varMap.xm}" style="width:200px;" readonly="readonly"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" value="${varMap.zjhm}" style="width:200px;" readonly="readonly"/>
		    	</td>
	    	</tr>
	 		<tr class="dialogTr">
			  	<td width="20%" class="dialogTd" align="right">请假原因：</td>
			  	<td width="80%" class="dialogTd" colspan="3"><textarea name="qjyy" id="qjyy" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'请假原因不能超过1000个汉字，请重新输入！',tipPosition:'left'">${varMap.jgdx.qjyy}</textarea>
				</td>
			</tr> 
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">请假日期：</td>
			    <td width="30%" class="dialogTd">
			    	<input type="text" name="qjrq" id="qjrq" class="easyui-validatebox" style="width: 200px;" value="${varMap.jgdx.qjrq }"
			     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'yjfh_rq\') }'})" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/>
			    </td>
	    		<td width="20%" class="dialogTd" align="right">去往地行政区划：</td>
			    <td width="30%" class="dialogTd">
			    	<input type="text" name="qwxzqhdm" id="qwxzqhdm" value="${varMap.jgdx.qwxzqhdm}" class="easyui-combobox" style="width:200px;">
				</td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">去往地详址：</td>
			    <td width="80%" class="dialogTd" colspan="3">
			    	<input type="text" name="qwxz" id="qwxz" class="easyui-validatebox" maxlength="100" style="width: 618px;" value="${varMap.jgdx.qwxz }"/>
			    </td>
	    	</tr>
	    	<tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">预计返回日期：</td>
			    <td width="80%" class="dialogTd" colspan="3">
			    	<input type="text" name="yjfh_rq" id="yjfh_rq" class="easyui-validatebox" style="width: 200px;" value="${varMap.jgdx.yjfh_rq}" 
			    		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'qjrq\') }'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
			    </td>
	    	</tr>
	 		<tr class="dialogTr">
			  	<td width="20%" class="dialogTd" align="right">备注：</td>
			  	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" id="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${varMap.jgdx.bz}</textarea>
				</td>
			</tr> 
	    