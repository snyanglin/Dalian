var refresh ="<div class='uline_rt' style='display:none'><a class='ulup_btn ulrt_btn1' href='javascript:void(0);'></a><a class='ulrefresh_btn ulrt_btn1' href='javascript:void(0);'></a></div>";
//单位人员信息
function info_dwryxx_(){
	var sb = new StringBuffer();
/*	sb.append("<ul url='info_cyryxxb' level='2'><li class='uline' ><span>从业人员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='cyryxxb' /><input type='hidden' name='openUrl' value='/cyryxxb/createPage' /></ul>");
	sb.append("<div class='clear'></div>");*/
	
	sb.append("<ul url='info_dwfrfzrllyxxb' level='2'><li class='uline' ><span>法人/负责人/联络员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwfrfzrllyxxb' /><input type='hidden' name='openUrl' value='/dwfrfzrllyxxb_dl/createPage' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
};
//从业人员（dg 大类）
function info_cyryxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul><table id='cyrydg' class='easyui-datagrid' data-options='pagination:false,fitColumns:true,singleSelect:true,height:200,"+
    "toolbar:[{text:'导入', handler:import_cyryxxb}, {text:'导出', handler:export_cyryxxb}, {text:'新增', handler:add_cyryxxb}]' style='max-height:200px'>");
	sb.append("<thead><tr>");
	sb.append("<th data-options='field:\'xm\',width:100'>姓名</th>");
	sb.append("<th data-options='field:\'zjhm\',width:100'>证件号码</th>");
	sb.append("<th data-options='field:\'pysj\',width:100'>入职时间</th>");
	sb.append("</tr></thead>");
	sb.append("</table>"); 
	sb.append("<a href='javascript:void(0)' onclick=''>更多...</a>"); 
	sb.append("<input type='hidden' name='method' value='cyryxxb_dg' /><input type='hidden' name='dg' value='true' />");
	sb.append("</ul>");
	return sb.toString();
};

//校园安全信息
function info_xyaqxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul class='003A'>");
	sb.append("<li><span class='spantitle'>学校类别：</span><span name='xxlbdm' dict='/common/dict/D_DW_XXLB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>学校隶属关系：</span><span name='xxlsgxdm' dict='/common/dict/D_DW_XXLSGX' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>办公电话：</span><span name='bbdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>校门数量：</span><span name='xmsl'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>学校人数：</span><span name='xxrs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>校车接送学生数量：</span><span name='xcjsxssl'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安保负责人证件类型：</span><span name='xxabfzrzjlx' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>安保负责人证件号码：</span><span name='xxabfzrzjhm' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>学校安保负责人姓名：</span><span name='xxabfzrxm'  class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>学校安保负责人电话：</span><span name='xxabfzrdh'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>法制副校长证件类型：</span><span name='fzfxzzjlx' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>法制副校长证件号码：</span><span name='fzfxzzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>法制副校长姓名：</span><span name='fzfxzxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>法制副校长电话：</span><span name='fzfxzdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>校园警务室民警姓名：</span><span name='xyjwsmjxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>校园警务室民警电话：</span><span name='xyjwsmjdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>宿舍情况：</span><span name='ssqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>安全等级：</span><span name='aqdj' dict='/common/dict/D_DW_AQDJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有无许可：</span><span name='ywxkdm' dict='/common/dict/D_BZ_YW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否签订安全责任状：</span><span name='sfqdaqzrzdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='dwxyaqxxb' /><input type='hidden' name='openUrl' value='/dwxyaqxxb_dl/createPage' />");
	sb.append("</ul>");
	sb.append("<ul url='info_xyaqxxbBay' level='2'><li class='uline' ><span>保安员</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwxyaqxxbBay' /><input type='hidden' name='openUrl' value='/dwxyaqxxbBay_dl/createPage' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_xyaqxxbHxd' level='2'><li class='uline' ><span>护校队</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='xyaqxxbHxd' /><input type='hidden' name='openUrl' value='/xyaqxxbHxd_dl/addXyaqxxbHxd' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_xyaqxxbXc' level='2'><li class='uline' ><span>校车</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='xyaqxxbXc' /><input type='hidden' name='openUrl' value='/xyaqxxbXc_dl/addXyaqxxbXc' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
};

//护校队
function info_xyaqxxbHxd_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件类型：</span><span name='zjlxdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//校车
function info_xyaqxxbXc_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>校车号牌：</span><span name='xcjdchphm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>自有或租赁：</span><span name='zyhzl' dict='/common/dict/D_DW_ZYHZL' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>核定载人数：</span><span name='hdzrs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>注册日期：</span><span name='zcrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>专用标志编号：</span><span name='zybzbh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>检验有效期：</span><span name='jyyxq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>驾驶人证件类型：</span><span name='jsrzjlxdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>驾驶人证件号码：</span><span name='jsrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>驾驶人姓名：</span><span name='jsrxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>驾驶人联系电话：</span><span name='jsrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>租赁单位：</span><span name='zldwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>租赁单位电话：</span><span name='zldwlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>租赁单位法人：</span><span name='zldwfrdbxm' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//保安員
function info_xyaqxxbBay_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件类型：</span><span name='zjlxdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//从业人员

//function info_cyryxxb_(){
//	var sb = new StringBuffer();
//	sb.append("<ul>");
//	sb.append("<li><span class='spantitle'>证件类型：</span><span name='cyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/D_BZ_MZ' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>文化程度：</span><span name='whcddm' dict='/common/dict/D_BZ_WHCD' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>国籍：</span><span name='gjdqdm' dict='/common/dict/D_BZ_GJDQ' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>户籍地详址：</span><span name='dz_hjdxz' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>现居住详址：</span><span name='dz_xzzxz' class='edit_word input_w1'></span></li>");
//	//从业信息
//	sb.append("<li><span class='spantitle'>简历：</span><span name='jl' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>所在部门：</span><span name='szbmmc' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>职务：</span><span name='zy' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>聘用时间：</span><span name='pysj' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>劳务性质：</span><span name='lwxz' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>劳务合同签署公司：</span><span name='sslwgsmc' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>是否在职培训：</span><span name='sfzzpxdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
//	/*sb.append("<li><span class='spantitle'>培训证号：</span><span name='pxzh' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>培训证书种类：</span><span name='pxzszl' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>在职培训描述：</span><span name='zzpxms' class='edit_word input_w1'></span></li>");*/
//	sb.append("<li><span class='spantitle'>是否离职：</span><span name='sflzdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>离职日期：</span><span name='lzrq' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>离职原因：</span><span name='lzyy' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>离职去向：</span><span name='lzqx' class='edit_word input_w1'></span></li>");
//	//上岗证件信息
//	sb.append("<li><span class='spantitle'>是否持职业资格证：</span><span name='sfysgzdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>职业资格证种类：</span><span name='sgzjzl' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>职业资格证号码：</span><span name='sgzjhm' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>职业资格证级别：</span><span name='sgzjjb' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>取得时间：</span><span name='sgzjqdsj' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>有效期：</span><span name='sgzyxq' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>发证机关：</span><span name='sgzfzjg' class='edit_word input_w1'></span></li>");
//	
//	//紧急联系人信息
//	sb.append("<li><span class='spantitle'>证件类型：</span><span name='jjqklxrcyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>证件号码：</span><span name='jjqklxrzjhm' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>姓名：</span><span name='jjqklxrxm' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>性别：</span><span name='jjqklxrxbdm' dict='/common/dict/D_BZ_XB' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>电话：</span><span name='jjqklxrdh' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>与其关系：</span><span name='ycyrygxdm' dict='/common/dict/D_BZ_RYGX' class='edit_word input_w2'></span></li>");
//	
//	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
//	sb.append("<input type='hidden' name='id' />");
//	sb.append("</ul>");
//	return sb.toString();
//}

//法定代表人\负责人\联络人
function info_dwfrfzrllyxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件类型：</span><span name='cyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件号码：</span><span name='zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>姓名：</span><span name='xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>性别：</span><span name='xbdm' dict='/common/dict/D_BZ_XB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>出生日期：</span><span name='csrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>民族：</span><span name='mzdm' dict='/common/dict/D_BZ_MZ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>国籍：</span><span name='gjdm' dict='/common/dict/D_BZ_SJGGHDQMCDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>户籍地址：</span><span name='dz_hjdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>居住地址：</span><span name='dz_xjzdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>单位人员类型：</span><span name='dwrylxdm' dict='/common/dict/D_DW_DWRYLXDM' class='edit_word input_w2'></span></li>");
	//sb.append("<li><span class='spantitle'>是否在公司任职：</span><span name='sfzgsrzdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>职务：</span><span name='zw' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//行业场所分类信息
function info_dwflxx_(){
	var sb = new StringBuffer();
	/*sb.append("<ul url='info_ldxxb' level='2'><li class='uline' ><span>旅店信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");	
	sb.append("<input type='hidden' name='method2' value='ldxxb' /><input type='hidden' name='openUrl' value='/ldxxb/addLdxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_ddxxb' level='2'><li class='uline' ><span>典当信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='ddxxb' /><input type='hidden' name='openUrl' value='/ddxxb/addDdxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_jdcxlxxb' level='2'><li class='uline' ><span>机动车修理信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jdcxlxxb' /><input type='hidden' name='openUrl' value='/jdcxlxxb/edit ' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_jhsgxxb' level='2'><li class='uline' ><span>旧货收购信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jhsgxxb' /><input type='hidden' name='openUrl' value='/jhsgxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yhxxb' level='2'><li class='uline' ><span>银行信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yhxxb' /><input type='hidden' name='openUrl' value='/yhxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");*/
	sb.append("<ul url='info_zzyhjzzsbb' level='2'><li class='uline' ><span>自助银行及自助设备</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='zzyhjzzsbb' /><input type='hidden' name='openUrl' value='/zzyhjzzsbb_dl/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	/*
	sb.append("<ul url='info_gxxxb' level='2'><li class='uline' ><span>高校信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='gxxxb' /><input type='hidden' name='openUrl' value='/gxxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");*/
	return sb.toString();
}






//银行信息(原金融单位)
function info_yhxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>银行类别：</span><span name='yhlbdm' dict='/common/dict/D_DW_YHLB' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>银行级别：</span><span name='yhjbdm' dict='/common/dict/D_DW_YHJB' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>银行所有制：</span><span name='yhsyz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>是否有金库：</span><span name='sfyjkdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>金库分类：</span><span name='jkfldm' dict='/common/dict/D_BZ_JRZABWGLXXDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>风险等级：</span><span name='fxdj'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>枪支数量：</span><span name='qzsl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安全防范合格证编号：</span><span name='aqffhgzbh' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='yhxxb' /><input type='hidden' name='openUrl' value='/yhxxb_dl/edit' />");
	sb.append("</ul>");
	return sb.toString();
}

//自助银行及自助设备表
function info_zzyhjzzsbb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>自助设备类别：</span><span name='zzsblbdm' dict='/common/dict/D_DW_ZZYHLB' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>安装日期：</span><span name='az_rq' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>安装地点：</span><span name='azdd' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>监控情况：</span><span name='jkqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>责任人常用证件：</span><span name='zrr_cyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人证件号码：</span><span name='zrr_zjhm'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人姓名：</span><span name='zrr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人联系电话：</span><span name='zrr_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人职务：</span><span name='zrr_zwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//高校信息表
function info_gxxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>高校学生人数：</span><span name='gxxs_rs' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>教师人数：</span><span name='js_rs' class='edit_word input_w2'></span></li>"); 
	sb.append("<li><span class='spantitle'>外籍学生人数：</span><span name='wjxs_rs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>外籍教师人数：</span><span name='wjjs_rs' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>少数民族学生人数：</span><span name='ssmzxs_rs' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>化学实验室数量：</span><span name='hxsyssl'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有无化学危险品：</span><span name='ywhxwxpdm' dict='/common/dict/D_GG_YW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>化学危险品责任人：</span><span name='glhxwxpzrr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人联系电话：</span><span name='zrr_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>化学危险品种类及数量情况：</span><span name='hxwxpzljslqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='gxxxb' /><input type='hidden' name='openUrl' value='/gxxxb_dl/edit' />");
	sb.append("</ul>");
	return sb.toString();
}

//机动车休息信息
function info_jdcxlxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>是否专修店：</span><span name='sfzxddm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否连锁店：</span><span name='sflsddm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>修理范围：</span><span name='xlfw' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jdcxlxxb' /><input type='hidden' name='openUrl' value='/jdcxlxxb_dl/edit ' />");
	sb.append("</ul>");
	return sb.toString();
	
}

//旧货收购信息
function info_jhsgxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>申请报告号：</span><span name='sqbgh' class='edit_word input_w1'></span></li>"); 
	sb.append("<li><span class='spantitle'>资信证明：</span><span name='zxzm' class='edit_word input_w1'></span></li>"); 
	sb.append("<li><span class='spantitle'>经营使用证明：</span><span name='jycssyzm' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jhsgxxb' /><input type='hidden' name='openUrl' value='/jhsgxxb_dl/edit' />");
	sb.append("</ul>");
	return sb.toString();
	
}

//上下级单位信息
function info_sxjdwxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_dwbschfgsxxb' level='2'><li class='uline' ><span>办事处或分公司信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwbschfgsxxb' /><input type='hidden' name='openUrl' value='/dwbschfgs/add' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yhflcxxb' level='2'><li class='uline' ><span>银行分理处信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yhflcxxb' /><input type='hidden' name='openUrl' value='/dwyhflcxxb_dl/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yhatmjxxb' level='2'><li class='uline' ><span>银行自助设备</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yhatmjxxb' /><input type='hidden' name='openUrl' value='/yhatmjxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_sjdwhjmgsxxb' level='2'><li class='uline' ><span>上级或加盟单位信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='sjdwhjmgsxxb' /><input type='hidden' name='openUrl' value='/sjdwhjmgsxxb/addSjdwhjmgsxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

//上级或加盟单位信息
function info_sjdwhjmgsxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>是否办理执照：</span><span name='sfblyyzzdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>营业执照代码：</span><span name='yyzzdm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>执照起始日期：</span><span name='yyzzqsrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>执照截止日期：</span><span name='yyzzjzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经营方式：</span><span name='jyfsdm' dict='/common/dict/D_DW_JYFSDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经营性质：</span><span name='jyxzdm' dict='/common/dict/D_DW_JYXZDM' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否重点单位：</span><span name='sfzddwdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>单位状态：</span><span name='dwztdm' dict='/common/dict/D_DW_DWZTDM' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//分公司或办事处信息
function info_dwbschfgsxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>分公司名称：</span><span name='fgshbscmc' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
	
}

//银行分理处信息
function info_yhflcxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>分理处名称：</span><span name='flcmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经营地址：</span><span name='dz_jydzxz' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>主营：</span><span name='zy' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>副营：</span><span name='fy' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>联系电话：</span><span name='flclxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件类型：</span><span name='fzrcyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号码：</span><span name='fzrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='fzr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人职务：</span><span name='fzrzw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人联系电话：</span><span name='fzrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='yhflcxxb' /><input type='hidden' name='openUrl' value='/dwyhflcxxb_dl/edit' />");
	sb.append("</ul>");
	return sb.toString();
	
}
//银行ＡＴＭ安装信息
function info_yhatmjxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>安装地点：</span><span name='azdd' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安装时间：</span><span name='azsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>监控情况：</span><span name='jkqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>责任人证件类型：</span><span name='zrrcyzjdm' dict='/common/dict/D_BZ_CYZJ'class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人证件号码：</span><span name='zrrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人姓名：</span><span name='zrr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人职务：</span><span name='zrrzw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任人联系电话：</span><span name='zrrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='yhatmjxxb' /><input type='hidden' name='openUrl' value='/yhatmjxxb/edit' />");
	sb.append("</ul>");
	return sb.toString();
}



//旅店信息
function info_ldxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul > ");
	sb.append("<li><span class='spantitle'>旅馆编码：</span><span name='lgbm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>星级：</span><span name='xj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>客房数：</span><span name='kefs'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否涉外：</span><span name='sfswdm' class='edit_word input_w2' dict='/common/dict/D_BZ_SF'></span></li>");
	sb.append("<li><span class='spantitle'>经营状态：</span><span name='jyztdm' class='edit_word input_w2' dict='/common/dict/D_DW_JYZT'></span></li>");
	sb.append("<li><span class='spantitle'>附属服务项目：</span><span name='fsfwxm' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='ldxxb' /><input type='hidden' name='openUrl' value='/ldxxb_dl/addLdxxb' /></ul>");
	sb.append("</ul>");
	return sb.toString();
}

//寄递单位信息
function info_jzdwxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul > ");
	sb.append("<li><span class='spantitle'>数据录入人员姓名：</span><span name='sjlrryxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>数据录入人员电话：</span><span name='sjlrrydh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>业务量：</span><span name='ywl'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>业务量单位：</span><span name='ywldw' class='edit_word input_w2' dict='/common/dict/BD_D_JZSYDWYWLDW'></span></li>");
	sb.append("<li><span class='spantitle'>派送范围：</span><span name='psfw' class='edit_word input_w2' ></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jzdwxxb' /><input type='hidden' name='openUrl' value='/jzdwxxb_dl/addJzdwxxb' /></ul>");
	sb.append("</ul>");
	return sb.toString();
}

//单位其他信息
function info_dwqtxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_dwzjxxzb' level='2'><li class='uline' ><span>单位证件信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwzjxxzb' /><input type='hidden' name='openUrl' value='/dwzjxxb_dl/addZjxx' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yyssxxb' level='2'><li class='uline' ><span>营业设施信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yyssxxb' /><input type='hidden' name='openUrl' value='/yyssxxb_dl/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dwccxxb' level='2'><li class='uline' ><span>仓储信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwccxxb' /><input type='hidden' name='openUrl' value='/dwccxxb_dl/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_rfxxb' level='2'><li class='uline' ><span>人防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='rfxxb' /><input type='hidden' name='openUrl' menu='人防信息新增/修改' value='/rfxx/addRfxx' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wfxxb' level='2'><li class='uline' ><span>物防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wfxxb' /><input type='hidden' name='openUrl' menu='物防信息新增/修改' value='/wfxxb/addWfxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_jfxxb' level='2'><li class='uline' ><span>技防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jfxxb' /><input type='hidden' name='openUrl' menu='技防信息新增/修改' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dwzybwxxb' level='2'><li class='uline' ><span>重要部位信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwzybwxxb' /><input type='hidden' name='openUrl' value='/dwzybw_dl/createPage' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}




//剧毒化学品资质信息
function info_jdhxpzzxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件名称：</span><span name='zzzjmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件编号：</span><span name='zzzjbh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件批准机关：</span><span name='zzzjpzjg'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件起始时间：</span><span name='qfrq' class='edit_word input_w2' ></span></li>");
	sb.append("<li><span class='spantitle'>证件有效时间：</span><span name='jzrq' class='edit_word input_w2' ></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='jdhxpzzxxb' /><input type='hidden' name='openUrl' value='/jdhxpzzxxb_dl/edit' />");
	sb.append("</ul>");
	return sb.toString();
}
//单位证件信息
function info_dwzjxxzb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>证件种类：</span><span name='dwzjzldm' class='edit_word input_w2' dict='/common/dict/D_DW_DWZJZL'></span></li>");
	sb.append("<li><span class='spantitle'>证件编号：</span><span name='dwzjbh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>签发日期：</span><span name='qfrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>截止日期：</span><span name='jzrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件审批机关：</span><span name='zjspjg' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>证件年检机关：</span><span name='zjnjjg' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
	
}


//单位设施部位信息
function info_dwssbwxx_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_dwzybwxxb' level='2'><li class='uline' ><span>重要部位信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwzybwxxb' /><input type='hidden' name='openUrl' value='/dwzybw_dl/createPage' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_yyssxxb' level='2'><li class='uline' ><span>营业设施信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='yyssxxb' /><input type='hidden' name='openUrl' value='/yyssxxb_dl/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dwccxxb' level='2'><li class='uline' ><span>仓储信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwccxxb' /><input type='hidden' name='openUrl' value='/dwccxxb_dl/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_rfxxb' level='2'><li class='uline' ><span>人防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='rfxxb' /><input type='hidden' name='openUrl' menu='人防信息新增/修改' value='/rfxx/addRfxx' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_wfxxb' level='2'><li class='uline' ><span>物防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='wfxxb' /><input type='hidden' name='openUrl' menu='物防信息新增/修改' value='/wfxxb/addWfxxb' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_jfxxb' level='2'><li class='uline' ><span>技防信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jfxxb' /><input type='hidden' name='openUrl' menu='技防信息新增/修改' value='' /></ul>");
	sb.append("<div class='clear'></div>");
	
	return sb.toString();
}

//重要部位信息
function info_dwzybwxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>重要部位名称：</span><span name='zybwmc' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>重要部位位置：</span><span name='zybwwz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>确定时间：</span><span name='qdsj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>确定理由依据：</span><span name='qdlyyj' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>重要部位描述：</span><span name='zybwms' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件类型：</span><span name='fzr_cyzjdm'  dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号码：</span><span name='fzr_zjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='fzr_xm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人性别：</span><span name='fzr_xbdm' dict='/common/dict/D_BZ_XB'  class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人联系电话：</span><span name='fzr_lxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人职务：</span><span name='fzr_zwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}


//营业设施信息
function info_yyssxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>设备名称：</span><span name='sbmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>设备数量：</span><span name='sbsl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>购买时间：</span><span name='sbgm_rq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>设备状态：</span><span name='sbzt' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>设备用途：</span><span name='sbyt' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
	
}
//典当业信息
function info_ddxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>经营许可证：</span><span name='jyxkzh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>设立申请书编号：</span><span name='slsqsbh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>资信证明号：</span><span name='zxzmh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>有无收当国家统收：</span><span name='ywsdgjtsdm' dict='/common/dict/D_BZ_YW' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>专营：</span><span name='zy' class='edit_word input_w1'></span></li>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method' value='ddxxb' /><input type='hidden' name='openUrl' value='/ddxxb_dl/addDdxxb' />");
	sb.append("</ul>");
	return sb.toString();
}

////重要部位信息
//function info_dwzybwxxb_(){
//	var sb = new StringBuffer();
//	sb.append("<ul>");
//	sb.append("<li><span class='spantitle'>部位名称：</span><span name='bwmc' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>部位位置：</span><span name='bwwz' class='edit_word input_w1'></span></li>");
//	sb.append("<li><span class='spantitle'>确定时间：</span><span name='qdsj' class='edit_word input_w2'></span></li>");
//	sb.append("<li><span class='spantitle'>责任人姓名：</span><span name='fzrxm' class='edit_word input_w2'></span></li>");
//	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
//	sb.append("<input type='hidden' name='id' />");
//	sb.append("</ul>");
//	return sb.toString();
//}
//仓储信息
function info_dwccxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>仓储名称：</span><span name='ccmc' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>仓储地址：</span><span name='dz_ccdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>占地面积：</span><span name='zdmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>建筑面积：</span><span name='jzmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否独立仓储：</span><span name='sfdlccdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>起用时间：</span><span name='qysj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>使用期限：</span><span name='ysqx' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储面积（平方米）：</span><span name='ccmj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储容积（立方米）：</span><span name='ccrj' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储物品：</span><span name='ccwp' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>仓储数量：</span><span name='ccsl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>数量单位：</span><span name='sldw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>消防设备情况：</span><span name='xfsbqk' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>值更人员信息：</span><span name='zgryxx' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>仓储值班室电话：</span><span name='cczbsdh' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>库管人员信息：</span><span name='kgryxx' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>证件类型：</span><span name='ccfzrcyzjdm' dict='/common/dict/D_BZ_CYZJ'class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人号码：</span><span name='ccfzrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储负责人姓名：</span><span name='ccfzr' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>仓储负责人职务：</span><span name='ccfzrzw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人电话：</span><span name='ccfzrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//单位业务办理
function info_dwywbl_(){
	var sb = new StringBuffer();
	sb.append("<ul url='info_dwjcxxb' level='2'><li class='uline' ><span>单位检查信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwjcxxb' /><input type='hidden' name='openUrl' value='/dwjcxxb_dl/add' /></ul>");
	sb.append("<div class='clear'></div>");
	sb.append("<ul url='info_dwcfxxb' level='2'><li class='uline' ><span>单位处罚信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='dwcfxxb' /><input type='hidden' name='openUrl' value='/dwcfxxb_dl/edit' /></ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

//单位检查信息
function info_dwjcxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>检查情况：</span><span name='jcqk' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}

//单位处罚信息
function info_dwcfxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>处罚情况：</span><span name='cfqk' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
	
}


//实有单位附件
function info_sydwfj_(){
	var sb = new StringBuffer();
	sb.append("<ul  url='info_sydwfj' level='1'>");
	sb.append("<input type='hidden' name='id' /><input type='hidden' name='method'  fj='true' value='fjxx' /><input type='hidden' name='openUrl' value='/sydwfj_dl/edit' />");
	sb.append("</ul>");
	sb.append("<div class='clear'></div>");
	return sb.toString();
}

//人防
function info_rfxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>防范组织形式：</span><span name='ffzzxsdm' dict='/common/dict/D_ZAFF_ZZXS' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>负责人常用证件：</span><span name='ffzrrcyzjdm' dict='/common/dict/D_BZ_CYZJ' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人证件号码：</span><span name='ffzrrzjhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人姓名：</span><span name='ffzrrxm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人联系电话：</span><span name='ffzrrlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人居住地址：</span><span name='dz_ffzrrjzdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>负责人所属单位：</span><span name='fffzrssdwmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>负责人传真号码：</span><span name='ffzrrczhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>所属单位地址：</span><span name='dz_ffzrrssdwdzxz' class='edit_word input_w1'></span></li>");
	
	sb.append("<li><span class='spantitle'>组织名称：</span><span name='ffzzmc' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织类别：</span><span name='ffzzlb' dict='/common/dict/D_ORG_ORGTYPE' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织联系电话：</span><span name='ffzzlxdh' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织传真号码：</span><span name='ffzzczhm' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>组织地址：</span><span name='dz_ffzzdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>组建日期：</span><span name='zjrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否治安承包：</span><span name='sfzacbdm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>是否定时巡逻：</span><span name='sfdsxldm' dict='/common/dict/D_BZ_SF' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>巡逻类型：</span><span name='xllxdm' dict='/common/dict/D_ZAFF_XLLX' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>巡逻路线：</span><span name='xllx' class='edit_word input_w2'></span></li>");
	
	sb.append("<li><span class='spantitle'>防范方式：</span><span name='fffsdm' dict='/common/dict/D_ZAFF_FFFS' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>防范部位：</span><span name='ffbw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>携带装备：</span><span name='xdsb' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>装备配置情况：</span><span name='zbpzqk' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>责任范围：</span><span name='zrfw' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>地区类别：</span><span name='dylbdm' dict='/common/dict/D_ZAFF_DYLB' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>隶属关系：</span><span name='lsgxdm' dict='/common/dict/D_ZAFF_LSGX' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>经费来源：</span><span name='jfly' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>作用情况：</span><span name='zyqk' class='edit_word input_w2'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//物防
function info_wfxxb_(){
	var sb = new StringBuffer();
	sb.append("<ul>");
	sb.append("<li><span class='spantitle'>物防种类：</span><span name='wfzl' dict='/common/dict/D_ZAFF_WFZL' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>数量：</span><span name='sl' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>安装日期：</span><span name='azrq' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>描述：</span><span name='ms' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>物防地址：</span><span name='dz_wfdzxz' class='edit_word input_w1'></span></li>");
	sb.append("<li><span class='spantitle'>坐标X：</span><span name='zbx' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>坐标Y：</span><span name='zby' class='edit_word input_w2'></span></li>");
	sb.append("<li><span class='spantitle'>备注：</span><span name='bz' class='edit_word input_w1'></span></li>");
	sb.append("<li class='uline2'><a class='delfw_btn ulrt_btn' href='javascript:void(0);'></a><a class='editfw_btn ulrt_btn' href='javascript:void(0);'></a></li>");
	sb.append("<input type='hidden' name='id' />");
	sb.append("</ul>");
	return sb.toString();
}
//技防
function info_jfxxb_(){
	
}

//单位保卫信息
function info_dwbwxx_(){
	var sb = new StringBuffer();
/**	sb.append("<ul url='info_jdhxpzzxxb' level='2'><li class='uline' ><span>剧毒化学品资质信息</span><a href='javascript:void(0);' class='addfw_btn' ></a>");
	sb.append(refresh+"</li>");
	sb.append("<input type='hidden' name='method2' value='jdhxpzzxxb' /><input type='hidden' name='openUrl' value='/jdhxpzzxxb/edit' /></ul>");
	sb.append("<div class='clear'></div>");**/
	return sb.toString();
}

