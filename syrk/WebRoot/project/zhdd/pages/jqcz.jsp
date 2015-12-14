<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${basePath}" />
<title>警情处置</title>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
</head>
<body>
	<%--弹出框--%>
	<div class="tips_top">
		<div id="mapBalloonTitle" class="tips_title">
			<a id="favoriteId" href="javascript:void(0);" class="tips_collect"></a>
			<strong><span id="jqcz_jqbh"></span></strong>
			<span>&nbsp;
				<%-- <a href="javascript:void(0);">发布</a>&nbsp; --%>
				<a href="javascript:void(0);" id="jqcz_jqyq">舆情</a>&nbsp;
				<a href="javascript:void(0);" onclick="Jqcz.showClbk();">布控</a>&nbsp;
				<a href="javascript:void(0);" id="jqcz_jqgl">关联</a>&nbsp;
				<a href="javascript:void(0);" id="jqcz_jqhf" onclick="Jqcz.jqczJqhfEvent();" style="display:none;">回放</a>&nbsp;
				<a href="javascript:void(0);" id="jqcz_jqzb" onclick="Jqcz.jqczJqzb();" style="display:none;">周边</a>
			</span>
			<a href="javascript:void(0);" title="关闭" class="tips_close"></a>
		</div>
	</div>
	
	<%-- 警情舆情容器div --%>
	<div class="easyui-draggable tipsbdy" data-options="handle:'#jqyq_title'" id="yqglContainerDiv"  style="z-index:1999;display:none;">
	<a href="javascript:void(0);" title="关闭" onclick="Jqyq.closeWindow();" class="tips_close"></a>
	<div class="tips_top"><div class="tips_title" id="jqyq_title"><strong>&nbsp;&nbsp;舆情</strong></div></div>
		<div id="yqglCont"></div>
		<div class="tips_bt"></div>
	</div>
	<div class="tips_ct_cz">
		<%-- 框内容 --%>
		<div class="tips_show_1 tips_showdx_toggle" id="tips_showdx">
			<dl class="tips_showdl show_toggle">
				<dt><span>报警</span></dt>
				<dd>
 					<label><span class="redcolor">*</span>人员：<input id="jqcz_bjrxm" class="inputtext" type="text" style="width:53px" /></label>
					<label>&nbsp;电话：<input id="jqcz_bjdh" class="inputtext" type="text" style="width:77px" /></label>
					<label><span class="redcolor">*</span>时间：<input id="jqcz_bjsj" class="inputtext" type="text" style="width:112px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" /></label>
				</dd>
			</dl>
			<dl class="tips_showdl show_toggle" style="display:none">
				<dt><span>接警</span></dt>
				<dd>
 					<label><span class="redcolor">*</span>人员：<input id="jqcz_jjrxm" class="inputtext" type="text" style="width:53px" /></label>
					<!-- <label>&nbsp;台服：<input id="jqcz_jjtfh" class="inputtext" type="text" style="width:77px" /></label> -->
					<label>&nbsp;方式：<input id="jqcz_bjfsmc" class="inputtext" type="text" style="width:77px" /></label>
					<label><span class="redcolor">*</span>时间：<input id="jqcz_jjsj" class="inputtext" type="text" style="width:112px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:$('#jqcz_bjsj').val()});" /></label>
				</dd>
			</dl>
			<dl class="tips_showdl">
				<dt><span>警情</span></dt>
				<dd><div class="show_toggle">
					<label><span class="redcolor">*</span>类别：
						<input type="hidden" id="jqcz_jqssdldm" name="lddm" />
	        			<input type="text" id="jqcz_jqssdlmc" name="jqssdlmc" class="tips_slect" style="width: 80px;" />
	          		</label>
	          		<label>
						<input type="hidden" id="jqcz_jqsszldm" name="lddm" />
	        			<input type="text" id="jqcz_jqsszlmc" name="jqssdlmc" class="tips_slect" style="width: 120px;" />
	          		</label>
	          		<label>
						<input type="hidden" id="jqcz_jqssxldm" name="lddm" />
	        			<input type="text" id="jqcz_jqssxlmc" name="jqssdlmc" class="tips_slect" style="width: 103px;" />
	          		</label>
					<br /> 
					</div>
					<!-- <label><span class="redcolor">*</span>地址：<textarea id="jqcz_jqafdd" class="jqcz_jqafdd"></textarea></label> -->
					<label><span class="redcolor">*</span>地址：<input type="text" id="jqcz_jqafdd" class="inputtext" style=" width:340px;" /></label><br/>
					<label><span class="redcolor">*</span>信息：<textarea id="jqcz_jqxx" style=" width:336px;"></textarea></label><br /> 
					<div class="show_toggle">
						<div class="clear"></div>
						<div class="tips_showdl tips_check tips_check_dx">
								<span class="lftitle lf">&nbsp;&nbsp;&nbsp;相关：</span>
								<div class="tips_check_inputli">
									<input type="checkbox" id="jqcz_ywty" onclick="Jqcz.setChecked('jqcz_ywty', true, true);"/><a href="javascript:void(0);" onclick="Jqcz.setChecked('jqcz_ywty');">有无逃逸</a>
		                 			<input name="" id="jqcz_ifelectric" type="checkbox" onclick="Jqcz.setChecked('jqcz_ifelectric', true, true);" /><a href="javascript:;" onclick="Jqcz.setChecked('jqcz_ifelectric');">电动车</a>
		                    		<input name="" id="jqcz_ifmotor" type="checkbox" onclick="Jqcz.setChecked('jqcz_ifmotor', true, true);"/><a href="javascript:;" onclick="Jqcz.setChecked('jqcz_ifmotor');">摩托车</a>
		                    		<input name="" id="jqcz_iftaxi" type="checkbox" onclick="Jqcz.setChecked('jqcz_iftaxi', true, true);"/><a href="javascript:;" onclick="Jqcz.setChecked('jqcz_iftaxi');">出租车</a>
									<input type="checkbox" id="jqcz_sfswhcl" onclick="Jqcz.setChecked('jqcz_sfswhcl', true, true);"/><a href="javascript:void(0);" onclick="Jqcz.setChecked('jqcz_sfswhcl');">危化车</a>
									<div class="clear"></div>
		                 			<input name="" id="jqcz_ifpolice" type="checkbox" onclick="Jqcz.setChecked('jqcz_ifpolice', true, true);"/><a href="javascript:;" onclick="Jqcz.setChecked('jqcz_ifpolice');">军警车</a>
									<input type="checkbox" id="jqcz_sfsjtsgdsr" onclick="Jqcz.setChecked('jqcz_sfsjtsgdsr', true, true);"/><a href="javascript:void(0);" onclick="Jqcz.setChecked('jqcz_sfsjtsgdsr');">事故当事人</a>
									<input name="" id="jqcz_ifschool" type="checkbox" onclick="Jqcz.setChecked('jqcz_ifschool', true, true);"  /><a href="javascript:;" onclick="Jqcz.setChecked('jqcz_ifschool');">学校</a>
								</div>
								<div class="clear"></div>
								<div class="tips_showdl" id="zjj_if_dx">
				 				</div>
		        				<div class="lf shoussw" style="margin-left:45px;" id="jqcz_if_sw_hurt">
		        				   <span class="lf" style="margin:5px 0 0;padding:0;"><input type="checkbox" id="jqcz_ifhurt" onclick="Jqcz.ifcheckboxSelected('zjj_ifhurt');"/><a href="javascript:void(0);" onclick="Jqcz.setChecked('jqcz_ifhurt');Jqcz.ifcheckboxSelected('zjj_ifhurt');">有无受伤</a></span>
								   <span class="lf" id="jqcz_if_sw_hurtcount" style="display: none;"><span class="redcolor">*</span><input id="jqcz_hurtcount"  class="inputtext"  style="width:22px;text-align:center;"  type="text" />(人)</span>
				 				   <span class="lf" id="jqcz_if_sw_ifdxhurt" style="margin:5px 0 0 5px;" style="display: none;"><input name="" id="jqcz_ifdxhurt" type="checkbox" value="" onclick="Jqcz.setChecked('jqcz_ifdxhurt', true, true);"/><a href="javascript:;" onclick="Jqcz.setChecked('jqcz_ifdxhurt');">是否典型伤人</a></span>
				 				</div>
		        				<div class="lf shoussw" id="jqcz_ywrysw_dead">
		        				 <span class="lf" style="margin:5px 0 0 5px;"><input type="checkbox" id="jqcz_ifdead" onclick="Jqcz.ifcheckboxSelected('jqcz_ifdead');"/><a href="javascript:void(0);" onclick="Jqcz.setChecked('jqcz_ifdead');Jqcz.ifcheckboxSelected('jqcz_ifdead');">有无死亡</a></span>
								 <span id="jqcz_if_sw_deadcount" style="display: none;"><span class="redcolor">*</span><input id="jqcz_deadcount"  class="inputtext"  style="width:22px;text-align:center;"  type="text" />(人)</span>
				  				</div>						
						</div>
						<div class="clear"></div>
				        <label>&nbsp;道路：<input type="hidden" id="jqcz_dldm" name="dldm" />
				        	<input type="text" id="jqcz_dlmc" name="dlmc" class="tips_slect" style="width:160px;" />
				        </label>
		        		<label><input type="hidden" id="jqcz_lddm" name="lddm" />
		        			<input type="text" id="jqcz_ldmc" name="ldmc" class="tips_slect" style="width:165px" />
		          		</label> 
						<a href="javascript:void(0);" onclick="Jqcz.jqxxLddw();" class="btn_tipsdw" style="display:none;">路段定位</a>		
					</div>		
				</dd>
			</dl>
			<dl class="tips_showdl">
				<dd>
					<label class="tips_lx">
					<div class="lf"><span><font color="red">*</font>类型：</span><input type="hidden" id="jqcz_jqlxdm" name="jqldm" />
						<input type="text" id="jqcz_jqlxmc" name="jqlxmc" class="tips_slect" style="width: 135px;" />
					</div>	
						<a href="javascript:void(0);" id="jqcz_sqbg_btn" onclick="Jqcz.updateSqbg(true);" class="btn_tipsdw lf" style="display:none;">变&nbsp;&nbsp;更</a>
						<a href="javascript:void(0);" id="jqcz_jqbg_btn" onclick="Jqcz.updateJqbg();" class="btn_tipsdw lf" style="display:none;">确&nbsp;&nbsp;认</a>
					</label>
				</dd>
			</dl>
			<dl class="tips_showdl" style="padding:0;">
				<dd>
					<div>
						<a href="javascript:void(0);" id="jqcz_save_btn" onclick="Jqcz.updateJqxx();" class="btn_tipssave btn_tipssaved" style="margin:5px 5px 0 0">保&nbsp;&nbsp;&nbsp;&nbsp;存</a>
					</div>
				</dd>
			</dl>
			<div class="clear"></div>
		</div>
		<a href="javascript:void(0);" id="jqcz_window_toggle" class="tips_slide_up" onclick="Jqcz.jqczToggle();"></a>
		<dl class="tips_dl dl_paijin">
			<dt id="jqcz_cllc_dt">
				<div class="lf menu_paijin">
					<a href="javascript:void(0);" class="dtaon" id="jqcz_jqdwtab">定位</a>
					<a href="javascript:void(0);" id="jqcz_cgjqtab">派警</a>
					<a href="javascript:void(0);" id="jqcz_jqzptab">派警</a>
					<a href="javascript:void(0);" id="jqcz_zdjqtab">上报</a>
					<a href="javascript:void(0);" id="jqcz_jqdbtab">督办</a>
					<a href="javascript:void(0);" id="jqcz_jqyjtab">移交</a>
					<a href="javascript:void(0);" id="jqcz_ejcjtab">二级</a>
					<a href="javascript:void(0);" id="jqcz_jqtstab">投诉</a>
					<a href="javascript:void(0);" id="jqcz_jqjltab">记录</a>
					<a href="javascript:void(0);" id="jqcz_shbjtab">事后</a>
					<a href="javascript:void(0);" id="jqcz_czjgtab">处置结果</a>
					<a href="javascript:void(0);" id="jqcz_ejqrtab">二级确认</a>
					<a href="javascript:void(0);" id="jqcz_ejtstab">二级警情</a>
					<a href="javascript:void(0);" id="jqcz_jqyptab" style="float:right;">已派</a>
				</div>
				<div class="rt jqcz_rtbtn">
					<%--<a href="javascript:void(0);" onclick="Jqcz.jqczTspj({jybh: '027249', jyxm : '曾钦富'});">派警</a>&nbsp;&nbsp;&nbsp; --%>
					<a href="javascript:void(0);" style="display:none;">呼叫</a>&nbsp;&nbsp;&nbsp;
					<a href="javascript:void(0);" style="display:none;">互动</a>
				</div>
			</dt>
			<%--警情定位搜索--%>
			<dd class="tips_jqcz_dd" style="display:none;">
				<dl class="tips_showdl">
					<dd>
						<label><div class="lf">路段定位：<input type="hidden" id="jqcz_fzdw_lddm" name="lddm" /><input type="text" id="jqcz_fzdw_ldmc" name="ldmc" class="tips_slect" style="width:210px;" /></div>
						<a href="javascript:void(0);" onclick="Jqcz.newLoateXY();" class="rt btn_tipssave btn_tipssaveb">定位</a>
			          	</label> 
					</dd>
				</dl>
			</dd>
			<%--/警情定位搜索--%>
			<%--派警内容--%>
			<dd class="tips_jqcz_dd" style="display:none">
				<%-- 常规警情处置面板 --%>
				<div id="pj_span" style="border:none;display:none;">
					<dl class="tips_showdl">
						<dd>
							<label>
								<span id="jqcz_pj_cjlx">
									<a id="jqcz_pj_cjlx_sc" style="margin:0 15px 0 0;" href="javascript:void(0);"><input type="radio" name="jqczPjlx" value="0" checked="checked"/>首次</a>
									<a id="jqcz_pj_cjlx_zp" style="margin:0 15px 0 0;" href="javascript:void(0);"><input type="radio" name="jqczPjlx" value="1"/>增援</a>
									<a id="jqcz_pj_cjlx_gp" style="margin:0 15px 0 0;" href="javascript:void(0);"><input type="radio" name="jqczPjlx" value="2"/>改派</a>
								</span>
							</label><br/>
							<label><span class="redcolor">*</span>所属大队：
								<input id="jqcz_pj_ssdddm" type="hidden" style="width:113px" />
								<input id="jqcz_pj_ssddmc" type="text" class="tips_slect" style="width:111px" />
							</label>
							<label><span class="redcolor">*</span>所属中队：
								<input id="jqcz_pj_sszddm" type="hidden" style="width:113px" />
								<input id="jqcz_pj_sszdmc" type="text" class="tips_slect" style="width:110px" />
							</label><br/>
							<label><span class="redcolor">*</span>出警民警：
								<input id="jqcz_pj_jjmjdm" type="hidden" style="width:113px" />
								<input id="jqcz_pj_jjmjmc" type="text" class="tips_slect" style="width:110px" />
							</label>
							<label>&nbsp;&nbsp;先期处置：
								<input id="jqcz_pj_xqjydm" type="hidden" style="width:113px" />
								<input id="jqcz_pj_xqjymc" type="text" class="tips_slect" style="width:111px" />
							</label>
						</dd>
					</dl>
					<dl class="tips_showdl">
					<!-- <dt id="jqcz_pjfs_dt">
						<span>通知民警</span>
					</dt> -->
					<dd id="jqcz_pjfs_dd_pj">
						<div class="tips_checkb"></div>
						<div class="lf"></div>
						<div class="rt"></div>
					</dd>
					<a href="javascript:void(0);" class="btn_tipssave btn_tipssaved" onclick="Jqcz.jqczPjsj();">确认派警</a>
				</dl>
				</div>
				<%-- 到达现场面板 --%>
				<div id="ddxc_span" style="border:none;display:none;">
					<dl class="tips_showdl">
						<dd>
							<div class="lf">现场交通：</div>
							<div class="lf" id="jqcz_ddxc_jtzt">
							<a class="tips_radioa" href="javascript:void(0);"><input type="radio" name="jqczXcjt"  value="0" checked="checked" />畅通</a>
							<a class="tips_radioa" href="javascript:void(0);" style="margin:0 0 0 15px"><input type="radio" name="jqczXcjt" value="1"/>缓慢</a>
							<a class="tips_radioa" href="javascript:void(0);" style="margin:0 0 0 15px"><input type="radio" name="jqczXcjt" value="2"/>拥堵</a>
							<a class="tips_radioa" href="javascript:void(0);" style="margin:0 0 0 15px"><input type="radio" name="jqczXcjt" value="3"/>其他</a>
							</div>
						</dd>
					</dl><br />
					<dl class="tips_showdl" id="jqcz_ddxc_xcgz">
						<dd>
							<div class="lf" id="jqcz_ddxc_xcgz_title">现场感知：</div>
							<div class="lf">
								<span class="tips_radioa chuzhi_btn_img"  onclick="Jqcz.jqczXcgz(0, 'tp');"><input id="jqcz_xcgz_tp_val" type="hidden" />
									<a id="jqcz_xcgz_tp" href="javascript:void(0);" title="照片">0</a>
								</span>
								<span class="tips_radioa chuzhi_btn_voice"  onclick="Jqcz.jqczXcgz(1, 'yy');"><input id="jqcz_xcgz_yy_val" type="hidden" />
									<a id="jqcz_xcgz_yy" href="javascript:void(0);" title="录音">0</a>
								</span>
								<span class="tips_radioa chuzhi_btn_video" onclick="Jqcz.jqczXcgz(2, 'sp');"><input id="jqcz_xcgz_sp_val" type="hidden" />
									<a id="jqcz_xcgz_sp" href="javascript:void(0);" title="录像">0</a>
								</span>
							</div>
						</dd>
					</dl><br />
					<dl class="tips_showdl">
						<dd style="margin-top:5px;">
							<div class="lf">补充说明：<textarea id="jqcz_dd_bz" style="width:215px; height:60px;"></textarea></div>
							<div class="rt">
								<a href="javascript:void(0);" onclick="Jqcz.jqczYxsWdd();" class="btn_tipssave btn_tipssaved" style="margin-top:3px;">已协商未到达</a>
								<a href="javascript:void(0);" onclick="Jqcz.jqczQrdd();" class="btn_tipssave btn_tipssaved" style="margin-top:7px;">确认到达</a>
							</div>
						</dd>
					</dl>
				</div>
				<%-- 处置中面板 --%>
				<div id="czz_span" style="border:none;display:none;">
					<dl class="tips_showdl" style="overflow:hidden">
						<dd>
							<div class="lf">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现场交通：</div>
							<div class="lf" id="jqcz_czz_jtzt">
							<a class="tips_radioa" href="javascript:void(0);"><input type="radio" name="czzXcjt"  value="0" checked="checked" />畅通</a>
							<a class="tips_radioa" href="javascript:void(0);" style="margin:0 0 0 12px"><input type="radio" name="czzXcjt" value="1"/>缓慢</a>
							<a class="tips_radioa" href="javascript:void(0);" style="margin:0 0 0 12px"><input type="radio" name="czzXcjt" value="2"/>拥堵</a>
							<a class="tips_radioa" href="javascript:void(0);" style="margin:0 0 0 12px"><input type="radio" name="czzXcjt" value="3"/>其他</a>
							</div>
						</dd>
					</dl>
					<dl class="tips_showdl" id="jqcz_czz_xcgz" style="display:none;"></dl><br />
					<dl class="tips_showdl">	
						<dd style="overflow:hidden;"><div style="margin:1px 0 0 1px;float:left">&nbsp;&nbsp;&nbsp;&nbsp;<span class="redcolor">*</span>处置反馈：</div><textarea id="jqcz_cz_czfk" style="width:305px; height:16px;"></textarea></dd>
						<dd style="overflow:hidden;"><div style="margin:1px 0 0 0;float:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;补充说明：</div><textarea id="jqcz_cz_bcsm" style="width:305px; height:16px;"></textarea></dd>
						<dd style="overflow:hidden;">
							<div class="lf">&nbsp;&nbsp;满意度调查：<textarea id="jqcz_cz_myddc" style="width:200px; height:45px;"></textarea></div>
							<div class="rt">
								<a href="javascript:void(0);" onclick="Jqcz.jqczMyddc();" class="btn_tipssave" style="margin:2px 5px 1px 0;">发送</a>
								<a href="javascript:void(0);" onclick="Jqcz.jqczQrwc();" class="btn_tipssave btn_tipssaved" style="margin:3px 5px 0 0;">确认完成</a>
							</div>
						</dd>
					</dl>
				</div>
				<%-- 处置反馈面板 --%>
				<div id="czfk_span" style="border:none;display:none;">
					<dl class="tips_showdl">
						<dd>
							处置结果：
								<div id="jqcz_cz_czjg" style="margin-left:40px;"></div>
						</dd>
					</dl>
				</div>
			</dd>
			<%--/派警内容--%>
			<%-- 增援、改派内容--%>
			<dd class="tips_jqcz_dd" id="tips_jqcz_jqzp" style="display:none">
				
			</dd>
			<%--重大警情--%>
			<dd class="tips_jqcz_dd" style="display:none;height:150px;width:390px;"> 
			<div id="scroll_main_zdjq" style="height:150px;width:390px;">
				<div id="scroll_content_zdjq" style="height:260px;width:390px;"> 
				<dl class="tips_showdl">
					<!-- <dt><span>警情级别</span></dt> -->
					<dd id="jqcz_zdjq_jb_dd"></dd>
				</dl>
				<dl class="tips_showdl">
					<dt style="height:18px;"><span>上报领导</span></dt>
					<dd><div class="lf" id="jqcz_zdjq_sb_div"></div></dd>
				</dl>
				<input type="hidden" id="jqcz_zdjq_jqnr"/>
			</div></div>
			</dd>
			<%--/重大警情--%>
			<%--警情督办内容--%>
			<dd class="tips_jqcz_dd">
				<dl class="tips_showdl">
					<dd>
						<label>
							督办信息： <span id="jqcz_jqdb_xx"></span>
						</label><br />
						<label>
							<input type="hidden" id="jqcz_jqdb_jyxx" />
							<span id="jqcz_jqdb_cjjy">出警人员</span>：<span id="jqcz_jqdb_jyxm"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话： <span id="jqcz_jqdb_lxdh"></span></label>
					</dd>
					<dd id="jqcz_pjfs_dd_db">2
						<div class="tips_checkb"></div>
						<div class="lf"></div>
						<div class="rt"></div>
					</dd>
					<dd>
						<div class="lf"></div>
						<div class="rt"><a href="javascript:void(0);" onclick="Jqcz.jqczJqdb();" class="btn_tipssave btn_tipssaved">确认督办</a></div>
					</dd>
				</dl>
			</dd>
			<%--/警情督办--%>
			<%--警情移交内容--%>
			<dd class="tips_jqcz_dd" style="display:none">
				<dl class="tips_showdl">
					<dd>
						<label><span class="redcolor">*</span>移交单位：
							<input id="jqcz_yj_yjdwdm" type="hidden"/>
							<input id="jqcz_yj_yjdwmc" type="text" class="tips_slect" style="width:305px" />
							<div id="jqcz_yj_yjdwmc_data_Div" style="display:none;"></div>
						</label>
						<label>
						<div style="margin:5px 0 0"><div class="lf">&nbsp;&nbsp;<span class="redcolor">*</span>移交原因：
							<input id="jqcz_yj_yjyydm" type="hidden"/>
							<input id="jqcz_yj_yjyymc" type="text" class="tips_slect" style="width:200px" />
						</div>
						<div class="rt">
							<a href="javascript:void(0);" onclick="Jqcz.jqczJqyj();" class="btn_tipssave btn_tipssaved">确&nbsp;&nbsp;&nbsp;&nbsp;定</a>
						</div></div>
						</label>
					</dd>
				</dl>
			</dd>
			<%--/警情移交内容--%>
			<%--二级处警内容--%>
			<dd class="tips_jqcz_dd" style="display:none">
				<dl class="tips_showdl">
					<dd>
						<label><span class="redcolor">*</span>单位：
							<input id="jqcz_ej_bgdddm" type="hidden" style="width:333px;" />
							<input id="jqcz_ej_bgddmc" type="text" class="tips_slect" style="width:330px;" />
						</label><br />
					</dd>
				</dl>
				<dl class="tips_showdl">
					<dd>
						<div style="margin:5px 0 0"><div class="lf">&nbsp;&nbsp;<span class="redcolor">*</span>原因：
							<!-- <textarea id="jqcz_ej_bgyy" cols="" rows="" style="width:220px; height:54px; margin:0 0 0 2px;"></textarea> -->
							<input id="jqcz_ej_bgdm" type="hidden"/>
							<input id="jqcz_ej_bgmc" type="text" class="tips_slect" style="width:220px;margin:0 0 0 2px;" />
						</div>
						<div class="rt">
							<a href="javascript:void(0);" onclick="Jqcz.jqczEjcj();" class="btn_tipssave btn_tipssaved">确&nbsp;&nbsp;&nbsp;&nbsp;定</a>
						</div></div>
					</dd>
				</dl>
			</dd>
			<%--/二级处警内容--%>
			<%--警情投诉--%>
			<dd class="tips_jqcz_dd" style="display:none">
				<dl class="tips_showdl">
					<dd>
						<label><span class="redcolor">*</span>投诉单位：
							<input id="jqcz_ts_tsdwdm" type="hidden" style="width:310px;" />
							<input id="jqcz_ts_tsdwmc" type="text" class="tips_slect" style="width:305px;" onExit="Jqcz.jqtsZzjgTree();" />
							<div id="jqcz_ts_tsdwmc_data_Div" style="display:none;"></div>
						</label>
						<label><span class="redcolor">*</span>投诉人员：
							<input id="jqcz_ts_tsrydm" type="hidden" style="width:310px;" />
							<input id="jqcz_ts_tsrymc" type="text" class="tips_slect" style="width:305px;" />
						</label>
					</dd>
				</dl>
				<dl class="tips_showdl">
					<dd>
						<div style="margin:5px 0 0"><div class="lf">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="redcolor">*</span>备注：
							<%-- <textarea id="jqcz_ts_tsnr" cols="" rows="" style="width:200px; height:54px; margin:0 0 0 2px;"></textarea> --%>
							<input id="jqcz_ts_tsnrdm" type="hidden"/>
							<input id="jqcz_ts_tsnr" type="text" class="tips_slect" style="width:200px;" />
						</div>
						<div class="rt">
							<a href="javascript:void(0);" onclick="Jqcz.jqczJqts();" class="btn_tipssave btn_tipssaved">确&nbsp;&nbsp;&nbsp;&nbsp;定</a>
						</div></div>
					</dd>
				</dl>
			</dd>
			<%--/警情投诉--%>
			<%--警情记录--%>
			<dd class="tips_jqcz_dd" style="display:none">
				<dl class="tips_showdl">
					<dd>
						<div class="lf">
							<span class="redcolor">*</span>备注：
							<%-- <textarea id="jqcz_jl_jlnr" style="width:230px; height:60px;"></textarea> --%>
							<input id="jqcz_jl_jlnrdm" type="hidden"/>
							<input id="jqcz_jl_jlnr" type="text" class="tips_slect" style="width:230px;" />
						</div>
						<div class="rt">
							<a href="javascript:void(0);" onclick="Jqcz.jqczJqjl();" class="btn_tipssave btn_tipssaved">确&nbsp;&nbsp;&nbsp;&nbsp;定</a>
						</div>
					</dd>
				</dl>
			</dd>
			<%--/警情记录内容--%>
			<%--事后报警--%>
			<dd class="tips_jqcz_dd" style="display:none">
				<dl class="tips_showdl">
					<dd style="overflow:hidden;">
						<label><span class="redcolor">*</span>所属大队：
							<input id="jqcz_sh_ssdddm" type="hidden" style="width:100px;" />
							<input id="jqcz_sh_ssddmc" type="text" class="tips_slect" style="width:100px;" />
						</label>
						<label><span class="redcolor">*</span>所属中队：
							<input id="jqcz_sh_sszddm" type="hidden" style="width:125px;" />
							<input id="jqcz_sh_sszdmc" type="text" class="tips_slect" style="width:120px;" />
						</label>
						<label><span class="redcolor">*</span>出警民警：
							<input id="jqcz_sh_jjmjdm" type="hidden" style="width:100px;" />
							<input id="jqcz_sh_jjmjmc" type="text" class="tips_slect" style="width:100px;" />
						</label>
						<label><span class="redcolor">*</span>出警时间：
							<input id="jqcz_sh_cjsj" class="inputtext" type="text" style="width:123px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
						</label>
						<label>&nbsp;&nbsp;先期处置：
							<input id="jqcz_sh_xqjydm" type="hidden" style="width:100px;" />
							<input id="jqcz_sh_xqjymc" type="text" class="tips_slect" style="width:100px;" />
						</label> 
					</dd>
					<dd style="overflow:hidden;" style="display:none;"><div class="lf">&nbsp;&nbsp;&nbsp;&nbsp;现场交通：</div>
						<div class="lf" id="jqcz_sh_jtzt">
							<a class="tips_radioa" href="javascript:void(0);"><input type="radio" name="shbjXcjt" value="0" checked="checked" />畅通</a>
							<a class="tips_radioa" href="javascript:void(0);"><input type="radio" name="shbjXcjt" value="1" />缓慢</a>
							<a class="tips_radioa" href="javascript:void(0);"><input type="radio" name="shbjXcjt" value="2" />拥堵</a>
						</div>
					</dd>
					<dd style="overflow:hidden;">&nbsp;&nbsp;<span class="redcolor">*</span>处置反馈：<textarea id="jqcz_sh_czfk" style="width:302px; height:35px;margin:0 0 0 8px"></textarea></dd>
					<dd style="overflow:hidden;">
						<div class="lf">&nbsp;&nbsp;&nbsp;&nbsp;补充说明：<textarea id="jqcz_sh_bz" style="width:195px; height:32px;margin:0 0 0 7px"></textarea></div>
						<div class="rt"><a href="javascript:void(0);" onclick="Jqcz.jqczQrsh();" class="btn_tipssave btn_tipssaved" style="margin-top:5px">确认完成</a></div>
					</dd>
				</dl>
			</dd>
			<%--/事后报警--%>
			<%-- 处置结果 展示--%>
			<dd class="tips_jqcz_dd" style="display:none">
				<dl class="tips_showdl">
					<dd>
						<div id="jqcz_jqczjg"></div>
					</dd>
				</dl>
			</dd>
			<%-- /处置结果展示 --%>
			<%-- /二级确认 --%>
			<dd class="tips_jqcz_dd" style="display:none">
				<dl class="tips_showdl">
					<dd>
						<div class="lf">
							<span class="redcolor">*</span><span>退回原因：</span>
							<textarea id="jqcz_ejqr_thyy" style="width:200px; height:45px;"></textarea>
						</div>
						<div class="rt">
							<a href="javascript:void(0);" onclick="Jqcz.ejjqConfirm();" class="btn_tipssave btn_tipssaved">接收</a>
							<a href="javascript:void(0);" onclick="Jqcz.ejjqBack();" class="btn_tipssave btn_tipssaved">退回</a>
						</div>
					</dd>
				</dl>
			</dd>
			<%-- /二级确认 --%>
			<%-- /二级中提醒 --%>
			<dd class="tips_jqcz_dd" style="display:none">
				<dl class="tips_showdl">
					<dd>
					<div class="lf">
					   二级处置中
					</div>	
					</dd>
				</dl>
			</dd>
			<%-- /二级中提醒--%>
			<%-- /已派--%>
			<dd class="tips_jqcz_dd" style="display:none;height:150px;width:390px;">
				<div id="scroll_main_jqyp" style="height:150px;width:390px;">
					<div id="scroll_content_jqyp" style="height:260px;width:390px;"> 
						<dl class="tips_showdl">
							<dd id="jqcz_jqyp_dd">
							</dd>
						</dl>
					</div>
				</div>
			</dd>
			<%-- /已派 --%>
		</dl>
		<%-- /框内容 --%>
	</div>
	<%--/弹出框--%>
<script type="text/javascript">
$(document).ready(function(){Jqcz.controlDiv();});
</script>
</body>
</html>