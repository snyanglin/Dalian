var refresh ="<div class='uline_rt' style='display:none'><a class='ulup_btn ulrt_btn1' href='javascript:void(0);'></a><a class='ulrefresh_btn ulrt_btn1' href='javascript:void(0);'></a></div>";

//反馈信息
function info_fankui_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_fankuixx' level='2'><li class='uline' ><span>反馈信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='fankuixx' /><input type='hidden' name='openUrl' value='/jcj/addFkxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
};

//反馈信息
function info_fankuixx_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>警情处理结果：</span><span name='jqcl_jg'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>出警情况：</span><span name='cjqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>警情发生时间：</span><span name='jqfs_sj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>警情结束时间：</span><span name='jqjs_sj'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>警情等级：</span><span name='jqdjdm' dict='/common/dict/D_JCJ_JQDJDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>抓获人数：</span><span name='zh_rs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>涉案人数：</span><span name='sa_rs' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='rylxfszb' /><input type='hidden' name='openUrl' value='/jcj/addFkxxb' />");

	sb.append("</ul>");
	return sb.toString();
}



