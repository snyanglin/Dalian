<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>视频建设简要单位</title>

</head>
  
<body style="margin-top:20px" class="bodybg">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    			<form  id="spjsdwUpdateForm" name="spjsdwUpdateForm" >
					<!-- 表示新增还是修改 -->
					<input type="hidden" name="dwbm" id="dwbm" value="${entity.dwbm}" />
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
				    	<td width="80%"  colspan="3" class="dialogTd">
				    		<input class='easyui-validatebox'   type='text' id="dwmc" name='dwmc' value="${entity.dwmc}" style="width:200px;"  
		    	        	readonly="readonly"/>
		    	        </td>
	    	        
	    	      </tr>

  	      
		 		<tr class="dialogTr">
					    	<td width="20%" class="dialogTd" align="right">单位标准地址：</td>
					    	<td width="80%" colspan="3" class="dialogTd" >
						    	<input class="easyui-validatebox" type='text'  value="${entity.dz_dwdzdm}" id="jzrk_fzdz1" style="width:380px;"  readonly="readonly">
						    	
					    	</td>
					    	
		   	       </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">单位地址(全地址)：</td>
				    	<td width="80%" colspan="3" class="dialogTd" >
				    		<input class='easyui-validatebox' type='text' id="dwdz" name='dwdz' value="${entity.dwdz}" style="width:96%;"  maxlength="130" 
		    	        	readonly="readonly"/>
		    	        </td>		    	        
	    	      </tr>	  		

	    	          	      
	    	      	

	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">业主姓名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="yzxm" name='yzxm'  value="${entity.yzxm}" style="width:50%;"  maxlength="50"
		    	        		readonly="readonly"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">业主手机：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="yzphone" name='yzphone'  value="${entity.yzphone}" style="width:50%;"  maxlength="50"
		    	        		readonly="readonly"/>
		    	        </td>		    	        
	    	      </tr>	    	      
	    	      
	    	      <tr class="dialogTr">

				    	<td width="20%" class="dialogTd" align="right">业主座机：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="yzzj" name='yzzj'  value="${entity.yzzj}" style="width:200px;"  maxlength="50"
		    	        		readonly="readonly"/>
		    	        </td>
		    	        <td width="20%" class="dialogTd" align="right">业主身份证号：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox'  type='text' id="yzsfzh" name='yzsfzh'  value="${entity.yzsfzh}" style="width:200px;"  maxlength="50"
		    	        		readonly="readonly"/>
		    	        </td>	
	    	      </tr>	  	    	      


	    	      	    	      
    			</form>
	    		</table>
			</div>
			
				
		</div>
	    </div>
	    </div>
	    
	    </table>	    
</div>



</body>
</html>