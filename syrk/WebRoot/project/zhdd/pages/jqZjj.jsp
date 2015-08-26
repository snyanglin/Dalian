<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>接警弹出</title>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
</head>
<body>
<div class="wintipsbdy" id="zjj_bodyid" style="position:relative">
<div class="tips">
<div class="tips_ct">
<div id="zjj_tipsshowDIv" class="tips_show_1">
<dl class="tips_showdl">
            <dt><div class="dtspan">接警</div></dt>
            <dd>
                <label>&nbsp;&nbsp;人员：<input name="" id="zjj_jjrxm" class="all_inputtext" type="text" style="width:65px;" value='${UserSession.userName}' disabled="disabled"/></label>
                <label>&nbsp;台服：<input name="" id="zjj_jjtfh" class="all_inputtext" type="text" style="width:78px" /></label>
                <label><font color="red">*</font>时间：<input name="" id="zjj_jjsj" class="all_inputtext" style="width:112px" value=""  type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{\'%y-%M-%d %H:%m:%s\'}',onpicked:function(){zjj_jjsj.focus();}});" /></label>
            </dd>
        </dl>
        <dl class="tips_showdl" id="zjj_bj_dl">
            <dt><div class="dtspan">报警</div></dt>
            <dd>
                <label><font color="red">*</font>人员：<input name="" id="zjj_bjrxm" class="all_inputtext" type="text" style="width:65px" /></label>
                <label>&nbsp;电话：<input name="" id="zjj_bjdh" class="all_inputtext"  style="width:78px" type="text" /></label>
                <label><font color="red">*</font>时间：<input name="" id="zjj_bjsj" class="all_inputtext" style="width:112px"  type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{\'%y-%M-%d %H:%m:%s\'}',onpicked:function(){zjj_bjsj.focus();}});"/></label>
            </dd>
        </dl>
        <dl class="tips_showdl" id="zjj_jq_dl">
            <dt><div class="dtspan">警情</div></dt>
            <dd>
                <label><font color="red">*</font>类别：<input id="zjj_jqssdldm"  type="hidden"/><input name="" type="text" class="all_slect" id="zjj_jqssdl" style="width: 87px;"/>
                </label>
                <label><input id="zjj_jqsszldm"  type="hidden"/><input name="" type="text" class="all_slect" id="zjj_jqsszl" style="width: 127px;"/>
                </label>
                <label><input id="zjj_jqssxldm"  type="hidden"/><input name="" type="text" class="all_slect" id="zjj_jqssxl" style="width: 118px;"/>
                </label><br/>
                <label><font color="red">*</font>大队：<input id="zjj_jqssdddm"  type="hidden"/><input name="" id="zjj_jqssdd" type="text" class="all_slect"/>
                </label>
                <label><font color="red">*</font>中队：<input id="zjj_jqsszddm"  type="hidden"/><input name="" id="zjj_jqsszd" type="text" class="all_slect"  style="width: 153px;"/>
                </label>
                <div style="margin:5px 0 5px"><label><font color="red">*</font>地址：<input class="all_inputtext" style="width:354px;" name="" id="zjj_jqafdd" /></label></div>
                <label><font color="red">*</font>信息：<textarea class="all_textarea" style="width:350px;" name="" id="zjj_jqxx" cols="" rows=""></textarea></label><br/>
                <input name="" id="zjj_afdzx" type="hidden"/>
                 <input name="" id="zjj_afdzy" type="hidden"/>
            </dd>
        </dl>
        <dl class="tips_showdl tips_check tips_check_dx" style="width:420px">
            <span class="lftitle lf">&nbsp;&nbsp;&nbsp;相关：</span>
			<div class="tips_check_inputli">
            <input name="" id="zjj_ywty" type="checkbox" value="" /><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_ywty');">有无逃逸</a>
            <input name="" id="zjj_ifelectric" type="checkbox" value="" /><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_ifelectric');">电动车</a>
            <input name="" id="zjj_ifmotor" type="checkbox" value="" /><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_ifmotor');">摩托车</a>
            <input name="" id="zjj_iftaxi" type="checkbox" value="" /><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_iftaxi');">出租车</a>
            <input name="" id="zjj_sfswhcl" type="checkbox" value="" /><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_sfswhcl');">危化车</a>
            <input name="" id="zjj_ifpolice" type="checkbox" value="" /><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_ifpolice');">军警车</a>
            <div class="clear"></div>
            <input name="" id="zjj_sfsjtsgdsr" type="checkbox" value="" /><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_sfsjtsgdsr');">事故当事人</a>
            <input name="" id="zjj_ifschool" type="checkbox" value="" /><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_ifschool');">学校</a>
        	</div>
	        <div class="lf" style="margin:0 0 0 45px;" id="zjj_if_hurt">
	          <span class="lf" style="margin:5px 0 0;padding:0;"><input name="" id="zjj_ifhurt" type="checkbox" value="" onclick="Zjj.ifcheckboxSelected('zjj_ifhurt');"/><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_ifhurt');Zjj.ifcheckboxSelected('zjj_ifhurt');">有无受伤</a></span>
	          <span class="lf" id="zjj_if_sw_hurtcount" style="display: none;"><span class="redcolor">*</span><input id="zjj_hurtcount"  class="all_inputtext"  style="width:28px;text-align:center;" type="text" />(人)</span>
			  <span class="lf" style="margin:5px 0 0 5px;" id="zjj_if_dxhurtcount" style="display: none;"> <input name="" id="zjj_ifdxhurt" type="checkbox" value="" onclick="Zjj.ifcheckboxSelected('zjj_ifdxhurt');"/> <a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_ifdxhurt');">是否典型伤人</a>
			  </span>
			</div>
	        <div class="lf" id="zjj_if_dead">
	          <span class="lf" style="margin:5px 0 0 5px;"><input name="" id="zjj_ifdead" type="checkbox" value="" onclick="Zjj.ifcheckboxSelected('zjj_ifdead');"/><a href="javascript:;" onclick="Zjj.checkboxSelected('zjj_ifdead');Zjj.ifcheckboxSelected('zjj_ifdead');">有无死亡</a></span>
	          <span id="zjj_if_sw_deadcount" style="display: none;"><span class="redcolor">*</span><input id="zjj_deadcount"  class="all_inputtext"  style="width:28px;text-align:center;" type="text" />(人)</span>
			</div>
        </dl>
          <div class="clear"></div>
        <dl class="tips_showdl" id="zjj_jq_dl">
        <dd>
        <label><div class="lf">&nbsp;&nbsp;<font color="red">*</font><span class="lablespan">警情类型：</span><input id="zjj_jqlxdm"  type="hidden"/><input name="" id="zjj_jqlxmc" type="text" class="all_slect" style="width:135px"/></div>
        </label>
        </dd>
        </dl>
    </div>
        <dl class="tips_dl dl_paijin">
		<%--警情定位搜索--%>
			<dd id="zjj_jqdw_dd" class="tips_zjj_dd" style="display:block;">
                <label><span class="lablespan">&nbsp;&nbsp;路段定位：</span><input name="" id="zjj_lddm" type="hidden"/><input name="" id="zjj_ldmc" class="all_slect" style="width:260px"  type="text" />
                 <a  href="javascript:void(0);" onclick="Zjj.newFzdw();" style="margin:-20px 15px 0 0;" class="btn_tipsdw">定位</a>
                 </label>
			</dd>
        <%--/警情定位搜索--%>
			<%--警情投诉--%>
			<dd id="zjj_jqts_dd" class="tips_zjj_dd" style="display:none">
				<dl class="tips_showdl" style="padding:0;">
					<dd>
						<label><font color="red">*</font>投诉单位：<input id="zjj_ts_tsdwdm" type="hidden" style="width:326px;" /><input id="zjj_ts_tsdwmc" type="text" class="all_slect" style="width:328px;" onExit="Zjj.jqtsZzjgTree();" />
							<div id="zjj_ts_tsdwmc_data_Div" style="display:none;"></div>
						</label><br/>
						<label>&nbsp;投诉人员：<input id="zjj_ts_tsrydm" type="hidden" style="width:326px;" /><input id="zjj_ts_tsrymc" type="text" class="all_slect" style="width:330px;" />
						</label><br />
					</dd>
				</dl>
				<dl class="tips_showdl" style="padding:5px 0 0;">
					<dd>
						<div class="lf">&nbsp;&nbsp;<font color="red">*</font>备注：
							<%-- <textarea class="all_textarea" id="zjj_ts_tsnr" cols="" rows="" style="width:347px; height:54px;"></textarea> --%>
							<input id="zjj_ts_tsnrdm" type="hidden"/>
							<input id="zjj_ts_tsnr" type="text" class="all_slect" style="width:347px;" />
						</div>
					</dd>
				</dl>
			</dd>
			<%--/警情投诉--%>
			<%--警情记录--%>
			<dd id="zjj_jqjl_dd" class="tips_zjj_dd" style="display:none">
				<dl class="tips_showdl" style="padding:0;">
					<dd>
						<div class="lf">&nbsp;&nbsp;<font color="red">*</font>备注：
							<%-- <textarea class="all_textarea" id="zjj_jl_jlnr" cols="" rows="" style="width:347px; height:54px;"></textarea> --%>
							<input id="zjj_jl_jlnrdm" type="hidden"/>
							<input id="zjj_jl_jlnr" type="text" class="all_slect" style="width:347px;" />
						</div>
					</dd>
				</dl>
			</dd>
			<%--/警情记录内容--%>
			<%--事后报警--%>
			<dd id="zjj_shbj_dd" class="tips_zjj_dd" style="display:none">
				<dl class="tips_showdl" style="padding:0;">
					<dd style="overflow:hidden;">
						<label><font color="red">*</font>所属大队：<input id="zjj_sh_ssdddm" type="hidden" style="width:113px" /><input id="zjj_sh_ssddmc" type="text" class="all_slect" style="width:113px" />
						</label>
						<label><font color="red">*</font>所属中队：<input id="zjj_sh_sszddm" type="hidden" style="width:138px" /><input id="zjj_sh_sszdmc" type="text" class="all_slect" style="width:138px" />
						</label><br/>
						<label><font color="red">*</font>出警民警：<input id="zjj_sh_jjmjdm" type="hidden" style="width:113px" /><input id="zjj_sh_jjmjmc" type="text" class="all_slect" style="width:113px" />
						</label>
					</dd>
					<dd style="overflow:hidden;margin:5px 0 0">&nbsp;&nbsp;<font color="red">*</font>处置反馈：<textarea id="zjj_sh_czfk" style="width:322px; height:36px;"></textarea></dd>
					<dd style="overflow:hidden;">
						<div class="lf">&nbsp;&nbsp;&nbsp;&nbsp;补充说明：<textarea id="zjj_sh_bz" style="width:322px; height:24px;"></textarea></div>
					</dd>
				</dl>
			</dd>
			<%--/事后报警--%>
		</dl>
		<a href="javascript:Zjj.addJqxx();" class="btn_tipssave" style="margin:5px 15px 5px 0;">保&nbsp;&nbsp;&nbsp;&nbsp;存</a>
		<a href="javascript:Zjj.closeWindow();" class="btn_tipssave" style="margin:5px 15px 5px 0;">取&nbsp;&nbsp;&nbsp;&nbsp;消</a>
</div>
</div>
</div>
</body>
</html>