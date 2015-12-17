<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">待列管人员姓名：</td>
<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="zdryName" value="${varMap.xm}" name="zdryName" style="width:200px;" readonly="readonly"  /></td>
<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" id="zjhm"   value="${varMap.zjhm}" style="width:200px;" readonly="readonly" /></td>
		    	
</tr>			    
		    
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
<input class="easyui-validatebox inputreadonly" type="text" id="sqyj" name="sqyj"  value="${varMap.sqyj}"  style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  readonly="readonly"/></td>
</tr>

 <input type="hidden" id="agree" name="agree""  value="sjbm" />
 <input type="hidden" id="disagree" name="disagree" value="NoChoice" />
 <input type="hidden" id="zdrylx" name="zdrylx""  value="${varMap.zdrylx}" />
 <input type="hidden" id="sqlxdm" name="sqlxdm"  value="${varMap.sqlxdm}" />
