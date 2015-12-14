<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>社区警务统计</title>
  </head>
  <body class="easyui-layout" style="overflow: hidden;height:100%;">
      <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
			<form id="queryForm">
				<table cellspacing="0" cellpadding="0" border="0" style="padding: 5px;">					
				  <tbody>
					    <tr class="dialogTr">
							<td class="dialogTd" style="width:90px" align="right">管辖分(县)局：</td>
						    <td class="dialogTd" style="width:140px" align="right">
								 <input type="text" name="gxsxj" id ="gxsxj" class="easyui-combobox"
							            data-options="valueField:'id',textField:'text',method:'get',selectOnNavigation:false,isTopLoad:false,
							                          url:contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',
							            			  onChange:function(newValue, oldValue){var parentOrgCode = $('#gxsxj').combobox('getValue');
							                                  if(parentOrgCode==''){
							                                 	 $('#gxpcs').combobox('loadData',[]);
							                                 	 $('#gxzrq').combobox('loadData',[]);
							                                  }else{
							                                  	 var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode='+parentOrgCode;
							                                  	 $('#gxpcs').combobox('reload', url);
							                                  }}" style="width:140px;"/>
						    </td>
						    <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						    <td class="dialogTd" style="width:85px;" align="right">管辖派出所：</td>
							<td class="dialogTd" style="width:140px;" align="right"> 
							     <input type="text" name='gxpcs' id="gxpcs" class="easyui-combobox"
							            data-options="valueField:'id',textField:'text',method:'get',selectOnNavigation:false,isTopLoad:false,
						         					  onChange:function(newValue, oldValue){var parentOrgCode = $('#gxpcs').combobox('getValue');
						         		                       if(parentOrgCode==''){
						         		                          $('#gxzrq').combobox('loadData', []);
						         		                       }else{
						         		                         var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=50&parentOrgCode='+parentOrgCode;    
			   													 $('#gxzrq').combobox('reload', url);
						         		                       }}" style="width:140px;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" style="width:85px;" align="right">管辖责任区：</td>
							<td class="dialogTd" style="width:140px;" align="right"> 
							 <input type="text" id="gxzrq" name="gxzrq" class="easyui-combobox" data-options="valueField:'id',textField:'text',method:'get',selectOnNavigation:false,isTopLoad:false" style="width:140px;"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd">
								<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >统计</a>
								<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
							</td>
						 </tr>
					</tbody>
				</table>
			</form>
			<hr>
			<iframe id="iframe" src="" width="100%" height="90%" frameborder="0"></iframe>
    </div>
	<script type="text/javascript">
	var msgObj;
	var bgObj;
	$(document).ready(function(){

		queryButton();
	    $("#iframe").on("load",function(){
			$(document.body).unmask(); 
		});
	});
		function clearCase(){
		
		  $("#queryForm").form("reset");
		}
		
		function queryButton(){
		
			var fj = "0";
			var pcs = "0";
			var zrq = "0";
			
			mask();
			if($("#gxsxj").val()!=""){
				fj=$("#gxsxj").val();
			}
			if($("#gxpcs").val()!=""){
				pcs=$("#gxpcs").val();
			}
			if($("#gxzrq").val()!=""){
				zrq=$("#gxzrq").val();
			}
			if (fj=="210200000000") {
					fj="0";
					pcs="0";
					zrq = "0";
			}
			var zzjglx;
			if (fj=="0" && pcs=="0"){zzjglx=11;}
			if (fj!="0" && pcs=="0"){zzjglx=12;}
			if (fj!="0" && pcs!="0"){zzjglx=13;}
			
			var url ="<%=contextPath%>/ReportEmitter?rpt=YXSJTJB.brt&params=";
			url = url+"ORG_FJ="+fj+";ORG_PCS="+pcs+";ORG_ZRQ="+zrq+";zzjglx="+zzjglx;
			
			iframe.window.location.href=url;
		}
		
		//打开实有人口页面
		function opensyrk(){
		     menu_open("人口核实进度","/forward/tjbb|syrktj");
		}
		
		//打开实有单位统计页面
		function opensydw(){
		     menu_open("实有单位统计","/forward/tjbb|sydwtj");
		}
		//打开实有房屋统计页面
		function opensyfw(){
		     menu_open("实有房屋统计","/forward/tjbb|syfwtj");
		}
		//打开出租房屋统计页面
		function openczfw(){
		     menu_open("出租房屋统计","/forward/tjbb|czfwtj");
		}
		//打开层户地址统计页面
		function openchdz(){
		     menu_open("层户地址统计","/forward/tjbb|BZDZ_CH");
		}
		//打开门楼地址统计页面
		function openmldz(){
		     menu_open("门楼地址统计","/forward/tjbb|BZDZ_MLP");
		}
		
		function mask(){
			$(document.body).mask("正在加载，很快就好，请稍等...");
		}

	</script>
  </body>
</html>