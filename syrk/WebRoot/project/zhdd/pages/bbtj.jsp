<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${basePath}" />
<title>报表统计</title>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
</head>
<body>
<div id="zhdd_bbtj_div" style="height:100%;">

	<div id="zhdd_bbtj_query" >
		<dl class="tips_showdl" id="zhdd_bbtj_jq_dl">
            <dd>
		  <!-- 查询条件 -->
		  <input id="jjxx_bbtj_jgdm" class="all_inputtext"   type="hidden"/>
			<ul class="jczy_jczy_ul" style="padding:10px 0 0;">
			
			<li>统计周期：          <input type="radio" name="zhddfxzq" value="5" onclick="bbtj.changeFxzq(this.value);"/>年
          					<input type="radio" name="zhddfxzq" value="4" onclick="bbtj.changeFxzq(this.value);"/>季
          					<input type="radio" name="zhddfxzq" value="3" onclick="bbtj.changeFxzq(this.value);"/>月
          					<input type="radio" name="zhddfxzq" value="2" onclick="bbtj.changeFxzq(this.value);"/>周
          					<input type="radio" name="zhddfxzq" value="1" onclick="bbtj.changeFxzq(this.value);"/>自定义
          	</li>
          	<!-- <li id="yjfxzqsj"></li> -->
          	<li class="lidatetime">
          	<input id="year_dm" type="hidden" style="width:104px;" /><input id="year_mc" type="text" class="all_slect" style="width:104px;margin:0 10px 0 0;" /><input id="quarter_dm" type="hidden" style="width:104px" /><input id="quarter_mc" type="text" class="all_slect" style="width:104px" /><input id="month_dm" type="hidden" style="width:104px" /><input id="month_mc" type="text" class="all_slect" style="width:104px" /><input id="week_dm" type="hidden" style="width:104px" /><input id="week_mc" type="text" class="all_slect" style="width:104px" />
				 <span id="zdyday_q" style="float: left;">起：</span><input id="zdyday_s" class="all_slect" type="text" style="width:125px"  />
				 <span id="zdyday_z">&nbsp;止：</span><input id="zdyday_e" class="all_slect" type="text" style="width:125px" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:$('#zdyday_s').val(),maxDate:'#F{\'%y-%M-%d %H:%m:%s\'}'});" />
				  <!-- <input id="a1" value=""/> <input id="a2" value=""/> -->
			</li>
			   <!-- 
			    <label>大队：<input id="zhdd_bbtj_jqssdddm" class="all_inputtext"  type="hidden"/><input name="" id="zhdd_bbtj_jqssdd" type="text" class="all_slect" style="width: 153px;"/>
                </label>
                <label>&nbsp;&nbsp;中队：<input id="zhdd_bbtj_jqsszddm" class="all_inputtext"   type="hidden"/><input name="" id="zhdd_bbtj_jqsszd" type="text" class="all_slect"  style="width: 153px;"/>
                </label><br />
               
                  -->
			</ul>
			</dd>
        </dl>
		<div class="cxfsdiv">
				<a class="btnab" href="javascript:void(0);" onclick="bbtj.bbtjQuery();">查询</a>
				<a class="btnab" href="javascript:void(0);" onclick="bbtj.resetOtherOpt(true);">重置</a>
		</div>
	</div>	
	<div class="tongjidata"><div class="tongjidata_div" id="bbtjgrid"  title="支队统计情况："></div></div>
	<div class="tongjidata"><div class="tongjidata_div" id="zhdd_bbtj_zd_query" title="大队统计情况："></div></div>
</div>
	 
<script type="text/javascript">
	bbtj.initFun();
</script>
</body>
</html>