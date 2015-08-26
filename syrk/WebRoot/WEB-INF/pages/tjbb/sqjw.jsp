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
				<table cellspacing="0" cellpadding="0" border="0" width="1000px" style="padding: 10px;" >
					<tbody>
					   <tr>
							<td class="toolbarTd" style="width:220px" align="left">
								&nbsp;&nbsp;&nbsp;分  局：<input id="cc1" class="easyui-combobox" value="210200000000"
							         data-options="valueField: 'id',textField: 'text',width:140,url: '<%=basePath %>gzjk/queryOrg',onSelect: function(rec){var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#cc2').combobox('reload', url);}"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:190px" align="left">
								派出所：<input id="cc2" class="easyui-combobox"
							data-options="valueField:'id', width:140, textField:'text',onSelect: function(rec1){var url = '<%=basePath %>gzjk/queryOrgLowest?orgCode='+rec1.id;$('#cc3').combobox('reload',url);}" />
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:190px" align="left">
								责任区：<input id="cc3" class="easyui-combobox"
							data-options="valueField:'id', width:140, textField:'text'" />
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
			if($("#cc1").val()!=""){
				fj=$("#cc1").val();
			}
			if($("#cc2").val()!=""){
				pcs=$("#cc2").val();
			}
			if($("#cc3").val()!=""){
				zrq=$("#cc3").val();
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