<%@ page language="java" pageEncoding="UTF-8"%>

<%String multiVideoInfo = request.getParameter("multiVideoInfo") ;%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>视频监控</title>
    <!-- 系统全局配置类 -->
	<script type="text/javascript" src="../../../common/config/SysConfig.js"></script>
	<script language="text/javascript" type="text/javascript" src="js/MegaWebPlayer.js"></script>
	<script language="text/javascript" type="text/javascript" src="js/videomod.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/config.js"></script>
	<SCRIPT LANGUAGE=javascript FOR=MegaWebPlayer EVENT='OnChangeFocus(nFocusWnd)'>
		nowFocus = nFocusWnd;
	</SCRIPT>	
	<script type="text/javascript">
		var multiVideoInfo = "<%=multiVideoInfo%>";
		window.onload = function(){
			var vm = new videomod();
			vm.videoPlay(multiVideoInfo);
		};
	</script>
	<link rel="stylesheet" type="text/css" href="css/spStyle.css">
	<style>
	.label {
		width:85px;
		width:30%;
	    color: #00326A;
	    font: 12px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	    margin-top:3px;
	}
	</style>
	
<body bgcolor="D8E9EC" onunload="stopPlayVideo();" style="border:none;margin:0px;">
<table border="1" id="spjkTab" cellpadding="0" cellspacing="0">
  <tr>
	    <td >
	    	<table>
	    		<tr>
	    			<td align="center">
							<table width="96" border="0"  cellpadding="0" cellspacing="0" >
								<tr>
									  <td width="33%" height="30"> 
									    <div align="center"><img id="leftup" src="images/leftup.gif" class="baw" width="30" height="30"/></div>
									  </td>
									  <td width="34%" height="30"> 
									    <div align="center"><img id="up" src="images/up.gif" class="baw" width="36" height="30" onclick="OnUp();"  style="cursor:hand" title="向上"/></div>
									  </td>
									  <td width="33%" height="30"> 
									    <div align="center"><img id="rightup" src="images/rightup.gif" class="baw" width="30" height="30"/></div>
									  </td>
								</tr>
								<tr>
									  <td width="33%" height="30"> 
									    <div align="center"><img id="left" src="images/left.gif" width="30" height="38" onclick="OnLeft();" style="cursor:hand" title="向左"/></div>
									  </td>
									  <td width="34%" height="30"> 
									    <div align="center"><b><span id="disInfo" name="disInfo" style="color:red"></span></b></div>
									  </td>
									  <td width="33%" height="30"> 
									    <div align="center"><img id="right" src="images/right.gif" class="baw" width="30" height="38" onclick="OnRight();"  style="cursor:hand" title="向右"/></div>
									  </td>
								</tr>
								<tr>
									  <td width="33%" height="30"> 
									    <div align="center"><img id="leftdown" src="images/leftdown.gif" class="baw" width="30" height="30"/></div>
									  </td>
									  <td width="34%" height="30"> 
									    <div align="center"><img id="down" src="images/down.gif" class="baw" width="36" height="30" onclick="OnDown();" style="cursor:hand" title="向下"/></div>
									  </td>
									  <td width="33%" height="30"> 
									    <div align="center"><img id="rightdown" src="images/rightdown.gif" class="baw" width="30" height="30"/></div>
									  </td>
				        </tr>
			       </table>			
	    			</td>
	    		</tr>
	        <tr>	        	
	        </tr>
	        
	        <tr>
   	<td>
	        		     <div>
		<table border=0>
			<tr>
				<td>
					<!--<img src="images/qh.jpg" class="baw" onclick="video_switchscreen();" style="cursor:hand" title="切换"/>&nbsp;&nbsp;-->
					<!-- <img src="images/qp.jpg" class="baw" onclick="video_fullscreen();" style="cursor:hand" title="全屏"/> -->
					<!-- <img src="images/1fp.jpg" class="baw" onclick="video_screen1();" style="cursor:hand" title="一分屏"/> -->
					<!-- <img src="images/ss.jpg" class="baw" onclick="realTime();" style="cursor:hand" title="实时"/> -->
				</td>
			</tr>			
			<!-- <tr>
				<td>
					<img src="images/tz.jpg" class="baw" onclick="video_stop();" style="cursor:hand" title="停止"/>
					<img src="images/tzsy.jpg" class="baw" onclick="video_stopall();" style="cursor:hand" title="停止所有"/>
					<img src="images/zt.jpg" class="baw" onclick="video_pause();" style="cursor:hand" title="暂停"/>
					
				</td>
			</tr>		 -->	
			<tr>
				<td>	
					<!--<img src="images/9fp.jpg" class="baw" onclick="video_screen9();" style="cursor:hand" title="九分屏"/>&nbsp;&nbsp;-->
					<img src="images/tj.jpg" class="baw" onclick="OnNear();" style="cursor:hand" title="推近"/>
					<img src="images/ly.jpg" class="baw" onclick="OnFar();"  style="cursor:hand" title="拉远"/>
					<img src="images/zhuatu.jpg" class="baw" onclick="video_cap();" style="cursor:hand" title="抓图"/>
				</td>
			</tr>			
			<!-- <tr>
				<td>
					<img src="images/kf.jpg" class="baw" onclick="video_fast();" style="cursor:hand" title="快放"/>
					<img src="images/mf.jpg" class="baw" onclick="video_slow();" style="cursor:hand" title="慢放"/>
				</td>
			</tr> -->
		</table>
		</div>
	        		</td>
  </tr>
	        
	        <!-- <tr>
	        	<td>
	        		   <div id="historyListDiv">
			<table border=0>
				<tr>
					<td width="230" class="label">历史视频查询：</td>
				</tr>
				<tr>
					<td class="label">开始时间：<input type="text" id="startTimeTxt" class="Wdate" size="15" onFocus="new WdatePicker(this,'%Y-%M-%D %h:%m:%s',true,'default')" /></td>
				</tr>
				<tr>
					<td class="label">结束时间：<input type="text" id="endTimeTxt" class="Wdate" size="15"  onFocus="new WdatePicker(this,'%Y-%M-%D %h:%m:%s',true,'default')" /></td>
				</tr>
				<tr>
					<td class="label">
						<INPUT TYPE=button ID=btnSelect VALUE="保存路径" onClick="video_selectpath();">
						<input type="button" id="queryHisBtn" onclick="getSETime();" value="查询历史视频"/>
					</td>
				</tr>
 			</table>
      </div>
	        	</td>
	        </tr> -->
	      </table>
	    </td>
	    <td id="tdOcx" align="center" rowspan="3">
		      <OBJECT ID="MegaWebPlayer" CLASSID="CLSID:9581374A-C188-4980-B6D5-2AE4318F694A" style="width: 640px; height: 480px">
			    <!-- <param name="HistoryMode" value="0"/> -->
		      </OBJECT>
	    </td>
   </tr>
</table>
</body>
</html>
