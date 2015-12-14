<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <base href="<%=basePath%>"/>
    <title>交通态势</title>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>   
	<script type="text/javascript"  src="project/zhdd/js/zjj.js"></script>
	<!-- 交通态势 -->
	<script type="text/javascript"  src="common/components/resource/js/jtts.js"></script>
  </head>
  <body id="body_jtts">
  <form>
   <div id="scroll_main_jtts">
		<div id="scroll_content_jtts" style="height:100%">      
		<div class="rtcontpadding" style="height:100%"> 
		
 	    <div  id="body_jtts_table" >
			<div class=rt_titleb>
			<div  id="jttsTableSslk" class="jttstable jttstable_on" onclick="jtts.changeModel(this)"><a class="btnab btnab_onb" href="javascript:void(0);" title="实时路况" onfocus="undefined">实时路况</a></div>
			<div  class="jttstable " onclick="jtts.changeModel(this)"><a  class="btnab" href="javascript:void(0);" title="路况预测" onfocus="undefined">路况预测</a></div>
			<div  id="jttsTableLkbj" class="jttstable" onclick="jtts.changeModel(this)"><a  class="btnab" href="javascript:void(0);" title="路况报警" onfocus="undefined">路况报警</a></div>
			</div>
			<div class="rt_title"><strong>示意图标</strong></div>
			<div style="padding:10px 1px">
				<div class="rtjbdiv" style="border-bottom:solid 3px #17bf00">畅通</div>
				<div class="rtjbdiv" style="border-bottom:solid 3px #ff9f19">缓行</div>
				<div class="rtjbdiv" style="border-bottom:solid 3px #f23030">拥堵</div>
				<div class="rtjbdiv" style="border-bottom:solid 3px #bb0000">严重拥堵</div>
			</div>
	 		<!-- 实时路况  start-->
	 		<div id="jtts_sslk">
	 			<div class="rt_title"><strong>实时路况更新</strong></div>
	 			<div id="jtts_sslk_sx"><!-- 实时路况刷新 -->
	 			 	<table cellpadding="0" cellspacing="0" border="0">
	 			 		<tr>
	 			 			<td width="52"><input type="checkbox"  id="jtts_sslk_sx_zt_ct" checked="checked" onclick="jtts.sslkSx();" name="jtts_sslk_sx_zt"  value="1"/>畅通</td>
	 			 			<td width="52"><input type="checkbox"  id="jtts_sslk_sx_zt_hx" checked="checked" onclick="jtts.sslkSx();" name="jtts_sslk_sx_zt" value="2"/>缓行</td>
	 			 			<td width="52"><input type="checkbox"  id="jtts_sslk_sx_zt_yd" checked="checked" onclick="jtts.sslkSx();" name="jtts_sslk_sx_zt" value="3"/>拥堵</td>
	 			 			<td width="86"><input type="checkbox"  id="jtts_sslk_sx_zt_yzyd" checked="checked" onclick="jtts.sslkSx();" name="jtts_sslk_sx_zt" value="4"/> 严重拥堵</td>
	 			 		</tr>
	 			 		<tr><td style="padding-left:55px" colspan=4><span>更新时间：</span><span id="jtts_sslk_sx_gxsj"></span><a class="refreshgif" id="jtts_sslk_sx_cz" onclick="jtts.sslkSx();"></a><!-- 刷新按钮 --></td></tr>
	 			 	</table>
	 			</div>
	 			<div class="rt_title"><strong>实时路况统计</strong></div>
	 			<div id="jtts_sslk_tj"></div><!-- 实时路况统计 -->
		 	   <!-- 实时路况查询 start -->
		 		<div class="rt_title"><strong>实时路况查询</strong></div>
			    <div id="jtts_cxtj"><!-- 查询条件 -->
			    	<table>
			    		<tr>
			    			<td rowspan=2><span>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</span></td>
			    			<td><input type="checkbox"  id="jtts_sslk_sx_zt_ct_cx1"  name="jtts_sslk_sx_zt"  value="1"/>畅通</td>
			    			<td><input type="checkbox"  id="jtts_sslk_sx_zt_hx_cx1"  name="jtts_sslk_sx_zt" value="2"/>缓行</td>
			    		</tr>
			    		<tr>
			    			<td><input type="checkbox"  id="jtts_sslk_sx_zt_yd_cx1"  name="jtts_sslk_sx_zt" value="3"/>拥堵</td>
			    			<td><input type="checkbox"  id="jtts_sslk_sx_zt_yzyd_cx1"  name="jtts_sslk_sx_zt" value="4"/> 严重拥堵</td>
			    		</tr>
			    		<tr>
			    			<td><span>路段名称：</span></td>
			    			<td colspan=2><input class="all_inputtext" style="width:170px;" type="text"  id="jtts_ldmc"/></td>
			    		</tr>
			    		<tr>
			    			<td colspan=3><a class="btnab btnabc" style="left:5%;"   href="javascript:void(0);" onclick="jtts.queryJtts();">查询</a>
			    			<a class="btnab btnabc"  href="javascript:void(0);" onclick="jtts.resetJtts(); ">重置</a></td>
			    		</tr>
			    	</table>
			     </div>
			   	<!-- 实时路况查询 end-->
	 	    </div>
 		</div>                        
		<!-- 实时路况  end-->
		<!-- 路况预测  start-->
 		<div id="jtts_lkyc">
 			<div class="rt_title"><strong>路况预测时间轴</strong></div>
 			<div class="lkyc_content">
 				<div class="lkyc_xq_time">
 					<span class="lkyc_xq">星期三</span>
 					<span class="lkyc_time">12:00</span>
 				</div>
 				<table class="lkyc_time_chose">
 					<tr>
 						<td width="80">星期</td>
 						<td><span style="width:25px;height:25px">一</span></td>
 						<td><span>二</span></td>
 						<td><span>三</span></td>
 						<td><span>四</span></td>
 						<td><span>五</span></td>
 						<td><span>六</span></td>
 						<td><span>日</span></td>
 					</tr>
 					<tr>
 						<td>时间</td>
 						<td colspan=7>
 							<!--  <div >
								<input class="easyui-slider" style="width:200px;" 
								data-options="showTip:true,rule: ['|',6,'|',12,'|',18,'|'],min:0,max:24,step:.25"/>
							</div>-->
							<div id="ss" style="width:200px"></div> 
 						</td>
 					</tr>
 				</table>
 			</div>
 			<div class="lkyc_xq_time" style="margin:30px 0 0 20px;"><span>(基于历史路况统计预测  仅供参考)</span></div>
 			<div class="rt_title"><strong>路况预测查询</strong></div>
 			<div class="lkycLdcxSr" id="lkycLdcxSr">路段名称：<input type='hidden' id='lkycLddm'/><input type='text' class='all_slect' style='width:180px;' id='lkycLdmc'/><a class="btnab">查询</a></div>
 			<div class="lkycLdcxJg" id="lkycLdcxJgUl">
 				<ul id="lkycLdcxJg"></ul>
 			</div>
 		</div>
 		<!-- 路况预测  end-->
 		<!-- 路况报警 start-->
 		<div id="jtts_lkbj" >
 			<div class="rt_title"><strong>路况报警条件设置</strong></div>
 			<table cellpadding="0" cellspacing="0" border="0" style="margin:0;padding:0;left:0;">
 				<tr>
 					<td rowspan=2 style="width:60px;"><span>报警状态：</span></td>
 					<td><input  type="checkbox"  id="jtts_lkbj_zt_ct"  name="jtts_lkbj_zt"  value="1"/>畅通</td>
 					<td><input  type="checkbox"  id="jtts_lkbj_zt_hx"  name="jtts_lkbj_zt" value="2"/>缓行</td>
 				</tr>
 				<tr>
 					<td><input  type="checkbox"  id="jtts_lkbj_zt_yd"  name="jtts_lkbj_zt" value="3"/>拥堵</td>
 					<td><input  type="checkbox"  id="jtts_lkbj_zt_yzyd"  name="jtts_lkbj_zt" value="4"/>严重拥堵</td>
 				</tr>
 				<tr>
 					<td><span>报警时段：</span></td>
 					<td colspan=2>
 					<input id="jtts_lkbj_kssj" class="all_slect " style="width:70px;" onclick="WdatePicker({dateFmt:'HH:mm',readOnly:true})"/><!-- start time -->
 					<span>&nbsp;至&nbsp;</span>
 					<input id="jtts_lkbj_jssj" class="all_slect" style="width:70px;" onclick="WdatePicker({dateFmt:'HH:mm',readOnly:true})"/><!-- end time -->
 					</td>
 				</tr>
 				<tr>
 					<td colspan=3><a style="position:relative;left:-5px" class="btnab" onclick="jtts.lkbjSz();"title="确定">确定</a>
 					<a style="position:relative;left:-5px" class="btnab" onclick="jtts.resetJtts();" title="重置">重置</a></td>
 				</tr>
 			</table>
 			<div class="rt_title" style="margin-top:0;"><strong>报警路段详情查看</strong><input type="hidden" id="lbkjxqckRadioMemory"/></div>
 			<div class="jtts_lkbj_xqck_cx">
 				<ul>
 					<li><label for="jttsLkbjXqckCx0"><input type="radio" checked="checked" id="jttsLkbjXqckCx0" name="jttsLkbjXqckCx" onclick="jtts.queryLdxxByflowlevel(0);"/>全部</label></li>
 				</ul>
 			</div>
 			<div id="jtts_lkbj_pagination" style="clear:left;"></div><!-- 分页 -->
	 		<div id="jtts_lkbj_content">
		   		 <div id="jtts_lkbj_result"></div><!-- 查询结果-->  
	   		</div>
 		</div>
 		<!-- 路况报警 end-->
 	    <div id="jjts_cxzs"><!-- 查询结果展示 -->
 		<div id="jtts_result_title" class="cxjg_title"><!-- 查询结果表头 -->
 			<span class="backspan"></span>
 			<span><a class="backbtn" onclick="jtts.showSeachResult(true);jtts.sslkSx();jtts.sslkSxsj();jtts.resetJtts();">返回</a></span>
 		</div>
 		<div id="jtts_result_cx_show">
 			<table>
		    		<tr>
		    			<td rowspan=2><span>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</span></td>
		    			<td><input type="checkbox"  id="jtts_sslk_sx_zt_ct_cx"  name="jtts_sslk_sx_zt"  value="1"/>畅通</td>
		    			<td><input type="checkbox"  id="jtts_sslk_sx_zt_hx_cx"  name="jtts_sslk_sx_zt" value="2"/>缓行</td>
		    		</tr>
		    		<tr>
		    			<td><input type="checkbox"  id="jtts_sslk_sx_zt_yd_cx"  name="jtts_sslk_sx_zt" value="3"/>拥堵</td>
		    			<td><input type="checkbox"  id="jtts_sslk_sx_zt_yzyd_cx"  name="jtts_sslk_sx_zt" value="4"/> 严重拥堵</td>
		    		</tr>
		    		<tr>
		    			<td><span>路段名称：</span></td>
		    			<td colspan=2><input class="all_inputtext" type="text"  id="jtts_ldmc_cx"/></td>
		    		</tr>
		    		<tr>
		    			<td colspan=3><a class="btnab btnabc"   href="javascript:void(0);" onclick="jtts.queryJttsMb();">查询</a>
		    			<a class="btnab btnabc"  href="javascript:void(0);" onclick="jtts.resetJtts(); ">重置</a></td>
		    		</tr>
		    	</table>
 		</div>
 		<div class="rt_title"><strong>实时路况查询结果</strong></div>
	 	<div id="jtts_pagination"></div><!-- 分页 -->
	 	<div id="jtts_cxzs_content">
		    <div id="jtts_result"></div><!-- 查询结果-->  
	    </div>
 	</div>
 	<!-- 历史路况展示 -->
 	<div id="jtts_lslk">
 		<div id="jtts_lslk_title" class="cxjg_title"><!-- 历史路况表头 -->
 			<span class="backspan"></span>
 			<span><a class="backbtn" href="javascript:void(0);" onclick="jtts.lslkback();">返回</a><strong >当日路况</strong></span >
 		</div>
 		<div id="jtts_lslk_content_div">
 			<div id="jtts_lslk_content"></div>
 		</div>
 	</div>
 </form>
			</div> 
		</div>
	</div>
  <script type="text/javascript" >
	 $(document).ready(function() { 	     //初始化实时路况
 	    jjtsInit.sslkInit();
		ScrollBarTool.init("scroll_main_jtts", "scroll_content_jtts",0); 
		$(window).resize(ScrollBarTool.debounce(function() {
			ScrollBarTool.init("scroll_main_jtts", "scroll_content_jtts",0, true); 
		}, 500));
     });	
 </script>
 </body>
</html>
