<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>监控系统简要信息</title>
</head>
<body style="margin-top:20px" class="bodybg">
	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
	    	  <div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
	    		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    			<form  id="spjkxtUpdateForm" name="spjkxtUpdateForm">
					<input type="hidden" name="xh" id="xh" value="${entity.xh}" />
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">视频监控系统名称：</td>
				    	<td width="30%" colspan="3" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="xtmc" name='xtmc' value="${entity.xtmc}" style="width:200px;"  maxlength="30"
		    	        	readonly="readonly"/>
		    	        </td>		    	        
	    	      </tr>
	    	      
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">用户名：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="xtyhm" name='xtyhm' value="${entity.xtyhm}"  style="width:200px;"  maxlength="20"
		    	        readonly="readonly"/></td>
				    	<td width="20%" class="dialogTd" align="right">系统密码：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="xtmm" name='xtmm'  value="${entity.xtmm}" style="width:200px;"  maxlength="50"
		    	        readonly="readonly"/></td>	    	      
	    	      
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">录像最大保存天数：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="ccsc" name='ccsc'  value="${entity.ccsc}" style="width:200px;"  maxlength="50"
		    	        readonly="readonly"/></td>	    	      
				    		    	      
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">所连平台厂商：</td>
				    	<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="ptcs" name='ptcs'  value="${entity.ptcs}" style="width:200px;"  maxlength="50"
		    	        readonly="readonly"/></td>
					<td width="20%" class="dialogTd" align="right">建设时间：</td>
				    	<td width="30%" class="dialogTd">
						<input type="text" name="jssj" id="jssj" value="${entity.jssj}" class="easyui-validatebox "   style="width:200px;"
						readonly="readonly" /></td>
		    	        </td>	    	      
	    	      </tr>	 
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">开机时间：</td>
				    	<td>
							<input type="text" name="kjsj" id="kjsj" value="${entity.kjsj}" class="easyui-validatebox "   style="width:200px;" readonly="readonly" /></td>
						</td>
				    	<td width="20%" class="dialogTd" align="right">关机时间：</td>
				    	<td>
							<input type="text" name="gjsj" id="gjsj" value="${entity.gjsj}" class="easyui-validatebox "   style="width:200px;" readonly="readonly"/></td>
						</td>						
	    	      </tr>
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">技术人员姓名：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="jsryxm" name='jsryxm'  value="${entity.jsryxm}" style="width:200px;"  maxlength="50"
		    	        		readonly="readonly"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">技术人员身份证号：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="jsrysfzh" name='jsrysfzh'  value="${entity.jsrysfzh}" style="width:200px;"  maxlength="50"
		    	        		readonly="readonly"/>
		    	        </td>		    	        
	    	      </tr>	    	      
	    	      
	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">技术人员手机：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="jsryphone" name='jsryphone'  value="${entity.jsryphone}" style="width:200px;"  maxlength="50"
		    	        		readonly="readonly"/>
		    	        </td>
				    	<td width="20%" class="dialogTd" align="right">技术人员座机：</td>
				    	<td width="30%" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="jsryzj" name='jsryzj'  value="${entity.jsryzj}" style="width:200px;"  maxlength="50"
		    	        		readonly="readonly"/>
		    	        </td>		    	        
	    	      </tr>	  	    	      

	    	      <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">拷贝方式：</td>
				    	<td width="80%"  colspan="3" class="dialogTd">
				    		<input class='easyui-validatebox' type='text' id="copyfsFromDB" name="copyfsFromDB" value="${entity.copyfs}" style="width:96%;"  maxlength="50"
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
