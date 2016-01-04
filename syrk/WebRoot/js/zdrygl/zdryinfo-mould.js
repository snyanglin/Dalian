var refresh ="<div class='uline_rt' style='display:none'><a class='ulup_btn ulrt_btn1' href='javascript:void(0);'></a><a class='ulrefresh_btn ulrt_btn1' href='javascript:void(0);'></a></div>";
/************************************select t.*, t.rowid from SYS_XXZSNRB t;********************/


/****************************************************涉环保重点人员******************************************************************************************/
//涉环保
function info_shbzdry_(){
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
	sb.append("<ul url='info_lgxx' level='2'><li class='uline' ><span>列管信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='lgxx' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString(); 
}

/****************************************************监管对象******************************************************************************************/
//监管对象
function info_jgdx_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>监管类别：</span><span name='jglbdm' dict='/common/dict/DL_D_JGLBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>监管单位：</span><span name='jgdwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>犯罪性质：</span><span name='fzxzdm' dict='/common/dict/BD_D_FZXZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>处理结果：</span><span name='wfxyrcljgdm' dict='/common/dict/DL_D_JGLBDM'  class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>判决机关：</span><span name='pjjgmc' class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jgdxxxb' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	sb.append("<ul url='info_lgxx' level='2'><li class='uline' ><span>列管信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='lgxx' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_qxjdjb' level='2'><li class='uline' ><span>请销假登记</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='qxjdjb' /><input type='hidden' name='openUrl' value='/zdryJgdxqxjdjb/add' /><input type='hidden' name='editUrl' value='/zdryJgdxqxjdjb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_psjdb' level='2'><li class='uline' ><span>评审鉴定</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='psjdb' /><input type='hidden' name='openUrl' value='/zdryPsjdb/add' /><input type='hidden' name='editUrl' value='/zdryPsjdb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dtgljsb' level='2'><li class='uline' ><span>动态管理纪实</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dtgljsb' /><input type='hidden' name='openUrl' value='/zdryDtgljsxxb/add' /><input type='hidden' name='editUrl' value='/zdryDtgljsxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zdrykcb' level='2'><li class='uline' ><span>重点人员考察</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zdrykcb' /><input type='hidden' name='openUrl' value='/zdryZdrykcxxb/add' /><input type='hidden' name='editUrl' value='/zdryZdrykcxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_jkbjryxxb' level='2'><li class='uline' ><span>帮教力量</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jkbjryxxb' /><input type='hidden' name='openUrl' value='/zdryJkbjllxxb/add' /><input type='hidden' name='editUrl' value='/zdryJkbjllxxb/queryDetail' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zagltdb' level='2'><li class='uline' ><span>作案规律特点</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zagltdb' /><input type='hidden' name='openUrl' value='/zdryZagltdxxb/add' /><input type='hidden' name='editUrl' value='/zdryZagltdxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wffzjlb' level='2'><li class='uline' ><span>违法犯罪记录</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wffzjlb' /><input type='hidden' name='openUrl' value='/zdryWffzjlxxb/add' /><input type='hidden' name='editUrl' value='/zdryWffzjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_syrkfj' level='2'><li class='uline' ><span>附件</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='fjxx' fj='true' /><input type='hidden' name='openUrl' value='/zdryEdit/fjEdit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString(); 
}
//请销假登记
function info_qxjdjb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>请假日期：</span><span name='qjrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>请假原因：</span><span name='qjyy' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>去往地：</span><span name='qwxzqhdm' dict='/common/dict/GB_D_XZQHDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>去往地详址：</span><span name='qwxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>预计返回日期：</span><span name='yjfh_rq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>实际返回日期：</span><span name='sjfh_rq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>销假日期：</span><span name='xjrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批人：</span><span name='spr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批时间：</span><span name='spsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批结果：</span><span name='spjg'  dict='/common/dict/D_GG_SPJG'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>审批意见：</span><span name='spyj' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//评审鉴定
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
//动态管理纪实
function info_dtgljsb_(){
	
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>是否在控：</span><span name='sfzkdm' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纪实类型：</span><span name='jslxdm' dict='/common/dict/BD_D_JSLXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纪实民警：</span><span name='dtjsmj_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纪实时间：</span><span name='js_sj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纪实内容：</span><span name='dtjs' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//列管信息
function info_lgxx_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>列管申请人：</span><span name='sqr'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>列管申请时间：</span><span name='sqsj'   class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>列管审批人：</span><span name='spr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>列管审批时间：</span><span name='spsj' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//重点人员考察
function info_zdrykcb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>考察周期：</span><span name='kczqdm' dict='/common/dict/DL_D_KCZQDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>考察年份：</span><span name='kcnf' nullToShow='false' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>考察季度：</span><span name='kcjd' nullToShow='false' dict='/common/dict/DL_D_JDDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>考察月份：</span><span name='kcyf' nullToShow='false' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>考察情况：</span><span name='kcqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>考察民警：</span><span name='kcmjxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>考察时间：</span><span name='kc_sj' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//物建监控/帮教力量
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



/****************************************************重点人口******************************************************************************************/
//重点人口
function info_zdrk_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>管理方法：</span><span name='glffdm' dict='/common/dict/ZA_D_ZDRKGLFF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>列管来源：</span><span name='lglydm' dict='/common/dict/ZA_D_LGLY' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纳入工作依据：</span><span name='nrgzyj' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='zdrkxxb'/><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	sb.append("<ul url='info_lgxx' level='2'><li class='uline' ><span>列管信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='lgxx' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dtgljsb' level='2'><li class='uline' ><span>动态管理纪实</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dtgljsb' /><input type='hidden' name='openUrl' value='/zdryDtgljsxxb/add' /><input type='hidden' name='editUrl' value='/zdryDtgljsxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zdrykcb' level='2'><li class='uline' ><span>重点人员考察</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zdrykcb' /><input type='hidden' name='openUrl' value='/zdryZdrykcxxb/add' /><input type='hidden' name='editUrl' value='/zdryZdrykcxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zagltdb' level='2'><li class='uline' ><span>作案规律特点</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zagltdb' /><input type='hidden' name='openUrl' value='/zdryZagltdxxb/add' /><input type='hidden' name='editUrl' value='/zdryZagltdxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wffzjlb' level='2'><li class='uline' ><span>违法犯罪记录</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wffzjlb' /><input type='hidden' name='openUrl' value='/zdryWffzjlxxb/add' /><input type='hidden' name='editUrl' value='/zdryWffzjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	
	sb.append("<ul url='info_zdryXdryxxb' level='2'><li class='uline' ><span>吸毒信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zdryXdryxxb' /><input type='hidden' name='openUrl' value='/zdryXdryxdxx/add' /><input type='hidden' name='editUrl' value='/zdryXdryxdxx/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	
	sb.append("<ul url='info_zdryXdrynjxx' level='2'><li class='uline' ><span>尿检信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zdryXdrynjxx' /><input type='hidden' name='openUrl' value='/zdryXdrynjxx/add' /><input type='hidden' name='editUrl' value='/zdryXdrynjxx/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	
/*	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' dict='/common/dict/BD_D_ZDRYLBDM'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>指定列管单位：</span><span name='xt_lrrbm'   class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>管理方法：</span><span name='glffdm' dict='/common/dict/ZA_D_ZDRKGLFF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>列管来源：</span><span name='lglydm' dict='/common/dict/ZA_D_LGLY' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纳入工作依据：</span><span name='nrgzyj' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='zdrkxxb'/><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");*/
	
/*	sb.append("<ul url='info_zdryXdryxxb' level='2'><li class='uline' ><span>吸毒信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='info_zdryXdryxxb' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	*/
	sb.append("<ul url='info_syrkfj' level='2'><li class='uline' ><span>附件</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden'name='method2' value='fjxx' fj='true' /><input type='hidden' name='openUrl' value='/zdryEdit/fjEdit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}



/****************************************************肇事肇祸精神病人******************************************************************************************/
//肇事肇祸精神病人
function info_jsbr_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>精神病类别：</span><span name='jsblbdm' dict='/common/dict/BD_D_JSBLBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否已肇事滋事：</span><span name='sfyzszsdm' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否持证：</span><span name='sfcjslcjzdm' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>鉴定机构：</span><span name='jdjg' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件取得时间：</span><span name='zjqdsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>简要案情：</span><span name='jyaq' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>精神病成因：</span><span name='jsbcy' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='zszhjsbrxxb' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	sb.append("<ul url='info_lgxx' level='2'><li class='uline' ><span>列管信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='lgxx' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dtgljsb' level='2'><li class='uline' ><span>动态管理纪实</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dtgljsb' /><input type='hidden' name='openUrl' value='/zdryDtgljsxxb/add' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zagltdb' level='2'><li class='uline' ><span>作案规律特点</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zagltdb' /><input type='hidden' name='openUrl' value='/zdryZagltdxxb/add' /><input type='hidden' name='editUrl' value='/zdryZagltdxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wffzjlb' level='2'><li class='uline' ><span>违法犯罪记录</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wffzjlb' /><input type='hidden' name='openUrl' value='/zdryWffzjlxxb/add' /><input type='hidden' name='editUrl' value='/zdryWffzjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_syrkfj' level='2'><li class='uline' ><span>附件</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='fjxx' fj='true' /><input type='hidden' name='openUrl' value='/zdryEdit/fjEdit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

/****************************************************轻微滋事精神病人******************************************************************************************/
//轻微滋事精神病人
function info_qwjsbr_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>精神病类别：</span><span name='jsblbdm' dict='/common/dict/BD_D_JSBLBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否已肇事滋事：</span><span name='sfyzszsdm' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否持证：</span><span name='sfcjslcjzdm' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>鉴定机构：</span><span name='jdjg' dict='/common/dict/BD_D_SFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件取得时间：</span><span name='zjqdsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>简要案情：</span><span name='jyaq' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>精神病成因：</span><span name='jsbcy' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='zszhjsbrxxb' /><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	sb.append("<ul url='info_lgxx' level='2'><li class='uline' ><span>列管信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='lgxx' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dtgljsb' level='2'><li class='uline' ><span>动态管理纪实</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dtgljsb' /><input type='hidden' name='openUrl' value='/zdryDtgljsxxb/add' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zagltdb' level='2'><li class='uline' ><span>作案规律特点</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zagltdb' /><input type='hidden' name='openUrl' value='/zdryZagltdxxb/add' /><input type='hidden' name='editUrl' value='/zdryZagltdxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wffzjlb' level='2'><li class='uline' ><span>违法犯罪记录</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wffzjlb' /><input type='hidden' name='openUrl' value='/zdryWffzjlxxb/add' /><input type='hidden' name='editUrl' value='/zdryWffzjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_syrkfj' level='2'><li class='uline' ><span>附件</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='fjxx' fj='true' /><input type='hidden' name='openUrl' value='/zdryEdit/fjEdit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}


/****************************************************非正常访******************************************************************************************/
//非正常访
function info_fzcf_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz'  class='edit_word input_w2'></span></li>");
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
	sb.append("<ul url='info_lgxx' level='2'><li class='uline' ><span>列管信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='lgxx' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dtgljsb' level='2'><li class='uline' ><span>动态管理纪实</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dtgljsb' /><input type='hidden' name='openUrl' value='/zdryDtgljsxxb/add' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zagltdb' level='2'><li class='uline' ><span>作案规律特点</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zagltdb' /><input type='hidden' name='openUrl' value='/zdryZagltdxxb/add' /><input type='hidden' name='editUrl' value='/zdryZagltdxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wffzjlb' level='2'><li class='uline' ><span>违法犯罪记录</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wffzjlb' /><input type='hidden' name='openUrl' value='/zdryWffzjlxxb/add' /><input type='hidden' name='editUrl' value='/zdryWffzjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_syrkfj' level='2'><li class='uline' ><span>附件</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='fjxx' fj='true' /><input type='hidden' name='openUrl' value='/zdryEdit/fjEdit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}


/****************************************************纳入视线******************************************************************************************/
//纳入视线
function info_nrsx_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>主要问题及现实表现：</span><span name='zywtjxsbx' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='nrsxdxxxb'/><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	sb.append("<ul url='info_lgxx' level='2'><li class='uline' ><span>列管信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='lgxx' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dtgljsb' level='2'><li class='uline' ><span>动态管理纪实</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dtgljsb' /><input type='hidden' name='openUrl' value='/zdryDtgljsxxb/add' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zagltdb' level='2'><li class='uline' ><span>作案规律特点</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zagltdb' /><input type='hidden' name='openUrl' value='/zdryZagltdxxb/add' /><input type='hidden' name='editUrl' value='/zdryZagltdxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wffzjlb' level='2'><li class='uline' ><span>违法犯罪记录</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wffzjlb' /><input type='hidden' name='openUrl' value='/zdryWffzjlxxb/add' /><input type='hidden' name='editUrl' value='/zdryWffzjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_syrkfj' level='2'><li class='uline' ><span>附件</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='fjxx' fj='true' /><input type='hidden' name='openUrl' value='/zdryEdit/fjEdit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}
/****************************************************涉枪涉爆******************************************************************************************/
//重点人口
function info_sqsb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点人员类别：</span><span name='bz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>管理方法：</span><span name='glffdm' dict='/common/dict/BD_D_ZDRKGLFFDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>列管来源：</span><span name='lglydm' dict='/common/dict/BD_D_LGLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>纳入工作依据：</span><span name='nrgzyj' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>案件类别代码：</span><span name='ajlbdm' dict='/common/dict/BD_D_SQSBZDRYSALBDM'  class='edit_word input_w1'></span></li>");
	
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='sqsbxxb'/><input type='hidden' name='openUrl' value='/zdryEdit/zdryUpdatePre' />");
	sb.append("</ul>");
	sb.append("<ul url='info_lgxx' level='2'><li class='uline' ><span>列管信息</span></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='lgxx' /><input type='hidden' name='openUrl' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dtgljsb' level='2'><li class='uline' ><span>动态管理纪实</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dtgljsb' /><input type='hidden' name='openUrl' value='/zdryDtgljsxxb/add' /><input type='hidden' name='editUrl' value='/zdryDtgljsxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zdrykcb' level='2'><li class='uline' ><span>重点人员考察</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zdrykcb' /><input type='hidden' name='openUrl' value='/zdryZdrykcxxb/add' /><input type='hidden' name='editUrl' value='/zdryZdrykcxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zagltdb' level='2'><li class='uline' ><span>作案规律特点</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zagltdb' /><input type='hidden' name='openUrl' value='/zdryZagltdxxb/add' /><input type='hidden' name='editUrl' value='/zdryZagltdxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wffzjlb' level='2'><li class='uline' ><span>违法犯罪记录</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wffzjlb' /><input type='hidden' name='openUrl' value='/zdryWffzjlxxb/add' /><input type='hidden' name='editUrl' value='/zdryWffzjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");

	sb.append("<ul url='info_syrkfj' level='2'><li class='uline' ><span>附件</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden'name='method2' value='fjxx' fj='true' /><input type='hidden' name='openUrl' value='/zdryEdit/fjEdit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

/****************************************************一般关注对象******************************************************************************************/
//一般关注对象
function info_ybgzdx_(){
	var sb = new StringBuffer();

	sb.append("<ul url='info_dtgljsb' level='2'><li class='uline' ><span>动态管理纪实</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dtgljsb' /><input type='hidden' name='openUrl' value='/zdryDtgljsxxb/add' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_zagltdb' level='2'><li class='uline' ><span>作案规律特点</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zagltdb' /><input type='hidden' name='openUrl' value='/zdryZagltdxxb/add' /><input type='hidden' name='editUrl' value='/zdryZagltdxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wffzjlb' level='2'><li class='uline' ><span>违法犯罪记录</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wffzjlb' /><input type='hidden' name='openUrl' value='/zdryWffzjlxxb/add' /><input type='hidden' name='editUrl' value='/zdryWffzjlxxb/{id}' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_syrkfj' level='2'><li class='uline' ><span>附件</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='fjxx' fj='true' /><input type='hidden' name='openUrl' value='/zdryEdit/fjEdit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}


/****************************************************日常管控******************************************************************************************/
//作案规律特点
function info_zagltdb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>案件类别：</span><span name='ajlbdm' dict='/common/dict/XZ_D_AJLBDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>选择对象：</span><span name='xzdxdm' dict='/common/dict/XZ_D_XZDXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>选择物品：</span><span name='xzwpdm' dict='/common/dict/XZ_D_XZWPDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>作案手段：</span><span name='zasddm' dict='/common/dict/XZ_D_ZASDDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>作案工具：</span><span name='zagjdm' dict='/common/dict/XZ_D_ZAGJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>销赃方式：</span><span name='xyrxzfsdm' dict='/common/dict/XZ_D_XZFSFLHDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>作案特点：</span><span name='zatddm' dict='/common/dict/XZ_D_ZATDDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>选择时机：</span><span name='xzsjdm' dict='/common/dict/XZ_D_XZSJDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>选择处所：</span><span name='xzcsdm' dict='/common/dict/XZ_D_XZCSDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//违法犯罪记录
function info_wffzjlb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>案件编号：</span><span name='ajbh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>案件名称：</span><span name='ajmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>案件类型：</span><span name='ajlxdm' dict='/common/dict/DL_D_AJLXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>人员涉案类型：</span><span name='rysalxdm' dict='/common/dict/ZA_D_RYSALXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>涉刑事案件类别：</span><span name='sxs_ajlbdm' nullToShow='false' dict='/common/dict/D_BZ_SXSAJLB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>涉行政案件类别：</span><span name='sxz_ajlbdm' nullToShow='false' dict='/common/dict/BD_D_AYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>案发日期：</span><span name='af_rq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>案发地点行政区划：</span><span name='afdd_xzqhdm' dict='/common/dict/D_BZ_XZQHLIST' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>案发地点详址：</span><span name='afddxz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>涉案情节及处理结果：</span><span name='saqjjcljg' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>处理单位：</span><span name='cl_dwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>办案民警：</span><span name='bamj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>问题性质：</span><span name='wtxzdm' dict='/common/dict/BD_D_WTXZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>处罚机关：</span><span name='cfjg' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>处罚时间：</span><span name='cfsj' class='edit_word input_w2'></span></li>");	
	sb.append("<li><span class='spantitle'>执行机关：</span><span name='zxjg' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>执行地点：</span><span name='zxdd' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>执行开始时间：</span><span name='zx_kssj' class='edit_word input_w2'></span></li>");	
	sb.append("<li><span class='spantitle'>执行结束时间：</span><span name='zx_jssj' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

function info_zdryXdryxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>毒品种类：</span><span name='dpzldm'  dict='/common/dict/JD_D_DPZLDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>吸毒方式：</span><span name='xdfsdm'  dict='/common/dict/JD_D_XDFSDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>毒品来源：</span><span name='dplydm'  dict='/common/dict/JD_D_DPLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>毒资来源：</span><span name='dzlydm' dict='/common/dict/JD_D_DZLYDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>吸毒原因：</span><span name='xdyydm'  dict='/common/dict/JD_D_XDYYDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>查获机构名称：</span><span name='chjgmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>共同吸毒情况：</span><span name='gtxdqk' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>危害社会后果：</span><span name='whshhg' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>初次吸毒种类：</span><span name='ccxdzldm' dict='/common/dict/JD_D_DPZLDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>初次吸毒日期：</span><span name='ccxd_rq' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>初次查获日期：</span><span name='ccch_rq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>初次查获处置情况：</span><span name='ccchczqkdm'  dict='/common/dict/BD_D_CHCZQKDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>初次查获详址：</span><span name='ccchxz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>吸毒人员现状：</span><span name='xdryxzdm'  dict='/common/dict/BD_D_XDRYXZDM' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>戒毒情况：</span><span name='jdqk' class='edit_word input_w2'></span></li>");	
	sb.append("<li><span class='spantitle'>复吸次数：</span><span name='fxcs' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>复吸日期：</span><span name='fxrq' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>复吸毒品种类：</span><span name='fxcs' dict='/common/dict/JD_D_DPZLDM' class='edit_word input_w1'></span></li>");	
	sb.append("<li><span class='spantitle'>复吸查获处置情况：</span><span name='fxdpzldm' dict='/common/dict/BD_D_CHCZQKDM' class='edit_word input_w2'></span></li>");	
	sb.append("<li><span class='spantitle'>复吸查获处置单位：</span><span name='fxchczdwdm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>复吸查获详址：</span><span name='fxchxz' class='edit_word input_w2'></span></li>");

	sb.append("<li class='uline2'></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

function info_zdryXdrynjxx_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>尿检日期：</span><span name='nj_rq'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>尿检结果：</span><span name='njjgdm'  dict='/common/dict/JD_D_NJJGDM'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>签到日期：</span><span name='qd_rq'  class='edit_word input_w2'></span></li>");
	
	sb.append("<li class='uline2'></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

/****************************************************附件信息******************************************************************************************/
//附件信息
function info_syrkfj_(){
	var sb = new StringBuffer();
	sb.append("<ul level='1'>");
	sb.append("<input type='hidden' name='id' /><input type='hidden'  fj='true' value='fjxx' />");
	sb.append("</ul>");
	return sb.toString();
}




