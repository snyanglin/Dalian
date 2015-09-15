var refresh ="<div class='uline_rt' style='display:none'><a class='ulup_btn ulrt_btn1' href='javascript:void(0);'></a><a class='ulrefresh_btn ulrt_btn1' href='javascript:void(0);'></a></div>";
/************************************select t.*, t.rowid from SYS_XXZSNRB t;********************/

/****************************************************重点人口******************************************************************************************/
//重点人口
function info_zdrk_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>管理方法：</span><span name='glffdm' dict='/common/dict/ZA_D_ZDRKGLFF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>列管来源：</span><span name='lglydm' dict='/common/dict/ZA_D_LGLY' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纳入工作依据：</span><span name='nrgzyj' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='zdrkxxb'/><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");	
	return sb.toString();
}

/****************************************************涉公安访******************************************************************************************/
//涉公安访
function info_sgaf_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>是否协控：</span><span name='sfxk' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>申请协控单位：</span><span name='sqxkdwmc' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>信访诉求及滋事情况：</span><span name='xfsqjzsqk' class='edit_word input_w1'></span></li>");	
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='sgafzdryxxb' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");	
	return sb.toString();
}

/****************************************************社区矫正******************************************************************************************/
function info_sqjz_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>监管单位机构名称：</span><span name='jgdw_gajgmc' class='edit_word input_w2'></span></li>");	
	sb.append("<li><span class='spantitle'>犯罪性质：</span><span name='fzxzdm' dict='/common/dict/DL_D_FZXZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>违法嫌疑人处理结果：</span><span name='wfxyrcljgdm' dict='/common/dict/XZ_D_WFXYRCLJGDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>判决机关名称：</span><span name='pjjgmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>考验截止日期：</span><span name='ky_jzrq' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='sqjz' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");		
	return sb.toString();
}

/****************************************************监管对象******************************************************************************************/
//监管对象
function info_jgdx_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>监管类别：</span><span name='jglbdm' dict='/common/dict/DL_D_JGLBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>监管单位：</span><span name='jgdwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>犯罪性质：</span><span name='fzxzdm' dict='/common/dict/DL_D_FZXZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>处理结果：</span><span name='wfxyrcljgdm' dict='/common/dict/XZ_D_WFXYRCLJGDM'  class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>判决机关：</span><span name='pjjgmc' class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jgdxxxb' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	return sb.toString(); 
}

/****************************************************肇事肇祸精神病人******************************************************************************************/
//肇事肇祸精神病人
function info_jsbr_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>精神病类别：</span><span name='jsblbdm' dict='/common/dict/DL_D_JSBLBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否已肇事滋事：</span><span name='sfyzszsdm' dict='/common/dict/DL_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否持证：</span><span name='sfcjslcjzdm' dict='/common/dict/DL_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>鉴定机构：</span><span name='jdjg' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件取得时间：</span><span name='zjqdsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>简要案情：</span><span name='jyaq' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>精神病成因：</span><span name='jsbcy' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='zszhjsbrxxb' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");	
	return sb.toString();
}

/****************************************************非正常上访******************************************************************************************/
function info_fzcsf_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>信息上报：</span><span name='xxsb' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>上访原因：</span><span name='sfyy'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>交控部门：</span><span name='jkbm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>交控级别：</span><span name='jkjbdm' dict='/common/dict/DL_D_JKJBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>上访人员类别：</span><span name='sfrylbdm' dict='/common/dict/DL_D_SFRYLBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>已解决事项：</span><span name='yjjsfsx'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>未解决事项：</span><span name='wjjsfsx' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>制造舆论地点：</span><span name='zzyldd' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>接访部门：</span><span name='jfbm' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>涉访处罚情况：</span><span name='cfqk'  class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='fzcfryxxb' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	return sb.toString();
}

/****************************************************涉枪涉暴******************************************************************************************/
function info_sqsb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");	
	sb.append("<li><span class='spantitle'>重点人员管理方法：</span><span name='glffdm' dict='/common/dict/BD_D_ZDRKGLFFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>列管来源：</span><span name='lglydm' dict='/common/dict/BD_D_LGLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纳入工作依据：</span><span name='nrgzyj' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>案件类别代码：</span><span name='ajlbdm'  dict='/common/dict/BD_D_SQSBZDRYSALBDM'  class='edit_word input_w1'></span></li>");	
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='sqsbzdry' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	return sb.toString();
}

/****************************************************涉环保重点人员******************************************************************************************/
//可能不用了，涉环保 不关联 人员基本表 和 实有人口表，所以不在这显示了
function info_shb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>是否死亡代码：</span><span name='sfswdm' dict='/common/dict/BD_D_SFDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>案件类别代码：</span><span name='ajlbdm'  dict='/common/dict/XZ_D_AJLBDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>作案特点代码：</span><span name='zatddm' dict='/common/dict/XZ_D_ZATDDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>简要案情：</span><span name='jyaq' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>处罚结果：</span><span name='cfjg'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>经常活动地区：</span><span name='jchddq'   class='edit_word input_w1'></span></li>"); 
	sb.append("<li><span class='spantitle'>简历：</span><span name='jl' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>指纹编号：</span><span name='zwbh' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>数据密级：</span><span name='sjmj' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>人口编码：</span><span name='rkbm' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='shbzdry' read='true' />");
	sb.append("</ul>");	
	return sb.toString(); 
}

/****************************************************附件信息******************************************************************************************/
//附件信息
function info_fjxx_(){
	var sb = new StringBuffer();
	sb.append("<ul level='1'>");
	sb.append("<input type='hidden' name='id' /><input type='hidden'  name='method' fj='true' value='fjxx' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryFjUploadPre' />");
	sb.append("</ul>");
	return sb.toString();
}
//帮教力量
function info_bjllMenu_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_jkbjryxxb' level='2'><li class='uline' ><span>帮教力量信息</span>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jkbjryxxb' /><input type='hidden' name='editUrl' value='/zdryJkbjllxxb/queryDetail?={id}' /></ul>");
	sb.append("<div class='clear'></div>");	
	return sb.toString();
}

function info_jkbjryxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>监控帮教类型：</span><span name='jkbjlxdm' dict='/common/dict/DL_D_JKBJLXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>与重点人员关系：</span><span name='jkbjry_ybbjr_rygx' dict='/common/dict/ZA_D_SHGXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人身份号码：</span><span name='jkbjry_gmsfhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人姓名：</span><span name='jkbjry_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人性别：</span><span name='jkbjry_xbdm' dict='/common/dict/GB_D_XBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人民族：</span><span name='jkbjry_mzdm' dict='/common/dict/GB_D_MZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人政治面貌：</span><span name='jkbjry_zzmmdm' dict='/common/dict/GB_D_ZZMMDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人联系电话：</span><span name='jkbjry_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人现住详址：</span><span name='dz_jkbjry_xjzdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人工作单位：</span><span name='jkbjry_gzdwmc' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>帮教人职务：</span><span name='jkbjry_zwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//请销假登记
function info_qxjdjbMenu_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_qxjdjb' level='2'><li class='uline' ><span>请销假登记信息</span>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='qxjdjb' /><input type='hidden' name='editUrl' value='/zdryJgdxqxjdjb/queryDetail?={id}' /></ul>");
	sb.append("<div class='clear'></div>");	
	return sb.toString();
}
function info_qxjdjb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>请假日期：</span><span name='qjrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>请假原因：</span><span name='qjyy' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>去往地：</span><span name='qwxzqhdm' dict='/common/dict/GB_D_XZQHDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>去往地详址：</span><span name='qwxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>预计返回日期：</span><span name='yjfh_rq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>实际返回日期：</span><span name='sjfh_rq' class='edit_word input_w2'></span></li>");	
	sb.append("<li><span class='spantitle'>审批人：</span><span name='spr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批时间：</span><span name='spsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批结果：</span><span name='spjg'  dict='/common/dict/D_GG_SPJG'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批意见：</span><span name='spyj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>销假日期：</span><span name='xjrq' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();	
}

//评审鉴定
function info_psjdbMenu_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_psjdb' level='2'><li class='uline' ><span>评审鉴定信息</span>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='psjdb' /><input type='hidden' name='editUrl' value='/zdryPsjdb/queryDetail?={id}' /></ul>");
	sb.append("<div class='clear'></div>");	
	return sb.toString();
}
function info_psjdb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>评议时间：</span><span name='py_sj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>评议地点：</span><span name='pydd' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>参加人员：</span><span name='cjry' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>内容纪要：</span><span name='nrjy' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();	
}

