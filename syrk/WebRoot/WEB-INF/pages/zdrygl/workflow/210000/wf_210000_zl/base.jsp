<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">待转类人员姓名：</td>
			<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="zdryName" value="${varMap.zdryName}" name="zdryName" style="width:200px;" readonly="readonly"  /></td>
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
	    	<c:if test="${sqlxdm eq '04'}">	    	
	    	 <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">请假日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="qjrq" id="qjrq" class="easyui-validatebox inputreadonly" style="width: 200px;"  readonly="readonly" /></td>
	    		<td width="20%" class="dialogTd" align="right">预计返回日期：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="yjfh_rq" id="yjfh_rq" style="width:200px;" readonly="readonly" /></td>		 	    
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">请假原因：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<textarea name="qjyy" id="qjyy" class="easyui-validatebox inputreadonly" style="width: 618px; height:48px; readonly="readonly"">
						${varMap.qjyy}
					</textarea>
		    	</td>	    				 	   
	    	</tr>	    	
	    	</c:if>
	    	
	    	
	    	  <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgrqText">重点人员已列管类别：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="yzdrylbmc" id="yzdrylbmc" class="easyui-validatebox inputreadonly" value="${varMap.yzdrylbmc }" style="width: 200px;"  readonly="readonly" /></td>
	    		<td width="10%" class="dialogTd" align="right">重点人员转类类别：</td>
		    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="xzdrylbmc" id="xzdrylbmc"  value="${varMap.xzdrylbmc }"style="width:200px;" readonly="readonly" /></td>
		 
	    	
	    	</tr>
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right" id="cgsqyjText">申请意见：</td>
			<td width="80%" class="dialogTd" colspan="3">
			<input class="easyui-validatebox inputreadonly" type="text" id="sqyj" name="sqyj"  value="${varMap.sqyj}"  style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  readonly="readonly"/></td>
		</tr>
