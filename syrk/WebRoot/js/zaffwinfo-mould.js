var refresh ="<div class='uline_rt' style='display:none'><a class='ulup_btn ulrt_btn1' href='javascript:void(0);'></a><a class='ulrefresh_btn ulrt_btn1' href='javascript:void(0);'></a></div>";

//社区基本信息
function info_sqjbxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul class='003A'>");
	sb.append("<li><span class='spantitle'>社区名称：</span><span name='sqmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>办公室电话：</span><span name='bgsdh' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>社区地址：</span><span name='dz_sqdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件：</span><span name='sqfzrcyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号：</span><span name='sqfzrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='sqfzrxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人电话：</span><span name='sqfzrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='sqjbxxb' /><input type='hidden' name='openUrl' value='/sqjbxxb/addSqjbxxb' />");
	sb.append("</ul>");
	
	sb.append("<ul url='info_sqwyhcyb' level='2'><li class='uline' ><span>社区委员会成员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='sqwyhcyb' /><input type='hidden' name='openUrl' value='/sqwyhcyb/addSqwyhcyb' /></ul>");
	sb.append("<div class='clear'></div>");
	
	sb.append("<ul url='info_sqzdbwb' level='2'><li class='uline' ><span>社区重点部位</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='sqzdbwb' /><input type='hidden' name='openUrl' value='/sqzdbwb/addSqzdbwb' /></ul>");
	sb.append("<div class='clear'></div>");
	
	sb.append("<ul url='info_sqzbhb' level='2'><li class='uline' ><span>社区治保会</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='sqzbhb' /><input type='hidden' name='openUrl' value='/sqzbhb/addSqzbhb' /></ul>");
	sb.append("<div class='clear'></div>");
	
	sb.append("<ul url='info_zazzryxxb' level='2'><li class='uline' ><span>治安组织人员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zazzryxxb' /><input type='hidden' name='openUrl' value='/zazzryxxb/addZazzryxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	
	
	
	return sb.toString();
};

//社区委员会成员
function info_sqwyhcyb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>文化程度：</span><span name='whcddm'  dict='/common/dict/D_BZ_WHCD' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>政治面貌：</span><span name='zzmmdm' dict='/common/dict/D_BZ_ZZMM' class='edit_word input_w2'></span></li>");
	
	sb.append("<li><span class='spantitle'>职务：</span><span name='zw' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>分管工作描述：</span><span name='fggzms' class='edit_word input_w1'></span></li>");
	
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>家庭住址：</span><span name='dz_jtzzxz' class='edit_word input_w1'></span></li>");	
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//社区重点部位
function info_sqzdbwb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重点部位名称：</span><span name='zdbwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>重点部位类型：</span><span name='dz_zdbwlxdm' dict='/common/dict/D_ZAFF_ZDBWLX'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>确定日期：</span><span name='qdrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>部位描述：</span><span name='bwms' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>重点部位地址：</span><span name='dz_zdbwxz' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//治安组织人员
function info_zazzryxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>文化程度：</span><span name='whcddm'  dict='/common/dict/D_BZ_WHCD' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>政治面貌：</span><span name='zzmmdm' dict='/common/dict/D_BZ_ZZMM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系方式：</span><span name='lxfs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>人员来源：</span><span name='ryly' class='edit_word input_w2'></span></li>");	
	sb.append("<li><span class='spantitle'>参加时间：</span><span name='cjsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织内职务：</span><span name='zznzw' class='edit_word input_w2'></span></li>");	
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//保安组织人员
function info_bazzryxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>文化程度：</span><span name='whcddm'  dict='/common/dict/D_BZ_WHCD' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>政治面貌：</span><span name='zzmmdm' dict='/common/dict/D_BZ_ZZMM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系方式：</span><span name='lxfs' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//社区民警
function info_sqmjxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>常用证件：</span><span name='cyzjdm'  dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>警号：</span><span name='jh'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/D_BZ_MZ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>文化程度：</span><span name='whcddm' dict='/common/dict/D_BZ_WHCD' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>政治面貌：</span><span name='zzmmdm' dict='/common/dict/D_BZ_ZZMM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>婚姻状况：</span><span name='hyzkdm' dict='/common/dict/D_BZ_HYZK' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>血型：</span><span name='xxdm' dict='/common/dict/D_BZ_XX' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>健康状况：</span><span name='jkzkdm' dict='/common/dict/D_RK_JKZK' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>参加工作日期：</span><span name='cjgzrq'   class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>入警日期：</span><span name='cjgagzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>任职日期：</span><span name='rzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>任职机构名称：</span><span name='rzjgmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>警衔：</span><span name='jx'  dict='/common/dict/D_RK_JX'class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>岗位：</span><span name='gwdm' dict='/common/dict/D_RK_GW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职务：</span><span name='zw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职级：</span><span name='zjdm' dict='/common/dict/D_RK_ZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>警种：</span><span name='jzdm' dict='/common/dict/D_RK_JZ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>社区兼任职务描述：</span><span name='sqjrzwms' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>警员状态：</span><span name='jyztdm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>登录帐号：</span><span name='dlzh' class='edit_word input_w2'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='sqmjxxb' /><input type='hidden' name='openUrl' value='/sqmjxxb/addSqmjxxb' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
};
//社区治保会
function info_sqzbhb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>负责人常用证件：</span><span name='fzrcyzjdm'  dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号码：</span><span name='fzrzjhm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='fzrxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系方式：</span><span name='fzrlxfs'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织名称：</span><span name='zzmc'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织类别：</span><span name='zzlb' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织形式：</span><span name='zzxsdm' dict='/common/dict/D_ZAFF_ZBHZZXS' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>地域类别：</span><span name='dylbdm' dict='/common/dict/D_ZAFF_DYLB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>治保会地址：</span><span name='dz_zbhdzxz'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>责任范围：</span><span name='zrfw'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>装备配置情况：</span><span name='zbpzqk'   class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>隶属关系：</span><span name='lsgxdm' dict='/common/dict/D_ZAFF_LSGX' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经费来源：</span><span name='jfly'  class='edit_word input_w2'></span></li>");
	
	sb.append("<li><span class='spantitle'>职务：</span><span name='zw'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>分管工作描述：</span><span name='fggzms'  class='edit_word input_w1'></span></li>");
	
	sb.append("<li><span class='spantitle'>作用情况：</span><span name='zyqk'   class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否治安承包：</span><span name='sfzacbdm'  dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组建日期：</span><span name='zjrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织联系方式：</span><span name='zzlxfs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织传真号码：</span><span name='zzczhm' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//保安组织
function info_bazzb_(){
	var sb = new StringBuffer();
	sb.append("<ul  class='003A'>");
	sb.append("<li><span class='spantitle'>负责人常用证件：</span><span name='fzrcyzjdm'  dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号码：</span><span name='fzrzjhm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='fzrxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系方式：</span><span name='fzrlxfs'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织名称：</span><span name='zzmc'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织类别：</span><span name='zzlb' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织形式：</span><span name='zzxsdm'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>地域类别：</span><span name='dylbdm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>保安组织地址：</span><span name='bazzdzdzxz'  class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>责任范围：</span><span name='zrfw'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>装备配置情况：</span><span name='zbpbqk'   class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>隶属关系：</span><span name='lsgxdm'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经费来源：</span><span name='jfly'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>作用情况：</span><span name='zyqk'   class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否治安承包：</span><span name='sfzacbdm'  dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组建日期：</span><span name='zjrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织联系方式：</span><span name='zzlxfs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织传真号码：</span><span name='zzczhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>所属单位：</span><span name='ssdw' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' id='bazzid'/><input type='hidden' name='method' value='bazzb' /><input type='hidden' name='openUrl' value='/bazzb/addBazzb' />");
	sb.append("</ul>");
	sb.append("<ul url='info_bazzryxxb' level='2'><li class='uline' ><span>保安组织人员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='bazzryxxb' /><input type='hidden' name='openUrl' value='/bazzryxxb/addBazzryxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	
	return sb.toString();
}