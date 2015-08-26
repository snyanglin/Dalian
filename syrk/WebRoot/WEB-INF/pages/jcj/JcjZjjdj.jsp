<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>实有房屋录入</title>
</head>

<body style="margin-top:20px" class="bodybg">

<div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
		<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
		    <form action="<%=basePath%>jcj/saveZdjxx" id="dataForm" name="dataForm" method="post">
					<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
						 <tr class="dialogTr">
					<input type="hidden" id="pk" name="id" value="${entity.id}" />
		    	    <td width="20%" class="dialogTd" align="right">警情来源:</td>
				    <td width="30%" class="dialogTd">
				         <input class="easyui-combobox" type="text" id="jcjjjxxb.jjlxdm" name="jcjjjxxb.jjlxdm" style="width:200px;"  value="05" disabled="disabled"
							data-options="url: contextPath + '/common/dict/D_JCJ_JJLXDM.js',valueField:'id',textField:'text',method:'get',required:true,tipPosition:'left'" />
				    </td>
				     <td width="20%" class="dialogTd" align="right">报警方式:</td>
				    <td width="30%" class="dialogTd">
				         <input class="easyui-combobox" type="text" id="" name="jcjjjxxb.bjfsdm" style="width:200px;"  value="05" 
							data-options="url: contextPath + '/common/dict/D_JCJ_BJFSDM.js',valueField:'id',textField:'text',method:'get',required:true,tipPosition:'left'" />
				    </td>
			      </tr>
			      
			       <tr class="dialogTr">
		    	    <td width="20%" class="dialogTd" align="right">警情地址描述:</td>
				    <td width="30%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" data-options="required:true" name="jcjjjxxb.jqdzms" style="width:596px;"    maxlength="100"
							 />
				    </td>
			      </tr>
			      
			       <tr class="dialogTr">
		    	    <td width="20%" class="dialogTd" align="right">警情地址详址:</td>
				    <td width="30%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" data-options="required:true" name="jcjjjxxb.jqdzxz" style="width:596px;"    maxlength="100"
							 />
				    </td>
			      </tr>
    			
    			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">报警内容:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="cdclqk" name="jcjjjxxb.bjnr" style="width:596px; height:48px;"
						data-options="required:true,validType:['maxLength[100]'],invalidMessage:'报警内容不能超过100个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
    			
    			   <tr class="dialogTr">
		           <td width="20%" class="dialogTd" align="right">报警人姓名:</td>
				   <td width="30%" class="dialogTd"><input type="text" name="jcjjjxxb.bjr_xm" data-options="required:true" class="easyui-validatebox" style="width: 200px;"  value=""
							 data-options="required:false"/>
				   </td>
				          
				  <td width="20%" class="dialogTd" align="right">报警人性别:</td>
				    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="" name="jcjjjxxb.bjr_xbdm" style="width:200px;"  value="05" 
							data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',method:'get',required:true,tipPosition:'left'" />
				    </td>
			     </tr>
			     
			      <tr class="dialogTr">
		           <td width="20%" class="dialogTd" align="right">报警电话:</td>
				   <td width="30%" class="dialogTd"><input type="text" name="jcjjjxxb.bj_lxdh" id="" class="easyui-validatebox" style="width: 200px;"  value=""
							 data-options="required:false"/>
				   </td>
				          
				  <td width="20%" class="dialogTd" align="right">主叫姓名:</td>
				   <td width="30%" class="dialogTd"><input type="text" name="jcjjjxxb.bjdhyh_xm" id="" class="easyui-validatebox" style="width: 200px;"  value=""
							 data-options="required:false"/>
				   </td>
			     </tr>
			     
			    
			    
			    <tr class="dialogTr">
		           <td width="20%" class="dialogTd" align="right">报警时间:</td>
				   <td width="30%" class="dialogTd"><input type="text" name="jcjjjxxb.bj_sj" id="bj_sj" class="easyui-validatebox" style="width: 200px;"  value=""
							 data-options="required:true" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s'})"/>
				   </td>
				  
			   </tr>
			    
    			
    			<tr class="dialogTr">
		    	    <td width="20%" class="dialogTd" align="right">主叫地址:</td>
				    <td width="30%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text"  name="jcjjjxxb.bjdhyhdz" style="width:596px;"    maxlength="100"/>
				    </td>
			      </tr>
    			
    			
    			
    			
    			
    			
    			
    			<!-- 反馈信息 -->
	    		  <tr class="dialogTr">
		    	    <td width="20%" class="dialogTd" align="right">警情类别:</td>
				    <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jcjfkxxb.jqlbdm" name="jcjfkxxb.jqlbdm" style="width:200px;"  value=""
							data-options="required:true,panelWidth:280,url: contextPath + '/common/dict/D_JCJ_JQLBDM.js',multiple:false,method:'get',editable:true,lines:true" />
				    </td>
				    
		    	    <td width="20%" class="dialogTd" align="right">警情等级:</td>
				    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jqdjdm" name="jcjfkxxb.jqdjdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_JCJ_JQDJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'" />
				    </td>	    	
			   </tr>
		    		
		      <tr class="dialogTr">
		           <td width="20%" class="dialogTd" align="right">警情发生时间:</td>
				   <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.jqfs_sj" id="jqfs_sj" class="easyui-validatebox" style="width: 200px;"  value=""
							 data-options="required:true" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s'})"/>
				   </td>
				  
				   <td width="20%" class="dialogTd" align="right">警情结束时间:</td>
				   <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.jqjs_sj" id="jqjs_sj" class="easyui-validatebox" style="width: 200px;" value=""
							data-options="required:true" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'jqfs_sj\') || \'%y-%M-%d %h:%m:%s\'}'})"/>
				   </td>
			   </tr>
	    	
	    	
	    	 
	    	
	          <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">到达现场时间:</td>
			    	<td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.ddxc_sj" id="ddxc_sj" class="easyui-validatebox" style="width: 200px;"  value=""
							data-options="required:true" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'jqfs_sj\') || \'%y-%M-%d\'}'})"/>
				    </td>
				     
			    	<td width="20%" class="dialogTd" align="right">处理完毕时间:</td>
				    <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.clwb_sj" id="clwb_sj" class="easyui-validatebox" style="width: 200px;" value=""
							data-options="required:true" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'ddxc_sj\') || \'%y-%M-%d\'}'})"/>
				   </td>			    		
		    	</tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出警情况:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="cjqk" name="jcjfkxxb.cjqk" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[150]'],invalidMessage:'出警情况不能超过150个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
			    
			 
		    	    
	    	    </tr>
		    	 
		    	  <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">处理结果:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="cljg" name="jcjfkxxb.cljg" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[300]'],invalidMessage:'处理结果不能超过300个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
			     <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出动车辆情况:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="cdclqk" name="jcjfkxxb.cdclqk" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[100]'],invalidMessage:'出动车辆情况不能超过100个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
				
				    <tr class="dialogTr" >
				 <td width="20%" class="dialogTd" align="right">处理结果:</td>
				 <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cljgdm" name="jcjfkxxb.cljgdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_JCJ_CLJGDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'" />
				    </td>
				             
			   <td width="20%" class="dialogTd" align="right">警情状态: </td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jqztdm" name="jcjfkxxb.jqztdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_JCJ_JQZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'c'" />
               </td>
				
				  <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出动人员情况:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="cdryqk" name="jcjfkxxb.cdryqk" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[100]'],invalidMessage:'出动人员情况不能超过100个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
			    <tr class="dialogTr">
			    	
			    	<td width="20%" class="dialogTd" align="right">抓获人数: </td>
			    	<td width="30%" class="dialogTd">
			    	<input type="text" name="jcjfkxxb.zh_rs" id="zh_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>					
				    </td>
			    	 
					<td width="20%" class="dialogTd" align="right">涉案人数:</td>
			    	<td width="30%" class="dialogTd">
			    	 <input type="text" name="jcjfkxxb.sa_rs" id="sa_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			    	
				     </td>
			    </tr>
			    
			     <tr class="dialogTr">
			    	 
			    	<td width="20%" class="dialogTd" align="right">救助人数: </td>
			    	<td width="30%" class="dialogTd">
			    	<input type="text" name="jcjfkxxb.jz_rs" id="jz_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>					
				    </td>
			    	 
			    </tr>
			      <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">救助人数说明:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="jzrssm" name="jcjfkxxb.jzrssm" style="width:596px; height:48px;" value=""
						data-options="required:false,validType:['maxLength[100]'],invalidMessage:'救助人数说明不能超过100个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
			    
			     <tr class="dialogTr">
			        
			        <td width="20%" class="dialogTd" align="right">逃跑人数: </td>
			    	<td width="30%" class="dialogTd">
			    	 <input type="text" name="jcjfkxxb.jj_rf" id="jj_rf" class="easyui-validatebox" style="width: 200px;"   value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			    	
				     </td>
			         
	    	         <td width="20%" class="dialogTd" align="right">解救人数:</td>
			         <td width="30%" class="dialogTd">
                       <input type="text" name="jcjfkxxb.jj_rs" id="jj_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>
			     </td>
	    	   </tr>
			     <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">解救人数说明:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="jjrssm" name="jcjfkxxb.jjrssm" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[500]'],invalidMessage:'解救人数说明不能超过500个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
				
				
				  <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">死亡人数: </td>
			   <td width="30%" class="dialogTd">
			      <input type="text" name="jcjfkxxb.sw_rs" id="sw_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   
			   </td>
			    
			   <td width="20%" class="dialogTd" align="right">受伤人数:</td>
			  <td width="30%" class="dialogTd">
			      <input type="text" name="jcjfkxxb.ss_rs" id="ss_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   
			   </td>
			   </tr>
			   <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">受伤人数说明:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="ssrssm" name="jcjfkxxb.ssrssm" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[250]'],invalidMessage:'受伤人数说明不能超过250个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">死亡人数说明:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="swrssm" name="jcjfkxxb.swrssm" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[250]'],invalidMessage:'死亡人数说明不能超过500个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
			    
			   
			    <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">待救援人数: </td>
			   <td width="30%" class="dialogTd">
			      <input type="text" name="jcjfkxxb.djy_rs" id="djy_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   
			   </td>
			    
			   <td width="20%" class="dialogTd" align="right">出警受伤人数:</td>
			   <td width="30%" class="dialogTd">
			     <input type="text" name="jcjfkxxb.cjryss_rs" id="cjryss_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   
			  </td>
			   </tr>
			    <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">出警死亡人数:</td>
			   <td width="30%" class="dialogTd">
			    <input type="text" name="jcjfkxxb.cjrysw_rs" id="cjrysw_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   
			   </td>
			   </tr>
			     <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">经济损失: </td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="jjssqk" name="jcjfkxxb.jjssqk" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[250]'],invalidMessage:'经济损失不能超过250个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
				   <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">挽回经济损失:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="whjjssqk" name="jcjfkxxb.whjjssqk" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[250]'],invalidMessage:'挽回经济损失不能超过250个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
			   
			    <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">是否破获刑事案件:</td>
			    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfphxsaj" name="jcjfkxxb.sfphxsaj" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
				  </td>
			       
			   <td width="20%" class="dialogTd" align="right">是否查处治安案件:</td>
			    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfcczaaj" name="jcjfkxxb.sfcczaaj" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
				  </td>
			   </tr>
			    <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">是否解决纠纷:</td>
			  <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfjjjf" name="jcjfkxxb.sfjjjf" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
			        
			   <td width="20%" class="dialogTd" align="right">留置审查人数:</td>
			   <td width="30%" class="dialogTd">
			       <input type="text" name="jcjfkxxb.cjrysw_rs" id="cjrysw_rs" class="easyui-validatebox" style="width: 200px;"  value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>
			   </td>
			   </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">警情处理结果:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="jqcl_jg" name="jcjfkxxb.jqcl_jg" style="width:596px; height:48px;"
						data-options="required:true,validType:['maxLength[1000]'],invalidMessage:'警情处理结果不能超过1000个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">损失情况描述:</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="" name="jcjfkxxb.ssqkms" style="width:596px; height:48px;"
						data-options="required:false,validType:['maxLength[500]'],invalidMessage:'损失情况描述不能超过500个汉字，请重新输入！',tipPosition:'right'"></textarea>
					</td>
				</tr>
				<tr>
				   <td width="20%" class="dialogTd" align="right">天气:</td>
			  <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="tqdm" name="jcjfkxxb.tqdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_JCJ_TQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
			   </tr>
			    <tr class="dialogTr">
	            <td width="20%" class="dialogTd" align="right">火灾原因:</td>
			  <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="hzyydm" name="jcjfkxxb.hzyydm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_BZ_QHYYFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />

			        
			   <td width="20%" class="dialogTd" align="right">灾害事故类型:</td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zhsglxdm" name="jcjfkxxb.zhsglxdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_JCJ_HZCSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />

			   </tr>
			   
			   	<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">起火物:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id=" " name="qhwdm"
						style="width:200px;" value="${entity.hzyydm }"
						data-options="url: contextPath + '/common/dict/D_BZ_QHWFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
					<td width="20%" class="dialogTd" align="right">起火建筑结构:</td>
					<td width="30%" class="dialogTd"><input
						class="easyui-combobox" type="text" id="zhsglxdm" name="zhsglxdm"
						style="width:200px;" value="${entity.zhsglxdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_JZWJGLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
				</tr>
			   
			   
			   
			   
			   <tr class="dialogTr">
			   <td width="20%" class="dialogTd" align="right">火灾场所:</td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="hzcsdm" name="jcjfkxxb.hzcsdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_JCJ_HZCSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
			         
			    <td width="20%" class="dialogTd" align="right">火灾等级:</td>
			     <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="hzdjdm" name="jcjfkxxb.hzdjdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_JCJ_HZDJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'" />
				 </td>     
			   
			   </tr>
			   <tr class="dialogTr">
	          
			   
			   <td width="20%" class="dialogTd" align="right">第一出动时间:</td>
			   <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.dycd_sj" id="dycd_sj" class="easyui-validatebox" style="width: 200px;" value=""
						data-options="required:false" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s'})"/>
			   </td>
			         
			   <td width="20%" class="dialogTd" align="right">第一到场时间:</td>
			   <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.dydc_sj" id="dydc_sj" class="easyui-validatebox" style="width: 200px;" value=""
						data-options="required:false" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'dycd_sj\') || \'%y-%M-%d %H:%m:%s\'}'})"/>
			   </td>
			   </tr>
			   <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">火场扑灭时间:</td>
			   <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.hcpm_sj" id="hcpm_sj" class="easyui-validatebox" style="width: 200px;"  value=""
						 data-options="required:false" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'dydc_sj\') || \'%y-%M-%d %H:%m:%s\'}'})"/>
			   </td>
			          
			   <td width="20%" class="dialogTd" align="right">撤离时间:</td>
			   <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.cl_sj" id="cl_sj" class="easyui-validatebox" style="width: 200px;" value=""
						data-options="required:false" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d %H:%m:%s',minDate:'#F{$dp.$D(\'hcpm_sj\') || \'%y-%M-%d %H:%m:%s\'}'})"/>
			   </td>
			   </tr>
			    <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">现场总指挥:</td>
			   <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.xczzh" id="" class="easyui-validatebox" style="width: 200px;"  value=""
						 data-options="required:false"/>
			   </td>
			          
			   <td width="20%" class="dialogTd" align="right">出动水枪数:</td>
			   <td width="30%" class="dialogTd">
			   <input type="text" name="jcjfkxxb.cdsqs" id="cdsqs" class="easyui-validatebox" style="width: 200px;"  value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   </td>
			   </tr>
			   
			   
			    <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">是否重点单位:</td>   
			  <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfzddw" name="jcjfkxxb.sfzddw" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
               </td>
			         
			   <td width="20%" class="dialogTd" align="right">重点单位名称:</td>
			   <td width="30%" class="dialogTd"><input type="text" name="jcjfkxxb.zd_dwmc" id="zd_dwmc" class="easyui-validatebox" style="width: 200px;"  value=""
						data-options="required:false"/>
			   </td>
			   </tr>
			     <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">下落不明人数:</td>
			  <td width="30%" class="dialogTd">
			   <input type="text" name="jcjfkxxb.xlbm_rs" id="xlbm_rs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   
			   </td>
			         
			   <td width="20%" class="dialogTd" align="right">道路交通事故形态:</td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="dljtsgxtdm" name="jcjfkxxb.dljtsgxtdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_BZ_JTSGXTFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
               </td>
			   </tr>
			     <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">是否装载危险品:</td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfwhp" name="jcjfkxxb.sfwhp" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
               </td>
                     
			   <td width="20%" class="dialogTd" align="right">交通事故初查原因:</td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sgccyydm" name="jcjfkxxb.sgccyydm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_BZ_JTSGYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
               </td>
			   </tr>
			   
			   <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">能见度:</td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="njddm" name="jcjfkxxb.njddm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_JCJ_NJDDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
               </td>
			          
			   <td width="20%" class="dialogTd" align="right">道路路面状况:</td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="dllmzkdm" name="jcjfkxxb.dllmzkdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_BZ_DLLMZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
               </td>
			   </tr>
			   
			   
			       <tr class="dialogTr">
	          <td width="20%" class="dialogTd" align="right">损坏机动车数:</td>
			   <td width="30%" class="dialogTd">
			      <input type="text" name="jcjfkxxb.shjdcs" id="shjdcs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   
			   </td>
			    
			   <td width="20%" class="dialogTd" align="right">损坏非机动车数:</td>
			   <td width="30%" class="dialogTd">
			     <input type="text" name="jcjfkxxb.shfjdcs" id="shfjdcs" class="easyui-validatebox" style="width: 200px;"  maxlength="4" value=""
				               data-options="required:true,validType:['numeric[\'i\']']"/>			   
			  </td>
			   </tr>
			   
			    <tr class="dialogTr">
	           <td width="20%" class="dialogTd" align="right">道路类型:</td>
			   <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="dllxdm" name="jcjfkxxb.dllxdm" style="width:200px;"  value=""
							data-options="url: contextPath + '/common/dict/D_BZ_DLLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'center'" />
               </td>
			   </tr>
						
						
						
						
			 </table>
		    </form>
		</div>
		<div style="height:6px;font-size:1px;"></div>

		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
			<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;
			<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="exit_onclick();">取消</a>
		</div>
		</div>
	    </div>
	    </div>
    	</td></tr></table>
</div>
</body>

</html>
<script type="text/javascript" >
$(document).ready(function(){
	$("#saveBotton").bind("click",function() {
		if ($("#dataForm").form('validate')) {
			var bottonObject = this;
			if (buttonDisabled(bottonObject) == false) {
				return false;
			}	
			topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
				if (r) {
					var formObject = $("#dataForm");
					formObject.form('submit',{
						dataType : 'json',
						onSubmit: function() {
						},
						success: function(result) {
							buttonEnabled(bottonObject);
							result = parseReturn(result);
							if (result.status == 'success') { // 返回成功后执行的方法
								exit_onclick();
								var editUrl = "/jcj?id="+result.saveID+"&sfcx=0";
								menu_open("接处警－详情",editUrl);
							}
							else {
								topMessager.alert(MESSAGER_TITLE, result.message, 'error');
							}
						}
					});			
				}
				else {
					buttonEnabled(bottonObject);
				}
			});
		}
	});
});

function exit_onclick() {
	closeSelf();
}
function doInit(paramArray) {
	
}

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
</script>