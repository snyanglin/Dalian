<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<tr class="dialogTr">
	    	<td width="30%" class="dialogTd" align="right">转递人员姓名：</td>
	    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="zdryName" name="zdryName" value="${varMap.xm}" style="width:200px;" readonly="readonly"  /></td>
	    	<td width="30%" class="dialogTd" align="right">公民身份号码：</td>
	    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" id="zjhm"  value="${varMap.zjhm}" style="width:200px;" readonly="readonly" /></td>
	     </tr>		
	      <tr class="dialogTr"> 
	    	<td width="20%" class="dialogTd" align="right">原居住地址：</td>
	    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" name="yjzddz" id="yjzddz"  value="${varMap.yjzddz}"  style="width: 619px;" maxlength="50" readonly="readonly" /></td>	    	
	    </tr>	
	    
	     <tr class="dialogTr">
	    	<td width="40%" class="dialogTd" align="right">原居住管辖派出所：</td>
	    	<td width="10%" class="dialogTd">
	    	<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="ygxpcs"  value="${varMap.ygxpcsdm}"  value="" style="width:200px;" readonly="readonly"/>
	    		<input type="hidden" name="ygxpcsdm" id="ygxpcsdm" />	
	    	</td>
			<td width="40%" class="dialogTd" align="right">原居住管辖责任区：</td>
	    	<td width="10%" class="dialogTd">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxzrq" name="ygxzrq"  value="${varMap.ygxzrqdm}"  value="" style="width:200px;" readonly="readonly"/>
	    		<input type="hidden" name="ygxzrqdm" id="ygxzrqdm" />	
	    	</td>
	    </tr>
	    	
			
	    <tr class="dialogTr">	
	    	<td width="30%" class="dialogTd" align="right" id="cgrqText">转递发起时间：</td>
	    	<td width="20%" class="dialogTd"><input type="text" name="sqsj" id="sqsj" value="${varMap.sqsj}" class="easyui-validatebox inputreadonly" style="width: 200px;"  readonly="readonly" /></td>
    		<td width="30%" class="dialogTd" align="right">转递发起人：</td>
	    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="sqrName" id="sqrName" value="${varMap.sqrName}"  style="width:200px;" readonly="readonly" /></td>
	 
    	
    	</tr>
    	
    	 <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">现居住地址：</td>
	      	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" name="zddz" id="zddz" value="${varMap.zddz}"  style="width: 619px;" maxlength="50" readonly="readonly" /></td>	    	
  		</tr>
	    	
