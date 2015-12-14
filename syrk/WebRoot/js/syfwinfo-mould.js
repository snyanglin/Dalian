var refresh ="<div class='uline_rt' style='display:none'><a class='ulup_btn ulrt_btn1' href='javascript:void(0);'></a><a class='ulrefresh_btn ulrt_btn1' href='javascript:void(0);'></a></div>";


//出租房屋信息
function info_czfwzb_(){
	var sb = new StringBuffer();
	sb.append("<ul class='003A'>");
	sb.append("<li><span class='spantitle'>治安责任人：</span><span name='zazrr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任书签订日期：</span><span name='zrs_qd_rq' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>出租人姓名：</span><span name='czur_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出租人联系电话：</span><span name='czur_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出租房间数：</span><span name='cz_fjs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出租面积(平方米)：</span><span name='cz_mjpfm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>承租人数：</span><span name='czrs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出租日期：</span><span name='cz_rq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>租金(元/月)：</span><span name='zj' class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='czfwzb' /><input type='hidden' name='openUrl' value='/czfw/create' />");
	sb.append("</ul>");
	sb.append("<ul url='info_czqkdjxx' level='2'><li class='uline' ><span>承租情况登记信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='czqkdjxx' /><input type='hidden' name='openUrl' value='/syfw/addCzqk' /></ul>");
	
	sb.append("<ul url='info_czfjcxx' level='2'><li class='uline' ><span>出租房屋检查信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='czfjcxx' /><input type='hidden' name='openUrl' value='/syfw/addCzfwjc' /></ul>");
	
	sb.append("<div class='clear'></div>");
	
	return sb.toString();
};

//附件信息
function info_fjxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_fjxx' level='1'>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' fj='true' value='fjxx' /><input type='hidden' name='openUrl' value='/syfw/fjxx' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
	
}

//附件信息
function info_zpxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_zpxx' level='1'>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' image='true' value='zpxx' /><input type='hidden' name='openUrl' value='' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
	
}

//出租房屋检查信息
function info_czfjcxx_(){
	var sb = new StringBuffer();
	sb.append("<ul>");	
	sb.append("<li><span class='spantitle'>检查日期：</span><span name='jcrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>检查人姓名：</span><span name='jcr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>检查单位：</span><span name='jcdw_gajgmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>简要情况：</span><span name='jcqk_jyqk' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method2' value='czfjcxx' /><input type='hidden' name='openUrl' value='/syfw/addCzfwjc' />");
	sb.append("</ul>");
	return sb.toString();
}

//承租情况登记信息
function info_czqkdjxx_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>承租人姓名：</span><span name='chzr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>承租人证件号码：</span><span name='chzr_zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>承租人联系电话：</span><span name='chzr_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>房屋承租情况：</span><span name='fwczqkdm' dict='/common/dict/D_BZ_FWCZQKDM' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method2' value='czqkdjxx' /><input type='hidden' name='openUrl' value='/syfw/addCzfwjc' />");
	sb.append("</ul>");
	return sb.toString();
}
